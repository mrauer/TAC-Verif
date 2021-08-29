/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.n
 *  java.lang.Object
 *  java.util.Comparator
 *  java.util.Spliterator
 *  java.util.Spliterator$OfLong
 *  java.util.Spliterator$OfPrimitive
 *  java.util.function.Consumer
 *  java.util.function.LongConsumer
 */
package j$;

import j$.g0;
import j$.i;
import j$.q;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.D;
import j$.x;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.LongConsumer;

public final class o
implements Spliterator.OfLong {
    final /* synthetic */ Spliterator.c a;

    private /* synthetic */ o(Spliterator.c c2) {
        this.a = c2;
    }

    public static /* synthetic */ Spliterator.OfLong a(Spliterator.c c2) {
        if (c2 == null) {
            return null;
        }
        if (c2 instanceof j.n) {
            return ((j.n)c2).a;
        }
        return new o(c2);
    }

    public /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    public /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
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

    public /* synthetic */ Comparator getComparator() {
        return this.a.getComparator();
    }

    public /* synthetic */ long getExactSizeIfKnown() {
        return this.a.getExactSizeIfKnown();
    }

    public /* synthetic */ boolean hasCharacteristics(int n2) {
        return this.a.hasCharacteristics(n2);
    }

    public /* synthetic */ boolean tryAdvance(Object object) {
        return this.a.tryAdvance(object);
    }

    public /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
        return this.a.b(x.b(consumer));
    }

    public /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return this.a.j(g0.b(longConsumer));
    }

    public /* synthetic */ Spliterator.OfLong trySplit() {
        return o.a(this.a.trySplit());
    }

    public /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return q.a(this.a.trySplit());
    }

    public /* synthetic */ java.util.Spliterator trySplit() {
        return i.a(this.a.trySplit());
    }
}

