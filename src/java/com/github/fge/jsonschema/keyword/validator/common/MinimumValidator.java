/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.BooleanNode
 *  java.lang.String
 *  java.math.BigDecimal
 */
package com.github.fge.jsonschema.keyword.validator.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.helpers.NumericValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.math.BigDecimal;

public final class MinimumValidator
extends NumericValidator {
    private final boolean exclusive;

    public MinimumValidator(JsonNode jsonNode) {
        super("minimum", jsonNode);
        this.exclusive = jsonNode.path("exclusive").asBoolean(false);
    }

    @Override
    public void validateDecimal(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        JsonNode jsonNode = fullData.getInstance().getNode();
        int n2 = jsonNode.decimalValue().compareTo(this.number.decimalValue());
        if (n2 > 0) {
            return;
        }
        if (n2 < 0) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.common.minimum.tooSmall").putArgument(this.keyword, this.number).putArgument("found", jsonNode));
            return;
        }
        if (!this.exclusive) {
            return;
        }
        processingReport.error(this.newMsg(fullData, messageBundle, "err.common.minimum.notExclusive").putArgument(this.keyword, this.number).put("exclusiveMinimum", (JsonNode)BooleanNode.TRUE));
    }

    @Override
    public void validateLong(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        JsonNode jsonNode = fullData.getInstance().getNode();
        long l2 = jsonNode.longValue() LCMP this.number.longValue();
        if (l2 > 0) {
            return;
        }
        if (l2 < 0) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.common.minimum.tooSmall").putArgument(this.keyword, this.number).putArgument("found", jsonNode));
            return;
        }
        if (!this.exclusive) {
            return;
        }
        processingReport.error(this.newMsg(fullData, messageBundle, "err.common.minimum.notExclusive").putArgument(this.keyword, this.number).put("exclusiveMinimum", (JsonNode)BooleanNode.TRUE));
    }
}

