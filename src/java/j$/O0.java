/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.LongToIntFunction
 */
package j$;

import j$.p0;
import java.util.function.LongToIntFunction;

public final class o0 {
    final /* synthetic */ LongToIntFunction a;

    private /* synthetic */ o0(LongToIntFunction longToIntFunction) {
        this.a = longToIntFunction;
    }

    public static /* synthetic */ o0 b(LongToIntFunction longToIntFunction) {
        if (longToIntFunction == null) {
            return null;
        }
        if (longToIntFunction instanceof p0) {
            return ((p0)longToIntFunction).a;
        }
        return new o0(longToIntFunction);
    }

    public int a(long l2) {
        return this.a.applyAsInt(l2);
    }
}

