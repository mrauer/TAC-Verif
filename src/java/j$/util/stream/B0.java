/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.util.stream.I1
 *  java.lang.Object
 */
package j$.util.stream;

import j$.util.function.K;
import j$.util.function.Predicate;
import j$.util.stream.N1;

public final class b0
implements K {
    public final /* synthetic */ N1 a;
    public final /* synthetic */ Predicate b;

    public /* synthetic */ b0(N1 n12, Predicate predicate) {
        this.a = n12;
        this.b = predicate;
    }

    @Override
    public final Object get() {
        return new j.I1(this.a, this.b);
    }
}

