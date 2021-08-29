/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.function;

import j$.util.function.BiConsumer;
import java.util.Objects;

public final class a
implements BiConsumer {
    public final /* synthetic */ BiConsumer a;
    public final /* synthetic */ BiConsumer b;

    public /* synthetic */ a(BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.a = biConsumer;
        this.b = biConsumer2;
    }

    @Override
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull((Object)biConsumer);
        return new a(this, biConsumer);
    }

    @Override
    public final void accept(Object object, Object object2) {
        BiConsumer biConsumer = this.a;
        BiConsumer biConsumer2 = this.b;
        biConsumer.accept(object, object2);
        biConsumer2.accept(object, object2);
    }
}

