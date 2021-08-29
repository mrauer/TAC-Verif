/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP521R1Field;
import org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement;
import org.bouncycastle.math.raw.Nat576;

public class SecP521R1Point
extends ECPoint.AbstractFp {
    public SecP521R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecP521R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
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
        SecP521R1FieldElement secP521R1FieldElement = (SecP521R1FieldElement)this.x;
        SecP521R1FieldElement secP521R1FieldElement2 = (SecP521R1FieldElement)this.y;
        SecP521R1FieldElement secP521R1FieldElement3 = (SecP521R1FieldElement)eCPoint.x;
        SecP521R1FieldElement secP521R1FieldElement4 = (SecP521R1FieldElement)eCPoint.getYCoord();
        SecP521R1FieldElement secP521R1FieldElement5 = (SecP521R1FieldElement)this.zs[0];
        SecP521R1FieldElement secP521R1FieldElement6 = (SecP521R1FieldElement)eCPoint.getZCoord(0);
        int[] arrn5 = new int[17];
        int[] arrn6 = new int[17];
        int[] arrn7 = new int[17];
        int[] arrn8 = new int[17];
        boolean bl = secP521R1FieldElement5.isOne();
        if (bl) {
            arrn3 = secP521R1FieldElement3.x;
            arrn2 = secP521R1FieldElement4.x;
        } else {
            SecP521R1Field.square(secP521R1FieldElement5.x, arrn7);
            SecP521R1Field.multiply(arrn7, secP521R1FieldElement3.x, arrn6);
            SecP521R1Field.multiply(arrn7, secP521R1FieldElement5.x, arrn7);
            SecP521R1Field.multiply(arrn7, secP521R1FieldElement4.x, arrn7);
            arrn3 = arrn6;
            arrn2 = arrn7;
        }
        boolean bl2 = secP521R1FieldElement6.isOne();
        if (bl2) {
            arrn4 = secP521R1FieldElement.x;
            arrn = secP521R1FieldElement2.x;
        } else {
            SecP521R1Field.square(secP521R1FieldElement6.x, arrn8);
            SecP521R1Field.multiply(arrn8, secP521R1FieldElement.x, arrn5);
            SecP521R1Field.multiply(arrn8, secP521R1FieldElement6.x, arrn8);
            SecP521R1Field.multiply(arrn8, secP521R1FieldElement2.x, arrn8);
            arrn4 = arrn5;
            arrn = arrn8;
        }
        int[] arrn9 = new int[17];
        SecP521R1Field.subtract(arrn4, arrn3, arrn9);
        SecP521R1Field.subtract(arrn, arrn2, arrn6);
        if (Nat576.isZero(17, arrn9)) {
            if (Nat576.isZero(17, arrn6)) {
                return this.twice();
            }
            return eCCurve.getInfinity();
        }
        int[] arrn10 = new int[33];
        SecP521R1Field.implSquare(arrn9, arrn10);
        SecP521R1Field.reduce(arrn10, arrn7);
        int[] arrn11 = new int[17];
        SecP521R1Field.multiply(arrn7, arrn9, arrn11);
        SecP521R1Field.multiply(arrn7, arrn4, arrn7);
        SecP521R1Field.multiply(arrn, arrn11, arrn5);
        SecP521R1FieldElement secP521R1FieldElement7 = new SecP521R1FieldElement(arrn8);
        int[] arrn12 = new int[33];
        SecP521R1Field.implSquare(arrn6, arrn12);
        SecP521R1Field.reduce(arrn12, arrn8);
        int[] arrn13 = secP521R1FieldElement7.x;
        SecP521R1Field.add(arrn13, arrn11, arrn13);
        int[] arrn14 = secP521R1FieldElement7.x;
        SecP521R1Field.subtract(arrn14, arrn7, arrn14);
        int[] arrn15 = secP521R1FieldElement7.x;
        SecP521R1Field.subtract(arrn15, arrn7, arrn15);
        SecP521R1FieldElement secP521R1FieldElement8 = new SecP521R1FieldElement(arrn11);
        SecP521R1Field.subtract(arrn7, secP521R1FieldElement7.x, arrn11);
        SecP521R1Field.multiply(secP521R1FieldElement8.x, arrn6, arrn6);
        SecP521R1Field.subtract(arrn6, arrn5, secP521R1FieldElement8.x);
        SecP521R1FieldElement secP521R1FieldElement9 = new SecP521R1FieldElement(arrn9);
        if (!bl) {
            SecP521R1Field.multiply(arrn9, secP521R1FieldElement5.x, arrn9);
        }
        if (!bl2) {
            int[] arrn16 = secP521R1FieldElement9.x;
            SecP521R1Field.multiply(arrn16, secP521R1FieldElement6.x, arrn16);
        }
        return new SecP521R1Point(eCCurve, secP521R1FieldElement7, secP521R1FieldElement8, new ECFieldElement[]{secP521R1FieldElement9});
    }

    @Override
    public ECPoint detach() {
        return new SecP521R1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        return new SecP521R1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        SecP521R1FieldElement secP521R1FieldElement = (SecP521R1FieldElement)this.y;
        if (secP521R1FieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        SecP521R1FieldElement secP521R1FieldElement2 = (SecP521R1FieldElement)this.x;
        SecP521R1FieldElement secP521R1FieldElement3 = (SecP521R1FieldElement)this.zs[0];
        int[] arrn = new int[17];
        int[] arrn2 = new int[17];
        int[] arrn3 = new int[17];
        SecP521R1Field.square(secP521R1FieldElement.x, arrn3);
        int[] arrn4 = new int[17];
        int[] arrn5 = new int[33];
        SecP521R1Field.implSquare(arrn3, arrn5);
        SecP521R1Field.reduce(arrn5, arrn4);
        boolean bl = secP521R1FieldElement3.isOne();
        int[] arrn6 = secP521R1FieldElement3.x;
        if (!bl) {
            SecP521R1Field.square(arrn6, arrn2);
            arrn6 = arrn2;
        }
        SecP521R1Field.subtract(secP521R1FieldElement2.x, arrn6, arrn);
        SecP521R1Field.add(secP521R1FieldElement2.x, arrn6, arrn2);
        SecP521R1Field.multiply(arrn2, arrn, arrn2);
        Nat576.addBothTo(17, arrn2, arrn2, arrn2);
        SecP521R1Field.reduce23(arrn2);
        SecP521R1Field.multiply(arrn3, secP521R1FieldElement2.x, arrn3);
        Nat576.shiftUpBits(17, arrn3, 2, 0);
        SecP521R1Field.reduce23(arrn3);
        Nat576.shiftUpBits(17, arrn4, 3, 0, arrn);
        SecP521R1Field.reduce23(arrn);
        SecP521R1FieldElement secP521R1FieldElement4 = new SecP521R1FieldElement(arrn4);
        int[] arrn7 = new int[33];
        SecP521R1Field.implSquare(arrn2, arrn7);
        SecP521R1Field.reduce(arrn7, arrn4);
        int[] arrn8 = secP521R1FieldElement4.x;
        SecP521R1Field.subtract(arrn8, arrn3, arrn8);
        int[] arrn9 = secP521R1FieldElement4.x;
        SecP521R1Field.subtract(arrn9, arrn3, arrn9);
        SecP521R1FieldElement secP521R1FieldElement5 = new SecP521R1FieldElement(arrn3);
        SecP521R1Field.subtract(arrn3, secP521R1FieldElement4.x, arrn3);
        int[] arrn10 = secP521R1FieldElement5.x;
        SecP521R1Field.multiply(arrn10, arrn2, arrn10);
        int[] arrn11 = secP521R1FieldElement5.x;
        SecP521R1Field.subtract(arrn11, arrn, arrn11);
        SecP521R1FieldElement secP521R1FieldElement6 = new SecP521R1FieldElement(arrn2);
        int[] arrn12 = secP521R1FieldElement.x;
        int n2 = arrn12[16];
        arrn2[16] = 511 & (Nat576.shiftUpBit(16, arrn12, n2 << 23, arrn2) | n2 << 1);
        if (!bl) {
            int[] arrn13 = secP521R1FieldElement6.x;
            SecP521R1Field.multiply(arrn13, secP521R1FieldElement3.x, arrn13);
        }
        return new SecP521R1Point(eCCurve, secP521R1FieldElement4, secP521R1FieldElement5, new ECFieldElement[]{secP521R1FieldElement6});
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

