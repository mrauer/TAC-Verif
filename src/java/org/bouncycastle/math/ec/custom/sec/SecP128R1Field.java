/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.custom.sec.SecT239Field;

public class SecP128R1Field {
    public static final int[] P = new int[]{-1, -1, -1, -3};
    public static final int[] PExt = new int[]{1, 0, 0, 4, -2, -1, 3, -4};
    public static final int[] PExtInv = new int[]{-1, -1, -1, -5, 1, 0, -4, 3};

    public static void add(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) + (0xFFFFFFFFL & (long)arrn2[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >>> 32) + ((0xFFFFFFFFL & (long)arrn[1]) + (0xFFFFFFFFL & (long)arrn2[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >>> 32) + ((0xFFFFFFFFL & (long)arrn[2]) + (0xFFFFFFFFL & (long)arrn2[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >>> 32) + ((0xFFFFFFFFL & (long)arrn[3]) + (0xFFFFFFFFL & (long)arrn2[3]));
        arrn3[3] = (int)l5;
        if ((int)(l5 >>> 32) != 0 || arrn3[3] >>> 1 >= 2147483646 && SecT239Field.gte(arrn3, P)) {
            SecP128R1Field.addPInvTo(arrn3);
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
        arrn[3] = (int)(l3 + (2L + (0xFFFFFFFFL & (long)arrn[3])));
    }

    public static int isZero(int[] arrn) {
        int n2 = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            n2 |= arrn[i2];
        }
        return -1 + (n2 >>> 1 | n2 & 1) >> 31;
    }

    public static void multiply(int[] arrn, int[] arrn2, int[] arrn3) {
        int[] arrn4 = new int[8];
        SecT239Field.mul(arrn, arrn2, arrn4);
        SecP128R1Field.reduce(arrn4, arrn3);
    }

    public static void reduce(int[] arrn, int[] arrn2) {
        long l2 = 0xFFFFFFFFL & (long)arrn[0];
        long l3 = 0xFFFFFFFFL & (long)arrn[1];
        long l4 = 0xFFFFFFFFL & (long)arrn[2];
        long l5 = 0xFFFFFFFFL & (long)arrn[3];
        long l6 = 0xFFFFFFFFL & (long)arrn[4];
        long l7 = 0xFFFFFFFFL & (long)arrn[5];
        long l8 = 0xFFFFFFFFL & (long)arrn[6];
        long l9 = 0xFFFFFFFFL & (long)arrn[7];
        long l10 = l5 + l9;
        long l11 = l8 + (l9 << 1);
        long l12 = l4 + l11;
        long l13 = l7 + (l11 << 1);
        long l14 = l3 + l13;
        long l15 = l6 + (l13 << 1);
        long l16 = l2 + l15;
        long l17 = l10 + (l15 << 1);
        arrn2[0] = (int)l16;
        long l18 = l14 + (l16 >>> 32);
        arrn2[1] = (int)l18;
        long l19 = l12 + (l18 >>> 32);
        arrn2[2] = (int)l19;
        long l20 = l17 + (l19 >>> 32);
        arrn2[3] = (int)l20;
        SecP128R1Field.reduce32((int)(l20 >>> 32), arrn2);
    }

    public static void reduce32(int n2, int[] arrn) {
        while (n2 != 0) {
            long l2 = 0xFFFFFFFFL & (long)n2;
            long l3 = l2 + (0xFFFFFFFFL & (long)arrn[0]);
            arrn[0] = (int)l3;
            long l4 = l3 >> 32;
            if (l4 != 0L) {
                long l5 = l4 + (0xFFFFFFFFL & (long)arrn[1]);
                arrn[1] = (int)l5;
                long l6 = (l5 >> 32) + (0xFFFFFFFFL & (long)arrn[2]);
                arrn[2] = (int)l6;
                l4 = l6 >> 32;
            }
            long l7 = l4 + ((0xFFFFFFFFL & (long)arrn[3]) + (l2 << 1));
            arrn[3] = (int)l7;
            n2 = (int)(l7 >> 32);
        }
        if (arrn[3] >>> 1 >= 2147483646 && SecT239Field.gte(arrn, P)) {
            SecP128R1Field.addPInvTo(arrn);
        }
    }

    public static void square(int[] arrn, int[] arrn2) {
        int[] arrn3 = new int[8];
        SecT239Field.square(arrn, arrn3);
        SecP128R1Field.reduce(arrn3, arrn2);
    }

    public static void squareN(int[] arrn, int n2, int[] arrn2) {
        int[] arrn3 = new int[8];
        SecT239Field.square(arrn, arrn3);
        do {
            SecP128R1Field.reduce(arrn3, arrn2);
            if (--n2 <= 0) break;
            SecT239Field.square(arrn2, arrn3);
        } while (true);
    }

    public static void subtract(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.sub(arrn, arrn2, arrn3) != 0) {
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
            arrn3[3] = (int)(l3 + ((0xFFFFFFFFL & (long)arrn3[3]) - 2L));
        }
    }
}

