/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP160R2Field;
import org.bouncycastle.math.ec.custom.sec.SecP160R2FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP160K1Point
extends ECPoint.AbstractFp {
    public SecP160K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecP160K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
        super(eCCurve, eCFieldElement, eCFieldElement2, arreCFieldElement);
    }

    @Override
    public ECPoint add(ECPoint eCPoint) {
        int[] arrn;
        int[] arrn2;
        int[] arrn3;
        int[] arrn4;
        if (this.isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        if (this == eCPoint) {
            return this.twice();
        }
        ECCurve eCCurve = this.curve;
        SecP160R2FieldElement secP160R2FieldElement = (SecP160R2FieldElement)this.x;
        SecP160R2FieldElement secP160R2FieldElement2 = (SecP160R2FieldElement)this.y;
        SecP160R2FieldElement secP160R2FieldElement3 = (SecP160R2FieldElement)eCPoint.x;
        SecP160R2FieldElement secP160R2FieldElement4 = (SecP160R2FieldElement)eCPoint.getYCoord();
        SecP160R2FieldElement secP160R2FieldElement5 = (SecP160R2FieldElement)this.zs[0];
        SecP160R2FieldElement secP160R2FieldElement6 = (SecP160R2FieldElement)eCPoint.getZCoord(0);
        int[] arrn5 = new int[10];
        int[] arrn6 = new int[5];
        int[] arrn7 = new int[5];
        int[] arrn8 = new int[5];
        boolean bl = secP160R2FieldElement5.isOne();
        if (bl) {
            arrn3 = secP160R2FieldElement3.x;
            arrn2 = secP160R2FieldElement4.x;
        } else {
            SecP160R2Field.square(secP160R2FieldElement5.x, arrn7);
            SecP160R2Field.multiply(arrn7, secP160R2FieldElement3.x, arrn6);
            SecP160R2Field.multiply(arrn7, secP160R2FieldElement5.x, arrn7);
            SecP160R2Field.multiply(arrn7, secP160R2FieldElement4.x, arrn7);
            arrn3 = arrn6;
            arrn2 = arrn7;
        }
        boolean bl2 = secP160R2FieldElement6.isOne();
        if (bl2) {
            arrn4 = secP160R2FieldElement.x;
            arrn = secP160R2FieldElement2.x;
        } else {
            SecP160R2Field.square(secP160R2FieldElement6.x, arrn8);
            SecP160R2Field.multiply(arrn8, secP160R2FieldElement.x, arrn5);
            SecP160R2Field.multiply(arrn8, secP160R2FieldElement6.x, arrn8);
            SecP160R2Field.multiply(arrn8, secP160R2FieldElement2.x, arrn8);
            arrn4 = arrn5;
            arrn = arrn8;
        }
        int[] arrn9 = new int[5];
        SecP160R2Field.subtract(arrn4, arrn3, arrn9);
        SecP160R2Field.subtract(arrn, arrn2, arrn6);
        if (SecT239Field.isZero1(arrn9)) {
            if (SecT239Field.isZero1(arrn6)) {
                return this.twice();
            }
            return eCCurve.getInfinity();
        }
        int[] arrn10 = new int[10];
        SecT239Field.square1(arrn9, arrn10);
        SecP160R2Field.reduce(arrn10, arrn7);
        int[] arrn11 = new int[5];
        int[] arrn12 = new int[10];
        SecT239Field.mul1(arrn7, arrn9, arrn12);
        SecP160R2Field.reduce(arrn12, arrn11);
        SecP160R2Field.multiply(arrn7, arrn4, arrn7);
        SecP160R2Field.negate(arrn11, arrn11);
        SecT239Field.mul1(arrn, arrn11, arrn5);
        SecP160R2Field.reduce32(SecT239Field.addBothTo1(arrn7, arrn7, arrn11), arrn11);
        SecP160R2FieldElement secP160R2FieldElement7 = new SecP160R2FieldElement(arrn8);
        int[] arrn13 = new int[10];
        SecT239Field.square1(arrn6, arrn13);
        SecP160R2Field.reduce(arrn13, arrn8);
        int[] arrn14 = secP160R2FieldElement7.x;
        SecP160R2Field.subtract(arrn14, arrn11, arrn14);
        SecP160R2FieldElement secP160R2FieldElement8 = new SecP160R2FieldElement(arrn11);
        if (SecT239Field.sub1(arrn7, secP160R2FieldElement7.x, arrn11) != 0) {
            Nat576.sub33From(5, 21389, arrn11);
        }
        SecP160R2Field.multiplyAddToExt(secP160R2FieldElement8.x, arrn6, arrn5);
        SecP160R2Field.reduce(arrn5, secP160R2FieldElement8.x);
        SecP160R2FieldElement secP160R2FieldElement9 = new SecP160R2FieldElement(arrn9);
        if (!bl) {
            SecP160R2Field.multiply(arrn9, secP160R2FieldElement5.x, arrn9);
        }
        if (!bl2) {
            int[] arrn15 = secP160R2FieldElement9.x;
            SecP160R2Field.multiply(arrn15, secP160R2FieldElement6.x, arrn15);
        }
        return new SecP160K1Point(eCCurve, secP160R2FieldElement7, secP160R2FieldElement8, new ECFieldElement[]{secP160R2FieldElement9});
    }

    @Override
    public ECPoint detach() {
        return new SecP160K1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        return new SecP160K1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        SecP160R2FieldElement secP160R2FieldElement = (SecP160R2FieldElement)this.y;
        if (secP160R2FieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        SecP160R2FieldElement secP160R2FieldElement2 = (SecP160R2FieldElement)this.x;
        SecP160R2FieldElement secP160R2FieldElement3 = (SecP160R2FieldElement)this.zs[0];
        int[] arrn = new int[5];
        SecP160R2Field.square(secP160R2FieldElement.x, arrn);
        int[] arrn2 = new int[5];
        int[] arrn3 = new int[10];
        SecT239Field.square1(arrn, arrn3);
        SecP160R2Field.reduce(arrn3, arrn2);
        int[] arrn4 = new int[5];
        SecP160R2Field.square(secP160R2FieldElement2.x, arrn4);
        SecP160R2Field.reduce32(SecT239Field.addBothTo1(arrn4, arrn4, arrn4), arrn4);
        SecP160R2Field.multiply(arrn, secP160R2FieldElement2.x, arrn);
        SecP160R2Field.reduce32(Nat576.shiftUpBits(5, arrn, 2, 0), arrn);
        int[] arrn5 = new int[5];
        SecP160R2Field.reduce32(Nat576.shiftUpBits(5, arrn2, 3, 0, arrn5), arrn5);
        SecP160R2FieldElement secP160R2FieldElement4 = new SecP160R2FieldElement(arrn2);
        int[] arrn6 = new int[10];
        SecT239Field.square1(arrn4, arrn6);
        SecP160R2Field.reduce(arrn6, arrn2);
        int[] arrn7 = secP160R2FieldElement4.x;
        SecP160R2Field.subtract(arrn7, arrn, arrn7);
        int[] arrn8 = secP160R2FieldElement4.x;
        SecP160R2Field.subtract(arrn8, arrn, arrn8);
        SecP160R2FieldElement secP160R2FieldElement5 = new SecP160R2FieldElement(arrn);
        if (SecT239Field.sub1(arrn, secP160R2FieldElement4.x, arrn) != 0) {
            Nat576.sub33From(5, 21389, arrn);
        }
        int[] arrn9 = secP160R2FieldElement5.x;
        int[] arrn10 = new int[10];
        SecT239Field.mul1(arrn9, arrn4, arrn10);
        SecP160R2Field.reduce(arrn10, arrn9);
        int[] arrn11 = secP160R2FieldElement5.x;
        SecP160R2Field.subtract(arrn11, arrn5, arrn11);
        SecP160R2FieldElement secP160R2FieldElement6 = new SecP160R2FieldElement(arrn4);
        SecP160R2Field.twice(secP160R2FieldElement.x, arrn4);
        if (!secP160R2FieldElement3.isOne()) {
            int[] arrn12 = secP160R2FieldElement6.x;
            SecP160R2Field.multiply(arrn12, secP160R2FieldElement3.x, arrn12);
        }
        return new SecP160K1Point(eCCurve, secP160R2FieldElement4, secP160R2FieldElement5, new ECFieldElement[]{secP160R2FieldElement6});
    }

    @Override
    public ECPoint twicePlus(ECPoint eCPoint) {
        if (this == eCPoint) {
            if (!this.isInfinity() && !this.y.isZero()) {
                return this.twice().add(this);
            }
            return this;
        }
        if (this.isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this.twice();
        }
        if (this.y.isZero()) {
            return eCPoint;
        }
        return this.twice().add(eCPoint);
    }
}

