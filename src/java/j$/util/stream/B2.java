/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.H;
import j$.util.function.K;
import j$.util.function.e;
import j$.util.function.f;
import j$.util.function.r;
import j$.util.stream.A2;
import j$.util.stream.Q1;
import j$.util.stream.u2;
import j$.util.stream.v2;
import java.util.Objects;

class b2
extends v2<R>
implements u2<Double, R, b2>,
A2.e {
    final /* synthetic */ K b;
    final /* synthetic */ H c;
    final /* synthetic */ BinaryOperator d;

    b2(K k3, H h4, BinaryOperator binaryOperator) {
        this.b = k3;
        this.c = h4;
        this.d = binaryOperator;
    }

    @Override
    public void accept(double d4) {
        this.c.accept(this.a, d4);
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
    public void i(u2 u22) {
        b2 b22 = (b2)u22;
        this.a = this.d.apply(this.a, b22.a);
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
        this.a = this.b.get();
    }

    @Override
    public /* synthetic */ boolean p() {
        return false;
    }
}

