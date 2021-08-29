/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.tree;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.tree.JsonTree;

public abstract class BaseJsonTree
implements JsonTree {
    public static final JsonNodeFactory FACTORY = JsonNodeFactory.instance;
    public final JsonNode baseNode;
    private final JsonNode node;
    public final JsonPointer pointer;

    public BaseJsonTree(JsonNode jsonNode) {
        this(jsonNode, JsonPointer.EMPTY);
    }

    public BaseJsonTree(JsonNode jsonNode, JsonPointer jsonPointer) {
        this.baseNode = jsonNode;
        this.node = jsonPointer.path(jsonNode);
        this.pointer = jsonPointer;
    }

    @Override
    public final JsonNode getBaseNode() {
        return this.baseNode;
    }

    @Override
    public final JsonNode getNode() {
        return this.node;
    }

    @Override
    public final JsonPointer getPointer() {
        return this.pointer;
    }

    public abstract String toString();
}

