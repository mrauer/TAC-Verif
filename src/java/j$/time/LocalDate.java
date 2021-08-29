/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package j$.time;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.Period;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.ZonedDateTime;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.f;
import j$.time.format.DateTimeFormatter;
import j$.time.k;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.c;
import j$.time.temporal.d;
import j$.time.temporal.e;
import j$.time.temporal.f;
import j$.time.temporal.g;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.l;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.zone.a;
import java.io.Serializable;
import java.util.Objects;

public final class LocalDate
implements Temporal,
l,
ChronoLocalDate,
Serializable {
    public static final LocalDate a = LocalDate.of(-999999999, 1, 1);
    public static final LocalDate b = LocalDate.of(999999999, 12, 31);
    private final int c;
    private final short d;
    private final short e;

    private LocalDate(int n3, int n4, int n5) {
        this.c = n3;
        this.d = (short)n4;
        this.e = (short)n5;
    }

    public static LocalDate H(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull((Object)temporalAccessor, (String)"temporal");
        LocalDate localDate = (LocalDate)temporalAccessor.t(c.a);
        if (localDate != null) {
            return localDate;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to obtain LocalDate from TemporalAccessor: ");
        stringBuilder.append((Object)temporalAccessor);
        stringBuilder.append(" of type ");
        stringBuilder.append(temporalAccessor.getClass().getName());
        throw new j$.time.g(stringBuilder.toString());
    }

    private int J(o o3) {
        switch (((j$.time.temporal.j)o3).ordinal()) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append((Object)o3);
                throw new q(stringBuilder.toString());
            }
            case 27: {
                return this.c >= 1;
            }
            case 26: {
                return this.c;
            }
            case 24: {
                throw new q("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            }
            case 23: {
                return this.d;
            }
            case 22: {
                return 1 + (this.L() - 1) / 7;
            }
            case 20: {
                throw new q("Invalid field 'EpochDay' for get() method, use getLong() instead");
            }
            case 17: {
                return 1 + (this.L() - 1) % 7;
            }
            case 16: {
                return 1 + (this.e - 1) % 7;
            }
            case 15: {
                return this.K().F();
            }
            case 25: {
                int n3 = this.c;
                if (n3 >= 1) {
                    return n3;
                }
                return 1 - n3;
            }
            case 21: {
                return 1 + (this.e - 1) / 7;
            }
            case 19: {
                return this.L();
            }
            case 18: 
        }
        return this.e;
    }

    private long N() {
        return 12L * (long)this.c + (long)this.d - 1L;
    }

    private long R(LocalDate localDate) {
        long l3 = 32L * this.N() + (long)this.e;
        return (32L * localDate.N() + (long)localDate.e - l3) / 32L;
    }

    public static LocalDate S(j$.time.f f3) {
        Instant instant = f3.b();
        ZoneOffset zoneOffset = f3.a().G().d(instant);
        return LocalDate.ofEpochDay(j$.time.e.E(instant.J() + (long)zoneOffset.L(), 86400L));
    }

    public static LocalDate T(int n3, int n4) {
        j$.time.temporal.j j3 = j$.time.temporal.j.YEAR;
        long l3 = n3;
        j3.K(l3);
        j$.time.temporal.j.DAY_OF_YEAR.K(n4);
        boolean bl = j$.time.chrono.g.a.G(l3);
        if (n4 == 366 && !bl) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid date 'DayOfYear 366' as '");
            stringBuilder.append(n3);
            stringBuilder.append("' is not a leap year");
            throw new j$.time.g(stringBuilder.toString());
        }
        k k3 = k.J(1 + (n4 - 1) / 31);
        if (n4 > -1 + (k3.F(bl) + k3.H(bl))) {
            k3 = k3.K(1L);
        }
        int n5 = 1 + (n4 - k3.F(bl));
        return new LocalDate(n3, k3.G(), n5);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static LocalDate Y(int n3, int n4, int n5) {
        int n6;
        if (n4 != 2) {
            if (n4 != 4 && n4 != 6 && n4 != 9 && n4 != 11) {
                return new LocalDate(n3, n4, n5);
            }
            n6 = 30;
        } else {
            n6 = j$.time.chrono.g.a.G(n3) ? 29 : 28;
        }
        n5 = Math.min((int)n5, (int)n6);
        return new LocalDate(n3, n4, n5);
    }

    public static LocalDate now() {
        return LocalDate.S(j$.time.f.d());
    }

    public static LocalDate of(int n3, int n4, int n5) {
        j$.time.temporal.j j3 = j$.time.temporal.j.YEAR;
        long l3 = n3;
        j3.K(l3);
        j$.time.temporal.j.MONTH_OF_YEAR.K(n4);
        j$.time.temporal.j.DAY_OF_MONTH.K(n5);
        int n6 = 28;
        if (n5 > n6) {
            if (n4 != 2) {
                n6 = n4 != 4 && n4 != 6 && n4 != 9 && n4 != 11 ? 31 : 30;
            } else if (j$.time.chrono.g.a.G(l3)) {
                n6 = 29;
            }
            if (n5 > n6) {
                if (n5 == 29) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid date 'February 29' as '");
                    stringBuilder.append(n3);
                    stringBuilder.append("' is not a leap year");
                    throw new j$.time.g(stringBuilder.toString());
                }
                StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("Invalid date '");
                stringBuilder.append(k.J(n4).name());
                stringBuilder.append(" ");
                stringBuilder.append(n5);
                stringBuilder.append("'");
                throw new j$.time.g(stringBuilder.toString());
            }
        }
        return new LocalDate(n3, n4, n5);
    }

    public static LocalDate ofEpochDay(long l3) {
        long l4;
        long l5 = l3 + 719528L - 60L;
        if (l5 < 0L) {
            long l6 = (l5 + 1L) / 146097L - 1L;
            l4 = l6 * 400L;
            l5 += 146097L * -l6;
        } else {
            l4 = 0L;
        }
        long l7 = (591L + l5 * 400L) / 146097L;
        long l8 = l5 - (l7 * 365L + l7 / 4L - l7 / 100L + l7 / 400L);
        if (l8 < 0L) {
            l8 = l5 - (365L * --l7 + l7 / 4L - l7 / 100L + l7 / 400L);
        }
        long l9 = l8;
        long l10 = l7 + l4;
        int n3 = (int)l9;
        int n4 = (2 + n3 * 5) / 153;
        int n5 = 1 + (n4 + 2) % 12;
        int n6 = 1 + (n3 - (5 + n4 * 306) / 10);
        long l11 = l10 + (long)(n4 / 10);
        return new LocalDate(j$.time.temporal.j.YEAR.J(l11), n5, n6);
    }

    public static LocalDate parse(CharSequence charSequence) {
        return LocalDate.parse(charSequence, DateTimeFormatter.a);
    }

    public static LocalDate parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull((Object)dateTimeFormatter, (String)"formatter");
        return (LocalDate)dateTimeFormatter.parse(charSequence, j$.time.d.a);
    }

    @Override
    public ChronoLocalDate C(long l3, TemporalUnit temporalUnit) {
        if (l3 == Long.MIN_VALUE) {
            return this.U(Long.MAX_VALUE, temporalUnit).U(1L, temporalUnit);
        }
        return this.U(-l3, temporalUnit);
    }

    @Override
    public int D() {
        if (this.P()) {
            return 366;
        }
        return 365;
    }

    @Override
    public int E(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return this.F((LocalDate)chronoLocalDate);
        }
        int n3 = Long.compare((long)this.toEpochDay(), (long)chronoLocalDate.toEpochDay());
        if (n3 == 0) {
            this.a();
            n3 = j$.time.chrono.g.a.j(chronoLocalDate.a());
        }
        return n3;
    }

    int F(LocalDate localDate) {
        int n3 = this.c - localDate.c;
        if (n3 == 0 && (n3 = this.d - localDate.d) == 0) {
            n3 = this.e - localDate.e;
        }
        return n3;
    }

    long G(LocalDate localDate) {
        return localDate.toEpochDay() - this.toEpochDay();
    }

    public j$.time.h K() {
        return j$.time.h.G(1 + (int)j$.time.e.D(3L + this.toEpochDay(), 7L));
    }

    public int L() {
        return -1 + (k.J(this.d).F(this.P()) + this.e);
    }

    public j.f M() {
        if (this.c >= 1) {
            return j$.time.chrono.h.CE;
        }
        return j$.time.chrono.h.BCE;
    }

    public int O() {
        return this.c;
    }

    public boolean P() {
        return j$.time.chrono.g.a.G(this.c);
    }

    public int Q() {
        short s3 = this.d;
        if (s3 != 2) {
            if (s3 != 4 && s3 != 6 && s3 != 9 && s3 != 11) {
                return 31;
            }
            return 30;
        }
        if (this.P()) {
            return 29;
        }
        return 28;
    }

    public LocalDate U(long l3, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (((ChronoUnit)temporalUnit).ordinal()) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported unit: ");
                    stringBuilder.append((Object)temporalUnit);
                    throw new q(stringBuilder.toString());
                }
                case 14: {
                    j$.time.temporal.j j3 = j$.time.temporal.j.ERA;
                    return this.a0(j3, j$.time.e.C(this.f(j3), l3));
                }
                case 13: {
                    return this.X(j$.time.e.F(l3, 1000L));
                }
                case 12: {
                    return this.X(j$.time.e.F(l3, 100L));
                }
                case 11: {
                    return this.X(j$.time.e.F(l3, 10L));
                }
                case 10: {
                    return this.X(l3);
                }
                case 9: {
                    return this.V(l3);
                }
                case 8: {
                    return this.W(l3);
                }
                case 7: 
            }
            return this.plusDays(l3);
        }
        return (LocalDate)temporalUnit.p(this, l3);
    }

    public LocalDate V(long l3) {
        if (l3 == 0L) {
            return this;
        }
        long l4 = l3 + (12L * (long)this.c + (long)(-1 + this.d));
        return LocalDate.Y(j$.time.temporal.j.YEAR.J(j$.time.e.E(l4, 12L)), 1 + (int)j$.time.e.D(l4, 12L), this.e);
    }

    public LocalDate W(long l3) {
        return this.plusDays(j$.time.e.F(l3, 7L));
    }

    public LocalDate X(long l3) {
        if (l3 == 0L) {
            return this;
        }
        return LocalDate.Y(j$.time.temporal.j.YEAR.J(l3 + (long)this.c), this.d, this.e);
    }

    public Period Z(ChronoLocalDate chronoLocalDate) {
        LocalDate localDate = LocalDate.H(chronoLocalDate);
        long l3 = localDate.N() - this.N();
        int n3 = localDate.e - this.e;
        long l4 = l3 LCMP 0L;
        if (l4 > 0 && n3 < 0) {
            LocalDate localDate2 = this.V(--l3);
            n3 = (int)(localDate.toEpochDay() - localDate2.toEpochDay());
        } else if (l4 < 0 && n3 > 0) {
            ++l3;
            n3 -= localDate.Q();
        }
        long l5 = l3 / 12L;
        int n4 = (int)(l3 % 12L);
        return Period.c(j$.time.e.B(l5), n4, n3);
    }

    @Override
    public j$.time.chrono.e a() {
        return j$.time.chrono.g.a;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public LocalDate a0(o var1_1, long var2_2) {
        if (var1_1 instanceof j$.time.temporal.j == false) return (LocalDate)var1_1.G(this, var2_2);
        var4_3 = (j$.time.temporal.j)var1_1;
        var4_3.K(var2_2);
        switch (var4_3.ordinal()) {
            default: {
                var16_4 = new StringBuilder();
                var16_4.append("Unsupported field: ");
                var16_4.append((Object)var1_1);
                throw new q(var16_4.toString());
            }
            case 27: {
                if (this.f(j$.time.temporal.j.ERA) != var2_2) return this.d0(1 - this.c);
                return this;
            }
            case 24: {
                return this.V(var2_2 - this.N());
            }
            case 23: {
                var13_5 = (int)var2_2;
                if (this.d == var13_5) {
                    return this;
                }
                j$.time.temporal.j.MONTH_OF_YEAR.K(var13_5);
                return LocalDate.Y(this.c, var13_5, this.e);
            }
            case 22: {
                var9_6 = j$.time.temporal.j.ALIGNED_WEEK_OF_YEAR;
                return this.W(var2_2 - this.f(var9_6));
            }
            case 20: {
                return LocalDate.ofEpochDay(var2_2);
            }
            case 17: {
                var12_7 = j$.time.temporal.j.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                ** GOTO lbl31
            }
            case 16: {
                var12_7 = j$.time.temporal.j.ALIGNED_DAY_OF_WEEK_IN_MONTH;
lbl31: // 2 sources:
                var10_8 = this.f(var12_7);
                return this.plusDays(var2_2 - var10_8);
            }
            case 15: {
                var10_8 = this.K().F();
                return this.plusDays(var2_2 - var10_8);
            }
            case 25: {
                if (this.c < 1) {
                    var2_2 = 1L - var2_2;
                }
            }
            case 26: {
                return this.d0((int)var2_2);
            }
            case 21: {
                var9_6 = j$.time.temporal.j.ALIGNED_WEEK_OF_MONTH;
                return this.W(var2_2 - this.f(var9_6));
            }
            case 19: {
                var8_9 = (int)var2_2;
                if (this.L() != var8_9) return LocalDate.T(this.c, var8_9);
                return this;
            }
            case 18: 
        }
        var7_10 = (int)var2_2;
        if (this.e != var7_10) return LocalDate.of(this.c, this.d, var7_10);
        return this;
    }

    public ZonedDateTime atStartOfDay(ZoneId zoneId) {
        a a4;
        Objects.requireNonNull((Object)zoneId, (String)"zone");
        LocalDateTime localDateTime = LocalDateTime.P(this, j$.time.j.c);
        if (!(zoneId instanceof ZoneOffset) && (a4 = zoneId.G().f(localDateTime)) != null && a4.H()) {
            localDateTime = a4.e();
        }
        return ZonedDateTime.J(localDateTime, zoneId, null);
    }

    public ChronoLocalDate b0(l object) {
        if (!(object instanceof LocalDate)) {
            object = object.v(this);
        }
        return (LocalDate)object;
    }

    public LocalDate c0(int n3) {
        if (this.L() == n3) {
            return this;
        }
        return LocalDate.T(this.c, n3);
    }

    public LocalDate d0(int n3) {
        if (this.c == n3) {
            return this;
        }
        j$.time.temporal.j.YEAR.K(n3);
        return LocalDate.Y(n3, this.d, this.e);
    }

    @Override
    public Temporal e(l object) {
        if (!(object instanceof LocalDate)) {
            object = ((LocalDate)object).v(this);
        }
        return (LocalDate)object;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof LocalDate) {
            return this.F((LocalDate)object) == 0;
        }
        return false;
    }

    @Override
    public long f(o o3) {
        if (o3 instanceof j$.time.temporal.j) {
            if (o3 == j$.time.temporal.j.EPOCH_DAY) {
                return this.toEpochDay();
            }
            if (o3 == j$.time.temporal.j.PROLEPTIC_MONTH) {
                return this.N();
            }
            return this.J(o3);
        }
        return o3.v(this);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull((Object)dateTimeFormatter, (String)"formatter");
        return dateTimeFormatter.a(this);
    }

    @Override
    public boolean h(o o3) {
        if (o3 instanceof j$.time.temporal.j) {
            return o3.i();
        }
        return o3 != null && o3.F(this);
    }

    @Override
    public int hashCode() {
        int n3 = this.c;
        short s3 = this.d;
        short s4 = this.e;
        return n3 & -2048 ^ s4 + ((n3 << 11) + (s3 << 6));
    }

    @Override
    public int i(o o3) {
        if (o3 instanceof j$.time.temporal.j) {
            return this.J(o3);
        }
        return j$.time.e.f(this, o3);
    }

    public boolean isAfter(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return this.F((LocalDate)chronoLocalDate) > 0;
        }
        return this.toEpochDay() > chronoLocalDate.toEpochDay();
    }

    public boolean isBefore(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return this.F((LocalDate)chronoLocalDate) < 0;
        }
        return this.toEpochDay() < chronoLocalDate.toEpochDay();
    }

    public boolean isEqual(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return this.F((LocalDate)chronoLocalDate) == 0;
        }
        return this.toEpochDay() == chronoLocalDate.toEpochDay();
    }

    public LocalDate minusDays(long l3) {
        if (l3 == Long.MIN_VALUE) {
            return this.plusDays(Long.MAX_VALUE).plusDays(1L);
        }
        return this.plusDays(-l3);
    }

    @Override
    public r p(o o3) {
        if (o3 instanceof j$.time.temporal.j) {
            j$.time.temporal.j j3 = (j$.time.temporal.j)o3;
            if (j3.i()) {
                int n3;
                int n4 = j3.ordinal();
                if (n4 != 18) {
                    if (n4 != 19) {
                        if (n4 != 21) {
                            if (n4 != 25) {
                                return o3.p();
                            }
                            long l3 = this.c <= 0 ? 1000000000L : 999999999L;
                            return r.i(1L, l3);
                        }
                        long l4 = k.J(this.d) == k.FEBRUARY && !this.P() ? 4L : 5L;
                        return r.i(1L, l4);
                    }
                    n3 = this.P() ? 366 : 365;
                } else {
                    n3 = this.Q();
                }
                return r.i(1L, n3);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported field: ");
            stringBuilder.append((Object)o3);
            throw new q(stringBuilder.toString());
        }
        return o3.H(this);
    }

    public LocalDate plusDays(long l3) {
        if (l3 == 0L) {
            return this;
        }
        return LocalDate.ofEpochDay(j$.time.e.C(this.toEpochDay(), l3));
    }

    @Override
    public j.ChronoLocalDateTime s(j$.time.j j3) {
        return LocalDateTime.P(this, j3);
    }

    @Override
    public Object t(TemporalQuery temporalQuery) {
        if (temporalQuery == c.a) {
            return this;
        }
        f f3 = f.a;
        Object object = null;
        if (temporalQuery != f3) {
            i i3 = i.a;
            object = null;
            if (temporalQuery != i3) {
                if (temporalQuery == e.a) {
                    return null;
                }
                if (temporalQuery == h.a) {
                    return null;
                }
                if (temporalQuery == d.a) {
                    this.a();
                    return j$.time.chrono.g.a;
                }
                if (temporalQuery == g.a) {
                    return ChronoUnit.DAYS;
                }
                object = temporalQuery.queryFrom(this);
            }
        }
        return object;
    }

    @Override
    public long toEpochDay() {
        long l3 = this.c;
        long l4 = this.d;
        long l5 = 0L + 365L * l3;
        long l6 = l3 >= 0L ? l5 + ((3L + l3) / 4L - (99L + l3) / 100L + (l3 + 399L) / 400L) : l5 - (l3 / -4L - l3 / -100L + l3 / -400L);
        long l7 = l6 + (367L * l4 - 362L) / 12L + (long)(-1 + this.e);
        if (l4 > 2L) {
            --l7;
            if (!this.P()) {
                --l7;
            }
        }
        return l7 - 719528L;
    }

    @Override
    public String toString() {
        int n3 = this.c;
        short s3 = this.d;
        short s4 = this.e;
        int n4 = Math.abs((int)n3);
        StringBuilder stringBuilder = new StringBuilder(10);
        if (n4 < 1000) {
            int n5;
            if (n3 < 0) {
                stringBuilder.append(n3 - 10000);
                n5 = 1;
            } else {
                stringBuilder.append(n3 + 10000);
                n5 = 0;
            }
            stringBuilder.deleteCharAt(n5);
        } else {
            if (n3 > 9999) {
                stringBuilder.append('+');
            }
            stringBuilder.append(n3);
        }
        String string = "-0";
        String string2 = s3 < 10 ? string : "-";
        stringBuilder.append(string2);
        stringBuilder.append((int)s3);
        if (s4 >= 10) {
            string = "-";
        }
        stringBuilder.append(string);
        stringBuilder.append((int)s4);
        return stringBuilder.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        LocalDate localDate = LocalDate.H(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) return temporalUnit.between(this, localDate);
        switch (((ChronoUnit)temporalUnit).ordinal()) {
            long l3;
            long l4;
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported unit: ");
                stringBuilder.append((Object)temporalUnit);
                throw new q(stringBuilder.toString());
            }
            case 14: {
                j$.time.temporal.j j3 = j$.time.temporal.j.ERA;
                return localDate.f(j3) - this.f(j3);
            }
            case 13: {
                l4 = this.R(localDate);
                l3 = 12000L;
                do {
                    return l4 / l3;
                    break;
                } while (true);
            }
            case 12: {
                l4 = this.R(localDate);
                l3 = 1200L;
                return l4 / l3;
            }
            case 11: {
                l4 = this.R(localDate);
                l3 = 120L;
                return l4 / l3;
            }
            case 10: {
                l4 = this.R(localDate);
                l3 = 12L;
                return l4 / l3;
            }
            case 9: {
                return this.R(localDate);
            }
            case 8: {
                l4 = this.G(localDate);
                l3 = 7L;
                return l4 / l3;
            }
            case 7: 
        }
        return this.G(localDate);
    }

    @Override
    public Temporal v(Temporal temporal) {
        return temporal.b(j$.time.temporal.j.EPOCH_DAY, this.toEpochDay());
    }

    @Override
    public ChronoLocalDate y(n n3) {
        if (n3 instanceof Period) {
            Period period = (Period)n3;
            return this.V(period.e()).plusDays(period.getDays());
        }
        Objects.requireNonNull((Object)n3, (String)"amountToAdd");
        return (LocalDate)((Period)n3).a(this);
    }
}

