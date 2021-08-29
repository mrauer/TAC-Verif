/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.util.AsJson;
import com.github.fge.jsonschema.core.util.ValueHolder;

public final class AsJsonValueHolder<T extends AsJson>
extends ValueHolder<T> {
    public AsJsonValueHolder(String string, T t2) {
        super(string, t2);
    }

    @Override
    public JsonNode valueAsJson() {
        return ((AsJson)this.value).asJson();
    }
}

