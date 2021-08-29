/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.stream;

import j$.util.function.H;
import j$.util.stream.n1;

public final class r
implements H {
    public static final /* synthetic */ r a;

    static /* synthetic */ {
        a = new r();
    }

    private /* synthetic */ r() {
    }

    @Override
    public final void accept(Object object, double d2) {
        double[] arrd = (double[])object;
        n1.b(arrd, d2);
        arrd[2] = d2 + arrd[2];
    }
}

