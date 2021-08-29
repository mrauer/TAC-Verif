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
import org.bouncycastle.math.ec.custom.sec.SecP160R1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecP160R1Field;
import org.bouncycastle.math.ec.custom.sec.SecP160R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP160R1Point;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP160R1Curve
extends ECCurve.AbstractFp {
    public static final ECFieldElement[] SECP160R1_AFFINE_ZS;
    public static final BigInteger q;
    public SecP160R1Point infinity = new SecP160R1Point(this, null, null);

    public static {
        q = SecP160R1FieldElement.Q;
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecP160R1FieldElement(ECConstants.ONE)};
        SECP160R1_AFFINE_ZS = arreCFieldElement;
    }

    public SecP160R1Curve() {
        super(q);
        this.a = new SecP160R1FieldElement(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC")));
        this.b = new SecP160R1FieldElement(new BigInteger(1, Hex.decodeStrict("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45")));
        this.order = new BigInteger(1, Hex.decodeStrict("0100000000000000000001F4C8F927AED3CA752257"));
        this.cofactor = BigInteger.valueOf((long)1L);
        this.coord = 2;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecP160R1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        int[] arrn = new int[2 * (n3 * 5)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy1(((SecP160R1FieldElement)eCPoint.x).x, 0, arrn, n4);
            int n5 = n4 + 5;
            SecT239Field.copy1(((SecP160R1FieldElement)eCPoint.y).x, 0, arrn, n5);
            n4 = n5 + 5;
        }
        return new SecP160R1Curve$1(this, n3, arrn);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP160R1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP160R1FieldElement(bigInteger);
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
        int[] arrn = new int[5];
        do {
            byte[] arrby = new byte[20];
            do {
                secureRandom.nextBytes(arrby);
                Nat576.littleEndianToInt(arrby, 0, arrn, 0, 5);
            } while (Nat576.lessThan(5, arrn, SecP160R1Field.P) == 0);
        } while (SecP160R1Field.isZero(arrn) != 0);
        return new SecP160R1FieldElement(arrn);
    }

    @Override
    public boolean supportsCoordinateSystem(int n2) {
        return n2 == 2;
    }
}

