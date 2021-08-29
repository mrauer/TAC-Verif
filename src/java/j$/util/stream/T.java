/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.stream;

import j$.util.function.H;
import j$.util.stream.n1;

public final class t
implements H {
    public static final /* synthetic */ t a;

    static /* synthetic */ {
        a = new t();
    }

    private /* synthetic */ t() {
    }

    @Override
    public final void accept(Object object, double d2) {
        double[] arrd = (double[])object;
        arrd[2] = 1.0 + arrd[2];
        n1.b(arrd, d2);
        arrd[3] = d2 + arrd[3];
    }
}

