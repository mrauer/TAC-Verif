/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.Predicate
 */
package j$;

import j$.util.function.Predicate;
import j$.z0;

public final class y0
implements Predicate {
    final /* synthetic */ java.util.function.Predicate a;

    private /* synthetic */ y0(java.util.function.Predicate predicate) {
        this.a = predicate;
    }

    public static /* synthetic */ Predicate a(java.util.function.Predicate predicate) {
        if (predicate == null) {
            return null;
        }
        if (predicate instanceof z0) {
            return ((z0)predicate).a;
        }
        return new y0(predicate);
    }

    @Override
    public /* synthetic */ Predicate and(Predicate predicate) {
        return y0.a(this.a.and(z0.a(predicate)));
    }

    @Override
    public /* synthetic */ Predicate negate() {
        return y0.a(this.a.negate());
    }

    @Override
    public /* synthetic */ Predicate or(Predicate predicate) {
        return y0.a(this.a.or(z0.a(predicate)));
    }

    @Override
    public /* synthetic */ boolean test(Object object) {
        return this.a.test(object);
    }
}

