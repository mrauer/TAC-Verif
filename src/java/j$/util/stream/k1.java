/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.k0;
import j$.util.function.D;
import j$.util.function.F;
import j$.util.function.j;
import j$.util.stream.A2;
import j$.util.stream.M1;
import j$.util.stream.N1;
import j$.util.stream.Q1;
import java.util.Objects;

class K1
extends M1<Long>
implements A2.g {
    final /* synthetic */ N1 c;
    final /* synthetic */ F d;

    K1(N1 n12, F f3) {
        this.c = n12;
        this.d = f3;
        super(n12);
    }

    @Override
    public void accept(long l3) {
        if (!this.a && ((k0)this.d).b(l3) == N1.e(this.c)) {
            this.a = true;
            this.b = N1.i(this.c);
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.b((Long)object);
    }

    public /* synthetic */ void b(Long l3) {
        Q1.c(this, l3);
    }

    @Override
    public D g(D d4) {
        Objects.requireNonNull((Object)d4);
        return new j(this, d4);
    }
}

