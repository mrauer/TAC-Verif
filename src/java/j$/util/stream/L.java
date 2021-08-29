/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.K;

public final class l
implements K {
    public final /* synthetic */ Spliterator a;

    public /* synthetic */ l(Spliterator spliterator) {
        this.a = spliterator;
    }

    @Override
    public final Object get() {
        return this.a;
    }
}

