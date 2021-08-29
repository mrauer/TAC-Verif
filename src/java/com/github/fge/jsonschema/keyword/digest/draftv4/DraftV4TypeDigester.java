/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 *  java.util.Iterator
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
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Objects;

public final class DraftV4TypeDigester
extends AbstractDigester {
    private static final Digester INSTANCE = new DraftV4TypeDigester();

    private DraftV4TypeDigester() {
        super("type", NodeType.ARRAY, NodeType.values());
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
        JsonNode jsonNode2 = jsonNode.get(this.keyword);
        EnumSet enumSet = EnumSet.noneOf(NodeType.class);
        if (jsonNode2.isTextual()) {
            enumSet.add((Object)NodeType.fromName(jsonNode2.textValue()));
        } else {
            Iterator iterator = jsonNode2.elements();
            while (iterator.hasNext()) {
                enumSet.add((Object)NodeType.fromName(((JsonNode)iterator.next()).textValue()));
            }
        }
        if (enumSet.contains((Object)NodeType.NUMBER)) {
            enumSet.add((Object)NodeType.INTEGER);
        }
        Iterator iterator = enumSet.iterator();
        while (iterator.hasNext()) {
            arrayNode.add(((NodeType)((Object)iterator.next())).toString());
        }
        return objectNode;
    }
}

