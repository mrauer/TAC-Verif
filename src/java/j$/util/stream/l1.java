/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.F;
import j$.util.function.f;
import j$.util.function.r;
import j$.util.function.t;
import j$.util.stream.A2;
import j$.util.stream.M1;
import j$.util.stream.N1;
import j$.util.stream.Q1;
import java.util.Objects;

class L1
extends M1<Double>
implements A2.e {
    final /* synthetic */ N1 c;
    final /* synthetic */ t d;

    L1(N1 n12, t t3) {
        this.c = n12;
        this.d = t3;
        super(n12);
    }

    @Override
    public void accept(double d4) {
        if (!this.a && ((F)this.d).b(d4) == N1.e(this.c)) {
            this.a = true;
            this.b = N1.i(this.c);
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.b((Double)object);
    }

    public /* synthetic */ void b(Double d4) {
        Q1.a(this, d4);
    }

    @Override
    public r k(r r3) {
        Objects.requireNonNull((Object)r3);
        return new f(this, r3);
    }
}

