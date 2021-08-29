/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.Objects
 *  java.util.Set
 */
package j$.util.stream;

import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.function.Function;
import j$.util.function.K;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.function.r;
import j$.util.function.x;
import j$.util.function.y;
import j$.util.stream.A2;
import j$.util.stream.B2;
import j$.util.stream.C1;
import j$.util.stream.D1;
import j$.util.stream.H1;
import j$.util.stream.K0;
import j$.util.stream.M;
import j$.util.stream.M2;
import j$.util.stream.N1;
import j$.util.stream.Q1;
import j$.util.stream.R1;
import j$.util.stream.S1;
import j$.util.stream.Stream;
import j$.util.stream.T1;
import j$.util.stream.T2;
import j$.util.stream.U2;
import j$.util.stream.W0;
import j$.util.stream.c2;
import j$.util.stream.e2;
import j$.util.stream.e3;
import j$.util.stream.g1;
import j$.util.stream.g2;
import j$.util.stream.g3;
import j$.util.stream.h1;
import j$.util.stream.i2;
import j$.util.stream.l1;
import j$.util.stream.m1;
import j$.util.stream.o1;
import j$.util.stream.p0;
import j$.util.stream.p1;
import j$.util.stream.q0;
import j$.util.stream.r0;
import j$.util.stream.s1;
import j$.util.stream.t1;
import j$.util.stream.w1;
import j$.util.stream.z1;
import j$.util.stream.z2;
import j$.util.u;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

