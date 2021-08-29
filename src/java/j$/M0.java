/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.LongToDoubleFunction
 */
package j$;

import j$.n0;
import java.util.function.LongToDoubleFunction;

public final class m0 {
    final /* synthetic */ LongToDoubleFunction a;

    private /* synthetic */ m0(LongToDoubleFunction longToDoubleFunction) {
        this.a = longToDoubleFunction;
    }

    public static /* synthetic */ m0 b(LongToDoubleFunction longToDoubleFunction) {
        if (longToDoubleFunction == null) {
            return null;
        }
        if (longToDoubleFunction instanceof n0) {
            return ((n0)longToDoubleFunction).a;
        }
        return new m0(longToDoubleFunction);
    }

    public double a(long l2) {
        return this.a.applyAsDouble(l2);
    }
}

