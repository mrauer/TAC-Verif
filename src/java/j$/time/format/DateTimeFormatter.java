/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.text.ParsePosition
 *  java.util.HashMap
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Objects
 *  java.util.Set
 */
package j$.time.format;

import j$.time.ZoneId;
import j$.time.format.c;
import j$.time.format.d;
import j$.time.format.e;
import j$.time.format.i;
import j$.time.format.k;
import j$.time.format.l;
import j$.time.g;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.o;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class DateTimeFormatter {
    public static final DateTimeFormatter ISO_DATE;
    public static final DateTimeFormatter ISO_DATE_TIME;
    public static final DateTimeFormatter ISO_OFFSET_DATE_TIME;
    public static final DateTimeFormatter a;
    public static final DateTimeFormatter b;
    public static final DateTimeFormatter c;
    public static final DateTimeFormatter d;
    private final c.c e;
    private final Locale f;
    private final j.i g;
    private final k h;
    private final Set i;
    private final j$.time.chrono.e j;
    private final ZoneId k;

    static {
        DateTimeFormatter dateTimeFormatter;
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        c c2 = new c();
        j$.time.temporal.j j2 = j$.time.temporal.j.YEAR;
        l l2 = l.EXCEEDS_PAD;
        c c4 = c2.p(j2, 4, 10, l2);
        c4.e('-');
        j$.time.temporal.j j3 = j$.time.temporal.j.MONTH_OF_YEAR;
        c4.o(j3, 2);
        c4.e('-');
        j$.time.temporal.j j4 = j$.time.temporal.j.DAY_OF_MONTH;
        c4.o(j4, 2);
        k k2 = k.STRICT;
        j$.time.chrono.g g2 = j$.time.chrono.g.a;
        a = dateTimeFormatter2 = c4.x(k2, g2);
        c c5 = new c();
        c5.t();
        c5.a(dateTimeFormatter2);
        c5.i();
        c5.x(k2, g2);
        c c6 = new c();
        c6.t();
        c6.a(dateTimeFormatter2);
        c6.s();
        c6.i();
        ISO_DATE = c6.x(k2, g2);
        c c7 = new c();
        j$.time.temporal.j j5 = j$.time.temporal.j.HOUR_OF_DAY;
        c7.o(j5, 2);
        c7.e(':');
        j$.time.temporal.j j6 = j$.time.temporal.j.MINUTE_OF_HOUR;
        c7.o(j6, 2);
        c7.s();
        c7.e(':');
        j$.time.temporal.j j7 = j$.time.temporal.j.SECOND_OF_MINUTE;
        c7.o(j7, 2);
        c7.s();
        c7.b(j$.time.temporal.j.NANO_OF_SECOND, 0, 9, true);
        DateTimeFormatter dateTimeFormatter4 = c7.x(k2, null);
        c c8 = new c();
        c8.t();
        c8.a(dateTimeFormatter4);
        c8.i();
        c8.x(k2, null);
        c c9 = new c();
        c9.t();
        c9.a(dateTimeFormatter4);
        c9.s();
        c9.i();
        c9.x(k2, null);
        c c10 = new c();
        c10.t();
        c10.a(dateTimeFormatter2);
        c10.e('T');
        c10.a(dateTimeFormatter4);
        b = dateTimeFormatter3 = c10.x(k2, g2);
        c c11 = new c();
        c11.t();
        c11.a(dateTimeFormatter3);
        c11.i();
        ISO_OFFSET_DATE_TIME = dateTimeFormatter = c11.x(k2, g2);
        c c12 = new c();
        c12.a(dateTimeFormatter);
        c12.s();
        c12.e('[');
        c12.u();
        c12.q();
        c12.e(']');
        c = c12.x(k2, g2);
        c c13 = new c();
        c13.a(dateTimeFormatter3);
        c13.s();
        c13.i();
        c13.s();
        c13.e('[');
        c13.u();
        c13.q();
        c13.e(']');
        ISO_DATE_TIME = c13.x(k2, g2);
        c c14 = new c();
        c14.t();
        c c15 = c14.p(j2, 4, 10, l2);
        c15.e('-');
        c15.o(j$.time.temporal.j.DAY_OF_YEAR, 3);
        c15.s();
        c15.i();
        c15.x(k2, g2);
        c c16 = new c();
        c16.t();
        c c17 = c16.p(j$.time.temporal.k.c, 4, 10, l2);
        c17.f("-W");
        c17.o(j$.time.temporal.k.b, 2);
        c17.e('-');
        j$.time.temporal.j j8 = j$.time.temporal.j.DAY_OF_WEEK;
        c17.o(j8, 1);
        c17.s();
        c17.i();
        c17.x(k2, g2);
        c c18 = new c();
        c18.t();
        c18.c();
        d = c18.x(k2, null);
        c c19 = new c();
        c19.t();
        c19.o(j2, 4);
        c19.o(j3, 2);
        c19.o(j4, 2);
        c19.s();
        c19.h("+HHMMss", "Z");
        c19.x(k2, g2);
        HashMap hashMap = new HashMap();
        Long l3 = 1L;
        hashMap.put((Object)l3, (Object)"Mon");
        Long l4 = 2L;
        hashMap.put((Object)l4, (Object)"Tue");
        Long l5 = 3L;
        hashMap.put((Object)l5, (Object)"Wed");
        Long l6 = 4L;
        hashMap.put((Object)l6, (Object)"Thu");
        Long l7 = 5L;
        hashMap.put((Object)l7, (Object)"Fri");
        Long l8 = 6L;
        hashMap.put((Object)l8, (Object)"Sat");
        Long l9 = 7L;
        hashMap.put((Object)l9, (Object)"Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)l3, (Object)"Jan");
        hashMap2.put((Object)l4, (Object)"Feb");
        hashMap2.put((Object)l5, (Object)"Mar");
        hashMap2.put((Object)l6, (Object)"Apr");
        hashMap2.put((Object)l7, (Object)"May");
        hashMap2.put((Object)l8, (Object)"Jun");
        hashMap2.put((Object)l9, (Object)"Jul");
        hashMap2.put((Object)8L, (Object)"Aug");
        hashMap2.put((Object)9L, (Object)"Sep");
        hashMap2.put((Object)10L, (Object)"Oct");
        hashMap2.put((Object)11L, (Object)"Nov");
        hashMap2.put((Object)12L, (Object)"Dec");
        c c20 = new c();
        c20.t();
        c20.v();
        c20.s();
        c20.l(j8, (Map)hashMap);
        c20.f(", ");
        c20.r();
        c c21 = c20.p(j4, 1, 2, l.NOT_NEGATIVE);
        c21.e(' ');
        c21.l(j3, (Map)hashMap2);
        c21.e(' ');
        c21.o(j2, 4);
        c21.e(' ');
        c21.o(j5, 2);
        c21.e(':');
        c21.o(j6, 2);
        c21.s();
        c21.e(':');
        c21.o(j7, 2);
        c21.r();
        c21.e(' ');
        c21.h("+HHMM", "GMT");
        c21.x(k.SMART, g2);
    }

    DateTimeFormatter(c.c c2, Locale locale, j.i i2, k k2, Set set, j$.time.chrono.e e2, ZoneId zoneId) {
        this.e = c2;
        this.i = null;
        this.f = locale;
        this.g = i2;
        Objects.requireNonNull((Object)((Object)k2), (String)"resolverStyle");
        this.h = k2;
        this.j = e2;
        this.k = null;
    }

    private TemporalAccessor f(CharSequence charSequence, ParsePosition parsePosition) {
        String string;
        d d2 = new d(this);
        ParsePosition parsePosition2 = new ParsePosition(0);
        int n2 = parsePosition2.getIndex();
        int n3 = this.e.i(d2, charSequence, n2);
        if (n3 < 0) {
            parsePosition2.setErrorIndex(n3);
            d2 = null;
        } else {
            parsePosition2.setIndex(n3);
        }
        if (d2 != null && parsePosition2.getErrorIndex() < 0 && parsePosition2.getIndex() >= charSequence.length()) {
            return d2.t(this.h, this.i);
        }
        if (charSequence.length() > 64) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(charSequence.subSequence(0, 64).toString());
            stringBuilder.append("...");
            string = stringBuilder.toString();
        } else {
            string = charSequence.toString();
        }
        if (parsePosition2.getErrorIndex() >= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Text '");
            stringBuilder.append(string);
            stringBuilder.append("' could not be parsed at index ");
            stringBuilder.append(parsePosition2.getErrorIndex());
            throw new e(stringBuilder.toString(), charSequence, parsePosition2.getErrorIndex());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Text '");
        stringBuilder.append(string);
        stringBuilder.append("' could not be parsed, unparsed text found at index ");
        stringBuilder.append(parsePosition2.getIndex());
        throw new e(stringBuilder.toString(), charSequence, parsePosition2.getIndex());
    }

    public static DateTimeFormatter ofPattern(String string) {
        c c2 = new c();
        c2.j(string);
        return c2.w();
    }

    public String a(TemporalAccessor temporalAccessor) {
        StringBuilder stringBuilder = new StringBuilder(32);
        try {
            j$.time.format.g g2 = new j$.time.format.g(temporalAccessor, this);
            this.e.e(g2, stringBuilder);
        }
        catch (IOException iOException) {
            throw new g(iOException.getMessage(), iOException);
        }
        return stringBuilder.toString();
    }

    public j$.time.chrono.e b() {
        return this.j;
    }

    public j.i c() {
        return this.g;
    }

    public Locale d() {
        return this.f;
    }

    public ZoneId e() {
        return this.k;
    }

    c.c g(boolean bl) {
        return this.e.a(bl);
    }

    public Object parse(CharSequence charSequence, TemporalQuery temporalQuery) {
        Objects.requireNonNull((Object)charSequence, (String)"text");
        Objects.requireNonNull((Object)temporalQuery, (String)"query");
        try {
            Object object = ((j$.time.format.j)this.f(charSequence, null)).t(temporalQuery);
            return object;
        }
        catch (RuntimeException runtimeException) {
            String string;
            if (charSequence.length() > 64) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(charSequence.subSequence(0, 64).toString());
                stringBuilder.append("...");
                string = stringBuilder.toString();
            } else {
                string = charSequence.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Text '");
            stringBuilder.append(string);
            stringBuilder.append("' could not be parsed: ");
            stringBuilder.append(runtimeException.getMessage());
            throw new e(stringBuilder.toString(), charSequence, 0, runtimeException);
        }
        catch (e e2) {
            throw e2;
        }
    }

    public String toString() {
        String string = this.e.toString();
        if (string.startsWith("[")) {
            return string;
        }
        return string.substring(1, string.length() - 1);
    }
}

