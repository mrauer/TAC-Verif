/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.e;
import java.util.Objects;

public final class f0
implements Consumer {
    public static final /* synthetic */ f0 a;

    static /* synthetic */ {
        a = new f0();
    }

    private /* synthetic */ f0() {
    }

    @Override
    public final void accept(Object object) {
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new e(this, consumer);
    }
}

