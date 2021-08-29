/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 */
package j$.util.stream;

import j$.util.function.BinaryOperator;
import j$.util.function.I;
import j$.util.function.K;
import j$.util.stream.U2;
import j$.util.stream.p2;
import j$.util.stream.u2;
import j$.util.stream.w2;

class o2
extends w2<Integer, R, p2> {
    final /* synthetic */ BinaryOperator b;
    final /* synthetic */ I c;
    final /* synthetic */ K d;

    o2(U2 u22, BinaryOperator binaryOperator, I i4, K k3) {
        this.b = binaryOperator;
        this.c = i4;
        this.d = k3;
        super(u22);
    }

    @Override
    public u2 a() {
        return new p2(this.d, this.c, this.b);
    }
}

