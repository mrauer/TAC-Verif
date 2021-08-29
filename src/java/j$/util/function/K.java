/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.function;

import j$.util.function.G;
import j$.util.function.l;
import java.util.Objects;

public final class k
implements G {
    public final /* synthetic */ G a;
    public final /* synthetic */ G b;

    public /* synthetic */ k(G g2, G g4) {
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
        G g2 = this.a;
        return this.b.applyAsLong(g2.applyAsLong(l2));
    }

    @Override
    public G b(G g2) {
        Objects.requireNonNull((Object)g2);
        return new l(this, g2);
    }
}

