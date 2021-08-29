/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.K;
import j$.util.function.e;
import j$.util.stream.u2;
import j$.util.stream.v2;
import java.util.Objects;

class j2
extends v2<R>
implements u2<T, R, j2> {
    final /* synthetic */ K b;
    final /* synthetic */ BiConsumer c;
    final /* synthetic */ BiConsumer d;

    j2(K k3, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.b = k3;
        this.c = biConsumer;
        this.d = biConsumer2;
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
    public void accept(Object object) {
        this.c.accept(this.a, object);
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new e(this, consumer);
    }

    @Override
    public void i(u2 u22) {
        j2 j22 = (j2)u22;
        this.d.accept(this.a, j22.a);
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

