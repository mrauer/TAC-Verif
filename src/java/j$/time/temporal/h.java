/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.time.temporal;

import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.j;
import j$.time.temporal.o;

public final class h
implements TemporalQuery {
    public static final /* synthetic */ h a;

    static /* synthetic */ {
        a = new h();
    }

    private /* synthetic */ h() {
    }

    @Override
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        j j2 = j.NANO_OF_DAY;
        if (temporalAccessor.h(j2)) {
            return j$.time.j.O(temporalAccessor.f(j2));
        }
        return null;
    }
}

