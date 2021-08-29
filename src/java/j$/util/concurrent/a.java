/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  java.util.concurrent.ConcurrentMap
 */
package j$.util.concurrent;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

public final class a
implements BiConsumer {
    public final /* synthetic */ ConcurrentMap a;
    public final /* synthetic */ BiFunction b;

    public /* synthetic */ a(ConcurrentMap concurrentMap, BiFunction biFunction) {
        this.a = concurrentMap;
        this.b = biFunction;
    }

    @Override
    public BiConsumer a(BiConsumer biConsumer) {
        Objects.requireNonNull((Object)biConsumer);
        return new j$.util.function.a(this, biConsumer);
    }

    @Override
    public final void accept(Object object, Object object2) {
        ConcurrentMap concurrentMap = this.a;
        BiFunction biFunction = this.b;
        while (!concurrentMap.replace(object, object2, biFunction.apply(object, object2)) && (object2 = concurrentMap.get(object)) != null) {
        }
    }
}

