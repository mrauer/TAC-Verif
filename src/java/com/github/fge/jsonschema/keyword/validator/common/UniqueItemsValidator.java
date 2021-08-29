/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.google.common.base.Equivalence
 *  com.google.common.base.Equivalence$Wrapper
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashSet
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
import java.util.HashSet;
import java.util.Iterator;

public final class UniqueItemsValidator
extends AbstractKeywordValidator {
    private static final Equivalence<JsonNode> EQUIVALENCE = JsonNumEquivalence.INSTANCE;
    private final boolean uniqueItems;

    public UniqueItemsValidator(JsonNode jsonNode) {
        super("uniqueItems");
        this.uniqueItems = jsonNode.get(this.keyword).booleanValue();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.keyword);
        stringBuilder.append(": ");
        stringBuilder.append(this.uniqueItems);
        return stringBuilder.toString();
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        if (!this.uniqueItems) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator iterator = fullData.getInstance().getNode().elements();
        while (iterator.hasNext()) {
            JsonNode jsonNode = (JsonNode)iterator.next();
            if (hashSet.add((Object)EQUIVALENCE.wrap((Object)jsonNode))) continue;
            processingReport.error(this.newMsg(fullData, messageBundle, "err.common.uniqueItems.duplicateElements"));
            break;
        }
    }
}

