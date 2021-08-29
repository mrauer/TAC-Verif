/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.function;

import j$.util.function.r;
import java.util.Objects;

public final class f
implements r {
    public final /* synthetic */ r a;
    public final /* synthetic */ r b;

    public /* synthetic */ f(r r2, r r3) {
        this.a = r2;
        this.b = r3;
    }

    @Override
    public final void accept(double d2) {
        r r2 = this.a;
        r r3 = this.b;
        r2.accept(d2);
        r3.accept(d2);
    }

    @Override
    public r k(r r2) {
        Objects.requireNonNull((Object)r2);
        return new f(this, r2);
    }
}

