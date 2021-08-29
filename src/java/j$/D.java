/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.PrimitiveIterator
 *  java.util.PrimitiveIterator$OfInt
 *  java.util.function.Consumer
 *  java.util.function.IntConsumer
 */
package j$;

import j$.T;
import j$.e;
import j$.util.function.Consumer;
import j$.util.function.x;
import j$.util.s;
import j$.y;
import java.util.PrimitiveIterator;
import java.util.function.IntConsumer;

public final class d
implements s.b {
    final /* synthetic */ PrimitiveIterator.OfInt a;

    private /* synthetic */ d(PrimitiveIterator.OfInt ofInt) {
        this.a = ofInt;
    }

    public static /* synthetic */ s.b a(PrimitiveIterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        if (ofInt instanceof e) {
            return ((e)ofInt).a;
        }
        return new d(ofInt);
    }

    @Override
    public /* synthetic */ void c(j.x x2) {
        this.a.forEachRemaining(T.a(x2));
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
    public /* synthetic */ Integer next() {
        return this.a.next();
    }

    @Override
    public /* synthetic */ Object next() {
        return this.a.next();
    }

    @Override
    public /* synthetic */ int nextInt() {
        return this.a.nextInt();
    }

    @Override
    public /* synthetic */ void remove() {
        this.a.remove();
    }
}

