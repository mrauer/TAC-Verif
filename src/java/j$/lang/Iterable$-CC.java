/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.Objects
 */
package j$.lang;

import j$.util.DesugarCollections;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.u;
import java.util.Iterator;
import java.util.Objects;

public final class Iterable$-CC {
    public static void $default$forEach(Iterable iterable, Consumer consumer) {
        if (DesugarCollections.a.isInstance((Object)iterable)) {
            DesugarCollections.c(iterable, consumer);
            return;
        }
        Objects.requireNonNull((Object)consumer);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }

    public static Spliterator $default$spliterator(Iterable iterable) {
        return u.o(iterable.iterator(), 0);
    }
}

