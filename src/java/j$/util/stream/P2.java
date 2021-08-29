/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.I;
import j$.util.function.K;
import j$.util.function.e;
import j$.util.function.i;
import j$.util.function.x;
import j$.util.stream.A2;
import j$.util.stream.Q1;
import j$.util.stream.u2;
import j$.util.stream.v2;
import java.util.Objects;

class p2
extends v2<R>
implements u2<Integer, R, p2>,
A2.f {
    final /* synthetic */ K b;
    final /* synthetic */ I c;
    final /* synthetic */ BinaryOperator d;

    p2(K k3, I i4, BinaryOperator binaryOperator) {
        this.b = k3;
        this.c = i4;
        this.d = binaryOperator;
    }

    @Override
    public /* synthetic */ void accept(double d4) {
        j$.time.e.c(this);
        throw null;
    }

    @Override
    public void accept(int n3) {
        this.c.accept(this.a, n3);
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
    public void i(u2 u22) {
        p2 p22 = (p2)u22;
        this.a = this.d.apply(this.a, p22.a);
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
        this.a = this.b.get();
    }

    @Override
    public /* synthetic */ boolean p() {
        return false;
    }
}

