/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.math.ec.custom.djb;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.djb.Curve25519Field;
import org.bouncycastle.math.ec.custom.djb.Curve25519FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class Curve25519Point
extends ECPoint.AbstractFp {
    public Curve25519Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public Curve25519Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
        super(eCCurve, eCFieldElement, eCFieldElement2, arreCFieldElement);
    }

    @Override
    public ECPoint add(ECPoint eCPoint) {
        int[] arrn;
        int[] arrn2;
        int[] arrn3;
        int[] arrn4;
        int[] arrn5;
        boolean bl;
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
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement)this.x;
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement)this.y;
        Curve25519FieldElement curve25519FieldElement3 = (Curve25519FieldElement)this.zs[0];
        Curve25519FieldElement curve25519FieldElement4 = (Curve25519FieldElement)eCPoint.x;
        Curve25519FieldElement curve25519FieldElement5 = (Curve25519FieldElement)eCPoint.getYCoord();
        Curve25519FieldElement curve25519FieldElement6 = (Curve25519FieldElement)eCPoint.getZCoord(0);
        int[] arrn6 = new int[16];
        int[] arrn7 = new int[8];
        int[] arrn8 = new int[8];
        int[] arrn9 = new int[8];
        boolean bl2 = curve25519FieldElement3.isOne();
        if (bl2) {
            arrn4 = curve25519FieldElement4.x;
            arrn2 = curve25519FieldElement5.x;
        } else {
            Curve25519Field.square(curve25519FieldElement3.x, arrn8);
            Curve25519Field.multiply(arrn8, curve25519FieldElement4.x, arrn7);
            Curve25519Field.multiply(arrn8, curve25519FieldElement3.x, arrn8);
            Curve25519Field.multiply(arrn8, curve25519FieldElement5.x, arrn8);
            arrn4 = arrn7;
            arrn2 = arrn8;
        }
        boolean bl3 = curve25519FieldElement6.isOne();
        if (bl3) {
            arrn5 = curve25519FieldElement.x;
            arrn = curve25519FieldElement2.x;
        } else {
            Curve25519Field.square(curve25519FieldElement6.x, arrn9);
            Curve25519Field.multiply(arrn9, curve25519FieldElement.x, arrn6);
            Curve25519Field.multiply(arrn9, curve25519FieldElement6.x, arrn9);
            Curve25519Field.multiply(arrn9, curve25519FieldElement2.x, arrn9);
            arrn5 = arrn6;
            arrn = arrn9;
        }
        int[] arrn10 = new int[8];
        Curve25519Field.subtract(arrn5, arrn4, arrn10);
        Curve25519Field.subtract(arrn, arrn2, arrn7);
        if (SecT239Field.isZero4(arrn10)) {
            if (SecT239Field.isZero4(arrn7)) {
                return this.twice();
            }
            return eCCurve.getInfinity();
        }
        int[] arrn11 = new int[8];
        int[] arrn12 = new int[16];
        SecT239Field.square4(arrn10, arrn12);
        Curve25519Field.reduce(arrn12, arrn11);
        int[] arrn13 = new int[8];
        int[] arrn14 = new int[16];
        SecT239Field.mul4(arrn11, arrn10, arrn14);
        Curve25519Field.reduce(arrn14, arrn13);
        Curve25519Field.multiply(arrn11, arrn5, arrn8);
        if (Curve25519Field.isZero(arrn13) != 0) {
            int[] arrn15 = Curve25519Field.P;
            SecT239Field.sub4(arrn15, arrn15, arrn13);
        } else {
            SecT239Field.sub4(Curve25519Field.P, arrn13, arrn13);
        }
        SecT239Field.mul4(arrn, arrn13, arrn6);
        Curve25519Field.reduce27(SecT239Field.addBothTo4(arrn8, arrn8, arrn13), arrn13);
        Curve25519FieldElement curve25519FieldElement7 = new Curve25519FieldElement(arrn9);
        int[] arrn16 = new int[16];
        SecT239Field.square4(arrn7, arrn16);
        Curve25519Field.reduce(arrn16, arrn9);
        int[] arrn17 = curve25519FieldElement7.x;
        Curve25519Field.subtract(arrn17, arrn13, arrn17);
        Curve25519FieldElement curve25519FieldElement8 = new Curve25519FieldElement(arrn13);
        Curve25519Field.subtract(arrn8, curve25519FieldElement7.x, arrn13);
        SecT239Field.mulAddTo4(curve25519FieldElement8.x, arrn7, arrn6);
        int[] arrn18 = Curve25519Field.PExt;
        if (Nat576.gte(16, arrn6, arrn18)) {
            int n2;
            long l2 = 0xFFFFFFFFL & (long)arrn6[0];
            int n3 = arrn18[0];
            arrn3 = arrn10;
            long l3 = l2 - (0xFFFFFFFFL & (long)n3);
            arrn6[0] = (int)l3;
            long l4 = l3 >> 32;
            if (l4 != 0L) {
                n2 = 8;
                l4 = Nat576.decAt(n2, arrn6, 1);
            } else {
                n2 = 8;
            }
            long l5 = l4 + (19L + (0xFFFFFFFFL & (long)arrn6[n2]));
            arrn6[8] = (int)l5;
            long l6 = l5 >> 32;
            if (l6 != 0L) {
                l6 = Nat576.incAt(15, arrn6, 9);
            }
            long l7 = 0xFFFFFFFFL & (long)arrn6[15];
            int n4 = 1 + arrn18[15];
            bl = bl2;
            arrn6[15] = (int)(l6 + (l7 - (0xFFFFFFFFL & (long)n4)));
        } else {
            arrn3 = arrn10;
            bl = bl2;
        }
        Curve25519Field.reduce(arrn6, curve25519FieldElement8.x);
        int[] arrn19 = arrn3;
        Curve25519FieldElement curve25519FieldElement9 = new Curve25519FieldElement(arrn19);
        if (!bl) {
            Curve25519Field.multiply(arrn19, curve25519FieldElement3.x, arrn19);
        }
        if (!bl3) {
            int[] arrn20 = curve25519FieldElement9.x;
            Curve25519Field.multiply(arrn20, curve25519FieldElement6.x, arrn20);
        }
        if (!bl || !bl3) {
            arrn11 = null;
        }
        return new Curve25519Point(eCCurve, curve25519FieldElement7, curve25519FieldElement8, new ECFieldElement[]{curve25519FieldElement9, this.calculateJacobianModifiedW(curve25519FieldElement9, arrn11)});
    }

    public Curve25519FieldElement calculateJacobianModifiedW(Curve25519FieldElement curve25519FieldElement, int[] arrn) {
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement)this.curve.a;
        if (curve25519FieldElement.isOne()) {
            return curve25519FieldElement2;
        }
        Curve25519FieldElement curve25519FieldElement3 = new Curve25519FieldElement();
        if (arrn == null) {
            arrn = curve25519FieldElement3.x;
            Curve25519Field.square(curve25519FieldElement.x, arrn);
        }
        Curve25519Field.square(arrn, curve25519FieldElement3.x);
        int[] arrn2 = curve25519FieldElement3.x;
        Curve25519Field.multiply(arrn2, curve25519FieldElement2.x, arrn2);
        return curve25519FieldElement3;
    }

    @Override
    public ECPoint detach() {
        return new Curve25519Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    public Curve25519FieldElement getJacobianModifiedW() {
        ECFieldElement[] arreCFieldElement = this.zs;
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement)arreCFieldElement[1];
        if (curve25519FieldElement == null) {
            curve25519FieldElement = this.calculateJacobianModifiedW((Curve25519FieldElement)arreCFieldElement[0], null);
            arreCFieldElement[1] = curve25519FieldElement;
        }
        return curve25519FieldElement;
    }

    @Override
    public ECFieldElement getZCoord(int n2) {
        if (n2 == 1) {
            return this.getJacobianModifiedW();
        }
        return ECPoint.super.getZCoord(n2);
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        return new Curve25519Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        if (this.y.isZero()) {
            return eCCurve.getInfinity();
        }
        return this.twiceJacobianModified(true);
    }

    public Curve25519Point twiceJacobianModified(boolean bl) {
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement)this.x;
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement)this.y;
        Curve25519FieldElement curve25519FieldElement3 = (Curve25519FieldElement)this.zs[0];
        Curve25519FieldElement curve25519FieldElement4 = this.getJacobianModifiedW();
        int[] arrn = new int[8];
        Curve25519Field.square(curve25519FieldElement.x, arrn);
        int n2 = SecT239Field.addBothTo4(arrn, arrn, arrn);
        int[] arrn2 = curve25519FieldElement4.x;
        long l2 = 0L + ((0xFFFFFFFFL & (long)arrn2[0]) + (0xFFFFFFFFL & (long)arrn[0]));
        arrn[0] = (int)l2;
        long l3 = (l2 >>> 32) + ((0xFFFFFFFFL & (long)arrn2[1]) + (0xFFFFFFFFL & (long)arrn[1]));
        arrn[1] = (int)l3;
        long l4 = (l3 >>> 32) + ((0xFFFFFFFFL & (long)arrn2[2]) + (0xFFFFFFFFL & (long)arrn[2]));
        arrn[2] = (int)l4;
        long l5 = (l4 >>> 32) + ((0xFFFFFFFFL & (long)arrn2[3]) + (0xFFFFFFFFL & (long)arrn[3]));
        arrn[3] = (int)l5;
        long l6 = (l5 >>> 32) + ((0xFFFFFFFFL & (long)arrn2[4]) + (0xFFFFFFFFL & (long)arrn[4]));
        arrn[4] = (int)l6;
        long l7 = (l6 >>> 32) + ((0xFFFFFFFFL & (long)arrn2[5]) + (0xFFFFFFFFL & (long)arrn[5]));
        arrn[5] = (int)l7;
        long l8 = (l7 >>> 32) + ((0xFFFFFFFFL & (long)arrn2[6]) + (0xFFFFFFFFL & (long)arrn[6]));
        arrn[6] = (int)l8;
        long l9 = (l8 >>> 32) + ((0xFFFFFFFFL & (long)arrn2[7]) + (0xFFFFFFFFL & (long)arrn[7]));
        arrn[7] = (int)l9;
        Curve25519Field.reduce27(n2 + (int)(l9 >>> 32), arrn);
        int[] arrn3 = new int[8];
        Curve25519Field.twice(curve25519FieldElement2.x, arrn3);
        int[] arrn4 = new int[8];
        Curve25519Field.multiply(arrn3, curve25519FieldElement2.x, arrn4);
        int[] arrn5 = new int[8];
        Curve25519Field.multiply(arrn4, curve25519FieldElement.x, arrn5);
        Curve25519Field.twice(arrn5, arrn5);
        int[] arrn6 = new int[8];
        int[] arrn7 = new int[16];
        SecT239Field.square4(arrn4, arrn7);
        Curve25519Field.reduce(arrn7, arrn6);
        Curve25519Field.twice(arrn6, arrn6);
        Curve25519FieldElement curve25519FieldElement5 = new Curve25519FieldElement(arrn4);
        int[] arrn8 = new int[16];
        SecT239Field.square4(arrn, arrn8);
        Curve25519Field.reduce(arrn8, arrn4);
        int[] arrn9 = curve25519FieldElement5.x;
        Curve25519Field.subtract(arrn9, arrn5, arrn9);
        int[] arrn10 = curve25519FieldElement5.x;
        Curve25519Field.subtract(arrn10, arrn5, arrn10);
        Curve25519FieldElement curve25519FieldElement6 = new Curve25519FieldElement(arrn5);
        Curve25519Field.subtract(arrn5, curve25519FieldElement5.x, arrn5);
        int[] arrn11 = curve25519FieldElement6.x;
        int[] arrn12 = new int[16];
        SecT239Field.mul4(arrn11, arrn, arrn12);
        Curve25519Field.reduce(arrn12, arrn11);
        int[] arrn13 = curve25519FieldElement6.x;
        Curve25519Field.subtract(arrn13, arrn6, arrn13);
        Curve25519FieldElement curve25519FieldElement7 = new Curve25519FieldElement(arrn3);
        if (!SecT239Field.isOne4(curve25519FieldElement3.x)) {
            int[] arrn14 = curve25519FieldElement7.x;
            Curve25519Field.multiply(arrn14, curve25519FieldElement3.x, arrn14);
        }
        Curve25519FieldElement curve25519FieldElement8 = null;
        if (bl) {
            curve25519FieldElement8 = new Curve25519FieldElement(arrn6);
            Curve25519Field.multiply(arrn6, curve25519FieldElement4.x, arrn6);
            int[] arrn15 = curve25519FieldElement8.x;
            Curve25519Field.twice(arrn15, arrn15);
        }
        return new Curve25519Point(this.curve, curve25519FieldElement5, curve25519FieldElement6, new ECFieldElement[]{curve25519FieldElement7, curve25519FieldElement8});
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public ECPoint twicePlus(ECPoint eCPoint) {
        if (this == eCPoint) {
            if (this.isInfinity()) {
                return this;
            }
            if (!this.y.isZero()) return this.twiceJacobianModified(false).add(this);
            return this;
        }
        if (this.isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this.twice();
        }
        if (!this.y.isZero()) return this.twiceJacobianModified(false).add(eCPoint);
        return eCPoint;
    }
}

