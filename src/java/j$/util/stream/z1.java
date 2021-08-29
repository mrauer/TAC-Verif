/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.e;
import j$.util.function.f;
import j$.util.function.q;
import j$.util.function.r;
import j$.util.o;
import j$.util.stream.A2;
import j$.util.stream.Q1;
import j$.util.stream.u2;
import java.util.Objects;

class Z1
implements u2<Double, o, Z1>,
A2.e {
    private boolean a;
    private double b;
    final /* synthetic */ q c;

    Z1(q q3) {
        this.c = q3;
    }

    @Override
    public void accept(double d4) {
        if (this.a) {
            this.a = false;
        } else {
            d4 = this.c.applyAsDouble(this.b, d4);
        }
        this.b = d4;
    }

    @Override
    public /* synthetic */ void accept(int n3) {
        j$.time.e.a(this);
        throw null;
    }

    @Override
    public /* synthetic */ void accept(long l3) {
        j$.time.e.b(this);
        throw null;
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.b((Double)object);
    }

    public /* synthetic */ void b(Double d4) {
        Q1.a(this, d4);
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new e(this, consumer);
    }

    @Override
    public Object get() {
        if (this.a) {
            return o.a();
        }
        return o.d(this.b);
    }

    @Override
    public void i(u2 u22) {
        Z1 z12 = (Z1)u22;
        if (!z12.a) {
            this.accept(z12.b);
        }
    }

    @Override
    public r k(r r3) {
        Objects.requireNonNull((Object)r3);
        return new f(this, r3);
    }

    @Override
    public void m() {
    }

    @Override
    public void n(long l3) {
        this.a = true;
        this.b = 0.0;
    }

    @Override
    public /* synthetic */ boolean p() {
        return false;
    }
}

