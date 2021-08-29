/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.synchronization.elements;

import j$.time.LocalDateTime;
import j$.time.chrono.ChronoLocalDateTime;
import j$.util.function.Predicate;
import j$.util.function.Predicate$-CC;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$Blacklist$fMRL67-IRTVJlGVnQNleQYc9gRM
implements Predicate {
    public final /* synthetic */ LocalDateTime f$0;

    public /* synthetic */ -$$Lambda$Blacklist$fMRL67-IRTVJlGVnQNleQYc9gRM(LocalDateTime localDateTime) {
        this.f$0 = localDateTime;
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
        LocalDateTime localDateTime = this.f$0;
        LocalDateTime localDateTime2 = (LocalDateTime)object;
        Intrinsics.checkNotNullParameter((Object)localDateTime2, (String)"it");
        return localDateTime2.compareTo(localDateTime) < 0;
    }
}

