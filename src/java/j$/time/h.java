/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package j$.time;

import j$.time.e;
import j$.time.g;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.j;
import j$.time.temporal.l;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;

public final class h
extends Enum<h>
implements TemporalAccessor,
l {
    public static final /* enum */ h FRIDAY;
    public static final /* enum */ h MONDAY;
    public static final /* enum */ h SATURDAY;
    public static final /* enum */ h SUNDAY;
    public static final /* enum */ h THURSDAY;
    public static final /* enum */ h TUESDAY;
    public static final /* enum */ h WEDNESDAY;
    private static final h[] a;
    private static final /* synthetic */ h[] b;

    static {
        h h2;
        h h3;
        h h4;
        h h5;
        h h6;
        h h7;
        h h8;
        MONDAY = h3 = new h();
        TUESDAY = h7 = new h();
        WEDNESDAY = h2 = new h();
        THURSDAY = h5 = new h();
        FRIDAY = h8 = new h();
        SATURDAY = h4 = new h();
        SUNDAY = h6 = new h();
        b = new h[]{h3, h7, h2, h5, h8, h4, h6};
        a = h.values();
    }

    public static h G(int n2) {
        if (n2 >= 1 && n2 <= 7) {
            return a[n2 - 1];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid value for DayOfWeek: ");
        stringBuilder.append(n2);
        throw new g(stringBuilder.toString());
    }

    public static h valueOf(String string) {
        return (h)Enum.valueOf(h.class, (String)string);
    }

    public static h[] values() {
        return (h[])b.clone();
    }

    public int F() {
        return 1 + this.ordinal();
    }

    public h H(long l2) {
        int n2 = (int)(l2 % 7L);
        return a[(this.ordinal() + (n2 + 7)) % 7];
    }

    @Override
    public long f(o o2) {
        if (o2 == j.DAY_OF_WEEK) {
            return this.F();
        }
        if (!(o2 instanceof j)) {
            return o2.v(this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append((Object)o2);
        throw new q(stringBuilder.toString());
    }

    @Override
    public boolean h(o o2) {
        if (o2 instanceof j) {
            return o2 == j.DAY_OF_WEEK;
        }
        return o2 != null && o2.F(this);
    }

    @Override
    public int i(o o2) {
        if (o2 == j.DAY_OF_WEEK) {
            return this.F();
        }
        return e.f(this, o2);
    }

    @Override
    public r p(o o2) {
        if (o2 == j.DAY_OF_WEEK) {
            return o2.p();
        }
        return e.k(this, o2);
    }

    @Override
    public Object t(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.g.a) {
            return ChronoUnit.DAYS;
        }
        return e.j(this, temporalQuery);
    }

    @Override
    public Temporal v(Temporal temporal) {
        return temporal.b(j.DAY_OF_WEEK, this.F());
    }
}

