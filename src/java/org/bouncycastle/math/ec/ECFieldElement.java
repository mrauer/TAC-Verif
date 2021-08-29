/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.util.BigIntegers;

public abstract class ECFieldElement
implements ECConstants {
    public abstract ECFieldElement add(ECFieldElement var1);

    public abstract ECFieldElement addOne();

    public int bitLength() {
        return this.toBigInteger().bitLength();
    }

    public abstract ECFieldElement divide(ECFieldElement var1);

    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray((7 + this.getFieldSize()) / 8, this.toBigInteger());
    }

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public boolean isOne() {
        return this.bitLength() == 1;
    }

    public boolean isZero() {
        return this.toBigInteger().signum() == 0;
    }

    public abstract ECFieldElement multiply(ECFieldElement var1);

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return this.multiply(eCFieldElement).subtract(eCFieldElement2.multiply(eCFieldElement3));
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return this.multiply(eCFieldElement).add(eCFieldElement2.multiply(eCFieldElement3));
    }

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return this.square().add(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePow(int n2) {
        ECFieldElement eCFieldElement = this;
        for (int i2 = 0; i2 < n2; ++i2) {
            eCFieldElement = eCFieldElement.square();
        }
        return eCFieldElement;
    }

    public abstract ECFieldElement subtract(ECFieldElement var1);

    public boolean testBitZero() {
        return this.toBigInteger().testBit(0);
    }

    public abstract BigInteger toBigInteger();

    public String toString() {
        return this.toBigInteger().toString(16);
    }
}

