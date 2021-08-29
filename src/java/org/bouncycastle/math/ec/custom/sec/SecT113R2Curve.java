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
import org.bouncycastle.math.ec.custom.sec.SecT113FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT113R2Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecT113R2Point;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.util.encoders.Hex;

public class SecT113R2Curve
extends ECCurve.AbstractF2m {
    public static final ECFieldElement[] SECT113R2_AFFINE_ZS;
    public SecT113R2Point infinity = new SecT113R2Point(this, null, null);

    public static {
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecT113FieldElement(ECConstants.ONE)};
        SECT113R2_AFFINE_ZS = arreCFieldElement;
    }

    public SecT113R2Curve() {
        super(113, 9, 0, 0);
        this.a = new SecT113FieldElement(new BigInteger(1, Hex.decodeStrict("00689918DBEC7E5A0DD6DFC0AA55C7")));
        this.b = new SecT113FieldElement(new BigInteger(1, Hex.decodeStrict("0095E9A9EC9B297BD4BF36E059184F")));
        this.order = new BigInteger(1, Hex.decodeStrict("010000000000000108789B2496AF93"));
        this.cofactor = BigInteger.valueOf((long)2L);
        this.coord = 6;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecT113R2Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        long[] arrl = new long[2 * (n3 * 2)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy64(((SecT113FieldElement)eCPoint.x).x, 0, arrl, n4);
            int n5 = n4 + 2;
            SecT239Field.copy64(((SecT113FieldElement)eCPoint.y).x, 0, arrl, n5);
            n4 = n5 + 2;
        }
        return new SecT113R2Curve$1(this, n3, arrl);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT113R2Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT113FieldElement(bigInteger);
    }

    @Override
    public int getFieldSize() {
        return 113;
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

