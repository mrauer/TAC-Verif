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

import j$.i;
import j$.p;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.x;
import java.util.Comparator;
import java.util.Spliterator;

public final class q
implements Spliterator.OfPrimitive {
    final /* synthetic */ Spliterator.d a;

    private /* synthetic */ q(Spliterator.d d2) {
        this.a = d2;
    }

    public static /* synthetic */ Spliterator.OfPrimitive a(Spliterator.d d2) {
        if (d2 == null) {
            return null;
        }
        if (d2 instanceof p) {
            return ((p)d2).a;
        }
        return new q(d2);
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

    public /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return q.a(this.a.trySplit());
    }

    public /* synthetic */ java.util.Spliterator trySplit() {
        return i.a(this.a.trySplit());
    }
}

