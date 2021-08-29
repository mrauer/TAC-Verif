/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.NumericNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Objects
 */
package com.github.fge.jsonschema.keyword.digest.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.AbstractDigester;
import com.github.fge.jsonschema.keyword.digest.Digester;
import java.util.Map;
import java.util.Objects;

public final class AdditionalItemsDigester
extends AbstractDigester {
    private static final Digester INSTANCE = new AdditionalItemsDigester();

    private AdditionalItemsDigester() {
        super("additionalItems", NodeType.ARRAY, new NodeType[0]);
    }

    public static Digester getInstance() {
        return INSTANCE;
    }

    @Override
    public JsonNode digest(JsonNode jsonNode) {
        JsonNodeFactory jsonNodeFactory = AbstractDigester.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        objectNode.put(this.keyword, true);
        NumericNode numericNode = jsonNodeFactory.numberNode(0);
        objectNode._children.put((Object)"itemsSize", (Object)numericNode);
        if (jsonNode.get(this.keyword).asBoolean(true)) {
            return objectNode;
        }
        JsonNode jsonNode2 = jsonNode.path("items");
        Objects.requireNonNull((Object)jsonNode2);
        if (!(jsonNode2 instanceof ArrayNode)) {
            return objectNode;
        }
        objectNode.put(this.keyword, false);
        NumericNode numericNode2 = jsonNodeFactory.numberNode(jsonNode2.size());
        objectNode._children.put((Object)"itemsSize", (Object)numericNode2);
        return objectNode;
    }
}

