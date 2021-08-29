/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.raw.Interleave;

public class SecT163Field {
    public static final long[] ROOT_Z = new long[]{-5270498306774157648L, 5270498306774195053L, 19634136210L};

    public static void addExt(long[] arrl, long[] arrl2, long[] arrl3) {
        arrl3[0] = arrl[0] ^ arrl2[0];
        arrl3[1] = arrl[1] ^ arrl2[1];
        arrl3[2] = arrl[2] ^ arrl2[2];
        arrl3[3] = arrl[3] ^ arrl2[3];
        arrl3[4] = arrl[4] ^ arrl2[4];
        arrl3[5] = arrl[5] ^ arrl2[5];
    }

    public static void implMultiply(long[] arrl, long[] arrl2, long[] arrl3) {
        long l2 = arrl[0];
        long l3 = arrl[1];
        long l4 = arrl[2];
        long l5 = l3 >>> 46 ^ l4 << 18;
        long l6 = 0x7FFFFFFFFFFFFFL & (l2 >>> 55 ^ l3 << 9);
        long l7 = l2 & 0x7FFFFFFFFFFFFFL;
        long l8 = arrl2[0];
        long l9 = arrl2[1];
        long l10 = arrl2[2];
        long l11 = l9 >>> 46 ^ l10 << 18;
        long l12 = 0x7FFFFFFFFFFFFFL & (l8 >>> 55 ^ l9 << 9);
        long l13 = l8 & 0x7FFFFFFFFFFFFFL;
        long[] arrl4 = new long[10];
        SecT163Field.implMulw(arrl3, l7, l13, arrl4, 0);
        SecT163Field.implMulw(arrl3, l5, l11, arrl4, 2);
        long l14 = l5 ^ (l7 ^ l6);
        long l15 = l11 ^ (l13 ^ l12);
        SecT163Field.implMulw(arrl3, l14, l15, arrl4, 4);
        long l16 = l6 << 1 ^ l5 << 2;
        long l17 = l12 << 1 ^ l11 << 2;
        SecT163Field.implMulw(arrl3, l7 ^ l16, l13 ^ l17, arrl4, 6);
        SecT163Field.implMulw(arrl3, l14 ^ l16, l15 ^ l17, arrl4, 8);
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
        long l28 = l26 ^ l25 >>> 55;
        long l29 = l25 & 0x7FFFFFFFFFFFFFL;
        long l30 = l27 ^ l28 >>> 55;
        long l31 = l28 & 0x7FFFFFFFFFFFFFL;
        long l32 = l29 >>> 1 ^ (l31 & 1L) << 54;
        long l33 = l31 >>> 1 ^ (l30 & 1L) << 54;
        long l34 = l30 >>> 1;
        long l35 = l32 ^ l32 << 1;
        long l36 = l35 ^ l35 << 2;
        long l37 = l36 ^ l36 << 4;
        long l38 = l37 ^ l37 << 8;
        long l39 = l38 ^ l38 << 16;
        long l40 = 0x7FFFFFFFFFFFFFL & (l39 ^ l39 << 32);
        long l41 = l33 ^ l40 >>> 54;
        long l42 = l41 ^ l41 << 1;
        long l43 = l42 ^ l42 << 2;
        long l44 = l43 ^ l43 << 4;
        long l45 = l44 ^ l44 << 8;
        long l46 = l45 ^ l45 << 16;
        long l47 = 0x7FFFFFFFFFFFFFL & (l46 ^ l46 << 32);
        long l48 = l34 ^ l47 >>> 54;
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
        arrl3[0] = l55 ^ l56 << 55;
        arrl3[1] = l56 >>> 9 ^ l57 << 46;
        arrl3[2] = l57 >>> 18 ^ l58 << 37;
        arrl3[3] = l58 >>> 27 ^ l59 << 28;
        arrl3[4] = l59 >>> 36 ^ l60 << 19;
        arrl3[5] = l60 >>> 45;
    }

    public static void implMulw(long[] arrl, long l2, long l3, long[] arrl2, int n2) {
        arrl[1] = l3;
        arrl[2] = arrl[1] << 1;
        arrl[3] = l3 ^ arrl[2];
        arrl[4] = arrl[2] << 1;
        arrl[5] = l3 ^ arrl[4];
        arrl[6] = arrl[3] << 1;
        arrl[7] = l3 ^ arrl[6];
        long l4 = arrl[3 & (int)l2];
        long l5 = 0L;
        int n3 = 47;
        do {
            int n4 = (int)(l2 >>> n3);
            long l6 = arrl[n4 & 7] ^ arrl[7 & n4 >>> 3] << 3 ^ arrl[7 & n4 >>> 6] << 6;
            l4 ^= l6 << n3;
            l5 ^= l6 >>> -n3;
        } while ((n3 -= 9) > 0);
        arrl2[n2] = 0x7FFFFFFFFFFFFFL & l4;
        arrl2[n2 + 1] = l4 >>> 55 ^ l5 << 9;
    }

    public static void implSquare(long[] arrl, long[] arrl2) {
        Interleave.expand64To128(arrl, 0, 3, arrl2, 0);
    }

    public static void multiply(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[8];
        SecT163Field.implMultiply(arrl, arrl2, arrl4);
        SecT163Field.reduce(arrl4, arrl3);
    }

    public static void multiplyAddToExt(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[8];
        SecT163Field.implMultiply(arrl, arrl2, arrl4);
        SecT163Field.addExt(arrl3, arrl4, arrl3);
    }

    public static void reduce(long[] arrl, long[] arrl2) {
        long l2 = arrl[0];
        long l3 = arrl[1];
        long l4 = arrl[2];
        long l5 = arrl[3];
        long l6 = arrl[4];
        long l7 = arrl[5];
        long l8 = l4 ^ (l7 << 29 ^ l7 << 32 ^ l7 << 35 ^ l7 << 36);
        long l9 = l5 ^ (l7 >>> 35 ^ l7 >>> 32 ^ l7 >>> 29 ^ l7 >>> 28);
        long l10 = l3 ^ (l6 << 29 ^ l6 << 32 ^ l6 << 35 ^ l6 << 36);
        long l11 = l8 ^ (l6 >>> 35 ^ l6 >>> 32 ^ l6 >>> 29 ^ l6 >>> 28);
        long l12 = l2 ^ (l9 << 29 ^ l9 << 32 ^ l9 << 35 ^ l9 << 36);
        long l13 = l10 ^ (l9 >>> 35 ^ l9 >>> 32 ^ l9 >>> 29 ^ l9 >>> 28);
        long l14 = l11 >>> 35;
        arrl2[0] = l12 ^ l14 ^ l14 << 3 ^ l14 << 6 ^ l14 << 7;
        arrl2[1] = l13;
        arrl2[2] = 0x7FFFFFFFFL & l11;
    }

    public static void squareN(long[] arrl, int n2, long[] arrl2) {
        long[] arrl3 = new long[6];
        SecT163Field.implSquare(arrl, arrl3);
        do {
            SecT163Field.reduce(arrl3, arrl2);
            if (--n2 <= 0) break;
            SecT163Field.implSquare(arrl2, arrl3);
        } while (true);
    }
}

