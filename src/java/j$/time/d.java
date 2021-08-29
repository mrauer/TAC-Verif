/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDate
 *  java.lang.Object
 */
package j$.time;

import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;

public final class d
implements TemporalQuery {
    public static final /* synthetic */ d a;

    static /* synthetic */ {
        a = new d();
    }

    private /* synthetic */ d() {
    }

    @Override
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        return j.LocalDate.H((TemporalAccessor)temporalAccessor);
    }
}

