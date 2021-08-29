/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.raw.Interleave;

public class SecT131Field {
    public static final long[] ROOT_Z = new long[]{2791191049453778211L, 2791191049453778402L, 6L};

    public static void addExt(long[] arrl, long[] arrl2, long[] arrl3) {
        arrl3[0] = arrl[0] ^ arrl2[0];
        arrl3[1] = arrl[1] ^ arrl2[1];
        arrl3[2] = arrl[2] ^ arrl2[2];
        arrl3[3] = arrl[3] ^ arrl2[3];
        arrl3[4] = arrl[4] ^ arrl2[4];
    }

    public static void implMultiply(long[] arrl, long[] arrl2, long[] arrl3) {
        long l2 = arrl[0];
        long l3 = arrl[1];
        long l4 = arrl[2];
        long l5 = 0xFFFFFFFFFFFL & (l3 >>> 24 ^ l4 << 40);
        long l6 = 0xFFFFFFFFFFFL & (l2 >>> 44 ^ l3 << 20);
        long l7 = l2 & 0xFFFFFFFFFFFL;
        long l8 = arrl2[0];
        long l9 = arrl2[1];
        long l10 = arrl2[2];
        long l11 = 0xFFFFFFFFFFFL & (l9 >>> 24 ^ l10 << 40);
        long l12 = 0xFFFFFFFFFFFL & (l8 >>> 44 ^ l9 << 20);
        long l13 = l8 & 0xFFFFFFFFFFFL;
        long[] arrl4 = new long[10];
        SecT131Field.implMulw(arrl3, l7, l13, arrl4, 0);
        SecT131Field.implMulw(arrl3, l5, l11, arrl4, 2);
        long l14 = l5 ^ (l7 ^ l6);
        long l15 = l11 ^ (l13 ^ l12);
        SecT131Field.implMulw(arrl3, l14, l15, arrl4, 4);
        long l16 = l6 << 1 ^ l5 << 2;
        long l17 = l12 << 1 ^ l11 << 2;
        SecT131Field.implMulw(arrl3, l7 ^ l16, l13 ^ l17, arrl4, 6);
        SecT131Field.implMulw(arrl3, l14 ^ l16, l15 ^ l17, arrl4, 8);
        long l18 = arrl4[6] ^ arrl4[8];
        long l19 = arrl4[7] ^ arrl4[9];
        long l20 = l18 << 1 ^ arrl4[6];
        long l21 = l18 ^ l19 << 1 ^ arrl4[7];
        long l22 = arrl4[0];
        long l23 = arrl4[1] ^ arrl4[0] ^ arrl4[4];
        long l24 = arrl4[1] ^ arrl4[5];
        long l25 = l22 ^ l20 ^ arrl4[2] << 4 ^ arrl4[2] << 1;
        long l26 = l23 ^ l21 ^ arrl4[3] << 4 ^ arrl4[3] << 1;
        long l27 = l24 ^ l19;
        long l28 = l26 ^ l25 >>> 44;
        long l29 = l25 & 0xFFFFFFFFFFFL;
        long l30 = l27 ^ l28 >>> 44;
        long l31 = l28 & 0xFFFFFFFFFFFL;
        long l32 = l29 >>> 1 ^ (l31 & 1L) << 43;
        long l33 = l31 >>> 1 ^ (l30 & 1L) << 43;
        long l34 = l30 >>> 1;
        long l35 = l32 ^ l32 << 1;
        long l36 = l35 ^ l35 << 2;
        long l37 = l36 ^ l36 << 4;
        long l38 = l37 ^ l37 << 8;
        long l39 = l38 ^ l38 << 16;
        long l40 = 0xFFFFFFFFFFFL & (l39 ^ l39 << 32);
        long l41 = l33 ^ l40 >>> 43;
        long l42 = l41 ^ l41 << 1;
        long l43 = l42 ^ l42 << 2;
        long l44 = l43 ^ l43 << 4;
        long l45 = l44 ^ l44 << 8;
        long l46 = l45 ^ l45 << 16;
        long l47 = 0xFFFFFFFFFFFL & (l46 ^ l46 << 32);
        long l48 = l34 ^ l47 >>> 43;
        long l49 = l48 ^ l48 << 1;
        long l50 = l49 ^ l49 << 2;
        long l51 = l50 ^ l50 << 4;
        long l52 = l51 ^ l51 << 8;
        long l53 = l52 ^ l52 << 16;
        long l54 = l53 ^ l53 << 32;
        arrl3[0] = l22;
        arrl3[1] = l23 ^ l40 ^ arrl4[2];
        arrl3[2] = l40 ^ (l24 ^ l47) ^ arrl4[3];
        arrl3[3] = l47 ^ l54;
        arrl3[4] = l54 ^ arrl4[2];
        arrl3[5] = arrl4[3];
        long l55 = arrl3[0];
        long l56 = arrl3[1];
        long l57 = arrl3[2];
        long l58 = arrl3[3];
        long l59 = arrl3[4];
        long l60 = arrl3[5];
        arrl3[0] = l55 ^ l56 << 44;
        arrl3[1] = l56 >>> 20 ^ l57 << 24;
        arrl3[2] = l57 >>> 40 ^ l58 << 4 ^ l59 << 48;
        arrl3[3] = l58 >>> 60 ^ l60 << 28 ^ l59 >>> 16;
        arrl3[4] = l60 >>> 36;
        arrl3[5] = 0L;
    }

