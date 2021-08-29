/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDate
 *  j$.time.LocalDateTime
 *  j$.time.ZonedDateTime
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Objects
 */
package j$.time;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.b;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.e;
import j$.time.f;
import j$.time.format.DateTimeFormatter;
import j$.time.g;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.d;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.l;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.zone.c;
import java.io.Serializable;
import java.util.Objects;

public final class OffsetDateTime
implements Temporal,
l,
Comparable<OffsetDateTime>,
Serializable {
    public static final OffsetDateTime MAX;
    private final j.LocalDateTime a;
    private final ZoneOffset b;

    static {
        new OffsetDateTime(j.LocalDateTime.a, ZoneOffset.e);
        MAX = new OffsetDateTime(j.LocalDateTime.b, ZoneOffset.d);
    }

    private OffsetDateTime(j.LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull((Object)localDateTime, (String)"dateTime");
        this.a = localDateTime;
        Objects.requireNonNull((Object)zoneOffset, (String)"offset");
        this.b = zoneOffset;
    }

    public static OffsetDateTime F(j.LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    public static OffsetDateTime G(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull((Object)instant, (String)"instant");
        Objects.requireNonNull((Object)zoneId, (String)"zone");
        ZoneOffset zoneOffset = c.j((ZoneOffset)zoneId).d(instant);
        return new OffsetDateTime(j.LocalDateTime.Q((long)instant.J(), (int)instant.K(), (ZoneOffset)zoneOffset), zoneOffset);
    }

    private OffsetDateTime J(j.LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        if (this.a == localDateTime && this.b.equals(zoneOffset)) {
            return this;
        }
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static OffsetDateTime from(TemporalAccessor temporalAccessor) {
        ZoneOffset zoneOffset;
        j.LocalDate localDate;
        j$.time.j j2;
        if (temporalAccessor instanceof OffsetDateTime) {
            return (OffsetDateTime)temporalAccessor;
        }
        try {
            zoneOffset = ZoneOffset.K(temporalAccessor);
            localDate = (j.LocalDate)temporalAccessor.t(j$.time.temporal.c.a);
            j2 = (j$.time.j)temporalAccessor.t(h.a);
            if (localDate == null) return OffsetDateTime.G(Instant.H(temporalAccessor), zoneOffset);
            if (j2 == null) return OffsetDateTime.G(Instant.H(temporalAccessor), zoneOffset);
        }
        catch (g g2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to obtain OffsetDateTime from TemporalAccessor: ");
            stringBuilder.append((Object)temporalAccessor);
            stringBuilder.append(" of type ");
            stringBuilder.append(temporalAccessor.getClass().getName());
            throw new g(stringBuilder.toString(), (Throwable)g2);
        }
        return new OffsetDateTime(j.LocalDateTime.P((j.LocalDate)localDate, (j$.time.j)j2), zoneOffset);
    }

    public static OffsetDateTime now() {
        f f2 = f.d();
        Instant instant = f2.b();
        return OffsetDateTime.G(instant, f2.a().G().d(instant));
    }

    public static OffsetDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull((Object)dateTimeFormatter, (String)"formatter");
        return (OffsetDateTime)dateTimeFormatter.parse(charSequence, b.a);
    }

    public j.LocalDateTime H() {
        return this.a;
    }

    public long I() {
        j.LocalDateTime localDateTime = this.a;
        ZoneOffset zoneOffset = this.b;
        Objects.requireNonNull((Object)localDateTime);
        return e.l((j.ChronoLocalDateTime)localDateTime, zoneOffset);
    }

    public j.ZonedDateTime atZoneSameInstant(ZoneId zoneId) {
        return j.ZonedDateTime.H((j.LocalDateTime)this.a, (ZoneOffset)this.b, (ZoneId)zoneId);
    }

    @Override
    public Temporal b(o o2, long l2) {
        if (o2 instanceof j$.time.temporal.j) {
            j$.time.temporal.j j2 = (j$.time.temporal.j)o2;
            int n2 = j2.ordinal();
            if (n2 != 28) {
                j.LocalDateTime localDateTime;
                ZoneOffset zoneOffset;
                if (n2 != 29) {
                    localDateTime = this.a.b0(o2, l2);
                    zoneOffset = this.b;
                } else {
                    localDateTime = this.a;
                    zoneOffset = ZoneOffset.O(j2.J(l2));
                }
                return this.J(localDateTime, zoneOffset);
            }
            return OffsetDateTime.G(Instant.N(l2, this.a.H()), this.b);
        }
        return (OffsetDateTime)o2.G(this, l2);
    }

    public j$.time.j c() {
        return this.a.c();
    }

    public int compareTo(Object object) {
        int n2;
        OffsetDateTime offsetDateTime = (OffsetDateTime)object;
        if (this.b.equals(offsetDateTime.b)) {
            n2 = this.a.compareTo((j.ChronoLocalDateTime)offsetDateTime.a);
        } else {
            n2 = Long.compare((long)this.I(), (long)offsetDateTime.I());
            if (n2 == 0) {
                n2 = this.c().K() - offsetDateTime.c().K();
            }
        }
        if (n2 == 0) {
            n2 = this.a.compareTo((j.ChronoLocalDateTime)offsetDateTime.a);
        }
        return n2;
    }

    @Override
    public Temporal e(l object) {
        if (!(object instanceof j.LocalDate || object instanceof j$.time.j || object instanceof j.LocalDateTime)) {
            if (object instanceof Instant) {
                return OffsetDateTime.G((Instant)object, this.b);
            }
            if (object instanceof ZoneOffset) {
                return this.J(this.a, (ZoneOffset)object);
            }
            if (!(object instanceof OffsetDateTime)) {
                object = ((j.LocalDate)object).v((Temporal)this);
            }
            return (OffsetDateTime)object;
        }
        return this.J(this.a.a0((l)object), this.b);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime)object;
            return this.a.equals((Object)offsetDateTime.a) && this.b.equals(offsetDateTime.b);
        }
        return false;
    }

    @Override
    public long f(o o2) {
        if (o2 instanceof j$.time.temporal.j) {
            int n2 = ((j$.time.temporal.j)o2).ordinal();
            if (n2 != 28) {
                if (n2 != 29) {
                    return this.a.f(o2);
                }
                return this.b.L();
            }
            return this.I();
        }
        return o2.v(this);
    }

    @Override
    public Temporal g(long l2, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return this.J(this.a.R(l2, temporalUnit), this.b);
        }
        return (OffsetDateTime)temporalUnit.p(this, l2);
    }

    @Override
    public boolean h(o o2) {
        return o2 instanceof j$.time.temporal.j || o2 != null && o2.F(this);
        {
        }
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    @Override
    public int i(o o2) {
        if (o2 instanceof j$.time.temporal.j) {
            int n2 = ((j$.time.temporal.j)o2).ordinal();
            if (n2 != 28) {
                if (n2 != 29) {
                    return this.a.i(o2);
                }
                return this.b.L();
            }
            throw new q("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        }
        return e.f(this, o2);
    }

    public boolean isBefore(OffsetDateTime offsetDateTime) {
        long l2 = this.I() LCMP offsetDateTime.I();
        return l2 < 0 || l2 == false && this.c().K() < offsetDateTime.c().K();
        {
        }
    }

    public ZoneOffset k() {
        return this.b;
    }

    @Override
    public r p(o o2) {
        if (o2 instanceof j$.time.temporal.j) {
            if (o2 != j$.time.temporal.j.INSTANT_SECONDS && o2 != j$.time.temporal.j.OFFSET_SECONDS) {
                return this.a.p(o2);
            }
            return o2.p();
        }
        return o2.H(this);
    }

    public OffsetDateTime plusHours(long l2) {
        return this.J(this.a.T(l2), this.b);
    }

    @Override
    public Object t(TemporalQuery temporalQuery) {
        if (temporalQuery != j$.time.temporal.e.a && temporalQuery != i.a) {
            if (temporalQuery == j$.time.temporal.f.a) {
                return null;
            }
            if (temporalQuery == j$.time.temporal.c.a) {
                return this.a.Y();
            }
            if (temporalQuery == h.a) {
                return this.c();
            }
            if (temporalQuery == d.a) {
                return j$.time.chrono.g.a;
            }
            if (temporalQuery == j$.time.temporal.g.a) {
                return ChronoUnit.NANOS;
            }
            return temporalQuery.queryFrom(this);
        }
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.toString());
        stringBuilder.append(this.b.toString());
        return stringBuilder.toString();
    }

    @Override
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        OffsetDateTime offsetDateTime = OffsetDateTime.from(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            OffsetDateTime offsetDateTime2 = offsetDateTime.withOffsetSameInstant(this.b);
            return this.a.until((Temporal)offsetDateTime2.a, temporalUnit);
        }
        return temporalUnit.between(this, offsetDateTime);
    }

    @Override
    public Temporal v(Temporal temporal) {
        return temporal.b(j$.time.temporal.j.EPOCH_DAY, this.a.Y().toEpochDay()).b(j$.time.temporal.j.NANO_OF_DAY, this.c().T()).b(j$.time.temporal.j.OFFSET_SECONDS, this.b.L());
    }

    public OffsetDateTime withOffsetSameInstant(ZoneOffset zoneOffset) {
        if (zoneOffset.equals(this.b)) {
            return this;
        }
        int n2 = zoneOffset.L() - this.b.L();
        return new OffsetDateTime(this.a.V((long)n2), zoneOffset);
    }
}

