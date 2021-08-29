/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  org.bouncycastle.math.field.GenericPolynomialExtensionField
 *  org.bouncycastle.math.field.PolynomialExtensionField
 *  org.bouncycastle.math.field.PrimeField
 */
package org.bouncycastle.math.field;

import java.math.BigInteger;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.GF2Polynomial;
import org.bouncycastle.math.field.GenericPolynomialExtensionField;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.math.field.PrimeField;

public abstract class FiniteFields {
    public static final FiniteField GF_2 = new PrimeField(BigInteger.valueOf((long)2L));
    public static final FiniteField GF_3 = new PrimeField(BigInteger.valueOf((long)3L));

    public static PolynomialExtensionField getBinaryExtensionField(int[] arrn) {
        if (arrn[0] == 0) {
            for (int i2 = 1; i2 < arrn.length; ++i2) {
                if (arrn[i2] > arrn[i2 - 1]) {
                    continue;
                }
                throw new IllegalArgumentException("Polynomial exponents must be monotonically increasing");
            }
            return new GenericPolynomialExtensionField(GF_2, new GF2Polynomial(arrn));
        }
        throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
    }
}

