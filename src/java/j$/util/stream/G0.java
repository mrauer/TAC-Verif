/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.f;
import j$.util.function.r;
import java.util.Objects;

public final class g0
implements r {
    public static final /* synthetic */ g0 a;

    static /* synthetic */ {
        a = new g0();
    }

    private /* synthetic */ g0() {
    }

    @Override
    public final void accept(double d2) {
    }

    @Override
    public r k(r r2) {
        Objects.requireNonNull((Object)r2);
        return new f(this, r2);
    }
}

