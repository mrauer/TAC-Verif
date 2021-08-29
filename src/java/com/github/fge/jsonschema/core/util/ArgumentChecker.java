/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle
 *  com.github.fge.jsonschema.core.util.ArgumentChecker$1
 *  com.github.fge.jsonschema.core.util.ArgumentChecker$2
 *  com.github.fge.jsonschema.core.util.ArgumentChecker$3
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.util;

import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.util.ArgumentChecker;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;

public abstract class ArgumentChecker<T> {
    public static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);

    public static <X> ArgumentChecker<X> anythingGoes() {
        return new 1();
    }

    public static <X> ArgumentChecker<X> notNull() {
        return new 2();
    }

    public static <X> ArgumentChecker<X> notNull(String string) {
        BUNDLE.checkNotNull((Object)string, "argChecker.nullMessage");
        return new 3(string);
    }

    public abstract void check(T var1);
}

