/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  com.google.common.base.Function
 *  com.google.common.collect.ImmutableMap
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.github.fge.jsonschema.core.util;

import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.util.ArgumentChecker;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Registry<K, V> {
    public static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    private final ArgumentChecker<K> keyChecker;
    private final Function<K, K> keyNormalizer;
    private final Map<K, V> map = new HashMap();
    private final ArgumentChecker<V> valueChecker;
    private final Function<V, V> valueNormalizer;

    public Registry(Function<K, K> function, ArgumentChecker<K> argumentChecker, Function<V, V> function2, ArgumentChecker<V> argumentChecker2) {
        MessageBundle messageBundle = BUNDLE;
        messageBundle.checkNotNull(function, "mapBuilder.nullNormalizer");
        this.keyNormalizer = function;
        messageBundle.checkNotNull(argumentChecker, "mapBuilder.nullChecker");
        this.keyChecker = argumentChecker;
        messageBundle.checkNotNull(function2, "mapBuilder.nullNormalizer");
        this.valueNormalizer = function2;
        messageBundle.checkNotNull(argumentChecker2, "mapBuilder.nullChecker");
        this.valueChecker = argumentChecker2;
    }

    public final Map<K, V> build() {
        return ImmutableMap.copyOf(this.map);
    }

    public abstract void checkEntry(K var1, V var2);

    public final Registry<K, V> clear() {
        this.map.clear();
        return this;
    }

    public final Registry<K, V> put(K k3, V v2) {
        MessageBundle messageBundle = BUNDLE;
        messageBundle.checkNotNull(k3, "mapBuilder.nullKey");
        messageBundle.checkNotNull(v2, "mapBuilder.nullValue");
        Object object = this.keyNormalizer.apply(k3);
        this.keyChecker.check(k3);
        Object object2 = this.valueNormalizer.apply(v2);
        this.valueChecker.check(v2);
        this.checkEntry(object, object2);
        this.map.put(object, object2);
        return this;
    }

    public final Registry<K, V> putAll(Map<K, V> map) {
        BUNDLE.checkNotNull(map, "mapBuilder.nullMap");
        for (Map.Entry entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final Registry<K, V> remove(K k3) {
        this.map.remove(k3);
        return this;
    }
}

