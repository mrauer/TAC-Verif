/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP224R1Field {
    public static final int[] P = new int[]{1, 0, 0, -1, -1, -1, -1};
    public static final int[] PExt = new int[]{1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};
    public static final int[] PExtInv = new int[]{-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};

    public static void add(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.add3(arrn, arrn2, arrn3) != 0 || arrn3[6] == -1 && SecT239Field.gte3(arrn3, P)) {
            SecP224R1Field.addPInvTo(arrn3);
        }
    }

    public static void addOne(int[] arrn, int[] arrn2) {
        if (Nat576.inc(7, arrn, arrn2) != 0 || arrn2[6] == -1 && SecT239Field.gte3(arrn2, P)) {
            SecP224R1Field.addPInvTo(arrn2);
        }
    }

    public static void addPInvTo(int[] arrn) {
        long l2 = (0xFFFFFFFFL & (long)arrn[0]) - 1L;
        arrn[0] = (int)l2;
        long l3 = l2 >> 32;
        if (l3 != 0L) {
            long l4 = l3 + (0xFFFFFFFFL & (long)arrn[1]);
            arrn[1] = (int)l4;
            long l5 = (l4 >> 32) + (0xFFFFFFFFL & (long)arrn[2]);
            arrn[2] = (int)l5;
            l3 = l5 >> 32;
        }
        long l6 = l3 + (1L + (0xFFFFFFFFL & (long)arrn[3]));
        arrn[3] = (int)l6;
        if (l6 >> 32 != 0L) {
            Nat576.incAt(7, arrn, 4);
        }
    }

    public static int isZero(int[] arrn) {
        int n2 = 0;
        for (int i2 = 0; i2 < 7; ++i2) {
            n2 |= arrn[i2];
        }
        return -1 + (n2 >>> 1 | n2 & 1) >> 31;
    }

    public static void multiply(int[] arrn, int[] arrn2, int[] arrn3) {
        int[] arrn4 = new int[14];
        SecT239Field.mul3(arrn, arrn2, arrn4);
        SecP224R1Field.reduce(arrn4, arrn3);
    }

    public static void negate(int[] arrn, int[] arrn2) {
        if (SecP224R1Field.isZero(arrn) != 0) {
            int[] arrn3 = P;
            SecT239Field.sub3(arrn3, arrn3, arrn2);
            return;
        }
        SecT239Field.sub3(P, arrn, arrn2);
    }

    public static void reduce(int[] arrn, int[] arrn2) {
        long l2 = 0xFFFFFFFFL & (long)arrn[10];
        long l3 = 0xFFFFFFFFL & (long)arrn[11];
        long l4 = 0xFFFFFFFFL & (long)arrn[12];
        long l5 = 0xFFFFFFFFL & (long)arrn[13];
        long l6 = l3 + (0xFFFFFFFFL & (long)arrn[7]) - 1L;
        long l7 = l4 + (0xFFFFFFFFL & (long)arrn[8]);
        long l8 = l5 + (0xFFFFFFFFL & (long)arrn[9]);
        long l9 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) - l6);
        long l10 = l9 & 0xFFFFFFFFL;
        long l11 = (l9 >> 32) + ((0xFFFFFFFFL & (long)arrn[1]) - l7);
        arrn2[1] = (int)l11;
        long l12 = (l11 >> 32) + ((0xFFFFFFFFL & (long)arrn[2]) - l8);
        arrn2[2] = (int)l12;
        long l13 = (l12 >> 32) + (l6 + (0xFFFFFFFFL & (long)arrn[3]) - l2);
        long l14 = l13 & 0xFFFFFFFFL;
        long l15 = (l13 >> 32) + (l7 + (0xFFFFFFFFL & (long)arrn[4]) - l3);
        arrn2[4] = (int)l15;
        long l16 = (l15 >> 32) + (l8 + (0xFFFFFFFFL & (long)arrn[5]) - l4);
        arrn2[5] = (int)l16;
        long l17 = (l16 >> 32) + (l2 + (0xFFFFFFFFL & (long)arrn[6]) - l5);
        arrn2[6] = (int)l17;
        long l18 = 1L + (l17 >> 32);
        long l19 = l14 + l18;
        long l20 = l10 - l18;
        arrn2[0] = (int)l20;
        long l21 = l20 >> 32;
        if (l21 != 0L) {
            long l22 = l21 + (0xFFFFFFFFL & (long)arrn2[1]);
            arrn2[1] = (int)l22;
            long l23 = (l22 >> 32) + (0xFFFFFFFFL & (long)arrn2[2]);
            arrn2[2] = (int)l23;
            l19 += l23 >> 32;
        }
        arrn2[3] = (int)l19;
        if (l19 >> 32 != 0L && Nat576.incAt(7, arrn2, 4) != 0 || arrn2[6] == -1 && SecT239Field.gte3(arrn2, P)) {
            SecP224R1Field.addPInvTo(arrn2);
        }
    }

    public static void reduce32(int n2, int[] arrn) {
        long l2;
        if (n2 != 0) {
            long l3 = 0xFFFFFFFFL & (long)n2;
            long l4 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) - l3);
            arrn[0] = (int)l4;
            long l5 = l4 >> 32;
            if (l5 != 0L) {
                long l6 = l5 + (0xFFFFFFFFL & (long)arrn[1]);
                arrn[1] = (int)l6;
                long l7 = (l6 >> 32) + (0xFFFFFFFFL & (long)arrn[2]);
                arrn[2] = (int)l7;
                l5 = l7 >> 32;
            }
            long l8 = l5 + (l3 + (0xFFFFFFFFL & (long)arrn[3]));
            arrn[3] = (int)l8;
            l2 = l8 >> 32;
        } else {
            l2 = 0L;
        }
        if (l2 != 0L && Nat576.incAt(7, arrn, 4) != 0 || arrn[6] == -1 && SecT239Field.gte3(arrn, P)) {
            SecP224R1Field.addPInvTo(arrn);
        }
    }

    public static void square(int[] arrn, int[] arrn2) {
        int[] arrn3 = new int[14];
        SecT239Field.square3(arrn, arrn3);
        SecP224R1Field.reduce(arrn3, arrn2);
    }

    public static void subtract(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.sub3(arrn, arrn2, arrn3) != 0) {
            long l2 = 1L + (0xFFFFFFFFL & (long)arrn3[0]);
            arrn3[0] = (int)l2;
            long l3 = l2 >> 32;
            if (l3 != 0L) {
                long l4 = l3 + (0xFFFFFFFFL & (long)arrn3[1]);
                arrn3[1] = (int)l4;
                long l5 = (l4 >> 32) + (0xFFFFFFFFL & (long)arrn3[2]);
                arrn3[2] = (int)l5;
                l3 = l5 >> 32;
            }
            long l6 = l3 + ((0xFFFFFFFFL & (long)arrn3[3]) - 1L);
            arrn3[3] = (int)l6;
            if (l6 >> 32 != 0L) {
                Nat576.decAt(7, arrn3, 4);
            }
        }
    }

    public static void twice(int[] arrn, int[] arrn2) {
        if (Nat576.shiftUpBit(7, arrn, 0, arrn2) != 0 || arrn2[6] == -1 && SecT239Field.gte3(arrn2, P)) {
            SecP224R1Field.addPInvTo(arrn2);
        }
    }
}

