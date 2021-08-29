/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.Iterator
 */
package j$.util;

import j$.util.Iterator;
import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.function.r;
import j$.util.function.x;

public interface s<T, T_CONS>
extends java.util.Iterator<T>,
Iterator {
    public void forEachRemaining(Object var1);

    public static interface a
    extends s<Double, r> {
        public void e(r var1);

        @Override
        public void forEachRemaining(Consumer var1);

        public Double next();

        public double nextDouble();
    }

    public static interface b
    extends s<Integer, x> {
        public void c(x var1);

        @Override
        public void forEachRemaining(Consumer var1);

        public Integer next();

        public int nextInt();
    }

    public static interface c
    extends s<Long, D> {
        public void d(D var1);

        @Override
        public void forEachRemaining(Consumer var1);

        public Long next();

        public long nextLong();
    }

}

