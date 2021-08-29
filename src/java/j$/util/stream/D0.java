/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.util.stream.K1
 *  java.lang.Object
 */
package j$.util.stream;

import j$.util.function.F;
import j$.util.function.K;
import j$.util.stream.N1;

public final class d0
implements K {
    public final /* synthetic */ N1 a;
    public final /* synthetic */ F b;

    public /* synthetic */ d0(N1 n12, F f2) {
        this.a = n12;
        this.b = f2;
    }

    @Override
    public final Object get() {
        return new j.K1(this.a, this.b);
    }
}

