/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Comparator
 *  java.util.Spliterator
 *  java.util.Spliterator$OfLong
 *  java.util.Spliterator$OfPrimitive
 *  java.util.function.Consumer
 *  java.util.function.LongConsumer
 */
package j$;

import j$.h;
import j$.h0;
import j$.o;
import j$.p;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.D;
import j$.y;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.LongConsumer;

public final class n
implements Spliterator.c {
    final /* synthetic */ Spliterator.OfLong a;

    private /* synthetic */ n(Spliterator.OfLong ofLong) {
        this.a = ofLong;
    }

    public static /* synthetic */ Spliterator.c a(Spliterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        if (ofLong instanceof o) {
            return ((o)ofLong).a;
        }
        return new n(ofLong);
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
    public /* synthetic */ void d(D d4) {
        this.a.forEachRemaining(h0.a(d4));
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
    public /* synthetic */ boolean j(D d4) {
        return this.a.tryAdvance(h0.a(d4));
    }

    @Override
    public /* synthetic */ boolean tryAdvance(Object object) {
        return this.a.tryAdvance(object);
    }

    @Override
    public /* synthetic */ Spliterator.c trySplit() {
        return n.a(this.a.trySplit());
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

