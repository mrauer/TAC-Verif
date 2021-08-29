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
import j$.util.stream.A2;
import java.util.Objects;

public final class c
implements x {
    public final /* synthetic */ A2 a;

    public /* synthetic */ c(A2 a2) {
        this.a = a2;
    }

    @Override
    public final void accept(int n2) {
        this.a.accept(n2);
    }

    @Override
    public x l(x x3) {
        Objects.requireNonNull((Object)x3);
        return new i(this, x3);
    }
}

