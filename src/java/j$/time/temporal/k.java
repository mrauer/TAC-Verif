/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDate
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package j$.time.temporal;

import j$.time.e;
import j$.time.g;
import j$.time.h;
import j$.time.i;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.l;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import java.util.Map;

public final class k {
    public static final o a = b.QUARTER_OF_YEAR;
    public static final o b = b.WEEK_OF_WEEK_BASED_YEAR;
    public static final o c = b.WEEK_BASED_YEAR;
    public static final TemporalUnit d = c.WEEK_BASED_YEARS;

    private static abstract class j$.time.temporal.k$b
    extends Enum<j$.time.temporal.k$b>
    implements o {
        public static final /* enum */ j$.time.temporal.k$b DAY_OF_QUARTER;
        public static final /* enum */ j$.time.temporal.k$b QUARTER_OF_YEAR;
        public static final /* enum */ j$.time.temporal.k$b WEEK_BASED_YEAR;
        public static final /* enum */ j$.time.temporal.k$b WEEK_OF_WEEK_BASED_YEAR;
        private static final int[] a;
        private static final /* synthetic */ j$.time.temporal.k$b[] b;

        static {
            j$.time.temporal.k$b b2;
            j$.time.temporal.k$b b3;
            j$.time.temporal.k$b b4;
            j$.time.temporal.k$b b5;
            DAY_OF_QUARTER = b3 = new j$.time.temporal.k$b(){

                @Override
                public boolean F(TemporalAccessor temporalAccessor) {
                    return temporalAccessor.h(j$.time.temporal.j.DAY_OF_YEAR) && temporalAccessor.h(j$.time.temporal.j.MONTH_OF_YEAR) && temporalAccessor.h(j$.time.temporal.j.YEAR) && j$.time.chrono.c.e(temporalAccessor).equals(j$.time.chrono.g.a);
                }

                @Override
                public Temporal G(Temporal temporal, long l2) {
                    long l3 = this.v(temporal);
                    this.p().b(l2, this);
                    j$.time.temporal.j j2 = j$.time.temporal.j.DAY_OF_YEAR;
                    return temporal.b(j2, temporal.f(j2) + (l2 - l3));
                }

                @Override
                public r H(TemporalAccessor temporalAccessor) {
                    if (this.F(temporalAccessor)) {
                        long l2 = temporalAccessor.f(j$.time.temporal.k$b.QUARTER_OF_YEAR);
                        if (l2 == 1L) {
                            long l3 = temporalAccessor.f(j$.time.temporal.j.YEAR);
                            if (j$.time.chrono.g.a.G(l3)) {
                                return r.i(1L, 91L);
                            }
                            return r.i(1L, 90L);
                        }
                        if (l2 == 2L) {
                            return r.i(1L, 91L);
                        }
                        if (l2 != 3L && l2 != 4L) {
                            return this.p();
                        }
                        return r.i(1L, 92L);
                    }
                    throw new q("Unsupported field: DayOfQuarter");
                }

                @Override
                public r p() {
                    return r.j(1L, 90L, 92L);
                }

                @Override
                public TemporalAccessor t(Map map, TemporalAccessor temporalAccessor, j$.time.format.k k2) {
                    j$.time.temporal.j j2 = j$.time.temporal.j.YEAR;
                    Long l2 = (Long)map.get((Object)j2);
                    j$.time.temporal.k$b b2 = j$.time.temporal.k$b.QUARTER_OF_YEAR;
                    Long l3 = (Long)map.get((Object)b2);
                    if (l2 != null && l3 != null) {
                        j.LocalDate localDate;
                        long l4;
                        int n2 = j2.J(l2);
                        long l5 = (Long)map.get((Object)j$.time.temporal.k$b.DAY_OF_QUARTER);
                        j$.time.temporal.k$b.K(temporalAccessor);
                        if (k2 == j$.time.format.k.LENIENT) {
                            localDate = j.LocalDate.of((int)n2, (int)1, (int)1).V(e.F(e.G(l3, 1L), 3L));
                            l4 = e.G(l5, 1L);
                        } else {
                            localDate = j.LocalDate.of((int)n2, (int)(1 + 3 * (b2.p().a(l3, b2) - 1)), (int)1);
                            if (l5 < 1L || l5 > 90L) {
                                r r2 = k2 == j$.time.format.k.STRICT ? this.H((TemporalAccessor)localDate) : this.p();
                                r2.b(l5, this);
                            }
                            l4 = l5 - 1L;
                        }
                        map.remove((Object)this);
                        map.remove((Object)j2);
                        map.remove((Object)b2);
                        return localDate.plusDays(l4);
                    }
                    return null;
                }

                public String toString() {
                    return "DayOfQuarter";
                }

                @Override
                public long v(TemporalAccessor temporalAccessor) {
                    if (this.F(temporalAccessor)) {
                        int n2 = temporalAccessor.i(j$.time.temporal.j.DAY_OF_YEAR);
                        int n3 = temporalAccessor.i(j$.time.temporal.j.MONTH_OF_YEAR);
                        long l2 = temporalAccessor.f(j$.time.temporal.j.YEAR);
                        int[] arrn = a;
                        int n4 = (n3 - 1) / 3;
                        int n5 = j$.time.chrono.g.a.G(l2) ? 4 : 0;
                        return n2 - arrn[n4 + n5];
                    }
                    throw new q("Unsupported field: DayOfQuarter");
                }
            };
            QUARTER_OF_YEAR = b5 = new j$.time.temporal.k$b(){

                @Override
                public boolean F(TemporalAccessor temporalAccessor) {
                    return temporalAccessor.h(j$.time.temporal.j.MONTH_OF_YEAR) && j$.time.chrono.c.e(temporalAccessor).equals(j$.time.chrono.g.a);
                }

                @Override
                public Temporal G(Temporal temporal, long l2) {
                    long l3 = this.v(temporal);
                    this.p().b(l2, this);
                    j$.time.temporal.j j2 = j$.time.temporal.j.MONTH_OF_YEAR;
                    return temporal.b(j2, temporal.f(j2) + 3L * (l2 - l3));
                }

                @Override
                public r p() {
                    return r.i(1L, 4L);
                }

                public String toString() {
                    return "QuarterOfYear";
                }

                @Override
                public long v(TemporalAccessor temporalAccessor) {
                    if (this.F(temporalAccessor)) {
                        return (2L + temporalAccessor.f(j$.time.temporal.j.MONTH_OF_YEAR)) / 3L;
                    }
                    throw new q("Unsupported field: QuarterOfYear");
                }
            };
            WEEK_OF_WEEK_BASED_YEAR = b2 = new j$.time.temporal.k$b(){

                @Override
                public boolean F(TemporalAccessor temporalAccessor) {
                    return temporalAccessor.h(j$.time.temporal.j.EPOCH_DAY) && j$.time.chrono.c.e(temporalAccessor).equals(j$.time.chrono.g.a);
                }

                @Override
                public Temporal G(Temporal temporal, long l2) {
                    this.p().b(l2, this);
                    return temporal.g(e.G(l2, this.v(temporal)), ChronoUnit.WEEKS);
                }

                @Override
                public r H(TemporalAccessor temporalAccessor) {
                    if (this.F(temporalAccessor)) {
                        return j$.time.temporal.k$b.L(j.LocalDate.H((TemporalAccessor)temporalAccessor));
                    }
                    throw new q("Unsupported field: WeekOfWeekBasedYear");
                }

                @Override
                public r p() {
                    return r.j(1L, 52L, 53L);
                }

                /*
                 * Enabled aggressive block sorting
                 */
                @Override
                public TemporalAccessor t(Map map, TemporalAccessor temporalAccessor, j$.time.format.k k2) {
                    j.LocalDate localDate;
                    j$.time.temporal.j j2;
                    j$.time.temporal.k$b b2;
                    block9 : {
                        Long l2;
                        j.LocalDate localDate2;
                        long l3;
                        block5 : {
                            long l4;
                            long l5;
                            block8 : {
                                j.LocalDate localDate3;
                                long l6;
                                block7 : {
                                    block6 : {
                                        b2 = j$.time.temporal.k$b.WEEK_BASED_YEAR;
                                        Long l7 = (Long)map.get((Object)b2);
                                        j2 = j$.time.temporal.j.DAY_OF_WEEK;
                                        l2 = (Long)map.get((Object)j2);
                                        if (l7 == null) return null;
                                        if (l2 == null) {
                                            return null;
                                        }
                                        int n2 = b2.p().a(l7, b2);
                                        l3 = (Long)map.get((Object)j$.time.temporal.k$b.WEEK_OF_WEEK_BASED_YEAR);
                                        j$.time.temporal.k$b.K(temporalAccessor);
                                        localDate2 = j.LocalDate.of((int)n2, (int)1, (int)4);
                                        if (k2 != j$.time.format.k.LENIENT) break block5;
                                        l5 = l2;
                                        if (l5 <= 7L) break block6;
                                        l6 = l5 - 1L;
                                        localDate3 = localDate2.W(l6 / 7L);
                                        break block7;
                                    }
                                    l4 = 1L;
                                    if (l5 >= l4) break block8;
                                    localDate3 = localDate2.W(e.G(l5, 7L) / 7L);
                                    l6 = l5 + 6L;
                                }
                                localDate2 = localDate3;
                                long l8 = l6 % 7L;
                                l4 = 1L;
                                l5 = l8 + l4;
                            }
                            localDate = localDate2.W(e.G(l3, l4)).a0((o)j2, l5);
                            break block9;
                        }
                        int n3 = j2.J(l2);
                        if (l3 < 1L || l3 > 52L) {
                            r r2 = k2 == j$.time.format.k.STRICT ? j$.time.temporal.k$b.L(localDate2) : this.p();
                            r2.b(l3, this);
                        }
                        localDate = localDate2.W(l3 - 1L).a0((o)j2, (long)n3);
                    }
                    map.remove((Object)this);
                    map.remove((Object)b2);
                    map.remove((Object)j2);
                    return localDate;
                }

                public String toString() {
                    return "WeekOfWeekBasedYear";
                }

                @Override
                public long v(TemporalAccessor temporalAccessor) {
                    if (this.F(temporalAccessor)) {
                        return j$.time.temporal.k$b.M(j.LocalDate.H((TemporalAccessor)temporalAccessor));
                    }
                    throw new q("Unsupported field: WeekOfWeekBasedYear");
                }
            };
            WEEK_BASED_YEAR = b4 = new j$.time.temporal.k$b(){

                @Override
                public boolean F(TemporalAccessor temporalAccessor) {
                    return temporalAccessor.h(j$.time.temporal.j.EPOCH_DAY) && j$.time.chrono.c.e(temporalAccessor).equals(j$.time.chrono.g.a);
                }

                @Override
                public Temporal G(Temporal temporal, long l2) {
                    if (this.F(temporal)) {
                        int n2 = this.p().a(l2, j$.time.temporal.k$b.WEEK_BASED_YEAR);
                        j.LocalDate localDate = j.LocalDate.H((TemporalAccessor)temporal);
                        j$.time.temporal.j j2 = j$.time.temporal.j.DAY_OF_WEEK;
                        int n3 = localDate.i((o)j2);
                        int n4 = j$.time.temporal.k$b.M(localDate);
                        if (n4 == 53 && j$.time.temporal.k$b.Q(n2) == 52) {
                            n4 = 52;
                        }
                        j.LocalDate localDate2 = j.LocalDate.of((int)n2, (int)1, (int)4);
                        return temporal.e((l)localDate2.plusDays((long)(n3 - localDate2.i((o)j2) + 7 * (n4 - 1))));
                    }
                    throw new q("Unsupported field: WeekBasedYear");
                }

                @Override
                public r p() {
                    return j$.time.temporal.j.YEAR.p();
                }

                public String toString() {
                    return "WeekBasedYear";
                }

                @Override
                public long v(TemporalAccessor temporalAccessor) {
                    if (this.F(temporalAccessor)) {
                        return j$.time.temporal.k$b.P(j.LocalDate.H((TemporalAccessor)temporalAccessor));
                    }
                    throw new q("Unsupported field: WeekBasedYear");
                }
            };
            b = new j$.time.temporal.k$b[]{b3, b5, b2, b4};
            a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
        }

        j$.time.temporal.k$b(j$.time.temporal.k$a a2) {
        }

        static void K(TemporalAccessor temporalAccessor) {
            if (j$.time.chrono.c.e(temporalAccessor).equals(j$.time.chrono.g.a)) {
                return;
            }
            throw new g("Resolve requires IsoChronology");
        }

        static r L(j.LocalDate localDate) {
            return r.i(1L, j$.time.temporal.k$b.Q(j$.time.temporal.k$b.P(localDate)));
        }

        static int M(j.LocalDate localDate) {
            int n2;
            block6 : {
                int n3;
                block5 : {
                    int n4 = localDate.K().ordinal();
                    int n5 = localDate.L();
                    int n6 = n5 - (n2 = 1);
                    int n7 = n6 + (3 - n4);
                    int n8 = -3 + (n7 - 7 * (n7 / 7));
                    if (n8 < -3) {
                        n8 += 7;
                    }
                    if (n6 < n8) {
                        return (int)r.i(1L, j$.time.temporal.k$b.Q(j$.time.temporal.k$b.P(localDate.c0(180).X(-1L)))).d();
                    }
                    n3 = n2 + (n6 - n8) / 7;
                    if (n3 != 53) break block5;
                    int n9 = !(n8 == -3 || n8 == -2 && localDate.P()) ? 0 : n2;
                    if (n9 == 0) break block6;
                }
                n2 = n3;
            }
            return n2;
        }

        private static int P(j.LocalDate localDate) {
            int n2 = localDate.O();
            int n3 = localDate.L();
            if (n3 <= 3) {
                if (n3 - localDate.K().ordinal() < -2) {
                    return n2 - 1;
                }
            } else if (n3 >= 363) {
                int n4 = localDate.K().ordinal();
                if (n3 - 363 - localDate.P() - n4 >= 0) {
                    ++n2;
                }
            }
            return n2;
        }

        private static int Q(int n2) {
            j.LocalDate localDate = j.LocalDate.of((int)n2, (int)1, (int)1);
            if (!(localDate.K() == h.THURSDAY || localDate.K() == h.WEDNESDAY && localDate.P())) {
                return 52;
            }
            return 53;
        }

        public static j$.time.temporal.k$b valueOf(String string) {
            return (j$.time.temporal.k$b)Enum.valueOf(j$.time.temporal.k$b.class, (String)string);
        }

        public static j$.time.temporal.k$b[] values() {
            return (j$.time.temporal.k$b[])b.clone();
        }

        @Override
        public r H(TemporalAccessor temporalAccessor) {
            return this.p();
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
        public /* synthetic */ TemporalAccessor t(Map map, TemporalAccessor temporalAccessor, j$.time.format.k k2) {
            return null;
        }

    }

    private static final class c
    extends Enum<c>
    implements TemporalUnit {
        public static final /* enum */ c QUARTER_YEARS;
        public static final /* enum */ c WEEK_BASED_YEARS;
        private static final /* synthetic */ c[] a;
        private final String b;

        static {
            c c2;
            c c4;
            WEEK_BASED_YEARS = c2 = new c("WeekBasedYears", i.t(31556952L));
            QUARTER_YEARS = c4 = new c("QuarterYears", i.t(7889238L));
            a = new c[]{c2, c4};
        }

        private c(String string2, i i2) {
            this.b = string2;
        }

        public static c valueOf(String string) {
            return (c)Enum.valueOf(c.class, (String)string);
        }

        public static c[] values() {
            return (c[])a.clone();
        }

        @Override
        public long between(Temporal temporal, Temporal temporal2) {
            if (temporal.getClass() != temporal2.getClass()) {
                return temporal.until(temporal2, this);
            }
            int n2 = this.ordinal();
            if (n2 != 0) {
                if (n2 == 1) {
                    return temporal.until(temporal2, ChronoUnit.MONTHS) / 3L;
                }
                throw new IllegalStateException("Unreachable");
            }
            o o2 = k.c;
            return e.G(temporal2.f(o2), temporal.f(o2));
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
        public Temporal p(Temporal temporal, long l2) {
            int n2 = this.ordinal();
            if (n2 != 0) {
                if (n2 == 1) {
                    return temporal.g(l2 / 256L, ChronoUnit.YEARS).g(3L * (l2 % 256L), ChronoUnit.MONTHS);
                }
                throw new IllegalStateException("Unreachable");
            }
            o o2 = k.c;
            return temporal.b(o2, e.C(temporal.i(o2), l2));
        }

        public String toString() {
            return this.b;
        }
    }

}

