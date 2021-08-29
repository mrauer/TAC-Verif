/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package j$.util;

import j$.util.function.f;
import j$.util.function.r;
import java.util.Objects;

public class l
implements r {
    private double a;
    private double b;
    private long count;
    private double max = Double.NEGATIVE_INFINITY;
    private double min = Double.POSITIVE_INFINITY;
    private double sum;

    private void d(double d2) {
        double d4 = d2 - this.a;
        double d5 = this.sum;
        double d6 = d5 + d4;
        this.a = d6 - d5 - d4;
        this.sum = d6;
    }

    @Override
    public void accept(double d2) {
        this.count = 1L + this.count;
        this.b = d2 + this.b;
        this.d(d2);
        this.min = Math.min((double)this.min, (double)d2);
        this.max = Math.max((double)this.max, (double)d2);
    }

    public void b(l l2) {
        this.count += l2.count;
        this.b += l2.b;
        this.d(l2.sum);
        this.d(l2.a);
        this.min = Math.min((double)this.min, (double)l2.min);
        this.max = Math.max((double)this.max, (double)l2.max);
    }

    public final double c() {
        double d2 = this.sum + this.a;
        if (Double.isNaN((double)d2) && Double.isInfinite((double)this.b)) {
            d2 = this.b;
        }
        return d2;
    }

    @Override
    public r k(r r2) {
        Objects.requireNonNull((Object)r2);
        return new f(this, r2);
    }

    public String toString() {
        Object[] arrobject = new Object[6];
        arrobject[0] = l.class.getSimpleName();
        arrobject[1] = this.count;
        arrobject[2] = this.c();
        arrobject[3] = this.min;
        double d2 = this.count > 0L ? this.c() / (double)this.count : 0.0;
        arrobject[4] = d2;
        arrobject[5] = this.max;
        return String.format((String)"%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", (Object[])arrobject);
    }
}

