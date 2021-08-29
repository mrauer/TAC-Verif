/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.function;

import j$.util.function.Consumer;
import java.util.Objects;

public final class e
implements Consumer {
    public final /* synthetic */ Consumer a;
    public final /* synthetic */ Consumer b;

    public /* synthetic */ e(Consumer consumer, Consumer consumer2) {
        this.a = consumer;
        this.b = consumer2;
    }

    @Override
    public final void accept(Object object) {
        Consumer consumer = this.a;
        Consumer consumer2 = this.b;
        consumer.accept(object);
        consumer2.accept(object);
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new e(this, consumer);
    }
}

