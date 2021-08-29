/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package j$.util.stream;

import j$.util.function.BinaryOperator;
import j$.util.function.H;
import j$.util.function.K;
import j$.util.stream.U2;
import j$.util.stream.b2;
import j$.util.stream.u2;
import j$.util.stream.w2;

class a2
extends w2<Double, R, b2> {
    final /* synthetic */ BinaryOperator b;
    final /* synthetic */ H c;
    final /* synthetic */ K d;

    a2(U2 u22, BinaryOperator binaryOperator, H h4, K k3) {
        this.b = binaryOperator;
        this.c = h4;
        this.d = k3;
        super(u22);
    }

    @Override
    public u2 a() {
        return new b2(this.d, this.c, this.b);
    }
}

