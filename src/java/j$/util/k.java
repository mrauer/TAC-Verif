/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.function.Function
 *  java.util.function.ToDoubleFunction
 *  java.util.function.ToIntFunction
 *  java.util.function.ToLongFunction
 */
package j$.util;

import j$.C0;
import j$.E0;
import j$.G0;
import j$.N;
import j$.util.Comparator;
import j$.util.Comparator$-CC;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;

final class k
extends Enum<k>
implements java.util.Comparator<Comparable<Object>>,
Comparator {
    public static final /* enum */ k INSTANCE;
    private static final /* synthetic */ k[] a;

    static {
        k k2;
        INSTANCE = k2 = new k();
        a = new k[]{k2};
    }

    public static k valueOf(String string) {
        return (k)Enum.valueOf(k.class, (String)string);
    }

    public static k[] values() {
        return (k[])a.clone();
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((Comparable)object).compareTo((Object)((Comparable)object2));
    }

    @Override
    public java.util.Comparator reversed() {
        return Collections.reverseOrder();
    }

    @Override
    public /* synthetic */ java.util.Comparator thenComparing(Function function) {
        return Comparator$-CC.$default$thenComparing((java.util.Comparator)this, function);
    }

    @Override
    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator$-CC.$default$thenComparing(this, function, comparator);
    }

    @Override
    public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
        return Comparator$-CC.$default$thenComparing((java.util.Comparator)this, comparator);
    }

    public /* synthetic */ java.util.Comparator thenComparing(java.util.function.Function function) {
        return Comparator$-CC.$default$thenComparing((java.util.Comparator)this, N.a(function));
    }

    public /* synthetic */ java.util.Comparator thenComparing(java.util.function.Function function, java.util.Comparator comparator) {
        return Comparator$-CC.$default$thenComparing(this, N.a(function), comparator);
    }

    @Override
    public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator$-CC.$default$thenComparingDouble(this, toDoubleFunction);
    }

    public /* synthetic */ java.util.Comparator thenComparingDouble(java.util.function.ToDoubleFunction toDoubleFunction) {
        return Comparator$-CC.$default$thenComparingDouble(this, C0.a(toDoubleFunction));
    }

    @Override
    public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator$-CC.$default$thenComparingInt(this, toIntFunction);
    }

    public /* synthetic */ java.util.Comparator thenComparingInt(java.util.function.ToIntFunction toIntFunction) {
        return Comparator$-CC.$default$thenComparingInt(this, E0.a(toIntFunction));
    }

    @Override
    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator$-CC.$default$thenComparingLong(this, toLongFunction);
    }

    public /* synthetic */ java.util.Comparator thenComparingLong(java.util.function.ToLongFunction toLongFunction) {
        return Comparator$-CC.$default$thenComparingLong(this, G0.a(toLongFunction));
    }
}

