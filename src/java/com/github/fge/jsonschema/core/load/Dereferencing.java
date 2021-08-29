/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.github.fge.jsonschema.core.load.Dereferencing$1
 *  com.github.fge.jsonschema.core.load.Dereferencing$2
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.load;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.load.Dereferencing;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.core.tree.key.SchemaKey;

public abstract class Dereferencing
extends Enum<Dereferencing> {
    private static final /* synthetic */ Dereferencing[] $VALUES;
    public static final /* enum */ Dereferencing CANONICAL;
    public static final /* enum */ Dereferencing INLINE;
    private final String name;

    public static {
        1 var0 = new 1("CANONICAL", 0, "canonical");
        CANONICAL = var0;
        2 var1_1 = new 2("INLINE", 1, "inline");
        INLINE = var1_1;
        $VALUES = new Dereferencing[]{var0, var1_1};
    }

    private Dereferencing(String string2) {
        this.name = string2;
    }

    public /* synthetic */ Dereferencing(String string, int n3, String string2, 1 var4_4) {
        this(string2);
    }

    public static Dereferencing valueOf(String string) {
        return (Dereferencing)Enum.valueOf(Dereferencing.class, (String)string);
    }

    public static Dereferencing[] values() {
        return (Dereferencing[])$VALUES.clone();
    }

    public SchemaTree newTree(JsonNode jsonNode) {
        return this.newTree(SchemaKey.anonymousKey(), jsonNode);
    }

    public SchemaTree newTree(JsonRef jsonRef, JsonNode jsonNode) {
        return this.newTree(SchemaKey.forJsonRef(jsonRef), jsonNode);
    }

    public abstract SchemaTree newTree(SchemaKey var1, JsonNode var2);

    public String toString() {
        return this.name;
    }
}

