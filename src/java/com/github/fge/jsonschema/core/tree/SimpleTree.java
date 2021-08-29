/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
 */
package com.github.fge.jsonschema.core.tree;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.util.AsJson;

public interface SimpleTree
extends AsJson {
    public JsonNode getBaseNode();

    public JsonNode getNode();

    public JsonPointer getPointer();
}

