/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.i;
import j$.util.function.x;
import java.util.Objects;

public final class h0
implements x {
    public static final /* synthetic */ h0 a;

    static /* synthetic */ {
        a = new h0();
    }

    private /* synthetic */ h0() {
    }

    @Override
    public final void accept(int n2) {
    }

    @Override
    public x l(x x3) {
        Objects.requireNonNull((Object)x3);
        return new i(this, x3);
    }
}

