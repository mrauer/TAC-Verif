/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigDecimal
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 */
package com.github.fge.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.github.fge.jackson.NodeType;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public final class JsonNumEquals {
    public static final boolean arrayEquals(JsonNode jsonNode, JsonNode jsonNode2) {
        int n3 = jsonNode.size();
        for (int i3 = 0; i3 < n3; ++i3) {
            if (JsonNumEquals.equivalent(jsonNode.get(i3), jsonNode2.get(i3))) continue;
            return false;
        }
        return true;
    }

    public static int doHash(JsonNode jsonNode) {
        if (jsonNode.isNumber()) {
            return Double.valueOf((double)jsonNode.doubleValue()).hashCode();
        }
        if (!jsonNode.isContainerNode()) {
            return jsonNode.hashCode();
        }
        int n3 = 0;
        if (jsonNode.size() == 0) {
            return 0;
        }
        if (jsonNode instanceof ArrayNode) {
            Iterator iterator = jsonNode.elements();
            while (iterator.hasNext()) {
                JsonNode jsonNode2 = (JsonNode)iterator.next();
                n3 = n3 * 31 + JsonNumEquals.hash(jsonNode2);
            }
            return n3;
        }
        Iterator iterator = jsonNode.fields();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            n3 = n3 * 31 + (((String)entry.getKey()).hashCode() ^ JsonNumEquals.hash((JsonNode)entry.getValue()));
        }
        return n3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean equivalent(JsonNode jsonNode, JsonNode jsonNode2) {
        boolean bl = true;
        if (jsonNode == jsonNode2) {
            return bl;
        }
        boolean bl2 = false;
        if (jsonNode == null) return bl2;
        if (jsonNode2 == null) {
            return false;
        }
        if (jsonNode.isNumber() && jsonNode2.isNumber()) {
            if (jsonNode.isIntegralNumber() && jsonNode2.isIntegralNumber()) {
                return jsonNode.equals((Object)jsonNode2);
            }
        } else {
            String string;
            NodeType nodeType = NodeType.getNodeType(jsonNode);
            if (nodeType != NodeType.getNodeType(jsonNode2)) {
                return false;
            }
            if (!jsonNode.isContainerNode()) {
                return jsonNode.equals((Object)jsonNode2);
            }
            if (jsonNode.size() != jsonNode2.size()) {
                return false;
            }
            if (nodeType == NodeType.ARRAY) {
                return JsonNumEquals.arrayEquals(jsonNode, jsonNode2);
            }
            HashSet hashSet = new HashSet();
            Iterator iterator = jsonNode.fieldNames();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                Objects.requireNonNull((Object)string2);
                hashSet.add((Object)string2);
            }
            HashSet hashSet2 = new HashSet();
            Iterator iterator2 = jsonNode2.fieldNames();
            while (iterator2.hasNext()) {
                String string3 = (String)iterator2.next();
                Objects.requireNonNull((Object)string3);
                hashSet2.add((Object)string3);
            }
            if (!hashSet2.equals((Object)hashSet)) return false;
            Iterator iterator3 = hashSet.iterator();
            do {
                if (!iterator3.hasNext()) return bl;
            } while (JsonNumEquals.equivalent(jsonNode.get(string = (String)iterator3.next()), jsonNode2.get(string)));
            return false;
        }
        if (jsonNode.decimalValue().compareTo(jsonNode2.decimalValue()) != 0) return false;
        return bl;
    }

    public static final int hash(JsonNode jsonNode) {
        if (jsonNode == null) {
            return 0;
        }
        return JsonNumEquals.doHash(jsonNode);
    }
}

