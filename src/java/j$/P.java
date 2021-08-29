/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Comparator
 *  java.util.Spliterator
 *  java.util.Spliterator$OfPrimitive
 *  java.util.function.Consumer
 */
package j$;

import j$.h;
import j$.q;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.y;
import java.util.Comparator;
import java.util.Spliterator;

public final class p
implements Spliterator.d {
    final /* synthetic */ Spliterator.OfPrimitive a;

    private /* synthetic */ p(Spliterator.OfPrimitive ofPrimitive) {
        this.a = ofPrimitive;
    }

    public static /* synthetic */ Spliterator.d a(Spliterator.OfPrimitive ofPrimitive) {
        if (ofPrimitive == null) {
            return null;
        }
        if (ofPrimitive instanceof q) {
            return ((q)ofPrimitive).a;
        }
        return new p(ofPrimitive);
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
    public /* synthetic */ boolean hasCharacteristics(int n2) {
        return this.a.hasCharacteristics(n2);
    }

    @Override
    public /* synthetic */ boolean tryAdvance(Object object) {
        return this.a.tryAdvance(object);
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

