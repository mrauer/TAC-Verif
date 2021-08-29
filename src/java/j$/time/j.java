/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDate
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package j$.time;

import j$.time.e;
import j$.time.g;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.c;
import j$.time.temporal.d;
import j$.time.temporal.f;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.l;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import java.io.Serializable;
import java.util.Objects;

public final class j
implements Temporal,
l,
Comparable<j>,
Serializable {
    public static final j a;
    public static final j b;
    public static final j c;
    private static final j[] d;
    private final byte e;
    private final byte f;
    private final byte g;
    private final int h;

    static {
        j[] arrj;
        d = new j[24];
        for (int i2 = 0; i2 < (arrj = d).length; ++i2) {
            arrj[i2] = new j(i2, 0, 0, 0);
        }
        c = arrj[0];
        arrj[12];
        a = arrj[0];
        b = new j(23, 59, 59, 999999999);
    }

    private j(int n2, int n3, int n4, int n5) {
        this.e = (byte)n2;
        this.f = (byte)n3;
        this.g = (byte)n4;
        this.h = n5;
    }

    private static j G(int n2, int n3, int n4, int n5) {
        if ((n5 | (n3 | n4)) == 0) {
            return d[n2];
        }
        return new j(n2, n3, n4, n5);
    }

    public static j H(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull((Object)temporalAccessor, (String)"temporal");
        j j2 = (j)temporalAccessor.t(h.a);
        if (j2 != null) {
            return j2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to obtain LocalTime from TemporalAccessor: ");
        stringBuilder.append((Object)temporalAccessor);
        stringBuilder.append(" of type ");
        stringBuilder.append(temporalAccessor.getClass().getName());
        throw new g(stringBuilder.toString());
    }

    private int J(o o2) {
        switch (((j$.time.temporal.j)o2).ordinal()) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append((Object)o2);
                throw new q(stringBuilder.toString());
            }
            case 14: {
                return this.e / 12;
            }
            case 13: {
                int n2 = this.e;
                if (n2 == 0) {
                    n2 = 24;
                }
                return n2;
            }
            case 12: {
                return this.e;
            }
            case 11: {
                int n3 = this.e % 12;
                if (n3 % 12 == 0) {
                    return 12;
                }
                return n3;
            }
            case 10: {
                return this.e % 12;
            }
            case 9: {
                return 60 * this.e + this.f;
            }
            case 8: {
                return this.f;
            }
            case 7: {
                return this.U();
            }
            case 6: {
                return this.g;
            }
            case 5: {
                return (int)(this.T() / 1000000L);
            }
            case 4: {
                return this.h / 1000000;
            }
            case 3: {
                throw new q("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            }
            case 2: {
                return this.h / 1000;
            }
            case 1: {
                throw new q("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            }
            case 0: 
        }
        return this.h;
    }

    public static j M(int n2, int n3) {
        j$.time.temporal.j.HOUR_OF_DAY.K(n2);
        if (n3 == 0) {
            return d[n2];
        }
        j$.time.temporal.j.MINUTE_OF_HOUR.K(n3);
        return new j(n2, n3, 0, 0);
    }

    public static j N(int n2, int n3, int n4, int n5) {
        j$.time.temporal.j.HOUR_OF_DAY.K(n2);
        j$.time.temporal.j.MINUTE_OF_HOUR.K(n3);
        j$.time.temporal.j.SECOND_OF_MINUTE.K(n4);
        j$.time.temporal.j.NANO_OF_SECOND.K(n5);
        return j.G(n2, n3, n4, n5);
    }

    public static j O(long l2) {
        j$.time.temporal.j.NANO_OF_DAY.K(l2);
        int n2 = (int)(l2 / 3600000000000L);
        long l3 = l2 - 3600000000000L * (long)n2;
        int n3 = (int)(l3 / 60000000000L);
        long l4 = l3 - 60000000000L * (long)n3;
        int n4 = (int)(l4 / 1000000000L);
        return j.G(n2, n3, n4, (int)(l4 - 1000000000L * (long)n4));
    }

    public int F(j j2) {
        int n2 = Integer.compare((int)this.e, (int)j2.e);
        if (n2 == 0 && (n2 = Integer.compare((int)this.f, (int)j2.f)) == 0 && (n2 = Integer.compare((int)this.g, (int)j2.g)) == 0) {
            n2 = Integer.compare((int)this.h, (int)j2.h);
        }
        return n2;
    }

    public int K() {
        return this.h;
    }

    public int L() {
        return this.g;
    }

    public j P(long l2) {
        if (l2 == 0L) {
            return this;
        }
        return j.G((24 + ((int)(l2 % 24L) + this.e)) % 24, this.f, this.g, this.h);
    }

    public j Q(long l2) {
        if (l2 == 0L) {
            return this;
        }
        int n2 = 60 * this.e + this.f;
        int n3 = (1440 + (n2 + (int)(l2 % 1440L))) % 1440;
        if (n2 == n3) {
            return this;
        }
        return j.G(n3 / 60, n3 % 60, this.g, this.h);
    }

    public j R(long l2) {
        long l3;
        if (l2 == 0L) {
            return this;
        }
        long l4 = this.T();
        if (l4 == (l3 = (86400000000000L + (l4 + l2 % 86400000000000L)) % 86400000000000L)) {
            return this;
        }
        return j.G((int)(l3 / 3600000000000L), (int)(l3 / 60000000000L % 60L), (int)(l3 / 1000000000L % 60L), (int)(l3 % 1000000000L));
    }

    public j S(long l2) {
        if (l2 == 0L) {
            return this;
        }
        int n2 = 3600 * this.e + 60 * this.f + this.g;
        int n3 = (86400 + (n2 + (int)(l2 % 86400L))) % 86400;
        if (n2 == n3) {
            return this;
        }
        return j.G(n3 / 3600, n3 / 60 % 60, n3 % 60, this.h);
    }

    public long T() {
        return 3600000000000L * (long)this.e + 60000000000L * (long)this.f + 1000000000L * (long)this.g + (long)this.h;
    }

    public int U() {
        return 3600 * this.e + 60 * this.f + this.g;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public j V(o var1_1, long var2_2) {
        if (var1_1 instanceof j$.time.temporal.j == false) return (j)var1_1.G(this, var2_2);
        var4_3 = (j$.time.temporal.j)var1_1;
        var4_3.K(var2_2);
        switch (var4_3.ordinal()) {
            default: {
                var18_4 = new StringBuilder();
                var18_4.append("Unsupported field: ");
                var18_4.append((Object)var1_1);
                throw new q(var18_4.toString());
            }
            case 14: {
                var16_5 = 12L * (var2_2 - (long)(this.e / 12));
                return this.P(var16_5);
            }
            case 13: {
                if (var2_2 != 24L) return this.W((int)var2_2);
                var2_2 = 0L;
            }
            case 12: {
                return this.W((int)var2_2);
            }
            case 11: {
                if (var2_2 == 12L) {
                    var2_2 = 0L;
                }
            }
            case 10: {
                var16_5 = var2_2 - (long)(this.e % 12);
                return this.P(var16_5);
            }
            case 9: {
                return this.Q(var2_2 - (long)(60 * this.e + this.f));
            }
            case 8: {
                var13_6 = (int)var2_2;
                if (this.f == var13_6) {
                    return this;
                }
                j$.time.temporal.j.MINUTE_OF_HOUR.K(var13_6);
                return j.G(this.e, var13_6, this.g, this.h);
            }
            case 7: {
                return this.S(var2_2 - (long)this.U());
            }
            case 6: {
                var10_7 = (int)var2_2;
                if (this.g == var10_7) {
                    return this;
                }
                j$.time.temporal.j.SECOND_OF_MINUTE.K(var10_7);
                return j.G(this.e, this.f, var10_7, this.h);
            }
            case 5: {
                var8_8 = 1000000L;
                ** GOTO lbl48
            }
            case 4: {
                var7_9 = 1000000 * (int)var2_2;
                return this.X(var7_9);
            }
            case 3: {
                var8_8 = 1000L;
lbl48: // 2 sources:
                var2_2 *= var8_8;
                ** GOTO lbl53
            }
            case 2: {
                var7_9 = 1000 * (int)var2_2;
                return this.X(var7_9);
            }
lbl53: // 2 sources:
            case 1: {
                return j.O(var2_2);
            }
            case 0: 
        }
        var7_9 = (int)var2_2;
        return this.X(var7_9);
    }

    public j W(int n2) {
        if (this.e == n2) {
            return this;
        }
        j$.time.temporal.j.HOUR_OF_DAY.K(n2);
        return j.G(n2, this.f, this.g, this.h);
    }

    public j X(int n2) {
        if (this.h == n2) {
            return this;
        }
        j$.time.temporal.j.NANO_OF_SECOND.K(n2);
        return j.G(this.e, this.f, this.g, n2);
    }

    @Override
    public Temporal e(l object) {
        if (!(object instanceof j)) {
            object = ((j.LocalDate)object).v((Temporal)this);
        }
        return (j)object;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof j) {
            j j2 = (j)object;
            return this.e == j2.e && this.f == j2.f && this.g == j2.g && this.h == j2.h;
        }
        return false;
    }

    @Override
    public long f(o o2) {
        if (o2 instanceof j$.time.temporal.j) {
            if (o2 == j$.time.temporal.j.NANO_OF_DAY) {
                return this.T();
            }
            if (o2 == j$.time.temporal.j.MICRO_OF_DAY) {
                return this.T() / 1000L;
            }
            return this.J(o2);
        }
        return o2.v(this);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public Temporal g(long var1_1, TemporalUnit var3_2) {
        if (var3_2 instanceof ChronoUnit == false) return (j)var3_2.p(this, var1_1);
        switch (((ChronoUnit)var3_2).ordinal()) {
            default: {
                var8_3 = new StringBuilder();
                var8_3.append("Unsupported unit: ");
                var8_3.append((Object)var3_2);
                throw new q(var8_3.toString());
            }
            case 6: {
                var1_1 = 12L * (var1_1 % 2L);
            }
            case 5: {
                return this.P(var1_1);
            }
            case 4: {
                return this.Q(var1_1);
            }
            case 3: {
                return this.S(var1_1);
            }
            case 2: {
                var4_4 = var1_1 % 86400000L;
                var6_5 = 1000000L;
                ** GOTO lbl23
            }
            case 1: {
                var4_4 = var1_1 % 86400000000L;
                var6_5 = 1000L;
lbl23: // 2 sources:
                var1_1 = var4_4 * var6_5;
            }
            case 0: 
        }
        return this.R(var1_1);
    }

    @Override
    public boolean h(o o2) {
        if (o2 instanceof j$.time.temporal.j) {
            return o2.e();
        }
        return o2 != null && o2.F(this);
    }

    public int hashCode() {
        long l2 = this.T();
        return (int)(l2 ^ l2 >>> 32);
    }

    @Override
    public int i(o o2) {
        if (o2 instanceof j$.time.temporal.j) {
            return this.J(o2);
        }
        return e.f(this, o2);
    }

    @Override
    public r p(o o2) {
        return e.k(this, o2);
    }

    @Override
    public Object t(TemporalQuery temporalQuery) {
        if (temporalQuery != d.a && temporalQuery != f.a && temporalQuery != i.a) {
            if (temporalQuery == j$.time.temporal.e.a) {
                return null;
            }
            if (temporalQuery == h.a) {
                return this;
            }
            if (temporalQuery == c.a) {
                return null;
            }
            if (temporalQuery == j$.time.temporal.g.a) {
                return ChronoUnit.NANOS;
            }
            return temporalQuery.queryFrom(this);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        int n2;
        StringBuilder stringBuilder = new StringBuilder(18);
        byte by = this.e;
        byte by2 = this.f;
        byte by3 = this.g;
        int n3 = this.h;
        String string = by < 10 ? "0" : "";
        stringBuilder.append(string);
        stringBuilder.append((int)by);
        String string2 = ":0";
        String string3 = by2 < 10 ? string2 : ":";
        stringBuilder.append(string3);
        stringBuilder.append((int)by2);
        if (by3 <= 0) {
            if (n3 <= 0) return stringBuilder.toString();
        }
        if (by3 >= 10) {
            string2 = ":";
        }
        stringBuilder.append(string2);
        stringBuilder.append((int)by3);
        if (n3 <= 0) return stringBuilder.toString();
        stringBuilder.append('.');
        int n4 = 1000000;
        if (n3 % n4 == 0) {
            n2 = 1000 + n3 / n4;
        } else {
            if (n3 % 1000 == 0) {
                n3 /= 1000;
            } else {
                n4 = 1000000000;
            }
            n2 = n3 + n4;
        }
        stringBuilder.append(Integer.toString((int)n2).substring(1));
        return stringBuilder.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        j j2 = j.H(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) return temporalUnit.between(this, j2);
        long l2 = j2.T() - this.T();
        switch (((ChronoUnit)temporalUnit).ordinal()) {
            long l3;
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported unit: ");
                stringBuilder.append((Object)temporalUnit);
                throw new q(stringBuilder.toString());
            }
            case 6: {
                l3 = 43200000000000L;
                do {
                    return l2 / l3;
                    break;
                } while (true);
            }
            case 5: {
                l3 = 3600000000000L;
                return l2 / l3;
            }
            case 4: {
                l3 = 60000000000L;
                return l2 / l3;
            }
            case 3: {
                l3 = 1000000000L;
                return l2 / l3;
            }
            case 2: {
                l3 = 1000000L;
                return l2 / l3;
            }
            case 1: {
                l3 = 1000L;
                return l2 / l3;
            }
            case 0: 
        }
        return l2;
    }

    @Override
    public Temporal v(Temporal temporal) {
        return temporal.b(j$.time.temporal.j.NANO_OF_DAY, this.T());
    }
}

