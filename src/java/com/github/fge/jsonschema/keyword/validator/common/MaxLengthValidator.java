/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.keyword.validator.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.helpers.PositiveIntegerValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;

public final class MaxLengthValidator
extends PositiveIntegerValidator {
    public MaxLengthValidator(JsonNode jsonNode) {
        super("maxLength", jsonNode);
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        String string = GeneratedOutlineSupport.outline8((FullData)fullData);
        int n2 = string.codePointCount(0, string.length());
        if (n2 > this.intValue) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.common.maxLength.tooLong").putArgument("value", string).putArgument("found", n2).putArgument(this.keyword, this.intValue));
        }
    }
}

