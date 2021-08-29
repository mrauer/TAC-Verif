/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.K;
import j$.util.function.y;
import j$.util.stream.A2;
import j$.util.stream.R1;
import j$.util.stream.T1;
import j$.util.stream.T2;
import j$.util.stream.U2;
import j$.util.stream.f3;
import j$.util.stream.g3;
import j$.util.stream.j;
import j$.util.stream.k;
import j$.util.stream.l;
import j$.util.stream.l1;
import java.util.Objects;

abstract class h1<E_IN, E_OUT, S extends l1<E_OUT, S>>
extends T1<E_OUT>
implements l1<E_OUT, S> {
    private final h1 a;
    private final h1 b;
    protected final int c;
    private h1 d;
    private int e;
    private int f;
    private Spliterator g;
    private boolean h;
    private boolean i;
    private Runnable j;
    private boolean k;

    h1(Spliterator spliterator, int n2, boolean bl) {
        int n3;
        this.b = null;
        this.g = spliterator;
        this.a = this;
        this.c = n3 = n2 & T2.b;
        this.f = n3 << 1 & T2.g;
        this.e = 0;
        this.k = bl;
    }

    h1(h1 h12, int n2) {
        if (!h12.h) {
            h1 h13;
            h12.h = true;
            h12.d = this;
            this.b = h12;
            this.c = n2 & T2.c;
            this.f = T2.e(n2, h12.f);
            this.a = h13 = h12.a;
            if (this.D0()) {
                h13.i = true;
            }
            this.e = 1 + h12.e;
            return;
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    private Spliterator F0(int n2) {
        h1 h12 = this.a;
        Spliterator spliterator = h12.g;
        if (spliterator != null) {
            h12.g = null;
            if (h12.k && h12.i) {
                h1 h13 = h12.d;
                int n3 = 1;
                while (h12 != this) {
                    int n4 = h13.c;
                    if (h13.D0()) {
                        int n5;
                        int n6;
                        n3 = 0;
                        if (T2.SHORT_CIRCUIT.t(n4)) {
                            n4 &= T2.p;
                        }
                        if ((spliterator = h13.C0(h12, spliterator)).hasCharacteristics(64)) {
                            n5 = n4 & T2.o;
                            n6 = T2.n;
                        } else {
                            n5 = n4 & T2.n;
                            n6 = T2.o;
                        }
                        n4 = n5 | n6;
                    }
                    int n7 = n3 + 1;
                    h13.e = n3;
                    h13.f = T2.e(n4, h12.f);
                    h1 h14 = h13.d;
                    n3 = n7;
                    h1 h15 = h13;
                    h13 = h14;
                    h12 = h15;
                }
            }
            if (n2 != 0) {
                this.f = T2.e(n2, this.f);
            }
            return spliterator;
        }
        throw new IllegalStateException("source already consumed or closed");
    }

    public /* synthetic */ Spliterator A0() {
        return this.F0(0);
    }

    R1 B0(T1 t12, Spliterator spliterator, y y2) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    Spliterator C0(T1 t12, Spliterator spliterator) {
        return this.B0(t12, spliterator, j.a).spliterator();
    }

    abstract boolean D0();

    abstract A2 E0(int var1, A2 var2);

    final Spliterator G0() {
        h1 h12 = this.a;
        if (this == h12) {
            if (!this.h) {
                this.h = true;
                Spliterator spliterator = h12.g;
                if (spliterator != null) {
                    h12.g = null;
                    return spliterator;
                }
                throw new IllegalStateException("source already consumed or closed");
            }
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        throw new IllegalStateException();
    }

    abstract Spliterator H0(T1 var1, K var2, boolean var3);

    @Override
    public void close() {
        this.h = true;
        this.g = null;
        h1 h12 = this.a;
        Runnable runnable = h12.j;
        if (runnable != null) {
            h12.j = null;
            runnable.run();
        }
    }

    @Override
    public final boolean isParallel() {
        return this.a.k;
    }

    @Override
    final void k0(A2 a2, Spliterator spliterator) {
        Objects.requireNonNull((Object)a2);
        if (!T2.SHORT_CIRCUIT.t(this.f)) {
            a2.n(spliterator.getExactSizeIfKnown());
            spliterator.forEachRemaining(a2);
            a2.m();
            return;
        }
        this.l0(a2, spliterator);
    }

    @Override
    final void l0(A2 a2, Spliterator spliterator) {
        h1 h12 = this;
        while (h12.e > 0) {
            h12 = h12.b;
        }
        a2.n(spliterator.getExactSizeIfKnown());
        h12.x0(spliterator, a2);
        a2.m();
    }

    @Override
    final R1 m0(Spliterator spliterator, boolean bl, y y2) {
        if (this.a.k) {
            return this.w0(this, spliterator, bl, y2);
        }
        R1.a a2 = this.q0(this.n0(spliterator), y2);
        Objects.requireNonNull((Object)a2);
        this.k0(this.s0(a2), spliterator);
        return a2.a();
    }

    @Override
    final long n0(Spliterator spliterator) {
        if (T2.SIZED.t(this.f)) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1L;
    }

    @Override
    final U2 o0() {
        h1 h12 = this;
        while (h12.e > 0) {
            h12 = h12.b;
        }
        return h12.y0();
    }

    @Override
    public l1 onClose(Runnable runnable) {
        h1 h12 = this.a;
        Runnable runnable2 = h12.j;
        if (runnable2 != null) {
            runnable = new f3(runnable2, runnable);
        }
        h12.j = runnable;
        return this;
    }

    @Override
    final int p0() {
        return this.f;
    }

    @Override
    public final l1 parallel() {
        this.a.k = true;
        return this;
    }

    @Override
    final A2 r0(A2 a2, Spliterator spliterator) {
        Objects.requireNonNull((Object)a2);
        this.k0(this.s0(a2), spliterator);
        return a2;
    }

    @Override
    final A2 s0(A2 a2) {
        Objects.requireNonNull((Object)a2);
        h1 h12 = this;
        while (h12.e > 0) {
            a2 = h12.E0(h12.b.f, a2);
            h12 = h12.b;
        }
        return a2;
    }

    @Override
    public final l1 sequential() {
        this.a.k = false;
        return this;
    }

    @Override
    public Spliterator spliterator() {
        if (!this.h) {
            this.h = true;
            h1 h12 = this.a;
            if (this == h12) {
                Spliterator spliterator = h12.g;
                if (spliterator != null) {
                    h12.g = null;
                    return spliterator;
                }
                throw new IllegalStateException("source already consumed or closed");
            }
            return this.H0(this, new k(this), h12.k);
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    @Override
    final Spliterator t0(Spliterator spliterator) {
        if (this.e == 0) {
            return spliterator;
        }
        return this.H0(this, new l(spliterator), this.a.k);
    }

    final Object u0(g3 g32) {
        if (!this.h) {
            this.h = true;
            if (this.a.k) {
                return g32.c(this, this.F0(g32.b()));
            }
            return g32.d(this, this.F0(g32.b()));
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    final R1 v0(y y2) {
        if (!this.h) {
            this.h = true;
            if (this.a.k && this.b != null && this.D0()) {
                this.e = 0;
                h1 h12 = this.b;
                return this.B0(h12, h12.F0(0), y2);
            }
            return this.m0(this.F0(0), true, y2);
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    abstract R1 w0(T1 var1, Spliterator var2, boolean var3, y var4);

    abstract void x0(Spliterator var1, A2 var2);

    abstract U2 y0();

    final boolean z0() {
        return T2.ORDERED.t(this.f);
    }
}

