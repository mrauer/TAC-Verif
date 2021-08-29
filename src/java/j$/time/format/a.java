/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.time.format;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.f;

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
        ZoneId zoneId = (ZoneId)temporalAccessor.t(f.a);
        if (zoneId != null && !(zoneId instanceof ZoneOffset)) {
            return zoneId;
        }
        return null;
    }
}

