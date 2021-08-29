/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDateTime
 *  java.lang.Object
 */
package j$.time;

import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;

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
        return j.LocalDateTime.G((TemporalAccessor)temporalAccessor);
    }
}

