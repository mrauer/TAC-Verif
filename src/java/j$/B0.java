/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.IntToLongFunction
 */
package j$;

import j$.a0;
import j$.util.function.A;
import java.util.function.IntToLongFunction;

public final class b0
implements IntToLongFunction {
    final /* synthetic */ A a;

    private /* synthetic */ b0(A a2) {
        this.a = a2;
    }

    public static /* synthetic */ IntToLongFunction a(A a2) {
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof a0) {
            return ((a0)a2).a;
        }
        return new b0(a2);
    }

    public /* synthetic */ long applyAsLong(int n2) {
        return this.a.applyAsLong(n2);
    }
}

