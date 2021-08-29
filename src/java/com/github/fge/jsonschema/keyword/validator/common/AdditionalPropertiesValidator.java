/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.google.common.base.Joiner
 *  com.google.common.collect.Collections2
 *  com.google.common.collect.ImmutableSet
 *  com.google.common.collect.ImmutableSet$Builder
 *  com.google.common.collect.NaturalOrdering
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Set
 */
package com.github.fge.jsonschema.keyword.validator.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.core.util.RegexECMA262Helper;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.NaturalOrdering;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class AdditionalPropertiesValidator
extends AbstractKeywordValidator {
    private static final Joiner TOSTRING_JOINER = new Joiner("; or ");
    private final boolean additionalOK;
    private final Set<String> patternProperties;
    private final Set<String> properties;

    public AdditionalPropertiesValidator(JsonNode jsonNode) {
        super("additionalProperties");
        this.additionalOK = jsonNode.get(this.keyword).booleanValue();
        ImmutableSet.Builder builder = new ImmutableSet.Builder();
        Iterator iterator = jsonNode.get("properties").elements();
        while (iterator.hasNext()) {
            builder.add((Object)((JsonNode)iterator.next()).textValue());
        }
        this.properties = builder.build();
        ImmutableSet.Builder builder2 = new ImmutableSet.Builder();
        Iterator iterator2 = jsonNode.get("patternProperties").elements();
        while (iterator2.hasNext()) {
            builder2.add((Object)((JsonNode)iterator2.next()).textValue());
        }
        this.patternProperties = builder2.build();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(GeneratedOutlineSupport.outline21((StringBuilder)new StringBuilder(), (String)this.keyword, (String)": "));
        if (this.additionalOK) {
            stringBuilder.append("allowed");
            return stringBuilder.toString();
        }
        stringBuilder.append("none");
        if (this.properties.isEmpty() && this.patternProperties.isEmpty()) {
            return stringBuilder.toString();
        }
        stringBuilder.append(", unless: ");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!this.properties.isEmpty()) {
            StringBuilder stringBuilder2 = GeneratedOutlineSupport.outline24((String)"one property is any of: ");
            stringBuilder2.append(this.properties);
            linkedHashSet.add((Object)stringBuilder2.toString());
        }
        if (!this.patternProperties.isEmpty()) {
            StringBuilder stringBuilder3 = GeneratedOutlineSupport.outline24((String)"a property matches any regex among: ");
            stringBuilder3.append(this.patternProperties);
            linkedHashSet.add((Object)stringBuilder3.toString());
        }
        stringBuilder.append(TOSTRING_JOINER.join((Iterable)linkedHashSet));
        return stringBuilder.toString();
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        if (this.additionalOK) {
            return;
        }
        HashSet hashSet = Collections2.newHashSet((Iterator)fullData.getInstance().getNode().fieldNames());
        hashSet.removeAll(this.properties);
        HashSet hashSet2 = new HashSet();
        for (String string : hashSet) {
            Iterator iterator = this.patternProperties.iterator();
            while (iterator.hasNext()) {
                if (!RegexECMA262Helper.regMatch((String)iterator.next(), string)) continue;
                hashSet2.add((Object)string);
            }
        }
        hashSet.removeAll((Collection)hashSet2);
        if (hashSet.isEmpty()) {
            return;
        }
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        Iterator iterator = NaturalOrdering.INSTANCE.sortedCopy((Iterable)hashSet).iterator();
        while (iterator.hasNext()) {
            arrayNode.add((String)iterator.next());
        }
        processingReport.error(this.newMsg(fullData, messageBundle, "err.common.additionalProperties.notAllowed").putArgument("unwanted", (JsonNode)arrayNode));
    }
}

