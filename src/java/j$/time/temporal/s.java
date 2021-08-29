/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  java.util.Objects
 *  java.util.concurrent.ConcurrentMap
 */
package j$.time.temporal;

import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.c;
import j$.time.e;
import j$.time.g;
import j$.time.h;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.j;
import j$.time.temporal.k;
import j$.time.temporal.o;
import j$.time.temporal.r;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

public final class s
implements Serializable {
    private static final ConcurrentMap a = new ConcurrentHashMap(4, 0.75f, 2);
    public static final TemporalUnit b;
    private final h c;
    private final int d;
    private final transient o e = a.h(this);
    private final transient o f = a.l(this);
    private final transient o g;
    private final transient o h;

    static {
        new s(h.MONDAY, 4);
        s.g(h.SUNDAY, 1);
        b = k.d;
    }

    private s(h h2, int n2) {
        a.n(this);
        this.g = a.m(this);
        this.h = a.k(this);
        Objects.requireNonNull((Object)h2, (String)"firstDayOfWeek");
        if (n2 >= 1 && n2 <= 7) {
            this.c = h2;
            this.d = n2;
            return;
        }
        throw new IllegalArgumentException("Minimal number of days is invalid");
    }

    public static s g(h h2, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(h2.toString());
        stringBuilder.append(n2);
        String string = stringBuilder.toString();
        ConcurrentMap concurrentMap = a;
        s s2 = (s)concurrentMap.get((Object)string);
        if (s2 == null) {
            concurrentMap.putIfAbsent((Object)string, (Object)new s(h2, n2));
            s2 = (s)concurrentMap.get((Object)string);
        }
        return s2;
    }

    public o d() {
        return this.e;
    }

    public h e() {
        return this.c;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof s) {
            return this.hashCode() == object.hashCode();
        }
        return false;
    }

    public int f() {
        return this.d;
    }

    public o h() {
        return this.h;
    }

    public int hashCode() {
        return 7 * this.c.ordinal() + this.d;
    }

    public o i() {
        return this.f;
    }

    public o j() {
        return this.g;
    }

    public String toString() {
        StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("WeekFields[");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(',');
        stringBuilder.append(this.d);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    static class a
    implements o {
        private static final r a = r.i(1L, 7L);
        private static final r b = r.k(0L, 1L, 4L, 6L);
        private static final r c = r.k(0L, 1L, 52L, 54L);
        private static final r d = r.j(1L, 52L, 53L);
        private final String e;
        private final s f;
        private final TemporalUnit g;
        private final TemporalUnit h;
        private final r i;

        private a(String string, s s2, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, r r2) {
            this.e = string;
            this.f = s2;
            this.g = temporalUnit;
            this.h = temporalUnit2;
            this.i = r2;
        }

        private int a(int n2, int n3) {
            return (n2 + 7 + (n3 - 1)) / 7;
        }

        private int b(TemporalAccessor temporalAccessor) {
            int n2 = this.f.e().F();
            return 1 + e.A(temporalAccessor.i(j.DAY_OF_WEEK) - n2, 7);
        }

        private int c(TemporalAccessor temporalAccessor) {
            int n2 = this.b(temporalAccessor);
            int n3 = temporalAccessor.i(j.YEAR);
            j j2 = j.DAY_OF_YEAR;
            int n4 = temporalAccessor.i(j2);
            int n5 = this.r(n4, n2);
            int n6 = this.a(n5, n4);
            if (n6 == 0) {
                return n3 - 1;
            }
            if (n6 >= this.a(n5, (int)temporalAccessor.p(j2).d() + this.f.f())) {
                ++n3;
            }
            return n3;
        }

        private long d(TemporalAccessor temporalAccessor) {
            int n2 = this.b(temporalAccessor);
            int n3 = temporalAccessor.i(j.DAY_OF_MONTH);
            return this.a(this.r(n3, n2), n3);
        }

        private int f(TemporalAccessor temporalAccessor) {
            int n2;
            int n3 = this.b(temporalAccessor);
            j j2 = j.DAY_OF_YEAR;
            int n4 = temporalAccessor.i(j2);
            int n5 = this.r(n4, n3);
            int n6 = this.a(n5, n4);
            if (n6 == 0) {
                return this.f(c.e(temporalAccessor).o(temporalAccessor).C(n4, ChronoUnit.DAYS));
            }
            if (n6 > 50 && n6 >= (n2 = this.a(n5, (int)temporalAccessor.p(j2).d() + this.f.f()))) {
                n6 = 1 + (n6 - n2);
            }
            return n6;
        }

        private long g(TemporalAccessor temporalAccessor) {
            int n2 = this.b(temporalAccessor);
            int n3 = temporalAccessor.i(j.DAY_OF_YEAR);
            return this.a(this.r(n3, n2), n3);
        }

        static a h(s s2) {
            a a2 = new a("DayOfWeek", s2, ChronoUnit.DAYS, ChronoUnit.WEEKS, a);
            return a2;
        }

        private ChronoLocalDate j(j$.time.chrono.e e2, int n2, int n3, int n4) {
            ChronoLocalDate chronoLocalDate = e2.x(n2, 1, 1);
            int n5 = this.r(1, this.b(chronoLocalDate));
            int n6 = Math.min((int)n3, (int)(this.a(n5, chronoLocalDate.D() + this.f.f()) - 1));
            return chronoLocalDate.g(-n5 + (n4 - 1) + 7 * (n6 - 1), ChronoUnit.DAYS);
        }

        static a k(s s2) {
            a a2 = new a("WeekBasedYear", s2, k.d, ChronoUnit.FOREVER, j.YEAR.p());
            return a2;
        }

        static a l(s s2) {
            a a2 = new a("WeekOfMonth", s2, ChronoUnit.WEEKS, ChronoUnit.MONTHS, b);
            return a2;
        }

        static a m(s s2) {
            a a2 = new a("WeekOfWeekBasedYear", s2, ChronoUnit.WEEKS, k.d, d);
            return a2;
        }

        static a n(s s2) {
            a a2 = new a("WeekOfYear", s2, ChronoUnit.WEEKS, ChronoUnit.YEARS, c);
            return a2;
        }

        private r o(TemporalAccessor temporalAccessor, o o2) {
            int n2 = this.b(temporalAccessor);
            int n3 = this.r(temporalAccessor.i(o2), n2);
            r r2 = temporalAccessor.p(o2);
            return r.i(this.a(n3, (int)r2.e()), this.a(n3, (int)r2.d()));
        }

        private r q(TemporalAccessor temporalAccessor) {
            j j2 = j.DAY_OF_YEAR;
            if (!temporalAccessor.h(j2)) {
                return c;
            }
            int n2 = this.b(temporalAccessor);
            int n3 = temporalAccessor.i(j2);
            int n4 = this.r(n3, n2);
            int n5 = this.a(n4, n3);
            if (n5 == 0) {
                return this.q(c.e(temporalAccessor).o(temporalAccessor).C(n3 + 7, ChronoUnit.DAYS));
            }
            int n6 = (int)temporalAccessor.p(j2).d();
            int n7 = this.a(n4, n6 + this.f.f());
            if (n5 >= n7) {
                return this.q(c.e(temporalAccessor).o(temporalAccessor).g(7 + (1 + (n6 - n3)), ChronoUnit.DAYS));
            }
            return r.i(1L, n7 - 1);
        }

        private int r(int n2, int n3) {
            int n4 = e.A(n2 - n3, 7);
            int n5 = -n4;
            if (n4 + 1 > this.f.f()) {
                n5 = 7 - n4;
            }
            return n5;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public boolean F(TemporalAccessor temporalAccessor) {
            j j2;
            if (!temporalAccessor.h(j.DAY_OF_WEEK)) return false;
            TemporalUnit temporalUnit = this.h;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return true;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                j2 = j.DAY_OF_MONTH;
                return temporalAccessor.h(j2);
            }
            if (temporalUnit != ChronoUnit.YEARS && temporalUnit != s.b) {
                if (temporalUnit != ChronoUnit.FOREVER) return false;
                j2 = j.YEAR;
                return temporalAccessor.h(j2);
            }
            j2 = j.DAY_OF_YEAR;
            return temporalAccessor.h(j2);
        }

        @Override
        public Temporal G(Temporal temporal, long l2) {
            int n2;
            int n3 = this.i.a(l2, this);
            if (n3 == (n2 = temporal.i(this))) {
                return temporal;
            }
            if (this.h == ChronoUnit.FOREVER) {
                int n4 = temporal.i(this.f.e);
                int n5 = temporal.i(this.f.g);
                return this.j(c.e(temporal), (int)l2, n5, n4);
            }
            return temporal.g(n3 - n2, this.g);
        }

        @Override
        public r H(TemporalAccessor temporalAccessor) {
            TemporalUnit temporalUnit = this.h;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return this.i;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                return this.o(temporalAccessor, j.DAY_OF_MONTH);
            }
            if (temporalUnit == ChronoUnit.YEARS) {
                return this.o(temporalAccessor, j.DAY_OF_YEAR);
            }
            if (temporalUnit == s.b) {
                return this.q(temporalAccessor);
            }
            if (temporalUnit == ChronoUnit.FOREVER) {
                return j.YEAR.p();
            }
            StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("unreachable, rangeUnit: ");
            stringBuilder.append((Object)this.h);
            stringBuilder.append(", this: ");
            stringBuilder.append((Object)this);
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Override
        public boolean e() {
            return false;
        }

        @Override
        public boolean i() {
            return true;
        }

        @Override
        public r p() {
            return this.i;
        }

        @Override
        public TemporalAccessor t(Map map, TemporalAccessor temporalAccessor, j$.time.format.k k2) {
            long l2 = (Long)map.get((Object)this);
            int n2 = e.B(l2);
            TemporalUnit temporalUnit = this.h;
            ChronoUnit chronoUnit = ChronoUnit.WEEKS;
            if (temporalUnit == chronoUnit) {
                int n3 = this.i.a(l2, this);
                long l3 = 1 + e.A(this.f.e().F() - 1 + (n3 - 1), 7);
                map.remove((Object)this);
                map.put((Object)j.DAY_OF_WEEK, (Object)l3);
            } else {
                j j2 = j.DAY_OF_WEEK;
                if (map.containsKey((Object)j2)) {
                    int n4 = 1 + e.A(j2.J((Long)map.get((Object)j2)) - this.f.e().F(), 7);
                    j$.time.chrono.e e2 = c.e(temporalAccessor);
                    j j3 = j.YEAR;
                    if (map.containsKey((Object)j3)) {
                        j j4;
                        int n5 = j3.J((Long)map.get((Object)j3));
                        TemporalUnit temporalUnit2 = this.h;
                        ChronoUnit chronoUnit2 = ChronoUnit.MONTHS;
                        if (temporalUnit2 == chronoUnit2 && map.containsKey((Object)(j4 = j.MONTH_OF_YEAR))) {
                            ChronoLocalDate chronoLocalDate;
                            long l4 = (Long)map.get((Object)j4);
                            long l5 = n2;
                            if (k2 == j$.time.format.k.LENIENT) {
                                ChronoLocalDate chronoLocalDate2 = e2.x(n5, 1, 1).g(e.G(l4, 1L), chronoUnit2);
                                long l6 = e.G(l5, this.d(chronoLocalDate2));
                                int n6 = n4 - this.b(chronoLocalDate2);
                                chronoLocalDate = chronoLocalDate2.g(e.C(e.F(l6, 7L), n6), ChronoUnit.DAYS);
                            } else {
                                ChronoLocalDate chronoLocalDate3 = e2.x(n5, j4.J(l4), 1);
                                int n7 = (int)((long)this.i.a(l5, this) - this.d(chronoLocalDate3));
                                ChronoLocalDate chronoLocalDate4 = chronoLocalDate3.g(n4 - this.b(chronoLocalDate3) + n7 * 7, ChronoUnit.DAYS);
                                if (k2 == j$.time.format.k.STRICT && chronoLocalDate4.f(j4) != l4) {
                                    throw new g("Strict mode rejected resolved date as it is in a different month");
                                }
                                chronoLocalDate = chronoLocalDate4;
                            }
                            map.remove((Object)this);
                            map.remove((Object)j3);
                            map.remove((Object)j4);
                            map.remove((Object)j2);
                            return chronoLocalDate;
                        }
                        if (this.h == ChronoUnit.YEARS) {
                            ChronoLocalDate chronoLocalDate;
                            long l7 = n2;
                            ChronoLocalDate chronoLocalDate5 = e2.x(n5, 1, 1);
                            if (k2 == j$.time.format.k.LENIENT) {
                                long l8 = e.G(l7, this.g(chronoLocalDate5));
                                int n8 = n4 - this.b(chronoLocalDate5);
                                chronoLocalDate = chronoLocalDate5.g(e.C(e.F(l8, 7L), n8), ChronoUnit.DAYS);
                            } else {
                                int n9 = (int)((long)this.i.a(l7, this) - this.g(chronoLocalDate5));
                                ChronoLocalDate chronoLocalDate6 = chronoLocalDate5.g(n4 - this.b(chronoLocalDate5) + n9 * 7, ChronoUnit.DAYS);
                                if (k2 == j$.time.format.k.STRICT && chronoLocalDate6.f(j3) != (long)n5) {
                                    throw new g("Strict mode rejected resolved date as it is in a different year");
                                }
                                chronoLocalDate = chronoLocalDate6;
                            }
                            map.remove((Object)this);
                            map.remove((Object)j3);
                            map.remove((Object)j2);
                            return chronoLocalDate;
                        }
                    } else {
                        TemporalUnit temporalUnit3 = this.h;
                        if ((temporalUnit3 == s.b || temporalUnit3 == ChronoUnit.FOREVER) && map.containsKey((Object)this.f.h) && map.containsKey((Object)this.f.g)) {
                            ChronoLocalDate chronoLocalDate;
                            int n10 = this.f.h.p().a((Long)map.get((Object)this.f.h), this.f.h);
                            if (k2 == j$.time.format.k.LENIENT) {
                                chronoLocalDate = this.j(e2, n10, 1, n4).g(e.G((Long)map.get((Object)this.f.g), 1L), chronoUnit);
                            } else {
                                ChronoLocalDate chronoLocalDate7 = this.j(e2, n10, this.f.g.p().a((Long)map.get((Object)this.f.g), this.f.g), n4);
                                if (k2 == j$.time.format.k.STRICT && this.c(chronoLocalDate7) != n10) {
                                    throw new g("Strict mode rejected resolved date as it is in a different week-based-year");
                                }
                                chronoLocalDate = chronoLocalDate7;
                            }
                            map.remove((Object)this);
                            map.remove((Object)this.f.h);
                            map.remove((Object)this.f.g);
                            map.remove((Object)j2);
                            return chronoLocalDate;
                        }
                    }
                }
            }
            return null;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.e);
            stringBuilder.append("[");
            stringBuilder.append(this.f.toString());
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        @Override
        public long v(TemporalAccessor temporalAccessor) {
            block8 : {
                int n2;
                block6 : {
                    TemporalUnit temporalUnit;
                    block7 : {
                        block5 : {
                            temporalUnit = this.h;
                            if (temporalUnit != ChronoUnit.WEEKS) break block5;
                            n2 = this.b(temporalAccessor);
                            break block6;
                        }
                        if (temporalUnit == ChronoUnit.MONTHS) {
                            return this.d(temporalAccessor);
                        }
                        if (temporalUnit == ChronoUnit.YEARS) {
                            return this.g(temporalAccessor);
                        }
                        if (temporalUnit != s.b) break block7;
                        n2 = this.f(temporalAccessor);
                        break block6;
                    }
                    if (temporalUnit != ChronoUnit.FOREVER) break block8;
                    n2 = this.c(temporalAccessor);
                }
                return n2;
            }
            StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("unreachable, rangeUnit: ");
            stringBuilder.append((Object)this.h);
            stringBuilder.append(", this: ");
            stringBuilder.append((Object)this);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

}

