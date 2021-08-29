/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP256R1Field;
import org.bouncycastle.math.ec.custom.sec.SecP256R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP256R1Point
extends ECPoint.AbstractFp {
    public SecP256R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecP256R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
        super(eCCurve, eCFieldElement, eCFieldElement2, arreCFieldElement);
    }

    @Override
    public ECPoint add(ECPoint eCPoint) {
        int[] arrn;
        SecP256R1FieldElement secP256R1FieldElement;
        boolean bl;
        ECCurve eCCurve;
        SecP256R1FieldElement secP256R1FieldElement2;
        SecP256R1FieldElement secP256R1FieldElement3;
        SecP256R1FieldElement secP256R1FieldElement4;
        int[] arrn2;
        boolean bl2;
        block14 : {
            int n2;
            block15 : {
                block13 : {
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
                    SecP256R1FieldElement secP256R1FieldElement5 = (SecP256R1FieldElement)this.x;
                    SecP256R1FieldElement secP256R1FieldElement6 = (SecP256R1FieldElement)this.y;
                    SecP256R1FieldElement secP256R1FieldElement7 = (SecP256R1FieldElement)eCPoint.x;
                    SecP256R1FieldElement secP256R1FieldElement8 = (SecP256R1FieldElement)eCPoint.getYCoord();
                    secP256R1FieldElement2 = (SecP256R1FieldElement)this.zs[0];
                    secP256R1FieldElement4 = (SecP256R1FieldElement)eCPoint.getZCoord(0);
                    arrn = new int[16];
                    int[] arrn8 = new int[8];
                    int[] arrn9 = new int[8];
                    int[] arrn10 = new int[8];
                    bl2 = secP256R1FieldElement2.isOne();
                    if (bl2) {
                        arrn5 = secP256R1FieldElement7.x;
                        arrn4 = secP256R1FieldElement8.x;
                    } else {
                        SecP256R1Field.square(secP256R1FieldElement2.x, arrn9);
                        SecP256R1Field.multiply(arrn9, secP256R1FieldElement7.x, arrn8);
                        SecP256R1Field.multiply(arrn9, secP256R1FieldElement2.x, arrn9);
                        SecP256R1Field.multiply(arrn9, secP256R1FieldElement8.x, arrn9);
                        arrn5 = arrn8;
                        arrn4 = arrn9;
                    }
                    bl = secP256R1FieldElement4.isOne();
                    if (bl) {
                        arrn6 = secP256R1FieldElement5.x;
                        arrn3 = secP256R1FieldElement6.x;
                    } else {
                        SecP256R1Field.square(secP256R1FieldElement4.x, arrn10);
                        SecP256R1Field.multiply(arrn10, secP256R1FieldElement5.x, arrn);
                        SecP256R1Field.multiply(arrn10, secP256R1FieldElement4.x, arrn10);
                        SecP256R1Field.multiply(arrn10, secP256R1FieldElement6.x, arrn10);
                        arrn6 = arrn;
                        arrn3 = arrn10;
                    }
                    arrn2 = new int[8];
                    SecP256R1Field.subtract(arrn6, arrn5, arrn2);
                    SecP256R1Field.subtract(arrn3, arrn4, arrn8);
                    if (SecT239Field.isZero4(arrn2)) {
                        if (SecT239Field.isZero4(arrn8)) {
                            return this.twice();
                        }
                        return eCCurve.getInfinity();
                    }
                    int[] arrn11 = new int[16];
                    SecT239Field.square4(arrn2, arrn11);
                    SecP256R1Field.reduce(arrn11, arrn9);
                    int[] arrn12 = new int[8];
                    int[] arrn13 = new int[16];
                    SecT239Field.mul4(arrn9, arrn2, arrn13);
                    SecP256R1Field.reduce(arrn13, arrn12);
                    SecP256R1Field.multiply(arrn9, arrn6, arrn9);
                    if (SecP256R1Field.isZero(arrn12) != 0) {
                        int[] arrn14 = SecP256R1Field.P;
                        SecT239Field.sub4(arrn14, arrn14, arrn12);
                    } else {
                        SecT239Field.sub4(SecP256R1Field.P, arrn12, arrn12);
                    }
                    SecT239Field.mul4(arrn3, arrn12, arrn);
                    SecP256R1Field.reduce32(SecT239Field.addBothTo4(arrn9, arrn9, arrn12), arrn12);
                    secP256R1FieldElement = new SecP256R1FieldElement(arrn10);
                    int[] arrn15 = new int[16];
                    SecT239Field.square4(arrn8, arrn15);
                    SecP256R1Field.reduce(arrn15, arrn10);
                    int[] arrn16 = secP256R1FieldElement.x;
                    SecP256R1Field.subtract(arrn16, arrn12, arrn16);
                    secP256R1FieldElement3 = new SecP256R1FieldElement(arrn12);
                    SecP256R1Field.subtract(arrn9, secP256R1FieldElement.x, arrn12);
                    if (SecT239Field.mulAddTo4(secP256R1FieldElement3.x, arrn8, arrn) != 0) break block13;
                    if (arrn[15] >>> 1 < Integer.MAX_VALUE || !Nat576.gte(n2 = 16, arrn, arrn7 = SecP256R1Field.PExt)) break block14;
                    break block15;
                }
                n2 = 16;
            }
            Nat576.subFrom(n2, SecP256R1Field.PExt, arrn);
        }
        SecP256R1Field.reduce(arrn, secP256R1FieldElement3.x);
        SecP256R1FieldElement secP256R1FieldElement9 = new SecP256R1FieldElement(arrn2);
        if (!bl2) {
            SecP256R1Field.multiply(arrn2, secP256R1FieldElement2.x, arrn2);
        }
        if (!bl) {
            int[] arrn17 = secP256R1FieldElement9.x;
            SecP256R1Field.multiply(arrn17, secP256R1FieldElement4.x, arrn17);
        }
        return new SecP256R1Point(eCCurve, secP256R1FieldElement, secP256R1FieldElement3, new ECFieldElement[]{secP256R1FieldElement9});
    }

    @Override
    public ECPoint detach() {
        return new SecP256R1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        return new SecP256R1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        SecP256R1FieldElement secP256R1FieldElement = (SecP256R1FieldElement)this.y;
        if (secP256R1FieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        SecP256R1FieldElement secP256R1FieldElement2 = (SecP256R1FieldElement)this.x;
        SecP256R1FieldElement secP256R1FieldElement3 = (SecP256R1FieldElement)this.zs[0];
        int[] arrn = new int[8];
        int[] arrn2 = new int[8];
        int[] arrn3 = new int[8];
        SecP256R1Field.square(secP256R1FieldElement.x, arrn3);
        int[] arrn4 = new int[8];
        int[] arrn5 = new int[16];
        SecT239Field.square4(arrn3, arrn5);
        SecP256R1Field.reduce(arrn5, arrn4);
        boolean bl = secP256R1FieldElement3.isOne();
        int[] arrn6 = secP256R1FieldElement3.x;
        if (!bl) {
            SecP256R1Field.square(arrn6, arrn2);
            arrn6 = arrn2;
        }
        SecP256R1Field.subtract(secP256R1FieldElement2.x, arrn6, arrn);
        SecP256R1Field.add(secP256R1FieldElement2.x, arrn6, arrn2);
        int[] arrn7 = new int[16];
        SecT239Field.mul4(arrn2, arrn, arrn7);
        SecP256R1Field.reduce(arrn7, arrn2);
        SecP256R1Field.reduce32(SecT239Field.addBothTo4(arrn2, arrn2, arrn2), arrn2);
        SecP256R1Field.multiply(arrn3, secP256R1FieldElement2.x, arrn3);
        SecP256R1Field.reduce32(Nat576.shiftUpBits(8, arrn3, 2, 0), arrn3);
        SecP256R1Field.reduce32(Nat576.shiftUpBits(8, arrn4, 3, 0, arrn), arrn);
        SecP256R1FieldElement secP256R1FieldElement4 = new SecP256R1FieldElement(arrn4);
        int[] arrn8 = new int[16];
        SecT239Field.square4(arrn2, arrn8);
        SecP256R1Field.reduce(arrn8, arrn4);
        int[] arrn9 = secP256R1FieldElement4.x;
        SecP256R1Field.subtract(arrn9, arrn3, arrn9);
        int[] arrn10 = secP256R1FieldElement4.x;
        SecP256R1Field.subtract(arrn10, arrn3, arrn10);
        SecP256R1FieldElement secP256R1FieldElement5 = new SecP256R1FieldElement(arrn3);
        SecP256R1Field.subtract(arrn3, secP256R1FieldElement4.x, arrn3);
        int[] arrn11 = secP256R1FieldElement5.x;
        int[] arrn12 = new int[16];
        SecT239Field.mul4(arrn11, arrn2, arrn12);
        SecP256R1Field.reduce(arrn12, arrn11);
        int[] arrn13 = secP256R1FieldElement5.x;
        SecP256R1Field.subtract(arrn13, arrn, arrn13);
        SecP256R1FieldElement secP256R1FieldElement6 = new SecP256R1FieldElement(arrn2);
        if (Nat576.shiftUpBit(8, secP256R1FieldElement.x, 0, arrn2) != 0 || arrn2[7] == -1 && SecT239Field.gte4(arrn2, SecP256R1Field.P)) {
            SecP256R1Field.addPInvTo(arrn2);
        }
        if (!bl) {
            int[] arrn14 = secP256R1FieldElement6.x;
            SecP256R1Field.multiply(arrn14, secP256R1FieldElement3.x, arrn14);
        }
        return new SecP256R1Point(eCCurve, secP256R1FieldElement4, secP256R1FieldElement5, new ECFieldElement[]{secP256R1FieldElement6});
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

