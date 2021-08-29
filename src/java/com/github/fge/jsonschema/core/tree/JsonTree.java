/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.github.fge.jsonschema.core.tree;

import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.tree.SimpleTree;

public interface JsonTree
extends SimpleTree {
    public JsonTree append(JsonPointer var1);
}

