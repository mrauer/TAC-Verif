/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP256K1Field;
import org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP256K1Point
extends ECPoint.AbstractFp {
    public SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
        super(eCCurve, eCFieldElement, eCFieldElement2, arreCFieldElement);
    }

    @Override
    public ECPoint add(ECPoint eCPoint) {
        int[] arrn;
        SecP256K1FieldElement secP256K1FieldElement;
        SecP256K1FieldElement secP256K1FieldElement2;
        boolean bl;
        SecP256K1FieldElement secP256K1FieldElement3;
        ECCurve eCCurve;
        int[] arrn2;
        boolean bl2;
        SecP256K1FieldElement secP256K1FieldElement4;
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
                    SecP256K1FieldElement secP256K1FieldElement5 = (SecP256K1FieldElement)this.x;
                    SecP256K1FieldElement secP256K1FieldElement6 = (SecP256K1FieldElement)this.y;
                    SecP256K1FieldElement secP256K1FieldElement7 = (SecP256K1FieldElement)eCPoint.x;
                    SecP256K1FieldElement secP256K1FieldElement8 = (SecP256K1FieldElement)eCPoint.getYCoord();
                    secP256K1FieldElement4 = (SecP256K1FieldElement)this.zs[0];
                    secP256K1FieldElement2 = (SecP256K1FieldElement)eCPoint.getZCoord(0);
                    arrn = new int[16];
                    int[] arrn8 = new int[8];
                    int[] arrn9 = new int[8];
                    int[] arrn10 = new int[8];
                    bl2 = secP256K1FieldElement4.isOne();
                    if (bl2) {
                        arrn5 = secP256K1FieldElement7.x;
                        arrn4 = secP256K1FieldElement8.x;
                    } else {
                        SecP256K1Field.square(secP256K1FieldElement4.x, arrn9);
                        SecP256K1Field.multiply(arrn9, secP256K1FieldElement7.x, arrn8);
                        SecP256K1Field.multiply(arrn9, secP256K1FieldElement4.x, arrn9);
                        SecP256K1Field.multiply(arrn9, secP256K1FieldElement8.x, arrn9);
                        arrn5 = arrn8;
                        arrn4 = arrn9;
                    }
                    bl = secP256K1FieldElement2.isOne();
                    if (bl) {
                        arrn7 = secP256K1FieldElement5.x;
                        arrn3 = secP256K1FieldElement6.x;
                    } else {
                        SecP256K1Field.square(secP256K1FieldElement2.x, arrn10);
                        SecP256K1Field.multiply(arrn10, secP256K1FieldElement5.x, arrn);
                        SecP256K1Field.multiply(arrn10, secP256K1FieldElement2.x, arrn10);
                        SecP256K1Field.multiply(arrn10, secP256K1FieldElement6.x, arrn10);
                        arrn7 = arrn;
                        arrn3 = arrn10;
                    }
                    arrn2 = new int[8];
                    SecP256K1Field.subtract(arrn7, arrn5, arrn2);
                    SecP256K1Field.subtract(arrn3, arrn4, arrn8);
                    if (SecT239Field.isZero4(arrn2)) {
                        if (SecT239Field.isZero4(arrn8)) {
                            return this.twice();
                        }
                        return eCCurve.getInfinity();
                    }
                    int[] arrn11 = new int[16];
                    SecT239Field.square4(arrn2, arrn11);
                    SecP256K1Field.reduce(arrn11, arrn9);
                    int[] arrn12 = new int[8];
                    int[] arrn13 = new int[16];
                    SecT239Field.mul4(arrn9, arrn2, arrn13);
                    SecP256K1Field.reduce(arrn13, arrn12);
                    SecP256K1Field.multiply(arrn9, arrn7, arrn9);
                    if (SecP256K1Field.isZero(arrn12) != 0) {
                        int[] arrn14 = SecP256K1Field.P;
                        SecT239Field.sub4(arrn14, arrn14, arrn12);
                    } else {
                        SecT239Field.sub4(SecP256K1Field.P, arrn12, arrn12);
                    }
                    SecT239Field.mul4(arrn3, arrn12, arrn);
                    SecP256K1Field.reduce32(SecT239Field.addBothTo4(arrn9, arrn9, arrn12), arrn12);
                    secP256K1FieldElement3 = new SecP256K1FieldElement(arrn10);
                    int[] arrn15 = new int[16];
                    SecT239Field.square4(arrn8, arrn15);
                    SecP256K1Field.reduce(arrn15, arrn10);
                    int[] arrn16 = secP256K1FieldElement3.x;
                    SecP256K1Field.subtract(arrn16, arrn12, arrn16);
                    secP256K1FieldElement = new SecP256K1FieldElement(arrn12);
                    if (SecT239Field.sub4(arrn9, secP256K1FieldElement3.x, arrn12) != 0) {
                        Nat576.sub33From(8, 977, arrn12);
                    }
                    if (SecT239Field.mulAddTo4(secP256K1FieldElement.x, arrn8, arrn) != 0) break block15;
                    if (arrn[15] != -1 || !Nat576.gte(n2 = 16, arrn, arrn6 = SecP256K1Field.PExt)) break block16;
                    break block17;
                }
                n2 = 16;
            }
            int[] arrn17 = SecP256K1Field.PExtInv;
            if (Nat576.addTo(arrn17.length, arrn17, arrn) != 0) {
                Nat576.incAt(n2, arrn, arrn17.length);
            }
        }
        SecP256K1Field.reduce(arrn, secP256K1FieldElement.x);
        SecP256K1FieldElement secP256K1FieldElement9 = new SecP256K1FieldElement(arrn2);
        if (!bl2) {
            SecP256K1Field.multiply(arrn2, secP256K1FieldElement4.x, arrn2);
        }
        if (!bl) {
            int[] arrn18 = secP256K1FieldElement9.x;
            SecP256K1Field.multiply(arrn18, secP256K1FieldElement2.x, arrn18);
        }
        return new SecP256K1Point(eCCurve, secP256K1FieldElement3, secP256K1FieldElement, new ECFieldElement[]{secP256K1FieldElement9});
    }

    @Override
    public ECPoint detach() {
        return new SecP256K1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        return new SecP256K1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        SecP256K1FieldElement secP256K1FieldElement = (SecP256K1FieldElement)this.y;
        if (secP256K1FieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        SecP256K1FieldElement secP256K1FieldElement2 = (SecP256K1FieldElement)this.x;
        SecP256K1FieldElement secP256K1FieldElement3 = (SecP256K1FieldElement)this.zs[0];
        int[] arrn = new int[8];
        SecP256K1Field.square(secP256K1FieldElement.x, arrn);
        int[] arrn2 = new int[8];
        int[] arrn3 = new int[16];
        SecT239Field.square4(arrn, arrn3);
        SecP256K1Field.reduce(arrn3, arrn2);
        int[] arrn4 = new int[8];
        SecP256K1Field.square(secP256K1FieldElement2.x, arrn4);
        SecP256K1Field.reduce32(SecT239Field.addBothTo4(arrn4, arrn4, arrn4), arrn4);
        SecP256K1Field.multiply(arrn, secP256K1FieldElement2.x, arrn);
        SecP256K1Field.reduce32(Nat576.shiftUpBits(8, arrn, 2, 0), arrn);
        int[] arrn5 = new int[8];
        SecP256K1Field.reduce32(Nat576.shiftUpBits(8, arrn2, 3, 0, arrn5), arrn5);
        SecP256K1FieldElement secP256K1FieldElement4 = new SecP256K1FieldElement(arrn2);
        int[] arrn6 = new int[16];
        SecT239Field.square4(arrn4, arrn6);
        SecP256K1Field.reduce(arrn6, arrn2);
        int[] arrn7 = secP256K1FieldElement4.x;
        SecP256K1Field.subtract(arrn7, arrn, arrn7);
        int[] arrn8 = secP256K1FieldElement4.x;
        SecP256K1Field.subtract(arrn8, arrn, arrn8);
        SecP256K1FieldElement secP256K1FieldElement5 = new SecP256K1FieldElement(arrn);
        if (SecT239Field.sub4(arrn, secP256K1FieldElement4.x, arrn) != 0) {
            Nat576.sub33From(8, 977, arrn);
        }
        int[] arrn9 = secP256K1FieldElement5.x;
        int[] arrn10 = new int[16];
        SecT239Field.mul4(arrn9, arrn4, arrn10);
        SecP256K1Field.reduce(arrn10, arrn9);
        int[] arrn11 = secP256K1FieldElement5.x;
        SecP256K1Field.subtract(arrn11, arrn5, arrn11);
        SecP256K1FieldElement secP256K1FieldElement6 = new SecP256K1FieldElement(arrn4);
        if (Nat576.shiftUpBit(8, secP256K1FieldElement.x, 0, arrn4) != 0 || arrn4[7] == -1 && SecT239Field.gte4(arrn4, SecP256K1Field.P)) {
            Nat576.add33To(8, 977, arrn4);
        }
        if (!secP256K1FieldElement3.isOne()) {
            int[] arrn12 = secP256K1FieldElement6.x;
            SecP256K1Field.multiply(arrn12, secP256K1FieldElement3.x, arrn12);
        }
        return new SecP256K1Point(eCCurve, secP256K1FieldElement4, secP256K1FieldElement5, new ECFieldElement[]{secP256K1FieldElement6});
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

