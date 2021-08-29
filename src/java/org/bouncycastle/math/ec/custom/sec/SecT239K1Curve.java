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
import org.bouncycastle.math.ec.custom.sec.SecT239FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT239K1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecT239K1Point;
import org.bouncycastle.util.encoders.Hex;

public class SecT239K1Curve
extends ECCurve.AbstractF2m {
    public static final ECFieldElement[] SECT239K1_AFFINE_ZS;
    public SecT239K1Point infinity = new SecT239K1Point(this, null, null);

    public static {
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecT239FieldElement(ECConstants.ONE)};
        SECT239K1_AFFINE_ZS = arreCFieldElement;
    }

    public SecT239K1Curve() {
        super(239, 158, 0, 0);
        this.a = new SecT239FieldElement(BigInteger.valueOf((long)0L));
        this.b = new SecT239FieldElement(BigInteger.valueOf((long)1L));
        this.order = new BigInteger(1, Hex.decodeStrict("2000000000000000000000000000005A79FEC67CB6E91F1C1DA800E478A5"));
        this.cofactor = BigInteger.valueOf((long)4L);
        this.coord = 6;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecT239K1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        long[] arrl = new long[2 * (n3 * 4)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy642(((SecT239FieldElement)eCPoint.x).x, 0, arrl, n4);
            int n5 = n4 + 4;
            SecT239Field.copy642(((SecT239FieldElement)eCPoint.y).x, 0, arrl, n5);
            n4 = n5 + 4;
        }
        return new SecT239K1Curve$1(this, n3, arrl);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT239K1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT239FieldElement(bigInteger);
    }

    @Override
    public int getFieldSize() {
        return 239;
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

