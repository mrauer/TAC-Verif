/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.BiFunction
 *  java.util.function.Function
 */
package j$;

import j$.N;
import j$.t;
import j$.util.function.BiFunction;
import j$.util.function.Function;

public final class u
implements java.util.function.BiFunction {
    final /* synthetic */ BiFunction a;

    private /* synthetic */ u(BiFunction biFunction) {
        this.a = biFunction;
    }

    public static /* synthetic */ java.util.function.BiFunction a(BiFunction biFunction) {
        if (biFunction == null) {
            return null;
        }
        if (biFunction instanceof t) {
            return ((t)biFunction).a;
        }
        return new u(biFunction);
    }

    public /* synthetic */ java.util.function.BiFunction andThen(java.util.function.Function function) {
        return u.a(this.a.andThen(N.a(function)));
    }

    public /* synthetic */ Object apply(Object object, Object object2) {
        return this.a.apply(object, object2);
    }
}

