/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.math.BigInteger
 *  java.security.SecureRandom
 */
package org.bouncycastle.math.ec.custom.djb;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.djb.Curve25519$1;
import org.bouncycastle.math.ec.custom.djb.Curve25519Field;
import org.bouncycastle.math.ec.custom.djb.Curve25519FieldElement;
import org.bouncycastle.math.ec.custom.djb.Curve25519Point;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class Curve25519
extends ECCurve.AbstractFp {
    public static final ECFieldElement[] CURVE25519_AFFINE_ZS;
    public static final BigInteger C_a;
    public static final BigInteger C_b;
    public static final BigInteger q;
    public Curve25519Point infinity = new Curve25519Point(this, null, null);

    public static {
        BigInteger bigInteger;
        q = Curve25519FieldElement.Q;
        C_a = bigInteger = new BigInteger(1, Hex.decodeStrict("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144"));
        C_b = new BigInteger(1, Hex.decodeStrict("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864"));
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new Curve25519FieldElement(ECConstants.ONE), new Curve25519FieldElement(bigInteger)};
        CURVE25519_AFFINE_ZS = arreCFieldElement;
    }

    public Curve25519() {
        super(q);
        this.a = new Curve25519FieldElement(C_a);
        this.b = new Curve25519FieldElement(C_b);
        this.order = new BigInteger(1, Hex.decodeStrict("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
        this.cofactor = BigInteger.valueOf((long)8L);
        this.coord = 4;
    }

    @Override
    public ECCurve cloneCurve() {
        return new Curve25519();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        int[] arrn = new int[2 * (n3 * 8)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy4(((Curve25519FieldElement)eCPoint.x).x, 0, arrn, n4);
            int n5 = n4 + 8;
            SecT239Field.copy4(((Curve25519FieldElement)eCPoint.y).x, 0, arrn, n5);
            n4 = n5 + 8;
        }
        return new Curve25519$1(this, n3, arrn);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new Curve25519Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new Curve25519FieldElement(bigInteger);
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
                arrn[7] = Integer.MAX_VALUE & arrn[7];
            } while (Nat576.lessThan(8, arrn, Curve25519Field.P) == 0);
        } while (Curve25519Field.isZero(arrn) != 0);
        return new Curve25519FieldElement(arrn);
    }

    @Override
    public boolean supportsCoordinateSystem(int n2) {
        return n2 == 4;
    }
}

