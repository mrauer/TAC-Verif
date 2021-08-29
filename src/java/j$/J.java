/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Comparator
 *  java.util.Spliterator
 *  java.util.Spliterator$OfDouble
 *  java.util.Spliterator$OfPrimitive
 *  java.util.function.Consumer
 *  java.util.function.DoubleConsumer
 */
package j$;

import j$.C;
import j$.h;
import j$.k;
import j$.p;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.r;
import j$.y;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.DoubleConsumer;

public final class j
implements Spliterator.a {
    final /* synthetic */ Spliterator.OfDouble a;

    private /* synthetic */ j(Spliterator.OfDouble ofDouble) {
        this.a = ofDouble;
    }

    public static /* synthetic */ Spliterator.a a(Spliterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        if (ofDouble instanceof k) {
            return ((k)ofDouble).a;
        }
        return new j(ofDouble);
    }

    @Override
    public /* synthetic */ boolean b(Consumer consumer) {
        return this.a.tryAdvance(y.a(consumer));
    }

    @Override
    public /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    @Override
    public /* synthetic */ void e(r r3) {
        this.a.forEachRemaining(C.a(r3));
    }

    @Override
    public /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(y.a(consumer));
    }

    @Override
    public /* synthetic */ void forEachRemaining(Object object) {
        this.a.forEachRemaining(object);
    }

    @Override
    public /* synthetic */ Comparator getComparator() {
        return this.a.getComparator();
    }

    @Override
    public /* synthetic */ long getExactSizeIfKnown() {
        return this.a.getExactSizeIfKnown();
    }

    @Override
    public /* synthetic */ boolean hasCharacteristics(int n3) {
        return this.a.hasCharacteristics(n3);
    }

    @Override
    public /* synthetic */ boolean o(r r3) {
        return this.a.tryAdvance(C.a(r3));
    }

    @Override
    public /* synthetic */ boolean tryAdvance(Object object) {
        return this.a.tryAdvance(object);
    }

    @Override
    public /* synthetic */ Spliterator.a trySplit() {
        return j.a(this.a.trySplit());
    }

    @Override
    public /* synthetic */ Spliterator.d trySplit() {
        return p.a(this.a.trySplit());
    }

    @Override
    public /* synthetic */ Spliterator trySplit() {
        return h.a(this.a.trySplit());
    }
}

