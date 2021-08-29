/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package j$.util;

import j$.util.function.i;
import j$.util.function.x;
import java.util.Objects;

public class m
implements x {
    private long count;
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;
    private long sum;

    @Override
    public void accept(int n2) {
        this.count = 1L + this.count;
        this.sum += (long)n2;
        this.min = Math.min((int)this.min, (int)n2);
        this.max = Math.max((int)this.max, (int)n2);
    }

    public void b(m m2) {
        this.count += m2.count;
        this.sum += m2.sum;
        this.min = Math.min((int)this.min, (int)m2.min);
        this.max = Math.max((int)this.max, (int)m2.max);
    }

    @Override
    public x l(x x3) {
        Objects.requireNonNull((Object)x3);
        return new i(this, x3);
    }

    public String toString() {
        Object[] arrobject = new Object[6];
        arrobject[0] = m.class.getSimpleName();
        arrobject[1] = this.count;
        arrobject[2] = this.sum;
        arrobject[3] = this.min;
        long l2 = this.count;
        double d2 = l2 > 0L ? (double)this.sum / (double)l2 : 0.0;
        arrobject[4] = d2;
        arrobject[5] = this.max;
        return String.format((String)"%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", (Object[])arrobject);
    }
}

