/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.math.BigInteger
 */
package org.bouncycastle.pqc.math.linearalgebra;

import java.math.BigInteger;

public final class IntegerFunctions {
    public static {
        BigInteger.valueOf((long)0L);
        BigInteger.valueOf((long)1L);
        BigInteger.valueOf((long)2L);
        BigInteger.valueOf((long)4L);
    }

    public static int ceilLog256(int n2) {
        if (n2 == 0) {
            return 1;
        }
        if (n2 < 0) {
            n2 = -n2;
        }
        int n3 = 0;
        while (n2 > 0) {
            ++n3;
            n2 >>>= 8;
        }
        return n3;
    }
}

