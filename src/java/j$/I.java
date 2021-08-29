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

import j$.h;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.x;
import java.util.Comparator;

public final class i
implements java.util.Spliterator {
    final /* synthetic */ Spliterator a;

    private /* synthetic */ i(Spliterator spliterator) {
        this.a = spliterator;
    }

    public static /* synthetic */ java.util.Spliterator a(Spliterator spliterator) {
        if (spliterator == null) {
            return null;
        }
        if (spliterator instanceof h) {
            return ((h)spliterator).a;
        }
        return new i(spliterator);
    }

    public /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    public /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        this.a.forEachRemaining(x.b(consumer));
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

    public /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
        return this.a.b(x.b(consumer));
    }

    public /* synthetic */ java.util.Spliterator trySplit() {
        return i.a(this.a.trySplit());
    }
}

