/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.ObjDoubleConsumer
 */
package j$;

import j$.s0;
import j$.util.function.H;
import java.util.function.ObjDoubleConsumer;

public final class t0
implements ObjDoubleConsumer {
    final /* synthetic */ H a;

    private /* synthetic */ t0(H h2) {
        this.a = h2;
    }

    public static /* synthetic */ ObjDoubleConsumer a(H h2) {
        if (h2 == null) {
            return null;
        }
        if (h2 instanceof s0) {
            return ((s0)h2).a;
        }
        return new t0(h2);
    }

    public /* synthetic */ void accept(Object object, double d2) {
        this.a.accept(object, d2);
    }
}

