/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package j$.time.temporal;

import j$.time.format.k;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.o;
import j$.time.temporal.r;
import java.util.Map;

public final class j
extends Enum<j>
implements o {
    public static final /* enum */ j ALIGNED_DAY_OF_WEEK_IN_MONTH;
    public static final /* enum */ j ALIGNED_DAY_OF_WEEK_IN_YEAR;
    public static final /* enum */ j ALIGNED_WEEK_OF_MONTH;
    public static final /* enum */ j ALIGNED_WEEK_OF_YEAR;
    public static final /* enum */ j AMPM_OF_DAY;
    public static final /* enum */ j CLOCK_HOUR_OF_AMPM;
    public static final /* enum */ j CLOCK_HOUR_OF_DAY;
    public static final /* enum */ j DAY_OF_MONTH;
    public static final /* enum */ j DAY_OF_WEEK;
    public static final /* enum */ j DAY_OF_YEAR;
    public static final /* enum */ j EPOCH_DAY;
    public static final /* enum */ j ERA;
    public static final /* enum */ j HOUR_OF_AMPM;
    public static final /* enum */ j HOUR_OF_DAY;
    public static final /* enum */ j INSTANT_SECONDS;
    public static final /* enum */ j MICRO_OF_DAY;
    public static final /* enum */ j MICRO_OF_SECOND;
    public static final /* enum */ j MILLI_OF_DAY;
    public static final /* enum */ j MILLI_OF_SECOND;
    public static final /* enum */ j MINUTE_OF_DAY;
    public static final /* enum */ j MINUTE_OF_HOUR;
    public static final /* enum */ j MONTH_OF_YEAR;
    public static final /* enum */ j NANO_OF_DAY;
    public static final /* enum */ j NANO_OF_SECOND;
    public static final /* enum */ j OFFSET_SECONDS;
    public static final /* enum */ j PROLEPTIC_MONTH;
    public static final /* enum */ j SECOND_OF_DAY;
    public static final /* enum */ j SECOND_OF_MINUTE;
    public static final /* enum */ j YEAR;
    public static final /* enum */ j YEAR_OF_ERA;
    private static final /* synthetic */ j[] a;
    private final String b;
    private final TemporalUnit c;
    private final TemporalUnit d;
    private final r e;

    static {
        j j2;
        j j3;
        j j4;
        j j5;
        j j6;
        j j7;
        j j8;
        j j9;
        j j10;
        j j11;
        j j12;
        j j13;
        j j14;
        j j15;
        j j16;
        j j17;
        j j18;
        j j19;
        j j20;
        j j21;
        j j22;
        j j23;
        j j24;
        j j25;
        j j26;
        j j27;
        j j28;
        j j29;
        j j30;
        j j31;
        ChronoUnit chronoUnit = ChronoUnit.NANOS;
        ChronoUnit chronoUnit2 = ChronoUnit.SECONDS;
        NANO_OF_SECOND = j28 = new j("NanoOfSecond", chronoUnit, chronoUnit2, r.i(0L, 999999999L));
        ChronoUnit chronoUnit3 = ChronoUnit.DAYS;
        NANO_OF_DAY = j16 = new j("NanoOfDay", chronoUnit, chronoUnit3, r.i(0L, 86399999999999L));
        ChronoUnit chronoUnit4 = ChronoUnit.MICROS;
        MICRO_OF_SECOND = j25 = new j("MicroOfSecond", chronoUnit4, chronoUnit2, r.i(0L, 999999L));
        MICRO_OF_DAY = j13 = new j("MicroOfDay", chronoUnit4, chronoUnit3, r.i(0L, 86399999999L));
        ChronoUnit chronoUnit5 = ChronoUnit.MILLIS;
        MILLI_OF_SECOND = j18 = new j("MilliOfSecond", chronoUnit5, chronoUnit2, r.i(0L, 999L));
        MILLI_OF_DAY = j15 = new j("MilliOfDay", chronoUnit5, chronoUnit3, r.i(0L, 86399999L));
        ChronoUnit chronoUnit6 = ChronoUnit.MINUTES;
        SECOND_OF_MINUTE = j24 = new j("SecondOfMinute", chronoUnit2, chronoUnit6, r.i(0L, 59L), "second");
        SECOND_OF_DAY = j5 = new j("SecondOfDay", chronoUnit2, chronoUnit3, r.i(0L, 86399L));
        ChronoUnit chronoUnit7 = ChronoUnit.HOURS;
        MINUTE_OF_HOUR = j17 = new j("MinuteOfHour", chronoUnit6, chronoUnit7, r.i(0L, 59L), "minute");
        MINUTE_OF_DAY = j29 = new j("MinuteOfDay", chronoUnit6, chronoUnit3, r.i(0L, 1439L));
        ChronoUnit chronoUnit8 = ChronoUnit.HALF_DAYS;
        HOUR_OF_AMPM = j22 = new j("HourOfAmPm", chronoUnit7, chronoUnit8, r.i(0L, 11L));
        CLOCK_HOUR_OF_AMPM = j2 = new j("ClockHourOfAmPm", chronoUnit7, chronoUnit8, r.i(1L, 12L));
        HOUR_OF_DAY = j9 = new j("HourOfDay", chronoUnit7, chronoUnit3, r.i(0L, 23L), "hour");
        CLOCK_HOUR_OF_DAY = j23 = new j("ClockHourOfDay", chronoUnit7, chronoUnit3, r.i(1L, 24L));
        AMPM_OF_DAY = j4 = new j("AmPmOfDay", chronoUnit8, chronoUnit3, r.i(0L, 1L), "dayperiod");
        ChronoUnit chronoUnit9 = ChronoUnit.WEEKS;
        DAY_OF_WEEK = j27 = new j("DayOfWeek", chronoUnit3, chronoUnit9, r.i(1L, 7L), "weekday");
        ALIGNED_DAY_OF_WEEK_IN_MONTH = j12 = new j("AlignedDayOfWeekInMonth", chronoUnit3, chronoUnit9, r.i(1L, 7L));
        ALIGNED_DAY_OF_WEEK_IN_YEAR = j21 = new j("AlignedDayOfWeekInYear", chronoUnit3, chronoUnit9, r.i(1L, 7L));
        ChronoUnit chronoUnit10 = ChronoUnit.MONTHS;
        DAY_OF_MONTH = j7 = new j("DayOfMonth", chronoUnit3, chronoUnit10, r.j(1L, 28L, 31L), "day");
        ChronoUnit chronoUnit11 = ChronoUnit.YEARS;
        DAY_OF_YEAR = j6 = new j("DayOfYear", chronoUnit3, chronoUnit11, r.j(1L, 365L, 366L));
        ChronoUnit chronoUnit12 = ChronoUnit.FOREVER;
        EPOCH_DAY = j20 = new j("EpochDay", chronoUnit3, chronoUnit12, r.i(-365249999634L, 365249999634L));
        ALIGNED_WEEK_OF_MONTH = j14 = new j("AlignedWeekOfMonth", chronoUnit9, chronoUnit10, r.j(1L, 4L, 5L));
        ALIGNED_WEEK_OF_YEAR = j30 = new j("AlignedWeekOfYear", chronoUnit9, chronoUnit11, r.i(1L, 53L));
        MONTH_OF_YEAR = j11 = new j("MonthOfYear", chronoUnit10, chronoUnit11, r.i(1L, 12L), "month");
        PROLEPTIC_MONTH = j3 = new j("ProlepticMonth", chronoUnit10, chronoUnit12, r.i(-11999999988L, 11999999999L));
        YEAR_OF_ERA = j19 = new j("YearOfEra", chronoUnit11, chronoUnit12, r.j(1L, 999999999L, 1000000000L));
        YEAR = j8 = new j("Year", chronoUnit11, chronoUnit12, r.i(-999999999L, 999999999L), "year");
        ERA = j31 = new j("Era", ChronoUnit.ERAS, chronoUnit12, r.i(0L, 1L), "era");
        INSTANT_SECONDS = j26 = new j("InstantSeconds", chronoUnit2, chronoUnit12, r.i(Long.MIN_VALUE, Long.MAX_VALUE));
        OFFSET_SECONDS = j10 = new j("OffsetSeconds", chronoUnit2, chronoUnit12, r.i(-64800L, 64800L));
        a = new j[]{j28, j16, j25, j13, j18, j15, j24, j5, j17, j29, j22, j2, j9, j23, j4, j27, j12, j21, j7, j6, j20, j14, j30, j11, j3, j19, j8, j31, j26, j10};
    }

    private j(String string2, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, r r2) {
        this.b = string2;
        this.c = temporalUnit;
        this.d = temporalUnit2;
        this.e = r2;
    }

    private j(String string2, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, r r2, String string3) {
        this.b = string2;
        this.c = temporalUnit;
        this.d = temporalUnit2;
        this.e = r2;
    }

    public static j valueOf(String string) {
        return (j)Enum.valueOf(j.class, (String)string);
    }

    public static j[] values() {
        return (j[])a.clone();
    }

    @Override
    public boolean F(TemporalAccessor temporalAccessor) {
        return temporalAccessor.h(this);
    }

    @Override
    public Temporal G(Temporal temporal, long l2) {
        return temporal.b(this, l2);
    }

    @Override
    public r H(TemporalAccessor temporalAccessor) {
        return temporalAccessor.p(this);
    }

    public int J(long l2) {
        return this.e.a(l2, this);
    }

    public long K(long l2) {
        this.e.b(l2, this);
        return l2;
    }

    @Override
    public boolean e() {
        return this.ordinal() < DAY_OF_WEEK.ordinal();
    }

    @Override
    public boolean i() {
        return this.ordinal() >= DAY_OF_WEEK.ordinal() && this.ordinal() <= ERA.ordinal();
    }

    @Override
    public r p() {
        return this.e;
    }

    @Override
    public /* synthetic */ TemporalAccessor t(Map map, TemporalAccessor temporalAccessor, k k2) {
        return null;
    }

    public String toString() {
        return this.b;
    }

    @Override
    public long v(TemporalAccessor temporalAccessor) {
        return temporalAccessor.f(this);
    }
}

