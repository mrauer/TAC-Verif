/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.ZonedDateTime
 *  java.lang.Object
 */
package j$.time;

import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;

public final class a
implements TemporalQuery {
    public static final /* synthetic */ a a;

    static /* synthetic */ {
        a = new a();
    }

    private /* synthetic */ a() {
    }

    @Override
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        return j.ZonedDateTime.F((TemporalAccessor)temporalAccessor);
    }
}

