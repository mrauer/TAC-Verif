/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.github.fge.jsonschema.core.util;

import com.github.fge.Frozen;
import com.github.fge.Thawed;
import com.github.fge.jsonschema.core.util.DictionaryBuilder;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public final class Dictionary<T>
implements Frozen<DictionaryBuilder<T>> {
    public final Map<String, T> entries;

    public Dictionary(DictionaryBuilder<T> dictionaryBuilder) {
        this.entries = ImmutableMap.copyOf(dictionaryBuilder.entries);
    }

    public static <T> DictionaryBuilder<T> newBuilder() {
        return new DictionaryBuilder();
    }

    public Map<String, T> entries() {
        return this.entries;
    }

    public DictionaryBuilder<T> thaw() {
        return new DictionaryBuilder(this);
    }
}

