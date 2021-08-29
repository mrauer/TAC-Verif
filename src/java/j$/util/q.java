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

public final class q {
    private static final q a = new q();
    private final boolean b;
    private final long c;

    private q() {
        this.b = false;
        this.c = 0L;
    }

    private q(long l2) {
        this.b = true;
        this.c = l2;
    }

    public static q a() {
        return a;
    }

    public static q d(long l2) {
        return new q(l2);
    }

    public long b() {
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
        if (!(object instanceof q)) {
            return false;
        }
        q q2 = (q)object;
        boolean bl = this.b;
        return bl && q2.b ? this.c == q2.c : bl == q2.b;
    }

    public int hashCode() {
        if (this.b) {
            long l2 = this.c;
            return (int)(l2 ^ l2 >>> 32);
        }
        return 0;
    }

    public String toString() {
        if (this.b) {
            Object[] arrobject = new Object[]{this.c};
            return String.format((String)"OptionalLong[%s]", (Object[])arrobject);
        }
        return "OptionalLong.empty";
    }
}

