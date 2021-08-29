/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.String
 *  java.math.BigDecimal
 */
package com.github.fge.jsonschema.keyword.validator.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.keyword.validator.helpers.NumericValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import java.math.BigDecimal;

public abstract class DivisorValidator
extends NumericValidator {
    public DivisorValidator(String string, JsonNode jsonNode) {
        super(string, jsonNode);
    }

    @Override
    public final void validateDecimal(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        JsonNode jsonNode = fullData.getInstance().getNode();
        if (jsonNode.decimalValue().remainder(this.number.decimalValue()).compareTo(BigDecimal.ZERO) == 0) {
            return;
        }
        processingReport.error(this.newMsg(fullData, messageBundle, "err.common.divisor.nonZeroRemainder").putArgument("value", jsonNode).putArgument("divisor", this.number));
    }

    @Override
    public final void validateLong(ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        JsonNode jsonNode = fullData.getInstance().getNode();
        if (jsonNode.longValue() % this.number.longValue() == 0L) {
            return;
        }
        processingReport.error(this.newMsg(fullData, messageBundle, "err.common.divisor.nonZeroRemainder").putArgument("value", jsonNode).putArgument("divisor", this.number));
    }
}

