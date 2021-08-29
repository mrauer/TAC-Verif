/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package com.github.fge.jsonschema.core.tree;

import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.tree.SimpleTree;

public interface SchemaTree
extends SimpleTree {
    public SchemaTree append(JsonPointer var1);

    public boolean containsRef(JsonRef var1);

    public JsonRef getContext();

    public JsonRef getDollarSchema();

    @Deprecated
    public long getId();

    public JsonRef getLoadingRef();

    public JsonPointer matchingPointer(JsonRef var1);

    public JsonRef resolve(JsonRef var1);

    public SchemaTree setPointer(JsonPointer var1);
}

