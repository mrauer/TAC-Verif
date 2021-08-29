/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDate
 *  java.lang.Object
 */
package j$.time.temporal;

import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.j;
import j$.time.temporal.o;

public final class c
implements TemporalQuery {
    public static final /* synthetic */ c a;

    static /* synthetic */ {
        a = new c();
    }

    private /* synthetic */ c() {
    }

    @Override
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        j j2 = j.EPOCH_DAY;
        if (temporalAccessor.h(j2)) {
            return j.LocalDate.ofEpochDay((long)temporalAccessor.f(j2));
        }
        return null;
    }
}

