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
import j$.util.n;
import java.util.Objects;

public final class w0
implements BiConsumer {
    public static final /* synthetic */ w0 a;

    static /* synthetic */ {
        a = new w0();
    }

    private /* synthetic */ w0() {
    }

    @Override
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull((Object)biConsumer);
        return new a(this, biConsumer);
    }

    @Override
    public final void accept(Object object, Object object2) {
        ((n)object).b((n)object2);
    }
}

