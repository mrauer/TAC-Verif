/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.System
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat576;

public class SecT571Field {
    public static final long[] ROOT_Z = new long[]{3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};

    public static void add(long[] arrl, long[] arrl2, long[] arrl3) {
        for (int i2 = 0; i2 < 9; ++i2) {
            arrl3[i2] = arrl[i2] ^ arrl2[i2];
        }
    }

    public static void addBothTo(long[] arrl, int n2, long[] arrl2, int n3, long[] arrl3, int n4) {
        for (int i2 = 0; i2 < 9; ++i2) {
            int n5 = n4 + i2;
            arrl3[n5] = arrl3[n5] ^ (arrl[n2 + i2] ^ arrl2[n3 + i2]);
        }
    }

    public static void addBothTo(long[] arrl, long[] arrl2, long[] arrl3) {
        for (int i2 = 0; i2 < 9; ++i2) {
            arrl3[i2] = arrl3[i2] ^ (arrl[i2] ^ arrl2[i2]);
        }
    }

    public static void addExt(long[] arrl, long[] arrl2, long[] arrl3) {
        for (int i2 = 0; i2 < 18; ++i2) {
            arrl3[i2] = arrl[i2] ^ arrl2[i2];
        }
    }

    public static void addOne(long[] arrl, long[] arrl2) {
        arrl2[0] = 1L ^ arrl[0];
        for (int i2 = 1; i2 < 9; ++i2) {
            arrl2[i2] = arrl[i2];
        }
    }

