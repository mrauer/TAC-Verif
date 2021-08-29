/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.b
 *  java.lang.Double
 *  java.lang.Object
 *  java.util.PrimitiveIterator
 *  java.util.PrimitiveIterator$OfDouble
 *  java.util.function.Consumer
 *  java.util.function.DoubleConsumer
 */
package j$;

import j$.B;
import j$.util.function.Consumer;
import j$.util.function.r;
import j$.util.s;
import j$.x;
import java.util.PrimitiveIterator;
import java.util.function.DoubleConsumer;

public final class c
implements PrimitiveIterator.OfDouble {
    final /* synthetic */ s.a a;

    private /* synthetic */ c(s.a a2) {
        this.a = a2;
    }

    public static /* synthetic */ PrimitiveIterator.OfDouble a(s.a a2) {
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof j.b) {
            return ((j.b)a2).a;
        }
        return new c(a2);
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

    public /* synthetic */ boolean hasNext() {
        return this.a.hasNext();
    }

    public /* synthetic */ Double next() {
        return this.a.next();
    }

    public /* synthetic */ Object next() {
        return this.a.next();
    }

    public /* synthetic */ double nextDouble() {
        return this.a.nextDouble();
    }

    public /* synthetic */ void remove() {
        this.a.remove();
    }
}

