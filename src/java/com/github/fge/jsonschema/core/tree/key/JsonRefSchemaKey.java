/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.fge.jsonschema.core.tree.key;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.tree.key.SchemaKey;

public final class JsonRefSchemaKey
extends SchemaKey {
    public JsonRefSchemaKey(JsonRef jsonRef) {
        super(jsonRef);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (JsonRefSchemaKey.class != object.getClass()) {
            return false;
        }
        JsonRefSchemaKey jsonRefSchemaKey = (JsonRefSchemaKey)object;
        return this.loadingRef.equals(jsonRefSchemaKey.loadingRef);
    }

    @Override
    public long getId() {
        return 0L;
    }

    @Override
    public int hashCode() {
        return this.loadingRef.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"loaded from JSON ref ");
        stringBuilder.append((Object)this.loadingRef);
        return stringBuilder.toString();
    }
}

