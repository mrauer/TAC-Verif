/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Comparator
 *  java.util.Objects
 *  java.util.concurrent.atomic.AtomicLong
 */
package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.stream.X2;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

abstract class d3<T, T_SPLITR extends Spliterator<T>> {
    protected final Spliterator a;
    protected final boolean b;
    private final long c;
    private final AtomicLong d;

    d3(Spliterator spliterator, long l2, long l3) {
        this.a = spliterator;
        long l4 = 0L;
        long l5 = l3 LCMP l4;
        boolean bl = l5 < 0;
        this.b = bl;
        if (l5 >= 0) {
            l4 = l3;
        }
        this.c = l4;
        if (l5 >= 0) {
            l2 += l3;
        }
        this.d = new AtomicLong(l2);
    }

    d3(Spliterator spliterator, d3 d32) {
        this.a = spliterator;
        this.b = d32.b;
        this.d = d32.d;
        this.c = d32.c;
    }

    public final int characteristics() {
        return -16465 & this.a.characteristics();
    }

    public final long estimateSize() {
        return this.a.estimateSize();
    }

    protected final long q(long l2) {
        long l3;
        long l4;
        do {
            if ((l3 = this.d.get()) != 0L) continue;
            if (this.b) {
                return l2;
            }
            return 0L;
        } while ((l4 = Math.min((long)l3, (long)l2)) > 0L && !this.d.compareAndSet(l3, l3 - l4));
        if (this.b) {
            return Math.max((long)(l2 - l4), (long)0L);
        }
        long l5 = this.c;
        if (l3 > l5) {
            return Math.max((long)(l4 - (l3 - l5)), (long)0L);
        }
        return l4;
    }

    protected abstract Spliterator r(Spliterator var1);

    protected final f s() {
        if (this.d.get() > 0L) {
            return f.MAYBE_MORE;
        }
        if (this.b) {
            return f.UNLIMITED;
        }
        return f.NO_MORE;
    }

    public final Spliterator trySplit() {
        if (this.d.get() == 0L) {
            return null;
        }
        Spliterator spliterator = this.a.trySplit();
        if (spliterator == null) {
            return null;
        }
        return this.r(spliterator);
    }

    static final class e<T>
    extends d3<T, Spliterator<T>>
    implements Spliterator<T>,
    Consumer<T> {
        Object e;

        e(Spliterator spliterator, long l2, long l3) {
            super(spliterator, l2, l3);
        }

        e(Spliterator spliterator, e e2) {
            super(spliterator, e2);
        }

        @Override
        public final void accept(Object object) {
            this.e = object;
        }

        @Override
        public boolean b(Consumer consumer) {
            Objects.requireNonNull((Object)consumer);
            while (this.s() != f.NO_MORE) {
                if (!this.a.b(this)) {
                    return false;
                }
                if (this.q(1L) != 1L) continue;
                consumer.accept(this.e);
                this.e = null;
                return true;
            }
            return false;
        }

        @Override
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull((Object)consumer);
            return new j$.util.function.e(this, consumer);
        }

        @Override
        public void forEachRemaining(Consumer consumer) {
            f f2;
            Objects.requireNonNull((Object)consumer);
            X2.e e2 = null;
            while ((f2 = this.s()) != f.NO_MORE) {
                if (f2 == f.MAYBE_MORE) {
                    int n2 = 0;
                    if (e2 == null) {
                        e2 = new X2.e(128);
                    } else {
                        e2.a = 0;
                    }
                    long l2 = 0L;
                    while (this.a.b(e2) && ++l2 < 128L) {
                    }
                    if (l2 == 0L) {
                        return;
                    }
                    long l3 = this.q(l2);
                    while ((long)n2 < l3) {
                        consumer.accept(e2.b[n2]);
                        ++n2;
                    }
                    continue;
                }
                this.a.forEachRemaining(consumer);
                break;
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

        @Override
        protected Spliterator r(Spliterator spliterator) {
            return new e<T>(spliterator, this);
        }
    }

    static final class f
    extends Enum<f> {
        public static final /* enum */ f MAYBE_MORE;
        public static final /* enum */ f NO_MORE;
        public static final /* enum */ f UNLIMITED;
        private static final /* synthetic */ f[] a;

        static {
            f f2;
            f f4;
            f f5;
            NO_MORE = f5 = new f();
            MAYBE_MORE = f4 = new f();
            UNLIMITED = f2 = new f();
            a = new f[]{f5, f4, f2};
        }

        public static f valueOf(String string) {
            return (f)Enum.valueOf(f.class, (String)string);
        }

        public static f[] values() {
            return (f[])a.clone();
        }
    }

}

