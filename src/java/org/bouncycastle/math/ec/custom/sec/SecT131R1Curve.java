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
import org.bouncycastle.math.ec.custom.sec.SecT131FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT131R1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecT131R1Point;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.util.encoders.Hex;

public class SecT131R1Curve
extends ECCurve.AbstractF2m {
    public static final ECFieldElement[] SECT131R1_AFFINE_ZS;
    public SecT131R1Point infinity = new SecT131R1Point(this, null, null);

    public static {
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecT131FieldElement(ECConstants.ONE)};
        SECT131R1_AFFINE_ZS = arreCFieldElement;
    }

    public SecT131R1Curve() {
        super(131, 2, 3, 8);
        this.a = new SecT131FieldElement(new BigInteger(1, Hex.decodeStrict("07A11B09A76B562144418FF3FF8C2570B8")));
        this.b = new SecT131FieldElement(new BigInteger(1, Hex.decodeStrict("0217C05610884B63B9C6C7291678F9D341")));
        this.order = new BigInteger(1, Hex.decodeStrict("0400000000000000023123953A9464B54D"));
        this.cofactor = BigInteger.valueOf((long)2L);
        this.coord = 6;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecT131R1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        long[] arrl = new long[2 * (n3 * 3)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy641(((SecT131FieldElement)eCPoint.x).x, 0, arrl, n4);
            int n5 = n4 + 3;
            SecT239Field.copy641(((SecT131FieldElement)eCPoint.y).x, 0, arrl, n5);
            n4 = n5 + 3;
        }
        return new SecT131R1Curve$1(this, n3, arrl);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT131R1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT131FieldElement(bigInteger);
    }

    @Override
    public int getFieldSize() {
        return 131;
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

