/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.BiFunction
 *  java.util.function.Function
 */
package j$;

import j$.O;
import j$.u;
import j$.util.function.BiFunction;
import j$.util.function.Function;

public final class t
implements BiFunction {
    final /* synthetic */ java.util.function.BiFunction a;

    private /* synthetic */ t(java.util.function.BiFunction biFunction) {
        this.a = biFunction;
    }

    public static /* synthetic */ BiFunction a(java.util.function.BiFunction biFunction) {
        if (biFunction == null) {
            return null;
        }
        if (biFunction instanceof u) {
            return ((u)biFunction).a;
        }
        return new t(biFunction);
    }

    @Override
    public /* synthetic */ BiFunction andThen(Function function) {
        return t.a(this.a.andThen(O.a(function)));
    }

    @Override
    public /* synthetic */ Object apply(Object object, Object object2) {
        return this.a.apply(object, object2);
    }
}

