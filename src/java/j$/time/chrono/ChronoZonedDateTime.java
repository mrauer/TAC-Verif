/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Object
 */
package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.e;
import j$.time.j;
import j$.time.temporal.Temporal;
import j$.time.temporal.o;

public interface ChronoZonedDateTime<D extends ChronoLocalDate>
extends Temporal,
Comparable<ChronoZonedDateTime<?>> {
    public long I();

    public e a();

    public j c();

    public ChronoLocalDate d();

    @Override
    public long f(o var1);

    public ZoneOffset k();

    public ChronoZonedDateTime l(ZoneId var1);

    public ZoneId q();

    public ChronoLocalDateTime w();
}

