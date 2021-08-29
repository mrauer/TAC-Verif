/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.function;

import j$.util.function.Function;
import j$.util.function.Function$-CC;

public final class h
implements Function {
    public final /* synthetic */ Function a;
    public final /* synthetic */ Function b;

    public /* synthetic */ h(Function function, Function function2) {
        this.a = function;
        this.b = function2;
    }

    @Override
    public /* synthetic */ Function andThen(Function function) {
        return Function$-CC.$default$andThen(this, function);
    }

    @Override
    public final Object apply(Object object) {
        return this.a.apply(this.b.apply(object));
    }

    @Override
    public /* synthetic */ Function compose(Function function) {
        return Function$-CC.$default$compose(this, function);
    }
}

