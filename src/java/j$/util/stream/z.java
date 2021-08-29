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

public final class Z
implements BinaryOperator {
    public static final /* synthetic */ Z a;

    static /* synthetic */ {
        a = new Z();
    }

    private /* synthetic */ Z() {
    }

    @Override
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction$-CC.$default$andThen(this, function);
    }

    @Override
    public final Object apply(Object object, Object object2) {
        return new R1.b((R1.b)object, (R1.b)object2){

            public /* synthetic */ void a(java.lang.Double[] arrdouble, int n3) {
                j$.util.stream.Q1.e(this, arrdouble, n3);
            }

            public /* synthetic */ Object c(int n3) {
                return this.f(n3);
            }

            public double[] f(int n3) {
                return new double[n3];
            }

            public /* synthetic */ void forEach(j$.util.function.Consumer consumer) {
                j$.util.stream.Q1.h(this, consumer);
            }

            public /* synthetic */ R1.b g(long l3, long l4, j$.util.function.y y3) {
                return j$.util.stream.Q1.k(this, l3, l4, y3);
            }

            public /* synthetic */ void j(Object[] arrobject, int n3) {
                this.a((java.lang.Double[])arrobject, n3);
            }

            public /* synthetic */ R1 r(long l3, long l4, j$.util.function.y y3) {
                return this.g(l3, l4, y3);
            }

            public j$.util.Spliterator$d spliterator() {
                return new j$.util.Spliterator$a(this){

                    public /* synthetic */ boolean b(j$.util.function.Consumer consumer) {
                        return j$.util.r.d(this, consumer);
                    }

                    public /* synthetic */ void forEachRemaining(j$.util.function.Consumer consumer) {
                        j$.util.r.a(this, consumer);
                    }
                };
            }

            public j$.util.Spliterator spliterator() {
                return new /* invalid duplicate definition of identical inner class */;
            }
        };
    }
}

