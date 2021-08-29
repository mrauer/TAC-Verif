/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.BooleanNode
 *  com.fasterxml.jackson.databind.node.ContainerNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.github.fge.jsonschema.keyword.digest.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.github.fge.jsonschema.keyword.digest.helpers.NumericDigester;
import java.util.Map;

public final class MinimumDigester
extends NumericDigester {
    private static final Digester INSTANCE = new MinimumDigester();

    private MinimumDigester() {
        super("minimum");
    }

    public static Digester getInstance() {
        return INSTANCE;
    }

    @Override
    public JsonNode digest(JsonNode jsonNode) {
        ObjectNode objectNode = this.digestedNumberNode(jsonNode);
        boolean bl = jsonNode.path("exclusiveMinimum").asBoolean(false);
        BooleanNode booleanNode = objectNode._nodeFactory.booleanNode(bl);
        objectNode._children.put((Object)"exclusive", (Object)booleanNode);
        return objectNode;
    }
}

