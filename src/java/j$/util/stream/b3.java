/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.function.K;
import j$.util.function.p;
import j$.util.r;
import j$.util.stream.A0;
import j$.util.stream.A2;
import j$.util.stream.S2;
import j$.util.stream.T1;
import j$.util.stream.V0;
import j$.util.stream.W2;
import j$.util.stream.j1;
import j$.util.stream.n0;
import java.util.Objects;

final class b3<P_IN>
extends W2<P_IN, Long, S2.d>
implements Spliterator.c {
    b3(T1 t12, Spliterator spliterator, boolean bl) {
        super(t12, spliterator, bl);
    }

    b3(T1 t12, K k3, boolean bl) {
        super(t12, k3, bl);
    }

    @Override
    public /* synthetic */ boolean b(Consumer consumer) {
        return r.f(this, consumer);
    }

    @Override
    public void d(D d4) {
        if (this.h == null && !this.i) {
            Objects.requireNonNull((Object)d4);
            this.g();
            this.b.r0(new V0(d4), this.d);
            this.i = true;
            return;
        }
        while (this.j(d4)) {
        }
    }

    @Override
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        r.c(this, consumer);
    }

    @Override
    void i() {
        D d4 = new D(){

            public Spliterator.c B() {
                j$.util.stream.S2$d$a a4 = new j$.util.stream.S2$d$a(this, 0, this.c, 0, this.b);
                return a4;
            }

            public void accept(long l3) {
                this.A();
                long[] arrl = (long[])this.e;
                int n3 = this.b;
                this.b = n3 + 1;
                arrl[n3] = l3;
            }

            public Object c(int n3) {
                return new long[n3];
            }

            public void forEach(Consumer consumer) {
                if (consumer instanceof D) {
                    this.h((D)((Object)consumer));
                    return;
                }
                if (!j$.util.stream.i3.a) {
                    this.B().forEachRemaining(consumer);
                    return;
                }
                j$.util.stream.i3.a(this.getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
                throw null;
            }

            public D g(D d4) {
                Objects.requireNonNull((Object)d4);
                return new j$.util.function.j(this, d4);
            }

            public java.util.Iterator iterator() {
                return j$.util.u.h(this.B());
            }

            protected void t(Object object, int n3, int n4, Object object2) {
                long[] arrl = (long[])object;
                D d4 = (D)object2;
                while (n3 < n4) {
                    d4.accept(arrl[n3]);
                    ++n3;
                }
            }

            public java.lang.String toString() {
                long[] arrl = (long[])this.e();
                if (arrl.length < 200) {
                    Object[] arrobject = new Object[]{this.getClass().getSimpleName(), arrl.length, this.c, java.util.Arrays.toString((long[])arrl)};
                    return java.lang.String.format((java.lang.String)"%s[length=%d, chunks=%d]%s", (Object[])arrobject);
                }
                long[] arrl2 = java.util.Arrays.copyOf((long[])arrl, (int)200);
                Object[] arrobject = new Object[]{this.getClass().getSimpleName(), arrl.length, this.c, java.util.Arrays.toString((long[])arrl2)};
                return java.lang.String.format((java.lang.String)"%s[length=%d, chunks=%d]%s...", (Object[])arrobject);
            }

            protected int u(Object object) {
                return ((long[])object).length;
            }

            protected Object[] z(int n3) {
                return new long[n3][];
            }
        };
        this.h = d4;
        this.e = this.b.s0(new n0(d4));
        this.f = new A0(this);
    }

    @Override
    public boolean j(D d4) {
        Objects.requireNonNull((Object)d4);
        boolean bl = this.a();
        if (bl) {
            S2.d d5 = this.h;
            long l3 = this.g;
            int n3 = d5.w(l3);
            long l4 = d5.c == 0 && n3 == 0 ? ((long[])d5.e)[(int)l3] : ((long[][])d5.f)[n3][(int)(l3 - d5.d[n3])];
            d4.accept(l4);
        }
        return bl;
    }

    @Override
    W2 k(Spliterator spliterator) {
        return new b3<P_IN>(this.b, spliterator, this.a);
    }

    @Override
    public Spliterator.c trySplit() {
        return (Spliterator.c)super.trySplit();
    }
}

