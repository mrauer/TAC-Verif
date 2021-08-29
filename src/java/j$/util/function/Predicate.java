/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.function;

public interface Predicate<T> {
    public Predicate and(Predicate var1);

    public Predicate negate();

    public Predicate or(Predicate var1);

    public boolean test(Object var1);
}

