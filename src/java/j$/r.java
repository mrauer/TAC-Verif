/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.BiConsumer
 */
package j$;

import j$.s;
import j$.util.function.BiConsumer;

public final class r
implements BiConsumer {
    final /* synthetic */ java.util.function.BiConsumer a;

    private /* synthetic */ r(java.util.function.BiConsumer biConsumer) {
        this.a = biConsumer;
    }

    public static /* synthetic */ BiConsumer b(java.util.function.BiConsumer biConsumer) {
        if (biConsumer == null) {
            return null;
        }
        if (biConsumer instanceof s) {
            return ((s)biConsumer).a;
        }
        return new r(biConsumer);
    }

    @Override
    public /* synthetic */ BiConsumer a(BiConsumer biConsumer) {
        return r.b(this.a.andThen(s.a(biConsumer)));
    }

    @Override
    public /* synthetic */ void accept(Object object, Object object2) {
        this.a.accept(object, object2);
    }
}

