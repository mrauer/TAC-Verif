/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Objects
 *  java.util.Set
 */
package j$.util;

import j$.util.Spliterator;
import j$.util.u;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public final class Set$-CC {
    public static Spliterator $default$spliterator(Set set) {
        Objects.requireNonNull((Object)set);
        return new u.i((Collection)set, 1);
    }
}

