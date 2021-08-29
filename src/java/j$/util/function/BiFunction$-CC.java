/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.function;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.b;
import java.util.Objects;

public final class BiFunction$-CC {
    public static BiFunction $default$andThen(BiFunction biFunction, Function function) {
        Objects.requireNonNull((Object)function);
        return new b(biFunction, function);
    }
}

