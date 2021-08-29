/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util;

import j$.util.function.Consumer;
import j$.util.function.f;
import j$.util.function.r;
import java.util.Objects;

public final class j
implements r {
    public final /* synthetic */ Consumer a;

    public /* synthetic */ j(Consumer consumer) {
        this.a = consumer;
    }

    @Override
    public final void accept(double d2) {
        this.a.accept(d2);
    }

    @Override
    public r k(r r2) {
        Objects.requireNonNull((Object)r2);
        return new f(this, r2);
    }
}

