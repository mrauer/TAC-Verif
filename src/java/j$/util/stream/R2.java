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
import j$.util.stream.A2;
import j$.util.stream.Q1;
import j$.util.stream.u2;
import java.util.Objects;

class r2
implements u2<Long, Long, r2>,
A2.g {
    private long a;
    final /* synthetic */ long b;
    final /* synthetic */ C c;

    r2(long l3, C c4) {
        this.b = l3;
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
        this.a = this.c.applyAsLong(this.a, l3);
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
        return this.a;
    }

    @Override
    public void i(u2 u22) {
        this.accept(((r2)u22).a);
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

