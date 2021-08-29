/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.ArithmeticException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Objects
 */
package org.bouncycastle.pqc.math.linearalgebra;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Objects;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;

public class PolynomialGF2mSmallM {
    public int[] coefficients;
    public int degree;
    public GF2mField field;

    public PolynomialGF2mSmallM(GF2mField gF2mField, int n2) {
        this.field = gF2mField;
        this.degree = n2;
        int[] arrn = new int[n2 + 1];
        this.coefficients = arrn;
        arrn[n2] = 1;
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, byte[] arrby) {
        int n2;
        this.field = gF2mField;
        int n3 = 1;
        for (n2 = 8; gF2mField.degree > n2; n2 += 8) {
            ++n3;
        }
        if (arrby.length % n3 == 0) {
            int[] arrn;
            this.coefficients = new int[arrby.length / n3];
            int n4 = 0;
            for (int i2 = 0; i2 < (arrn = this.coefficients).length; ++i2) {
                for (int i3 = 0; i3 < n2; i3 += 8) {
                    int[] arrn2 = this.coefficients;
                    int n5 = arrn2[i2];
                    int n6 = n4 + 1;
                    arrn2[i2] = n5 ^ (255 & arrby[n4]) << i3;
                    n4 = n6;
                }
                if (this.field.isElementOfThisField(this.coefficients[i2])) {
                    continue;
                }
                throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
            }
            if (arrn.length != 1 && arrn[arrn.length - 1] == 0) {
                throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
            }
            this.computeDegree();
            return;
        }
        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int[] arrn) {
        int[] arrn2;
        this.field = gF2mField;
        int n2 = PolynomialGF2mSmallM.computeDegree(arrn);
        if (n2 == -1) {
            arrn2 = new int[1];
        } else {
            int n3 = arrn.length;
            int n4 = n2 + 1;
            if (n3 == n4) {
                arrn2 = new int[arrn.length];
                System.arraycopy((Object)arrn, (int)0, (Object)arrn2, (int)0, (int)arrn.length);
            } else {
                int[] arrn3 = new int[n4];
                System.arraycopy((Object)arrn, (int)0, (Object)arrn3, (int)0, (int)n4);
                arrn2 = arrn3;
            }
        }
        this.coefficients = arrn2;
        this.computeDegree();
    }

    public PolynomialGF2mSmallM(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.field = polynomialGF2mSmallM.field;
        this.degree = polynomialGF2mSmallM.degree;
        this.coefficients = Nat576.clone(polynomialGF2mSmallM.coefficients);
    }

    public static int computeDegree(int[] arrn) {
        int n2;
        for (n2 = -1 + arrn.length; n2 >= 0 && arrn[n2] == 0; --n2) {
        }
        return n2;
    }

    public final int[] add(int[] arrn, int[] arrn2) {
        int[] arrn3;
        if (arrn.length < arrn2.length) {
            arrn3 = new int[arrn2.length];
            System.arraycopy((Object)arrn2, (int)0, (Object)arrn3, (int)0, (int)arrn2.length);
        } else {
            arrn3 = new int[arrn.length];
            System.arraycopy((Object)arrn, (int)0, (Object)arrn3, (int)0, (int)arrn.length);
            arrn = arrn2;
        }
        int n2 = arrn.length;
        while (--n2 >= 0) {
            GF2mField gF2mField = this.field;
            int n3 = arrn3[n2];
            int n4 = arrn[n2];
            Objects.requireNonNull((Object)gF2mField);
            arrn3[n2] = n3 ^ n4;
        }
        return arrn3;
    }

