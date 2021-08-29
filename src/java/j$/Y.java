/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.Consumer
 */
package j$;

import j$.util.function.Consumer;
import j$.x;

public final class y
implements java.util.function.Consumer {
    final /* synthetic */ Consumer a;

    private /* synthetic */ y(Consumer consumer) {
        this.a = consumer;
    }

    public static /* synthetic */ java.util.function.Consumer a(Consumer consumer) {
        if (consumer == null) {
            return null;
        }
        if (consumer instanceof x) {
            return ((x)consumer).a;
        }
        return new y(consumer);
    }

    public /* synthetic */ void accept(Object object) {
        this.a.accept(object);
    }

    public /* synthetic */ java.util.function.Consumer andThen(java.util.function.Consumer consumer) {
        return y.a(this.a.f(x.b(consumer)));
    }
}