    public static void implMulw(long[] arrl, long l2, long l3, long[] arrl2, int n2) {
        arrl[1] = l3;
        arrl[2] = arrl[1] << 1;
        arrl[3] = l3 ^ arrl[2];
        arrl[4] = arrl[2] << 1;
        arrl[5] = l3 ^ arrl[4];
        arrl[6] = arrl[3] << 1;
        arrl[7] = l3 ^ arrl[6];
        int n3 = (int)l2;
        long l4 = arrl[n3 & 7] ^ arrl[7 & n3 >>> 3] << 3 ^ arrl[7 & n3 >>> 6] << 6 ^ arrl[7 & n3 >>> 9] << 9 ^ arrl[7 & n3 >>> 12] << 12;
        long l5 = 0L;
        int n4 = 30;
        do {
            int n5 = (int)(l2 >>> n4);
            long l6 = arrl[n5 & 7] ^ arrl[7 & n5 >>> 3] << 3 ^ arrl[7 & n5 >>> 6] << 6 ^ arrl[7 & n5 >>> 9] << 9 ^ arrl[7 & n5 >>> 12] << 12;
            l4 ^= l6 << n4;
            l5 ^= l6 >>> -n4;
        } while ((n4 -= 15) > 0);
        arrl2[n2] = 0xFFFFFFFFFFFL & l4;
        arrl2[n2 + 1] = l4 >>> 44 ^ l5 << 20;
    }

    public static void implSquare(long[] arrl, long[] arrl2) {
        Interleave.expand64To128(arrl, 0, 2, arrl2, 0);
        int n2 = 255 & (int)arrl[2];
        int n3 = 3855 & (n2 | n2 << 4);
        int n4 = 13107 & (n3 | n3 << 2);
        arrl2[4] = 0xFFFFFFFFL & (long)(21845 & (n4 | n4 << 1));
    }

    public static void multiply(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[8];
        SecT131Field.implMultiply(arrl, arrl2, arrl4);
        SecT131Field.reduce(arrl4, arrl3);
    }

    public static void multiplyAddToExt(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[8];
        SecT131Field.implMultiply(arrl, arrl2, arrl4);
        SecT131Field.addExt(arrl3, arrl4, arrl3);
    }

    public static void reduce(long[] arrl, long[] arrl2) {
        long l2 = arrl[0];
        long l3 = arrl[1];
        long l4 = arrl[2];
        long l5 = arrl[3];
        long l6 = arrl[4];
        long l7 = l3 ^ (l6 << 61 ^ l6 << 63);
        long l8 = l4 ^ (l6 ^ (l6 >>> 3 ^ l6 >>> 1) ^ l6 << 5);
        long l9 = l5 ^ l6 >>> 59;
        long l10 = l2 ^ (l9 << 61 ^ l9 << 63);
        long l11 = l7 ^ (l9 ^ (l9 >>> 3 ^ l9 >>> 1) ^ l9 << 5);
        long l12 = l8 ^ l9 >>> 59;
        long l13 = l12 >>> 3;
        arrl2[0] = l10 ^ l13 ^ l13 << 2 ^ l13 << 3 ^ l13 << 8;
        arrl2[1] = l11 ^ l13 >>> 56;
        arrl2[2] = 7L & l12;
    }

    public static void square(long[] arrl, long[] arrl2) {
        long[] arrl3 = new long[5];
        SecT131Field.implSquare(arrl, arrl3);
        SecT131Field.reduce(arrl3, arrl2);
    }

    public static void squareN(long[] arrl, int n2, long[] arrl2) {
        long[] arrl3 = new long[5];
        SecT131Field.implSquare(arrl, arrl3);
        do {
            SecT131Field.reduce(arrl3, arrl2);
            if (--n2 <= 0) break;
            SecT131Field.implSquare(arrl2, arrl3);
        } while (true);
    }
}

