/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.BiFunction$-CC;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.stream.R1;
import j$.util.stream.S1;

public final class y
implements BinaryOperator {
    public static final /* synthetic */ y a;

    static /* synthetic */ {
        a = new y();
    }

    private /* synthetic */ y() {
    }

    @Override
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction$-CC.$default$andThen(this, function);
    }

    @Override
    public final Object apply(Object object, Object object2) {
        return new R1.d((R1.d)object, (R1.d)object2){

            public /* synthetic */ void a(java.lang.Long[] arrlong, int n3) {
                j$.util.stream.Q1.g(this, arrlong, n3);
            }

            public /* synthetic */ Object c(int n3) {
                return this.f(n3);
            }

            public long[] f(int n3) {
                return new long[n3];
            }

            public /* synthetic */ void forEach(j$.util.function.Consumer consumer) {
                j$.util.stream.Q1.j(this, consumer);
            }

            public /* synthetic */ R1.d g(long l3, long l4, j$.util.function.y y3) {
                return j$.util.stream.Q1.m(this, l3, l4, y3);
            }

            public /* synthetic */ void j(Object[] arrobject, int n3) {
                this.a((java.lang.Long[])arrobject, n3);
            }

            public /* synthetic */ R1 r(long l3, long l4, j$.util.function.y y3) {
                return this.g(l3, l4, y3);
            }

            public j$.util.Spliterator$d spliterator() {
                return new j$.util.Spliterator$c(this){

                    public /* synthetic */ boolean b(j$.util.function.Consumer consumer) {
                        return j$.util.r.f(this, consumer);
                    }

                    public /* synthetic */ void forEachRemaining(j$.util.function.Consumer consumer) {
                        j$.util.r.c(this, consumer);
                    }
                };
            }

            public j$.util.Spliterator spliterator() {
                return new /* invalid duplicate definition of identical inner class */;
            }
        };
    }
}

