/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.BooleanNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  com.google.common.collect.Collections2
 *  com.google.common.collect.NaturalOrdering
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 */
package com.github.fge.jsonschema.processors.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.AbstractDigester;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.google.common.collect.Collections2;
import com.google.common.collect.NaturalOrdering;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class ObjectSchemaDigester
extends AbstractDigester {
    private static final Digester INSTANCE = new ObjectSchemaDigester();

    private ObjectSchemaDigester() {
        super("", NodeType.OBJECT, new NodeType[0]);
    }

    public static Digester getInstance() {
        return INSTANCE;
    }

    @Override
    public JsonNode digest(JsonNode jsonNode) {
        JsonNodeFactory jsonNodeFactory = AbstractDigester.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory);
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        JsonNode jsonNode2 = jsonNode.path("additionalProperties");
        Objects.requireNonNull((Object)jsonNode2);
        BooleanNode booleanNode = jsonNodeFactory.booleanNode(jsonNode2 instanceof ObjectNode);
        objectNode._children.put((Object)"hasAdditional", (Object)booleanNode);
        Objects.requireNonNull((Object)jsonNodeFactory);
        ArrayNode arrayNode = new ArrayNode(jsonNodeFactory);
        objectNode._children.put((Object)"properties", (Object)arrayNode);
        HashSet hashSet = Collections2.newHashSet((Iterator)jsonNode.path("properties").fieldNames());
        Iterator iterator = NaturalOrdering.INSTANCE.sortedCopy((Iterable)hashSet).iterator();
        while (iterator.hasNext()) {
            arrayNode.add((String)iterator.next());
        }
        JsonNodeFactory jsonNodeFactory2 = AbstractDigester.FACTORY;
        Objects.requireNonNull((Object)jsonNodeFactory2);
        ArrayNode arrayNode2 = new ArrayNode(jsonNodeFactory2);
        objectNode._children.put((Object)"patternProperties", (Object)arrayNode2);
        HashSet hashSet2 = Collections2.newHashSet((Iterator)jsonNode.path("patternProperties").fieldNames());
        Iterator iterator2 = NaturalOrdering.INSTANCE.sortedCopy((Iterable)hashSet2).iterator();
        while (iterator2.hasNext()) {
            arrayNode2.add((String)iterator2.next());
        }
        return objectNode;
    }
}

