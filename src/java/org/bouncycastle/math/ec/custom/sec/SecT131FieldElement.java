/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT131Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat576;

public class SecT131FieldElement
extends ECFieldElement.AbstractF2m {
    public long[] x;

    public SecT131FieldElement() {
        this.x = new long[3];
    }

    public SecT131FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= 131) {
            this.x = Nat576.fromBigInteger64(131, bigInteger);
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
    }

    public SecT131FieldElement(long[] arrl) {
        this.x = arrl;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] arrl = new long[3];
        long[] arrl2 = this.x;
        long[] arrl3 = ((SecT131FieldElement)eCFieldElement).x;
        arrl[0] = arrl2[0] ^ arrl3[0];
        arrl[1] = arrl2[1] ^ arrl3[1];
        arrl[2] = arrl2[2] ^ arrl3[2];
        return new SecT131FieldElement(arrl);
    }

    @Override
    public ECFieldElement addOne() {
        long[] arrl = new long[3];
        long[] arrl2 = this.x;
        arrl[0] = 1L ^ arrl2[0];
        arrl[1] = arrl2[1];
        arrl[2] = arrl2[2];
        return new SecT131FieldElement(arrl);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return this.multiply(eCFieldElement.invert());
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecT131FieldElement)) {
            return false;
        }
        SecT131FieldElement secT131FieldElement = (SecT131FieldElement)object;
        return SecT239Field.eq641(this.x, secT131FieldElement.x);
    }

    @Override
    public int getFieldSize() {
        return 131;
    }

    @Override
    public ECFieldElement halfTrace() {
        long[] arrl = new long[3];
        long[] arrl2 = this.x;
        long[] arrl3 = new long[5];
        arrl[0] = arrl2[0];
        arrl[1] = arrl2[1];
        arrl[2] = arrl2[2];
        for (int i2 = 1; i2 < 131; i2 += 2) {
            SecT131Field.implSquare(arrl, arrl3);
            SecT131Field.reduce(arrl3, arrl);
            SecT131Field.implSquare(arrl, arrl3);
            SecT131Field.reduce(arrl3, arrl);
            arrl[0] = arrl[0] ^ arrl2[0];
            arrl[1] = arrl[1] ^ arrl2[1];
            arrl[2] = arrl[2] ^ arrl2[2];
        }
        return new SecT131FieldElement(arrl);
    }

    @Override
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return 131832 ^ Nat576.hashCode(this.x, 0, 3);
    }

    @Override
    public ECFieldElement invert() {
        long[] arrl = new long[3];
        long[] arrl2 = this.x;
        if (!SecT239Field.isZero641(arrl2)) {
            long[] arrl3 = new long[3];
            long[] arrl4 = new long[3];
            SecT131Field.square(arrl2, arrl3);
            long[] arrl5 = new long[8];
            SecT131Field.implMultiply(arrl3, arrl2, arrl5);
            SecT131Field.reduce(arrl5, arrl3);
            SecT131Field.squareN(arrl3, 2, arrl4);
            long[] arrl6 = new long[8];
            SecT131Field.implMultiply(arrl4, arrl3, arrl6);
            SecT131Field.reduce(arrl6, arrl4);
            SecT131Field.squareN(arrl4, 4, arrl3);
            long[] arrl7 = new long[8];
            SecT131Field.implMultiply(arrl3, arrl4, arrl7);
            SecT131Field.reduce(arrl7, arrl3);
            SecT131Field.squareN(arrl3, 8, arrl4);
            long[] arrl8 = new long[8];
            SecT131Field.implMultiply(arrl4, arrl3, arrl8);
            SecT131Field.reduce(arrl8, arrl4);
            SecT131Field.squareN(arrl4, 16, arrl3);
            long[] arrl9 = new long[8];
            SecT131Field.implMultiply(arrl3, arrl4, arrl9);
            SecT131Field.reduce(arrl9, arrl3);
            SecT131Field.squareN(arrl3, 32, arrl4);
            long[] arrl10 = new long[8];
            SecT131Field.implMultiply(arrl4, arrl3, arrl10);
            SecT131Field.reduce(arrl10, arrl4);
            SecT131Field.square(arrl4, arrl4);
            long[] arrl11 = new long[8];
            SecT131Field.implMultiply(arrl4, arrl2, arrl11);
            SecT131Field.reduce(arrl11, arrl4);
            SecT131Field.squareN(arrl4, 65, arrl3);
            long[] arrl12 = new long[8];
            SecT131Field.implMultiply(arrl3, arrl4, arrl12);
            SecT131Field.reduce(arrl12, arrl3);
            SecT131Field.square(arrl3, arrl);
            return new SecT131FieldElement(arrl);
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean isOne() {
        return SecT239Field.isOne641(this.x);
    }

    @Override
    public boolean isZero() {
        return SecT239Field.isZero641(this.x);
    }

    @Override
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] arrl = new long[3];
        SecT131Field.multiply(this.x, ((SecT131FieldElement)eCFieldElement).x, arrl);
        return new SecT131FieldElement(arrl);
    }

    @Override
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return this.multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT131FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT131FieldElement)eCFieldElement2).x;
        long[] arrl4 = ((SecT131FieldElement)eCFieldElement3).x;
        long[] arrl5 = new long[5];
        SecT131Field.multiplyAddToExt(arrl, arrl2, arrl5);
        SecT131Field.multiplyAddToExt(arrl3, arrl4, arrl5);
        long[] arrl6 = new long[3];
        SecT131Field.reduce(arrl5, arrl6);
        return new SecT131FieldElement(arrl6);
    }

    @Override
    public ECFieldElement negate() {
        return this;
    }

    @Override
    public ECFieldElement sqrt() {
        long[] arrl = new long[3];
        long[] arrl2 = this.x;
        long[] arrl3 = new long[3];
        long l2 = Interleave.unshuffle(arrl2[0]);
        long l3 = Interleave.unshuffle(arrl2[1]);
        long l4 = l2 & 0xFFFFFFFFL | l3 << 32;
        arrl3[0] = l2 >>> 32 | l3 & -4294967296L;
        long l5 = Interleave.unshuffle(arrl2[2]);
        long l6 = l5 & 0xFFFFFFFFL;
        arrl3[1] = l5 >>> 32;
        long[] arrl4 = SecT131Field.ROOT_Z;
        long[] arrl5 = new long[8];
        SecT131Field.implMultiply(arrl3, arrl4, arrl5);
        SecT131Field.reduce(arrl5, arrl);
        arrl[0] = l4 ^ arrl[0];
        arrl[1] = l6 ^ arrl[1];
        return new SecT131FieldElement(arrl);
    }

    @Override
    public ECFieldElement square() {
        long[] arrl = new long[3];
        SecT131Field.square(this.x, arrl);
        return new SecT131FieldElement(arrl);
    }

    @Override
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT131FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT131FieldElement)eCFieldElement2).x;
        long[] arrl4 = new long[5];
        long[] arrl5 = new long[5];
        SecT131Field.implSquare(arrl, arrl5);
        SecT131Field.addExt(arrl4, arrl5, arrl4);
        SecT131Field.multiplyAddToExt(arrl2, arrl3, arrl4);
        long[] arrl6 = new long[3];
        SecT131Field.reduce(arrl4, arrl6);
        return new SecT131FieldElement(arrl6);
    }

    @Override
    public ECFieldElement squarePow(int n2) {
        if (n2 < 1) {
            return this;
        }
        long[] arrl = new long[3];
        SecT131Field.squareN(this.x, n2, arrl);
        return new SecT131FieldElement(arrl);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return this.add(eCFieldElement);
    }

    @Override
    public boolean testBitZero() {
        long l2 = 1L & this.x[0] LCMP 0L;
        boolean bl = false;
        if (l2 != false) {
            bl = true;
        }
        return bl;
    }

    @Override
    public BigInteger toBigInteger() {
        return SecT239Field.toBigInteger641(this.x);
    }

    @Override
    public int trace() {
        long[] arrl = this.x;
        return 1 & (int)(arrl[0] ^ arrl[1] >>> 59 ^ arrl[2] >>> 1);
    }
}

