/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.Comparator
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.stream.E0;
import j$.util.stream.F0;
import java.util.Comparator;
import java.util.Objects;

abstract class c3<T, T_SPLITR extends Spliterator<T>> {
    final long a;
    final long b;
    Spliterator c;
    long d;
    long e;

    c3(Spliterator spliterator, long l2, long l3, long l4, long l5) {
        this.c = spliterator;
        this.a = l2;
        this.b = l3;
        this.d = l4;
        this.e = l5;
    }

    protected abstract Spliterator a(Spliterator var1, long var2, long var4, long var6, long var8);

    public int characteristics() {
        return this.c.characteristics();
    }

    public long estimateSize() {
        long l2 = this.a;
        long l3 = this.e;
        if (l2 < l3) {
            return l3 - Math.max((long)l2, (long)this.d);
        }
        return 0L;
    }

    public Spliterator trySplit() {
        long l2;
        long l3;
        Spliterator spliterator;
        long l4;
        long l5;
        long l6 = this.a;
        long l7 = this.e;
        if (l6 >= l7) {
            return null;
        }
        if (this.d >= l7) {
            return null;
        }
        do {
            if ((spliterator = this.c.trySplit()) == null) {
                return null;
            }
            l3 = this.a;
            l2 = this.d + spliterator.estimateSize();
            l4 = Math.min((long)l2, (long)this.b);
            if (l3 >= l4) {
                this.d = l4;
                continue;
            }
            l5 = this.b;
            if (l4 < l5) break;
            this.c = spliterator;
            this.e = l4;
        } while (true);
        long l8 = this.d;
        if (l8 >= l3 && l2 <= l5) {
            this.d = l4;
            return spliterator;
        }
        this.d = l4;
        return this.a(spliterator, l3, l5, l8, l4);
    }

    static final class e<T>
    extends c3<T, Spliterator<T>>
    implements Spliterator<T> {
        e(Spliterator spliterator, long l2, long l3) {
            super(spliterator, l2, l3, 0L, Math.min((long)spliterator.estimateSize(), (long)l3));
        }

        private e(Spliterator spliterator, long l2, long l3, long l4, long l5) {
            super(spliterator, l2, l3, l4, l5);
        }

        @Override
        protected Spliterator a(Spliterator spliterator, long l2, long l3, long l4, long l5) {
            e<T> e2 = new e<T>(spliterator, l2, l3, l4, l5);
            return e2;
        }

        @Override
        public boolean b(Consumer consumer) {
            long l2;
            long l3;
            Objects.requireNonNull((Object)consumer);
            if (this.a >= this.e) {
                return false;
            }
            while ((l2 = this.a) > (l3 = this.d)) {
                this.c.b(E0.a);
                this.d = 1L + this.d;
            }
            if (l3 >= this.e) {
                return false;
            }
            this.d = l3 + 1L;
            return this.c.b(consumer);
        }

        @Override
        public void forEachRemaining(Consumer consumer) {
            Objects.requireNonNull((Object)consumer);
            long l2 = this.a;
            long l3 = this.e;
            if (l2 >= l3) {
                return;
            }
            long l4 = this.d;
            if (l4 >= l3) {
                return;
            }
            if (l4 >= l2 && l4 + this.c.estimateSize() <= this.b) {
                this.c.forEachRemaining(consumer);
                this.d = this.e;
                return;
            }
            while (this.a > this.d) {
                this.c.b(F0.a);
                this.d = 1L + this.d;
            }
            while (this.d < this.e) {
                this.c.b(consumer);
                this.d = 1L + this.d;
            }
        }

        @Override
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.e.g(this);
        }

        @Override
        public /* synthetic */ boolean hasCharacteristics(int n2) {
            return j$.time.e.h(this, n2);
        }
    }

}

