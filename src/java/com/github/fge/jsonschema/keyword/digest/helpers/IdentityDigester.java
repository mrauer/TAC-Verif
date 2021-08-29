/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.String
 */
package com.github.fge.jsonschema.keyword.digest.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.AbstractDigester;

public final class IdentityDigester
extends AbstractDigester {
    public /* varargs */ IdentityDigester(String string, NodeType nodeType, NodeType ... arrnodeType) {
        super(string, nodeType, arrnodeType);
    }

    @Override
    public JsonNode digest(JsonNode jsonNode) {
        return jsonNode;
    }
}

