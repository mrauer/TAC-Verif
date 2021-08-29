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
import org.bouncycastle.math.ec.custom.sec.SecT409FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT409R1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecT409R1Point;
import org.bouncycastle.util.encoders.Hex;

public class SecT409R1Curve
extends ECCurve.AbstractF2m {
    public static final ECFieldElement[] SECT409R1_AFFINE_ZS;
    public SecT409R1Point infinity = new SecT409R1Point(this, null, null);

    public static {
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecT409FieldElement(ECConstants.ONE)};
        SECT409R1_AFFINE_ZS = arreCFieldElement;
    }

    public SecT409R1Curve() {
        super(409, 87, 0, 0);
        this.a = new SecT409FieldElement(BigInteger.valueOf((long)1L));
        this.b = new SecT409FieldElement(new BigInteger(1, Hex.decodeStrict("0021A5C2C8EE9FEB5C4B9A753B7B476B7FD6422EF1F3DD674761FA99D6AC27C8A9A197B272822F6CD57A55AA4F50AE317B13545F")));
        this.order = new BigInteger(1, Hex.decodeStrict("010000000000000000000000000000000000000000000000000001E2AAD6A612F33307BE5FA47C3C9E052F838164CD37D9A21173"));
        this.cofactor = BigInteger.valueOf((long)2L);
        this.coord = 6;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecT409R1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        long[] arrl = new long[2 * (n3 * 7)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy644(((SecT409FieldElement)eCPoint.x).x, 0, arrl, n4);
            int n5 = n4 + 7;
            SecT239Field.copy644(((SecT409FieldElement)eCPoint.y).x, 0, arrl, n5);
            n4 = n5 + 7;
        }
        return new SecT409R1Curve$1(this, n3, arrl);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT409R1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT409FieldElement(bigInteger);
    }

    @Override
    public int getFieldSize() {
        return 409;
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

