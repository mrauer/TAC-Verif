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
import org.bouncycastle.math.ec.custom.sec.SecT571FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT571R1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecT571R1Point;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecT571R1Curve
extends ECCurve.AbstractF2m {
    public static final ECFieldElement[] SECT571R1_AFFINE_ZS;
    public static final SecT571FieldElement SecT571R1_B;
    public static final SecT571FieldElement SecT571R1_B_SQRT;
    public SecT571R1Point infinity = new SecT571R1Point(this, null, null);

    public static {
        SecT571FieldElement secT571FieldElement;
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecT571FieldElement(ECConstants.ONE)};
        SECT571R1_AFFINE_ZS = arreCFieldElement;
        SecT571R1_B = secT571FieldElement = new SecT571FieldElement(new BigInteger(1, Hex.decodeStrict("02F40E7E2221F295DE297117B7F3D62F5C6A97FFCB8CEFF1CD6BA8CE4A9A18AD84FFABBD8EFA59332BE7AD6756A66E294AFD185A78FF12AA520E4DE739BACA0C7FFEFF7F2955727A")));
        SecT571R1_B_SQRT = (SecT571FieldElement)secT571FieldElement.sqrt();
    }

    public SecT571R1Curve() {
        super(571, 2, 5, 10);
        this.a = new SecT571FieldElement(BigInteger.valueOf((long)1L));
        this.b = SecT571R1_B;
        this.order = new BigInteger(1, Hex.decodeStrict("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE661CE18FF55987308059B186823851EC7DD9CA1161DE93D5174D66E8382E9BB2FE84E47"));
        this.cofactor = BigInteger.valueOf((long)2L);
        this.coord = 6;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecT571R1Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        long[] arrl = new long[2 * (n3 * 9)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            Nat576.copy64(((SecT571FieldElement)eCPoint.x).x, 0, arrl, n4);
            int n5 = n4 + 9;
            Nat576.copy64(((SecT571FieldElement)eCPoint.y).x, 0, arrl, n5);
            n4 = n5 + 9;
        }
        return new SecT571R1Curve$1(this, n3, arrl);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT571R1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT571FieldElement(bigInteger);
    }

    @Override
    public int getFieldSize() {
        return 571;
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

