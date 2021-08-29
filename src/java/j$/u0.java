/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.ObjIntConsumer
 */
package j$;

import j$.util.function.I;
import j$.v0;
import java.util.function.ObjIntConsumer;

public final class u0
implements I {
    final /* synthetic */ ObjIntConsumer a;

    private /* synthetic */ u0(ObjIntConsumer objIntConsumer) {
        this.a = objIntConsumer;
    }

    public static /* synthetic */ I a(ObjIntConsumer objIntConsumer) {
        if (objIntConsumer == null) {
            return null;
        }
        if (objIntConsumer instanceof v0) {
            return ((v0)objIntConsumer).a;
        }
        return new u0(objIntConsumer);
    }

    @Override
    public /* synthetic */ void accept(Object object, int n2) {
        this.a.accept(object, n2);
    }
}

