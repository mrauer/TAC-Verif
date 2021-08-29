/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.ObjLongConsumer
 */
package j$;

import j$.util.function.J;
import j$.x0;
import java.util.function.ObjLongConsumer;

public final class w0
implements J {
    final /* synthetic */ ObjLongConsumer a;

    private /* synthetic */ w0(ObjLongConsumer objLongConsumer) {
        this.a = objLongConsumer;
    }

    public static /* synthetic */ J a(ObjLongConsumer objLongConsumer) {
        if (objLongConsumer == null) {
            return null;
        }
        if (objLongConsumer instanceof x0) {
            return ((x0)objLongConsumer).a;
        }
        return new w0(objLongConsumer);
    }

    @Override
    public /* synthetic */ void accept(Object object, long l2) {
        this.a.accept(object, l2);
    }
}