    public static void implMultiply(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[16];
        for (int i2 = 0; i2 < 9; ++i2) {
            SecT571Field.implMulwAcc(arrl4, arrl[i2], arrl2[i2], arrl3, i2 << 1);
        }
        long l2 = arrl3[0];
        long l3 = arrl3[1];
        long l4 = l2 ^ arrl3[2];
        arrl3[1] = l4 ^ l3;
        long l5 = l3 ^ arrl3[3];
        long l6 = l4 ^ arrl3[4];
        arrl3[2] = l6 ^ l5;
        long l7 = l5 ^ arrl3[5];
        long l8 = l6 ^ arrl3[6];
        arrl3[3] = l8 ^ l7;
        long l9 = l7 ^ arrl3[7];
        long l10 = l8 ^ arrl3[8];
        arrl3[4] = l10 ^ l9;
        long l11 = l9 ^ arrl3[9];
        long l12 = l10 ^ arrl3[10];
        arrl3[5] = l12 ^ l11;
        long l13 = l11 ^ arrl3[11];
        long l14 = l12 ^ arrl3[12];
        arrl3[6] = l14 ^ l13;
        long l15 = l13 ^ arrl3[13];
        long l16 = l14 ^ arrl3[14];
        arrl3[7] = l16 ^ l15;
        long l17 = l15 ^ arrl3[15];
        long l18 = l16 ^ arrl3[16];
        arrl3[8] = l18 ^ l17;
        long l19 = l18 ^ (l17 ^ arrl3[17]);
        arrl3[9] = l19 ^ arrl3[0];
        arrl3[10] = l19 ^ arrl3[1];
        arrl3[11] = l19 ^ arrl3[2];
        arrl3[12] = l19 ^ arrl3[3];
        arrl3[13] = l19 ^ arrl3[4];
        arrl3[14] = l19 ^ arrl3[5];
        arrl3[15] = l19 ^ arrl3[6];
        arrl3[16] = l19 ^ arrl3[7];
        arrl3[17] = l19 ^ arrl3[8];
        SecT571Field.implMulwAcc(arrl4, arrl[0] ^ arrl[1], arrl2[0] ^ arrl2[1], arrl3, 1);
        SecT571Field.implMulwAcc(arrl4, arrl[0] ^ arrl[2], arrl2[0] ^ arrl2[2], arrl3, 2);
        SecT571Field.implMulwAcc(arrl4, arrl[0] ^ arrl[3], arrl2[0] ^ arrl2[3], arrl3, 3);
        SecT571Field.implMulwAcc(arrl4, arrl[1] ^ arrl[2], arrl2[1] ^ arrl2[2], arrl3, 3);
        SecT571Field.implMulwAcc(arrl4, arrl[0] ^ arrl[4], arrl2[0] ^ arrl2[4], arrl3, 4);
        SecT571Field.implMulwAcc(arrl4, arrl[1] ^ arrl[3], arrl2[1] ^ arrl2[3], arrl3, 4);
        SecT571Field.implMulwAcc(arrl4, arrl[0] ^ arrl[5], arrl2[0] ^ arrl2[5], arrl3, 5);
        SecT571Field.implMulwAcc(arrl4, arrl[1] ^ arrl[4], arrl2[1] ^ arrl2[4], arrl3, 5);
        SecT571Field.implMulwAcc(arrl4, arrl[2] ^ arrl[3], arrl2[2] ^ arrl2[3], arrl3, 5);
        SecT571Field.implMulwAcc(arrl4, arrl[0] ^ arrl[6], arrl2[0] ^ arrl2[6], arrl3, 6);
        SecT571Field.implMulwAcc(arrl4, arrl[1] ^ arrl[5], arrl2[1] ^ arrl2[5], arrl3, 6);
        SecT571Field.implMulwAcc(arrl4, arrl[2] ^ arrl[4], arrl2[2] ^ arrl2[4], arrl3, 6);
        SecT571Field.implMulwAcc(arrl4, arrl[0] ^ arrl[7], arrl2[0] ^ arrl2[7], arrl3, 7);
        SecT571Field.implMulwAcc(arrl4, arrl[1] ^ arrl[6], arrl2[1] ^ arrl2[6], arrl3, 7);
        SecT571Field.implMulwAcc(arrl4, arrl[2] ^ arrl[5], arrl2[2] ^ arrl2[5], arrl3, 7);
        SecT571Field.implMulwAcc(arrl4, arrl[3] ^ arrl[4], arrl2[3] ^ arrl2[4], arrl3, 7);
        SecT571Field.implMulwAcc(arrl4, arrl[0] ^ arrl[8], arrl2[0] ^ arrl2[8], arrl3, 8);
        SecT571Field.implMulwAcc(arrl4, arrl[1] ^ arrl[7], arrl2[1] ^ arrl2[7], arrl3, 8);
        SecT571Field.implMulwAcc(arrl4, arrl[2] ^ arrl[6], arrl2[2] ^ arrl2[6], arrl3, 8);
        SecT571Field.implMulwAcc(arrl4, arrl[3] ^ arrl[5], arrl2[3] ^ arrl2[5], arrl3, 8);
        SecT571Field.implMulwAcc(arrl4, arrl[1] ^ arrl[8], arrl2[1] ^ arrl2[8], arrl3, 9);
        SecT571Field.implMulwAcc(arrl4, arrl[2] ^ arrl[7], arrl2[2] ^ arrl2[7], arrl3, 9);
        SecT571Field.implMulwAcc(arrl4, arrl[3] ^ arrl[6], arrl2[3] ^ arrl2[6], arrl3, 9);
        SecT571Field.implMulwAcc(arrl4, arrl[4] ^ arrl[5], arrl2[4] ^ arrl2[5], arrl3, 9);
        SecT571Field.implMulwAcc(arrl4, arrl[2] ^ arrl[8], arrl2[2] ^ arrl2[8], arrl3, 10);
        SecT571Field.implMulwAcc(arrl4, arrl[3] ^ arrl[7], arrl2[3] ^ arrl2[7], arrl3, 10);
        SecT571Field.implMulwAcc(arrl4, arrl[4] ^ arrl[6], arrl2[4] ^ arrl2[6], arrl3, 10);
        SecT571Field.implMulwAcc(arrl4, arrl[3] ^ arrl[8], arrl2[3] ^ arrl2[8], arrl3, 11);
        SecT571Field.implMulwAcc(arrl4, arrl[4] ^ arrl[7], arrl2[4] ^ arrl2[7], arrl3, 11);
        SecT571Field.implMulwAcc(arrl4, arrl[5] ^ arrl[6], arrl2[5] ^ arrl2[6], arrl3, 11);
        SecT571Field.implMulwAcc(arrl4, arrl[4] ^ arrl[8], arrl2[4] ^ arrl2[8], arrl3, 12);
        SecT571Field.implMulwAcc(arrl4, arrl[5] ^ arrl[7], arrl2[5] ^ arrl2[7], arrl3, 12);
        SecT571Field.implMulwAcc(arrl4, arrl[5] ^ arrl[8], arrl2[5] ^ arrl2[8], arrl3, 13);
        SecT571Field.implMulwAcc(arrl4, arrl[6] ^ arrl[7], arrl2[6] ^ arrl2[7], arrl3, 13);
        SecT571Field.implMulwAcc(arrl4, arrl[6] ^ arrl[8], arrl2[6] ^ arrl2[8], arrl3, 14);
        SecT571Field.implMulwAcc(arrl4, arrl[7] ^ arrl[8], arrl2[7] ^ arrl2[8], arrl3, 15);
    }

