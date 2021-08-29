/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.function;

import j$.util.function.BiFunction;
import j$.util.function.BiFunction$-CC;
import j$.util.function.Function;

public final class b
implements BiFunction {
    public final /* synthetic */ BiFunction a;
    public final /* synthetic */ Function b;

    public /* synthetic */ b(BiFunction biFunction, Function function) {
        this.a = biFunction;
        this.b = function;
    }

    @Override
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction$-CC.$default$andThen(this, function);
    }

    @Override
    public final Object apply(Object object, Object object2) {
        BiFunction biFunction = this.a;
        return this.b.apply(biFunction.apply(object, object2));
    }
}

