/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Comparable
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.util.regex.Pattern
 */
package j$.time;

import j$.time.e;
import j$.time.temporal.n;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;

public final class i
implements n,
Comparable<i>,
Serializable {
    public static final i a = new i(0L, 0);
    private final long b;
    private final int c;

    static {
        BigInteger.valueOf((long)1000000000L);
        Pattern.compile((String)"([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", (int)2);
    }

    private i(long l2, int n2) {
        this.b = l2;
        this.c = n2;
    }

    private static i e(long l2, int n2) {
        if ((l2 | (long)n2) == 0L) {
            return a;
        }
        return new i(l2, n2);
    }

    public static i p(long l2) {
        long l3 = l2 / 1000000000L;
        int n2 = (int)(l2 % 1000000000L);
        if (n2 < 0) {
            n2 = (int)(1000000000L + (long)n2);
            --l3;
        }
        return i.e(l3, n2);
    }

    public static i t(long l2) {
        return i.e(l2, 0);
    }

    public static i v(long l2, long l3) {
        return i.e(e.C(l2, e.E(l3, 1000000000L)), (int)e.D(l3, 1000000000L));
    }

    public int compareTo(Object object) {
        i i2 = (i)object;
        int n2 = Long.compare((long)this.b, (long)i2.b);
        if (n2 != 0) {
            return n2;
        }
        return this.c - i2.c;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof i) {
            i i2 = (i)object;
            return this.b == i2.b && this.c == i2.c;
        }
        return false;
    }

    public int hashCode() {
        long l2 = this.b;
        return (int)(l2 ^ l2 >>> 32) + 51 * this.c;
    }

    public long i() {
        return this.b;
    }

    public String toString() {
        if (this == a) {
            return "PT0S";
        }
        long l2 = this.b;
        long l3 = l2 / 3600L;
        int n2 = (int)(l2 % 3600L / 60L);
        int n3 = (int)(l2 % 60L);
        StringBuilder stringBuilder = new StringBuilder(24);
        stringBuilder.append("PT");
        if (l3 != 0L) {
            stringBuilder.append(l3);
            stringBuilder.append('H');
        }
        if (n2 != 0) {
            stringBuilder.append(n2);
            stringBuilder.append('M');
        }
        if (n3 == 0 && this.c == 0 && stringBuilder.length() > 2) {
            return stringBuilder.toString();
        }
        if (n3 < 0 && this.c > 0) {
            if (n3 == -1) {
                stringBuilder.append("-0");
            } else {
                stringBuilder.append(n3 + 1);
            }
        } else {
            stringBuilder.append(n3);
        }
        if (this.c > 0) {
            int n4 = stringBuilder.length();
            if (n3 < 0) {
                stringBuilder.append(2000000000L - (long)this.c);
            } else {
                stringBuilder.append(1000000000L + (long)this.c);
            }
            while (stringBuilder.charAt(-1 + stringBuilder.length()) == '0') {
                stringBuilder.setLength(-1 + stringBuilder.length());
            }
            stringBuilder.setCharAt(n4, '.');
        }
        stringBuilder.append('S');
        return stringBuilder.toString();
    }
}

