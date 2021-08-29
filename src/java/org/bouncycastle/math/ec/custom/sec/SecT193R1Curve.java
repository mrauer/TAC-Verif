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
import org.bouncycastle.math.ec.custom.sec.SecT193R1Curve$1;
import org.bouncycastle.math.ec.custom.sec.SecT193R1Point;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.util.encoders.Hex;

public class SecT193R1Curve
extends ECCurve.AbstractF2m {
    public static final ECFieldElement[] SECT193R1_AFFINE_ZS;
    public SecT193R1Point infinity = new SecT193R1Point(this, null, null);

    public static {
        ECFieldElement[] arreCFieldElement = new ECFieldElement[]{new SecT193FieldElement(ECConstants.ONE)};
        SECT193R1_AFFINE_ZS = arreCFieldElement;
    }

    public SecT193R1Curve() {
        super(193, 15, 0, 0);
        this.a = new SecT193FieldElement(new BigInteger(1, Hex.decodeStrict("0017858FEB7A98975169E171F77B4087DE098AC8A911DF7B01")));
        this.b = new SecT193FieldElement(new BigInteger(1, Hex.decodeStrict("00FDFB49BFE6C3A89FACADAA7A1E5BBC7CC1C2E5D831478814")));
        this.order = new BigInteger(1, Hex.decodeStrict("01000000000000000000000000C7F34A778F443ACC920EBA49"));
        this.cofactor = BigInteger.valueOf((long)2L);
        this.coord = 6;
    }

    @Override
    public ECCurve cloneCurve() {
        return new SecT193R1Curve();
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
        return new SecT193R1Curve$1(this, n3, arrl);
    }

    @Override
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT193R1Point(this, eCFieldElement, eCFieldElement2);
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

