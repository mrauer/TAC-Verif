/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.a;
import j$.util.stream.n1;
import java.util.Objects;

public final class p
implements BiConsumer {
    public static final /* synthetic */ p a;

    static /* synthetic */ {
        a = new p();
    }

    private /* synthetic */ p() {
    }

    @Override
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull((Object)biConsumer);
        return new a(this, biConsumer);
    }

    @Override
    public final void accept(Object object, Object object2) {
        double[] arrd = (double[])object;
        double[] arrd2 = (double[])object2;
        n1.b(arrd, arrd2[0]);
        n1.b(arrd, arrd2[1]);
        arrd[2] = arrd[2] + arrd2[2];
    }
}

