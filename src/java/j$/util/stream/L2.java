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
import j$.util.stream.A2;
import j$.util.stream.Q1;
import j$.util.stream.u2;
import java.util.Objects;

class l2
implements u2<Integer, Integer, l2>,
A2.f {
    private int a;
    final /* synthetic */ int b;
    final /* synthetic */ w c;

    l2(int n3, w w3) {
        this.b = n3;
        this.c = w3;
    }

    @Override
    public /* synthetic */ void accept(double d4) {
        j$.time.e.c(this);
        throw null;
    }

    @Override
    public void accept(int n3) {
        this.a = this.c.applyAsInt(this.a, n3);
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
        return this.a;
    }

    @Override
    public void i(u2 u22) {
        this.accept(((l2)u22).a);
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
        this.a = this.b;
    }

    @Override
    public /* synthetic */ boolean p() {
        return false;
    }
}

