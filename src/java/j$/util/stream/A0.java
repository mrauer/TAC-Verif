/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.util.stream.L1
 *  java.lang.Object
 */
package j$.util.stream;

import j$.util.function.K;
import j$.util.function.t;
import j$.util.stream.N1;

public final class a0
implements K {
    public final /* synthetic */ N1 a;
    public final /* synthetic */ t b;

    public /* synthetic */ a0(N1 n12, t t2) {
        this.a = n12;
        this.b = t2;
    }

    @Override
    public final Object get() {
        return new j.L1(this.a, this.b);
    }
}

