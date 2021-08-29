/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.BigIntegerNode
 *  com.fasterxml.jackson.databind.node.BooleanNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.LongNode
 *  com.fasterxml.jackson.databind.node.NullNode
 *  com.fasterxml.jackson.databind.node.NumericNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.util.Map
 *  java.util.Objects
 */
package com.github.fge.jsonschema.keyword.digest.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.AbstractDigester;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;

public abstract class NumericDigester
extends AbstractDigester {
    public NumericDigester(String string) {
        NodeType nodeType = NodeType.INTEGER;
        NodeType[] arrnodeType = new NodeType[]{NodeType.NUMBER};
        super(string, nodeType, arrnodeType);
    }

    private static boolean valueIsLong(JsonNode jsonNode) {
        if (!jsonNode.canConvertToLong()) {
            return false;
        }
        if (NodeType.getNodeType(jsonNode) == NodeType.INTEGER) {
            return true;
        }
        int n2 = jsonNode.decimalValue().remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO);
        boolean bl = false;
        if (n2 == 0) {
            bl = true;
        }
        return bl;
    }

    public final ObjectNode digestedNumberNode(JsonNode jsonNode) {
        JsonNodeFactory jsonNodeFactory = AbstractDigester.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        Object object = jsonNode.get(this.keyword);
        boolean bl = NumericDigester.valueIsLong(object);
        BooleanNode booleanNode = jsonNodeFactory.booleanNode(bl);
        objectNode._children.put((Object)"valueIsLong", (Object)booleanNode);
        if (bl) {
            String string = this.keyword;
            Object object2 = object.canConvertToInt() ? jsonNodeFactory.numberNode(object.intValue()) : new LongNode(object.longValue());
            objectNode.set(string, (JsonNode)object2);
            return objectNode;
        }
        BigDecimal bigDecimal = object.decimalValue();
        String string = this.keyword;
        if (bigDecimal.scale() == 0) {
            BigInteger bigInteger = bigDecimal.toBigIntegerExact();
            object = bigInteger == null ? NullNode.instance : new BigIntegerNode(bigInteger);
        }
        objectNode.set(string, object);
        return objectNode;
    }
}

