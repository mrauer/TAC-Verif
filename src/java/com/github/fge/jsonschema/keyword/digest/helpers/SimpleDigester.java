/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.github.fge.jsonschema.keyword.digest.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.AbstractDigester;
import java.util.Objects;

public final class SimpleDigester
extends AbstractDigester {
    public /* varargs */ SimpleDigester(String string, NodeType nodeType, NodeType ... arrnodeType) {
        super(string, nodeType, arrnodeType);
    }

    @Override
    public JsonNode digest(JsonNode jsonNode) {
        JsonNodeFactory jsonNodeFactory = AbstractDigester.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        String string = this.keyword;
        objectNode.set(string, jsonNode.get(string));
        return objectNode;
    }
}

