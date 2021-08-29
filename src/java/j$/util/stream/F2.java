/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.Optional;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.e;
import j$.util.stream.u2;
import java.util.Objects;

class f2
implements u2<T, Optional<T>, f2> {
    private boolean a;
    private Object b;
    final /* synthetic */ BinaryOperator c;

    f2(BinaryOperator binaryOperator) {
        this.c = binaryOperator;
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
        if (this.a) {
            this.a = false;
        } else {
            object = this.c.apply(this.b, object);
        }
        this.b = object;
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new e(this, consumer);
    }

    @Override
    public Object get() {
        if (this.a) {
            return Optional.a();
        }
        return Optional.d(this.b);
    }

    @Override
    public void i(u2 u22) {
        f2 f22 = (f2)u22;
        if (!f22.a) {
            this.accept(f22.b);
        }
    }

    @Override
    public void m() {
    }

    @Override
    public void n(long l3) {
        this.a = true;
        this.b = null;
    }

    @Override
    public /* synthetic */ boolean p() {
        return false;
    }
}

