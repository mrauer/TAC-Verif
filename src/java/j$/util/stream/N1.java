/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.EnumSet
 *  java.util.Set
 */
package j$.util.stream;

import j$.util.stream.m1;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public final class n1 {
    static {
        m1.a a2 = m1.a.CONCURRENT;
        m1.a a3 = m1.a.UNORDERED;
        m1.a a4 = m1.a.IDENTITY_FINISH;
        Collections.unmodifiableSet((Set)EnumSet.of((Enum)a2, (Enum)a3, (Enum)a4));
        Collections.unmodifiableSet((Set)EnumSet.of((Enum)a2, (Enum)a3));
        Collections.unmodifiableSet((Set)EnumSet.of((Enum)a4));
        Collections.unmodifiableSet((Set)EnumSet.of((Enum)a3, (Enum)a4));
        Collections.emptySet();
    }

    static double a(double[] arrd) {
        double d2 = arrd[0] + arrd[1];
        double d4 = arrd[arrd.length - 1];
        if (Double.isNaN((double)d2) && Double.isInfinite((double)d4)) {
            return d4;
        }
        return d2;
    }

    static double[] b(double[] arrd, double d2) {
        double d4 = d2 - arrd[1];
        double d5 = arrd[0];
        double d6 = d5 + d4;
        arrd[1] = d6 - d5 - d4;
        arrd[0] = d6;
        return arrd;
    }
}

