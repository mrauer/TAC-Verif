/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Objects
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.K;
import j$.util.function.y;
import j$.util.stream.A;
import j$.util.stream.A2;
import j$.util.stream.M0;
import j$.util.stream.R1;
import j$.util.stream.S1;
import j$.util.stream.T1;
import j$.util.stream.T2;
import j$.util.stream.U2;
import j$.util.stream.Y2;
import j$.util.stream.h1;
import j$.util.stream.i;
import j$.util.stream.i2;
import j$.util.stream.m;
import j$.util.stream.w1;
import j$.util.stream.y2;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

class o1
extends y2.l<T, T> {
    o1(h1 h12, U2 u22, int n3) {
        super(h12, u22, n3);
    }

    @Override
    R1 B0(T1 t12, Spliterator spliterator, y y3) {
        if (T2.DISTINCT.t(t12.p0())) {
            return t12.m0(spliterator, false, y3);
        }
        if (T2.ORDERED.t(t12.p0())) {
            return this.I0(t12, spliterator);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        new w1.d(new m(atomicBoolean, concurrentHashMap), false).c(t12, spliterator);
        Set set = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet((Collection)set);
            hashSet.add(null);
            set = hashSet;
        }
        return new S1.d((Collection)set);
    }

    @Override
    Spliterator C0(T1 t12, Spliterator spliterator) {
        if (T2.DISTINCT.t(t12.p0())) {
            return t12.t0(spliterator);
        }
        if (T2.ORDERED.t(t12.p0())) {
            return ((S1.d)this.I0(t12, spliterator)).spliterator();
        }
        return new Y2(t12.t0(spliterator));
    }

    @Override
    A2 E0(int n3, A2 a22) {
        Objects.requireNonNull((Object)a22);
        if (T2.DISTINCT.t(n3)) {
            return a22;
        }
        if (T2.SORTED.t(n3)) {
            return new A2.d<T, T>(this, a22){
                boolean b;
                Object c;

                @Override
                public void accept(Object object) {
                    if (object == null) {
                        if (!this.b) {
                            this.b = true;
                            A2 a22 = this.a;
                            this.c = null;
                            a22.accept(null);
                            return;
                        }
                    } else {
                        Object object2 = this.c;
                        if (object2 == null || !object.equals(object2)) {
                            A2 a23 = this.a;
                            this.c = object;
                            a23.accept(object);
                        }
                    }
                }

                @Override
                public void m() {
                    this.b = false;
                    this.c = null;
                    this.a.m();
                }

                @Override
                public void n(long l3) {
                    this.b = false;
                    this.c = null;
                    this.a.n(-1L);
                }
            };
        }
        return new A2.d<T, T>(this, a22){
            Set b;

            @Override
            public void accept(Object object) {
                if (!this.b.contains(object)) {
                    this.b.add(object);
                    this.a.accept(object);
                }
            }

            @Override
            public void m() {
                this.b = null;
                this.a.m();
            }

            @Override
            public void n(long l3) {
                this.b = new HashSet();
                this.a.n(-1L);
            }
        };
    }

    R1 I0(T1 t12, Spliterator spliterator) {
        A a4 = A.a;
        M0 m02 = M0.a;
        i i4 = i.a;
        return new S1.d((Collection)new i2(U2.REFERENCE, i4, m02, a4).c(t12, spliterator));
    }

}

