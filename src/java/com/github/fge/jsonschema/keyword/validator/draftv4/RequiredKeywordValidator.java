/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.google.common.collect.Collections2
 *  com.google.common.collect.ImmutableSet
 *  com.google.common.collect.ImmutableSet$Builder
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.Set
 */
package com.github.fge.jsonschema.keyword.validator.draftv4;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class RequiredKeywordValidator
extends AbstractKeywordValidator {
    private final Set<String> required;

    public RequiredKeywordValidator(JsonNode jsonNode) {
        super("required");
        ImmutableSet.Builder builder = new ImmutableSet.Builder();
        Iterator iterator = jsonNode.get(this.keyword).elements();
        while (iterator.hasNext()) {
            builder.add((Object)((JsonNode)iterator.next()).textValue());
        }
        this.required = builder.build();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.keyword);
        stringBuilder.append(": ");
        stringBuilder.append(this.required.size());
        stringBuilder.append(" properties");
        return stringBuilder.toString();
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        LinkedHashSet linkedHashSet = Collections2.newLinkedHashSet(this.required);
        linkedHashSet.removeAll((Collection)Collections2.newHashSet((Iterator)fullData.getInstance().getNode().fieldNames()));
        if (!linkedHashSet.isEmpty()) {
            processingReport.error(this.newMsg(fullData, messageBundle, "err.common.object.missingMembers").put("required", this.required).putArgument("missing", AbstractKeywordValidator.toArrayNode(linkedHashSet)));
        }
    }
}

