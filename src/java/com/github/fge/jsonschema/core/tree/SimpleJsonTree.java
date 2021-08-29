/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.NullNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  com.fasterxml.jackson.databind.node.TextNode
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  java.util.Objects
 */
package com.github.fge.jsonschema.core.tree;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.tree.BaseJsonTree;
import com.github.fge.jsonschema.core.tree.JsonTree;
import java.util.Map;
import java.util.Objects;

public final class SimpleJsonTree
extends BaseJsonTree {
    public SimpleJsonTree(JsonNode jsonNode) {
        super(jsonNode);
    }

    private SimpleJsonTree(JsonNode jsonNode, JsonPointer jsonPointer) {
        super(jsonNode, jsonPointer);
    }

    @Override
    public SimpleJsonTree append(JsonPointer jsonPointer) {
        return new SimpleJsonTree(this.baseNode, this.pointer.append(jsonPointer));
    }

    @Override
    public JsonNode asJson() {
        JsonNodeFactory jsonNodeFactory = BaseJsonTree.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        TextNode textNode = jsonNodeFactory.textNode(this.pointer.toString());
        if (textNode == null) {
            objectNode.nullNode();
            textNode = NullNode.instance;
        }
        objectNode._children.put((Object)"pointer", (Object)textNode);
        return objectNode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"current pointer: \"");
        stringBuilder.append((Object)this.pointer);
        stringBuilder.append('\"');
        return stringBuilder.toString();
    }
}

