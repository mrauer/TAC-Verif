/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 */
package j$.util.stream;

import j$.util.function.w;
import j$.util.stream.U2;
import j$.util.stream.l2;
import j$.util.stream.u2;
import j$.util.stream.w2;

class k2
extends w2<Integer, Integer, l2> {
    final /* synthetic */ w b;
    final /* synthetic */ int c;

    k2(U2 u22, w w3, int n3) {
        this.b = w3;
        this.c = n3;
        super(u22);
    }

    @Override
    public u2 a() {
        return new l2(this.c, this.b);
    }
}

