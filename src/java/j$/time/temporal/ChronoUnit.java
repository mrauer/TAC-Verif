/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package j$.time.temporal;

import j$.time.i;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalUnit;

public final class ChronoUnit
extends Enum<ChronoUnit>
implements TemporalUnit {
    public static final /* enum */ ChronoUnit CENTURIES;
    public static final /* enum */ ChronoUnit DAYS;
    public static final /* enum */ ChronoUnit DECADES;
    public static final /* enum */ ChronoUnit ERAS;
    public static final /* enum */ ChronoUnit FOREVER;
    public static final /* enum */ ChronoUnit HALF_DAYS;
    public static final /* enum */ ChronoUnit HOURS;
    public static final /* enum */ ChronoUnit MICROS;
    public static final /* enum */ ChronoUnit MILLENNIA;
    public static final /* enum */ ChronoUnit MILLIS;
    public static final /* enum */ ChronoUnit MINUTES;
    public static final /* enum */ ChronoUnit MONTHS;
    public static final /* enum */ ChronoUnit NANOS;
    public static final /* enum */ ChronoUnit SECONDS;
    public static final /* enum */ ChronoUnit WEEKS;
    public static final /* enum */ ChronoUnit YEARS;
    private static final /* synthetic */ ChronoUnit[] a;
    private final String b;

    static {
        ChronoUnit chronoUnit;
        ChronoUnit chronoUnit2;
        ChronoUnit chronoUnit3;
        ChronoUnit chronoUnit4;
        ChronoUnit chronoUnit5;
        ChronoUnit chronoUnit6;
        ChronoUnit chronoUnit7;
        ChronoUnit chronoUnit8;
        ChronoUnit chronoUnit9;
        ChronoUnit chronoUnit10;
        ChronoUnit chronoUnit11;
        ChronoUnit chronoUnit12;
        ChronoUnit chronoUnit13;
        ChronoUnit chronoUnit14;
        ChronoUnit chronoUnit15;
        ChronoUnit chronoUnit16;
        NANOS = chronoUnit9 = new ChronoUnit("Nanos", i.p(1L));
        MICROS = chronoUnit10 = new ChronoUnit("Micros", i.p(1000L));
        MILLIS = chronoUnit = new ChronoUnit("Millis", i.p(1000000L));
        SECONDS = chronoUnit16 = new ChronoUnit("Seconds", i.t(1L));
        MINUTES = chronoUnit13 = new ChronoUnit("Minutes", i.t(60L));
        HOURS = chronoUnit5 = new ChronoUnit("Hours", i.t(3600L));
        HALF_DAYS = chronoUnit8 = new ChronoUnit("HalfDays", i.t(43200L));
        DAYS = chronoUnit14 = new ChronoUnit("Days", i.t(86400L));
        WEEKS = chronoUnit3 = new ChronoUnit("Weeks", i.t(604800L));
        MONTHS = chronoUnit11 = new ChronoUnit("Months", i.t(2629746L));
        YEARS = chronoUnit12 = new ChronoUnit("Years", i.t(31556952L));
        DECADES = chronoUnit6 = new ChronoUnit("Decades", i.t(315569520L));
        CENTURIES = chronoUnit15 = new ChronoUnit("Centuries", i.t(3155695200L));
        MILLENNIA = chronoUnit2 = new ChronoUnit("Millennia", i.t(31556952000L));
        ERAS = chronoUnit4 = new ChronoUnit("Eras", i.t(31556952000000000L));
        FOREVER = chronoUnit7 = new ChronoUnit("Forever", i.v(Long.MAX_VALUE, 999999999L));
        a = new ChronoUnit[]{chronoUnit9, chronoUnit10, chronoUnit, chronoUnit16, chronoUnit13, chronoUnit5, chronoUnit8, chronoUnit14, chronoUnit3, chronoUnit11, chronoUnit12, chronoUnit6, chronoUnit15, chronoUnit2, chronoUnit4, chronoUnit7};
    }

    private ChronoUnit(String string2, i i2) {
        this.b = string2;
    }

    public static ChronoUnit valueOf(String string) {
        return (ChronoUnit)Enum.valueOf(ChronoUnit.class, (String)string);
    }

    public static ChronoUnit[] values() {
        return (ChronoUnit[])a.clone();
    }

    @Override
    public long between(Temporal temporal, Temporal temporal2) {
        return temporal.until(temporal2, this);
    }

    @Override
    public boolean e() {
        return this.compareTo((Enum)DAYS) < 0;
    }

    @Override
    public boolean i() {
        return this.compareTo((Enum)DAYS) >= 0 && this != FOREVER;
    }

    @Override
    public Temporal p(Temporal temporal, long l2) {
        return temporal.g(l2, this);
    }

    public String toString() {
        return this.b;
    }
}

