/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.net.URI
 */
package com.github.fge.jsonschema.core.ref;

import com.github.fge.jsonschema.core.ref.JsonRef;
import java.net.URI;

public final class EmptyJsonRef
extends JsonRef {
    private static final JsonRef INSTANCE = new EmptyJsonRef();

    private EmptyJsonRef() {
        super(JsonRef.HASHONLY_URI);
    }

    public static JsonRef getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean isAbsolute() {
        return false;
    }

    @Override
    public JsonRef resolve(JsonRef jsonRef) {
        return jsonRef;
    }
}

