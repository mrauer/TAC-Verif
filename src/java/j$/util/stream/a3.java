/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.K;
import j$.util.function.p;
import j$.util.function.x;
import j$.util.r;
import j$.util.stream.A2;
import j$.util.stream.L0;
import j$.util.stream.S2;
import j$.util.stream.T1;
import j$.util.stream.W2;
import j$.util.stream.e;
import j$.util.stream.j1;
import j$.util.stream.z0;
import java.util.Objects;

final class a3<P_IN>
extends W2<P_IN, Integer, S2.c>
implements Spliterator.b {
    a3(T1 t12, Spliterator spliterator, boolean bl) {
        super(t12, spliterator, bl);
    }

    a3(T1 t12, K k3, boolean bl) {
        super(t12, k3, bl);
    }

    @Override
    public /* synthetic */ boolean b(Consumer consumer) {
        return r.e(this, consumer);
    }

    @Override
    public void c(x x2) {
        if (this.h == null && !this.i) {
            Objects.requireNonNull((Object)x2);
            this.g();
            this.b.r0(new e(x2), this.d);
            this.i = true;
            return;
        }
        while (this.h(x2)) {
        }
    }

    @Override
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        r.b(this, consumer);
    }

    @Override
    public boolean h(x x2) {
        Objects.requireNonNull((Object)x2);
        boolean bl = this.a();
        if (bl) {
            S2.c c4 = this.h;
            long l3 = this.g;
            int n3 = c4.w(l3);
            int n4 = c4.c == 0 && n3 == 0 ? ((int[])c4.e)[(int)l3] : ((int[][])c4.f)[n3][(int)(l3 - c4.d[n3])];
            x2.accept(n4);
        }
        return bl;
    }

    @Override
    void i() {
        x x2 = new x(){

            public Spliterator.b B() {
                j$.util.stream.S2$c$a a4 = new j$.util.stream.S2$c$a(this, 0, this.c, 0, this.b);
                return a4;
            }

            public void accept(int n3) {
                this.A();
                int[] arrn = (int[])this.e;
                int n4 = this.b;
                this.b = n4 + 1;
                arrn[n4] = n3;
            }

            public Object c(int n3) {
                return new int[n3];
            }

            public void forEach(Consumer consumer) {
                if (consumer instanceof x) {
                    this.h((x)((Object)consumer));
                    return;
                }
                if (!j$.util.stream.i3.a) {
                    this.B().forEachRemaining(consumer);
                    return;
                }
                j$.util.stream.i3.a(this.getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
                throw null;
            }

            public java.util.Iterator iterator() {
                return j$.util.u.g(this.B());
            }

            public x l(x x2) {
                Objects.requireNonNull((Object)x2);
                return new j$.util.function.i(this, x2);
            }

            protected void t(Object object, int n3, int n4, Object object2) {
                int[] arrn = (int[])object;
                x x2 = (x)object2;
                while (n3 < n4) {
                    x2.accept(arrn[n3]);
                    ++n3;
                }
            }

            public java.lang.String toString() {
                int[] arrn = (int[])this.e();
                if (arrn.length < 200) {
                    Object[] arrobject = new Object[]{this.getClass().getSimpleName(), arrn.length, this.c, java.util.Arrays.toString((int[])arrn)};
                    return java.lang.String.format((java.lang.String)"%s[length=%d, chunks=%d]%s", (Object[])arrobject);
                }
                int[] arrn2 = java.util.Arrays.copyOf((int[])arrn, (int)200);
                Object[] arrobject = new Object[]{this.getClass().getSimpleName(), arrn.length, this.c, java.util.Arrays.toString((int[])arrn2)};
                return java.lang.String.format((java.lang.String)"%s[length=%d, chunks=%d]%s...", (Object[])arrobject);
            }

            protected int u(Object object) {
                return ((int[])object).length;
            }

            protected Object[] z(int n3) {
                return new int[n3][];
            }
        };
        this.h = x2;
        this.e = this.b.s0(new L0(x2));
        this.f = new z0(this);
    }

    @Override
    W2 k(Spliterator spliterator) {
        return new a3<P_IN>(this.b, spliterator, this.a);
    }

    @Override
    public Spliterator.b trySplit() {
        return (Spliterator.b)super.trySplit();
    }
}

