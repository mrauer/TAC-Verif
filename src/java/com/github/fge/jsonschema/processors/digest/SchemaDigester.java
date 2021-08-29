/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  com.google.common.collect.ArrayListMultimap
 *  com.google.common.collect.Collections2
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableMap$Builder
 *  com.google.common.collect.ListMultimap
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.EnumSet
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.github.fge.jsonschema.processors.digest;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.github.fge.jsonschema.library.Library;
import com.github.fge.jsonschema.processors.data.SchemaContext;
import com.github.fge.jsonschema.processors.data.SchemaDigest;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ListMultimap;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SchemaDigester
implements Processor<SchemaContext, SchemaDigest> {
    private final Map<String, Digester> digesterMap = new HashMap();
    private final ListMultimap<NodeType, String> typeMap = new ArrayListMultimap();

    public SchemaDigester(Dictionary<Digester> dictionary) {
        for (Map.Entry entry : dictionary.entries().entrySet()) {
            String string = (String)entry.getKey();
            Digester digester = (Digester)entry.getValue();
            this.digesterMap.put((Object)string, (Object)digester);
            for (NodeType nodeType : digester.supportedTypes()) {
                this.typeMap.put((Object)nodeType, (Object)string);
            }
        }
    }

    public SchemaDigester(Library library) {
        this(library.getDigesters());
    }

    private Map<String, JsonNode> buildDigests(JsonNode jsonNode) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        HashMap hashMap = new HashMap(this.digesterMap);
        hashMap.keySet().retainAll((Collection)Collections2.newHashSet((Iterator)jsonNode.fieldNames()));
        for (Map.Entry entry : hashMap.entrySet()) {
            builder.put(entry.getKey(), (Object)((Digester)entry.getValue()).digest(jsonNode));
        }
        return builder.build();
    }

    @Override
    public SchemaDigest process(ProcessingReport processingReport, SchemaContext schemaContext) throws ProcessingException {
        JsonNode jsonNode = schemaContext.getSchema().getNode();
        NodeType nodeType = schemaContext.getInstanceType();
        HashMap hashMap = new HashMap(this.buildDigests(jsonNode));
        hashMap.keySet().retainAll((Collection)this.typeMap.get((Object)nodeType));
        return new SchemaDigest(schemaContext, (Map<String, JsonNode>)hashMap);
    }

    public String toString() {
        return "schema digester";
    }
}

