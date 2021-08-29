/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDate
 *  j$.time.LocalDateTime
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.ref.SoftReference
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.math.RoundingMode
 *  java.text.DateFormatSymbols
 *  java.text.ParsePosition
 *  java.util.AbstractMap
 *  java.util.AbstractMap$SimpleImmutableEntry
 *  java.util.ArrayList
 *  java.util.Calendar
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 *  java.util.TimeZone
 */
package j$.time.format;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.format.DateTimeFormatter;
import j$.time.format.h;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.s;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;

public final class c {
    private static final Map a;
    public static final /* synthetic */ int b;
    private c c = this;
    private final c d;
    private final List e = new ArrayList();
    private final boolean f;
    private int g;
    private char h;
    private int i = -1;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put((Object)Character.valueOf((char)'G'), (Object)j$.time.temporal.j.ERA);
        hashMap.put((Object)Character.valueOf((char)'y'), (Object)j$.time.temporal.j.YEAR_OF_ERA);
        hashMap.put((Object)Character.valueOf((char)'u'), (Object)j$.time.temporal.j.YEAR);
        Character c2 = Character.valueOf((char)'Q');
        j$.time.temporal.o o2 = j$.time.temporal.k.a;
        hashMap.put((Object)c2, (Object)o2);
        hashMap.put((Object)Character.valueOf((char)'q'), (Object)o2);
        Character c4 = Character.valueOf((char)'M');
        j$.time.temporal.j j2 = j$.time.temporal.j.MONTH_OF_YEAR;
        hashMap.put((Object)c4, (Object)j2);
        hashMap.put((Object)Character.valueOf((char)'L'), (Object)j2);
        hashMap.put((Object)Character.valueOf((char)'D'), (Object)j$.time.temporal.j.DAY_OF_YEAR);
        hashMap.put((Object)Character.valueOf((char)'d'), (Object)j$.time.temporal.j.DAY_OF_MONTH);
        hashMap.put((Object)Character.valueOf((char)'F'), (Object)j$.time.temporal.j.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        Character c5 = Character.valueOf((char)'E');
        j$.time.temporal.j j3 = j$.time.temporal.j.DAY_OF_WEEK;
        hashMap.put((Object)c5, (Object)j3);
        hashMap.put((Object)Character.valueOf((char)'c'), (Object)j3);
        hashMap.put((Object)Character.valueOf((char)'e'), (Object)j3);
        hashMap.put((Object)Character.valueOf((char)'a'), (Object)j$.time.temporal.j.AMPM_OF_DAY);
        hashMap.put((Object)Character.valueOf((char)'H'), (Object)j$.time.temporal.j.HOUR_OF_DAY);
        hashMap.put((Object)Character.valueOf((char)'k'), (Object)j$.time.temporal.j.CLOCK_HOUR_OF_DAY);
        hashMap.put((Object)Character.valueOf((char)'K'), (Object)j$.time.temporal.j.HOUR_OF_AMPM);
        hashMap.put((Object)Character.valueOf((char)'h'), (Object)j$.time.temporal.j.CLOCK_HOUR_OF_AMPM);
        hashMap.put((Object)Character.valueOf((char)'m'), (Object)j$.time.temporal.j.MINUTE_OF_HOUR);
        hashMap.put((Object)Character.valueOf((char)'s'), (Object)j$.time.temporal.j.SECOND_OF_MINUTE);
        Character c6 = Character.valueOf((char)'S');
        j$.time.temporal.j j4 = j$.time.temporal.j.NANO_OF_SECOND;
        hashMap.put((Object)c6, (Object)j4);
        hashMap.put((Object)Character.valueOf((char)'A'), (Object)j$.time.temporal.j.MILLI_OF_DAY);
        hashMap.put((Object)Character.valueOf((char)'n'), (Object)j4);
        hashMap.put((Object)Character.valueOf((char)'N'), (Object)j$.time.temporal.j.NANO_OF_DAY);
    }

    public c() {
        this.d = null;
        this.f = false;
    }

    private c(c c2, boolean bl) {
        this.d = c2;
        this.f = bl;
    }

    private int d(d d2) {
        Objects.requireNonNull((Object)d2, (String)"pp");
        c c2 = this.c;
        int n2 = c2.g;
        if (n2 > 0) {
            j j2 = new j(d2, n2, c2.h);
            c2.g = 0;
            c2.h = '\u0000';
            d2 = j2;
        }
        c2.e.add((Object)d2);
        c c4 = this.c;
        c4.i = -1;
        return -1 + c4.e.size();
    }

    private c m(h h2) {
        c c2 = this.c;
        int n2 = c2.i;
        if (n2 >= 0) {
            h h3;
            h h4 = (h)c2.e.get(n2);
            if (h2.c == h2.d && h2.e == j$.time.format.l.NOT_NEGATIVE) {
                h3 = h4.g(h2.d);
                this.d(h2.f());
                this.c.i = n2;
            } else {
                h3 = h4.f();
                this.c.i = this.d(h2);
            }
            this.c.e.set(n2, (Object)h3);
            return this;
        }
        c2.i = this.d(h2);
        return this;
    }

    private DateTimeFormatter y(Locale locale, j$.time.format.k k2, j$.time.chrono.e e2) {
        Objects.requireNonNull((Object)locale, (String)"locale");
        while (this.c.d != null) {
            this.r();
        }
        c c2 = new c(this.e, false);
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatter(c2, locale, j$.time.format.i.a, k2, null, e2, null);
        return dateTimeFormatter;
    }

