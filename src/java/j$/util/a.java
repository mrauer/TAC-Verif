/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Comparable
 *  java.lang.Object
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
import j$.util.Comparator$-CC;
import j$.util.function.Function;
import java.io.Serializable;
import java.util.Comparator;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public final class a
implements Comparator,
Serializable {
    public final /* synthetic */ Function a;

    public /* synthetic */ a(Function function) {
        this.a = function;
    }

    public final int compare(Object object, Object object2) {
        Function function = this.a;
        return ((Comparable)function.apply(object)).compareTo(function.apply(object2));
    }

    public /* synthetic */ Comparator reversed() {
        return Comparator$-CC.$default$reversed(this);
    }

    public /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return Comparator$-CC.$default$thenComparing((Comparator)this, comparator);
    }

    public /* synthetic */ Comparator thenComparing(java.util.function.Function function) {
        return Comparator$-CC.$default$thenComparing((Comparator)this, N.a(function));
    }

    public /* synthetic */ Comparator thenComparing(java.util.function.Function function, Comparator comparator) {
        return Comparator$-CC.$default$thenComparing(this, N.a(function), comparator);
    }

    public /* synthetic */ Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator$-CC.$default$thenComparingDouble(this, C0.a(toDoubleFunction));
    }

    public /* synthetic */ Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator$-CC.$default$thenComparingInt(this, E0.a(toIntFunction));
    }

    public /* synthetic */ Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator$-CC.$default$thenComparingLong(this, G0.a(toLongFunction));
    }
}

