/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.function;

import j$.util.function.G;
import j$.util.function.k;
import java.util.Objects;

public final class l
implements G {
    public final /* synthetic */ G a;
    public final /* synthetic */ G b;

    public /* synthetic */ l(G g2, G g4) {
        this.a = g2;
        this.b = g4;
    }

    @Override
    public G a(G g2) {
        Objects.requireNonNull((Object)g2);
        return new k(this, g2);
    }

    @Override
    public final long applyAsLong(long l2) {
        return this.a.applyAsLong(this.b.applyAsLong(l2));
    }

    @Override
    public G b(G g2) {
        Objects.requireNonNull((Object)g2);
        return new l(this, g2);
    }
}

