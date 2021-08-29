/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Integer
 */
package j$.util.stream;

import j$.H;
import j$.util.stream.A2;
import j$.util.stream.U2;
import j$.util.stream.h1;
import j$.util.stream.p1;
import j$.util.stream.z1;

class q1
extends z1.k<Double> {
    final /* synthetic */ H l;

    q1(p1 p12, h1 h12, U2 u22, int n3, H h4) {
        this.l = h4;
        super(h12, u22, n3);
    }

    @Override
    A2 E0(int n3, A2 a22) {
        return new A2.a<Integer>(a22){

            @Override
            public void accept(double d4) {
                this.a.accept(q1.this.l.a(d4));
            }
        };
    }

}

