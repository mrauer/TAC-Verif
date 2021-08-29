/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.BiFunction
 *  java.util.function.BinaryOperator
 *  java.util.function.Function
 */
package j$;

import j$.O;
import j$.t;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.w;

public final class v
implements BinaryOperator {
    final /* synthetic */ java.util.function.BinaryOperator a;

    private /* synthetic */ v(java.util.function.BinaryOperator binaryOperator) {
        this.a = binaryOperator;
    }

    public static /* synthetic */ BinaryOperator a(java.util.function.BinaryOperator binaryOperator) {
        if (binaryOperator == null) {
            return null;
        }
        if (binaryOperator instanceof w) {
            return ((w)binaryOperator).a;
        }
        return new v(binaryOperator);
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

