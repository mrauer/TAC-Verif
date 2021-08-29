/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.f
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.PrimitiveIterator
 *  java.util.PrimitiveIterator$OfLong
 *  java.util.function.Consumer
 *  java.util.function.LongConsumer
 */
package j$;

import j$.g0;
import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.s;
import j$.x;
import java.util.PrimitiveIterator;
import java.util.function.LongConsumer;

public final class g
implements PrimitiveIterator.OfLong {
    final /* synthetic */ s.c a;

    private /* synthetic */ g(s.c c2) {
        this.a = c2;
    }

    public static /* synthetic */ PrimitiveIterator.OfLong a(s.c c2) {
        if (c2 == null) {
            return null;
        }
        if (c2 instanceof j.f) {
            return ((j.f)c2).a;
        }
        return new g(c2);
    }

    public /* synthetic */ void forEachRemaining(Object object) {
        this.a.forEachRemaining(object);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        this.a.forEachRemaining(x.b(consumer));
    }

    public /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.a.d(g0.b(longConsumer));
    }

    public /* synthetic */ boolean hasNext() {
        return this.a.hasNext();
    }

    public /* synthetic */ Long next() {
        return this.a.next();
    }

    public /* synthetic */ Object next() {
        return this.a.next();
    }

    public /* synthetic */ long nextLong() {
        return this.a.nextLong();
    }

    public /* synthetic */ void remove() {
        this.a.remove();
    }
}

