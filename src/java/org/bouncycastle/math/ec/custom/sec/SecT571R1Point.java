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
import org.bouncycastle.math.ec.custom.sec.SecT571R1Curve;
import org.bouncycastle.math.raw.Nat576;

public class SecT571R1Point
extends ECPoint.AbstractF2m {
    public SecT571R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecT571R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
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
            secT571FieldElement3 = (SecT571FieldElement)eCFieldElement2.square().add(eCFieldElement2).add(secT571FieldElement10).addOne();
            if (secT571FieldElement3.isZero()) {
                return new SecT571R1Point(eCCurve, secT571FieldElement3, SecT571R1Curve.SecT571R1_B_SQRT);
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
                return new SecT571R1Point(eCCurve, secT571FieldElement11, SecT571R1Curve.SecT571R1_B_SQRT);
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
        return new SecT571R1Point(eCCurve, secT571FieldElement3, secT571FieldElement, new ECFieldElement[]{secT571FieldElement2});
    }

    @Override
    public ECPoint detach() {
        return new SecT571R1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
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
        return new SecT571R1Point(this.curve, eCFieldElement, eCFieldElement2.add(eCFieldElement3), new ECFieldElement[]{eCFieldElement3});
    }

    @Override
    public ECPoint twice() {
        long[] arrl;
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        SecT571FieldElement secT571FieldElement = (SecT571FieldElement)this.x;
        if (secT571FieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        SecT571FieldElement secT571FieldElement2 = (SecT571FieldElement)this.y;
        SecT571FieldElement secT571FieldElement3 = (SecT571FieldElement)this.zs[0];
        long[] arrl2 = new long[9];
        long[] arrl3 = new long[9];
        long[] arrl4 = secT571FieldElement3.isOne() ? null : SecT571Field.precompMultiplicand(secT571FieldElement3.x);
        long[] arrl5 = secT571FieldElement2.x;
        if (arrl4 == null) {
            arrl = secT571FieldElement3.x;
        } else {
            SecT571Field.multiplyPrecomp(arrl5, arrl4, arrl2);
            SecT571Field.square(secT571FieldElement3.x, arrl3);
            arrl5 = arrl2;
            arrl = arrl3;
        }
        long[] arrl6 = new long[9];
        SecT571Field.square(secT571FieldElement2.x, arrl6);
        SecT571Field.addBothTo(arrl5, arrl, arrl6);
        if (Nat576.isZero64(arrl6)) {
            return new SecT571R1Point(eCCurve, new SecT571FieldElement(arrl6), SecT571R1Curve.SecT571R1_B_SQRT);
        }
        long[] arrl7 = new long[18];
        SecT571Field.multiplyAddToExt(arrl6, arrl5, arrl7);
        SecT571FieldElement secT571FieldElement4 = new SecT571FieldElement(arrl2);
        SecT571Field.square(arrl6, arrl2);
        SecT571FieldElement secT571FieldElement5 = new SecT571FieldElement(arrl6);
        if (arrl4 != null) {
            SecT571Field.multiply(arrl6, arrl, arrl6);
        }
        long[] arrl8 = secT571FieldElement.x;
        if (arrl4 != null) {
            SecT571Field.multiplyPrecomp(arrl8, arrl4, arrl3);
            arrl8 = arrl3;
        }
        SecT571Field.squareAddToExt(arrl8, arrl7);
        SecT571Field.reduce(arrl7, arrl3);
        SecT571Field.addBothTo(secT571FieldElement4.x, secT571FieldElement5.x, arrl3);
        return new SecT571R1Point(eCCurve, secT571FieldElement4, new SecT571FieldElement(arrl3), new ECFieldElement[]{secT571FieldElement5});
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
        SecT571FieldElement secT571FieldElement = (SecT571FieldElement)this.x;
        if (secT571FieldElement.isZero()) {
            return eCPoint;
        }
        SecT571FieldElement secT571FieldElement2 = (SecT571FieldElement)eCPoint.x;
        SecT571FieldElement secT571FieldElement3 = (SecT571FieldElement)eCPoint.getZCoord(0);
        if (!secT571FieldElement2.isZero() && secT571FieldElement3.isOne()) {
            SecT571FieldElement secT571FieldElement4 = (SecT571FieldElement)this.y;
            SecT571FieldElement secT571FieldElement5 = (SecT571FieldElement)this.zs[0];
            SecT571FieldElement secT571FieldElement6 = (SecT571FieldElement)eCPoint.y;
            long[] arrl = new long[9];
            long[] arrl2 = new long[9];
            long[] arrl3 = new long[9];
            long[] arrl4 = new long[9];
            SecT571Field.square(secT571FieldElement.x, arrl);
            SecT571Field.square(secT571FieldElement4.x, arrl2);
            SecT571Field.square(secT571FieldElement5.x, arrl3);
            SecT571Field.multiply(secT571FieldElement4.x, secT571FieldElement5.x, arrl4);
            SecT571Field.addBothTo(arrl3, arrl2, arrl4);
            long[] arrl5 = SecT571Field.precompMultiplicand(arrl3);
            SecT571Field.multiplyPrecomp(secT571FieldElement6.x, arrl5, arrl3);
            SecT571Field.add(arrl3, arrl2, arrl3);
            long[] arrl6 = new long[18];
            SecT571Field.multiplyAddToExt(arrl3, arrl4, arrl6);
            long[] arrl7 = new long[18];
            SecT571Field.implMultiplyPrecomp(arrl, arrl5, arrl7);
            SecT571Field.addExt(arrl6, arrl7, arrl6);
            SecT571Field.reduce(arrl6, arrl3);
            SecT571Field.multiplyPrecomp(secT571FieldElement2.x, arrl5, arrl);
            SecT571Field.add(arrl, arrl4, arrl2);
            SecT571Field.square(arrl2, arrl2);
            if (Nat576.isZero64(arrl2)) {
                if (Nat576.isZero64(arrl3)) {
                    return eCPoint.twice();
                }
                return eCCurve.getInfinity();
            }
            if (Nat576.isZero64(arrl3)) {
                return new SecT571R1Point(eCCurve, new SecT571FieldElement(arrl3), SecT571R1Curve.SecT571R1_B_SQRT);
            }
            SecT571FieldElement secT571FieldElement7 = new SecT571FieldElement();
            SecT571Field.square(arrl3, secT571FieldElement7.x);
            long[] arrl8 = secT571FieldElement7.x;
            SecT571Field.multiply(arrl8, arrl, arrl8);
            SecT571FieldElement secT571FieldElement8 = new SecT571FieldElement(arrl);
            SecT571Field.multiply(arrl3, arrl2, arrl);
            long[] arrl9 = secT571FieldElement8.x;
            SecT571Field.multiplyPrecomp(arrl9, arrl5, arrl9);
            SecT571FieldElement secT571FieldElement9 = new SecT571FieldElement(arrl2);
            SecT571Field.add(arrl3, arrl2, arrl2);
            long[] arrl10 = secT571FieldElement9.x;
            SecT571Field.square(arrl10, arrl10);
            for (int i2 = 0; i2 < 18; ++i2) {
                arrl6[i2] = 0L;
            }
            SecT571Field.multiplyAddToExt(secT571FieldElement9.x, arrl4, arrl6);
            SecT571Field.addOne(secT571FieldElement6.x, arrl4);
            SecT571Field.multiplyAddToExt(arrl4, secT571FieldElement8.x, arrl6);
            SecT571Field.reduce(arrl6, secT571FieldElement9.x);
            return new SecT571R1Point(eCCurve, secT571FieldElement7, secT571FieldElement9, new ECFieldElement[]{secT571FieldElement8});
        }
        return this.twice().add(eCPoint);
    }
}

