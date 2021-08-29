/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.function;

import j$.util.function.D;
import java.util.Objects;

public final class j
implements D {
    public final /* synthetic */ D a;
    public final /* synthetic */ D b;

    public /* synthetic */ j(D d2, D d4) {
        this.a = d2;
        this.b = d4;
    }

    @Override
    public final void accept(long l2) {
        D d2 = this.a;
        D d4 = this.b;
        d2.accept(l2);
        d4.accept(l2);
    }

    @Override
    public D g(D d2) {
        Objects.requireNonNull((Object)d2);
        return new j(this, d2);
    }
}

