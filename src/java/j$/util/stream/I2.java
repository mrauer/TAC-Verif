/*
 * Decompiled with CFR 0.0.
 */
package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.K;
import j$.util.stream.U2;
import j$.util.stream.j2;
import j$.util.stream.u2;
import j$.util.stream.w2;

class i2
extends w2<T, R, j2> {
    final /* synthetic */ BiConsumer b;
    final /* synthetic */ BiConsumer c;
    final /* synthetic */ K d;

    i2(U2 u22, BiConsumer biConsumer, BiConsumer biConsumer2, K k3) {
        this.b = biConsumer;
        this.c = biConsumer2;
        this.d = k3;
        super(u22);
    }

    @Override
    public u2 a() {
        return new j2(this.d, this.c, this.b);
    }
}

