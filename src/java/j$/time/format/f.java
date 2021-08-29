/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.ChronoLocalDate;
import j$.time.e;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.d;
import j$.time.temporal.g;
import j$.time.temporal.o;
import j$.time.temporal.r;

class f
implements TemporalAccessor {
    final /* synthetic */ ChronoLocalDate a;
    final /* synthetic */ TemporalAccessor b;
    final /* synthetic */ j$.time.chrono.e c;
    final /* synthetic */ ZoneId d;

    f(ChronoLocalDate chronoLocalDate, TemporalAccessor temporalAccessor, j$.time.chrono.e e2, ZoneId zoneId) {
        this.a = chronoLocalDate;
        this.b = temporalAccessor;
        this.c = e2;
        this.d = zoneId;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public long f(o o2) {
        TemporalAccessor temporalAccessor;
        if (this.a != null && o2.i()) {
            temporalAccessor = this.a;
            do {
                return temporalAccessor.f(o2);
                break;
            } while (true);
        }
        temporalAccessor = this.b;
        return temporalAccessor.f(o2);
    }

    @Override
    public boolean h(o o2) {
        if (this.a != null && o2.i()) {
            return this.a.h(o2);
        }
        return this.b.h(o2);
    }

    @Override
    public /* synthetic */ int i(o o2) {
        return e.f(this, o2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public r p(o o2) {
        TemporalAccessor temporalAccessor;
        if (this.a != null && o2.i()) {
            temporalAccessor = this.a;
            do {
                return temporalAccessor.p(o2);
                break;
            } while (true);
        }
        temporalAccessor = this.b;
        return temporalAccessor.p(o2);
    }

    @Override
    public Object t(TemporalQuery temporalQuery) {
        if (temporalQuery == d.a) {
            return this.c;
        }
        if (temporalQuery == j$.time.temporal.f.a) {
            return this.d;
        }
        if (temporalQuery == g.a) {
            return this.b.t(temporalQuery);
        }
        return temporalQuery.queryFrom(this);
    }
}

