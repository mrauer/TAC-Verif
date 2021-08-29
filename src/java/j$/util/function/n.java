/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.function;

import j$.util.function.Predicate;
import j$.util.function.Predicate$-CC;

public final class n
implements Predicate {
    public final /* synthetic */ Predicate a;

    public /* synthetic */ n(Predicate predicate) {
        this.a = predicate;
    }

    @Override
    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate$-CC.$default$and(this, predicate);
    }

    @Override
    public /* synthetic */ Predicate negate() {
        return Predicate$-CC.$default$negate(this);
    }

    @Override
    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate$-CC.$default$or(this, predicate);
    }

    @Override
    public final boolean test(Object object) {
        return true ^ this.a.test(object);
    }
}

