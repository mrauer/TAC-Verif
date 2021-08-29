/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Double
 *  java.lang.Integer
 */
package j$.util.stream;

import j$.Y;
import j$.util.stream.A2;
import j$.util.stream.U2;
import j$.util.stream.h1;
import j$.util.stream.p1;
import j$.util.stream.z1;

class A1
extends p1.i<Integer> {
    final /* synthetic */ Y l;

    A1(j.z1 z12, h1 h12, U2 u22, int n3, Y y3) {
        this.l = y3;
        super(h12, u22, n3);
    }

    @Override
    A2 E0(int n3, A2 a22) {
        return new A2.b<Double>(a22){

            @Override
            public void accept(int n3) {
                this.a.accept(A1.this.l.a(n3));
            }
        };
    }

}

