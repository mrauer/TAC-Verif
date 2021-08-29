/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.bouncycastle.pqc.math.linearalgebra;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.math.linearalgebra.IntegerFunctions;

public class Permutation {
    public int[] perm;

    public Permutation(byte[] arrby) {
        if (arrby.length > 4) {
            int n2;
            int n3 = Nat576.OS2IP(arrby, 0);
            if (arrby.length == 4 + n3 * (n2 = IntegerFunctions.ceilLog256(n3 - 1))) {
                boolean bl;
                block7 : {
                    this.perm = new int[n3];
                    for (int i2 = 0; i2 < n3; ++i2) {
                        int[] arrn = this.perm;
                        int n4 = 4 + i2 * n2;
                        int n5 = 0;
                        for (int i3 = n2 - 1; i3 >= 0; --i3) {
                            n5 |= (255 & arrby[n4 + i3]) << i3 * 8;
                        }
                        arrn[i2] = n5;
                    }
                    int[] arrn = this.perm;
                    int n6 = arrn.length;
                    boolean[] arrbl = new boolean[n6];
                    for (int i4 = 0; i4 < n6; ++i4) {
                        int n7 = arrn[i4];
                        bl = false;
                        if (n7 < 0) break block7;
                        int n8 = arrn[i4];
                        bl = false;
                        if (n8 >= n6) break block7;
                        if (arrbl[arrn[i4]]) {
                            bl = false;
                            break block7;
                        }
                        arrbl[arrn[i4]] = true;
                    }
                    bl = true;
                }
                if (bl) {
                    return;
                }
                throw new IllegalArgumentException("invalid encoding");
            }
            throw new IllegalArgumentException("invalid encoding");
        }
        throw new IllegalArgumentException("invalid encoding");
    }

    public boolean equals(Object object) {
        if (!(object instanceof Permutation)) {
            return false;
        }
        Permutation permutation = (Permutation)object;
        return Nat576.equals(this.perm, permutation.perm);
    }

    public byte[] getEncoded() {
        int n2 = this.perm.length;
        int n3 = IntegerFunctions.ceilLog256(n2 - 1);
        byte[] arrby = new byte[4 + n2 * n3];
        Nat576.I2OSP(n2, arrby, 0);
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = this.perm[i2];
            int n5 = 4 + i2 * n3;
            for (int i3 = n3 - 1; i3 >= 0; --i3) {
                arrby[n5 + i3] = (byte)(n4 >>> i3 * 8);
            }
        }
        return arrby;
    }

    public int hashCode() {
        return Nat576.hashCode(this.perm);
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"[");
        stringBuilder.append(this.perm[0]);
        String string = stringBuilder.toString();
        for (int i2 = 1; i2 < this.perm.length; ++i2) {
            StringBuilder stringBuilder2 = GeneratedOutlineSupport.outline26((String)string, (String)", ");
            stringBuilder2.append(this.perm[i2]);
            string = stringBuilder2.toString();
        }
        return GeneratedOutlineSupport.outline18((String)string, (String)"]");
    }
}

