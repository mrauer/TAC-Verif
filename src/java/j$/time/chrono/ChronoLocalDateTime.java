/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Comparable
 *  java.lang.Object
 */
package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.e;
import j$.time.j;
import j$.time.temporal.Temporal;
import j$.time.temporal.l;

public interface ChronoLocalDateTime<D extends ChronoLocalDate>
extends Temporal,
l,
Comparable<ChronoLocalDateTime<?>> {
    public e a();

    public j c();

    public int compareTo(ChronoLocalDateTime var1);

    public ChronoLocalDate d();

    public j.ChronoZonedDateTime n(ZoneId var1);
}

