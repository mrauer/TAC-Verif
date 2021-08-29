/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.v
 *  java.lang.Object
 *  java.util.function.BiFunction
 *  java.util.function.BinaryOperator
 *  java.util.function.Function
 */
package j$;

import j$.N;
import j$.u;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;

public final class w
implements java.util.function.BinaryOperator {
    final /* synthetic */ BinaryOperator a;

    private /* synthetic */ w(BinaryOperator binaryOperator) {
        this.a = binaryOperator;
    }

    public static /* synthetic */ java.util.function.BinaryOperator a(BinaryOperator binaryOperator) {
        if (binaryOperator == null) {
            return null;
        }
        if (binaryOperator instanceof j.v) {
            return ((j.v)binaryOperator).a;
        }
        return new w(binaryOperator);
    }

    public /* synthetic */ java.util.function.BiFunction andThen(java.util.function.Function function) {
        return u.a(this.a.andThen(N.a(function)));
    }

    public /* synthetic */ Object apply(Object object, Object object2) {
        return this.a.apply(object, object2);
    }
}

