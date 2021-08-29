/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.Consumer
 */
package j$;

import j$.util.function.Consumer;
import j$.y;

public final class x
implements Consumer {
    final /* synthetic */ java.util.function.Consumer a;

    private /* synthetic */ x(java.util.function.Consumer consumer) {
        this.a = consumer;
    }

    public static /* synthetic */ Consumer b(java.util.function.Consumer consumer) {
        if (consumer == null) {
            return null;
        }
        if (consumer instanceof y) {
            return ((y)consumer).a;
        }
        return new x(consumer);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.a.accept(object);
    }

    @Override
    public /* synthetic */ Consumer f(Consumer consumer) {
        return x.b(this.a.andThen(y.a(consumer)));
    }
}

