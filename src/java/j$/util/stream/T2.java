/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.C;
import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.function.e;
import j$.util.function.j;
import j$.util.q;
import j$.util.stream.A2;
import j$.util.stream.Q1;
import j$.util.stream.u2;
import java.util.Objects;

class t2
implements u2<Long, q, t2>,
A2.g {
    private boolean a;
    private long b;
    final /* synthetic */ C c;

    t2(C c4) {
        this.c = c4;
    }

    @Override
    public /* synthetic */ void accept(double d4) {
        j$.time.e.c(this);
        throw null;
    }

    @Override
    public /* synthetic */ void accept(int n3) {
        j$.time.e.a(this);
        throw null;
    }

    @Override
    public void accept(long l3) {
        if (this.a) {
            this.a = false;
        } else {
            l3 = this.c.applyAsLong(this.b, l3);
        }
        this.b = l3;
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.b((Long)object);
    }

    public /* synthetic */ void b(Long l3) {
        Q1.c(this, l3);
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new e(this, consumer);
    }

    @Override
    public D g(D d4) {
        Objects.requireNonNull((Object)d4);
        return new j(this, d4);
    }

    @Override
    public Object get() {
        if (this.a) {
            return q.a();
        }
        return q.d(this.b);
    }

    @Override
    public void i(u2 u22) {
        t2 t22 = (t2)u22;
        if (!t22.a) {
            this.accept(t22.b);
        }
    }

    @Override
    public void m() {
    }

    @Override
    public void n(long l3) {
        this.a = true;
        this.b = 0L;
    }

    @Override
    public /* synthetic */ boolean p() {
        return false;
    }
}

