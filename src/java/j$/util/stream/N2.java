/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.e;
import j$.util.function.i;
import j$.util.function.w;
import j$.util.function.x;
import j$.util.p;
import j$.util.stream.A2;
import j$.util.stream.Q1;
import j$.util.stream.u2;
import java.util.Objects;

class n2
implements u2<Integer, p, n2>,
A2.f {
    private boolean a;
    private int b;
    final /* synthetic */ w c;

    n2(w w3) {
        this.c = w3;
    }

    @Override
    public /* synthetic */ void accept(double d4) {
        j$.time.e.c(this);
        throw null;
    }

    @Override
    public void accept(int n3) {
        if (this.a) {
            this.a = false;
        } else {
            n3 = this.c.applyAsInt(this.b, n3);
        }
        this.b = n3;
    }

    @Override
    public /* synthetic */ void accept(long l3) {
        j$.time.e.b(this);
        throw null;
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.b((Integer)object);
    }

    public /* synthetic */ void b(Integer n3) {
        Q1.b(this, n3);
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new e(this, consumer);
    }

    @Override
    public Object get() {
        if (this.a) {
            return p.a();
        }
        return p.d(this.b);
    }

    @Override
    public void i(u2 u22) {
        n2 n22 = (n2)u22;
        if (!n22.a) {
            this.accept(n22.b);
        }
    }

    @Override
    public x l(x x2) {
        Objects.requireNonNull((Object)x2);
        return new i(this, x2);
    }

    @Override
    public void m() {
    }

    @Override
    public void n(long l3) {
        this.a = true;
        this.b = 0;
    }

    @Override
    public /* synthetic */ boolean p() {
        return false;
    }
}

