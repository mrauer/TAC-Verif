/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDate
 *  j$.time.ZonedDateTime
 *  java.io.Serializable
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

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.e;
import j$.time.f;
import j$.time.format.DateTimeFormatter;
import j$.time.g;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.c;
import j$.time.temporal.d;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.l;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import java.io.Serializable;
import java.util.Objects;

public final class Instant
implements Temporal,
l,
Comparable<Instant>,
Serializable {
    public static final Instant a = new Instant(0L, 0);
    private final long b;
    private final int c;

    static {
        Instant.N(-31557014167219200L, 0L);
        Instant.N(31556889864403199L, 999999999L);
    }

    private Instant(long l2, int n2) {
        this.b = l2;
        this.c = n2;
    }

    private static Instant G(long l2, int n2) {
        if ((l2 | (long)n2) == 0L) {
            return a;
        }
        if (l2 >= -31557014167219200L && l2 <= 31556889864403199L) {
            return new Instant(l2, n2);
        }
        throw new g("Instant exceeds minimum or maximum instant");
    }

    public static Instant H(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Instant) {
            return (Instant)temporalAccessor;
        }
        Objects.requireNonNull((Object)temporalAccessor, (String)"temporal");
        try {
            Instant instant = Instant.N(temporalAccessor.f(j$.time.temporal.j.INSTANT_SECONDS), temporalAccessor.i(j$.time.temporal.j.NANO_OF_SECOND));
            return instant;
        }
        catch (g g2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to obtain Instant from TemporalAccessor: ");
            stringBuilder.append((Object)temporalAccessor);
            stringBuilder.append(" of type ");
            stringBuilder.append(temporalAccessor.getClass().getName());
            throw new g(stringBuilder.toString(), (Throwable)g2);
        }
    }

    private long L(Instant instant) {
        return e.C(e.F(e.G(instant.b, this.b), 1000000000L), instant.c - this.c);
    }

    public static Instant M(long l2) {
        return Instant.G(e.E(l2, 1000L), 1000000 * (int)e.D(l2, 1000L));
    }

    public static Instant N(long l2, long l3) {
        return Instant.G(e.C(l2, e.E(l3, 1000000000L)), (int)e.D(l3, 1000000000L));
    }

    private Instant O(long l2, long l3) {
        if ((l2 | l3) == 0L) {
            return this;
        }
        return Instant.N(e.C(e.C(this.b, l2), l3 / 1000000000L), l3 % 1000000000L + (long)this.c);
    }

    private long Q(Instant instant) {
        long l2 = e.G(instant.b, this.b);
        long l3 = instant.c - this.c;
        long l4 = l2 LCMP 0L;
        if (l4 > 0 && l3 < 0L) {
            return l2 - 1L;
        }
        if (l4 < 0 && l3 > 0L) {
            ++l2;
        }
        return l2;
    }

    public static Instant now() {
        return new f.a(ZoneOffset.UTC).b();
    }

    public static Instant ofEpochSecond(long l2) {
        return Instant.G(l2, 0);
    }

    public int F(Instant instant) {
        int n2 = Long.compare((long)this.b, (long)instant.b);
        if (n2 != 0) {
            return n2;
        }
        return this.c - instant.c;
    }

    public long J() {
        return this.b;
    }

    public int K() {
        return this.c;
    }

    public Instant P(long l2) {
        return this.O(l2, 0L);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public long R() {
        long l2;
        int n2;
        long l3 = this.b;
        if (l3 < 0L && this.c > 0) {
            l2 = e.F(l3 + 1L, 1000L);
            n2 = -1000 + this.c / 1000000;
            do {
                return e.C(l2, n2);
                break;
            } while (true);
        }
        l2 = e.F(l3, 1000L);
        n2 = this.c / 1000000;
        return e.C(l2, n2);
    }

    public j.ZonedDateTime atZone(ZoneId zoneId) {
        return j.ZonedDateTime.G((Instant)this, (ZoneId)zoneId);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Temporal b(o o2, long l2) {
        int n2;
        if (!(o2 instanceof j$.time.temporal.j)) return (Instant)o2.G(this, l2);
        j$.time.temporal.j j2 = (j$.time.temporal.j)o2;
        j2.K(l2);
        int n3 = j2.ordinal();
        if (n3 == 0) {
            if (l2 == (long)this.c) return this;
            return Instant.G(this.b, (int)l2);
        }
        if (n3 != 2) {
            if (n3 != 4) {
                if (n3 == 28) {
                    if (l2 == this.b) return this;
                    n2 = this.c;
                    return Instant.G(l2, n2);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append((Object)o2);
                throw new q(stringBuilder.toString());
            }
            n2 = 1000000 * (int)l2;
            if (n2 == this.c) return this;
        } else {
            n2 = 1000 * (int)l2;
            if (n2 == this.c) return this;
        }
        l2 = this.b;
        return Instant.G(l2, n2);
    }

    @Override
    public Temporal e(l l2) {
        return (Instant)((j.LocalDate)l2).v((Temporal)this);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Instant) {
            Instant instant = (Instant)object;
            return this.b == instant.b && this.c == instant.c;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public long f(o o2) {
        int n2;
        if (!(o2 instanceof j$.time.temporal.j)) return o2.v(this);
        int n3 = ((j$.time.temporal.j)o2).ordinal();
        if (n3 != 0) {
            if (n3 != 2) {
                if (n3 != 4) {
                    if (n3 == 28) {
                        return this.b;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported field: ");
                    stringBuilder.append((Object)o2);
                    throw new q(stringBuilder.toString());
                }
                n2 = this.c / 1000000;
                do {
                    return n2;
                    break;
                } while (true);
            }
            n2 = this.c / 1000;
            return n2;
        }
        n2 = this.c;
        return n2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Temporal g(long l2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) return (Instant)temporalUnit.p(this, l2);
        switch (((ChronoUnit)temporalUnit).ordinal()) {
            long l3;
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported unit: ");
                stringBuilder.append((Object)temporalUnit);
                throw new q(stringBuilder.toString());
            }
            case 7: {
                l3 = 86400L;
                return this.P(e.F(l2, l3));
            }
            case 6: {
                l3 = 43200L;
                return this.P(e.F(l2, l3));
            }
            case 5: {
                l3 = 3600L;
                return this.P(e.F(l2, l3));
            }
            case 4: {
                l3 = 60L;
                return this.P(e.F(l2, l3));
            }
            case 3: {
                return this.O(l2, 0L);
            }
            case 2: {
                return this.O(l2 / 1000L, 1000000L * (l2 % 1000L));
            }
            case 1: {
                return this.O(l2 / 1000000L, 1000L * (l2 % 1000000L));
            }
            case 0: 
        }
        return this.O(0L, l2);
    }

    @Override
    public boolean h(o o2) {
        boolean bl = o2 instanceof j$.time.temporal.j;
        boolean bl2 = true;
        if (bl) {
            if (o2 != j$.time.temporal.j.INSTANT_SECONDS && o2 != j$.time.temporal.j.NANO_OF_SECOND && o2 != j$.time.temporal.j.MICRO_OF_SECOND) {
                if (o2 == j$.time.temporal.j.MILLI_OF_SECOND) {
                    return bl2;
                }
                bl2 = false;
            }
            return bl2;
        }
        if (o2 != null && o2.F(this)) {
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        long l2 = this.b;
        return (int)(l2 ^ l2 >>> 32) + 51 * this.c;
    }

    @Override
    public int i(o o2) {
        if (o2 instanceof j$.time.temporal.j) {
            int n2 = ((j$.time.temporal.j)o2).ordinal();
            if (n2 != 0) {
                if (n2 != 2) {
                    if (n2 != 4) {
                        if (n2 == 28) {
                            j$.time.temporal.j.INSTANT_SECONDS.J(this.b);
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unsupported field: ");
                        stringBuilder.append((Object)o2);
                        throw new q(stringBuilder.toString());
                    }
                    return this.c / 1000000;
                }
                return this.c / 1000;
            }
            return this.c;
        }
        return e.k(this, o2).a(o2.v(this), o2);
    }

    public boolean isAfter(Instant instant) {
        return this.F(instant) > 0;
    }

    public boolean isBefore(Instant instant) {
        return this.F(instant) < 0;
    }

    @Override
    public r p(o o2) {
        return e.k(this, o2);
    }

    @Override
    public Object t(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.g.a) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery != d.a && temporalQuery != j$.time.temporal.f.a && temporalQuery != i.a && temporalQuery != j$.time.temporal.e.a && temporalQuery != c.a && temporalQuery != h.a) {
            return temporalQuery.queryFrom(this);
        }
        return null;
    }

    public String toString() {
        return DateTimeFormatter.d.a(this);
    }

    @Override
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        Instant instant = Instant.H(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            switch (((ChronoUnit)temporalUnit).ordinal()) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported unit: ");
                    stringBuilder.append((Object)temporalUnit);
                    throw new q(stringBuilder.toString());
                }
                case 7: {
                    return this.Q(instant) / 86400L;
                }
                case 6: {
                    return this.Q(instant) / 43200L;
                }
                case 5: {
                    return this.Q(instant) / 3600L;
                }
                case 4: {
                    return this.Q(instant) / 60L;
                }
                case 3: {
                    return this.Q(instant);
                }
                case 2: {
                    return e.G(instant.R(), this.R());
                }
                case 1: {
                    return this.L(instant) / 1000L;
                }
                case 0: 
            }
            return this.L(instant);
        }
        return temporalUnit.between(this, instant);
    }

    @Override
    public Temporal v(Temporal temporal) {
        return temporal.b(j$.time.temporal.j.INSTANT_SECONDS, this.b).b(j$.time.temporal.j.NANO_OF_SECOND, this.c);
    }
}