    public final void computeDegree() {
        int n2 = this.coefficients.length;
        while ((n2 = (this.degree = n2 - 1)) >= 0 && this.coefficients[n2] == 0) {
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object var1_1) {
        block5 : {
            if (var1_1 == null) return false;
            if (!(var1_1 instanceof PolynomialGF2mSmallM)) {
                return false;
            }
            var2_2 = (PolynomialGF2mSmallM)var1_1;
            if (this.field.equals(var2_2.field) == false) return false;
            if (this.degree != var2_2.degree) return false;
            var3_3 = this.coefficients;
            var4_4 = var2_2.coefficients;
            var5_5 = PolynomialGF2mSmallM.computeDegree(var3_3);
            if (var5_5 == PolynomialGF2mSmallM.computeDegree(var4_4)) {
            } else {
                do {
                    var7_6 = false;
                    break block5;
                    break;
                } while (true);
            }
            for (var6_7 = 0; var6_7 <= var5_5; ++var6_7) {
                if (var3_3[var6_7] != var4_4[var6_7]) ** continue;
            }
            var7_6 = true;
        }
        if (var7_6 == false) return false;
        return true;
    }

    public int getCoefficient(int n2) {
        if (n2 >= 0 && n2 <= this.degree) {
            return this.coefficients[n2];
        }
        return 0;
    }

    public int getDegree() {
        int[] arrn = this.coefficients;
        int n2 = -1 + arrn.length;
        if (arrn[n2] == 0) {
            return -1;
        }
        return n2;
    }

    public byte[] getEncoded() {
        int n2;
        int n3 = 1;
        for (n2 = 8; this.field.degree > n2; n2 += 8) {
            ++n3;
        }
        byte[] arrby = new byte[n3 * this.coefficients.length];
        int n4 = 0;
        for (int i2 = 0; i2 < this.coefficients.length; ++i2) {
            for (int i3 = 0; i3 < n2; i3 += 8) {
                int n5 = n4 + 1;
                arrby[n4] = (byte)(this.coefficients[i2] >>> i3);
                n4 = n5;
            }
        }
        return arrby;
    }

    public int hashCode() {
        int[] arrn;
        int n2 = this.field.polynomial;
        for (int i2 = 0; i2 < (arrn = this.coefficients).length; ++i2) {
            n2 = n2 * 31 + arrn[i2];
        }
        return n2;
    }

    public void multThisWithElement(int n2) {
        if (this.field.isElementOfThisField(n2)) {
            this.coefficients = this.multWithElement(this.coefficients, n2);
            this.computeDegree();
            return;
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public PolynomialGF2mSmallM multWithElement(int n2) {
        if (this.field.isElementOfThisField(n2)) {
            int[] arrn = this.multWithElement(this.coefficients, n2);
            return new PolynomialGF2mSmallM(this.field, arrn);
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public final int[] multWithElement(int[] arrn, int n2) {
        int n3 = PolynomialGF2mSmallM.computeDegree(arrn);
        if (n3 != -1 && n2 != 0) {
            if (n2 == 1) {
                int[] arrn2 = new int[arrn.length];
                System.arraycopy((Object)arrn, (int)0, (Object)arrn2, (int)0, (int)arrn.length);
                return arrn2;
            }
            int[] arrn3 = new int[n3 + 1];
            while (n3 >= 0) {
                arrn3[n3] = this.field.mult(arrn[n3], n2);
                --n3;
            }
            return arrn3;
        }
        return new int[1];
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)" Polynomial over ");
        stringBuilder.append(this.field.toString());
        stringBuilder.append(": \n");
        String string = stringBuilder.toString();
        for (int i2 = 0; i2 < this.coefficients.length; ++i2) {
            StringBuilder stringBuilder2 = GeneratedOutlineSupport.outline24((String)string);
            GF2mField gF2mField = this.field;
            int n2 = this.coefficients[i2];
            String string2 = "";
            for (int i3 = 0; i3 < gF2mField.degree; ++i3) {
                StringBuilder stringBuilder3;
                String string3;
                if ((1 & (byte)n2) == 0) {
                    stringBuilder3 = new StringBuilder();
                    string3 = "0";
                } else {
                    stringBuilder3 = new StringBuilder();
                    string3 = "1";
                }
                string2 = GeneratedOutlineSupport.outline21((StringBuilder)stringBuilder3, (String)string3, (String)string2);
                n2 >>>= 1;
            }
            stringBuilder2.append(string2);
            stringBuilder2.append("Y^");
            stringBuilder2.append(i2);
            stringBuilder2.append("+");
            string = stringBuilder2.toString();
        }
        return GeneratedOutlineSupport.outline18((String)string, (String)";");
    }
}

