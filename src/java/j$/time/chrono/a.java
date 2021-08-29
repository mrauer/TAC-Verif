/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDate
 *  j$.time.LocalDateTime
 *  j$.time.chrono.b
 *  j$.time.chrono.d
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 */
package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.e;
import j$.time.f;
import j$.time.format.k;
import j$.time.g;
import j$.time.h;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.r;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class a
implements j$.time.chrono.e {
    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new Locale("ja", "JP", "JP");
    }

    protected a() {
    }

    @Override
    public ChronoLocalDate A(f f2) {
        j.LocalDate localDate = j.LocalDate.S((f)f2);
        (j$.time.chrono.g)this;
        return j.LocalDate.H((TemporalAccessor)localDate);
    }

    @Override
    public ChronoZonedDateTime B(Instant instant, ZoneId zoneId) {
        return j.d.G((j$.time.chrono.e)this, (Instant)instant, (ZoneId)zoneId);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    ChronoLocalDate F(Map var1_1, k var2_2) {
        block8 : {
            var3_3 = j$.time.temporal.j.YEAR_OF_ERA;
            var4_4 = (Long)var1_1.remove((Object)var3_3);
            if (var4_4 == null) {
                var5_15 = j$.time.temporal.j.ERA;
                if (var1_1.containsKey((Object)var5_15) == false) return null;
                var5_15.p().b((Long)var1_1.get((Object)var5_15), var5_15);
                return null;
            }
            var8_5 = j$.time.temporal.j.ERA;
            var9_6 = (Long)var1_1.remove((Object)var8_5);
            var10_7 = var2_2 != k.LENIENT ? var3_3.p().a(var4_4, var3_3) : e.B(var4_4);
            if (var9_6 != null) {
                var17_8 = var8_5.p().a(var9_6, var8_5);
                if (var17_8 != 0) {
                    if (var17_8 != 1) {
                        var19_10 = new StringBuilder();
                        var19_10.append("Invalid era: ");
                        var19_10.append(var17_8);
                        throw new g(var19_10.toString());
                    }
                    var18_9 = j$.time.chrono.h.CE;
                } else {
                    var18_9 = j$.time.chrono.h.BCE;
                }
                this.e(var1_1, j$.time.temporal.j.YEAR, ((j$.time.chrono.g)this).H(var18_9, var10_7));
                return null;
            }
            var11_11 = j$.time.temporal.j.YEAR;
            if (!var1_1.containsKey((Object)var11_11)) break block8;
            var13_12 = j.LocalDate.T((int)var11_11.p().a((Long)var1_1.get((Object)var11_11), var11_11), (int)1).M();
            ** GOTO lbl37
        }
        if (var2_2 == k.STRICT) {
            var1_1.put((Object)var3_3, (Object)var4_4);
            return null;
        }
        var12_13 = Arrays.asList((Object[])j$.time.chrono.h.values());
        if (var12_13.isEmpty()) {
            var14_14 = var10_7;
        } else {
            var13_12 = (j$.time.chrono.f)var12_13.get(var12_13.size() - 1);
lbl37: // 2 sources:
            var14_14 = ((j$.time.chrono.g)this).H(var13_12, var10_7);
        }
        this.e(var1_1, var11_11, var14_14);
        return null;
    }

    void e(Map map, j$.time.temporal.j j2, long l2) {
        Long l3 = (Long)map.get((Object)j2);
        if (l3 != null && l3 != l2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Conflict found: ");
            stringBuilder.append((Object)j2);
            stringBuilder.append(" ");
            stringBuilder.append((Object)l3);
            stringBuilder.append(" differs from ");
            stringBuilder.append((Object)j2);
            stringBuilder.append(" ");
            stringBuilder.append(l2);
            throw new g(stringBuilder.toString());
        }
        map.put((Object)j2, (Object)l2);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof a) {
            return this.j((a)object) == 0;
        }
        return false;
    }

    public int hashCode() {
        return 72805 ^ this.getClass().hashCode();
    }

    public ChronoLocalDate i() {
        return this.A(f.d());
    }

    @Override
    public int j(j$.time.chrono.e e2) {
        return "ISO".compareTo(e2.m());
    }

    ChronoLocalDate p(ChronoLocalDate chronoLocalDate, long l2, long l3, long l4) {
        j.LocalDate localDate;
        block4 : {
            long l5;
            block3 : {
                ChronoUnit chronoUnit;
                block2 : {
                    ChronoUnit chronoUnit2 = ChronoUnit.MONTHS;
                    j.LocalDate localDate2 = ((j.LocalDate)chronoLocalDate).U(l2, (TemporalUnit)chronoUnit2);
                    chronoUnit = ChronoUnit.WEEKS;
                    localDate = localDate2.U(l3, (TemporalUnit)chronoUnit);
                    if (l4 <= 7L) break block2;
                    l5 = l4 - 1L;
                    localDate = localDate.U(l5 / 7L, (TemporalUnit)chronoUnit);
                    break block3;
                }
                if (l4 >= 1L) break block4;
                localDate = localDate.U(e.G(l4, 7L) / 7L, (TemporalUnit)chronoUnit);
                l5 = l4 + 6L;
            }
            l4 = 1L + l5 % 7L;
        }
        return localDate.b0(m.a(h.G((int)l4)));
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public ChronoZonedDateTime r(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = ZoneId.F(temporalAccessor);
        {
            catch (g g2) {
                StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("Unable to obtain ChronoZonedDateTime from TemporalAccessor: ");
                stringBuilder.append((Object)temporalAccessor.getClass());
                throw new g(stringBuilder.toString(), (Throwable)g2);
            }
        }
        try {
            return this.B(Instant.H(temporalAccessor), zoneId);
        }
        catch (g g2) {
            return j.d.F((j.b)j.b.F((j$.time.chrono.e)this, (Temporal)this.u(temporalAccessor)), (ZoneId)zoneId, null);
        }
    }

    void t(Map map, k k2) {
        j$.time.temporal.j j2 = j$.time.temporal.j.PROLEPTIC_MONTH;
        Long l2 = (Long)map.remove((Object)j2);
        if (l2 != null) {
            if (k2 != k.LENIENT) {
                j2.K(l2);
            }
            ChronoLocalDate chronoLocalDate = this.i().b(j$.time.temporal.j.DAY_OF_MONTH, 1L).b(j2, l2);
            j$.time.temporal.j j3 = j$.time.temporal.j.MONTH_OF_YEAR;
            this.e(map, j3, chronoLocalDate.i(j3));
            j$.time.temporal.j j4 = j$.time.temporal.j.YEAR;
            this.e(map, j4, chronoLocalDate.i(j4));
        }
    }

    public String toString() {
        return "ISO";
    }

    @Override
    public ChronoLocalDateTime u(TemporalAccessor temporalAccessor) {
        try {
            (j$.time.chrono.g)this;
            j.LocalDateTime localDateTime = j.LocalDateTime.P((j.LocalDate)j.LocalDate.H((TemporalAccessor)temporalAccessor), (j$.time.j)j$.time.j.H(temporalAccessor));
            return localDateTime;
        }
        catch (g g2) {
            StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("Unable to obtain ChronoLocalDateTime from TemporalAccessor: ");
            stringBuilder.append((Object)temporalAccessor.getClass());
            throw new g(stringBuilder.toString(), (Throwable)g2);
        }
    }

    ChronoLocalDate v(Map map, k k2) {
        j$.time.temporal.j j2 = j$.time.temporal.j.YEAR;
        int n2 = j2.p().a((Long)map.remove((Object)j2), j2);
        if (k2 == k.LENIENT) {
            long l2 = e.G((Long)map.remove((Object)j$.time.temporal.j.MONTH_OF_YEAR), 1L);
            long l3 = e.G((Long)map.remove((Object)j$.time.temporal.j.DAY_OF_MONTH), 1L);
            return j.LocalDate.of((int)n2, (int)1, (int)1).U(l2, (TemporalUnit)ChronoUnit.MONTHS).U(l3, (TemporalUnit)ChronoUnit.DAYS);
        }
        j$.time.temporal.j j3 = j$.time.temporal.j.MONTH_OF_YEAR;
        int n3 = j3.p().a((Long)map.remove((Object)j3), j3);
        j$.time.temporal.j j4 = j$.time.temporal.j.DAY_OF_MONTH;
        int n4 = j4.p().a((Long)map.remove((Object)j4), j4);
        if (k2 == k.SMART) {
            try {
                j.LocalDate localDate = j.LocalDate.of((int)n2, (int)n3, (int)n4);
                return localDate;
            }
            catch (g g2) {
                return j.LocalDate.of((int)n2, (int)n3, (int)1).b0((l)j$.time.temporal.a.a);
            }
        }
        return j.LocalDate.of((int)n2, (int)n3, (int)n4);
    }

    @Override
    public ChronoLocalDate z(Map map, k k2) {
        j$.time.temporal.j j2 = j$.time.temporal.j.EPOCH_DAY;
        if (map.containsKey((Object)j2)) {
            return j.LocalDate.ofEpochDay((long)((Long)map.remove((Object)j2)));
        }
        this.t(map, k2);
        ChronoLocalDate chronoLocalDate = this.F(map, k2);
        if (chronoLocalDate != null) {
            return chronoLocalDate;
        }
        j$.time.temporal.j j3 = j$.time.temporal.j.YEAR;
        if (map.containsKey((Object)j3)) {
            j$.time.temporal.j j4;
            j$.time.temporal.j j5 = j$.time.temporal.j.MONTH_OF_YEAR;
            if (map.containsKey((Object)j5)) {
                if (map.containsKey((Object)j$.time.temporal.j.DAY_OF_MONTH)) {
                    return this.v(map, k2);
                }
                j$.time.temporal.j j6 = j$.time.temporal.j.ALIGNED_WEEK_OF_MONTH;
                if (map.containsKey((Object)j6)) {
                    j$.time.temporal.j j7 = j$.time.temporal.j.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                    if (map.containsKey((Object)j7)) {
                        int n2 = j3.p().a((Long)map.remove((Object)j3), j3);
                        if (k2 == k.LENIENT) {
                            long l2 = e.G((Long)map.remove((Object)j5), 1L);
                            long l3 = e.G((Long)map.remove((Object)j6), 1L);
                            long l4 = e.G((Long)map.remove((Object)j7), 1L);
                            return j.LocalDate.of((int)n2, (int)1, (int)1).U(l2, (TemporalUnit)ChronoUnit.MONTHS).U(l3, (TemporalUnit)ChronoUnit.WEEKS).U(l4, (TemporalUnit)ChronoUnit.DAYS);
                        }
                        int n3 = j5.p().a((Long)map.remove((Object)j5), j5);
                        int n4 = j6.p().a((Long)map.remove((Object)j6), j6);
                        int n5 = j7.p().a((Long)map.remove((Object)j7), j7);
                        j.LocalDate localDate = j.LocalDate.of((int)n2, (int)n3, (int)1).U((long)(7 * (n4 - 1) + (n5 - 1)), (TemporalUnit)ChronoUnit.DAYS);
                        if (k2 == k.STRICT) {
                            if (localDate.i((o)j5) == n3) {
                                return localDate;
                            }
                            throw new g("Strict mode rejected resolved date as it is in a different month");
                        }
                        return localDate;
                    }
                    j$.time.temporal.j j8 = j$.time.temporal.j.DAY_OF_WEEK;
                    if (map.containsKey((Object)j8)) {
                        int n6 = j3.p().a((Long)map.remove((Object)j3), j3);
                        if (k2 == k.LENIENT) {
                            long l5 = e.G((Long)map.remove((Object)j5), 1L);
                            long l6 = e.G((Long)map.remove((Object)j6), 1L);
                            long l7 = e.G((Long)map.remove((Object)j8), 1L);
                            return this.p((ChronoLocalDate)j.LocalDate.of((int)n6, (int)1, (int)1), l5, l6, l7);
                        }
                        int n7 = j5.p().a((Long)map.remove((Object)j5), j5);
                        int n8 = j6.p().a((Long)map.remove((Object)j6), j6);
                        int n9 = j8.p().a((Long)map.remove((Object)j8), j8);
                        ChronoLocalDate chronoLocalDate2 = j.LocalDate.of((int)n6, (int)n7, (int)1).U((long)(7 * (n8 - 1)), (TemporalUnit)ChronoUnit.DAYS).b0(m.a(h.G(n9)));
                        if (k2 == k.STRICT) {
                            if (((j.LocalDate)chronoLocalDate2).i((o)j5) == n7) {
                                return chronoLocalDate2;
                            }
                            throw new g("Strict mode rejected resolved date as it is in a different month");
                        }
                        return chronoLocalDate2;
                    }
                }
            }
            if (map.containsKey((Object)(j4 = j$.time.temporal.j.DAY_OF_YEAR))) {
                int n10 = j3.p().a((Long)map.remove((Object)j3), j3);
                if (k2 == k.LENIENT) {
                    long l8 = e.G((Long)map.remove((Object)j4), 1L);
                    return j.LocalDate.T((int)n10, (int)1).U(l8, (TemporalUnit)ChronoUnit.DAYS);
                }
                return j.LocalDate.T((int)n10, (int)j4.p().a((Long)map.remove((Object)j4), j4));
            }
            j$.time.temporal.j j9 = j$.time.temporal.j.ALIGNED_WEEK_OF_YEAR;
            if (map.containsKey((Object)j9)) {
                j$.time.temporal.j j10 = j$.time.temporal.j.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                if (map.containsKey((Object)j10)) {
                    int n11 = j3.p().a((Long)map.remove((Object)j3), j3);
                    if (k2 == k.LENIENT) {
                        long l9 = e.G((Long)map.remove((Object)j9), 1L);
                        long l10 = e.G((Long)map.remove((Object)j10), 1L);
                        return j.LocalDate.T((int)n11, (int)1).U(l9, (TemporalUnit)ChronoUnit.WEEKS).U(l10, (TemporalUnit)ChronoUnit.DAYS);
                    }
                    int n12 = j9.p().a((Long)map.remove((Object)j9), j9);
                    int n13 = j10.p().a((Long)map.remove((Object)j10), j10);
                    j.LocalDate localDate = j.LocalDate.T((int)n11, (int)1).U((long)(7 * (n12 - 1) + (n13 - 1)), (TemporalUnit)ChronoUnit.DAYS);
                    if (k2 == k.STRICT) {
                        if (localDate.i((o)j3) == n11) {
                            return localDate;
                        }
                        throw new g("Strict mode rejected resolved date as it is in a different year");
                    }
                    return localDate;
                }
                j$.time.temporal.j j11 = j$.time.temporal.j.DAY_OF_WEEK;
                if (map.containsKey((Object)j11)) {
                    int n14 = j3.p().a((Long)map.remove((Object)j3), j3);
                    if (k2 == k.LENIENT) {
                        long l11 = e.G((Long)map.remove((Object)j9), 1L);
                        long l12 = e.G((Long)map.remove((Object)j11), 1L);
                        return this.p((ChronoLocalDate)j.LocalDate.T((int)n14, (int)1), 0L, l11, l12);
                    }
                    int n15 = j9.p().a((Long)map.remove((Object)j9), j9);
                    int n16 = j11.p().a((Long)map.remove((Object)j11), j11);
                    ChronoLocalDate chronoLocalDate3 = j.LocalDate.T((int)n14, (int)1).U((long)(7 * (n15 - 1)), (TemporalUnit)ChronoUnit.DAYS).b0(m.a(h.G(n16)));
                    if (k2 == k.STRICT) {
                        if (((j.LocalDate)chronoLocalDate3).i((o)j3) == n14) {
                            return chronoLocalDate3;
                        }
                        throw new g("Strict mode rejected resolved date as it is in a different year");
                    }
                    return chronoLocalDate3;
                }
            }
        }
        return null;
    }
}

