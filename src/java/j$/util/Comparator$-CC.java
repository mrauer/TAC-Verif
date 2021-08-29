/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Objects
 */
package j$.util;

import j$.util.a;
import j$.util.b;
import j$.util.c;
import j$.util.d;
import j$.util.e;
import j$.util.f;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.k;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public final class Comparator$-CC {
    public static Comparator $default$reversed(Comparator comparator) {
        return Collections.reverseOrder((Comparator)comparator);
    }

    public static Comparator $default$thenComparing(Comparator comparator, Function function) {
        Objects.requireNonNull((Object)function);
        return j$.time.e.O(comparator, new a(function));
    }

    public static Comparator $default$thenComparing(Comparator comparator, Function function, Comparator comparator2) {
        Objects.requireNonNull((Object)function);
        Objects.requireNonNull((Object)comparator2);
        return j$.time.e.O(comparator, new b(comparator2, function));
    }

    public static Comparator $default$thenComparing(Comparator comparator, Comparator comparator2) {
        Objects.requireNonNull((Object)comparator2);
        return new d(comparator, comparator2);
    }

    public static Comparator $default$thenComparingDouble(Comparator comparator, ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull((Object)toDoubleFunction);
        return j$.time.e.O(comparator, new c(toDoubleFunction));
    }

    public static Comparator $default$thenComparingInt(Comparator comparator, ToIntFunction toIntFunction) {
        Objects.requireNonNull((Object)toIntFunction);
        return j$.time.e.O(comparator, new e(toIntFunction));
    }

    public static Comparator $default$thenComparingLong(Comparator comparator, ToLongFunction toLongFunction) {
        Objects.requireNonNull((Object)toLongFunction);
        return j$.time.e.O(comparator, new f(toLongFunction));
    }

    public static Comparator a() {
        return k.INSTANCE;
    }
}

