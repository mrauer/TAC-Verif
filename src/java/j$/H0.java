/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.LongConsumer
 */
package j$;

import j$.g0;
import j$.util.function.D;
import java.util.function.LongConsumer;

public final class h0
implements LongConsumer {
    final /* synthetic */ D a;

    private /* synthetic */ h0(D d2) {
        this.a = d2;
    }

    public static /* synthetic */ LongConsumer a(D d2) {
        if (d2 == null) {
            return null;
        }
        if (d2 instanceof g0) {
            return ((g0)d2).a;
        }
        return new h0(d2);
    }

    public /* synthetic */ void accept(long l2) {
        this.a.accept(l2);
    }

    public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return h0.a(this.a.g(g0.b(longConsumer)));
    }
}

