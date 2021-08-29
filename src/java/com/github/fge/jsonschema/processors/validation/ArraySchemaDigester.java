/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.BooleanNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.MissingNode
 *  com.fasterxml.jackson.databind.node.NumericNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Objects
 */
package com.github.fge.jsonschema.processors.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.AbstractDigester;
import com.github.fge.jsonschema.keyword.digest.Digester;
import java.util.Map;
import java.util.Objects;

public final class ArraySchemaDigester
extends AbstractDigester {
    private static final Digester INSTANCE = new ArraySchemaDigester();

    private ArraySchemaDigester() {
        super("", NodeType.ARRAY, new NodeType[0]);
    }

    public static Digester getInstance() {
        return INSTANCE;
    }

    @Override
    public JsonNode digest(JsonNode jsonNode) {
        JsonNodeFactory jsonNodeFactory = AbstractDigester.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        NumericNode numericNode = jsonNodeFactory.numberNode(0);
        objectNode._children.put((Object)"itemsSize", (Object)numericNode);
        BooleanNode booleanNode = jsonNodeFactory.booleanNode(false);
        objectNode._children.put((Object)"itemsIsArray", (Object)booleanNode);
        JsonNode jsonNode2 = jsonNode.path("items");
        JsonNode jsonNode3 = jsonNode.path("additionalItems");
        Objects.requireNonNull((Object)jsonNode2);
        boolean bl = true ^ jsonNode2 instanceof MissingNode;
        Objects.requireNonNull((Object)jsonNode3);
        boolean bl2 = jsonNode3 instanceof ObjectNode;
        BooleanNode booleanNode2 = jsonNodeFactory.booleanNode(bl);
        objectNode._children.put((Object)"hasItems", (Object)booleanNode2);
        BooleanNode booleanNode3 = jsonNodeFactory.booleanNode(bl2);
        objectNode._children.put((Object)"hasAdditional", (Object)booleanNode3);
        if (jsonNode2 instanceof ArrayNode) {
            BooleanNode booleanNode4 = jsonNodeFactory.booleanNode(true);
            objectNode._children.put((Object)"itemsIsArray", (Object)booleanNode4);
            NumericNode numericNode2 = jsonNodeFactory.numberNode(jsonNode2.size());
            objectNode._children.put((Object)"itemsSize", (Object)numericNode2);
        }
        return objectNode;
    }
}

