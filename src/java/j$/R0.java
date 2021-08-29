/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.LongUnaryOperator
 */
package j$;

import j$.q0;
import j$.util.function.G;
import java.util.function.LongUnaryOperator;

public final class r0
implements LongUnaryOperator {
    final /* synthetic */ G a;

    private /* synthetic */ r0(G g2) {
        this.a = g2;
    }

    public static /* synthetic */ LongUnaryOperator a(G g2) {
        if (g2 == null) {
            return null;
        }
        if (g2 instanceof q0) {
            return ((q0)g2).a;
        }
        return new r0(g2);
    }

    public /* synthetic */ LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator) {
        return r0.a(this.a.a(q0.c(longUnaryOperator)));
    }

    public /* synthetic */ long applyAsLong(long l2) {
        return this.a.applyAsLong(l2);
    }

    public /* synthetic */ LongUnaryOperator compose(LongUnaryOperator longUnaryOperator) {
        return r0.a(this.a.b(q0.c(longUnaryOperator)));
    }
}

