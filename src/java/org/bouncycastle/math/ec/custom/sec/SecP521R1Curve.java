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
import org.bouncycastle.math.ec.custom.sec.SecP521R1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecP521R1Field;
import org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP521R1Point;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP521R1Curve
extends ECCurve.AbstractFp {
    public static final ECFieldElement[] SECP521R1_AFFINE_ZS;
    public static final BigInteger q;
    public SecP521R1Point infinity = new SecP521R1Point(this, null, null);

    public static {
        q = SecP521R1FieldElement.Q;
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecP521R1FieldElement(ECConstants.ONE)};
        SECP521R1_AFFINE_ZS = arreCFieldElement;
    }

    public SecP521R1Curve() {
        super(q);
        this.a = new SecP521R1FieldElement(new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.b = new SecP521R1FieldElement(new BigInteger(1, Hex.decodeStrict("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00")));
        this.order = new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409"));
        this.cofactor = BigInteger.valueOf((long)1L);
        this.coord = 2;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecP521R1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        int[] arrn = new int[2 * (n3 * 17)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            System.arraycopy((Object)((SecP521R1FieldElement)eCPoint.x).x, (int)0, (Object)arrn, (int)n4, (int)17);
            int n5 = n4 + 17;
            System.arraycopy((Object)((SecP521R1FieldElement)eCPoint.y).x, (int)0, (Object)arrn, (int)n5, (int)17);
            n4 = n5 + 17;
        }
        return new SecP521R1Curve$1(this, n3, arrn);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP521R1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP521R1FieldElement(bigInteger);
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
        int[] arrn = new int[17];
        do {
            byte[] arrby = new byte[68];
            do {
                secureRandom.nextBytes(arrby);
                Nat576.littleEndianToInt(arrby, 0, arrn, 0, 17);
                arrn[16] = 511 & arrn[16];
            } while (Nat576.lessThan(17, arrn, SecP521R1Field.P) == 0);
        } while (SecP521R1Field.isZero(arrn) != 0);
        return new SecP521R1FieldElement(arrn);
    }

    @Override
    public boolean supportsCoordinateSystem(int n2) {
        return n2 == 2;
    }
}

