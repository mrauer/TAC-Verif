/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.ArithmeticException
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec.custom.sec;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat576;

public class SecT239Field {
    public static int add1(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) + (0xFFFFFFFFL & (long)arrn2[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >>> 32) + ((0xFFFFFFFFL & (long)arrn[1]) + (0xFFFFFFFFL & (long)arrn2[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >>> 32) + ((0xFFFFFFFFL & (long)arrn[2]) + (0xFFFFFFFFL & (long)arrn2[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >>> 32) + ((0xFFFFFFFFL & (long)arrn[3]) + (0xFFFFFFFFL & (long)arrn2[3]));
        arrn3[3] = (int)l5;
        long l6 = (l5 >>> 32) + ((0xFFFFFFFFL & (long)arrn[4]) + (0xFFFFFFFFL & (long)arrn2[4]));
        arrn3[4] = (int)l6;
        return (int)(l6 >>> 32);
    }

    public static int add2(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) + (0xFFFFFFFFL & (long)arrn2[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >>> 32) + ((0xFFFFFFFFL & (long)arrn[1]) + (0xFFFFFFFFL & (long)arrn2[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >>> 32) + ((0xFFFFFFFFL & (long)arrn[2]) + (0xFFFFFFFFL & (long)arrn2[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >>> 32) + ((0xFFFFFFFFL & (long)arrn[3]) + (0xFFFFFFFFL & (long)arrn2[3]));
        arrn3[3] = (int)l5;
        long l6 = (l5 >>> 32) + ((0xFFFFFFFFL & (long)arrn[4]) + (0xFFFFFFFFL & (long)arrn2[4]));
        arrn3[4] = (int)l6;
        long l7 = (l6 >>> 32) + ((0xFFFFFFFFL & (long)arrn[5]) + (0xFFFFFFFFL & (long)arrn2[5]));
        arrn3[5] = (int)l7;
        return (int)(l7 >>> 32);
    }

    public static int add3(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) + (0xFFFFFFFFL & (long)arrn2[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >>> 32) + ((0xFFFFFFFFL & (long)arrn[1]) + (0xFFFFFFFFL & (long)arrn2[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >>> 32) + ((0xFFFFFFFFL & (long)arrn[2]) + (0xFFFFFFFFL & (long)arrn2[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >>> 32) + ((0xFFFFFFFFL & (long)arrn[3]) + (0xFFFFFFFFL & (long)arrn2[3]));
        arrn3[3] = (int)l5;
        long l6 = (l5 >>> 32) + ((0xFFFFFFFFL & (long)arrn[4]) + (0xFFFFFFFFL & (long)arrn2[4]));
        arrn3[4] = (int)l6;
        long l7 = (l6 >>> 32) + ((0xFFFFFFFFL & (long)arrn[5]) + (0xFFFFFFFFL & (long)arrn2[5]));
        arrn3[5] = (int)l7;
        long l8 = (l7 >>> 32) + ((0xFFFFFFFFL & (long)arrn[6]) + (0xFFFFFFFFL & (long)arrn2[6]));
        arrn3[6] = (int)l8;
        return (int)(l8 >>> 32);
    }

    public static int add4(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) + (0xFFFFFFFFL & (long)arrn2[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >>> 32) + ((0xFFFFFFFFL & (long)arrn[1]) + (0xFFFFFFFFL & (long)arrn2[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >>> 32) + ((0xFFFFFFFFL & (long)arrn[2]) + (0xFFFFFFFFL & (long)arrn2[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >>> 32) + ((0xFFFFFFFFL & (long)arrn[3]) + (0xFFFFFFFFL & (long)arrn2[3]));
        arrn3[3] = (int)l5;
        long l6 = (l5 >>> 32) + ((0xFFFFFFFFL & (long)arrn[4]) + (0xFFFFFFFFL & (long)arrn2[4]));
        arrn3[4] = (int)l6;
        long l7 = (l6 >>> 32) + ((0xFFFFFFFFL & (long)arrn[5]) + (0xFFFFFFFFL & (long)arrn2[5]));
        arrn3[5] = (int)l7;
        long l8 = (l7 >>> 32) + ((0xFFFFFFFFL & (long)arrn[6]) + (0xFFFFFFFFL & (long)arrn2[6]));
        arrn3[6] = (int)l8;
        long l9 = (l8 >>> 32) + ((0xFFFFFFFFL & (long)arrn[7]) + (0xFFFFFFFFL & (long)arrn2[7]));
        arrn3[7] = (int)l9;
        return (int)(l9 >>> 32);
    }

    public static int addBothTo(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) + (0xFFFFFFFFL & (long)arrn2[0]) + (0xFFFFFFFFL & (long)arrn3[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >>> 32) + ((0xFFFFFFFFL & (long)arrn[1]) + (0xFFFFFFFFL & (long)arrn2[1]) + (0xFFFFFFFFL & (long)arrn3[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >>> 32) + ((0xFFFFFFFFL & (long)arrn[2]) + (0xFFFFFFFFL & (long)arrn2[2]) + (0xFFFFFFFFL & (long)arrn3[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >>> 32) + ((0xFFFFFFFFL & (long)arrn[3]) + (0xFFFFFFFFL & (long)arrn2[3]) + (0xFFFFFFFFL & (long)arrn3[3]));
        arrn3[3] = (int)l5;
        return (int)(l5 >>> 32);
    }

    public static int addBothTo1(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) + (0xFFFFFFFFL & (long)arrn2[0]) + (0xFFFFFFFFL & (long)arrn3[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >>> 32) + ((0xFFFFFFFFL & (long)arrn[1]) + (0xFFFFFFFFL & (long)arrn2[1]) + (0xFFFFFFFFL & (long)arrn3[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >>> 32) + ((0xFFFFFFFFL & (long)arrn[2]) + (0xFFFFFFFFL & (long)arrn2[2]) + (0xFFFFFFFFL & (long)arrn3[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >>> 32) + ((0xFFFFFFFFL & (long)arrn[3]) + (0xFFFFFFFFL & (long)arrn2[3]) + (0xFFFFFFFFL & (long)arrn3[3]));
        arrn3[3] = (int)l5;
        long l6 = (l5 >>> 32) + ((0xFFFFFFFFL & (long)arrn[4]) + (0xFFFFFFFFL & (long)arrn2[4]) + (0xFFFFFFFFL & (long)arrn3[4]));
        arrn3[4] = (int)l6;
        return (int)(l6 >>> 32);
    }

    public static int addBothTo2(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) + (0xFFFFFFFFL & (long)arrn2[0]) + (0xFFFFFFFFL & (long)arrn3[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >>> 32) + ((0xFFFFFFFFL & (long)arrn[1]) + (0xFFFFFFFFL & (long)arrn2[1]) + (0xFFFFFFFFL & (long)arrn3[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >>> 32) + ((0xFFFFFFFFL & (long)arrn[2]) + (0xFFFFFFFFL & (long)arrn2[2]) + (0xFFFFFFFFL & (long)arrn3[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >>> 32) + ((0xFFFFFFFFL & (long)arrn[3]) + (0xFFFFFFFFL & (long)arrn2[3]) + (0xFFFFFFFFL & (long)arrn3[3]));
        arrn3[3] = (int)l5;
        long l6 = (l5 >>> 32) + ((0xFFFFFFFFL & (long)arrn[4]) + (0xFFFFFFFFL & (long)arrn2[4]) + (0xFFFFFFFFL & (long)arrn3[4]));
        arrn3[4] = (int)l6;
        long l7 = (l6 >>> 32) + ((0xFFFFFFFFL & (long)arrn[5]) + (0xFFFFFFFFL & (long)arrn2[5]) + (0xFFFFFFFFL & (long)arrn3[5]));
        arrn3[5] = (int)l7;
        return (int)(l7 >>> 32);
    }

    public static int addBothTo3(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) + (0xFFFFFFFFL & (long)arrn2[0]) + (0xFFFFFFFFL & (long)arrn3[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >>> 32) + ((0xFFFFFFFFL & (long)arrn[1]) + (0xFFFFFFFFL & (long)arrn2[1]) + (0xFFFFFFFFL & (long)arrn3[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >>> 32) + ((0xFFFFFFFFL & (long)arrn[2]) + (0xFFFFFFFFL & (long)arrn2[2]) + (0xFFFFFFFFL & (long)arrn3[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >>> 32) + ((0xFFFFFFFFL & (long)arrn[3]) + (0xFFFFFFFFL & (long)arrn2[3]) + (0xFFFFFFFFL & (long)arrn3[3]));
        arrn3[3] = (int)l5;
        long l6 = (l5 >>> 32) + ((0xFFFFFFFFL & (long)arrn[4]) + (0xFFFFFFFFL & (long)arrn2[4]) + (0xFFFFFFFFL & (long)arrn3[4]));
        arrn3[4] = (int)l6;
        long l7 = (l6 >>> 32) + ((0xFFFFFFFFL & (long)arrn[5]) + (0xFFFFFFFFL & (long)arrn2[5]) + (0xFFFFFFFFL & (long)arrn3[5]));
        arrn3[5] = (int)l7;
        long l8 = (l7 >>> 32) + ((0xFFFFFFFFL & (long)arrn[6]) + (0xFFFFFFFFL & (long)arrn2[6]) + (0xFFFFFFFFL & (long)arrn3[6]));
        arrn3[6] = (int)l8;
        return (int)(l8 >>> 32);
    }

    public static int addBothTo4(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) + (0xFFFFFFFFL & (long)arrn2[0]) + (0xFFFFFFFFL & (long)arrn3[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >>> 32) + ((0xFFFFFFFFL & (long)arrn[1]) + (0xFFFFFFFFL & (long)arrn2[1]) + (0xFFFFFFFFL & (long)arrn3[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >>> 32) + ((0xFFFFFFFFL & (long)arrn[2]) + (0xFFFFFFFFL & (long)arrn2[2]) + (0xFFFFFFFFL & (long)arrn3[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >>> 32) + ((0xFFFFFFFFL & (long)arrn[3]) + (0xFFFFFFFFL & (long)arrn2[3]) + (0xFFFFFFFFL & (long)arrn3[3]));
        arrn3[3] = (int)l5;
        long l6 = (l5 >>> 32) + ((0xFFFFFFFFL & (long)arrn[4]) + (0xFFFFFFFFL & (long)arrn2[4]) + (0xFFFFFFFFL & (long)arrn3[4]));
        arrn3[4] = (int)l6;
        long l7 = (l6 >>> 32) + ((0xFFFFFFFFL & (long)arrn[5]) + (0xFFFFFFFFL & (long)arrn2[5]) + (0xFFFFFFFFL & (long)arrn3[5]));
        arrn3[5] = (int)l7;
        long l8 = (l7 >>> 32) + ((0xFFFFFFFFL & (long)arrn[6]) + (0xFFFFFFFFL & (long)arrn2[6]) + (0xFFFFFFFFL & (long)arrn3[6]));
        arrn3[6] = (int)l8;
        long l9 = (l8 >>> 32) + ((0xFFFFFFFFL & (long)arrn[7]) + (0xFFFFFFFFL & (long)arrn2[7]) + (0xFFFFFFFFL & (long)arrn3[7]));
        arrn3[7] = (int)l9;
        return (int)(l9 >>> 32);
    }

    public static void addExt(long[] arrl, long[] arrl2, long[] arrl3) {
        arrl3[0] = arrl[0] ^ arrl2[0];
        arrl3[1] = arrl[1] ^ arrl2[1];
        arrl3[2] = arrl[2] ^ arrl2[2];
        arrl3[3] = arrl[3] ^ arrl2[3];
        arrl3[4] = arrl[4] ^ arrl2[4];
        arrl3[5] = arrl[5] ^ arrl2[5];
        arrl3[6] = arrl[6] ^ arrl2[6];
        arrl3[7] = arrl[7] ^ arrl2[7];
    }

    public static int addTo(int[] arrn, int n2, int[] arrn2, int n3, int n4) {
        long l2 = 0xFFFFFFFFL & (long)n4;
        long l3 = 0xFFFFFFFFL & (long)arrn[n2 + 0];
        int n5 = n3 + 0;
        long l4 = l2 + (l3 + (0xFFFFFFFFL & (long)arrn2[n5]));
        arrn2[n5] = (int)l4;
        long l5 = l4 >>> 32;
        long l6 = 0xFFFFFFFFL & (long)arrn[n2 + 1];
        int n6 = n3 + 1;
        long l7 = l5 + (l6 + (0xFFFFFFFFL & (long)arrn2[n6]));
        arrn2[n6] = (int)l7;
        long l8 = l7 >>> 32;
        long l9 = 0xFFFFFFFFL & (long)arrn[n2 + 2];
        int n7 = n3 + 2;
        long l10 = l8 + (l9 + (0xFFFFFFFFL & (long)arrn2[n7]));
        arrn2[n7] = (int)l10;
        long l11 = l10 >>> 32;
        long l12 = 0xFFFFFFFFL & (long)arrn[n2 + 3];
        int n8 = n3 + 3;
        long l13 = l11 + (l12 + (0xFFFFFFFFL & (long)arrn2[n8]));
        arrn2[n8] = (int)l13;
        long l14 = l13 >>> 32;
        long l15 = 0xFFFFFFFFL & (long)arrn[n2 + 4];
        int n9 = n3 + 4;
        long l16 = l14 + (l15 + (0xFFFFFFFFL & (long)arrn2[n9]));
        arrn2[n9] = (int)l16;
        long l17 = l16 >>> 32;
        long l18 = 0xFFFFFFFFL & (long)arrn[n2 + 5];
        int n10 = n3 + 5;
        long l19 = l17 + (l18 + (0xFFFFFFFFL & (long)arrn2[n10]));
        arrn2[n10] = (int)l19;
        return (int)(l19 >>> 32);
    }

    public static int addTo1(int[] arrn, int n2, int[] arrn2, int n3, int n4) {
        long l2 = 0xFFFFFFFFL & (long)n4;
        long l3 = 0xFFFFFFFFL & (long)arrn[n2 + 0];
        int n5 = n3 + 0;
        long l4 = l2 + (l3 + (0xFFFFFFFFL & (long)arrn2[n5]));
        arrn2[n5] = (int)l4;
        long l5 = l4 >>> 32;
        long l6 = 0xFFFFFFFFL & (long)arrn[n2 + 1];
        int n6 = n3 + 1;
        long l7 = l5 + (l6 + (0xFFFFFFFFL & (long)arrn2[n6]));
        arrn2[n6] = (int)l7;
        long l8 = l7 >>> 32;
        long l9 = 0xFFFFFFFFL & (long)arrn[n2 + 2];
        int n7 = n3 + 2;
        long l10 = l8 + (l9 + (0xFFFFFFFFL & (long)arrn2[n7]));
        arrn2[n7] = (int)l10;
        long l11 = l10 >>> 32;
        long l12 = 0xFFFFFFFFL & (long)arrn[n2 + 3];
        int n8 = n3 + 3;
        long l13 = l11 + (l12 + (0xFFFFFFFFL & (long)arrn2[n8]));
        arrn2[n8] = (int)l13;
        long l14 = l13 >>> 32;
        long l15 = 0xFFFFFFFFL & (long)arrn[n2 + 4];
        int n9 = n3 + 4;
        long l16 = l14 + (l15 + (0xFFFFFFFFL & (long)arrn2[n9]));
        arrn2[n9] = (int)l16;
        long l17 = l16 >>> 32;
        long l18 = 0xFFFFFFFFL & (long)arrn[n2 + 5];
        int n10 = n3 + 5;
        long l19 = l17 + (l18 + (0xFFFFFFFFL & (long)arrn2[n10]));
        arrn2[n10] = (int)l19;
        long l20 = l19 >>> 32;
        long l21 = 0xFFFFFFFFL & (long)arrn[n2 + 6];
        int n11 = n3 + 6;
        long l22 = l20 + (l21 + (0xFFFFFFFFL & (long)arrn2[n11]));
        arrn2[n11] = (int)l22;
        long l23 = l22 >>> 32;
        long l24 = 0xFFFFFFFFL & (long)arrn[n2 + 7];
        int n12 = n3 + 7;
        long l25 = l23 + (l24 + (0xFFFFFFFFL & (long)arrn2[n12]));
        arrn2[n12] = (int)l25;
        return (int)(l25 >>> 32);
    }

    public static int addToEachOther(int[] arrn, int n2, int[] arrn2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10 = n2 + 0;
        long l2 = 0xFFFFFFFFL & (long)arrn[n10];
        int n11 = n3 + 0;
        long l3 = 0L + (l2 + (0xFFFFFFFFL & (long)arrn2[n11]));
        arrn[n10] = n6 = (int)l3;
        arrn2[n11] = n6;
        long l4 = l3 >>> 32;
        int n12 = n2 + 1;
        long l5 = 0xFFFFFFFFL & (long)arrn[n12];
        int n13 = n3 + 1;
        long l6 = l4 + (l5 + (0xFFFFFFFFL & (long)arrn2[n13]));
        arrn[n12] = n8 = (int)l6;
        arrn2[n13] = n8;
        long l7 = l6 >>> 32;
        int n14 = n2 + 2;
        long l8 = 0xFFFFFFFFL & (long)arrn[n14];
        int n15 = n3 + 2;
        long l9 = l7 + (l8 + (0xFFFFFFFFL & (long)arrn2[n15]));
        arrn[n14] = n5 = (int)l9;
        arrn2[n15] = n5;
        long l10 = l9 >>> 32;
        int n16 = n2 + 3;
        long l11 = 0xFFFFFFFFL & (long)arrn[n16];
        int n17 = n3 + 3;
        long l12 = l10 + (l11 + (0xFFFFFFFFL & (long)arrn2[n17]));
        arrn[n16] = n9 = (int)l12;
        arrn2[n17] = n9;
        long l13 = l12 >>> 32;
        int n18 = n2 + 4;
        long l14 = 0xFFFFFFFFL & (long)arrn[n18];
        int n19 = n3 + 4;
        long l15 = l13 + (l14 + (0xFFFFFFFFL & (long)arrn2[n19]));
        arrn[n18] = n7 = (int)l15;
        arrn2[n19] = n7;
        long l16 = l15 >>> 32;
        int n20 = n2 + 5;
        long l17 = 0xFFFFFFFFL & (long)arrn[n20];
        int n21 = n3 + 5;
        long l18 = l16 + (l17 + (0xFFFFFFFFL & (long)arrn2[n21]));
        arrn[n20] = n4 = (int)l18;
        arrn2[n21] = n4;
        return (int)(l18 >>> 32);
    }

    public static int addToEachOther1(int[] arrn, int n2, int[] arrn2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        int n12 = n2 + 0;
        long l2 = 0xFFFFFFFFL & (long)arrn[n12];
        int n13 = n3 + 0;
        long l3 = 0L + (l2 + (0xFFFFFFFFL & (long)arrn2[n13]));
        arrn[n12] = n8 = (int)l3;
        arrn2[n13] = n8;
        long l4 = l3 >>> 32;
        int n14 = n2 + 1;
        long l5 = 0xFFFFFFFFL & (long)arrn[n14];
        int n15 = n3 + 1;
        long l6 = l4 + (l5 + (0xFFFFFFFFL & (long)arrn2[n15]));
        arrn[n14] = n10 = (int)l6;
        arrn2[n15] = n10;
        long l7 = l6 >>> 32;
        int n16 = n2 + 2;
        long l8 = 0xFFFFFFFFL & (long)arrn[n16];
        int n17 = n3 + 2;
        long l9 = l7 + (l8 + (0xFFFFFFFFL & (long)arrn2[n17]));
        arrn[n16] = n5 = (int)l9;
        arrn2[n17] = n5;
        long l10 = l9 >>> 32;
        int n18 = n2 + 3;
        long l11 = 0xFFFFFFFFL & (long)arrn[n18];
        int n19 = n3 + 3;
        long l12 = l10 + (l11 + (0xFFFFFFFFL & (long)arrn2[n19]));
        arrn[n18] = n11 = (int)l12;
        arrn2[n19] = n11;
        long l13 = l12 >>> 32;
        int n20 = n2 + 4;
        long l14 = 0xFFFFFFFFL & (long)arrn[n20];
        int n21 = n3 + 4;
        long l15 = l13 + (l14 + (0xFFFFFFFFL & (long)arrn2[n21]));
        arrn[n20] = n9 = (int)l15;
        arrn2[n21] = n9;
        long l16 = l15 >>> 32;
        int n22 = n2 + 5;
        long l17 = 0xFFFFFFFFL & (long)arrn[n22];
        int n23 = n3 + 5;
        long l18 = l16 + (l17 + (0xFFFFFFFFL & (long)arrn2[n23]));
        arrn[n22] = n4 = (int)l18;
        arrn2[n23] = n4;
        long l19 = l18 >>> 32;
        int n24 = n2 + 6;
        long l20 = 0xFFFFFFFFL & (long)arrn[n24];
        int n25 = n3 + 6;
        long l21 = l19 + (l20 + (0xFFFFFFFFL & (long)arrn2[n25]));
        arrn[n24] = n6 = (int)l21;
        arrn2[n25] = n6;
        long l22 = l21 >>> 32;
        int n26 = n2 + 7;
        long l23 = 0xFFFFFFFFL & (long)arrn[n26];
        int n27 = n3 + 7;
        long l24 = l22 + (l23 + (0xFFFFFFFFL & (long)arrn2[n27]));
        arrn[n26] = n7 = (int)l24;
        arrn2[n27] = n7;
        return (int)(l24 >>> 32);
    }

    public static int bitPermuteStep(int n2, int n3, int n4) {
        int n5 = n3 & (n2 ^ n2 >>> n4);
        return n2 ^ (n5 ^ n5 << n4);
    }

    public static long bitPermuteStep(long l2, long l3, int n2) {
        long l4 = l3 & (l2 ^ l2 >>> n2);
        return l2 ^ (l4 ^ l4 << n2);
    }

    public static void checkedModOddInverse(int[] arrn, int[] arrn2, int[] arrn3) {
        if (SecT239Field.modOddInverse(arrn, arrn2, arrn3) != 0) {
            return;
        }
        throw new ArithmeticException("Inverse does not exist.");
    }

    public static void copy(int[] arrn, int n2, int[] arrn2, int n3) {
        arrn2[n3 + 0] = arrn[n2 + 0];
        arrn2[n3 + 1] = arrn[n2 + 1];
        arrn2[n3 + 2] = arrn[n2 + 2];
        arrn2[n3 + 3] = arrn[n2 + 3];
    }

    public static void copy(int[] arrn, int[] arrn2) {
        arrn2[0] = arrn[0];
        arrn2[1] = arrn[1];
        arrn2[2] = arrn[2];
        arrn2[3] = arrn[3];
        arrn2[4] = arrn[4];
        arrn2[5] = arrn[5];
        arrn2[6] = arrn[6];
    }

    public static void copy1(int[] arrn, int n2, int[] arrn2, int n3) {
        arrn2[n3 + 0] = arrn[n2 + 0];
        arrn2[n3 + 1] = arrn[n2 + 1];
        arrn2[n3 + 2] = arrn[n2 + 2];
        arrn2[n3 + 3] = arrn[n2 + 3];
        arrn2[n3 + 4] = arrn[n2 + 4];
    }

    public static void copy2(int[] arrn, int n2, int[] arrn2, int n3) {
        arrn2[n3 + 0] = arrn[n2 + 0];
        arrn2[n3 + 1] = arrn[n2 + 1];
        arrn2[n3 + 2] = arrn[n2 + 2];
        arrn2[n3 + 3] = arrn[n2 + 3];
        arrn2[n3 + 4] = arrn[n2 + 4];
        arrn2[n3 + 5] = arrn[n2 + 5];
    }

    public static void copy3(int[] arrn, int n2, int[] arrn2, int n3) {
        arrn2[n3 + 0] = arrn[n2 + 0];
        arrn2[n3 + 1] = arrn[n2 + 1];
        arrn2[n3 + 2] = arrn[n2 + 2];
        arrn2[n3 + 3] = arrn[n2 + 3];
        arrn2[n3 + 4] = arrn[n2 + 4];
        arrn2[n3 + 5] = arrn[n2 + 5];
        arrn2[n3 + 6] = arrn[n2 + 6];
    }

    public static void copy4(int[] arrn, int n2, int[] arrn2, int n3) {
        arrn2[n3 + 0] = arrn[n2 + 0];
        arrn2[n3 + 1] = arrn[n2 + 1];
        arrn2[n3 + 2] = arrn[n2 + 2];
        arrn2[n3 + 3] = arrn[n2 + 3];
        arrn2[n3 + 4] = arrn[n2 + 4];
        arrn2[n3 + 5] = arrn[n2 + 5];
        arrn2[n3 + 6] = arrn[n2 + 6];
        arrn2[n3 + 7] = arrn[n2 + 7];
    }

    public static void copy64(long[] arrl, int n2, long[] arrl2, int n3) {
        arrl2[n3 + 0] = arrl[n2 + 0];
        arrl2[n3 + 1] = arrl[n2 + 1];
    }

    public static void copy641(long[] arrl, int n2, long[] arrl2, int n3) {
        arrl2[n3 + 0] = arrl[n2 + 0];
        arrl2[n3 + 1] = arrl[n2 + 1];
        arrl2[n3 + 2] = arrl[n2 + 2];
    }

    public static void copy642(long[] arrl, int n2, long[] arrl2, int n3) {
        arrl2[n3 + 0] = arrl[n2 + 0];
        arrl2[n3 + 1] = arrl[n2 + 1];
        arrl2[n3 + 2] = arrl[n2 + 2];
        arrl2[n3 + 3] = arrl[n2 + 3];
    }

    public static void copy642(long[] arrl, long[] arrl2) {
        arrl2[0] = arrl[0];
        arrl2[1] = arrl[1];
        arrl2[2] = arrl[2];
        arrl2[3] = arrl[3];
    }

    public static void copy643(long[] arrl, int n2, long[] arrl2, int n3) {
        arrl2[n3 + 0] = arrl[n2 + 0];
        arrl2[n3 + 1] = arrl[n2 + 1];
        arrl2[n3 + 2] = arrl[n2 + 2];
        arrl2[n3 + 3] = arrl[n2 + 3];
        arrl2[n3 + 4] = arrl[n2 + 4];
    }

    public static void copy644(long[] arrl, int n2, long[] arrl2, int n3) {
        arrl2[n3 + 0] = arrl[n2 + 0];
        arrl2[n3 + 1] = arrl[n2 + 1];
        arrl2[n3 + 2] = arrl[n2 + 2];
        arrl2[n3 + 3] = arrl[n2 + 3];
        arrl2[n3 + 4] = arrl[n2 + 4];
        arrl2[n3 + 5] = arrl[n2 + 5];
        arrl2[n3 + 6] = arrl[n2 + 6];
    }

    public static boolean diff(int[] arrn, int n2, int[] arrn2, int n3, int[] arrn3, int n4) {
        boolean bl;
        int n5 = 5;
        do {
            bl = true;
            if (n5 < 0) break;
            int n6 = Integer.MIN_VALUE ^ arrn[n2 + n5];
            int n7 = Integer.MIN_VALUE ^ arrn2[n3 + n5];
            if (n6 < n7) {
                bl = false;
                break;
            }
            if (n6 > n7) break;
            --n5;
        } while (true);
        if (bl) {
            SecT239Field.sub(arrn, n2, arrn2, n3, arrn3, n4);
            return bl;
        }
        SecT239Field.sub(arrn2, n3, arrn, n2, arrn3, n4);
        return bl;
    }

    public static boolean diff1(int[] arrn, int n2, int[] arrn2, int n3, int[] arrn3, int n4) {
        boolean bl;
        int n5 = 7;
        do {
            bl = true;
            if (n5 < 0) break;
            int n6 = Integer.MIN_VALUE ^ arrn[n2 + n5];
            int n7 = Integer.MIN_VALUE ^ arrn2[n3 + n5];
            if (n6 < n7) {
                bl = false;
                break;
            }
            if (n6 > n7) break;
            --n5;
        } while (true);
        if (bl) {
            SecT239Field.sub1(arrn, n2, arrn2, n3, arrn3, n4);
            return bl;
        }
        SecT239Field.sub1(arrn2, n3, arrn, n2, arrn3, n4);
        return bl;
    }

    public static void encode30(int n2, int[] arrn, int n3, int[] arrn2, int n4) {
        int n5 = 0;
        long l2 = 0L;
        while (n2 > 0) {
            if (n5 < Math.min((int)30, (int)n2)) {
                int n6 = n3 + 1;
                l2 |= (0xFFFFFFFFL & (long)arrn[n3]) << n5;
                n5 += 32;
                n3 = n6;
            }
            int n7 = n4 + 1;
            arrn2[n4] = 1073741823 & (int)l2;
            l2 >>>= 30;
            n5 -= 30;
            n2 -= 30;
            n4 = n7;
        }
    }

    public static boolean eq(int[] arrn, int[] arrn2) {
        for (int i2 = 3; i2 >= 0; --i2) {
            if (arrn[i2] == arrn2[i2]) continue;
            return false;
        }
        return true;
    }

    public static boolean eq1(int[] arrn, int[] arrn2) {
        for (int i2 = 4; i2 >= 0; --i2) {
            if (arrn[i2] == arrn2[i2]) continue;
            return false;
        }
        return true;
    }

    public static boolean eq2(int[] arrn, int[] arrn2) {
        for (int i2 = 5; i2 >= 0; --i2) {
            if (arrn[i2] == arrn2[i2]) continue;
            return false;
        }
        return true;
    }

    public static boolean eq3(int[] arrn, int[] arrn2) {
        for (int i2 = 6; i2 >= 0; --i2) {
            if (arrn[i2] == arrn2[i2]) continue;
            return false;
        }
        return true;
    }

    public static boolean eq4(int[] arrn, int[] arrn2) {
        for (int i2 = 7; i2 >= 0; --i2) {
            if (arrn[i2] == arrn2[i2]) continue;
            return false;
        }
        return true;
    }

    public static boolean eq641(long[] arrl, long[] arrl2) {
        for (int i2 = 2; i2 >= 0; --i2) {
            if (arrl[i2] == arrl2[i2]) continue;
            return false;
        }
        return true;
    }

    public static boolean eq642(long[] arrl, long[] arrl2) {
        for (int i2 = 3; i2 >= 0; --i2) {
            if (arrl[i2] == arrl2[i2]) continue;
            return false;
        }
        return true;
    }

    public static int[] fromBigInteger1(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0 && bigInteger.bitLength() <= 160) {
            int[] arrn = new int[5];
            for (int i2 = 0; i2 < 5; ++i2) {
                arrn[i2] = bigInteger.intValue();
                bigInteger = bigInteger.shiftRight(32);
            }
            return arrn;
        }
        throw new IllegalArgumentException();
    }

    public static int[] fromBigInteger2(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0 && bigInteger.bitLength() <= 192) {
            int[] arrn = new int[6];
            for (int i2 = 0; i2 < 6; ++i2) {
                arrn[i2] = bigInteger.intValue();
                bigInteger = bigInteger.shiftRight(32);
            }
            return arrn;
        }
        throw new IllegalArgumentException();
    }

    public static int[] fromBigInteger3(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0 && bigInteger.bitLength() <= 224) {
            int[] arrn = new int[7];
            for (int i2 = 0; i2 < 7; ++i2) {
                arrn[i2] = bigInteger.intValue();
                bigInteger = bigInteger.shiftRight(32);
            }
            return arrn;
        }
        throw new IllegalArgumentException();
    }

    public static int[] fromBigInteger4(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0 && bigInteger.bitLength() <= 256) {
            int[] arrn = new int[8];
            for (int i2 = 0; i2 < 8; ++i2) {
                arrn[i2] = bigInteger.intValue();
                bigInteger = bigInteger.shiftRight(32);
            }
            return arrn;
        }
        throw new IllegalArgumentException();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int getBit1(int[] arrn, int n2) {
        int n3;
        if (n2 == 0) {
            n3 = arrn[0];
            do {
                return n3 & 1;
                break;
            } while (true);
        }
        int n4 = n2 >> 5;
        if (n4 < 0) return 0;
        if (n4 >= 5) {
            return 0;
        }
        int n5 = n2 & 31;
        n3 = arrn[n4] >>> n5;
        return n3 & 1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int getBit2(int[] arrn, int n2) {
        int n3;
        if (n2 == 0) {
            n3 = arrn[0];
            do {
                return n3 & 1;
                break;
            } while (true);
        }
        int n4 = n2 >> 5;
        if (n4 < 0) return 0;
        if (n4 >= 6) {
            return 0;
        }
        int n5 = n2 & 31;
        n3 = arrn[n4] >>> n5;
        return n3 & 1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int getBit3(int[] arrn, int n2) {
        int n3;
        if (n2 == 0) {
            n3 = arrn[0];
            do {
                return n3 & 1;
                break;
            } while (true);
        }
        int n4 = n2 >> 5;
        if (n4 < 0) return 0;
        if (n4 >= 7) {
            return 0;
        }
        int n5 = n2 & 31;
        n3 = arrn[n4] >>> n5;
        return n3 & 1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int getBit4(int[] arrn, int n2) {
        int n3;
        if (n2 == 0) {
            n3 = arrn[0];
            do {
                return n3 & 1;
                break;
            } while (true);
        }
        if ((n2 & 255) != n2) {
            return 0;
        }
        int n4 = n2 >>> 5;
        int n5 = n2 & 31;
        n3 = arrn[n4] >>> n5;
        return n3 & 1;
    }

    public static boolean gte(int[] arrn, int[] arrn2) {
        for (int i2 = 3; i2 >= 0; --i2) {
            int n2 = Integer.MIN_VALUE ^ arrn[i2];
            int n3 = Integer.MIN_VALUE ^ arrn2[i2];
            if (n2 < n3) {
                return false;
            }
            if (n2 <= n3) continue;
            return true;
        }
        return true;
    }

    public static boolean gte1(int[] arrn, int[] arrn2) {
        for (int i2 = 4; i2 >= 0; --i2) {
            int n2 = Integer.MIN_VALUE ^ arrn[i2];
            int n3 = Integer.MIN_VALUE ^ arrn2[i2];
            if (n2 < n3) {
                return false;
            }
            if (n2 <= n3) continue;
            return true;
        }
        return true;
    }

    public static boolean gte2(int[] arrn, int[] arrn2) {
        for (int i2 = 5; i2 >= 0; --i2) {
            int n2 = Integer.MIN_VALUE ^ arrn[i2];
            int n3 = Integer.MIN_VALUE ^ arrn2[i2];
            if (n2 < n3) {
                return false;
            }
            if (n2 <= n3) continue;
            return true;
        }
        return true;
    }

    public static boolean gte3(int[] arrn, int[] arrn2) {
        for (int i2 = 6; i2 >= 0; --i2) {
            int n2 = Integer.MIN_VALUE ^ arrn[i2];
            int n3 = Integer.MIN_VALUE ^ arrn2[i2];
            if (n2 < n3) {
                return false;
            }
            if (n2 <= n3) continue;
            return true;
        }
        return true;
    }

    public static boolean gte4(int[] arrn, int[] arrn2) {
        for (int i2 = 7; i2 >= 0; --i2) {
            int n2 = Integer.MIN_VALUE ^ arrn[i2];
            int n3 = Integer.MIN_VALUE ^ arrn2[i2];
            if (n2 < n3) {
                return false;
            }
            if (n2 <= n3) continue;
            return true;
        }
        return true;
    }

    public static void implExpand(long[] arrl, long[] arrl2) {
        long l2 = arrl[0];
        long l3 = arrl[1];
        long l4 = arrl[2];
        long l5 = arrl[3];
        arrl2[0] = l2 & 0xFFFFFFFFFFFFFFFL;
        arrl2[1] = 0xFFFFFFFFFFFFFFFL & (l2 >>> 60 ^ l3 << 4);
        arrl2[2] = 0xFFFFFFFFFFFFFFFL & (l3 >>> 56 ^ l4 << 8);
        arrl2[3] = l4 >>> 52 ^ l5 << 12;
    }

    public static void implExpand1(long[] arrl, long[] arrl2) {
        long l2 = arrl[0];
        long l3 = arrl[1];
        long l4 = arrl[2];
        long l5 = arrl[3];
        long l6 = arrl[4];
        long l7 = arrl[5];
        long l8 = arrl[6];
        arrl2[0] = l2 & 0x7FFFFFFFFFFFFFFL;
        arrl2[1] = 0x7FFFFFFFFFFFFFFL & (l2 >>> 59 ^ l3 << 5);
        arrl2[2] = 0x7FFFFFFFFFFFFFFL & (l3 >>> 54 ^ l4 << 10);
        arrl2[3] = 0x7FFFFFFFFFFFFFFL & (l4 >>> 49 ^ l5 << 15);
        arrl2[4] = 0x7FFFFFFFFFFFFFFL & (l5 >>> 44 ^ l6 << 20);
        arrl2[5] = 0x7FFFFFFFFFFFFFFL & (l6 >>> 39 ^ l7 << 25);
        arrl2[6] = l7 >>> 34 ^ l8 << 30;
    }

    public static void implMultiply(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[4];
        long[] arrl5 = new long[4];
        SecT239Field.implExpand(arrl, arrl4);
        SecT239Field.implExpand(arrl2, arrl5);
        long[] arrl6 = new long[8];
        SecT239Field.implMulwAcc(arrl6, arrl4[0], arrl5[0], arrl3, 0);
        SecT239Field.implMulwAcc(arrl6, arrl4[1], arrl5[1], arrl3, 1);
        SecT239Field.implMulwAcc(arrl6, arrl4[2], arrl5[2], arrl3, 2);
        SecT239Field.implMulwAcc(arrl6, arrl4[3], arrl5[3], arrl3, 3);
        int n2 = 5;
        while (n2 > 0) {
            long l2 = arrl3[n2];
            int n3 = n2 - 1;
            arrl3[n2] = l2 ^ arrl3[n3];
            n2 = n3;
        }
        SecT239Field.implMulwAcc(arrl6, arrl4[0] ^ arrl4[1], arrl5[0] ^ arrl5[1], arrl3, 1);
        SecT239Field.implMulwAcc(arrl6, arrl4[2] ^ arrl4[3], arrl5[2] ^ arrl5[3], arrl3, 3);
        for (int i2 = 7; i2 > 1; --i2) {
            arrl3[i2] = arrl3[i2] ^ arrl3[i2 - 2];
        }
        long l3 = arrl4[0] ^ arrl4[2];
        long l4 = arrl4[1] ^ arrl4[3];
        long l5 = arrl5[0] ^ arrl5[2];
        long l6 = arrl5[1] ^ arrl5[3];
        SecT239Field.implMulwAcc(arrl6, l3 ^ l4, l5 ^ l6, arrl3, 3);
        long[] arrl7 = new long[3];
        SecT239Field.implMulwAcc(arrl6, l3, l5, arrl7, 0);
        SecT239Field.implMulwAcc(arrl6, l4, l6, arrl7, 1);
        long l7 = arrl7[0];
        long l8 = arrl7[1];
        long l9 = arrl7[2];
        arrl3[2] = l7 ^ arrl3[2];
        arrl3[3] = arrl3[3] ^ (l7 ^ l8);
        arrl3[4] = arrl3[4] ^ (l8 ^ l9);
        arrl3[5] = l9 ^ arrl3[5];
        long l10 = arrl3[0];
        long l11 = arrl3[1];
        long l12 = arrl3[2];
        long l13 = arrl3[3];
        long l14 = arrl3[4];
        long l15 = arrl3[5];
        long l16 = arrl3[6];
        long l17 = arrl3[7];
        arrl3[0] = l10 ^ l11 << 60;
        arrl3[1] = l11 >>> 4 ^ l12 << 56;
        arrl3[2] = l12 >>> 8 ^ l13 << 52;
        arrl3[3] = l13 >>> 12 ^ l14 << 48;
        arrl3[4] = l14 >>> 16 ^ l15 << 44;
        arrl3[5] = l15 >>> 20 ^ l16 << 40;
        arrl3[6] = l16 >>> 24 ^ l17 << 36;
        arrl3[7] = l17 >>> 28;
    }

    public static void implMultiply1(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[7];
        long[] arrl5 = new long[7];
        SecT239Field.implExpand1(arrl, arrl4);
        SecT239Field.implExpand1(arrl2, arrl5);
        long[] arrl6 = new long[8];
        for (int i2 = 0; i2 < 7; ++i2) {
            SecT239Field.implMulwAcc1(arrl6, arrl4[i2], arrl5[i2], arrl3, i2 << 1);
        }
        long l2 = arrl3[0];
        long l3 = arrl3[1];
        long l4 = l2 ^ arrl3[2];
        arrl3[1] = l4 ^ l3;
        long l5 = l3 ^ arrl3[3];
        long l6 = l4 ^ arrl3[4];
        arrl3[2] = l6 ^ l5;
        long l7 = l5 ^ arrl3[5];
        long l8 = l6 ^ arrl3[6];
        arrl3[3] = l8 ^ l7;
        long l9 = l7 ^ arrl3[7];
        long l10 = l8 ^ arrl3[8];
        arrl3[4] = l10 ^ l9;
        long l11 = l9 ^ arrl3[9];
        long l12 = l10 ^ arrl3[10];
        arrl3[5] = l12 ^ l11;
        long l13 = l11 ^ arrl3[11];
        long l14 = l12 ^ arrl3[12];
        arrl3[6] = l14 ^ l13;
        long l15 = l14 ^ (l13 ^ arrl3[13]);
        arrl3[7] = l15 ^ arrl3[0];
        arrl3[8] = l15 ^ arrl3[1];
        arrl3[9] = l15 ^ arrl3[2];
        arrl3[10] = l15 ^ arrl3[3];
        arrl3[11] = l15 ^ arrl3[4];
        arrl3[12] = l15 ^ arrl3[5];
        arrl3[13] = l15 ^ arrl3[6];
        SecT239Field.implMulwAcc1(arrl6, arrl4[0] ^ arrl4[1], arrl5[0] ^ arrl5[1], arrl3, 1);
        SecT239Field.implMulwAcc1(arrl6, arrl4[0] ^ arrl4[2], arrl5[0] ^ arrl5[2], arrl3, 2);
        SecT239Field.implMulwAcc1(arrl6, arrl4[0] ^ arrl4[3], arrl5[0] ^ arrl5[3], arrl3, 3);
        SecT239Field.implMulwAcc1(arrl6, arrl4[1] ^ arrl4[2], arrl5[1] ^ arrl5[2], arrl3, 3);
        SecT239Field.implMulwAcc1(arrl6, arrl4[0] ^ arrl4[4], arrl5[0] ^ arrl5[4], arrl3, 4);
        SecT239Field.implMulwAcc1(arrl6, arrl4[1] ^ arrl4[3], arrl5[1] ^ arrl5[3], arrl3, 4);
        SecT239Field.implMulwAcc1(arrl6, arrl4[0] ^ arrl4[5], arrl5[0] ^ arrl5[5], arrl3, 5);
        SecT239Field.implMulwAcc1(arrl6, arrl4[1] ^ arrl4[4], arrl5[1] ^ arrl5[4], arrl3, 5);
        SecT239Field.implMulwAcc1(arrl6, arrl4[2] ^ arrl4[3], arrl5[2] ^ arrl5[3], arrl3, 5);
        SecT239Field.implMulwAcc1(arrl6, arrl4[0] ^ arrl4[6], arrl5[0] ^ arrl5[6], arrl3, 6);
        SecT239Field.implMulwAcc1(arrl6, arrl4[1] ^ arrl4[5], arrl5[1] ^ arrl5[5], arrl3, 6);
        SecT239Field.implMulwAcc1(arrl6, arrl4[2] ^ arrl4[4], arrl5[2] ^ arrl5[4], arrl3, 6);
        SecT239Field.implMulwAcc1(arrl6, arrl4[1] ^ arrl4[6], arrl5[1] ^ arrl5[6], arrl3, 7);
        SecT239Field.implMulwAcc1(arrl6, arrl4[2] ^ arrl4[5], arrl5[2] ^ arrl5[5], arrl3, 7);
        SecT239Field.implMulwAcc1(arrl6, arrl4[3] ^ arrl4[4], arrl5[3] ^ arrl5[4], arrl3, 7);
        SecT239Field.implMulwAcc1(arrl6, arrl4[2] ^ arrl4[6], arrl5[2] ^ arrl5[6], arrl3, 8);
        SecT239Field.implMulwAcc1(arrl6, arrl4[3] ^ arrl4[5], arrl5[3] ^ arrl5[5], arrl3, 8);
        SecT239Field.implMulwAcc1(arrl6, arrl4[3] ^ arrl4[6], arrl5[3] ^ arrl5[6], arrl3, 9);
        SecT239Field.implMulwAcc1(arrl6, arrl4[4] ^ arrl4[5], arrl5[4] ^ arrl5[5], arrl3, 9);
        SecT239Field.implMulwAcc1(arrl6, arrl4[4] ^ arrl4[6], arrl5[4] ^ arrl5[6], arrl3, 10);
        SecT239Field.implMulwAcc1(arrl6, arrl4[5] ^ arrl4[6], arrl5[5] ^ arrl5[6], arrl3, 11);
        long l16 = arrl3[0];
        long l17 = arrl3[1];
        long l18 = arrl3[2];
        long l19 = arrl3[3];
        long l20 = arrl3[4];
        long l21 = arrl3[5];
        long l22 = arrl3[6];
        long l23 = arrl3[7];
        long l24 = arrl3[8];
        long l25 = arrl3[9];
        long l26 = arrl3[10];
        long l27 = arrl3[11];
        long l28 = arrl3[12];
        long l29 = arrl3[13];
        arrl3[0] = l16 ^ l17 << 59;
        arrl3[1] = l17 >>> 5 ^ l18 << 54;
        arrl3[2] = l18 >>> 10 ^ l19 << 49;
        arrl3[3] = l19 >>> 15 ^ l20 << 44;
        arrl3[4] = l20 >>> 20 ^ l21 << 39;
        arrl3[5] = l21 >>> 25 ^ l22 << 34;
        arrl3[6] = l22 >>> 30 ^ l23 << 29;
        arrl3[7] = l23 >>> 35 ^ l24 << 24;
        arrl3[8] = l24 >>> 40 ^ l25 << 19;
        arrl3[9] = l25 >>> 45 ^ l26 << 14;
        arrl3[10] = l26 >>> 50 ^ l27 << 9;
        arrl3[11] = l27 >>> 55 ^ l28 << 4 ^ l29 << 63;
        arrl3[12] = l29 >>> 1;
    }

    public static void implMulwAcc(long[] arrl, long l2, long l3, long[] arrl2, int n2) {
        arrl[1] = l3;
        arrl[2] = arrl[1] << 1;
        arrl[3] = l3 ^ arrl[2];
        arrl[4] = arrl[2] << 1;
        arrl[5] = l3 ^ arrl[4];
        arrl[6] = arrl[3] << 1;
        arrl[7] = l3 ^ arrl[6];
        int n3 = (int)l2;
        long l4 = arrl[n3 & 7] ^ arrl[7 & n3 >>> 3] << 3;
        long l5 = 0L;
        int n4 = 54;
        do {
            int n5 = (int)(l2 >>> n4);
            long l6 = arrl[n5 & 7] ^ arrl[7 & n5 >>> 3] << 3;
            l4 ^= l6 << n4;
            l5 ^= l6 >>> -n4;
        } while ((n4 -= 6) > 0);
        long l7 = l5 ^ (l2 & 585610922974906400L & l3 << 4 >> 63) >>> 5;
        arrl2[n2] = arrl2[n2] ^ 0xFFFFFFFFFFFFFFFL & l4;
        int n6 = n2 + 1;
        arrl2[n6] = arrl2[n6] ^ (l4 >>> 60 ^ l7 << 4);
    }

    public static void implMulwAcc1(long[] arrl, long l2, long l3, long[] arrl2, int n2) {
        arrl[1] = l3;
        arrl[2] = arrl[1] << 1;
        arrl[3] = l3 ^ arrl[2];
        arrl[4] = arrl[2] << 1;
        arrl[5] = l3 ^ arrl[4];
        arrl[6] = arrl[3] << 1;
        arrl[7] = l3 ^ arrl[6];
        int n3 = (int)l2;
        long l4 = arrl[n3 & 7] ^ arrl[7 & n3 >>> 3] << 3;
        long l5 = 0L;
        int n4 = 54;
        do {
            int n5 = (int)(l2 >>> n4);
            long l6 = arrl[n5 & 7] ^ arrl[7 & n5 >>> 3] << 3;
            l4 ^= l6 << n4;
            l5 ^= l6 >>> -n4;
        } while ((n4 -= 6) > 0);
        arrl2[n2] = arrl2[n2] ^ 0x7FFFFFFFFFFFFFFL & l4;
        int n6 = n2 + 1;
        arrl2[n6] = arrl2[n6] ^ (l4 >>> 59 ^ l5 << 5);
    }

    public static void implSquare(long[] arrl, long[] arrl2) {
        Interleave.expand64To128(arrl, 0, 4, arrl2, 0);
    }

    public static void implSquare1(long[] arrl, long[] arrl2) {
        Interleave.expand64To128(arrl, 0, 6, arrl2, 0);
        arrl2[12] = Interleave.expand32to64((int)arrl[6]);
    }

    public static boolean isOne(int[] arrn) {
        if (arrn[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < 4; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }

    public static boolean isOne1(int[] arrn) {
        if (arrn[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < 5; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }

    public static boolean isOne2(int[] arrn) {
        if (arrn[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < 6; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }

    public static boolean isOne3(int[] arrn) {
        if (arrn[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < 7; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }

    public static boolean isOne4(int[] arrn) {
        if (arrn[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < 8; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }

    public static boolean isOne641(long[] arrl) {
        if (arrl[0] != 1L) {
            return false;
        }
        for (int i2 = 1; i2 < 3; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    public static boolean isOne642(long[] arrl) {
        if (arrl[0] != 1L) {
            return false;
        }
        for (int i2 = 1; i2 < 4; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    public static boolean isZero(int[] arrn) {
        for (int i2 = 0; i2 < 4; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }

    public static boolean isZero1(int[] arrn) {
        for (int i2 = 0; i2 < 5; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }

    public static boolean isZero2(int[] arrn) {
        for (int i2 = 0; i2 < 6; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }

    public static boolean isZero3(int[] arrn) {
        for (int i2 = 0; i2 < 7; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }

    public static boolean isZero4(int[] arrn) {
        for (int i2 = 0; i2 < 8; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }

    public static boolean isZero64(long[] arrl) {
        for (int i2 = 0; i2 < 2; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    public static boolean isZero641(long[] arrl) {
        for (int i2 = 0; i2 < 3; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    public static boolean isZero642(long[] arrl) {
        for (int i2 = 0; i2 < 4; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    public static boolean isZero643(long[] arrl) {
        for (int i2 = 0; i2 < 5; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    public static boolean isZero644(long[] arrl) {
        for (int i2 = 0; i2 < 7; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    public static int modOddInverse(int[] arrn, int[] arrn2, int[] arrn3) {
        int n2;
        int n3 = arrn.length;
        int n4 = n3 << 5;
        int n5 = 1;
        int n6 = n4 - Integer.numberOfLeadingZeros((int)arrn[n3 - n5]);
        int n7 = n6 + 29;
        int n8 = 30;
        int n9 = n7 / n8;
        int[] arrn4 = new int[4];
        int[] arrn5 = new int[n9];
        int[] arrn6 = new int[n9];
        int[] arrn7 = new int[n9];
        int[] arrn8 = new int[n9];
        int[] arrn9 = new int[n9];
        int n10 = 0;
        arrn6[0] = n5;
        SecT239Field.encode30(n6, arrn2, 0, arrn8, 0);
        SecT239Field.encode30(n6, arrn, 0, arrn9, 0);
        System.arraycopy((Object)arrn9, (int)0, (Object)arrn7, (int)0, (int)n9);
        int n11 = arrn9[0];
        int n12 = n11 * (2 - n11 * n11);
        int n13 = n12 * (2 - n11 * n12);
        int n14 = n13 * (2 - n11 * n13);
        int n15 = n14 * (2 - n11 * n14);
        int n16 = n6 * 49;
        int n17 = n6 < 46 ? 80 : 47;
        int n18 = (n16 + n17) / 17;
        int n19 = -1;
        int n20 = 2;
        while (n10 < n18) {
            int n21;
            int n22 = arrn7[0];
            int n23 = arrn8[0];
            int n24 = n6;
            int n25 = n21 = n5;
            int n26 = 0;
            int n27 = 0;
            for (int i2 = 0; i2 < n8; ++i2) {
                int n28 = n19 >> 31;
                int n29 = n18;
                int n30 = -(n23 & 1);
                int n31 = (n22 ^ n28) - n28;
                int n32 = (n21 ^ n28) - n28;
                int n33 = (n26 ^ n28) - n28;
                int n34 = n23 + (n31 & n30);
                int n35 = n28 & n30;
                n19 = (n19 ^ n35) - (n35 + 1);
                n22 += n34 & n35;
                int n36 = n21 + ((n27 += n32 & n30) & n35);
                int n37 = n26 + (n35 & (n25 += n33 & n30));
                n23 = n34 >> 1;
                n21 = n36 << 1;
                n26 = n37 << 1;
                n8 = 30;
                n18 = n29;
            }
            int n38 = n18;
            arrn4[0] = n21;
            arrn4[n5] = n26;
            arrn4[n20] = n27;
            arrn4[3] = n25;
            int n39 = arrn4[0];
            int n40 = arrn4[n5];
            int n41 = arrn4[n20];
            int n42 = arrn4[3];
            int n43 = n9 - 1;
            int n44 = arrn5[n43] >> 31;
            int n45 = arrn6[n43] >> 31;
            int n46 = (n39 & n44) + (n40 & n45);
            int n47 = (n44 & n41) + (n45 & n42);
            int n48 = n19;
            int n49 = arrn9[0];
            int n50 = n10;
            int n51 = arrn5[0];
            int[] arrn10 = arrn8;
            int n52 = arrn6[0];
            int[] arrn11 = arrn4;
            long l2 = n39;
            int[] arrn12 = arrn6;
            int[] arrn13 = arrn7;
            long l3 = n51;
            long l4 = l2 * l3;
            long l5 = n40;
            int[] arrn14 = arrn5;
            long l6 = n52;
            long l7 = l4 + l5 * l6;
            int n53 = n43;
            long l8 = n41;
            long l9 = l3 * l8;
            long l10 = n42;
            long l11 = l9 + l6 * l10;
            int n54 = n46 - (1073741823 & n46 + n15 * (int)l7);
            int n55 = n47 - (1073741823 & n47 + n15 * (int)l11);
            long l12 = n49;
            long l13 = n54;
            long l14 = l7 + l12 * l13;
            long l15 = n55;
            long l16 = l11 + l12 * l15;
            long l17 = l14 >> 30;
            long l18 = l16 >> 30;
            for (int i3 = 1; i3 < n9; ++i3) {
                int n56 = arrn9[i3];
                int n57 = arrn14[i3];
                int n58 = n15;
                int n59 = arrn12[i3];
                int n60 = n53;
                int[] arrn15 = arrn9;
                long l19 = n57;
                long l20 = l2 * l19;
                int n61 = n9;
                long l21 = n59;
                long l22 = l20 + l5 * l21;
                long l23 = n56;
                long l24 = GeneratedOutlineSupport.outline4((long)l23, (long)l13, (long)l22, (long)l17);
                long l25 = GeneratedOutlineSupport.outline4((long)l23, (long)l15, (long)(l19 * l8 + l21 * l10), (long)l18);
                int n62 = i3 - 1;
                arrn14[n62] = 1073741823 & (int)l24;
                l17 = l24 >> 30;
                arrn12[n62] = 1073741823 & (int)l25;
                l18 = l25 >> 30;
                n15 = n58;
                arrn9 = arrn15;
                n53 = n60;
                n9 = n61;
            }
            int n63 = n15;
            int n64 = n9;
            int n65 = n53;
            int[] arrn16 = arrn9;
            arrn14[n65] = (int)l17;
            arrn12[n65] = (int)l18;
            int n66 = arrn11[0];
            int n67 = arrn11[1];
            int n68 = arrn11[2];
            int n69 = arrn11[3];
            int n70 = arrn13[0];
            int n71 = arrn10[0];
            long l26 = n66;
            long l27 = n70;
            long l28 = l26 * l27;
            long l29 = n67;
            long l30 = n71;
            long l31 = l28 + l29 * l30;
            long l32 = n68;
            long l33 = l27 * l32;
            long l34 = n69;
            long l35 = l33 + l30 * l34;
            long l36 = l31 >> 30;
            long l37 = l35 >> 30;
            for (int i4 = 1; i4 < n64; ++i4) {
                int n72 = arrn13[i4];
                int[] arrn17 = arrn14;
                int n73 = arrn10[i4];
                long l38 = l37;
                long l39 = n72;
                long l40 = l26 * l39;
                long l41 = n73;
                long l42 = GeneratedOutlineSupport.outline4((long)l29, (long)l41, (long)l40, (long)l36);
                long l43 = GeneratedOutlineSupport.outline4((long)l41, (long)l34, (long)(l39 * l32), (long)l38);
                int n74 = i4 - 1;
                arrn13[n74] = 1073741823 & (int)l42;
                l36 = l42 >> 30;
                arrn10[n74] = 1073741823 & (int)l43;
                l37 = l43 >> 30;
                arrn14 = arrn17;
            }
            int[] arrn18 = arrn14;
            arrn13[n65] = (int)l36;
            arrn10[n65] = (int)l37;
            n10 = n50 + 30;
            n5 = 1;
            n8 = 30;
            n20 = 2;
            n18 = n38;
            n19 = n48;
            n9 = n64;
            arrn4 = arrn11;
            n15 = n63;
            n6 = n24;
            arrn8 = arrn10;
            arrn6 = arrn12;
            arrn7 = arrn13;
            arrn5 = arrn18;
            arrn9 = arrn16;
        }
        int n75 = n9;
        int n76 = n6;
        int[] arrn19 = arrn5;
        int[] arrn20 = arrn7;
        int[] arrn21 = arrn8;
        int[] arrn22 = arrn9;
        int n77 = arrn20[n75 - 1] >> 31;
        int n78 = n75 - 1;
        int n79 = 0;
        for (int i5 = 0; i5 < n78; ++i5) {
            int n80 = n79 + ((n77 ^ arrn20[i5]) - n77);
            arrn20[i5] = n80 & 1073741823;
            n79 = n80 >> 30;
        }
        arrn20[n78] = n79 + ((n77 ^ arrn20[n78]) - n77);
        int n81 = arrn19[n78] >> 31;
        int n82 = 0;
        for (int i6 = 0; i6 < n78; ++i6) {
            int n83 = n82 + ((n77 ^ arrn19[i6] + (n81 & arrn22[i6])) - n77);
            arrn19[i6] = n83 & 1073741823;
            n82 = n83 >> 30;
        }
        arrn19[n78] = n82 + ((n77 ^ arrn19[n78] + (n81 & arrn22[n78])) - n77);
        int n84 = arrn19[n78] >> 31;
        int n85 = 0;
        for (int i7 = 0; i7 < n78; ++i7) {
            int n86 = n85 + (arrn19[i7] + (n84 & arrn22[i7]));
            arrn19[i7] = n86 & 1073741823;
            n85 = n86 >> 30;
        }
        arrn19[n78] = n85 + (arrn19[n78] + (n84 & arrn22[n78]));
        long l44 = 0L;
        int n87 = 0;
        int n88 = 0;
        int n89 = 0;
        for (int i8 = n76; i8 > 0; i8 -= 32) {
            while (n89 < Math.min((int)32, (int)i8)) {
                int n90 = n88 + 1;
                l44 |= (long)arrn19[n88] << n89;
                n89 += 30;
                n88 = n90;
            }
            int n91 = n87 + 1;
            arrn3[n87] = (int)l44;
            l44 >>>= 32;
            n89 -= 32;
            n87 = n91;
        }
        int n92 = 0;
        int n93 = arrn20[0];
        int n94 = n93 ^ n2;
        for (n2 = 1; n2 < n75; ++n2) {
            n94 |= arrn20[n2];
        }
        int n95 = -1 + (n94 >>> 1 | n94 & 1) >> 31;
        int n96 = 0;
        while (n92 < n75) {
            n96 |= arrn21[n92];
            ++n92;
        }
        return n95 & -1 + (n96 >>> 1 | n96 & 1) >> 31;
    }

    public static void mul(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0xFFFFFFFFL & (long)arrn2[0];
        int n2 = 1;
        long l3 = 0xFFFFFFFFL & (long)arrn2[n2];
        long l4 = 0xFFFFFFFFL & (long)arrn2[2];
        long l5 = 0xFFFFFFFFL & (long)arrn2[3];
        long l6 = 0xFFFFFFFFL & (long)arrn[0];
        long l7 = 0L + l6 * l2;
        arrn3[0] = (int)l7;
        int n3 = 32;
        long l8 = (l7 >>> n3) + l6 * l3;
        arrn3[n2] = (int)l8;
        long l9 = (l8 >>> n3) + l6 * l4;
        arrn3[2] = (int)l9;
        long l10 = (l9 >>> n3) + l6 * l5;
        arrn3[3] = (int)l10;
        int n4 = (int)(l10 >>> n3);
        int n5 = 4;
        arrn3[n5] = n4;
        while (n2 < n5) {
            long l11 = 0xFFFFFFFFL & (long)arrn[n2];
            long l12 = l11 * l2;
            int n6 = n2 + 0;
            int n7 = arrn3[n6];
            int n8 = n2;
            long l13 = 0L + (l12 + (0xFFFFFFFFL & (long)n7));
            arrn3[n6] = (int)l13;
            long l14 = l13 >>> n3;
            long l15 = l11 * l3;
            int n9 = n8 + 1;
            int n10 = arrn3[n9];
            long l16 = l2;
            long l17 = l14 + (l15 + (0xFFFFFFFFL & (long)n10));
            arrn3[n9] = (int)l17;
            long l18 = l17 >>> 32;
            long l19 = l11 * l4;
            int n11 = n8 + 2;
            int n12 = arrn3[n11];
            long l20 = l3;
            long l21 = l18 + (l19 + (0xFFFFFFFFL & (long)n12));
            arrn3[n11] = (int)l21;
            n3 = 32;
            long l22 = l21 >>> n3;
            long l23 = l11 * l5;
            int n13 = n8 + 3;
            long l24 = l22 + (l23 + (0xFFFFFFFFL & (long)arrn3[n13]));
            arrn3[n13] = (int)l24;
            long l25 = l24 >>> n3;
            arrn3[n8 + 4] = (int)l25;
            n2 = n9;
            l2 = l16;
            l3 = l20;
            n5 = 4;
        }
    }

    public static void mul1(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0xFFFFFFFFL & (long)arrn2[0];
        int n2 = 1;
        long l3 = 0xFFFFFFFFL & (long)arrn2[n2];
        long l4 = 0xFFFFFFFFL & (long)arrn2[2];
        long l5 = 0xFFFFFFFFL & (long)arrn2[3];
        long l6 = 0xFFFFFFFFL & (long)arrn2[4];
        long l7 = 0xFFFFFFFFL & (long)arrn[0];
        long l8 = 0L + l7 * l2;
        arrn3[0] = (int)l8;
        long l9 = (l8 >>> 32) + l7 * l3;
        arrn3[n2] = (int)l9;
        long l10 = (l9 >>> 32) + l7 * l4;
        arrn3[2] = (int)l10;
        long l11 = (l10 >>> 32) + l7 * l5;
        arrn3[3] = (int)l11;
        long l12 = (l11 >>> 32) + l7 * l6;
        arrn3[4] = (int)l12;
        int n3 = (int)(l12 >>> 32);
        int n4 = 5;
        arrn3[n4] = n3;
        while (n2 < n4) {
            long l13 = 0xFFFFFFFFL & (long)arrn[n2];
            long l14 = l13 * l2;
            int n5 = n2 + 0;
            int n6 = arrn3[n5];
            long l15 = l2;
            long l16 = 0L + (l14 + (0xFFFFFFFFL & (long)n6));
            arrn3[n5] = (int)l16;
            long l17 = l16 >>> 32;
            long l18 = l13 * l3;
            int n7 = n2 + 1;
            int n8 = arrn3[n7];
            long l19 = l3;
            long l20 = l17 + (l18 + (0xFFFFFFFFL & (long)n8));
            arrn3[n7] = (int)l20;
            long l21 = l20 >>> 32;
            long l22 = l13 * l4;
            int n9 = n2 + 2;
            long l23 = l21 + (l22 + (0xFFFFFFFFL & (long)arrn3[n9]));
            arrn3[n9] = (int)l23;
            long l24 = l23 >>> 32;
            long l25 = l13 * l5;
            int n10 = n2 + 3;
            long l26 = l24 + (l25 + (0xFFFFFFFFL & (long)arrn3[n10]));
            arrn3[n10] = (int)l26;
            long l27 = l26 >>> 32;
            long l28 = l13 * l6;
            int n11 = n2 + 4;
            long l29 = l27 + (l28 + (0xFFFFFFFFL & (long)arrn3[n11]));
            arrn3[n11] = (int)l29;
            long l30 = l29 >>> 32;
            arrn3[n2 + 5] = (int)l30;
            n2 = n7;
            l2 = l15;
            l3 = l19;
            n4 = 5;
        }
    }

    public static void mul2(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0xFFFFFFFFL & (long)arrn2[0];
        long l3 = 0xFFFFFFFFL & (long)arrn2[1];
        long l4 = 0xFFFFFFFFL & (long)arrn2[2];
        long l5 = 0xFFFFFFFFL & (long)arrn2[3];
        long l6 = 0xFFFFFFFFL & (long)arrn2[4];
        long l7 = 0xFFFFFFFFL & (long)arrn2[5];
        long l8 = 0xFFFFFFFFL & (long)arrn[0];
        long l9 = 0L + l8 * l2;
        arrn3[0] = (int)l9;
        long l10 = (l9 >>> 32) + l8 * l3;
        arrn3[1] = (int)l10;
        long l11 = (l10 >>> 32) + l8 * l4;
        arrn3[2] = (int)l11;
        long l12 = (l11 >>> 32) + l8 * l5;
        arrn3[3] = (int)l12;
        long l13 = (l12 >>> 32) + l8 * l6;
        arrn3[4] = (int)l13;
        long l14 = (l13 >>> 32) + l8 * l7;
        arrn3[5] = (int)l14;
        int n2 = (int)(l14 >>> 32);
        int n3 = 6;
        arrn3[n3] = n2;
        int n4 = 1;
        while (n4 < n3) {
            long l15 = 0xFFFFFFFFL & (long)arrn[n4];
            long l16 = l15 * l2;
            int n5 = n4 + 0;
            int n6 = arrn3[n5];
            long l17 = l2;
            long l18 = 0L + (l16 + (0xFFFFFFFFL & (long)n6));
            arrn3[n5] = (int)l18;
            long l19 = l18 >>> 32;
            long l20 = l15 * l3;
            int n7 = n4 + 1;
            int n8 = arrn3[n7];
            long l21 = l3;
            long l22 = l19 + (l20 + (0xFFFFFFFFL & (long)n8));
            arrn3[n7] = (int)l22;
            long l23 = l22 >>> 32;
            long l24 = l15 * l4;
            int n9 = n4 + 2;
            long l25 = l23 + (l24 + (0xFFFFFFFFL & (long)arrn3[n9]));
            arrn3[n9] = (int)l25;
            long l26 = l25 >>> 32;
            long l27 = l15 * l5;
            int n10 = n4 + 3;
            long l28 = l26 + (l27 + (0xFFFFFFFFL & (long)arrn3[n10]));
            arrn3[n10] = (int)l28;
            long l29 = l28 >>> 32;
            long l30 = l15 * l6;
            int n11 = n4 + 4;
            long l31 = l29 + (l30 + (0xFFFFFFFFL & (long)arrn3[n11]));
            arrn3[n11] = (int)l31;
            long l32 = l31 >>> 32;
            long l33 = l15 * l7;
            int n12 = n4 + 5;
            long l34 = l32 + (l33 + (0xFFFFFFFFL & (long)arrn3[n12]));
            arrn3[n12] = (int)l34;
            long l35 = l34 >>> 32;
            arrn3[n4 + 6] = (int)l35;
            n4 = n7;
            l2 = l17;
            l3 = l21;
            n3 = 6;
        }
    }

    public static void mul3(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0xFFFFFFFFL & (long)arrn2[0];
        long l3 = 0xFFFFFFFFL & (long)arrn2[1];
        long l4 = 0xFFFFFFFFL & (long)arrn2[2];
        long l5 = 0xFFFFFFFFL & (long)arrn2[3];
        long l6 = 0xFFFFFFFFL & (long)arrn2[4];
        long l7 = 0xFFFFFFFFL & (long)arrn2[5];
        long l8 = 0xFFFFFFFFL & (long)arrn2[6];
        long l9 = 0xFFFFFFFFL & (long)arrn[0];
        long l10 = 0L + l9 * l2;
        arrn3[0] = (int)l10;
        long l11 = (l10 >>> 32) + l9 * l3;
        arrn3[1] = (int)l11;
        long l12 = (l11 >>> 32) + l9 * l4;
        arrn3[2] = (int)l12;
        long l13 = (l12 >>> 32) + l9 * l5;
        arrn3[3] = (int)l13;
        long l14 = (l13 >>> 32) + l9 * l6;
        arrn3[4] = (int)l14;
        long l15 = (l14 >>> 32) + l9 * l7;
        arrn3[5] = (int)l15;
        long l16 = (l15 >>> 32) + l9 * l8;
        arrn3[6] = (int)l16;
        int n2 = (int)(l16 >>> 32);
        int n3 = 7;
        arrn3[n3] = n2;
        int n4 = 1;
        while (n4 < n3) {
            long l17 = 0xFFFFFFFFL & (long)arrn[n4];
            long l18 = l17 * l2;
            int n5 = n4 + 0;
            int n6 = arrn3[n5];
            long l19 = l2;
            long l20 = 0L + (l18 + (0xFFFFFFFFL & (long)n6));
            arrn3[n5] = (int)l20;
            long l21 = l20 >>> 32;
            long l22 = l17 * l3;
            int n7 = n4 + 1;
            int n8 = arrn3[n7];
            long l23 = l3;
            long l24 = l21 + (l22 + (0xFFFFFFFFL & (long)n8));
            arrn3[n7] = (int)l24;
            long l25 = l24 >>> 32;
            long l26 = l17 * l4;
            int n9 = n4 + 2;
            long l27 = l25 + (l26 + (0xFFFFFFFFL & (long)arrn3[n9]));
            arrn3[n9] = (int)l27;
            long l28 = l27 >>> 32;
            long l29 = l17 * l5;
            int n10 = n4 + 3;
            long l30 = l28 + (l29 + (0xFFFFFFFFL & (long)arrn3[n10]));
            arrn3[n10] = (int)l30;
            long l31 = l30 >>> 32;
            long l32 = l17 * l6;
            int n11 = n4 + 4;
            long l33 = l31 + (l32 + (0xFFFFFFFFL & (long)arrn3[n11]));
            arrn3[n11] = (int)l33;
            long l34 = l33 >>> 32;
            long l35 = l17 * l7;
            int n12 = n4 + 5;
            long l36 = l34 + (l35 + (0xFFFFFFFFL & (long)arrn3[n12]));
            arrn3[n12] = (int)l36;
            long l37 = l36 >>> 32;
            long l38 = l17 * l8;
            int n13 = n4 + 6;
            long l39 = l37 + (l38 + (0xFFFFFFFFL & (long)arrn3[n13]));
            arrn3[n13] = (int)l39;
            long l40 = l39 >>> 32;
            arrn3[n4 + 7] = (int)l40;
            n4 = n7;
            l2 = l19;
            l3 = l23;
            n3 = 7;
        }
    }

    public static void mul4(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0xFFFFFFFFL & (long)arrn2[0];
        long l3 = 0xFFFFFFFFL & (long)arrn2[1];
        long l4 = 0xFFFFFFFFL & (long)arrn2[2];
        long l5 = 0xFFFFFFFFL & (long)arrn2[3];
        long l6 = 0xFFFFFFFFL & (long)arrn2[4];
        long l7 = 0xFFFFFFFFL & (long)arrn2[5];
        long l8 = 0xFFFFFFFFL & (long)arrn2[6];
        long l9 = 0xFFFFFFFFL & (long)arrn2[7];
        long l10 = 0xFFFFFFFFL & (long)arrn[0];
        long l11 = 0L + l10 * l2;
        arrn3[0] = (int)l11;
        long l12 = (l11 >>> 32) + l10 * l3;
        arrn3[1] = (int)l12;
        long l13 = (l12 >>> 32) + l10 * l4;
        arrn3[2] = (int)l13;
        long l14 = (l13 >>> 32) + l10 * l5;
        arrn3[3] = (int)l14;
        long l15 = (l14 >>> 32) + l10 * l6;
        arrn3[4] = (int)l15;
        long l16 = (l15 >>> 32) + l10 * l7;
        arrn3[5] = (int)l16;
        long l17 = (l16 >>> 32) + l10 * l8;
        arrn3[6] = (int)l17;
        long l18 = (l17 >>> 32) + l10 * l9;
        arrn3[7] = (int)l18;
        int n2 = (int)(l18 >>> 32);
        int n3 = 8;
        arrn3[n3] = n2;
        int n4 = 1;
        while (n4 < n3) {
            long l19 = 0xFFFFFFFFL & (long)arrn[n4];
            long l20 = l19 * l2;
            int n5 = n4 + 0;
            int n6 = arrn3[n5];
            long l21 = l2;
            long l22 = 0L + (l20 + (0xFFFFFFFFL & (long)n6));
            arrn3[n5] = (int)l22;
            long l23 = l22 >>> 32;
            long l24 = l19 * l3;
            int n7 = n4 + 1;
            int n8 = arrn3[n7];
            long l25 = l3;
            long l26 = l23 + (l24 + (0xFFFFFFFFL & (long)n8));
            arrn3[n7] = (int)l26;
            long l27 = l26 >>> 32;
            long l28 = l19 * l4;
            int n9 = n4 + 2;
            long l29 = l27 + (l28 + (0xFFFFFFFFL & (long)arrn3[n9]));
            arrn3[n9] = (int)l29;
            long l30 = l29 >>> 32;
            long l31 = l19 * l5;
            int n10 = n4 + 3;
            long l32 = l30 + (l31 + (0xFFFFFFFFL & (long)arrn3[n10]));
            arrn3[n10] = (int)l32;
            long l33 = l32 >>> 32;
            long l34 = l19 * l6;
            int n11 = n4 + 4;
            long l35 = l33 + (l34 + (0xFFFFFFFFL & (long)arrn3[n11]));
            arrn3[n11] = (int)l35;
            long l36 = l35 >>> 32;
            long l37 = l19 * l7;
            int n12 = n4 + 5;
            long l38 = l36 + (l37 + (0xFFFFFFFFL & (long)arrn3[n12]));
            arrn3[n12] = (int)l38;
            long l39 = l38 >>> 32;
            long l40 = l19 * l8;
            int n13 = n4 + 6;
            long l41 = l39 + (l40 + (0xFFFFFFFFL & (long)arrn3[n13]));
            arrn3[n13] = (int)l41;
            long l42 = l41 >>> 32;
            long l43 = l19 * l9;
            int n14 = n4 + 7;
            long l44 = l42 + (l43 + (0xFFFFFFFFL & (long)arrn3[n14]));
            arrn3[n14] = (int)l44;
            long l45 = l44 >>> 32;
            arrn3[n4 + 8] = (int)l45;
            n4 = n7;
            l2 = l21;
            l3 = l25;
            n3 = 8;
        }
    }

    public static int mulAddTo1(int[] arrn, int[] arrn2, int[] arrn3) {
        int n2 = 0;
        long l2 = arrn2[0];
        long l3 = 0xFFFFFFFFL;
        long l4 = l2 & l3;
        long l5 = l3 & (long)arrn2[1];
        long l6 = l3 & (long)arrn2[2];
        long l7 = l3 & (long)arrn2[3];
        long l8 = l3 & (long)arrn2[4];
        long l9 = 0L;
        while (n2 < 5) {
            long l10 = l3 & (long)arrn[n2];
            long l11 = l10 * l4;
            int n3 = n2 + 0;
            long l12 = l4;
            long l13 = 0L + (l11 + (l3 & (long)arrn3[n3]));
            arrn3[n3] = (int)l13;
            long l14 = l13 >>> 32;
            long l15 = l10 * l5;
            int n4 = n2 + 1;
            int n5 = arrn3[n4];
            long l16 = l5;
            long l17 = l14 + (l15 + (0xFFFFFFFFL & (long)n5));
            arrn3[n4] = (int)l17;
            long l18 = l17 >>> 32;
            long l19 = l10 * l6;
            int n6 = n2 + 2;
            long l20 = l18 + (l19 + (0xFFFFFFFFL & (long)arrn3[n6]));
            arrn3[n6] = (int)l20;
            long l21 = l20 >>> 32;
            long l22 = l10 * l7;
            int n7 = n2 + 3;
            int n8 = arrn3[n7];
            long l23 = l6;
            long l24 = l21 + (l22 + (0xFFFFFFFFL & (long)n8));
            arrn3[n7] = (int)l24;
            long l25 = l24 >>> 32;
            long l26 = l10 * l8;
            int n9 = n2 + 4;
            long l27 = l25 + (l26 + (0xFFFFFFFFL & (long)arrn3[n9]));
            arrn3[n9] = (int)l27;
            long l28 = l27 >>> 32;
            int n10 = n2 + 5;
            long l29 = l28 + (0xFFFFFFFFL & (long)arrn3[n10]) + l9;
            arrn3[n10] = (int)l29;
            l9 = l29 >>> 32;
            l3 = 0xFFFFFFFFL;
            l4 = l12;
            n2 = n4;
            l5 = l16;
            l6 = l23;
        }
        return (int)l9;
    }

    public static int mulAddTo2(int[] arrn, int[] arrn2, int[] arrn3) {
        int n2 = 0;
        long l2 = arrn2[0];
        long l3 = 0xFFFFFFFFL;
        long l4 = l2 & l3;
        long l5 = l3 & (long)arrn2[1];
        long l6 = l3 & (long)arrn2[2];
        long l7 = l3 & (long)arrn2[3];
        long l8 = l3 & (long)arrn2[4];
        long l9 = l3 & (long)arrn2[5];
        long l10 = 0L;
        while (n2 < 6) {
            int n3 = arrn[n2];
            long l11 = l9;
            long l12 = l3 & (long)n3;
            long l13 = l12 * l4;
            int n4 = n2 + 0;
            long l14 = l4;
            long l15 = 0L + (l13 + (l3 & (long)arrn3[n4]));
            arrn3[n4] = (int)l15;
            long l16 = l15 >>> 32;
            long l17 = l12 * l5;
            int n5 = n2 + 1;
            long l18 = l16 + (l17 + (0xFFFFFFFFL & (long)arrn3[n5]));
            arrn3[n5] = (int)l18;
            long l19 = l18 >>> 32;
            long l20 = l12 * l6;
            int n6 = n2 + 2;
            int n7 = arrn3[n6];
            long l21 = l5;
            long l22 = l19 + (l20 + (0xFFFFFFFFL & (long)n7));
            arrn3[n6] = (int)l22;
            long l23 = l22 >>> 32;
            long l24 = l12 * l7;
            int n8 = n2 + 3;
            long l25 = l23 + (l24 + (0xFFFFFFFFL & (long)arrn3[n8]));
            arrn3[n8] = (int)l25;
            long l26 = l25 >>> 32;
            long l27 = l12 * l8;
            int n9 = n2 + 4;
            long l28 = l26 + (l27 + (0xFFFFFFFFL & (long)arrn3[n9]));
            arrn3[n9] = (int)l28;
            long l29 = l28 >>> 32;
            long l30 = l12 * l11;
            int n10 = n2 + 5;
            long l31 = l29 + (l30 + (0xFFFFFFFFL & (long)arrn3[n10]));
            arrn3[n10] = (int)l31;
            long l32 = l31 >>> 32;
            int n11 = n2 + 6;
            long l33 = l32 + (0xFFFFFFFFL & (long)arrn3[n11]) + l10;
            arrn3[n11] = (int)l33;
            l10 = l33 >>> 32;
            n2 = n5;
            l3 = 0xFFFFFFFFL;
            l9 = l11;
            l4 = l14;
            l5 = l21;
        }
        return (int)l10;
    }

    public static int mulAddTo3(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0xFFFFFFFFL & (long)arrn2[0];
        long l3 = 0xFFFFFFFFL & (long)arrn2[1];
        long l4 = 0xFFFFFFFFL & (long)arrn2[2];
        long l5 = 0xFFFFFFFFL & (long)arrn2[3];
        long l6 = 0xFFFFFFFFL & (long)arrn2[4];
        long l7 = 0xFFFFFFFFL & (long)arrn2[5];
        long l8 = 0xFFFFFFFFL & (long)arrn2[6];
        long l9 = 0L;
        int n2 = 0;
        while (n2 < 7) {
            int n3 = arrn[n2];
            long l10 = l8;
            long l11 = 0xFFFFFFFFL & (long)n3;
            long l12 = l11 * l2;
            int n4 = n2 + 0;
            long l13 = l7;
            long l14 = 0L + (l12 + (0xFFFFFFFFL & (long)arrn3[n4]));
            arrn3[n4] = (int)l14;
            long l15 = l14 >>> 32;
            long l16 = l11 * l3;
            int n5 = n2 + 1;
            int n6 = arrn3[n5];
            long l17 = l3;
            long l18 = l15 + (l16 + (0xFFFFFFFFL & (long)n6));
            arrn3[n5] = (int)l18;
            long l19 = l18 >>> 32;
            long l20 = l11 * l4;
            int n7 = n2 + 2;
            int n8 = arrn3[n7];
            long l21 = l4;
            long l22 = l19 + (l20 + (0xFFFFFFFFL & (long)n8));
            arrn3[n7] = (int)l22;
            long l23 = l22 >>> 32;
            long l24 = l11 * l5;
            int n9 = n2 + 3;
            long l25 = l23 + (l24 + (0xFFFFFFFFL & (long)arrn3[n9]));
            arrn3[n9] = (int)l25;
            long l26 = l25 >>> 32;
            long l27 = l11 * l6;
            int n10 = n2 + 4;
            long l28 = l26 + (l27 + (0xFFFFFFFFL & (long)arrn3[n10]));
            arrn3[n10] = (int)l28;
            long l29 = l28 >>> 32;
            long l30 = l11 * l13;
            int n11 = n2 + 5;
            long l31 = l29 + (l30 + (0xFFFFFFFFL & (long)arrn3[n11]));
            arrn3[n11] = (int)l31;
            long l32 = l31 >>> 32;
            long l33 = l11 * l10;
            int n12 = n2 + 6;
            long l34 = l32 + (l33 + (0xFFFFFFFFL & (long)arrn3[n12]));
            arrn3[n12] = (int)l34;
            long l35 = l34 >>> 32;
            int n13 = n2 + 7;
            long l36 = l35 + (0xFFFFFFFFL & (long)arrn3[n13]) + l9;
            arrn3[n13] = (int)l36;
            l9 = l36 >>> 32;
            n2 = n5;
            l8 = l10;
            l7 = l13;
            l4 = l21;
            l3 = l17;
        }
        return (int)l9;
    }

    public static int mulAddTo4(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0xFFFFFFFFL & (long)arrn2[0];
        long l3 = 0xFFFFFFFFL & (long)arrn2[1];
        long l4 = 0xFFFFFFFFL & (long)arrn2[2];
        long l5 = 0xFFFFFFFFL & (long)arrn2[3];
        long l6 = 0xFFFFFFFFL & (long)arrn2[4];
        long l7 = 0xFFFFFFFFL & (long)arrn2[5];
        long l8 = 0xFFFFFFFFL & (long)arrn2[6];
        long l9 = 0xFFFFFFFFL & (long)arrn2[7];
        long l10 = 0L;
        int n2 = 0;
        while (n2 < 8) {
            int n3 = arrn[n2];
            long l11 = l9;
            long l12 = 0xFFFFFFFFL & (long)n3;
            long l13 = l12 * l2;
            int n4 = n2 + 0;
            long l14 = l7;
            long l15 = 0L + (l13 + (0xFFFFFFFFL & (long)arrn3[n4]));
            arrn3[n4] = (int)l15;
            long l16 = l15 >>> 32;
            long l17 = l12 * l3;
            int n5 = n2 + 1;
            int n6 = arrn3[n5];
            long l18 = l3;
            long l19 = l16 + (l17 + (0xFFFFFFFFL & (long)n6));
            arrn3[n5] = (int)l19;
            long l20 = l19 >>> 32;
            long l21 = l12 * l4;
            int n7 = n2 + 2;
            int n8 = arrn3[n7];
            long l22 = l4;
            long l23 = l20 + (l21 + (0xFFFFFFFFL & (long)n8));
            arrn3[n7] = (int)l23;
            long l24 = l23 >>> 32;
            long l25 = l12 * l5;
            int n9 = n2 + 3;
            long l26 = l24 + (l25 + (0xFFFFFFFFL & (long)arrn3[n9]));
            arrn3[n9] = (int)l26;
            long l27 = l26 >>> 32;
            long l28 = l12 * l6;
            int n10 = n2 + 4;
            long l29 = l27 + (l28 + (0xFFFFFFFFL & (long)arrn3[n10]));
            arrn3[n10] = (int)l29;
            long l30 = l29 >>> 32;
            long l31 = l12 * l14;
            int n11 = n2 + 5;
            long l32 = l30 + (l31 + (0xFFFFFFFFL & (long)arrn3[n11]));
            arrn3[n11] = (int)l32;
            long l33 = l32 >>> 32;
            long l34 = l12 * l8;
            int n12 = n2 + 6;
            long l35 = l33 + (l34 + (0xFFFFFFFFL & (long)arrn3[n12]));
            arrn3[n12] = (int)l35;
            long l36 = l35 >>> 32;
            long l37 = l12 * l11;
            int n13 = n2 + 7;
            long l38 = l36 + (l37 + (0xFFFFFFFFL & (long)arrn3[n13]));
            arrn3[n13] = (int)l38;
            long l39 = l38 >>> 32;
            int n14 = n2 + 8;
            long l40 = l39 + (0xFFFFFFFFL & (long)arrn3[n14]) + l10;
            arrn3[n14] = (int)l40;
            l10 = l40 >>> 32;
            n2 = n5;
            l9 = l11;
            l7 = l14;
            l4 = l22;
            l3 = l18;
        }
        return (int)l10;
    }

    public static void multiply(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[8];
        SecT239Field.implMultiply(arrl, arrl2, arrl4);
        SecT239Field.reduce(arrl4, arrl3);
    }

    public static void multiply1(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[14];
        SecT239Field.implMultiply1(arrl, arrl2, arrl4);
        SecT239Field.reduce1(arrl4, arrl3);
    }

    public static void multiplyAddToExt(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[8];
        SecT239Field.implMultiply(arrl, arrl2, arrl4);
        SecT239Field.addExt(arrl3, arrl4, arrl3);
    }

    public static void multiplyAddToExt1(long[] arrl, long[] arrl2, long[] arrl3) {
        long[] arrl4 = new long[14];
        SecT239Field.implMultiply1(arrl, arrl2, arrl4);
        for (int i2 = 0; i2 < 13; ++i2) {
            arrl3[i2] = arrl3[i2] ^ arrl4[i2];
        }
    }

    public static void reduce(long[] arrl, long[] arrl2) {
        long l2 = arrl[0];
        long l3 = arrl[1];
        long l4 = arrl[2];
        long l5 = arrl[3];
        long l6 = arrl[4];
        long l7 = arrl[5];
        long l8 = arrl[6];
        long l9 = arrl[7];
        long l10 = l5 ^ l9 << 17;
        long l11 = l6 ^ l9 >>> 47;
        long l12 = l7 ^ l9 << 47;
        long l13 = l8 ^ l9 >>> 17;
        long l14 = l4 ^ l13 << 17;
        long l15 = l10 ^ l13 >>> 47;
        long l16 = l11 ^ l13 << 47;
        long l17 = l12 ^ l13 >>> 17;
        long l18 = l3 ^ l17 << 17;
        long l19 = l14 ^ l17 >>> 47;
        long l20 = l15 ^ l17 << 47;
        long l21 = l16 ^ l17 >>> 17;
        long l22 = l2 ^ l21 << 17;
        long l23 = l18 ^ l21 >>> 47;
        long l24 = l19 ^ l21 << 47;
        long l25 = l20 ^ l21 >>> 17;
        long l26 = l25 >>> 47;
        arrl2[0] = l22 ^ l26;
        arrl2[1] = l23;
        arrl2[2] = l24 ^ l26 << 30;
        arrl2[3] = 0x7FFFFFFFFFFFL & l25;
    }

    public static void reduce1(long[] arrl, long[] arrl2) {
        long l2 = arrl[0];
        long l3 = arrl[1];
        long l4 = arrl[2];
        long l5 = arrl[3];
        long l6 = arrl[4];
        long l7 = arrl[5];
        long l8 = arrl[6];
        long l9 = arrl[7];
        long l10 = arrl[12];
        long l11 = l7 ^ l10 << 39;
        long l12 = l8 ^ (l10 >>> 25 ^ l10 << 62);
        long l13 = l9 ^ l10 >>> 2;
        long l14 = arrl[11];
        long l15 = l6 ^ l14 << 39;
        long l16 = l11 ^ (l14 >>> 25 ^ l14 << 62);
        long l17 = l12 ^ l14 >>> 2;
        long l18 = arrl[10];
        long l19 = l5 ^ l18 << 39;
        long l20 = l15 ^ (l18 >>> 25 ^ l18 << 62);
        long l21 = l16 ^ l18 >>> 2;
        long l22 = arrl[9];
        long l23 = l4 ^ l22 << 39;
        long l24 = l19 ^ (l22 >>> 25 ^ l22 << 62);
        long l25 = l20 ^ l22 >>> 2;
        long l26 = arrl[8];
        long l27 = l3 ^ l26 << 39;
        long l28 = l23 ^ (l26 >>> 25 ^ l26 << 62);
        long l29 = l24 ^ l26 >>> 2;
        long l30 = l2 ^ l13 << 39;
        long l31 = l27 ^ (l13 >>> 25 ^ l13 << 62);
        long l32 = l28 ^ l13 >>> 2;
        long l33 = l17 >>> 25;
        arrl2[0] = l30 ^ l33;
        arrl2[1] = l31 ^ l33 << 23;
        arrl2[2] = l32;
        arrl2[3] = l29;
        arrl2[4] = l25;
        arrl2[5] = l21;
        arrl2[6] = l17 & 0x1FFFFFFL;
    }

    public static void square(int[] arrn, int[] arrn2) {
        long l2 = 0xFFFFFFFFL & (long)arrn[0];
        int n2 = 8;
        int n3 = 0;
        int n4 = 3;
        do {
            int n5 = n4 - 1;
            long l3 = 0xFFFFFFFFL & (long)arrn[n4];
            long l4 = l3 * l3;
            int n6 = n2 - 1;
            arrn2[n6] = n3 << 31 | (int)(l4 >>> 33);
            n2 = n6 - 1;
            arrn2[n2] = (int)(l4 >>> 1);
            int n7 = (int)l4;
            if (n5 <= 0) {
                long l5 = l2 * l2;
                long l6 = 0xFFFFFFFFL & (long)(n7 << 31) | l5 >>> 33;
                arrn2[0] = (int)l5;
                int n8 = 1 & (int)(l5 >>> 32);
                long l7 = 0xFFFFFFFFL & (long)arrn[1];
                long l8 = 0xFFFFFFFFL & (long)arrn2[2];
                long l9 = l6 + l7 * l2;
                int n9 = (int)l9;
                arrn2[1] = n8 | n9 << 1;
                int n10 = n9 >>> 31;
                long l10 = l8 + (l9 >>> 32);
                long l11 = 0xFFFFFFFFL & (long)arrn[2];
                long l12 = 0xFFFFFFFFL & (long)arrn2[3];
                long l13 = 0xFFFFFFFFL & (long)arrn2[4];
                long l14 = l10 + l11 * l2;
                int n11 = (int)l14;
                arrn2[2] = n10 | n11 << 1;
                int n12 = n11 >>> 31;
                long l15 = GeneratedOutlineSupport.outline4((long)l11, (long)l7, (long)(l14 >>> 32), (long)l12);
                long l16 = l13 + (l15 >>> 32);
                long l17 = l15 & 0xFFFFFFFFL;
                long l18 = 0xFFFFFFFFL & (long)arrn[3];
                long l19 = (0xFFFFFFFFL & (long)arrn2[5]) + (l16 >>> 32);
                long l20 = l16 & 0xFFFFFFFFL;
                long l21 = (0xFFFFFFFFL & (long)arrn2[6]) + (l19 >>> 32);
                long l22 = l19 & 0xFFFFFFFFL;
                long l23 = l17 + l2 * l18;
                int n13 = (int)l23;
                arrn2[3] = n12 | n13 << 1;
                int n14 = n13 >>> 31;
                long l24 = GeneratedOutlineSupport.outline4((long)l7, (long)l18, (long)(l23 >>> 32), (long)l20);
                long l25 = GeneratedOutlineSupport.outline4((long)l18, (long)l11, (long)(l24 >>> 32), (long)l22);
                long l26 = l21 + (l25 >>> 32);
                long l27 = 0xFFFFFFFFL & l25;
                int n15 = (int)l24;
                arrn2[4] = n14 | n15 << 1;
                int n16 = n15 >>> 31;
                int n17 = (int)l27;
                arrn2[5] = n16 | n17 << 1;
                int n18 = n17 >>> 31;
                int n19 = (int)l26;
                arrn2[6] = n18 | n19 << 1;
                arrn2[7] = n19 >>> 31 | arrn2[7] + (int)(l26 >>> 32) << 1;
                return;
            }
            n4 = n5;
            n3 = n7;
        } while (true);
    }

    public static void square(long[] arrl, long[] arrl2) {
        long[] arrl3 = new long[8];
        SecT239Field.implSquare(arrl, arrl3);
        SecT239Field.reduce(arrl3, arrl2);
    }

    public static void square1(int[] arrn, int[] arrn2) {
        long l2 = 0xFFFFFFFFL & (long)arrn[0];
        int n2 = 10;
        int n3 = 0;
        int n4 = 4;
        do {
            int n5 = n4 - 1;
            long l3 = 0xFFFFFFFFL & (long)arrn[n4];
            long l4 = l3 * l3;
            int n6 = n2 - 1;
            arrn2[n6] = n3 << 31 | (int)(l4 >>> 33);
            n2 = n6 - 1;
            arrn2[n2] = (int)(l4 >>> 1);
            int n7 = (int)l4;
            if (n5 <= 0) {
                long l5 = l2 * l2;
                long l6 = 0xFFFFFFFFL & (long)(n7 << 31) | l5 >>> 33;
                arrn2[0] = (int)l5;
                int n8 = 1 & (int)(l5 >>> 32);
                long l7 = 0xFFFFFFFFL & (long)arrn[1];
                long l8 = 0xFFFFFFFFL & (long)arrn2[2];
                long l9 = l6 + l7 * l2;
                int n9 = (int)l9;
                arrn2[1] = n8 | n9 << 1;
                int n10 = n9 >>> 31;
                long l10 = l8 + (l9 >>> 32);
                long l11 = 0xFFFFFFFFL & (long)arrn[2];
                long l12 = 0xFFFFFFFFL & (long)arrn2[3];
                long l13 = 0xFFFFFFFFL & (long)arrn2[4];
                long l14 = l10 + l11 * l2;
                int n11 = (int)l14;
                arrn2[2] = n10 | n11 << 1;
                int n12 = n11 >>> 31;
                long l15 = GeneratedOutlineSupport.outline4((long)l11, (long)l7, (long)(l14 >>> 32), (long)l12);
                long l16 = l13 + (l15 >>> 32);
                long l17 = l15 & 0xFFFFFFFFL;
                long l18 = 0xFFFFFFFFL & (long)arrn[3];
                long l19 = (0xFFFFFFFFL & (long)arrn2[5]) + (l16 >>> 32);
                long l20 = l16 & 0xFFFFFFFFL;
                long l21 = (0xFFFFFFFFL & (long)arrn2[6]) + (l19 >>> 32);
                long l22 = l19 & 0xFFFFFFFFL;
                long l23 = l17 + l18 * l2;
                int n13 = (int)l23;
                arrn2[3] = n12 | n13 << 1;
                int n14 = n13 >>> 31;
                long l24 = GeneratedOutlineSupport.outline4((long)l18, (long)l7, (long)(l23 >>> 32), (long)l20);
                long l25 = GeneratedOutlineSupport.outline4((long)l18, (long)l11, (long)(l24 >>> 32), (long)l22);
                long l26 = l24 & 0xFFFFFFFFL;
                long l27 = l21 + (l25 >>> 32);
                long l28 = l25 & 0xFFFFFFFFL;
                long l29 = 0xFFFFFFFFL & (long)arrn[4];
                long l30 = (0xFFFFFFFFL & (long)arrn2[7]) + (l27 >>> 32);
                long l31 = l27 & 0xFFFFFFFFL;
                long l32 = (0xFFFFFFFFL & (long)arrn2[8]) + (l30 >>> 32);
                long l33 = l30 & 0xFFFFFFFFL;
                long l34 = l26 + l2 * l29;
                int n15 = (int)l34;
                arrn2[4] = n14 | n15 << 1;
                int n16 = n15 >>> 31;
                long l35 = GeneratedOutlineSupport.outline4((long)l29, (long)l7, (long)(l34 >>> 32), (long)l28);
                long l36 = GeneratedOutlineSupport.outline4((long)l29, (long)l11, (long)(l35 >>> 32), (long)l31);
                long l37 = GeneratedOutlineSupport.outline4((long)l29, (long)l18, (long)(l36 >>> 32), (long)l33);
                long l38 = l32 + (l37 >>> 32);
                int n17 = (int)l35;
                arrn2[5] = n16 | n17 << 1;
                int n18 = n17 >>> 31;
                int n19 = (int)l36;
                arrn2[6] = n18 | n19 << 1;
                int n20 = n19 >>> 31;
                int n21 = (int)l37;
                arrn2[7] = n20 | n21 << 1;
                int n22 = n21 >>> 31;
                int n23 = (int)l38;
                arrn2[8] = n22 | n23 << 1;
                arrn2[9] = n23 >>> 31 | arrn2[9] + (int)(l38 >>> 32) << 1;
                return;
            }
            n4 = n5;
            n3 = n7;
        } while (true);
    }

    public static void square2(int[] arrn, int[] arrn2) {
        long l2 = 0xFFFFFFFFL & (long)arrn[0];
        int n2 = 12;
        int n3 = 5;
        int n4 = 0;
        do {
            int n5 = n3 - 1;
            long l3 = 0xFFFFFFFFL & (long)arrn[n3];
            long l4 = l3 * l3;
            int n6 = n2 - 1;
            arrn2[n6] = n4 << 31 | (int)(l4 >>> 33);
            n2 = n6 - 1;
            arrn2[n2] = (int)(l4 >>> 1);
            int n7 = (int)l4;
            if (n5 <= 0) {
                long l5 = l2 * l2;
                long l6 = 0xFFFFFFFFL & (long)(n7 << 31) | l5 >>> 33;
                arrn2[0] = (int)l5;
                int n8 = 1 & (int)(l5 >>> 32);
                long l7 = 0xFFFFFFFFL & (long)arrn[1];
                long l8 = 0xFFFFFFFFL & (long)arrn2[2];
                long l9 = l6 + l7 * l2;
                int n9 = (int)l9;
                arrn2[1] = n8 | n9 << 1;
                int n10 = n9 >>> 31;
                long l10 = l8 + (l9 >>> 32);
                long l11 = 0xFFFFFFFFL & (long)arrn[2];
                long l12 = 0xFFFFFFFFL & (long)arrn2[3];
                long l13 = 0xFFFFFFFFL & (long)arrn2[4];
                long l14 = l10 + l11 * l2;
                int n11 = (int)l14;
                arrn2[2] = n10 | n11 << 1;
                int n12 = n11 >>> 31;
                long l15 = GeneratedOutlineSupport.outline4((long)l11, (long)l7, (long)(l14 >>> 32), (long)l12);
                long l16 = l13 + (l15 >>> 32);
                long l17 = l15 & 0xFFFFFFFFL;
                long l18 = 0xFFFFFFFFL & (long)arrn[3];
                long l19 = (0xFFFFFFFFL & (long)arrn2[5]) + (l16 >>> 32);
                long l20 = l16 & 0xFFFFFFFFL;
                long l21 = (0xFFFFFFFFL & (long)arrn2[6]) + (l19 >>> 32);
                long l22 = l19 & 0xFFFFFFFFL;
                long l23 = l17 + l18 * l2;
                int n13 = (int)l23;
                arrn2[3] = n12 | n13 << 1;
                int n14 = n13 >>> 31;
                long l24 = GeneratedOutlineSupport.outline4((long)l18, (long)l7, (long)(l23 >>> 32), (long)l20);
                long l25 = GeneratedOutlineSupport.outline4((long)l18, (long)l11, (long)(l24 >>> 32), (long)l22);
                long l26 = l24 & 0xFFFFFFFFL;
                long l27 = l21 + (l25 >>> 32);
                long l28 = l25 & 0xFFFFFFFFL;
                long l29 = 0xFFFFFFFFL & (long)arrn[4];
                long l30 = (0xFFFFFFFFL & (long)arrn2[7]) + (l27 >>> 32);
                long l31 = l27 & 0xFFFFFFFFL;
                long l32 = (0xFFFFFFFFL & (long)arrn2[8]) + (l30 >>> 32);
                long l33 = l30 & 0xFFFFFFFFL;
                long l34 = l26 + l29 * l2;
                int n15 = (int)l34;
                arrn2[4] = n14 | n15 << 1;
                int n16 = n15 >>> 31;
                long l35 = GeneratedOutlineSupport.outline4((long)l29, (long)l7, (long)(l34 >>> 32), (long)l28);
                long l36 = GeneratedOutlineSupport.outline4((long)l29, (long)l11, (long)(l35 >>> 32), (long)l31);
                long l37 = l35 & 0xFFFFFFFFL;
                long l38 = GeneratedOutlineSupport.outline4((long)l29, (long)l18, (long)(l36 >>> 32), (long)l33);
                long l39 = l36 & 0xFFFFFFFFL;
                long l40 = l32 + (l38 >>> 32);
                long l41 = l38 & 0xFFFFFFFFL;
                long l42 = 0xFFFFFFFFL & (long)arrn[5];
                long l43 = (0xFFFFFFFFL & (long)arrn2[9]) + (l40 >>> 32);
                long l44 = l40 & 0xFFFFFFFFL;
                long l45 = (0xFFFFFFFFL & (long)arrn2[10]) + (l43 >>> 32);
                long l46 = l43 & 0xFFFFFFFFL;
                long l47 = l37 + l2 * l42;
                int n17 = (int)l47;
                arrn2[5] = n16 | n17 << 1;
                int n18 = n17 >>> 31;
                long l48 = GeneratedOutlineSupport.outline4((long)l7, (long)l42, (long)(l47 >>> 32), (long)l39);
                long l49 = GeneratedOutlineSupport.outline4((long)l42, (long)l11, (long)(l48 >>> 32), (long)l41);
                long l50 = GeneratedOutlineSupport.outline4((long)l42, (long)l18, (long)(l49 >>> 32), (long)l44);
                long l51 = GeneratedOutlineSupport.outline4((long)l42, (long)l29, (long)(l50 >>> 32), (long)l46);
                long l52 = l45 + (l51 >>> 32);
                int n19 = (int)l48;
                arrn2[6] = n18 | n19 << 1;
                int n20 = n19 >>> 31;
                int n21 = (int)l49;
                arrn2[7] = n20 | n21 << 1;
                int n22 = n21 >>> 31;
                int n23 = (int)l50;
                arrn2[8] = n22 | n23 << 1;
                int n24 = n23 >>> 31;
                int n25 = (int)l51;
                arrn2[9] = n24 | n25 << 1;
                int n26 = n25 >>> 31;
                int n27 = (int)l52;
                arrn2[10] = n26 | n27 << 1;
                arrn2[11] = n27 >>> 31 | arrn2[11] + (int)(l52 >>> 32) << 1;
                return;
            }
            n3 = n5;
            n4 = n7;
        } while (true);
    }

    public static void square3(int[] arrn, int[] arrn2) {
        long l2 = 0xFFFFFFFFL & (long)arrn[0];
        int n2 = 14;
        int n3 = 6;
        int n4 = 0;
        do {
            int n5 = n3 - 1;
            long l3 = 0xFFFFFFFFL & (long)arrn[n3];
            long l4 = l3 * l3;
            int n6 = n2 - 1;
            arrn2[n6] = n4 << 31 | (int)(l4 >>> 33);
            n2 = n6 - 1;
            arrn2[n2] = (int)(l4 >>> 1);
            int n7 = (int)l4;
            if (n5 <= 0) {
                long l5 = l2 * l2;
                long l6 = 0xFFFFFFFFL & (long)(n7 << 31) | l5 >>> 33;
                arrn2[0] = (int)l5;
                int n8 = 1 & (int)(l5 >>> 32);
                long l7 = 0xFFFFFFFFL & (long)arrn[1];
                long l8 = 0xFFFFFFFFL & (long)arrn2[2];
                long l9 = l6 + l7 * l2;
                int n9 = (int)l9;
                arrn2[1] = n8 | n9 << 1;
                int n10 = n9 >>> 31;
                long l10 = l8 + (l9 >>> 32);
                long l11 = 0xFFFFFFFFL & (long)arrn[2];
                long l12 = 0xFFFFFFFFL & (long)arrn2[3];
                long l13 = 0xFFFFFFFFL & (long)arrn2[4];
                long l14 = l10 + l11 * l2;
                int n11 = (int)l14;
                arrn2[2] = n10 | n11 << 1;
                int n12 = n11 >>> 31;
                long l15 = GeneratedOutlineSupport.outline4((long)l11, (long)l7, (long)(l14 >>> 32), (long)l12);
                long l16 = l13 + (l15 >>> 32);
                long l17 = l15 & 0xFFFFFFFFL;
                long l18 = 0xFFFFFFFFL & (long)arrn[3];
                long l19 = (0xFFFFFFFFL & (long)arrn2[5]) + (l16 >>> 32);
                long l20 = l16 & 0xFFFFFFFFL;
                long l21 = (0xFFFFFFFFL & (long)arrn2[6]) + (l19 >>> 32);
                long l22 = l19 & 0xFFFFFFFFL;
                long l23 = l17 + l18 * l2;
                int n13 = (int)l23;
                arrn2[3] = n12 | n13 << 1;
                int n14 = n13 >>> 31;
                long l24 = GeneratedOutlineSupport.outline4((long)l18, (long)l7, (long)(l23 >>> 32), (long)l20);
                long l25 = GeneratedOutlineSupport.outline4((long)l18, (long)l11, (long)(l24 >>> 32), (long)l22);
                long l26 = l24 & 0xFFFFFFFFL;
                long l27 = l21 + (l25 >>> 32);
                long l28 = l25 & 0xFFFFFFFFL;
                long l29 = 0xFFFFFFFFL & (long)arrn[4];
                long l30 = (0xFFFFFFFFL & (long)arrn2[7]) + (l27 >>> 32);
                long l31 = l27 & 0xFFFFFFFFL;
                long l32 = (0xFFFFFFFFL & (long)arrn2[8]) + (l30 >>> 32);
                long l33 = l30 & 0xFFFFFFFFL;
                long l34 = l26 + l29 * l2;
                int n15 = (int)l34;
                arrn2[4] = n14 | n15 << 1;
                int n16 = n15 >>> 31;
                long l35 = GeneratedOutlineSupport.outline4((long)l29, (long)l7, (long)(l34 >>> 32), (long)l28);
                long l36 = GeneratedOutlineSupport.outline4((long)l29, (long)l11, (long)(l35 >>> 32), (long)l31);
                long l37 = l35 & 0xFFFFFFFFL;
                long l38 = GeneratedOutlineSupport.outline4((long)l29, (long)l18, (long)(l36 >>> 32), (long)l33);
                long l39 = l36 & 0xFFFFFFFFL;
                long l40 = l32 + (l38 >>> 32);
                long l41 = l38 & 0xFFFFFFFFL;
                long l42 = 0xFFFFFFFFL & (long)arrn[5];
                long l43 = (0xFFFFFFFFL & (long)arrn2[9]) + (l40 >>> 32);
                long l44 = l40 & 0xFFFFFFFFL;
                long l45 = (0xFFFFFFFFL & (long)arrn2[10]) + (l43 >>> 32);
                long l46 = l43 & 0xFFFFFFFFL;
                long l47 = l37 + l42 * l2;
                int n17 = (int)l47;
                arrn2[5] = n16 | n17 << 1;
                int n18 = n17 >>> 31;
                long l48 = GeneratedOutlineSupport.outline4((long)l42, (long)l7, (long)(l47 >>> 32), (long)l39);
                long l49 = GeneratedOutlineSupport.outline4((long)l42, (long)l11, (long)(l48 >>> 32), (long)l41);
                long l50 = l48 & 0xFFFFFFFFL;
                long l51 = GeneratedOutlineSupport.outline4((long)l42, (long)l18, (long)(l49 >>> 32), (long)l44);
                long l52 = l49 & 0xFFFFFFFFL;
                long l53 = GeneratedOutlineSupport.outline4((long)l42, (long)l29, (long)(l51 >>> 32), (long)l46);
                long l54 = l51 & 0xFFFFFFFFL;
                long l55 = l45 + (l53 >>> 32);
                long l56 = l53 & 0xFFFFFFFFL;
                long l57 = 0xFFFFFFFFL & (long)arrn[6];
                long l58 = (0xFFFFFFFFL & (long)arrn2[11]) + (l55 >>> 32);
                long l59 = l55 & 0xFFFFFFFFL;
                long l60 = (0xFFFFFFFFL & (long)arrn2[12]) + (l58 >>> 32);
                long l61 = l58 & 0xFFFFFFFFL;
                long l62 = l50 + l2 * l57;
                int n19 = (int)l62;
                arrn2[6] = n18 | n19 << 1;
                int n20 = n19 >>> 31;
                long l63 = GeneratedOutlineSupport.outline4((long)l7, (long)l57, (long)(l62 >>> 32), (long)l52);
                long l64 = GeneratedOutlineSupport.outline4((long)l57, (long)l11, (long)(l63 >>> 32), (long)l54);
                long l65 = GeneratedOutlineSupport.outline4((long)l57, (long)l18, (long)(l64 >>> 32), (long)l56);
                long l66 = GeneratedOutlineSupport.outline4((long)l57, (long)l29, (long)(l65 >>> 32), (long)l59);
                long l67 = GeneratedOutlineSupport.outline4((long)l57, (long)l42, (long)(l66 >>> 32), (long)l61);
                long l68 = l60 + (l67 >>> 32);
                int n21 = (int)l63;
                arrn2[7] = n20 | n21 << 1;
                int n22 = n21 >>> 31;
                int n23 = (int)l64;
                arrn2[8] = n22 | n23 << 1;
                int n24 = n23 >>> 31;
                int n25 = (int)l65;
                arrn2[9] = n24 | n25 << 1;
                int n26 = n25 >>> 31;
                int n27 = (int)l66;
                arrn2[10] = n26 | n27 << 1;
                int n28 = n27 >>> 31;
                int n29 = (int)l67;
                arrn2[11] = n28 | n29 << 1;
                int n30 = n29 >>> 31;
                int n31 = (int)l68;
                arrn2[12] = n30 | n31 << 1;
                arrn2[13] = n31 >>> 31 | arrn2[13] + (int)(l68 >>> 32) << 1;
                return;
            }
            n3 = n5;
            n4 = n7;
        } while (true);
    }

    public static void square4(int[] arrn, int[] arrn2) {
        long l2 = 0xFFFFFFFFL & (long)arrn[0];
        int n2 = 16;
        int n3 = 7;
        int n4 = 0;
        do {
            int n5 = n3 - 1;
            long l3 = 0xFFFFFFFFL & (long)arrn[n3];
            long l4 = l3 * l3;
            int n6 = n2 - 1;
            arrn2[n6] = n4 << 31 | (int)(l4 >>> 33);
            n2 = n6 - 1;
            arrn2[n2] = (int)(l4 >>> 1);
            int n7 = (int)l4;
            if (n5 <= 0) {
                long l5 = l2 * l2;
                long l6 = 0xFFFFFFFFL & (long)(n7 << 31) | l5 >>> 33;
                arrn2[0] = (int)l5;
                int n8 = 1 & (int)(l5 >>> 32);
                long l7 = 0xFFFFFFFFL & (long)arrn[1];
                long l8 = 0xFFFFFFFFL & (long)arrn2[2];
                long l9 = l6 + l7 * l2;
                int n9 = (int)l9;
                arrn2[1] = n8 | n9 << 1;
                int n10 = n9 >>> 31;
                long l10 = l8 + (l9 >>> 32);
                long l11 = 0xFFFFFFFFL & (long)arrn[2];
                long l12 = 0xFFFFFFFFL & (long)arrn2[3];
                long l13 = 0xFFFFFFFFL & (long)arrn2[4];
                long l14 = l10 + l11 * l2;
                int n11 = (int)l14;
                arrn2[2] = n10 | n11 << 1;
                int n12 = n11 >>> 31;
                long l15 = GeneratedOutlineSupport.outline4((long)l11, (long)l7, (long)(l14 >>> 32), (long)l12);
                long l16 = l13 + (l15 >>> 32);
                long l17 = l15 & 0xFFFFFFFFL;
                long l18 = 0xFFFFFFFFL & (long)arrn[3];
                long l19 = (0xFFFFFFFFL & (long)arrn2[5]) + (l16 >>> 32);
                long l20 = l16 & 0xFFFFFFFFL;
                long l21 = (0xFFFFFFFFL & (long)arrn2[6]) + (l19 >>> 32);
                long l22 = l19 & 0xFFFFFFFFL;
                long l23 = l17 + l18 * l2;
                int n13 = (int)l23;
                arrn2[3] = n12 | n13 << 1;
                int n14 = n13 >>> 31;
                long l24 = GeneratedOutlineSupport.outline4((long)l18, (long)l7, (long)(l23 >>> 32), (long)l20);
                long l25 = GeneratedOutlineSupport.outline4((long)l18, (long)l11, (long)(l24 >>> 32), (long)l22);
                long l26 = l24 & 0xFFFFFFFFL;
                long l27 = l21 + (l25 >>> 32);
                long l28 = l25 & 0xFFFFFFFFL;
                long l29 = 0xFFFFFFFFL & (long)arrn[4];
                long l30 = (0xFFFFFFFFL & (long)arrn2[7]) + (l27 >>> 32);
                long l31 = l27 & 0xFFFFFFFFL;
                long l32 = (0xFFFFFFFFL & (long)arrn2[8]) + (l30 >>> 32);
                long l33 = l30 & 0xFFFFFFFFL;
                long l34 = l26 + l29 * l2;
                int n15 = (int)l34;
                arrn2[4] = n14 | n15 << 1;
                int n16 = n15 >>> 31;
                long l35 = GeneratedOutlineSupport.outline4((long)l29, (long)l7, (long)(l34 >>> 32), (long)l28);
                long l36 = GeneratedOutlineSupport.outline4((long)l29, (long)l11, (long)(l35 >>> 32), (long)l31);
                long l37 = l35 & 0xFFFFFFFFL;
                long l38 = GeneratedOutlineSupport.outline4((long)l29, (long)l18, (long)(l36 >>> 32), (long)l33);
                long l39 = l36 & 0xFFFFFFFFL;
                long l40 = l32 + (l38 >>> 32);
                long l41 = l38 & 0xFFFFFFFFL;
                long l42 = 0xFFFFFFFFL & (long)arrn[5];
                long l43 = (0xFFFFFFFFL & (long)arrn2[9]) + (l40 >>> 32);
                long l44 = l40 & 0xFFFFFFFFL;
                long l45 = (0xFFFFFFFFL & (long)arrn2[10]) + (l43 >>> 32);
                long l46 = l43 & 0xFFFFFFFFL;
                long l47 = l37 + l42 * l2;
                int n17 = (int)l47;
                arrn2[5] = n16 | n17 << 1;
                int n18 = n17 >>> 31;
                long l48 = GeneratedOutlineSupport.outline4((long)l42, (long)l7, (long)(l47 >>> 32), (long)l39);
                long l49 = GeneratedOutlineSupport.outline4((long)l42, (long)l11, (long)(l48 >>> 32), (long)l41);
                long l50 = l48 & 0xFFFFFFFFL;
                long l51 = GeneratedOutlineSupport.outline4((long)l42, (long)l18, (long)(l49 >>> 32), (long)l44);
                long l52 = l49 & 0xFFFFFFFFL;
                long l53 = GeneratedOutlineSupport.outline4((long)l42, (long)l29, (long)(l51 >>> 32), (long)l46);
                long l54 = l51 & 0xFFFFFFFFL;
                long l55 = l45 + (l53 >>> 32);
                long l56 = l53 & 0xFFFFFFFFL;
                long l57 = 0xFFFFFFFFL & (long)arrn[6];
                long l58 = (0xFFFFFFFFL & (long)arrn2[11]) + (l55 >>> 32);
                long l59 = l55 & 0xFFFFFFFFL;
                long l60 = (0xFFFFFFFFL & (long)arrn2[12]) + (l58 >>> 32);
                long l61 = l58 & 0xFFFFFFFFL;
                long l62 = l50 + l57 * l2;
                int n19 = (int)l62;
                arrn2[6] = n18 | n19 << 1;
                int n20 = n19 >>> 31;
                long l63 = GeneratedOutlineSupport.outline4((long)l57, (long)l7, (long)(l62 >>> 32), (long)l52);
                long l64 = GeneratedOutlineSupport.outline4((long)l57, (long)l11, (long)(l63 >>> 32), (long)l54);
                long l65 = l63 & 0xFFFFFFFFL;
                long l66 = GeneratedOutlineSupport.outline4((long)l57, (long)l18, (long)(l64 >>> 32), (long)l56);
                long l67 = l64 & 0xFFFFFFFFL;
                long l68 = GeneratedOutlineSupport.outline4((long)l57, (long)l29, (long)(l66 >>> 32), (long)l59);
                long l69 = l66 & 0xFFFFFFFFL;
                long l70 = GeneratedOutlineSupport.outline4((long)l57, (long)l42, (long)(l68 >>> 32), (long)l61);
                long l71 = l68 & 0xFFFFFFFFL;
                long l72 = l60 + (l70 >>> 32);
                long l73 = l70 & 0xFFFFFFFFL;
                long l74 = 0xFFFFFFFFL & (long)arrn[7];
                long l75 = (0xFFFFFFFFL & (long)arrn2[13]) + (l72 >>> 32);
                long l76 = l72 & 0xFFFFFFFFL;
                long l77 = (0xFFFFFFFFL & (long)arrn2[14]) + (l75 >>> 32);
                long l78 = l75 & 0xFFFFFFFFL;
                long l79 = l65 + l2 * l74;
                int n21 = (int)l79;
                arrn2[7] = n20 | n21 << 1;
                int n22 = n21 >>> 31;
                long l80 = GeneratedOutlineSupport.outline4((long)l7, (long)l74, (long)(l79 >>> 32), (long)l67);
                long l81 = GeneratedOutlineSupport.outline4((long)l74, (long)l11, (long)(l80 >>> 32), (long)l69);
                long l82 = GeneratedOutlineSupport.outline4((long)l74, (long)l18, (long)(l81 >>> 32), (long)l71);
                long l83 = GeneratedOutlineSupport.outline4((long)l74, (long)l29, (long)(l82 >>> 32), (long)l73);
                long l84 = GeneratedOutlineSupport.outline4((long)l74, (long)l42, (long)(l83 >>> 32), (long)l76);
                long l85 = GeneratedOutlineSupport.outline4((long)l74, (long)l57, (long)(l84 >>> 32), (long)l78);
                long l86 = l77 + (l85 >>> 32);
                int n23 = (int)l80;
                arrn2[8] = n22 | n23 << 1;
                int n24 = n23 >>> 31;
                int n25 = (int)l81;
                arrn2[9] = n24 | n25 << 1;
                int n26 = n25 >>> 31;
                int n27 = (int)l82;
                arrn2[10] = n26 | n27 << 1;
                int n28 = n27 >>> 31;
                int n29 = (int)l83;
                arrn2[11] = n28 | n29 << 1;
                int n30 = n29 >>> 31;
                int n31 = (int)l84;
                arrn2[12] = n30 | n31 << 1;
                int n32 = n31 >>> 31;
                int n33 = (int)l85;
                arrn2[13] = n32 | n33 << 1;
                int n34 = n33 >>> 31;
                int n35 = (int)l86;
                arrn2[14] = n34 | n35 << 1;
                arrn2[15] = n35 >>> 31 | arrn2[15] + (int)(l86 >>> 32) << 1;
                return;
            }
            n3 = n5;
            n4 = n7;
        } while (true);
    }

    public static void squareN(long[] arrl, int n2, long[] arrl2) {
        long[] arrl3 = new long[8];
        SecT239Field.implSquare(arrl, arrl3);
        do {
            SecT239Field.reduce(arrl3, arrl2);
            if (--n2 <= 0) break;
            SecT239Field.implSquare(arrl2, arrl3);
        } while (true);
    }

    public static void squareN1(long[] arrl, int n2, long[] arrl2) {
        long[] arrl3 = new long[13];
        SecT239Field.implSquare1(arrl, arrl3);
        do {
            SecT239Field.reduce1(arrl3, arrl2);
            if (--n2 <= 0) break;
            SecT239Field.implSquare1(arrl2, arrl3);
        } while (true);
    }

    public static int sub(int[] arrn, int n2, int[] arrn2, int n3, int[] arrn3, int n4) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[n2 + 0]) - (0xFFFFFFFFL & (long)arrn2[n3 + 0]));
        arrn3[n4 + 0] = (int)l2;
        long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn[n2 + 1]) - (0xFFFFFFFFL & (long)arrn2[n3 + 1]));
        arrn3[n4 + 1] = (int)l3;
        long l4 = (l3 >> 32) + ((0xFFFFFFFFL & (long)arrn[n2 + 2]) - (0xFFFFFFFFL & (long)arrn2[n3 + 2]));
        arrn3[n4 + 2] = (int)l4;
        long l5 = (l4 >> 32) + ((0xFFFFFFFFL & (long)arrn[n2 + 3]) - (0xFFFFFFFFL & (long)arrn2[n3 + 3]));
        arrn3[n4 + 3] = (int)l5;
        long l6 = (l5 >> 32) + ((0xFFFFFFFFL & (long)arrn[n2 + 4]) - (0xFFFFFFFFL & (long)arrn2[n3 + 4]));
        arrn3[n4 + 4] = (int)l6;
        long l7 = (l6 >> 32) + ((0xFFFFFFFFL & (long)arrn[n2 + 5]) - (0xFFFFFFFFL & (long)arrn2[n3 + 5]));
        arrn3[n4 + 5] = (int)l7;
        return (int)(l7 >> 32);
    }

    public static int sub(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) - (0xFFFFFFFFL & (long)arrn2[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn[1]) - (0xFFFFFFFFL & (long)arrn2[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >> 32) + ((0xFFFFFFFFL & (long)arrn[2]) - (0xFFFFFFFFL & (long)arrn2[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >> 32) + ((0xFFFFFFFFL & (long)arrn[3]) - (0xFFFFFFFFL & (long)arrn2[3]));
        arrn3[3] = (int)l5;
        return (int)(l5 >> 32);
    }

    public static int sub1(int[] arrn, int n2, int[] arrn2, int n3, int[] arrn3, int n4) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[n2 + 0]) - (0xFFFFFFFFL & (long)arrn2[n3 + 0]));
        arrn3[n4 + 0] = (int)l2;
        long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn[n2 + 1]) - (0xFFFFFFFFL & (long)arrn2[n3 + 1]));
        arrn3[n4 + 1] = (int)l3;
        long l4 = (l3 >> 32) + ((0xFFFFFFFFL & (long)arrn[n2 + 2]) - (0xFFFFFFFFL & (long)arrn2[n3 + 2]));
        arrn3[n4 + 2] = (int)l4;
        long l5 = (l4 >> 32) + ((0xFFFFFFFFL & (long)arrn[n2 + 3]) - (0xFFFFFFFFL & (long)arrn2[n3 + 3]));
        arrn3[n4 + 3] = (int)l5;
        long l6 = (l5 >> 32) + ((0xFFFFFFFFL & (long)arrn[n2 + 4]) - (0xFFFFFFFFL & (long)arrn2[n3 + 4]));
        arrn3[n4 + 4] = (int)l6;
        long l7 = (l6 >> 32) + ((0xFFFFFFFFL & (long)arrn[n2 + 5]) - (0xFFFFFFFFL & (long)arrn2[n3 + 5]));
        arrn3[n4 + 5] = (int)l7;
        long l8 = (l7 >> 32) + ((0xFFFFFFFFL & (long)arrn[n2 + 6]) - (0xFFFFFFFFL & (long)arrn2[n3 + 6]));
        arrn3[n4 + 6] = (int)l8;
        long l9 = (l8 >> 32) + ((0xFFFFFFFFL & (long)arrn[n2 + 7]) - (0xFFFFFFFFL & (long)arrn2[n3 + 7]));
        arrn3[n4 + 7] = (int)l9;
        return (int)(l9 >> 32);
    }

    public static int sub1(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) - (0xFFFFFFFFL & (long)arrn2[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn[1]) - (0xFFFFFFFFL & (long)arrn2[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >> 32) + ((0xFFFFFFFFL & (long)arrn[2]) - (0xFFFFFFFFL & (long)arrn2[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >> 32) + ((0xFFFFFFFFL & (long)arrn[3]) - (0xFFFFFFFFL & (long)arrn2[3]));
        arrn3[3] = (int)l5;
        long l6 = (l5 >> 32) + ((0xFFFFFFFFL & (long)arrn[4]) - (0xFFFFFFFFL & (long)arrn2[4]));
        arrn3[4] = (int)l6;
        return (int)(l6 >> 32);
    }

    public static int sub2(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) - (0xFFFFFFFFL & (long)arrn2[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn[1]) - (0xFFFFFFFFL & (long)arrn2[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >> 32) + ((0xFFFFFFFFL & (long)arrn[2]) - (0xFFFFFFFFL & (long)arrn2[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >> 32) + ((0xFFFFFFFFL & (long)arrn[3]) - (0xFFFFFFFFL & (long)arrn2[3]));
        arrn3[3] = (int)l5;
        long l6 = (l5 >> 32) + ((0xFFFFFFFFL & (long)arrn[4]) - (0xFFFFFFFFL & (long)arrn2[4]));
        arrn3[4] = (int)l6;
        long l7 = (l6 >> 32) + ((0xFFFFFFFFL & (long)arrn[5]) - (0xFFFFFFFFL & (long)arrn2[5]));
        arrn3[5] = (int)l7;
        return (int)(l7 >> 32);
    }

    public static int sub3(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) - (0xFFFFFFFFL & (long)arrn2[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn[1]) - (0xFFFFFFFFL & (long)arrn2[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >> 32) + ((0xFFFFFFFFL & (long)arrn[2]) - (0xFFFFFFFFL & (long)arrn2[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >> 32) + ((0xFFFFFFFFL & (long)arrn[3]) - (0xFFFFFFFFL & (long)arrn2[3]));
        arrn3[3] = (int)l5;
        long l6 = (l5 >> 32) + ((0xFFFFFFFFL & (long)arrn[4]) - (0xFFFFFFFFL & (long)arrn2[4]));
        arrn3[4] = (int)l6;
        long l7 = (l6 >> 32) + ((0xFFFFFFFFL & (long)arrn[5]) - (0xFFFFFFFFL & (long)arrn2[5]));
        arrn3[5] = (int)l7;
        long l8 = (l7 >> 32) + ((0xFFFFFFFFL & (long)arrn[6]) - (0xFFFFFFFFL & (long)arrn2[6]));
        arrn3[6] = (int)l8;
        return (int)(l8 >> 32);
    }

    public static int sub4(int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn[0]) - (0xFFFFFFFFL & (long)arrn2[0]));
        arrn3[0] = (int)l2;
        long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn[1]) - (0xFFFFFFFFL & (long)arrn2[1]));
        arrn3[1] = (int)l3;
        long l4 = (l3 >> 32) + ((0xFFFFFFFFL & (long)arrn[2]) - (0xFFFFFFFFL & (long)arrn2[2]));
        arrn3[2] = (int)l4;
        long l5 = (l4 >> 32) + ((0xFFFFFFFFL & (long)arrn[3]) - (0xFFFFFFFFL & (long)arrn2[3]));
        arrn3[3] = (int)l5;
        long l6 = (l5 >> 32) + ((0xFFFFFFFFL & (long)arrn[4]) - (0xFFFFFFFFL & (long)arrn2[4]));
        arrn3[4] = (int)l6;
        long l7 = (l6 >> 32) + ((0xFFFFFFFFL & (long)arrn[5]) - (0xFFFFFFFFL & (long)arrn2[5]));
        arrn3[5] = (int)l7;
        long l8 = (l7 >> 32) + ((0xFFFFFFFFL & (long)arrn[6]) - (0xFFFFFFFFL & (long)arrn2[6]));
        arrn3[6] = (int)l8;
        long l9 = (l8 >> 32) + ((0xFFFFFFFFL & (long)arrn[7]) - (0xFFFFFFFFL & (long)arrn2[7]));
        arrn3[7] = (int)l9;
        return (int)(l9 >> 32);
    }

    public static int subFrom1(int[] arrn, int[] arrn2) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn2[0]) - (0xFFFFFFFFL & (long)arrn[0]));
        arrn2[0] = (int)l2;
        long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn2[1]) - (0xFFFFFFFFL & (long)arrn[1]));
        arrn2[1] = (int)l3;
        long l4 = (l3 >> 32) + ((0xFFFFFFFFL & (long)arrn2[2]) - (0xFFFFFFFFL & (long)arrn[2]));
        arrn2[2] = (int)l4;
        long l5 = (l4 >> 32) + ((0xFFFFFFFFL & (long)arrn2[3]) - (0xFFFFFFFFL & (long)arrn[3]));
        arrn2[3] = (int)l5;
        long l6 = (l5 >> 32) + ((0xFFFFFFFFL & (long)arrn2[4]) - (0xFFFFFFFFL & (long)arrn[4]));
        arrn2[4] = (int)l6;
        return (int)(l6 >> 32);
    }

    public static int subFrom2(int[] arrn, int[] arrn2) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn2[0]) - (0xFFFFFFFFL & (long)arrn[0]));
        arrn2[0] = (int)l2;
        long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn2[1]) - (0xFFFFFFFFL & (long)arrn[1]));
        arrn2[1] = (int)l3;
        long l4 = (l3 >> 32) + ((0xFFFFFFFFL & (long)arrn2[2]) - (0xFFFFFFFFL & (long)arrn[2]));
        arrn2[2] = (int)l4;
        long l5 = (l4 >> 32) + ((0xFFFFFFFFL & (long)arrn2[3]) - (0xFFFFFFFFL & (long)arrn[3]));
        arrn2[3] = (int)l5;
        long l6 = (l5 >> 32) + ((0xFFFFFFFFL & (long)arrn2[4]) - (0xFFFFFFFFL & (long)arrn[4]));
        arrn2[4] = (int)l6;
        long l7 = (l6 >> 32) + ((0xFFFFFFFFL & (long)arrn2[5]) - (0xFFFFFFFFL & (long)arrn[5]));
        arrn2[5] = (int)l7;
        return (int)(l7 >> 32);
    }

    public static int subFrom4(int[] arrn, int[] arrn2) {
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn2[0]) - (0xFFFFFFFFL & (long)arrn[0]));
        arrn2[0] = (int)l2;
        long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn2[1]) - (0xFFFFFFFFL & (long)arrn[1]));
        arrn2[1] = (int)l3;
        long l4 = (l3 >> 32) + ((0xFFFFFFFFL & (long)arrn2[2]) - (0xFFFFFFFFL & (long)arrn[2]));
        arrn2[2] = (int)l4;
        long l5 = (l4 >> 32) + ((0xFFFFFFFFL & (long)arrn2[3]) - (0xFFFFFFFFL & (long)arrn[3]));
        arrn2[3] = (int)l5;
        long l6 = (l5 >> 32) + ((0xFFFFFFFFL & (long)arrn2[4]) - (0xFFFFFFFFL & (long)arrn[4]));
        arrn2[4] = (int)l6;
        long l7 = (l6 >> 32) + ((0xFFFFFFFFL & (long)arrn2[5]) - (0xFFFFFFFFL & (long)arrn[5]));
        arrn2[5] = (int)l7;
        long l8 = (l7 >> 32) + ((0xFFFFFFFFL & (long)arrn2[6]) - (0xFFFFFFFFL & (long)arrn[6]));
        arrn2[6] = (int)l8;
        long l9 = (l8 >> 32) + ((0xFFFFFFFFL & (long)arrn2[7]) - (0xFFFFFFFFL & (long)arrn[7]));
        arrn2[7] = (int)l9;
        return (int)(l9 >> 32);
    }

    public static BigInteger toBigInteger1(int[] arrn) {
        byte[] arrby = new byte[20];
        for (int i2 = 0; i2 < 5; ++i2) {
            int n2 = arrn[i2];
            if (n2 == 0) continue;
            Nat576.intToBigEndian(n2, arrby, 4 - i2 << 2);
        }
        return new BigInteger(1, arrby);
    }

    public static BigInteger toBigInteger2(int[] arrn) {
        byte[] arrby = new byte[24];
        for (int i2 = 0; i2 < 6; ++i2) {
            int n2 = arrn[i2];
            if (n2 == 0) continue;
            Nat576.intToBigEndian(n2, arrby, 5 - i2 << 2);
        }
        return new BigInteger(1, arrby);
    }

    public static BigInteger toBigInteger3(int[] arrn) {
        byte[] arrby = new byte[28];
        for (int i2 = 0; i2 < 7; ++i2) {
            int n2 = arrn[i2];
            if (n2 == 0) continue;
            Nat576.intToBigEndian(n2, arrby, 6 - i2 << 2);
        }
        return new BigInteger(1, arrby);
    }

    public static BigInteger toBigInteger4(int[] arrn) {
        byte[] arrby = new byte[32];
        for (int i2 = 0; i2 < 8; ++i2) {
            int n2 = arrn[i2];
            if (n2 == 0) continue;
            Nat576.intToBigEndian(n2, arrby, 7 - i2 << 2);
        }
        return new BigInteger(1, arrby);
    }

    public static BigInteger toBigInteger641(long[] arrl) {
        byte[] arrby = new byte[24];
        for (int i2 = 0; i2 < 3; ++i2) {
            long l2 = arrl[i2];
            if (l2 == 0L) continue;
            Nat576.longToBigEndian(l2, arrby, 2 - i2 << 3);
        }
        return new BigInteger(1, arrby);
    }

    public static BigInteger toBigInteger642(long[] arrl) {
        byte[] arrby = new byte[32];
        for (int i2 = 0; i2 < 4; ++i2) {
            long l2 = arrl[i2];
            if (l2 == 0L) continue;
            Nat576.longToBigEndian(l2, arrby, 3 - i2 << 3);
        }
        return new BigInteger(1, arrby);
    }
}

