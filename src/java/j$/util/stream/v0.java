/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.function.e;
import j$.util.function.j;
import j$.util.stream.A2;
import j$.util.stream.Q1;
import java.util.Objects;

public final class V0
implements A2.g {
    public final /* synthetic */ D a;

    public /* synthetic */ V0(D d4) {
        this.a = d4;
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
    public final void accept(long l3) {
        this.a.accept(l3);
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

