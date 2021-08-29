/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.math.BigInteger
 *  java.security.SecureRandom
 */
package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP224R1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecP224R1Field;
import org.bouncycastle.math.ec.custom.sec.SecP224R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP224R1Point;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP224R1Curve
extends ECCurve.AbstractFp {
    public static final ECFieldElement[] SECP224R1_AFFINE_ZS;
    public static final BigInteger q;
    public SecP224R1Point infinity = new SecP224R1Point(this, null, null);

    public static {
        q = SecP224R1FieldElement.Q;
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecP224R1FieldElement(ECConstants.ONE)};
        SECP224R1_AFFINE_ZS = arreCFieldElement;
    }

    public SecP224R1Curve() {
        super(q);
        this.a = new SecP224R1FieldElement(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        this.b = new SecP224R1FieldElement(new BigInteger(1, Hex.decodeStrict("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        this.cofactor = BigInteger.valueOf((long)1L);
        this.coord = 2;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecP224R1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        int[] arrn = new int[2 * (n3 * 7)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy3(((SecP224R1FieldElement)eCPoint.x).x, 0, arrn, n4);
            int n5 = n4 + 7;
            SecT239Field.copy3(((SecP224R1FieldElement)eCPoint.y).x, 0, arrn, n5);
            n4 = n5 + 7;
        }
        return new SecP224R1Curve$1(this, n3, arrn);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP224R1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP224R1FieldElement(bigInteger);
    }

    @Override
    public int getFieldSize() {
        return q.bitLength();
    }

    @Override
    public ECPoint getInfinity() {
        return this.infinity;
    }

    @Override
    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] arrn = new int[7];
        do {
            byte[] arrby = new byte[28];
            do {
                secureRandom.nextBytes(arrby);
                Nat576.littleEndianToInt(arrby, 0, arrn, 0, 7);
            } while (Nat576.lessThan(7, arrn, SecP224R1Field.P) == 0);
        } while (SecP224R1Field.isZero(arrn) != 0);
        return new SecP224R1FieldElement(arrn);
    }

    @Override
    public boolean supportsCoordinateSystem(int n2) {
        return n2 == 2;
    }
}

