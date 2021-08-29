/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package j$.time.format;

import j$.com.android.tools.r8.a;
import j$.util.concurrent.ConcurrentHashMap;

public final class i {
    public static final i a = new i('0', '+', '-', '.');
    private final char b;
    private final char c;
    private final char d;
    private final char e;

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    private i(char c2, char c4, char c5, char c6) {
        this.b = c2;
        this.c = c4;
        this.d = c5;
        this.e = c6;
    }

    String a(String string) {
        char c2 = this.b;
        if (c2 == '0') {
            return string;
        }
        int n2 = c2 - 48;
        char[] arrc = string.toCharArray();
        for (int i2 = 0; i2 < arrc.length; ++i2) {
            arrc[i2] = (char)(n2 + arrc[i2]);
        }
        return new String(arrc);
    }

    int b(char c2) {
        int n2 = c2 - this.b;
        if (n2 >= 0 && n2 <= 9) {
            return n2;
        }
        return -1;
    }

    public char c() {
        return this.e;
    }

    public char d() {
        return this.d;
    }

    public char e() {
        return this.c;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof i) {
            i i2 = (i)object;
            return this.b == i2.b && this.c == i2.c && this.d == i2.d && this.e == i2.e;
        }
        return false;
    }

    public char f() {
        return this.b;
    }

    public int hashCode() {
        return this.b + this.c + this.d + this.e;
    }

    public String toString() {
        StringBuilder stringBuilder = a.b("DecimalStyle[");
        stringBuilder.append(this.b);
        stringBuilder.append(this.c);
        stringBuilder.append(this.d);
        stringBuilder.append(this.e);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

