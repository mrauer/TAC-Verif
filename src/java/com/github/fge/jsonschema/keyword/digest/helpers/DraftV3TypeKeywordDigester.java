/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ContainerNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.NumericNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.EnumSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 */
package com.github.fge.jsonschema.keyword.digest.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.AbstractDigester;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class DraftV3TypeKeywordDigester
extends AbstractDigester {
    private static final String ANY = "any";

    public DraftV3TypeKeywordDigester(String string) {
        super(string, NodeType.ARRAY, NodeType.values());
    }

    private static void putType(EnumSet<NodeType> enumSet, String string) {
        if (ANY.equals((Object)string)) {
            enumSet.addAll((Collection)EnumSet.allOf(NodeType.class));
            return;
        }
        NodeType nodeType = NodeType.fromName(string);
        enumSet.add((Object)nodeType);
        if (nodeType == NodeType.NUMBER) {
            enumSet.add((Object)NodeType.INTEGER);
        }
    }

    @Override
    public JsonNode digest(JsonNode jsonNode) {
        JsonNodeFactory jsonNodeFactory = AbstractDigester.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        Objects.requireNonNull((Object)jsonNodeFactory);
        ArrayNode arrayNode = new ArrayNode(jsonNodeFactory);
        objectNode.set(this.keyword, (JsonNode)arrayNode);
        Objects.requireNonNull((Object)jsonNodeFactory);
        ArrayNode arrayNode2 = new ArrayNode(jsonNodeFactory);
        objectNode._children.put((Object)"schemas", (Object)arrayNode2);
        JsonNode jsonNode2 = jsonNode.get(this.keyword);
        EnumSet enumSet = EnumSet.noneOf(NodeType.class);
        if (jsonNode2.isTextual()) {
            DraftV3TypeKeywordDigester.putType((EnumSet<NodeType>)enumSet, jsonNode2.textValue());
        } else {
            int n2 = jsonNode2.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                JsonNode jsonNode3 = jsonNode2.get(i2);
                if (jsonNode3.isTextual()) {
                    DraftV3TypeKeywordDigester.putType((EnumSet<NodeType>)enumSet, jsonNode3.textValue());
                    continue;
                }
                NumericNode numericNode = arrayNode2._nodeFactory.numberNode(i2);
                arrayNode2._children.add((Object)numericNode);
            }
        }
        if (EnumSet.complementOf((EnumSet)enumSet).isEmpty()) {
            arrayNode2._children.clear();
        }
        Iterator iterator = enumSet.iterator();
        while (iterator.hasNext()) {
            arrayNode.add(((NodeType)((Object)iterator.next())).toString());
        }
        return objectNode;
    }
}

