/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.util.Objects
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package j$.util.stream;

import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import j$.util.function.e;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class m
implements Consumer {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ ConcurrentHashMap b;

    public /* synthetic */ m(AtomicBoolean atomicBoolean, ConcurrentHashMap concurrentHashMap) {
        this.a = atomicBoolean;
        this.b = concurrentHashMap;
    }

    @Override
    public final void accept(Object object) {
        AtomicBoolean atomicBoolean = this.a;
        ConcurrentHashMap concurrentHashMap = this.b;
        if (object == null) {
            atomicBoolean.set(true);
            return;
        }
        concurrentHashMap.putIfAbsent(object, (Object)Boolean.TRUE);
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new e(this, consumer);
    }
}

