/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ArithmeticException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package org.bouncycastle.pqc.math.linearalgebra;

import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class PolynomialRingGF2m {
    public GF2mField field;
    public PolynomialGF2mSmallM p;
    public PolynomialGF2mSmallM[] sqMatrix;
    public PolynomialGF2mSmallM[] sqRootMatrix;

    public PolynomialRingGF2m(GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int n2;
        int n3;
        this.field = gF2mField;
        this.p = polynomialGF2mSmallM;
        int n4 = polynomialGF2mSmallM.getDegree();
        this.sqMatrix = new PolynomialGF2mSmallM[n4];
        for (int i2 = 0; i2 < (n3 = n4 >> 1); ++i2) {
            int n5 = i2 << 1;
            int[] arrn = new int[n5 + 1];
            arrn[n5] = 1;
            this.sqMatrix[i2] = new PolynomialGF2mSmallM(this.field, arrn);
        }
        while (n3 < n4) {
            int n6 = n3 << 1;
            int[] arrn = new int[n6 + 1];
            arrn[n6] = 1;
            PolynomialGF2mSmallM polynomialGF2mSmallM2 = new PolynomialGF2mSmallM(this.field, arrn);
            PolynomialGF2mSmallM[] arrpolynomialGF2mSmallM = this.sqMatrix;
            PolynomialGF2mSmallM polynomialGF2mSmallM3 = this.p;
            int[] arrn2 = polynomialGF2mSmallM2.coefficients;
            int[] arrn3 = polynomialGF2mSmallM3.coefficients;
            int n7 = PolynomialGF2mSmallM.computeDegree(arrn3);
            if (n7 != -1) {
                int n8 = arrn2.length;
                int[] arrn4 = new int[n8];
                int n9 = PolynomialGF2mSmallM.computeDegree(arrn3);
                int n10 = n9 == -1 ? 0 : arrn3[n9];
                int n11 = polynomialGF2mSmallM2.field.inverse(n10);
                System.arraycopy((Object)arrn2, (int)0, (Object)arrn4, (int)0, (int)n8);
                while (n7 <= PolynomialGF2mSmallM.computeDegree(arrn4)) {
                    int[] arrn5;
                    GF2mField gF2mField2 = polynomialGF2mSmallM2.field;
                    int n12 = PolynomialGF2mSmallM.computeDegree(arrn4);
                    int n13 = n12 == -1 ? 0 : arrn4[n12];
                    int n14 = gF2mField2.mult(n13, n11);
                    int n15 = PolynomialGF2mSmallM.computeDegree(arrn4) - n7;
                    int n16 = PolynomialGF2mSmallM.computeDegree(arrn3);
                    if (n16 == -1) {
                        arrn5 = new int[1];
                    } else {
                        int[] arrn6 = new int[1 + (n16 + n15)];
                        System.arraycopy((Object)arrn3, (int)0, (Object)arrn6, (int)n15, (int)(n16 + 1));
                        arrn5 = arrn6;
                    }
                    arrn4 = polynomialGF2mSmallM2.add(polynomialGF2mSmallM2.multWithElement(arrn5, n14), arrn4);
                }
                arrpolynomialGF2mSmallM[n3] = new PolynomialGF2mSmallM(polynomialGF2mSmallM2.field, arrn4);
                ++n3;
                continue;
            }
            throw new ArithmeticException("Division by zero");
        }
        int n17 = this.p.getDegree();
        PolynomialGF2mSmallM[] arrpolynomialGF2mSmallM = new PolynomialGF2mSmallM[n17];
        for (int i3 = n2 = n17 - 1; i3 >= 0; --i3) {
            arrpolynomialGF2mSmallM[i3] = new PolynomialGF2mSmallM(this.sqMatrix[i3]);
        }
        this.sqRootMatrix = new PolynomialGF2mSmallM[n17];
        while (n2 >= 0) {
            this.sqRootMatrix[n2] = new PolynomialGF2mSmallM(this.field, n2);
            --n2;
        }
        for (int i4 = 0; i4 < n17; ++i4) {
            if (arrpolynomialGF2mSmallM[i4].getCoefficient(i4) == 0) {
                boolean bl = false;
                for (int i5 = i4 + 1; i5 < n17; ++i5) {
                    if (arrpolynomialGF2mSmallM[i5].getCoefficient(i4) == 0) continue;
                    PolynomialGF2mSmallM polynomialGF2mSmallM4 = arrpolynomialGF2mSmallM[i4];
                    arrpolynomialGF2mSmallM[i4] = arrpolynomialGF2mSmallM[i5];
                    arrpolynomialGF2mSmallM[i5] = polynomialGF2mSmallM4;
                    PolynomialGF2mSmallM[] arrpolynomialGF2mSmallM2 = this.sqRootMatrix;
                    PolynomialGF2mSmallM polynomialGF2mSmallM5 = arrpolynomialGF2mSmallM2[i4];
                    arrpolynomialGF2mSmallM2[i4] = arrpolynomialGF2mSmallM2[i5];
                    arrpolynomialGF2mSmallM2[i5] = polynomialGF2mSmallM5;
                    i5 = n17;
                    bl = true;
                }
                if (!bl) {
                    throw new ArithmeticException("Squaring matrix is not invertible.");
                }
            }
            int n18 = arrpolynomialGF2mSmallM[i4].getCoefficient(i4);
            int n19 = this.field.inverse(n18);
            arrpolynomialGF2mSmallM[i4].multThisWithElement(n19);
            this.sqRootMatrix[i4].multThisWithElement(n19);
            for (int i6 = 0; i6 < n17; ++i6) {
                int n20;
                if (i6 == i4 || (n20 = arrpolynomialGF2mSmallM[i6].getCoefficient(i4)) == 0) continue;
                PolynomialGF2mSmallM polynomialGF2mSmallM6 = arrpolynomialGF2mSmallM[i4].multWithElement(n20);
                PolynomialGF2mSmallM polynomialGF2mSmallM7 = this.sqRootMatrix[i4].multWithElement(n20);
                PolynomialGF2mSmallM polynomialGF2mSmallM8 = arrpolynomialGF2mSmallM[i6];
                polynomialGF2mSmallM8.coefficients = polynomialGF2mSmallM8.add(polynomialGF2mSmallM8.coefficients, polynomialGF2mSmallM6.coefficients);
                polynomialGF2mSmallM8.computeDegree();
                PolynomialGF2mSmallM polynomialGF2mSmallM9 = this.sqRootMatrix[i6];
                polynomialGF2mSmallM9.coefficients = polynomialGF2mSmallM9.add(polynomialGF2mSmallM9.coefficients, polynomialGF2mSmallM7.coefficients);
                polynomialGF2mSmallM9.computeDegree();
            }
        }
    }
}

