/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.Objects
 */
package j$.time;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.OffsetDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.e;
import j$.time.f;
import j$.time.format.DateTimeFormatter;
import j$.time.g;
import j$.time.i;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.j;
import j$.time.temporal.l;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.zone.a;
import j$.time.zone.c;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public final class ZonedDateTime
implements Temporal,
ChronoZonedDateTime<LocalDate>,
Serializable {
    private final LocalDateTime a;
    private final ZoneOffset b;
    private final ZoneId c;

    private ZonedDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.a = localDateTime;
        this.b = zoneOffset;
        this.c = zoneId;
    }

    public static ZonedDateTime F(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof ZonedDateTime) {
            return (ZonedDateTime)temporalAccessor;
        }
        try {
            ZoneId zoneId = ZoneId.F(temporalAccessor);
            j j3 = j.INSTANT_SECONDS;
            if (temporalAccessor.h(j3)) {
                return ZonedDateTime.v(temporalAccessor.f(j3), temporalAccessor.i(j.NANO_OF_SECOND), zoneId);
            }
            ZonedDateTime zonedDateTime = ZonedDateTime.J(LocalDateTime.P(LocalDate.H(temporalAccessor), j$.time.j.H(temporalAccessor)), zoneId, null);
            return zonedDateTime;
        }
        catch (g g3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to obtain ZonedDateTime from TemporalAccessor: ");
            stringBuilder.append((Object)temporalAccessor);
            stringBuilder.append(" of type ");
            stringBuilder.append(temporalAccessor.getClass().getName());
            throw new g(stringBuilder.toString(), (Throwable)g3);
        }
    }

    public static ZonedDateTime G(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull((Object)instant, (String)"instant");
        Objects.requireNonNull((Object)zoneId, (String)"zone");
        return ZonedDateTime.v(instant.J(), instant.K(), zoneId);
    }

    public static ZonedDateTime H(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Objects.requireNonNull((Object)localDateTime, (String)"localDateTime");
        Objects.requireNonNull((Object)zoneOffset, (String)"offset");
        Objects.requireNonNull((Object)zoneId, (String)"zone");
        if (zoneId.G().g(localDateTime).contains((Object)zoneOffset)) {
            return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
        }
        return ZonedDateTime.v(e.l(localDateTime, zoneOffset), localDateTime.H(), zoneId);
    }

    public static ZonedDateTime J(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull((Object)localDateTime, (String)"localDateTime");
        Objects.requireNonNull((Object)zoneId, (String)"zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, (ZoneOffset)zoneId, zoneId);
        }
        c c4 = zoneId.G();
        List list = c4.g(localDateTime);
        if (list.size() == 1) {
            zoneOffset = (ZoneOffset)list.get(0);
        } else if (list.size() == 0) {
            a a4 = c4.f(localDateTime);
            localDateTime = localDateTime.V(a4.p().i());
            zoneOffset = a4.v();
        } else if (zoneOffset == null || !list.contains((Object)zoneOffset)) {
            zoneOffset = (ZoneOffset)list.get(0);
            Objects.requireNonNull((Object)zoneOffset, (String)"offset");
        }
        return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
    }

    private ZonedDateTime K(LocalDateTime localDateTime) {
        return ZonedDateTime.J(localDateTime, this.c, this.b);
    }

    private ZonedDateTime L(ZoneOffset zoneOffset) {
        if (!zoneOffset.equals(this.b) && this.c.G().g(this.a).contains((Object)zoneOffset)) {
            return new ZonedDateTime(this.a, zoneOffset, this.c);
        }
        return this;
    }

    public static ZonedDateTime now() {
        f f3 = f.d();
        return ZonedDateTime.G(f3.b(), f3.a());
    }

    public static ZonedDateTime parse(CharSequence charSequence) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.c;
        Objects.requireNonNull((Object)dateTimeFormatter, (String)"formatter");
        return (ZonedDateTime)dateTimeFormatter.parse(charSequence, j$.time.a.a);
    }

    private static ZonedDateTime v(long l3, int n3, ZoneId zoneId) {
        ZoneOffset zoneOffset = zoneId.G().d(Instant.N(l3, n3));
        return new ZonedDateTime(LocalDateTime.Q(l3, n3, zoneOffset), zoneOffset, zoneId);
    }

    @Override
    public /* synthetic */ long I() {
        return j$.time.chrono.c.d(this);
    }

    public LocalDateTime M() {
        return this.a;
    }

    public ZonedDateTime N(l l3) {
        if (l3 instanceof LocalDate) {
            return ZonedDateTime.J(LocalDateTime.P((LocalDate)l3, this.a.c()), this.c, this.b);
        }
        if (l3 instanceof j$.time.j) {
            return ZonedDateTime.J(LocalDateTime.P(this.a.Y(), (j$.time.j)l3), this.c, this.b);
        }
        if (l3 instanceof LocalDateTime) {
            return this.K((LocalDateTime)l3);
        }
        if (l3 instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime)l3;
            return ZonedDateTime.J(offsetDateTime.H(), this.c, offsetDateTime.k());
        }
        if (l3 instanceof Instant) {
            Instant instant = (Instant)l3;
            return ZonedDateTime.v(instant.J(), instant.K(), this.c);
        }
        if (l3 instanceof ZoneOffset) {
            return this.L((ZoneOffset)l3);
        }
        return (ZonedDateTime)l3.v(this);
    }

    @Override
    public j$.time.chrono.e a() {
        Objects.requireNonNull((Object)((LocalDate)this.d()));
        return j$.time.chrono.g.a;
    }

    @Override
    public Temporal b(o o3, long l3) {
        if (o3 instanceof j) {
            j j3 = (j)o3;
            int n3 = j3.ordinal();
            if (n3 != 28) {
                if (n3 != 29) {
                    return this.K(this.a.b0(o3, l3));
                }
                return this.L(ZoneOffset.O(j3.J(l3)));
            }
            return ZonedDateTime.v(l3, this.a.H(), this.c);
        }
        return (ZonedDateTime)o3.G(this, l3);
    }

    @Override
    public j$.time.j c() {
        return this.a.c();
    }

    public /* synthetic */ int compareTo(Object object) {
        return j$.time.chrono.c.a(this, (ChronoZonedDateTime)object);
    }

    @Override
    public ChronoLocalDate d() {
        return this.a.Y();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime)object;
            return this.a.equals(zonedDateTime.a) && this.b.equals(zonedDateTime.b) && this.c.equals(zonedDateTime.c);
        }
        return false;
    }

    @Override
    public long f(o o3) {
        if (o3 instanceof j) {
            int n3 = ((j)o3).ordinal();
            if (n3 != 28) {
                if (n3 != 29) {
                    return this.a.f(o3);
                }
                return this.b.L();
            }
            return j$.time.chrono.c.d(this);
        }
        return o3.v(this);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull((Object)dateTimeFormatter, (String)"formatter");
        return dateTimeFormatter.a(this);
    }

    @Override
    public Temporal g(long l3, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            if (temporalUnit.i()) {
                return this.K(this.a.R(l3, temporalUnit));
            }
            return ZonedDateTime.H(this.a.R(l3, temporalUnit), this.b, this.c);
        }
        return (ZonedDateTime)temporalUnit.p(this, l3);
    }

    @Override
    public boolean h(o o3) {
        return o3 instanceof j || o3 != null && o3.F(this);
        {
        }
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode() ^ Integer.rotateLeft((int)this.c.hashCode(), (int)3);
    }

    @Override
    public int i(o o3) {
        if (o3 instanceof j) {
            int n3 = ((j)o3).ordinal();
            if (n3 != 28) {
                if (n3 != 29) {
                    return this.a.i(o3);
                }
                return this.b.L();
            }
            throw new q("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        }
        return j$.time.chrono.c.b(this, o3);
    }

    public boolean isAfter(ChronoZonedDateTime chronoZonedDateTime) {
        long l3 = this.I() LCMP chronoZonedDateTime.I();
        return l3 > 0 || l3 == false && this.c().K() > chronoZonedDateTime.c().K();
        {
        }
    }

    public boolean isBefore(ChronoZonedDateTime chronoZonedDateTime) {
        long l3 = this.I() LCMP chronoZonedDateTime.I();
        return l3 < 0 || l3 == false && this.c().K() < chronoZonedDateTime.c().K();
        {
        }
    }

    @Override
    public ZoneOffset k() {
        return this.b;
    }

    @Override
    public r p(o o3) {
        if (o3 instanceof j) {
            if (o3 != j.INSTANT_SECONDS && o3 != j.OFFSET_SECONDS) {
                return this.a.p(o3);
            }
            return o3.p();
        }
        return o3.H(this);
    }

    @Override
    public ZoneId q() {
        return this.c;
    }

    @Override
    public Object t(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.c.a) {
            return this.a.Y();
        }
        return j$.time.chrono.c.c(this, temporalQuery);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.toString());
        stringBuilder.append(this.b.toString());
        String string = stringBuilder.toString();
        if (this.b != this.c) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append('[');
            stringBuilder2.append(this.c.toString());
            stringBuilder2.append(']');
            string = stringBuilder2.toString();
        }
        return string;
    }

    @Override
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        ZonedDateTime zonedDateTime = ZonedDateTime.F(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            ZonedDateTime zonedDateTime2 = zonedDateTime.withZoneSameInstant(this.c);
            if (temporalUnit.i()) {
                return this.a.until(zonedDateTime2.a, temporalUnit);
            }
            return OffsetDateTime.F(this.a, this.b).until(OffsetDateTime.F(zonedDateTime2.a, zonedDateTime2.b), temporalUnit);
        }
        return temporalUnit.between(this, zonedDateTime);
    }

    @Override
    public ChronoLocalDateTime w() {
        return this.a;
    }

    public ZonedDateTime withZoneSameInstant(ZoneId zoneId) {
        Objects.requireNonNull((Object)zoneId, (String)"zone");
        if (this.c.equals(zoneId)) {
            return this;
        }
        LocalDateTime localDateTime = this.a;
        ZoneOffset zoneOffset = this.b;
        Objects.requireNonNull((Object)localDateTime);
        return ZonedDateTime.v(e.l(localDateTime, zoneOffset), this.a.H(), zoneId);
    }
}

