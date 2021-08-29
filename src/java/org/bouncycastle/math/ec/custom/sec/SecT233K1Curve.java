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
import org.bouncycastle.math.ec.custom.sec.SecT233FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT233K1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecT233K1Point;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.util.encoders.Hex;

public class SecT233K1Curve
extends ECCurve.AbstractF2m {
    public static final ECFieldElement[] SECT233K1_AFFINE_ZS;
    public SecT233K1Point infinity = new SecT233K1Point(this, null, null);

    public static {
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecT233FieldElement(ECConstants.ONE)};
        SECT233K1_AFFINE_ZS = arreCFieldElement;
    }

    public SecT233K1Curve() {
        super(233, 74, 0, 0);
        this.a = new SecT233FieldElement(BigInteger.valueOf((long)0L));
        this.b = new SecT233FieldElement(BigInteger.valueOf((long)1L));
        this.order = new BigInteger(1, Hex.decodeStrict("8000000000000000000000000000069D5BB915BCD46EFB1AD5F173ABDF"));
        this.cofactor = BigInteger.valueOf((long)4L);
        this.coord = 6;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecT233K1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        long[] arrl = new long[2 * (n3 * 4)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy642(((SecT233FieldElement)eCPoint.x).x, 0, arrl, n4);
            int n5 = n4 + 4;
            SecT239Field.copy642(((SecT233FieldElement)eCPoint.y).x, 0, arrl, n5);
            n4 = n5 + 4;
        }
        return new SecT233K1Curve$1(this, n3, arrl);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT233K1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT233FieldElement(bigInteger);
    }

    @Override
    public int getFieldSize() {
        return 233;
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

