/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Double
 *  java.lang.Object
 *  java.util.PrimitiveIterator
 *  java.util.PrimitiveIterator$OfDouble
 *  java.util.function.Consumer
 *  java.util.function.DoubleConsumer
 */
package j$;

import j$.C;
import j$.c;
import j$.util.function.Consumer;
import j$.util.function.r;
import j$.util.s;
import j$.y;
import java.util.PrimitiveIterator;
import java.util.function.DoubleConsumer;

public final class b
implements s.a {
    final /* synthetic */ PrimitiveIterator.OfDouble a;

    private /* synthetic */ b(PrimitiveIterator.OfDouble ofDouble) {
        this.a = ofDouble;
    }

    public static /* synthetic */ s.a a(PrimitiveIterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        if (ofDouble instanceof c) {
            return ((c)ofDouble).a;
        }
        return new b(ofDouble);
    }

    @Override
    public /* synthetic */ void e(j.r r3) {
        this.a.forEachRemaining(C.a(r3));
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
    public /* synthetic */ boolean hasNext() {
        return this.a.hasNext();
    }

    @Override
    public /* synthetic */ Double next() {
        return this.a.next();
    }

    @Override
    public /* synthetic */ Object next() {
        return this.a.next();
    }

    @Override
    public /* synthetic */ double nextDouble() {
        return this.a.nextDouble();
    }

    @Override
    public /* synthetic */ void remove() {
        this.a.remove();
    }
}

