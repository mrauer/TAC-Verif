/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.CountedCompleter
 */
package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.K;
import j$.util.function.Predicate;
import j$.util.stream.A2;
import j$.util.stream.T1;
import j$.util.stream.h3;
import j$.util.stream.i1;
import j$.util.stream.k1;
import j$.util.stream.t1;
import java.util.concurrent.CountedCompleter;

final class v1<P_IN, P_OUT, O>
extends i1<P_IN, P_OUT, O, v1<P_IN, P_OUT, O>> {
    private final t1 j;

    v1(t1 t12, T1 t13, Spliterator spliterator) {
        super(t13, spliterator);
        this.j = t12;
    }

    v1(v1 v12, Spliterator spliterator) {
        super(v12, spliterator);
        this.j = v12.j;
    }

    private void m(Object object) {
        boolean bl;
        block3 : {
            k1 k12 = this;
            while (k12 != null) {
                k1 k13 = k12.c();
                if (k13 != null && k13.e != k12) {
                    bl = false;
                    break block3;
                }
                k12 = k13;
            }
            bl = true;
        }
        if (bl) {
            this.l(object);
            return;
        }
        this.j();
    }

    @Override
    protected Object a() {
        T1 t12 = this.b;
        h3 h32 = (h3)this.j.e.get();
        t12.r0(h32, this.c);
        Object object = h32.get();
        if (!this.j.b) {
            if (object != null) {
                this.l(object);
            }
            return null;
        }
        if (object != null) {
            this.m(object);
            return object;
        }
        return null;
    }

    @Override
    protected k1 f(Spliterator spliterator) {
        return new v1<P_IN, P_OUT, O>(this, spliterator);
    }

    @Override
    protected Object k() {
        return this.j.c;
    }

    @Override
    public void onCompletion(CountedCompleter countedCompleter) {
        if (this.j.b) {
            v1 v12 = (v1)this.e;
            v1 v13 = null;
            while (v12 != v13) {
                Object object = v12.b();
                if (object != null && this.j.d.test(object)) {
                    this.g(object);
                    this.m(object);
                    break;
                }
                v1 v14 = (v1)this.f;
                v13 = v12;
                v12 = v14;
            }
        }
        this.c = null;
        this.f = null;
        this.e = null;
    }
}

