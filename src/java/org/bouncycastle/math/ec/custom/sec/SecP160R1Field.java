/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP160R1Field {
    public static final int[] P = new int[]{Integer.MAX_VALUE, -1, -1, -1, -1};
    public static final int[] PExt = new int[]{1, 1073741825, 0, 0, 0, -2, -2, -1, -1, -1};
    public static final int[] PExtInv = new int[]{-1, -1073741826, -1, -1, -1, 1, 1};

    public static void add(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.add1(arrn, arrn2, arrn3) != 0 || arrn3[4] == -1 && SecT239Field.gte1(arrn3, P)) {
            Nat576.addWordTo(5, -2147483647, arrn3);
        }
    }

    public static int isZero(int[] arrn) {
        int n2 = 0;
        for (int i2 = 0; i2 < 5; ++i2) {
            n2 |= arrn[i2];
        }
        return -1 + (n2 >>> 1 | n2 & 1) >> 31;
    }

    public static void multiply(int[] arrn, int[] arrn2, int[] arrn3) {
        int[] arrn4 = new int[10];
        SecT239Field.mul1(arrn, arrn2, arrn4);
        SecP160R1Field.reduce(arrn4, arrn3);
    }

    public static void reduce(int[] arrn, int[] arrn2) {
        long l2 = 0xFFFFFFFFL & (long)arrn[5];
        long l3 = 0xFFFFFFFFL & (long)arrn[6];
        long l4 = 0xFFFFFFFFL & (long)arrn[7];
        long l5 = 0xFFFFFFFFL & (long)arrn[8];
        long l6 = 0xFFFFFFFFL & (long)arrn[9];
        long l7 = 0L + (l2 + (0xFFFFFFFFL & (long)arrn[0]) + (l2 << 31));
        arrn2[0] = (int)l7;
        long l8 = (l7 >>> 32) + (l3 + (0xFFFFFFFFL & (long)arrn[1]) + (l3 << 31));
        arrn2[1] = (int)l8;
        long l9 = (l8 >>> 32) + (l4 + (0xFFFFFFFFL & (long)arrn[2]) + (l4 << 31));
        arrn2[2] = (int)l9;
        long l10 = (l9 >>> 32) + (l5 + (0xFFFFFFFFL & (long)arrn[3]) + (l5 << 31));
        arrn2[3] = (int)l10;
        long l11 = (l10 >>> 32) + (l6 + (0xFFFFFFFFL & (long)arrn[4]) + (l6 << 31));
        arrn2[4] = (int)l11;
        SecP160R1Field.reduce32((int)(l11 >>> 32), arrn2);
    }

    public static void reduce32(int n2, int[] arrn) {
        block4 : {
            block3 : {
                block2 : {
                    if (n2 == 0) break block2;
                    long l2 = 0L + ((0xFFFFFFFFL & (long)-2147483647) * (0xFFFFFFFFL & (long)n2) + (0xFFFFFFFFL & (long)arrn[0]));
                    arrn[0] = (int)l2;
                    long l3 = (l2 >>> 32) + (0xFFFFFFFFL & (long)arrn[1]);
                    arrn[1] = (int)l3;
                    int n3 = l3 >>> 32 == 0L ? 0 : Nat576.incAt(5, arrn, 0, 2);
                    if (n3 != 0) break block3;
                }
                if (arrn[4] != -1 || !SecT239Field.gte1(arrn, P)) break block4;
            }
            Nat576.addWordTo(5, -2147483647, arrn);
        }
    }

    public static void square(int[] arrn, int[] arrn2) {
        int[] arrn3 = new int[10];
        SecT239Field.square1(arrn, arrn3);
        SecP160R1Field.reduce(arrn3, arrn2);
    }

    public static void squareN(int[] arrn, int n2, int[] arrn2) {
        int[] arrn3 = new int[10];
        SecT239Field.square1(arrn, arrn3);
        do {
            SecP160R1Field.reduce(arrn3, arrn2);
            if (--n2 <= 0) break;
            SecT239Field.square1(arrn2, arrn3);
        } while (true);
    }

    public static void subtract(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.sub1(arrn, arrn2, arrn3) != 0) {
            long l2 = (0xFFFFFFFFL & (long)arrn3[0]) - (0xFFFFFFFFL & (long)-2147483647);
            arrn3[0] = (int)l2;
            if (l2 >> 32 == 0L) {
                return;
            }
            Nat576.decAt(5, arrn3, 1);
        }
    }
}

