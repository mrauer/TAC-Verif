/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.Objects
 */
package j$.util;

import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Objects;

public final class Iterator$-CC {
    public static void $default$forEachRemaining(Iterator iterator, Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }

    public static void a(Iterator iterator) {
        throw new UnsupportedOperationException("remove");
    }
}

