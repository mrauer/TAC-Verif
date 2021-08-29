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
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 *  java.util.TreeSet
 */
package com.github.fge.jsonschema.keyword.digest.draftv3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.JacksonUtils;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.AbstractDigester;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.github.fge.jsonschema.keyword.digest.draftv3.DraftV3DependenciesDigester;
import com.google.common.collect.Collections2;
import com.google.common.collect.NaturalOrdering;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public final class DraftV3DependenciesDigester
extends AbstractDigester {
    private static final Digester INSTANCE = new DraftV3DependenciesDigester();

    private DraftV3DependenciesDigester() {
        super("dependencies", NodeType.OBJECT, new NodeType[0]);
    }

    public static Digester getInstance() {
        return INSTANCE;
    }

    private static JsonNode sortedSet(JsonNode jsonNode) {
        TreeSet treeSet = new TreeSet((Comparator)new Comparator<JsonNode>(){

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
        HashSet hashSet = jsonNode instanceof Collection ? new HashSet((Collection)jsonNode) : Collections2.newHashSet((Iterator)jsonNode.elements());
        treeSet.addAll((Collection)hashSet);
        JsonNodeFactory jsonNodeFactory = AbstractDigester.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ArrayNode arrayNode = new ArrayNode(jsonNodeFactory);
        arrayNode.addAll((Collection)treeSet);
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
            int n2 = NodeType.getNodeType(jsonNode2).ordinal();
            if (n2 != 0) {
                if (n2 != 5) {
                    if (n2 != 6) continue;
                    JsonNodeFactory jsonNodeFactory2 = AbstractDigester.FACTORY;
                    Objects.requireNonNull((Object)jsonNodeFactory2);
                    objectNode2.set(string, (JsonNode)new ArrayNode(jsonNodeFactory2).add(jsonNode2.textValue()));
                    continue;
                }
                arrayList.add((Object)string);
                continue;
            }
            JsonNode jsonNode3 = DraftV3DependenciesDigester.sortedSet(jsonNode2);
            if (jsonNode3.size() == 0) continue;
            objectNode2.set(string, jsonNode3);
        }
        Iterator iterator = NaturalOrdering.INSTANCE.sortedCopy((Iterable)arrayList).iterator();
        while (iterator.hasNext()) {
            arrayNode.add((String)iterator.next());
        }
        return objectNode;
    }
}

