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
import j$.util.stream.S2;
import java.util.Objects;

public final class g
implements A2 {
    public final /* synthetic */ S2 a;

    public /* synthetic */ g(S2 s22) {
        this.a = s22;
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
    public /* synthetic */ void accept(long l3) {
        j$.time.e.b(this);
        throw null;
    }

    @Override
    public final void accept(Object object) {
        this.a.accept(object);
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
    public void n(long l3) {
    }

    @Override
    public /* synthetic */ boolean p() {
        return false;
    }
}

