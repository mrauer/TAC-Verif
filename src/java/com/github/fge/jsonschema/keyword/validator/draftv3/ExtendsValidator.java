/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.github.fge.jsonschema.keyword.validator.draftv3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.util.Objects;

public final class ExtendsValidator
extends AbstractKeywordValidator {
    public ExtendsValidator(JsonNode jsonNode) {
        super("extends");
    }

    @Override
    public String toString() {
        return this.keyword;
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        SchemaTree schemaTree = fullData.getSchema();
        JsonNode jsonNode = schemaTree.getNode().get(this.keyword);
        Objects.requireNonNull((Object)jsonNode);
        if (jsonNode instanceof ObjectNode) {
            processor.process(processingReport, fullData.withSchema(schemaTree.append(JsonPointer.of(this.keyword, new Object[0]))));
            return;
        }
        int n2 = jsonNode.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            String string = this.keyword;
            Object[] arrobject = new Object[]{i2};
            processor.process(processingReport, fullData.withSchema(schemaTree.append(JsonPointer.of(string, arrobject))));
        }
    }
}

