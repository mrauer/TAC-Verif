/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.e;
import j$.util.stream.u2;
import j$.util.stream.v2;
import java.util.Objects;

class d2
extends v2<U>
implements u2<T, U, d2> {
    final /* synthetic */ Object b;
    final /* synthetic */ BiFunction c;
    final /* synthetic */ BinaryOperator d;

    d2(Object object, BiFunction biFunction, BinaryOperator binaryOperator) {
        this.b = object;
        this.c = biFunction;
        this.d = binaryOperator;
    }

    @Override
    public /* synthetic */ void accept(double d4) {
        j$.time.e.c(this);
        throw null;
    }

    @Override
    public /* synthetic */ void accept(int n3) {
        j$.time.e.a(this);
        throw null;
    }

    @Override
    public /* synthetic */ void accept(long l3) {
        j$.time.e.b(this);
        throw null;
    }

    @Override
    public void accept(Object object) {
        this.a = this.c.apply(this.a, object);
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new e(this, consumer);
    }

    @Override
    public void i(u2 u22) {
        d2 d22 = (d2)u22;
        this.a = this.d.apply(this.a, d22.a);
    }

    @Override
    public void m() {
    }

    @Override
    public void n(long l3) {
        this.a = this.b;
    }

    @Override
    public /* synthetic */ boolean p() {
        return false;
    }
}

