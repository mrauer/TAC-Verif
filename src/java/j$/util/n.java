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

import j$.util.function.D;
import j$.util.function.i;
import j$.util.function.j;
import j$.util.function.x;
import java.util.Objects;

public class n
implements D,
x {
    private long count;
    private long max = Long.MIN_VALUE;
    private long min = Long.MAX_VALUE;
    private long sum;

    @Override
    public void accept(int n2) {
        this.accept((long)n2);
    }

    @Override
    public void accept(long l2) {
        this.count = 1L + this.count;
        this.sum = l2 + this.sum;
        this.min = Math.min((long)this.min, (long)l2);
        this.max = Math.max((long)this.max, (long)l2);
    }

    public void b(n n2) {
        this.count += n2.count;
        this.sum += n2.sum;
        this.min = Math.min((long)this.min, (long)n2.min);
        this.max = Math.max((long)this.max, (long)n2.max);
    }

    @Override
    public D g(D d2) {
        Objects.requireNonNull((Object)d2);
        return new j(this, d2);
    }

    @Override
    public x l(x x3) {
        Objects.requireNonNull((Object)x3);
        return new i(this, x3);
    }

    public String toString() {
        Object[] arrobject = new Object[6];
        arrobject[0] = n.class.getSimpleName();
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