    public c a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull((Object)dateTimeFormatter, (String)"formatter");
        this.d(dateTimeFormatter.g(false));
        return this;
    }

    public c b(j$.time.temporal.o o2, int n2, int n3, boolean bl) {
        this.d(new e(o2, n2, n3, bl));
        return this;
    }

    public c c() {
        this.d(new f(-2));
        return this;
    }

    public c e(char c2) {
        this.d(new b(c2));
        return this;
    }

    public c f(String string) {
        Objects.requireNonNull((Object)string, (String)"literal");
        if (string.length() > 0) {
            d d2 = string.length() == 1 ? new b(string.charAt(0)) : new n(string);
            this.d(d2);
        }
        return this;
    }

    public c g(j$.time.format.m m2) {
        Objects.requireNonNull((Object)((Object)m2), (String)"style");
        if (m2 != j$.time.format.m.FULL && m2 != j$.time.format.m.SHORT) {
            throw new IllegalArgumentException("Style must be either full or short");
        }
        this.d(new g(m2));
        return this;
    }

    public c h(String string, String string2) {
        this.d(new i(string, string2));
        return this;
    }

    public c i() {
        this.d(i.b);
        return this;
    }

    /*
     * Exception decompiling
     */
    public c j(String var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE], 8[CASE]], but top level block is 12[SWITCH]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public c k(j$.time.temporal.o o2, j$.time.format.m m2) {
        Objects.requireNonNull((Object)o2, (String)"field");
        Objects.requireNonNull((Object)((Object)m2), (String)"textStyle");
        this.d(new o(o2, m2, new j$.time.format.h()));
        return this;
    }

    public c l(j$.time.temporal.o o2, Map map) {
        Objects.requireNonNull((Object)o2, (String)"field");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        j$.time.format.m m2 = j$.time.format.m.FULL;
        this.d(new o(o2, m2, new j$.time.format.h(this, new h.b(Collections.singletonMap((Object)((Object)m2), (Object)linkedHashMap))){
            final /* synthetic */ h.b d;
            {
                this.d = b2;
            }

            @Override
            public String d(j$.time.temporal.o o2, long l2, j$.time.format.m m2, Locale locale) {
                return this.d.a(l2, m2);
            }

            @Override
            public Iterator e(j$.time.temporal.o o2, j$.time.format.m m2, Locale locale) {
                return this.d.b(m2);
            }
        }));
        return this;
    }

    public c n(j$.time.temporal.o o2) {
        Objects.requireNonNull((Object)o2, (String)"field");
        this.m(new h(o2, 1, 19, j$.time.format.l.NORMAL));
        return this;
    }

    public c o(j$.time.temporal.o o2, int n2) {
        Objects.requireNonNull((Object)o2, (String)"field");
        if (n2 >= 1 && n2 <= 19) {
            this.m(new h(o2, n2, n2, j$.time.format.l.NOT_NEGATIVE));
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The width must be from 1 to 19 inclusive but was ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public c p(j$.time.temporal.o o2, int n2, int n3, j$.time.format.l l2) {
        if (n2 == n3 && l2 == j$.time.format.l.NOT_NEGATIVE) {
            this.o(o2, n3);
            return this;
        }
        Objects.requireNonNull((Object)o2, (String)"field");
        Objects.requireNonNull((Object)((Object)l2), (String)"signStyle");
        if (n2 >= 1 && n2 <= 19) {
            if (n3 >= 1 && n3 <= 19) {
                if (n3 >= n2) {
                    this.m(new h(o2, n2, n3, l2));
                    return this;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The maximum width must exceed or equal the minimum width but ");
                stringBuilder.append(n3);
                stringBuilder.append(" < ");
                stringBuilder.append(n2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The maximum width must be from 1 to 19 inclusive but was ");
            stringBuilder.append(n3);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The minimum width must be from 1 to 19 inclusive but was ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public c q() {
        this.d(new q(j$.time.format.a.a, "ZoneRegionId()"));
        return this;
    }

    public c r() {
        c c2 = this.c;
        if (c2.d != null) {
            if (c2.e.size() > 0) {
                c c4 = this.c;
                c c5 = new c(c4.e, c4.f);
                this.c = this.c.d;
                this.d(c5);
                return this;
            }
            this.c = this.c.d;
            return this;
        }
        throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
    }

    public c s() {
        c c2 = this.c;
        c2.i = -1;
        this.c = new c(c2, true);
        return this;
    }

    public c t() {
        this.d(m.INSENSITIVE);
        return this;
    }

    public c u() {
        this.d(m.SENSITIVE);
        return this;
    }

    public c v() {
        this.d(m.LENIENT);
        return this;
    }

    public DateTimeFormatter w() {
        return this.y(Locale.getDefault(), j$.time.format.k.SMART, null);
    }

    DateTimeFormatter x(j$.time.format.k k2, j$.time.chrono.e e2) {
        return this.y(Locale.getDefault(), k2, e2);
    }

    static final class b
    implements d {
        private final char a;

        b(char c2) {
            this.a = c2;
        }

        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            stringBuilder.append(this.a);
            return true;
        }

        @Override
        public int i(j$.time.format.d d2, CharSequence charSequence, int n2) {
            if (n2 == charSequence.length()) {
                return n2;
            }
            char c2 = charSequence.charAt(n2);
            if (c2 != this.a && (d2.k() || Character.toUpperCase((char)c2) != Character.toUpperCase((char)this.a) && Character.toLowerCase((char)c2) != Character.toLowerCase((char)this.a))) {
                return n2;
            }
            return n2 + 1;
        }

        public String toString() {
            if (this.a == '\'') {
                return "''";
            }
            StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("'");
            stringBuilder.append(this.a);
            stringBuilder.append("'");
            return stringBuilder.toString();
        }
    }

    static final class c
    implements d {
        private final d[] a;
        private final boolean b;

        c(List list, boolean bl) {
            d[] arrd = (d[])list.toArray((Object[])new d[list.size()]);
            this.a = arrd;
            this.b = bl;
        }

        c(d[] arrd, boolean bl) {
            this.a = arrd;
            this.b = bl;
        }

        public c a(boolean bl) {
            if (bl == this.b) {
                return this;
            }
            return new c(this.a, bl);
        }

        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            d[] arrd;
            int n2;
            int n3 = stringBuilder.length();
            if (this.b) {
                g2.g();
            }
            try {
                arrd = this.a;
                n2 = arrd.length;
            }
            catch (Throwable throwable) {
                if (this.b) {
                    g2.a();
                }
                throw throwable;
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                block7 : {
                    if (arrd[i2].e(g2, stringBuilder)) continue;
                    stringBuilder.setLength(n3);
                    if (!this.b) break block7;
                    g2.a();
                }
                return true;
            }
            if (this.b) {
                g2.a();
            }
            return true;
        }

        @Override
        public int i(j$.time.format.d d2, CharSequence charSequence, int n2) {
            boolean bl = this.b;
            if (bl) {
                d2.r();
                d[] arrd = this.a;
                int n3 = arrd.length;
                int n4 = n2;
                for (int i2 = 0; i2 < n3; ++i2) {
                    if ((n4 = arrd[i2].i(d2, charSequence, n4)) >= 0) continue;
                    d2.f(false);
                    return n2;
                }
                d2.f(true);
                return n4;
            }
            d[] arrd = this.a;
            int n5 = arrd.length;
            for (int i4 = 0; i4 < n5; ++i4) {
                if ((n2 = arrd[i4].i(d2, charSequence, n2)) >= 0) continue;
                return n2;
            }
            return n2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.a != null) {
                String string = this.b ? "[" : "(";
                stringBuilder.append(string);
                d[] arrd = this.a;
                int n2 = arrd.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    stringBuilder.append((Object)arrd[i2]);
                }
                String string2 = this.b ? "]" : ")";
                stringBuilder.append(string2);
            }
            return stringBuilder.toString();
        }
    }

    static interface d {
        public boolean e(j$.time.format.g var1, StringBuilder var2);

        public int i(j$.time.format.d var1, CharSequence var2, int var3);
    }

    static final class e
    implements d {
        private final j$.time.temporal.o a;
        private final int b;
        private final int c;
        private final boolean d;

        e(j$.time.temporal.o o2, int n2, int n3, boolean bl) {
            Objects.requireNonNull((Object)o2, (String)"field");
            if (o2.p().f()) {
                if (n2 >= 0 && n2 <= 9) {
                    if (n3 >= 1 && n3 <= 9) {
                        if (n3 >= n2) {
                            this.a = o2;
                            this.b = n2;
                            this.c = n3;
                            this.d = bl;
                            return;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Maximum width must exceed or equal the minimum width but ");
                        stringBuilder.append(n3);
                        stringBuilder.append(" < ");
                        stringBuilder.append(n2);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Maximum width must be from 1 to 9 inclusive but was ");
                    stringBuilder.append(n3);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Minimum width must be from 0 to 9 inclusive but was ");
                stringBuilder.append(n2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field must have a fixed set of values: ");
            stringBuilder.append((Object)o2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            Long l2 = g2.e(this.a);
            if (l2 == null) {
                return false;
            }
            j$.time.format.i i2 = g2.b();
            long l3 = l2;
            j$.time.temporal.r r2 = this.a.p();
            r2.b(l3, this.a);
            BigDecimal bigDecimal = BigDecimal.valueOf((long)r2.e());
            BigDecimal bigDecimal2 = BigDecimal.valueOf((long)r2.d()).subtract(bigDecimal).add(BigDecimal.ONE);
            BigDecimal bigDecimal3 = BigDecimal.valueOf((long)l3).subtract(bigDecimal).divide(bigDecimal2, 9, RoundingMode.FLOOR);
            BigDecimal bigDecimal4 = bigDecimal3.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : bigDecimal3.stripTrailingZeros();
            if (bigDecimal4.scale() == 0) {
                if (this.b > 0) {
                    boolean bl = this.d;
                    int n2 = 0;
                    if (bl) {
                        stringBuilder.append(i2.c());
                    }
                    while (n2 < this.b) {
                        stringBuilder.append(i2.f());
                        ++n2;
                    }
                }
            } else {
                String string = i2.a(bigDecimal4.setScale(Math.min((int)Math.max((int)bigDecimal4.scale(), (int)this.b), (int)this.c), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.d) {
                    stringBuilder.append(i2.c());
                }
                stringBuilder.append(string);
            }
            return true;
        }

        @Override
        public int i(j$.time.format.d d2, CharSequence charSequence, int n2) {
            int n3;
            int n4;
            int n5;
            block9 : {
                int n6;
                int n7 = d2.l() ? this.b : 0;
                int n8 = d2.l() ? this.c : 9;
                int n9 = charSequence.length();
                if (n2 == n9) {
                    if (n7 > 0) {
                        // empty if block
                    }
                    return n2;
                }
                if (this.d) {
                    if (charSequence.charAt(n2) != d2.g().c()) {
                        if (n7 > 0) {
                            // empty if block
                        }
                        return n2;
                    }
                    ++n2;
                }
                if ((n6 = n7 + (n3 = n2)) > n9) {
                    return n3;
                }
                int n10 = Math.min((int)(n8 + n3), (int)n9);
                n4 = 0;
                int n11 = n3;
                while (n11 < n10) {
                    int n12 = n11 + 1;
                    char c2 = charSequence.charAt(n11);
                    int n13 = d2.g().b(c2);
                    if (n13 < 0) {
                        if (n12 < n6) {
                            return n3;
                        }
                        n5 = n12 - 1;
                        break block9;
                    }
                    n4 = n13 + n4 * 10;
                    n11 = n12;
                }
                n5 = n11;
            }
            BigDecimal bigDecimal = new BigDecimal(n4).movePointLeft(n5 - n3);
            j$.time.temporal.r r2 = this.a.p();
            BigDecimal bigDecimal2 = BigDecimal.valueOf((long)r2.e());
            long l2 = bigDecimal.multiply(BigDecimal.valueOf((long)r2.d()).subtract(bigDecimal2).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimal2).longValueExact();
            return d2.o(this.a, l2, n3, n5);
        }

        public String toString() {
            String string = this.d ? ",DecimalPoint" : "";
            StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("Fraction(");
            stringBuilder.append((Object)this.a);
            stringBuilder.append(",");
            stringBuilder.append(this.b);
            stringBuilder.append(",");
            stringBuilder.append(this.c);
            stringBuilder.append(string);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static final class f
    implements d {
        f(int n2) {
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            j$.time.temporal.j j2;
            Long l2 = g2.e(j$.time.temporal.j.INSTANT_SECONDS);
            TemporalAccessor temporalAccessor = g2.d();
            Long l3 = temporalAccessor.h(j2 = j$.time.temporal.j.NANO_OF_SECOND) ? Long.valueOf((long)g2.d().f(j2)) : null;
            int n2 = 0;
            if (l2 == null) {
                return false;
            }
            long l4 = l2;
            long l5 = l3 != null ? l3 : 0L;
            int n3 = j2.J(l5);
            if (l4 >= -62167219200L) {
                long l6 = 62167219200L + (l4 - 315569520000L);
                long l7 = 1L + j$.time.e.E(l6, 315569520000L);
                j.LocalDateTime localDateTime = j.LocalDateTime.Q((long)(j$.time.e.D(l6, 315569520000L) - 62167219200L), (int)0, (ZoneOffset)ZoneOffset.UTC);
                if (l7 > 0L) {
                    stringBuilder.append('+');
                    stringBuilder.append(l7);
                }
                stringBuilder.append((Object)localDateTime);
                if (localDateTime.J() == 0) {
                    stringBuilder.append(":00");
                }
            } else {
                long l8 = l4 + 62167219200L;
                long l9 = l8 / 315569520000L;
                long l10 = l8 % 315569520000L;
                j.LocalDateTime localDateTime = j.LocalDateTime.Q((long)(l10 - 62167219200L), (int)0, (ZoneOffset)ZoneOffset.UTC);
                int n4 = stringBuilder.length();
                stringBuilder.append((Object)localDateTime);
                if (localDateTime.J() == 0) {
                    stringBuilder.append(":00");
                }
                if (l9 < 0L) {
                    if (localDateTime.K() == -10000) {
                        stringBuilder.replace(n4, n4 + 2, Long.toString((long)(l9 - 1L)));
                    } else if (l10 == 0L) {
                        stringBuilder.insert(n4, l9);
                    } else {
                        stringBuilder.insert(n4 + 1, Math.abs((long)l9));
                    }
                }
            }
            if (n3 > 0) {
                stringBuilder.append('.');
                int n5 = 100000000;
                while (n3 > 0 || n2 % 3 != 0 || n2 < -2) {
                    int n6 = n3 / n5;
                    stringBuilder.append((char)(n6 + 48));
                    n3 -= n6 * n5;
                    n5 /= 10;
                    ++n2;
                }
            }
            stringBuilder.append('Z');
            return true;
        }

        @Override
        public int i(j$.time.format.d d2, CharSequence charSequence, int n2) {
            int n3;
            int n4;
            long l2;
            long l3;
            c c2 = new c();
            c2.a(DateTimeFormatter.a);
            c2.e('T');
            j$.time.temporal.j j2 = j$.time.temporal.j.HOUR_OF_DAY;
            c2.o(j2, 2);
            c2.e(':');
            j$.time.temporal.j j3 = j$.time.temporal.j.MINUTE_OF_HOUR;
            c2.o(j3, 2);
            c2.e(':');
            j$.time.temporal.j j4 = j$.time.temporal.j.SECOND_OF_MINUTE;
            c2.o(j4, 2);
            j$.time.temporal.j j5 = j$.time.temporal.j.NANO_OF_SECOND;
            int n5 = 0;
            c2.b(j5, 0, 9, true);
            c2.e('Z');
            c c4 = c2.w().g(false);
            j$.time.format.d d4 = d2.d();
            int n6 = c4.i(d4, charSequence, n2);
            if (n6 < 0) {
                return n6;
            }
            long l4 = d4.j(j$.time.temporal.j.YEAR);
            int n7 = d4.j(j$.time.temporal.j.MONTH_OF_YEAR).intValue();
            int n8 = d4.j(j$.time.temporal.j.DAY_OF_MONTH).intValue();
            int n9 = d4.j(j2).intValue();
            int n10 = d4.j(j3).intValue();
            Long l5 = d4.j(j4);
            Long l6 = d4.j(j5);
            int n11 = l5 != null ? l5.intValue() : 0;
            int n12 = l6 != null ? l6.intValue() : 0;
            if (n9 == 24 && n10 == 0 && n11 == 0 && n12 == 0) {
                n3 = n11;
                n5 = 1;
                n4 = 0;
            } else if (n9 == 23 && n10 == 59 && n11 == 60) {
                d2.p();
                n4 = n9;
                n3 = 59;
                n5 = 0;
            } else {
                n4 = n9;
                n3 = n11;
            }
            int n13 = (int)l4 % 10000;
            try {
                l2 = j$.time.e.l((ChronoLocalDateTime)j.LocalDateTime.O((int)n13, (int)n7, (int)n8, (int)n4, (int)n10, (int)n3, (int)0).S((long)n5), ZoneOffset.UTC);
                l3 = j$.time.e.F(l4 / 10000L, 315569520000L);
            }
            catch (RuntimeException runtimeException) {
                return n2;
            }
            long l7 = l3 + l2;
            j$.time.temporal.j j6 = j$.time.temporal.j.INSTANT_SECONDS;
            int n14 = n12;
            int n15 = d2.o(j6, l7, n2, n6);
            return d2.o(j5, n14, n2, n15);
        }

        public String toString() {
            return "Instant()";
        }
    }

    static final class g
    implements d {
        private final j$.time.format.m a;

        g(j$.time.format.m m2) {
            this.a = m2;
        }

        private static StringBuilder a(StringBuilder stringBuilder, int n2) {
            stringBuilder.append((char)(48 + n2 / 10));
            stringBuilder.append((char)(48 + n2 % 10));
            return stringBuilder;
        }

        int b(CharSequence charSequence, int n2) {
            char c2 = charSequence.charAt(n2);
            if (c2 >= '0' && c2 <= '9') {
                return c2 - 48;
            }
            return -1;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            Long l2 = g2.e(j$.time.temporal.j.OFFSET_SECONDS);
            if (l2 == null) {
                return false;
            }
            stringBuilder.append("GMT");
            int n2 = j$.time.e.B(l2);
            if (n2 == 0) return true;
            int n3 = Math.abs((int)(n2 / 3600 % 100));
            int n4 = Math.abs((int)(n2 / 60 % 60));
            int n5 = Math.abs((int)(n2 % 60));
            String string = n2 < 0 ? "-" : "+";
            stringBuilder.append(string);
            if (this.a == j$.time.format.m.FULL) {
                g.a(stringBuilder, n3);
                stringBuilder.append(':');
                g.a(stringBuilder, n4);
                if (n5 == 0) return true;
            } else {
                if (n3 >= 10) {
                    stringBuilder.append((char)(48 + n3 / 10));
                }
                stringBuilder.append((char)(48 + n3 % 10));
                if (n4 == 0) {
                    if (n5 == 0) return true;
                }
                stringBuilder.append(':');
                g.a(stringBuilder, n4);
                if (n5 == 0) return true;
            }
            stringBuilder.append(':');
            g.a(stringBuilder, n5);
            return true;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public int i(j$.time.format.d var1_1, CharSequence var2_2, int var3_3) {
            block13 : {
                block12 : {
                    block11 : {
                        var4_4 = var3_3 + var2_2.length();
                        if (!var1_1.s(var2_2, var3_3, "GMT", 0, 3)) {
                            return var3_3;
                        }
                        var5_5 = var3_3 + 3;
                        if (var5_5 == var4_4) {
                            return var1_1.o(j$.time.temporal.j.OFFSET_SECONDS, 0L, var3_3, var5_5);
                        }
                        var6_6 = var2_2.charAt(var5_5);
                        if (var6_6 == '+') {
                            var7_7 = 1;
                        } else {
                            if (var6_6 != '-') return var1_1.o(j$.time.temporal.j.OFFSET_SECONDS, 0L, var3_3, var5_5);
                            var7_7 = -1;
                        }
                        var8_8 = var5_5 + 1;
                        var9_9 = this.a;
                        var10_10 = j$.time.format.m.FULL;
                        var11_11 = 0;
                        if (var9_9 != var10_10) break block11;
                        var26_12 = var8_8 + 1;
                        var27_13 = this.b(var2_2, var8_8);
                        var28_14 = var26_12 + 1;
                        var29_15 = this.b(var2_2, var26_12);
                        if (var27_13 < 0) return var3_3;
                        if (var29_15 < 0) return var3_3;
                        var30_16 = var28_14 + 1;
                        if (var2_2.charAt(var28_14) != ':') {
                            return var3_3;
                        }
                        var13_17 = var29_15 + var27_13 * 10;
                        var31_18 = var30_16 + 1;
                        var32_19 = this.b(var2_2, var30_16);
                        var12_20 = var31_18 + 1;
                        var33_21 = this.b(var2_2, var31_18);
                        if (var32_19 < 0) return var3_3;
                        if (var33_21 < 0) {
                            return var3_3;
                        }
                        var22_22 = var33_21 + var32_19 * 10;
                        var34_23 = var12_20 + 2;
                        if (var34_23 >= var4_4 || var2_2.charAt(var12_20) != ':') ** GOTO lbl-1000
                        var24_24 = this.b(var2_2, var12_20 + 1);
                        var25_25 = this.b(var2_2, var34_23);
                        if (var24_24 < 0 || var25_25 < 0) ** GOTO lbl-1000
                        ** GOTO lbl-1000
                    }
                    var12_20 = var8_8 + 1;
                    var13_17 = this.b(var2_2, var8_8);
                    if (var13_17 < 0) {
                        return var3_3;
                    }
                    if (var12_20 >= var4_4) break block12;
                    var18_27 = this.b(var2_2, var12_20);
                    if (var18_27 >= 0) {
                        var13_17 = var18_27 + var13_17 * 10;
                        ++var12_20;
                    }
                    if ((var19_28 = var12_20 + 2) >= var4_4 || var2_2.charAt(var12_20) != ':' || var19_28 >= var4_4 || var2_2.charAt(var12_20) != ':') break block12;
                    var20_29 = this.b(var2_2, var12_20 + 1);
                    var21_30 = this.b(var2_2, var19_28);
                    if (var20_29 < 0 || var21_30 < 0) break block12;
                    var22_22 = var21_30 + var20_29 * 10;
                    var23_31 = (var12_20 += 3) + 2;
                    if (var23_31 < var4_4 && var2_2.charAt(var12_20) == ':') {
                        var24_24 = this.b(var2_2, var12_20 + 1);
                        var25_25 = this.b(var2_2, var23_31);
                        ** if (var24_24 < 0 || var25_25 < 0) goto lbl-1000
                    }
                    ** GOTO lbl-1000
lbl-1000: // 2 sources:
                    {
                        var11_11 = var22_22;
                        var14_26 = var25_25 + var24_24 * 10;
                        var12_20 += 3;
                        ** GOTO lbl72
                    }
lbl-1000: // 4 sources:
                    {
                        var11_11 = var22_22;
                        var14_26 = 0;
                    }
                    break block13;
                }
                var14_26 = 0;
            }
            var15_32 = var12_20;
            var16_33 = (long)var7_7 * (3600L * (long)var13_17 + 60L * (long)var11_11 + (long)var14_26);
            return var1_1.o(j$.time.temporal.j.OFFSET_SECONDS, var16_33, var3_3, var15_32);
        }

        public String toString() {
            StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("LocalizedOffset(");
            stringBuilder.append((Object)this.a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static class h
    implements d {
        static final long[] a = new long[]{0L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 10000000000L};
        final j$.time.temporal.o b;
        final int c;
        final int d;
        private final j$.time.format.l e;
        final int f;

        h(j$.time.temporal.o o2, int n2, int n3, j$.time.format.l l2) {
            this.b = o2;
            this.c = n2;
            this.d = n3;
            this.e = l2;
            this.f = 0;
        }

        protected h(j$.time.temporal.o o2, int n2, int n3, j$.time.format.l l2, int n4) {
            this.b = o2;
            this.c = n2;
            this.d = n3;
            this.e = l2;
            this.f = n4;
        }

        long b(j$.time.format.g g2, long l2) {
            return l2;
        }

        boolean c(j$.time.format.d d2) {
            int n2 = this.f;
            return n2 == -1 || n2 > 0 && this.c == this.d && this.e == j$.time.format.l.NOT_NEGATIVE;
            {
            }
        }

        int d(j$.time.format.d d2, long l2, int n2, int n3) {
            return d2.o(this.b, l2, n2, n3);
        }

        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            long l2;
            block2 : {
                int n2;
                String string;
                j$.time.format.i i2;
                block6 : {
                    char c2;
                    block7 : {
                        block8 : {
                            block9 : {
                                block3 : {
                                    block4 : {
                                        block5 : {
                                            Long l3 = g2.e(this.b);
                                            n2 = 0;
                                            if (l3 == null) {
                                                return false;
                                            }
                                            l2 = this.b(g2, l3);
                                            i2 = g2.b();
                                            String string2 = l2 == Long.MIN_VALUE ? "9223372036854775808" : Long.toString((long)Math.abs((long)l2));
                                            if (string2.length() > this.d) break block2;
                                            string = i2.a(string2);
                                            if (l2 < 0L) break block3;
                                            int n3 = this.e.ordinal();
                                            if (n3 == 1) break block4;
                                            if (n3 == 4) break block5;
                                            n2 = 0;
                                            break block6;
                                        }
                                        int n4 = this.c;
                                        n2 = 0;
                                        if (n4 >= 19) break block6;
                                        long l4 = l2 LCMP a[n4];
                                        n2 = 0;
                                        if (l4 < 0) break block6;
                                    }
                                    c2 = i2.e();
                                    break block7;
                                }
                                int n5 = this.e.ordinal();
                                if (n5 == 0 || n5 == 1) break block8;
                                if (n5 == 3) break block9;
                                if (n5 == 4) break block8;
                                n2 = 0;
                                break block6;
                            }
                            StringBuilder stringBuilder2 = j$.com.android.tools.r8.a.b("Field ");
                            stringBuilder2.append((Object)this.b);
                            stringBuilder2.append(" cannot be printed as the value ");
                            stringBuilder2.append(l2);
                            stringBuilder2.append(" cannot be negative according to the SignStyle");
                            throw new j$.time.g(stringBuilder2.toString());
                        }
                        c2 = i2.d();
                    }
                    stringBuilder.append(c2);
                }
                while (n2 < this.c - string.length()) {
                    stringBuilder.append(i2.f());
                    ++n2;
                }
                stringBuilder.append(string);
                return true;
            }
            StringBuilder stringBuilder3 = j$.com.android.tools.r8.a.b("Field ");
            stringBuilder3.append((Object)this.b);
            stringBuilder3.append(" cannot be printed as the value ");
            stringBuilder3.append(l2);
            stringBuilder3.append(" exceeds the maximum print width of ");
            stringBuilder3.append(this.d);
            throw new j$.time.g(stringBuilder3.toString());
        }

        h f() {
            if (this.f == -1) {
                return this;
            }
            h h2 = new h(this.b, this.c, this.d, this.e, -1);
            return h2;
        }

        h g(int n2) {
            h h2 = new h(this.b, this.c, this.d, this.e, n2 + this.f);
            return h2;
        }

        @Override
        public int i(j$.time.format.d d2, CharSequence charSequence, int n2) {
            int n3;
            long l2;
            int n4;
            BigInteger bigInteger;
            block25 : {
                long l3;
                block24 : {
                    int n5;
                    block16 : {
                        block15 : {
                            int n6;
                            int n7;
                            block26 : {
                                block23 : {
                                    boolean bl;
                                    block21 : {
                                        block22 : {
                                            boolean bl2;
                                            block20 : {
                                                block14 : {
                                                    int n8;
                                                    int n9;
                                                    int n10;
                                                    block18 : {
                                                        block19 : {
                                                            char c2;
                                                            boolean bl3;
                                                            block17 : {
                                                                boolean bl4;
                                                                n5 = n2;
                                                                n9 = charSequence.length();
                                                                if (n5 == n9) break block16;
                                                                c2 = charSequence.charAt(n2);
                                                                char c4 = d2.g().e();
                                                                n10 = 0;
                                                                if (c2 != c4) break block17;
                                                                j$.time.format.l l4 = this.e;
                                                                boolean bl5 = d2.l();
                                                                if (!l4.e(true, bl5, bl4 = this.c == this.d)) break block16;
                                                                n4 = n5 + 1;
                                                                bl = true;
                                                                bl2 = false;
                                                                break block18;
                                                            }
                                                            if (c2 != d2.g().d()) break block19;
                                                            j$.time.format.l l5 = this.e;
                                                            boolean bl6 = d2.l();
                                                            if (!l5.e(false, bl6, bl3 = this.c == this.d)) break block16;
                                                            n4 = n5 + 1;
                                                            bl2 = true;
                                                            bl = false;
                                                            break block18;
                                                        }
                                                        if (this.e == j$.time.format.l.ALWAYS && d2.l()) break block16;
                                                        n4 = n5;
                                                        bl2 = false;
                                                        bl = false;
                                                    }
                                                    int n11 = !d2.l() && !this.c(d2) ? 1 : this.c;
                                                    int n12 = n4 + n11;
                                                    if (n12 > n9) break block15;
                                                    int n13 = !d2.l() && !this.c(d2) ? 9 : this.d;
                                                    int n14 = n13 + Math.max((int)this.f, (int)0);
                                                    do {
                                                        int n15;
                                                        bigInteger = null;
                                                        if (n10 >= 2) break block14;
                                                        int n16 = Math.min((int)(n14 + n4), (int)n9);
                                                        n8 = n4;
                                                        l3 = 0L;
                                                        while (n8 < n16) {
                                                            int n17 = n8 + 1;
                                                            char c5 = charSequence.charAt(n8);
                                                            int n18 = d2.g().b(c5);
                                                            if (n18 < 0) {
                                                                n8 = n17 - 1;
                                                                if (n8 >= n12) break;
                                                                break block15;
                                                            }
                                                            if (n17 - n4 > 18) {
                                                                if (bigInteger == null) {
                                                                    bigInteger = BigInteger.valueOf((long)l3);
                                                                }
                                                                bigInteger = bigInteger.multiply(BigInteger.TEN).add(BigInteger.valueOf((long)n18));
                                                            } else {
                                                                l3 = l3 * 10L + (long)n18;
                                                            }
                                                            n8 = n17;
                                                        }
                                                        if ((n15 = this.f) <= 0 || n10 != 0) break;
                                                        n14 = Math.max((int)n11, (int)(n8 - n4 - n15));
                                                        ++n10;
                                                    } while (true);
                                                    n3 = n8;
                                                    break block20;
                                                }
                                                n3 = n4;
                                                l3 = 0L;
                                            }
                                            if (!bl2) break block21;
                                            if (bigInteger == null) break block22;
                                            if (bigInteger.equals((Object)BigInteger.ZERO) && d2.l()) break block23;
                                            bigInteger = bigInteger.negate();
                                            break block24;
                                        }
                                        if (l3 == 0L && d2.l()) break block23;
                                        l2 = -l3;
                                        break block25;
                                    }
                                    if (this.e != j$.time.format.l.EXCEEDS_PAD || !d2.l()) break block24;
                                    n7 = n3 - n4;
                                    n6 = this.c;
                                    if (!bl) break block26;
                                    if (n7 > n6) break block24;
                                }
                                return n4 - 1;
                            }
                            if (n7 <= n6) break block24;
                        }
                        n5 = n4;
                    }
                    return n5;
                }
                l2 = l3;
            }
            if (bigInteger != null) {
                if (bigInteger.bitLength() > 63) {
                    bigInteger = bigInteger.divide(BigInteger.TEN);
                    --n3;
                }
                l2 = bigInteger.longValue();
            }
            return this.d(d2, l2, n4, n3);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public String toString() {
            block2 : {
                var1_1 = this.c;
                if (var1_1 != 1 || this.d != 19 || this.e != j$.time.format.l.NORMAL) break block2;
                var2_2 = j$.com.android.tools.r8.a.b("Value(");
                var9_3 = this.b;
                ** GOTO lbl21
            }
            if (var1_1 == this.d && this.e == j$.time.format.l.NOT_NEGATIVE) {
                var2_2 = j$.com.android.tools.r8.a.b("Value(");
                var2_2.append((Object)this.b);
                var2_2.append(",");
                var2_2.append(this.c);
            } else {
                var2_2 = j$.com.android.tools.r8.a.b("Value(");
                var2_2.append((Object)this.b);
                var2_2.append(",");
                var2_2.append(this.c);
                var2_2.append(",");
                var2_2.append(this.d);
                var2_2.append(",");
                var9_4 = this.e;
lbl21: // 2 sources:
                var2_2.append((Object)var9_5);
            }
            var2_2.append(")");
            return var2_2.toString();
        }
    }

    static final class i
    implements d {
        static final String[] a = new String[]{"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        static final i b = new i("+HH:MM:ss", "Z");
        static final i c = new i("+HH:MM:ss", "0");
        private final String d;
        private final int e;

        i(String string, String string2) {
            String[] arrstring;
            Objects.requireNonNull((Object)string, (String)"pattern");
            Objects.requireNonNull((Object)string2, (String)"noOffsetText");
            for (int i2 = 0; i2 < (arrstring = a).length; ++i2) {
                if (!arrstring[i2].equals((Object)string)) continue;
                this.e = i2;
                this.d = string2;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid zone offset pattern: ");
            stringBuilder.append(string);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        private boolean a(int[] arrn, int n2, CharSequence charSequence, boolean bl) {
            int n3 = this.e;
            if ((n3 + 3) / 2 < n2) {
                return false;
            }
            int n4 = arrn[0];
            if (n3 % 2 == 0 && n2 > 1) {
                int n5 = n4 + 1;
                if (n5 <= charSequence.length()) {
                    if (charSequence.charAt(n4) != ':') {
                        return bl;
                    }
                    n4 = n5;
                } else {
                    return bl;
                }
            }
            if (n4 + 2 > charSequence.length()) {
                return bl;
            }
            int n6 = n4 + 1;
            char c2 = charSequence.charAt(n4);
            int n7 = n6 + 1;
            char c4 = charSequence.charAt(n6);
            if (c2 >= '0' && c2 <= '9' && c4 >= '0') {
                if (c4 > '9') {
                    return bl;
                }
                int n8 = 10 * (c2 - 48) + (c4 - 48);
                if (n8 >= 0) {
                    if (n8 > 59) {
                        return bl;
                    }
                    arrn[n2] = n8;
                    arrn[0] = n7;
                    return false;
                }
            }
            return bl;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            Long l2 = g2.e(j$.time.temporal.j.OFFSET_SECONDS);
            if (l2 == null) {
                return false;
            }
            int n2 = j$.time.e.B(l2);
            if (n2 != 0) {
                int n3 = Math.abs((int)(n2 / 3600 % 100));
                int n4 = Math.abs((int)(n2 / 60 % 60));
                int n5 = Math.abs((int)(n2 % 60));
                int n6 = stringBuilder.length();
                String string = n2 < 0 ? "-" : "+";
                stringBuilder.append(string);
                stringBuilder.append((char)(48 + n3 / 10));
                stringBuilder.append((char)(48 + n3 % 10));
                int n7 = this.e;
                if (n7 >= 3 || n7 >= 1 && n4 > 0) {
                    int n8 = n7 % 2;
                    String string2 = ":";
                    String string3 = n8 == 0 ? string2 : "";
                    stringBuilder.append(string3);
                    stringBuilder.append((char)(48 + n4 / 10));
                    stringBuilder.append((char)(48 + n4 % 10));
                    n3 += n4;
                    int n9 = this.e;
                    if (n9 >= 7 || n9 >= 5 && n5 > 0) {
                        if (n9 % 2 != 0) {
                            string2 = "";
                        }
                        stringBuilder.append(string2);
                        stringBuilder.append((char)(48 + n5 / 10));
                        stringBuilder.append((char)(48 + n5 % 10));
                        n3 += n5;
                    }
                }
                if (n3 != 0) {
                    return true;
                }
                stringBuilder.setLength(n6);
            }
            stringBuilder.append(this.d);
            return true;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public int i(j$.time.format.d d2, CharSequence charSequence, int n2) {
            int n3;
            long l2;
            j$.time.temporal.j j2;
            int n4;
            int n5;
            j$.time.format.d d4;
            block10 : {
                char c2;
                block9 : {
                    int n6;
                    block8 : {
                        n6 = charSequence.length();
                        n5 = this.d.length();
                        if (n5 != 0) break block8;
                        if (n2 == n6) {
                            j2 = j$.time.temporal.j.OFFSET_SECONDS;
                            l2 = 0L;
                            d4 = d2;
                            n3 = n2;
                            n4 = n2;
                            return d4.o(j2, l2, n3, n4);
                        }
                        break block9;
                    }
                    if (n2 == n6) {
                        return n2;
                    }
                    if (d2.s(charSequence, n2, this.d, 0, n5)) break block10;
                }
                if ((c2 = charSequence.charAt(n2)) == '+' || c2 == '-') {
                    boolean bl;
                    int n7 = c2 == '-' ? -1 : 1;
                    int[] arrn = new int[4];
                    arrn[0] = n2 + 1;
                    boolean bl2 = this.a(arrn, 1, charSequence, true) || this.a(arrn, 2, charSequence, bl = this.e >= 3) || this.a(arrn, 3, charSequence, false);
                    if (!bl2) {
                        long l3 = (long)n7 * (3600L * (long)arrn[1] + 60L * (long)arrn[2] + (long)arrn[3]);
                        j2 = j$.time.temporal.j.OFFSET_SECONDS;
                        int n8 = arrn[0];
                        d4 = d2;
                        l2 = l3;
                        n3 = n2;
                        n4 = n8;
                        return d4.o(j2, l2, n3, n4);
                    }
                }
                if (n5 != 0) return n2;
            }
            j2 = j$.time.temporal.j.OFFSET_SECONDS;
            n4 = n2 + n5;
            l2 = 0L;
            d4 = d2;
            n3 = n2;
            return d4.o(j2, l2, n3, n4);
        }

        public String toString() {
            String string = this.d.replace((CharSequence)"'", (CharSequence)"''");
            StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("Offset(");
            stringBuilder.append(a[this.e]);
            stringBuilder.append(",'");
            stringBuilder.append(string);
            stringBuilder.append("')");
            return stringBuilder.toString();
        }
    }

    static final class j
    implements d {
        private final d a;
        private final int b;
        private final char c;

        j(d d2, int n2, char c2) {
            this.a = d2;
            this.b = n2;
            this.c = c2;
        }

        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            int n2 = stringBuilder.length();
            if (!this.a.e(g2, stringBuilder)) {
                return false;
            }
            int n3 = stringBuilder.length() - n2;
            int n4 = this.b;
            if (n3 <= n4) {
                for (int i2 = 0; i2 < this.b - n3; ++i2) {
                    stringBuilder.insert(n2, this.c);
                }
                return true;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Cannot print as output of ");
            stringBuilder2.append(n3);
            stringBuilder2.append(" characters exceeds pad width of ");
            stringBuilder2.append(this.b);
            throw new j$.time.g(stringBuilder2.toString());
        }

        @Override
        public int i(j$.time.format.d d2, CharSequence charSequence, int n2) {
            boolean bl = d2.l();
            if (n2 <= charSequence.length()) {
                int n3;
                if (n2 == charSequence.length()) {
                    return n2;
                }
                int n4 = n2 + this.b;
                if (n4 > charSequence.length()) {
                    if (bl) {
                        return n2;
                    }
                    n4 = charSequence.length();
                }
                for (n3 = n2; n3 < n4 && d2.b(charSequence.charAt(n3), this.c); ++n3) {
                }
                CharSequence charSequence2 = charSequence.subSequence(0, n4);
                int n5 = this.a.i(d2, charSequence2, n3);
                if (n5 != n4 && bl) {
                    n5 = n2 + n3;
                }
                return n5;
            }
            throw new IndexOutOfBoundsException();
        }

        public String toString() {
            String string;
            StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("Pad(");
            stringBuilder.append((Object)this.a);
            stringBuilder.append(",");
            stringBuilder.append(this.b);
            if (this.c == ' ') {
                string = ")";
            } else {
                StringBuilder stringBuilder2 = j$.com.android.tools.r8.a.b(",'");
                stringBuilder2.append(this.c);
                stringBuilder2.append("')");
                string = stringBuilder2.toString();
            }
            stringBuilder.append(string);
            return stringBuilder.toString();
        }
    }

    static class k {
        protected String a;
        protected String b;
        protected char c;
        protected k d;
        protected k e;

        private k(String string, String string2, k k2) {
            this.a = string;
            this.b = string2;
            this.d = k2;
            int n2 = string.length() == 0 ? 65535 : (int)this.a.charAt(0);
            this.c = (char)n2;
        }

        private boolean b(String string, String string2) {
            int n2;
            for (n2 = 0; n2 < string.length() && n2 < this.a.length() && this.c(string.charAt(n2), this.a.charAt(n2)); ++n2) {
            }
            if (n2 == this.a.length()) {
                if (n2 < string.length()) {
                    String string3 = string.substring(n2);
                    k k2 = this.d;
                    while (k2 != null) {
                        if (this.c(k2.c, string3.charAt(0))) {
                            return k2.b(string3, string2);
                        }
                        k2 = k2.e;
                    }
                    k k3 = this.e(string3, string2, null);
                    k3.e = this.d;
                    this.d = k3;
                    return true;
                }
                this.b = string2;
                return true;
            }
            k k4 = this.e(this.a.substring(n2), this.b, this.d);
            this.a = string.substring(0, n2);
            this.d = k4;
            if (n2 < string.length()) {
                k k5;
                this.d.e = k5 = this.e(string.substring(n2), string2, null);
                this.b = null;
                return true;
            }
            this.b = string2;
            return true;
        }

        public static k f(j$.time.format.d d2) {
            if (d2.k()) {
                return new k("", null, null);
            }
            return new a("", null, null, null);
        }

        public static k g(Set set, j$.time.format.d d2) {
            k k2 = k.f(d2);
            for (String string : set) {
                k2.b(string, string);
            }
            return k2;
        }

        public boolean a(String string, String string2) {
            return this.b(string, string2);
        }

        protected boolean c(char c2, char c4) {
            return c2 == c4;
        }

        public String d(CharSequence charSequence, ParsePosition parsePosition) {
            int n2;
            int n3 = parsePosition.getIndex();
            if (!this.h(charSequence, n3, n2 = charSequence.length())) {
                return null;
            }
            int n4 = n3 + this.a.length();
            k k2 = this.d;
            if (k2 != null && n4 != n2) {
                do {
                    if (!this.c(k2.c, charSequence.charAt(n4))) continue;
                    parsePosition.setIndex(n4);
                    String string = k2.d(charSequence, parsePosition);
                    if (string == null) break;
                    return string;
                } while ((k2 = k2.e) != null);
            }
            parsePosition.setIndex(n4);
            return this.b;
        }

        protected k e(String string, String string2, k k2) {
            return new k(string, string2, k2);
        }

        protected boolean h(CharSequence charSequence, int n2, int n3) {
            if (charSequence instanceof String) {
                return ((String)charSequence).startsWith(this.a, n2);
            }
            int n4 = this.a.length();
            if (n4 > n3 - n2) {
                return false;
            }
            int n5 = 0;
            do {
                int n6 = n4 - 1;
                if (n4 <= 0) break;
                String string = this.a;
                int n7 = n5 + 1;
                char c2 = string.charAt(n5);
                int n8 = n2 + 1;
                if (!this.c(c2, charSequence.charAt(n2))) {
                    return false;
                }
                n2 = n8;
                n4 = n6;
                n5 = n7;
            } while (true);
            return true;
        }

        private static class a
        extends k {
            private a(String string, String string2, k k2) {
                super(string, string2, k2);
            }

            a(String string, String string2, k k2, j$.time.format.c$a a2) {
                super(string, null, null);
            }

            @Override
            protected boolean c(char c2, char c4) {
                return j$.time.format.d.c(c2, c4);
            }

            @Override
            protected k e(String string, String string2, k k2) {
                return new a(string, string2, k2);
            }

            @Override
            protected boolean h(CharSequence charSequence, int n2, int n3) {
                int n4 = this.a.length();
                if (n4 > n3 - n2) {
                    return false;
                }
                int n5 = 0;
                do {
                    int n6 = n4 - 1;
                    if (n4 <= 0) break;
                    String string = this.a;
                    int n7 = n5 + 1;
                    char c2 = string.charAt(n5);
                    int n8 = n2 + 1;
                    if (!j$.time.format.d.c(c2, charSequence.charAt(n2))) {
                        return false;
                    }
                    n2 = n8;
                    n4 = n6;
                    n5 = n7;
                } while (true);
                return true;
            }
        }

    }

    static final class l
    extends h {
        static final j.LocalDate g = j.LocalDate.of((int)2000, (int)1, (int)1);
        private final int h;
        private final ChronoLocalDate i;

        l(j$.time.temporal.o o2, int n2, int n3, int n4, ChronoLocalDate chronoLocalDate) {
            this(o2, n2, n3, n4, chronoLocalDate, 0);
            if (n2 >= 1 && n2 <= 10) {
                if (n3 >= 1 && n3 <= 10) {
                    if (n3 >= n2) {
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Maximum width must exceed or equal the minimum width but ");
                    stringBuilder.append(n3);
                    stringBuilder.append(" < ");
                    stringBuilder.append(n2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The maxWidth must be from 1 to 10 inclusive but was ");
                stringBuilder.append(n2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The minWidth must be from 1 to 10 inclusive but was ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        private l(j$.time.temporal.o o2, int n2, int n3, int n4, ChronoLocalDate chronoLocalDate, int n5) {
            super(o2, n2, n3, j$.time.format.l.NOT_NEGATIVE, n5);
            this.h = n4;
            this.i = chronoLocalDate;
        }

        @Override
        long b(j$.time.format.g g2, long l2) {
            long[] arrl;
            long l3;
            int n2;
            long l4 = Math.abs((long)l2);
            int n3 = this.h;
            if (this.i != null) {
                n3 = j$.time.chrono.c.e(g2.d()).o(this.i).i(this.b);
            }
            long l5 = l2 >= (l3 = (long)n3) && l2 < l3 + (arrl = h.a)[n2 = this.c] ? arrl[n2] : h.a[this.d];
            return l4 % l5;
        }

        @Override
        boolean c(j$.time.format.d d2) {
            if (!d2.l()) {
                return false;
            }
            return super.c(d2);
        }

        @Override
        int d(j$.time.format.d d2, long l2, int n2, int n3) {
            int n4;
            int n5;
            int n6 = this.h;
            if (this.i != null) {
                n6 = d2.h().o(this.i).i(this.b);
                j$.time.format.b b2 = new j$.time.format.b(this, d2, l2, n2, n3);
                d2.a(b2);
            }
            if ((n4 = n3 - n2) == (n5 = this.c) && l2 >= 0L) {
                long l3 = h.a[n5];
                long l4 = n6;
                long l5 = l4 - l4 % l3;
                long l6 = n6 > 0 ? l5 + l2 : l5 - l2;
                l2 = l6;
                if (l2 < l4) {
                    l2 += l3;
                }
            }
            long l7 = l2;
            return d2.o(this.b, l7, n2, n3);
        }

        @Override
        h f() {
            if (this.f == -1) {
                return this;
            }
            l l2 = new l(this.b, this.c, this.d, this.h, this.i, -1);
            return l2;
        }

        @Override
        h g(int n2) {
            l l2 = new l(this.b, this.c, this.d, this.h, this.i, n2 + this.f);
            return l2;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("ReducedValue(");
            stringBuilder.append((Object)this.b);
            stringBuilder.append(",");
            stringBuilder.append(this.c);
            stringBuilder.append(",");
            stringBuilder.append(this.d);
            stringBuilder.append(",");
            ChronoLocalDate chronoLocalDate = this.i;
            if (chronoLocalDate == null) {
                chronoLocalDate = Integer.valueOf((int)this.h);
            }
            stringBuilder.append((Object)chronoLocalDate);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static final class m
    extends Enum<m>
    implements d {
        public static final /* enum */ m INSENSITIVE;
        public static final /* enum */ m LENIENT;
        public static final /* enum */ m SENSITIVE;
        public static final /* enum */ m STRICT;
        private static final /* synthetic */ m[] a;

        static {
            m m2;
            m m3;
            m m4;
            m m5;
            SENSITIVE = m4 = new m();
            INSENSITIVE = m2 = new m();
            STRICT = m3 = new m();
            LENIENT = m5 = new m();
            a = new m[]{m4, m2, m3, m5};
        }

        public static m valueOf(String string) {
            return (m)Enum.valueOf(m.class, (String)string);
        }

        public static m[] values() {
            return (m[])a.clone();
        }

        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            return true;
        }

        @Override
        public int i(j$.time.format.d d2, CharSequence charSequence, int n2) {
            int n3 = this.ordinal();
            if (n3 != 0) {
                if (n3 != 1) {
                    if (n3 != 2) {
                        if (n3 != 3) {
                            return n2;
                        }
                        d2.q(false);
                        return n2;
                    }
                    d2.q(true);
                    return n2;
                }
                d2.m(false);
                return n2;
            }
            d2.m(true);
            return n2;
        }

        public String toString() {
            int n2 = this.ordinal();
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 == 3) {
                            return "ParseStrict(false)";
                        }
                        throw new IllegalStateException("Unreachable");
                    }
                    return "ParseStrict(true)";
                }
                return "ParseCaseSensitive(false)";
            }
            return "ParseCaseSensitive(true)";
        }
    }

    static final class n
    implements d {
        private final String a;

        n(String string) {
            this.a = string;
        }

        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            stringBuilder.append(this.a);
            return true;
        }

        @Override
        public int i(j$.time.format.d d2, CharSequence charSequence, int n2) {
            if (n2 <= charSequence.length() && n2 >= 0) {
                String string = this.a;
                if (!d2.s(charSequence, n2, string, 0, string.length())) {
                    return n2;
                }
                return n2 + this.a.length();
            }
            throw new IndexOutOfBoundsException();
        }

        public String toString() {
            String string = this.a.replace((CharSequence)"'", (CharSequence)"''");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("'");
            stringBuilder.append(string);
            stringBuilder.append("'");
            return stringBuilder.toString();
        }
    }

    static final class o
    implements d {
        private final j$.time.temporal.o a;
        private final j$.time.format.m b;
        private final j$.time.format.h c;
        private volatile h d;

        o(j$.time.temporal.o o2, j$.time.format.m m2, j$.time.format.h h2) {
            this.a = o2;
            this.b = m2;
            this.c = h2;
        }

        private h a() {
            if (this.d == null) {
                this.d = new h(this.a, 1, 19, j$.time.format.l.NORMAL);
            }
            return this.d;
        }

        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            String string;
            j$.time.chrono.g g4;
            Long l2 = g2.e(this.a);
            if (l2 == null) {
                return false;
            }
            TemporalAccessor temporalAccessor = g2.d();
            j$.time.chrono.e e2 = (j$.time.chrono.e)temporalAccessor.t(j$.time.temporal.d.a);
            if (e2 != null && e2 != (g4 = j$.time.chrono.g.a)) {
                j$.time.format.h h2 = this.c;
                j$.time.temporal.o o2 = this.a;
                long l3 = l2;
                j$.time.format.m m2 = this.b;
                Locale locale = g2.c();
                Objects.requireNonNull((Object)h2);
                string = e2 != g4 && o2 instanceof j$.time.temporal.j ? null : h2.d(o2, l3, m2, locale);
            } else {
                string = this.c.d(this.a, l2, this.b, g2.c());
            }
            if (string == null) {
                return this.a().e(g2, stringBuilder);
            }
            stringBuilder.append(string);
            return true;
        }

        @Override
        public int i(j$.time.format.d d2, CharSequence charSequence, int n2) {
            block6 : {
                Iterator iterator;
                block8 : {
                    Iterator iterator2;
                    block10 : {
                        j$.time.format.h h2;
                        j$.time.temporal.o o2;
                        Locale locale;
                        j$.time.format.m m2;
                        block9 : {
                            j$.time.chrono.e e2;
                            j$.time.chrono.g g2;
                            block7 : {
                                int n3 = charSequence.length();
                                if (n2 < 0 || n2 > n3) break block6;
                                m2 = d2.l() ? this.b : null;
                                e2 = d2.h();
                                if (e2 != (g2 = j$.time.chrono.g.a)) break block7;
                                iterator = this.c.e(this.a, m2, d2.i());
                                break block8;
                            }
                            h2 = this.c;
                            o2 = this.a;
                            locale = d2.i();
                            Objects.requireNonNull((Object)h2);
                            if (e2 == g2) break block9;
                            boolean bl = o2 instanceof j$.time.temporal.j;
                            iterator2 = null;
                            if (bl) break block10;
                        }
                        iterator2 = h2.e(o2, m2, locale);
                    }
                    iterator = iterator2;
                }
                if (iterator != null) {
                    while (iterator.hasNext()) {
                        Map.Entry entry = (Map.Entry)iterator.next();
                        String string = (String)entry.getKey();
                        if (!d2.s(string, 0, charSequence, n2, string.length())) continue;
                        return d2.o(this.a, (Long)entry.getValue(), n2, n2 + string.length());
                    }
                    if (d2.l()) {
                        return n2;
                    }
                }
                return this.a().i(d2, charSequence, n2);
            }
            throw new IndexOutOfBoundsException();
        }

        public String toString() {
            StringBuilder stringBuilder;
            Object object;
            if (this.b == j$.time.format.m.FULL) {
                stringBuilder = j$.com.android.tools.r8.a.b("Text(");
                object = this.a;
            } else {
                stringBuilder = j$.com.android.tools.r8.a.b("Text(");
                stringBuilder.append((Object)this.a);
                stringBuilder.append(",");
                object = this.b;
            }
            stringBuilder.append(object);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static final class p
    implements d {
        private char a;
        private int b;

        p(char c2, int n2) {
            this.a = c2;
            this.b = n2;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private d a(Locale var1_1) {
            Objects.requireNonNull((Object)var1_1, (String)"locale");
            var4_2 = Calendar.getInstance((Locale)new Locale(var1_1.getLanguage(), var1_1.getCountry()));
            var5_3 = var4_2.getFirstDayOfWeek();
            var6_4 = s.g(j$.time.h.SUNDAY.H(var5_3 - 1), var4_2.getMinimalDaysInFirstWeek());
            var7_5 = this.a;
            if (var7_5 == 'W') ** GOTO lbl20
            if (var7_5 != 'Y') {
                if (var7_5 != 'c' && var7_5 != 'e') {
                    if (var7_5 != 'w') throw new IllegalStateException("unreachable");
                    var8_6 = var6_4.j();
                } else {
                    var8_6 = var6_4.d();
                }
            } else {
                var10_7 = var6_4.h();
                var11_8 = this.b;
                if (var11_8 == 2) {
                    return new l(var10_7, 2, 2, 0, (ChronoLocalDate)l.g, 0);
                }
                var13_10 = var11_8 < 4 ? j$.time.format.l.NORMAL : j$.time.format.l.EXCEEDS_PAD;
                return new h(var10_7, var11_8, 19, var13_10, -1);
lbl20: // 1 sources:
                var8_6 = var6_4.i();
            }
            if (this.b == 2) {
                var9_12 = 2;
                return new h(var8_6, var9_12, 2, j$.time.format.l.NOT_NEGATIVE);
            }
            var9_12 = 1;
            return new h(var8_6, var9_12, 2, j$.time.format.l.NOT_NEGATIVE);
        }

        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            return ((h)this.a(g2.c())).e(g2, stringBuilder);
        }

        @Override
        public int i(j$.time.format.d d2, CharSequence charSequence, int n2) {
            return ((h)this.a(d2.i())).i(d2, charSequence, n2);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public String toString() {
            block4 : {
                block7 : {
                    block8 : {
                        block5 : {
                            block6 : {
                                block2 : {
                                    block3 : {
                                        var1_1 = new StringBuilder(30);
                                        var1_1.append("Localized(");
                                        var3_2 = this.a;
                                        if (var3_2 != 'Y') break block2;
                                        var9_3 = this.b;
                                        if (var9_3 != 1) break block3;
                                        var17_4 = "WeekBasedYear";
                                        ** GOTO lbl12
                                    }
                                    if (var9_3 == 2) {
                                        var17_4 = "ReducedValue(WeekBasedYear,2,2,2000-01-01)";
lbl12: // 2 sources:
                                        var1_1.append(var17_4);
                                    } else {
                                        var1_1.append("WeekBasedYear,");
                                        var1_1.append(this.b);
                                        var1_1.append(",");
                                        var1_1.append(19);
                                        var1_1.append(",");
                                        var15_5 = this.b < 4 ? j$.time.format.l.NORMAL : j$.time.format.l.EXCEEDS_PAD;
                                        var1_1.append((Object)var15_5);
                                    }
                                    break block4;
                                }
                                if (var3_2 == 'W') break block5;
                                if (var3_2 == 'c' || var3_2 == 'e') break block6;
                                if (var3_2 != 'w') break block7;
                                var4_6 = "WeekOfWeekBasedYear";
                                break block8;
                            }
                            var4_6 = "DayOfWeek";
                            break block8;
                        }
                        var4_6 = "WeekOfMonth";
                    }
                    var1_1.append(var4_6);
                }
                var1_1.append(",");
                var1_1.append(this.b);
            }
            var1_1.append(")");
            return var1_1.toString();
        }
    }

    static class q
    implements d {
        private static volatile Map.Entry a;
        private static volatile Map.Entry b;
        private final TemporalQuery c;
        private final String d;

        q(TemporalQuery temporalQuery, String string) {
            this.c = temporalQuery;
            this.d = string;
        }

        private int b(j$.time.format.d d2, CharSequence charSequence, int n2, int n3, i i2) {
            String string = charSequence.toString().substring(n2, n3).toUpperCase();
            if (n3 < charSequence.length() && charSequence.charAt(n3) != '0' && !d2.b(charSequence.charAt(n3), 'Z')) {
                j$.time.format.d d4 = d2.d();
                int n4 = i2.i(d4, charSequence, n3);
                if (n4 < 0) {
                    if (i2 == i.b) {
                        return n2;
                    }
                    d2.n(ZoneId.H(string));
                    return n3;
                }
                try {
                    d2.n(ZoneId.ofOffset(string, ZoneOffset.O((int)d4.j(j$.time.temporal.j.OFFSET_SECONDS).longValue())));
                    return n4;
                }
                catch (j$.time.g g2) {
                    return n2;
                }
            }
            d2.n(ZoneId.H(string));
            return n3;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        protected k a(j$.time.format.d d2) {
            Set set = j$.time.zone.e.a();
            int n2 = ((HashSet)set).size();
            Map.Entry entry = d2.k() ? a : b;
            if (entry == null || (Integer)entry.getKey() != n2) {
                q q2 = this;
                synchronized (q2) {
                    entry = d2.k() ? a : b;
                    if (entry == null || (Integer)entry.getKey() != n2) {
                        entry = new AbstractMap.SimpleImmutableEntry((Object)n2, (Object)k.g(set, d2));
                        if (d2.k()) {
                            a = entry;
                        } else {
                            b = entry;
                        }
                    }
                }
            }
            return (k)entry.getValue();
        }

        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            ZoneId zoneId = (ZoneId)g2.f(this.c);
            if (zoneId == null) {
                return false;
            }
            stringBuilder.append(zoneId.m());
            return true;
        }

        @Override
        public int i(j$.time.format.d d2, CharSequence charSequence, int n2) {
            int n3 = charSequence.length();
            if (n2 <= n3) {
                if (n2 == n3) {
                    return n2;
                }
                char c2 = charSequence.charAt(n2);
                if (c2 != '+' && c2 != '-') {
                    String string;
                    k k2;
                    ParsePosition parsePosition;
                    int n4 = n2 + 2;
                    if (n3 >= n4) {
                        int n5;
                        char c4 = charSequence.charAt(n2 + 1);
                        if (d2.b(c2, 'U') && d2.b(c4, 'T')) {
                            int n6 = n2 + 3;
                            if (n3 >= n6 && d2.b(charSequence.charAt(n4), 'C')) {
                                return this.b(d2, charSequence, n2, n6, i.c);
                            }
                            return this.b(d2, charSequence, n2, n4, i.c);
                        }
                        if (d2.b(c2, 'G') && n3 >= (n5 = n2 + 3) && d2.b(c4, 'M') && d2.b(charSequence.charAt(n4), 'T')) {
                            return this.b(d2, charSequence, n2, n5, i.c);
                        }
                    }
                    if ((string = (k2 = this.a(d2)).d(charSequence, parsePosition = new ParsePosition(n2))) == null) {
                        if (d2.b(c2, 'Z')) {
                            d2.n(ZoneOffset.UTC);
                            return n2 + 1;
                        }
                        return n2;
                    }
                    d2.n(ZoneId.H(string));
                    return parsePosition.getIndex();
                }
                return this.b(d2, charSequence, n2, n2, i.b);
            }
            throw new IndexOutOfBoundsException();
        }

        public String toString() {
            return this.d;
        }
    }

    static final class r
    extends q {
        private static final Map e = new ConcurrentHashMap();
        private final j$.time.format.m f;
        private Set g;
        private final Map h;
        private final Map i;

        r(j$.time.format.m m2, Set set) {
            j$.time.temporal.i i2 = j$.time.temporal.i.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ZoneText(");
            stringBuilder.append((Object)m2);
            stringBuilder.append(")");
            super(i2, stringBuilder.toString());
            this.h = new HashMap();
            this.i = new HashMap();
            Objects.requireNonNull((Object)((Object)m2), (String)"textStyle");
            this.f = m2;
        }

        @Override
        protected k a(j$.time.format.d d2) {
            k k2;
            if (this.f == j$.time.format.m.NARROW) {
                return super.a(d2);
            }
            Locale locale = d2.i();
            boolean bl = d2.k();
            HashSet hashSet = (HashSet)j$.time.zone.e.a();
            int n2 = hashSet.size();
            Map map = bl ? this.h : this.i;
            Map.Entry entry = (Map.Entry)map.get((Object)locale);
            if (entry == null || (Integer)entry.getKey() != n2 || (k2 = (k)((SoftReference)entry.getValue()).get()) == null) {
                k2 = k.f(d2);
                String[][] arrstring = DateFormatSymbols.getInstance((Locale)locale).getZoneStrings();
                int n3 = arrstring.length;
                int n4 = 0;
                do {
                    int n5 = 1;
                    if (n4 >= n3) break;
                    String[] arrstring2 = arrstring[n4];
                    String string = arrstring2[0];
                    if (hashSet.contains((Object)string)) {
                        k2.a(string, string);
                        String string2 = j$.time.format.n.a(string, locale);
                        if (this.f != j$.time.format.m.FULL) {
                            n5 = 2;
                        }
                        while (n5 < arrstring2.length) {
                            k2.a(arrstring2[n5], string2);
                            n5 += 2;
                        }
                    }
                    ++n4;
                } while (true);
                if (this.g != null) {
                    for (String[] arrstring3 : arrstring) {
                        String string = arrstring3[0];
                        if (!this.g.contains((Object)string) || !hashSet.contains((Object)string)) continue;
                        for (int i2 = this.f == j$.time.format.m.FULL ? n5 : 2; i2 < arrstring3.length; i2 += 2) {
                            k2.a(arrstring3[i2], string);
                        }
                    }
                }
                map.put((Object)locale, (Object)new AbstractMap.SimpleImmutableEntry((Object)n2, (Object)new SoftReference((Object)k2)));
            }
            return k2;
        }

        @Override
        public boolean e(j$.time.format.g g2, StringBuilder stringBuilder) {
            ZoneId zoneId = (ZoneId)g2.f(j$.time.temporal.f.a);
            if (zoneId == null) {
                return false;
            }
            String string = zoneId.m();
            if (!(zoneId instanceof ZoneOffset)) {
                String string2;
                TemporalAccessor temporalAccessor = g2.d();
                int n2 = temporalAccessor.h(j$.time.temporal.j.INSTANT_SECONDS) ? (zoneId.G().h(Instant.H(temporalAccessor)) ? 1 : 0) : 2;
                Locale locale = g2.c();
                if (this.f == j$.time.format.m.NARROW) {
                    string2 = null;
                } else {
                    String[] arrstring;
                    Map map = e;
                    SoftReference softReference = (SoftReference)map.get((Object)string);
                    Object object = null;
                    if (softReference == null || (object = (Map)softReference.get()) == null || (arrstring = (String[])object.get((Object)locale)) == null) {
                        TimeZone timeZone = TimeZone.getTimeZone((String)string);
                        String[] arrstring2 = new String[]{string, timeZone.getDisplayName(false, 1, locale), timeZone.getDisplayName(false, 0, locale), timeZone.getDisplayName(true, 1, locale), timeZone.getDisplayName(true, 0, locale), string, string};
                        if (object == null) {
                            object = new ConcurrentHashMap();
                        }
                        object.put((Object)locale, (Object)arrstring2);
                        map.put((Object)string, (Object)new SoftReference(object));
                        arrstring = arrstring2;
                    }
                    int n3 = this.f.e();
                    string2 = n2 != 0 ? (n2 != 1 ? arrstring[n3 + 5] : arrstring[n3 + 3]) : arrstring[n3 + 1];
                }
                if (string2 != null) {
                    string = string2;
                }
            }
            stringBuilder.append(string);
            return true;
        }
    }

}