    public static void implMultiplyPrecomp(long[] arrl, long[] arrl2, long[] arrl3) {
        int n2;
        for (int i2 = n2 = 56; i2 >= 0; i2 -= 8) {
            for (int i3 = 1; i3 < 9; i3 += 2) {
                int n3 = (int)(arrl[i3] >>> i2);
                int n4 = n3 & 15;
                int n5 = 15 & n3 >>> 4;
                SecT571Field.addBothTo(arrl2, n4 * 9, arrl2, 9 * (n5 + 16), arrl3, i3 - 1);
            }
            Nat576.shiftUpBits64(16, arrl3, 0, 8, 0L);
        }
        while (n2 >= 0) {
            for (int i4 = 0; i4 < 9; i4 += 2) {
                int n6 = (int)(arrl[i4] >>> n2);
                int n7 = n6 & 15;
                int n8 = 15 & n6 >>> 4;
                SecT571Field.addBothTo(arrl2, n7 * 9, arrl2, 9 * (n8 + 16), arrl3, i4);
            }
            if (n2 > 0) {
                Nat576.shiftUpBits64(18, arrl3, 0, 8, 0L);
            }
            n2 -= 8;
        }
    }

    public static void implMulwAcc(long[] arrl, long l2, long l3, long[] arrl2, int n2) {
        long l4 = l2;
        arrl[1] = l3;
        for (int i2 = 2; i2 < 16; i2 += 2) {
            arrl[i2] = arrl[i2 >>> 1] << 1;
            arrl[i2 + 1] = l3 ^ arrl[i2];
        }
        int n3 = (int)l4;
        long l5 = 0L;
        long l6 = arrl[n3 & 15] ^ arrl[15 & n3 >>> 4] << 4;
        int n4 = 56;
        do {
            int n5 = (int)(l4 >>> n4);
            long l7 = arrl[n5 & 15] ^ arrl[15 & n5 >>> 4] << 4;
            l6 ^= l7 << n4;
            l5 ^= l7 >>> -n4;
        } while ((n4 -= 8) > 0);
        for (int i3 = 0; i3 < 7; ++i3) {
            l4 = (l4 & -72340172838076674L) >>> 1;
            l5 ^= l4 & l3 << i3 >> 63;
        }
        arrl2[n2] = l6 ^ arrl2[n2];
        int n6 = n2 + 1;
        arrl2[n6] = l5 ^ arrl2[n6];
    }

    public static void implSquare(long[] arrl, long[] arrl2) {
        Interleave.expand64To128(arrl, 0, 9, arrl2, 0);
    }

    public static void multiply(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[18];
        SecT571Field.implMultiply(arrl, arrl2, arrl4);
        SecT571Field.reduce(arrl4, arrl3);
    }

