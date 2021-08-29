/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.g;
import j$.time.e;
import j$.time.j;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.d;
import j$.time.temporal.f;
import j$.time.temporal.h;
import j$.time.temporal.i;
import j$.time.temporal.o;
import j$.time.temporal.q;
import java.util.Objects;

public final class c {
    public static int a(ChronoZonedDateTime chronoZonedDateTime, ChronoZonedDateTime chronoZonedDateTime2) {
        int n2 = Long.compare((long)chronoZonedDateTime.I(), (long)chronoZonedDateTime2.I());
        if (n2 == 0 && (n2 = chronoZonedDateTime.c().K() - chronoZonedDateTime2.c().K()) == 0 && (n2 = chronoZonedDateTime.w().compareTo(chronoZonedDateTime2.w())) == 0 && (n2 = chronoZonedDateTime.q().m().compareTo(chronoZonedDateTime2.q().m())) == 0) {
            n2 = chronoZonedDateTime.a().j(chronoZonedDateTime2.a());
        }
        return n2;
    }

    public static int b(ChronoZonedDateTime chronoZonedDateTime, o o2) {
        if (o2 instanceof j$.time.temporal.j) {
            int n2 = ((j$.time.temporal.j)o2).ordinal();
            if (n2 != 28) {
                if (n2 != 29) {
                    return chronoZonedDateTime.w().i(o2);
                }
                return chronoZonedDateTime.k().L();
            }
            throw new q("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        }
        return e.f(chronoZonedDateTime, o2);
    }

    public static Object c(ChronoZonedDateTime chronoZonedDateTime, TemporalQuery temporalQuery) {
        if (temporalQuery != i.a && temporalQuery != f.a) {
            if (temporalQuery == j$.time.temporal.e.a) {
                return chronoZonedDateTime.k();
            }
            if (temporalQuery == h.a) {
                return chronoZonedDateTime.c();
            }
            if (temporalQuery == d.a) {
                return chronoZonedDateTime.a();
            }
            if (temporalQuery == j$.time.temporal.g.a) {
                return ChronoUnit.NANOS;
            }
            return temporalQuery.queryFrom(chronoZonedDateTime);
        }
        return chronoZonedDateTime.q();
    }

    public static long d(ChronoZonedDateTime chronoZonedDateTime) {
        return 86400L * chronoZonedDateTime.d().toEpochDay() + (long)chronoZonedDateTime.c().U() - (long)chronoZonedDateTime.k().L();
    }

    public static j$.time.chrono.e e(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull((Object)temporalAccessor, (String)"temporal");
        j$.time.chrono.e e2 = (j$.time.chrono.e)temporalAccessor.t(d.a);
        if (e2 != null) {
            return e2;
        }
        return g.a;
    }
}

