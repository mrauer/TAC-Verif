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

import j$.time.chrono.c;
import j$.time.e;
import j$.time.g;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.d;
import j$.time.temporal.j;
import j$.time.temporal.l;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;

public final class k
extends Enum<k>
implements TemporalAccessor,
l {
    public static final /* enum */ k APRIL;
    public static final /* enum */ k AUGUST;
    public static final /* enum */ k DECEMBER;
    public static final /* enum */ k FEBRUARY;
    public static final /* enum */ k JANUARY;
    public static final /* enum */ k JULY;
    public static final /* enum */ k JUNE;
    public static final /* enum */ k MARCH;
    public static final /* enum */ k MAY;
    public static final /* enum */ k NOVEMBER;
    public static final /* enum */ k OCTOBER;
    public static final /* enum */ k SEPTEMBER;
    private static final k[] a;
    private static final /* synthetic */ k[] b;

    static {
        k k2;
        k k3;
        k k4;
        k k5;
        k k6;
        k k7;
        k k8;
        k k9;
        k k10;
        k k11;
        k k12;
        k k13;
        JANUARY = k4 = new k();
        FEBRUARY = k2 = new k();
        MARCH = k12 = new k();
        APRIL = k6 = new k();
        MAY = k11 = new k();
        JUNE = k3 = new k();
        JULY = k7 = new k();
        AUGUST = k13 = new k();
        SEPTEMBER = k5 = new k();
        OCTOBER = k10 = new k();
        NOVEMBER = k9 = new k();
        DECEMBER = k8 = new k();
        b = new k[]{k4, k2, k12, k6, k11, k3, k7, k13, k5, k10, k9, k8};
        a = k.values();
    }

    public static k J(int n2) {
        if (n2 >= 1 && n2 <= 12) {
            return a[n2 - 1];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid value for MonthOfYear: ");
        stringBuilder.append(n2);
        throw new g(stringBuilder.toString());
    }

    public static k valueOf(String string) {
        return (k)Enum.valueOf(k.class, (String)string);
    }

    public static k[] values() {
        return (k[])b.clone();
    }

    public int F(boolean bl) {
        int n2;
        switch (this.ordinal()) {
            default: {
                n2 = 335;
                break;
            }
            case 9: {
                n2 = 274;
                break;
            }
            case 7: {
                n2 = 213;
                break;
            }
            case 6: {
                n2 = 182;
                break;
            }
            case 4: {
                n2 = 121;
                break;
            }
            case 2: {
                n2 = 60;
                break;
            }
            case 0: {
                return 1;
            }
            case 10: {
                n2 = 305;
                break;
            }
            case 8: {
                n2 = 244;
                break;
            }
            case 5: {
                n2 = 152;
                break;
            }
            case 3: {
                n2 = 91;
                break;
            }
            case 1: {
                return 32;
            }
        }
        return bl + n2;
    }

    public int G() {
        return 1 + this.ordinal();
    }

    public int H(boolean bl) {
        int n2 = this.ordinal();
        if (n2 != 1) {
            if (n2 != 3 && n2 != 5 && n2 != 8 && n2 != 10) {
                return 31;
            }
            return 30;
        }
        if (bl) {
            return 29;
        }
        return 28;
    }

    public k K(long l2) {
        int n2 = (int)(l2 % 12L);
        return a[(this.ordinal() + (n2 + 12)) % 12];
    }

    @Override
    public long f(o o2) {
        if (o2 == j.MONTH_OF_YEAR) {
            return this.G();
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
            return o2 == j.MONTH_OF_YEAR;
        }
        return o2 != null && o2.F(this);
    }

    @Override
    public int i(o o2) {
        if (o2 == j.MONTH_OF_YEAR) {
            return this.G();
        }
        return e.f(this, o2);
    }

    @Override
    public r p(o o2) {
        if (o2 == j.MONTH_OF_YEAR) {
            return o2.p();
        }
        return e.k(this, o2);
    }

    @Override
    public Object t(TemporalQuery temporalQuery) {
        if (temporalQuery == d.a) {
            return j$.time.chrono.g.a;
        }
        if (temporalQuery == j$.time.temporal.g.a) {
            return ChronoUnit.MONTHS;
        }
        return e.j(this, temporalQuery);
    }

    @Override
    public Temporal v(Temporal temporal) {
        if (c.e(temporal).equals(j$.time.chrono.g.a)) {
            return temporal.b(j.MONTH_OF_YEAR, this.G());
        }
        throw new g("Adjustment only supported on ISO date-time");
    }
}

