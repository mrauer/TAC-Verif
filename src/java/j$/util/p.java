/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.NoSuchElementException
 */
package j$.util;

import java.util.NoSuchElementException;

public final class p {
    private static final p a = new p();
    private final boolean b;
    private final int c;

    private p() {
        this.b = false;
        this.c = 0;
    }

    private p(int n2) {
        this.b = true;
        this.c = n2;
    }

    public static p a() {
        return a;
    }

    public static p d(int n2) {
        return new p(n2);
    }

    public int b() {
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
        if (!(object instanceof p)) {
            return false;
        }
        p p2 = (p)object;
        boolean bl = this.b;
        return bl && p2.b ? this.c == p2.c : bl == p2.b;
    }

    public int hashCode() {
        if (this.b) {
            return this.c;
        }
        return 0;
    }

    public String toString() {
        if (this.b) {
            Object[] arrobject = new Object[]{this.c};
            return String.format((String)"OptionalInt[%s]", (Object[])arrobject);
        }
        return "OptionalInt.empty";
    }
}

