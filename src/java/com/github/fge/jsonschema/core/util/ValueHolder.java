/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.github.fge.jsonschema.core.util.AsJsonValueHolder
 *  com.github.fge.jsonschema.core.util.SimpleValueHolder
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.util.AsJson;
import com.github.fge.jsonschema.core.util.AsJsonValueHolder;
import com.github.fge.jsonschema.core.util.SimpleValueHolder;

public abstract class ValueHolder<T>
implements MessageProvider {
    public static final JsonNodeFactory FACTORY = JsonNodeFactory.instance;
    private final String name;
    public final T value;

    public ValueHolder(String string, T t) {
        this.name = string;
        this.value = t;
    }

    public static <V extends AsJson> ValueHolder<V> hold(V v) {
        return new AsJsonValueHolder("value", v);
    }

    public static <V> ValueHolder<V> hold(V v) {
        return new SimpleValueHolder("value", v);
    }

    public static <V extends AsJson> ValueHolder<V> hold(String string, V v) {
        return new AsJsonValueHolder(string, v);
    }

    public static <V> ValueHolder<V> hold(String string, V v) {
        return new SimpleValueHolder(string, v);
    }

    public final String getName() {
        return this.name;
    }

    public final T getValue() {
        return this.value;
    }

    @Override
    public final ProcessingMessage newMessage() {
        return new ProcessingMessage().put(this.name, this.valueAsJson());
    }

    public abstract JsonNode valueAsJson();
}

