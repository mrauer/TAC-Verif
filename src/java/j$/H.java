/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Comparator
 *  java.util.Spliterator
 *  java.util.function.Consumer
 */
package j$;

import j$.i;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.y;
import java.util.Comparator;

public final class h
implements Spliterator {
    final /* synthetic */ java.util.Spliterator a;

    private /* synthetic */ h(java.util.Spliterator spliterator) {
        this.a = spliterator;
    }

    public static /* synthetic */ Spliterator a(java.util.Spliterator spliterator) {
        if (spliterator == null) {
            return null;
        }
        if (spliterator instanceof i) {
            return ((i)spliterator).a;
        }
        return new h(spliterator);
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
    public /* synthetic */ Spliterator trySplit() {
        return h.a(this.a.trySplit());
    }
}

