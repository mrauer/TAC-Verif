/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.BiConsumer
 */
package j$;

import j$.r;
import j$.util.function.BiConsumer;

public final class s
implements java.util.function.BiConsumer {
    final /* synthetic */ BiConsumer a;

    private /* synthetic */ s(BiConsumer biConsumer) {
        this.a = biConsumer;
    }

    public static /* synthetic */ java.util.function.BiConsumer a(BiConsumer biConsumer) {
        if (biConsumer == null) {
            return null;
        }
        if (biConsumer instanceof r) {
            return ((r)biConsumer).a;
        }
        return new s(biConsumer);
    }

    public /* synthetic */ void accept(Object object, Object object2) {
        this.a.accept(object, object2);
    }

    public /* synthetic */ java.util.function.BiConsumer andThen(java.util.function.BiConsumer biConsumer) {
        return s.a(this.a.a(r.b(biConsumer)));
    }
}

