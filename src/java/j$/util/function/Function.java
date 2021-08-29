/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.function;

public interface Function<T, R> {
    public Function andThen(Function var1);

    public Object apply(Object var1);

    public Function compose(Function var1);
}

