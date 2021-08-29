/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.time.format;

import j$.time.chrono.e;
import j$.time.format.c;
import j$.time.format.d;
import j$.util.function.Consumer;
import java.util.Objects;

public final class b
implements Consumer {
    public final /* synthetic */ c.l a;
    public final /* synthetic */ d b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public /* synthetic */ b(c.l l2, d d2, long l3, int n2, int n3) {
        this.a = l2;
        this.b = d2;
        this.c = l3;
        this.d = n2;
        this.e = n3;
    }

    @Override
    public final void accept(Object object) {
        c.l l2 = this.a;
        d d2 = this.b;
        long l3 = this.c;
        int n2 = this.d;
        int n3 = this.e;
        (e)object;
        l2.d(d2, l3, n2, n3);
    }

    @Override
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull((Object)consumer);
        return new j$.util.function.e(this, consumer);
    }
}

