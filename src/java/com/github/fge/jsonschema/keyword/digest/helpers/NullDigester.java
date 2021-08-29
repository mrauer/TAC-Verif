/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.NullNode
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.github.fge.jsonschema.keyword.digest.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.AbstractDigester;
import java.util.Objects;

public final class NullDigester
extends AbstractDigester {
    public /* varargs */ NullDigester(String string, NodeType nodeType, NodeType ... arrnodeType) {
        super(string, nodeType, arrnodeType);
    }

    @Override
    public JsonNode digest(JsonNode jsonNode) {
        Objects.requireNonNull((Object)AbstractDigester.FACTORY);
        return NullNode.instance;
    }
}

