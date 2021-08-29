/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.LinkedHashSet
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.a;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;

public final class i
implements BiConsumer {
    public static final /* synthetic */ i a;

    static /* synthetic */ {
        a = new i();
    }

    private /* synthetic */ i() {
    }

    @Override
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull((Object)biConsumer);
        return new a(this, biConsumer);
    }

    @Override
    public final void accept(Object object, Object object2) {
        ((LinkedHashSet)object).addAll((Collection)((LinkedHashSet)object2));
    }
}

