/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.ObjIntConsumer
 */
package j$;

import j$.u0;
import j$.util.function.I;
import java.util.function.ObjIntConsumer;

public final class v0
implements ObjIntConsumer {
    final /* synthetic */ I a;

    private /* synthetic */ v0(I i2) {
        this.a = i2;
    }

    public static /* synthetic */ ObjIntConsumer a(I i2) {
        if (i2 == null) {
            return null;
        }
        if (i2 instanceof u0) {
            return ((u0)i2).a;
        }
        return new v0(i2);
    }

    public /* synthetic */ void accept(Object object, int n2) {
        this.a.accept(object, n2);
    }
}

