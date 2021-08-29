/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.f;
import j$.time.format.k;
import j$.time.temporal.TemporalAccessor;
import java.util.Map;

public interface e
extends Comparable<e> {
    public ChronoLocalDate A(f var1);

    public ChronoZonedDateTime B(Instant var1, ZoneId var2);

    public boolean equals(Object var1);

    public int j(e var1);

    public String m();

    public ChronoLocalDate o(TemporalAccessor var1);

    public ChronoZonedDateTime r(TemporalAccessor var1);

    public ChronoLocalDateTime u(TemporalAccessor var1);

    public ChronoLocalDate x(int var1, int var2, int var3);

    public ChronoLocalDate z(Map var1, j.k var2);
}

