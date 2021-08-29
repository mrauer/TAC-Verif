/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP192R1Field;
import org.bouncycastle.math.ec.custom.sec.SecP192R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP192R1Point
extends ECPoint.AbstractFp {
    public SecP192R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecP192R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
        super(eCCurve, eCFieldElement, eCFieldElement2, arreCFieldElement);
    }

    @Override
    public ECPoint add(ECPoint eCPoint) {
        int[] arrn;
        SecP192R1FieldElement secP192R1FieldElement;
        boolean bl;
        ECCurve eCCurve;
        SecP192R1FieldElement secP192R1FieldElement2;
        SecP192R1FieldElement secP192R1FieldElement3;
        SecP192R1FieldElement secP192R1FieldElement4;
        int[] arrn2;
        boolean bl2;
        block15 : {
            int n2;
            block16 : {
                block14 : {
                    int[] arrn3;
                    int[] arrn4;
                    int[] arrn5;
                    int[] arrn6;
                    int[] arrn7;
                    if (this.isInfinity()) {
                        return eCPoint;
                    }
                    if (eCPoint.isInfinity()) {
                        return this;
                    }
                    if (this == eCPoint) {
                        return this.twice();
                    }
                    eCCurve = this.curve;
                    SecP192R1FieldElement secP192R1FieldElement5 = (SecP192R1FieldElement)this.x;
                    SecP192R1FieldElement secP192R1FieldElement6 = (SecP192R1FieldElement)this.y;
                    SecP192R1FieldElement secP192R1FieldElement7 = (SecP192R1FieldElement)eCPoint.x;
                    SecP192R1FieldElement secP192R1FieldElement8 = (SecP192R1FieldElement)eCPoint.getYCoord();
                    secP192R1FieldElement = (SecP192R1FieldElement)this.zs[0];
                    secP192R1FieldElement4 = (SecP192R1FieldElement)eCPoint.getZCoord(0);
                    arrn = new int[12];
                    int[] arrn8 = new int[6];
                    int[] arrn9 = new int[6];
                    int[] arrn10 = new int[6];
                    bl2 = secP192R1FieldElement.isOne();
                    if (bl2) {
                        arrn5 = secP192R1FieldElement7.x;
                        arrn4 = secP192R1FieldElement8.x;
                    } else {
                        SecP192R1Field.square(secP192R1FieldElement.x, arrn9);
                        SecP192R1Field.multiply(arrn9, secP192R1FieldElement7.x, arrn8);
                        SecP192R1Field.multiply(arrn9, secP192R1FieldElement.x, arrn9);
                        SecP192R1Field.multiply(arrn9, secP192R1FieldElement8.x, arrn9);
                        arrn5 = arrn8;
                        arrn4 = arrn9;
                    }
                    bl = secP192R1FieldElement4.isOne();
                    if (bl) {
                        arrn7 = secP192R1FieldElement5.x;
                        arrn3 = secP192R1FieldElement6.x;
                    } else {
                        SecP192R1Field.square(secP192R1FieldElement4.x, arrn10);
                        SecP192R1Field.multiply(arrn10, secP192R1FieldElement5.x, arrn);
                        SecP192R1Field.multiply(arrn10, secP192R1FieldElement4.x, arrn10);
                        SecP192R1Field.multiply(arrn10, secP192R1FieldElement6.x, arrn10);
                        arrn7 = arrn;
                        arrn3 = arrn10;
                    }
                    arrn2 = new int[6];
                    SecP192R1Field.subtract(arrn7, arrn5, arrn2);
                    SecP192R1Field.subtract(arrn3, arrn4, arrn8);
                    if (SecT239Field.isZero2(arrn2)) {
                        if (SecT239Field.isZero2(arrn8)) {
                            return this.twice();
                        }
                        return eCCurve.getInfinity();
                    }
                    int[] arrn11 = new int[12];
                    SecT239Field.square2(arrn2, arrn11);
                    SecP192R1Field.reduce(arrn11, arrn9);
                    int[] arrn12 = new int[6];
                    int[] arrn13 = new int[12];
                    SecT239Field.mul2(arrn9, arrn2, arrn13);
                    SecP192R1Field.reduce(arrn13, arrn12);
                    SecP192R1Field.multiply(arrn9, arrn7, arrn9);
                    if (SecP192R1Field.isZero(arrn12) != 0) {
                        int[] arrn14 = SecP192R1Field.P;
                        SecT239Field.sub2(arrn14, arrn14, arrn12);
                    } else {
                        SecT239Field.sub2(SecP192R1Field.P, arrn12, arrn12);
                    }
                    SecT239Field.mul2(arrn3, arrn12, arrn);
                    SecP192R1Field.reduce32(SecT239Field.addBothTo2(arrn9, arrn9, arrn12), arrn12);
                    secP192R1FieldElement2 = new SecP192R1FieldElement(arrn10);
                    int[] arrn15 = new int[12];
                    SecT239Field.square2(arrn8, arrn15);
                    SecP192R1Field.reduce(arrn15, arrn10);
                    int[] arrn16 = secP192R1FieldElement2.x;
                    SecP192R1Field.subtract(arrn16, arrn12, arrn16);
                    secP192R1FieldElement3 = new SecP192R1FieldElement(arrn12);
                    SecP192R1Field.subtract(arrn9, secP192R1FieldElement2.x, arrn12);
                    if (SecT239Field.mulAddTo2(secP192R1FieldElement3.x, arrn8, arrn) != 0) break block14;
                    if (arrn[11] != -1 || !Nat576.gte(n2 = 12, arrn, arrn6 = SecP192R1Field.PExt)) break block15;
                    break block16;
                }
                n2 = 12;
            }
            int[] arrn17 = SecP192R1Field.PExtInv;
            if (Nat576.addTo(arrn17.length, arrn17, arrn) != 0) {
                Nat576.incAt(n2, arrn, arrn17.length);
            }
        }
        SecP192R1Field.reduce(arrn, secP192R1FieldElement3.x);
        SecP192R1FieldElement secP192R1FieldElement9 = new SecP192R1FieldElement(arrn2);
        if (!bl2) {
            SecP192R1Field.multiply(arrn2, secP192R1FieldElement.x, arrn2);
        }
        if (!bl) {
            int[] arrn18 = secP192R1FieldElement9.x;
            SecP192R1Field.multiply(arrn18, secP192R1FieldElement4.x, arrn18);
        }
        return new SecP192R1Point(eCCurve, secP192R1FieldElement2, secP192R1FieldElement3, new ECFieldElement[]{secP192R1FieldElement9});
    }

    @Override
    public ECPoint detach() {
        return new SecP192R1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        return new SecP192R1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        SecP192R1FieldElement secP192R1FieldElement = (SecP192R1FieldElement)this.y;
        if (secP192R1FieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        SecP192R1FieldElement secP192R1FieldElement2 = (SecP192R1FieldElement)this.x;
        SecP192R1FieldElement secP192R1FieldElement3 = (SecP192R1FieldElement)this.zs[0];
        int[] arrn = new int[6];
        int[] arrn2 = new int[6];
        int[] arrn3 = new int[6];
        SecP192R1Field.square(secP192R1FieldElement.x, arrn3);
        int[] arrn4 = new int[6];
        int[] arrn5 = new int[12];
        SecT239Field.square2(arrn3, arrn5);
        SecP192R1Field.reduce(arrn5, arrn4);
        boolean bl = secP192R1FieldElement3.isOne();
        int[] arrn6 = secP192R1FieldElement3.x;
        if (!bl) {
            SecP192R1Field.square(arrn6, arrn2);
            arrn6 = arrn2;
        }
        SecP192R1Field.subtract(secP192R1FieldElement2.x, arrn6, arrn);
        SecP192R1Field.add(secP192R1FieldElement2.x, arrn6, arrn2);
        int[] arrn7 = new int[12];
        SecT239Field.mul2(arrn2, arrn, arrn7);
        SecP192R1Field.reduce(arrn7, arrn2);
        SecP192R1Field.reduce32(SecT239Field.addBothTo2(arrn2, arrn2, arrn2), arrn2);
        SecP192R1Field.multiply(arrn3, secP192R1FieldElement2.x, arrn3);
        SecP192R1Field.reduce32(Nat576.shiftUpBits(6, arrn3, 2, 0), arrn3);
        SecP192R1Field.reduce32(Nat576.shiftUpBits(6, arrn4, 3, 0, arrn), arrn);
        SecP192R1FieldElement secP192R1FieldElement4 = new SecP192R1FieldElement(arrn4);
        int[] arrn8 = new int[12];
        SecT239Field.square2(arrn2, arrn8);
        SecP192R1Field.reduce(arrn8, arrn4);
        int[] arrn9 = secP192R1FieldElement4.x;
        SecP192R1Field.subtract(arrn9, arrn3, arrn9);
        int[] arrn10 = secP192R1FieldElement4.x;
        SecP192R1Field.subtract(arrn10, arrn3, arrn10);
        SecP192R1FieldElement secP192R1FieldElement5 = new SecP192R1FieldElement(arrn3);
        SecP192R1Field.subtract(arrn3, secP192R1FieldElement4.x, arrn3);
        int[] arrn11 = secP192R1FieldElement5.x;
        int[] arrn12 = new int[12];
        SecT239Field.mul2(arrn11, arrn2, arrn12);
        SecP192R1Field.reduce(arrn12, arrn11);
        int[] arrn13 = secP192R1FieldElement5.x;
        SecP192R1Field.subtract(arrn13, arrn, arrn13);
        SecP192R1FieldElement secP192R1FieldElement6 = new SecP192R1FieldElement(arrn2);
        if (Nat576.shiftUpBit(6, secP192R1FieldElement.x, 0, arrn2) != 0 || arrn2[5] == -1 && SecT239Field.gte2(arrn2, SecP192R1Field.P)) {
            SecP192R1Field.addPInvTo(arrn2);
        }
        if (!bl) {
            int[] arrn14 = secP192R1FieldElement6.x;
            SecP192R1Field.multiply(arrn14, secP192R1FieldElement3.x, arrn14);
        }
        return new SecP192R1Point(eCCurve, secP192R1FieldElement4, secP192R1FieldElement5, new ECFieldElement[]{secP192R1FieldElement6});
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

