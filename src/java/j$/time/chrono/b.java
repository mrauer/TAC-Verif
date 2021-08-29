/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package j$.time.chrono;

import j$.com.android.tools.r8.a;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.d;
import j$.time.e;
import j$.time.j;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.l;
import j$.time.temporal.o;
import j$.time.temporal.r;
import java.io.Serializable;
import java.util.Objects;

final class b<D extends ChronoLocalDate>
implements ChronoLocalDateTime<D>,
Temporal,
l,
Serializable {
    private final transient ChronoLocalDate a;
    private final transient j b;

    private b(ChronoLocalDate chronoLocalDate, j j3) {
        Objects.requireNonNull((Object)j3, (String)"time");
        this.a = chronoLocalDate;
        this.b = j3;
    }

    static b F(j$.time.chrono.e e4, Temporal temporal) {
        b b4 = (b)temporal;
        if (e4.equals(b4.a())) {
            return b4;
        }
        StringBuilder stringBuilder = a.b("Chronology mismatch, required: ");
        stringBuilder.append(e4.m());
        stringBuilder.append(", actual: ");
        stringBuilder.append(b4.a().m());
        throw new ClassCastException(stringBuilder.toString());
    }

    private b H(long l3) {
        return this.N(this.a.g(l3, ChronoUnit.DAYS), this.b);
    }

    private b J(long l3) {
        return this.L(this.a, 0L, 0L, 0L, l3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private b L(ChronoLocalDate chronoLocalDate, long l3, long l4, long l5, long l6) {
        j j3;
        ChronoLocalDate chronoLocalDate2 = chronoLocalDate;
        if ((l6 | (l5 | (l3 | l4))) == 0L) {
            j3 = this.b;
            do {
                return this.N(chronoLocalDate2, j3);
                break;
            } while (true);
        }
        long l7 = l6 / 86400000000000L + l5 / 86400L + l4 / 1440L + l3 / 24L;
        long l8 = l6 % 86400000000000L + 1000000000L * (l5 % 86400L) + 60000000000L * (l4 % 1440L) + 3600000000000L * (l3 % 24L);
        long l9 = this.b.T();
        long l10 = l8 + l9;
        long l11 = l7 + e.E(l10, 86400000000000L);
        long l12 = e.D(l10, 86400000000000L);
        j3 = l12 == l9 ? this.b : j.O(l12);
        chronoLocalDate2 = chronoLocalDate2.g(l11, ChronoUnit.DAYS);
        return this.N(chronoLocalDate2, j3);
    }

    private b N(Temporal temporal, j j3) {
        ChronoLocalDate chronoLocalDate;
        ChronoLocalDate chronoLocalDate2 = this.a;
        if (chronoLocalDate2 == temporal && this.b == j3) {
            return this;
        }
        j$.time.chrono.e e4 = chronoLocalDate2.a();
        if (e4.equals((chronoLocalDate = (ChronoLocalDate)temporal).a())) {
            return new b<D>(chronoLocalDate, j3);
        }
        StringBuilder stringBuilder = a.b("Chronology mismatch, expected: ");
        stringBuilder.append(e4.m());
        stringBuilder.append(", actual: ");
        stringBuilder.append(chronoLocalDate.a().m());
        throw new ClassCastException(stringBuilder.toString());
    }

    public b G(long l3, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (((ChronoUnit)temporalUnit).ordinal()) {
                default: {
                    return this.N(this.a.g(l3, temporalUnit), this.b);
                }
                case 6: {
                    b b4 = this.H(l3 / 256L);
                    long l4 = 12L * (l3 % 256L);
                    return b4.L(b4.a, l4, 0L, 0L, 0L);
                }
                case 5: {
                    return this.L(this.a, l3, 0L, 0L, 0L);
                }
                case 4: {
                    return this.L(this.a, 0L, l3, 0L, 0L);
                }
                case 3: {
                    return this.L(this.a, 0L, 0L, l3, 0L);
                }
                case 2: {
                    return this.H(l3 / 86400000L).J(1000000L * (l3 % 86400000L));
                }
                case 1: {
                    return this.H(l3 / 86400000000L).J(1000L * (l3 % 86400000000L));
                }
                case 0: 
            }
            return this.J(l3);
        }
        return b.F(this.a.a(), temporalUnit.p(this, l3));
    }

    b K(long l3) {
        return this.L(this.a, 0L, 0L, l3, 0L);
    }

    public /* synthetic */ long M(ZoneOffset zoneOffset) {
        return e.l(this, zoneOffset);
    }

    public b O(o o3, long l3) {
        if (o3 instanceof j$.time.temporal.j) {
            if (((j$.time.temporal.j)o3).e()) {
                return this.N(this.a, this.b.V(o3, l3));
            }
            return this.N(this.a.b(o3, l3), this.b);
        }
        return b.F(this.a.a(), o3.G(this, l3));
    }

    @Override
    public j$.time.chrono.e a() {
        return this.a.a();
    }

    @Override
    public j c() {
        return this.b;
    }

    @Override
    public /* synthetic */ int compareTo(ChronoLocalDateTime chronoLocalDateTime) {
        return e.e(this, chronoLocalDateTime);
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.compareTo((ChronoLocalDateTime)object);
    }

    @Override
    public ChronoLocalDate d() {
        return this.a;
    }

    @Override
    public Temporal e(l object) {
        j$.time.chrono.e e4;
        if (object instanceof ChronoLocalDate) {
            return this.N((ChronoLocalDate)object, this.b);
        }
        if (object instanceof j) {
            return this.N(this.a, (j)object);
        }
        if (object instanceof b) {
            e4 = this.a.a();
        } else {
            e4 = this.a.a();
            object = ((LocalDate)object).v(this);
        }
        return b.F(e4, (b)object);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof ChronoLocalDateTime) {
            return e.e(this, (ChronoLocalDateTime)object) == 0;
        }
        return false;
    }

    @Override
    public long f(o o3) {
        if (o3 instanceof j$.time.temporal.j) {
            if (((j$.time.temporal.j)o3).e()) {
                return this.b.f(o3);
            }
            return this.a.f(o3);
        }
        return o3.v(this);
    }

    @Override
    public boolean h(o o3) {
        boolean bl = o3 instanceof j$.time.temporal.j;
        boolean bl2 = true;
        if (bl) {
            j$.time.temporal.j j3 = (j$.time.temporal.j)o3;
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
        return this.a.hashCode() ^ this.b.hashCode();
    }

    @Override
    public int i(o o3) {
        if (o3 instanceof j$.time.temporal.j) {
            if (((j$.time.temporal.j)o3).e()) {
                return this.b.i(o3);
            }
            return this.a.i(o3);
        }
        return this.p(o3).a(this.f(o3), o3);
    }

    @Override
    public ChronoZonedDateTime n(ZoneId zoneId) {
        return d.F(this, zoneId, null);
    }

    @Override
    public r p(o o3) {
        if (o3 instanceof j$.time.temporal.j) {
            if (((j$.time.temporal.j)o3).e()) {
                j j3 = this.b;
                Objects.requireNonNull((Object)j3);
                return e.k(j3, o3);
            }
            return this.a.p(o3);
        }
        return o3.H(this);
    }

    @Override
    public /* synthetic */ Object t(TemporalQuery temporalQuery) {
        return e.i(this, temporalQuery);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.toString());
        stringBuilder.append('T');
        stringBuilder.append(this.b.toString());
        return stringBuilder.toString();
    }

    @Override
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        ChronoLocalDateTime chronoLocalDateTime;
        block10 : {
            block11 : {
                long l3;
                block12 : {
                    long l4;
                    Objects.requireNonNull((Object)temporal, (String)"endExclusive");
                    chronoLocalDateTime = this.a().u(temporal);
                    if (!(temporalUnit instanceof ChronoUnit)) break block10;
                    if (!temporalUnit.e()) break block11;
                    j$.time.temporal.j j3 = j$.time.temporal.j.EPOCH_DAY;
                    l3 = chronoLocalDateTime.f(j3) - this.a.f(j3);
                    switch (((ChronoUnit)temporalUnit).ordinal()) {
                        default: {
                            break block12;
                        }
                        case 6: {
                            l4 = 2L;
                            break;
                        }
                        case 5: {
                            l4 = 24L;
                            break;
                        }
                        case 4: {
                            l4 = 1440L;
                            break;
                        }
                        case 3: {
                            l4 = 86400L;
                            break;
                        }
                        case 2: {
                            l4 = 86400000L;
                            break;
                        }
                        case 1: {
                            l4 = 86400000000L;
                            break;
                        }
                        case 0: {
                            l4 = 86400000000000L;
                        }
                    }
                    l3 = e.F(l3, l4);
                }
                return e.C(l3, this.b.until(chronoLocalDateTime.c(), temporalUnit));
            }
            ChronoLocalDate chronoLocalDate = chronoLocalDateTime.d();
            boolean bl = chronoLocalDateTime.c().F(this.b) < 0;
            if (bl) {
                chronoLocalDate = chronoLocalDate.C(1L, ChronoUnit.DAYS);
            }
            return this.a.until(chronoLocalDate, temporalUnit);
        }
        Objects.requireNonNull((Object)temporalUnit, (String)"unit");
        return temporalUnit.between(this, chronoLocalDateTime);
    }

    @Override
    public /* synthetic */ Temporal v(Temporal temporal) {
        return e.d(this, temporal);
    }
}

