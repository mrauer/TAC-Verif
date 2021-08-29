/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j$.util.concurrent.ThreadLocalRandom$b
 *  j$.util.concurrent.ThreadLocalRandom$c
 *  j$.util.concurrent.ThreadLocalRandom$d
 *  java.io.ObjectStreamField
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.StrictMath
 *  java.lang.String
 *  java.lang.System
 *  java.lang.ThreadLocal
 *  java.lang.UnsupportedOperationException
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 *  java.security.SecureRandom
 *  java.util.Random
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.concurrent.atomic.AtomicLong
 *  java.util.stream.DoubleStream
 *  java.util.stream.IntStream
 *  java.util.stream.LongStream
 */
package j$.util.concurrent;

import j$.N0;
import j$.P0;
import j$.R0;
import j$.util.Spliterator;
import j$.util.concurrent.ThreadLocalRandom;
import j$.util.stream.Q1;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/*
 * Exception performing whole class analysis.
 */
public class ThreadLocalRandom
extends Random {
    private static final AtomicInteger a;
    private static final AtomicLong b;
    private static final ThreadLocal c;
    private static final ThreadLocal d;
    long e;
    int f;
    boolean g;

    static {
        long l2;
        a = new AtomicInteger();
        if (((Boolean)AccessController.doPrivileged((PrivilegedAction)new j$.util.concurrent.c())).booleanValue()) {
            byte[] arrby = SecureRandom.getSeed((int)8);
            l2 = 255L & (long)arrby[0];
            for (int i2 = 1; i2 < 8; ++i2) {
                l2 = l2 << 8 | 255L & (long)arrby[i2];
            }
        } else {
            l2 = ThreadLocalRandom.h(System.currentTimeMillis()) ^ ThreadLocalRandom.h(System.nanoTime());
        }
        b = new AtomicLong(l2);
        c = new ThreadLocal();
        d = new ThreadLocal<ThreadLocalRandom>(){

            protected Object initialValue() {
                return new ThreadLocalRandom(null);
            }
        };
        new ObjectStreamField("rnd", Long.TYPE);
        new ObjectStreamField("initialized", Boolean.TYPE);
    }

    private ThreadLocalRandom() {
        this.g = true;
    }

    ThreadLocalRandom(j$.util.concurrent.c c2) {
        this.g = true;
    }

    static final int a(int n2) {
        int n3;
        int n4 = n2 ^ n2 << 13;
        int n5 = n4 ^ n4 >>> 17;
        ((ThreadLocalRandom)ThreadLocalRandom.d.get()).f = n3 = n5 ^ n5 << 5;
        return n3;
    }

    static final int b() {
        return ((ThreadLocalRandom)ThreadLocalRandom.d.get()).f;
    }

    public static ThreadLocalRandom current() {
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom)((Object)d.get());
        if (threadLocalRandom.f == 0) {
            ThreadLocalRandom.f();
        }
        return threadLocalRandom;
    }

    static final void f() {
        int n2 = a.addAndGet(-1640531527);
        if (n2 == 0) {
            n2 = 1;
        }
        long l2 = ThreadLocalRandom.h(b.getAndAdd(-4942790177534073029L));
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom)((Object)d.get());
        threadLocalRandom.e = l2;
        threadLocalRandom.f = n2;
    }

    private static int g(long l2) {
        long l3 = -49064778989728563L * (l2 ^ l2 >>> 33);
        return (int)(-4265267296055464877L * (l3 ^ l3 >>> 33) >>> 32);
    }

    private static long h(long l2) {
        long l3 = -49064778989728563L * (l2 ^ l2 >>> 33);
        long l4 = -4265267296055464877L * (l3 ^ l3 >>> 33);
        return l4 ^ l4 >>> 33;
    }

    final double c(double d2, double d4) {
        double d5 = 1.1102230246251565E-16 * (double)(this.nextLong() >>> 11);
        if (d2 < d4 && (d5 = d2 + d5 * (d4 - d2)) >= d4) {
            d5 = Double.longBitsToDouble((long)(Double.doubleToLongBits((double)d4) - 1L));
        }
        return d5;
    }

    /*
     * Enabled aggressive block sorting
     */
    final int d(int n2, int n3) {
        int n4;
        block4 : {
            int n5;
            n4 = ThreadLocalRandom.g(this.i());
            if (n2 >= n3) return n4;
            int n6 = n3 - n2;
            int n7 = n6 - 1;
            if ((n6 & n7) == 0) {
                n5 = n4 & n7;
                return n5 + n2;
            }
            if (n6 > 0) {
                int n8;
                int n9 = n4 >>> 1;
                while ((n8 = n9 + n7) - (n5 = n9 % n6) < 0) {
                    n9 = ThreadLocalRandom.g(this.i()) >>> 1;
                }
            }
            break block4;
            return n5 + n2;
        }
        while (n4 < n2 || n4 >= n3) {
            n4 = ThreadLocalRandom.g(this.i());
        }
        return n4;
    }

    public DoubleStream doubles() {
        b b2 = new /* Unavailable Anonymous Inner Class!! */;
        return N0.k0(Q1.o((Spliterator.a)b2, false));
    }

    public DoubleStream doubles(double d2, double d4) {
        if (d2 < d4) {
            b b2 = new /* Unavailable Anonymous Inner Class!! */;
            return N0.k0(Q1.o((Spliterator.a)b2, false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public DoubleStream doubles(long l2) {
        if (l2 >= 0L) {
            b b2 = new /* Unavailable Anonymous Inner Class!! */;
            return N0.k0(Q1.o((Spliterator.a)b2, false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    public DoubleStream doubles(long l2, double d2, double d4) {
        if (l2 >= 0L) {
            if (d2 < d4) {
                b b2 = new /* Unavailable Anonymous Inner Class!! */;
                return N0.k0(Q1.o((Spliterator.a)b2, false));
            }
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    final long e(long l2, long l3) {
        long l4 = ThreadLocalRandom.h(this.i());
        if (l2 < l3) {
            long l5 = l3 - l2;
            long l6 = l5 - 1L;
            if ((l5 & l6) == 0L) {
                return l2 + (l4 & l6);
            }
            if (l5 > 0L) {
                long l7;
                long l8;
                long l9;
                while ((l7 = (l8 = l4 >>> 1) + l6) - (l9 = l8 % l5) < 0L) {
                    l4 = ThreadLocalRandom.h(this.i());
                }
                return l9 + l2;
            }
            while (l4 < l2 || l4 >= l3) {
                l4 = ThreadLocalRandom.h(this.i());
            }
        }
        return l4;
    }

    final long i() {
        long l2;
        this.e = l2 = -7046029254386353131L + this.e;
        return l2;
    }

    public IntStream ints() {
        c c2 = new /* Unavailable Anonymous Inner Class!! */;
        return P0.k0(Q1.p((Spliterator.b)c2, false));
    }

    public IntStream ints(int n2, int n3) {
        if (n2 < n3) {
            c c2 = new /* Unavailable Anonymous Inner Class!! */;
            return P0.k0(Q1.p((Spliterator.b)c2, false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public IntStream ints(long l2) {
        if (l2 >= 0L) {
            c c2 = new /* Unavailable Anonymous Inner Class!! */;
            return P0.k0(Q1.p((Spliterator.b)c2, false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    public IntStream ints(long l2, int n2, int n3) {
        if (l2 >= 0L) {
            if (n2 < n3) {
                c c2 = new /* Unavailable Anonymous Inner Class!! */;
                return P0.k0(Q1.p((Spliterator.b)c2, false));
            }
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    public LongStream longs() {
        d d2 = new /* Unavailable Anonymous Inner Class!! */;
        return R0.k0(Q1.q((Spliterator.c)d2, false));
    }

    public LongStream longs(long l2) {
        if (l2 >= 0L) {
            d d2 = new /* Unavailable Anonymous Inner Class!! */;
            return R0.k0(Q1.q((Spliterator.c)d2, false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    public LongStream longs(long l2, long l3) {
        if (l2 < l3) {
            d d2 = new /* Unavailable Anonymous Inner Class!! */;
            return R0.k0(Q1.q((Spliterator.c)d2, false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public LongStream longs(long l2, long l3, long l4) {
        if (l2 >= 0L) {
            if (l3 < l4) {
                d d2 = new /* Unavailable Anonymous Inner Class!! */;
                return R0.k0(Q1.q((Spliterator.c)d2, false));
            }
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    protected int next(int n2) {
        return (int)(ThreadLocalRandom.h(this.i()) >>> 64 - n2);
    }

    public boolean nextBoolean() {
        return ThreadLocalRandom.g(this.i()) < 0;
    }

    public double nextDouble() {
        return 1.1102230246251565E-16 * (double)(ThreadLocalRandom.h(this.i()) >>> 11);
    }

    public float nextFloat() {
        return 5.9604645E-8f * (float)(ThreadLocalRandom.g(this.i()) >>> 8);
    }

    public double nextGaussian() {
        double d2;
        double d4;
        double d5;
        ThreadLocal threadLocal = c;
        Double d6 = (Double)threadLocal.get();
        if (d6 != null) {
            threadLocal.set(null);
            return d6;
        }
        while ((d5 = (d4 = 2.0 * this.nextDouble() - 1.0) * d4 + (d2 = 2.0 * this.nextDouble() - 1.0) * d2) >= 1.0 || d5 == 0.0) {
        }
        double d7 = StrictMath.sqrt((double)(-2.0 * StrictMath.log((double)d5) / d5));
        c.set((Object)new Double(d2 * d7));
        return d4 * d7;
    }

    public int nextInt() {
        return ThreadLocalRandom.g(this.i());
    }

    public int nextInt(int n2) {
        if (n2 > 0) {
            int n3;
            int n4;
            int n5;
            int n6 = ThreadLocalRandom.g(this.i());
            int n7 = n2 - 1;
            if ((n2 & n7) == 0) {
                return n6 & n7;
            }
            while ((n4 = (n3 = n6 >>> 1) + n7) - (n5 = n3 % n2) < 0) {
                n6 = ThreadLocalRandom.g(this.i());
            }
            return n5;
        }
        throw new IllegalArgumentException("bound must be positive");
    }

    public long nextLong() {
        return ThreadLocalRandom.h(this.i());
    }

    public void setSeed(long l2) {
        if (!this.g) {
            return;
        }
        throw new UnsupportedOperationException();
    }

}

