/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.stream.U2;
import j$.util.stream.d2;
import j$.util.stream.u2;
import j$.util.stream.w2;

class c2
extends w2<T, U, d2> {
    final /* synthetic */ BinaryOperator b;
    final /* synthetic */ BiFunction c;
    final /* synthetic */ Object d;

    c2(U2 u22, BinaryOperator binaryOperator, BiFunction biFunction, Object object) {
        this.b = binaryOperator;
        this.c = biFunction;
        this.d = object;
        super(u22);
    }

    @Override
    public u2 a() {
        return new d2(this.d, this.c, this.b);
    }
}

