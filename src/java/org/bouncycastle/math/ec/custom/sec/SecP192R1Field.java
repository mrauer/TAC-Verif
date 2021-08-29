/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP192R1Field {
    public static final int[] P = new int[]{-1, -1, -2, -1, -1, -1};
    public static final int[] PExt = new int[]{1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};
    public static final int[] PExtInv = new int[]{-1, -1, -3, -1, -2, -1, 1, 0, 2};

    public static void add(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.add2(arrn, arrn2, arrn3) != 0 || arrn3[5] == -1 && SecT239Field.gte2(arrn3, P)) {
            SecP192R1Field.addPInvTo(arrn3);
        }
    }

    public static void addPInvTo(int[] arrn) {
        long l2 = 1L + (0xFFFFFFFFL & (long)arrn[0]);
        arrn[0] = (int)l2;
        long l3 = l2 >> 32;
        if (l3 != 0L) {
            long l4 = l3 + (0xFFFFFFFFL & (long)arrn[1]);
            arrn[1] = (int)l4;
            l3 = l4 >> 32;
        }
        long l5 = l3 + (1L + (0xFFFFFFFFL & (long)arrn[2]));
        arrn[2] = (int)l5;
        if (l5 >> 32 != 0L) {
            Nat576.incAt(6, arrn, 3);
        }
    }

    public static int isZero(int[] arrn) {
        int n2 = 0;
        for (int i2 = 0; i2 < 6; ++i2) {
            n2 |= arrn[i2];
        }
        return -1 + (n2 >>> 1 | n2 & 1) >> 31;
    }

    public static void multiply(int[] arrn, int[] arrn2, int[] arrn3) {
        int[] arrn4 = new int[12];
        SecT239Field.mul2(arrn, arrn2, arrn4);
        SecP192R1Field.reduce(arrn4, arrn3);
    }

    public static void reduce(int[] arrn, int[] arrn2) {
        long l2 = 0xFFFFFFFFL & (long)arrn[6];
        long l3 = 0xFFFFFFFFL & (long)arrn[7];
        long l4 = 0xFFFFFFFFL & (long)arrn[8];
        long l5 = 0xFFFFFFFFL & (long)arrn[9];
        long l6 = 0xFFFFFFFFL & (long)arrn[10];
        long l7 = 0xFFFFFFFFL & (long)arrn[11];
        long l8 = l6 + l2;
        long l9 = l7 + l3;
        long l10 = 0L + (l8 + (0xFFFFFFFFL & (long)arrn[0]));
        int n2 = (int)l10;
        long l11 = (l10 >> 32) + (l9 + (0xFFFFFFFFL & (long)arrn[1]));
        arrn2[1] = (int)l11;
        long l12 = l11 >> 32;
        long l13 = l8 + l4;
        long l14 = l9 + l5;
        long l15 = l12 + (l13 + (0xFFFFFFFFL & (long)arrn[2]));
        long l16 = l15 & 0xFFFFFFFFL;
        long l17 = (l15 >> 32) + (l14 + (0xFFFFFFFFL & (long)arrn[3]));
        arrn2[3] = (int)l17;
        long l18 = l17 >> 32;
        long l19 = l13 - l2;
        long l20 = l14 - l3;
        long l21 = l18 + (l19 + (0xFFFFFFFFL & (long)arrn[4]));
        arrn2[4] = (int)l21;
        long l22 = (l21 >> 32) + (l20 + (0xFFFFFFFFL & (long)arrn[5]));
        arrn2[5] = (int)l22;
        long l23 = l22 >> 32;
        long l24 = l16 + l23;
        long l25 = l23 + (0xFFFFFFFFL & (long)n2);
        arrn2[0] = (int)l25;
        long l26 = l25 >> 32;
        if (l26 != 0L) {
            long l27 = l26 + (0xFFFFFFFFL & (long)arrn2[1]);
            arrn2[1] = (int)l27;
            l24 += l27 >> 32;
        }
        arrn2[2] = (int)l24;
        if (l24 >> 32 != 0L && Nat576.incAt(6, arrn2, 3) != 0 || arrn2[5] == -1 && SecT239Field.gte2(arrn2, P)) {
            SecP192R1Field.addPInvTo(arrn2);
        }
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
                l5 = l6 >> 32;
            }
            long l7 = l5 + (l3 + (0xFFFFFFFFL & (long)arrn[2]));
            arrn[2] = (int)l7;
            l2 = l7 >> 32;
        } else {
            l2 = 0L;
        }
        if (l2 != 0L && Nat576.incAt(6, arrn, 3) != 0 || arrn[5] == -1 && SecT239Field.gte2(arrn, P)) {
            SecP192R1Field.addPInvTo(arrn);
        }
    }

    public static void square(int[] arrn, int[] arrn2) {
        int[] arrn3 = new int[12];
        SecT239Field.square2(arrn, arrn3);
        SecP192R1Field.reduce(arrn3, arrn2);
    }

    public static void squareN(int[] arrn, int n2, int[] arrn2) {
        int[] arrn3 = new int[12];
        SecT239Field.square2(arrn, arrn3);
        do {
            SecP192R1Field.reduce(arrn3, arrn2);
            if (--n2 <= 0) break;
            SecT239Field.square2(arrn2, arrn3);
        } while (true);
    }

    public static void subtract(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.sub2(arrn, arrn2, arrn3) != 0) {
            long l2 = (0xFFFFFFFFL & (long)arrn3[0]) - 1L;
            arrn3[0] = (int)l2;
            long l3 = l2 >> 32;
            if (l3 != 0L) {
                long l4 = l3 + (0xFFFFFFFFL & (long)arrn3[1]);
                arrn3[1] = (int)l4;
                l3 = l4 >> 32;
            }
            long l5 = l3 + ((0xFFFFFFFFL & (long)arrn3[2]) - 1L);
            arrn3[2] = (int)l5;
            if (l5 >> 32 != 0L) {
                Nat576.decAt(6, arrn3, 3);
            }
        }
    }
}

