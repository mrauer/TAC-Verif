/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.math.BigInteger
 *  java.security.SecureRandom
 */
package org.bouncycastle.util;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class BigIntegers {
    public static final BigInteger ONE;
    public static final BigInteger ZERO;

    public static {
        ZERO = BigInteger.valueOf((long)0L);
        ONE = BigInteger.valueOf((long)1L);
        BigInteger.valueOf((long)2L);
        BigInteger.valueOf((long)3L);
        new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);
        BigInteger.valueOf((long)743L).bitLength();
    }

    public static byte[] asUnsignedByteArray(int n2, BigInteger bigInteger) {
        int n3;
        byte[] arrby = bigInteger.toByteArray();
        if (arrby.length == n2) {
            return arrby;
        }
        byte by = arrby[0];
        int n4 = 0;
        if (by == 0) {
            int n5 = arrby.length;
            n4 = 0;
            if (n5 != 1) {
                n4 = 1;
            }
        }
        if ((n3 = arrby.length - n4) <= n2) {
            byte[] arrby2 = new byte[n2];
            System.arraycopy((Object)arrby, (int)n4, (Object)arrby2, (int)(n2 - n3), (int)n3);
            return arrby2;
        }
        throw new IllegalArgumentException("standard length exceeded for value");
    }

    public static BigInteger createRandomBigInteger(int n2, SecureRandom secureRandom) {
        if (n2 >= 1) {
            int n3 = (n2 + 7) / 8;
            byte[] arrby = new byte[n3];
            secureRandom.nextBytes(arrby);
            int n4 = n3 * 8 - n2;
            arrby[0] = (byte)(arrby[0] & (byte)(255 >>> n4));
            return new BigInteger(1, arrby);
        }
        throw new IllegalArgumentException("bitLength must be at least 1");
    }

    public static BigInteger fromUnsignedByteArray(byte[] arrby, int n2, int n3) {
        if (n2 != 0 || n3 != arrby.length) {
            byte[] arrby2 = new byte[n3];
            System.arraycopy((Object)arrby, (int)n2, (Object)arrby2, (int)0, (int)n3);
            arrby = arrby2;
        }
        return new BigInteger(1, arrby);
    }
}

