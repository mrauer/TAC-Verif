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
import org.bouncycastle.math.ec.custom.sec.SecT193FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT193R2Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecT193R2Point;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.util.encoders.Hex;

public class SecT193R2Curve
extends ECCurve.AbstractF2m {
    public static final ECFieldElement[] SECT193R2_AFFINE_ZS;
    public SecT193R2Point infinity = new SecT193R2Point(this, null, null);

    public static {
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecT193FieldElement(ECConstants.ONE)};
        SECT193R2_AFFINE_ZS = arreCFieldElement;
    }

    public SecT193R2Curve() {
        super(193, 15, 0, 0);
        this.a = new SecT193FieldElement(new BigInteger(1, Hex.decodeStrict("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B")));
        this.b = new SecT193FieldElement(new BigInteger(1, Hex.decodeStrict("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE")));
        this.order = new BigInteger(1, Hex.decodeStrict("010000000000000000000000015AAB561B005413CCD4EE99D5"));
        this.cofactor = BigInteger.valueOf((long)2L);
        this.coord = 6;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecT193R2Curve();
    }

    @Override
    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        long[] arrl = new long[2 * (n3 * 4)];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            SecT239Field.copy642(((SecT193FieldElement)eCPoint.x).x, 0, arrl, n4);
            int n5 = n4 + 4;
            SecT239Field.copy642(((SecT193FieldElement)eCPoint.y).x, 0, arrl, n5);
            n4 = n5 + 4;
        }
        return new SecT193R2Curve$1(this, n3, arrl);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT193R2Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT193FieldElement(bigInteger);
    }

    @Override
    public int getFieldSize() {
        return 193;
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

