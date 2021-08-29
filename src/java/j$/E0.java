/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.LongBinaryOperator
 */
package j$;

import j$.f0;
import j$.util.function.C;
import java.util.function.LongBinaryOperator;

public final class e0
implements C {
    final /* synthetic */ LongBinaryOperator a;

    private /* synthetic */ e0(LongBinaryOperator longBinaryOperator) {
        this.a = longBinaryOperator;
    }

    public static /* synthetic */ C a(LongBinaryOperator longBinaryOperator) {
        if (longBinaryOperator == null) {
            return null;
        }
        if (longBinaryOperator instanceof f0) {
            return ((f0)longBinaryOperator).a;
        }
        return new e0(longBinaryOperator);
    }

    @Override
    public /* synthetic */ long applyAsLong(long l2, long l3) {
        return this.a.applyAsLong(l2, l3);
    }
}

