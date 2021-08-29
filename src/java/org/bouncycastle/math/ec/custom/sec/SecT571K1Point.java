/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecT571Field;
import org.bouncycastle.math.ec.custom.sec.SecT571FieldElement;
import org.bouncycastle.math.raw.Nat576;

public class SecT571K1Point
extends ECPoint.AbstractF2m {
    public SecT571K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecT571K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
        super(eCCurve, eCFieldElement, eCFieldElement2, arreCFieldElement);
    }

    @Override
    public ECPoint add(ECPoint eCPoint) {
        long[] arrl;
        long[] arrl2;
        SecT571FieldElement secT571FieldElement;
        long[] arrl3;
        SecT571FieldElement secT571FieldElement2;
        SecT571FieldElement secT571FieldElement3;
        if (this.isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        SecT571FieldElement secT571FieldElement4 = (SecT571FieldElement)this.x;
        SecT571FieldElement secT571FieldElement5 = (SecT571FieldElement)eCPoint.x;
        if (secT571FieldElement4.isZero()) {
            if (secT571FieldElement5.isZero()) {
                return eCCurve.getInfinity();
            }
            return eCPoint.add(this);
        }
        SecT571FieldElement secT571FieldElement6 = (SecT571FieldElement)this.y;
        SecT571FieldElement secT571FieldElement7 = (SecT571FieldElement)this.zs[0];
        SecT571FieldElement secT571FieldElement8 = (SecT571FieldElement)eCPoint.y;
        SecT571FieldElement secT571FieldElement9 = (SecT571FieldElement)eCPoint.getZCoord(0);
        long[] arrl4 = new long[9];
        long[] arrl5 = new long[9];
        long[] arrl6 = new long[9];
        long[] arrl7 = new long[9];
        long[] arrl8 = secT571FieldElement7.isOne() ? null : SecT571Field.precompMultiplicand(secT571FieldElement7.x);
        if (arrl8 == null) {
            arrl2 = secT571FieldElement5.x;
            arrl = secT571FieldElement8.x;
        } else {
            SecT571Field.multiplyPrecomp(secT571FieldElement5.x, arrl8, arrl5);
            SecT571Field.multiplyPrecomp(secT571FieldElement8.x, arrl8, arrl7);
            arrl = arrl7;
            arrl2 = arrl5;
        }
        long[] arrl9 = secT571FieldElement9.isOne() ? null : SecT571Field.precompMultiplicand(secT571FieldElement9.x);
        long[] arrl10 = secT571FieldElement4.x;
        if (arrl9 == null) {
            arrl3 = secT571FieldElement6.x;
        } else {
            SecT571Field.multiplyPrecomp(arrl10, arrl9, arrl4);
            SecT571Field.multiplyPrecomp(secT571FieldElement6.x, arrl9, arrl6);
            arrl10 = arrl4;
            arrl3 = arrl6;
        }
        SecT571Field.add(arrl3, arrl, arrl6);
        SecT571Field.add(arrl10, arrl2, arrl7);
        if (Nat576.isZero64(arrl7)) {
            if (Nat576.isZero64(arrl6)) {
                return this.twice();
            }
            return eCCurve.getInfinity();
        }
        if (secT571FieldElement5.isZero()) {
            ECPoint eCPoint2 = this.normalize();
            SecT571FieldElement secT571FieldElement10 = (SecT571FieldElement)eCPoint2.x;
            ECFieldElement eCFieldElement = eCPoint2.getYCoord();
            ECFieldElement eCFieldElement2 = eCFieldElement.add(secT571FieldElement8).divide(secT571FieldElement10);
            secT571FieldElement3 = (SecT571FieldElement)eCFieldElement2.square().add(eCFieldElement2).add(secT571FieldElement10);
            if (secT571FieldElement3.isZero()) {
                return new SecT571K1Point(eCCurve, secT571FieldElement3, eCCurve.b);
            }
            secT571FieldElement = (SecT571FieldElement)eCFieldElement2.multiply(secT571FieldElement10.add(secT571FieldElement3)).add(secT571FieldElement3).add(eCFieldElement).divide(secT571FieldElement3).add(secT571FieldElement3);
            secT571FieldElement2 = (SecT571FieldElement)eCCurve.fromBigInteger(ECConstants.ONE);
        } else {
            SecT571Field.square(arrl7, arrl7);
            long[] arrl11 = SecT571Field.precompMultiplicand(arrl6);
            SecT571Field.multiplyPrecomp(arrl10, arrl11, arrl4);
            SecT571Field.multiplyPrecomp(arrl2, arrl11, arrl5);
            SecT571FieldElement secT571FieldElement11 = new SecT571FieldElement(arrl4);
            SecT571Field.multiply(arrl4, arrl5, arrl4);
            if (secT571FieldElement11.isZero()) {
                return new SecT571K1Point(eCCurve, secT571FieldElement11, eCCurve.b);
            }
            SecT571FieldElement secT571FieldElement12 = new SecT571FieldElement(arrl6);
            SecT571Field.multiplyPrecomp(arrl7, arrl11, arrl6);
            if (arrl9 != null) {
                long[] arrl12 = secT571FieldElement12.x;
                SecT571Field.multiplyPrecomp(arrl12, arrl9, arrl12);
            }
            long[] arrl13 = new long[18];
            SecT571Field.add(arrl5, arrl7, arrl7);
            SecT571Field.squareAddToExt(arrl7, arrl13);
            SecT571Field.add(secT571FieldElement6.x, secT571FieldElement7.x, arrl7);
            SecT571Field.multiplyAddToExt(arrl7, secT571FieldElement12.x, arrl13);
            SecT571FieldElement secT571FieldElement13 = new SecT571FieldElement(arrl7);
            SecT571Field.reduce(arrl13, arrl7);
            if (arrl8 != null) {
                long[] arrl14 = secT571FieldElement12.x;
                SecT571Field.multiplyPrecomp(arrl14, arrl8, arrl14);
            }
            secT571FieldElement3 = secT571FieldElement11;
            secT571FieldElement = secT571FieldElement13;
            secT571FieldElement2 = secT571FieldElement12;
        }
        return new SecT571K1Point(eCCurve, secT571FieldElement3, secT571FieldElement, new ECFieldElement[]{secT571FieldElement2});
    }

    @Override
    public ECPoint detach() {
        return new SecT571K1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    @Override
    public boolean getCompressionYTilde() {
        ECFieldElement eCFieldElement = this.x;
        if (eCFieldElement.isZero()) {
            return false;
        }
        boolean bl = this.y.testBitZero();
        boolean bl2 = eCFieldElement.testBitZero();
        boolean bl3 = false;
        if (bl != bl2) {
            bl3 = true;
        }
        return bl3;
    }

    @Override
    public ECFieldElement getYCoord() {
        ECFieldElement eCFieldElement = this.x;
        ECFieldElement eCFieldElement2 = this.y;
        if (!this.isInfinity()) {
            if (eCFieldElement.isZero()) {
                return eCFieldElement2;
            }
            ECFieldElement eCFieldElement3 = eCFieldElement2.add(eCFieldElement).multiply(eCFieldElement);
            ECFieldElement eCFieldElement4 = this.zs[0];
            if (!eCFieldElement4.isOne()) {
                eCFieldElement3 = eCFieldElement3.divide(eCFieldElement4);
            }
            return eCFieldElement3;
        }
        return eCFieldElement2;
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        ECFieldElement eCFieldElement = this.x;
        if (eCFieldElement.isZero()) {
            return this;
        }
        ECFieldElement eCFieldElement2 = this.y;
        ECFieldElement eCFieldElement3 = this.zs[0];
        return new SecT571K1Point(this.curve, eCFieldElement, eCFieldElement2.add(eCFieldElement3), new ECFieldElement[]{eCFieldElement3});
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        ECFieldElement eCFieldElement = this.x;
        if (eCFieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        ECFieldElement eCFieldElement2 = this.y;
        ECFieldElement eCFieldElement3 = this.zs[0];
        boolean bl = eCFieldElement3.isOne();
        ECFieldElement eCFieldElement4 = bl ? eCFieldElement3 : eCFieldElement3.square();
        ECFieldElement eCFieldElement5 = bl ? eCFieldElement2.square().add(eCFieldElement2) : eCFieldElement2.add(eCFieldElement3).multiply(eCFieldElement2);
        if (eCFieldElement5.isZero()) {
            return new SecT571K1Point(eCCurve, eCFieldElement5, eCCurve.b);
        }
        ECFieldElement eCFieldElement6 = eCFieldElement5.square();
        ECFieldElement eCFieldElement7 = bl ? eCFieldElement5 : eCFieldElement5.multiply(eCFieldElement4);
        ECFieldElement eCFieldElement8 = eCFieldElement2.add(eCFieldElement).square();
        if (!bl) {
            eCFieldElement3 = eCFieldElement4.square();
        }
        return new SecT571K1Point(eCCurve, eCFieldElement6, eCFieldElement8.add(eCFieldElement5).add(eCFieldElement4).multiply(eCFieldElement8).add(eCFieldElement3).add(eCFieldElement6).add(eCFieldElement7), new ECFieldElement[]{eCFieldElement7});
    }

    @Override
    public ECPoint twicePlus(ECPoint eCPoint) {
        if (this.isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this.twice();
        }
        ECCurve eCCurve = this.curve;
        ECFieldElement eCFieldElement = this.x;
        if (eCFieldElement.isZero()) {
            return eCPoint;
        }
        ECFieldElement eCFieldElement2 = eCPoint.x;
        ECFieldElement eCFieldElement3 = eCPoint.getZCoord(0);
        if (!eCFieldElement2.isZero() && eCFieldElement3.isOne()) {
            ECFieldElement eCFieldElement4 = this.y;
            ECFieldElement eCFieldElement5 = this.zs[0];
            ECFieldElement eCFieldElement6 = eCPoint.y;
            ECFieldElement eCFieldElement7 = eCFieldElement.square();
            ECFieldElement eCFieldElement8 = eCFieldElement4.square();
            ECFieldElement eCFieldElement9 = eCFieldElement5.square();
            ECFieldElement eCFieldElement10 = eCFieldElement8.add(eCFieldElement4.multiply(eCFieldElement5));
            ECFieldElement eCFieldElement11 = eCFieldElement6.addOne();
            ECFieldElement eCFieldElement12 = eCFieldElement11.multiply(eCFieldElement9).add(eCFieldElement8).multiplyPlusProduct(eCFieldElement10, eCFieldElement7, eCFieldElement9);
            ECFieldElement eCFieldElement13 = eCFieldElement2.multiply(eCFieldElement9);
            ECFieldElement eCFieldElement14 = eCFieldElement13.add(eCFieldElement10).square();
            if (eCFieldElement14.isZero()) {
                if (eCFieldElement12.isZero()) {
                    return eCPoint.twice();
                }
                return eCCurve.getInfinity();
            }
            if (eCFieldElement12.isZero()) {
                return new SecT571K1Point(eCCurve, eCFieldElement12, eCCurve.b);
            }
            ECFieldElement eCFieldElement15 = eCFieldElement12.square().multiply(eCFieldElement13);
            ECFieldElement eCFieldElement16 = eCFieldElement12.multiply(eCFieldElement14).multiply(eCFieldElement9);
            return new SecT571K1Point(eCCurve, eCFieldElement15, eCFieldElement12.add(eCFieldElement14).square().multiplyPlusProduct(eCFieldElement10, eCFieldElement11, eCFieldElement16), new ECFieldElement[]{eCFieldElement16});
        }
        return this.twice().add(eCPoint);
    }
}

