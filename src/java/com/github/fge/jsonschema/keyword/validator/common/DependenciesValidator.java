/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.google.common.collect.Collections2
 *  com.google.common.collect.CompactHashMap
 *  com.google.common.collect.EmptyImmutableListMultimap
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableListMultimap
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableMap$Builder
 *  com.google.common.collect.ImmutableSet
 *  com.google.common.collect.ImmutableSet$Builder
 *  com.google.common.collect.Multimap
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.github.fge.jsonschema.keyword.validator.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JacksonUtils;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.google.android.material.R;
import com.google.common.collect.Collections2;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.EmptyImmutableListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class DependenciesValidator
extends AbstractKeywordValidator {
    private final Multimap<String, String> propertyDeps;
    private final Set<String> schemaDeps;

    public DependenciesValidator(JsonNode jsonNode) {
        EmptyImmutableListMultimap emptyImmutableListMultimap;
        super("dependencies");
        CompactHashMap compactHashMap = new CompactHashMap();
        for (Map.Entry entry : ((HashMap)JacksonUtils.asMap(jsonNode.get("propertyDeps"))).entrySet()) {
            String string = (String)entry.getKey();
            Iterator iterator = ((JsonNode)entry.getValue()).elements();
            while (iterator.hasNext()) {
                String string2 = ((JsonNode)iterator.next()).textValue();
                R.style.checkEntryNotNull((Object)string, (Object)string2);
                Collection collection = (Collection)compactHashMap.get((Object)string);
                if (collection == null) {
                    collection = new ArrayList();
                    compactHashMap.put((Object)string, (Object)collection);
                }
                collection.add((Object)string2);
            }
        }
        Set set = compactHashMap.entrySet();
        if (set.isEmpty()) {
            emptyImmutableListMultimap = EmptyImmutableListMultimap.INSTANCE;
        } else {
            ImmutableMap.Builder builder = new ImmutableMap.Builder(set.size());
            int n2 = 0;
            for (Map.Entry entry : set) {
                Object object = entry.getKey();
                ImmutableList immutableList = ImmutableList.copyOf((Collection)((Collection)entry.getValue()));
                if (immutableList.isEmpty()) continue;
                builder.put(object, (Object)immutableList);
                n2 += immutableList.size();
            }
            emptyImmutableListMultimap = new ImmutableListMultimap(builder.build(), n2);
        }
        this.propertyDeps = emptyImmutableListMultimap;
        ImmutableSet.Builder builder = new ImmutableSet.Builder();
        Iterator iterator = jsonNode.get("schemaDeps").elements();
        while (iterator.hasNext()) {
            builder.add((Object)((JsonNode)iterator.next()).textValue());
        }
        this.schemaDeps = builder.build();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.keyword);
        stringBuilder.append(": ");
        stringBuilder.append(this.propertyDeps.size());
        stringBuilder.append(" property dependencies, ");
        stringBuilder.append(this.schemaDeps.size());
        stringBuilder.append(" schema dependencies");
        return stringBuilder.toString();
    }

    @Override
    public void validate(Processor<FullData, FullData> processor, ProcessingReport processingReport, MessageBundle messageBundle, FullData fullData) throws ProcessingException {
        HashSet hashSet = Collections2.newHashSet((Iterator)fullData.getInstance().getNode().fieldNames());
        for (String string : this.propertyDeps.keySet()) {
            if (!hashSet.contains((Object)string)) continue;
            Collection collection = this.propertyDeps.get((Object)string);
            LinkedHashSet linkedHashSet = Collections2.newLinkedHashSet((Iterable)collection);
            linkedHashSet.removeAll((Collection)hashSet);
            if (linkedHashSet.isEmpty()) continue;
            processingReport.error(this.newMsg(fullData, messageBundle, "err.common.dependencies.missingPropertyDeps").putArgument("property", string).putArgument("required", AbstractKeywordValidator.toArrayNode(collection)).putArgument("missing", AbstractKeywordValidator.toArrayNode(linkedHashSet)));
        }
        if (this.schemaDeps.isEmpty()) {
            return;
        }
        SchemaTree schemaTree = fullData.getSchema();
        for (String string : this.schemaDeps) {
            if (!hashSet.contains((Object)string)) continue;
            processor.process(processingReport, fullData.withSchema(schemaTree.append(JsonPointer.of(this.keyword, string))));
        }
    }
}

