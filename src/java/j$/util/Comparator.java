/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Comparator
 */
package j$.util;

import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;

public interface Comparator<T> {
    public int compare(Object var1, Object var2);

    public boolean equals(Object var1);

    public java.util.Comparator reversed();

    public java.util.Comparator thenComparing(Function var1);

    public java.util.Comparator thenComparing(Function var1, java.util.Comparator var2);

    public java.util.Comparator thenComparing(java.util.Comparator var1);

    public java.util.Comparator thenComparingDouble(ToDoubleFunction var1);

    public java.util.Comparator thenComparingInt(ToIntFunction var1);

    public java.util.Comparator thenComparingLong(ToLongFunction var1);
}

