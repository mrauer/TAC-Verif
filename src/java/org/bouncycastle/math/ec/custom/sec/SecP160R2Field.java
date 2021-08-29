/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.security.SecureRandom
 */
package org.bouncycastle.math.ec.custom.sec;

import java.security.SecureRandom;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP160R2Field {
    public static final int[] P = new int[]{-21389, -2, -1, -1, -1};
    public static final int[] PExt = new int[]{457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1};
    public static final int[] PExtInv = new int[]{-457489321, -42779, -2, -1, -1, 42777, 2};

    public static void add(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.add1(arrn, arrn2, arrn3) != 0 || arrn3[4] == -1 && SecT239Field.gte1(arrn3, P)) {
            Nat576.add33To(5, 21389, arrn3);
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
        SecP160R2Field.reduce(arrn4, arrn3);
    }

    public static void multiplyAddToExt(int[] arrn, int[] arrn2, int[] arrn3) {
        int[] arrn4;
        if ((SecT239Field.mulAddTo1(arrn, arrn2, arrn3) != 0 || arrn3[9] == -1 && Nat576.gte(10, arrn3, PExt)) && Nat576.addTo((arrn4 = PExtInv).length, arrn4, arrn3) != 0) {
            Nat576.incAt(10, arrn3, arrn4.length);
        }
    }

    public static void negate(int[] arrn, int[] arrn2) {
        if (SecP160R2Field.isZero(arrn) != 0) {
            int[] arrn3 = P;
            SecT239Field.sub1(arrn3, arrn3, arrn2);
            return;
        }
        SecT239Field.sub1(P, arrn, arrn2);
    }

    public static void randomMult(SecureRandom secureRandom, int[] arrn) {
        do {
            byte[] arrby = new byte[20];
            do {
                secureRandom.nextBytes(arrby);
                Nat576.littleEndianToInt(arrby, 0, arrn, 0, 5);
            } while (Nat576.lessThan(5, arrn, P) == 0);
        } while (SecP160R2Field.isZero(arrn) != 0);
    }

    public static void reduce(int[] arrn, int[] arrn2) {
        long l2 = 0xFFFFFFFFL & (long)21389;
        long l3 = 0xFFFFFFFFL & (long)arrn[5];
        long l4 = 0L + (l2 * l3 + (0xFFFFFFFFL & (long)arrn[0]));
        arrn2[0] = (int)l4;
        long l5 = l4 >>> 32;
        long l6 = 0xFFFFFFFFL & (long)arrn[6];
        long l7 = l5 + (l3 + l2 * l6 + (0xFFFFFFFFL & (long)arrn[1]));
        arrn2[1] = (int)l7;
        long l8 = l7 >>> 32;
        long l9 = 0xFFFFFFFFL & (long)arrn[7];
        long l10 = l8 + (l6 + l2 * l9 + (0xFFFFFFFFL & (long)arrn[2]));
        arrn2[2] = (int)l10;
        long l11 = l10 >>> 32;
        long l12 = 0xFFFFFFFFL & (long)arrn[8];
        long l13 = l11 + (l9 + l2 * l12 + (0xFFFFFFFFL & (long)arrn[3]));
        arrn2[3] = (int)l13;
        long l14 = l13 >>> 32;
        long l15 = 0xFFFFFFFFL & (long)arrn[9];
        long l16 = l14 + (l12 + l2 * l15 + (0xFFFFFFFFL & (long)arrn[4]));
        arrn2[4] = (int)l16;
        long l17 = l15 + (l16 >>> 32);
        long l18 = l17 & 0xFFFFFFFFL;
        long l19 = 0L + (l2 * l18 + (0xFFFFFFFFL & (long)arrn2[0]));
        arrn2[0] = (int)l19;
        long l20 = l19 >>> 32;
        long l21 = l17 >>> 32;
        long l22 = l20 + (l18 + l2 * l21 + (0xFFFFFFFFL & (long)arrn2[1]));
        arrn2[1] = (int)l22;
        long l23 = (l22 >>> 32) + (l21 + (0xFFFFFFFFL & (long)arrn2[2]));
        arrn2[2] = (int)l23;
        long l24 = (l23 >>> 32) + (0xFFFFFFFFL & (long)arrn2[3]);
        arrn2[3] = (int)l24;
        int n2 = l24 >>> 32 == 0L ? 0 : Nat576.incAt(5, arrn2, 0, 4);
        if (n2 != 0 || arrn2[4] == -1 && SecT239Field.gte1(arrn2, P)) {
            Nat576.add33To(5, 21389, arrn2);
        }
    }

    public static void reduce32(int n2, int[] arrn) {
        block4 : {
            block3 : {
                block2 : {
                    if (n2 == 0) break block2;
                    long l2 = 0xFFFFFFFFL & (long)21389;
                    long l3 = 0xFFFFFFFFL & (long)n2;
                    long l4 = 0L + (l2 * l3 + (0xFFFFFFFFL & (long)arrn[0]));
                    arrn[0] = (int)l4;
                    long l5 = (l4 >>> 32) + (l3 + (0xFFFFFFFFL & (long)arrn[1]));
                    arrn[1] = (int)l5;
                    long l6 = (l5 >>> 32) + (0xFFFFFFFFL & (long)arrn[2]);
                    arrn[2] = (int)l6;
                    int n3 = l6 >>> 32 == 0L ? 0 : Nat576.incAt(5, arrn, 0, 3);
                    if (n3 != 0) break block3;
                }
                if (arrn[4] != -1 || !SecT239Field.gte1(arrn, P)) break block4;
            }
            Nat576.add33To(5, 21389, arrn);
        }
    }

    public static void square(int[] arrn, int[] arrn2) {
        int[] arrn3 = new int[10];
        SecT239Field.square1(arrn, arrn3);
        SecP160R2Field.reduce(arrn3, arrn2);
    }

    public static void squareN(int[] arrn, int n2, int[] arrn2) {
        int[] arrn3 = new int[10];
        SecT239Field.square1(arrn, arrn3);
        do {
            SecP160R2Field.reduce(arrn3, arrn2);
            if (--n2 <= 0) break;
            SecT239Field.square1(arrn2, arrn3);
        } while (true);
    }

    public static void subtract(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.sub1(arrn, arrn2, arrn3) != 0) {
            Nat576.sub33From(5, 21389, arrn3);
        }
    }

    public static void twice(int[] arrn, int[] arrn2) {
        if (Nat576.shiftUpBit(5, arrn, 0, arrn2) != 0 || arrn2[4] == -1 && SecT239Field.gte1(arrn2, P)) {
            Nat576.add33To(5, 21389, arrn2);
        }
    }
}

