/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP192K1Field {
    public static final int[] P = new int[]{-4553, -2, -1, -1, -1, -1};
    public static final int[] PExt = new int[]{20729809, 9106, 1, 0, 0, 0, -9106, -3, -1, -1, -1, -1};
    public static final int[] PExtInv = new int[]{-20729809, -9107, -2, -1, -1, -1, 9105, 2};

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
        SecP192K1Field.reduce(arrn4, arrn3);
    }

    public static void reduce(int[] arrn, int[] arrn2) {
        long l2 = 0xFFFFFFFFL & (long)4553;
        long l3 = 0xFFFFFFFFL & (long)arrn[6];
        long l4 = 0L + (l2 * l3 + (0xFFFFFFFFL & (long)arrn[0]));
        arrn2[0] = (int)l4;
        long l5 = l4 >>> 32;
        long l6 = 0xFFFFFFFFL & (long)arrn[7];
        long l7 = l5 + (l3 + l2 * l6 + (0xFFFFFFFFL & (long)arrn[1]));
        arrn2[1] = (int)l7;
        long l8 = l7 >>> 32;
        long l9 = 0xFFFFFFFFL & (long)arrn[8];
        long l10 = l8 + (l6 + l2 * l9 + (0xFFFFFFFFL & (long)arrn[2]));
        arrn2[2] = (int)l10;
        long l11 = l10 >>> 32;
        long l12 = 0xFFFFFFFFL & (long)arrn[9];
        long l13 = l11 + (l9 + l2 * l12 + (0xFFFFFFFFL & (long)arrn[3]));
        arrn2[3] = (int)l13;
        long l14 = l13 >>> 32;
        long l15 = 0xFFFFFFFFL & (long)arrn[10];
        long l16 = l14 + (l12 + l2 * l15 + (0xFFFFFFFFL & (long)arrn[4]));
        arrn2[4] = (int)l16;
        long l17 = l16 >>> 32;
        long l18 = 0xFFFFFFFFL & (long)arrn[11];
        long l19 = l17 + (l15 + l2 * l18 + (0xFFFFFFFFL & (long)arrn[5]));
        arrn2[5] = (int)l19;
        long l20 = l18 + (l19 >>> 32);
        long l21 = l20 & 0xFFFFFFFFL;
        long l22 = 0L + (l2 * l21 + (0xFFFFFFFFL & (long)arrn2[0]));
        arrn2[0] = (int)l22;
        long l23 = l22 >>> 32;
        long l24 = l20 >>> 32;
        long l25 = l23 + (l21 + l2 * l24 + (0xFFFFFFFFL & (long)arrn2[1]));
        arrn2[1] = (int)l25;
        long l26 = (l25 >>> 32) + (l24 + (0xFFFFFFFFL & (long)arrn2[2]));
        arrn2[2] = (int)l26;
        long l27 = (l26 >>> 32) + (0xFFFFFFFFL & (long)arrn2[3]);
        arrn2[3] = (int)l27;
        int n2 = l27 >>> 32 == 0L ? 0 : Nat576.incAt(6, arrn2, 0, 4);
        if (n2 != 0 || arrn2[5] == -1 && SecT239Field.gte2(arrn2, P)) {
            Nat576.add33To(6, 4553, arrn2);
        }
    }

    public static void reduce32(int n2, int[] arrn) {
        block4 : {
            block3 : {
                block2 : {
                    if (n2 == 0) break block2;
                    long l2 = 0xFFFFFFFFL & (long)4553;
                    long l3 = 0xFFFFFFFFL & (long)n2;
                    long l4 = 0L + (l2 * l3 + (0xFFFFFFFFL & (long)arrn[0]));
                    arrn[0] = (int)l4;
                    long l5 = (l4 >>> 32) + (l3 + (0xFFFFFFFFL & (long)arrn[1]));
                    arrn[1] = (int)l5;
                    long l6 = (l5 >>> 32) + (0xFFFFFFFFL & (long)arrn[2]);
                    arrn[2] = (int)l6;
                    int n3 = l6 >>> 32 == 0L ? 0 : Nat576.incAt(6, arrn, 0, 3);
                    if (n3 != 0) break block3;
                }
                if (arrn[5] != -1 || !SecT239Field.gte2(arrn, P)) break block4;
            }
            Nat576.add33To(6, 4553, arrn);
        }
    }

    public static void square(int[] arrn, int[] arrn2) {
        int[] arrn3 = new int[12];
        SecT239Field.square2(arrn, arrn3);
        SecP192K1Field.reduce(arrn3, arrn2);
    }

    public static void squareN(int[] arrn, int n2, int[] arrn2) {
        int[] arrn3 = new int[12];
        SecT239Field.square2(arrn, arrn3);
        do {
            SecP192K1Field.reduce(arrn3, arrn2);
            if (--n2 <= 0) break;
            SecT239Field.square2(arrn2, arrn3);
        } while (true);
    }

    public static void subtract(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.sub2(arrn, arrn2, arrn3) != 0) {
            Nat576.sub33From(6, 4553, arrn3);
        }
    }
}

