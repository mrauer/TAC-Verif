/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.LongFunction
 */
package j$;

import j$.j0;
import j$.util.function.E;
import java.util.function.LongFunction;

public final class i0
implements E {
    final /* synthetic */ LongFunction a;

    private /* synthetic */ i0(LongFunction longFunction) {
        this.a = longFunction;
    }

    public static /* synthetic */ E a(LongFunction longFunction) {
        if (longFunction == null) {
            return null;
        }
        if (longFunction instanceof j0) {
            return ((j0)longFunction).a;
        }
        return new i0(longFunction);
    }

    @Override
    public /* synthetic */ Object apply(long l2) {
        return this.a.apply(l2);
    }
}

