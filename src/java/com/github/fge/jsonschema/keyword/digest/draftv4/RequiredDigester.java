/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  com.google.common.collect.Collections2
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 *  java.util.Objects
 */
package com.github.fge.jsonschema.keyword.digest.draftv4;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.AbstractDigester;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.github.fge.jsonschema.keyword.digest.draftv4.RequiredDigester;
import com.google.common.collect.Collections2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public final class RequiredDigester
extends AbstractDigester {
    private static final Digester INSTANCE = new RequiredDigester();

    private RequiredDigester() {
        super("required", NodeType.OBJECT, new NodeType[0]);
    }

    public static Digester getInstance() {
        return INSTANCE;
    }

    @Override
    public JsonNode digest(JsonNode jsonNode) {
        JsonNodeFactory jsonNodeFactory = AbstractDigester.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        Objects.requireNonNull((Object)jsonNodeFactory);
        ArrayNode arrayNode = new ArrayNode(jsonNodeFactory);
        objectNode.set(this.keyword, (JsonNode)arrayNode);
        ArrayList arrayList = Collections2.newArrayList((Iterable)jsonNode.get(this.keyword));
        Collections.sort((List)arrayList, (Comparator)new Comparator<JsonNode>(this){
            public final /* synthetic */ RequiredDigester this$0;
            {
                this.this$0 = requiredDigester;
            }

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
        arrayNode.addAll((Collection)arrayList);
        return objectNode;
    }
}

