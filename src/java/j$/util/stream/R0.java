/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.e;
import java.util.Objects;

public final class r0
implements Consumer {
    public final /* synthetic */ BiConsumer a;
    public final /* synthetic */ Object b;

    public /* synthetic */ r0(BiConsumer biConsumer, Object object) {
        this.a = biConsumer;
        this.b = object;
    }

    @Override
    public final void accept(Object object) {
        this.a.accept(this.b, object);
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new e(this, consumer);
    }
}

