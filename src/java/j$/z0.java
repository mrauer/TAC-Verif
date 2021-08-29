/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.Predicate
 */
package j$;

import j$.util.function.Predicate;
import j$.y0;

public final class z0
implements java.util.function.Predicate {
    final /* synthetic */ Predicate a;

    private /* synthetic */ z0(Predicate predicate) {
        this.a = predicate;
    }

    public static /* synthetic */ java.util.function.Predicate a(Predicate predicate) {
        if (predicate == null) {
            return null;
        }
        if (predicate instanceof y0) {
            return ((y0)predicate).a;
        }
        return new z0(predicate);
    }

    public /* synthetic */ java.util.function.Predicate and(java.util.function.Predicate predicate) {
        return z0.a(this.a.and(y0.a(predicate)));
    }

    public /* synthetic */ java.util.function.Predicate negate() {
        return z0.a(this.a.negate());
    }

    public /* synthetic */ java.util.function.Predicate or(java.util.function.Predicate predicate) {
        return z0.a(this.a.or(y0.a(predicate)));
    }

    public /* synthetic */ boolean test(Object object) {
        return this.a.test(object);
    }
}

