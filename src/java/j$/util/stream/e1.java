/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 */
package j$.util.stream;

import j$.o0;
import j$.util.stream.A2;
import j$.util.stream.D1;
import j$.util.stream.U2;
import j$.util.stream.h1;
import j$.util.stream.z1;

class E1
extends z1.k<Long> {
    final /* synthetic */ o0 l;

    E1(D1 d12, h1 h12, U2 u22, int n3, o0 o02) {
        this.l = o02;
        super(h12, u22, n3);
    }

    @Override
    A2 E0(int n3, A2 a22) {
        return new A2.c<Integer>(a22){

            @Override
            public void accept(long l3) {
                this.a.accept(E1.this.l.a(l3));
            }
        };
    }

}

