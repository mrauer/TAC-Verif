/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.String
 */
package j$.time.chrono;

import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.e;
import j$.time.j;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.l;
import j$.time.temporal.n;
import j$.time.temporal.o;

public interface ChronoLocalDate
extends Temporal,
l,
Comparable<ChronoLocalDate> {
    public ChronoLocalDate C(long var1, TemporalUnit var3);

    public int D();

    public int E(ChronoLocalDate var1);

    public e a();

    @Override
    public ChronoLocalDate b(o var1, long var2);

    public boolean equals(Object var1);

    @Override
    public ChronoLocalDate g(long var1, TemporalUnit var3);

    @Override
    public boolean h(o var1);

    public int hashCode();

    public ChronoLocalDateTime s(j var1);

    public long toEpochDay();

    public String toString();

    @Override
    public long until(Temporal var1, TemporalUnit var2);

    public ChronoLocalDate y(n var1);
}

