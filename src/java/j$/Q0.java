/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.LongUnaryOperator
 */
package j$;

import j$.r0;
import j$.util.function.G;
import java.util.function.LongUnaryOperator;

public final class q0
implements G {
    final /* synthetic */ LongUnaryOperator a;

    private /* synthetic */ q0(LongUnaryOperator longUnaryOperator) {
        this.a = longUnaryOperator;
    }

    public static /* synthetic */ G c(LongUnaryOperator longUnaryOperator) {
        if (longUnaryOperator == null) {
            return null;
        }
        if (longUnaryOperator instanceof r0) {
            return ((r0)longUnaryOperator).a;
        }
        return new q0(longUnaryOperator);
    }

    @Override
    public /* synthetic */ G a(G g2) {
        return q0.c(this.a.andThen(r0.a(g2)));
    }

    @Override
    public /* synthetic */ long applyAsLong(long l2) {
        return this.a.applyAsLong(l2);
    }

    @Override
    public /* synthetic */ G b(G g2) {
        return q0.c(this.a.compose(r0.a(g2)));
    }
}

