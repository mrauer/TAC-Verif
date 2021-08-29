/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.keyword.validator.draftv4;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ListProcessingReport;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;

public final class NotValidator
extends AbstractKeywordValidator {
    private static final JsonPointer PTR = JsonPointer.of("not", new Object[0]);

    public NotValidator(JsonNode jsonNode) {
        super("not");
    }

    @Override
    public String toString() {
        return "must not match subschema";
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        SchemaTree schemaTree = fullData.getSchema();
        ListProcessingReport listProcessingReport = new ListProcessingReport(processingReport.getLogLevel(), LogLevel.FATAL);
        processor.process(listProcessingReport, fullData.withSchema(schemaTree.append(PTR)));
        if (listProcessingReport.isSuccess()) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.draftv4.not.fail"));
        }
    }
}

