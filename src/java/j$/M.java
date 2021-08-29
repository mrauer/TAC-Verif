/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.l
 *  java.lang.Object
 *  java.util.Comparator
 *  java.util.Spliterator
 *  java.util.Spliterator$OfInt
 *  java.util.Spliterator$OfPrimitive
 *  java.util.function.Consumer
 *  java.util.function.IntConsumer
 */
package j$;

import j$.S;
import j$.i;
import j$.q;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.x;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.IntConsumer;

public final class m
implements Spliterator.OfInt {
    final /* synthetic */ Spliterator.b a;

    private /* synthetic */ m(Spliterator.b b2) {
        this.a = b2;
    }

    public static /* synthetic */ Spliterator.OfInt a(Spliterator.b b2) {
        if (b2 == null) {
            return null;
        }
        if (b2 instanceof j.l) {
            return ((j.l)b2).a;
        }
        return new m(b2);
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
        this.a.forEachRemaining(j$.x.b(consumer));
    }

    public /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.a.c(S.b(intConsumer));
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
        return this.a.b(j$.x.b(consumer));
    }

    public /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.a.h(S.b(intConsumer));
    }

    public /* synthetic */ Spliterator.OfInt trySplit() {
        return m.a(this.a.trySplit());
    }

    public /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return q.a(this.a.trySplit());
    }

    public /* synthetic */ java.util.Spliterator trySplit() {
        return i.a(this.a.trySplit());
    }
}

