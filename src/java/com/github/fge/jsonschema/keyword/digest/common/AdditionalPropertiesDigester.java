/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  com.google.common.collect.Collections2
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 */
package com.github.fge.jsonschema.keyword.digest.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.AbstractDigester;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.google.common.collect.Collections2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class AdditionalPropertiesDigester
extends AbstractDigester {
    private static final Digester INSTANCE = new AdditionalPropertiesDigester();

    private AdditionalPropertiesDigester() {
        super("additionalProperties", NodeType.OBJECT, new NodeType[0]);
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
        Objects.requireNonNull((Object)jsonNodeFactory);
        ArrayNode arrayNode2 = new ArrayNode(jsonNodeFactory);
        objectNode.put(this.keyword, true);
        objectNode._children.put((Object)"properties", (Object)arrayNode);
        objectNode._children.put((Object)"patternProperties", (Object)arrayNode2);
        if (jsonNode.get(this.keyword).asBoolean(true)) {
            return objectNode;
        }
        objectNode.put(this.keyword, false);
        ArrayList arrayList = Collections2.newArrayList((Iterator)jsonNode.path("properties").fieldNames());
        Collections.sort((List)arrayList);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            arrayNode.add((String)iterator.next());
        }
        ArrayList arrayList2 = Collections2.newArrayList((Iterator)jsonNode.path("patternProperties").fieldNames());
        Collections.sort((List)arrayList2);
        Iterator iterator2 = arrayList2.iterator();
        while (iterator2.hasNext()) {
            arrayNode2.add((String)iterator2.next());
        }
        return objectNode;
    }
}

