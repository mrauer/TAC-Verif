/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP128R1Field;
import org.bouncycastle.math.ec.custom.sec.SecP128R1FieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class SecP128R1Point
extends ECPoint.AbstractFp {
    public SecP128R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecP128R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
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
        SecP128R1FieldElement secP128R1FieldElement = (SecP128R1FieldElement)this.x;
        SecP128R1FieldElement secP128R1FieldElement2 = (SecP128R1FieldElement)this.y;
        SecP128R1FieldElement secP128R1FieldElement3 = (SecP128R1FieldElement)eCPoint.x;
        SecP128R1FieldElement secP128R1FieldElement4 = (SecP128R1FieldElement)eCPoint.getYCoord();
        SecP128R1FieldElement secP128R1FieldElement5 = (SecP128R1FieldElement)this.zs[0];
        SecP128R1FieldElement secP128R1FieldElement6 = (SecP128R1FieldElement)eCPoint.getZCoord(0);
        int[] arrn5 = new int[8];
        int[] arrn6 = new int[4];
        int[] arrn7 = new int[4];
        int[] arrn8 = new int[4];
        boolean bl = secP128R1FieldElement5.isOne();
        if (bl) {
            arrn3 = secP128R1FieldElement3.x;
            arrn2 = secP128R1FieldElement4.x;
        } else {
            SecP128R1Field.square(secP128R1FieldElement5.x, arrn7);
            SecP128R1Field.multiply(arrn7, secP128R1FieldElement3.x, arrn6);
            SecP128R1Field.multiply(arrn7, secP128R1FieldElement5.x, arrn7);
            SecP128R1Field.multiply(arrn7, secP128R1FieldElement4.x, arrn7);
            arrn3 = arrn6;
            arrn2 = arrn7;
        }
        boolean bl2 = secP128R1FieldElement6.isOne();
        if (bl2) {
            arrn4 = secP128R1FieldElement.x;
            arrn = secP128R1FieldElement2.x;
        } else {
            SecP128R1Field.square(secP128R1FieldElement6.x, arrn8);
            SecP128R1Field.multiply(arrn8, secP128R1FieldElement.x, arrn5);
            SecP128R1Field.multiply(arrn8, secP128R1FieldElement6.x, arrn8);
            SecP128R1Field.multiply(arrn8, secP128R1FieldElement2.x, arrn8);
            arrn4 = arrn5;
            arrn = arrn8;
        }
        int[] arrn9 = new int[4];
        SecP128R1Field.subtract(arrn4, arrn3, arrn9);
        SecP128R1Field.subtract(arrn, arrn2, arrn6);
        if (SecT239Field.isZero(arrn9)) {
            if (SecT239Field.isZero(arrn6)) {
                return this.twice();
            }
            return eCCurve.getInfinity();
        }
        int[] arrn10 = new int[8];
        SecT239Field.square(arrn9, arrn10);
        SecP128R1Field.reduce(arrn10, arrn7);
        int[] arrn11 = new int[4];
        int[] arrn12 = new int[8];
        SecT239Field.mul(arrn7, arrn9, arrn12);
        SecP128R1Field.reduce(arrn12, arrn11);
        SecP128R1Field.multiply(arrn7, arrn4, arrn7);
        if (SecP128R1Field.isZero(arrn11) != 0) {
            int[] arrn13 = SecP128R1Field.P;
            SecT239Field.sub(arrn13, arrn13, arrn11);
        } else {
            SecT239Field.sub(SecP128R1Field.P, arrn11, arrn11);
        }
        SecT239Field.mul(arrn, arrn11, arrn5);
        SecP128R1Field.reduce32(SecT239Field.addBothTo(arrn7, arrn7, arrn11), arrn11);
        SecP128R1FieldElement secP128R1FieldElement7 = new SecP128R1FieldElement(arrn8);
        int[] arrn14 = new int[8];
        SecT239Field.square(arrn6, arrn14);
        SecP128R1Field.reduce(arrn14, arrn8);
        int[] arrn15 = secP128R1FieldElement7.x;
        SecP128R1Field.subtract(arrn15, arrn11, arrn15);
        SecP128R1FieldElement secP128R1FieldElement8 = new SecP128R1FieldElement(arrn11);
        SecP128R1Field.subtract(arrn7, secP128R1FieldElement7.x, arrn11);
        int[] arrn16 = secP128R1FieldElement8.x;
        long l2 = 0xFFFFFFFFL & (long)arrn6[0];
        long l3 = 0xFFFFFFFFL & (long)arrn6[1];
        long l4 = 0xFFFFFFFFL & (long)arrn6[2];
        long l5 = 0xFFFFFFFFL & (long)arrn6[3];
        long l6 = 0L;
        int n2 = 0;
        while (n2 < 4) {
            int n3 = arrn16[n2];
            SecP128R1FieldElement secP128R1FieldElement9 = secP128R1FieldElement8;
            int[] arrn17 = arrn16;
            long l7 = 0xFFFFFFFFL & (long)n3;
            long l8 = l7 * l2;
            int n4 = n2 + 0;
            long l9 = l2;
            long l10 = 0L + (l8 + (0xFFFFFFFFL & (long)arrn5[n4]));
            boolean bl3 = bl;
            arrn5[n4] = (int)l10;
            long l11 = l10 >>> 32;
            long l12 = l7 * l3;
            int n5 = n2 + 1;
            int n6 = arrn5[n5];
            long l13 = l3;
            long l14 = l11 + (l12 + (0xFFFFFFFFL & (long)n6));
            arrn5[n5] = (int)l14;
            long l15 = l14 >>> 32;
            long l16 = l7 * l4;
            int n7 = n2 + 2;
            int n8 = arrn5[n7];
            long l17 = l4;
            long l18 = l15 + (l16 + (0xFFFFFFFFL & (long)n8));
            arrn5[n7] = (int)l18;
            long l19 = l18 >>> 32;
            long l20 = l7 * l5;
            int n9 = n2 + 3;
            long l21 = l19 + (l20 + (0xFFFFFFFFL & (long)arrn5[n9]));
            arrn5[n9] = (int)l21;
            long l22 = l21 >>> 32;
            int n10 = n2 + 4;
            long l23 = l6 + (l22 + (0xFFFFFFFFL & (long)arrn5[n10]));
            arrn5[n10] = (int)l23;
            l6 = l23 >>> 32;
            n2 = n5;
            secP128R1FieldElement8 = secP128R1FieldElement9;
            arrn16 = arrn17;
            bl = bl3;
            l2 = l9;
            l3 = l13;
            l4 = l17;
        }
        SecP128R1FieldElement secP128R1FieldElement10 = secP128R1FieldElement8;
        boolean bl4 = bl;
        if ((int)l6 != 0 || arrn5[7] >>> 1 >= 2147483646 && SecT239Field.gte4(arrn5, SecP128R1Field.PExt)) {
            int[] arrn18 = SecP128R1Field.PExtInv;
            Nat576.addTo(arrn18.length, arrn18, arrn5);
        }
        SecP128R1Field.reduce(arrn5, secP128R1FieldElement10.x);
        SecP128R1FieldElement secP128R1FieldElement11 = new SecP128R1FieldElement(arrn9);
        if (!bl4) {
            SecP128R1Field.multiply(arrn9, secP128R1FieldElement5.x, arrn9);
        }
        if (!bl2) {
            int[] arrn19 = secP128R1FieldElement11.x;
            SecP128R1Field.multiply(arrn19, secP128R1FieldElement6.x, arrn19);
        }
        return new SecP128R1Point(eCCurve, secP128R1FieldElement7, secP128R1FieldElement10, new ECFieldElement[]{secP128R1FieldElement11});
    }

    @Override
    public ECPoint detach() {
        return new SecP128R1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        return new SecP128R1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        SecP128R1FieldElement secP128R1FieldElement = (SecP128R1FieldElement)this.y;
        if (secP128R1FieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        SecP128R1FieldElement secP128R1FieldElement2 = (SecP128R1FieldElement)this.x;
        SecP128R1FieldElement secP128R1FieldElement3 = (SecP128R1FieldElement)this.zs[0];
        int[] arrn = new int[4];
        int[] arrn2 = new int[4];
        int[] arrn3 = new int[4];
        SecP128R1Field.square(secP128R1FieldElement.x, arrn3);
        int[] arrn4 = new int[4];
        int[] arrn5 = new int[8];
        SecT239Field.square(arrn3, arrn5);
        SecP128R1Field.reduce(arrn5, arrn4);
        boolean bl = secP128R1FieldElement3.isOne();
        int[] arrn6 = secP128R1FieldElement3.x;
        if (!bl) {
            SecP128R1Field.square(arrn6, arrn2);
            arrn6 = arrn2;
        }
        SecP128R1Field.subtract(secP128R1FieldElement2.x, arrn6, arrn);
        SecP128R1Field.add(secP128R1FieldElement2.x, arrn6, arrn2);
        int[] arrn7 = new int[8];
        SecT239Field.mul(arrn2, arrn, arrn7);
        SecP128R1Field.reduce(arrn7, arrn2);
        SecP128R1Field.reduce32(SecT239Field.addBothTo(arrn2, arrn2, arrn2), arrn2);
        SecP128R1Field.multiply(arrn3, secP128R1FieldElement2.x, arrn3);
        SecP128R1Field.reduce32(Nat576.shiftUpBits(4, arrn3, 2, 0), arrn3);
        SecP128R1Field.reduce32(Nat576.shiftUpBits(4, arrn4, 3, 0, arrn), arrn);
        SecP128R1FieldElement secP128R1FieldElement4 = new SecP128R1FieldElement(arrn4);
        int[] arrn8 = new int[8];
        SecT239Field.square(arrn2, arrn8);
        SecP128R1Field.reduce(arrn8, arrn4);
        int[] arrn9 = secP128R1FieldElement4.x;
        SecP128R1Field.subtract(arrn9, arrn3, arrn9);
        int[] arrn10 = secP128R1FieldElement4.x;
        SecP128R1Field.subtract(arrn10, arrn3, arrn10);
        SecP128R1FieldElement secP128R1FieldElement5 = new SecP128R1FieldElement(arrn3);
        SecP128R1Field.subtract(arrn3, secP128R1FieldElement4.x, arrn3);
        int[] arrn11 = secP128R1FieldElement5.x;
        int[] arrn12 = new int[8];
        SecT239Field.mul(arrn11, arrn2, arrn12);
        SecP128R1Field.reduce(arrn12, arrn11);
        int[] arrn13 = secP128R1FieldElement5.x;
        SecP128R1Field.subtract(arrn13, arrn, arrn13);
        SecP128R1FieldElement secP128R1FieldElement6 = new SecP128R1FieldElement(arrn2);
        if (Nat576.shiftUpBit(4, secP128R1FieldElement.x, 0, arrn2) != 0 || arrn2[3] >>> 1 >= 2147483646 && SecT239Field.gte(arrn2, SecP128R1Field.P)) {
            SecP128R1Field.addPInvTo(arrn2);
        }
        if (!bl) {
            int[] arrn14 = secP128R1FieldElement6.x;
            SecP128R1Field.multiply(arrn14, secP128R1FieldElement3.x, arrn14);
        }
        return new SecP128R1Point(eCCurve, secP128R1FieldElement4, secP128R1FieldElement5, new ECFieldElement[]{secP128R1FieldElement6});
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

