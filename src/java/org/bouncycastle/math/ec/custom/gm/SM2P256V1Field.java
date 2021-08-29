/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec.custom.gm;

import org.bouncycastle.math.ec.custom.sec.SecT239Field;

public class SM2P256V1Field {
    public static final int[] P = new int[]{-1, -1, 0, -1, -1, -1, -1, -2};
    public static final int[] PExt = new int[]{1, 0, -2, 1, 1, -2, 0, 2, -2, -3, 3, -2, -1, -1, 0, -2};

    public static void add(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.add4(arrn, arrn2, arrn3) != 0 || arrn3[7] >>> 1 >= Integer.MAX_VALUE && SecT239Field.gte4(arrn3, P)) {
            SM2P256V1Field.addPInvTo(arrn3);
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
        long l5 = l3 + ((0xFFFFFFFFL & (long)arrn[2]) - 1L);
        arrn[2] = (int)l5;
        long l6 = (l5 >> 32) + (1L + (0xFFFFFFFFL & (long)arrn[3]));
        arrn[3] = (int)l6;
        long l7 = l6 >> 32;
        if (l7 != 0L) {
            long l8 = l7 + (0xFFFFFFFFL & (long)arrn[4]);
            arrn[4] = (int)l8;
            long l9 = (l8 >> 32) + (0xFFFFFFFFL & (long)arrn[5]);
            arrn[5] = (int)l9;
            long l10 = (l9 >> 32) + (0xFFFFFFFFL & (long)arrn[6]);
            arrn[6] = (int)l10;
            l7 = l10 >> 32;
        }
        arrn[7] = (int)(l7 + (1L + (0xFFFFFFFFL & (long)arrn[7])));
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
        SM2P256V1Field.reduce(arrn4, arrn3);
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
        long l10 = l2 + l3;
        long l11 = l4 + l5;
        long l12 = l6 + l9;
        long l13 = l7 + l8;
        long l14 = l13 + (l9 << 1);
        long l15 = l10 + l13;
        long l16 = l15 + (l11 + l12);
        long l17 = 0L + (l9 + (l8 + (l7 + (l16 + (0xFFFFFFFFL & (long)arrn[0])))));
        arrn2[0] = (int)l17;
        long l18 = (l17 >> 32) + (l9 + (l8 + (l16 + (0xFFFFFFFFL & (long)arrn[1]) - l2)));
        arrn2[1] = (int)l18;
        long l19 = (l18 >> 32) + ((0xFFFFFFFFL & (long)arrn[2]) - l15);
        arrn2[2] = (int)l19;
        long l20 = (l19 >> 32) + (l7 + (l16 + (0xFFFFFFFFL & (long)arrn[3]) - l3 - l4));
        arrn2[3] = (int)l20;
        long l21 = (l20 >> 32) + (l8 + (l16 + (0xFFFFFFFFL & (long)arrn[4]) - l11 - l2));
        arrn2[4] = (int)l21;
        long l22 = (l21 >> 32) + (l4 + (l14 + (0xFFFFFFFFL & (long)arrn[5])));
        arrn2[5] = (int)l22;
        long l23 = (l22 >> 32) + (l9 + (l8 + (l5 + (0xFFFFFFFFL & (long)arrn[6]))));
        arrn2[6] = (int)l23;
        long l24 = (l23 >> 32) + (l6 + (l14 + (l16 + (0xFFFFFFFFL & (long)arrn[7]))));
        arrn2[7] = (int)l24;
        SM2P256V1Field.reduce32((int)(l24 >> 32), arrn2);
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
            long l7 = l5 + ((0xFFFFFFFFL & (long)arrn[2]) - l3);
            arrn[2] = (int)l7;
            long l8 = (l7 >> 32) + (l3 + (0xFFFFFFFFL & (long)arrn[3]));
            arrn[3] = (int)l8;
            long l9 = l8 >> 32;
            if (l9 != 0L) {
                long l10 = l9 + (0xFFFFFFFFL & (long)arrn[4]);
                arrn[4] = (int)l10;
                long l11 = (l10 >> 32) + (0xFFFFFFFFL & (long)arrn[5]);
                arrn[5] = (int)l11;
                long l12 = (l11 >> 32) + (0xFFFFFFFFL & (long)arrn[6]);
                arrn[6] = (int)l12;
                l9 = l12 >> 32;
            }
            long l13 = l9 + (l3 + (0xFFFFFFFFL & (long)arrn[7]));
            arrn[7] = (int)l13;
            l2 = l13 >> 32;
        } else {
            l2 = 0L;
        }
        if (l2 != 0L || arrn[7] >>> 1 >= Integer.MAX_VALUE && SecT239Field.gte4(arrn, P)) {
            SM2P256V1Field.addPInvTo(arrn);
        }
    }

    public static void square(int[] arrn, int[] arrn2) {
        int[] arrn3 = new int[16];
        SecT239Field.square4(arrn, arrn3);
        SM2P256V1Field.reduce(arrn3, arrn2);
    }

    public static void squareN(int[] arrn, int n2, int[] arrn2) {
        int[] arrn3 = new int[16];
        SecT239Field.square4(arrn, arrn3);
        do {
            SM2P256V1Field.reduce(arrn3, arrn2);
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
                l3 = l4 >> 32;
            }
            long l5 = l3 + (1L + (0xFFFFFFFFL & (long)arrn3[2]));
            arrn3[2] = (int)l5;
            long l6 = (l5 >> 32) + ((0xFFFFFFFFL & (long)arrn3[3]) - 1L);
            arrn3[3] = (int)l6;
            long l7 = l6 >> 32;
            if (l7 != 0L) {
                long l8 = l7 + (0xFFFFFFFFL & (long)arrn3[4]);
                arrn3[4] = (int)l8;
                long l9 = (l8 >> 32) + (0xFFFFFFFFL & (long)arrn3[5]);
                arrn3[5] = (int)l9;
                long l10 = (l9 >> 32) + (0xFFFFFFFFL & (long)arrn3[6]);
                arrn3[6] = (int)l10;
                l7 = l10 >> 32;
            }
            arrn3[7] = (int)(l7 + ((0xFFFFFFFFL & (long)arrn3[7]) - 1L));
        }
    }
}

