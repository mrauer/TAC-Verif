/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Equivalence
 *  java.lang.Object
 */
package com.github.fge.jsonschema.core.util.equivalence;

import com.google.common.base.Equivalence;

public final class Equivalences {
    private Equivalences() {
    }

    public static <T> Equivalence<T> equals() {
        return Equivalence.equals();
    }

    public static <T> Equivalence<T> identity() {
        return Equivalence.identity();
    }
}

