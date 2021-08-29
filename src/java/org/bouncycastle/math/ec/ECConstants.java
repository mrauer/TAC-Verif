/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;

public interface ECConstants {
    public static final BigInteger FOUR;
    public static final BigInteger ONE;
    public static final BigInteger TWO;
    public static final BigInteger ZERO;

    public static {
        ZERO = BigInteger.valueOf((long)0L);
        ONE = BigInteger.valueOf((long)1L);
        TWO = BigInteger.valueOf((long)2L);
        BigInteger.valueOf((long)3L);
        FOUR = BigInteger.valueOf((long)4L);
        BigInteger.valueOf((long)8L);
    }
}

