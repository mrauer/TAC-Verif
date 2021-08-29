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
import org.bouncycastle.math.ec.custom.sec.SecT571K1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecT571K1Point;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecT571K1Curve
extends ECCurve.AbstractF2m {
    public static final ECFieldElement[] SECT571K1_AFFINE_ZS;
    public SecT571K1Point infinity = new SecT571K1Point(this, null, null);

    public static {
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecT571FieldElement(ECConstants.ONE)};
        SECT571K1_AFFINE_ZS = arreCFieldElement;
    }

    public SecT571K1Curve() {
        super(571, 2, 5, 10);
        this.a = new SecT571FieldElement(BigInteger.valueOf((long)0L));
        this.b = new SecT571FieldElement(BigInteger.valueOf((long)1L));
        this.order = new BigInteger(1, Hex.decodeStrict("020000000000000000000000000000000000000000000000000000000000000000000000131850E1F19A63E4B391A8DB917F4138B630D84BE5D639381E91DEB45CFE778F637C1001"));
        this.cofactor = BigInteger.valueOf((long)4L);
        this.coord = 6;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecT571K1Curve();
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
        return new SecT571K1Curve$1(this, n3, arrl);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT571K1Point(this, eCFieldElement, eCFieldElement2);
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

