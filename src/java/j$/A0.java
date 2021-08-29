/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.IntToLongFunction
 */
package j$;

import j$.b0;
import j$.util.function.A;
import java.util.function.IntToLongFunction;

public final class a0
implements A {
    final /* synthetic */ IntToLongFunction a;

    private /* synthetic */ a0(IntToLongFunction intToLongFunction) {
        this.a = intToLongFunction;
    }

    public static /* synthetic */ A a(IntToLongFunction intToLongFunction) {
        if (intToLongFunction == null) {
            return null;
        }
        if (intToLongFunction instanceof b0) {
            return ((b0)intToLongFunction).a;
        }
        return new a0(intToLongFunction);
    }

    @Override
    public /* synthetic */ long applyAsLong(int n2) {
        return this.a.applyAsLong(n2);
    }
}

