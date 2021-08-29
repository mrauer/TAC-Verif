/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.Comparator
 */
package j$.util;

import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.function.r;
import j$.util.function.x;
import java.util.Comparator;

public interface Spliterator<T> {
    public boolean b(Consumer var1);

    public int characteristics();

    public long estimateSize();

    public void forEachRemaining(Consumer var1);

    public Comparator getComparator();

    public long getExactSizeIfKnown();

    public boolean hasCharacteristics(int var1);

    public Spliterator trySplit();

    public static interface a
    extends d<Double, r, a> {
        @Override
        public boolean b(Consumer var1);

        public void e(r var1);

        @Override
        public void forEachRemaining(Consumer var1);

        public boolean o(r var1);

        @Override
        public a trySplit();
    }

    public static interface b
    extends d<Integer, x, b> {
        @Override
        public boolean b(Consumer var1);

        public void c(x var1);

        @Override
        public void forEachRemaining(Consumer var1);

        public boolean h(x var1);

        @Override
        public b trySplit();
    }

    public static interface c
    extends d<Long, D, c> {
        @Override
        public boolean b(Consumer var1);

        public void d(D var1);

        @Override
        public void forEachRemaining(Consumer var1);

        public boolean j(D var1);

        @Override
        public c trySplit();
    }

    public static interface d<T, T_CONS, T_SPLITR extends d<T, T_CONS, T_SPLITR>>
    extends Spliterator<T> {
        public void forEachRemaining(Object var1);

        public boolean tryAdvance(Object var1);

        @Override
        public d trySplit();
    }

}

