/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.JsonToken
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.EnumMap
 *  java.util.HashMap
 *  java.util.Map
 */
package com.github.fge.jackson;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class NodeType
extends Enum<NodeType> {
    private static final /* synthetic */ NodeType[] $VALUES;
    public static final /* enum */ NodeType ARRAY;
    public static final /* enum */ NodeType BOOLEAN;
    public static final /* enum */ NodeType INTEGER;
    private static final Map<String, NodeType> NAME_MAP;
    public static final /* enum */ NodeType NULL;
    public static final /* enum */ NodeType NUMBER;
    public static final /* enum */ NodeType OBJECT;
    public static final /* enum */ NodeType STRING;
    private static final Map<JsonToken, NodeType> TOKEN_MAP;
    private final String name;

    public static {
        EnumMap enumMap;
        NodeType nodeType;
        NodeType nodeType2;
        NodeType nodeType3;
        NodeType nodeType4;
        NodeType nodeType5;
        NodeType nodeType6;
        NodeType nodeType7;
        ARRAY = nodeType7 = new NodeType("array");
        BOOLEAN = nodeType3 = new NodeType("boolean");
        INTEGER = nodeType2 = new NodeType("integer");
        NULL = nodeType6 = new NodeType("null");
        NUMBER = nodeType4 = new NodeType("number");
        OBJECT = nodeType5 = new NodeType("object");
        STRING = nodeType = new NodeType("string");
        $VALUES = new NodeType[]{nodeType7, nodeType3, nodeType2, nodeType6, nodeType4, nodeType5, nodeType};
        TOKEN_MAP = enumMap = new EnumMap(JsonToken.class);
        enumMap.put((Object)JsonToken.START_ARRAY, (Object)nodeType7);
        enumMap.put((Object)JsonToken.VALUE_TRUE, (Object)nodeType3);
        enumMap.put((Object)JsonToken.VALUE_FALSE, (Object)nodeType3);
        enumMap.put((Object)JsonToken.VALUE_NUMBER_INT, (Object)nodeType2);
        enumMap.put((Object)JsonToken.VALUE_NUMBER_FLOAT, (Object)nodeType4);
        enumMap.put((Object)JsonToken.VALUE_NULL, (Object)nodeType6);
        enumMap.put((Object)JsonToken.START_OBJECT, (Object)nodeType5);
        enumMap.put((Object)JsonToken.VALUE_STRING, (Object)nodeType);
        HashMap hashMap = new HashMap();
        NodeType[] arrnodeType = NodeType.values();
        for (int i3 = 0; i3 < 7; ++i3) {
            NodeType nodeType8 = arrnodeType[i3];
            hashMap.put((Object)nodeType8.name, (Object)nodeType8);
        }
        NAME_MAP = Collections.unmodifiableMap((Map)hashMap);
    }

    public NodeType(String string2) {
        this.name = string2;
    }

    public static NodeType fromName(String string) {
        return (NodeType)((Object)NAME_MAP.get((Object)string));
    }

    public static NodeType getNodeType(JsonNode jsonNode) {
        JsonToken jsonToken = jsonNode.asToken();
        NodeType nodeType = (NodeType)((Object)TOKEN_MAP.get((Object)jsonToken));
        if (nodeType != null) {
            return nodeType;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unhandled token type ");
        stringBuilder.append((Object)jsonToken);
        throw new NullPointerException(stringBuilder.toString());
    }

    public static NodeType valueOf(String string) {
        return (NodeType)Enum.valueOf(NodeType.class, (String)string);
    }

    public static NodeType[] values() {
        return (NodeType[])$VALUES.clone();
    }

    public String toString() {
        return this.name;
    }
}

