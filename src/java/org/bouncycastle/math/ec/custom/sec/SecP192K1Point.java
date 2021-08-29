/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP192K1Field;
import org.bouncycastle.math.ec.custom.sec.SecP192K1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP192K1Point
extends ECPoint.AbstractFp {
    public SecP192K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecP192K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
        super(eCCurve, eCFieldElement, eCFieldElement2, arreCFieldElement);
    }

    @Override
    public ECPoint add(ECPoint eCPoint) {
        int[] arrn;
        SecP192K1FieldElement secP192K1FieldElement;
        boolean bl;
        ECCurve eCCurve;
        SecP192K1FieldElement secP192K1FieldElement2;
        SecP192K1FieldElement secP192K1FieldElement3;
        SecP192K1FieldElement secP192K1FieldElement4;
        int[] arrn2;
        boolean bl2;
        block16 : {
            int n2;
            block17 : {
                block15 : {
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
                    SecP192K1FieldElement secP192K1FieldElement5 = (SecP192K1FieldElement)this.x;
                    SecP192K1FieldElement secP192K1FieldElement6 = (SecP192K1FieldElement)this.y;
                    SecP192K1FieldElement secP192K1FieldElement7 = (SecP192K1FieldElement)eCPoint.x;
                    SecP192K1FieldElement secP192K1FieldElement8 = (SecP192K1FieldElement)eCPoint.getYCoord();
                    secP192K1FieldElement2 = (SecP192K1FieldElement)this.zs[0];
                    secP192K1FieldElement3 = (SecP192K1FieldElement)eCPoint.getZCoord(0);
                    arrn = new int[12];
                    int[] arrn8 = new int[6];
                    int[] arrn9 = new int[6];
                    int[] arrn10 = new int[6];
                    bl2 = secP192K1FieldElement2.isOne();
                    if (bl2) {
                        arrn5 = secP192K1FieldElement7.x;
                        arrn4 = secP192K1FieldElement8.x;
                    } else {
                        SecP192K1Field.square(secP192K1FieldElement2.x, arrn9);
                        SecP192K1Field.multiply(arrn9, secP192K1FieldElement7.x, arrn8);
                        SecP192K1Field.multiply(arrn9, secP192K1FieldElement2.x, arrn9);
                        SecP192K1Field.multiply(arrn9, secP192K1FieldElement8.x, arrn9);
                        arrn5 = arrn8;
                        arrn4 = arrn9;
                    }
                    bl = secP192K1FieldElement3.isOne();
                    if (bl) {
                        arrn7 = secP192K1FieldElement5.x;
                        arrn3 = secP192K1FieldElement6.x;
                    } else {
                        SecP192K1Field.square(secP192K1FieldElement3.x, arrn10);
                        SecP192K1Field.multiply(arrn10, secP192K1FieldElement5.x, arrn);
                        SecP192K1Field.multiply(arrn10, secP192K1FieldElement3.x, arrn10);
                        SecP192K1Field.multiply(arrn10, secP192K1FieldElement6.x, arrn10);
                        arrn7 = arrn;
                        arrn3 = arrn10;
                    }
                    arrn2 = new int[6];
                    SecP192K1Field.subtract(arrn7, arrn5, arrn2);
                    SecP192K1Field.subtract(arrn3, arrn4, arrn8);
                    if (SecT239Field.isZero2(arrn2)) {
                        if (SecT239Field.isZero2(arrn8)) {
                            return this.twice();
                        }
                        return eCCurve.getInfinity();
                    }
                    int[] arrn11 = new int[12];
                    SecT239Field.square2(arrn2, arrn11);
                    SecP192K1Field.reduce(arrn11, arrn9);
                    int[] arrn12 = new int[6];
                    int[] arrn13 = new int[12];
                    SecT239Field.mul2(arrn9, arrn2, arrn13);
                    SecP192K1Field.reduce(arrn13, arrn12);
                    SecP192K1Field.multiply(arrn9, arrn7, arrn9);
                    if (SecP192K1Field.isZero(arrn12) != 0) {
                        int[] arrn14 = SecP192K1Field.P;
                        SecT239Field.sub2(arrn14, arrn14, arrn12);
                    } else {
                        SecT239Field.sub2(SecP192K1Field.P, arrn12, arrn12);
                    }
                    SecT239Field.mul2(arrn3, arrn12, arrn);
                    SecP192K1Field.reduce32(SecT239Field.addBothTo2(arrn9, arrn9, arrn12), arrn12);
                    secP192K1FieldElement = new SecP192K1FieldElement(arrn10);
                    int[] arrn15 = new int[12];
                    SecT239Field.square2(arrn8, arrn15);
                    SecP192K1Field.reduce(arrn15, arrn10);
                    int[] arrn16 = secP192K1FieldElement.x;
                    SecP192K1Field.subtract(arrn16, arrn12, arrn16);
                    secP192K1FieldElement4 = new SecP192K1FieldElement(arrn12);
                    if (SecT239Field.sub2(arrn9, secP192K1FieldElement.x, arrn12) != 0) {
                        Nat576.sub33From(6, 4553, arrn12);
                    }
                    if (SecT239Field.mulAddTo2(secP192K1FieldElement4.x, arrn8, arrn) != 0) break block15;
                    if (arrn[11] != -1 || !Nat576.gte(n2 = 12, arrn, arrn6 = SecP192K1Field.PExt)) break block16;
                    break block17;
                }
                n2 = 12;
            }
            int[] arrn17 = SecP192K1Field.PExtInv;
            if (Nat576.addTo(arrn17.length, arrn17, arrn) != 0) {
                Nat576.incAt(n2, arrn, arrn17.length);
            }
        }
        SecP192K1Field.reduce(arrn, secP192K1FieldElement4.x);
        SecP192K1FieldElement secP192K1FieldElement9 = new SecP192K1FieldElement(arrn2);
        if (!bl2) {
            SecP192K1Field.multiply(arrn2, secP192K1FieldElement2.x, arrn2);
        }
        if (!bl) {
            int[] arrn18 = secP192K1FieldElement9.x;
            SecP192K1Field.multiply(arrn18, secP192K1FieldElement3.x, arrn18);
        }
        return new SecP192K1Point(eCCurve, secP192K1FieldElement, secP192K1FieldElement4, new ECFieldElement[]{secP192K1FieldElement9});
    }

    @Override
    public ECPoint detach() {
        return new SecP192K1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        return new SecP192K1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        SecP192K1FieldElement secP192K1FieldElement = (SecP192K1FieldElement)this.y;
        if (secP192K1FieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        SecP192K1FieldElement secP192K1FieldElement2 = (SecP192K1FieldElement)this.x;
        SecP192K1FieldElement secP192K1FieldElement3 = (SecP192K1FieldElement)this.zs[0];
        int[] arrn = new int[6];
        SecP192K1Field.square(secP192K1FieldElement.x, arrn);
        int[] arrn2 = new int[6];
        int[] arrn3 = new int[12];
        SecT239Field.square2(arrn, arrn3);
        SecP192K1Field.reduce(arrn3, arrn2);
        int[] arrn4 = new int[6];
        SecP192K1Field.square(secP192K1FieldElement2.x, arrn4);
        SecP192K1Field.reduce32(SecT239Field.addBothTo2(arrn4, arrn4, arrn4), arrn4);
        SecP192K1Field.multiply(arrn, secP192K1FieldElement2.x, arrn);
        SecP192K1Field.reduce32(Nat576.shiftUpBits(6, arrn, 2, 0), arrn);
        int[] arrn5 = new int[6];
        SecP192K1Field.reduce32(Nat576.shiftUpBits(6, arrn2, 3, 0, arrn5), arrn5);
        SecP192K1FieldElement secP192K1FieldElement4 = new SecP192K1FieldElement(arrn2);
        int[] arrn6 = new int[12];
        SecT239Field.square2(arrn4, arrn6);
        SecP192K1Field.reduce(arrn6, arrn2);
        int[] arrn7 = secP192K1FieldElement4.x;
        SecP192K1Field.subtract(arrn7, arrn, arrn7);
        int[] arrn8 = secP192K1FieldElement4.x;
        SecP192K1Field.subtract(arrn8, arrn, arrn8);
        SecP192K1FieldElement secP192K1FieldElement5 = new SecP192K1FieldElement(arrn);
        if (SecT239Field.sub2(arrn, secP192K1FieldElement4.x, arrn) != 0) {
            Nat576.sub33From(6, 4553, arrn);
        }
        int[] arrn9 = secP192K1FieldElement5.x;
        int[] arrn10 = new int[12];
        SecT239Field.mul2(arrn9, arrn4, arrn10);
        SecP192K1Field.reduce(arrn10, arrn9);
        int[] arrn11 = secP192K1FieldElement5.x;
        SecP192K1Field.subtract(arrn11, arrn5, arrn11);
        SecP192K1FieldElement secP192K1FieldElement6 = new SecP192K1FieldElement(arrn4);
        if (Nat576.shiftUpBit(6, secP192K1FieldElement.x, 0, arrn4) != 0 || arrn4[5] == -1 && SecT239Field.gte2(arrn4, SecP192K1Field.P)) {
            Nat576.add33To(6, 4553, arrn4);
        }
        if (!secP192K1FieldElement3.isOne()) {
            int[] arrn12 = secP192K1FieldElement6.x;
            SecP192K1Field.multiply(arrn12, secP192K1FieldElement3.x, arrn12);
        }
        return new SecP192K1Point(eCCurve, secP192K1FieldElement4, secP192K1FieldElement5, new ECFieldElement[]{secP192K1FieldElement6});
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

