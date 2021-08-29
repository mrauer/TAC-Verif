/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  I
 *  java.lang.ArithmeticException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.reflect.Array
 */
package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import org.bouncycastle.math.raw.Nat576;

public class GF2Matrix {
    public int length;
    public int[][] matrix;
    public int numColumns;
    public int numRows;

    public GF2Matrix(int n2, int[][] arrn) {
        int n3 = 0;
        if (arrn[0].length == n2 + 31 >> 5) {
            int n4;
            this.numColumns = n2;
            this.numRows = arrn.length;
            this.length = arrn[0].length;
            int n5 = n2 & 31;
            if (n5 == 0) {
                n4 = -1;
                n3 = 0;
            } else {
                n4 = (1 << n5) - 1;
            }
            while (n3 < this.numRows) {
                int[] arrn2 = arrn[n3];
                int n6 = this.length - 1;
                arrn2[n6] = n4 & arrn2[n6];
                ++n3;
            }
            this.matrix = arrn;
            return;
        }
        throw new ArithmeticException("Int array does not match given number of columns.");
    }

    public GF2Matrix(GF2Matrix gF2Matrix) {
        int[][] arrn;
        this.numColumns = gF2Matrix.numColumns;
        this.numRows = gF2Matrix.numRows;
        this.length = gF2Matrix.length;
        this.matrix = new int[gF2Matrix.matrix.length][];
        for (int i2 = 0; i2 < (arrn = this.matrix).length; ++i2) {
            arrn[i2] = Nat576.clone(gF2Matrix.matrix[i2]);
        }
    }

    public GF2Matrix(byte[] arrby) {
        if (arrby.length >= 9) {
            int n2;
            int n3;
            int n4;
            this.numRows = Nat576.OS2IP(arrby, 0);
            this.numColumns = n4 = Nat576.OS2IP(arrby, 4);
            int n5 = n4 + 7 >>> 3;
            int n6 = this.numRows;
            int n7 = n5 * n6;
            if (n6 > 0 && n7 == (n3 = arrby.length) - (n2 = 8)) {
                int n8;
                this.length = n8 = n4 + 31 >>> 5;
                int[] arrn = new int[2];
                arrn[1] = n8;
                arrn[0] = n6;
                this.matrix = (int[][])Array.newInstance(I.class, (int[])arrn);
                int n9 = this.numColumns;
                int n10 = n9 >> 5;
                int n11 = n9 & 31;
                for (int i2 = 0; i2 < this.numRows; ++i2) {
                    int n12 = 0;
                    while (n12 < n10) {
                        this.matrix[i2][n12] = Nat576.OS2IP(arrby, n2);
                        ++n12;
                        n2 += 4;
                    }
                    for (int i3 = 0; i3 < n11; i3 += 8) {
                        int[] arrn2 = this.matrix[i2];
                        int n13 = arrn2[n10];
                        int n14 = n2 + 1;
                        arrn2[n10] = n13 ^ (255 & arrby[n2]) << i3;
                        n2 = n14;
                    }
                }
                return;
            }
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    public boolean equals(Object object) {
        if (!(object instanceof GF2Matrix)) {
            return false;
        }
        GF2Matrix gF2Matrix = (GF2Matrix)object;
        if (this.numRows == gF2Matrix.numRows && this.numColumns == gF2Matrix.numColumns) {
            if (this.length != gF2Matrix.length) {
                return false;
            }
            for (int i2 = 0; i2 < this.numRows; ++i2) {
                if (Nat576.equals(this.matrix[i2], gF2Matrix.matrix[i2])) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public byte[] getEncoded() {
        int n2 = 7 + this.numColumns >>> 3;
        int n3 = this.numRows;
        int n4 = n2 * n3;
        int n5 = 8;
        byte[] arrby = new byte[n4 + n5];
        Nat576.I2OSP(n3, arrby, 0);
        Nat576.I2OSP(this.numColumns, arrby, 4);
        int n6 = this.numColumns;
        int n7 = n6 >>> 5;
        int n8 = n6 & 31;
        for (int i2 = 0; i2 < this.numRows; ++i2) {
            int n9 = 0;
            while (n9 < n7) {
                Nat576.I2OSP(this.matrix[i2][n9], arrby, n5);
                ++n9;
                n5 += 4;
            }
            for (int i3 = 0; i3 < n8; i3 += 8) {
                int n10 = n5 + 1;
                arrby[n5] = (byte)(255 & this.matrix[i2][n7] >>> i3);
                n5 = n10;
            }
        }
        return arrby;
    }

    public int hashCode() {
        int n2 = 31 * (31 * this.numRows + this.numColumns) + this.length;
        for (int i2 = 0; i2 < this.numRows; ++i2) {
            n2 = n2 * 31 + Nat576.hashCode(this.matrix[i2]);
        }
        return n2;
    }

    public String toString() {
        int n2 = 31 & this.numColumns;
        int n3 = this.length;
        if (n2 != 0) {
            --n3;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.numRows; ++i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i2);
            stringBuilder.append(": ");
            stringBuffer.append(stringBuilder.toString());
            for (int i3 = 0; i3 < n3; ++i3) {
                int n4 = this.matrix[i2][i3];
                for (int i4 = 0; i4 < 32; ++i4) {
                    if ((1 & n4 >>> i4) == 0) {
                        stringBuffer.append('0');
                        continue;
                    }
                    stringBuffer.append('1');
                }
                stringBuffer.append(' ');
            }
            int n5 = this.matrix[i2][-1 + this.length];
            for (int i5 = 0; i5 < n2; ++i5) {
                if ((1 & n5 >>> i5) == 0) {
                    stringBuffer.append('0');
                    continue;
                }
                stringBuffer.append('1');
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }
}

