/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.google.common.base.Equivalence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 */
package com.github.fge.jsonschema.keyword.validator.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonNumEquivalence;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.base.Equivalence;
import java.util.Iterator;

public final class EnumValidator
extends AbstractKeywordValidator {
    private static final Equivalence<JsonNode> EQUIVALENCE = JsonNumEquivalence.INSTANCE;
    private final JsonNode values;

    public EnumValidator(JsonNode jsonNode) {
        super("enum");
        this.values = jsonNode.get(this.keyword);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.keyword);
        stringBuilder.append('(');
        stringBuilder.append(this.values.size());
        stringBuilder.append(" possible values)");
        return stringBuilder.toString();
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        JsonNode jsonNode = fullData.getInstance().getNode();
        Iterator iterator = this.values.elements();
        while (iterator.hasNext()) {
            JsonNode jsonNode2 = (JsonNode)iterator.next();
            if (!EQUIVALENCE.equivalent((Object)jsonNode2, (Object)jsonNode)) continue;
            return;
        }
        processingReport.error(this.newMsg(fullData, messageBundle, "err.common.enum.notInEnum").putArgument("value", jsonNode).putArgument(this.keyword, this.values));
    }
}

