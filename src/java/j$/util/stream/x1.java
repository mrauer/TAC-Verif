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
import j$.util.stream.A2;
import j$.util.stream.Q1;
import j$.util.stream.u2;
import java.util.Objects;

class X1
implements u2<Double, Double, X1>,
A2.e {
    private double a;
    final /* synthetic */ double b;
    final /* synthetic */ q c;

    X1(double d4, q q3) {
        this.b = d4;
        this.c = q3;
    }

    @Override
    public void accept(double d4) {
        this.a = this.c.applyAsDouble(this.a, d4);
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
        return this.a;
    }

    @Override
    public void i(u2 u22) {
        this.accept(((X1)u22).a);
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
        this.a = this.b;
    }

    @Override
    public /* synthetic */ boolean p() {
        return false;
    }
}

