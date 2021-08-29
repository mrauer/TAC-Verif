/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.ObjLongConsumer
 */
package j$;

import j$.util.function.J;
import j$.w0;
import java.util.function.ObjLongConsumer;

public final class x0
implements ObjLongConsumer {
    final /* synthetic */ J a;

    private /* synthetic */ x0(J j2) {
        this.a = j2;
    }

    public static /* synthetic */ ObjLongConsumer a(J j2) {
        if (j2 == null) {
            return null;
        }
        if (j2 instanceof w0) {
            return ((w0)j2).a;
        }
        return new x0(j2);
    }

    public /* synthetic */ void accept(Object object, long l2) {
        this.a.accept(object, l2);
    }
}

