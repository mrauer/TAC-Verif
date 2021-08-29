/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.LongConsumer
 */
package j$;

import j$.h0;
import j$.util.function.D;
import java.util.function.LongConsumer;

public final class g0
implements D {
    final /* synthetic */ LongConsumer a;

    private /* synthetic */ g0(LongConsumer longConsumer) {
        this.a = longConsumer;
    }

    public static /* synthetic */ D b(LongConsumer longConsumer) {
        if (longConsumer == null) {
            return null;
        }
        if (longConsumer instanceof h0) {
            return ((h0)longConsumer).a;
        }
        return new g0(longConsumer);
    }

    @Override
    public /* synthetic */ void accept(long l2) {
        this.a.accept(l2);
    }

    @Override
    public /* synthetic */ D g(D d2) {
        return g0.b(this.a.andThen(h0.a(d2)));
    }
}

