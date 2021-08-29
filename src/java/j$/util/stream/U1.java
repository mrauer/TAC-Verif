/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.time.e;
import j$.util.Optional;
import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.function.f;
import j$.util.function.i;
import j$.util.function.j;
import j$.util.function.r;
import j$.util.function.x;
import j$.util.o;
import j$.util.p;
import j$.util.q;
import j$.util.stream.A2;
import j$.util.stream.h3;
import java.util.Objects;

abstract class u1<T, O>
implements h3<T, O> {
    boolean a;
    Object b;

    u1() {
    }

    @Override
    public /* synthetic */ void accept(double d4) {
        e.c(this);
        throw null;
    }

    @Override
    public /* synthetic */ void accept(int n3) {
        e.a(this);
        throw null;
    }

    @Override
    public /* synthetic */ void accept(long l3) {
        e.b(this);
        throw null;
    }

    @Override
    public void accept(Object object) {
        if (!this.a) {
            this.a = true;
            this.b = object;
        }
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new j$.util.function.e(this, consumer);
    }

    @Override
    public void m() {
    }

    @Override
    public void n(long l3) {
    }

    @Override
    public boolean p() {
        return this.a;
    }

    static final class a
    extends u1<Double, o>
    implements A2.e {
        a() {
        }

        @Override
        public void accept(double d4) {
            this.accept((Object)d4);
        }

        @Override
        public Object get() {
            if (this.a) {
                return o.d((Double)this.b);
            }
            return null;
        }

        @Override
        public r k(r r3) {
            Objects.requireNonNull((Object)r3);
            return new f(this, r3);
        }
    }

    static final class b
    extends u1<Integer, p>
    implements A2.f {
        b() {
        }

        @Override
        public void accept(int n3) {
            this.accept((Object)n3);
        }

        @Override
        public Object get() {
            if (this.a) {
                return p.d((Integer)this.b);
            }
            return null;
        }

        @Override
        public x l(x x2) {
            Objects.requireNonNull((Object)x2);
            return new i(this, x2);
        }
    }

    static final class c
    extends u1<Long, q>
    implements A2.g {
        c() {
        }

        @Override
        public void accept(long l3) {
            this.accept((Object)l3);
        }

        @Override
        public D g(D d4) {
            Objects.requireNonNull((Object)d4);
            return new j(this, d4);
        }

        @Override
        public Object get() {
            if (this.a) {
                return q.d((Long)this.b);
            }
            return null;
        }
    }

    static final class d<T>
    extends u1<T, Optional<T>> {
        d() {
        }

        @Override
        public Object get() {
            if (this.a) {
                return Optional.d(this.b);
            }
            return null;
        }
    }

}

