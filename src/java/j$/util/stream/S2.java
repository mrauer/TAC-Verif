/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Long
 */
package j$.util.stream;

import j$.util.function.C;
import j$.util.q;
import j$.util.stream.U2;
import j$.util.stream.t2;
import j$.util.stream.u2;
import j$.util.stream.w2;

class s2
extends w2<Long, j.q, t2> {
    final /* synthetic */ C b;

    s2(U2 u22, C c4) {
        this.b = c4;
        super(u22);
    }

    @Override
    public u2 a() {
        return new t2(this.b);
    }
}

