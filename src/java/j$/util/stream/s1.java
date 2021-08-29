/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  j$.util.stream.R1$a$a
 *  j$.util.stream.R1$a$b
 *  j$.util.stream.R1$a$c
 *  j$.util.stream.S1$f$a
 *  j$.util.stream.S1$f$b
 *  j$.util.stream.S1$f$c
 *  j$.util.stream.S1$g
 *  j$.util.stream.S1$h
 *  j$.util.stream.S1$i
 *  j$.util.stream.S1$j$a
 *  j$.util.stream.S1$j$b
 *  j$.util.stream.S1$j$c
 *  j$.util.stream.S1$k
 *  j$.util.stream.S1$l
 *  j$.util.stream.S1$m
 *  j$.util.stream.S1$n
 *  j$.util.stream.S1$o$e
 *  j$.util.stream.S1$p
 *  j$.util.stream.S1$q
 *  j$.util.stream.S1$r
 *  j$.util.stream.S1$s
 *  j$.util.stream.S1$s$a
 *  j$.util.stream.S1$s$b
 *  j$.util.stream.S1$s$c
 *  j$.util.stream.S1$s$d
 *  j$.util.stream.S1$t
 *  j$.util.stream.S1$u$a
 *  j$.util.stream.S1$u$b
 *  j$.util.stream.S1$u$c
 *  j$.util.stream.Z
 *  j$.util.stream.f
 *  j$.util.stream.y
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Void
 *  java.util.ArrayDeque
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.Deque
 *  java.util.Objects
 *  java.util.concurrent.CountedCompleter
 *  java.util.concurrent.ForkJoinTask
 */
package j$.util.stream;

import j$.util.Collection$-EL;
import j$.util.Spliterator;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.E;
import j$.util.function.y;
import j$.util.stream.A2;
import j$.util.stream.B;
import j$.util.stream.P0;
import j$.util.stream.Q1;
import j$.util.stream.R1;
import j$.util.stream.S1;
import j$.util.stream.T1;
import j$.util.stream.U2;
import j$.util.stream.c1;
import j$.util.stream.e1;
import j$.util.stream.j0;
import j$.util.stream.k1;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Objects;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinTask;

/*
 * Exception performing whole class analysis.
 */
final class S1 {
    private static final R1 a;
    private static final R1.c b;
    private static final R1.d c;
    private static final R1.b d;
    private static final int[] e;
    private static final long[] f;
    private static final double[] g;

    static {
        a = new j.d(null);
        b = new /* Unavailable Anonymous Inner Class!! */;
        c = new /* Unavailable Anonymous Inner Class!! */;
        d = new /* Unavailable Anonymous Inner Class!! */;
        e = new int[0];
        f = new long[0];
        g = new double[0];
    }

    static /* synthetic */ int[] a() {
        return e;
    }

    static /* synthetic */ long[] b() {
        return f;
    }

    static /* synthetic */ double[] c() {
        return g;
    }

