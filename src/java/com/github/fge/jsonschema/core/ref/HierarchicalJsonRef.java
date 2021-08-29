/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.net.URI
 *  java.util.List
 */
package com.github.fge.jsonschema.core.ref;

import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jackson.jsonpointer.TokenResolver;
import com.github.fge.jackson.jsonpointer.TreePointer;
import com.github.fge.jsonschema.core.ref.JsonRef;
import java.net.URI;
import java.util.List;

public final class HierarchicalJsonRef
extends JsonRef {
    public HierarchicalJsonRef(URI uRI) {
        super(uRI);
    }

    @Override
    public boolean isAbsolute() {
        if (!this.legal) {
            return false;
        }
        boolean bl = this.locator.isAbsolute();
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = this.pointer.tokenResolvers.isEmpty();
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    public JsonRef resolve(JsonRef jsonRef) {
        return JsonRef.fromURI(this.uri.resolve(jsonRef.uri));
    }
}

