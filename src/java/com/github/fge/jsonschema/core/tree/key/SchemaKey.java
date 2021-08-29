/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.tree.key.AnonymousSchemaKey
 *  com.github.fge.jsonschema.core.tree.key.JsonRefSchemaKey
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.github.fge.jsonschema.core.tree.key;

import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.tree.key.AnonymousSchemaKey;
import com.github.fge.jsonschema.core.tree.key.JsonRefSchemaKey;
import java.util.Objects;

public abstract class SchemaKey {
    public final JsonRef loadingRef;

    public SchemaKey(JsonRef jsonRef) {
        this.loadingRef = jsonRef;
    }

    public static SchemaKey anonymousKey() {
        return new AnonymousSchemaKey();
    }

    public static SchemaKey forJsonRef(JsonRef jsonRef) {
        Objects.requireNonNull((Object)jsonRef);
        return new JsonRefSchemaKey(jsonRef);
    }

    public abstract boolean equals(Object var1);

    public abstract long getId();

    public final JsonRef getLoadingRef() {
        return this.loadingRef;
    }

    public abstract int hashCode();

    public abstract String toString();
}

