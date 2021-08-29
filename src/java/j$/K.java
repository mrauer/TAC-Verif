/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.j
 *  java.lang.Object
 *  java.util.Comparator
 *  java.util.Spliterator
 *  java.util.Spliterator$OfDouble
 *  java.util.Spliterator$OfPrimitive
 *  java.util.function.Consumer
 *  java.util.function.DoubleConsumer
 */
package j$;

import j$.B;
import j$.i;
import j$.q;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.r;
import j$.x;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.DoubleConsumer;

public final class k
implements Spliterator.OfDouble {
    final /* synthetic */ Spliterator.a a;

    private /* synthetic */ k(Spliterator.a a2) {
        this.a = a2;
    }

    public static /* synthetic */ Spliterator.OfDouble a(Spliterator.a a2) {
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof j.j) {
            return ((j.j)a2).a;
        }
        return new k(a2);
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

    public /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.a.e(B.b(doubleConsumer));
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

    public /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return this.a.o(B.b(doubleConsumer));
    }

    public /* synthetic */ Spliterator.OfDouble trySplit() {
        return k.a(this.a.trySplit());
    }

    public /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return q.a(this.a.trySplit());
    }

    public /* synthetic */ java.util.Spliterator trySplit() {
        return i.a(this.a.trySplit());
    }
}

