/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP160R1Field;
import org.bouncycastle.math.ec.custom.sec.SecP160R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP160R1Point
extends ECPoint.AbstractFp {
    public SecP160R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecP160R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
        super(eCCurve, eCFieldElement, eCFieldElement2, arreCFieldElement);
    }

    @Override
    public ECPoint add(ECPoint eCPoint) {
        int[] arrn;
        SecP160R1FieldElement secP160R1FieldElement;
        boolean bl;
        ECCurve eCCurve;
        SecP160R1FieldElement secP160R1FieldElement2;
        SecP160R1FieldElement secP160R1FieldElement3;
        SecP160R1FieldElement secP160R1FieldElement4;
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
                    SecP160R1FieldElement secP160R1FieldElement5 = (SecP160R1FieldElement)this.x;
                    SecP160R1FieldElement secP160R1FieldElement6 = (SecP160R1FieldElement)this.y;
                    SecP160R1FieldElement secP160R1FieldElement7 = (SecP160R1FieldElement)eCPoint.x;
                    SecP160R1FieldElement secP160R1FieldElement8 = (SecP160R1FieldElement)eCPoint.getYCoord();
                    secP160R1FieldElement2 = (SecP160R1FieldElement)this.zs[0];
                    secP160R1FieldElement4 = (SecP160R1FieldElement)eCPoint.getZCoord(0);
                    arrn = new int[10];
                    int[] arrn8 = new int[5];
                    int[] arrn9 = new int[5];
                    int[] arrn10 = new int[5];
                    bl2 = secP160R1FieldElement2.isOne();
                    if (bl2) {
                        arrn5 = secP160R1FieldElement7.x;
                        arrn4 = secP160R1FieldElement8.x;
                    } else {
                        SecP160R1Field.square(secP160R1FieldElement2.x, arrn9);
                        SecP160R1Field.multiply(arrn9, secP160R1FieldElement7.x, arrn8);
                        SecP160R1Field.multiply(arrn9, secP160R1FieldElement2.x, arrn9);
                        SecP160R1Field.multiply(arrn9, secP160R1FieldElement8.x, arrn9);
                        arrn5 = arrn8;
                        arrn4 = arrn9;
                    }
                    bl = secP160R1FieldElement4.isOne();
                    if (bl) {
                        arrn7 = secP160R1FieldElement5.x;
                        arrn3 = secP160R1FieldElement6.x;
                    } else {
                        SecP160R1Field.square(secP160R1FieldElement4.x, arrn10);
                        SecP160R1Field.multiply(arrn10, secP160R1FieldElement5.x, arrn);
                        SecP160R1Field.multiply(arrn10, secP160R1FieldElement4.x, arrn10);
                        SecP160R1Field.multiply(arrn10, secP160R1FieldElement6.x, arrn10);
                        arrn7 = arrn;
                        arrn3 = arrn10;
                    }
                    arrn2 = new int[5];
                    SecP160R1Field.subtract(arrn7, arrn5, arrn2);
                    SecP160R1Field.subtract(arrn3, arrn4, arrn8);
                    if (SecT239Field.isZero1(arrn2)) {
                        if (SecT239Field.isZero1(arrn8)) {
                            return this.twice();
                        }
                        return eCCurve.getInfinity();
                    }
                    int[] arrn11 = new int[10];
                    SecT239Field.square1(arrn2, arrn11);
                    SecP160R1Field.reduce(arrn11, arrn9);
                    int[] arrn12 = new int[5];
                    int[] arrn13 = new int[10];
                    SecT239Field.mul1(arrn9, arrn2, arrn13);
                    SecP160R1Field.reduce(arrn13, arrn12);
                    SecP160R1Field.multiply(arrn9, arrn7, arrn9);
                    if (SecP160R1Field.isZero(arrn12) != 0) {
                        int[] arrn14 = SecP160R1Field.P;
                        SecT239Field.sub1(arrn14, arrn14, arrn12);
                    } else {
                        SecT239Field.sub1(SecP160R1Field.P, arrn12, arrn12);
                    }
                    SecT239Field.mul1(arrn3, arrn12, arrn);
                    SecP160R1Field.reduce32(SecT239Field.addBothTo1(arrn9, arrn9, arrn12), arrn12);
                    secP160R1FieldElement3 = new SecP160R1FieldElement(arrn10);
                    int[] arrn15 = new int[10];
                    SecT239Field.square1(arrn8, arrn15);
                    SecP160R1Field.reduce(arrn15, arrn10);
                    int[] arrn16 = secP160R1FieldElement3.x;
                    SecP160R1Field.subtract(arrn16, arrn12, arrn16);
                    secP160R1FieldElement = new SecP160R1FieldElement(arrn12);
                    SecP160R1Field.subtract(arrn9, secP160R1FieldElement3.x, arrn12);
                    if (SecT239Field.mulAddTo1(secP160R1FieldElement.x, arrn8, arrn) != 0) break block14;
                    if (arrn[9] != -1 || !Nat576.gte(n2 = 10, arrn, arrn6 = SecP160R1Field.PExt)) break block15;
                    break block16;
                }
                n2 = 10;
            }
            int[] arrn17 = SecP160R1Field.PExtInv;
            if (Nat576.addTo(arrn17.length, arrn17, arrn) != 0) {
                Nat576.incAt(n2, arrn, arrn17.length);
            }
        }
        SecP160R1Field.reduce(arrn, secP160R1FieldElement.x);
        SecP160R1FieldElement secP160R1FieldElement9 = new SecP160R1FieldElement(arrn2);
        if (!bl2) {
            SecP160R1Field.multiply(arrn2, secP160R1FieldElement2.x, arrn2);
        }
        if (!bl) {
            int[] arrn18 = secP160R1FieldElement9.x;
            SecP160R1Field.multiply(arrn18, secP160R1FieldElement4.x, arrn18);
        }
        return new SecP160R1Point(eCCurve, secP160R1FieldElement3, secP160R1FieldElement, new ECFieldElement[]{secP160R1FieldElement9});
    }

    @Override
    public ECPoint detach() {
        return new SecP160R1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        return new SecP160R1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        SecP160R1FieldElement secP160R1FieldElement = (SecP160R1FieldElement)this.y;
        if (secP160R1FieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        SecP160R1FieldElement secP160R1FieldElement2 = (SecP160R1FieldElement)this.x;
        SecP160R1FieldElement secP160R1FieldElement3 = (SecP160R1FieldElement)this.zs[0];
        int[] arrn = new int[5];
        int[] arrn2 = new int[5];
        int[] arrn3 = new int[5];
        SecP160R1Field.square(secP160R1FieldElement.x, arrn3);
        int[] arrn4 = new int[5];
        int[] arrn5 = new int[10];
        SecT239Field.square1(arrn3, arrn5);
        SecP160R1Field.reduce(arrn5, arrn4);
        boolean bl = secP160R1FieldElement3.isOne();
        int[] arrn6 = secP160R1FieldElement3.x;
        if (!bl) {
            SecP160R1Field.square(arrn6, arrn2);
            arrn6 = arrn2;
        }
        SecP160R1Field.subtract(secP160R1FieldElement2.x, arrn6, arrn);
        SecP160R1Field.add(secP160R1FieldElement2.x, arrn6, arrn2);
        int[] arrn7 = new int[10];
        SecT239Field.mul1(arrn2, arrn, arrn7);
        SecP160R1Field.reduce(arrn7, arrn2);
        SecP160R1Field.reduce32(SecT239Field.addBothTo1(arrn2, arrn2, arrn2), arrn2);
        SecP160R1Field.multiply(arrn3, secP160R1FieldElement2.x, arrn3);
        SecP160R1Field.reduce32(Nat576.shiftUpBits(5, arrn3, 2, 0), arrn3);
        SecP160R1Field.reduce32(Nat576.shiftUpBits(5, arrn4, 3, 0, arrn), arrn);
        SecP160R1FieldElement secP160R1FieldElement4 = new SecP160R1FieldElement(arrn4);
        int[] arrn8 = new int[10];
        SecT239Field.square1(arrn2, arrn8);
        SecP160R1Field.reduce(arrn8, arrn4);
        int[] arrn9 = secP160R1FieldElement4.x;
        SecP160R1Field.subtract(arrn9, arrn3, arrn9);
        int[] arrn10 = secP160R1FieldElement4.x;
        SecP160R1Field.subtract(arrn10, arrn3, arrn10);
        SecP160R1FieldElement secP160R1FieldElement5 = new SecP160R1FieldElement(arrn3);
        SecP160R1Field.subtract(arrn3, secP160R1FieldElement4.x, arrn3);
        int[] arrn11 = secP160R1FieldElement5.x;
        int[] arrn12 = new int[10];
        SecT239Field.mul1(arrn11, arrn2, arrn12);
        SecP160R1Field.reduce(arrn12, arrn11);
        int[] arrn13 = secP160R1FieldElement5.x;
        SecP160R1Field.subtract(arrn13, arrn, arrn13);
        SecP160R1FieldElement secP160R1FieldElement6 = new SecP160R1FieldElement(arrn2);
        if (Nat576.shiftUpBit(5, secP160R1FieldElement.x, 0, arrn2) != 0 || arrn2[4] == -1 && SecT239Field.gte1(arrn2, SecP160R1Field.P)) {
            Nat576.addWordTo(5, -2147483647, arrn2);
        }
        if (!bl) {
            int[] arrn14 = secP160R1FieldElement6.x;
            SecP160R1Field.multiply(arrn14, secP160R1FieldElement3.x, arrn14);
        }
        return new SecP160R1Point(eCCurve, secP160R1FieldElement4, secP160R1FieldElement5, new ECFieldElement[]{secP160R1FieldElement6});
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

