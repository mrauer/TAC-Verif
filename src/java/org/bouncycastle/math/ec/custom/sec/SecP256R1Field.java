/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.custom.sec.SecT239Field;

public class SecP256R1Field {
    public static final int[] P = new int[]{-1, -1, -1, 0, 0, 0, 1, -1};
    public static final int[] PExt = new int[]{1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2};

    public static void add(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.add4(arrn, arrn2, arrn3) != 0 || arrn3[7] == -1 && SecT239Field.gte4(arrn3, P)) {
            SecP256R1Field.addPInvTo(arrn3);
        }
    }

    public static void addPInvTo(int[] arrn) {
        long l2 = 1L + (0xFFFFFFFFL & (long)arrn[0]);
        arrn[0] = (int)l2;
        long l3 = l2 >> 32;
        if (l3 != 0L) {
            long l4 = l3 + (0xFFFFFFFFL & (long)arrn[1]);
            arrn[1] = (int)l4;
            long l5 = (l4 >> 32) + (0xFFFFFFFFL & (long)arrn[2]);
            arrn[2] = (int)l5;
            l3 = l5 >> 32;
        }
        long l6 = l3 + ((0xFFFFFFFFL & (long)arrn[3]) - 1L);
        arrn[3] = (int)l6;
        long l7 = l6 >> 32;
        if (l7 != 0L) {
            long l8 = l7 + (0xFFFFFFFFL & (long)arrn[4]);
            arrn[4] = (int)l8;
            long l9 = (l8 >> 32) + (0xFFFFFFFFL & (long)arrn[5]);
            arrn[5] = (int)l9;
            l7 = l9 >> 32;
        }
        long l10 = l7 + ((0xFFFFFFFFL & (long)arrn[6]) - 1L);
        arrn[6] = (int)l10;
        arrn[7] = (int)((l10 >> 32) + (1L + (0xFFFFFFFFL & (long)arrn[7])));
    }

    public static int isZero(int[] arrn) {
        int n2 = 0;
        for (int i2 = 0; i2 < 8; ++i2) {
            n2 |= arrn[i2];
        }
        return -1 + (n2 >>> 1 | n2 & 1) >> 31;
    }

    public static void multiply(int[] arrn, int[] arrn2, int[] arrn3) {
        int[] arrn4 = new int[16];
        SecT239Field.mul4(arrn, arrn2, arrn4);
        SecP256R1Field.reduce(arrn4, arrn3);
    }

    public static void reduce(int[] arrn, int[] arrn2) {
        long l2 = 0xFFFFFFFFL & (long)arrn[8];
        long l3 = 0xFFFFFFFFL & (long)arrn[9];
        long l4 = 0xFFFFFFFFL & (long)arrn[10];
        long l5 = 0xFFFFFFFFL & (long)arrn[11];
        long l6 = 0xFFFFFFFFL & (long)arrn[12];
        long l7 = 0xFFFFFFFFL & (long)arrn[13];
        long l8 = 0xFFFFFFFFL & (long)arrn[14];
        long l9 = 0xFFFFFFFFL & (long)arrn[15];
        long l10 = l2 - 6L;
        long l11 = l10 + l3;
        long l12 = l3 + l4;
        long l13 = l4 + l5 - l9;
        long l14 = l5 + l6;
        long l15 = l6 + l7;
        long l16 = l7 + l8;
        long l17 = l8 + l9;
        long l18 = l16 - l11;
        long l19 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) - l14 - l18);
        arrn2[0] = (int)l19;
        long l20 = (l19 >> 32) + (l12 + (0xFFFFFFFFL & (long)arrn[1]) - l15 - l17);
        arrn2[1] = (int)l20;
        long l21 = (l20 >> 32) + (l13 + (0xFFFFFFFFL & (long)arrn[2]) - l16);
        arrn2[2] = (int)l21;
        long l22 = (l21 >> 32) + (l18 + ((0xFFFFFFFFL & (long)arrn[3]) + (l14 << 1)) - l17);
        arrn2[3] = (int)l22;
        long l23 = (l22 >> 32) + (l8 + ((0xFFFFFFFFL & (long)arrn[4]) + (l15 << 1)) - l12);
        arrn2[4] = (int)l23;
        long l24 = (l23 >> 32) + ((0xFFFFFFFFL & (long)arrn[5]) + (l16 << 1) - l13);
        arrn2[5] = (int)l24;
        long l25 = (l24 >> 32) + (l18 + ((0xFFFFFFFFL & (long)arrn[6]) + (l17 << 1)));
        arrn2[6] = (int)l25;
        long l26 = (l25 >> 32) + (l10 + ((0xFFFFFFFFL & (long)arrn[7]) + (l9 << 1)) - l13 - l15);
        arrn2[7] = (int)l26;
        SecP256R1Field.reduce32((int)(6L + (l26 >> 32)), arrn2);
    }

    public static void reduce32(int n2, int[] arrn) {
        long l2;
        if (n2 != 0) {
            long l3 = 0xFFFFFFFFL & (long)n2;
            long l4 = 0L + (l3 + (0xFFFFFFFFL & (long)arrn[0]));
            arrn[0] = (int)l4;
            long l5 = l4 >> 32;
            if (l5 != 0L) {
                long l6 = l5 + (0xFFFFFFFFL & (long)arrn[1]);
                arrn[1] = (int)l6;
                long l7 = (l6 >> 32) + (0xFFFFFFFFL & (long)arrn[2]);
                arrn[2] = (int)l7;
                l5 = l7 >> 32;
            }
            long l8 = l5 + ((0xFFFFFFFFL & (long)arrn[3]) - l3);
            arrn[3] = (int)l8;
            long l9 = l8 >> 32;
            if (l9 != 0L) {
                long l10 = l9 + (0xFFFFFFFFL & (long)arrn[4]);
                arrn[4] = (int)l10;
                long l11 = (l10 >> 32) + (0xFFFFFFFFL & (long)arrn[5]);
                arrn[5] = (int)l11;
                l9 = l11 >> 32;
            }
            long l12 = l9 + ((0xFFFFFFFFL & (long)arrn[6]) - l3);
            arrn[6] = (int)l12;
            long l13 = (l12 >> 32) + (l3 + (0xFFFFFFFFL & (long)arrn[7]));
            arrn[7] = (int)l13;
            l2 = l13 >> 32;
        } else {
            l2 = 0L;
        }
        if (l2 != 0L || arrn[7] == -1 && SecT239Field.gte4(arrn, P)) {
            SecP256R1Field.addPInvTo(arrn);
        }
    }

    public static void square(int[] arrn, int[] arrn2) {
        int[] arrn3 = new int[16];
        SecT239Field.square4(arrn, arrn3);
        SecP256R1Field.reduce(arrn3, arrn2);
    }

    public static void squareN(int[] arrn, int n2, int[] arrn2) {
        int[] arrn3 = new int[16];
        SecT239Field.square4(arrn, arrn3);
        do {
            SecP256R1Field.reduce(arrn3, arrn2);
            if (--n2 <= 0) break;
            SecT239Field.square4(arrn2, arrn3);
        } while (true);
    }

    public static void subtract(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.sub4(arrn, arrn2, arrn3) != 0) {
            long l2 = (0xFFFFFFFFL & (long)arrn3[0]) - 1L;
            arrn3[0] = (int)l2;
            long l3 = l2 >> 32;
            if (l3 != 0L) {
                long l4 = l3 + (0xFFFFFFFFL & (long)arrn3[1]);
                arrn3[1] = (int)l4;
                long l5 = (l4 >> 32) + (0xFFFFFFFFL & (long)arrn3[2]);
                arrn3[2] = (int)l5;
                l3 = l5 >> 32;
            }
            long l6 = l3 + (1L + (0xFFFFFFFFL & (long)arrn3[3]));
            arrn3[3] = (int)l6;
            long l7 = l6 >> 32;
            if (l7 != 0L) {
                long l8 = l7 + (0xFFFFFFFFL & (long)arrn3[4]);
                arrn3[4] = (int)l8;
                long l9 = (l8 >> 32) + (0xFFFFFFFFL & (long)arrn3[5]);
                arrn3[5] = (int)l9;
                l7 = l9 >> 32;
            }
            long l10 = l7 + (1L + (0xFFFFFFFFL & (long)arrn3[6]));
            arrn3[6] = (int)l10;
            arrn3[7] = (int)((l10 >> 32) + ((0xFFFFFFFFL & (long)arrn3[7]) - 1L));
        }
    }
}

