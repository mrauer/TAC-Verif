/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.LongFunction
 */
package j$;

import j$.i0;
import j$.util.function.E;
import java.util.function.LongFunction;

public final class j0
implements LongFunction {
    final /* synthetic */ E a;

    private /* synthetic */ j0(E e2) {
        this.a = e2;
    }

    public static /* synthetic */ LongFunction a(E e2) {
        if (e2 == null) {
            return null;
        }
        if (e2 instanceof i0) {
            return ((i0)e2).a;
        }
        return new j0(e2);
    }

    public /* synthetic */ Object apply(long l2) {
        return this.a.apply(l2);
    }
}

