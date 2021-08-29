/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.LongPredicate
 */
package j$;

import j$.k0;
import j$.util.function.F;
import java.util.function.LongPredicate;

public final class l0
implements LongPredicate {
    final /* synthetic */ F a;

    private /* synthetic */ l0(F f2) {
        this.a = f2;
    }

    public static /* synthetic */ LongPredicate a(F f2) {
        if (f2 == null) {
            return null;
        }
        if (f2 instanceof k0) {
            return ((k0)f2).a;
        }
        return new l0(f2);
    }

    public /* synthetic */ LongPredicate and(LongPredicate longPredicate) {
        F f2 = this.a;
        F f4 = k0.a(longPredicate);
        return l0.a(k0.a(((k0)f2).a.and(l0.a(f4))));
    }

    public /* synthetic */ LongPredicate negate() {
        return l0.a(k0.a(((k0)this.a).a.negate()));
    }

    public /* synthetic */ LongPredicate or(LongPredicate longPredicate) {
        F f2 = this.a;
        F f4 = k0.a(longPredicate);
        return l0.a(k0.a(((k0)f2).a.or(l0.a(f4))));
    }

    public /* synthetic */ boolean test(long l2) {
        return ((k0)this.a).a.test(l2);
    }
}

