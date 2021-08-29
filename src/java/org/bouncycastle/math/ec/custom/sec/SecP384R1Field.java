/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat576;

public class SecP384R1Field {
    public static final int[] P = new int[]{-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};
    public static final int[] PExt = new int[]{1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};
    public static final int[] PExtInv = new int[]{-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    public static void add(int[] arrn, int[] arrn2, int[] arrn3) {
        if (Nat576.add(12, arrn, arrn2, arrn3) != 0 || arrn3[11] == -1 && Nat576.gte(12, arrn3, P)) {
            SecP384R1Field.addPInvTo(arrn3);
        }
    }

    public static void addPInvTo(int[] arrn) {
        long l2 = 1L + (0xFFFFFFFFL & (long)arrn[0]);
        arrn[0] = (int)l2;
        long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn[1]) - 1L);
        arrn[1] = (int)l3;
        long l4 = l3 >> 32;
        if (l4 != 0L) {
            long l5 = l4 + (0xFFFFFFFFL & (long)arrn[2]);
            arrn[2] = (int)l5;
            l4 = l5 >> 32;
        }
        long l6 = l4 + (1L + (0xFFFFFFFFL & (long)arrn[3]));
        arrn[3] = (int)l6;
        long l7 = (l6 >> 32) + (1L + (0xFFFFFFFFL & (long)arrn[4]));
        arrn[4] = (int)l7;
        if (l7 >> 32 != 0L) {
            Nat576.incAt(12, arrn, 5);
        }
    }

    public static int isZero(int[] arrn) {
        int n2 = 0;
        for (int i2 = 0; i2 < 12; ++i2) {
            n2 |= arrn[i2];
        }
        return -1 + (n2 >>> 1 | n2 & 1) >> 31;
    }

    public static void multiply(int[] arrn, int[] arrn2, int[] arrn3) {
        int[] arrn4 = new int[24];
        Interleave.mul(arrn, arrn2, arrn4);
        SecP384R1Field.reduce(arrn4, arrn3);
    }

    public static void reduce(int[] arrn, int[] arrn2) {
        long l2 = 0xFFFFFFFFL & (long)arrn[16];
        long l3 = 0xFFFFFFFFL & (long)arrn[17];
        long l4 = 0xFFFFFFFFL & (long)arrn[18];
        long l5 = 0xFFFFFFFFL & (long)arrn[19];
        long l6 = 0xFFFFFFFFL & (long)arrn[20];
        long l7 = 0xFFFFFFFFL & (long)arrn[21];
        long l8 = 0xFFFFFFFFL & (long)arrn[22];
        long l9 = 0xFFFFFFFFL & (long)arrn[23];
        long l10 = l6 + (0xFFFFFFFFL & (long)arrn[12]) - 1L;
        long l11 = l8 + (0xFFFFFFFFL & (long)arrn[13]);
        long l12 = l9 + (l8 + (0xFFFFFFFFL & (long)arrn[14]));
        long l13 = l9 + (0xFFFFFFFFL & (long)arrn[15]);
        long l14 = l3 + l7;
        long l15 = l7 - l9;
        long l16 = l8 - l9;
        long l17 = l10 + l15;
        long l18 = 0L + (l17 + (0xFFFFFFFFL & (long)arrn[0]));
        arrn2[0] = (int)l18;
        long l19 = (l18 >> 32) + (l11 + (l9 + (0xFFFFFFFFL & (long)arrn[1]) - l10));
        arrn2[1] = (int)l19;
        long l20 = (l19 >> 32) + (l12 + ((0xFFFFFFFFL & (long)arrn[2]) - l7 - l11));
        arrn2[2] = (int)l20;
        long l21 = (l20 >> 32) + (l17 + (l13 + ((0xFFFFFFFFL & (long)arrn[3]) - l12)));
        arrn2[3] = (int)l21;
        long l22 = (l21 >> 32) + (l17 + (l11 + (l7 + (l2 + (0xFFFFFFFFL & (long)arrn[4]))) - l13));
        arrn2[4] = (int)l22;
        long l23 = (l22 >> 32) + (l14 + (l12 + (l11 + ((0xFFFFFFFFL & (long)arrn[5]) - l2))));
        arrn2[5] = (int)l23;
        long l24 = (l23 >> 32) + (l13 + (l12 + (l4 + (0xFFFFFFFFL & (long)arrn[6]) - l3)));
        arrn2[6] = (int)l24;
        long l25 = (l24 >> 32) + (l13 + (l5 + (l2 + (0xFFFFFFFFL & (long)arrn[7])) - l4));
        arrn2[7] = (int)l25;
        long l26 = (l25 >> 32) + (l6 + (l3 + (l2 + (0xFFFFFFFFL & (long)arrn[8]))) - l5);
        arrn2[8] = (int)l26;
        long l27 = (l26 >> 32) + (l14 + (l4 + (0xFFFFFFFFL & (long)arrn[9]) - l6));
        arrn2[9] = (int)l27;
        long l28 = (l27 >> 32) + (l16 + (l5 + (l4 + (0xFFFFFFFFL & (long)arrn[10])) - l15));
        arrn2[10] = (int)l28;
        long l29 = (l28 >> 32) + (l6 + (l5 + (0xFFFFFFFFL & (long)arrn[11])) - l16);
        arrn2[11] = (int)l29;
        SecP384R1Field.reduce32((int)(1L + (l29 >> 32)), arrn2);
    }

    public static void reduce32(int n2, int[] arrn) {
        long l2;
        if (n2 != 0) {
            long l3 = 0xFFFFFFFFL & (long)n2;
            long l4 = 0L + (l3 + (0xFFFFFFFFL & (long)arrn[0]));
            arrn[0] = (int)l4;
            long l5 = (l4 >> 32) + ((0xFFFFFFFFL & (long)arrn[1]) - l3);
            arrn[1] = (int)l5;
            long l6 = l5 >> 32;
            if (l6 != 0L) {
                long l7 = l6 + (0xFFFFFFFFL & (long)arrn[2]);
                arrn[2] = (int)l7;
                l6 = l7 >> 32;
            }
            long l8 = l6 + (l3 + (0xFFFFFFFFL & (long)arrn[3]));
            arrn[3] = (int)l8;
            long l9 = (l8 >> 32) + (l3 + (0xFFFFFFFFL & (long)arrn[4]));
            arrn[4] = (int)l9;
            l2 = l9 >> 32;
        } else {
            l2 = 0L;
        }
        if (l2 != 0L && Nat576.incAt(12, arrn, 5) != 0 || arrn[11] == -1 && Nat576.gte(12, arrn, P)) {
            SecP384R1Field.addPInvTo(arrn);
        }
    }

    public static void square(int[] arrn, int[] arrn2) {
        int[] arrn3 = new int[24];
        Interleave.square(arrn, arrn3);
        SecP384R1Field.reduce(arrn3, arrn2);
    }

    public static void squareN(int[] arrn, int n2, int[] arrn2) {
        int[] arrn3 = new int[24];
        Interleave.square(arrn, arrn3);
        do {
            SecP384R1Field.reduce(arrn3, arrn2);
            if (--n2 <= 0) break;
            Interleave.square(arrn2, arrn3);
        } while (true);
    }

    public static void subtract(int[] arrn, int[] arrn2, int[] arrn3) {
        if (Nat576.sub(12, arrn, arrn2, arrn3) != 0) {
            long l2 = (0xFFFFFFFFL & (long)arrn3[0]) - 1L;
            arrn3[0] = (int)l2;
            long l3 = (l2 >> 32) + (1L + (0xFFFFFFFFL & (long)arrn3[1]));
            arrn3[1] = (int)l3;
            long l4 = l3 >> 32;
            if (l4 != 0L) {
                long l5 = l4 + (0xFFFFFFFFL & (long)arrn3[2]);
                arrn3[2] = (int)l5;
                l4 = l5 >> 32;
            }
            long l6 = l4 + ((0xFFFFFFFFL & (long)arrn3[3]) - 1L);
            arrn3[3] = (int)l6;
            long l7 = (l6 >> 32) + ((0xFFFFFFFFL & (long)arrn3[4]) - 1L);
            arrn3[4] = (int)l7;
            if (l7 >> 32 != 0L) {
                Nat576.decAt(12, arrn3, 5);
            }
        }
    }
}

