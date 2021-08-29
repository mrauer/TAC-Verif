/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.K;
import j$.util.function.p;
import j$.util.stream.A2;
import j$.util.stream.G0;
import j$.util.stream.N0;
import j$.util.stream.S2;
import j$.util.stream.T1;
import j$.util.stream.W2;
import j$.util.stream.g;
import j$.util.stream.j1;
import java.util.Objects;

final class e3<P_IN, P_OUT>
extends W2<P_IN, P_OUT, S2<P_OUT>> {
    e3(T1 t12, Spliterator spliterator, boolean bl) {
        super(t12, spliterator, bl);
    }

    e3(T1 t12, K k3, boolean bl) {
        super(t12, k3, bl);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public boolean b(Consumer consumer) {
        Object object;
        Objects.requireNonNull((Object)consumer);
        boolean bl = this.a();
        if (!bl) {
            return bl;
        }
        S2 s22 = (S2)this.h;
        long l3 = this.g;
        if (s22.c == 0) {
            if (l3 >= (long)s22.b) {
                throw new IndexOutOfBoundsException(Long.toString((long)l3));
            }
            object = s22.e[(int)l3];
        } else {
            if (l3 >= s22.count()) {
                throw new IndexOutOfBoundsException(Long.toString((long)l3));
            }
            int n3 = 0;
            do {
                if (n3 > s22.c) {
                    throw new IndexOutOfBoundsException(Long.toString((long)l3));
                }
                long[] arrl = s22.d;
                long l4 = arrl[n3];
                Object[][] arrobject = s22.f;
                if (l3 < l4 + (long)arrobject[n3].length) {
                    object = arrobject[n3][(int)(l3 - arrl[n3])];
                    break;
                }
                ++n3;
            } while (true);
        }
        consumer.accept(object);
        return bl;
    }

    @Override
    public void forEachRemaining(Consumer consumer) {
        if (this.h == null && !this.i) {
            Objects.requireNonNull((Object)consumer);
            this.g();
            this.b.r0(new N0(consumer), this.d);
            this.i = true;
            return;
        }
        while (this.b(consumer)) {
        }
    }

    @Override
    void i() {
        S2 s22;
        this.h = s22 = new S2();
        this.e = this.b.s0(new g(s22));
        this.f = new G0(this);
    }

    @Override
    W2 k(Spliterator spliterator) {
        return new e3<P_IN, P_OUT>(this.b, spliterator, this.a);
    }
}

