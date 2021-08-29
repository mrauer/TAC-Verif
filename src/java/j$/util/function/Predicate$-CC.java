/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.function;

import j$.util.function.Predicate;
import j$.util.function.m;
import j$.util.function.n;
import j$.util.function.o;
import java.util.Objects;

public final class Predicate$-CC {
    public static Predicate $default$and(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull((Object)predicate2);
        return new o(predicate, predicate2);
    }

    public static Predicate $default$negate(Predicate predicate) {
        return new n(predicate);
    }

    public static Predicate $default$or(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull((Object)predicate2);
        return new m(predicate, predicate2);
    }
}

