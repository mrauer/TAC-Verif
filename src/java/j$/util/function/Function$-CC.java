/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 */
package j$.util.function;

import j$.util.function.Function;
import j$.util.function.g;
import j$.util.function.h;
import java.util.Objects;

public final class Function$-CC {
    public static Function $default$andThen(Function function, Function function2) {
        Objects.requireNonNull((Object)function2);
        return new g(function, function2);
    }

    public static Function $default$compose(Function function, Function function2) {
        Objects.requireNonNull((Object)function2);
        return new h(function, function2);
    }
}

