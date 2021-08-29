/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package dgca.verifier.app.decoder;

import j$.util.function.Function;
import j$.util.function.Function$-CC;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$SignatureExtKt$FnfQ187F8x_8GIgupJKujF0csbs
implements Function {
    public static final /* synthetic */ -$$Lambda$SignatureExtKt$FnfQ187F8x_8GIgupJKujF0csbs INSTANCE;

    public static /* synthetic */ {
        INSTANCE = new -$$Lambda$SignatureExtKt$FnfQ187F8x_8GIgupJKujF0csbs();
    }

    @Override
    public /* synthetic */ Function andThen(Function function) {
        return Function$-CC.$default$andThen(this, function);
    }

    @Override
    public final Object apply(Object object) {
        byte[] arrby = (byte[])object;
        Intrinsics.checkNotNullParameter((Object)arrby, (String)"r");
        return arrby.length;
    }

    @Override
    public /* synthetic */ Function compose(Function function) {
        return Function$-CC.$default$compose(this, function);
    }
}

