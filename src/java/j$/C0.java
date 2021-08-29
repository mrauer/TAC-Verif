/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.IntUnaryOperator
 */
package j$;

import j$.d0;
import j$.util.function.B;
import java.util.function.IntUnaryOperator;

public final class c0
implements B {
    final /* synthetic */ IntUnaryOperator a;

    private /* synthetic */ c0(IntUnaryOperator intUnaryOperator) {
        this.a = intUnaryOperator;
    }

    public static /* synthetic */ B b(IntUnaryOperator intUnaryOperator) {
        if (intUnaryOperator == null) {
            return null;
        }
        if (intUnaryOperator instanceof d0) {
            return ((d0)intUnaryOperator).a;
        }
        return new c0(intUnaryOperator);
    }

    public /* synthetic */ int a(int n2) {
        return this.a.applyAsInt(n2);
    }
}

