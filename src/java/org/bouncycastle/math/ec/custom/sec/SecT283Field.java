/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.raw.Interleave;

public class SecT283Field {
    public static final long[] ROOT_Z = new long[]{878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042L};

    public static void addExt(long[] arrl, long[] arrl2, long[] arrl3) {
        arrl3[0] = arrl[0] ^ arrl2[0];
        arrl3[1] = arrl[1] ^ arrl2[1];
        arrl3[2] = arrl[2] ^ arrl2[2];
        arrl3[3] = arrl[3] ^ arrl2[3];
        arrl3[4] = arrl[4] ^ arrl2[4];
        arrl3[5] = arrl[5] ^ arrl2[5];
        arrl3[6] = arrl[6] ^ arrl2[6];
        arrl3[7] = arrl[7] ^ arrl2[7];
        arrl3[8] = arrl[8] ^ arrl2[8];
    }

    public static void implExpand(long[] arrl, long[] arrl2) {
        long l2 = arrl[0];
        long l3 = arrl[1];
        long l4 = arrl[2];
        long l5 = arrl[3];
        long l6 = arrl[4];
        arrl2[0] = l2 & 0x1FFFFFFFFFFFFFFL;
        arrl2[1] = 0x1FFFFFFFFFFFFFFL & (l2 >>> 57 ^ l3 << 7);
        arrl2[2] = 0x1FFFFFFFFFFFFFFL & (l3 >>> 50 ^ l4 << 14);
        arrl2[3] = 0x1FFFFFFFFFFFFFFL & (l4 >>> 43 ^ l5 << 21);
        arrl2[4] = l5 >>> 36 ^ l6 << 28;
    }

    public static void implMultiply(long[] arrl, long[] arrl2, long[] arrl3) {
        long l2;
        long l3;
        long l4;
        long l5;
        long[] arrl4 = new long[5];
        long[] arrl5 = new long[5];
        SecT283Field.implExpand(arrl, arrl4);
        SecT283Field.implExpand(arrl2, arrl5);
        long[] arrl6 = new long[26];
        SecT283Field.implMulw(arrl3, arrl4[0], arrl5[0], arrl6, 0);
        SecT283Field.implMulw(arrl3, arrl4[1], arrl5[1], arrl6, 2);
        SecT283Field.implMulw(arrl3, arrl4[2], arrl5[2], arrl6, 4);
        SecT283Field.implMulw(arrl3, arrl4[3], arrl5[3], arrl6, 6);
        SecT283Field.implMulw(arrl3, arrl4[4], arrl5[4], arrl6, 8);
        long l6 = arrl4[0] ^ arrl4[1];
        long l7 = arrl5[0] ^ arrl5[1];
        long l8 = arrl4[0] ^ arrl4[2];
        long l9 = arrl5[0] ^ arrl5[2];
        long l10 = arrl4[2] ^ arrl4[4];
        long l11 = arrl5[2] ^ arrl5[4];
        long l12 = arrl4[3] ^ arrl4[4];
        long l13 = arrl5[3] ^ arrl5[4];
        SecT283Field.implMulw(arrl3, l8 ^ arrl4[3], l9 ^ arrl5[3], arrl6, 18);
        SecT283Field.implMulw(arrl3, l10 ^ arrl4[1], l11 ^ arrl5[1], arrl6, 20);
        long l14 = l6 ^ l12;
        long l15 = l7 ^ l13;
        long l16 = l14 ^ arrl4[2];
        long l17 = l15 ^ arrl5[2];
        SecT283Field.implMulw(arrl3, l14, l15, arrl6, 22);
        SecT283Field.implMulw(arrl3, l16, l17, arrl6, 24);
        SecT283Field.implMulw(arrl3, l6, l7, arrl6, 10);
        SecT283Field.implMulw(arrl3, l8, l9, arrl6, 12);
        SecT283Field.implMulw(arrl3, l10, l11, arrl6, 14);
        SecT283Field.implMulw(arrl3, l12, l13, arrl6, 16);
        arrl3[0] = arrl6[0];
        arrl3[9] = arrl6[9];
        long l18 = arrl6[0] ^ arrl6[1];
        long l19 = l18 ^ arrl6[2];
        arrl3[1] = l5 = l19 ^ arrl6[10];
        long l20 = arrl6[3] ^ arrl6[4];
        arrl3[2] = l3 = l19 ^ (l20 ^ (arrl6[11] ^ arrl6[12]));
        long l21 = l18 ^ l20;
        long l22 = arrl6[5] ^ arrl6[6];
        long l23 = l21 ^ l22 ^ arrl6[8];
        long l24 = arrl6[13] ^ arrl6[14];
        arrl3[3] = l23 ^ l24 ^ (arrl6[18] ^ arrl6[22] ^ arrl6[24]);
        long l25 = arrl6[7] ^ arrl6[8] ^ arrl6[9];
        arrl3[8] = l2 = l25 ^ arrl6[17];
        arrl3[7] = l4 = l25 ^ l22 ^ (arrl6[15] ^ arrl6[16]);
        long l26 = l5 ^ l4;
        long l27 = arrl6[19] ^ arrl6[20];
        long l28 = arrl6[25] ^ arrl6[24];
        long l29 = arrl6[18] ^ arrl6[23];
        long l30 = l27 ^ l28;
        arrl3[4] = l26 ^ (l30 ^ l29);
        arrl3[5] = l30 ^ (l3 ^ l2) ^ (arrl6[21] ^ arrl6[22]);
        arrl3[6] = l24 ^ (l23 ^ arrl6[0] ^ arrl6[9]) ^ arrl6[21] ^ arrl6[23] ^ arrl6[25];
        long l31 = arrl3[0];
        long l32 = arrl3[1];
        long l33 = arrl3[2];
        long l34 = arrl3[3];
        long l35 = arrl3[4];
        long l36 = arrl3[5];
        long l37 = arrl3[6];
        long l38 = arrl3[7];
        long l39 = arrl3[8];
        long l40 = arrl3[9];
        arrl3[0] = l31 ^ l32 << 57;
        arrl3[1] = l32 >>> 7 ^ l33 << 50;
        arrl3[2] = l33 >>> 14 ^ l34 << 43;
        arrl3[3] = l34 >>> 21 ^ l35 << 36;
        arrl3[4] = l35 >>> 28 ^ l36 << 29;
        arrl3[5] = l36 >>> 35 ^ l37 << 22;
        arrl3[6] = l37 >>> 42 ^ l38 << 15;
        arrl3[7] = l38 >>> 49 ^ l39 << 8;
        arrl3[8] = l39 >>> 56 ^ l40 << 1;
        arrl3[9] = l40 >>> 63;
    }

