/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.a;
import j$.util.l;
import java.util.Objects;

public final class k0
implements BiConsumer {
    public static final /* synthetic */ k0 a;

    static /* synthetic */ {
        a = new k0();
    }

    private /* synthetic */ k0() {
    }

    @Override
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull((Object)biConsumer);
        return new a(this, biConsumer);
    }

    @Override
    public final void accept(Object object, Object object2) {
        ((l)object).b((l)object2);
    }
}

