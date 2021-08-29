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

public final class f
implements TemporalQuery {
    public static final /* synthetic */ f a;

    static /* synthetic */ {
        a = new f();
    }

    private /* synthetic */ f() {
    }

    @Override
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        return (ZoneId)temporalAccessor.t(a);
    }
}

