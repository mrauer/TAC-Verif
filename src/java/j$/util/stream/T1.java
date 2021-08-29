/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.util.stream.h3
 *  j$.util.stream.v1
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.K;
import j$.util.function.Predicate;
import j$.util.stream.A2;
import j$.util.stream.T1;
import j$.util.stream.T2;
import j$.util.stream.U2;
import j$.util.stream.g3;
import j$.util.stream.h1;
import java.util.Objects;

final class t1<T, O>
implements g3<T, O> {
    private final U2 a;
    final boolean b;
    final Object c;
    final Predicate d;
    final K e;

    t1(boolean bl, U2 u2, Object object, Predicate predicate, K k2) {
        this.b = bl;
        this.a = u2;
        this.c = object;
        this.d = predicate;
        this.e = k2;
    }

    @Override
    public int b() {
        int n2 = T2.p;
        int n3 = this.b ? 0 : T2.m;
        return n2 | n3;
    }

    @Override
    public Object c(T1 t12, Spliterator spliterator) {
        return new j.v1(this, t12, spliterator).invoke();
    }

    @Override
    public Object d(T1 t12, Spliterator spliterator) {
        j.h3 h32 = (j.h3)this.e.get();
        h1 h12 = (h1)t12;
        Objects.requireNonNull((Object)h32);
        h12.k0(h12.s0((A2)h32), spliterator);
        Object object = h32.get();
        if (object != null) {
            return object;
        }
        return this.c;
    }
}

