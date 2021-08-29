/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.d
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.PrimitiveIterator
 *  java.util.PrimitiveIterator$OfInt
 *  java.util.function.Consumer
 *  java.util.function.IntConsumer
 */
package j$;

import j$.S;
import j$.util.function.Consumer;
import j$.util.function.x;
import j$.util.s;
import java.util.PrimitiveIterator;
import java.util.function.IntConsumer;

public final class e
implements PrimitiveIterator.OfInt {
    final /* synthetic */ s.b a;

    private /* synthetic */ e(s.b b2) {
        this.a = b2;
    }

    public static /* synthetic */ PrimitiveIterator.OfInt a(s.b b2) {
        if (b2 == null) {
            return null;
        }
        if (b2 instanceof j.d) {
            return ((j.d)b2).a;
        }
        return new e(b2);
    }

    public /* synthetic */ void forEachRemaining(Object object) {
        this.a.forEachRemaining(object);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        this.a.forEachRemaining(j$.x.b(consumer));
    }

    public /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.a.c(S.b(intConsumer));
    }

    public /* synthetic */ boolean hasNext() {
        return this.a.hasNext();
    }

    public /* synthetic */ Integer next() {
        return this.a.next();
    }

    public /* synthetic */ Object next() {
        return this.a.next();
    }

    public /* synthetic */ int nextInt() {
        return this.a.nextInt();
    }

    public /* synthetic */ void remove() {
        this.a.remove();
    }
}

