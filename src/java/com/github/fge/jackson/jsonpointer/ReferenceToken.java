/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jackson.jsonpointer.JsonPointerMessages
 *  com.github.fge.msgsimple.bundle.MessageBundle
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.CharBuffer
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.List
 */
package com.github.fge.jackson.jsonpointer;

import com.github.fge.jackson.jsonpointer.JsonPointerMessages;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ReferenceToken {
    public static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonPointerMessages.class);
    public static final List<Character> DECODED;
    public static final List<Character> ENCODED;
    public final String cooked;
    public final String raw;

    public static {
        Object[] arrobject = new Character[]{Character.valueOf((char)'0'), Character.valueOf((char)'1')};
        ENCODED = Collections.unmodifiableList((List)Arrays.asList((Object[])arrobject));
        Object[] arrobject2 = new Character[]{Character.valueOf((char)'~'), Character.valueOf((char)'/')};
        DECODED = Collections.unmodifiableList((List)Arrays.asList((Object[])arrobject2));
    }

    public ReferenceToken(String string, String string2) {
        this.cooked = string;
        this.raw = string2;
    }

    public static ReferenceToken fromRaw(String string) {
        BUNDLE.checkNotNull((Object)string, "nullInput");
        StringBuilder stringBuilder = new StringBuilder(string.length());
        CharBuffer charBuffer = CharBuffer.wrap((CharSequence)string);
        while (charBuffer.hasRemaining()) {
            char c4 = charBuffer.get();
            int n3 = DECODED.indexOf((Object)Character.valueOf((char)c4));
            if (n3 != -1) {
                stringBuilder.append('~');
                stringBuilder.append(ENCODED.get(n3));
                continue;
            }
            stringBuilder.append(c4);
        }
        return new ReferenceToken(stringBuilder.toString(), string);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (ReferenceToken.class != object.getClass()) {
            return false;
        }
        ReferenceToken referenceToken = (ReferenceToken)object;
        return this.raw.equals((Object)referenceToken.raw);
    }

    public int hashCode() {
        return this.raw.hashCode();
    }

    public String toString() {
        return this.cooked;
    }
}

