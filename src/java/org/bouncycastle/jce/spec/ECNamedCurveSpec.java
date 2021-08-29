/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.math.BigInteger
 *  java.security.spec.ECField
 *  java.security.spec.ECFieldF2m
 *  java.security.spec.ECFieldFp
 *  java.security.spec.ECParameterSpec
 *  java.security.spec.ECPoint
 *  java.security.spec.EllipticCurve
 *  org.bouncycastle.math.ec.ECFieldElement
 *  org.bouncycastle.math.field.PolynomialExtensionField
 */
package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.GF2Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.math.raw.Nat576;

public class ECNamedCurveSpec
extends ECParameterSpec {
    public String name;

    public ECNamedCurveSpec(String string, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(ellipticCurve, eCPoint, bigInteger, bigInteger2.intValue());
        this.name = string;
    }

    public ECNamedCurveSpec(String string, ECCurve eCCurve, org.bouncycastle.math.ec.ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] arrby) {
        ECFieldFp eCFieldFp;
        FiniteField finiteField = eCCurve.field;
        boolean bl = finiteField.getDimension() == 1;
        if (bl) {
            eCFieldFp = new ECFieldFp(finiteField.getCharacteristic());
        } else {
            GF2Polynomial gF2Polynomial = ((PolynomialExtensionField)finiteField).getMinimalPolynomial();
            int[] arrn = gF2Polynomial.getExponentsPresent();
            int n2 = Nat576.getLength(1, arrn.length - 1);
            int[] arrn2 = new int[n2];
            System.arraycopy((Object)arrn, (int)1, (Object)arrn2, (int)0, (int)Math.min((int)(arrn.length - 1), (int)n2));
            int[] arrn3 = Nat576.reverse(arrn2);
            eCFieldFp = new ECFieldF2m(gF2Polynomial.getDegree(), arrn3);
        }
        super(new EllipticCurve((ECField)eCFieldFp, eCCurve.a.toBigInteger(), eCCurve.b.toBigInteger(), null), EC5Util.convertPoint(eCPoint), bigInteger, bigInteger2.intValue());
        this.name = string;
    }
}

