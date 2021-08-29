/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 */
package org.bouncycastle.math.ec.custom.sec;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP521R1Field {
    public static final int[] P = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 511};

    public static void add(int[] arrn, int[] arrn2, int[] arrn3) {
        int n2 = Nat576.add(16, arrn, arrn2, arrn3) + arrn[16] + arrn2[16];
        if (n2 > 511 || n2 == 511 && Nat576.eq(16, arrn3, P)) {
            n2 = 511 & n2 + Nat576.inc(16, arrn3);
        }
        arrn3[16] = n2;
    }

    public static void implSquare(int[] arrn, int[] arrn2) {
        int[] arrn3 = arrn2;
        SecT239Field.square4(arrn, arrn2);
        int n2 = 8;
        long l2 = arrn[n2];
        long l3 = 0xFFFFFFFFL;
        long l4 = l2 & l3;
        int n3 = 7;
        int n4 = 0;
        int n5 = 16;
        do {
            int n6 = n3 - 1;
            long l5 = l3 & (long)arrn[n3 + n2];
            long l6 = l5 * l5;
            int n7 = n5 - 1;
            arrn3[16 + n7] = n4 << 31 | (int)(l6 >>> 33);
            n5 = n7 - 1;
            arrn3[16 + n5] = (int)(l6 >>> 1);
            int n8 = (int)l6;
            if (n6 <= 0) {
                long l7 = l4 * l4;
                long l8 = 0xFFFFFFFFL & (long)(n8 << 31) | l7 >>> 33;
                arrn3[16] = (int)l7;
                int n9 = 1 & (int)(l7 >>> 32);
                long l9 = 0xFFFFFFFFL & (long)arrn[9];
                long l10 = 0xFFFFFFFFL & (long)arrn3[18];
                long l11 = l8 + l9 * l4;
                int n10 = (int)l11;
                arrn3[17] = n9 | n10 << 1;
                int n11 = n10 >>> 31;
                long l12 = l10 + (l11 >>> 32);
                long l13 = 0xFFFFFFFFL & (long)arrn[10];
                long l14 = 0xFFFFFFFFL & (long)arrn3[19];
                long l15 = 0xFFFFFFFFL & (long)arrn3[20];
                long l16 = l12 + l13 * l4;
                int n12 = (int)l16;
                arrn3[18] = n11 | n12 << 1;
                int n13 = n12 >>> 31;
                long l17 = GeneratedOutlineSupport.outline4((long)l13, (long)l9, (long)(l16 >>> 32), (long)l14);
                long l18 = l15 + (l17 >>> 32);
                long l19 = l17 & 0xFFFFFFFFL;
                long l20 = 0xFFFFFFFFL & (long)arrn[11];
                long l21 = (0xFFFFFFFFL & (long)arrn3[21]) + (l18 >>> 32);
                long l22 = l18 & 0xFFFFFFFFL;
                long l23 = (0xFFFFFFFFL & (long)arrn3[22]) + (l21 >>> 32);
                long l24 = l21 & 0xFFFFFFFFL;
                long l25 = l19 + l20 * l4;
                int n14 = (int)l25;
                arrn3[19] = n13 | n14 << 1;
                int n15 = n14 >>> 31;
                long l26 = GeneratedOutlineSupport.outline4((long)l20, (long)l9, (long)(l25 >>> 32), (long)l22);
                long l27 = GeneratedOutlineSupport.outline4((long)l20, (long)l13, (long)(l26 >>> 32), (long)l24);
                long l28 = l26 & 0xFFFFFFFFL;
                long l29 = l23 + (l27 >>> 32);
                long l30 = l27 & 0xFFFFFFFFL;
                long l31 = 0xFFFFFFFFL & (long)arrn[12];
                long l32 = (0xFFFFFFFFL & (long)arrn3[23]) + (l29 >>> 32);
                long l33 = l29 & 0xFFFFFFFFL;
                long l34 = (0xFFFFFFFFL & (long)arrn3[24]) + (l32 >>> 32);
                long l35 = l32 & 0xFFFFFFFFL;
                long l36 = l28 + l31 * l4;
                int n16 = (int)l36;
                arrn3[20] = n15 | n16 << 1;
                int n17 = n16 >>> 31;
                long l37 = GeneratedOutlineSupport.outline4((long)l31, (long)l9, (long)(l36 >>> 32), (long)l30);
                long l38 = GeneratedOutlineSupport.outline4((long)l31, (long)l13, (long)(l37 >>> 32), (long)l33);
                long l39 = l37 & 0xFFFFFFFFL;
                long l40 = GeneratedOutlineSupport.outline4((long)l31, (long)l20, (long)(l38 >>> 32), (long)l35);
                long l41 = l38 & 0xFFFFFFFFL;
                long l42 = l34 + (l40 >>> 32);
                long l43 = l40 & 0xFFFFFFFFL;
                long l44 = 0xFFFFFFFFL & (long)arrn[13];
                long l45 = (0xFFFFFFFFL & (long)arrn3[25]) + (l42 >>> 32);
                long l46 = l42 & 0xFFFFFFFFL;
                long l47 = (0xFFFFFFFFL & (long)arrn3[26]) + (l45 >>> 32);
                long l48 = l45 & 0xFFFFFFFFL;
                long l49 = l39 + l44 * l4;
                int n18 = (int)l49;
                arrn3[21] = n17 | n18 << 1;
                int n19 = n18 >>> 31;
                long l50 = GeneratedOutlineSupport.outline4((long)l44, (long)l9, (long)(l49 >>> 32), (long)l41);
                long l51 = GeneratedOutlineSupport.outline4((long)l44, (long)l13, (long)(l50 >>> 32), (long)l43);
                long l52 = l50 & 0xFFFFFFFFL;
                long l53 = GeneratedOutlineSupport.outline4((long)l44, (long)l20, (long)(l51 >>> 32), (long)l46);
                long l54 = l51 & 0xFFFFFFFFL;
                long l55 = GeneratedOutlineSupport.outline4((long)l44, (long)l31, (long)(l53 >>> 32), (long)l48);
                long l56 = l53 & 0xFFFFFFFFL;
                long l57 = l47 + (l55 >>> 32);
                long l58 = l55 & 0xFFFFFFFFL;
                long l59 = 0xFFFFFFFFL & (long)arrn[14];
                long l60 = (0xFFFFFFFFL & (long)arrn3[27]) + (l57 >>> 32);
                long l61 = l57 & 0xFFFFFFFFL;
                long l62 = (0xFFFFFFFFL & (long)arrn3[28]) + (l60 >>> 32);
                long l63 = l60 & 0xFFFFFFFFL;
                long l64 = l52 + l59 * l4;
                int n20 = (int)l64;
                arrn3[22] = n19 | n20 << 1;
                int n21 = n20 >>> 31;
                long l65 = GeneratedOutlineSupport.outline4((long)l59, (long)l9, (long)(l64 >>> 32), (long)l54);
                long l66 = GeneratedOutlineSupport.outline4((long)l59, (long)l13, (long)(l65 >>> 32), (long)l56);
                long l67 = l65 & 0xFFFFFFFFL;
                long l68 = GeneratedOutlineSupport.outline4((long)l59, (long)l20, (long)(l66 >>> 32), (long)l58);
                long l69 = l66 & 0xFFFFFFFFL;
                long l70 = GeneratedOutlineSupport.outline4((long)l59, (long)l31, (long)(l68 >>> 32), (long)l61);
                long l71 = l68 & 0xFFFFFFFFL;
                long l72 = GeneratedOutlineSupport.outline4((long)l59, (long)l44, (long)(l70 >>> 32), (long)l63);
                long l73 = l70 & 0xFFFFFFFFL;
                long l74 = l62 + (l72 >>> 32);
                long l75 = l72 & 0xFFFFFFFFL;
                long l76 = 0xFFFFFFFFL & (long)arrn[15];
                long l77 = (0xFFFFFFFFL & (long)arrn3[29]) + (l74 >>> 32);
                long l78 = l74 & 0xFFFFFFFFL;
                long l79 = (0xFFFFFFFFL & (long)arrn3[30]) + (l77 >>> 32);
                long l80 = l77 & 0xFFFFFFFFL;
                long l81 = l67 + l4 * l76;
                int n22 = (int)l81;
                arrn2[23] = n21 | n22 << 1;
                int n23 = n22 >>> 31;
                long l82 = GeneratedOutlineSupport.outline4((long)l76, (long)l9, (long)(l81 >>> 32), (long)l69);
                long l83 = GeneratedOutlineSupport.outline4((long)l76, (long)l13, (long)(l82 >>> 32), (long)l71);
                long l84 = GeneratedOutlineSupport.outline4((long)l76, (long)l20, (long)(l83 >>> 32), (long)l73);
                long l85 = GeneratedOutlineSupport.outline4((long)l76, (long)l31, (long)(l84 >>> 32), (long)l75);
                long l86 = GeneratedOutlineSupport.outline4((long)l76, (long)l44, (long)(l85 >>> 32), (long)l78);
                long l87 = GeneratedOutlineSupport.outline4((long)l76, (long)l59, (long)(l86 >>> 32), (long)l80);
                long l88 = l79 + (l87 >>> 32);
                int n24 = (int)l82;
                arrn2[24] = n23 | n24 << 1;
                int n25 = n24 >>> 31;
                int n26 = (int)l83;
                arrn2[25] = n25 | n26 << 1;
                int n27 = n26 >>> 31;
                int n28 = (int)l84;
                arrn2[26] = n27 | n28 << 1;
                int n29 = n28 >>> 31;
                int n30 = (int)l85;
                arrn2[27] = n29 | n30 << 1;
                int n31 = n30 >>> 31;
                int n32 = (int)l86;
                arrn2[28] = n31 | n32 << 1;
                int n33 = n32 >>> 31;
                int n34 = (int)l87;
                arrn2[29] = n33 | n34 << 1;
                int n35 = n34 >>> 31;
                int n36 = (int)l88;
                arrn2[30] = n35 | n36 << 1;
                arrn2[31] = n36 >>> 31 | arrn2[31] + (int)(l88 >>> 32) << 1;
                int n37 = SecT239Field.addToEachOther1(arrn2, 8, arrn2, 16);
                int n38 = n37 + SecT239Field.addTo1(arrn2, 24, arrn2, 16, n37 + SecT239Field.addTo1(arrn2, 0, arrn2, 8, 0));
                int[] arrn4 = new int[8];
                SecT239Field.diff1(arrn, 8, arrn, 0, arrn4, 0);
                int[] arrn5 = new int[16];
                SecT239Field.square4(arrn4, arrn5);
                Nat576.addWordAt(32, n38 + Nat576.subFrom(16, arrn5, 0, arrn2, 8), arrn2, 24);
                int n39 = arrn[16];
                long l89 = 0xFFFFFFFFL & (long)(n39 << 1);
                long l90 = 0L;
                int n40 = 0;
                do {
                    long l91 = l89 * (0xFFFFFFFFL & (long)arrn[0 + n40]);
                    int n41 = n40 + 16;
                    long l92 = l90 + (l91 + (0xFFFFFFFFL & (long)arrn2[n41]));
                    arrn2[n41] = (int)l92;
                    long l93 = l92 >>> 32;
                    if (++n40 >= 16) {
                        arrn2[32] = (int)l93 + n39 * n39;
                        return;
                    }
                    l90 = l93;
                } while (true);
            }
            int[] arrn6 = arrn3;
            n4 = n8;
            n2 = 8;
            l3 = 0xFFFFFFFFL;
            n3 = n6;
            arrn3 = arrn6;
        } while (true);
    }

    public static int isZero(int[] arrn) {
        int n2 = 0;
        for (int i2 = 0; i2 < 17; ++i2) {
            n2 |= arrn[i2];
        }
        return -1 + (n2 >>> 1 | n2 & 1) >> 31;
    }

    public static void multiply(int[] arrn, int[] arrn2, int[] arrn3) {
        int n2;
        int[] arrn4 = new int[33];
        SecT239Field.mul4(arrn, arrn2, arrn4);
        long l2 = 0xFFFFFFFFL & (long)arrn2[8];
        long l3 = 0xFFFFFFFFL & (long)arrn2[9];
        long l4 = 0xFFFFFFFFL & (long)arrn2[10];
        long l5 = 0xFFFFFFFFL & (long)arrn2[11];
        long l6 = 0xFFFFFFFFL & (long)arrn2[12];
        long l7 = 0xFFFFFFFFL & (long)arrn2[13];
        long l8 = 0xFFFFFFFFL & (long)arrn2[14];
        long l9 = 0xFFFFFFFFL & (long)arrn2[15];
        long l10 = 0xFFFFFFFFL & (long)arrn[8];
        long l11 = l10 * l2;
        long l12 = 0L;
        long l13 = l11 + l12;
        arrn4[16] = (int)l13;
        int n3 = 32;
        long l14 = (l13 >>> n3) + l10 * l3;
        arrn4[17] = (int)l14;
        long l15 = (l14 >>> n3) + l10 * l4;
        arrn4[18] = (int)l15;
        long l16 = (l15 >>> n3) + l10 * l5;
        arrn4[19] = (int)l16;
        long l17 = (l16 >>> n3) + l10 * l6;
        arrn4[20] = (int)l17;
        long l18 = (l17 >>> n3) + l10 * l7;
        arrn4[21] = (int)l18;
        long l19 = (l18 >>> n3) + l10 * l8;
        arrn4[22] = (int)l19;
        long l20 = (l19 >>> n3) + l10 * l9;
        arrn4[23] = (int)l20;
        arrn4[24] = (int)(l20 >>> n3);
        int n4 = n2 = 1;
        int n5 = 16;
        while (n4 < 8) {
            int n6 = n5 + n2;
            long l21 = 0xFFFFFFFFL & (long)arrn[n4 + 8];
            long l22 = l21 * l2;
            int n7 = n6 + 0;
            long l23 = l12 + (l22 + (0xFFFFFFFFL & (long)arrn4[n7]));
            int n8 = n4;
            arrn4[n7] = (int)l23;
            long l24 = l23 >>> n3;
            long l25 = l21 * l3;
            int n9 = n6 + 1;
            int n10 = arrn4[n9];
            long l26 = l3;
            long l27 = l24 + (l25 + (0xFFFFFFFFL & (long)n10));
            arrn4[n9] = (int)l27;
            long l28 = l27 >>> 32;
            long l29 = l21 * l4;
            int n11 = n6 + 2;
            int n12 = arrn4[n11];
            long l30 = l4;
            long l31 = l28 + (l29 + (0xFFFFFFFFL & (long)n12));
            arrn4[n11] = (int)l31;
            long l32 = l31 >>> 32;
            long l33 = l21 * l5;
            int n13 = n6 + 3;
            long l34 = l32 + (l33 + (0xFFFFFFFFL & (long)arrn4[n13]));
            arrn4[n13] = (int)l34;
            long l35 = l34 >>> 32;
            long l36 = l21 * l6;
            int n14 = n6 + 4;
            long l37 = l35 + (l36 + (0xFFFFFFFFL & (long)arrn4[n14]));
            arrn4[n14] = (int)l37;
            long l38 = l37 >>> 32;
            long l39 = l21 * l7;
            int n15 = n6 + 5;
            long l40 = l38 + (l39 + (0xFFFFFFFFL & (long)arrn4[n15]));
            arrn4[n15] = (int)l40;
            long l41 = l40 >>> 32;
            long l42 = l21 * l8;
            int n16 = n6 + 6;
            long l43 = l41 + (l42 + (0xFFFFFFFFL & (long)arrn4[n16]));
            arrn4[n16] = (int)l43;
            long l44 = l43 >>> 32;
            long l45 = l21 * l9;
            int n17 = n6 + 7;
            long l46 = l44 + (l45 + (0xFFFFFFFFL & (long)arrn4[n17]));
            arrn4[n17] = (int)l46;
            long l47 = l46 >>> 32;
            arrn4[n6 + 8] = (int)l47;
            n4 = n8 + 1;
            n5 = n6;
            l4 = l30;
            l3 = l26;
            n2 = 1;
            n3 = 32;
        }
        int n18 = SecT239Field.addToEachOther1(arrn4, 8, arrn4, 16);
        int n19 = 0;
        int n20 = n18 + SecT239Field.addTo1(arrn4, 24, arrn4, 16, n18 + SecT239Field.addTo1(arrn4, 0, arrn4, 8, 0));
        int[] arrn5 = new int[8];
        int[] arrn6 = new int[8];
        boolean bl = SecT239Field.diff1(arrn, 8, arrn, 0, arrn5, 0) != SecT239Field.diff1(arrn2, 8, arrn2, 0, arrn6, 0);
        int[] arrn7 = new int[16];
        SecT239Field.mul4(arrn5, arrn6, arrn7);
        int n21 = bl ? Nat576.addTo(16, arrn7, 0, arrn4, 8) : Nat576.subFrom(16, arrn7, 0, arrn4, 8);
        Nat576.addWordAt(32, n20 + n21, arrn4, 24);
        int n22 = arrn[16];
        int n23 = arrn2[16];
        long l48 = 0xFFFFFFFFL & (long)n22;
        long l49 = 0xFFFFFFFFL & (long)n23;
        do {
            long l50 = l48 * (0xFFFFFFFFL & (long)arrn2[n19]) + l49 * (0xFFFFFFFFL & (long)arrn[n19]);
            int n24 = 16 + n19;
            int n25 = arrn4[n24];
            int[] arrn8 = arrn4;
            long l51 = l12 + (l50 + (0xFFFFFFFFL & (long)n25));
            arrn8[n24] = (int)l51;
            long l52 = l51 >>> 32;
            if (++n19 >= 16) {
                arrn8[32] = (int)l52 + n22 * n23;
                SecP521R1Field.reduce(arrn8, arrn3);
                return;
            }
            l12 = l52;
            arrn4 = arrn8;
        } while (true);
    }

    public static void reduce(int[] arrn, int[] arrn2) {
        int n2;
        int n3 = n2 = arrn[32];
        int n4 = 16;
        while (--n4 >= 0) {
            int n5 = arrn[16 + n4];
            arrn2[n4 + 0] = n5 >>> 9 | n3 << -9;
            n3 = n5;
        }
        int n6 = (n3 << -9 >>> 23) + (n2 >>> 9) + Nat576.addTo(16, arrn, arrn2);
        if (n6 > 511 || n6 == 511 && Nat576.eq(16, arrn2, P)) {
            n6 = 511 & n6 + Nat576.inc(16, arrn2);
        }
        arrn2[16] = n6;
    }

    public static void reduce23(int[] arrn) {
        int n2 = arrn[16];
        int n3 = Nat576.addWordTo(16, n2 >>> 9, arrn) + (n2 & 511);
        if (n3 > 511 || n3 == 511 && Nat576.eq(16, arrn, P)) {
            n3 = 511 & n3 + Nat576.inc(16, arrn);
        }
        arrn[16] = n3;
    }

    public static void square(int[] arrn, int[] arrn2) {
        int[] arrn3 = new int[33];
        SecP521R1Field.implSquare(arrn, arrn3);
        SecP521R1Field.reduce(arrn3, arrn2);
    }

    public static void subtract(int[] arrn, int[] arrn2, int[] arrn3) {
        int n2 = Nat576.sub(16, arrn, arrn2, arrn3) + arrn[16] - arrn2[16];
        if (n2 < 0) {
            int n3;
            block2 : {
                for (int i2 = 0; i2 < 16; ++i2) {
                    int n4;
                    arrn3[i2] = n4 = -1 + arrn3[i2];
                    if (n4 == -1) continue;
                    n3 = 0;
                    break block2;
                }
                n3 = -1;
            }
            n2 = 511 & n2 + n3;
        }
        arrn3[16] = n2;
    }
}

