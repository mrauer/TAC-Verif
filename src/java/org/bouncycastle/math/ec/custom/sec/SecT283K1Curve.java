/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.ec.custom.sec.SecT283FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT283K1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecT283K1Point;
import org.bouncycastle.util.encoders.Hex;

public class SecT283K1Curve
extends ECCurve.AbstractF2m {
    public static final ECFieldElement[] SECT283K1_AFFINE_ZS;
    public SecT283K1Point infinity = new SecT283K1Point(this, null, null);

    public static {
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecT283FieldElement(ECConstants.ONE)};
        SECT283K1_AFFINE_ZS = arreCFieldElement;
    }

    public SecT283K1Curve() {
        super(283, 5, 7, 12);
        this.a = new SecT283FieldElement(BigInteger.valueOf((long)0L));
        this.b = new SecT283FieldElement(BigInteger.valueOf((long)1L));
        this.order = new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE9AE2ED07577265DFF7F94451E061E163C61"));
        this.cofactor = BigInteger.valueOf((long)4L);
        this.coord = 6;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecT283K1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        long[] arrl = new long[2 * (n3 * 5)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy643(((SecT283FieldElement)eCPoint.x).x, 0, arrl, n4);
            int n5 = n4 + 5;
            SecT239Field.copy643(((SecT283FieldElement)eCPoint.y).x, 0, arrl, n5);
            n4 = n5 + 5;
        }
        return new SecT283K1Curve$1(this, n3, arrl);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT283K1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT283FieldElement(bigInteger);
    }

    @Override
    public int getFieldSize() {
        return 283;
    }

    @Override
    public ECPoint getInfinity() {
        return this.infinity;
    }

    @Override
    public boolean supportsCoordinateSystem(int n2) {
        return n2 == 6;
    }
}

