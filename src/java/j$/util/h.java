/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util;

import j$.util.function.Consumer;
import j$.util.function.i;
import j$.util.function.x;
import java.util.Objects;

public final class h
implements x {
    public final /* synthetic */ Consumer a;

    public /* synthetic */ h(Consumer consumer) {
        this.a = consumer;
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

