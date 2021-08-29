/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package j$.time.format;

import j$.com.android.tools.r8.a;
import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.e;
import j$.time.format.DateTimeFormatter;
import j$.time.format.f;
import j$.time.format.i;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.d;
import j$.time.temporal.j;
import j$.time.temporal.o;
import j$.time.zone.c;
import java.util.Locale;

final class g {
    private TemporalAccessor a;
    private DateTimeFormatter b;
    private int c;

    g(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        block10 : {
            j$.time.chrono.e e2;
            ChronoLocalDate chronoLocalDate;
            ZoneId zoneId;
            block13 : {
                j$.time.chrono.e e3;
                block15 : {
                    j$.time.chrono.e e4;
                    block14 : {
                        ZoneId zoneId2;
                        block11 : {
                            j j2;
                            block12 : {
                                e3 = dateTimeFormatter.b();
                                zoneId2 = dateTimeFormatter.e();
                                if (e3 == null && zoneId2 == null) break block10;
                                e4 = (j$.time.chrono.e)temporalAccessor.t(d.a);
                                zoneId = (ZoneId)temporalAccessor.t(j$.time.temporal.f.a);
                                if (e.x(e3, e4)) {
                                    e3 = null;
                                }
                                if (e.x(zoneId2, zoneId)) {
                                    zoneId2 = null;
                                }
                                if (e3 == null && zoneId2 == null) break block10;
                                e2 = e3 != null ? e3 : e4;
                                if (zoneId2 == null) break block11;
                                if (!temporalAccessor.h(j.INSTANT_SECONDS)) break block12;
                                if (e2 == null) {
                                    e2 = j$.time.chrono.g.a;
                                }
                                temporalAccessor = e2.B(Instant.H(temporalAccessor), zoneId2);
                                break block10;
                            }
                            if (zoneId2.normalized() instanceof ZoneOffset && temporalAccessor.h(j2 = j.OFFSET_SECONDS) && temporalAccessor.i(j2) != zoneId2.G().d(Instant.a).L()) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Unable to apply override zone '");
                                stringBuilder.append((Object)zoneId2);
                                stringBuilder.append("' because the temporal object being formatted has a different offset but does not represent an instant: ");
                                stringBuilder.append((Object)temporalAccessor);
                                throw new j$.time.g(stringBuilder.toString());
                            }
                        }
                        if (zoneId2 != null) {
                            zoneId = zoneId2;
                        }
                        chronoLocalDate = null;
                        if (e3 == null) break block13;
                        if (!temporalAccessor.h(j.EPOCH_DAY)) break block14;
                        chronoLocalDate = e2.o(temporalAccessor);
                        break block13;
                    }
                    if (e3 != j$.time.chrono.g.a) break block15;
                    chronoLocalDate = null;
                    if (e4 == null) break block13;
                }
                j[] arrj = j.values();
                int n2 = 0;
                do {
                    chronoLocalDate = null;
                    if (n2 >= 30) break;
                    j j3 = arrj[n2];
                    if (j3.i() && temporalAccessor.h(j3)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unable to apply override chronology '");
                        stringBuilder.append((Object)e3);
                        stringBuilder.append("' because the temporal object being formatted contains date fields but does not represent a whole date: ");
                        stringBuilder.append((Object)temporalAccessor);
                        throw new j$.time.g(stringBuilder.toString());
                    }
                    ++n2;
                } while (true);
            }
            temporalAccessor = new f(chronoLocalDate, temporalAccessor, e2, zoneId);
        }
        this.a = temporalAccessor;
        this.b = dateTimeFormatter;
    }

    void a() {
        this.c = -1 + this.c;
    }

    i b() {
        return this.b.c();
    }

    Locale c() {
        return this.b.d();
    }

    TemporalAccessor d() {
        return this.a;
    }

    Long e(o o2) {
        try {
            Long l2 = this.a.f(o2);
            return l2;
        }
        catch (j$.time.g g2) {
            if (this.c > 0) {
                return null;
            }
            throw g2;
        }
    }

    Object f(TemporalQuery temporalQuery) {
        Object object = this.a.t(temporalQuery);
        if (object == null) {
            if (this.c != 0) {
                return object;
            }
            StringBuilder stringBuilder = a.b("Unable to extract value: ");
            stringBuilder.append((Object)this.a.getClass());
            throw new j$.time.g(stringBuilder.toString());
        }
        return object;
    }

    void g() {
        this.c = 1 + this.c;
    }

    public String toString() {
        return this.a.toString();
    }
}

