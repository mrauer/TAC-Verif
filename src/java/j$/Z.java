/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.DoubleBinaryOperator
 */
package j$;

import j$.A;
import j$.util.function.q;
import java.util.function.DoubleBinaryOperator;

public final class z
implements q {
    final /* synthetic */ DoubleBinaryOperator a;

    private /* synthetic */ z(DoubleBinaryOperator doubleBinaryOperator) {
        this.a = doubleBinaryOperator;
    }

    public static /* synthetic */ q a(DoubleBinaryOperator doubleBinaryOperator) {
        if (doubleBinaryOperator == null) {
            return null;
        }
        if (doubleBinaryOperator instanceof A) {
            return ((A)doubleBinaryOperator).a;
        }
        return new z(doubleBinaryOperator);
    }

    @Override
    public /* synthetic */ double applyAsDouble(double d2, double d4) {
        return this.a.applyAsDouble(d2, d4);
    }
}

