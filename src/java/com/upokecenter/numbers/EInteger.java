/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.ArithmeticException
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.Objects
 */
package com.upokecenter.numbers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.upokecenter.numbers.NumberUtility;
import java.util.Arrays;
import java.util.Objects;

public final class EInteger
implements Comparable<EInteger> {
    public static final int[] ValueCharToDigit = new int[]{36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 36, 36, 36, 36, 36, 36, 36, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 36, 36, 36, 36, 36, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 36, 36, 36, 36};
    public static final int[] ValueMaxSafeInts = new int[]{1073741823, 715827881, 536870911, 429496728, 357913940, 306783377, 268435455, 238609293, 214748363, 195225785, 178956969, 165191048, 153391688, 143165575, 134217727, 126322566, 119304646, 113025454, 107374181, 102261125, 97612892, 93368853, 89478484, 85899344, 82595523, 79536430, 76695843, 74051159, 71582787, 69273665, 67108863, 65075261, 63161282, 61356674, 59652322};
    public static final EInteger ValueOne = new EInteger(1, new short[]{1}, false);
    public static final EInteger ValueTen = new EInteger(1, new short[]{10}, false);
    public static final EInteger ValueZero = new EInteger(0, new short[]{0}, false);
    public final boolean negative;
    public final int wordCount;
    public final short[] words;

    public EInteger(int n2, short[] arrs, boolean bl) {
        this.wordCount = n2;
        this.words = arrs;
        this.negative = bl;
    }

    public static int AddInternal(short[] arrs, int n2, short[] arrs2, int n3, short[] arrs3, int n4, int n5) {
        int n6 = n5 & 1;
        int n7 = 0;
        boolean bl = n6 == 0;
        if (!bl) {
            --n5;
        }
        int n8 = 0;
        while (n7 < n5) {
            int n9 = (65535 & arrs2[n3 + n7]) + (65535 & arrs3[n4 + n7]) + (short)(n8 >> 16);
            arrs[n2 + n7] = (short)n9;
            int n10 = n7 + 1;
            n8 = (65535 & arrs2[n3 + n10]) + (65535 & arrs3[n4 + n10]) + (short)(n9 >> 16);
            arrs[n2 + n10] = (short)n8;
            n7 = n10 + 1;
        }
        if (!bl) {
            n8 = (65535 & arrs2[n3 + n5]) + (65535 & arrs3[n4 + n5]) + (short)(n8 >> 16);
            arrs[n2 + n5] = (short)n8;
        }
        return 65535 & n8 >> 16;
    }

    public static int AddUnevenSize(short[] arrs, int n2, short[] arrs2, int n3, int n4, short[] arrs3, int n5, int n6) {
        int n7 = 0;
        for (int i2 = 0; i2 < n6; ++i2) {
            n7 = (65535 & arrs2[n3 + i2]) + (65535 & arrs3[n5 + i2]) + (short)(n7 >> 16);
            arrs[n2 + i2] = (short)n7;
        }
        while (n6 < n4) {
            n7 = (65535 & arrs2[n3 + n6]) + (short)(n7 >> 16);
            arrs[n2 + n6] = (short)n7;
            ++n6;
        }
        return 65535 & n7 >> 16;
    }

    public static int ApproxLogTenOfTwo(int n2) {
        int n3 = n2 & 65535;
        int n4 = 65535 & n2 >> 16;
        int n5 = 65535 & n3 * 34043 >> 16;
        short s = (short)n5;
        int n6 = 65535 & n5 >> 16;
        int n7 = n3 * 8346 + (s & 65535);
        short s2 = (short)n7;
        int n8 = n6 + (65535 & n7 >> 16) + (65535 & 34043 * n4 + (s2 & 65535) >> 16);
        short s3 = (short)n8;
        int n9 = 65535 & n8 >> 16;
        int n10 = n3 * 154 + (s3 & 65535);
        short s4 = (short)n10;
        int n11 = n9 + (65535 & n10 >> 16);
        int n12 = n4 * 8346 + (s4 & 65535);
        short s5 = (short)n12;
        int n13 = n11 + (65535 & n12 >> 16);
        short s6 = (short)(s5 & 65535);
        short s7 = (short)n13;
        short s8 = (short)(n4 * 154 + (s7 & 65535));
        return (Integer.MAX_VALUE & (s6 & 65535 | (s8 & 65535) << 16)) >> 9;
    }

    public static void AsymmetricMultiply(short[] arrs, int n2, short[] arrs2, int n3, short[] arrs3, int n4, int n5, short[] arrs4, int n6, int n7) {
        int n8;
        int n9;
        int n10;
        short[] arrs5;
        short[] arrs6;
        int n11 = n5;
        if (n11 == n7) {
            if (n4 == n6 && arrs3 == arrs4) {
                EInteger.RecursiveSquare(arrs, n2, arrs2, n3, arrs3, n4, n5);
                return;
            }
            if (n11 == 2) {
                EInteger.BaselineMultiply2(arrs, n2, arrs3, n4, arrs4, n6);
                return;
            }
            EInteger.SameSizeMultiply(arrs, n2, arrs2, n3, arrs3, n4, arrs4, n6, n5);
            return;
        }
        if (n11 > n7) {
            arrs6 = arrs3;
            n8 = n4;
            arrs5 = arrs4;
            n10 = n6;
            n9 = n11;
            n11 = n7;
        } else {
            n9 = n7;
            arrs5 = arrs3;
            n10 = n4;
            arrs6 = arrs4;
            n8 = n6;
        }
        int n12 = 1;
        if (n11 != n12 && (n11 != 2 || arrs5[n10 + 1] != 0)) {
            if (n11 == 2 && (n9 & 1) == 0) {
                int n13 = 65535 & arrs5[n10];
                int n14 = 65535 & arrs5[n10 + n12];
                int n15 = n2 + n9;
                arrs[n15] = 0;
                arrs[n15 + n12] = 0;
                int n16 = 65535 & n14 - n13;
                int n17 = n14 & 65535;
                int n18 = n13 & 65535;
                if (n17 >= n18) {
                    for (int i2 = 0; i2 < n9; i2 += 4) {
                        int n19;
                        short s;
                        int n20 = n8 + i2;
                        int n21 = 65535 & arrs6[n20];
                        int n22 = 65535 & arrs6[n20 + n12];
                        int n23 = n2 + i2;
                        if (n21 >= n22) {
                            n19 = n16 * (65535 & n21 - n22);
                            s = 0;
                        } else {
                            short s2 = (short)n16;
                            int n24 = (s2 & 65535) * (65535 & n21 - n22);
                            s = s2;
                            n19 = n24;
                        }
                        int n25 = n21 * n18;
                        int n26 = n25 & 65535;
                        arrs[n23] = (short)n26;
                        int n27 = 65535 & n25 >> 16;
                        int n28 = n22 * n17;
                        int n29 = n26 + n27 + (n19 & 65535) + (n28 & 65535);
                        arrs[n23 + 1] = (short)n29;
                        int n30 = n27 + (n28 + (65535 & n29 >> 16)) + (65535 & n19 >> 16) + (65535 & n28 >> 16) - (s & 65535);
                        arrs[n23 + 2] = (short)n30;
                        int n31 = n30 >> 16;
                        arrs[n23 + 3] = (short)n31;
                        n12 = 1;
                    }
                } else {
                    for (int i3 = 0; i3 < n9; i3 += 4) {
                        int n32;
                        short s;
                        int n33 = n8 + i3;
                        int n34 = 65535 & arrs6[n33];
                        int n35 = 65535 & arrs6[n33 + 1];
                        int n36 = n2 + i3;
                        if (n34 > n35) {
                            s = (short)(65535 & n34 - n35);
                            n32 = n16 * (s & 65535);
                        } else {
                            n32 = (65535 & n18 - n17) * (65535 & n35 - n34);
                            s = 0;
                        }
                        int n37 = n34 * n18;
                        int n38 = 65535 & n37 >> 16;
                        int n39 = n37 & 65535;
                        arrs[n36] = (short)n39;
                        int n40 = n35 * n17;
                        int n41 = n39 + n38 + (n32 & 65535) + (n40 & 65535);
                        int n42 = n36 + 1;
                        int n43 = n16;
                        arrs[n42] = (short)n41;
                        int n44 = n38 + (n40 + (65535 & n41 >> 16)) + (65535 & n32 >> 16) + (65535 & n40 >> 16) - (s & 65535);
                        arrs[n36 + 2] = (short)n44;
                        int n45 = n44 >> 16;
                        arrs[n36 + 3] = (short)n45;
                        n16 = n43;
                    }
                }
                int n46 = n16;
                if (n17 >= n18) {
                    for (int i4 = 2; i4 < n9; i4 += 4) {
                        int n47;
                        int n48;
                        short s;
                        int n49 = n8 + i4;
                        int n50 = 65535 & arrs6[n49];
                        int n51 = 65535 & arrs6[n49 + 1];
                        int n52 = n2 + i4;
                        if (n50 >= n51) {
                            n47 = n46 * (65535 & n50 - n51);
                            n48 = n46;
                            s = 0;
                        } else {
                            n48 = n46;
                            s = (short)n48;
                            n47 = (s & 65535) * (65535 & n50 - n51);
                        }
                        int n53 = n50 * n18;
                        int n54 = 65535 & n53 >> 16;
                        int n55 = n53 + (65535 & arrs[n52]);
                        int n56 = n18;
                        arrs[n52] = (short)(n55 & 65535);
                        int n57 = n51 * n17;
                        int n58 = n57 & 65535;
                        int n59 = 65535 & n57 >> 16;
                        int n60 = n58 + ((65535 & n55 >> 16) + (n53 & 65535) + (n47 & 65535));
                        int n61 = n52 + 1;
                        int n62 = n60 + (65535 & arrs[n61]);
                        int n63 = n17;
                        arrs[n61] = (short)(n62 & 65535);
                        int n64 = n59 + (n54 + (n58 + (65535 & n62 >> 16)) + (65535 & n47 >> 16)) - (s & 65535);
                        int n65 = n52 + 2;
                        int n66 = n64 + (65535 & arrs[n65]);
                        arrs[n65] = (short)(n66 & 65535);
                        int n67 = n59 + (65535 & n66 >> 16);
                        int n68 = n52 + 3;
                        int n69 = n67 + (65535 & arrs[n68]);
                        arrs[n68] = (short)(n69 & 65535);
                        if (n69 >> 16 != 0) {
                            int n70 = n52 + 4;
                            arrs[n70] = (short)(1 + arrs[n70]);
                            int n71 = n52 + 5;
                            short s3 = arrs[n71];
                            boolean bl = arrs[n70] == 0;
                            arrs[n71] = (short)(s3 + (short)(bl ? 1 : 0));
                        }
                        n18 = n56;
                        n17 = n63;
                        n46 = n48;
                    }
                } else {
                    int n72 = n46;
                    int n73 = n18;
                    int n74 = n17;
                    for (int i5 = 2; i5 < n9; i5 += 4) {
                        short s;
                        int n75;
                        int n76 = n8 + i5;
                        int n77 = 65535 & arrs6[n76];
                        int n78 = 65535 & arrs6[n76 + 1];
                        int n79 = n2 + i5;
                        if (n77 > n78) {
                            s = (short)(65535 & n77 - n78);
                            n75 = n72 * (s & 65535);
                        } else {
                            n75 = (65535 & n73 - n74) * (65535 & n78 - n77);
                            s = 0;
                        }
                        int n80 = n77 * n73;
                        int n81 = 65535 & n80 >> 16;
                        int n82 = n80 + (65535 & arrs[n79]);
                        arrs[n79] = (short)(n82 & 65535);
                        int n83 = n78 * n74;
                        int n84 = n83 & 65535;
                        int n85 = 65535 & n83 >> 16;
                        int n86 = n84 + ((65535 & n82 >> 16) + (n80 & 65535) + (n75 & 65535));
                        int n87 = n79 + 1;
                        int n88 = n86 + (65535 & arrs[n87]);
                        arrs[n87] = (short)(n88 & 65535);
                        int n89 = n85 + (n81 + (n84 + (65535 & n88 >> 16)) + (65535 & n75 >> 16)) - (s & 65535);
                        int n90 = n79 + 2;
                        int n91 = n89 + (65535 & arrs[n90]);
                        arrs[n90] = (short)(n91 & 65535);
                        int n92 = n85 + (65535 & n91 >> 16);
                        int n93 = n79 + 3;
                        int n94 = n92 + (65535 & arrs[n93]);
                        arrs[n93] = (short)(n94 & 65535);
                        if (n94 >> 16 == 0) continue;
                        int n95 = n79 + 4;
                        arrs[n95] = (short)(1 + arrs[n95]);
                        int n96 = n79 + 5;
                        short s4 = arrs[n96];
                        boolean bl = arrs[n95] == 0;
                        arrs[n96] = (short)(s4 + (short)(bl ? 1 : 0));
                    }
                }
                return;
            }
            if (n11 <= 10 && n9 <= 10) {
                EInteger.SchoolbookMultiply(arrs, n2, arrs5, n10, n11, arrs6, n8, n9);
                return;
            }
            int n97 = n9 % n11;
            int n98 = 1 & n9 / n11;
            if (n97 == 0) {
                int n99;
                if (n98 == 0) {
                    short[] arrs7 = arrs5;
                    int n100 = n10;
                    short[] arrs8 = arrs6;
                    int n101 = n8;
                    EInteger.SameSizeMultiply(arrs, n2, arrs2, n3, arrs7, n100, arrs8, n101, n11);
                    int n102 = n2 + n11;
                    int n103 = n11 << 1;
                    System.arraycopy((Object)arrs, (int)n102, (Object)arrs2, (int)(n3 + n103), (int)n11);
                    int n104 = n103;
                    while (n104 < n9) {
                        int n105 = n104 + (n3 + n11);
                        int n106 = n8 + n104;
                        short[] arrs9 = arrs5;
                        int n107 = n10;
                        int n108 = n104;
                        short[] arrs10 = arrs6;
                        EInteger.SameSizeMultiply(arrs2, n105, arrs2, n3, arrs9, n107, arrs10, n106, n11);
                        n104 = n108 + n103;
                    }
                    int n109 = n11;
                    while (n11 < n9) {
                        int n110 = n2 + n11;
                        int n111 = n8 + n11;
                        short[] arrs11 = arrs5;
                        int n112 = n10;
                        short[] arrs12 = arrs6;
                        int n113 = n11;
                        EInteger.SameSizeMultiply(arrs, n110, arrs2, n3, arrs11, n112, arrs12, n111, n109);
                        n11 = n113 + n103;
                    }
                    n99 = n109;
                } else {
                    int n114 = n11;
                    int n115 = 0;
                    while (n115 < n9) {
                        int n116 = n2 + n115;
                        int n117 = n8 + n115;
                        short[] arrs13 = arrs5;
                        int n118 = n10;
                        short[] arrs14 = arrs6;
                        int n119 = n115;
                        EInteger.SameSizeMultiply(arrs, n116, arrs2, n3, arrs13, n118, arrs14, n117, n114);
                        n115 = n119 + (n114 << 1);
                    }
                    int n120 = n99 = n114;
                    while (n120 < n9) {
                        int n121 = n120 + (n3 + n99);
                        int n122 = n8 + n120;
                        short[] arrs15 = arrs5;
                        int n123 = n10;
                        short[] arrs16 = arrs6;
                        int n124 = n120;
                        EInteger.SameSizeMultiply(arrs2, n121, arrs2, n3, arrs15, n123, arrs16, n122, n99);
                        n120 = n124 + (n99 << 1);
                    }
                }
                int n125 = n2 + n99;
                if (EInteger.AddInternal(arrs, n125, arrs, n125, arrs2, n3 + (n99 << 1), n9 - n99) != 0) {
                    EInteger.Increment(arrs, n2 + n9, n99, (short)1);
                    return;
                }
            } else {
                int n126 = n11 + n9;
                int n127 = n11 << 2;
                if (n126 >= n127) {
                    short[] arrs17 = arrs6;
                    int n128 = n8;
                    int n129 = n9;
                    short[] arrs18 = arrs5;
                    int n130 = n11;
                    EInteger.ChunkedLinearMultiply(arrs, n2, arrs2, n3, arrs17, n128, n129, arrs18, n10, n130);
                    return;
                }
                if (n11 + 1 != n9 && (n11 + 2 != n9 || arrs6[n8 + n9 - 1] != 0)) {
                    short[] arrs19 = new short[n127];
                    short[] arrs20 = arrs6;
                    int n131 = n8;
                    int n132 = n9;
                    short[] arrs21 = arrs5;
                    int n133 = n11;
                    EInteger.ChunkedLinearMultiply(arrs, n2, arrs19, 0, arrs20, n131, n132, arrs21, n10, n133);
                    return;
                }
                int n134 = n11;
                Arrays.fill((short[])arrs, (int)n2, (int)(n126 + n2), (short)0);
                EInteger.SameSizeMultiply(arrs, n2, arrs2, n3, arrs5, n10, arrs6, n8, n134);
                int n135 = n2 + n134;
                int n136 = 65535 & arrs6[n8 + n134];
                short s = 0;
                for (int i6 = 0; i6 < n134; ++i6) {
                    int n137 = n136 * (65535 & arrs5[n10 + i6]) + (s & 65535);
                    int n138 = n135 + i6;
                    int n139 = n137 + (65535 & arrs[n138]);
                    arrs[n138] = (short)n139;
                    short s5 = (short)(n139 >> 16);
                    s = s5;
                }
                arrs[n135 + n134] = s;
            }
            return;
        }
        int n140 = n12;
        short s = arrs5[n10];
        if (s != 0) {
            if (s != n140) {
                int n141 = n2 + n9;
                short s6 = arrs5[n10];
                arrs[n141] = EInteger.LinearMultiply(arrs, n2, arrs6, n8, s6, n9);
                arrs[n141 + n140] = 0;
                return;
            }
            System.arraycopy((Object)arrs6, (int)n8, (Object)arrs, (int)n2, (int)n9);
            int n142 = n2 + n9;
            arrs[n142] = 0;
            arrs[n142 + n140] = 0;
            return;
        }
        Arrays.fill((short[])arrs, (int)n2, (int)(n2 + (n9 + 2)), (short)0);
    }

    public static void BaselineMultiply2(short[] arrs, int n2, short[] arrs2, int n3, short[] arrs3, int n4) {
        int n5 = 65535 & arrs2[n3];
        int n6 = 65535 & arrs2[n3 + 1];
        int n7 = 65535 & arrs3[n4];
        int n8 = 65535 & arrs3[n4 + 1];
        int n9 = n5 * n7;
        short s = (short)n9;
        int n10 = 65535 & n9 >> 16;
        arrs[n2] = s;
        short s2 = (short)n10;
        int n11 = 65535 & n10 >> 16;
        int n12 = n5 * n8 + (s2 & 65535);
        short s3 = (short)n12;
        int n13 = n11 + (65535 & n12 >> 16);
        int n14 = n7 * n6 + (s3 & 65535);
        short s4 = (short)n14;
        int n15 = n13 + (65535 & n14 >> 16);
        arrs[n2 + 1] = s4;
        int n16 = n15 + n6 * n8;
        arrs[n2 + 2] = (short)n16;
        arrs[n2 + 3] = (short)(n16 >> 16);
    }

    public static void BaselineMultiply8(short[] arrs, int n2, short[] arrs2, int n3, short[] arrs3, int n4) {
        int n5 = (65535 & arrs2[n3]) * (65535 & arrs3[n4]);
        short s = (short)n5;
        int n6 = 65535 & n5 >> 16;
        arrs[n2] = s;
        short s2 = (short)n6;
        int n7 = 65535 & n6 >> 16;
        int n8 = 65535 & arrs2[n3];
        int n9 = n4 + 1;
        int n10 = n8 * (65535 & arrs3[n9]) + (s2 & 65535);
        short s3 = (short)n10;
        int n11 = n7 + (65535 & n10 >> 16);
        int n12 = n3 + 1;
        int n13 = (65535 & arrs2[n12]) * (65535 & arrs3[n4]) + (s3 & 65535);
        short s4 = (short)n13;
        int n14 = n11 + (65535 & n13 >> 16);
        arrs[n2 + 1] = s4;
        short s5 = (short)n14;
        int n15 = 65535 & n14 >> 16;
        int n16 = 65535 & arrs2[n3];
        int n17 = n4 + 2;
        int n18 = n16 * (65535 & arrs3[n17]) + (s5 & 65535);
        short s6 = (short)n18;
        int n19 = n15 + (65535 & n18 >> 16);
        int n20 = (65535 & arrs2[n12]) * (65535 & arrs3[n9]) + (s6 & 65535);
        short s7 = (short)n20;
        int n21 = n19 + (65535 & n20 >> 16);
        int n22 = n3 + 2;
        int n23 = (65535 & arrs2[n22]) * (65535 & arrs3[n4]) + (s7 & 65535);
        short s8 = (short)n23;
        int n24 = n21 + (65535 & n23 >> 16);
        arrs[n2 + 2] = s8;
        short s9 = (short)n24;
        int n25 = 65535 & n24 >> 16;
        int n26 = 65535 & arrs2[n3];
        int n27 = n4 + 3;
        int n28 = n26 * (65535 & arrs3[n27]) + (s9 & 65535);
        short s10 = (short)n28;
        int n29 = n25 + (65535 & n28 >> 16);
        int n30 = (65535 & arrs2[n12]) * (65535 & arrs3[n17]) + (s10 & 65535);
        short s11 = (short)n30;
        int n31 = n29 + (65535 & n30 >> 16);
        int n32 = (65535 & arrs2[n22]) * (65535 & arrs3[n9]) + (s11 & 65535);
        short s12 = (short)n32;
        int n33 = n31 + (65535 & n32 >> 16);
        int n34 = n3 + 3;
        int n35 = (65535 & arrs2[n34]) * (65535 & arrs3[n4]) + (s12 & 65535);
        short s13 = (short)n35;
        int n36 = n33 + (65535 & n35 >> 16);
        arrs[n2 + 3] = s13;
        short s14 = (short)n36;
        int n37 = 65535 & n36 >> 16;
        int n38 = 65535 & arrs2[n3];
        int n39 = n4 + 4;
        int n40 = n38 * (65535 & arrs3[n39]) + (s14 & 65535);
        short s15 = (short)n40;
        int n41 = n37 + (65535 & n40 >> 16);
        int n42 = (65535 & arrs2[n12]) * (65535 & arrs3[n27]) + (s15 & 65535);
        short s16 = (short)n42;
        int n43 = n41 + (65535 & n42 >> 16);
        int n44 = (65535 & arrs2[n22]) * (65535 & arrs3[n17]) + (s16 & 65535);
        short s17 = (short)n44;
        int n45 = n43 + (65535 & n44 >> 16);
        int n46 = (65535 & arrs2[n34]) * (65535 & arrs3[n9]) + (s17 & 65535);
        short s18 = (short)n46;
        int n47 = n45 + (65535 & n46 >> 16);
        int n48 = n3 + 4;
        int n49 = (65535 & arrs2[n48]) * (65535 & arrs3[n4]) + (s18 & 65535);
        short s19 = (short)n49;
        int n50 = n47 + (65535 & n49 >> 16);
        arrs[n2 + 4] = s19;
        short s20 = (short)n50;
        int n51 = 65535 & n50 >> 16;
        int n52 = 65535 & arrs2[n3];
        int n53 = n4 + 5;
        int n54 = n52 * (65535 & arrs3[n53]) + (s20 & 65535);
        short s21 = (short)n54;
        int n55 = n51 + (65535 & n54 >> 16);
        int n56 = (65535 & arrs2[n12]) * (65535 & arrs3[n39]) + (s21 & 65535);
        short s22 = (short)n56;
        int n57 = n55 + (65535 & n56 >> 16);
        int n58 = (65535 & arrs2[n22]) * (65535 & arrs3[n27]) + (s22 & 65535);
        short s23 = (short)n58;
        int n59 = n57 + (65535 & n58 >> 16);
        int n60 = (65535 & arrs2[n34]) * (65535 & arrs3[n17]) + (s23 & 65535);
        short s24 = (short)n60;
        int n61 = n59 + (65535 & n60 >> 16);
        int n62 = (65535 & arrs2[n48]) * (65535 & arrs3[n9]) + (s24 & 65535);
        short s25 = (short)n62;
        int n63 = n61 + (65535 & n62 >> 16);
        int n64 = n3 + 5;
        int n65 = (65535 & arrs2[n64]) * (65535 & arrs3[n4]) + (s25 & 65535);
        short s26 = (short)n65;
        int n66 = n63 + (65535 & n65 >> 16);
        arrs[n2 + 5] = s26;
        short s27 = (short)n66;
        int n67 = 65535 & n66 >> 16;
        int n68 = 65535 & arrs2[n3];
        int n69 = n4 + 6;
        int n70 = n68 * (65535 & arrs3[n69]) + (s27 & 65535);
        short s28 = (short)n70;
        int n71 = n67 + (65535 & n70 >> 16);
        int n72 = (65535 & arrs2[n12]) * (65535 & arrs3[n53]) + (s28 & 65535);
        short s29 = (short)n72;
        int n73 = n71 + (65535 & n72 >> 16);
        int n74 = (65535 & arrs2[n22]) * (65535 & arrs3[n39]) + (s29 & 65535);
        short s30 = (short)n74;
        int n75 = n73 + (65535 & n74 >> 16);
        int n76 = (65535 & arrs2[n34]) * (65535 & arrs3[n27]) + (s30 & 65535);
        short s31 = (short)n76;
        int n77 = n75 + (65535 & n76 >> 16);
        int n78 = (65535 & arrs2[n48]) * (65535 & arrs3[n17]) + (s31 & 65535);
        short s32 = (short)n78;
        int n79 = n77 + (65535 & n78 >> 16);
        int n80 = (65535 & arrs2[n64]) * (65535 & arrs3[n9]) + (s32 & 65535);
        short s33 = (short)n80;
        int n81 = n79 + (65535 & n80 >> 16);
        int n82 = n3 + 6;
        int n83 = (65535 & arrs2[n82]) * (65535 & arrs3[n4]) + (s33 & 65535);
        short s34 = (short)n83;
        int n84 = n81 + (65535 & n83 >> 16);
        arrs[n2 + 6] = s34;
        short s35 = (short)n84;
        int n85 = 65535 & n84 >> 16;
        int n86 = 65535 & arrs2[n3];
        int n87 = n4 + 7;
        int n88 = n86 * (65535 & arrs3[n87]) + (s35 & 65535);
        short s36 = (short)n88;
        int n89 = n85 + (65535 & n88 >> 16);
        int n90 = (65535 & arrs2[n12]) * (65535 & arrs3[n69]) + (s36 & 65535);
        short s37 = (short)n90;
        int n91 = n89 + (65535 & n90 >> 16);
        int n92 = (65535 & arrs2[n22]) * (65535 & arrs3[n53]) + (s37 & 65535);
        short s38 = (short)n92;
        int n93 = n91 + (65535 & n92 >> 16);
        int n94 = (65535 & arrs2[n34]) * (65535 & arrs3[n39]) + (s38 & 65535);
        short s39 = (short)n94;
        int n95 = n93 + (65535 & n94 >> 16);
        int n96 = (65535 & arrs2[n48]) * (65535 & arrs3[n27]) + (s39 & 65535);
        short s40 = (short)n96;
        int n97 = n95 + (65535 & n96 >> 16);
        int n98 = (65535 & arrs2[n64]) * (65535 & arrs3[n17]) + (s40 & 65535);
        short s41 = (short)n98;
        int n99 = n97 + (65535 & n98 >> 16);
        int n100 = (65535 & arrs2[n82]) * (65535 & arrs3[n9]) + (s41 & 65535);
        short s42 = (short)n100;
        int n101 = n99 + (65535 & n100 >> 16);
        int n102 = n3 + 7;
        int n103 = (65535 & arrs2[n102]) * (65535 & arrs3[n4]) + (s42 & 65535);
        short s43 = (short)n103;
        int n104 = n101 + (65535 & n103 >> 16);
        arrs[n2 + 7] = s43;
        short s44 = (short)n104;
        int n105 = 65535 & n104 >> 16;
        int n106 = (65535 & arrs2[n12]) * (65535 & arrs3[n87]) + (s44 & 65535);
        short s45 = (short)n106;
        int n107 = n105 + (65535 & n106 >> 16);
        int n108 = (65535 & arrs2[n22]) * (65535 & arrs3[n69]) + (s45 & 65535);
        short s46 = (short)n108;
        int n109 = n107 + (65535 & n108 >> 16);
        int n110 = (65535 & arrs2[n34]) * (65535 & arrs3[n53]) + (s46 & 65535);
        short s47 = (short)n110;
        int n111 = n109 + (65535 & n110 >> 16);
        int n112 = (65535 & arrs2[n48]) * (65535 & arrs3[n39]) + (s47 & 65535);
        short s48 = (short)n112;
        int n113 = n111 + (65535 & n112 >> 16);
        int n114 = (65535 & arrs2[n64]) * (65535 & arrs3[n27]) + (s48 & 65535);
        short s49 = (short)n114;
        int n115 = n113 + (65535 & n114 >> 16);
        int n116 = (65535 & arrs2[n82]) * (65535 & arrs3[n17]) + (s49 & 65535);
        short s50 = (short)n116;
        int n117 = n115 + (65535 & n116 >> 16);
        int n118 = (65535 & arrs2[n102]) * (65535 & arrs3[n9]) + (s50 & 65535);
        short s51 = (short)n118;
        int n119 = n117 + (65535 & n118 >> 16);
        arrs[n2 + 8] = s51;
        short s52 = (short)n119;
        int n120 = 65535 & n119 >> 16;
        int n121 = (65535 & arrs2[n22]) * (65535 & arrs3[n87]) + (s52 & 65535);
        short s53 = (short)n121;
        int n122 = n120 + (65535 & n121 >> 16);
        int n123 = (65535 & arrs2[n34]) * (65535 & arrs3[n69]) + (s53 & 65535);
        short s54 = (short)n123;
        int n124 = n122 + (65535 & n123 >> 16);
        int n125 = (65535 & arrs2[n48]) * (65535 & arrs3[n53]) + (s54 & 65535);
        short s55 = (short)n125;
        int n126 = n124 + (65535 & n125 >> 16);
        int n127 = (65535 & arrs2[n64]) * (65535 & arrs3[n39]) + (s55 & 65535);
        short s56 = (short)n127;
        int n128 = n126 + (65535 & n127 >> 16);
        int n129 = (65535 & arrs2[n82]) * (65535 & arrs3[n27]) + (s56 & 65535);
        short s57 = (short)n129;
        int n130 = n128 + (65535 & n129 >> 16);
        int n131 = (65535 & arrs2[n102]) * (65535 & arrs3[n17]) + (s57 & 65535);
        short s58 = (short)n131;
        int n132 = n130 + (65535 & n131 >> 16);
        arrs[n2 + 9] = s58;
        short s59 = (short)n132;
        int n133 = 65535 & n132 >> 16;
        int n134 = (65535 & arrs2[n34]) * (65535 & arrs3[n87]) + (s59 & 65535);
        short s60 = (short)n134;
        int n135 = n133 + (65535 & n134 >> 16);
        int n136 = (65535 & arrs2[n48]) * (65535 & arrs3[n69]) + (s60 & 65535);
        short s61 = (short)n136;
        int n137 = n135 + (65535 & n136 >> 16);
        int n138 = (65535 & arrs2[n64]) * (65535 & arrs3[n53]) + (s61 & 65535);
        short s62 = (short)n138;
        int n139 = n137 + (65535 & n138 >> 16);
        int n140 = (65535 & arrs2[n82]) * (65535 & arrs3[n39]) + (s62 & 65535);
        short s63 = (short)n140;
        int n141 = n139 + (65535 & n140 >> 16);
        int n142 = (65535 & arrs2[n102]) * (65535 & arrs3[n27]) + (s63 & 65535);
        short s64 = (short)n142;
        int n143 = n141 + (65535 & n142 >> 16);
        arrs[n2 + 10] = s64;
        short s65 = (short)n143;
        int n144 = 65535 & n143 >> 16;
        int n145 = (65535 & arrs2[n48]) * (65535 & arrs3[n87]) + (s65 & 65535);
        short s66 = (short)n145;
        int n146 = n144 + (65535 & n145 >> 16);
        int n147 = (65535 & arrs2[n64]) * (65535 & arrs3[n69]) + (s66 & 65535);
        short s67 = (short)n147;
        int n148 = n146 + (65535 & n147 >> 16);
        int n149 = (65535 & arrs2[n82]) * (65535 & arrs3[n53]) + (s67 & 65535);
        short s68 = (short)n149;
        int n150 = n148 + (65535 & n149 >> 16);
        int n151 = (65535 & arrs2[n102]) * (65535 & arrs3[n39]) + (s68 & 65535);
        short s69 = (short)n151;
        int n152 = n150 + (65535 & n151 >> 16);
        arrs[n2 + 11] = s69;
        short s70 = (short)n152;
        int n153 = 65535 & n152 >> 16;
        int n154 = (65535 & arrs2[n64]) * (65535 & arrs3[n87]) + (s70 & 65535);
        short s71 = (short)n154;
        int n155 = n153 + (65535 & n154 >> 16);
        int n156 = (65535 & arrs2[n82]) * (65535 & arrs3[n69]) + (s71 & 65535);
        short s72 = (short)n156;
        int n157 = n155 + (65535 & n156 >> 16);
        int n158 = (65535 & arrs2[n102]) * (65535 & arrs3[n53]) + (s72 & 65535);
        short s73 = (short)n158;
        int n159 = n157 + (65535 & n158 >> 16);
        arrs[n2 + 12] = s73;
        short s74 = (short)n159;
        int n160 = 65535 & n159 >> 16;
        int n161 = (65535 & arrs2[n82]) * (65535 & arrs3[n87]) + (s74 & 65535);
        short s75 = (short)n161;
        int n162 = n160 + (65535 & n161 >> 16);
        int n163 = (65535 & arrs2[n102]) * (65535 & arrs3[n69]) + (s75 & 65535);
        short s76 = (short)n163;
        int n164 = n162 + (65535 & n163 >> 16);
        arrs[n2 + 13] = s76;
        int n165 = n164 + (65535 & arrs2[n102]) * (65535 & arrs3[n87]);
        arrs[n2 + 14] = (short)n165;
        arrs[n2 + 15] = (short)(n165 >> 16);
    }

    public static void ChunkedLinearMultiply(short[] arrs, int n2, short[] arrs2, int n3, short[] arrs3, int n4, int n5, short[] arrs4, int n6, int n7) {
        short[] arrs5 = arrs2;
        int n8 = n3;
        int n9 = n5;
        int n10 = n7;
        Arrays.fill((short[])arrs, (int)n2, (int)(n2 + n10), (short)0);
        int n11 = 0;
        int n12 = 0;
        while (n11 < n9) {
            int n13;
            short[] arrs6;
            int n14;
            int n15 = n9 - n11;
            if (n15 > n10) {
                EInteger.SameSizeMultiply(arrs2, n3, arrs2, n10 + (n8 + n10), arrs3, n4 + n11, arrs4, n6, n7);
                int n16 = n10 + n10;
                int n17 = n2 + n12;
                n13 = n11;
                int n18 = n8;
                short[] arrs7 = arrs5;
                EInteger.AddUnevenSize(arrs2, n3, arrs2, n3, n16, arrs, n17, n7);
                System.arraycopy((Object)arrs7, (int)n18, (Object)arrs, (int)(n2 + n13), (int)n16);
                n12 += n7;
                arrs6 = arrs7;
                n14 = n18;
            } else {
                n13 = n11;
                int n19 = n8;
                EInteger.AsymmetricMultiply(arrs2, n3, arrs2, n7 + (n19 + n15), arrs3, n4 + n13, n15, arrs4, n6, n7);
                int n20 = n15 + n7;
                int n21 = n2 + n12;
                n14 = n8;
                arrs6 = arrs5;
                EInteger.AddUnevenSize(arrs2, n3, arrs2, n3, n20, arrs, n21, n7);
                System.arraycopy((Object)arrs6, (int)n14, (Object)arrs, (int)(n2 + n13), (int)n20);
            }
            n11 = n13 + n7;
            n9 = n5;
            n10 = n7;
            arrs5 = arrs6;
            n8 = n14;
        }
    }

    public static int Compare(short[] arrs, int n2, short[] arrs2, int n3, int n4) {
        do {
            int n5 = n4 - 1;
            if (n4 == 0) break;
            int n6 = 65535 & arrs[n2 + n5];
            int n7 = 65535 & arrs2[n3 + n5];
            if (n6 > n7) {
                return 1;
            }
            if (n6 < n7) {
                return -1;
            }
            n4 = n5;
        } while (true);
        return 0;
    }

    public static int CompareWithWords1IsOneBigger(short[] arrs, int n2, short[] arrs2, int n3, int n4) {
        if (arrs[n2 + n4 - 1] != 0) {
            return 1;
        }
        int n5 = n4 - 1;
        do {
            int n6 = n5 - 1;
            if (n5 == 0) break;
            int n7 = 65535 & arrs[n2 + n6];
            int n8 = 65535 & arrs2[n3 + n6];
            if (n7 > n8) {
                return 1;
            }
            if (n7 < n8) {
                return -1;
            }
            n5 = n6;
        } while (true);
        return 0;
    }

    public static int CountWords(short[] arrs) {
        int n2;
        int n3 = arrs.length;
        while (n3 != 0 && arrs[n2 = n3 - 1] == 0) {
            n3 = n2;
        }
        return n3;
    }

    public static int Decrement(short[] arrs, int n2, int n3, short s) {
        short s2 = arrs[n2];
        arrs[n2] = (short)(s2 - s);
        if ((65535 & arrs[n2]) <= (s2 & 65535)) {
            return 0;
        }
        for (int i2 = 1; i2 < n3; ++i2) {
            int n4 = n2 + i2;
            short s3 = arrs[n4];
            arrs[n4] = (short)(arrs[n4] - 1);
            if (s3 == 0) continue;
            return 0;
        }
        return 1;
    }

    public static void DivideThreeBlocksByTwo(short[] arrs, int n2, short[] arrs2, int n3, short[] arrs3, int n4, int n5, short[] arrs4, int n6, short[] arrs5, int n7, short[] arrs6) {
        int n8 = n3 + n5;
        int n9 = n4 + n5;
        if (EInteger.WordsCompare(arrs2, n8, n5, arrs3, n9, n5) < 0) {
            EInteger.RecursiveDivideInner(arrs2, n3, arrs3, n9, arrs4, n6, arrs5, n7, n5);
            System.arraycopy((Object)arrs5, (int)n7, (Object)arrs6, (int)(n5 * 4), (int)n5);
            int n10 = n5 * 5;
            Arrays.fill((short[])arrs6, (int)n10, (int)(n10 + n5), (short)0);
        } else {
            for (int i2 = 0; i2 < n5; ++i2) {
                arrs4[n6 + i2] = -1;
            }
            int n11 = n6 + n5;
            Arrays.fill((short[])arrs4, (int)n11, (int)(n11 + n5), (short)0);
            int n12 = n5 * 4;
            System.arraycopy((Object)arrs2, (int)n3, (Object)arrs6, (int)n12, (int)(n5 * 2));
            int n13 = n5 * 5;
            EInteger.SubtractInternal(arrs6, n13, arrs6, n13, arrs3, n9, n5);
            EInteger.Increment(arrs6, n13, n5, (short)EInteger.AddInternal(arrs6, n12, arrs6, n12, arrs3, n9, n5));
        }
        int n14 = n5 * 2;
        EInteger.AsymmetricMultiply(arrs6, 0, arrs6, n14, arrs4, n6, n5, arrs3, n4, n5);
        int n15 = n5 * 3;
        System.arraycopy((Object)arrs, (int)n2, (Object)arrs6, (int)n15, (int)n5);
        Arrays.fill((short[])arrs6, (int)n14, (int)(n14 + n5), (short)0);
        if (EInteger.SubtractInternal(arrs6, n15, arrs6, n15, arrs6, 0, n15) != 0) {
            int n16;
            do {
                int n17 = EInteger.AddInternal(arrs6, n15, arrs6, n15, arrs3, n4, n14);
                n16 = EInteger.Increment(arrs6, n5 * 5, n5, (short)n17);
                EInteger.Decrement(arrs4, n6, n14, (short)1);
            } while (n16 == 0);
        }
        System.arraycopy((Object)arrs6, (int)n15, (Object)arrs5, (int)n7, (int)n14);
    }

    public static short FastDivideAndRemainder(short[] arrs, int n2, short[] arrs2, int n3, int n4, short s) {
        int n5;
        int n6;
        int n7 = s & 65535;
        int n8 = -1 + (n3 + n4);
        int n9 = -1 + (n2 + n4);
        if (n7 >= 32768) {
            n5 = 0;
            for (n6 = 0; n6 < n4; ++n6) {
                int n10;
                int n11 = 65535 & arrs2[n8] | n5 << 16;
                int n12 = n11 >> 31;
                if (n12 == 0) {
                    n10 = n11 / n7;
                    arrs[n9] = (short)n10;
                } else {
                    int n13 = n12 == 0 ? n11 / n7 : (int)((0xFFFFFFFFL & (long)n11) / (long)n7);
                    n10 = 65535 & (short)n13;
                    arrs[n9] = (short)n10;
                }
                n5 = n11 - n10 * n7;
                --n8;
                --n9;
            }
        } else {
            n5 = 0;
            while (n6 < n4) {
                int n14 = 65535 & arrs2[n8] | n5 << 16;
                int n15 = n14 / n7;
                arrs[n9] = (short)n15;
                n5 = n14 - n15 * n7;
                --n8;
                --n9;
                ++n6;
            }
        }
        return (short)n5;
    }

    public static short FastDivideAndRemainderTen(short[] arrs, int n2, short[] arrs2, int n3, int n4) {
        int n5 = -1 + (n3 + n4);
        int n6 = -1 + (n2 + n4);
        int n7 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n8 = 65535 & arrs2[n5] | n7 << 16;
            int n9 = n8 < 43698 ? n8 * 26215 >> 18 : n8 / 10;
            arrs[n6] = (short)n9;
            n7 = n8 - n9 * 10;
            --n5;
            --n6;
        }
        return (short)n7;
    }

    public static short FastDivideAndRemainderTwo(short[] arrs, int n2, short[] arrs2, int n3, int n4) {
        int n5 = -1 + (n3 + n4);
        int n6 = -1 + (n2 + n4);
        int n7 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n8 = 65535 & arrs2[n5] | n7 << 16;
            arrs[n6] = (short)(n8 >> 1);
            n7 = n8 & 1;
            --n5;
            --n6;
        }
        return (short)n7;
    }

    public static EInteger FromBytes(byte[] arrby, boolean bl) {
        int n2;
        if (arrby.length == 0) {
            return EInteger.FromInt32(0);
        }
        int n3 = arrby.length;
        int n4 = n3 + 1 >> 1;
        short[] arrs = new short[n4];
        int n5 = bl ? n3 - 1 : 0;
        boolean bl2 = (128 & arrby[n5]) != 0;
        if (!bl2) {
            if (bl) {
                boolean bl3 = (n3 & 1) != 0;
                if (bl3) {
                    --n3;
                }
                int n6 = 0;
                int n7 = 0;
                while (n6 < n3) {
                    int n8 = n6 + 1;
                    arrs[n7] = (short)(255 & arrby[n6] | arrby[n8] << 8);
                    n6 += 2;
                    ++n7;
                }
                if (bl3) {
                    arrs[n3 >> 1] = (short)(255 & arrby[n3]);
                }
            } else {
                int n9 = 0;
                int n10 = 0;
                while (n9 < n3) {
                    int n11 = n3 - 1 - n9;
                    int n12 = n3 - 2 - n9;
                    int n13 = 255 & arrby[n11];
                    if (n12 >= 0 && n12 < n3) {
                        n13 |= arrby[n12] << 8;
                    }
                    arrs[n10] = (short)n13;
                    n9 += 2;
                    ++n10;
                }
            }
        } else {
            int n14 = 0;
            int n15 = 0;
            while (n14 < n3) {
                int n16 = bl ? n14 : n3 - 1 - n14;
                int n17 = bl ? n14 + 1 : n3 - 2 - n14;
                int n18 = 255 & arrby[n16];
                int n19 = n17 >= 0 && n17 < n3 ? arrby[n17] << 8 : 65280;
                arrs[n15] = (short)(n18 | n19);
                n14 += 2;
                ++n15;
            }
            while (n15 < n4) {
                arrs[n15] = -1;
                ++n15;
            }
            EInteger.TwosComplement(arrs, 0, n4);
        }
        while (n4 != 0 && arrs[n2 = n4 - 1] == 0) {
            n4 = n2;
        }
        if (n4 == 0) {
            return EInteger.FromInt32(0);
        }
        return new EInteger(n4, arrs, bl2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static EInteger FromInt32(int n2) {
        short[] arrs;
        if (n2 == 0) {
            return ValueZero;
        }
        int n3 = 1;
        if (n2 == n3) {
            return ValueOne;
        }
        if (n2 == 10) {
            return ValueTen;
        }
        int n4 = n2 < 0 ? n3 : 0;
        if (n2 >> 15 == 0) {
            arrs = new short[2];
            if (n4 != 0) {
                n2 = -n2;
            }
            arrs[0] = (short)(n2 & 65535);
            return new EInteger(n3, arrs, (boolean)n4);
        }
        if (n2 == Integer.MIN_VALUE) {
            arrs = new short[]{0, -32768};
        } else {
            arrs = new short[2];
            if (n4 != 0) {
                n2 = -n2;
            }
            arrs[0] = (short)(n2 & 65535);
            arrs[n3] = (short)(65535 & n2 >> 16);
            if (arrs[n3] == 0) {
                return new EInteger(n3, arrs, (boolean)n4);
            }
        }
        n3 = 2;
        return new EInteger(n3, arrs, (boolean)n4);
    }

    public static EInteger FromInt64(long l2) {
        short[] arrs;
        long l3 = l2 LCMP 0L;
        if (l3 == false) {
            return ValueZero;
        }
        if (l2 == 1L) {
            return ValueOne;
        }
        if (l2 == 10L) {
            return ValueTen;
        }
        int n2 = 1;
        int n3 = l3 < 0 ? n2 : 0;
        if (l2 >> 16 == 0L) {
            arrs = new short[n2];
            int n4 = (int)l2;
            if (n3 != 0) {
                n4 = -n4;
            }
            arrs[0] = (short)(n4 & 65535);
        } else if (l2 >> 31 == 0L) {
            arrs = new short[2];
            int n5 = (int)l2;
            if (n3 != 0) {
                n5 = -n5;
            }
            arrs[0] = (short)(n5 & 65535);
            arrs[n2] = (short)(65535 & n5 >> 16);
            n2 = 2;
        } else if (l2 == Long.MIN_VALUE) {
            arrs = new short[]{0, 0, 0, -32768};
            n2 = 4;
        } else {
            arrs = new short[4];
            if (n3 != 0) {
                l2 = -l2;
            }
            arrs[0] = (short)(l2 & 65535L);
            long l4 = l2 >> 16;
            arrs[n2] = (short)(l4 & 65535L);
            long l5 = l4 >> 16;
            arrs[2] = (short)(l5 & 65535L);
            arrs[3] = (short)(65535L & l5 >> 16);
            for (n2 = 4; n2 != 0 && arrs[n2 - 1] == 0; --n2) {
            }
        }
        return new EInteger(n2, arrs, (boolean)n3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static EInteger FromSubstring(String string, int n2, int n3) {
        if (n2 < 0) throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"index (", (int)n2, (String)") is less than 0"));
        if (n2 <= string.length()) {
            if (n3 < 0) throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"endIndex (", (int)n3, (String)") is less than 0"));
            if (n3 <= string.length()) {
                int n4;
                int n5;
                if (n3 < n2) throw new IllegalArgumentException(GeneratedOutlineSupport.outline13((String)"endIndex (", (int)n3, (String)") is less than ", (int)n2));
                if (n2 == n3) throw new NumberFormatException("No digits");
                char c2 = string.charAt(n2);
                int n6 = 1;
                if (c2 == '-') {
                    if (++n2 == n3) throw new NumberFormatException("No digits");
                    n5 = n6;
                } else {
                    n5 = 0;
                }
                while (n2 < n3 && string.charAt(n2) == '0') {
                    ++n2;
                }
                if (n3 - n2 == 0) {
                    return EInteger.FromInt32(0);
                }
                short[] arrs = new short[4];
                int n7 = ValueMaxSafeInts[8];
                int n8 = 0;
                int n9 = n6;
                while (n2 < n3) {
                    char c3 = string.charAt(n2);
                    int n10 = c3 >= '' ? 36 : ValueCharToDigit[c3];
                    if (n10 >= 10) throw new NumberFormatException("Illegal character found");
                    if (n6 != 0 && n8 < n7) {
                        n8 = n10 + n8 * 10;
                    } else {
                        if (n6 != 0) {
                            arrs[0] = (short)(n8 & 65535);
                            arrs[n9] = (short)(65535 & n8 >> 16);
                            n6 = 0;
                        }
                        int n11 = arrs.length;
                        short s = 0;
                        for (int i2 = 0; i2 < n11; ++i2) {
                            int n12 = 10 * (65535 & arrs[i2]) + (s & 65535);
                            arrs[i2] = (short)n12;
                            s = (short)(n12 >> 16);
                        }
                        if (s != 0) {
                            arrs = EInteger.GrowForCarry(arrs, s);
                        }
                        if (n10 != 0) {
                            int n13 = 65535 & arrs[0];
                            if (n13 <= 65526) {
                                arrs[0] = (short)(n13 + n10);
                            } else if (EInteger.Increment(arrs, 0, arrs.length, (short)n10) != 0) {
                                arrs = EInteger.GrowForCarry(arrs, (short)1);
                            }
                        }
                    }
                    ++n2;
                    n9 = 1;
                }
                if (n6 != 0) {
                    arrs[0] = (short)(n8 & 65535);
                    arrs[1] = (short)(65535 & n8 >> 16);
                }
                if ((n4 = EInteger.CountWords(arrs)) != 0) return new EInteger(n4, arrs, (boolean)n5);
                return EInteger.FromInt32(0);
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline25((String)"endIndex (", (int)n3, (String)") is more than ");
            stringBuilder.append(string.length());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline25((String)"index (", (int)n2, (String)") is more than ");
        stringBuilder.append(string.length());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     */
    public static EInteger GcdLong(long l2, long l3) {
        long l4;
        long l5;
        long l6;
        int n2 = 0;
        while ((l6 = (l2 LCMP 0L)) != false && l3 != 0L && (l4 = (l2 LCMP l3)) != false) {
            block12 : {
                block10 : {
                    block11 : {
                        block9 : {
                            boolean bl;
                            boolean bl2;
                            block8 : {
                                bl = (l2 & 1L) == 0L;
                                bl2 = (1L & l3) == 0L;
                                if (!bl || !bl2) break block8;
                                ++n2;
                                l2 >>= 1;
                                break block9;
                            }
                            if (bl && !bl2) break block10;
                            if (bl || !bl2) break block11;
                        }
                        l3 >>= 1;
                        continue;
                    }
                    if (l4 < 0) break block12;
                    l2 -= l3;
                }
                l2 >>= 1;
                continue;
            }
            long l7 = l3 - l2 >> 1;
            long l8 = l2;
            l2 = l7;
            l3 = l8;
        }
        if (l6 == false) {
            l5 = l3 << n2;
            return EInteger.FromInt64(l5);
        }
        l5 = l2 << n2;
        return EInteger.FromInt64(l5);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static void GeneralDivide(short[] var0, int var1_1, int var2_2, short[] var3_3, int var4_4, int var5_5, short[] var6_6, int var7_7, short[] var8_8, int var9_9) {
        block39 : {
            var10_10 = 1 + (var2_2 - var5_5);
            for (var11_11 = var5_5; var11_11 > 0 && var3_3[var4_4 + var11_11 - 1] == 0; --var11_11) {
            }
            for (var12_12 = var2_2; var12_12 > 0 && var0[var1_1 + var12_12 - 1] == 0; --var12_12) {
            }
            var13_13 = var12_12 - var11_11;
            var14_14 = var13_13 + 1;
            var15_15 = 0;
            if (var6_6 != null) {
                if (var14_14 >= 0 && var14_14 < var10_10) {
                    var106_16 = var7_7 + var14_14;
                    Arrays.fill((short[])var6_6, (int)var106_16, (int)(var106_16 + Math.max((int)0, (int)(var10_10 - var14_14))), (short)0);
                } else {
                    Arrays.fill((short[])var6_6, (int)var7_7, (int)(var7_7 + Math.max((int)0, (int)var10_10)), (short)0);
                }
            }
            if (var8_8 != null) {
                var105_17 = var9_9 + var11_11;
                Arrays.fill((short[])var8_8, (int)var105_17, (int)(var105_17 + (var5_5 - var11_11)), (short)0);
            }
            if (var12_12 < var11_11) {
                if (var6_6 != null) {
                    Arrays.fill((short[])var6_6, (int)var7_7, (int)(var7_7 + Math.max((int)0, (int)var10_10)), (short)0);
                }
                if (var8_8 == null) return;
                System.arraycopy((Object)var0, (int)var1_1, (Object)var8_8, (int)var9_9, (int)var2_2);
                return;
            }
            if (var12_12 == var11_11) {
                var103_18 = EInteger.Compare(var0, var1_1, var3_3, var4_4, var12_12);
                if (var103_18 == 0) {
                    if (var6_6 != null) {
                        var6_6[var7_7] = 1;
                        var104_19 = var7_7 + 1;
                        Arrays.fill((short[])var6_6, (int)var104_19, (int)(var104_19 + Math.max((int)0, (int)(var10_10 - 1))), (short)0);
                    }
                    if (var8_8 == null) return;
                    Arrays.fill((short[])var8_8, (int)var9_9, (int)(var9_9 + var12_12), (short)0);
                    return;
                }
                if (var103_18 < 0) {
                    if (var6_6 != null) {
                        Arrays.fill((short[])var6_6, (int)var7_7, (int)(var7_7 + Math.max((int)0, (int)var10_10)), (short)0);
                    }
                    if (var8_8 == null) return;
                    System.arraycopy((Object)var0, (int)var1_1, (Object)var8_8, (int)var9_9, (int)var2_2);
                    return;
                }
            }
            if (var11_11 == 1) {
                var101_20 = var3_3[var4_4];
                var102_21 = EInteger.FastDivideAndRemainder(var6_6, var7_7, var0, var1_1, var12_12, var101_20);
                if (var8_8 == null) return;
                var8_8[var9_9] = var102_21;
                return;
            }
            var16_22 = 40;
            if (var11_11 > var16_22) {
                while (var16_22 < var11_11) {
                    var16_22 <<= 1;
                }
                var79_23 = new short[var16_22];
                var80_24 = var16_22 - var11_11;
                System.arraycopy((Object)var3_3, (int)var4_4, (Object)var79_23, (int)var80_24, (int)var11_11);
                var81_25 = var12_12 + var80_24;
                var82_26 = var11_11 - 1;
                if ((32768 & var3_3[var82_26]) == 0) {
                    var98_27 = var3_3[var82_26];
                    var84_28 = 0;
                    while ((var98_27 & 32768) == 0) {
                        ++var84_28;
                        var98_27 <<= 1;
                    }
                    var99_29 = var0[var12_12 - 1];
                    while ((var99_29 & 32768) == 0) {
                        ++var15_15;
                        var99_29 <<= 1;
                    }
                    var83_30 = var15_15 < var84_28 ? 1 : 0;
                    EInteger.ShiftWordsLeftByBits(var79_23, var16_22 + 0 - var11_11, var11_11, var84_28);
                } else {
                    var83_30 = 0;
                    var84_28 = 0;
                }
                var85_31 = (var81_25 + var83_30 + (var16_22 - 1)) / var16_22;
                var86_32 = new short[var85_31 * var16_22];
                var87_33 = var80_24 + 0;
                System.arraycopy((Object)var0, (int)var1_1, (Object)var86_32, (int)var87_33, (int)var12_12);
                EInteger.ShiftWordsLeftByBits(var86_32, var87_33, var12_12 + var83_30, var84_28);
                var89_34 = new short[var16_22 * 5];
                var90_35 = var85_31 - 1;
                do {
                    if (var90_35 < 0) {
                        if (var8_8 == null) return;
                        System.arraycopy((Object)var89_34, (int)var80_24, (Object)var8_8, (int)var9_9, (int)var11_11);
                        EInteger.ShiftWordsRightByBits(var8_8, var9_9, var11_11, var84_28);
                        return;
                    }
                    var92_36 = var90_35 * var16_22;
                    System.arraycopy((Object)var86_32, (int)(var92_36 + 0), (Object)var89_34, (int)var16_22, (int)var16_22);
                    var93_37 = var16_22 * 3;
                    var94_38 = var16_22 << 1;
                    var95_39 = var93_37 + var94_38;
                    var96_40 = var86_32;
                    Arrays.fill((short[])var89_34, (int)var93_37, (int)var95_39, (short)0);
                    EInteger.RecursiveDivideInner(var89_34, var16_22, var79_23, 0, var89_34, var93_37, var89_34, 0, var16_22);
                    if (var6_6 != null && (var97_41 = Math.min((int)var16_22, (int)(var6_6.length - var92_36))) > 0) {
                        System.arraycopy((Object)var89_34, (int)var93_37, (Object)var6_6, (int)(var92_36 + var7_7), (int)var97_41);
                    }
                    System.arraycopy((Object)var89_34, (int)0, (Object)var89_34, (int)var94_38, (int)var16_22);
                    --var90_35;
                    var86_32 = var96_40;
                } while (true);
            }
            var17_42 = var4_4 + var11_11 - 1;
            if ((32768 & var3_3[var17_42]) == 0) {
                var75_43 = var3_3[var17_42];
                if (var75_43 == 0) throw new IllegalStateException();
                var76_44 = 0;
                while ((var75_43 & 32768) == 0) {
                    ++var76_44;
                    var75_43 <<= 1;
                }
                var19_45 = var12_12 + 1;
                var22_46 = new short[var19_45 + var11_11];
                System.arraycopy((Object)var0, (int)var1_1, (Object)var22_46, (int)0, (int)var12_12);
                System.arraycopy((Object)var3_3, (int)var4_4, (Object)var22_46, (int)var19_45, (int)var11_11);
                EInteger.ShiftWordsLeftByBits(var22_46, 0, var19_45, var76_44);
                EInteger.ShiftWordsLeftByBits(var22_46, var19_45, var11_11, var76_44);
                var20_47 = var22_46;
                var21_48 = var76_44;
                var23_49 = false;
            } else {
                var18_50 = new short[var12_12 + 1];
                System.arraycopy((Object)var0, (int)var1_1, (Object)var18_50, (int)0, (int)var12_12);
                var19_45 = var4_4;
                var20_47 = var18_50;
                var21_48 = 0;
                var22_46 = var3_3;
                var23_49 = true;
            }
            var24_51 = var19_45 + var11_11;
            var25_52 = 65535 & var22_46[var24_51 - 1];
            var26_53 = 0 + var12_12;
            var27_54 = 65535 & var22_46[var24_51 - 2];
            for (var28_55 = var13_13; var28_55 >= 0; --var28_55) {
                block41 : {
                    block40 : {
                        var33_56 = 0 + var28_55;
                        var34_57 = var33_56 + var11_11;
                        var35_58 = 65535 & var20_47[var34_57 - 1];
                        var36_59 = var23_49 && var34_57 >= var26_53 ? 0 : 65535 & var20_47[var34_57];
                        var37_60 = var35_58 + (var36_59 << 16);
                        var38_61 = 65535 & var20_47[var34_57 - 2];
                        if (var37_60 >> 31 == 0) {
                            var45_67 = var37_60 / var25_52;
                            var43_65 = var23_49;
                            var44_66 = var20_47;
                            var39_62 = var34_57;
                            var40_63 = var26_53;
                        } else {
                            var39_62 = var34_57;
                            var40_63 = var26_53;
                            var41_64 = 0xFFFFFFFFL & (long)var37_60;
                            var43_65 = var23_49;
                            var44_66 = var20_47;
                            var45_67 = (int)(var41_64 / (long)var25_52);
                        }
                        var46_68 = var37_60 - var45_67 * var25_52;
                        var47_69 = (long)var46_68 << 16;
                        var49_70 = 65535L & (long)var38_61;
                        var51_71 = var47_69 | var49_70;
                        if (var45_67 >> 16 != 0) break block40;
                        var74_91 = var45_67 * var27_54;
                        var53_72 = var22_46;
                        if ((0xFFFFFFFFL & (long)var74_91) <= var51_71) ** GOTO lbl-1000
                        break block41;
                    }
                    var53_72 = var22_46;
                }
                var54_73 = var46_68 + var25_52;
                --var45_67;
                if (var54_73 >> 16 != 0) ** GOTO lbl-1000
                var72_90 = var49_70 | (long)var54_73 << 16;
                if (var45_67 >> 16 != 0 || (0xFFFFFFFFL & (long)(var45_67 * var27_54)) > var72_90) {
                    var55_74 = var45_67 - 1;
                    if (var8_8 == null && var28_55 == 0) {
                        if (var6_6 != null) {
                            var6_6[var7_7 + var28_55] = (short)var55_74;
                        }
                        var29_92 = var44_66;
                        var30_93 = var11_11;
                        break block39;
                    }
                } else lbl-1000: // 3 sources:
                {
                    var55_74 = var45_67;
                }
                var56_75 = var55_74 & 65535;
                if (var11_11 <= 0) throw new IllegalArgumentException();
                if (var56_75 >> 16 != 0) throw new IllegalArgumentException();
                var58_77 = 0;
                for (var57_76 = 0; var57_76 < var11_11; ++var57_76) {
                    var69_87 = var56_75 * (65535 & var53_72[var19_45 + var57_76]) + (var58_77 & 65535);
                    var70_88 = var33_56 + var57_76;
                    var71_89 = (65535 & var44_66[var70_88]) - (var69_87 & 65535);
                    var44_66[var70_88] = (short)var71_89;
                    var58_77 = (65535 & var69_87 >> 16) + (1 & var71_89 >> 31);
                }
                var59_78 = var58_77 & 65535;
                var60_79 = (65535 & var44_66[var39_62]) - var59_78;
                var44_66[var39_62] = (short)var60_79;
                if ((short)(1 & var60_79 >> 31) != 0) {
                    var64_83 = var44_66;
                    var65_84 = var39_62;
                    var61_80 = var40_63;
                    var66_85 = var44_66;
                    var63_82 = var11_11;
                    var67_86 = (short)EInteger.AddInternal(var64_83, var33_56, var66_85, var33_56, var53_72, var19_45, var63_82);
                    var62_81 = var44_66;
                    EInteger.Increment(var62_81, var65_84, 1, var67_86);
                    --var55_74;
                } else {
                    var61_80 = var40_63;
                    var62_81 = var44_66;
                    var63_82 = var11_11;
                }
                if (var6_6 != null) {
                    var6_6[var7_7 + var28_55] = (short)var55_74;
                }
                var11_11 = var63_82;
                var23_49 = var43_65;
                var26_53 = var61_80;
                var20_47 = var62_81;
                var22_46 = var53_72;
            }
            var29_92 = var20_47;
            var30_93 = var11_11;
        }
        if (var8_8 == null) return;
        if (var21_48 != 0) {
            var31_94 = var30_93;
            EInteger.ShiftWordsRightByBits(var29_92, 0, var31_94 + 1, var21_48);
        } else {
            var31_94 = var30_93;
        }
        System.arraycopy((Object)var29_92, (int)0, (Object)var8_8, (int)var9_9, (int)var31_94);
    }

    public static short[] GrowForCarry(short[] arrs, short s) {
        int n2 = arrs.length;
        int n3 = n2 + 1;
        if (n3 > arrs.length) {
            short[] arrs2 = new short[n3];
            System.arraycopy((Object)arrs, (int)0, (Object)arrs2, (int)0, (int)arrs.length);
            arrs = arrs2;
        }
        arrs[n2] = s;
        return arrs;
    }

    public static int Increment(short[] arrs, int n2, int n3, short s) {
        short s2 = arrs[n2];
        arrs[n2] = (short)(s + s2);
        if ((65535 & arrs[n2]) >= (s2 & 65535)) {
            return 0;
        }
        for (int i2 = 1; i2 < n3; ++i2) {
            int n4 = n2 + i2;
            arrs[n4] = (short)(1 + arrs[n4]);
            if (arrs[n4] == 0) continue;
            return 0;
        }
        return 1;
    }

    public static EInteger LeftShiftBigIntVar(EInteger eInteger, EInteger eInteger2) {
        if (eInteger.isZero()) {
            return eInteger;
        }
        while (eInteger2.signum() > 0) {
            int n2 = 1000000;
            if (eInteger2.compareTo(EInteger.FromInt64(1000000L)) < 0) {
                n2 = eInteger2.ToInt32Checked();
            }
            eInteger = eInteger.ShiftLeft(n2);
            eInteger2 = eInteger2.Subtract(EInteger.FromInt32(n2));
        }
        return eInteger;
    }

    public static short LinearMultiply(short[] arrs, int n2, short[] arrs2, int n3, short s, int n4) {
        int n5 = s & 65535;
        short s2 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n6 = n5 * (65535 & arrs2[n3 + i2]) + (s2 & 65535);
            arrs[n2 + i2] = (short)n6;
            s2 = (short)(n6 >> 16);
        }
        return s2;
    }

    public static void RecursiveDivideInner(short[] arrs, int n2, short[] arrs2, int n3, short[] arrs3, int n4, short[] arrs4, int n5, int n6) {
        if (n6 >= 40 && (n6 & 1) != 1) {
            int n7 = n6 >> 1;
            short[] arrs5 = new short[n7 * 10];
            Arrays.fill((short[])arrs3, (int)n4, (int)(n4 + n6 * 2), (short)0);
            Arrays.fill((short[])arrs4, (int)n5, (int)(n5 + n6), (short)0);
            int n8 = n2 + n7;
            int n9 = n2 + n6;
            int n10 = n7 * 6;
            int n11 = n7 * 8;
            EInteger.DivideThreeBlocksByTwo(arrs, n8, arrs, n9, arrs2, n3, n7, arrs5, n10, arrs5, n11, arrs5);
            EInteger.DivideThreeBlocksByTwo(arrs, n2, arrs5, n11, arrs2, n3, n7, arrs3, n4, arrs4, n5, arrs5);
            System.arraycopy((Object)arrs5, (int)n10, (Object)arrs3, (int)(n4 + n7), (int)n7);
            return;
        }
        EInteger.GeneralDivide(arrs, n2, n6 * 2, arrs2, n3, n6, arrs3, n4, arrs4, n5);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void RecursiveSquare(short[] arrs, int n2, short[] arrs2, int n3, short[] arrs3, int n4, int n5) {
        if (n5 > 10) {
            if ((n5 & 1) == 0) {
                int n6 = n5 >> 1;
                int n7 = n3 + n5;
                EInteger.RecursiveSquare(arrs, n2, arrs2, n7, arrs3, n4, n6);
                int n8 = n2 + n5;
                int n9 = n4 + n6;
                EInteger.RecursiveSquare(arrs, n8, arrs2, n7, arrs3, n9, n6);
                EInteger.SameSizeMultiply(arrs2, n3, arrs2, n7, arrs3, n4, arrs3, n9, n6);
                int n10 = n2 + n6;
                int n11 = EInteger.AddInternal(arrs, n10, arrs, n10, arrs2, n3, n5) + EInteger.AddInternal(arrs, n10, arrs, n10, arrs2, n3, n5);
                EInteger.Increment(arrs, n8 + n6, n6, (short)n11);
                return;
            }
            EInteger.SameSizeMultiply(arrs, n2, arrs2, n3, arrs3, n4, arrs3, n4, n5);
            return;
        } else {
            if (n5 == 2) {
                int n12 = (65535 & arrs3[n4]) * (65535 & arrs3[n4]);
                arrs[n2] = (short)n12;
                int n13 = 65535 & n12 >> 16;
                int n14 = 65535 & arrs3[n4];
                int n15 = n4 + 1;
                int n16 = n14 * (65535 & arrs3[n15]);
                short s = (short)n16;
                int n17 = ((65535 & n16 >> 16) << 1) + (1 & s >> 15);
                int n18 = n13 + (65535 & (short)(s << 1));
                short s2 = (short)n18;
                int n19 = n17 + (65535 & n18 >> 16);
                arrs[n2 + 1] = s2;
                int n20 = n19 + (65535 & arrs3[n15]) * (65535 & arrs3[n15]);
                arrs[n2 + 2] = (short)n20;
                arrs[n2 + 3] = (short)(n20 >> 16);
                return;
            }
            if (n5 == 4) {
                int n21 = (65535 & arrs3[n4]) * (65535 & arrs3[n4]);
                arrs[n2] = (short)n21;
                int n22 = 65535 & n21 >> 16;
                int n23 = 65535 & arrs3[n4];
                int n24 = n4 + 1;
                int n25 = n23 * (65535 & arrs3[n24]);
                short s = (short)n25;
                int n26 = ((65535 & n25 >> 16) << 1) + (1 & s >> 15);
                int n27 = n22 + (65535 & (short)(s << 1));
                short s3 = (short)n27;
                int n28 = n26 + (65535 & n27 >> 16);
                arrs[n2 + 1] = s3;
                int n29 = 65535 & arrs3[n4];
                int n30 = n4 + 2;
                int n31 = n29 * (65535 & arrs3[n30]);
                short s4 = (short)n31;
                int n32 = ((65535 & n31 >> 16) << 1) + (1 & s4 >> 15);
                short s5 = (short)(s4 << 1);
                int n33 = (65535 & arrs3[n24]) * (65535 & arrs3[n24]) + (s5 & 65535);
                short s6 = (short)n33;
                int n34 = n32 + (65535 & n33 >> 16);
                int n35 = n28 + (s6 & 65535);
                short s7 = (short)n35;
                int n36 = n34 + (65535 & n35 >> 16);
                arrs[n2 + 2] = s7;
                int n37 = 65535 & arrs3[n4];
                int n38 = n4 + 3;
                int n39 = n37 * (65535 & arrs3[n38]);
                short s8 = (short)n39;
                int n40 = 65535 & n39 >> 16;
                int n41 = (65535 & arrs3[n24]) * (65535 & arrs3[n30]) + (s8 & 65535);
                short s9 = (short)n41;
                int n42 = (n40 + (65535 & n41 >> 16) << 1) + (1 & s9 >> 15);
                int n43 = n36 + (65535 & (short)(s9 << 1));
                short s10 = (short)n43;
                int n44 = n42 + (65535 & n43 >> 16);
                arrs[n2 + 3] = s10;
                int n45 = (65535 & arrs3[n24]) * (65535 & arrs3[n38]);
                short s11 = (short)n45;
                int n46 = ((65535 & n45 >> 16) << 1) + (1 & s11 >> 15);
                short s12 = (short)(s11 << 1);
                int n47 = (65535 & arrs3[n30]) * (65535 & arrs3[n30]) + (s12 & 65535);
                short s13 = (short)n47;
                int n48 = n46 + (65535 & n47 >> 16);
                int n49 = n44 + (s13 & 65535);
                short s14 = (short)n49;
                int n50 = n48 + (65535 & n49 >> 16);
                arrs[n2 + 4] = s14;
                int n51 = (65535 & arrs3[n30]) * (65535 & arrs3[n38]);
                short s15 = (short)n51;
                int n52 = ((65535 & n51 >> 16) << 1) + (1 & s15 >> 15);
                int n53 = n50 + (65535 & (short)(s15 << 1));
                short s16 = (short)n53;
                int n54 = n52 + (65535 & n53 >> 16);
                arrs[-3 + (n2 + 8)] = s16;
                int n55 = n54 + (65535 & arrs3[n38]) * (65535 & arrs3[n38]);
                arrs[n2 + 6] = (short)n55;
                arrs[n2 + 7] = (short)(n55 >> 16);
                return;
            }
            if (n5 == 8) {
                int n56 = (65535 & arrs3[n4]) * (65535 & arrs3[n4]);
                arrs[n2] = (short)n56;
                int n57 = 65535 & n56 >> 16;
                int n58 = 65535 & arrs3[n4];
                int n59 = n4 + 1;
                int n60 = n58 * (65535 & arrs3[n59]);
                short s = (short)n60;
                int n61 = ((65535 & n60 >> 16) << 1) + (1 & s >> 15);
                int n62 = n57 + (65535 & (short)(s << 1));
                short s17 = (short)n62;
                int n63 = n61 + (65535 & n62 >> 16);
                arrs[n2 + 1] = s17;
                int n64 = 65535 & arrs3[n4];
                int n65 = n4 + 2;
                int n66 = n64 * (65535 & arrs3[n65]);
                short s18 = (short)n66;
                int n67 = ((65535 & n66 >> 16) << 1) + (1 & s18 >> 15);
                short s19 = (short)(s18 << 1);
                int n68 = (65535 & arrs3[n59]) * (65535 & arrs3[n59]) + (s19 & 65535);
                short s20 = (short)n68;
                int n69 = n67 + (65535 & n68 >> 16);
                int n70 = n63 + (s20 & 65535);
                short s21 = (short)n70;
                int n71 = n69 + (65535 & n70 >> 16);
                arrs[n2 + 2] = s21;
                int n72 = 65535 & arrs3[n4];
                int n73 = n4 + 3;
                int n74 = n72 * (65535 & arrs3[n73]);
                short s22 = (short)n74;
                int n75 = 65535 & n74 >> 16;
                int n76 = (65535 & arrs3[n59]) * (65535 & arrs3[n65]) + (s22 & 65535);
                short s23 = (short)n76;
                int n77 = (n75 + (65535 & n76 >> 16) << 1) + (1 & s23 >> 15);
                int n78 = n71 + (65535 & (short)(s23 << 1));
                short s24 = (short)n78;
                int n79 = n77 + (65535 & n78 >> 16);
                arrs[n2 + 3] = s24;
                int n80 = 65535 & arrs3[n4];
                int n81 = n4 + 4;
                int n82 = n80 * (65535 & arrs3[n81]);
                short s25 = (short)n82;
                int n83 = 65535 & n82 >> 16;
                int n84 = (65535 & arrs3[n59]) * (65535 & arrs3[n73]) + (s25 & 65535);
                short s26 = (short)n84;
                int n85 = (n83 + (65535 & n84 >> 16) << 1) + (1 & s26 >> 15);
                short s27 = (short)(s26 << 1);
                int n86 = (65535 & arrs3[n65]) * (65535 & arrs3[n65]) + (s27 & 65535);
                short s28 = (short)n86;
                int n87 = n85 + (65535 & n86 >> 16);
                int n88 = n79 + (s28 & 65535);
                short s29 = (short)n88;
                int n89 = n87 + (65535 & n88 >> 16);
                arrs[n2 + 4] = s29;
                int n90 = 65535 & arrs3[n4];
                int n91 = n4 + 5;
                int n92 = n90 * (65535 & arrs3[n91]);
                short s30 = (short)n92;
                int n93 = 65535 & n92 >> 16;
                int n94 = (65535 & arrs3[n59]) * (65535 & arrs3[n81]) + (s30 & 65535);
                short s31 = (short)n94;
                int n95 = n93 + (65535 & n94 >> 16);
                int n96 = (65535 & arrs3[n65]) * (65535 & arrs3[n73]) + (s31 & 65535);
                short s32 = (short)n96;
                int n97 = (n95 + (65535 & n96 >> 16) << 1) + (1 & s32 >> 15);
                int n98 = n89 + (65535 & (short)(s32 << 1));
                short s33 = (short)n98;
                int n99 = n97 + (65535 & n98 >> 16);
                arrs[n2 + 5] = s33;
                int n100 = 65535 & arrs3[n4];
                int n101 = n4 + 6;
                int n102 = n100 * (65535 & arrs3[n101]);
                short s34 = (short)n102;
                int n103 = 65535 & n102 >> 16;
                int n104 = (65535 & arrs3[n59]) * (65535 & arrs3[n91]) + (s34 & 65535);
                short s35 = (short)n104;
                int n105 = n103 + (65535 & n104 >> 16);
                int n106 = (65535 & arrs3[n65]) * (65535 & arrs3[n81]) + (s35 & 65535);
                short s36 = (short)n106;
                int n107 = (n105 + (65535 & n106 >> 16) << 1) + (1 & s36 >> 15);
                short s37 = (short)(s36 << 1);
                int n108 = (65535 & arrs3[n73]) * (65535 & arrs3[n73]) + (s37 & 65535);
                short s38 = (short)n108;
                int n109 = n107 + (65535 & n108 >> 16);
                int n110 = n99 + (s38 & 65535);
                short s39 = (short)n110;
                int n111 = n109 + (65535 & n110 >> 16);
                arrs[n2 + 6] = s39;
                int n112 = 65535 & arrs3[n4];
                int n113 = n4 + 7;
                int n114 = n112 * (65535 & arrs3[n113]);
                short s40 = (short)n114;
                int n115 = 65535 & n114 >> 16;
                int n116 = (65535 & arrs3[n59]) * (65535 & arrs3[n101]) + (s40 & 65535);
                short s41 = (short)n116;
                int n117 = n115 + (65535 & n116 >> 16);
                int n118 = (65535 & arrs3[n65]) * (65535 & arrs3[n91]) + (s41 & 65535);
                short s42 = (short)n118;
                int n119 = n117 + (65535 & n118 >> 16);
                int n120 = (65535 & arrs3[n73]) * (65535 & arrs3[n81]) + (s42 & 65535);
                short s43 = (short)n120;
                int n121 = (n119 + (65535 & n120 >> 16) << 1) + (1 & s43 >> 15);
                int n122 = n111 + (65535 & (short)(s43 << 1));
                short s44 = (short)n122;
                int n123 = n121 + (65535 & n122 >> 16);
                arrs[n2 + 7] = s44;
                int n124 = (65535 & arrs3[n59]) * (65535 & arrs3[n113]);
                short s45 = (short)n124;
                int n125 = 65535 & n124 >> 16;
                int n126 = (65535 & arrs3[n65]) * (65535 & arrs3[n101]) + (s45 & 65535);
                short s46 = (short)n126;
                int n127 = n125 + (65535 & n126 >> 16);
                int n128 = (65535 & arrs3[n73]) * (65535 & arrs3[n91]) + (s46 & 65535);
                short s47 = (short)n128;
                int n129 = (n127 + (65535 & n128 >> 16) << 1) + (1 & s47 >> 15);
                short s48 = (short)(s47 << 1);
                int n130 = (65535 & arrs3[n81]) * (65535 & arrs3[n81]) + (s48 & 65535);
                short s49 = (short)n130;
                int n131 = n129 + (65535 & n130 >> 16);
                int n132 = n123 + (s49 & 65535);
                short s50 = (short)n132;
                int n133 = n131 + (65535 & n132 >> 16);
                arrs[n2 + 8] = s50;
                int n134 = (65535 & arrs3[n65]) * (65535 & arrs3[n113]);
                short s51 = (short)n134;
                int n135 = 65535 & n134 >> 16;
                int n136 = (65535 & arrs3[n73]) * (65535 & arrs3[n101]) + (s51 & 65535);
                short s52 = (short)n136;
                int n137 = n135 + (65535 & n136 >> 16);
                int n138 = (65535 & arrs3[n81]) * (65535 & arrs3[n91]) + (s52 & 65535);
                short s53 = (short)n138;
                int n139 = (n137 + (65535 & n138 >> 16) << 1) + (1 & s53 >> 15);
                int n140 = n133 + (65535 & (short)(s53 << 1));
                short s54 = (short)n140;
                int n141 = n139 + (65535 & n140 >> 16);
                arrs[n2 + 9] = s54;
                int n142 = (65535 & arrs3[n73]) * (65535 & arrs3[n113]);
                short s55 = (short)n142;
                int n143 = 65535 & n142 >> 16;
                int n144 = (65535 & arrs3[n81]) * (65535 & arrs3[n101]) + (s55 & 65535);
                short s56 = (short)n144;
                int n145 = (n143 + (65535 & n144 >> 16) << 1) + (1 & s56 >> 15);
                short s57 = (short)(s56 << 1);
                int n146 = (65535 & arrs3[n91]) * (65535 & arrs3[n91]) + (s57 & 65535);
                short s58 = (short)n146;
                int n147 = n145 + (65535 & n146 >> 16);
                int n148 = n141 + (s58 & 65535);
                short s59 = (short)n148;
                int n149 = n147 + (65535 & n148 >> 16);
                arrs[n2 + 10] = s59;
                int n150 = (65535 & arrs3[n81]) * (65535 & arrs3[n113]);
                short s60 = (short)n150;
                int n151 = 65535 & n150 >> 16;
                int n152 = (65535 & arrs3[n91]) * (65535 & arrs3[n101]) + (s60 & 65535);
                short s61 = (short)n152;
                int n153 = (n151 + (65535 & n152 >> 16) << 1) + (1 & s61 >> 15);
                int n154 = n149 + (65535 & (short)(s61 << 1));
                short s62 = (short)n154;
                int n155 = n153 + (65535 & n154 >> 16);
                arrs[n2 + 11] = s62;
                int n156 = (65535 & arrs3[n91]) * (65535 & arrs3[n113]);
                short s63 = (short)n156;
                int n157 = ((65535 & n156 >> 16) << 1) + (1 & s63 >> 15);
                short s64 = (short)(s63 << 1);
                int n158 = (65535 & arrs3[n101]) * (65535 & arrs3[n101]) + (s64 & 65535);
                short s65 = (short)n158;
                int n159 = n157 + (65535 & n158 >> 16);
                int n160 = n155 + (s65 & 65535);
                short s66 = (short)n160;
                int n161 = n159 + (65535 & n160 >> 16);
                arrs[n2 + 12] = s66;
                int n162 = (65535 & arrs3[n101]) * (65535 & arrs3[n113]);
                short s67 = (short)n162;
                int n163 = ((65535 & n162 >> 16) << 1) + (1 & s67 >> 15);
                int n164 = n161 + (65535 & (short)(s67 << 1));
                short s68 = (short)n164;
                int n165 = n163 + (65535 & n164 >> 16);
                arrs[n2 + 13] = s68;
                int n166 = n165 + (65535 & arrs3[n113]) * (65535 & arrs3[n113]);
                arrs[n2 + 14] = (short)n166;
                arrs[n2 + 15] = (short)(n166 >> 16);
                return;
            }
            for (int i2 = 0; i2 < n5; ++i2) {
                int n167 = n2 + i2;
                int n168 = 65535 & arrs3[n4 + i2];
                short s = 0;
                for (int i3 = 0; i3 < n5; ++i3) {
                    int n169 = n168 * (65535 & arrs3[n4 + i3]) + (s & 65535);
                    if (i2 != 0) {
                        n169 += 65535 & arrs[n167 + i3];
                    }
                    arrs[n167 + i3] = (short)n169;
                    s = (short)(n169 >> 16);
                }
                arrs[n167 + n5] = s;
            }
        }
    }

    public static void ReverseChars(char[] arrc, int n2, int n3) {
        int n4 = n3 >> 1;
        int n5 = -1 + (n3 + n2);
        int n6 = 0;
        while (n6 < n4) {
            int n7 = n2 + n6;
            char c2 = arrc[n7];
            arrc[n7] = arrc[n5];
            arrc[n5] = c2;
            ++n6;
            --n5;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void SameSizeMultiply(short[] arrs, int n2, short[] arrs2, int n3, short[] arrs3, int n4, short[] arrs4, int n5, int n6) {
        int n7;
        int n8;
        if (n6 <= 10) {
            if (n6 == 2) {
                EInteger.BaselineMultiply2(arrs, n2, arrs3, n4, arrs4, n5);
                return;
            }
            if (n6 == 4) {
                int n9 = 65535 & arrs3[n4];
                int n10 = 65535 & arrs4[n5];
                int n11 = n9 * n10;
                short s = (short)n11;
                int n12 = 65535 & n11 >> 16;
                arrs[n2] = s;
                short s2 = (short)n12;
                int n13 = 65535 & n12 >> 16;
                int n14 = n5 + 1;
                int n15 = n9 * (65535 & arrs4[n14]) + (s2 & 65535);
                short s3 = (short)n15;
                int n16 = n13 + (65535 & n15 >> 16);
                int n17 = n4 + 1;
                int n18 = n10 * (65535 & arrs3[n17]) + (s3 & 65535);
                short s4 = (short)n18;
                int n19 = n16 + (65535 & n18 >> 16);
                arrs[n2 + 1] = s4;
                short s5 = (short)n19;
                int n20 = 65535 & n19 >> 16;
                int n21 = n5 + 2;
                int n22 = n9 * (65535 & arrs4[n21]) + (s5 & 65535);
                short s6 = (short)n22;
                int n23 = n20 + (65535 & n22 >> 16);
                int n24 = (65535 & arrs3[n17]) * (65535 & arrs4[n14]) + (s6 & 65535);
                short s7 = (short)n24;
                int n25 = n23 + (65535 & n24 >> 16);
                int n26 = n4 + 2;
                int n27 = n10 * (65535 & arrs3[n26]) + (s7 & 65535);
                short s8 = (short)n27;
                int n28 = n25 + (65535 & n27 >> 16);
                arrs[n2 + 2] = s8;
                short s9 = (short)n28;
                int n29 = 65535 & n28 >> 16;
                int n30 = n5 + 3;
                int n31 = n9 * (65535 & arrs4[n30]) + (s9 & 65535);
                short s10 = (short)n31;
                int n32 = n29 + (65535 & n31 >> 16);
                int n33 = (65535 & arrs3[n17]) * (65535 & arrs4[n21]) + (s10 & 65535);
                short s11 = (short)n33;
                int n34 = n32 + (65535 & n33 >> 16);
                int n35 = (65535 & arrs3[n26]) * (65535 & arrs4[n14]) + (s11 & 65535);
                short s12 = (short)n35;
                int n36 = n34 + (65535 & n35 >> 16);
                int n37 = n4 + 3;
                int n38 = n10 * (65535 & arrs3[n37]) + (s12 & 65535);
                short s13 = (short)n38;
                int n39 = n36 + (65535 & n38 >> 16);
                arrs[n2 + 3] = s13;
                short s14 = (short)n39;
                int n40 = 65535 & n39 >> 16;
                int n41 = (65535 & arrs3[n17]) * (65535 & arrs4[n30]) + (s14 & 65535);
                short s15 = (short)n41;
                int n42 = n40 + (65535 & n41 >> 16);
                int n43 = (65535 & arrs3[n26]) * (65535 & arrs4[n21]) + (s15 & 65535);
                short s16 = (short)n43;
                int n44 = n42 + (65535 & n43 >> 16);
                int n45 = (65535 & arrs3[n37]) * (65535 & arrs4[n14]) + (s16 & 65535);
                short s17 = (short)n45;
                int n46 = n44 + (65535 & n45 >> 16);
                arrs[n2 + 4] = s17;
                short s18 = (short)n46;
                int n47 = 65535 & n46 >> 16;
                int n48 = (65535 & arrs3[n26]) * (65535 & arrs4[n30]) + (s18 & 65535);
                short s19 = (short)n48;
                int n49 = n47 + (65535 & n48 >> 16);
                int n50 = (65535 & arrs3[n37]) * (65535 & arrs4[n21]) + (s19 & 65535);
                short s20 = (short)n50;
                int n51 = n49 + (65535 & n50 >> 16);
                arrs[n2 + 5] = s20;
                int n52 = n51 + (65535 & arrs3[n37]) * (65535 & arrs4[n30]);
                arrs[n2 + 6] = (short)n52;
                arrs[n2 + 7] = (short)(n52 >> 16);
                return;
            }
            if (n6 != 8) {
                EInteger.SchoolbookMultiply(arrs, n2, arrs3, n4, n6, arrs4, n5, n6);
                return;
            }
            EInteger.BaselineMultiply8(arrs, n2, arrs3, n4, arrs4, n5);
            return;
        }
        for (n8 = n6; n8 != 0 && arrs3[-1 + (n4 + n8)] == 0; --n8) {
        }
        for (n7 = n6; n7 != 0 && arrs4[-1 + (n5 + n7)] == 0; --n7) {
        }
        if (n8 != 0 && n7 != 0) {
            int n73;
            if ((n6 & 1) == 0) {
                int n53 = n6 >> 1;
                if (n8 <= n53 && n7 <= n53) {
                    int n54 = n2 + n6;
                    Arrays.fill((short[])arrs, (int)n54, (int)(n54 + n6), (short)0);
                    if (n53 == 8) {
                        EInteger.BaselineMultiply8(arrs, n2, arrs3, n4, arrs4, n5);
                        return;
                    }
                    EInteger.SameSizeMultiply(arrs, n2, arrs2, n3, arrs3, n4, arrs4, n5, n53);
                    return;
                }
                int n55 = n2 + n6;
                int n56 = n55 + n53;
                int n57 = n2 + n53;
                int n58 = n3 + n6;
                int n59 = n4 + n53;
                int n60 = EInteger.Compare(arrs3, n4, arrs3, n59, n53) > 0 ? 0 : n53;
                int n61 = n4 + (n53 ^ n60);
                int n62 = n4 + n60;
                int n63 = n60;
                EInteger.SubtractInternal(arrs, n2, arrs3, n62, arrs3, n61, n53);
                int n64 = n5 + n53;
                int n65 = EInteger.Compare(arrs4, n5, arrs4, n64, n53) > 0 ? 0 : n53;
                int n66 = n5 + (n53 ^ n65);
                EInteger.SubtractInternal(arrs, n57, arrs4, n5 + n65, arrs4, n66, n53);
                int n67 = n65;
                EInteger.SameSizeMultiply(arrs, n55, arrs2, n58, arrs3, n59, arrs4, n64, n53);
                EInteger.SameSizeMultiply(arrs2, n3, arrs2, n58, arrs, n2, arrs, n57, n53);
                EInteger.SameSizeMultiply(arrs, n2, arrs2, n58, arrs3, n4, arrs4, n5, n53);
                int n68 = EInteger.AddInternal(arrs, n55, arrs, n55, arrs, n57, n53);
                int n69 = n68 + EInteger.AddInternal(arrs, n57, arrs, n55, arrs, n2, n53);
                int n70 = n68 + EInteger.AddInternal(arrs, n55, arrs, n55, arrs, n56, n53);
                int n71 = n63 == n67 ? n70 - EInteger.SubtractInternal(arrs, n57, arrs, n57, arrs2, n3, n6) : n70 + EInteger.AddInternal(arrs, n57, arrs, n57, arrs2, n3, n6);
                int n72 = n71 + EInteger.Increment(arrs, n55, n53, (short)n69);
                if (n72 == 0) return;
                EInteger.Increment(arrs, n56, n53, (short)n72);
                return;
            }
            int n74 = n6 >> 1;
            int n75 = n6 - n74;
            int n76 = n4 + n75;
            int n77 = EInteger.CompareWithWords1IsOneBigger(arrs3, n4, arrs3, n76, n75) > 0 ? 0 : n75;
            if (n77 == 0) {
                EInteger.SubtractWords1IsOneBigger(arrs, n2, arrs3, n4, arrs3, n76, n75);
            } else {
                EInteger.SubtractWords2IsOneBigger(arrs, n2, arrs3, n76, arrs3, n4, n75);
            }
            int n78 = n5 + n75;
            int n79 = EInteger.CompareWithWords1IsOneBigger(arrs4, n5, arrs4, n78, n75) > 0 ? 0 : n75;
            if (n79 == 0) {
                n73 = n78;
                EInteger.SubtractWords1IsOneBigger(arrs2, n3, arrs4, n5, arrs4, n78, n75);
            } else {
                n73 = n78;
                EInteger.SubtractWords2IsOneBigger(arrs2, n3, arrs4, n73, arrs4, n5, n75);
            }
            int n80 = n74 << 1;
            int n81 = n75 << 1;
            int n82 = n3 + n80;
            int n83 = n2 + n80;
            int n84 = n79;
            int n85 = n77;
            EInteger.SameSizeMultiply(arrs2, n82, arrs, n83, arrs, n2, arrs2, n3, n75);
            short s = arrs2[n82];
            int n86 = n82 + 1;
            short s21 = arrs2[n86];
            int n87 = n2 + n81;
            EInteger.SameSizeMultiply(arrs, n87, arrs, n2, arrs3, n76, arrs4, n73, n74);
            EInteger.SameSizeMultiply(arrs, n2, arrs2, n3, arrs3, n4, arrs4, n5, n75);
            arrs2[n82] = s;
            arrs2[n86] = s21;
            int n88 = n2 + n75;
            int n89 = EInteger.AddInternal(arrs, n87, arrs, n87, arrs, n88, n75);
            int n90 = n89 + EInteger.AddInternal(arrs, n88, arrs, n87, arrs, n2, n75);
            int n91 = n87 + n75;
            int n92 = n75 - 2;
            int n93 = n89 + EInteger.AddUnevenSize(arrs, n87, arrs, n87, n75, arrs, n91, n92);
            int n94 = n85 == n84 ? n93 - EInteger.SubtractInternal(arrs, n88, arrs, n88, arrs2, n82, n81) : n93 + EInteger.AddInternal(arrs, n88, arrs, n88, arrs2, n82, n81);
            int n95 = n94 + EInteger.Increment(arrs, n87, n75, (short)n90);
            if (n95 == 0) return;
            EInteger.Increment(arrs, n91, n92, (short)n95);
            return;
        }
        Arrays.fill((short[])arrs, (int)n2, (int)(n2 + (n6 << 1)), (short)0);
        return;
        catch (Throwable throwable) {
            throw throwable;
        }
    }

    public static void SchoolbookMultiply(short[] arrs, int n2, short[] arrs2, int n3, int n4, short[] arrs3, int n5, int n6) {
        int n7 = 1;
        if (n4 < n6) {
            int n8 = 65535 & arrs2[n3];
            int n9 = 0;
            for (int i2 = 0; i2 < n6; ++i2) {
                int n10 = n8 * (65535 & arrs3[n5 + i2]) + (n9 & 65535);
                arrs[n2 + i2] = (short)n10;
                n9 = 65535 & n10 >> 16;
            }
            arrs[n2 + n6] = (short)n9;
            while (n7 < n4) {
                int n11 = n2 + n7;
                int n12 = 65535 & arrs2[n3 + n7];
                int n13 = 0;
                for (int i3 = 0; i3 < n6; ++i3) {
                    int n14 = n12 * (65535 & arrs3[n5 + i3]) + (n13 & 65535);
                    int n15 = n11 + i3;
                    int n16 = n14 + (65535 & arrs[n15]);
                    arrs[n15] = (short)n16;
                    n13 = 65535 & n16 >> 16;
                }
                arrs[n11 + n6] = (short)n13;
                ++n7;
            }
        } else {
            int n17 = 65535 & arrs3[n5];
            int n18 = 0;
            for (int i4 = 0; i4 < n4; ++i4) {
                int n19 = n17 * (65535 & arrs2[n3 + i4]) + (n18 & 65535);
                arrs[n2 + i4] = (short)n19;
                n18 = 65535 & n19 >> 16;
            }
            arrs[n2 + n4] = (short)n18;
            while (n7 < n6) {
                int n20 = n2 + n7;
                int n21 = 65535 & arrs3[n5 + n7];
                int n22 = 0;
                for (int i5 = 0; i5 < n4; ++i5) {
                    int n23 = n21 * (65535 & arrs2[n3 + i5]) + (n22 & 65535);
                    int n24 = n20 + i5;
                    int n25 = n23 + (65535 & arrs[n24]);
                    arrs[n24] = (short)n25;
                    n22 = 65535 & n25 >> 16;
                }
                arrs[n20 + n4] = (short)n22;
                ++n7;
            }
        }
    }

    public static short ShiftWordsLeftByBits(short[] arrs, int n2, int n3, int n4) {
        int n5 = 0;
        if (n4 != 0) {
            int n6 = 16 - n4;
            int n7 = 0;
            while (n5 < n3) {
                short s = arrs[n2];
                arrs[n2] = (short)(n7 | s << n4);
                n7 = (65535 & s) >> n6;
                ++n5;
                ++n2;
            }
            n5 = n7;
        }
        return (short)n5;
    }

    public static short ShiftWordsRightByBits(short[] arrs, int n2, int n3, int n4) {
        short s = 0;
        if (n4 != 0) {
            while (n3 > 0) {
                int n5 = -1 + (n2 + n3);
                int n6 = 65535 & arrs[n5];
                arrs[n5] = (short)(65535 & n6 >> n4 | s & 65535);
                s = (short)(n6 << 16 - n4);
                --n3;
            }
        }
        return s;
    }

    public static short[] ShortenArray(short[] arrs, int n2) {
        if (arrs.length > 32 && n2 < arrs.length && arrs.length - n2 >= 16) {
            short[] arrs2 = new short[n2];
            System.arraycopy((Object)arrs, (int)0, (Object)arrs2, (int)0, (int)Math.min((int)n2, (int)arrs.length));
            arrs = arrs2;
        }
        return arrs;
    }

    public static int SubtractInternal(short[] arrs, int n2, short[] arrs2, int n3, short[] arrs3, int n4, int n5) {
        int n6 = n5 & 1;
        int n7 = 0;
        boolean bl = n6 != 0;
        if (bl) {
            --n5;
        }
        int n8 = 0;
        while (n7 < n5) {
            int n9 = 65535 & arrs3[n4];
            int n10 = 65535 & arrs3[n4 + 1];
            int n11 = 65535 & arrs2[n3];
            int n12 = 65535 & arrs2[n3 + 1];
            int n13 = n11 - n9 - (1 & n8 >> 31);
            int n14 = n2 + 1;
            arrs[n2] = (short)n13;
            int n15 = n12 - n10 - (1 & n13 >> 31);
            int n16 = n14 + 1;
            arrs[n14] = (short)n15;
            n3 += 2;
            n4 += 2;
            n7 += 2;
            n8 = n15;
            n2 = n16;
        }
        if (bl) {
            n8 = (65535 & arrs2[n3]) - (65535 & arrs3[n4]) - (1 & n8 >> 31);
            arrs[n2] = (short)n8;
        }
        return 1 & n8 >> 31;
    }

    public static int SubtractWords1IsOneBigger(short[] arrs, int n2, short[] arrs2, int n3, short[] arrs3, int n4, int n5) {
        int n6 = n5 - 1;
        int n7 = 0;
        for (int i2 = 0; i2 < n6; ++i2) {
            n7 = (65535 & arrs2[n3]) - (65535 & arrs3[n4]) - (1 & n7 >> 31);
            int n8 = n2 + 1;
            arrs[n2] = (short)n7;
            ++n3;
            ++n4;
            n2 = n8;
        }
        int n9 = (65535 & arrs2[n3]) - (1 & n7 >> 31);
        arrs[n2] = (short)n9;
        return 1 & n9 >> 31;
    }

    public static int SubtractWords2IsOneBigger(short[] arrs, int n2, short[] arrs2, int n3, short[] arrs3, int n4, int n5) {
        int n6 = n5 - 1;
        int n7 = 0;
        for (int i2 = 0; i2 < n6; ++i2) {
            n7 = (65535 & arrs2[n3]) - (65535 & arrs3[n4]) - (1 & n7 >> 31);
            int n8 = n2 + 1;
            arrs[n2] = (short)n7;
            ++n3;
            ++n4;
            n2 = n8;
        }
        int n9 = 0 - ((65535 & arrs3[n4]) - (1 & n7 >> 31));
        arrs[n2] = (short)n9;
        return 1 & n9 >> 31;
    }

    public static void TwosComplement(short[] arrs, int n2, int n3) {
        EInteger.Decrement(arrs, n2, n3, (short)1);
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = n2 + i2;
            arrs[n4] = arrs[n4];
        }
    }

    public static int WordsCompare(short[] arrs, int n2, int n3, short[] arrs2, int n4, int n5) {
        int n6 = -1;
        if (n3 == 0) {
            if (n5 == 0) {
                return 0;
            }
            return n6;
        }
        if (n5 == 0) {
            return 1;
        }
        if (n3 == n5) {
            if (n3 == 1 && arrs[n2] == arrs2[n4]) {
                return 0;
            }
            int n7 = n2 + n3 - 1;
            int n8 = n4 + n3 - 1;
            do {
                int n9 = n3 - 1;
                if (n3 == 0) break;
                int n10 = 65535 & arrs[n7];
                int n11 = 65535 & arrs2[n8];
                if (n10 > n11) {
                    return 1;
                }
                if (n10 < n11) {
                    return n6;
                }
                --n7;
                --n8;
                n3 = n9;
            } while (true);
            return 0;
        }
        if (n3 > n5) {
            n6 = 1;
        }
        return n6;
    }

    public static int WordsShiftRightFour(short[] arrs, int n2) {
        if (n2 != 0) {
            int n3;
            int n4 = 0;
            for (int i2 = n3 = n2 - 1; i2 >= 0; --i2) {
                short s = arrs[i2];
                int n5 = n4 | (65520 & s) >> 4;
                int n6 = 61440 & s << 12;
                arrs[i2] = (short)n5;
                n4 = n6;
            }
            if (arrs[n3] == 0) {
                n2 = n3;
            }
        }
        return n2;
    }

    public static int WordsShiftRightOne(short[] arrs, int n2) {
        if (n2 != 0) {
            int n3;
            int n4 = 0;
            for (int i2 = n3 = n2 - 1; i2 >= 0; --i2) {
                short s = arrs[i2];
                int n5 = n4 | (65534 & s) >> 1;
                int n6 = 32768 & s << 15;
                arrs[i2] = (short)n5;
                n4 = n6;
            }
            if (arrs[n3] == 0) {
                n2 = n3;
            }
        }
        return n2;
    }

    public static int WordsSubtract(short[] arrs, int n2, short[] arrs2, int n3) {
        int n4;
        short s = (short)EInteger.SubtractInternal(arrs, 0, arrs, 0, arrs2, 0, n3);
        if (s != 0) {
            EInteger.Decrement(arrs, n3, n2 - n3, s);
        }
        while (n2 != 0 && arrs[n4 = n2 - 1] == 0) {
            n2 = n4;
        }
        return n2;
    }

    public static long WordsToLongUnchecked(short[] arrs, int n2) {
        if (n2 == 0) {
            return 0L;
        }
        int n3 = 65535 & arrs[0];
        if (n2 > 1) {
            n3 |= (65535 & arrs[1]) << 16;
        }
        if (n2 > 2) {
            int n4 = 65535 & arrs[2];
            if (n2 > 3) {
                n4 |= (65535 & arrs[3]) << 16;
            }
            return 0xFFFFFFFFL & (long)n3 | (long)n4 << 32;
        }
        return 0xFFFFFFFFL & (long)n3;
    }

    public EInteger Abs() {
        int n2 = this.wordCount;
        if (n2 != 0 && this.negative) {
            return new EInteger(n2, this.words, false);
        }
        return this;
    }

    public EInteger Add(int n2) {
        if (n2 == 0) {
            return this;
        }
        int n3 = this.wordCount;
        if (n3 == 0) {
            return EInteger.FromInt32(n2);
        }
        int n4 = 1;
        if (n3 == n4 && n2 < 65535 && n2 >= -65535) {
            boolean bl;
            boolean bl2;
            if (n2 > 0 && !(bl = this.negative)) {
                int n5 = n2 + (65535 & this.words[0]);
                short[] arrs = new short[2];
                arrs[0] = (short)n5;
                int n6 = n5 >> 16;
                arrs[n4] = (short)n6;
                if (n6 != 0) {
                    n4 = 2;
                }
                return new EInteger(n4, arrs, bl);
            }
            if (n2 < 0 && (bl2 = this.negative)) {
                int n7 = (65535 & this.words[0]) - n2;
                short[] arrs = new short[2];
                arrs[0] = (short)n7;
                int n8 = n7 >> 16;
                arrs[n4] = (short)n8;
                if (n8 != 0) {
                    n4 = 2;
                }
                return new EInteger(n4, arrs, bl2);
            }
            int n9 = 65535 & this.words[0];
            int n10 = Math.abs((int)n2);
            if (n9 > n10) {
                int n11 = n9 - n10;
                short[] arrs = new short[2];
                arrs[0] = (short)n11;
                return new EInteger(n4, arrs, this.negative);
            }
            if (n9 == n10) {
                return EInteger.FromInt32(0);
            }
            int n12 = n10 - n9;
            short[] arrs = new short[2];
            arrs[0] = (short)n12;
            return new EInteger(n4, arrs, (boolean)(n4 ^ this.negative));
        }
        return this.Add(EInteger.FromInt32(n2));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public EInteger Add(EInteger var1_1) {
        block28 : {
            block26 : {
                block27 : {
                    Objects.requireNonNull((Object)var1_1, (String)"bigintAugend");
                    var3_2 = this.wordCount;
                    if (var3_2 == 0) {
                        return var1_1;
                    }
                    var4_3 = var1_1.wordCount;
                    if (var4_3 == 0) {
                        return this;
                    }
                    var5_4 = 2;
                    var6_5 = 1;
                    if (var4_3 == var6_5 && var3_2 == var6_5) {
                        var55_6 = this.negative ? 1 : 0;
                        if (var55_6 == var1_1.negative) {
                            var62_7 = (65535 & this.words[0]) + (65535 & var1_1.words[0]);
                            var63_8 = new short[var5_4];
                            var63_8[0] = (short)var62_7;
                            var64_9 = var62_7 >> 16;
                            var63_8[var6_5] = (short)var64_9;
                            if (var64_9 != 0) return new EInteger(var5_4, var63_8, (boolean)var55_6);
                            var5_4 = var6_5;
                            return new EInteger(var5_4, var63_8, (boolean)var55_6);
                        }
                        var56_10 = 65535 & this.words[0];
                        var57_11 = 65535 & var1_1.words[0];
                        if (var56_10 == var57_11) {
                            return EInteger.FromInt32(0);
                        }
                        if (var56_10 > var57_11) {
                            var60_12 = var56_10 - var57_11;
                            var61_13 = new short[var5_4];
                            var61_13[0] = (short)var60_12;
                            return new EInteger(var6_5, var61_13, (boolean)var55_6);
                        }
                        var58_14 = var57_11 - var56_10;
                        var59_15 = new short[var5_4];
                        var59_15[0] = (short)var58_14;
                        return new EInteger(var6_5, var59_15, (boolean)(var55_6 ^ var6_5));
                    }
                    var7_16 = this.negative;
                    if ((var7_16 ^ true) == (var6_5 ^ var1_1.negative)) {
                        if (!(var4_3 > var5_4 || var3_2 > var5_4 || var3_2 >= var5_4 && this.words[var6_5] >> 15 != 0 || var4_3 >= var5_4 && var1_1.words[var6_5] >> 15 != 0)) {
                            var49_17 = this.words;
                            var50_18 = 65535 & var49_17[0];
                            if (var3_2 == var5_4) {
                                var50_18 |= (65535 & var49_17[var6_5]) << 16;
                            }
                            var51_19 = var1_1.words;
                            var52_20 = 65535 & var51_19[0];
                            if (var4_3 == var5_4) {
                                var52_20 |= (65535 & var51_19[var6_5]) << 16;
                            }
                            var53_21 = var50_18 + var52_20;
                            var54_22 = new short[var5_4];
                            var54_22[0] = (short)(var53_21 & 65535);
                            var54_22[var6_5] = (short)(65535 & var53_21 >> 16);
                            if (var54_22[var6_5] != 0) return new EInteger(var5_4, var54_22, var7_16);
                            var5_4 = var6_5;
                            return new EInteger(var5_4, var54_22, var7_16);
                        }
                        if (var4_3 <= var5_4 && var3_2 <= var5_4) {
                            var41_23 = this.words;
                            var42_24 = 65535 & var41_23[0];
                            if (var3_2 == var5_4) {
                                var42_24 |= (65535 & var41_23[var6_5]) << 16;
                            }
                            var43_25 = var1_1.words;
                            var44_26 = 65535 & var43_25[0];
                            if (var4_3 == var5_4) {
                                var44_26 |= (65535 & var43_25[var6_5]) << 16;
                            }
                            if ((var45_27 = (0xFFFFFFFFL & (long)var42_24) + (0xFFFFFFFFL & (long)var44_26)) >> 32 == 0L) {
                                var47_28 = (int)var45_27;
                                var48_29 = new short[var5_4];
                                var48_29[0] = (short)(var47_28 & 65535);
                                var48_29[var6_5] = (short)(65535 & var47_28 >> 16);
                                if (var48_29[var6_5] != 0) return new EInteger(var5_4, var48_29, var7_16);
                                var5_4 = var6_5;
                                return new EInteger(var5_4, var48_29, var7_16);
                            }
                        }
                        var23_30 = Math.max((int)this.words.length, (int)var1_1.words.length);
                        var24_31 = new short[var23_30];
                        var25_32 = Math.max((int)var3_2, (int)var4_3);
                        if (var3_2 == var4_3) {
                            var39_33 = this.words;
                            var40_34 = var1_1.words;
                            var31_35 = EInteger.AddInternal(var24_31, 0, var39_33, 0, var40_34, 0, var3_2);
                        } else if (var3_2 > var4_3) {
                            var35_36 = this.words;
                            var36_37 = var1_1.words;
                            var31_35 = EInteger.AddInternal(var24_31, 0, var35_36, 0, var36_37, 0, var4_3);
                            var37_38 = this.words;
                            var38_39 = var3_2 - var4_3;
                            System.arraycopy((Object)var37_38, (int)var4_3, (Object)var24_31, (int)var4_3, (int)var38_39);
                            if (var31_35 != 0) {
                                var31_35 = EInteger.Increment(var24_31, var4_3, var38_39, (short)var31_35);
                            }
                        } else {
                            var26_40 = this.words;
                            var27_41 = var1_1.words;
                            var28_42 = EInteger.AddInternal(var24_31, 0, var26_40, 0, var27_41, 0, var3_2);
                            var29_43 = var1_1.words;
                            var30_44 = var4_3 - var3_2;
                            System.arraycopy((Object)var29_43, (int)var3_2, (Object)var24_31, (int)var3_2, (int)var30_44);
                            var31_35 = var28_42 != 0 ? EInteger.Increment(var24_31, var3_2, var30_44, (short)var28_42) : var28_42;
                        }
                        if (var31_35 != 0) {
                            var33_45 = var25_32 + 1;
                            if (var33_45 > var23_30) {
                                var34_46 = new short[var33_45];
                                System.arraycopy((Object)var24_31, (int)0, (Object)var34_46, (int)0, (int)var23_30);
                                var24_31 = var34_46;
                            }
                            var24_31[var25_32] = (short)var31_35;
                            var6_5 = 0;
                        }
                        if ((var32_47 = EInteger.CountWords(var24_31)) == 0) {
                            return EInteger.FromInt32(0);
                        }
                        if (var6_5 == 0) return new EInteger(var32_47, var24_31, this.negative);
                        var24_31 = EInteger.ShortenArray(var24_31, var32_47);
                        return new EInteger(var32_47, var24_31, this.negative);
                    }
                    if (var7_16) {
                        var8_48 = this;
                    } else {
                        var8_48 = var1_1;
                        var1_1 = this;
                    }
                    var9_49 = var1_1.wordCount;
                    var10_50 = var8_48.wordCount;
                    var11_51 = new short[Math.max((int)var1_1.words.length, (int)var8_48.words.length)];
                    if (var9_49 != var10_50) break block26;
                    if (EInteger.Compare(var1_1.words, 0, var8_48.words, 0, var9_49) < 0) break block27;
                    EInteger.SubtractInternal(var11_51, 0, var1_1.words, 0, var8_48.words, 0, var9_49);
                    ** GOTO lbl129
                }
                EInteger.SubtractInternal(var11_51, 0, var8_48.words, 0, var1_1.words, 0, var9_49);
                break block28;
            }
            if (var9_49 > var10_50) {
                var17_52 = (short)EInteger.SubtractInternal(var11_51, 0, var1_1.words, 0, var8_48.words, 0, var10_50);
                var18_53 = var1_1.words;
                var19_54 = var9_49 - var10_50;
                System.arraycopy((Object)var18_53, (int)var10_50, (Object)var11_51, (int)var10_50, (int)var19_54);
                EInteger.Decrement(var11_51, var10_50, var19_54, var17_52);
lbl129: // 2 sources:
                var6_5 = 0;
            } else {
                var12_55 = (short)EInteger.SubtractInternal(var11_51, 0, var8_48.words, 0, var1_1.words, 0, var9_49);
                var13_56 = var8_48.words;
                var14_57 = var10_50 - var9_49;
                System.arraycopy((Object)var13_56, (int)var9_49, (Object)var11_51, (int)var9_49, (int)var14_57);
                EInteger.Decrement(var11_51, var9_49, var14_57, var12_55);
            }
        }
        var16_58 = EInteger.CountWords(var11_51);
        if (var16_58 != 0) return new EInteger(var16_58, EInteger.ShortenArray(var11_51, var16_58), (boolean)var6_5);
        return EInteger.FromInt32(0);
    }

    public boolean CanFitInInt32() {
        short[] arrs;
        int n2 = this.wordCount;
        if (n2 > 2) {
            return false;
        }
        if (n2 == 2 && (32768 & (arrs = this.words)[1]) != 0) {
            boolean bl = this.negative;
            boolean bl2 = false;
            if (bl) {
                short s = arrs[1];
                bl2 = false;
                if (s == -32768) {
                    short s2 = arrs[0];
                    bl2 = false;
                    if (s2 == 0) {
                        bl2 = true;
                    }
                }
            }
            return bl2;
        }
        return true;
    }

    public boolean CanFitInInt64() {
        short[] arrs;
        int n2 = this.wordCount;
        if (n2 > 4) {
            return false;
        }
        if (n2 == 4 && (32768 & (arrs = this.words)[3]) != 0) {
            boolean bl = this.negative;
            boolean bl2 = false;
            if (bl) {
                short s = arrs[3];
                bl2 = false;
                if (s == -32768) {
                    short s2 = arrs[2];
                    bl2 = false;
                    if (s2 == 0) {
                        short s3 = arrs[1];
                        bl2 = false;
                        if (s3 == 0) {
                            short s4 = arrs[0];
                            bl2 = false;
                            if (s4 == 0) {
                                bl2 = true;
                            }
                        }
                    }
                }
            }
            return bl2;
        }
        return true;
    }

    public EInteger[] DivRem(EInteger eInteger) {
        Objects.requireNonNull((Object)eInteger, (String)"divisor");
        int n2 = this.wordCount;
        int n3 = eInteger.wordCount;
        if (n3 != 0) {
            if (n2 < n3) {
                EInteger[] arreInteger = new EInteger[]{EInteger.FromInt32(0), this};
                return arreInteger;
            }
            if (n3 == 1) {
                int n4;
                short[] arrs = new short[n2];
                short[] arrs2 = eInteger.words;
                short s = arrs2[0];
                int n5 = s != 2 ? (s != 10 ? 65535 & EInteger.FastDivideAndRemainder(arrs, 0, this.words, 0, n2, arrs2[0]) : EInteger.FastDivideAndRemainderTen(arrs, 0, this.words, 0, n2)) : EInteger.FastDivideAndRemainderTwo(arrs, 0, this.words, 0, n2);
                for (n4 = this.wordCount; n4 != 0 && arrs[n4 - 1] == 0; --n4) {
                }
                if (n4 == 0) {
                    EInteger[] arreInteger = new EInteger[]{EInteger.FromInt32(0), this};
                    return arreInteger;
                }
                short[] arrs3 = EInteger.ShortenArray(arrs, n4);
                boolean bl = this.negative;
                EInteger eInteger2 = new EInteger(n4, arrs3, bl ^ eInteger.negative);
                if (bl) {
                    n5 = -n5;
                }
                EInteger[] arreInteger = new EInteger[]{eInteger2, EInteger.FromInt64(n5)};
                return arreInteger;
            }
            if (this.CanFitInInt32() && eInteger.CanFitInInt32()) {
                long l2 = this.ToInt32Checked();
                long l3 = eInteger.ToInt32Checked();
                if (l2 != Integer.MIN_VALUE || l3 != -1L) {
                    long l4 = l2 / l3;
                    long l5 = l2 - l3 * l4;
                    EInteger[] arreInteger = new EInteger[]{EInteger.FromInt64(l4), EInteger.FromInt64(l5)};
                    return arreInteger;
                }
            } else if (this.CanFitInInt64() && eInteger.CanFitInInt64()) {
                long l6 = this.ToInt64Checked();
                long l7 = eInteger.ToInt64Checked();
                if (l6 != Long.MIN_VALUE || l7 != -1L) {
                    long l8 = l6 / l7;
                    long l9 = l6 - l7 * l8;
                    EInteger[] arreInteger = new EInteger[]{EInteger.FromInt64(l8), EInteger.FromInt64(l9)};
                    return arreInteger;
                }
            }
            short[] arrs = new short[n3];
            short[] arrs4 = new short[1 + (n2 - n3)];
            EInteger.GeneralDivide(this.words, 0, this.wordCount, eInteger.words, 0, eInteger.wordCount, arrs4, 0, arrs, 0);
            int n6 = EInteger.CountWords(arrs);
            int n7 = EInteger.CountWords(arrs4);
            short[] arrs5 = EInteger.ShortenArray(arrs, n6);
            short[] arrs6 = EInteger.ShortenArray(arrs4, n7);
            EInteger eInteger3 = n6 == 0 ? EInteger.FromInt32(0) : new EInteger(n6, arrs5, this.negative);
            EInteger eInteger4 = n7 == 0 ? EInteger.FromInt32(0) : new EInteger(n7, arrs6, this.negative ^ eInteger.negative);
            return new EInteger[]{eInteger4, eInteger3};
        }
        throw new ArithmeticException();
    }

    public EInteger Divide(EInteger eInteger) {
        Objects.requireNonNull((Object)eInteger, (String)"bigintDivisor");
        int n2 = this.wordCount;
        int n3 = eInteger.wordCount;
        if (n3 != 0) {
            if (n2 < n3) {
                return EInteger.FromInt32(0);
            }
            if (n2 <= 2 && n3 <= 2 && this.CanFitInInt32() && eInteger.CanFitInInt32()) {
                int n4 = this.ToInt32Checked();
                int n5 = eInteger.ToInt32Checked();
                if (n4 != Integer.MIN_VALUE || n5 != -1) {
                    return EInteger.FromInt32(n4 / n5);
                }
            }
            if (n2 <= 4 && n3 <= 4 && this.CanFitInInt64() && eInteger.CanFitInInt64()) {
                long l2 = this.ToInt64Checked();
                long l3 = eInteger.ToInt64Checked();
                if (l2 != Long.MIN_VALUE || l3 != -1L) {
                    return EInteger.FromInt64(l2 / l3);
                }
            }
            if (n3 == 1) {
                short[] arrs = this.words;
                short[] arrs2 = new short[arrs.length];
                int n6 = this.wordCount;
                short s = eInteger.words[0];
                if (s != 2) {
                    if (s != 10) {
                        EInteger.FastDivideAndRemainder(arrs2, 0, arrs, 0, n2, s);
                    } else {
                        EInteger.FastDivideAndRemainderTen(arrs2, 0, arrs, 0, n2);
                    }
                } else {
                    EInteger.FastDivideAndRemainderTwo(arrs2, 0, arrs, 0, n2);
                }
                while (n6 != 0 && arrs2[n6 - 1] == 0) {
                    --n6;
                }
                if (n6 != 0) {
                    return new EInteger(n6, arrs2, this.negative ^ eInteger.negative);
                }
                return EInteger.FromInt32(0);
            }
            short[] arrs = new short[1 + (n2 - n3)];
            EInteger.GeneralDivide(this.words, 0, this.wordCount, eInteger.words, 0, eInteger.wordCount, arrs, 0, null, 0);
            int n7 = EInteger.CountWords(arrs);
            short[] arrs3 = EInteger.ShortenArray(arrs, n7);
            if (n7 != 0) {
                return new EInteger(n7, arrs3, this.negative ^ eInteger.negative);
            }
            return EInteger.FromInt32(0);
        }
        throw new ArithmeticException();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public EInteger Gcd(EInteger var1_1) {
        Objects.requireNonNull((Object)var1_1, (String)"bigintSecond");
        if (this.isZero()) {
            return var1_1.Abs();
        }
        var3_2 = this.Abs();
        if (var1_1.isZero()) {
            return var3_2;
        }
        var4_3 = var1_1.Abs();
        if (var4_3.equals(EInteger.FromInt32(1)) != false) return var4_3;
        if (var3_2.equals(var4_3)) {
            return var4_3;
        }
        if (var3_2.equals(EInteger.FromInt32(1))) {
            return var3_2;
        }
        if (var3_2.CanFitInInt64() && var4_3.CanFitInInt64()) {
            return EInteger.GcdLong(var3_2.ToInt64Unchecked(), var4_3.ToInt64Unchecked());
        }
        var5_4 = null;
        var6_5 = var3_2.words;
        var7_6 = new short[var6_5.length];
        System.arraycopy((Object)var6_5, (int)0, (Object)var7_6, (int)0, (int)var3_2.wordCount);
        var8_7 = var4_3.words;
        var9_8 = new short[var8_7.length];
        System.arraycopy((Object)var8_7, (int)0, (Object)var9_8, (int)0, (int)var4_3.wordCount);
        var10_9 = var3_2.wordCount;
        var11_10 = var4_3.wordCount;
        var12_11 = 0;
        while (var10_9 != 0 && var11_10 != 0) {
            if (var10_9 == var11_10) {
                for (var32_29 = 0; var32_29 < var10_9; ++var32_29) {
                    if (var7_6[var32_29] == var9_8[var32_29]) {
                        continue;
                    }
                    ** break block31
                }
                var15_12 = true;
            } else lbl-1000: // 2 sources:
            {
                
                var15_12 = false;
            }
            if (var15_12) break;
            if (var10_9 <= 3 && var11_10 <= 3) {
                return EInteger.GcdLong(EInteger.WordsToLongUnchecked(var7_6, var10_9), EInteger.WordsToLongUnchecked(var9_8, var11_10));
            }
            if ((15 & var7_6[0]) == 0 && (15 & var9_8[0]) == 0) {
                if (var12_11 < 0) {
                    var5_4 = var5_4.Add(EInteger.FromInt32(4));
                } else if (var12_11 == 2147483644) {
                    var5_4 = EInteger.FromInt32(2147483644).Add(EInteger.FromInt32(4));
                    var12_11 = -1;
                } else {
                    var12_11 += 4;
                }
                var10_9 = EInteger.WordsShiftRightFour(var7_6, var10_9);
                var11_10 = EInteger.WordsShiftRightFour(var9_8, var11_10);
                continue;
            }
            var16_13 = (1 & var7_6[0]) == 0;
            var17_14 = (1 & var9_8[0]) == 0;
            if (var16_13 && var17_14) {
                if (var12_11 < 0) {
                    var5_4 = var5_4.Add(EInteger.FromInt32(1));
                } else if (var12_11 == Integer.MAX_VALUE) {
                    var5_4 = EInteger.FromInt32(Integer.MAX_VALUE).Add(EInteger.FromInt32(1));
                    var12_11 = -1;
                } else {
                    ++var12_11;
                }
                var10_9 = EInteger.WordsShiftRightOne(var7_6, var10_9);
                var11_10 = EInteger.WordsShiftRightOne(var9_8, var11_10);
                continue;
            }
            if (var16_13 && !var17_14) {
                if (Math.abs((int)(var10_9 - var11_10)) > 1 && (15 & var7_6[0]) == 0) {
                    var10_9 = EInteger.WordsShiftRightFour(var7_6, var10_9);
                    continue;
                }
                var10_9 = EInteger.WordsShiftRightOne(var7_6, var10_9);
                continue;
            }
            if (!var16_13 && var17_14) {
                if ((255 & var9_8[0]) == 0 && Math.abs((int)(var10_9 - var11_10)) > 1) {
                    if (var11_10 == 0) continue;
                    var26_23 = var11_10 - 1;
                    var27_24 = 0;
                    for (var28_25 = var26_23; var28_25 >= 0; --var28_25) {
                        var29_26 = var9_8[var28_25];
                        var30_27 = var27_24 | (var29_26 & 65280) >> 8;
                        var31_28 = 65280 & var29_26 << 8;
                        var9_8[var28_25] = (short)var30_27;
                        var27_24 = var31_28;
                    }
                    if (var9_8[var26_23] != 0) continue;
                    var11_10 = var26_23;
                    continue;
                }
                if ((15 & var9_8[0]) == 0 && Math.abs((int)(var10_9 - var11_10)) > 1) {
                    var11_10 = EInteger.WordsShiftRightFour(var9_8, var11_10);
                    continue;
                }
                var11_10 = EInteger.WordsShiftRightOne(var9_8, var11_10);
                continue;
            }
            if (EInteger.WordsCompare(var7_6, 0, var10_9, var9_8, 0, var11_10) >= 0) {
                if (Math.abs((int)((var10_9 = EInteger.WordsSubtract(var7_6, var10_9, var9_8, var11_10)) - var11_10)) > 1 && (2 & var7_6[0]) == 0) {
                    if (var10_9 == 0) continue;
                    var20_17 = var10_9 - 1;
                    var21_18 = 0;
                    for (var22_19 = var20_17; var22_19 >= 0; --var22_19) {
                        var23_20 = var7_6[var22_19];
                        var24_21 = var21_18 | (65532 & var23_20) >> 2;
                        var25_22 = 49152 & var23_20 << 14;
                        var7_6[var22_19] = (short)var24_21;
                        var21_18 = var25_22;
                    }
                    if (var7_6[var20_17] != 0) continue;
                    var10_9 = var20_17;
                    continue;
                }
                var10_9 = EInteger.WordsShiftRightOne(var7_6, var10_9);
                continue;
            }
            var18_15 = EInteger.WordsShiftRightOne(var9_8, EInteger.WordsSubtract(var9_8, var11_10, var7_6, var10_9));
            var11_10 = var10_9;
            var10_9 = var18_15;
            var19_16 = var9_8;
            var9_8 = var7_6;
            var7_6 = var19_16;
        }
        var13_30 = new EInteger(var10_9, var7_6, false);
        var14_31 = new EInteger(var11_10, var9_8, false);
        if (var12_11 >= 0) {
            if (var13_30.isZero() == false) return var13_30.ShiftLeft(var12_11);
            return var14_31.ShiftLeft(var12_11);
        }
        if (var13_30.isZero() == false) return EInteger.LeftShiftBigIntVar(var13_30, var5_4);
        return EInteger.LeftShiftBigIntVar(var14_31, var5_4);
    }

    /*
     * Enabled aggressive block sorting
     */
    public EInteger GetDigitCountAsEInteger() {
        int n2;
        int n3;
        int n4;
        long l2;
        int n5;
        int n6;
        block61 : {
            long l3;
            block59 : {
                int n7;
                int n8;
                int n9;
                block60 : {
                    block55 : {
                        long l4;
                        block57 : {
                            long l5;
                            block58 : {
                                block56 : {
                                    if (this.isZero()) {
                                        l2 = 1L;
                                        return EInteger.FromInt64(l2);
                                    }
                                    boolean bl = this.HasSmallValue();
                                    n3 = 100000;
                                    n5 = 10000000;
                                    n2 = 100000000;
                                    n4 = 1000000;
                                    n6 = 2;
                                    if (!bl) break block55;
                                    l4 = this.ToInt64Checked();
                                    if (l4 == Long.MIN_VALUE) break block56;
                                    if (l4 < 0L) {
                                        l4 = -l4;
                                    }
                                    if ((l5 = (l4 LCMP 1000000000L)) < 0) break block57;
                                    if (l4 < 1000000000000000000L) break block58;
                                }
                                l2 = 19L;
                                return EInteger.FromInt64(l2);
                            }
                            int n10 = l4 >= 100000000000000000L ? 18 : (l4 >= 10000000000000000L ? 17 : (l4 >= 1000000000000000L ? 16 : (l4 >= 100000000000000L ? 15 : (l4 >= 10000000000000L ? 14 : (l4 >= 1000000000000L ? 13 : (l4 >= 100000000000L ? 12 : (l4 >= 10000000000L ? 11 : (l5 >= 0 ? 10 : 9))))))));
                            l3 = n10;
                            break block59;
                        }
                        int n11 = (int)l4;
                        if (n11 >= n2) {
                            l2 = 9L;
                            return EInteger.FromInt64(l2);
                        }
                        if (n11 >= n5) {
                            n6 = 8;
                        } else if (n11 >= n4) {
                            n6 = 7;
                        } else if (n11 >= n3) {
                            n6 = 6;
                        } else if (n11 >= 10000) {
                            n6 = 5;
                        } else if (n11 >= 1000) {
                            n6 = 4;
                        } else if (n11 >= 100) {
                            n6 = 3;
                        } else if (n11 < 10) {
                            n6 = 1;
                        }
                        l3 = n6;
                        break block59;
                    }
                    n8 = this.wordCount < n4 ? this.GetUnsignedBitLengthAsEInteger().ToInt32Checked() : Integer.MAX_VALUE;
                    if (n8 > 2135) break block60;
                    int n12 = 1 + (631305 * (n8 - 1) >> 21);
                    int n13 = 1 + (n8 * 631305 >> 21);
                    if (n12 == n13) {
                        l2 = n12;
                        return EInteger.FromInt64(l2);
                    }
                    l3 = this.Abs().compareTo(NumberUtility.FindPowerOfTen(n12)) >= 0 ? (long)n13 : (long)n12;
                    break block59;
                }
                if (n8 > 6432162) break block61;
                int n14 = EInteger.ApproxLogTenOfTwo(n8 - 1);
                if (n14 == (n9 = EInteger.ApproxLogTenOfTwo(n8))) {
                    l2 = n14 + 1;
                    return EInteger.FromInt64(l2);
                }
                if (n8 >= 50000) break block61;
                EInteger eInteger = this.Abs();
                l3 = eInteger.compareTo(NumberUtility.FindPowerOfTen(n7 = n14 + 1)) >= 0 ? (long)(n9 + 1) : (long)n7;
            }
            l2 = l3;
            return EInteger.FromInt64(l2);
        }
        short[] arrs = null;
        int n15 = this.wordCount;
        long l6 = 0L;
        while (n15 != 0) {
            int n16;
            block63 : {
                block73 : {
                    long l7;
                    block65 : {
                        block74 : {
                            int n17;
                            block77 : {
                                block72 : {
                                    block76 : {
                                        block71 : {
                                            block75 : {
                                                block70 : {
                                                    block62 : {
                                                        int n18;
                                                        block69 : {
                                                            block68 : {
                                                                block67 : {
                                                                    block66 : {
                                                                        block64 : {
                                                                            if (n15 == 1 || n15 == n6 && arrs[1] == false) break block62;
                                                                            if (n15 != n6 || arrs[1] <= 0 || arrs[1] > 32767) break block63;
                                                                            n18 = 65535 & arrs[0] | (65535 & arrs[1]) << 16;
                                                                            if (n18 < 1000000000) break block64;
                                                                            l7 = 10L;
                                                                            break block65;
                                                                        }
                                                                        if (n18 < n2) break block66;
                                                                        l7 = 9L;
                                                                        break block65;
                                                                    }
                                                                    if (n18 < n5) break block67;
                                                                    l7 = 8L;
                                                                    break block65;
                                                                }
                                                                if (n18 < n4) break block68;
                                                                l7 = 7L;
                                                                break block65;
                                                            }
                                                            if (n18 < n3) break block69;
                                                            l7 = 6L;
                                                            break block65;
                                                        }
                                                        if (n18 >= 10000) break block70;
                                                        if (n18 >= 1000) break block71;
                                                        if (n18 >= 100) break block72;
                                                        if (n18 < 10) break block73;
                                                        break block74;
                                                    }
                                                    n17 = 65535 & arrs[0];
                                                    if (n17 < 10000) break block75;
                                                }
                                                l7 = 5L;
                                                break block65;
                                            }
                                            if (n17 < 1000) break block76;
                                        }
                                        l6 += 4L;
                                        break;
                                    }
                                    if (n17 < 100) break block77;
                                }
                                l7 = 3L;
                                break block65;
                            }
                            if (n17 < 10) break block73;
                        }
                        l7 = 2L;
                    }
                    l6 += l7;
                    break;
                }
                ++l6;
                break;
            }
            short[] arrs2 = arrs == null ? this.words : arrs;
            boolean bl = false;
            int n19 = 0;
            int n20 = n15;
            do {
                int n21;
                int n22;
                int n23;
                block78 : {
                    block81 : {
                        int n24;
                        block80 : {
                            int n25;
                            int n26;
                            block79 : {
                                n23 = n15 - 1;
                                if (n15 <= 0) break;
                                n21 = 65535 & arrs2[n23] | n19 << 16;
                                n22 = n21 / 10000;
                                if (bl || n22 == 0) break block78;
                                if (n23 < n4) {
                                    int n27;
                                    int n28 = n23 + 1;
                                    if (n28 != 0) {
                                        n27 = n28 - 1 << 4;
                                        if (n22 != 0) {
                                            int n29;
                                            n27 += 16;
                                            if (n22 >> 8 == 0) {
                                                n29 = n22 << 8;
                                                n27 -= 8;
                                            } else {
                                                n29 = n22;
                                            }
                                            if (n29 >> 12 == 0) {
                                                n29 <<= 4;
                                                n27 -= 4;
                                            }
                                            if (n29 >> 14 == 0) {
                                                n29 <<= 2;
                                                n27 -= 2;
                                            }
                                            if (n29 >> 15 == 0) {
                                                // empty if block
                                            }
                                        }
                                    } else {
                                        n27 = 0;
                                    }
                                    n26 = --n27;
                                } else {
                                    n26 = Integer.MAX_VALUE;
                                }
                                if (n26 > 2135) break block79;
                                n24 = 1 + (631305 * (n26 - 1) >> 21);
                                int n30 = 1 + (n26 * 631305 >> 21);
                                if (n24 == n30) break block80;
                                if (n24 > 1) {
                                    int n31 = n30 + 4;
                                    int n32 = n24 + 4;
                                    long l8 = this.Abs().compareTo(NumberUtility.FindPowerOfTen(n32)) >= 0 ? (long)n31 : (long)n32;
                                    l2 = l6 + l8;
                                    return EInteger.FromInt64(l2);
                                }
                                break block81;
                            }
                            if (n26 > 6432162 || (n25 = EInteger.ApproxLogTenOfTwo(n26 - 1)) != EInteger.ApproxLogTenOfTwo(n26)) break block81;
                            ++l6;
                            n24 = n25;
                        }
                        l2 = 4L + (l6 + (long)n24);
                        return EInteger.FromInt64(l2);
                    }
                    bl = true;
                }
                if (arrs == null) {
                    if (n22 != 0) {
                        int n33 = this.wordCount;
                        short[] arrs3 = new short[n33];
                        System.arraycopy((Object)this.words, (int)0, (Object)arrs3, (int)0, (int)n33);
                        int n34 = n23 + 1;
                        arrs3[n23] = (short)n22;
                        n20 = n34;
                        arrs = arrs3;
                    }
                } else {
                    arrs[n23] = (short)n22;
                }
                short s = (short)(n21 - n22 * 10000);
                n15 = n23;
                n19 = s;
                n4 = 1000000;
            } while (true);
            n15 = n20;
            while (n15 != 0 && arrs[n16 = n15 - 1] == 0) {
                n15 = n16;
            }
            l6 += 4L;
            n3 = 100000;
            n5 = 10000000;
            n2 = 100000000;
            n4 = 1000000;
            n6 = 2;
        }
        l2 = l6;
        return EInteger.FromInt64(l2);
    }

    public EInteger GetLowBitAsEInteger() {
        long l2 = 0L;
        for (int i2 = 0; i2 < this.wordCount; ++i2) {
            int n2 = 65535 & this.words[i2];
            if (n2 == 0) {
                l2 += 16L;
                continue;
            }
            int n3 = (65535 & n2 << 15) != 0 ? 0 : ((65535 & n2 << 14) != 0 ? 1 : ((65535 & n2 << 13) != 0 ? 2 : ((65535 & n2 << 12) != 0 ? 3 : ((65535 & n2 << 11) != 0 ? 4 : ((65535 & n2 << 10) != 0 ? 5 : ((65535 & n2 << 9) != 0 ? 6 : ((65535 & n2 << 8) != 0 ? 7 : ((65535 & n2 << 7) != 0 ? 8 : ((65535 & n2 << 6) != 0 ? 9 : ((65535 & n2 << 5) != 0 ? 10 : ((65535 & n2 << 4) != 0 ? 11 : ((65535 & n2 << 3) != 0 ? 12 : ((65535 & n2 << 2) != 0 ? 13 : ((65535 & n2 << 1) != 0 ? 14 : 15))))))))))))));
            return EInteger.FromInt64(l2).Add(EInteger.FromInt32(n3));
        }
        return EInteger.FromInt32(-1);
    }

    public boolean GetSignedBit(int n2) {
        if (n2 >= 0) {
            if (this.wordCount == 0) {
                return false;
            }
            if (this.negative) {
                int n3;
                int n4 = n2 / 16;
                if (n4 >= this.words.length) {
                    return true;
                }
                for (n3 = 0; n3 < n4 && this.words[n3] == 0; ++n3) {
                }
                short s = this.words[n4];
                if (n3 == n4) {
                    s = (short)(s - 1);
                }
                int n5 = 1 & (short)s >> (n2 & 15);
                boolean bl = false;
                if (n5 != 0) {
                    bl = true;
                }
                return bl;
            }
            return this.GetUnsignedBit(n2);
        }
        throw new IllegalArgumentException("index");
    }

    public EInteger GetSignedBitLengthAsEInteger() {
        int n2 = this.wordCount;
        if (n2 != 0) {
            int n3;
            if (this.negative) {
                EInteger eInteger = this.Abs();
                if (n2 > 1 && eInteger.words[0] != 0) {
                    return eInteger.GetSignedBitLengthAsEInteger();
                }
                return eInteger.Subtract(EInteger.FromInt32(1)).GetSignedBitLengthAsEInteger();
            }
            short[] arrs = this.words;
            int n4 = n2 - 1;
            int n5 = 65535 & arrs[n4];
            if (n5 != 0) {
                if (n5 >> 8 == 0) {
                    n5 <<= 8;
                    n3 = 8;
                } else {
                    n3 = 16;
                }
                if (n5 >> 12 == 0) {
                    n5 <<= 4;
                    n3 -= 4;
                }
                if (n5 >> 14 == 0) {
                    n5 <<= 2;
                    n3 -= 2;
                }
                if (n5 >> 15 == 0) {
                    --n3;
                }
            } else {
                n3 = 0;
            }
            if (n2 < 268435440) {
                return EInteger.FromInt32(n3 + (n4 << 4));
            }
            EInteger.FromInt32(n2).Subtract(1).Multiply(16).Add(n3);
        }
        return EInteger.FromInt32(0);
    }

    public boolean GetUnsignedBit(int n2) {
        if (n2 >= 0) {
            int n3 = n2 >> 4;
            short[] arrs = this.words;
            int n4 = arrs.length;
            boolean bl = false;
            if (n3 < n4) {
                boolean bl2 = (1 & arrs[n3] >> (n2 & 15)) != 0;
                bl = false;
                if (bl2) {
                    bl = true;
                }
            }
            return bl;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"index (", (int)n2, (String)") is less than 0"));
    }

    public EInteger GetUnsignedBitLengthAsEInteger() {
        int n2 = this.wordCount;
        if (n2 != 0) {
            short[] arrs = this.words;
            int n3 = n2 - 1;
            int n4 = 65535 & arrs[n3];
            EInteger eInteger = EInteger.FromInt32(n3).ShiftLeft(4);
            if (n4 == 0) {
                return eInteger;
            }
            int n5 = 16;
            if (n4 >> 8 == 0) {
                n4 <<= 8;
                n5 = 8;
            }
            if (n4 >> 12 == 0) {
                n4 <<= 4;
                n5 -= 4;
            }
            if (n4 >> 14 == 0) {
                n4 <<= 2;
                n5 -= 2;
            }
            if (n4 >> 15 == 0) {
                --n5;
            }
            return eInteger.Add(EInteger.FromInt32(n5));
        }
        return EInteger.FromInt32(0);
    }

    public final boolean HasSmallValue() {
        short[] arrs;
        int n2 = this.wordCount;
        if (n2 > 4) {
            return false;
        }
        if (n2 == 4 && (32768 & (arrs = this.words)[3]) != 0) {
            boolean bl = this.negative;
            boolean bl2 = false;
            if (bl) {
                short s = arrs[3];
                bl2 = false;
                if (s == -32768) {
                    short s2 = arrs[2];
                    bl2 = false;
                    if (s2 == 0) {
                        short s3 = arrs[1];
                        bl2 = false;
                        if (s3 == 0) {
                            short s4 = arrs[0];
                            bl2 = false;
                            if (s4 == 0) {
                                bl2 = true;
                            }
                        }
                    }
                }
            }
            return bl2;
        }
        return true;
    }

    public EInteger Multiply(int n2) {
        return this.Multiply(EInteger.FromInt32(n2));
    }

    public EInteger Multiply(EInteger eInteger) {
        int n2;
        EInteger eInteger2 = eInteger;
        Objects.requireNonNull((Object)eInteger2, (String)"bigintMult");
        int n3 = this.wordCount;
        if (n3 != 0 && (n2 = eInteger2.wordCount) != 0) {
            int n4;
            short[] arrs;
            int n5;
            int n6 = 1;
            if (n3 == n6 && this.words[0] == n6) {
                if (this.negative) {
                    eInteger2 = eInteger.Negate();
                }
                return eInteger2;
            }
            if (n2 == n6 && eInteger2.words[0] == n6) {
                if (eInteger2.negative) {
                    return this.Negate();
                }
                return this;
            }
            if (n3 == n6) {
                if (n2 == n6) {
                    short[] arrs2 = new short[2];
                    int n7 = (65535 & this.words[0]) * (65535 & eInteger2.words[0]);
                    arrs2[0] = (short)(n7 & 65535);
                    arrs2[n6] = (short)(65535 & n7 >> 16);
                    if (arrs2[n6] != 0) {
                        n6 = 2;
                    }
                    return new EInteger(n6, arrs2, this.negative ^ eInteger2.negative);
                }
                n5 = n2 + 1;
                arrs = new short[n5];
                short[] arrs3 = eInteger2.words;
                short s = this.words[0];
                arrs[n2] = EInteger.LinearMultiply(arrs, 0, arrs3, 0, s, n2);
                n4 = 0;
            } else if (n2 == n6) {
                int n8 = n3 + 1;
                arrs = new short[n8];
                short[] arrs4 = this.words;
                short s = eInteger2.words[0];
                arrs[n3] = EInteger.LinearMultiply(arrs, 0, arrs4, 0, s, n3);
                n5 = n8;
                n4 = 0;
            } else if (this.equals(eInteger)) {
                int n9 = this.wordCount;
                int n10 = n9 + n9;
                short[] arrs5 = new short[n10];
                EInteger.RecursiveSquare(arrs5, 0, new short[n10], 0, this.words, 0, n9);
                n4 = n6;
                n5 = n10;
                arrs = arrs5;
            } else {
                int n11;
                int n12 = this.wordCount;
                if (n12 <= 10 && (n11 = eInteger2.wordCount) <= 10) {
                    int n13 = n12 + n11;
                    arrs = new short[n13];
                    short[] arrs6 = this.words;
                    short[] arrs7 = eInteger2.words;
                    EInteger.SchoolbookMultiply(arrs, 0, arrs6, 0, n12, arrs7, 0, n11);
                    n5 = n13;
                    n4 = 0;
                } else {
                    int n14 = eInteger2.wordCount;
                    int n15 = n12 + n14;
                    arrs = new short[n15];
                    short[] arrs8 = new short[n15];
                    short[] arrs9 = this.words;
                    short[] arrs10 = eInteger2.words;
                    EInteger.AsymmetricMultiply(arrs, 0, arrs8, 0, arrs9, 0, n12, arrs10, 0, n14);
                    n4 = n6;
                    n5 = n15;
                }
            }
            while (n5 != 0 && arrs[n5 - 1] == 0) {
                --n5;
            }
            if (n4 != 0) {
                arrs = EInteger.ShortenArray(arrs, n5);
            }
            return new EInteger(n5, arrs, this.negative ^ eInteger2.negative);
        }
        return EInteger.FromInt32(0);
    }

    public EInteger Negate() {
        int n2 = this.wordCount;
        if (n2 == 0) {
            return this;
        }
        return new EInteger(n2, this.words, true ^ this.negative);
    }

    public EInteger Pow(int n2) {
        if (n2 >= 0) {
            if (n2 == 0) {
                return EInteger.FromInt32(1);
            }
            if (n2 == 1) {
                return this;
            }
            if (!this.isZero()) {
                if (this.compareTo(1) == 0) {
                    return this;
                }
                if (this.compareTo(-1) == 0) {
                    if (this.isEven()) {
                        return EInteger.FromInt32(1);
                    }
                    return this;
                }
                if (n2 == 2) {
                    return this.Multiply(this);
                }
                if (n2 == 3) {
                    return this.Multiply(this).Multiply(this);
                }
                EInteger eInteger = EInteger.FromInt32(1);
                EInteger eInteger2 = this;
                while (n2 != 0) {
                    if ((n2 & 1) != 0) {
                        eInteger = eInteger.Multiply(eInteger2);
                    }
                    if ((n2 >>= 1) == 0) continue;
                    eInteger2 = eInteger2.Multiply(eInteger2);
                }
                return eInteger;
            }
            return this;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"powerSmall (", (int)n2, (String)") is less than 0"));
    }

    public EInteger Remainder(int n2) {
        return this.Remainder(EInteger.FromInt32(n2));
    }

    public EInteger Remainder(EInteger eInteger) {
        Objects.requireNonNull((Object)eInteger, (String)"divisor");
        int n2 = this.wordCount;
        int n3 = eInteger.wordCount;
        if (n3 != 0) {
            if (n2 < n3) {
                return this;
            }
            int n4 = 1;
            if (n3 == n4) {
                short[] arrs = this.words;
                short s = eInteger.words[0];
                int n5 = 0;
                do {
                    int n6;
                    int n7 = n2 - 1;
                    if (n2 <= 0) break;
                    int n8 = 65535 & arrs[n7] | n5 << 16;
                    int n9 = s & 65535;
                    if (n8 >> 31 == 0) {
                        n6 = 65535 & n8 % n9;
                    } else {
                        int n10 = 0;
                        for (int i2 = 0; i2 < 32; ++i2) {
                            int n11 = n10 >> 31;
                            n10 = n10 << 1 | n4 & n8 >> 31;
                            n8 <<= n4;
                            int n12 = n11 | n10;
                            if (n12 >> 31 == 0 && n12 < n9) continue;
                            n10 -= n9;
                            ++n8;
                        }
                        n6 = n10 & 65535;
                    }
                    n5 = (short)n6;
                    n2 = n7;
                } while (true);
                int n13 = n5 & 65535;
                if (this.negative) {
                    n13 = -n13;
                }
                return EInteger.FromInt64(n13);
            }
            if (n2 == n3) {
                n4 = EInteger.Compare(this.words, 0, eInteger.words, 0, n2);
            } else if (n2 <= n3) {
                n4 = -1;
            }
            if (n4 < 0) {
                return this;
            }
            short[] arrs = new short[n3];
            EInteger.GeneralDivide(this.words, 0, this.wordCount, eInteger.words, 0, eInteger.wordCount, null, 0, arrs, 0);
            int n14 = EInteger.CountWords(arrs);
            if (n14 == 0) {
                return EInteger.FromInt32(0);
            }
            return new EInteger(n14, EInteger.ShortenArray(arrs, n14), this.negative);
        }
        throw new ArithmeticException();
    }

    public EInteger ShiftLeft(int n2) {
        if (n2 != 0) {
            int n3 = this.wordCount;
            if (n3 == 0) {
                return this;
            }
            if (n2 < 0) {
                if (n2 == Integer.MIN_VALUE) {
                    return this.ShiftRight(1).ShiftRight(Integer.MAX_VALUE);
                }
                return this.ShiftRight(-n2);
            }
            int n4 = n2 >> 4;
            int n5 = n2 & 15;
            if (!this.negative) {
                short[] arrs = new short[n3 + (n2 + 15 >> 4)];
                System.arraycopy((Object)this.words, (int)0, (Object)arrs, (int)n4, (int)n3);
                EInteger.ShiftWordsLeftByBits(arrs, n4, n3 + (n5 + 15 >> 4), n5);
                return new EInteger(EInteger.CountWords(arrs), arrs, false);
            }
            int n6 = n3 + (n2 + 15 >> 4);
            short[] arrs = new short[n6];
            System.arraycopy((Object)this.words, (int)0, (Object)arrs, (int)0, (int)n3);
            EInteger.TwosComplement(arrs, 0, n6);
            int n7 = n3 + n4;
            int n8 = Math.min((int)n4, (int)n7);
            if (n8 != 0) {
                while (--n7 >= n8) {
                    int n9 = 0 + n7;
                    arrs[n9] = arrs[n9 - n8];
                }
                Arrays.fill((short[])arrs, (int)0, (int)(n8 + 0), (short)0);
            }
            EInteger.ShiftWordsLeftByBits(arrs, n4, n3 + (n5 + 15 >> 4), n5);
            EInteger.TwosComplement(arrs, 0, n6);
            return new EInteger(EInteger.CountWords(arrs), arrs, true);
        }
        return this;
    }

    public EInteger ShiftLeft(EInteger eInteger) {
        Objects.requireNonNull((Object)eInteger, (String)"eshift");
        if (eInteger.signum() < 0) {
            return this.ShiftRight(eInteger.Negate());
        }
        EInteger eInteger2 = this;
        while (!eInteger.CanFitInInt32()) {
            eInteger = eInteger.Subtract(2147483632);
            eInteger2 = eInteger2.ShiftLeft(2147483632);
        }
        return eInteger2.ShiftLeft(eInteger.ToInt32Checked());
    }

    public EInteger ShiftRight(int n2) {
        if (n2 != 0) {
            short[] arrs;
            int n3;
            int n4 = this.wordCount;
            if (n4 == 0) {
                return this;
            }
            if (n2 < 0) {
                if (n2 == Integer.MIN_VALUE) {
                    return this.ShiftLeft(1).ShiftLeft(Integer.MAX_VALUE);
                }
                return this.ShiftLeft(-n2);
            }
            int n5 = n2 >> 4;
            int n6 = n2 & 15;
            if (this.negative) {
                short[] arrs2 = this.words;
                n3 = arrs2.length;
                arrs = new short[n3];
                System.arraycopy((Object)arrs2, (int)0, (Object)arrs, (int)0, (int)n4);
                EInteger.TwosComplement(arrs, 0, n3);
                int n7 = Math.min((int)n5, (int)n4);
                if (n7 != 0) {
                    int n8 = 0;
                    while (n8 + n7 < n4) {
                        int n9 = 0 + n8;
                        arrs[n9] = arrs[n9 + n7];
                        ++n8;
                    }
                    int n10 = 0 + (n4 - n7);
                    for (int i2 = 0; i2 < n7; ++i2) {
                        arrs[n10 + i2] = -1;
                    }
                }
                if (n4 > n5) {
                    int n11 = 16 - n6;
                    short s = (short)(65535 << n11);
                    if (n6 != 0) {
                        for (int i3 = n4 - n5; i3 > 0; --i3) {
                            int n12 = -1 + (0 + i3);
                            int n13 = 65535 & arrs[n12];
                            arrs[n12] = (short)(n13 >> n6 | s & 65535);
                            s = (short)(n13 << n11);
                        }
                    }
                }
                EInteger.TwosComplement(arrs, 0, n3);
            } else {
                if (n5 >= n4) {
                    return EInteger.FromInt32(0);
                }
                short[] arrs3 = this.words;
                arrs = new short[arrs3.length];
                n3 = n4 - n5;
                System.arraycopy((Object)arrs3, (int)n5, (Object)arrs, (int)0, (int)n3);
                if (n6 != 0) {
                    EInteger.ShiftWordsRightByBits(arrs, 0, n3, n6);
                }
            }
            while (n3 != 0 && arrs[n3 - 1] == 0) {
                --n3;
            }
            if (n3 == 0) {
                return EInteger.FromInt32(0);
            }
            if (n5 > 2) {
                arrs = EInteger.ShortenArray(arrs, n3);
            }
            return new EInteger(n3, arrs, this.negative);
        }
        return this;
    }

    public EInteger ShiftRight(EInteger eInteger) {
        if (eInteger.signum() < 0) {
            return this.ShiftLeft(eInteger.Negate());
        }
        EInteger eInteger2 = this;
        while (!eInteger.CanFitInInt32()) {
            eInteger = eInteger.Subtract(2147483632);
            eInteger2 = eInteger2.ShiftRight(2147483632);
        }
        return eInteger2.ShiftRight(eInteger.ToInt32Checked());
    }

    public final String SmallValueToString() {
        long l2 = this.ToInt64Unchecked();
        if (l2 == Long.MIN_VALUE) {
            return "-9223372036854775808";
        }
        if (l2 == Integer.MIN_VALUE) {
            return "-2147483648";
        }
        boolean bl = l2 < 0L;
        int n2 = (int)l2;
        if ((long)n2 == l2) {
            char[] arrc = new char[12];
            int n3 = 11;
            if (bl) {
                n2 = -n2;
            }
            while (n2 > 43698) {
                int n4 = n2 / 10;
                char c2 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(n2 - n4 * 10);
                int n5 = n3 - 1;
                arrc[n3] = c2;
                n3 = n5;
                n2 = n4;
            }
            while (n2 > 9) {
                int n6 = n2 * 26215 >> 18;
                char c3 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(n2 - n6 * 10);
                int n7 = n3 - 1;
                arrc[n3] = c3;
                n3 = n7;
                n2 = n6;
            }
            if (n2 != 0) {
                int n8 = n3 - 1;
                arrc[n3] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(n2);
                n3 = n8;
            }
            if (bl) {
                arrc[n3] = 45;
            } else {
                ++n3;
            }
            return new String(arrc, n3, 12 - n3);
        }
        char[] arrc = new char[24];
        int n9 = 23;
        if (bl) {
            l2 = -l2;
        }
        while (l2 > 9L) {
            long l3 = l2 / 10L;
            char c4 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((int)(l2 - 10L * l3));
            int n10 = n9 - 1;
            arrc[n9] = c4;
            n9 = n10;
            l2 = l3;
        }
        if (l2 != 0L) {
            int n11 = n9 - 1;
            arrc[n9] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((int)l2);
            n9 = n11;
        }
        if (bl) {
            arrc[n9] = 45;
        } else {
            ++n9;
        }
        return new String(arrc, n9, 24 - n9);
    }

    public EInteger Subtract(int n2) {
        if (n2 == Integer.MIN_VALUE) {
            return this.Subtract(EInteger.FromInt32(n2));
        }
        if (n2 == 0) {
            return this;
        }
        return this.Add(-n2);
    }

    public EInteger Subtract(EInteger eInteger) {
        Objects.requireNonNull((Object)eInteger, (String)"subtrahend");
        if (this.wordCount == 0) {
            return eInteger.Negate();
        }
        if (eInteger.wordCount == 0) {
            return this;
        }
        return this.Add(eInteger.Negate());
    }

    public byte[] ToBytes(boolean bl) {
        int n2 = this.signum();
        int n3 = 0;
        int n4 = 1;
        if (n2 == 0) {
            byte[] arrby = new byte[n4];
            arrby[0] = 0;
            return arrby;
        }
        if (n2 > 0) {
            int n5;
            int n6 = this.wordCount;
            if (n6 == 0) {
                n5 = 0;
            } else {
                short[] arrs = this.words;
                int n7 = n6 - 1;
                short s = arrs[n7];
                n5 = n7 << n4;
                if (s != 0) {
                    n5 = s >> 8 == 0 ? ++n5 : (n5 += 2);
                }
            }
            int n8 = this.GetUnsignedBit(n5 * 8 - n4) ? n5 + 1 : n5;
            byte[] arrby = new byte[n8];
            int n9 = 0;
            while (n3 < n5) {
                int n10 = bl ? n3 : n8 - 1 - n3;
                int n11 = bl ? n3 + 1 : n8 - 2 - n3;
                short[] arrs = this.words;
                arrby[n10] = (byte)(255 & arrs[n9]);
                if (n11 >= 0 && n11 < n8) {
                    arrby[n11] = (byte)(255 & arrs[n9] >> 8);
                }
                n3 += 2;
                ++n9;
            }
            return arrby;
        }
        short[] arrs = this.words;
        int n12 = arrs.length;
        short[] arrs2 = new short[n12];
        System.arraycopy((Object)arrs, (int)0, (Object)arrs2, (int)0, (int)arrs.length);
        EInteger.TwosComplement(arrs2, 0, n12);
        int n13 = n12 * 2;
        int n14 = n13;
        for (int i2 = n12 - n4; i2 >= 0; --i2) {
            if (arrs2[i2] == -1) {
                n14 -= 2;
                continue;
            }
            if ((65408 & arrs2[i2]) == 65408) {
                --n14;
                break;
            }
            if ((32768 & arrs2[i2]) == 32768) break;
            ++n14;
            break;
        }
        if (n14 != 0) {
            n4 = n14;
        }
        byte[] arrby = new byte[n4];
        int n15 = bl ? n4 - 1 : 0;
        arrby[n15] = -1;
        int n16 = Math.min((int)n4, (int)n13);
        int n17 = 0;
        while (n3 < n16) {
            int n18 = bl ? n3 : n4 - 1 - n3;
            int n19 = bl ? n3 + 1 : n4 - 2 - n3;
            arrby[n18] = (byte)(255 & arrs2[n17]);
            if (n19 >= 0 && n19 < n16) {
                arrby[n19] = (byte)(255 & arrs2[n17] >> 8);
            }
            n3 += 2;
            ++n17;
        }
        return arrby;
    }

    public int ToInt32Checked() {
        int n2 = this.wordCount;
        if (n2 == 0) {
            return 0;
        }
        if (n2 <= 2) {
            short[] arrs;
            if (n2 == 2 && (32768 & (arrs = this.words)[1]) != 0) {
                if (this.negative && arrs[1] == -32768 && arrs[0] == 0) {
                    return Integer.MIN_VALUE;
                }
                throw new ArithmeticException();
            }
            return this.ToInt32Unchecked();
        }
        throw new ArithmeticException();
    }

    public int ToInt32Unchecked() {
        int n2 = this.wordCount;
        if (n2 == 0) {
            return 0;
        }
        short[] arrs = this.words;
        int n3 = 65535 & arrs[0];
        if (n2 > 1) {
            n3 |= (65535 & arrs[1]) << 16;
        }
        if (this.negative) {
            --n3;
        }
        return n3;
    }

    public long ToInt64Checked() {
        int n2 = this.wordCount;
        if (n2 == 0) {
            return 0L;
        }
        if (n2 <= 4) {
            short[] arrs;
            if (n2 == 4 && (32768 & (arrs = this.words)[3]) != 0) {
                if (this.negative && arrs[3] == -32768 && arrs[2] == 0 && arrs[1] == 0 && arrs[0] == 0) {
                    return Long.MIN_VALUE;
                }
                throw new ArithmeticException();
            }
            return this.ToInt64Unchecked();
        }
        throw new ArithmeticException();
    }

    public long ToInt64Unchecked() {
        int n2 = this.wordCount;
        if (n2 == 0) {
            return 0L;
        }
        short[] arrs = this.words;
        int n3 = 65535 & arrs[0];
        if (n2 > 1) {
            n3 |= (65535 & arrs[1]) << 16;
        }
        if (n2 > 2) {
            int n4 = 65535 & arrs[2];
            if (n2 > 3) {
                n4 |= (65535 & arrs[3]) << 16;
            }
            if (this.negative) {
                int n5;
                if (n3 == 0) {
                    n5 = n3 - 1;
                    --n4;
                } else {
                    n5 = n3 - 1;
                }
                n3 = n5;
            }
            return 0xFFFFFFFFL & (long)n3 | (long)n4 << 32;
        }
        long l2 = 0xFFFFFFFFL & (long)n3;
        if (this.negative) {
            l2 = -l2;
        }
        return l2;
    }

    public final void ToRadixStringDecimal(StringBuilder stringBuilder, boolean bl) {
        int n2;
        if (this.wordCount >= 100 && bl) {
            StringBuilder stringBuilder2 = new StringBuilder();
            int n3 = 3 * this.wordCount;
            EInteger[] arreInteger = this.DivRem(NumberUtility.FindPowerOfTen(n3));
            arreInteger[0].ToRadixStringDecimal(stringBuilder, bl);
            arreInteger[1].ToRadixStringDecimal(stringBuilder2, bl);
            for (int i2 = stringBuilder2.length(); i2 < n3; ++i2) {
                stringBuilder.append('0');
            }
            stringBuilder.append(stringBuilder2.toString());
            return;
        }
        if (this.HasSmallValue()) {
            stringBuilder.append(this.SmallValueToString());
            return;
        }
        short[] arrs = new short[n2];
        System.arraycopy((Object)this.words, (int)0, (Object)arrs, (int)0, (int)n2);
        for (n2 = this.wordCount; n2 != 0 && arrs[n2 - 1] == 0; --n2) {
        }
        char[] arrc = new char[1 + (n2 << 4)];
        int n4 = 0;
        while (n2 != 0) {
            if (n2 == 1 && arrs[0] > 0 && arrs[0] <= 32767) {
                int n5 = arrs[0];
                while (n5 != 0) {
                    int n6 = n5 * 26215 >> 18;
                    int n7 = n4 + 1;
                    arrc[n4] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(n5 - n6 * 10);
                    n5 = n6;
                    n4 = n7;
                }
                break;
            }
            if (n2 == 2 && arrs[1] > 0 && arrs[1] <= 32767) {
                int n8 = 65535 & arrs[0] | (65535 & arrs[1]) << 16;
                while (n8 != 0) {
                    int n9 = n8 < 43698 ? n8 * 26215 >> 18 : n8 / 10;
                    int n10 = n4 + 1;
                    arrc[n4] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(n8 - n9 * 10);
                    n8 = n9;
                    n4 = n10;
                }
                break;
            }
            int n11 = n2;
            int n12 = 0;
            do {
                int n13 = n11 - 1;
                if (n11 <= 0) break;
                int n14 = 65535 & arrs[n13] | n12 << 16;
                int n15 = n14 / 10000;
                arrs[n13] = (short)n15;
                n12 = (short)(n14 - n15 * 10000);
                n11 = n13;
            } while (true);
            while (n2 != 0 && arrs[n2 - 1] == 0) {
                --n2;
            }
            int n16 = n12 * 3277 >> 15;
            int n17 = n4 + 1;
            arrc[n4] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(n12 - n16 * 10);
            int n18 = n16 * 3277 >> 15;
            int n19 = n17 + 1;
            arrc[n17] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(n16 - n18 * 10);
            int n20 = n18 * 3277 >> 15;
            int n21 = n19 + 1;
            arrc[n19] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(n18 - n20 * 10);
            n4 = n21 + 1;
            arrc[n21] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(n20);
        }
        EInteger.ReverseChars(arrc, 0, n4);
        stringBuilder.append(arrc, 0, n4 + 0);
    }

    public int compareTo(int n2) {
        short[] arrs;
        int n3 = this.wordCount;
        int n4 = -1;
        if (n3 > 2) {
            if (this.negative) {
                return n4;
            }
            return 1;
        }
        if (n3 == 2 && (32768 & (arrs = this.words)[1]) != 0) {
            boolean bl = this.negative;
            if (bl && arrs[1] == -32768 && arrs[0] == 0) {
                if (n2 == Integer.MIN_VALUE) {
                    n4 = 0;
                }
                return n4;
            }
            if (bl) {
                return n4;
            }
            return 1;
        }
        int n5 = this.ToInt32Unchecked();
        if (n5 == n2) {
            return 0;
        }
        if (n5 < n2) {
            return n4;
        }
        return 1;
    }

    public int compareTo(EInteger eInteger) {
        int n2;
        int n3;
        int n4 = 1;
        if (eInteger == null) {
            return n4;
        }
        if (this == eInteger) {
            return 0;
        }
        int n5 = this.wordCount;
        int n6 = n5 == 0 ? 0 : (this.negative ? -1 : n4);
        if (n6 != (n3 = (n2 = eInteger.wordCount) == 0 ? 0 : (eInteger.negative ? -1 : n4))) {
            if (n6 < n3) {
                n4 = -1;
            }
            return n4;
        }
        if (n6 == 0) {
            return 0;
        }
        if (n5 == n2) {
            if (n5 == n4 && this.words[0] == eInteger.words[0]) {
                return 0;
            }
            short[] arrs = this.words;
            short[] arrs2 = eInteger.words;
            do {
                int n7 = n5 - 1;
                if (n5 == 0) break;
                int n8 = 65535 & arrs[n7];
                int n9 = 65535 & arrs2[n7];
                if (n8 > n9) {
                    if (n6 > 0) {
                        return n4;
                    }
                    return -1;
                }
                if (n8 < n9) {
                    if (n6 > 0) {
                        n4 = -1;
                    }
                    return n4;
                }
                n5 = n7;
            } while (true);
            return 0;
        }
        int n10 = n5 > n2 ? n4 : 0;
        int n11 = 0;
        if (n6 <= 0) {
            n11 = n4;
        }
        if ((n10 ^ n11) != 0) {
            return n4;
        }
        return -1;
    }

    public boolean equals(Object object) {
        EInteger eInteger = object instanceof EInteger ? (EInteger)object : null;
        if (eInteger == null) {
            return false;
        }
        if (this.wordCount == eInteger.wordCount) {
            if (this.negative != eInteger.negative) {
                return false;
            }
            for (int i2 = 0; i2 < this.wordCount; ++i2) {
                if (this.words[i2] == eInteger.words[i2]) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int n2 = 0 + 1000000007 * this.signum();
        short[] arrs = this.words;
        if (arrs != null) {
            for (int i2 = 0; i2 < this.wordCount; ++i2) {
                n2 += 1000000013 * this.words[i2];
            }
        }
        return n2;
    }

    public final boolean isEven() {
        return true ^ this.GetUnsignedBit(0);
    }

    public final boolean isZero() {
        return this.wordCount == 0;
    }

    public final int signum() {
        if (this.wordCount == 0) {
            return 0;
        }
        if (this.negative) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        boolean bl = this.isZero();
        String string = "0";
        if (bl) {
            return string;
        }
        if (this.HasSmallValue()) {
            return this.SmallValueToString();
        }
        if (this.wordCount != 0) {
            if (this.HasSmallValue()) {
                string = this.SmallValueToString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                if (this.negative) {
                    stringBuilder.append('-');
                }
                this.Abs().ToRadixStringDecimal(stringBuilder, true);
                string = stringBuilder.toString();
            }
        }
        return string;
    }
}

