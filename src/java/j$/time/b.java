/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.time;

import j$.time.OffsetDateTime;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;

public final class b
implements TemporalQuery {
    public static final /* synthetic */ b a;

    static /* synthetic */ {
        a = new b();
    }

    private /* synthetic */ b() {
    }

    @Override
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        return OffsetDateTime.from(temporalAccessor);
    }
}

