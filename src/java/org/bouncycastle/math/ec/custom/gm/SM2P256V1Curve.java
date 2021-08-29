/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.math.BigInteger
 *  java.security.SecureRandom
 */
package org.bouncycastle.math.ec.custom.gm;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.gm.SM2P256V1Curve$1;
import org.bouncycastle.math.ec.custom.gm.SM2P256V1Field;
import org.bouncycastle.math.ec.custom.gm.SM2P256V1FieldElement;
import org.bouncycastle.math.ec.custom.gm.SM2P256V1Point;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SM2P256V1Curve
extends ECCurve.AbstractFp {
    public static final ECFieldElement[] SM2P256V1_AFFINE_ZS;
    public static final BigInteger q;
    public SM2P256V1Point infinity = new SM2P256V1Point(this, null, null);

    public static {
        q = SM2P256V1FieldElement.Q;
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SM2P256V1FieldElement(ECConstants.ONE)};
        SM2P256V1_AFFINE_ZS = arreCFieldElement;
    }

    public SM2P256V1Curve() {
        super(q);
        this.a = new SM2P256V1FieldElement(new BigInteger(1, Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC")));
        this.b = new SM2P256V1FieldElement(new BigInteger(1, Hex.decodeStrict("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"));
        this.cofactor = BigInteger.valueOf((long)1L);
        this.coord = 2;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SM2P256V1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        int[] arrn = new int[2 * (n3 * 8)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy4(((SM2P256V1FieldElement)eCPoint.x).x, 0, arrn, n4);
            int n5 = n4 + 8;
            SecT239Field.copy4(((SM2P256V1FieldElement)eCPoint.y).x, 0, arrn, n5);
            n4 = n5 + 8;
        }
        return new SM2P256V1Curve$1(this, n3, arrn);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SM2P256V1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SM2P256V1FieldElement(bigInteger);
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
            } while (Nat576.lessThan(8, arrn, SM2P256V1Field.P) == 0);
        } while (SM2P256V1Field.isZero(arrn) != 0);
        return new SM2P256V1FieldElement(arrn);
    }

    @Override
    public boolean supportsCoordinateSystem(int n2) {
        return n2 == 2;
    }
}

