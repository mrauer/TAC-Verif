/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Objects
 */
package j$.util;

import j$.util.Collection$-EL;
import j$.util.DesugarCollections;
import j$.util.Spliterator;
import j$.util.function.Predicate;
import j$.util.stream.Q1;
import j$.util.stream.Stream;
import j$.util.u;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public final class Collection$-CC {
    public static Stream $default$parallelStream(Collection collection) {
        return Q1.v(Collection$-EL.b(collection), true);
    }

    public static boolean $default$removeIf(Collection collection, Predicate predicate) {
        if (DesugarCollections.a.isInstance((Object)collection)) {
            return DesugarCollections.d(collection, predicate);
        }
        Objects.requireNonNull((Object)predicate);
        boolean bl = false;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!predicate.test(iterator.next())) continue;
            iterator.remove();
            bl = true;
        }
        return bl;
    }

    public static Spliterator $default$spliterator(Collection collection) {
        Objects.requireNonNull((Object)collection);
        return new u.i(collection, 0);
    }

    public static Stream $default$stream(Collection collection) {
        return Q1.v(Collection$-EL.b(collection), false);
    }
}

