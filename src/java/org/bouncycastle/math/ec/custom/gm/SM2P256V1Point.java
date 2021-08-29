/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.math.ec.custom.gm;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.gm.SM2P256V1Field;
import org.bouncycastle.math.ec.custom.gm.SM2P256V1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SM2P256V1Point
extends ECPoint.AbstractFp {
    public SM2P256V1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SM2P256V1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
        super(eCCurve, eCFieldElement, eCFieldElement2, arreCFieldElement);
    }

    @Override
    public ECPoint add(ECPoint eCPoint) {
        int[] arrn;
        SM2P256V1FieldElement sM2P256V1FieldElement;
        SM2P256V1FieldElement sM2P256V1FieldElement2;
        boolean bl;
        ECCurve eCCurve;
        SM2P256V1FieldElement sM2P256V1FieldElement3;
        SM2P256V1FieldElement sM2P256V1FieldElement4;
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
                    SM2P256V1FieldElement sM2P256V1FieldElement5 = (SM2P256V1FieldElement)this.x;
                    SM2P256V1FieldElement sM2P256V1FieldElement6 = (SM2P256V1FieldElement)this.y;
                    SM2P256V1FieldElement sM2P256V1FieldElement7 = (SM2P256V1FieldElement)eCPoint.x;
                    SM2P256V1FieldElement sM2P256V1FieldElement8 = (SM2P256V1FieldElement)eCPoint.getYCoord();
                    sM2P256V1FieldElement3 = (SM2P256V1FieldElement)this.zs[0];
                    sM2P256V1FieldElement2 = (SM2P256V1FieldElement)eCPoint.getZCoord(0);
                    arrn = new int[16];
                    int[] arrn8 = new int[8];
                    int[] arrn9 = new int[8];
                    int[] arrn10 = new int[8];
                    bl2 = sM2P256V1FieldElement3.isOne();
                    if (bl2) {
                        arrn5 = sM2P256V1FieldElement7.x;
                        arrn4 = sM2P256V1FieldElement8.x;
                    } else {
                        SM2P256V1Field.square(sM2P256V1FieldElement3.x, arrn9);
                        SM2P256V1Field.multiply(arrn9, sM2P256V1FieldElement7.x, arrn8);
                        SM2P256V1Field.multiply(arrn9, sM2P256V1FieldElement3.x, arrn9);
                        SM2P256V1Field.multiply(arrn9, sM2P256V1FieldElement8.x, arrn9);
                        arrn5 = arrn8;
                        arrn4 = arrn9;
                    }
                    bl = sM2P256V1FieldElement2.isOne();
                    if (bl) {
                        arrn6 = sM2P256V1FieldElement5.x;
                        arrn3 = sM2P256V1FieldElement6.x;
                    } else {
                        SM2P256V1Field.square(sM2P256V1FieldElement2.x, arrn10);
                        SM2P256V1Field.multiply(arrn10, sM2P256V1FieldElement5.x, arrn);
                        SM2P256V1Field.multiply(arrn10, sM2P256V1FieldElement2.x, arrn10);
                        SM2P256V1Field.multiply(arrn10, sM2P256V1FieldElement6.x, arrn10);
                        arrn6 = arrn;
                        arrn3 = arrn10;
                    }
                    arrn2 = new int[8];
                    SM2P256V1Field.subtract(arrn6, arrn5, arrn2);
                    SM2P256V1Field.subtract(arrn3, arrn4, arrn8);
                    if (SecT239Field.isZero4(arrn2)) {
                        if (SecT239Field.isZero4(arrn8)) {
                            return this.twice();
                        }
                        return eCCurve.getInfinity();
                    }
                    int[] arrn11 = new int[16];
                    SecT239Field.square4(arrn2, arrn11);
                    SM2P256V1Field.reduce(arrn11, arrn9);
                    int[] arrn12 = new int[8];
                    int[] arrn13 = new int[16];
                    SecT239Field.mul4(arrn9, arrn2, arrn13);
                    SM2P256V1Field.reduce(arrn13, arrn12);
                    SM2P256V1Field.multiply(arrn9, arrn6, arrn9);
                    if (SM2P256V1Field.isZero(arrn12) != 0) {
                        int[] arrn14 = SM2P256V1Field.P;
                        SecT239Field.sub4(arrn14, arrn14, arrn12);
                    } else {
                        SecT239Field.sub4(SM2P256V1Field.P, arrn12, arrn12);
                    }
                    SecT239Field.mul4(arrn3, arrn12, arrn);
                    SM2P256V1Field.reduce32(SecT239Field.addBothTo4(arrn9, arrn9, arrn12), arrn12);
                    sM2P256V1FieldElement = new SM2P256V1FieldElement(arrn10);
                    int[] arrn15 = new int[16];
                    SecT239Field.square4(arrn8, arrn15);
                    SM2P256V1Field.reduce(arrn15, arrn10);
                    int[] arrn16 = sM2P256V1FieldElement.x;
                    SM2P256V1Field.subtract(arrn16, arrn12, arrn16);
                    sM2P256V1FieldElement4 = new SM2P256V1FieldElement(arrn12);
                    SM2P256V1Field.subtract(arrn9, sM2P256V1FieldElement.x, arrn12);
                    if (SecT239Field.mulAddTo4(sM2P256V1FieldElement4.x, arrn8, arrn) != 0) break block13;
                    if (arrn[15] >>> 1 < Integer.MAX_VALUE || !Nat576.gte(n2 = 16, arrn, arrn7 = SM2P256V1Field.PExt)) break block14;
                    break block15;
                }
                n2 = 16;
            }
            Nat576.subFrom(n2, SM2P256V1Field.PExt, arrn);
        }
        SM2P256V1Field.reduce(arrn, sM2P256V1FieldElement4.x);
        SM2P256V1FieldElement sM2P256V1FieldElement9 = new SM2P256V1FieldElement(arrn2);
        if (!bl2) {
            SM2P256V1Field.multiply(arrn2, sM2P256V1FieldElement3.x, arrn2);
        }
        if (!bl) {
            int[] arrn17 = sM2P256V1FieldElement9.x;
            SM2P256V1Field.multiply(arrn17, sM2P256V1FieldElement2.x, arrn17);
        }
        return new SM2P256V1Point(eCCurve, sM2P256V1FieldElement, sM2P256V1FieldElement4, new ECFieldElement[]{sM2P256V1FieldElement9});
    }

    @Override
    public ECPoint detach() {
        return new SM2P256V1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        return new SM2P256V1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        SM2P256V1FieldElement sM2P256V1FieldElement = (SM2P256V1FieldElement)this.y;
        if (sM2P256V1FieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        SM2P256V1FieldElement sM2P256V1FieldElement2 = (SM2P256V1FieldElement)this.x;
        SM2P256V1FieldElement sM2P256V1FieldElement3 = (SM2P256V1FieldElement)this.zs[0];
        int[] arrn = new int[8];
        int[] arrn2 = new int[8];
        int[] arrn3 = new int[8];
        SM2P256V1Field.square(sM2P256V1FieldElement.x, arrn3);
        int[] arrn4 = new int[8];
        int[] arrn5 = new int[16];
        SecT239Field.square4(arrn3, arrn5);
        SM2P256V1Field.reduce(arrn5, arrn4);
        boolean bl = sM2P256V1FieldElement3.isOne();
        int[] arrn6 = sM2P256V1FieldElement3.x;
        if (!bl) {
            SM2P256V1Field.square(arrn6, arrn2);
            arrn6 = arrn2;
        }
        SM2P256V1Field.subtract(sM2P256V1FieldElement2.x, arrn6, arrn);
        SM2P256V1Field.add(sM2P256V1FieldElement2.x, arrn6, arrn2);
        int[] arrn7 = new int[16];
        SecT239Field.mul4(arrn2, arrn, arrn7);
        SM2P256V1Field.reduce(arrn7, arrn2);
        SM2P256V1Field.reduce32(SecT239Field.addBothTo4(arrn2, arrn2, arrn2), arrn2);
        SM2P256V1Field.multiply(arrn3, sM2P256V1FieldElement2.x, arrn3);
        SM2P256V1Field.reduce32(Nat576.shiftUpBits(8, arrn3, 2, 0), arrn3);
        SM2P256V1Field.reduce32(Nat576.shiftUpBits(8, arrn4, 3, 0, arrn), arrn);
        SM2P256V1FieldElement sM2P256V1FieldElement4 = new SM2P256V1FieldElement(arrn4);
        int[] arrn8 = new int[16];
        SecT239Field.square4(arrn2, arrn8);
        SM2P256V1Field.reduce(arrn8, arrn4);
        int[] arrn9 = sM2P256V1FieldElement4.x;
        SM2P256V1Field.subtract(arrn9, arrn3, arrn9);
        int[] arrn10 = sM2P256V1FieldElement4.x;
        SM2P256V1Field.subtract(arrn10, arrn3, arrn10);
        SM2P256V1FieldElement sM2P256V1FieldElement5 = new SM2P256V1FieldElement(arrn3);
        SM2P256V1Field.subtract(arrn3, sM2P256V1FieldElement4.x, arrn3);
        int[] arrn11 = sM2P256V1FieldElement5.x;
        int[] arrn12 = new int[16];
        SecT239Field.mul4(arrn11, arrn2, arrn12);
        SM2P256V1Field.reduce(arrn12, arrn11);
        int[] arrn13 = sM2P256V1FieldElement5.x;
        SM2P256V1Field.subtract(arrn13, arrn, arrn13);
        SM2P256V1FieldElement sM2P256V1FieldElement6 = new SM2P256V1FieldElement(arrn2);
        if (Nat576.shiftUpBit(8, sM2P256V1FieldElement.x, 0, arrn2) != 0 || arrn2[7] >>> 1 >= Integer.MAX_VALUE && SecT239Field.gte4(arrn2, SM2P256V1Field.P)) {
            SM2P256V1Field.addPInvTo(arrn2);
        }
        if (!bl) {
            int[] arrn14 = sM2P256V1FieldElement6.x;
            SM2P256V1Field.multiply(arrn14, sM2P256V1FieldElement3.x, arrn14);
        }
        return new SM2P256V1Point(eCCurve, sM2P256V1FieldElement4, sM2P256V1FieldElement5, new ECFieldElement[]{sM2P256V1FieldElement6});
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

