/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP224R1Field;
import org.bouncycastle.math.ec.custom.sec.SecP224R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP224R1Point
extends ECPoint.AbstractFp {
    public SecP224R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecP224R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
        super(eCCurve, eCFieldElement, eCFieldElement2, arreCFieldElement);
    }

    @Override
    public ECPoint add(ECPoint eCPoint) {
        int[] arrn;
        SecP224R1FieldElement secP224R1FieldElement;
        boolean bl;
        SecP224R1FieldElement secP224R1FieldElement2;
        ECCurve eCCurve;
        SecP224R1FieldElement secP224R1FieldElement3;
        int[] arrn2;
        boolean bl2;
        SecP224R1FieldElement secP224R1FieldElement4;
        block13 : {
            int n2;
            block14 : {
                block12 : {
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
                    SecP224R1FieldElement secP224R1FieldElement5 = (SecP224R1FieldElement)this.x;
                    SecP224R1FieldElement secP224R1FieldElement6 = (SecP224R1FieldElement)this.y;
                    SecP224R1FieldElement secP224R1FieldElement7 = (SecP224R1FieldElement)eCPoint.x;
                    SecP224R1FieldElement secP224R1FieldElement8 = (SecP224R1FieldElement)eCPoint.getYCoord();
                    secP224R1FieldElement2 = (SecP224R1FieldElement)this.zs[0];
                    secP224R1FieldElement4 = (SecP224R1FieldElement)eCPoint.getZCoord(0);
                    arrn = new int[14];
                    int[] arrn8 = new int[7];
                    int[] arrn9 = new int[7];
                    int[] arrn10 = new int[7];
                    bl2 = secP224R1FieldElement2.isOne();
                    if (bl2) {
                        arrn6 = secP224R1FieldElement7.x;
                        arrn5 = secP224R1FieldElement8.x;
                    } else {
                        SecP224R1Field.square(secP224R1FieldElement2.x, arrn9);
                        SecP224R1Field.multiply(arrn9, secP224R1FieldElement7.x, arrn8);
                        SecP224R1Field.multiply(arrn9, secP224R1FieldElement2.x, arrn9);
                        SecP224R1Field.multiply(arrn9, secP224R1FieldElement8.x, arrn9);
                        arrn6 = arrn8;
                        arrn5 = arrn9;
                    }
                    bl = secP224R1FieldElement4.isOne();
                    if (bl) {
                        arrn7 = secP224R1FieldElement5.x;
                        arrn3 = secP224R1FieldElement6.x;
                    } else {
                        SecP224R1Field.square(secP224R1FieldElement4.x, arrn10);
                        SecP224R1Field.multiply(arrn10, secP224R1FieldElement5.x, arrn);
                        SecP224R1Field.multiply(arrn10, secP224R1FieldElement4.x, arrn10);
                        SecP224R1Field.multiply(arrn10, secP224R1FieldElement6.x, arrn10);
                        arrn7 = arrn;
                        arrn3 = arrn10;
                    }
                    arrn2 = new int[7];
                    SecP224R1Field.subtract(arrn7, arrn6, arrn2);
                    SecP224R1Field.subtract(arrn3, arrn5, arrn8);
                    if (SecT239Field.isZero3(arrn2)) {
                        if (SecT239Field.isZero3(arrn8)) {
                            return this.twice();
                        }
                        return eCCurve.getInfinity();
                    }
                    int[] arrn11 = new int[14];
                    SecT239Field.square3(arrn2, arrn11);
                    SecP224R1Field.reduce(arrn11, arrn9);
                    int[] arrn12 = new int[7];
                    int[] arrn13 = new int[14];
                    SecT239Field.mul3(arrn9, arrn2, arrn13);
                    SecP224R1Field.reduce(arrn13, arrn12);
                    SecP224R1Field.multiply(arrn9, arrn7, arrn9);
                    SecP224R1Field.negate(arrn12, arrn12);
                    SecT239Field.mul3(arrn3, arrn12, arrn);
                    SecP224R1Field.reduce32(SecT239Field.addBothTo3(arrn9, arrn9, arrn12), arrn12);
                    secP224R1FieldElement3 = new SecP224R1FieldElement(arrn10);
                    int[] arrn14 = new int[14];
                    SecT239Field.square3(arrn8, arrn14);
                    SecP224R1Field.reduce(arrn14, arrn10);
                    int[] arrn15 = secP224R1FieldElement3.x;
                    SecP224R1Field.subtract(arrn15, arrn12, arrn15);
                    secP224R1FieldElement = new SecP224R1FieldElement(arrn12);
                    SecP224R1Field.subtract(arrn9, secP224R1FieldElement3.x, arrn12);
                    if (SecT239Field.mulAddTo3(secP224R1FieldElement.x, arrn8, arrn) != 0) break block12;
                    if (arrn[13] != -1 || !Nat576.gte(n2 = 14, arrn, arrn4 = SecP224R1Field.PExt)) break block13;
                    break block14;
                }
                n2 = 14;
            }
            int[] arrn16 = SecP224R1Field.PExtInv;
            if (Nat576.addTo(arrn16.length, arrn16, arrn) != 0) {
                Nat576.incAt(n2, arrn, arrn16.length);
            }
        }
        SecP224R1Field.reduce(arrn, secP224R1FieldElement.x);
        SecP224R1FieldElement secP224R1FieldElement9 = new SecP224R1FieldElement(arrn2);
        if (!bl2) {
            SecP224R1Field.multiply(arrn2, secP224R1FieldElement2.x, arrn2);
        }
        if (!bl) {
            int[] arrn17 = secP224R1FieldElement9.x;
            SecP224R1Field.multiply(arrn17, secP224R1FieldElement4.x, arrn17);
        }
        return new SecP224R1Point(eCCurve, secP224R1FieldElement3, secP224R1FieldElement, new ECFieldElement[]{secP224R1FieldElement9});
    }

    @Override
    public ECPoint detach() {
        return new SecP224R1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        return new SecP224R1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        SecP224R1FieldElement secP224R1FieldElement = (SecP224R1FieldElement)this.y;
        if (secP224R1FieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        SecP224R1FieldElement secP224R1FieldElement2 = (SecP224R1FieldElement)this.x;
        SecP224R1FieldElement secP224R1FieldElement3 = (SecP224R1FieldElement)this.zs[0];
        int[] arrn = new int[7];
        int[] arrn2 = new int[7];
        int[] arrn3 = new int[7];
        SecP224R1Field.square(secP224R1FieldElement.x, arrn3);
        int[] arrn4 = new int[7];
        int[] arrn5 = new int[14];
        SecT239Field.square3(arrn3, arrn5);
        SecP224R1Field.reduce(arrn5, arrn4);
        boolean bl = secP224R1FieldElement3.isOne();
        int[] arrn6 = secP224R1FieldElement3.x;
        if (!bl) {
            SecP224R1Field.square(arrn6, arrn2);
            arrn6 = arrn2;
        }
        SecP224R1Field.subtract(secP224R1FieldElement2.x, arrn6, arrn);
        SecP224R1Field.add(secP224R1FieldElement2.x, arrn6, arrn2);
        int[] arrn7 = new int[14];
        SecT239Field.mul3(arrn2, arrn, arrn7);
        SecP224R1Field.reduce(arrn7, arrn2);
        SecP224R1Field.reduce32(SecT239Field.addBothTo3(arrn2, arrn2, arrn2), arrn2);
        SecP224R1Field.multiply(arrn3, secP224R1FieldElement2.x, arrn3);
        SecP224R1Field.reduce32(Nat576.shiftUpBits(7, arrn3, 2, 0), arrn3);
        SecP224R1Field.reduce32(Nat576.shiftUpBits(7, arrn4, 3, 0, arrn), arrn);
        SecP224R1FieldElement secP224R1FieldElement4 = new SecP224R1FieldElement(arrn4);
        int[] arrn8 = new int[14];
        SecT239Field.square3(arrn2, arrn8);
        SecP224R1Field.reduce(arrn8, arrn4);
        int[] arrn9 = secP224R1FieldElement4.x;
        SecP224R1Field.subtract(arrn9, arrn3, arrn9);
        int[] arrn10 = secP224R1FieldElement4.x;
        SecP224R1Field.subtract(arrn10, arrn3, arrn10);
        SecP224R1FieldElement secP224R1FieldElement5 = new SecP224R1FieldElement(arrn3);
        SecP224R1Field.subtract(arrn3, secP224R1FieldElement4.x, arrn3);
        int[] arrn11 = secP224R1FieldElement5.x;
        int[] arrn12 = new int[14];
        SecT239Field.mul3(arrn11, arrn2, arrn12);
        SecP224R1Field.reduce(arrn12, arrn11);
        int[] arrn13 = secP224R1FieldElement5.x;
        SecP224R1Field.subtract(arrn13, arrn, arrn13);
        SecP224R1FieldElement secP224R1FieldElement6 = new SecP224R1FieldElement(arrn2);
        SecP224R1Field.twice(secP224R1FieldElement.x, arrn2);
        if (!bl) {
            int[] arrn14 = secP224R1FieldElement6.x;
            SecP224R1Field.multiply(arrn14, secP224R1FieldElement3.x, arrn14);
        }
        return new SecP224R1Point(eCCurve, secP224R1FieldElement4, secP224R1FieldElement5, new ECFieldElement[]{secP224R1FieldElement6});
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

