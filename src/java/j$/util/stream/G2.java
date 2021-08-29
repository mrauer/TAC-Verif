/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Set
 */
package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BinaryOperator;
import j$.util.function.K;
import j$.util.stream.T2;
import j$.util.stream.U2;
import j$.util.stream.h2;
import j$.util.stream.m1;
import j$.util.stream.u2;
import j$.util.stream.w2;
import java.util.Set;

class g2
extends w2<T, I, h2> {
    final /* synthetic */ BinaryOperator b;
    final /* synthetic */ BiConsumer c;
    final /* synthetic */ K d;
    final /* synthetic */ m1 e;

    g2(U2 u22, BinaryOperator binaryOperator, BiConsumer biConsumer, K k3, m1 m12) {
        this.b = binaryOperator;
        this.c = biConsumer;
        this.d = k3;
        this.e = m12;
        super(u22);
    }

    @Override
    public u2 a() {
        return new h2(this.d, this.c, this.b);
    }

    @Override
    public int b() {
        if (this.e.characteristics().contains((Object)m1.a.UNORDERED)) {
            return T2.m;
        }
        return 0;
    }
}

