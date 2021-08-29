/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.github.fge.msgsimple;

import java.util.HashMap;
import java.util.Map;

public final class InternalBundle {
    public static final InternalBundle INSTANCE = new InternalBundle();
    public final Map<String, String> messages;

    public InternalBundle() {
        HashMap hashMap;
        this.messages = hashMap = new HashMap();
        hashMap.put((Object)"query.nullKey", (Object)"cannot query null keys");
        hashMap.put((Object)"query.nullLocale", (Object)"cannot query null locale");
        hashMap.put((Object)"cfg.nullProvider", (Object)"cannot append null message source provider");
        hashMap.put((Object)"cfg.nullResourcePath", (Object)"resource path cannot be null");
        hashMap.put((Object)"cfg.noLoader", (Object)"no loader has been provided");
        hashMap.put((Object)"cfg.nullLoader", (Object)"loader cannot be null");
        hashMap.put((Object)"cfg.nullDefaultSource", (Object)"when provided, the default message source must not be null");
        hashMap.put((Object)"cfg.nonPositiveDuration", (Object)"timeout must be greater than 0");
        hashMap.put((Object)"cfg.nullTimeUnit", (Object)"time unit must not be null");
        hashMap.put((Object)"cfg.nullKey", (Object)"null keys are not allowed");
        hashMap.put((Object)"cfg.nullSource", (Object)"null sources are not allowed");
        hashMap.put((Object)"cfg.nullMap", (Object)"null map is not allowed");
        hashMap.put((Object)"cfg.nullFile", (Object)"file cannot be null");
        hashMap.put((Object)"cfg.nullPath", (Object)"file path cannot be null");
        hashMap.put((Object)"cfg.nullInputStream", (Object)"provided InputStream is null");
        hashMap.put((Object)"cfg.map.nullKey", (Object)"null keys not allowed in map");
        hashMap.put((Object)"cfg.map.nullValue", (Object)"null values not allowed in map");
        hashMap.put((Object)"properties.resource.notFound", (Object)"resource \"%s\" not found");
        hashMap.put((Object)"cfg.nullCharset", (Object)"charset cannot be null");
        hashMap.put((Object)"cfg.nullBundle", (Object)"bundle cannot be null");
        hashMap.put((Object)"factory.noConstructor", (Object)"bundle provider does not have a no-arg constructor");
        hashMap.put((Object)"factory.cannotInstantiate", (Object)"cannot instantiate bundle provider");
        hashMap.put((Object)"factory.illegalProvider", (Object)"bundle provider returns null");
    }

    public <T> T checkNotNull(T t3, String string) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException((String)this.messages.get((Object)string));
    }
}

