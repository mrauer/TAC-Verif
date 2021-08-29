/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Object
 */
package j$.util.stream;

import j$.util.function.ToDoubleFunction;

public final class n
implements ToDoubleFunction {
    public static final /* synthetic */ n a;

    static /* synthetic */ {
        a = new n();
    }

    private /* synthetic */ n() {
    }

    @Override
    public final double applyAsDouble(Object object) {
        return (Double)object;
    }
}

