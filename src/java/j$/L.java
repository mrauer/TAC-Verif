/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Comparator
 *  java.util.Spliterator
 *  java.util.Spliterator$OfInt
 *  java.util.Spliterator$OfPrimitive
 *  java.util.function.Consumer
 *  java.util.function.IntConsumer
 */
package j$;

import j$.T;
import j$.h;
import j$.m;
import j$.p;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.x;
import j$.y;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.IntConsumer;

public final class l
implements Spliterator.b {
    final /* synthetic */ Spliterator.OfInt a;

    private /* synthetic */ l(Spliterator.OfInt ofInt) {
        this.a = ofInt;
    }

    public static /* synthetic */ Spliterator.b a(Spliterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        if (ofInt instanceof m) {
            return ((m)ofInt).a;
        }
        return new l(ofInt);
    }

    @Override
    public /* synthetic */ boolean b(Consumer consumer) {
        return this.a.tryAdvance(y.a(consumer));
    }

    @Override
    public /* synthetic */ void c(x x2) {
        this.a.forEachRemaining(T.a(x2));
    }

    @Override
    public /* synthetic */ int characteristics() {
        return this.a.characteristics();
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
    public /* synthetic */ boolean h(x x2) {
        return this.a.tryAdvance(T.a(x2));
    }

    @Override
    public /* synthetic */ boolean hasCharacteristics(int n3) {
        return this.a.hasCharacteristics(n3);
    }

    @Override
    public /* synthetic */ boolean tryAdvance(Object object) {
        return this.a.tryAdvance(object);
    }

    @Override
    public /* synthetic */ Spliterator.b trySplit() {
        return l.a(this.a.trySplit());
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

