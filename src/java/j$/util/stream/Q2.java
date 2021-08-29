/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Long
 */
package j$.util.stream;

import j$.util.function.C;
import j$.util.stream.U2;
import j$.util.stream.r2;
import j$.util.stream.u2;
import j$.util.stream.w2;

class q2
extends w2<Long, Long, r2> {
    final /* synthetic */ j.C b;
    final /* synthetic */ long c;

    q2(U2 u22, j.C c4, long l3) {
        this.b = c4;
        this.c = l3;
        super(u22);
    }

    @Override
    public u2 a() {
        return new r2(this.c, this.b);
    }
}

