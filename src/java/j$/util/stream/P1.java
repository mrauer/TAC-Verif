/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.Objects
 */
package j$.util.stream;

import j$.F;
import j$.H;
import j$.L;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BinaryOperator;
import j$.util.function.K;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.y;
import j$.util.l;
import j$.util.s;
import j$.util.stream.A2;
import j$.util.stream.B2;
import j$.util.stream.C1;
import j$.util.stream.D;
import j$.util.stream.D1;
import j$.util.stream.H0;
import j$.util.stream.H1;
import j$.util.stream.J2;
import j$.util.stream.M;
import j$.util.stream.N1;
import j$.util.stream.O0;
import j$.util.stream.Q1;
import j$.util.stream.R1;
import j$.util.stream.S0;
import j$.util.stream.S1;
import j$.util.stream.Stream;
import j$.util.stream.T1;
import j$.util.stream.T2;
import j$.util.stream.U0;
import j$.util.stream.U2;
import j$.util.stream.W1;
import j$.util.stream.X;
import j$.util.stream.X0;
import j$.util.stream.Y1;
import j$.util.stream.Z2;
import j$.util.stream.a2;
import j$.util.stream.g3;
import j$.util.stream.h1;
import j$.util.stream.i3;
import j$.util.stream.k0;
import j$.util.stream.l1;
import j$.util.stream.n;
import j$.util.stream.n1;
import j$.util.stream.o;
import j$.util.stream.p;
import j$.util.stream.q;
import j$.util.stream.q1;
import j$.util.stream.r;
import j$.util.stream.r1;
import j$.util.stream.s;
import j$.util.stream.s1;
import j$.util.stream.t;
import j$.util.stream.t1;
import j$.util.stream.u;
import j$.util.stream.v;
import j$.util.stream.w;
import j$.util.stream.w1;
import j$.util.stream.x;
import j$.util.stream.y2;
import java.util.Iterator;
import java.util.Objects;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
abstract class p1<E_IN>
extends h1<E_IN, Double, s1>
implements s1 {
    p1(Spliterator spliterator, int n3, boolean bl) {
        super(spliterator, n3, bl);
    }

    p1(h1 h12, int n3) {
        super(h12, n3);
    }

    private static Spliterator.a J0(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.a) {
            return (Spliterator.a)spliterator;
        }
        if (i3.a) {
            i3.a(h1.class, "using DoubleStream.adapt(Spliterator<Double> s)");
            throw null;
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    @Override
    public final j$.util.o B(j$.util.function.q q3) {
        Objects.requireNonNull((Object)q3);
        return (j$.util.o)this.u0(new Y1(U2.DOUBLE_VALUE, q3));
    }

    @Override
    public final Object C(K k3, j$.util.function.H h4, BiConsumer biConsumer) {
        w w3 = new w(biConsumer);
        Objects.requireNonNull((Object)k3);
        Objects.requireNonNull((Object)h4);
        return this.u0(new a2(U2.DOUBLE_VALUE, w3, h4, k3));
    }

    @Override
    public final double F(double d4, j$.util.function.q q3) {
        Objects.requireNonNull((Object)q3);
        return (Double)this.u0(new W1(U2.DOUBLE_VALUE, q3, d4));
    }

    @Override
    public final s1 G(final j$.util.function.v v2) {
        Objects.requireNonNull((Object)v2);
        i<Double> i4 = new i<Double>(this, (h1)this, U2.DOUBLE_VALUE, T2.k | T2.i){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.a<Double>(a22){

                    @Override
                    public void accept(double d4) {
                        this.a.accept(((L)v2).a(d4));
                    }
                };
            }

        };
        return i4;
    }

    @Override
    public final Stream H(final j$.util.function.s s3) {
        Objects.requireNonNull((Object)s3);
        y2.m m3 = new y2.m<Double, U>(this, this, U2.DOUBLE_VALUE, T2.k | T2.i){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.a<U>(a22){

                    @Override
                    public void accept(double d4) {
                        this.a.accept(s3.apply(d4));
                    }
                };
            }

        };
        return m3;
    }

    @Override
    final Spliterator H0(T1 t1, K k3, boolean bl) {
        return new Z2(t1, k3, bl);
    }

    @Override
    public final boolean I(j$.util.function.t t3) {
        return (Boolean)this.u0(Q1.r(t3, N1.NONE));
    }

    @Override
    public final boolean N(j$.util.function.t t3) {
        return (Boolean)this.u0(Q1.r(t3, N1.ALL));
    }

    @Override
    public final boolean V(j$.util.function.t t3) {
        return (Boolean)this.u0(Q1.r(t3, N1.ANY));
    }

    @Override
    public final j$.util.o average() {
        double[] arrd = (double[])this.C(x.a, t.a, v.a);
        if (arrd[2] > 0.0) {
            return j$.util.o.d(n1.a(arrd) / arrd[2]);
        }
        return j$.util.o.a();
    }

    @Override
    public final Stream boxed() {
        return this.H(O0.a);
    }

    @Override
    public final long count() {
        return ((D1)this.u(s.a)).sum();
    }

    @Override
    public final s1 d(final j$.util.function.r r3) {
        Objects.requireNonNull((Object)r3);
        i<Double> i4 = new i<Double>(this, (h1)this, U2.DOUBLE_VALUE, 0){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.a<Double>(a22){

                    @Override
                    public void accept(double d4) {
                        r3.accept(d4);
                        this.a.accept(d4);
                    }
                };
            }

        };
        return i4;
    }

    @Override
    public final s1 distinct() {
        return ((y2)this.H(O0.a)).distinct().g0(n.a);
    }

    @Override
    public final j$.util.o findAny() {
        t1 t12 = new t1(false, U2.DOUBLE_VALUE, j$.util.o.a(), S0.a, U0.a);
        return (j$.util.o)this.u0(t12);
    }

    @Override
    public final j$.util.o findFirst() {
        t1 t12 = new t1(true, U2.DOUBLE_VALUE, j$.util.o.a(), S0.a, U0.a);
        return (j$.util.o)this.u0(t12);
    }

    @Override
    public final s.a iterator() {
        return j$.util.u.f(this.spliterator());
    }

    @Override
    public Iterator iterator() {
        return j$.util.u.f(this.spliterator());
    }

    @Override
    public void j0(j$.util.function.r r3) {
        Objects.requireNonNull((Object)r3);
        this.u0(new w1.a(r3, true));
    }

    @Override
    public void l(j$.util.function.r r3) {
        Objects.requireNonNull((Object)r3);
        this.u0(new w1.a(r3, false));
    }

    @Override
    public final s1 limit(long l3) {
        if (l3 >= 0L) {
            return B2.f(this, 0L, l3);
        }
        throw new IllegalArgumentException(Long.toString((long)l3));
    }

    @Override
    public final j$.util.o max() {
        return this.B(D.a);
    }

    @Override
    public final j$.util.o min() {
        return this.B(X0.a);
    }

    @Override
    public final j.C1 n(H h4) {
        Objects.requireNonNull((Object)h4);
        q1 q12 = new q1(this, this, U2.DOUBLE_VALUE, T2.k | T2.i, h4);
        return q12;
    }

    @Override
    final R1.a q0(long l3, y y3) {
        return S1.j(l3);
    }

    @Override
    public final s1 s(final j$.util.function.t t3) {
        Objects.requireNonNull((Object)t3);
        i<Double> i4 = new i<Double>(this, (h1)this, U2.DOUBLE_VALUE, T2.o){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.a<Double>(a22){

                    @Override
                    public void accept(double d4) {
                        if (((F)t3).b(d4)) {
                            this.a.accept(d4);
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
    public final s1 skip(long l3) {
        long l4 = l3 LCMP 0L;
        if (l4 >= 0) {
            if (l4 == false) {
                return this;
            }
            return B2.f(this, l3, -1L);
        }
        throw new IllegalArgumentException(Long.toString((long)l3));
    }

    @Override
    public final s1 sorted() {
        return new J2(this);
    }

    @Override
    public final Spliterator.a spliterator() {
        return p1.J0(super.spliterator());
    }

    @Override
    public final double sum() {
        return n1.a((double[])this.C(u.a, r.a, p.a));
    }

    @Override
    public final l summaryStatistics() {
        return (l)this.C(H0.a, X.a, k0.a);
    }

    @Override
    public final s1 t(final j$.util.function.s s3) {
        i<Double> i4 = new i<Double>(this, (h1)this, U2.DOUBLE_VALUE, T2.k | T2.i | T2.o){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.a<Double>(a22){

                    @Override
                    public void accept(double d4) {
                        s1 s12 = (s1)s3.apply(d4);
                        if (s12 != null) {
                            try {
                                s12.sequential().l(new o(this));
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
    public final double[] toArray() {
        return (double[])S1.m((R1.b)this.v0(q.a)).e();
    }

    @Override
    public final H1 u(final j$.util.function.u u3) {
        Objects.requireNonNull((Object)u3);
        D1.i<Double> i4 = new D1.i<Double>(this, (h1)this, U2.DOUBLE_VALUE, T2.k | T2.i){

            @Override
            A2 E0(int n3, A2 a22) {
                return new A2.a<Long>(a22){

                    @Override
                    public void accept(double d4) {
                        this.a.accept(u3.applyAsLong(d4));
                    }
                };
            }

        };
        return i4;
    }

    @Override
    public l1 unordered() {
        if (!this.z0()) {
            return this;
        }
        return new r1(this, this, U2.DOUBLE_VALUE, T2.m);
    }

    @Override
    final R1 w0(T1 t12, Spliterator spliterator, boolean bl, y y3) {
        return S1.f(t12, spliterator, bl);
    }

    @Override
    final void x0(Spliterator spliterator, A2 a22) {
        block5 : {
            j$.util.function.r r3;
            Spliterator.a a4;
            block4 : {
                block3 : {
                    a4 = p1.J0(spliterator);
                    if (!(a22 instanceof j$.util.function.r)) break block3;
                    r3 = (j$.util.function.r)((Object)a22);
                    break block4;
                }
                if (i3.a) break block5;
                r3 = new M(a22);
            }
            while (!a22.p() && a4.o(r3)) {
            }
            return;
        }
        i3.a(h1.class, "using DoubleStream.adapt(Sink<Double> s)");
        throw null;
    }

    @Override
    final U2 y0() {
        return U2.DOUBLE_VALUE;
    }

    static class g<E_IN>
    extends p1<E_IN> {
        g(Spliterator spliterator, int n3, boolean bl) {
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
        public void j0(j$.util.function.r r3) {
            if (!this.isParallel()) {
                p1.J0(this.G0()).e(r3);
                return;
            }
            Objects.requireNonNull((Object)r3);
            this.u0(new w1.a(r3, true));
        }

        @Override
        public void l(j$.util.function.r r3) {
            if (!this.isParallel()) {
                p1.J0(this.G0()).e(r3);
                return;
            }
            super.l(r3);
        }
    }

    static abstract class h<E_IN>
    extends p1<E_IN> {
        h(h1 h12, U2 u22, int n3) {
            super(h12, n3);
        }

        @Override
        final boolean D0() {
            return true;
        }
    }

    static abstract class i<E_IN>
    extends p1<E_IN> {
        i(h1 h12, U2 u22, int n3) {
            super(h12, n3);
        }

        @Override
        final boolean D0() {
            return false;
        }
    }

}

