/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package j$.util.stream;

import j$.util.function.q;
import j$.util.o;
import j$.util.stream.U2;
import j$.util.stream.Z1;
import j$.util.stream.u2;
import j$.util.stream.w2;

class Y1
extends w2<Double, o, Z1> {
    final /* synthetic */ q b;

    Y1(U2 u22, q q3) {
        this.b = q3;
        super(u22);
    }

    @Override
    public u2 a() {
        return new Z1(this.b);
    }
}

