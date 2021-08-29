/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.time.temporal;

import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.e;
import j$.time.temporal.f;

public final class i
implements TemporalQuery {
    public static final /* synthetic */ i a;

    static /* synthetic */ {
        a = new i();
    }

    private /* synthetic */ i() {
    }

    @Override
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId)temporalAccessor.t(f.a);
        if (zoneId != null) {
            return zoneId;
        }
        return (ZoneId)temporalAccessor.t(e.a);
    }
}

