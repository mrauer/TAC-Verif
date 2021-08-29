/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Void
 *  java.util.Objects
 *  java.util.concurrent.CountedCompleter
 */
package j$.util.stream;

import j$.time.e;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.function.f;
import j$.util.function.i;
import j$.util.function.j;
import j$.util.function.r;
import j$.util.function.x;
import j$.util.stream.A2;
import j$.util.stream.Q1;
import j$.util.stream.T1;
import j$.util.stream.T2;
import j$.util.stream.g3;
import j$.util.stream.h1;
import j$.util.stream.h3;
import j$.util.stream.x1;
import j$.util.stream.y1;
import java.util.Objects;
import java.util.concurrent.CountedCompleter;

abstract class w1<T>
implements g3<T, Void>,
h3<T, Void> {
    private final boolean a;

    protected w1(boolean bl) {
        this.a = bl;
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
    public int b() {
        if (this.a) {
            return 0;
        }
        return T2.m;
    }

    @Override
    public Object c(T1 t12, Spliterator spliterator) {
        CountedCompleter countedCompleter = this.a ? new x1(t12, spliterator, this) : new y1(t12, spliterator, t12.s0(this));
        countedCompleter.invoke();
        return null;
    }

    @Override
    public Object d(T1 t12, Spliterator spliterator) {
        h1 h12 = (h1)t12;
        h12.k0(h12.s0(this), spliterator);
        return null;
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
    public /* synthetic */ boolean p() {
        return false;
    }

    static final class a
    extends w1<Double>
    implements A2.e {
        final r b;

        a(r r3, boolean bl) {
            super(bl);
            this.b = r3;
        }

        @Override
        public void accept(double d4) {
            this.b.accept(d4);
        }

        @Override
        public /* synthetic */ void accept(Object object) {
            this.e((Double)object);
        }

        public /* synthetic */ void e(Double d4) {
            Q1.a(this, d4);
        }

        @Override
        public r k(r r3) {
            Objects.requireNonNull((Object)r3);
            return new f(this, r3);
        }
    }

    static final class b
    extends w1<Integer>
    implements A2.f {
        final x b;

        b(x x2, boolean bl) {
            super(bl);
            this.b = x2;
        }

        @Override
        public void accept(int n3) {
            this.b.accept(n3);
        }

        @Override
        public /* synthetic */ void accept(Object object) {
            this.e((Integer)object);
        }

        public /* synthetic */ void e(Integer n3) {
            Q1.b(this, n3);
        }

        @Override
        public x l(x x2) {
            Objects.requireNonNull((Object)x2);
            return new i(this, x2);
        }
    }

    static final class c
    extends w1<Long>
    implements A2.g {
        final D b;

        c(D d4, boolean bl) {
            super(bl);
            this.b = d4;
        }

        @Override
        public void accept(long l3) {
            this.b.accept(l3);
        }

        @Override
        public /* synthetic */ void accept(Object object) {
            this.e((Long)object);
        }

        public /* synthetic */ void e(Long l3) {
            Q1.c(this, l3);
        }

        @Override
        public D g(D d4) {
            Objects.requireNonNull((Object)d4);
            return new j(this, d4);
        }
    }

    static final class d<T>
    extends w1<T> {
        final Consumer b;

        d(Consumer consumer, boolean bl) {
            super(bl);
            this.b = consumer;
        }

        @Override
        public void accept(Object object) {
            this.b.accept(object);
        }
    }

}

