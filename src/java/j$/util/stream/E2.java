/*
 * Decompiled with CFR 0.0.
 */
package j$.util.stream;

import j$.util.Optional;
import j$.util.function.BinaryOperator;
import j$.util.stream.U2;
import j$.util.stream.f2;
import j$.util.stream.u2;
import j$.util.stream.w2;

class e2
extends w2<T, Optional<T>, f2> {
    final /* synthetic */ BinaryOperator b;

    e2(U2 u22, BinaryOperator binaryOperator) {
        this.b = binaryOperator;
        super(u22);
    }

    @Override
    public u2 a() {
        return new f2(this.b);
    }
}

