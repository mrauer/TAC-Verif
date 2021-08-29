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
import j$.util.stream.A2;
import java.util.Objects;

public final class b
implements Consumer {
    public final /* synthetic */ A2 a;

    public /* synthetic */ b(A2 a2) {
        this.a = a2;
    }

    @Override
    public final void accept(Object object) {
        this.a.accept(object);
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new e(this, consumer);
    }
}

