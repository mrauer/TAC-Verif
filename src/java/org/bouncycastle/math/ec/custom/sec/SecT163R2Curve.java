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
import org.bouncycastle.math.ec.custom.sec.SecT163FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT163R2Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecT163R2Point;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.util.encoders.Hex;

public class SecT163R2Curve
extends ECCurve.AbstractF2m {
    public static final ECFieldElement[] SECT163R2_AFFINE_ZS;
    public SecT163R2Point infinity = new SecT163R2Point(this, null, null);

    public static {
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecT163FieldElement(ECConstants.ONE)};
        SECT163R2_AFFINE_ZS = arreCFieldElement;
    }

    public SecT163R2Curve() {
        super(163, 3, 6, 7);
        this.a = new SecT163FieldElement(BigInteger.valueOf((long)1L));
        this.b = new SecT163FieldElement(new BigInteger(1, Hex.decodeStrict("020A601907B8C953CA1481EB10512F78744A3205FD")));
        this.order = new BigInteger(1, Hex.decodeStrict("040000000000000000000292FE77E70C12A4234C33"));
        this.cofactor = BigInteger.valueOf((long)2L);
        this.coord = 6;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecT163R2Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        long[] arrl = new long[2 * (n3 * 3)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy641(((SecT163FieldElement)eCPoint.x).x, 0, arrl, n4);
            int n5 = n4 + 3;
            SecT239Field.copy641(((SecT163FieldElement)eCPoint.y).x, 0, arrl, n5);
            n4 = n5 + 3;
        }
        return new SecT163R2Curve$1(this, n3, arrl);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT163R2Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT163FieldElement(bigInteger);
    }

    @Override
    public int getFieldSize() {
        return 163;
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

