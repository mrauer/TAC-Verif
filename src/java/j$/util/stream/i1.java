/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.stream;

import j$.util.function.Predicate;
import j$.util.stream.M1;
import j$.util.stream.N1;

class I1
extends M1<T> {
    final /* synthetic */ N1 c;
    final /* synthetic */ Predicate d;

    I1(N1 n12, Predicate predicate) {
        this.c = n12;
        this.d = predicate;
        super(n12);
    }

    @Override
    public void accept(Object object) {
        if (!this.a && this.d.test(object) == N1.e(this.c)) {
            this.a = true;
            this.b = N1.i(this.c);
        }
    }
}

