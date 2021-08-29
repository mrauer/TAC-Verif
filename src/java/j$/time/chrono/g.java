/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDate
 *  j$.time.LocalDateTime
 *  j$.time.ZonedDateTime
 *  java.io.Serializable
 *  java.lang.ClassCastException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 */
package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.a;
import j$.time.chrono.h;
import j$.time.e;
import j$.time.f;
import j$.time.k;
import j$.time.temporal.TemporalAccessor;
import java.io.Serializable;
import java.util.Map;

public final class g
extends a
implements Serializable {
    public static final g a = new g();

    private g() {
    }

    @Override
    public ChronoLocalDate A(f f2) {
        return j.LocalDate.H((TemporalAccessor)j.LocalDate.S((f)f2));
    }

    @Override
    public ChronoZonedDateTime B(Instant instant, ZoneId zoneId) {
        return j.ZonedDateTime.G((Instant)instant, (ZoneId)zoneId);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    ChronoLocalDate F(Map var1_1, j$.time.format.k var2_2) {
        block8 : {
            block10 : {
                block9 : {
                    var3_3 = j$.time.temporal.j.YEAR_OF_ERA;
                    var4_4 = (Long)var1_1.remove((Object)var3_3);
                    if (var4_4 == null) {
                        var5_13 = j$.time.temporal.j.ERA;
                        if (var1_1.containsKey((Object)var5_13) == false) return null;
                        var5_13.K((Long)var1_1.get((Object)var5_13));
                        return null;
                    }
                    if (var2_2 != j$.time.format.k.LENIENT) {
                        var3_3.K(var4_4);
                    }
                    if ((var8_5 = (Long)var1_1.remove((Object)j$.time.temporal.j.ERA)) != null) break block8;
                    var15_6 = j$.time.temporal.j.YEAR;
                    var16_7 = (Long)var1_1.get((Object)var15_6);
                    if (var2_2 != j$.time.format.k.STRICT) break block9;
                    if (var16_7 == null) {
                        var1_1.put((Object)var3_3, (Object)var4_4);
                        return null;
                    }
                    var20_8 = var16_7 LCMP 0L;
                    var17_9 = var4_4;
                    if (var20_8 <= 0) ** GOTO lbl24
                    break block10;
                }
                if (var16_7 != null && var16_7 <= 0L) {
                    var17_9 = var4_4;
lbl24: // 2 sources:
                    var17_9 = e.G(1L, var17_9);
                } else {
                    var17_9 = var4_4;
                }
            }
            this.e(var1_1, var15_6, var17_9);
            return null;
        }
        if (var8_5 == 1L) {
            var12_10 = j$.time.temporal.j.YEAR;
            var13_11 = var4_4;
        } else {
            if (var8_5 != 0L) {
                var9_12 = new StringBuilder();
                var9_12.append("Invalid value for era: ");
                var9_12.append((Object)var8_5);
                throw new j$.time.g(var9_12.toString());
            }
            var12_10 = j$.time.temporal.j.YEAR;
            var13_11 = e.G(1L, var4_4);
        }
        this.e(var1_1, var12_10, var13_11);
        return null;
    }

    public boolean G(long l2) {
        return (3L & l2) == 0L && (l2 % 100L != 0L || l2 % 400L == 0L);
    }

    public int H(j$.time.chrono.f f2, int n2) {
        if (f2 instanceof h) {
            if (f2 == h.CE) {
                return n2;
            }
            return 1 - n2;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override
    public ChronoLocalDate i() {
        return j.LocalDate.H((TemporalAccessor)j.LocalDate.S((f)f.d()));
    }

    @Override
    public String m() {
        return "ISO";
    }

    @Override
    public ChronoLocalDate o(TemporalAccessor temporalAccessor) {
        return j.LocalDate.H((TemporalAccessor)temporalAccessor);
    }

    @Override
    public ChronoZonedDateTime r(TemporalAccessor temporalAccessor) {
        return j.ZonedDateTime.F((TemporalAccessor)temporalAccessor);
    }

    @Override
    void t(Map map, j$.time.format.k k2) {
        j$.time.temporal.j j2 = j$.time.temporal.j.PROLEPTIC_MONTH;
        Long l2 = (Long)map.remove((Object)j2);
        if (l2 != null) {
            if (k2 != j$.time.format.k.LENIENT) {
                j2.K(l2);
            }
            this.e(map, j$.time.temporal.j.MONTH_OF_YEAR, 1L + e.D(l2, 12L));
            this.e(map, j$.time.temporal.j.YEAR, e.E(l2, 12L));
        }
    }

    @Override
    public ChronoLocalDateTime u(TemporalAccessor temporalAccessor) {
        return j.LocalDateTime.G((TemporalAccessor)temporalAccessor);
    }

    @Override
    ChronoLocalDate v(Map map, j$.time.format.k k2) {
        int n2;
        int n3;
        int n4;
        block2 : {
            int n5;
            block4 : {
                block3 : {
                    j$.time.temporal.j j2 = j$.time.temporal.j.YEAR;
                    n3 = j2.J((Long)map.remove((Object)j2));
                    j$.time.format.k k3 = j$.time.format.k.LENIENT;
                    boolean bl = true;
                    if (k2 == k3) {
                        long l2 = e.G((Long)map.remove((Object)j$.time.temporal.j.MONTH_OF_YEAR), 1L);
                        long l3 = e.G((Long)map.remove((Object)j$.time.temporal.j.DAY_OF_MONTH), 1L);
                        return j.LocalDate.of((int)n3, (int)bl, (int)bl).V(l2).plusDays(l3);
                    }
                    j$.time.temporal.j j3 = j$.time.temporal.j.MONTH_OF_YEAR;
                    n4 = j3.J((Long)map.remove((Object)j3));
                    j$.time.temporal.j j4 = j$.time.temporal.j.DAY_OF_MONTH;
                    n2 = j4.J((Long)map.remove((Object)j4));
                    if (k2 != j$.time.format.k.SMART) break block2;
                    if (n4 == 4 || n4 == 6 || n4 == 9 || n4 == 11) break block3;
                    if (n4 != 2) break block2;
                    k k4 = k.FEBRUARY;
                    long l4 = n3;
                    if ((3L & l4) != 0L || l4 % 100L == 0L && l4 % 400L != 0L) {
                        bl = false;
                    }
                    n5 = k4.H(bl);
                    break block4;
                }
                n5 = 30;
            }
            n2 = Math.min((int)n2, (int)n5);
        }
        return j.LocalDate.of((int)n3, (int)n4, (int)n2);
    }

    @Override
    public ChronoLocalDate x(int n2, int n3, int n4) {
        return j.LocalDate.of((int)n2, (int)n3, (int)n4);
    }

    @Override
    public ChronoLocalDate z(Map map, j$.time.format.k k2) {
        return (j.LocalDate)super.z(map, k2);
    }
}

