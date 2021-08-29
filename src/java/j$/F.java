/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.PrimitiveIterator
 *  java.util.PrimitiveIterator$OfLong
 *  java.util.function.Consumer
 *  java.util.function.LongConsumer
 */
package j$;

import j$.g;
import j$.h0;
import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.s;
import j$.y;
import java.util.PrimitiveIterator;
import java.util.function.LongConsumer;

public final class f
implements s.c {
    final /* synthetic */ PrimitiveIterator.OfLong a;

    private /* synthetic */ f(PrimitiveIterator.OfLong ofLong) {
        this.a = ofLong;
    }

    public static /* synthetic */ s.c a(PrimitiveIterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        if (ofLong instanceof g) {
            return ((g)ofLong).a;
        }
        return new f(ofLong);
    }

    @Override
    public /* synthetic */ void d(j.D d4) {
        this.a.forEachRemaining(h0.a(d4));
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
    public /* synthetic */ Long next() {
        return this.a.next();
    }

    @Override
    public /* synthetic */ Object next() {
        return this.a.next();
    }

    @Override
    public /* synthetic */ long nextLong() {
        return this.a.nextLong();
    }

    @Override
    public /* synthetic */ void remove() {
        this.a.remove();
    }
}

