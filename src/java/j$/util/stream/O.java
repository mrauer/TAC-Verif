/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.util.stream.A2$a
 *  j$.util.stream.p1
 *  j$.util.stream.p1$d
 *  j$.util.stream.p1$d$a
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.f;
import j$.util.function.r;
import j$.util.stream.A2;
import java.util.Objects;

public final class o
implements r {
    public final /* synthetic */ j.p1.d.a a;

    public /* synthetic */ o(j.p1.d.a a2) {
        this.a = a2;
    }

    @Override
    public final void accept(double d2) {
        this.a.a.accept(d2);
    }

    @Override
    public r k(r r2) {
        Objects.requireNonNull((Object)r2);
        return new f(this, r2);
    }
}

