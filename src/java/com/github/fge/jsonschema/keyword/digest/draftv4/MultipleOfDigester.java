/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  java.lang.String
 */
package com.github.fge.jsonschema.keyword.digest.draftv4;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.github.fge.jsonschema.keyword.digest.helpers.NumericDigester;

public final class MultipleOfDigester
extends NumericDigester {
    private static final Digester INSTANCE = new MultipleOfDigester();

    private MultipleOfDigester() {
        super("multipleOf");
    }

    public static Digester getInstance() {
        return INSTANCE;
    }

    @Override
    public JsonNode digest(JsonNode jsonNode) {
        return this.digestedNumberNode(jsonNode);
    }
}

