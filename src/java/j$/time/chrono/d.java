/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.ClassCastException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  java.util.Objects
 */
package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.b;
import j$.time.chrono.c;
import j$.time.e;
import j$.time.i;
import j$.time.j;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.l;
import j$.time.temporal.o;
import j$.time.temporal.r;
import j$.time.zone.a;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

final class d<D extends ChronoLocalDate>
implements ChronoZonedDateTime<D>,
Serializable {
    private final transient b a;
    private final transient ZoneOffset b;
    private final transient ZoneId c;

    private d(b b4, ZoneOffset zoneOffset, ZoneId zoneId) {
        Objects.requireNonNull((Object)b4, (String)"dateTime");
        this.a = b4;
        this.b = zoneOffset;
        this.c = zoneId;
    }

    /*
     * Enabled aggressive block sorting
     */
    static ChronoZonedDateTime F(b b4, ZoneId zoneId, ZoneOffset zoneOffset) {
        block6 : {
            List list;
            block4 : {
                block5 : {
                    LocalDateTime localDateTime;
                    Objects.requireNonNull((Object)b4, (String)"localDateTime");
                    Objects.requireNonNull((Object)zoneId, (String)"zone");
                    if (zoneId instanceof ZoneOffset) {
                        return new d<D>(b4, (ZoneOffset)zoneId, zoneId);
                    }
                    j$.time.zone.c c4 = zoneId.G();
                    list = c4.g(localDateTime = LocalDateTime.G(b4));
                    if (list.size() == 1) break block4;
                    if (list.size() != 0) break block5;
                    a a4 = c4.f(localDateTime);
                    b4 = b4.K(a4.p().i());
                    zoneOffset = a4.v();
                    break block6;
                }
                if (zoneOffset != null && list.contains((Object)zoneOffset)) break block6;
            }
            zoneOffset = (ZoneOffset)list.get(0);
        }
        Objects.requireNonNull((Object)zoneOffset, (String)"offset");
        return new d<D>(b4, zoneOffset, zoneId);
    }

    static d G(j$.time.chrono.e e4, Instant instant, ZoneId zoneId) {
        ZoneOffset zoneOffset = zoneId.G().d(instant);
        Objects.requireNonNull((Object)zoneOffset, (String)"offset");
        return new d<D>((b)e4.u(LocalDateTime.Q(instant.J(), instant.K(), zoneOffset)), zoneOffset, zoneId);
    }

    static d v(j$.time.chrono.e e4, Temporal temporal) {
        d d4 = (d)temporal;
        if (e4.equals(d4.a())) {
            return d4;
        }
        StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("Chronology mismatch, required: ");
        stringBuilder.append(e4.m());
        stringBuilder.append(", actual: ");
        stringBuilder.append(d4.a().m());
        throw new ClassCastException(stringBuilder.toString());
    }

    public ChronoZonedDateTime H(long l3, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            b b4 = this.a.G(l3, temporalUnit);
            return d.v(this.a(), b4.v(this));
        }
        return d.v(this.a(), temporalUnit.p(this, l3));
    }

    @Override
    public /* synthetic */ long I() {
        return c.d(this);
    }

    public ChronoZonedDateTime J(l l3) {
        return d.v(this.a(), l3.v(this));
    }

    @Override
    public j$.time.chrono.e a() {
        return this.d().a();
    }

    @Override
    public Temporal b(o o3, long l3) {
        if (o3 instanceof j$.time.temporal.j) {
            j$.time.temporal.j j3 = (j$.time.temporal.j)o3;
            int n3 = j3.ordinal();
            if (n3 != 28) {
                if (n3 != 29) {
                    return d.F(this.a.O(o3, l3), this.c, this.b);
                }
                ZoneOffset zoneOffset = ZoneOffset.O(j3.J(l3));
                b b4 = this.a;
                Instant instant = Instant.N(b4.M(zoneOffset), b4.c().K());
                ZoneId zoneId = this.c;
                return d.G(this.a(), instant, zoneId);
            }
            return this.H(l3 - c.d(this), ChronoUnit.SECONDS);
        }
        return d.v(this.a(), o3.G(this, l3));
    }

    @Override
    public j c() {
        return ((b)this.w()).c();
    }

    public /* synthetic */ int compareTo(Object object) {
        return c.a(this, (ChronoZonedDateTime)object);
    }

    @Override
    public ChronoLocalDate d() {
        return ((b)this.w()).d();
    }

    @Override
    public /* synthetic */ Temporal e(l l3) {
        return this.J(l3);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof ChronoZonedDateTime) {
            return c.a(this, (ChronoZonedDateTime)object) == 0;
        }
        return false;
    }

    @Override
    public long f(o o3) {
        if (o3 instanceof j$.time.temporal.j) {
            int n3 = ((j$.time.temporal.j)o3).ordinal();
            if (n3 != 28) {
                if (n3 != 29) {
                    return ((b)this.w()).f(o3);
                }
                return this.k().L();
            }
            return this.I();
        }
        return o3.v(this);
    }

    @Override
    public boolean h(o o3) {
        return o3 instanceof j$.time.temporal.j || o3 != null && o3.F(this);
        {
        }
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode() ^ Integer.rotateLeft((int)this.c.hashCode(), (int)3);
    }

    @Override
    public /* synthetic */ int i(o o3) {
        return c.b(this, o3);
    }

    @Override
    public ZoneOffset k() {
        return this.b;
    }

    @Override
    public ChronoZonedDateTime l(ZoneId zoneId) {
        Objects.requireNonNull((Object)zoneId, (String)"zone");
        if (this.c.equals(zoneId)) {
            return this;
        }
        b b4 = this.a;
        ZoneOffset zoneOffset = this.b;
        Objects.requireNonNull((Object)b4);
        Instant instant = Instant.N(e.l(b4, zoneOffset), b4.c().K());
        return d.G(this.a(), instant, zoneId);
    }

    @Override
    public r p(o o3) {
        if (o3 instanceof j$.time.temporal.j) {
            if (o3 != j$.time.temporal.j.INSTANT_SECONDS && o3 != j$.time.temporal.j.OFFSET_SECONDS) {
                return ((b)this.w()).p(o3);
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
    public /* synthetic */ Object t(TemporalQuery temporalQuery) {
        return c.c(this, temporalQuery);
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
        Objects.requireNonNull((Object)temporal, (String)"endExclusive");
        ChronoZonedDateTime chronoZonedDateTime = this.a().r(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            ChronoZonedDateTime chronoZonedDateTime2 = chronoZonedDateTime.l(this.b);
            return this.a.until(chronoZonedDateTime2.w(), temporalUnit);
        }
        Objects.requireNonNull((Object)temporalUnit, (String)"unit");
        return temporalUnit.between(this, chronoZonedDateTime);
    }

    @Override
    public ChronoLocalDateTime w() {
        return this.a;
    }
}

