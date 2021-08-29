/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Long
 */
package j$.util.stream;

import j$.m0;
import j$.util.stream.A2;
import j$.util.stream.D1;
import j$.util.stream.U2;
import j$.util.stream.h1;
import j$.util.stream.p1;

class F1
extends p1.i<Long> {
    final /* synthetic */ m0 l;

    F1(D1 d12, h1 h12, U2 u22, int n3, m0 m02) {
        this.l = m02;
        super(h12, u22, n3);
    }

    @Override
    A2 E0(int n3, A2 a22) {
        return new A2.c<Double>(a22){

            @Override
            public void accept(long l3) {
                this.a.accept(F1.this.l.a(l3));
            }
        };
    }

}

