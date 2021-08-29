/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.fasterxml.jackson.databind.node.TextNode
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.TextNode;
import com.github.fge.jsonschema.core.util.ValueHolder;

public final class SimpleValueHolder<T>
extends ValueHolder<T> {
    public SimpleValueHolder(String string, T t2) {
        super(string, t2);
    }

    @Override
    public JsonNode valueAsJson() {
        return ValueHolder.FACTORY.textNode(this.value.getClass().getCanonicalName());
    }
}

