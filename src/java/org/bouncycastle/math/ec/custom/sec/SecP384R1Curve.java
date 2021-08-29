/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.System
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
import org.bouncycastle.math.ec.custom.sec.SecP384R1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecP384R1Field;
import org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP384R1Point;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP384R1Curve
extends ECCurve.AbstractFp {
    public static final ECFieldElement[] SECP384R1_AFFINE_ZS;
    public static final BigInteger q;
    public SecP384R1Point infinity = new SecP384R1Point(this, null, null);

    public static {
        q = SecP384R1FieldElement.Q;
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecP384R1FieldElement(ECConstants.ONE)};
        SECP384R1_AFFINE_ZS = arreCFieldElement;
    }

    public SecP384R1Curve() {
        super(q);
        this.a = new SecP384R1FieldElement(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC")));
        this.b = new SecP384R1FieldElement(new BigInteger(1, Hex.decodeStrict("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973"));
        this.cofactor = BigInteger.valueOf((long)1L);
        this.coord = 2;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecP384R1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        int[] arrn = new int[2 * (n3 * 12)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            System.arraycopy((Object)((SecP384R1FieldElement)eCPoint.x).x, (int)0, (Object)arrn, (int)n4, (int)12);
            int n5 = n4 + 12;
            System.arraycopy((Object)((SecP384R1FieldElement)eCPoint.y).x, (int)0, (Object)arrn, (int)n5, (int)12);
            n4 = n5 + 12;
        }
        return new SecP384R1Curve$1(this, n3, arrn);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP384R1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP384R1FieldElement(bigInteger);
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
        int[] arrn = new int[12];
        do {
            byte[] arrby = new byte[48];
            do {
                secureRandom.nextBytes(arrby);
                Nat576.littleEndianToInt(arrby, 0, arrn, 0, 12);
            } while (Nat576.lessThan(12, arrn, SecP384R1Field.P) == 0);
        } while (SecP384R1Field.isZero(arrn) != 0);
        return new SecP384R1FieldElement(arrn);
    }

    @Override
    public boolean supportsCoordinateSystem(int n2) {
        return n2 == 2;
    }
}

