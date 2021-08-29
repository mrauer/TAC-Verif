/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.function;

import j$.util.function.BiFunction;
import j$.util.function.Function;

public interface BinaryOperator<T>
extends BiFunction<T, T, T> {
    @Override
    public /* synthetic */ BiFunction andThen(Function var1);

    @Override
    public /* synthetic */ Object apply(Object var1, Object var2);
}

