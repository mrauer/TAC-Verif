/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP384R1Field;
import org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat576;

public class SecP384R1Point
extends ECPoint.AbstractFp {
    public SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
        super(eCCurve, eCFieldElement, eCFieldElement2, arreCFieldElement);
    }

    @Override
    public ECPoint add(ECPoint eCPoint) {
        int[] arrn;
        int[] arrn2;
        int[] arrn3;
        int n2;
        int[] arrn4;
        int[] arrn5;
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
        SecP384R1FieldElement secP384R1FieldElement = (SecP384R1FieldElement)this.x;
        SecP384R1FieldElement secP384R1FieldElement2 = (SecP384R1FieldElement)this.y;
        SecP384R1FieldElement secP384R1FieldElement3 = (SecP384R1FieldElement)eCPoint.x;
        SecP384R1FieldElement secP384R1FieldElement4 = (SecP384R1FieldElement)eCPoint.getYCoord();
        SecP384R1FieldElement secP384R1FieldElement5 = (SecP384R1FieldElement)this.zs[0];
        SecP384R1FieldElement secP384R1FieldElement6 = (SecP384R1FieldElement)eCPoint.getZCoord(0);
        int[] arrn6 = new int[24];
        int[] arrn7 = new int[24];
        int[] arrn8 = new int[12];
        int[] arrn9 = new int[12];
        boolean bl = secP384R1FieldElement5.isOne();
        if (bl) {
            arrn4 = secP384R1FieldElement3.x;
            arrn3 = secP384R1FieldElement4.x;
        } else {
            SecP384R1Field.square(secP384R1FieldElement5.x, arrn8);
            SecP384R1Field.multiply(arrn8, secP384R1FieldElement3.x, arrn7);
            SecP384R1Field.multiply(arrn8, secP384R1FieldElement5.x, arrn8);
            SecP384R1Field.multiply(arrn8, secP384R1FieldElement4.x, arrn8);
            arrn4 = arrn7;
            arrn3 = arrn8;
        }
        boolean bl2 = secP384R1FieldElement6.isOne();
        if (bl2) {
            arrn5 = secP384R1FieldElement.x;
            arrn = secP384R1FieldElement2.x;
        } else {
            SecP384R1Field.square(secP384R1FieldElement6.x, arrn9);
            SecP384R1Field.multiply(arrn9, secP384R1FieldElement.x, arrn6);
            SecP384R1Field.multiply(arrn9, secP384R1FieldElement6.x, arrn9);
            SecP384R1Field.multiply(arrn9, secP384R1FieldElement2.x, arrn9);
            arrn5 = arrn6;
            arrn = arrn9;
        }
        int[] arrn10 = new int[12];
        SecP384R1Field.subtract(arrn5, arrn4, arrn10);
        int[] arrn11 = new int[12];
        SecP384R1Field.subtract(arrn, arrn3, arrn11);
        if (Nat576.isZero(12, arrn10)) {
            if (Nat576.isZero(12, arrn11)) {
                return this.twice();
            }
            return eCCurve.getInfinity();
        }
        int[] arrn12 = new int[24];
        Interleave.square(arrn10, arrn12);
        SecP384R1Field.reduce(arrn12, arrn8);
        int[] arrn13 = new int[12];
        int[] arrn14 = new int[24];
        Interleave.mul(arrn8, arrn10, arrn14);
        SecP384R1Field.reduce(arrn14, arrn13);
        SecP384R1Field.multiply(arrn8, arrn5, arrn8);
        if (SecP384R1Field.isZero(arrn13) != 0) {
            int[] arrn15 = SecP384R1Field.P;
            n2 = 12;
            Nat576.sub(n2, arrn15, arrn15, arrn13);
        } else {
            n2 = 12;
            Nat576.sub(n2, SecP384R1Field.P, arrn13, arrn13);
        }
        Interleave.mul(arrn, arrn13, arrn6);
        SecP384R1Field.reduce32(Nat576.addBothTo(n2, arrn8, arrn8, arrn13), arrn13);
        SecP384R1FieldElement secP384R1FieldElement7 = new SecP384R1FieldElement(arrn9);
        int[] arrn16 = new int[24];
        Interleave.square(arrn11, arrn16);
        SecP384R1Field.reduce(arrn16, arrn9);
        int[] arrn17 = secP384R1FieldElement7.x;
        SecP384R1Field.subtract(arrn17, arrn13, arrn17);
        SecP384R1FieldElement secP384R1FieldElement8 = new SecP384R1FieldElement(arrn13);
        SecP384R1Field.subtract(arrn8, secP384R1FieldElement7.x, arrn13);
        Interleave.mul(secP384R1FieldElement8.x, arrn11, arrn7);
        if ((Nat576.add(24, arrn6, arrn7, arrn6) != 0 || arrn6[23] == -1 && Nat576.gte(24, arrn6, SecP384R1Field.PExt)) && Nat576.addTo((arrn2 = SecP384R1Field.PExtInv).length, arrn2, arrn6) != 0) {
            Nat576.incAt(24, arrn6, arrn2.length);
        }
        SecP384R1Field.reduce(arrn6, secP384R1FieldElement8.x);
        SecP384R1FieldElement secP384R1FieldElement9 = new SecP384R1FieldElement(arrn10);
        if (!bl) {
            SecP384R1Field.multiply(arrn10, secP384R1FieldElement5.x, arrn10);
        }
        if (!bl2) {
            int[] arrn18 = secP384R1FieldElement9.x;
            SecP384R1Field.multiply(arrn18, secP384R1FieldElement6.x, arrn18);
        }
        return new SecP384R1Point(eCCurve, secP384R1FieldElement7, secP384R1FieldElement8, new ECFieldElement[]{secP384R1FieldElement9});
    }

    @Override
    public ECPoint detach() {
        return new SecP384R1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        return new SecP384R1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        SecP384R1FieldElement secP384R1FieldElement = (SecP384R1FieldElement)this.y;
        if (secP384R1FieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        SecP384R1FieldElement secP384R1FieldElement2 = (SecP384R1FieldElement)this.x;
        SecP384R1FieldElement secP384R1FieldElement3 = (SecP384R1FieldElement)this.zs[0];
        int[] arrn = new int[12];
        int[] arrn2 = new int[12];
        int[] arrn3 = new int[12];
        SecP384R1Field.square(secP384R1FieldElement.x, arrn3);
        int[] arrn4 = new int[12];
        int[] arrn5 = new int[24];
        Interleave.square(arrn3, arrn5);
        SecP384R1Field.reduce(arrn5, arrn4);
        boolean bl = secP384R1FieldElement3.isOne();
        int[] arrn6 = secP384R1FieldElement3.x;
        if (!bl) {
            SecP384R1Field.square(arrn6, arrn2);
            arrn6 = arrn2;
        }
        SecP384R1Field.subtract(secP384R1FieldElement2.x, arrn6, arrn);
        SecP384R1Field.add(secP384R1FieldElement2.x, arrn6, arrn2);
        int[] arrn7 = new int[24];
        Interleave.mul(arrn2, arrn, arrn7);
        SecP384R1Field.reduce(arrn7, arrn2);
        SecP384R1Field.reduce32(Nat576.addBothTo(12, arrn2, arrn2, arrn2), arrn2);
        SecP384R1Field.multiply(arrn3, secP384R1FieldElement2.x, arrn3);
        SecP384R1Field.reduce32(Nat576.shiftUpBits(12, arrn3, 2, 0), arrn3);
        SecP384R1Field.reduce32(Nat576.shiftUpBits(12, arrn4, 3, 0, arrn), arrn);
        SecP384R1FieldElement secP384R1FieldElement4 = new SecP384R1FieldElement(arrn4);
        int[] arrn8 = new int[24];
        Interleave.square(arrn2, arrn8);
        SecP384R1Field.reduce(arrn8, arrn4);
        int[] arrn9 = secP384R1FieldElement4.x;
        SecP384R1Field.subtract(arrn9, arrn3, arrn9);
        int[] arrn10 = secP384R1FieldElement4.x;
        SecP384R1Field.subtract(arrn10, arrn3, arrn10);
        SecP384R1FieldElement secP384R1FieldElement5 = new SecP384R1FieldElement(arrn3);
        SecP384R1Field.subtract(arrn3, secP384R1FieldElement4.x, arrn3);
        int[] arrn11 = secP384R1FieldElement5.x;
        int[] arrn12 = new int[24];
        Interleave.mul(arrn11, arrn2, arrn12);
        SecP384R1Field.reduce(arrn12, arrn11);
        int[] arrn13 = secP384R1FieldElement5.x;
        SecP384R1Field.subtract(arrn13, arrn, arrn13);
        SecP384R1FieldElement secP384R1FieldElement6 = new SecP384R1FieldElement(arrn2);
        if (Nat576.shiftUpBit(12, secP384R1FieldElement.x, 0, arrn2) != 0 || arrn2[11] == -1 && Nat576.gte(12, arrn2, SecP384R1Field.P)) {
            SecP384R1Field.addPInvTo(arrn2);
        }
        if (!bl) {
            int[] arrn14 = secP384R1FieldElement6.x;
            SecP384R1Field.multiply(arrn14, secP384R1FieldElement3.x, arrn14);
        }
        return new SecP384R1Point(eCCurve, secP384R1FieldElement4, secP384R1FieldElement5, new ECFieldElement[]{secP384R1FieldElement6});
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

