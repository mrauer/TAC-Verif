/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.ObjDoubleConsumer
 */
package j$;

import j$.t0;
import j$.util.function.H;
import java.util.function.ObjDoubleConsumer;

public final class s0
implements H {
    final /* synthetic */ ObjDoubleConsumer a;

    private /* synthetic */ s0(ObjDoubleConsumer objDoubleConsumer) {
        this.a = objDoubleConsumer;
    }

    public static /* synthetic */ H a(ObjDoubleConsumer objDoubleConsumer) {
        if (objDoubleConsumer == null) {
            return null;
        }
        if (objDoubleConsumer instanceof t0) {
            return ((t0)objDoubleConsumer).a;
        }
        return new s0(objDoubleConsumer);
    }

    @Override
    public /* synthetic */ void accept(Object object, double d2) {
        this.a.accept(object, d2);
    }
}

