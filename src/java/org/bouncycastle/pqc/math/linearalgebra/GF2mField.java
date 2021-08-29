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

public class GF2mField {
    public int degree = 0;
    public int polynomial;

    public GF2mField(byte[] arrby) {
        if (arrby.length == 4) {
            boolean bl;
            block6 : {
                int n2;
                int n3 = 255 & arrby[0] | (255 & arrby[1]) << 8;
                int n4 = 2;
                this.polynomial = n2 = n3 | (255 & arrby[n4]) << 16 | (255 & arrby[3]) << 24;
                if (n2 == 0) {
                    bl = false;
                } else {
                    int n5 = Nat576.degree(n2) >>> 1;
                    for (int i2 = 0; i2 < n5; ++i2) {
                        n4 = Nat576.modMultiply(n4, n4, n2);
                        int n6 = n4 ^ 2;
                        int n7 = n2;
                        while (n7 != 0) {
                            int n8 = Nat576.remainder(n6, n7);
                            n6 = n7;
                            n7 = n8;
                        }
                        if (n6 == 1) continue;
                        bl = false;
                        break block6;
                    }
                    bl = true;
                }
            }
            if (bl) {
                this.degree = Nat576.degree(this.polynomial);
                return;
            }
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    }

    public boolean equals(Object object) {
        if (object != null) {
            if (!(object instanceof GF2mField)) {
                return false;
            }
            GF2mField gF2mField = (GF2mField)object;
            if (this.degree == gF2mField.degree && this.polynomial == gF2mField.polynomial) {
                return true;
            }
        }
        return false;
    }

    public byte[] getEncoded() {
        int n2 = this.polynomial;
        byte[] arrby = new byte[]{(byte)n2, (byte)(n2 >>> 8), (byte)(n2 >>> 16), (byte)(n2 >>> 24)};
        return arrby;
    }

    public int hashCode() {
        return this.polynomial;
    }

    public int inverse(int n2) {
        int n3 = -2 + (1 << this.degree);
        if (n3 == 0) {
            return 1;
        }
        if (n2 == 0) {
            return 0;
        }
        if (n2 == 1) {
            return 1;
        }
        if (n3 < 0) {
            n2 = this.inverse(n2);
            n3 = -n3;
        }
        int n4 = 1;
        while (n3 != 0) {
            if ((n3 & 1) == 1) {
                n4 = this.mult(n4, n2);
            }
            n2 = this.mult(n2, n2);
            n3 >>>= 1;
        }
        return n4;
    }

    public boolean isElementOfThisField(int n2) {
        int n3 = this.degree;
        if (n3 == 31) {
            boolean bl = false;
            if (n2 >= 0) {
                bl = true;
            }
            return bl;
        }
        boolean bl = false;
        if (n2 >= 0) {
            int n4 = 1 << n3;
            bl = false;
            if (n2 < n4) {
                bl = true;
            }
        }
        return bl;
    }

    public int mult(int n2, int n3) {
        return Nat576.modMultiply(n2, n3, this.polynomial);
    }

    public String toString() {
        String string;
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Finite Field GF(2^");
        stringBuilder.append(this.degree);
        stringBuilder.append(") = GF(2)[X]/<");
        int n2 = this.polynomial;
        if (n2 == 0) {
            string = "0";
        } else {
            String string2 = (byte)(n2 & 1) == 1 ? "1" : "";
            int n3 = n2 >>> 1;
            int n4 = 1;
            while (n3 != 0) {
                if ((byte)(n3 & 1) == 1) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(string2);
                    stringBuilder2.append("+x^");
                    stringBuilder2.append(n4);
                    string2 = stringBuilder2.toString();
                }
                n3 >>>= 1;
                ++n4;
            }
            string = string2;
        }
        return GeneratedOutlineSupport.outline21((StringBuilder)stringBuilder, (String)string, (String)"> ");
    }
}

