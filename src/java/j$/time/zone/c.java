/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDate
 *  j$.time.LocalDateTime
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.List
 *  java.util.Objects
 *  java.util.TimeZone
 *  java.util.concurrent.ConcurrentMap
 */
package j$.time.zone;

import j$.time.Instant;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.e;
import j$.time.f;
import j$.time.zone.a;
import j$.time.zone.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

public final class c
implements Serializable {
    private static final long[] a = new long[0];
    private static final b[] b = new b[0];
    private static final j.LocalDateTime[] c = new j.LocalDateTime[0];
    private static final a[] d = new a[0];
    private final long[] e;
    private final ZoneOffset[] f;
    private final long[] g;
    private final j.LocalDateTime[] h;
    private final ZoneOffset[] i;
    private final b[] j;
    private final TimeZone k;
    private final transient ConcurrentMap l = new ConcurrentHashMap();

    private c(ZoneOffset zoneOffset) {
        ZoneOffset[] arrzoneOffset = new ZoneOffset[1];
        this.f = arrzoneOffset;
        arrzoneOffset[0] = zoneOffset;
        long[] arrl = a;
        this.e = arrl;
        this.g = arrl;
        this.h = c;
        this.i = arrzoneOffset;
        this.j = b;
        this.k = null;
    }

    c(TimeZone timeZone) {
        ZoneOffset[] arrzoneOffset = new ZoneOffset[1];
        this.f = arrzoneOffset;
        arrzoneOffset[0] = c.k(timeZone.getRawOffset());
        long[] arrl = a;
        this.e = arrl;
        this.g = arrl;
        this.h = c;
        this.i = arrzoneOffset;
        this.j = b;
        this.k = timeZone;
    }

    private Object a(j.LocalDateTime localDateTime, a a2) {
        j.LocalDateTime localDateTime2 = a2.i();
        boolean bl = a2.H();
        boolean bl2 = localDateTime.M((ChronoLocalDateTime)localDateTime2);
        if (bl) {
            if (bl2) {
                return a2.F();
            }
            if (localDateTime.M((ChronoLocalDateTime)a2.e())) {
                return a2;
            }
            return a2.v();
        }
        if (!bl2) {
            return a2.v();
        }
        if (localDateTime.M((ChronoLocalDateTime)a2.e())) {
            return a2.F();
        }
        return a2;
    }

    private a[] b(int n2) {
        Integer n3 = n2;
        a[] arra = (a[])this.l.get((Object)n3);
        if (arra != null) {
            return arra;
        }
        if (this.k != null) {
            if (n2 < 1800) {
                return d;
            }
            long l2 = e.l((ChronoLocalDateTime)j.LocalDateTime.N((int)(n2 - 1), (int)12, (int)31, (int)0, (int)0), this.f[0]);
            TimeZone timeZone = this.k;
            long l3 = 1000L;
            int n4 = timeZone.getOffset(l2 * l3);
            long l4 = 31968000L + l2;
            Object[] arrobject = d;
            while (l2 < l4) {
                long l5;
                long l6;
                long l7 = 7776000L + l2;
                TimeZone timeZone2 = this.k;
                long l8 = l2;
                if (n4 != timeZone2.getOffset(l7 * l3)) {
                    l2 = l8;
                    while (l7 - l2 > 1L) {
                        long l9 = l7 + l2;
                        long l10 = l4;
                        long l11 = e.E(l9, 2L);
                        TimeZone timeZone3 = this.k;
                        long l12 = l7;
                        if (timeZone3.getOffset(l11 * 1000L) == n4) {
                            l2 = l11;
                            l7 = l12;
                        } else {
                            l7 = l11;
                        }
                        l3 = 1000L;
                        l4 = l10;
                    }
                    l5 = l4;
                    long l13 = l7;
                    l6 = l3;
                    if (this.k.getOffset(l2 * l6) == n4) {
                        l2 = l13;
                    }
                    ZoneOffset zoneOffset = c.k(n4);
                    int n5 = this.k.getOffset(l2 * l6);
                    ZoneOffset zoneOffset2 = c.k(n5);
                    if (this.c(l2, zoneOffset2) == n2) {
                        a[] arra2 = (a[])Arrays.copyOf((Object[])arrobject, (int)(1 + arrobject.length));
                        arra2[-1 + arra2.length] = new a(l2, zoneOffset, zoneOffset2);
                        n4 = n5;
                        arrobject = arra2;
                    } else {
                        n4 = n5;
                    }
                } else {
                    l5 = l4;
                    l6 = l3;
                    l2 = l7;
                }
                l3 = l6;
                l4 = l5;
            }
            if (1916 <= n2 && n2 < 2100) {
                this.l.putIfAbsent((Object)n3, (Object)arrobject);
            }
            return arrobject;
        }
        b[] arrb = this.j;
        a[] arra3 = new a[arrb.length];
        if (arrb.length <= 0) {
            if (n2 < 2100) {
                this.l.putIfAbsent((Object)n3, (Object)arra3);
            }
            return arra3;
        }
        Objects.requireNonNull((Object)arrb[0]);
        throw null;
    }

    private int c(long l2, ZoneOffset zoneOffset) {
        return j.LocalDate.ofEpochDay((long)e.E(l2 + (long)zoneOffset.L(), 86400L)).O();
    }

    private Object e(j.LocalDateTime localDateTime) {
        j.LocalDateTime[] arrlocalDateTime;
        TimeZone timeZone = this.k;
        Object object = null;
        if (timeZone != null) {
            a[] arra = this.b(localDateTime.K());
            if (arra.length == 0) {
                return c.k(this.k.getOffset(1000L * e.l((ChronoLocalDateTime)localDateTime, this.f[0])));
            }
            for (a a2 : arra) {
                Object object2 = this.a(localDateTime, a2);
                if (!(object2 instanceof a)) {
                    if (object2.equals((Object)a2.F())) {
                        return object2;
                    }
                    object = object2;
                    continue;
                }
                return object2;
            }
            return object;
        }
        if (this.g.length == 0) {
            return this.f[0];
        }
        if (this.j.length > 0 && localDateTime.L((ChronoLocalDateTime)(arrlocalDateTime = this.h)[-1 + arrlocalDateTime.length])) {
            int n2;
            a[] arra = this.b(localDateTime.K());
            int n3 = arra.length;
            while (n2 < n3) {
                a a3 = arra[n2];
                Object object3 = this.a(localDateTime, a3);
                if (!(object3 instanceof a)) {
                    if (object3.equals((Object)a3.F())) {
                        return object3;
                    }
                    ++n2;
                    object = object3;
                    continue;
                }
                return object3;
            }
            return object;
        }
        int n4 = Arrays.binarySearch((Object[])this.h, (Object)localDateTime);
        if (n4 == -1) {
            return this.i[0];
        }
        if (n4 < 0) {
            n4 = -2 + -n4;
        } else {
            int n5;
            j.LocalDateTime localDateTime2;
            j.LocalDateTime[] arrlocalDateTime2 = this.h;
            if (n4 < -1 + arrlocalDateTime2.length && (localDateTime2 = arrlocalDateTime2[n4]).equals((Object)arrlocalDateTime2[n5 = n4 + 1])) {
                n4 = n5;
            }
        }
        if ((n4 & 1) == 0) {
            j.LocalDateTime[] arrlocalDateTime3 = this.h;
            j.LocalDateTime localDateTime3 = arrlocalDateTime3[n4];
            j.LocalDateTime localDateTime4 = arrlocalDateTime3[n4 + 1];
            ZoneOffset[] arrzoneOffset = this.i;
            int n6 = n4 / 2;
            ZoneOffset zoneOffset = arrzoneOffset[n6];
            ZoneOffset zoneOffset2 = arrzoneOffset[n6 + 1];
            if (zoneOffset2.L() > zoneOffset.L()) {
                return new a(localDateTime3, zoneOffset, zoneOffset2);
            }
            return new a(localDateTime4, zoneOffset, zoneOffset2);
        }
        return this.i[1 + n4 / 2];
    }

    public static c j(ZoneOffset zoneOffset) {
        return new c(zoneOffset);
    }

    private static ZoneOffset k(int n2) {
        return ZoneOffset.O(n2 / 1000);
    }

    public ZoneOffset d(Instant instant) {
        long[] arrl;
        TimeZone timeZone = this.k;
        if (timeZone != null) {
            return c.k(timeZone.getOffset(instant.R()));
        }
        int n2 = this.g.length;
        if (n2 == 0) {
            return this.f[0];
        }
        long l2 = instant.J();
        if (this.j.length > 0 && l2 > (arrl = this.g)[-1 + arrl.length]) {
            ZoneOffset[] arrzoneOffset = this.i;
            a[] arra = this.b(this.c(l2, arrzoneOffset[-1 + arrzoneOffset.length]));
            a a2 = null;
            for (int i2 = 0; i2 < arra.length; ++i2) {
                a2 = arra[i2];
                if (l2 >= a2.I()) continue;
                return a2.F();
            }
            return a2.v();
        }
        int n3 = Arrays.binarySearch((long[])this.g, (long)l2);
        if (n3 < 0) {
            n3 = -2 + -n3;
        }
        return this.i[n3 + 1];
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof c) {
            c c2 = (c)object;
            return e.x((Object)this.k, (Object)c2.k) && Arrays.equals((long[])this.e, (long[])c2.e) && Arrays.equals((Object[])this.f, (Object[])c2.f) && Arrays.equals((long[])this.g, (long[])c2.g) && Arrays.equals((Object[])this.i, (Object[])c2.i) && Arrays.equals((Object[])this.j, (Object[])c2.j);
        }
        return false;
    }

    public a f(j.LocalDateTime localDateTime) {
        Object object = this.e(localDateTime);
        if (object instanceof a) {
            return (a)object;
        }
        return null;
    }

    public List g(j.LocalDateTime localDateTime) {
        Object object = this.e(localDateTime);
        if (object instanceof a) {
            return ((a)object).G();
        }
        return Collections.singletonList((Object)((ZoneOffset)object));
    }

    public boolean h(Instant instant) {
        ZoneOffset zoneOffset;
        TimeZone timeZone = this.k;
        if (timeZone != null) {
            zoneOffset = c.k(timeZone.getRawOffset());
        } else if (this.g.length == 0) {
            zoneOffset = this.f[0];
        } else {
            long l2 = instant.J();
            int n2 = Arrays.binarySearch((long[])this.e, (long)l2);
            if (n2 < 0) {
                n2 = -2 + -n2;
            }
            zoneOffset = this.f[n2 + 1];
        }
        return true ^ zoneOffset.equals(this.d(instant));
    }

    public int hashCode() {
        TimeZone timeZone = this.k;
        int n2 = timeZone != null ? timeZone.hashCode() : 0;
        return n2 ^ Arrays.hashCode((long[])this.e) ^ Arrays.hashCode((Object[])this.f) ^ Arrays.hashCode((long[])this.g) ^ Arrays.hashCode((Object[])this.i) ^ Arrays.hashCode((Object[])this.j);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean i() {
        block15 : {
            block19 : {
                block17 : {
                    block18 : {
                        block16 : {
                            var1_1 = this.k;
                            if (var1_1 == null) {
                                var2_37 = this.g.length;
                                var3_38 = false;
                                if (var2_37 != 0) return var3_38;
                                return true;
                            }
                            var4_2 = var1_1.useDaylightTime();
                            var5_3 = false;
                            if (var4_2 != false) return var5_3;
                            if (this.k.getDSTSavings() != 0) {
                                return false;
                            }
                            var6_4 = Instant.now();
                            if (this.k == null) break block16;
                            var27_5 = var6_4.J();
                            if (var6_4.K() > 0 && var27_5 < Long.MAX_VALUE) {
                                ++var27_5;
                            }
                            var29_6 = this.c(var27_5, this.d(var6_4));
                            var30_7 = this.b(var29_6);
                            break block17;
                        }
                        if (this.g.length != 0) break block18;
                        var7_9 = null;
                        break block15;
                    }
                    var8_21 = var6_4.J();
                    if (var6_4.K() > 0 && var8_21 < Long.MAX_VALUE) {
                        ++var8_21;
                    }
                    var10_22 = this.g;
                    var11_23 = var10_22[var10_22.length - 1];
                    if (this.j.length <= 0 || var8_21 <= var11_23) ** GOTO lbl-1000
                    var19_24 = this.i;
                    var20_25 = var19_24[var19_24.length - 1];
                    var21_26 = this.c(var8_21, var20_25);
                    var22_27 = this.b(var21_26);
                    break block19;
                }
                for (var31_8 = var30_7.length - 1; var31_8 >= 0; --var31_8) {
                    if (var27_5 <= var30_7[var31_8].I()) continue;
                    var7_9 = var30_7[var31_8];
                    break block15;
                }
                var7_9 = null;
                if (var29_6 <= 1800) break block15;
                var32_10 = this.b(var29_6 - 1);
                for (var33_11 = var32_10.length - 1; var33_11 >= 0; --var33_11) {
                    if (var27_5 <= var32_10[var33_11].I()) continue;
                    var7_9 = var32_10[var33_11];
                    break block15;
                }
                var34_12 = Math.min((long)(var27_5 - 31104000L), (long)(31968000L + f.e().c() / 1000L));
                var36_13 = this.k.getOffset(1000L * (var27_5 - 1L));
                var37_14 = 86400L * j.LocalDate.of((int)1800, (int)1, (int)1).toEpochDay();
                do {
                    var39_15 = var37_14 LCMP var34_12;
                    var7_9 = null;
                    if (var39_15 > 0) break block15;
                    var40_16 = this.k.getOffset(var34_12 * 1000L);
                    if (var36_13 != var40_16) {
                        var41_17 = this.c(var34_12, c.k(var40_16));
                        var42_18 = this.b(var41_17 + 1);
                        break;
                    }
                    var34_12 -= 7776000L;
                } while (true);
                for (var43_19 = var42_18.length - 1; var43_19 >= 0; --var43_19) {
                    if (var27_5 <= var42_18[var43_19].I()) continue;
                    var7_9 = var42_18[var43_19];
                    break block15;
                }
                var44_20 = this.b(var41_17);
                var7_9 = var44_20[var44_20.length - 1];
                break block15;
            }
            for (var23_28 = var22_27.length - 1; var23_28 >= 0; --var23_28) {
                if (var8_21 <= var22_27[var23_28].I()) continue;
                var7_9 = var22_27[var23_28];
                break block15;
            }
            var25_30 = var21_26 - 1;
            var24_29 = this.c(var11_23, var20_25);
            if (var25_30 > var24_29) {
                var26_31 = this.b(var25_30);
                var7_9 = var26_31[var26_31.length - 1];
            } else lbl-1000: // 2 sources:
            {
                if ((var13_32 = Arrays.binarySearch((long[])this.g, (long)var8_21)) < 0) {
                    var13_32 = -var13_32 - 1;
                }
                if (var13_32 <= 0) {
                    var7_9 = null;
                } else {
                    var14_33 = this.g;
                    var15_34 = var13_32 - 1;
                    var16_35 = var14_33[var15_34];
                    var18_36 = this.i;
                    var7_9 = new a(var16_35, var18_36[var15_34], var18_36[var13_32]);
                }
            }
        }
        var5_3 = false;
        if (var7_9 != null) return var5_3;
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder;
        if (this.k != null) {
            stringBuilder = j$.com.android.tools.r8.a.b("ZoneRules[timeZone=");
            stringBuilder.append(this.k.getID());
        } else {
            stringBuilder = j$.com.android.tools.r8.a.b("ZoneRules[currentStandardOffset=");
            ZoneOffset[] arrzoneOffset = this.f;
            stringBuilder.append((Object)arrzoneOffset[-1 + arrzoneOffset.length]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

