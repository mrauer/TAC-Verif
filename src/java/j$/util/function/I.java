/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.function;

import j$.util.function.x;
import java.util.Objects;

public final class i
implements x {
    public final /* synthetic */ x a;
    public final /* synthetic */ x b;

    public /* synthetic */ i(x x3, x x4) {
        this.a = x3;
        this.b = x4;
    }

    @Override
    public final void accept(int n2) {
        x x3 = this.a;
        x x4 = this.b;
        x3.accept(n2);
        x4.accept(n2);
    }

    @Override
    public x l(x x3) {
        Objects.requireNonNull((Object)x3);
        return new i(this, x3);
    }
}

