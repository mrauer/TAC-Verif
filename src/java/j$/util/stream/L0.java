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
import j$.util.function.r;
import j$.util.stream.A2;
import j$.util.stream.Q1;
import java.util.Objects;

public final class l0
implements A2.e {
    public final /* synthetic */ r a;

    public /* synthetic */ l0(r r3) {
        this.a = r3;
    }

    @Override
    public final void accept(double d4) {
        this.a.accept(d4);
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
    public r k(r r3) {
        Objects.requireNonNull((Object)r3);
        return new f(this, r3);
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

