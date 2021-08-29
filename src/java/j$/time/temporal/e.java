/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.time.temporal;

import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.j;
import j$.time.temporal.o;

public final class e
implements TemporalQuery {
    public static final /* synthetic */ e a;

    static /* synthetic */ {
        a = new e();
    }

    private /* synthetic */ e() {
    }

    @Override
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        j j2 = j.OFFSET_SECONDS;
        if (temporalAccessor.h(j2)) {
            return ZoneOffset.O(temporalAccessor.i(j2));
        }
        return null;
    }
}

