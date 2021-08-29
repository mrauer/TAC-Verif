/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.W;
import j$.util.function.i;
import j$.util.function.x;
import j$.util.function.z;
import j$.util.stream.A2;
import j$.util.stream.M1;
import j$.util.stream.N1;
import j$.util.stream.Q1;
import java.util.Objects;

class J1
extends M1<Integer>
implements A2.f {
    final /* synthetic */ N1 c;
    final /* synthetic */ z d;

    J1(N1 n12, z z3) {
        this.c = n12;
        this.d = z3;
        super(n12);
    }

    @Override
    public void accept(int n3) {
        if (!this.a && ((W)this.d).b(n3) == N1.e(this.c)) {
            this.a = true;
            this.b = N1.i(this.c);
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.b((Integer)object);
    }

    public /* synthetic */ void b(Integer n3) {
        Q1.b(this, n3);
    }

    @Override
    public x l(x x2) {
        Objects.requireNonNull((Object)x2);
        return new i(this, x2);
    }
}

