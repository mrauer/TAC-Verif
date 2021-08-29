/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.IntUnaryOperator
 */
package j$;

import j$.c0;
import j$.util.function.B;
import java.util.function.IntUnaryOperator;

public final class d0
implements IntUnaryOperator {
    final /* synthetic */ B a;

    private /* synthetic */ d0(B b2) {
        this.a = b2;
    }

    public static /* synthetic */ IntUnaryOperator a(B b2) {
        if (b2 == null) {
            return null;
        }
        if (b2 instanceof c0) {
            return ((c0)b2).a;
        }
        return new d0(b2);
    }

    public /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
        B b2 = this.a;
        B b3 = c0.b(intUnaryOperator);
        return d0.a(c0.b(((c0)b2).a.andThen(d0.a(b3))));
    }

    public /* synthetic */ int applyAsInt(int n2) {
        return ((c0)this.a).a.applyAsInt(n2);
    }

    public /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
        B b2 = this.a;
        B b3 = c0.b(intUnaryOperator);
        return d0.a(c0.b(((c0)b2).a.compose(d0.a(b3))));
    }
}

