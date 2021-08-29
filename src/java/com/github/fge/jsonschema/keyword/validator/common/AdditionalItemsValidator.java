/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.fge.jsonschema.keyword.validator.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;

public final class AdditionalItemsValidator
extends AbstractKeywordValidator {
    private final boolean additionalOK;
    private final int itemsSize;

    public AdditionalItemsValidator(JsonNode jsonNode) {
        super("additionalItems");
        this.additionalOK = jsonNode.get(this.keyword).booleanValue();
        this.itemsSize = jsonNode.get("itemsSize").intValue();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.keyword);
        stringBuilder.append(": ");
        String string = this.additionalOK ? "allowed" : GeneratedOutlineSupport.outline20((StringBuilder)new StringBuilder(), (int)this.itemsSize, (String)" max");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        if (this.additionalOK) {
            return;
        }
        int n2 = fullData.getInstance().getNode().size();
        if (n2 > this.itemsSize) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.common.additionalItems.notAllowed").putArgument("allowed", this.itemsSize).putArgument("found", n2));
        }
    }
}

