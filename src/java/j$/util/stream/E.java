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
import j$.util.function.i;
import j$.util.function.x;
import j$.util.stream.A2;
import j$.util.stream.Q1;
import java.util.Objects;

public final class e
implements A2.f {
    public final /* synthetic */ x a;

    public /* synthetic */ e(x x2) {
        this.a = x2;
    }

    @Override
    public /* synthetic */ void accept(double d4) {
        j$.time.e.c(this);
        throw null;
    }

    @Override
    public final void accept(int n3) {
        this.a.accept(n3);
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
        return new j$.util.function.e(this, consumer);
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
    }

    @Override
    public /* synthetic */ boolean p() {
        return false;
    }
}

