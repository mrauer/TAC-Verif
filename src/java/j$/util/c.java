/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Double
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
import j$.util.function.ToDoubleFunction;
import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public final class c
implements Comparator,
Serializable {
    public final /* synthetic */ ToDoubleFunction a;

    public /* synthetic */ c(ToDoubleFunction toDoubleFunction) {
        this.a = toDoubleFunction;
    }

    public final int compare(Object object, Object object2) {
        ToDoubleFunction toDoubleFunction = this.a;
        return Double.compare((double)toDoubleFunction.applyAsDouble(object), (double)toDoubleFunction.applyAsDouble(object2));
    }

    public /* synthetic */ Comparator reversed() {
        return Comparator$-CC.$default$reversed(this);
    }

    public /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return Comparator$-CC.$default$thenComparing((Comparator)this, comparator);
    }

    public /* synthetic */ Comparator thenComparing(Function function) {
        return Comparator$-CC.$default$thenComparing((Comparator)this, N.a(function));
    }

    public /* synthetic */ Comparator thenComparing(Function function, Comparator comparator) {
        return Comparator$-CC.$default$thenComparing(this, N.a(function), comparator);
    }

    public /* synthetic */ Comparator thenComparingDouble(java.util.function.ToDoubleFunction toDoubleFunction) {
        return Comparator$-CC.$default$thenComparingDouble(this, C0.a(toDoubleFunction));
    }

    public /* synthetic */ Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator$-CC.$default$thenComparingInt(this, E0.a(toIntFunction));
    }

    public /* synthetic */ Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator$-CC.$default$thenComparingLong(this, G0.a(toLongFunction));
    }
}

