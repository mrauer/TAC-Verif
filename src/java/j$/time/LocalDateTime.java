/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Objects
 */
package j$.time;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.OffsetDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.ZonedDateTime;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.e;
import j$.time.f;
import j$.time.format.DateTimeFormatter;
import j$.time.g;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.j;
import j$.time.temporal.l;
import j$.time.temporal.o;
import j$.time.temporal.r;
import j$.time.zone.c;
import java.io.Serializable;
import java.util.Objects;

public final class LocalDateTime
implements Temporal,
l,
ChronoLocalDateTime<LocalDate>,
Serializable {
    public static final LocalDateTime a = LocalDateTime.P(LocalDate.a, j$.time.j.a);
    public static final LocalDateTime b = LocalDateTime.P(LocalDate.b, j$.time.j.b);
    private final LocalDate c;
    private final j$.time.j d;

    private LocalDateTime(LocalDate localDate, j$.time.j j3) {
        this.c = localDate;
        this.d = j3;
    }

    private int F(LocalDateTime localDateTime) {
        int n3 = this.c.F(localDateTime.c);
        if (n3 == 0) {
            n3 = this.d.F(localDateTime.d);
        }
        return n3;
    }

    public static LocalDateTime G(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime)temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime)temporalAccessor).M();
        }
        if (temporalAccessor instanceof OffsetDateTime) {
            return ((OffsetDateTime)temporalAccessor).H();
        }
        try {
            LocalDateTime localDateTime = new LocalDateTime(LocalDate.H(temporalAccessor), j$.time.j.H(temporalAccessor));
            return localDateTime;
        }
        catch (g g3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to obtain LocalDateTime from TemporalAccessor: ");
            stringBuilder.append((Object)temporalAccessor);
            stringBuilder.append(" of type ");
            stringBuilder.append(temporalAccessor.getClass().getName());
            throw new g(stringBuilder.toString(), (Throwable)g3);
        }
    }

    public static LocalDateTime N(int n3, int n4, int n5, int n6, int n7) {
        return new LocalDateTime(LocalDate.of(n3, n4, n5), j$.time.j.M(n6, n7));
    }

    public static LocalDateTime O(int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        return new LocalDateTime(LocalDate.of(n3, n4, n5), j$.time.j.N(n6, n7, n8, n9));
    }

    public static LocalDateTime P(LocalDate localDate, j$.time.j j3) {
        Objects.requireNonNull((Object)localDate, (String)"date");
        Objects.requireNonNull((Object)j3, (String)"time");
        return new LocalDateTime(localDate, j3);
    }

    public static LocalDateTime Q(long l3, int n3, ZoneOffset zoneOffset) {
        Objects.requireNonNull((Object)zoneOffset, (String)"offset");
        j j3 = j.NANO_OF_SECOND;
        long l4 = n3;
        j3.K(l4);
        long l5 = l3 + (long)zoneOffset.L();
        long l6 = e.E(l5, 86400L);
        int n4 = (int)e.D(l5, 86400L);
        return new LocalDateTime(LocalDate.ofEpochDay(l6), j$.time.j.O(l4 + 1000000000L * (long)n4));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private LocalDateTime W(LocalDate localDate, long l3, long l4, long l5, long l6, int n3) {
        j$.time.j j3;
        LocalDate localDate2 = localDate;
        if ((l6 | (l5 | (l3 | l4))) == 0L) {
            j3 = this.d;
            do {
                return this.Z(localDate2, j3);
                break;
            } while (true);
        }
        long l7 = l6 / 86400000000000L + l5 / 86400L + l4 / 1440L + l3 / 24L;
        long l8 = n3;
        long l9 = l7 * l8;
        long l10 = l6 % 86400000000000L + 1000000000L * (l5 % 86400L) + 60000000000L * (l4 % 1440L) + 3600000000000L * (l3 % 24L);
        long l11 = this.d.T();
        long l12 = l11 + l10 * l8;
        long l13 = l9 + e.E(l12, 86400000000000L);
        long l14 = e.D(l12, 86400000000000L);
        j3 = l14 == l11 ? this.d : j$.time.j.O(l14);
        localDate2 = localDate2.plusDays(l13);
        return this.Z(localDate2, j3);
    }

    private LocalDateTime Z(LocalDate localDate, j$.time.j j3) {
        if (this.c == localDate && this.d == j3) {
            return this;
        }
        return new LocalDateTime(localDate, j3);
    }

    public static LocalDateTime now() {
        f f3 = f.d();
        Instant instant = f3.b();
        ZoneOffset zoneOffset = f3.a().G().d(instant);
        return LocalDateTime.Q(instant.J(), instant.K(), zoneOffset);
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.b;
        Objects.requireNonNull((Object)dateTimeFormatter, (String)"formatter");
        return (LocalDateTime)dateTimeFormatter.parse(charSequence, j$.time.c.a);
    }

    public int H() {
        return this.d.K();
    }

    public int J() {
        return this.d.L();
    }

    public int K() {
        return this.c.O();
    }

    public boolean L(ChronoLocalDateTime chronoLocalDateTime) {
        boolean bl;
        block6 : {
            block5 : {
                if (chronoLocalDateTime instanceof LocalDateTime) {
                    int n3 = this.F((LocalDateTime)chronoLocalDateTime);
                    boolean bl2 = false;
                    if (n3 > 0) {
                        bl2 = true;
                    }
                    return bl2;
                }
                long l3 = this.d().toEpochDay() LCMP chronoLocalDateTime.d().toEpochDay();
                if (l3 > 0) break block5;
                bl = false;
                if (l3 != false) break block6;
                long l4 = this.c().T() LCMP chronoLocalDateTime.c().T();
                bl = false;
                if (l4 <= 0) break block6;
            }
            bl = true;
        }
        return bl;
    }

    public boolean M(ChronoLocalDateTime chronoLocalDateTime) {
        boolean bl;
        block6 : {
            block5 : {
                if (chronoLocalDateTime instanceof LocalDateTime) {
                    int n3 = this.F((LocalDateTime)chronoLocalDateTime);
                    boolean bl2 = false;
                    if (n3 < 0) {
                        bl2 = true;
                    }
                    return bl2;
                }
                long l3 = this.d().toEpochDay() LCMP chronoLocalDateTime.d().toEpochDay();
                if (l3 < 0) break block5;
                bl = false;
                if (l3 != false) break block6;
                long l4 = this.c().T() LCMP chronoLocalDateTime.c().T();
                bl = false;
                if (l4 >= 0) break block6;
            }
            bl = true;
        }
        return bl;
    }

    public LocalDateTime R(long l3, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (((ChronoUnit)temporalUnit).ordinal()) {
                default: {
                    return this.Z(this.c.U(l3, temporalUnit), this.d);
                }
                case 6: {
                    return this.S(l3 / 256L).T(12L * (l3 % 256L));
                }
                case 5: {
                    return this.T(l3);
                }
                case 4: {
                    return this.W(this.c, 0L, l3, 0L, 0L, 1);
                }
                case 3: {
                    return this.V(l3);
                }
                case 2: {
                    return this.S(l3 / 86400000L).U(1000000L * (l3 % 86400000L));
                }
                case 1: {
                    return this.S(l3 / 86400000000L).U(1000L * (l3 % 86400000000L));
                }
                case 0: 
            }
            return this.U(l3);
        }
        return (LocalDateTime)temporalUnit.p(this, l3);
    }

    public LocalDateTime S(long l3) {
        return this.Z(this.c.plusDays(l3), this.d);
    }

    public LocalDateTime T(long l3) {
        return this.W(this.c, l3, 0L, 0L, 0L, 1);
    }

    public LocalDateTime U(long l3) {
        return this.W(this.c, 0L, 0L, 0L, l3, 1);
    }

    public LocalDateTime V(long l3) {
        return this.W(this.c, 0L, 0L, l3, 0L, 1);
    }

    public /* synthetic */ long X(ZoneOffset zoneOffset) {
        return e.l(this, zoneOffset);
    }

    public LocalDate Y() {
        return this.c;
    }

    @Override
    public j$.time.chrono.e a() {
        Objects.requireNonNull((Object)this.c);
        return j$.time.chrono.g.a;
    }

    public LocalDateTime a0(l l3) {
        if (l3 instanceof LocalDate) {
            return this.Z((LocalDate)l3, this.d);
        }
        if (l3 instanceof j$.time.j) {
            return this.Z(this.c, (j$.time.j)l3);
        }
        if (l3 instanceof LocalDateTime) {
            return (LocalDateTime)l3;
        }
        return (LocalDateTime)l3.v(this);
    }

    public ZonedDateTime atZone(ZoneId zoneId) {
        return ZonedDateTime.J(this, zoneId, null);
    }

    public LocalDateTime b0(o o3, long l3) {
        if (o3 instanceof j) {
            if (((j)o3).e()) {
                return this.Z(this.c, this.d.V(o3, l3));
            }
            return this.Z(this.c.a0(o3, l3), this.d);
        }
        return (LocalDateTime)o3.G(this, l3);
    }

    @Override
    public j$.time.j c() {
        return this.d;
    }

    @Override
    public int compareTo(ChronoLocalDateTime chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return this.F((LocalDateTime)chronoLocalDateTime);
        }
        return e.e(this, chronoLocalDateTime);
    }

    @Override
    public ChronoLocalDate d() {
        return this.c;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime)object;
            return this.c.equals(localDateTime.c) && this.d.equals(localDateTime.d);
        }
        return false;
    }

    @Override
    public long f(o o3) {
        if (o3 instanceof j) {
            if (((j)o3).e()) {
                return this.d.f(o3);
            }
            return this.c.f(o3);
        }
        return o3.v(this);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull((Object)dateTimeFormatter, (String)"formatter");
        return dateTimeFormatter.a(this);
    }

    @Override
    public boolean h(o o3) {
        boolean bl = o3 instanceof j;
        boolean bl2 = true;
        if (bl) {
            j j3 = (j)o3;
            if (!j3.i()) {
                if (j3.e()) {
                    return bl2;
                }
                bl2 = false;
            }
            return bl2;
        }
        if (o3 != null && o3.F(this)) {
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode() ^ this.d.hashCode();
    }

    @Override
    public int i(o o3) {
        if (o3 instanceof j) {
            if (((j)o3).e()) {
                return this.d.i(o3);
            }
            return this.c.i(o3);
        }
        return e.f(this, o3);
    }

    public LocalDateTime minusMinutes(long l3) {
        return this.W(this.c, 0L, l3, 0L, 0L, -1);
    }

    @Override
    public r p(o o3) {
        if (o3 instanceof j) {
            if (((j)o3).e()) {
                j$.time.j j3 = this.d;
                Objects.requireNonNull((Object)j3);
                return e.k(j3, o3);
            }
            return this.c.p(o3);
        }
        return o3.H(this);
    }

    @Override
    public Object t(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.c.a) {
            return this.c;
        }
        return e.i(this, temporalQuery);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c.toString());
        stringBuilder.append('T');
        stringBuilder.append(this.d.toString());
        return stringBuilder.toString();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public long until(Temporal var1_1, TemporalUnit var2_2) {
        block14 : {
            var3_3 = LocalDateTime.G(var1_1);
            if (var2_2 instanceof ChronoUnit == false) return var2_2.between(this, var3_3);
            if (!var2_2.e()) break block14;
            var8_4 = this.c.G(var3_3.c);
            var10_5 = var8_4 LCMP 0L;
            if (var10_5 == false) {
                return this.d.until(var3_3.d, var2_2);
            }
            var11_6 = var3_3.d.T() - this.d.T();
            if (var10_5 > 0) {
                var13_7 = var8_4 - 1L;
                var15_8 = var11_6 + 86400000000000L;
            } else {
                var13_7 = var8_4 + 1L;
                var15_8 = var11_6 - 86400000000000L;
            }
            switch (((ChronoUnit)var2_2).ordinal()) {
                default: {
                    return e.C(var13_7, var15_8);
                }
                case 6: {
                    var17_9 = e.F(var13_7, 2L);
                    var19_10 = 43200000000000L;
                    ** GOTO lbl41
                }
                case 5: {
                    var17_9 = e.F(var13_7, 24L);
                    var19_10 = 3600000000000L;
                    ** GOTO lbl41
                }
                case 4: {
                    var17_9 = e.F(var13_7, 1440L);
                    var19_10 = 60000000000L;
                    ** GOTO lbl41
                }
                case 3: {
                    var17_9 = e.F(var13_7, 86400L);
                    var19_10 = 1000000000L;
                    ** GOTO lbl41
                }
                case 2: {
                    var17_9 = e.F(var13_7, 86400000L);
                    var19_10 = 1000000L;
                    ** GOTO lbl41
                }
                case 1: {
                    var17_9 = e.F(var13_7, 86400000000L);
                    var19_10 = 1000L;
lbl41: // 6 sources:
                    var13_7 = var17_9;
                    return e.C(var13_7, var15_8 /= var19_10);
                }
                case 0: 
            }
            var13_7 = e.F(var13_7, 86400000000000L);
            return e.C(var13_7, var15_8);
        }
        var4_11 = var3_3.c;
        var5_12 = var4_11.isAfter(this.c);
        var6_13 = true;
        if (var5_12 && (var7_14 = var3_3.d.F(this.d) < 0 ? var6_13 : false)) {
            var4_11 = var4_11.minusDays(1L);
            return this.c.until(var4_11, var2_2);
        }
        if (var4_11.isBefore(this.c) == false) return this.c.until(var4_11, var2_2);
        if (var3_3.d.F(this.d) <= 0) {
            var6_13 = false;
        }
        if (var6_13 == false) return this.c.until(var4_11, var2_2);
        var4_11 = var4_11.plusDays(1L);
        return this.c.until(var4_11, var2_2);
    }

    @Override
    public Temporal v(Temporal temporal) {
        return e.d(this, temporal);
    }
}

