/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.e;
import j$.util.stream.Y2;
import java.util.Objects;

public final class x0
implements Consumer {
    public final /* synthetic */ Y2 a;
    public final /* synthetic */ Consumer b;

    public /* synthetic */ x0(Y2 y22, Consumer consumer) {
        this.a = y22;
        this.b = consumer;
    }

    @Override
    public final void accept(Object object) {
        this.a.g(this.b, object);
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new e(this, consumer);
    }
}

