/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j$.util.u$b
 *  j$.util.u$c
 *  j$.util.u$d
 *  j$.util.u$f
 *  j$.util.u$g$a
 *  j$.util.u$g$b
 *  j$.util.u$g$c
 *  j$.util.u$h
 *  j$.util.u$j
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 *  java.util.Objects
 *  java.util.function.Consumer
 */
package j$.util;

import j$.util.Iterator;
import j$.util.Iterator$-CC;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.s;
import j$.util.u;
import j$.x;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;

/*
 * Exception performing whole class analysis.
 */
public final class u {
    private static final Spliterator a;
    private static final Spliterator.b b;
    private static final Spliterator.c c;
    private static final Spliterator.a d;

    static {
        a = new g.d();
        b = new /* Unavailable Anonymous Inner Class!! */;
        c = new /* Unavailable Anonymous Inner Class!! */;
        d = new /* Unavailable Anonymous Inner Class!! */;
    }

    private static void a(int n2, int n3, int n4) {
        if (n3 <= n4) {
            if (n3 >= 0) {
                if (n4 <= n2) {
                    return;
                }
                throw new ArrayIndexOutOfBoundsException(n4);
            }
            throw new ArrayIndexOutOfBoundsException(n3);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("origin(");
        stringBuilder.append(n3);
        stringBuilder.append(") > fence(");
        stringBuilder.append(n4);
        stringBuilder.append(")");
        throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    }

    public static Spliterator.a b() {
        return d;
    }

    public static Spliterator.b c() {
        return b;
    }

    public static Spliterator.c d() {
        return c;
    }

    public static Spliterator e() {
        return a;
    }

    public static s.a f(Spliterator.a a2) {
        Objects.requireNonNull((Object)a2);
        return new d(a2);
    }

    public static s.b g(Spliterator.b b2) {
        Objects.requireNonNull((Object)b2);
        return new b(b2);
    }

    public static s.c h(Spliterator.c c2) {
        Objects.requireNonNull((Object)c2);
        return new c(c2);
    }

    public static java.util.Iterator i(Spliterator spliterator) {
        Objects.requireNonNull((Object)spliterator);
        return spliterator.new a();
    }

    public static Spliterator.a j(double[] arrd, int n2, int n3, int n4) {
        Objects.requireNonNull((Object)arrd);
        u.a(arrd.length, n2, n3);
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static Spliterator.b k(int[] arrn, int n2, int n3, int n4) {
        Objects.requireNonNull((Object)arrn);
        u.a(arrn.length, n2, n3);
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static Spliterator.c l(long[] arrl, int n2, int n3, int n4) {
        Objects.requireNonNull((Object)arrl);
        u.a(arrl.length, n2, n3);
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static Spliterator m(Collection collection, int n2) {
        Objects.requireNonNull((Object)collection);
        return new i(collection, n2);
    }

    public static Spliterator n(Object[] arrobject, int n2, int n3, int n4) {
        Objects.requireNonNull((Object)arrobject);
        u.a(arrobject.length, n2, n3);
        return new e(arrobject, n2, n3, n4);
    }

    public static Spliterator o(java.util.Iterator iterator, int n2) {
        Objects.requireNonNull((Object)iterator);
        return new i(iterator, n2);
    }

    class a
    implements java.util.Iterator<T>,
    Consumer<T>,
    Iterator {
        boolean a = false;
        Object b;

        a() {
        }

        @Override
        public void accept(Object object) {
            this.a = true;
            this.b = object;
        }

        @Override
        public Consumer f(Consumer consumer) {
            Objects.requireNonNull((Object)consumer);
            return new j$.util.function.e(this, consumer);
        }

        @Override
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator$-CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator$-CC.$default$forEachRemaining(this, x.b(consumer));
        }

        @Override
        public boolean hasNext() {
            if (!this.a) {
                Spliterator.this.b(this);
            }
            return this.a;
        }

        @Override
        public Object next() {
            if (!this.a && !this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.a = false;
            return this.b;
        }

        @Override
        public /* synthetic */ void remove() {
            Iterator$-CC.a(this);
            throw null;
        }
    }

    static final class e<T>
    implements Spliterator<T> {
        private final Object[] a;
        private int b;
        private final int c;
        private final int d;

        public e(Object[] arrobject, int n2, int n3, int n4) {
            this.a = arrobject;
            this.b = n2;
            this.c = n3;
            this.d = 16384 | (n4 | 64);
        }

        @Override
        public boolean b(Consumer consumer) {
            consumer.getClass();
            int n2 = this.b;
            if (n2 >= 0 && n2 < this.c) {
                Object[] arrobject = this.a;
                this.b = n2 + 1;
                consumer.accept(arrobject[n2]);
                return true;
            }
            return false;
        }

        @Override
        public int characteristics() {
            return this.d;
        }

        @Override
        public long estimateSize() {
            return this.c - this.b;
        }

        @Override
        public void forEachRemaining(Consumer consumer) {
            int n2;
            consumer.getClass();
            Object[] arrobject = this.a;
            int n3 = arrobject.length;
            int n4 = this.c;
            if (n3 >= n4 && (n2 = this.b) >= 0) {
                this.b = n4;
                if (n2 < n4) {
                    do {
                        consumer.accept(arrobject[n2]);
                    } while (++n2 < n4);
                }
            }
        }

        @Override
        public Comparator getComparator() {
            if (j$.time.e.h(this, 4)) {
                return null;
            }
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
        public Spliterator trySplit() {
            int n2 = this.b;
            int n3 = n2 + this.c >>> 1;
            if (n2 >= n3) {
                return null;
            }
            Object[] arrobject = this.a;
            this.b = n3;
            return new e<T>(arrobject, n2, n3, this.d);
        }
    }

    private static abstract class g<T, S extends Spliterator<T>, C> {
        g() {
        }

        public int characteristics() {
            return 16448;
        }

        public long estimateSize() {
            return 0L;
        }

        public void forEachRemaining(Object object) {
            Objects.requireNonNull((Object)object);
        }

        public boolean tryAdvance(Object object) {
            Objects.requireNonNull((Object)object);
            return false;
        }

        public Spliterator trySplit() {
            return null;
        }

        private static final class d<T>
        extends g<T, Spliterator<T>, Consumer<? super T>>
        implements Spliterator<T> {
            d() {
            }

            @Override
            public boolean b(Consumer consumer) {
                Objects.requireNonNull((Object)consumer);
                return false;
            }

            @Override
            public void forEachRemaining(Consumer consumer) {
                Objects.requireNonNull((Object)consumer);
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

    static class i<T>
    implements Spliterator<T> {
        private final Collection a;
        private java.util.Iterator b;
        private final int c;
        private long d;
        private int e;

        public i(Collection collection, int n2) {
            this.a = collection;
            this.b = null;
            if ((n2 & 4096) == 0) {
                n2 = 16384 | (n2 | 64);
            }
            this.c = n2;
        }

        public i(java.util.Iterator iterator, int n2) {
            this.a = null;
            this.b = iterator;
            this.d = Long.MAX_VALUE;
            this.c = n2 & -16449;
        }

        @Override
        public boolean b(Consumer consumer) {
            consumer.getClass();
            if (this.b == null) {
                this.b = this.a.iterator();
                this.d = this.a.size();
            }
            if (this.b.hasNext()) {
                consumer.accept(this.b.next());
                return true;
            }
            return false;
        }

        @Override
        public int characteristics() {
            return this.c;
        }

        @Override
        public long estimateSize() {
            if (this.b == null) {
                long l2;
                this.b = this.a.iterator();
                this.d = l2 = (long)this.a.size();
                return l2;
            }
            return this.d;
        }

        @Override
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            java.util.Iterator iterator = this.b;
            if (iterator == null) {
                this.b = iterator = this.a.iterator();
                this.d = this.a.size();
            }
            if (iterator instanceof Iterator) {
                ((Iterator)iterator).forEachRemaining(consumer);
                return;
            }
            Iterator$-CC.$default$forEachRemaining(iterator, consumer);
        }

        @Override
        public Comparator getComparator() {
            if (j$.time.e.h(this, 4)) {
                return null;
            }
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
        public Spliterator trySplit() {
            long l2;
            java.util.Iterator iterator = this.b;
            if (iterator == null) {
                this.b = iterator = this.a.iterator();
                this.d = l2 = (long)this.a.size();
            } else {
                l2 = this.d;
            }
            if (l2 > 1L && iterator.hasNext()) {
                int n2 = 1024 + this.e;
                if ((long)n2 > l2) {
                    n2 = (int)l2;
                }
                if (n2 > 33554432) {
                    n2 = 33554432;
                }
                Object[] arrobject = new Object[n2];
                int n3 = 0;
                do {
                    arrobject[n3] = iterator.next();
                } while (++n3 < n2 && iterator.hasNext());
                this.e = n3;
                long l3 = this.d;
                if (l3 != Long.MAX_VALUE) {
                    this.d = l3 - (long)n3;
                }
                return new e(arrobject, 0, n3, this.c);
            }
            return null;
        }
    }

}

