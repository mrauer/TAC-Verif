/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.util.stream.u2
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.A2;
import j$.util.stream.T1;
import j$.util.stream.U2;
import j$.util.stream.g3;
import j$.util.stream.h1;
import j$.util.stream.x2;
import java.util.Objects;

abstract class w2<T, R, S extends j.u2<T, R, S>>
implements g3<T, R> {
    private final U2 a;

    w2(U2 u22) {
        this.a = u22;
    }

    public abstract j.u2 a();

    @Override
    public /* synthetic */ int b() {
        return 0;
    }

    @Override
    public Object c(T1 t12, Spliterator spliterator) {
        return ((j.u2)new x2<P_IN, P_OUT, R, S>(this, t12, spliterator).invoke()).get();
    }

    @Override
    public Object d(T1 t12, Spliterator spliterator) {
        j.u2 u22 = this.a();
        h1 h12 = (h1)t12;
        Objects.requireNonNull((Object)u22);
        h12.k0(h12.s0((A2)u22), spliterator);
        return u22.get();
    }
}

