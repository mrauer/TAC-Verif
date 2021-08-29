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

public final class f
implements BinaryOperator {
    public static final /* synthetic */ f a;

    static /* synthetic */ {
        a = new f();
    }

    private /* synthetic */ f() {
    }

    @Override
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction$-CC.$default$andThen(this, function);
    }

    @Override
    public final Object apply(Object object, Object object2) {
        return new R1.c((R1.c)object, (R1.c)object2){

            public /* synthetic */ void a(java.lang.Integer[] arrinteger, int n3) {
                j$.util.stream.Q1.f(this, arrinteger, n3);
            }

            public /* synthetic */ Object c(int n3) {
                return this.f(n3);
            }

            public int[] f(int n3) {
                return new int[n3];
            }

            public /* synthetic */ void forEach(j$.util.function.Consumer consumer) {
                j$.util.stream.Q1.i(this, consumer);
            }

            public /* synthetic */ R1.c g(long l3, long l4, j$.util.function.y y3) {
                return j$.util.stream.Q1.l(this, l3, l4, y3);
            }

            public /* synthetic */ void j(Object[] arrobject, int n3) {
                this.a((java.lang.Integer[])arrobject, n3);
            }

            public /* synthetic */ R1 r(long l3, long l4, j$.util.function.y y3) {
                return this.g(l3, l4, y3);
            }

            public j$.util.Spliterator$d spliterator() {
                return new j$.util.Spliterator$b(this){

                    public /* synthetic */ boolean b(j$.util.function.Consumer consumer) {
                        return j$.util.r.e(this, consumer);
                    }

                    public /* synthetic */ void forEachRemaining(j$.util.function.Consumer consumer) {
                        j$.util.r.b(this, consumer);
                    }
                };
            }

            public j$.util.Spliterator spliterator() {
                return new /* invalid duplicate definition of identical inner class */;
            }
        };
    }
}

