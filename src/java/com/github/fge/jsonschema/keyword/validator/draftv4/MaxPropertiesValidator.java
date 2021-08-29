/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.String
 */
package com.github.fge.jsonschema.keyword.validator.draftv4;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.keyword.validator.helpers.PositiveIntegerValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;

public final class MaxPropertiesValidator
extends PositiveIntegerValidator {
    public MaxPropertiesValidator(JsonNode jsonNode) {
        super("maxProperties", jsonNode);
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        int n2 = fullData.getInstance().getNode().size();
        if (n2 > this.intValue) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.draftv4.maxProperties.tooManyMembers").putArgument("found", n2).putArgument("required", this.intValue));
        }
    }
}

