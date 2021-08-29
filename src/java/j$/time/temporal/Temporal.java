/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Object
 */
package j$.time.temporal;

import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.l;
import j$.time.temporal.o;

public interface Temporal
extends TemporalAccessor {
    public Temporal b(o var1, long var2);

    public Temporal e(j.l var1);

    public Temporal g(long var1, j.TemporalUnit var3);

    public long until(Temporal var1, j.TemporalUnit var2);
}