    public static void multiplyAddToExt(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[18];
        SecT571Field.implMultiply(arrl, arrl2, arrl4);
        SecT571Field.addExt(arrl3, arrl4, arrl3);
    }

    public static void multiplyPrecomp(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[18];
        SecT571Field.implMultiplyPrecomp(arrl, arrl2, arrl4);
        SecT571Field.reduce(arrl4, arrl3);
    }

    public static long[] precompMultiplicand(long[] arrl) {
        long l2;
        long[] arrl2 = new long[288];
        System.arraycopy((Object)arrl, (int)0, (Object)arrl2, (int)9, (int)9);
        int n2 = 7;
        int n3 = 0;
        do {
            l2 = 0L;
            if (n2 <= 0) break;
            int n4 = (n3 += 18) >>> 1;
            for (int i2 = 0; i2 < 9; ++i2) {
                long l3 = arrl2[n4 + i2];
                arrl2[n3 + i2] = l3 << 1 | l2 >>> 63;
                l2 = l3;
            }
            int n5 = n3 + 8;
            long l4 = arrl2[n5];
            long l5 = l4 >>> 59;
            arrl2[n3] = arrl2[n3] ^ (l5 ^ l5 << 2 ^ l5 << 5 ^ l5 << 10);
            arrl2[n5] = l4 & 0x7FFFFFFFFFFFFFFL;
            int n6 = n3 + 9;
            for (int i3 = 0; i3 < 9; ++i3) {
                arrl2[n6 + i3] = arrl2[9 + i3] ^ arrl2[n3 + i3];
            }
            --n2;
        } while (true);
        for (int i4 = 0; i4 < 144; ++i4) {
            long l6 = arrl2[0 + i4];
            arrl2[144 + i4] = l6 << 4 | l2 >>> -4;
            l2 = l6;
        }
        return arrl2;
    }

    public static void reduce(long[] arrl, long[] arrl2) {
        long l2 = arrl[9];
        long l3 = arrl[17];
        long l4 = l2 ^ l3 >>> 59 ^ l3 >>> 57 ^ l3 >>> 54 ^ l3 >>> 49;
        long l5 = arrl[8] ^ l3 << 5 ^ l3 << 7 ^ l3 << 10 ^ l3 << 15;
        for (int i2 = 16; i2 >= 10; --i2) {
            long l6 = arrl[i2];
            arrl2[i2 - 8] = l5 ^ l6 >>> 59 ^ l6 >>> 57 ^ l6 >>> 54 ^ l6 >>> 49;
            l5 = arrl[i2 - 9] ^ l6 << 5 ^ l6 << 7 ^ l6 << 10 ^ l6 << 15;
        }
        arrl2[1] = l5 ^ l4 >>> 59 ^ l4 >>> 57 ^ l4 >>> 54 ^ l4 >>> 49;
        long l7 = arrl[0] ^ l4 << 5 ^ l4 << 7 ^ l4 << 10 ^ l4 << 15;
        long l8 = arrl2[8];
        long l9 = l8 >>> 59;
        arrl2[0] = l7 ^ l9 ^ l9 << 2 ^ l9 << 5 ^ l9 << 10;
        arrl2[8] = 0x7FFFFFFFFFFFFFFL & l8;
    }

    public static void square(long[] arrl, long[] arrl2) {
        long[] arrl3 = new long[18];
        SecT571Field.implSquare(arrl, arrl3);
        SecT571Field.reduce(arrl3, arrl2);
    }

    public static void squareAddToExt(long[] arrl, long[] arrl2) {
        long[] arrl3 = new long[18];
        SecT571Field.implSquare(arrl, arrl3);
        SecT571Field.addExt(arrl2, arrl3, arrl2);
    }

    public static void squareN(long[] arrl, int n2, long[] arrl2) {
        long[] arrl3 = new long[18];
        SecT571Field.implSquare(arrl, arrl3);
        do {
            SecT571Field.reduce(arrl3, arrl2);
            if (--n2 <= 0) break;
            SecT571Field.implSquare(arrl2, arrl3);
        } while (true);
    }
}

