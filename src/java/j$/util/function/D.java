/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Comparator
 */
package j$.util.function;

import j$.util.function.BiFunction;
import j$.util.function.BiFunction$-CC;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import java.util.Comparator;

public final class d
implements BinaryOperator {
    public final /* synthetic */ Comparator a;

    public /* synthetic */ d(Comparator comparator) {
        this.a = comparator;
    }

    @Override
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction$-CC.$default$andThen(this, function);
    }

    @Override
    public final Object apply(Object object, Object object2) {
        if (this.a.compare(object, object2) >= 0) {
            return object;
        }
        return object2;
    }
}

