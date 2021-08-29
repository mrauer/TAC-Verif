/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.D;
import j$.util.function.j;
import java.util.Objects;

public final class i0
implements D {
    public static final /* synthetic */ i0 a;

    static /* synthetic */ {
        a = new i0();
    }

    private /* synthetic */ i0() {
    }

    @Override
    public final void accept(long l2) {
    }

    @Override
    public D g(D d2) {
        Objects.requireNonNull((Object)d2);
        return new j(this, d2);
    }
}

