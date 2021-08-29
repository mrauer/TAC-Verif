/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.util.stream.u2
 *  java.lang.Object
 *  java.util.concurrent.CountedCompleter
 */
package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.A2;
import j$.util.stream.T1;
import j$.util.stream.k1;
import j$.util.stream.w2;
import java.util.concurrent.CountedCompleter;

final class x2<P_IN, P_OUT, R, S extends j.u2<P_OUT, R, S>>
extends k1<P_IN, P_OUT, S, x2<P_IN, P_OUT, R, S>> {
    private final w2 h;

    x2(w2 w22, T1 t12, Spliterator spliterator) {
        super(t12, spliterator);
        this.h = w22;
    }

    x2(x2 x22, Spliterator spliterator) {
        super(x22, spliterator);
        this.h = x22.h;
    }

    @Override
    protected Object a() {
        T1 t12 = this.b;
        j.u2 u22 = this.h.a();
        t12.r0((A2)u22, this.c);
        return u22;
    }

    @Override
    protected k1 f(Spliterator spliterator) {
        return new x2<P_IN, P_OUT, R, S>(this, spliterator);
    }

    @Override
    public void onCompletion(CountedCompleter countedCompleter) {
        if (!this.d()) {
            j.u2 u22 = (j.u2)((x2)this.e).b();
            u22.i((j.u2)((x2)this.f).b());
            this.g((Object)u22);
        }
        this.c = null;
        this.f = null;
        this.e = null;
    }
}

