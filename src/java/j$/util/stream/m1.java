/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.e;
import j$.util.stream.A2;
import j$.util.stream.N1;
import java.util.Objects;

abstract class M1<T>
implements A2<T> {
    boolean a;
    boolean b;

    M1(N1 n12) {
        this.b = true ^ N1.i(n12);
    }

    @Override
    public /* synthetic */ void accept(double d2) {
        j$.time.e.c(this);
        throw null;
    }

    @Override
    public /* synthetic */ void accept(int n2) {
        j$.time.e.a(this);
        throw null;
    }

    @Override
    public /* synthetic */ void accept(long l2) {
        j$.time.e.b(this);
        throw null;
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new e(this, consumer);
    }

    @Override
    public void m() {
    }

    @Override
    public void n(long l2) {
    }

    @Override
    public boolean p() {
        return this.a;
    }
}

