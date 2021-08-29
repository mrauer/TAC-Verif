/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.LongBinaryOperator
 */
package j$;

import j$.e0;
import j$.util.function.C;
import java.util.function.LongBinaryOperator;

public final class f0
implements LongBinaryOperator {
    final /* synthetic */ C a;

    private /* synthetic */ f0(C c2) {
        this.a = c2;
    }

    public static /* synthetic */ LongBinaryOperator a(C c2) {
        if (c2 == null) {
            return null;
        }
        if (c2 instanceof e0) {
            return ((e0)c2).a;
        }
        return new f0(c2);
    }

    public /* synthetic */ long applyAsLong(long l2, long l3) {
        return this.a.applyAsLong(l2, l3);
    }
}

