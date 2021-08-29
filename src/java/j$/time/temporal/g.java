/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.time.temporal;

import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;

public final class g
implements TemporalQuery {
    public static final /* synthetic */ g a;

    static /* synthetic */ {
        a = new g();
    }

    private /* synthetic */ g() {
    }

    @Override
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        return (TemporalUnit)temporalAccessor.t(a);
    }
}

