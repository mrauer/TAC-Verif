/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.github.fge.jsonschema.keyword.validator.draftv4;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ListProcessingReport;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.helpers.SchemaArrayValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.Objects;

public final class AllOfValidator
extends SchemaArrayValidator {
    public AllOfValidator(JsonNode jsonNode) {
        super("allOf");
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        SchemaTree schemaTree = fullData.getSchema();
        JsonPointer jsonPointer = schemaTree.getPointer();
        int n2 = schemaTree.getNode().get(this.keyword).size();
        JsonNodeFactory jsonNodeFactory = SchemaArrayValidator.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            ListProcessingReport listProcessingReport = new ListProcessingReport(processingReport.getLogLevel(), LogLevel.FATAL);
            String string = this.keyword;
            Object[] arrobject = new Object[]{i2};
            JsonPointer jsonPointer2 = jsonPointer.append(JsonPointer.of(string, arrobject));
            processor.process(listProcessingReport, fullData.withSchema(schemaTree.setPointer(jsonPointer2)));
            objectNode.set(jsonPointer2.toString(), listProcessingReport.asJson());
            if (!listProcessingReport.isSuccess()) continue;
            ++n3;
        }
        if (n3 != n2) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.draftv4.allOf.fail").putArgument("matched", n3).putArgument("nrSchemas", n2).put("reports", (JsonNode)objectNode));
        }
    }
}

