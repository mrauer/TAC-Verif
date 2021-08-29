/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec.custom.djb;

import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class Curve25519Field {
    public static final int[] P = new int[]{-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
    public static final int[] PExt = new int[]{361, 0, 0, 0, 0, 0, 0, 0, -19, -1, -1, -1, -1, -1, -1, 1073741823};

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
        Curve25519Field.reduce(arrn4, arrn3);
    }

    public static void reduce(int[] arrn, int[] arrn2) {
        int n2;
        int n3 = n2 = arrn[7];
        for (int i2 = 0; i2 < 8; ++i2) {
            int n4 = arrn[i2 + 8];
            arrn2[0 + i2] = n4 << 1 | n3 >>> 31;
            n3 = n4;
        }
        long l2 = 0xFFFFFFFFL & (long)19;
        long l3 = 0L + (l2 * (0xFFFFFFFFL & (long)arrn2[0]) + (0xFFFFFFFFL & (long)arrn[0]));
        arrn2[0] = (int)l3;
        long l4 = (l3 >>> 32) + (l2 * (0xFFFFFFFFL & (long)arrn2[1]) + (0xFFFFFFFFL & (long)arrn[1]));
        arrn2[1] = (int)l4;
        long l5 = (l4 >>> 32) + (l2 * (0xFFFFFFFFL & (long)arrn2[2]) + (0xFFFFFFFFL & (long)arrn[2]));
        arrn2[2] = (int)l5;
        long l6 = (l5 >>> 32) + (l2 * (0xFFFFFFFFL & (long)arrn2[3]) + (0xFFFFFFFFL & (long)arrn[3]));
        arrn2[3] = (int)l6;
        long l7 = (l6 >>> 32) + (l2 * (0xFFFFFFFFL & (long)arrn2[4]) + (0xFFFFFFFFL & (long)arrn[4]));
        arrn2[4] = (int)l7;
        long l8 = (l7 >>> 32) + (l2 * (0xFFFFFFFFL & (long)arrn2[5]) + (0xFFFFFFFFL & (long)arrn[5]));
        arrn2[5] = (int)l8;
        long l9 = (l8 >>> 32) + (l2 * (0xFFFFFFFFL & (long)arrn2[6]) + (0xFFFFFFFFL & (long)arrn[6]));
        arrn2[6] = (int)l9;
        long l10 = (l9 >>> 32) + (l2 * (0xFFFFFFFFL & (long)arrn2[7]) + (0xFFFFFFFFL & (long)arrn[7]));
        arrn2[7] = (int)l10;
        int n5 = (int)(l10 >>> 32) << 1;
        int n6 = arrn2[7];
        int n7 = n5 + ((n6 >>> 31) - (n2 >>> 31));
        arrn2[7] = (Integer.MAX_VALUE & n6) + Nat576.addWordTo(7, n7 * 19, arrn2);
        if (SecT239Field.gte4(arrn2, P)) {
            Curve25519Field.subPFrom(arrn2);
        }
    }

    public static void reduce27(int n2, int[] arrn) {
        int n3 = arrn[7];
        int n4 = n2 << 1 | n3 >>> 31;
        arrn[7] = (n3 & Integer.MAX_VALUE) + Nat576.addWordTo(7, n4 * 19, arrn);
        if (SecT239Field.gte4(arrn, P)) {
            Curve25519Field.subPFrom(arrn);
        }
    }

    public static void square(int[] arrn, int[] arrn2) {
        int[] arrn3 = new int[16];
        SecT239Field.square4(arrn, arrn3);
        Curve25519Field.reduce(arrn3, arrn2);
    }

    public static void squareN(int[] arrn, int n2, int[] arrn2) {
        int[] arrn3 = new int[16];
        SecT239Field.square4(arrn, arrn3);
        do {
            Curve25519Field.reduce(arrn3, arrn2);
            if (--n2 <= 0) break;
            SecT239Field.square4(arrn2, arrn3);
        } while (true);
    }

    public static int subPFrom(int[] arrn) {
        long l2 = 19L + (0xFFFFFFFFL & (long)arrn[0]);
        arrn[0] = (int)l2;
        long l3 = l2 >> 32;
        if (l3 != 0L) {
            l3 = Nat576.incAt(7, arrn, 1);
        }
        long l4 = l3 + ((0xFFFFFFFFL & (long)arrn[7]) - 0x80000000L);
        arrn[7] = (int)l4;
        return (int)(l4 >> 32);
    }

    public static void subtract(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.sub4(arrn, arrn2, arrn3) != 0) {
            long l2 = (0xFFFFFFFFL & (long)arrn3[0]) - 19L;
            arrn3[0] = (int)l2;
            long l3 = l2 >> 32;
            if (l3 != 0L) {
                l3 = Nat576.decAt(7, arrn3, 1);
            }
            arrn3[7] = (int)(l3 + (0x80000000L + (0xFFFFFFFFL & (long)arrn3[7])));
        }
    }

    public static void twice(int[] arrn, int[] arrn2) {
        Nat576.shiftUpBit(8, arrn, 0, arrn2);
        if (SecT239Field.gte4(arrn2, P)) {
            Curve25519Field.subPFrom(arrn2);
        }
    }
}

