/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.time.LocalDate
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.List
 *  java.util.regex.Pattern
 */
package j$.time;

import j$.com.android.tools.r8.a;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.e;
import j$.time.g;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.d;
import j$.time.temporal.n;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class Period
implements n,
Serializable {
    public static final Period a = new Period(0, 0, 0);
    private final int b;
    private final int c;
    private final int d;

    static {
        Pattern.compile((String)"([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", (int)2);
        Object[] arrobject = new TemporalUnit[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS};
        Collections.unmodifiableList((List)Arrays.asList((Object[])arrobject));
    }

    private Period(int n2, int n3, int n4) {
        this.b = n2;
        this.c = n3;
        this.d = n4;
    }

    public static Period between(j.LocalDate localDate, j.LocalDate localDate2) {
        return localDate.Z((j.ChronoLocalDate)localDate2);
    }

    public static Period c(int n2, int n3, int n4) {
        if ((n4 | (n2 | n3)) == 0) {
            return a;
        }
        return new Period(n2, n3, n4);
    }

    public static Period d(int n2) {
        if ((n2 | 0) == 0) {
            return a;
        }
        return new Period(0, 0, n2);
    }

    public Temporal a(Temporal temporal) {
        int n2;
        block6 : {
            j.LocalDate localDate;
            ChronoUnit chronoUnit;
            long l2;
            block7 : {
                int n3;
                block5 : {
                    localDate = (j.LocalDate)temporal;
                    d d2 = d.a;
                    e e2 = (e)localDate.t((TemporalQuery)d2);
                    if (e2 != null && !j$.time.chrono.g.a.equals(e2)) {
                        StringBuilder stringBuilder = a.b("Chronology mismatch, expected: ISO, actual: ");
                        stringBuilder.append(e2.m());
                        throw new g(stringBuilder.toString());
                    }
                    n3 = this.c;
                    if (n3 != 0) break block5;
                    int n4 = this.b;
                    if (n4 == 0) break block6;
                    l2 = n4;
                    chronoUnit = ChronoUnit.YEARS;
                    break block7;
                }
                l2 = 12L * (long)this.b + (long)n3;
                if (l2 == 0L) break block6;
                chronoUnit = ChronoUnit.MONTHS;
            }
            temporal = localDate.U(l2, (TemporalUnit)chronoUnit);
        }
        if ((n2 = this.d) != 0) {
            long l3 = n2;
            ChronoUnit chronoUnit = ChronoUnit.DAYS;
            temporal = ((j.LocalDate)temporal).U(l3, (TemporalUnit)chronoUnit);
        }
        return temporal;
    }

    public boolean b() {
        return this == a;
    }

    public long e() {
        return 12L * (long)this.b + (long)this.c;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Period) {
            Period period = (Period)object;
            return this.b == period.b && this.c == period.c && this.d == period.d;
        }
        return false;
    }

    public int getDays() {
        return this.d;
    }

    public int getMonths() {
        return this.c;
    }

    public int getYears() {
        return this.b;
    }

    public int hashCode() {
        return this.b + Integer.rotateLeft((int)this.c, (int)8) + Integer.rotateLeft((int)this.d, (int)16);
    }

    public String toString() {
        int n2;
        int n3;
        if (this == a) {
            return "P0D";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('P');
        int n4 = this.b;
        if (n4 != 0) {
            stringBuilder.append(n4);
            stringBuilder.append('Y');
        }
        if ((n2 = this.c) != 0) {
            stringBuilder.append(n2);
            stringBuilder.append('M');
        }
        if ((n3 = this.d) != 0) {
            stringBuilder.append(n3);
            stringBuilder.append('D');
        }
        return stringBuilder.toString();
    }
}

