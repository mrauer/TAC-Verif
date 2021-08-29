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
import org.bouncycastle.math.ec.custom.sec.SecP128R1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecP128R1Field;
import org.bouncycastle.math.ec.custom.sec.SecP128R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP128R1Point;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP128R1Curve
extends ECCurve.AbstractFp {
    public static final ECFieldElement[] SECP128R1_AFFINE_ZS;
    public static final BigInteger q;
    public SecP128R1Point infinity = new SecP128R1Point(this, null, null);

    public static {
        q = SecP128R1FieldElement.Q;
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecP128R1FieldElement(ECConstants.ONE)};
        SECP128R1_AFFINE_ZS = arreCFieldElement;
    }

    public SecP128R1Curve() {
        super(q);
        this.a = new SecP128R1FieldElement(new BigInteger(1, Hex.decodeStrict("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.b = new SecP128R1FieldElement(new BigInteger(1, Hex.decodeStrict("E87579C11079F43DD824993C2CEE5ED3")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFE0000000075A30D1B9038A115"));
        this.cofactor = BigInteger.valueOf((long)1L);
        this.coord = 2;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecP128R1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        int[] arrn = new int[2 * (n3 * 4)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy(((SecP128R1FieldElement)eCPoint.x).x, 0, arrn, n4);
            int n5 = n4 + 4;
            SecT239Field.copy(((SecP128R1FieldElement)eCPoint.y).x, 0, arrn, n5);
            n4 = n5 + 4;
        }
        return new SecP128R1Curve$1(this, n3, arrn);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP128R1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP128R1FieldElement(bigInteger);
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
        int[] arrn = new int[4];
        do {
            byte[] arrby = new byte[16];
            do {
                secureRandom.nextBytes(arrby);
                Nat576.littleEndianToInt(arrby, 0, arrn, 0, 4);
            } while (Nat576.lessThan(4, arrn, SecP128R1Field.P) == 0);
        } while (SecP128R1Field.isZero(arrn) != 0);
        return new SecP128R1FieldElement(arrn);
    }

    @Override
    public boolean supportsCoordinateSystem(int n2) {
        return n2 == 2;
    }
}

