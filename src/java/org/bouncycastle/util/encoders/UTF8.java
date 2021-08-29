/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.util.encoders;

public class UTF8 {
    public static final short[] firstUnitTable = new short[128];
    public static final byte[] transitionTable;

    public static {
        byte[] arrby = new byte[112];
        transitionTable = arrby;
        byte[] arrby2 = new byte[128];
        UTF8.fill(arrby2, 0, 15, (byte)1);
        UTF8.fill(arrby2, 16, 31, (byte)2);
        UTF8.fill(arrby2, 32, 63, (byte)3);
        UTF8.fill(arrby2, 64, 65, (byte)0);
        UTF8.fill(arrby2, 66, 95, (byte)4);
        UTF8.fill(arrby2, 96, 96, (byte)5);
        UTF8.fill(arrby2, 97, 108, (byte)6);
        UTF8.fill(arrby2, 109, 109, (byte)7);
        UTF8.fill(arrby2, 110, 111, (byte)6);
        UTF8.fill(arrby2, 112, 112, (byte)8);
        UTF8.fill(arrby2, 113, 115, (byte)9);
        UTF8.fill(arrby2, 116, 116, (byte)10);
        UTF8.fill(arrby2, 117, 127, (byte)0);
        UTF8.fill(arrby, 0, arrby.length - 1, (byte)-2);
        UTF8.fill(arrby, 8, 11, (byte)-1);
        UTF8.fill(arrby, 24, 27, (byte)0);
        UTF8.fill(arrby, 40, 43, (byte)16);
        UTF8.fill(arrby, 58, 59, (byte)0);
        UTF8.fill(arrby, 72, 73, (byte)0);
        UTF8.fill(arrby, 89, 91, (byte)16);
        UTF8.fill(arrby, 104, 104, (byte)16);
        byte[] arrby3 = new byte[]{0, 0, 0, 0, 31, 15, 15, 15, 7, 7, 7};
        byte[] arrby4 = new byte[]{-2, -2, -2, -2, 0, 48, 16, 64, 80, 32, 96};
        for (int i2 = 0; i2 < 128; ++i2) {
            byte by = arrby2[i2];
            int n2 = i2 & arrby3[by];
            byte by2 = arrby4[by];
            UTF8.firstUnitTable[i2] = (short)(by2 | n2 << 8);
        }
    }

    public static void fill(byte[] arrby, int n2, int n3, byte by) {
        while (n2 <= n3) {
            arrby[n2] = by;
            ++n2;
        }
    }
}