abstract class y2<P_IN, P_OUT>
extends h1<P_IN, P_OUT, Stream<P_OUT>>
implements Stream<P_OUT> {
    y2(Spliterator spliterator, int n3, boolean bl) {
        super(spliterator, n3, bl);
    }

    y2(h1 h12, int n3) {
        super(h12, n3);
    }

    @Override
    public final s1 A(final Function function) {
        Objects.requireNonNull((Object)function);
        p1.i i4 = new p1.i<P_OUT>(this, this, U2.REFERENCE, T2.k | T2.i | T2.o){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.d<P_OUT, Double>(a22){
                    r b;
                    {
                        A2 a23 = this.a;
                        Objects.requireNonNull((Object)a23);
                        this.b = new M(a23);
                    }

                    @Override
                    public void accept(Object object) {
                        s1 s12 = (s1)function.apply(object);
                        if (s12 != null) {
                            try {
                                s12.sequential().l(this.b);
                            }
                            catch (Throwable throwable) {
                                try {
                                    s12.close();
                                }
                                catch (Throwable throwable2) {
                                    throwable.addSuppressed(throwable2);
                                }
                                throw throwable;
                            }
                        }
                        if (s12 != null) {
                            s12.close();
                        }
                    }

                    @Override
                    public void n(long l3) {
                        this.a.n(-1L);
                    }
                };
            }

        };
        return i4;
    }

    @Override
    final Spliterator H0(T1 t12, K k3, boolean bl) {
        return new e3(t12, k3, bl);
    }

    @Override
    public final Stream O(final Predicate predicate) {
        Objects.requireNonNull((Object)predicate);
        m m3 = new m<P_OUT, P_OUT>(this, this, U2.REFERENCE, T2.o){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.d<P_OUT, P_OUT>(a22){

                    @Override
                    public void accept(Object object) {
                        if (predicate.test(object)) {
                            this.a.accept(object);
                        }
                    }

                    @Override
                    public void n(long l3) {
                        this.a.n(-1L);
                    }
                };
            }

        };
        return m3;
    }

    @Override
    public final Stream R(final Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        m m3 = new m<P_OUT, P_OUT>(this, this, U2.REFERENCE, 0){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.d<P_OUT, P_OUT>(a22){

                    @Override
                    public void accept(Object object) {
                        consumer.accept(object);
                        this.a.accept(object);
                    }
                };
            }

        };
        return m3;
    }

    @Override
    public final Object S(m1 m12) {
        Object object;
        if (this.isParallel() && m12.characteristics().contains((Object)m1.a.CONCURRENT) && (!this.z0() || m12.characteristics().contains((Object)m1.a.UNORDERED))) {
            object = m12.supplier().get();
            this.forEach(new r0(m12.accumulator(), object));
        } else {
            Objects.requireNonNull((Object)m12);
            K k3 = m12.supplier();
            BiConsumer biConsumer = m12.accumulator();
            BinaryOperator binaryOperator = m12.combiner();
            g2 g22 = new g2(U2.REFERENCE, binaryOperator, biConsumer, k3, m12);
            object = this.u0(g22);
        }
        if (m12.characteristics().contains((Object)m1.a.IDENTITY_FINISH)) {
            return object;
        }
        return m12.finisher().apply(object);
    }

    @Override
    public final boolean T(Predicate predicate) {
        return (Boolean)this.u0(Q1.u(predicate, N1.ALL));
    }

    @Override
    public final H1 U(final Function function) {
        Objects.requireNonNull((Object)function);
        D1.i i4 = new D1.i<P_OUT>(this, this, U2.REFERENCE, T2.k | T2.i | T2.o){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.d<P_OUT, Long>(a22){
                    D b;
                    {
                        A2 a23 = this.a;
                        Objects.requireNonNull((Object)a23);
                        this.b = new K0(a23);
                    }

                    @Override
                    public void accept(Object object) {
                        H1 h12 = (H1)function.apply(object);
                        if (h12 != null) {
                            try {
                                h12.sequential().f(this.b);
                            }
                            catch (Throwable throwable) {
                                try {
                                    h12.close();
                                }
                                catch (Throwable throwable2) {
                                    throwable.addSuppressed(throwable2);
                                }
                                throw throwable;
                            }
                        }
                        if (h12 != null) {
                            h12.close();
                        }
                    }

                    @Override
                    public void n(long l3) {
                        this.a.n(-1L);
                    }
                };
            }

        };
        return i4;
    }

    @Override
    public final boolean a(Predicate predicate) {
        return (Boolean)this.u0(Q1.u(predicate, N1.ANY));
    }

    @Override
    public final boolean b0(Predicate predicate) {
        return (Boolean)this.u0(Q1.u(predicate, N1.NONE));
    }

    @Override
    public final long count() {
        return ((D1)this.d0(p0.a)).sum();
    }

    @Override
    public final H1 d0(final ToLongFunction toLongFunction) {
        Objects.requireNonNull((Object)toLongFunction);
        D1.i i4 = new D1.i<P_OUT>(this, this, U2.REFERENCE, T2.k | T2.i){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.d<P_OUT, Long>(a22){

                    @Override
                    public void accept(Object object) {
                        this.a.accept(toLongFunction.applyAsLong(object));
                    }
                };
            }

        };
        return i4;
    }

    @Override
    public final Stream distinct() {
        return new o1(this, U2.REFERENCE, T2.h | T2.o);
    }

    @Override
    public final C1 e(final Function function) {
        Objects.requireNonNull((Object)function);
        z1.k k3 = new z1.k<P_OUT>(this, this, U2.REFERENCE, T2.k | T2.i | T2.o){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.d<P_OUT, Integer>(a22){
                    x b;
                    {
                        A2 a23 = this.a;
                        Objects.requireNonNull((Object)a23);
                        this.b = new j$.util.stream.c(a23);
                    }

                    @Override
                    public void accept(Object object) {
                        C1 c1 = (C1)function.apply(object);
                        if (c1 != null) {
                            try {
                                c1.sequential().P(this.b);
                            }
                            catch (Throwable throwable) {
                                try {
                                    c1.close();
                                }
                                catch (Throwable throwable2) {
                                    throwable.addSuppressed(throwable2);
                                }
                                throw throwable;
                            }
                        }
                        if (c1 != null) {
                            c1.close();
                        }
                    }

                    @Override
                    public void n(long l3) {
                        this.a.n(-1L);
                    }
                };
            }

        };
        return k3;
    }

    @Override
    public final Optional findAny() {
        t1 t12 = new t1(false, U2.REFERENCE, Optional.a(), g1.a, W0.a);
        return (Optional)this.u0(t12);
    }

    @Override
    public final Optional findFirst() {
        t1 t12 = new t1(true, U2.REFERENCE, Optional.a(), g1.a, W0.a);
        return (Optional)this.u0(t12);
    }

    @Override
    public void forEach(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        this.u0(new w1.d(consumer, false));
    }

    @Override
    public void g(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        this.u0(new w1.d(consumer, true));
    }

    @Override
    public final s1 g0(final ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull((Object)toDoubleFunction);
        p1.i i4 = new p1.i<P_OUT>(this, this, U2.REFERENCE, T2.k | T2.i){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.d<P_OUT, Double>(a22){

                    @Override
                    public void accept(Object object) {
                        this.a.accept(toDoubleFunction.applyAsDouble(object));
                    }
                };
            }

        };
        return i4;
    }

    @Override
    public final Iterator iterator() {
        return u.i(this.spliterator());
    }

    @Override
    public final Object k(K k3, BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull((Object)k3);
        Objects.requireNonNull((Object)biConsumer);
        Objects.requireNonNull((Object)biConsumer2);
        return this.u0(new i2(U2.REFERENCE, biConsumer2, biConsumer, k3));
    }

    @Override
    public final Stream limit(long l3) {
        if (l3 >= 0L) {
            return B2.i(this, 0L, l3);
        }
        throw new IllegalArgumentException(Long.toString((long)l3));
    }

    @Override
    public final C1 m(final ToIntFunction toIntFunction) {
        Objects.requireNonNull((Object)toIntFunction);
        z1.k k3 = new z1.k<P_OUT>(this, this, U2.REFERENCE, T2.k | T2.i){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.d<P_OUT, Integer>(a22){

                    @Override
                    public void accept(Object object) {
                        this.a.accept(toIntFunction.applyAsInt(object));
                    }
                };
            }

        };
        return k3;
    }

    @Override
    public final Stream map(final Function function) {
        Objects.requireNonNull((Object)function);
        m m3 = new m<P_OUT, R>(this, this, U2.REFERENCE, T2.k | T2.i){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.d<P_OUT, R>(a22){

                    @Override
                    public void accept(Object object) {
                        this.a.accept(function.apply(object));
                    }
                };
            }

        };
        return m3;
    }

    @Override
    public final Optional max(Comparator comparator) {
        Objects.requireNonNull((Object)comparator);
        return this.r(new j$.util.function.d(comparator));
    }

    @Override
    public final Optional min(Comparator comparator) {
        Objects.requireNonNull((Object)comparator);
        return this.r(new j$.util.function.c(comparator));
    }

    @Override
    public final Stream o(final Function function) {
        Objects.requireNonNull((Object)function);
        m m3 = new m<P_OUT, R>(this, this, U2.REFERENCE, T2.k | T2.i | T2.o){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.d<P_OUT, R>(a22){

                    @Override
                    public void accept(Object object) {
                        Stream stream = (Stream)function.apply(object);
                        if (stream != null) {
                            try {
                                ((Stream)stream.sequential()).forEach(this.a);
                            }
                            catch (Throwable throwable) {
                                try {
                                    stream.close();
                                }
                                catch (Throwable throwable2) {
                                    throwable.addSuppressed(throwable2);
                                }
                                throw throwable;
                            }
                        }
                        if (stream != null) {
                            stream.close();
                        }
                    }

                    @Override
                    public void n(long l3) {
                        this.a.n(-1L);
                    }
                };
            }

        };
        return m3;
    }

    @Override
    final R1.a q0(long l3, y y3) {
        return S1.d(l3, y3);
    }

    @Override
    public final Optional r(BinaryOperator binaryOperator) {
        Objects.requireNonNull((Object)binaryOperator);
        return (Optional)this.u0(new e2(U2.REFERENCE, binaryOperator));
    }

    @Override
    public final Object reduce(Object object, BinaryOperator binaryOperator) {
        Objects.requireNonNull((Object)binaryOperator);
        return this.u0(new c2(U2.REFERENCE, binaryOperator, binaryOperator, object));
    }

    @Override
    public final Stream skip(long l3) {
        long l4 = l3 LCMP 0L;
        if (l4 >= 0) {
            if (l4 == false) {
                return this;
            }
            return B2.i(this, l3, -1L);
        }
        throw new IllegalArgumentException(Long.toString((long)l3));
    }

    @Override
    public final Stream sorted() {
        return new M2(this);
    }

    @Override
    public final Stream sorted(Comparator comparator) {
        return new M2(this, comparator);
    }

    @Override
    public final Object[] toArray() {
        q0 q02 = q0.a;
        return S1.l(this.v0(q02), q02).q(q02);
    }

    @Override
    public final Object[] toArray(y y3) {
        return S1.l(this.v0(y3), y3).q(y3);
    }

    @Override
    public l1 unordered() {
        if (!this.z0()) {
            return this;
        }
        return new z2(this, this, U2.REFERENCE, T2.m);
    }

    @Override
    final R1 w0(T1 t12, Spliterator spliterator, boolean bl, y y3) {
        return S1.e(t12, spliterator, bl, y3);
    }

    @Override
    final void x0(Spliterator spliterator, A2 a22) {
        while (!a22.p() && spliterator.b(a22)) {
        }
    }

    @Override
    public final Object y(Object object, BiFunction biFunction, BinaryOperator binaryOperator) {
        Objects.requireNonNull((Object)biFunction);
        Objects.requireNonNull((Object)binaryOperator);
        return this.u0(new c2(U2.REFERENCE, binaryOperator, biFunction, object));
    }

    @Override
    final U2 y0() {
        return U2.REFERENCE;
    }

    static class k<E_IN, E_OUT>
    extends y2<E_IN, E_OUT> {
        k(Spliterator spliterator, int n3, boolean bl) {
            super(spliterator, n3, bl);
        }

        @Override
        final boolean D0() {
            throw new UnsupportedOperationException();
        }

        @Override
        final A2 E0(int n3, A2 a22) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEach(Consumer consumer) {
            if (!this.isParallel()) {
                this.G0().forEachRemaining(consumer);
                return;
            }
            super.forEach(consumer);
        }

        @Override
        public void g(Consumer consumer) {
            if (!this.isParallel()) {
                this.G0().forEachRemaining(consumer);
                return;
            }
            Objects.requireNonNull((Object)consumer);
            this.u0(new w1.d(consumer, true));
        }
    }

    static abstract class l<E_IN, E_OUT>
    extends y2<E_IN, E_OUT> {
        l(h1 h12, U2 u22, int n3) {
            super(h12, n3);
        }

        @Override
        final boolean D0() {
            return true;
        }
    }

    static abstract class m<E_IN, E_OUT>
    extends y2<E_IN, E_OUT> {
        m(h1 h12, U2 u22, int n3) {
            super(h12, n3);
        }

        @Override
        final boolean D0() {
            return false;
        }
    }

}

