/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util;

import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.function.j;
import java.util.Objects;

public final class g
implements D {
    public final /* synthetic */ Consumer a;

    public /* synthetic */ g(Consumer consumer) {
        this.a = consumer;
    }

    @Override
    public final void accept(long l2) {
        this.a.accept(l2);
    }

    @Override
    public D g(D d2) {
        Objects.requireNonNull((Object)d2);
        return new j(this, d2);
    }
}

