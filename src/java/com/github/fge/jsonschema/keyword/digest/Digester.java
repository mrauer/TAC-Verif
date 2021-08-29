/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
 *  java.util.EnumSet
 */
package com.github.fge.jsonschema.keyword.digest;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import java.util.EnumSet;

public interface Digester {
    public JsonNode digest(JsonNode var1);

    public EnumSet<NodeType> supportedTypes();
}

