/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.function;

import j$.util.function.Function;

public interface BiFunction<T, U, R> {
    public BiFunction andThen(Function var1);

    public Object apply(Object var1, Object var2);
}

