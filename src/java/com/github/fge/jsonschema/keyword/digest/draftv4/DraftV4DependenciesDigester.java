/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  com.google.common.collect.Collections2
 *  com.google.common.collect.NaturalOrdering
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 */
package com.github.fge.jsonschema.keyword.digest.draftv4;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.JacksonUtils;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.AbstractDigester;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.github.fge.jsonschema.keyword.digest.draftv4.DraftV4DependenciesDigester;
import com.google.common.collect.Collections2;
import com.google.common.collect.NaturalOrdering;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class DraftV4DependenciesDigester
extends AbstractDigester {
    private static final Digester INSTANCE = new DraftV4DependenciesDigester();

    private DraftV4DependenciesDigester() {
        super("dependencies", NodeType.OBJECT, new NodeType[0]);
    }

    public static Digester getInstance() {
        return INSTANCE;
    }

    private static JsonNode sortedSet(JsonNode jsonNode) {
        ArrayList arrayList = Collections2.newArrayList((Iterable)jsonNode);
        Collections.sort((List)arrayList, (Comparator)new Comparator<JsonNode>(){

            public int compare(JsonNode jsonNode, JsonNode jsonNode2) {
                return jsonNode.textValue().compareTo(jsonNode2.textValue());
            }

            public /* synthetic */ Comparator reversed() {
                return j$.util.Comparator$-CC.$default$reversed(this);
            }

            public /* synthetic */ Comparator thenComparing(j$.util.function.Function function) {
                return j$.util.Comparator$-CC.$default$thenComparing((Comparator)this, function);
            }

            public /* synthetic */ Comparator thenComparing(j$.util.function.Function function, Comparator comparator) {
                return j$.util.Comparator$-CC.$default$thenComparing(this, function, comparator);
            }

            public /* synthetic */ Comparator thenComparing(Comparator comparator) {
                return j$.util.Comparator$-CC.$default$thenComparing((Comparator)this, comparator);
            }

            public /* synthetic */ Comparator thenComparingDouble(j$.util.function.ToDoubleFunction toDoubleFunction) {
                return j$.util.Comparator$-CC.$default$thenComparingDouble(this, toDoubleFunction);
            }

            public /* synthetic */ Comparator thenComparingInt(j$.util.function.ToIntFunction toIntFunction) {
                return j$.util.Comparator$-CC.$default$thenComparingInt(this, toIntFunction);
            }

            public /* synthetic */ Comparator thenComparingLong(j$.util.function.ToLongFunction toLongFunction) {
                return j$.util.Comparator$-CC.$default$thenComparingLong(this, toLongFunction);
            }
        });
        JsonNodeFactory jsonNodeFactory = AbstractDigester.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ArrayNode arrayNode = new ArrayNode(jsonNodeFactory);
        arrayNode.addAll((Collection)arrayList);
        return arrayNode;
    }

    @Override
    public JsonNode digest(JsonNode jsonNode) {
        JsonNodeFactory jsonNodeFactory = AbstractDigester.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode2 = new ObjectNode(jsonNodeFactory);
        objectNode._children.put((Object)"propertyDeps", (Object)objectNode2);
        Objects.requireNonNull((Object)jsonNodeFactory);
        ArrayNode arrayNode = new ArrayNode(jsonNodeFactory);
        objectNode._children.put((Object)"schemaDeps", (Object)arrayNode);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((HashMap)JacksonUtils.asMap(jsonNode.get(this.keyword))).entrySet()) {
            String string = (String)entry.getKey();
            JsonNode jsonNode2 = (JsonNode)entry.getValue();
            Objects.requireNonNull((Object)jsonNode2);
            if (jsonNode2 instanceof ObjectNode) {
                arrayList.add((Object)string);
                continue;
            }
            objectNode2.set(string, DraftV4DependenciesDigester.sortedSet(jsonNode2));
        }
        Iterator iterator = NaturalOrdering.INSTANCE.sortedCopy((Iterable)arrayList).iterator();
        while (iterator.hasNext()) {
            arrayNode.add((String)iterator.next());
        }
        return objectNode;
    }
}

