/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec.custom.sec;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;

public class SecT283K1Point
extends ECPoint.AbstractF2m {
    public SecT283K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecT283K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
        super(eCCurve, eCFieldElement, eCFieldElement2, arreCFieldElement);
    }

    @Override
    public ECPoint add(ECPoint eCPoint) {
        ECFieldElement eCFieldElement;
        ECFieldElement eCFieldElement2;
        ECFieldElement eCFieldElement3;
        ECFieldElement eCFieldElement4;
        ECFieldElement eCFieldElement5;
        ECFieldElement eCFieldElement6;
        if (this.isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        ECFieldElement eCFieldElement7 = this.x;
        ECFieldElement eCFieldElement8 = eCPoint.x;
        if (eCFieldElement7.isZero()) {
            if (eCFieldElement8.isZero()) {
                return eCCurve.getInfinity();
            }
            return eCPoint.add(this);
        }
        ECFieldElement eCFieldElement9 = this.y;
        ECFieldElement eCFieldElement10 = this.zs[0];
        ECFieldElement eCFieldElement11 = eCPoint.y;
        ECFieldElement eCFieldElement12 = eCPoint.getZCoord(0);
        boolean bl = eCFieldElement10.isOne();
        if (!bl) {
            eCFieldElement2 = eCFieldElement8.multiply(eCFieldElement10);
            eCFieldElement5 = eCFieldElement11.multiply(eCFieldElement10);
        } else {
            eCFieldElement2 = eCFieldElement8;
            eCFieldElement5 = eCFieldElement11;
        }
        boolean bl2 = eCFieldElement12.isOne();
        if (!bl2) {
            eCFieldElement7 = eCFieldElement7.multiply(eCFieldElement12);
            eCFieldElement4 = eCFieldElement9.multiply(eCFieldElement12);
        } else {
            eCFieldElement4 = eCFieldElement9;
        }
        ECFieldElement eCFieldElement13 = eCFieldElement4.add(eCFieldElement5);
        ECFieldElement eCFieldElement14 = eCFieldElement7.add(eCFieldElement2);
        if (eCFieldElement14.isZero()) {
            if (eCFieldElement13.isZero()) {
                return this.twice();
            }
            return eCCurve.getInfinity();
        }
        if (eCFieldElement8.isZero()) {
            ECPoint eCPoint2 = this.normalize();
            ECFieldElement eCFieldElement15 = eCPoint2.x;
            ECFieldElement eCFieldElement16 = eCPoint2.getYCoord();
            ECFieldElement eCFieldElement17 = eCFieldElement16.add(eCFieldElement11).divide(eCFieldElement15);
            eCFieldElement3 = GeneratedOutlineSupport.outline30((ECFieldElement)eCFieldElement17, (ECFieldElement)eCFieldElement17, (ECFieldElement)eCFieldElement15);
            if (eCFieldElement3.isZero()) {
                return new SecT283K1Point(eCCurve, eCFieldElement3, eCCurve.b);
            }
            eCFieldElement = eCFieldElement17.multiply(eCFieldElement15.add(eCFieldElement3)).add(eCFieldElement3).add(eCFieldElement16).divide(eCFieldElement3).add(eCFieldElement3);
            eCFieldElement6 = eCCurve.fromBigInteger(ECConstants.ONE);
        } else {
            ECFieldElement eCFieldElement18;
            ECFieldElement eCFieldElement19 = eCFieldElement14.square();
            ECFieldElement eCFieldElement20 = eCFieldElement13.multiply(eCFieldElement7);
            ECFieldElement eCFieldElement21 = eCFieldElement20.multiply(eCFieldElement18 = eCFieldElement13.multiply(eCFieldElement2));
            if (eCFieldElement21.isZero()) {
                return new SecT283K1Point(eCCurve, eCFieldElement21, eCCurve.b);
            }
            ECFieldElement eCFieldElement22 = eCFieldElement13.multiply(eCFieldElement19);
            if (!bl2) {
                eCFieldElement22 = eCFieldElement22.multiply(eCFieldElement12);
            }
            eCFieldElement = eCFieldElement18.add(eCFieldElement19).squarePlusProduct(eCFieldElement22, eCFieldElement9.add(eCFieldElement10));
            ECFieldElement eCFieldElement23 = !bl ? eCFieldElement22.multiply(eCFieldElement10) : eCFieldElement22;
            eCFieldElement3 = eCFieldElement21;
            eCFieldElement6 = eCFieldElement23;
        }
        return new SecT283K1Point(eCCurve, eCFieldElement3, eCFieldElement, new ECFieldElement[]{eCFieldElement6});
    }

    @Override
    public ECPoint detach() {
        return new SecT283K1Point(null, this.getAffineXCoord(), this.getAffineYCoord());
    }

    @Override
    public boolean getCompressionYTilde() {
        ECFieldElement eCFieldElement = this.x;
        if (eCFieldElement.isZero()) {
            return false;
        }
        boolean bl = this.y.testBitZero();
        boolean bl2 = eCFieldElement.testBitZero();
        boolean bl3 = false;
        if (bl != bl2) {
            bl3 = true;
        }
        return bl3;
    }

    @Override
    public ECFieldElement getYCoord() {
        ECFieldElement eCFieldElement = this.x;
        ECFieldElement eCFieldElement2 = this.y;
        if (!this.isInfinity()) {
            if (eCFieldElement.isZero()) {
                return eCFieldElement2;
            }
            ECFieldElement eCFieldElement3 = eCFieldElement2.add(eCFieldElement).multiply(eCFieldElement);
            ECFieldElement eCFieldElement4 = this.zs[0];
            if (!eCFieldElement4.isOne()) {
                eCFieldElement3 = eCFieldElement3.divide(eCFieldElement4);
            }
            return eCFieldElement3;
        }
        return eCFieldElement2;
    }

    @Override
    public ECPoint negate() {
        if (this.isInfinity()) {
            return this;
        }
        ECFieldElement eCFieldElement = this.x;
        if (eCFieldElement.isZero()) {
            return this;
        }
        ECFieldElement eCFieldElement2 = this.y;
        ECFieldElement eCFieldElement3 = this.zs[0];
        return new SecT283K1Point(this.curve, eCFieldElement, eCFieldElement2.add(eCFieldElement3), new ECFieldElement[]{eCFieldElement3});
    }

    @Override
    public ECPoint twice() {
        if (this.isInfinity()) {
            return this;
        }
        ECCurve eCCurve = this.curve;
        ECFieldElement eCFieldElement = this.x;
        if (eCFieldElement.isZero()) {
            return eCCurve.getInfinity();
        }
        ECFieldElement eCFieldElement2 = this.y;
        ECFieldElement eCFieldElement3 = this.zs[0];
        boolean bl = eCFieldElement3.isOne();
        ECFieldElement eCFieldElement4 = bl ? eCFieldElement3 : eCFieldElement3.square();
        ECFieldElement eCFieldElement5 = bl ? eCFieldElement2.square().add(eCFieldElement2) : eCFieldElement2.add(eCFieldElement3).multiply(eCFieldElement2);
        if (eCFieldElement5.isZero()) {
            return new SecT283K1Point(eCCurve, eCFieldElement5, eCCurve.b);
        }
        ECFieldElement eCFieldElement6 = eCFieldElement5.square();
        ECFieldElement eCFieldElement7 = bl ? eCFieldElement5 : eCFieldElement5.multiply(eCFieldElement4);
        ECFieldElement eCFieldElement8 = eCFieldElement2.add(eCFieldElement).square();
        if (!bl) {
            eCFieldElement3 = eCFieldElement4.square();
        }
        return new SecT283K1Point(eCCurve, eCFieldElement6, eCFieldElement8.add(eCFieldElement5).add(eCFieldElement4).multiply(eCFieldElement8).add(eCFieldElement3).add(eCFieldElement6).add(eCFieldElement7), new ECFieldElement[]{eCFieldElement7});
    }

    @Override
    public ECPoint twicePlus(ECPoint eCPoint) {
        if (this.isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this.twice();
        }
        ECCurve eCCurve = this.curve;
        ECFieldElement eCFieldElement = this.x;
        if (eCFieldElement.isZero()) {
            return eCPoint;
        }
        ECFieldElement eCFieldElement2 = eCPoint.x;
        ECFieldElement eCFieldElement3 = eCPoint.getZCoord(0);
        if (!eCFieldElement2.isZero() && eCFieldElement3.isOne()) {
            ECFieldElement eCFieldElement4 = this.y;
            ECFieldElement eCFieldElement5 = this.zs[0];
            ECFieldElement eCFieldElement6 = eCPoint.y;
            ECFieldElement eCFieldElement7 = eCFieldElement.square();
            ECFieldElement eCFieldElement8 = eCFieldElement4.square();
            ECFieldElement eCFieldElement9 = eCFieldElement5.square();
            ECFieldElement eCFieldElement10 = eCFieldElement8.add(eCFieldElement4.multiply(eCFieldElement5));
            ECFieldElement eCFieldElement11 = eCFieldElement6.addOne();
            ECFieldElement eCFieldElement12 = eCFieldElement11.multiply(eCFieldElement9).add(eCFieldElement8).multiplyPlusProduct(eCFieldElement10, eCFieldElement7, eCFieldElement9);
            ECFieldElement eCFieldElement13 = eCFieldElement2.multiply(eCFieldElement9);
            ECFieldElement eCFieldElement14 = eCFieldElement13.add(eCFieldElement10).square();
            if (eCFieldElement14.isZero()) {
                if (eCFieldElement12.isZero()) {
                    return eCPoint.twice();
                }
                return eCCurve.getInfinity();
            }
            if (eCFieldElement12.isZero()) {
                return new SecT283K1Point(eCCurve, eCFieldElement12, eCCurve.b);
            }
            ECFieldElement eCFieldElement15 = eCFieldElement12.square().multiply(eCFieldElement13);
            ECFieldElement eCFieldElement16 = eCFieldElement12.multiply(eCFieldElement14).multiply(eCFieldElement9);
            return new SecT283K1Point(eCCurve, eCFieldElement15, eCFieldElement12.add(eCFieldElement14).square().multiplyPlusProduct(eCFieldElement10, eCFieldElement11, eCFieldElement16), new ECFieldElement[]{eCFieldElement16});
        }
        return this.twice().add(eCPoint);
    }
}

