/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDate
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 */
package j$.time.format;

import j$.com.android.tools.r8.a;
import j$.time.Instant;
import j$.time.Period;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.e;
import j$.time.format.k;
import j$.time.g;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.c;
import j$.time.temporal.d;
import j$.time.temporal.f;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

final class j
implements TemporalAccessor {
    final Map a = new HashMap();
    ZoneId b;
    j$.time.chrono.e c;
    boolean d;
    private k e;
    private ChronoLocalDate f;
    private j$.time.j g;
    Period h = Period.a;

    j() {
    }

    private void A(o o2, o o3, Long l2) {
        Long l3 = (Long)this.a.put((Object)o3, (Object)l2);
        if (l3 != null) {
            if (l3.longValue() == l2.longValue()) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Conflict found: ");
            stringBuilder.append((Object)o3);
            stringBuilder.append(" ");
            stringBuilder.append((Object)l3);
            stringBuilder.append(" differs from ");
            stringBuilder.append((Object)o3);
            stringBuilder.append(" ");
            stringBuilder.append((Object)l2);
            stringBuilder.append(" while resolving  ");
            stringBuilder.append((Object)o2);
            throw new g(stringBuilder.toString());
        }
    }

    /*
     * Exception decompiling
     */
    private void j(TemporalAccessor var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     */
    private void o() {
        block2 : {
            ZoneId zoneId;
            block3 : {
                if (!this.a.containsKey((Object)j$.time.temporal.j.INSTANT_SECONDS)) break block2;
                zoneId = this.b;
                if (zoneId != null) break block3;
                Long l2 = (Long)this.a.get((Object)j$.time.temporal.j.OFFSET_SECONDS);
                if (l2 == null) break block2;
                zoneId = ZoneOffset.O(l2.intValue());
            }
            this.r(zoneId);
            return;
        }
    }

    private void r(ZoneId zoneId) {
        Map map = this.a;
        j$.time.temporal.j j2 = j$.time.temporal.j.INSTANT_SECONDS;
        Instant instant = Instant.ofEpochSecond((Long)map.remove((Object)j2));
        ChronoZonedDateTime chronoZonedDateTime = this.c.B(instant, zoneId);
        this.z(chronoZonedDateTime.d());
        this.A(j2, j$.time.temporal.j.SECOND_OF_DAY, (long)chronoZonedDateTime.c().U());
    }

    /*
     * Enabled aggressive block sorting
     */
    private void u(long l2, long l3, long l4, long l5) {
        Period period;
        j$.time.j j2;
        if (this.e == k.LENIENT) {
            long l6 = e.C(e.C(e.C(e.F(l2, 3600000000000L), e.F(l3, 60000000000L)), e.F(l4, 1000000000L)), l5);
            int n2 = (int)e.E(l6, 86400000000000L);
            j2 = j$.time.j.O(e.D(l6, 86400000000000L));
            period = Period.d(n2);
        } else {
            int n3 = j$.time.temporal.j.MINUTE_OF_HOUR.J(l3);
            int n4 = j$.time.temporal.j.NANO_OF_SECOND.J(l5);
            if (this.e == k.SMART && l2 == 24L && n3 == 0 && l4 == 0L && n4 == 0) {
                j2 = j$.time.j.c;
                period = Period.d(1);
            } else {
                j2 = j$.time.j.N(j$.time.temporal.j.HOUR_OF_DAY.J(l2), n3, j$.time.temporal.j.SECOND_OF_MINUTE.J(l4), n4);
                period = Period.a;
            }
        }
        this.x(j2, period);
    }

    private void v() {
        j$.time.temporal.j j2;
        Map map;
        j$.time.temporal.j j3;
        j$.time.temporal.j j4;
        j$.time.temporal.j j5;
        Map map2;
        Map map3;
        j$.time.temporal.j j6;
        j$.time.temporal.j j7;
        Map map4;
        Map map5;
        Map map6;
        Map map7;
        Map map8;
        j$.time.temporal.j j8;
        j$.time.temporal.j j9;
        j$.time.temporal.j j10;
        j$.time.temporal.j j11;
        j$.time.temporal.j j12;
        j$.time.temporal.j j13;
        Map map9;
        Map map10;
        Map map11;
        Map map12;
        Map map13 = this.a;
        j$.time.temporal.j j14 = j$.time.temporal.j.CLOCK_HOUR_OF_DAY;
        boolean bl = map13.containsKey((Object)j14);
        long l2 = 0L;
        if (bl) {
            long l3 = (Long)this.a.remove((Object)j14);
            k k2 = this.e;
            if (k2 == k.STRICT || k2 == k.SMART && l3 != l2) {
                j14.K(l3);
            }
            j$.time.temporal.j j15 = j$.time.temporal.j.HOUR_OF_DAY;
            if (l3 == 24L) {
                l3 = l2;
            }
            this.A(j14, j15, l3);
        }
        if ((map6 = this.a).containsKey((Object)(j4 = j$.time.temporal.j.CLOCK_HOUR_OF_AMPM))) {
            long l4 = (Long)this.a.remove((Object)j4);
            k k3 = this.e;
            if (k3 == k.STRICT || k3 == k.SMART && l4 != l2) {
                j4.K(l4);
            }
            j$.time.temporal.j j16 = j$.time.temporal.j.HOUR_OF_AMPM;
            if (l4 != 12L) {
                l2 = l4;
            }
            this.A(j4, j16, l2);
        }
        if ((map = this.a).containsKey((Object)(j5 = j$.time.temporal.j.AMPM_OF_DAY)) && (map2 = this.a).containsKey((Object)(j7 = j$.time.temporal.j.HOUR_OF_AMPM))) {
            Long l5;
            j$.time.temporal.j j17;
            long l6 = (Long)this.a.remove((Object)j5);
            long l7 = (Long)this.a.remove((Object)j7);
            if (this.e == k.LENIENT) {
                j17 = j$.time.temporal.j.HOUR_OF_DAY;
                l5 = e.C(e.F(l6, 12L), l7);
            } else {
                j5.K(l6);
                j7.K(l6);
                j17 = j$.time.temporal.j.HOUR_OF_DAY;
                l5 = l7 + l6 * 12L;
            }
            this.A(j5, j17, l5);
        }
        if ((map7 = this.a).containsKey((Object)(j9 = j$.time.temporal.j.NANO_OF_DAY))) {
            long l8 = (Long)this.a.remove((Object)j9);
            if (this.e != k.LENIENT) {
                j9.K(l8);
            }
            this.A(j9, j$.time.temporal.j.HOUR_OF_DAY, l8 / 3600000000000L);
            this.A(j9, j$.time.temporal.j.MINUTE_OF_HOUR, l8 / 60000000000L % 60L);
            this.A(j9, j$.time.temporal.j.SECOND_OF_MINUTE, l8 / 1000000000L % 60L);
            this.A(j9, j$.time.temporal.j.NANO_OF_SECOND, l8 % 1000000000L);
        }
        if ((map10 = this.a).containsKey((Object)(j13 = j$.time.temporal.j.MICRO_OF_DAY))) {
            long l9 = (Long)this.a.remove((Object)j13);
            if (this.e != k.LENIENT) {
                j13.K(l9);
            }
            this.A(j13, j$.time.temporal.j.SECOND_OF_DAY, l9 / 1000000L);
            this.A(j13, j$.time.temporal.j.MICRO_OF_SECOND, l9 % 1000000L);
        }
        if ((map5 = this.a).containsKey((Object)(j6 = j$.time.temporal.j.MILLI_OF_DAY))) {
            long l10 = (Long)this.a.remove((Object)j6);
            if (this.e != k.LENIENT) {
                j6.K(l10);
            }
            this.A(j6, j$.time.temporal.j.SECOND_OF_DAY, l10 / 1000L);
            this.A(j6, j$.time.temporal.j.MILLI_OF_SECOND, l10 % 1000L);
        }
        if ((map3 = this.a).containsKey((Object)(j2 = j$.time.temporal.j.SECOND_OF_DAY))) {
            long l11 = (Long)this.a.remove((Object)j2);
            if (this.e != k.LENIENT) {
                j2.K(l11);
            }
            this.A(j2, j$.time.temporal.j.HOUR_OF_DAY, l11 / 3600L);
            this.A(j2, j$.time.temporal.j.MINUTE_OF_HOUR, l11 / 60L % 60L);
            this.A(j2, j$.time.temporal.j.SECOND_OF_MINUTE, l11 % 60L);
        }
        if ((map8 = this.a).containsKey((Object)(j8 = j$.time.temporal.j.MINUTE_OF_DAY))) {
            long l12 = (Long)this.a.remove((Object)j8);
            if (this.e != k.LENIENT) {
                j8.K(l12);
            }
            this.A(j8, j$.time.temporal.j.HOUR_OF_DAY, l12 / 60L);
            this.A(j8, j$.time.temporal.j.MINUTE_OF_HOUR, l12 % 60L);
        }
        if ((map9 = this.a).containsKey((Object)(j11 = j$.time.temporal.j.NANO_OF_SECOND))) {
            Map map14;
            j$.time.temporal.j j18;
            Map map15;
            j$.time.temporal.j j19;
            long l13 = (Long)this.a.get((Object)j11);
            k k4 = this.e;
            k k5 = k.LENIENT;
            if (k4 != k5) {
                j11.K(l13);
            }
            if ((map15 = this.a).containsKey((Object)(j19 = j$.time.temporal.j.MICRO_OF_SECOND))) {
                long l14 = (Long)this.a.remove((Object)j19);
                if (this.e != k5) {
                    j19.K(l14);
                }
                l13 = l14 * 1000L + l13 % 1000L;
                this.A(j19, j11, l13);
            }
            if ((map14 = this.a).containsKey((Object)(j18 = j$.time.temporal.j.MILLI_OF_SECOND))) {
                long l15 = (Long)this.a.remove((Object)j18);
                if (this.e != k5) {
                    j18.K(l15);
                }
                this.A(j18, j11, l15 * 1000000L + l13 % 1000000L);
            }
        }
        if ((map4 = this.a).containsKey((Object)(j12 = j$.time.temporal.j.HOUR_OF_DAY)) && (map11 = this.a).containsKey((Object)(j3 = j$.time.temporal.j.MINUTE_OF_HOUR)) && (map12 = this.a).containsKey((Object)(j10 = j$.time.temporal.j.SECOND_OF_MINUTE)) && this.a.containsKey((Object)j11)) {
            this.u((Long)this.a.remove((Object)j12), (Long)this.a.remove((Object)j3), (Long)this.a.remove((Object)j10), (Long)this.a.remove((Object)j11));
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void x(j$.time.j j2, Period period) {
        j$.time.j j3 = this.g;
        if (j3 != null) {
            if (!j3.equals(j2)) {
                StringBuilder stringBuilder = a.b("Conflict found: Fields resolved to different times: ");
                stringBuilder.append((Object)this.g);
                stringBuilder.append(" ");
                stringBuilder.append((Object)j2);
                throw new g(stringBuilder.toString());
            }
            if (!(this.h.b() || period.b() || this.h.equals(period))) {
                StringBuilder stringBuilder = a.b("Conflict found: Fields resolved to different excess periods: ");
                stringBuilder.append((Object)this.h);
                stringBuilder.append(" ");
                stringBuilder.append((Object)period);
                throw new g(stringBuilder.toString());
            }
        } else {
            this.g = j2;
        }
        this.h = period;
    }

    private void z(ChronoLocalDate chronoLocalDate) {
        ChronoLocalDate chronoLocalDate2 = this.f;
        if (chronoLocalDate2 != null) {
            if (chronoLocalDate != null) {
                if (chronoLocalDate2.equals(chronoLocalDate)) {
                    return;
                }
                StringBuilder stringBuilder = a.b("Conflict found: Fields resolved to two different dates: ");
                stringBuilder.append((Object)this.f);
                stringBuilder.append(" ");
                stringBuilder.append((Object)chronoLocalDate);
                throw new g(stringBuilder.toString());
            }
        } else if (chronoLocalDate != null) {
            if (this.c.equals(chronoLocalDate.a())) {
                this.f = chronoLocalDate;
                return;
            }
            StringBuilder stringBuilder = a.b("ChronoLocalDate must use the effective parsed chronology: ");
            stringBuilder.append((Object)this.c);
            throw new g(stringBuilder.toString());
        }
    }

    @Override
    public long f(o o2) {
        Objects.requireNonNull((Object)o2, (String)"field");
        Long l2 = (Long)this.a.get((Object)o2);
        if (l2 != null) {
            return l2;
        }
        ChronoLocalDate chronoLocalDate = this.f;
        if (chronoLocalDate != null && chronoLocalDate.h(o2)) {
            return this.f.f(o2);
        }
        j$.time.j j2 = this.g;
        if (j2 != null && j2.h(o2)) {
            return this.g.f(o2);
        }
        if (!(o2 instanceof j$.time.temporal.j)) {
            return o2.v(this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append((Object)o2);
        throw new q(stringBuilder.toString());
    }

    @Override
    public boolean h(o o2) {
        ChronoLocalDate chronoLocalDate;
        boolean bl = this.a.containsKey((Object)o2);
        boolean bl2 = true;
        if (!(bl || (chronoLocalDate = this.f) != null && chronoLocalDate.h(o2))) {
            j$.time.j j2 = this.g;
            if (j2 != null && j2.h(o2)) {
                return bl2;
            }
            if (o2 != null && !(o2 instanceof j$.time.temporal.j) && o2.F(this)) {
                return bl2;
            }
            bl2 = false;
        }
        return bl2;
    }

    @Override
    public /* synthetic */ int i(o o2) {
        return e.f(this, o2);
    }

    TemporalAccessor m(k k2, Set set) {
        block47 : {
            ChronoZonedDateTime chronoZonedDateTime;
            block49 : {
                block48 : {
                    j$.time.j j2;
                    ChronoLocalDate chronoLocalDate;
                    ChronoLocalDate chronoLocalDate2;
                    j$.time.j j3;
                    block46 : {
                        block40 : {
                            Long l2;
                            j$.time.temporal.j j4;
                            Map map;
                            block45 : {
                                Map map2;
                                Long l3;
                                j$.time.temporal.j j5;
                                block44 : {
                                    long l4;
                                    block43 : {
                                        block41 : {
                                            long l5;
                                            block42 : {
                                                if (set != null) {
                                                    this.a.keySet().retainAll((Collection)set);
                                                }
                                                this.e = k2;
                                                this.o();
                                                this.z(this.c.z(this.a, this.e));
                                                this.v();
                                                if (this.a.size() > 0) {
                                                    int n2;
                                                    block0 : for (n2 = 0; n2 < 50; ++n2) {
                                                        Iterator iterator = this.a.entrySet().iterator();
                                                        while (iterator.hasNext()) {
                                                            o o2 = (o)((Map.Entry)iterator.next()).getKey();
                                                            TemporalAccessor temporalAccessor = o2.t(this.a, this, this.e);
                                                            if (temporalAccessor != null) {
                                                                if (temporalAccessor instanceof ChronoZonedDateTime) {
                                                                    ChronoZonedDateTime chronoZonedDateTime2 = (ChronoZonedDateTime)temporalAccessor;
                                                                    ZoneId zoneId = this.b;
                                                                    if (zoneId == null) {
                                                                        this.b = chronoZonedDateTime2.q();
                                                                    } else if (!zoneId.equals(chronoZonedDateTime2.q())) {
                                                                        StringBuilder stringBuilder = a.b("ChronoZonedDateTime must use the effective parsed zone: ");
                                                                        stringBuilder.append((Object)this.b);
                                                                        throw new g(stringBuilder.toString());
                                                                    }
                                                                    temporalAccessor = chronoZonedDateTime2.w();
                                                                }
                                                                if (temporalAccessor instanceof ChronoLocalDateTime) {
                                                                    ChronoLocalDateTime chronoLocalDateTime = (ChronoLocalDateTime)temporalAccessor;
                                                                    this.x(chronoLocalDateTime.c(), Period.a);
                                                                    this.z(chronoLocalDateTime.d());
                                                                    continue block0;
                                                                }
                                                                if (temporalAccessor instanceof ChronoLocalDate) {
                                                                    this.z((ChronoLocalDate)temporalAccessor);
                                                                    continue block0;
                                                                }
                                                                if (temporalAccessor instanceof j$.time.j) {
                                                                    this.x((j$.time.j)temporalAccessor, Period.a);
                                                                    continue block0;
                                                                }
                                                                throw new g("Method resolve() can only return ChronoZonedDateTime, ChronoLocalDateTime, ChronoLocalDate or LocalTime");
                                                            }
                                                            if (this.a.containsKey((Object)o2)) continue;
                                                            continue block0;
                                                        }
                                                        break block0;
                                                    }
                                                    if (n2 != 50) {
                                                        if (n2 > 0) {
                                                            this.o();
                                                            this.z(this.c.z(this.a, this.e));
                                                            this.v();
                                                        }
                                                    } else {
                                                        throw new g("One of the parsed fields has an incorrectly implemented resolve method");
                                                    }
                                                }
                                                if (this.g != null) break block40;
                                                Map map3 = this.a;
                                                j$.time.temporal.j j6 = j$.time.temporal.j.MILLI_OF_SECOND;
                                                if (!map3.containsKey((Object)j6)) break block41;
                                                l5 = (Long)this.a.remove((Object)j6);
                                                Map map4 = this.a;
                                                j$.time.temporal.j j7 = j$.time.temporal.j.MICRO_OF_SECOND;
                                                if (!map4.containsKey((Object)j7)) break block42;
                                                l4 = l5 * 1000L + (Long)this.a.get((Object)j7) % 1000L;
                                                this.A(j6, j7, l4);
                                                this.a.remove((Object)j7);
                                                break block43;
                                            }
                                            Map map5 = this.a;
                                            j5 = j$.time.temporal.j.NANO_OF_SECOND;
                                            Long l6 = l5 * 1000000L;
                                            map2 = map5;
                                            l3 = l6;
                                            break block44;
                                        }
                                        Map map6 = this.a;
                                        j$.time.temporal.j j8 = j$.time.temporal.j.MICRO_OF_SECOND;
                                        if (!map6.containsKey((Object)j8)) break block45;
                                        l4 = (Long)this.a.remove((Object)j8);
                                    }
                                    map2 = this.a;
                                    j5 = j$.time.temporal.j.NANO_OF_SECOND;
                                    l3 = l4 * 1000L;
                                }
                                map2.put((Object)j5, (Object)l3);
                            }
                            if ((l2 = (Long)(map = this.a).get((Object)(j4 = j$.time.temporal.j.HOUR_OF_DAY))) == null) break block40;
                            Map map7 = this.a;
                            j$.time.temporal.j j9 = j$.time.temporal.j.MINUTE_OF_HOUR;
                            Long l7 = (Long)map7.get((Object)j9);
                            Map map8 = this.a;
                            j$.time.temporal.j j10 = j$.time.temporal.j.SECOND_OF_MINUTE;
                            Long l8 = (Long)map8.get((Object)j10);
                            Map map9 = this.a;
                            j$.time.temporal.j j11 = j$.time.temporal.j.NANO_OF_SECOND;
                            Long l9 = (Long)map9.get((Object)j11);
                            if (l7 == null && (l8 != null || l9 != null) || l7 != null && l8 == null && l9 != null) break block46;
                            long l10 = l7 != null ? l7 : 0L;
                            long l11 = l8 != null ? l8 : 0L;
                            long l12 = l11;
                            long l13 = l9 != null ? l9 : 0L;
                            long l14 = l13;
                            this.u(l2, l10, l12, l14);
                            this.a.remove((Object)j4);
                            this.a.remove((Object)j9);
                            this.a.remove((Object)j10);
                            this.a.remove((Object)j11);
                        }
                        if (this.e != k.LENIENT && this.a.size() > 0) {
                            for (Map.Entry entry : this.a.entrySet()) {
                                o o3 = (o)entry.getKey();
                                if (!(o3 instanceof j$.time.temporal.j) || !o3.e()) continue;
                                ((j$.time.temporal.j)o3).K((Long)entry.getValue());
                            }
                        }
                    }
                    if ((chronoLocalDate2 = this.f) != null) {
                        this.j(chronoLocalDate2);
                    }
                    if ((j3 = this.g) != null) {
                        this.j(j3);
                        if (this.f != null && this.a.size() > 0) {
                            this.j(this.f.s(this.g));
                        }
                    }
                    if (this.f != null && this.g != null && !this.h.b()) {
                        this.f = this.f.y(this.h);
                        this.h = Period.a;
                    }
                    if (this.g == null && (this.a.containsKey((Object)j$.time.temporal.j.INSTANT_SECONDS) || this.a.containsKey((Object)j$.time.temporal.j.SECOND_OF_DAY) || this.a.containsKey((Object)j$.time.temporal.j.SECOND_OF_MINUTE))) {
                        Map map = this.a;
                        j$.time.temporal.j j12 = j$.time.temporal.j.NANO_OF_SECOND;
                        if (map.containsKey((Object)j12)) {
                            long l15 = (Long)this.a.get((Object)j12);
                            this.a.put((Object)j$.time.temporal.j.MICRO_OF_SECOND, (Object)(l15 / 1000L));
                            this.a.put((Object)j$.time.temporal.j.MILLI_OF_SECOND, (Object)(l15 / 1000000L));
                        } else {
                            this.a.put((Object)j12, (Object)0L);
                            this.a.put((Object)j$.time.temporal.j.MICRO_OF_SECOND, (Object)0L);
                            this.a.put((Object)j$.time.temporal.j.MILLI_OF_SECOND, (Object)0L);
                        }
                    }
                    if ((chronoLocalDate = this.f) == null || (j2 = this.g) == null) break block47;
                    if (this.b == null) break block48;
                    chronoZonedDateTime = chronoLocalDate.s(j2).n(this.b);
                    break block49;
                }
                Long l16 = (Long)this.a.get((Object)j$.time.temporal.j.OFFSET_SECONDS);
                if (l16 == null) break block47;
                ZoneOffset zoneOffset = ZoneOffset.O(l16.intValue());
                chronoZonedDateTime = this.f.s(this.g).n(zoneOffset);
            }
            j$.time.temporal.j j13 = j$.time.temporal.j.INSTANT_SECONDS;
            long l17 = chronoZonedDateTime.f(j13);
            this.a.put((Object)j13, (Object)l17);
        }
        return this;
    }

    @Override
    public /* synthetic */ r p(o o2) {
        return e.k(this, o2);
    }

    @Override
    public Object t(TemporalQuery temporalQuery) {
        if (temporalQuery == f.a) {
            return this.b;
        }
        if (temporalQuery == d.a) {
            return this.c;
        }
        if (temporalQuery == c.a) {
            ChronoLocalDate chronoLocalDate = this.f;
            j.LocalDate localDate = null;
            if (chronoLocalDate != null) {
                localDate = j.LocalDate.H((TemporalAccessor)chronoLocalDate);
            }
            return localDate;
        }
        if (temporalQuery == h.a) {
            return this.g;
        }
        if (temporalQuery != i.a && temporalQuery != j$.time.temporal.e.a) {
            if (temporalQuery == j$.time.temporal.g.a) {
                return null;
            }
            return temporalQuery.queryFrom(this);
        }
        return temporalQuery.queryFrom(this);
    }

    public String toString() {
        StringBuilder stringBuilder;
        block4 : {
            block5 : {
                stringBuilder = new StringBuilder(64);
                stringBuilder.append((Object)this.a);
                stringBuilder.append(',');
                stringBuilder.append((Object)this.c);
                if (this.b != null) {
                    stringBuilder.append(',');
                    stringBuilder.append((Object)this.b);
                }
                if (this.f == null && this.g == null) break block4;
                stringBuilder.append(" resolved to ");
                ChronoLocalDate chronoLocalDate = this.f;
                if (chronoLocalDate == null) break block5;
                stringBuilder.append((Object)chronoLocalDate);
                if (this.g == null) break block4;
                stringBuilder.append('T');
            }
            stringBuilder.append((Object)this.g);
        }
        return stringBuilder.toString();
    }
}

