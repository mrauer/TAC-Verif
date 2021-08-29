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
import org.bouncycastle.math.ec.custom.sec.SecP256K1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecP256K1Field;
import org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP256K1Point;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP256K1Curve
extends ECCurve.AbstractFp {
    public static final ECFieldElement[] SECP256K1_AFFINE_ZS;
    public static final BigInteger q;
    public SecP256K1Point infinity = new SecP256K1Point(this, null, null);

    public static {
        q = SecP256K1FieldElement.Q;
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecP256K1FieldElement(ECConstants.ONE)};
        SECP256K1_AFFINE_ZS = arreCFieldElement;
    }

    public SecP256K1Curve() {
        super(q);
        this.a = new SecP256K1FieldElement(ECConstants.ZERO);
        this.b = new SecP256K1FieldElement(BigInteger.valueOf((long)7L));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
        this.cofactor = BigInteger.valueOf((long)1L);
        this.coord = 2;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecP256K1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        int[] arrn = new int[2 * (n3 * 8)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy4(((SecP256K1FieldElement)eCPoint.x).x, 0, arrn, n4);
            int n5 = n4 + 8;
            SecT239Field.copy4(((SecP256K1FieldElement)eCPoint.y).x, 0, arrn, n5);
            n4 = n5 + 8;
        }
        return new SecP256K1Curve$1(this, n3, arrn);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP256K1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP256K1FieldElement(bigInteger);
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
        int[] arrn = new int[8];
        do {
            byte[] arrby = new byte[32];
            do {
                secureRandom.nextBytes(arrby);
                Nat576.littleEndianToInt(arrby, 0, arrn, 0, 8);
            } while (Nat576.lessThan(8, arrn, SecP256K1Field.P) == 0);
        } while (SecP256K1Field.isZero(arrn) != 0);
        return new SecP256K1FieldElement(arrn);
    }

    @Override
    public boolean supportsCoordinateSystem(int n2) {
        return n2 == 2;
    }
}