    public static void implMulw(long[] arrl, long l2, long l3, long[] arrl2, int n2) {
        arrl[1] = l3;
        arrl[2] = arrl[1] << 1;
        arrl[3] = l3 ^ arrl[2];
        arrl[4] = arrl[2] << 1;
        arrl[5] = l3 ^ arrl[4];
        arrl[6] = arrl[3] << 1;
        arrl[7] = l3 ^ arrl[6];
        long l4 = arrl[7 & (int)l2];
        long l5 = 0L;
        int n3 = 48;
        do {
            int n4 = (int)(l2 >>> n3);
            long l6 = arrl[n4 & 7] ^ arrl[7 & n4 >>> 3] << 3 ^ arrl[7 & n4 >>> 6] << 6;
            l4 ^= l6 << n3;
            l5 ^= l6 >>> -n3;
        } while ((n3 -= 9) > 0);
        long l7 = l5 ^ (l2 & 72198606942111744L & l3 << 7 >> 63) >>> 8;
        arrl2[n2] = 0x1FFFFFFFFFFFFFFL & l4;
        arrl2[n2 + 1] = l4 >>> 57 ^ l7 << 7;
    }

    public static void implSquare(long[] arrl, long[] arrl2) {
        Interleave.expand64To128(arrl, 0, 4, arrl2, 0);
        arrl2[8] = Interleave.expand32to64((int)arrl[4]);
    }

    public static void multiply(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[10];
        SecT283Field.implMultiply(arrl, arrl2, arrl4);
        SecT283Field.reduce(arrl4, arrl3);
    }

    public static void multiplyAddToExt(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[10];
        SecT283Field.implMultiply(arrl, arrl2, arrl4);
        SecT283Field.addExt(arrl3, arrl4, arrl3);
    }

    public static void reduce(long[] arrl, long[] arrl2) {
        long l2 = arrl[0];
        long l3 = arrl[1];
        long l4 = arrl[2];
        long l5 = arrl[3];
        long l6 = arrl[4];
        long l7 = arrl[5];
        long l8 = arrl[6];
        long l9 = arrl[7];
        long l10 = arrl[8];
        long l11 = l5 ^ (l10 << 37 ^ l10 << 42 ^ l10 << 44 ^ l10 << 49);
        long l12 = l6 ^ (l10 >>> 27 ^ l10 >>> 22 ^ l10 >>> 20 ^ l10 >>> 15);
        long l13 = l4 ^ (l9 << 37 ^ l9 << 42 ^ l9 << 44 ^ l9 << 49);
        long l14 = l11 ^ (l9 >>> 27 ^ l9 >>> 22 ^ l9 >>> 20 ^ l9 >>> 15);
        long l15 = l3 ^ (l8 << 37 ^ l8 << 42 ^ l8 << 44 ^ l8 << 49);
        long l16 = l13 ^ (l8 >>> 27 ^ l8 >>> 22 ^ l8 >>> 20 ^ l8 >>> 15);
        long l17 = l2 ^ (l7 << 37 ^ l7 << 42 ^ l7 << 44 ^ l7 << 49);
        long l18 = l15 ^ (l7 >>> 27 ^ l7 >>> 22 ^ l7 >>> 20 ^ l7 >>> 15);
        long l19 = l12 >>> 27;
        arrl2[0] = l17 ^ l19 ^ l19 << 5 ^ l19 << 7 ^ l19 << 12;
        arrl2[1] = l18;
        arrl2[2] = l16;
        arrl2[3] = l14;
        arrl2[4] = 0x7FFFFFFL & l12;
    }

    public static void square(long[] arrl, long[] arrl2) {
        long[] arrl3 = new long[9];
        SecT283Field.implSquare(arrl, arrl3);
        SecT283Field.reduce(arrl3, arrl2);
    }

    public static void squareN(long[] arrl, int n2, long[] arrl2) {
        long[] arrl3 = new long[9];
        SecT283Field.implSquare(arrl, arrl3);
        do {
            SecT283Field.reduce(arrl3, arrl2);
            if (--n2 <= 0) break;
            SecT283Field.implSquare(arrl2, arrl3);
        } while (true);
    }
}

