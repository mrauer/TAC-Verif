/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package j$.time.temporal;

import j$.time.g;
import j$.time.temporal.o;
import java.io.Serializable;

public final class r
implements Serializable {
    private final long a;
    private final long b;
    private final long c;
    private final long d;

    private r(long l2, long l3, long l4, long l5) {
        this.a = l2;
        this.b = l3;
        this.c = l4;
        this.d = l5;
    }

    private String c(o o2, long l2) {
        if (o2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid value for ");
            stringBuilder.append((Object)o2);
            stringBuilder.append(" (valid values ");
            stringBuilder.append((Object)this);
            stringBuilder.append("): ");
            stringBuilder.append(l2);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid value (valid values ");
        stringBuilder.append((Object)this);
        stringBuilder.append("): ");
        stringBuilder.append(l2);
        return stringBuilder.toString();
    }

    public static r i(long l2, long l3) {
        if (l2 <= l3) {
            r r2 = new r(l2, l2, l3, l3);
            return r2;
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static r j(long l2, long l3, long l4) {
        return r.k(l2, l2, l3, l4);
    }

    public static r k(long l2, long l3, long l4, long l5) {
        if (l2 <= l3) {
            if (l4 <= l5) {
                if (l3 <= l5) {
                    r r2 = new r(l2, l3, l4, l5);
                    return r2;
                }
                throw new IllegalArgumentException("Minimum value must be less than maximum value");
            }
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
    }

    public int a(long l2, o o2) {
        boolean bl = this.g() && this.h(l2);
        if (bl) {
            return (int)l2;
        }
        throw new g(this.c(o2, l2));
    }

    public long b(long l2, o o2) {
        if (this.h(l2)) {
            return l2;
        }
        throw new g(this.c(o2, l2));
    }

    public long d() {
        return this.d;
    }

    public long e() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof r) {
            r r2 = (r)object;
            return this.a == r2.a && this.b == r2.b && this.c == r2.c && this.d == r2.d;
        }
        return false;
    }

    public boolean f() {
        return this.a == this.b && this.c == this.d;
    }

    public boolean g() {
        return this.a >= Integer.MIN_VALUE && this.d <= Integer.MAX_VALUE;
    }

    public boolean h(long l2) {
        return l2 >= this.a && l2 <= this.d;
    }

    public int hashCode() {
        long l2 = this.a;
        long l3 = this.b;
        long l4 = l2 + (l3 << 16) + (l3 >> 48);
        long l5 = this.c;
        long l6 = l4 + (l5 << 32) + (l5 >> 32);
        long l7 = this.d;
        long l8 = l6 + (l7 << 48) + (l7 >> 16);
        return (int)(l8 ^ l8 >>> 32);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        if (this.a != this.b) {
            stringBuilder.append('/');
            stringBuilder.append(this.b);
        }
        stringBuilder.append(" - ");
        stringBuilder.append(this.c);
        if (this.c != this.d) {
            stringBuilder.append('/');
            stringBuilder.append(this.d);
        }
        return stringBuilder.toString();
    }
}

