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
import org.bouncycastle.math.ec.custom.sec.SecP192K1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecP192K1Field;
import org.bouncycastle.math.ec.custom.sec.SecP192K1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP192K1Point;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP192K1Curve
extends ECCurve.AbstractFp {
    public static final ECFieldElement[] SECP192K1_AFFINE_ZS;
    public static final BigInteger q;
    public SecP192K1Point infinity = new SecP192K1Point(this, null, null);

    public static {
        q = SecP192K1FieldElement.Q;
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecP192K1FieldElement(ECConstants.ONE)};
        SECP192K1_AFFINE_ZS = arreCFieldElement;
    }

    public SecP192K1Curve() {
        super(q);
        this.a = new SecP192K1FieldElement(ECConstants.ZERO);
        this.b = new SecP192K1FieldElement(BigInteger.valueOf((long)3L));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D"));
        this.cofactor = BigInteger.valueOf((long)1L);
        this.coord = 2;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecP192K1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        int[] arrn = new int[2 * (n3 * 6)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy2(((SecP192K1FieldElement)eCPoint.x).x, 0, arrn, n4);
            int n5 = n4 + 6;
            SecT239Field.copy2(((SecP192K1FieldElement)eCPoint.y).x, 0, arrn, n5);
            n4 = n5 + 6;
        }
        return new SecP192K1Curve$1(this, n3, arrn);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP192K1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP192K1FieldElement(bigInteger);
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
        int[] arrn = new int[6];
        do {
            byte[] arrby = new byte[24];
            do {
                secureRandom.nextBytes(arrby);
                Nat576.littleEndianToInt(arrby, 0, arrn, 0, 6);
            } while (Nat576.lessThan(6, arrn, SecP192K1Field.P) == 0);
        } while (SecP192K1Field.isZero(arrn) != 0);
        return new SecP192K1FieldElement(arrn);
    }

    @Override
    public boolean supportsCoordinateSystem(int n2) {
        return n2 == 2;
    }
}

