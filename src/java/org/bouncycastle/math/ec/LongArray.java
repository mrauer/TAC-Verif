/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Cloneable
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.System
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;

public class LongArray
implements Cloneable {
    public static final short[] INTERLEAVE2_TABLE = new short[]{0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, 1024, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, 16384, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};
    public static final byte[] bitLengths = new byte[]{0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
    public long[] m_ints;

    public LongArray(int n2) {
        this.m_ints = new long[n2];
    }

    public LongArray(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            int n2;
            if (bigInteger.signum() == 0) {
                this.m_ints = new long[]{0L};
                return;
            }
            byte[] arrby = bigInteger.toByteArray();
            int n3 = arrby.length;
            if (arrby[0] == 0) {
                --n3;
                n2 = 1;
            } else {
                n2 = 0;
            }
            int n4 = (n3 + 7) / 8;
            this.m_ints = new long[n4];
            int n5 = n4 - 1;
            int n6 = n2 + n3 % 8;
            if (n2 < n6) {
                long l2 = 0L;
                while (n2 < n6) {
                    l2 = l2 << 8 | (long)(255 & arrby[n2]);
                    ++n2;
                }
                long[] arrl = this.m_ints;
                int n7 = n5 - 1;
                arrl[n5] = l2;
                n5 = n7;
            }
            while (n5 >= 0) {
                long l3 = 0L;
                for (int i2 = 0; i2 < 8; ++i2) {
                    long l4 = l3 << 8;
                    int n8 = n2 + 1;
                    l3 = l4 | (long)(255 & arrby[n2]);
                    n2 = n8;
                }
                this.m_ints[n5] = l3;
                --n5;
            }
            return;
        }
        throw new IllegalArgumentException("invalid F2m field value");
    }

    public LongArray(long[] arrl) {
        this.m_ints = arrl;
    }

    public LongArray(long[] arrl, int n2, int n3) {
        if (n2 == 0 && n3 == arrl.length) {
            this.m_ints = arrl;
            return;
        }
        long[] arrl2 = new long[n3];
        this.m_ints = arrl2;
        System.arraycopy((Object)arrl, (int)n2, (Object)arrl2, (int)0, (int)n3);
    }

    public static void add(long[] arrl, int n2, long[] arrl2, int n3, int n4) {
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = n2 + i2;
            arrl[n5] = arrl[n5] ^ arrl2[n3 + i2];
        }
    }

    public static void add(long[] arrl, int n2, long[] arrl2, int n3, long[] arrl3, int n4, int n5) {
        for (int i2 = 0; i2 < n5; ++i2) {
            arrl3[n4 + i2] = arrl[n2 + i2] ^ arrl2[n3 + i2];
        }
    }

    public static void addBoth(long[] arrl, int n2, long[] arrl2, int n3, long[] arrl3, int n4, int n5) {
        for (int i2 = 0; i2 < n5; ++i2) {
            int n6 = n2 + i2;
            arrl[n6] = arrl[n6] ^ (arrl2[n3 + i2] ^ arrl3[n4 + i2]);
        }
    }

    public static long addShiftedUp(long[] arrl, int n2, long[] arrl2, int n3, int n4, int n5) {
        int n6 = 64 - n5;
        long l2 = 0L;
        for (int i2 = 0; i2 < n4; ++i2) {
            long l3 = arrl2[n3 + i2];
            int n7 = n2 + i2;
            arrl[n7] = arrl[n7] ^ (l2 | l3 << n5);
            l2 = l3 >>> n6;
        }
        return l2;
    }

    public static int bitLength(long l2) {
        int n2;
        int n3;
        int n4;
        int n5 = 32;
        int n6 = (int)(l2 >>> n5);
        if (n6 == 0) {
            n6 = (int)l2;
            n5 = 0;
        }
        int n7 = (n2 = n6 >>> 16) == 0 ? ((n3 = n6 >>> 8) == 0 ? bitLengths[n6] : 8 + bitLengths[n3]) : ((n4 = n2 >>> 8) == 0 ? 16 + bitLengths[n2] : 24 + bitLengths[n4]);
        return n5 + n7;
    }

    public static void flipBit(long[] arrl, int n2, int n3) {
        int n4 = n3 >>> 6;
        long l2 = 1L << (n3 & 63);
        int n5 = n2 + n4;
        arrl[n5] = l2 ^ arrl[n5];
    }

    public static void flipVector(long[] arrl, int n2, long[] arrl2, int n3, int n4, int n5) {
        int n6 = n2 + (n5 >>> 6);
        int n7 = n5 & 63;
        int n8 = n4;
        if (n7 == 0) {
            LongArray.add(arrl, n6, arrl2, n3, n8);
            return;
        }
        int n9 = n6 + 1;
        int n10 = 64 - n7;
        int n11 = 64 - n10;
        long l2 = 0L;
        while (--n8 >= 0) {
            long l3 = arrl2[n3 + n8];
            int n12 = n9 + n8;
            arrl[n12] = arrl[n12] ^ (l2 | l3 >>> n10);
            l2 = l3 << n11;
        }
        arrl[n6] = l2 ^ arrl[n6];
    }

    public static void flipWord(long[] arrl, int n2, int n3, long l2) {
        int n4 = n2 + (n3 >>> 6);
        int n5 = n3 & 63;
        if (n5 == 0) {
            arrl[n4] = l2 ^ arrl[n4];
            return;
        }
        arrl[n4] = arrl[n4] ^ l2 << n5;
        long l3 = l2 >>> 64 - n5;
        if (l3 != 0L) {
            int n6 = n4 + 1;
            arrl[n6] = l3 ^ arrl[n6];
        }
    }

    public static long interleave2_32to64(int n2) {
        short[] arrs = INTERLEAVE2_TABLE;
        int n3 = arrs[n2 & 255] | arrs[255 & n2 >>> 8] << 16;
        return (0xFFFFFFFFL & (long)(arrs[255 & n2 >>> 16] | arrs[n2 >>> 24] << 16)) << 32 | 0xFFFFFFFFL & (long)n3;
    }

    public static void multiplyWord(long l2, long[] arrl, int n2, long[] arrl2, int n3) {
        long l3;
        if ((l2 & 1L) != 0L) {
            LongArray.add(arrl2, n3, arrl, 0, n2);
        }
        long l4 = l2;
        int n4 = 1;
        while ((l3 = l4 >>> 1) != 0L) {
            long l5;
            if ((l3 & 1L) != 0L && (l5 = LongArray.addShiftedUp(arrl2, n3, arrl, 0, n2, n4)) != 0L) {
                int n5 = n3 + n2;
                arrl2[n5] = l5 ^ arrl2[n5];
            }
            ++n4;
            l4 = l3;
        }
    }

    public static void reduceBit(long[] arrl, int n2, int n3, int n4, int[] arrn) {
        LongArray.flipBit(arrl, n2, n3);
        int n5 = n3 - n4;
        int n6 = arrn.length;
        while (--n6 >= 0) {
            LongArray.flipBit(arrl, n2, n5 + arrn[n6]);
        }
        LongArray.flipBit(arrl, n2, n5);
    }

    public static int reduceInPlace(long[] arrl, int n2, int n3, int n4, int[] arrn) {
        int n5;
        int n6 = n4 + 63 >>> 6;
        if (n3 < n6) {
            return n3;
        }
        int n7 = n3 << 6;
        int n8 = Math.min((int)n7, (int)((n4 << 1) - 1));
        int n9 = n3;
        for (n5 = n7 - n8; n5 >= 64; n5 -= 64) {
            --n9;
        }
        int n10 = arrn.length;
        int n11 = arrn[n10 - 1];
        int n12 = n10 > 1 ? arrn[n10 - 2] : 0;
        int n13 = Math.max((int)n4, (int)(n11 + 64));
        int n14 = n5 + Math.min((int)(n8 - n13), (int)(n4 - n12)) >> 6;
        if (n14 > 1) {
            int n15;
            int n16 = n9 - n14;
            int n17 = n16 << 6;
            int n18 = n17 - n4;
            int n19 = arrn.length;
            while ((n15 = n19 - 1) >= 0) {
                int n20 = n2 + n16;
                int n21 = n9 - n16;
                int n22 = n18 + arrn[n15];
                int n23 = n16;
                LongArray.flipVector(arrl, n2, arrl, n20, n21, n22);
                n16 = n23;
                n19 = n15;
            }
            int n24 = n16;
            LongArray.flipVector(arrl, n2, arrl, n2 + n24, n9 - n24, n18);
            while (n9 > n24) {
                arrl[n2 + --n9] = 0L;
            }
            n8 = n17;
        }
        if (n8 > n13) {
            int n25 = n13 >>> 6;
            while (--n9 > n25) {
                int n26 = n2 + n9;
                long l2 = arrl[n26];
                if (l2 == 0L) continue;
                arrl[n26] = 0L;
                int n27 = (n9 << 6) - n4;
                int n28 = arrn.length;
                while (--n28 >= 0) {
                    LongArray.flipWord(arrl, n2, n27 + arrn[n28], l2);
                }
                LongArray.flipWord(arrl, n2, n27, l2);
            }
            int n29 = n25 + n2;
            int n30 = n13 & 63;
            long l3 = arrl[n29] >>> n30;
            if (l3 != 0L) {
                arrl[n29] = arrl[n29] ^ l3 << n30;
                int n31 = n13 - n4;
                int n32 = arrn.length;
                while (--n32 >= 0) {
                    LongArray.flipWord(arrl, n2, n31 + arrn[n32], l3);
                }
                LongArray.flipWord(arrl, n2, n31, l3);
            }
        } else {
            n13 = n8;
        }
        if (n13 > n4) {
            while (--n13 >= n4) {
                int n33 = n13 >>> 6;
                boolean bl = (1L << (n13 & 63) & arrl[n33 + n2]) != 0L;
                if (!bl) continue;
                LongArray.reduceBit(arrl, n2, n13, n4, arrn);
            }
        }
        return n6;
    }

    public static long shiftUp(long[] arrl, int n2, long[] arrl2, int n3, int n4, int n5) {
        int n6 = 64 - n5;
        long l2 = 0L;
        for (int i2 = 0; i2 < n4; ++i2) {
            long l3 = arrl[n2 + i2];
            arrl2[n3 + i2] = l2 | l3 << n5;
            l2 = l3 >>> n6;
        }
        return l2;
    }

    public final void addShiftedByBitsSafe(LongArray longArray, int n2, int n3) {
        int n4 = n2 + 63 >>> 6;
        int n5 = n3 >>> 6;
        int n6 = n3 & 63;
        if (n6 == 0) {
            LongArray.add(this.m_ints, n5, longArray.m_ints, 0, n4);
            return;
        }
        long l2 = LongArray.addShiftedUp(this.m_ints, n5, longArray.m_ints, 0, n4, n6);
        if (l2 != 0L) {
            long[] arrl = this.m_ints;
            int n7 = n4 + n5;
            arrl[n7] = l2 ^ arrl[n7];
        }
    }

    public void addShiftedByWords(LongArray longArray, int n2) {
        int n3 = longArray.getUsedLength();
        if (n3 == 0) {
            return;
        }
        int n4 = n3 + n2;
        long[] arrl = this.m_ints;
        if (n4 > arrl.length) {
            long[] arrl2 = new long[n4];
            System.arraycopy((Object)arrl, (int)0, (Object)arrl2, (int)0, (int)Math.min((int)arrl.length, (int)n4));
            this.m_ints = arrl2;
        }
        LongArray.add(this.m_ints, n2, longArray.m_ints, 0, n3);
    }

    public Object clone() {
        long[] arrl = this.m_ints;
        long[] arrl2 = arrl == null ? null : (long[])arrl.clone();
        return new LongArray(arrl2);
    }

    public int degree() {
        long l2;
        long[] arrl;
        int n2 = this.m_ints.length;
        do {
            if (n2 != 0) continue;
            return 0;
        } while ((l2 = (arrl = this.m_ints)[--n2]) == 0L);
        return (n2 << 6) + LongArray.bitLength(l2);
    }

    public final int degreeFrom(int n2) {
        long[] arrl;
        long l2;
        int n3 = n2 + 62 >>> 6;
        do {
            if (n3 != 0) continue;
            return 0;
        } while ((l2 = (arrl = this.m_ints)[--n3]) == 0L);
        return (n3 << 6) + LongArray.bitLength(l2);
    }

    public boolean equals(Object object) {
        if (!(object instanceof LongArray)) {
            return false;
        }
        LongArray longArray = (LongArray)object;
        int n2 = this.getUsedLength();
        if (longArray.getUsedLength() != n2) {
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.m_ints[i2] == longArray.m_ints[i2]) continue;
            return false;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int getUsedLength() {
        long[] arrl = this.m_ints;
        int n2 = Math.min((int)arrl.length, (int)arrl.length);
        if (n2 < 1) {
            return 0;
        }
        if (arrl[0] != 0L) {
            while (arrl[--n2] == 0L) {
            }
            return n2 + 1;
        }
        do {
            if (arrl[--n2] == 0L) continue;
            return n2 + 1;
        } while (n2 > 0);
        return 0;
    }

    public int hashCode() {
        int n2 = this.getUsedLength();
        int n3 = 1;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l2 = this.m_ints[i2];
            n3 = 31 * (n3 * 31 ^ (int)l2) ^ (int)(l2 >>> 32);
        }
        return n3;
    }

    public boolean isOne() {
        long[] arrl = this.m_ints;
        if (arrl[0] != 1L) {
            return false;
        }
        for (int i2 = 1; i2 < arrl.length; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    public boolean isZero() {
        long[] arrl = this.m_ints;
        for (int i2 = 0; i2 < arrl.length; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    public LongArray multiply(LongArray longArray) {
        int n2;
        LongArray longArray2;
        int n3;
        LongArray longArray3;
        int n4 = this.degree();
        if (n4 == 0) {
            return this;
        }
        int n5 = longArray.degree();
        if (n5 == 0) {
            return longArray;
        }
        if (n4 > n5) {
            n3 = n4;
            n2 = n5;
            longArray2 = this;
            longArray3 = longArray;
        } else {
            n2 = n4;
            n3 = n5;
            longArray3 = this;
            longArray2 = longArray;
        }
        int n6 = n2 + 63 >>> 6;
        int n7 = n3 + 63 >>> 6;
        int n8 = 62 + (n2 + n3) >>> 6;
        if (n6 == 1) {
            long l2 = longArray3.m_ints[0];
            if (l2 == 1L) {
                return longArray2;
            }
            long[] arrl = new long[n8];
            LongArray.multiplyWord(l2, longArray2.m_ints, n7, arrl, 0);
            return new LongArray(arrl, 0, n8);
        }
        int n9 = 63 + (n3 + 7) >>> 6;
        int n10 = 16;
        int[] arrn = new int[n10];
        int n11 = n9 << 4;
        long[] arrl = new long[n11];
        arrn[1] = n9;
        System.arraycopy((Object)longArray2.m_ints, (int)0, (Object)arrl, (int)n9, (int)n7);
        int n12 = n9;
        for (int i2 = 2; i2 < n10; ++i2) {
            int n13;
            long[] arrl2;
            arrn[i2] = n12 += n9;
            if ((i2 & 1) == 0) {
                int n14 = n12 >>> 1;
                long[] arrl3 = arrl;
                long[] arrl4 = arrl;
                int n15 = n12;
                arrl2 = arrl;
                n13 = n11;
                LongArray.shiftUp(arrl3, n14, arrl4, n15, n9, 1);
            } else {
                arrl2 = arrl;
                n13 = n11;
                int n16 = n12 - n9;
                LongArray.add(arrl2, n9, arrl2, n16, arrl, n12, n9);
            }
            n11 = n13;
            arrl = arrl2;
            n10 = 16;
        }
        long[] arrl5 = arrl;
        int n17 = n11;
        long[] arrl6 = new long[n17];
        LongArray.shiftUp(arrl5, 0, arrl6, 0, n17, 4);
        long[] arrl7 = longArray3.m_ints;
        int n18 = n8 << 3;
        long[] arrl8 = new long[n18];
        block1 : for (int i3 = 0; i3 < n6; ++i3) {
            long l3 = arrl7[i3];
            int n19 = i3;
            do {
                int n20 = 15 & (int)l3;
                long l4 = l3 >>> 4;
                int n21 = 15 & (int)l4;
                int n22 = arrn[n20];
                int n23 = arrn[n21];
                LongArray.addBoth(arrl8, n19, arrl5, n22, arrl6, n23, n9);
                l3 = l4 >>> 4;
                if (l3 == 0L) {
                    continue block1;
                }
                n19 += n8;
            } while (true);
        }
        while ((n18 -= n8) != 0) {
            LongArray.addShiftedUp(arrl8, n18 - n8, arrl8, n18, n8, 8);
        }
        return new LongArray(arrl8, 0, n8);
    }

    public void reduce(int n2, int[] arrn) {
        long[] arrl = this.m_ints;
        int n3 = LongArray.reduceInPlace(arrl, 0, arrl.length, n2, arrn);
        if (n3 < arrl.length) {
            long[] arrl2 = new long[n3];
            this.m_ints = arrl2;
            System.arraycopy((Object)arrl, (int)0, (Object)arrl2, (int)0, (int)n3);
        }
    }

    public String toString() {
        int n2 = this.getUsedLength();
        if (n2 == 0) {
            return "0";
        }
        long[] arrl = this.m_ints;
        int n3 = n2 - 1;
        StringBuffer stringBuffer = new StringBuffer(Long.toBinaryString((long)arrl[n3]));
        while (--n3 >= 0) {
            String string = Long.toBinaryString((long)this.m_ints[n3]);
            int n4 = string.length();
            if (n4 < 64) {
                stringBuffer.append("0000000000000000000000000000000000000000000000000000000000000000".substring(n4));
            }
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }
}

