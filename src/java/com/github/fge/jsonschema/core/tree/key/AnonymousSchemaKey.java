/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.atomic.AtomicLong
 */
package com.github.fge.jsonschema.core.tree.key;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.tree.key.SchemaKey;
import java.util.concurrent.atomic.AtomicLong;

public final class AnonymousSchemaKey
extends SchemaKey {
    private static final AtomicLong ID_GEN = new AtomicLong(0L);
    private final long id = ID_GEN.getAndIncrement();

    public AnonymousSchemaKey() {
        super(JsonRef.emptyRef());
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (AnonymousSchemaKey.class != object.getClass()) {
            return false;
        }
        AnonymousSchemaKey anonymousSchemaKey = (AnonymousSchemaKey)object;
        long l = this.id LCMP anonymousSchemaKey.id;
        boolean bl = false;
        if (l == false) {
            bl = true;
        }
        return bl;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        long l = this.id;
        return (int)(l ^ l >>> 32);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"anonymous; id = ");
        stringBuilder.append(this.id);
        return stringBuilder.toString();
    }
}

