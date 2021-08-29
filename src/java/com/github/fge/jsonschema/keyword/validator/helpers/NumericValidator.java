/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.fge.jsonschema.keyword.validator.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;

public abstract class NumericValidator
extends AbstractKeywordValidator {
    private final boolean isLong;
    public final JsonNode number;

    public NumericValidator(String string, JsonNode jsonNode) {
        super(string);
        this.number = jsonNode.get(string);
        this.isLong = jsonNode.get("valueIsLong").booleanValue();
    }

    private static boolean valueIsLong(JsonNode jsonNode) {
        return NodeType.getNodeType(jsonNode) == NodeType.INTEGER && jsonNode.canConvertToLong();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.keyword);
        stringBuilder.append(": ");
        stringBuilder.append((Object)this.number);
        return stringBuilder.toString();
    }

    @Override
    public final void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        if (NumericValidator.valueIsLong(fullData.getInstance().getNode()) && this.isLong) {
            this.validateLong(processingReport, messageBundle, fullData);
            return;
        }
        this.validateDecimal(processingReport, messageBundle, fullData);
    }

    public abstract void validateDecimal(ProcessingReport var1, MessageBundle var2, FullData var3) throws ProcessingException;

    public abstract void validateLong(ProcessingReport var1, MessageBundle var2, FullData var3) throws ProcessingException;
}