    static R1.a d(long l2, y y3) {
        if (l2 >= 0L && l2 < 0x7FFFFFF7L) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static R1 e(T1 t12, Spliterator spliterator, boolean bl, y y3) {
        long l2 = t12.n0(spliterator);
        if (l2 >= 0L && spliterator.hasCharacteristics(16384)) {
            if (l2 < 0x7FFFFFF7L) {
                Object[] arrobject = (Object[])y3.apply((int)l2);
                new d(spliterator, t12, arrobject).invoke();
                return new c(arrobject);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        R1 r1 = (R1)new e.d(t12, y3, spliterator).invoke();
        if (bl) {
            r1 = S1.l(r1, y3);
        }
        return r1;
    }

    public static R1.b f(T1 t12, Spliterator spliterator, boolean bl) {
        long l2 = t12.n0(spliterator);
        if (l2 >= 0L && spliterator.hasCharacteristics(16384)) {
            if (l2 < 0x7FFFFFF7L) {
                double[] arrd = new double[(int)l2];
                new a(spliterator, t12, arrd).invoke();
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        R1.b b2 = (R1.b)new e.a(t12, spliterator).invoke();
        if (bl) {
            b2 = S1.m(b2);
        }
        return b2;
    }

    public static R1.c g(T1 t12, Spliterator spliterator, boolean bl) {
        long l2 = t12.n0(spliterator);
        if (l2 >= 0L && spliterator.hasCharacteristics(16384)) {
            if (l2 < 0x7FFFFFF7L) {
                int[] arrn = new int[(int)l2];
                new b(spliterator, t12, arrn).invoke();
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        R1.c c2 = (R1.c)new e.b(t12, spliterator).invoke();
        if (bl) {
            c2 = S1.n(c2);
        }
        return c2;
    }

    public static R1.d h(T1 t12, Spliterator spliterator, boolean bl) {
        long l2 = t12.n0(spliterator);
        if (l2 >= 0L && spliterator.hasCharacteristics(16384)) {
            if (l2 < 0x7FFFFFF7L) {
                long[] arrl = new long[(int)l2];
                new c(spliterator, t12, arrl).invoke();
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        R1.d d2 = (R1.d)new e.c(t12, spliterator).invoke();
        if (bl) {
            d2 = S1.o(d2);
        }
        return d2;
    }

    static R1 i(U2 u2, R1 r1, R1 r12) {
        int n2 = u2.ordinal();
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 == 3) {
                        return new /* Unavailable Anonymous Inner Class!! */;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown shape ");
                    stringBuilder.append((Object)u2);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        return new f(r1, r12);
    }

    static R1.a.a j(long l2) {
        if (l2 >= 0L && l2 < 0x7FFFFFF7L) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    static R1 k(U2 u2) {
        int n2 = u2.ordinal();
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 == 3) {
                        return d;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown shape ");
                    stringBuilder.append((Object)u2);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                return c;
            }
            return b;
        }
        return a;
    }

    public static R1 l(R1 r1, y y3) {
        if (r1.o() > 0) {
            long l2 = r1.count();
            if (l2 < 0x7FFFFFF7L) {
                Object[] arrobject = (Object[])y3.apply((int)l2);
                new u.e(r1, arrobject, 0, null).invoke();
                return new c(arrobject);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return r1;
    }

    public static R1.b m(R1.b b2) {
        if (b2.o() > 0) {
            long l2 = b2.count();
            if (l2 < 0x7FFFFFF7L) {
                double[] arrd = new double[(int)l2];
                new /* Unavailable Anonymous Inner Class!! */.invoke();
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return b2;
    }

    public static R1.c n(R1.c c2) {
        if (c2.o() > 0) {
            long l2 = c2.count();
            if (l2 < 0x7FFFFFF7L) {
                int[] arrn = new int[(int)l2];
                new /* Unavailable Anonymous Inner Class!! */.invoke();
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return c2;
    }

    public static R1.d o(R1.d d2) {
        if (d2.o() > 0) {
            long l2 = d2.count();
            if (l2 < 0x7FFFFFF7L) {
                long[] arrl = new long[(int)l2];
                new /* Unavailable Anonymous Inner Class!! */.invoke();
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return d2;
    }

    static R1.a.b p(long l2) {
        if (l2 >= 0L && l2 < 0x7FFFFFF7L) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    static R1.a.c q(long l2) {
        if (l2 >= 0L && l2 < 0x7FFFFFF7L) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    private static abstract class b<T, T_NODE extends R1<T>>
    implements R1<T> {
        protected final R1 a;
        protected final R1 b;
        private final long c;

        b(R1 r1, R1 r12) {
            this.a = r1;
            this.b = r12;
            this.c = r1.count() + r12.count();
        }

        @Override
        public R1 b(int n2) {
            if (n2 == 0) {
                return this.a;
            }
            if (n2 == 1) {
                return this.b;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override
        public long count() {
            return this.c;
        }

        @Override
        public int o() {
            return 2;
        }
    }

    private static class c<T>
    implements R1<T> {
        final Object[] a;
        int b;

        c(long l2, y y3) {
            if (l2 < 0x7FFFFFF7L) {
                this.a = (Object[])y3.apply((int)l2);
                this.b = 0;
                return;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        c(Object[] arrobject) {
            this.a = arrobject;
            this.b = arrobject.length;
        }

        @Override
        public R1 b(int n2) {
            throw new IndexOutOfBoundsException();
        }

        @Override
        public long count() {
            return this.b;
        }

        @Override
        public void forEach(Consumer consumer) {
            for (int i2 = 0; i2 < this.b; ++i2) {
                consumer.accept(this.a[i2]);
            }
        }

        @Override
        public void j(Object[] arrobject, int n2) {
            System.arraycopy((Object)this.a, (int)0, (Object)arrobject, (int)n2, (int)this.b);
        }

        @Override
        public /* synthetic */ int o() {
            return 0;
        }

        @Override
        public Object[] q(y y3) {
            Object[] arrobject = this.a;
            if (arrobject.length == this.b) {
                return arrobject;
            }
            throw new IllegalStateException();
        }

        @Override
        public /* synthetic */ R1 r(long l2, long l3, y y3) {
            return Q1.n(this, l2, l3, y3);
        }

        @Override
        public Spliterator spliterator() {
            return j$.util.u.n(this.a, 0, this.b, 1040);
        }

        public String toString() {
            Object[] arrobject = new Object[]{this.a.length - this.b, Arrays.toString((Object[])this.a)};
            return String.format((String)"ArrayNode[%d][%s]", (Object[])arrobject);
        }
    }

    private static final class d<T>
    implements R1<T> {
        private final Collection a;

        d(Collection collection) {
            this.a = collection;
        }

        @Override
        public R1 b(int n2) {
            throw new IndexOutOfBoundsException();
        }

        @Override
        public long count() {
            return this.a.size();
        }

        @Override
        public void forEach(Consumer consumer) {
            Collection$-EL.a(this.a, consumer);
        }

        @Override
        public void j(Object[] arrobject, int n2) {
            for (Object object : this.a) {
                int n3 = n2 + 1;
                arrobject[n2] = object;
                n2 = n3;
            }
        }

        @Override
        public /* synthetic */ int o() {
            return 0;
        }

        @Override
        public Object[] q(y y3) {
            Collection collection = this.a;
            return collection.toArray((Object[])y3.apply(collection.size()));
        }

        @Override
        public /* synthetic */ R1 r(long l2, long l3, y y3) {
            return Q1.n(this, l2, l3, y3);
        }

        @Override
        public Spliterator spliterator() {
            return Collection$-EL.stream(this.a).spliterator();
        }

        public String toString() {
            Object[] arrobject = new Object[]{this.a.size(), this.a};
            return String.format((String)"CollectionNode[%d][%s]", (Object[])arrobject);
        }
    }

    private static class e<P_IN, P_OUT, T_NODE extends R1<P_OUT>, T_BUILDER extends R1.a<P_OUT>>
    extends k1<P_IN, P_OUT, T_NODE, e<P_IN, P_OUT, T_NODE, T_BUILDER>> {
        protected final T1 h;
        protected final E i;
        protected final BinaryOperator j;

        e(e e2, Spliterator spliterator) {
            super(e2, spliterator);
            this.h = e2.h;
            this.i = e2.i;
            this.j = e2.j;
        }

        e(T1 t12, Spliterator spliterator, E e2, BinaryOperator binaryOperator) {
            super(t12, spliterator);
            this.h = t12;
            this.i = e2;
            this.j = binaryOperator;
        }

        @Override
        protected Object a() {
            R1.a a2 = (R1.a)this.i.apply(this.h.n0(this.c));
            this.h.r0(a2, this.c);
            return a2.a();
        }

        @Override
        protected k1 f(Spliterator spliterator) {
            return new e<P_IN, P_OUT, T_NODE, T_BUILDER>(this, spliterator);
        }

        @Override
        public void onCompletion(CountedCompleter countedCompleter) {
            if (!this.d()) {
                this.g((R1)this.j.apply((R1)((e)this.e).b(), (R1)((e)this.f).b()));
            }
            this.c = null;
            this.f = null;
            this.e = null;
        }

        private static final class a<P_IN>
        extends e<P_IN, Double, R1.b, R1.a.a> {
            a(T1 t12, Spliterator spliterator) {
                super(t12, spliterator, e1.a, (BinaryOperator)j.Z.a);
            }
        }

        private static final class b<P_IN>
        extends e<P_IN, Integer, R1.c, R1.a.b> {
            b(T1 t12, Spliterator spliterator) {
                super(t12, spliterator, c1.a, (BinaryOperator)j.f.a);
            }
        }

        private static final class c<P_IN>
        extends e<P_IN, Long, R1.d, R1.a.c> {
            c(T1 t12, Spliterator spliterator) {
                super(t12, spliterator, B.a, (BinaryOperator)j.y.a);
            }
        }

        private static final class d<P_IN, P_OUT>
        extends e<P_IN, P_OUT, R1<P_OUT>, R1.a<P_OUT>> {
            d(T1 t12, y y3, Spliterator spliterator) {
                super(t12, spliterator, new j0(y3), P0.a);
            }
        }

    }

    /*
     * Exception performing whole class analysis.
     */
    static final class f<T>
    extends j$.util.stream.S1$b<T, R1<T>>
    implements R1<T> {
        f(R1 r1, R1 r12) {
            super(r1, r12);
        }

        @Override
        public void forEach(Consumer consumer) {
            this.a.forEach(consumer);
            this.b.forEach(consumer);
        }

        @Override
        public void j(Object[] arrobject, int n2) {
            Objects.requireNonNull((Object)arrobject);
            this.a.j(arrobject, n2);
            this.b.j(arrobject, n2 + (int)this.a.count());
        }

        @Override
        public Object[] q(y y3) {
            long l2 = this.count();
            if (l2 < 0x7FFFFFF7L) {
                Object[] arrobject = (Object[])y3.apply((int)l2);
                this.j(arrobject, 0);
                return arrobject;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        @Override
        public R1 r(long l2, long l3, y y3) {
            if (l2 == 0L && l3 == this.count()) {
                return this;
            }
            long l4 = this.a.count();
            if (l2 >= l4) {
                return this.b.r(l2 - l4, l3 - l4, y3);
            }
            if (l3 <= l4) {
                return this.a.r(l2, l3, y3);
            }
            return S1.i(U2.REFERENCE, this.a.r(l2, l4, y3), this.b.r(0L, l3 - l4, y3));
        }

        @Override
        public Spliterator spliterator() {
            return new /* Unavailable Anonymous Inner Class!! */;
        }

        public String toString() {
            if (this.count() < 32L) {
                Object[] arrobject = new Object[]{this.a, this.b};
                return String.format((String)"ConcNode[%s.%s]", (Object[])arrobject);
            }
            Object[] arrobject = new Object[]{this.count()};
            return String.format((String)"ConcNode[size=%d]", (Object[])arrobject);
        }

        private static abstract class d<E, T_CONS, T_ARR, T_SPLITR extends Spliterator.d<E, T_CONS, T_SPLITR>, T_NODE extends R1.e<E, T_CONS, T_ARR, T_SPLITR, T_NODE>>
        extends j$.util.stream.S1$b<E, T_NODE>
        implements R1.e<E, T_CONS, T_ARR, T_SPLITR, T_NODE> {
            d(R1.e e2, R1.e e4) {
                super(e2, e4);
            }

            @Override
            public void d(Object object, int n2) {
                ((R1.e)this.a).d(object, n2);
                ((R1.e)this.b).d(object, n2 + (int)((R1.e)this.a).count());
            }

            @Override
            public Object e() {
                long l2 = this.count();
                if (l2 < 0x7FFFFFF7L) {
                    Object object = this.c((int)l2);
                    this.d(object, 0);
                    return object;
                }
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }

            @Override
            public void h(Object object) {
                ((R1.e)this.a).h(object);
                ((R1.e)this.b).h(object);
            }

            @Override
            public /* synthetic */ Object[] q(y y3) {
                return Q1.d(this, y3);
            }

            public String toString() {
                if (this.count() < 32L) {
                    Object[] arrobject = new Object[]{this.getClass().getName(), this.a, this.b};
                    return String.format((String)"%s[%s.%s]", (Object[])arrobject);
                }
                Object[] arrobject = new Object[]{this.getClass().getName(), this.count()};
                return String.format((String)"%s[size=%d]", (Object[])arrobject);
            }
        }

    }

    private static abstract class j<T, T_ARR, T_CONS>
    implements R1<T> {
        j() {
        }

        @Override
        public R1 b(int n2) {
            throw new IndexOutOfBoundsException();
        }

        @Override
        public long count() {
            return 0L;
        }

        public void d(Object object, int n2) {
        }

        public void h(Object object) {
        }

        @Override
        public /* synthetic */ int o() {
            return 0;
        }

        @Override
        public Object[] q(y y3) {
            return (Object[])y3.apply(0);
        }

        @Override
        public /* synthetic */ R1 r(long l2, long l3, y y3) {
            return Q1.n(this, l2, l3, y3);
        }

        private static class d<T>
        extends j<T, T[], Consumer<? super T>> {
            d(j$.util.stream.S1$a a2) {
            }

            @Override
            public void forEach(Consumer consumer) {
            }

            @Override
            public void j(Object[] arrobject, int n2) {
            }

            @Override
            public Spliterator spliterator() {
                return j$.util.u.e();
            }
        }

    }

    private static abstract class o<T, S extends Spliterator<T>, N extends R1<T>>
    implements Spliterator<T> {
        R1 a;
        int b;
        Spliterator c;
        Spliterator d;
        Deque e;

        o(R1 r1) {
            this.a = r1;
        }

        protected final R1 a(Deque deque) {
            R1 r1;
            while ((r1 = (R1)deque.pollFirst()) != null) {
                if (r1.o() == 0) {
                    if (r1.count() <= 0L) continue;
                    return r1;
                }
                for (int i2 = -1 + r1.o(); i2 >= 0; --i2) {
                    deque.addFirst((Object)r1.b(i2));
                }
            }
            return null;
        }

        @Override
        public final int characteristics() {
            return 64;
        }

        @Override
        public final long estimateSize() {
            R1 r1 = this.a;
            long l2 = 0L;
            if (r1 == null) {
                return l2;
            }
            Spliterator spliterator = this.c;
            if (spliterator != null) {
                return spliterator.estimateSize();
            }
            for (int i2 = this.b; i2 < this.a.o(); ++i2) {
                l2 += this.a.b(i2).count();
            }
            return l2;
        }

        protected final Deque f() {
            ArrayDeque arrayDeque = new ArrayDeque(8);
            for (int i2 = -1 + this.a.o(); i2 >= this.b; --i2) {
                arrayDeque.addFirst((Object)this.a.b(i2));
            }
            return arrayDeque;
        }

        protected final boolean g() {
            if (this.a == null) {
                return false;
            }
            if (this.d == null) {
                Spliterator spliterator = this.c;
                if (spliterator == null) {
                    Deque deque;
                    this.e = deque = this.f();
                    R1 r1 = this.a(deque);
                    if (r1 != null) {
                        spliterator = r1.spliterator();
                    } else {
                        this.a = null;
                        return false;
                    }
                }
                this.d = spliterator;
            }
            return true;
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
        public final Spliterator trySplit() {
            R1 r1 = this.a;
            if (r1 != null && this.d == null) {
                R1 r12;
                Spliterator spliterator = this.c;
                if (spliterator != null) {
                    return spliterator.trySplit();
                }
                if (this.b < r1.o() - 1) {
                    R1 r13 = this.a;
                    int n2 = this.b;
                    this.b = n2 + 1;
                    return r13.b(n2).spliterator();
                }
                this.a = r12 = this.a.b(this.b);
                if (r12.o() == 0) {
                    Spliterator spliterator2;
                    this.c = spliterator2 = this.a.spliterator();
                    return spliterator2.trySplit();
                }
                this.b = 0;
                R1 r14 = this.a;
                this.b = 1;
                return r14.b(0).spliterator();
            }
            return null;
        }
    }

    private static abstract class u<T, T_NODE extends R1<T>, K extends u<T, T_NODE, K>>
    extends CountedCompleter<Void> {
        protected final R1 a;
        protected final int b;

        u(R1 r1, int n2) {
            this.a = r1;
            this.b = n2;
        }

        u(u u2, R1 r1, int n2) {
            super((CountedCompleter)u2);
            this.a = r1;
            this.b = n2;
        }

        abstract void a();

        abstract u b(int var1, int var2);

        public void compute() {
            u u2 = this;
            do {
                int n2;
                if (u2.a.o() == 0) {
                    u2.a();
                    u2.propagateCompletion();
                    return;
                }
                u2.setPendingCount(-1 + u2.a.o());
                int n3 = 0;
                for (n2 = 0; n2 < -1 + u2.a.o(); ++n2) {
                    u u3 = u2.b(n2, n3 + u2.b);
                    n3 = (int)((long)n3 + u3.a.count());
                    u3.fork();
                }
                u2 = u2.b(n2, n3 + u2.b);
            } while (true);
        }

        private static class d<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>, T_NODE extends R1.e<T, T_CONS, T_ARR, T_SPLITR, T_NODE>>
        extends u<T, T_NODE, d<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> {
            private final Object c;

            d(R1.e e2, Object object, int n2, j$.util.stream.S1$a a2) {
                super(e2, n2);
                this.c = object;
            }

            private d(d d2, R1.e e2, int n2) {
                super(d2, e2, n2);
                this.c = d2.c;
            }

            @Override
            void a() {
                ((R1.e)this.a).d(this.c, this.b);
            }

            @Override
            u b(int n2, int n3) {
                return new d<T, T_CONS, T_ARR, T_SPLITR, T_NODE>(this, ((R1.e)this.a).b(n2), n3);
            }
        }

        private static final class e<T>
        extends u<T, R1<T>, e<T>> {
            private final Object[] c;

            e(R1 r1, Object[] arrobject, int n2, j$.util.stream.S1$a a2) {
                super(r1, n2);
                this.c = arrobject;
            }

            private e(e e2, R1 r1, int n2) {
                super(e2, r1, n2);
                this.c = e2.c;
            }

            @Override
            void a() {
                this.a.j(this.c, this.b);
            }

            @Override
            u b(int n2, int n3) {
                return new e<T>(this, this.a.b(n2), n3);
            }
        }

    }

}

