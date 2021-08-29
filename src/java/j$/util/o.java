/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.util.NoSuchElementException
 */
package j$.util;

import java.util.NoSuchElementException;

public final class o {
    private static final o a = new o();
    private final boolean b;
    private final double c;

    private o() {
        this.b = false;
        this.c = Double.NaN;
    }

    private o(double d2) {
        this.b = true;
        this.c = d2;
    }

    public static o a() {
        return a;
    }

    public static o d(double d2) {
        return new o(d2);
    }

    public double b() {
        if (this.b) {
            return this.c;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.b;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof o)) {
            return false;
        }
        o o2 = (o)object;
        boolean bl = this.b;
        return bl && o2.b ? Double.compare((double)this.c, (double)o2.c) == 0 : bl == o2.b;
    }

    public int hashCode() {
        if (this.b) {
            long l2 = Double.doubleToLongBits((double)this.c);
            return (int)(l2 ^ l2 >>> 32);
        }
        return 0;
    }

    public String toString() {
        if (this.b) {
            Object[] arrobject = new Object[]{this.c};
            return String.format((String)"OptionalDouble[%s]", (Object[])arrobject);
        }
        return "OptionalDouble.empty";
    }
}

