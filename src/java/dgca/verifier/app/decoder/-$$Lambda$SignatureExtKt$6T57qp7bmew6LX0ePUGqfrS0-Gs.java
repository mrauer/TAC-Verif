/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j
 *  java.lang.Integer
 *  java.lang.Object
 */
package dgca.verifier.app.decoder;

import j$.util.function.BiFunction;
import j$.util.function.BiFunction$-CC;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;

public final class -$$Lambda$SignatureExtKt$6T57qp7bmew6LX0ePUGqfrS0-Gs
implements BinaryOperator {
    public static final /* synthetic */ -$$Lambda$SignatureExtKt$6T57qp7bmew6LX0ePUGqfrS0-Gs INSTANCE;

    public static /* synthetic */ {
        INSTANCE = new -$$Lambda$SignatureExtKt$6T57qp7bmew6LX0ePUGqfrS0-Gs();
    }

    @Override
    public /* synthetic */ BiFunction andThen(j.Function function) {
        return BiFunction$-CC.$default$andThen(this, function);
    }

    @Override
    public final Object apply(Object object, Object object2) {
        return (Integer)object + (Integer)object2;
    }
}

