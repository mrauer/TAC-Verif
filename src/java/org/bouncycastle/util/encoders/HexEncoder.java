/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 */
package org.bouncycastle.util.encoders;

import java.io.IOException;

public class HexEncoder {
    public final byte[] decodingTable = new byte[128];
    public final byte[] encodingTable = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    public HexEncoder() {
        byte[] arrby;
        int n2 = 0;
        do {
            byte[] arrby2 = this.decodingTable;
            int n3 = arrby2.length;
            if (n2 >= n3) break;
            arrby2[n2] = -1;
            ++n2;
        } while (true);
        for (int i2 = 0; i2 < (arrby = this.encodingTable).length; ++i2) {
            this.decodingTable[arrby[i2]] = (byte)i2;
        }
        byte[] arrby3 = this.decodingTable;
        arrby3[65] = arrby3[97];
        arrby3[66] = arrby3[98];
        arrby3[67] = arrby3[99];
        arrby3[68] = arrby3[100];
        arrby3[69] = arrby3[101];
        arrby3[70] = arrby3[102];
    }

    public byte[] decodeStrict(String string, int n2, int n3) throws IOException {
        if (n2 >= 0 && n3 >= 0 && n2 <= string.length() - n3) {
            if ((n3 & 1) == 0) {
                int n4 = n3 >>> 1;
                byte[] arrby = new byte[n4];
                for (int i2 = 0; i2 < n4; ++i2) {
                    byte[] arrby2 = this.decodingTable;
                    int n5 = n2 + 1;
                    byte by = arrby2[string.charAt(n2)];
                    byte[] arrby3 = this.decodingTable;
                    int n6 = n5 + 1;
                    int n7 = arrby3[string.charAt(n5)] | by << 4;
                    if (n7 >= 0) {
                        arrby[i2] = (byte)n7;
                        n2 = n6;
                        continue;
                    }
                    throw new IOException("invalid characters encountered in Hex string");
                }
                return arrby;
            }
            throw new IOException("a hexadecimal encoding must have an even number of characters");
        }
        throw new IndexOutOfBoundsException("invalid offset and/or length specified");
    }
}

