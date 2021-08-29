/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 */
package org.bouncycastle.math.raw;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class Interleave {
    public static long expand32to64(int n2) {
        int n3 = SecT239Field.bitPermuteStep(SecT239Field.bitPermuteStep(SecT239Field.bitPermuteStep(SecT239Field.bitPermuteStep(n2, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1);
        return (0x55555555L & (long)(n3 >>> 1)) << 32 | 0x55555555L & (long)n3;
    }

    public static void expand64To128(long[] arrl, int n2, int n3, long[] arrl2, int n4) {
        for (int i2 = 0; i2 < n3; ++i2) {
            long l2 = SecT239Field.bitPermuteStep(SecT239Field.bitPermuteStep(SecT239Field.bitPermuteStep(SecT239Field.bitPermuteStep(SecT239Field.bitPermuteStep(arrl[n2 + i2], 0xFFFF0000L, 16), 0xFF000000FF00L, 8), 0xF000F000F000F0L, 4), 0xC0C0C0C0C0C0C0CL, 2), 0x2222222222222222L, 1);
            arrl2[n4] = l2 & 0x5555555555555555L;
            arrl2[n4 + 1] = 0x5555555555555555L & l2 >>> 1;
            n4 += 2;
        }
    }

    public static void mul(int[] arrn, int[] arrn2, int[] arrn3) {
        SecT239Field.mul2(arrn, arrn2, arrn3);
        long l2 = 0xFFFFFFFFL & (long)arrn2[6];
        long l3 = 0xFFFFFFFFL & (long)arrn2[7];
        long l4 = 0xFFFFFFFFL & (long)arrn2[8];
        long l5 = 0xFFFFFFFFL & (long)arrn2[9];
        long l6 = 0xFFFFFFFFL & (long)arrn2[10];
        long l7 = 0xFFFFFFFFL & (long)arrn2[11];
        long l8 = 0xFFFFFFFFL & (long)arrn[6];
        long l9 = 0L + l8 * l2;
        int n2 = (int)l9;
        int n3 = 12;
        arrn3[n3] = n2;
        long l10 = (l9 >>> 32) + l8 * l3;
        arrn3[13] = (int)l10;
        long l11 = (l10 >>> 32) + l8 * l4;
        arrn3[14] = (int)l11;
        long l12 = (l11 >>> 32) + l8 * l5;
        arrn3[15] = (int)l12;
        long l13 = (l12 >>> 32) + l8 * l6;
        arrn3[16] = (int)l13;
        long l14 = (l13 >>> 32) + l8 * l7;
        arrn3[17] = (int)l14;
        arrn3[18] = (int)(l14 >>> 32);
        int n4 = 1;
        int n5 = n3;
        for (int i2 = n4; i2 < 6; ++i2) {
            long l15 = 0xFFFFFFFFL & (long)arrn[6 + i2];
            long l16 = l15 * l2;
            int n6 = (n5 += n4) + 0;
            long l17 = 0L + (l16 + (0xFFFFFFFFL & (long)arrn3[n6]));
            arrn3[n6] = (int)l17;
            long l18 = l17 >>> 32;
            long l19 = l15 * l3;
            int n7 = n5 + 1;
            int n8 = arrn3[n7];
            long l20 = l3;
            long l21 = l18 + (l19 + (0xFFFFFFFFL & (long)n8));
            arrn3[n7] = (int)l21;
            long l22 = l21 >>> 32;
            long l23 = l15 * l4;
            int n9 = n5 + 2;
            long l24 = l22 + (l23 + (0xFFFFFFFFL & (long)arrn3[n9]));
            arrn3[n9] = (int)l24;
            long l25 = l24 >>> 32;
            long l26 = l15 * l5;
            int n10 = n5 + 3;
            long l27 = l25 + (l26 + (0xFFFFFFFFL & (long)arrn3[n10]));
            arrn3[n10] = (int)l27;
            long l28 = l27 >>> 32;
            long l29 = l15 * l6;
            int n11 = n5 + 4;
            long l30 = l28 + (l29 + (0xFFFFFFFFL & (long)arrn3[n11]));
            arrn3[n11] = (int)l30;
            long l31 = l30 >>> 32;
            long l32 = l15 * l7;
            int n12 = n5 + 5;
            long l33 = l31 + (l32 + (0xFFFFFFFFL & (long)arrn3[n12]));
            arrn3[n12] = (int)l33;
            long l34 = l33 >>> 32;
            arrn3[n5 + 6] = (int)l34;
            l3 = l20;
            n3 = 12;
            n4 = 1;
        }
        int n13 = n3;
        int n14 = SecT239Field.addToEachOther(arrn3, 6, arrn3, n13);
        int n15 = n14 + SecT239Field.addTo(arrn3, 18, arrn3, n13, n14 + SecT239Field.addTo(arrn3, 0, arrn3, 6, 0));
        int[] arrn4 = new int[6];
        int[] arrn5 = new int[6];
        boolean bl = SecT239Field.diff(arrn, 6, arrn, 0, arrn4, 0) != SecT239Field.diff(arrn2, 6, arrn2, 0, arrn5, 0);
        int[] arrn6 = new int[n13];
        SecT239Field.mul2(arrn4, arrn5, arrn6);
        int n16 = bl ? Nat576.addTo(n13, arrn6, 0, arrn3, 6) : Nat576.subFrom(n13, arrn6, 0, arrn3, 6);
        Nat576.addWordAt(24, n15 + n16, arrn3, 18);
    }

    public static void square(int[] arrn, int[] arrn2) {
        int[] arrn3 = arrn2;
        SecT239Field.square2(arrn, arrn2);
        int n2 = 6;
        long l2 = 0xFFFFFFFFL & (long)arrn[n2];
        int n3 = 12;
        int n4 = 0;
        int n5 = 5;
        int n6 = n3;
        do {
            int n7 = n5 - 1;
            long l3 = 0xFFFFFFFFL & (long)arrn[n5 + n2];
            long l4 = l3 * l3;
            int n8 = n3 - 1;
            arrn3[n6 + n8] = n4 << 31 | (int)(l4 >>> 33);
            n3 = n8 - 1;
            arrn3[n6 + n3] = (int)(l4 >>> 1);
            int n9 = (int)l4;
            if (n7 <= 0) {
                long l5 = l2 * l2;
                long l6 = 0xFFFFFFFFL & (long)(n9 << 31) | l5 >>> 33;
                arrn3[12] = (int)l5;
                int n10 = 1 & (int)(l5 >>> 32);
                long l7 = 0xFFFFFFFFL & (long)arrn[7];
                long l8 = 0xFFFFFFFFL & (long)arrn3[14];
                long l9 = l6 + l7 * l2;
                int n11 = (int)l9;
                arrn3[13] = n10 | n11 << 1;
                int n12 = n11 >>> 31;
                long l10 = l8 + (l9 >>> 32);
                long l11 = 0xFFFFFFFFL & (long)arrn[8];
                long l12 = 0xFFFFFFFFL & (long)arrn3[15];
                long l13 = 0xFFFFFFFFL & (long)arrn3[16];
                long l14 = l10 + l11 * l2;
                int n13 = (int)l14;
                arrn3[14] = n12 | n13 << 1;
                int n14 = n13 >>> 31;
                long l15 = GeneratedOutlineSupport.outline4((long)l11, (long)l7, (long)(l14 >>> 32), (long)l12);
                long l16 = l13 + (l15 >>> 32);
                long l17 = l15 & 0xFFFFFFFFL;
                long l18 = 0xFFFFFFFFL & (long)arrn[9];
                long l19 = (0xFFFFFFFFL & (long)arrn2[17]) + (l16 >>> 32);
                long l20 = l16 & 0xFFFFFFFFL;
                long l21 = (0xFFFFFFFFL & (long)arrn2[18]) + (l19 >>> 32);
                long l22 = l19 & 0xFFFFFFFFL;
                long l23 = l17 + l18 * l2;
                int n15 = (int)l23;
                arrn2[15] = n14 | n15 << 1;
                int n16 = n15 >>> 31;
                long l24 = GeneratedOutlineSupport.outline4((long)l18, (long)l7, (long)(l23 >>> 32), (long)l20);
                long l25 = GeneratedOutlineSupport.outline4((long)l18, (long)l11, (long)(l24 >>> 32), (long)l22);
                long l26 = l24 & 0xFFFFFFFFL;
                long l27 = l21 + (l25 >>> 32);
                long l28 = l25 & 0xFFFFFFFFL;
                long l29 = 0xFFFFFFFFL & (long)arrn[10];
                long l30 = (0xFFFFFFFFL & (long)arrn2[19]) + (l27 >>> 32);
                long l31 = l27 & 0xFFFFFFFFL;
                long l32 = (0xFFFFFFFFL & (long)arrn2[20]) + (l30 >>> 32);
                long l33 = l30 & 0xFFFFFFFFL;
                long l34 = l26 + l29 * l2;
                int n17 = (int)l34;
                arrn2[16] = n16 | n17 << 1;
                int n18 = n17 >>> 31;
                long l35 = GeneratedOutlineSupport.outline4((long)l29, (long)l7, (long)(l34 >>> 32), (long)l28);
                long l36 = GeneratedOutlineSupport.outline4((long)l29, (long)l11, (long)(l35 >>> 32), (long)l31);
                long l37 = l35 & 0xFFFFFFFFL;
                long l38 = GeneratedOutlineSupport.outline4((long)l29, (long)l18, (long)(l36 >>> 32), (long)l33);
                long l39 = l36 & 0xFFFFFFFFL;
                long l40 = l32 + (l38 >>> 32);
                long l41 = l38 & 0xFFFFFFFFL;
                long l42 = 0xFFFFFFFFL & (long)arrn[11];
                long l43 = (0xFFFFFFFFL & (long)arrn2[21]) + (l40 >>> 32);
                long l44 = l40 & 0xFFFFFFFFL;
                long l45 = (0xFFFFFFFFL & (long)arrn2[22]) + (l43 >>> 32);
                long l46 = l43 & 0xFFFFFFFFL;
                long l47 = l37 + l2 * l42;
                int n19 = (int)l47;
                arrn2[17] = n18 | n19 << 1;
                int n20 = n19 >>> 31;
                long l48 = GeneratedOutlineSupport.outline4((long)l42, (long)l7, (long)(l47 >>> 32), (long)l39);
                long l49 = GeneratedOutlineSupport.outline4((long)l42, (long)l11, (long)(l48 >>> 32), (long)l41);
                long l50 = GeneratedOutlineSupport.outline4((long)l42, (long)l18, (long)(l49 >>> 32), (long)l44);
                long l51 = GeneratedOutlineSupport.outline4((long)l42, (long)l29, (long)(l50 >>> 32), (long)l46);
                long l52 = l45 + (l51 >>> 32);
                int n21 = (int)l48;
                arrn2[18] = n20 | n21 << 1;
                int n22 = n21 >>> 31;
                int n23 = (int)l49;
                arrn2[19] = n22 | n23 << 1;
                int n24 = n23 >>> 31;
                int n25 = (int)l50;
                arrn2[20] = n24 | n25 << 1;
                int n26 = n25 >>> 31;
                int n27 = (int)l51;
                arrn2[21] = n26 | n27 << 1;
                int n28 = n27 >>> 31;
                int n29 = (int)l52;
                arrn2[22] = n28 | n29 << 1;
                arrn2[23] = n29 >>> 31 | arrn2[23] + (int)(l52 >>> 32) << 1;
                int n30 = SecT239Field.addToEachOther(arrn2, 6, arrn2, 12);
                int n31 = n30 + SecT239Field.addTo(arrn2, 18, arrn2, 12, n30 + SecT239Field.addTo(arrn2, 0, arrn2, 6, 0));
                int[] arrn4 = new int[6];
                SecT239Field.diff(arrn, 6, arrn, 0, arrn4, 0);
                int[] arrn5 = new int[12];
                SecT239Field.square2(arrn4, arrn5);
                Nat576.addWordAt(24, n31 + Nat576.subFrom(12, arrn5, 0, arrn2, 6), arrn2, 18);
                return;
            }
            int[] arrn6 = arrn3;
            n2 = 6;
            n4 = n9;
            n6 = 12;
            arrn3 = arrn6;
            n5 = n7;
        } while (true);
    }

    public static long unshuffle(long l2) {
        return SecT239Field.bitPermuteStep(SecT239Field.bitPermuteStep(SecT239Field.bitPermuteStep(SecT239Field.bitPermuteStep(SecT239Field.bitPermuteStep(l2, 0x2222222222222222L, 1), 0xC0C0C0C0C0C0C0CL, 2), 0xF000F000F000F0L, 4), 0xFF000000FF00L, 8), 0xFFFF0000L, 16);
    }
}

