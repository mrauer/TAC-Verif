/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.EnumSet
 *  java.util.Iterator
 *  java.util.List
 */
package com.github.fge.jsonschema.keyword.validator.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public abstract class DraftV3TypeKeywordValidator
extends AbstractKeywordValidator {
    public static final JsonNodeFactory FACTORY = JsonNodeFactory.instance;
    public final List<Integer> schemas = new ArrayList();
    public final EnumSet<NodeType> types = EnumSet.noneOf(NodeType.class);

    public DraftV3TypeKeywordValidator(String string, JsonNode jsonNode) {
        super(string);
        Iterator iterator = jsonNode.get(string).elements();
        while (iterator.hasNext()) {
            JsonNode jsonNode2 = (JsonNode)iterator.next();
            this.types.add((Object)NodeType.fromName(jsonNode2.textValue()));
        }
        Iterator iterator2 = jsonNode.get("schemas").elements();
        while (iterator2.hasNext()) {
            JsonNode jsonNode3 = (JsonNode)iterator2.next();
            this.schemas.add((Object)jsonNode3.intValue());
        }
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.keyword);
        stringBuilder.append(": ");
        stringBuilder.append(this.types);
        stringBuilder.append("; ");
        stringBuilder.append(this.schemas.size());
        stringBuilder.append(" schemas");
        return stringBuilder.toString();
    }
}

