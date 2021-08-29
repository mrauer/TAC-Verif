/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.github.fge.jsonschema.core.util;

import com.github.fge.Frozen;
import com.github.fge.Thawed;
import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.util.Dictionary;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import java.util.HashMap;
import java.util.Map;

public final class DictionaryBuilder<T>
implements Thawed<Dictionary<T>> {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    public final Map<String, T> entries;

    public DictionaryBuilder() {
        this.entries = new HashMap();
    }

    public DictionaryBuilder(Dictionary<T> dictionary) {
        HashMap hashMap;
        this.entries = hashMap = new HashMap();
        hashMap.putAll(dictionary.entries);
    }

    public DictionaryBuilder<T> addAll(Dictionary<T> dictionary) {
        BUNDLE.checkNotNull(dictionary, "dictionary.nullDict");
        this.entries.putAll(dictionary.entries);
        return this;
    }

    public DictionaryBuilder<T> addEntry(String string, T t) {
        MessageBundle messageBundle = BUNDLE;
        messageBundle.checkNotNull(string, "dictionary.nullKey");
        messageBundle.checkNotNull(t, "dictionary.nullValue");
        this.entries.put((Object)string, t);
        return this;
    }

    public Dictionary<T> freeze() {
        return new Dictionary(this);
    }

    public DictionaryBuilder<T> removeEntry(String string) {
        this.entries.remove((Object)string);
        return this;
    }
}

