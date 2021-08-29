/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.function;

import j$.util.function.Predicate;
import j$.util.function.Predicate$-CC;

public final class o
implements Predicate {
    public final /* synthetic */ Predicate a;
    public final /* synthetic */ Predicate b;

    public /* synthetic */ o(Predicate predicate, Predicate predicate2) {
        this.a = predicate;
        this.b = predicate2;
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
        Predicate predicate = this.a;
        Predicate predicate2 = this.b;
        return predicate.test(object) && predicate2.test(object);
    }
}

