/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BiFunction$-CC;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;

public final class w
implements BinaryOperator {
    public final /* synthetic */ BiConsumer a;

    public /* synthetic */ w(BiConsumer biConsumer) {
        this.a = biConsumer;
    }

    @Override
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction$-CC.$default$andThen(this, function);
    }

    @Override
    public final Object apply(Object object, Object object2) {
        this.a.accept(object, object2);
        return object;
    }
}

