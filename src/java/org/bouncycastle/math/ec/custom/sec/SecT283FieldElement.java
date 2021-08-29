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
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.ec.custom.sec.SecT283Field;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat576;

public class SecT283FieldElement
extends ECFieldElement.AbstractF2m {
    public long[] x;

    public SecT283FieldElement() {
        this.x = new long[5];
    }

    public SecT283FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= 283) {
            this.x = Nat576.fromBigInteger64(283, bigInteger);
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
    }

    public SecT283FieldElement(long[] arrl) {
        this.x = arrl;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] arrl = new long[5];
        long[] arrl2 = this.x;
        long[] arrl3 = ((SecT283FieldElement)eCFieldElement).x;
        arrl[0] = arrl2[0] ^ arrl3[0];
        arrl[1] = arrl2[1] ^ arrl3[1];
        arrl[2] = arrl2[2] ^ arrl3[2];
        arrl[3] = arrl2[3] ^ arrl3[3];
        arrl[4] = arrl2[4] ^ arrl3[4];
        return new SecT283FieldElement(arrl);
    }

    @Override
    public ECFieldElement addOne() {
        long[] arrl = new long[5];
        long[] arrl2 = this.x;
        arrl[0] = 1L ^ arrl2[0];
        arrl[1] = arrl2[1];
        arrl[2] = arrl2[2];
        arrl[3] = arrl2[3];
        arrl[4] = arrl2[4];
        return new SecT283FieldElement(arrl);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return this.multiply(eCFieldElement.invert());
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecT283FieldElement)) {
            return false;
        }
        SecT283FieldElement secT283FieldElement = (SecT283FieldElement)object;
        long[] arrl = this.x;
        long[] arrl2 = secT283FieldElement.x;
        for (int i2 = 4; i2 >= 0; --i2) {
            if (arrl[i2] == arrl2[i2]) continue;
            return false;
        }
        return true;
    }

    @Override
    public int getFieldSize() {
        return 283;
    }

    @Override
    public ECFieldElement halfTrace() {
        long[] arrl = new long[5];
        long[] arrl2 = this.x;
        long[] arrl3 = new long[9];
        arrl[0] = arrl2[0];
        arrl[1] = arrl2[1];
        arrl[2] = arrl2[2];
        arrl[3] = arrl2[3];
        arrl[4] = arrl2[4];
        for (int i2 = 1; i2 < 283; i2 += 2) {
            SecT283Field.implSquare(arrl, arrl3);
            SecT283Field.reduce(arrl3, arrl);
            SecT283Field.implSquare(arrl, arrl3);
            SecT283Field.reduce(arrl3, arrl);
            arrl[0] = arrl[0] ^ arrl2[0];
            arrl[1] = arrl[1] ^ arrl2[1];
            arrl[2] = arrl[2] ^ arrl2[2];
            arrl[3] = arrl[3] ^ arrl2[3];
            arrl[4] = arrl[4] ^ arrl2[4];
        }
        return new SecT283FieldElement(arrl);
    }

    @Override
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return 2831275 ^ Nat576.hashCode(this.x, 0, 5);
    }

    @Override
    public ECFieldElement invert() {
        long[] arrl = new long[5];
        long[] arrl2 = this.x;
        if (!SecT239Field.isZero643(arrl2)) {
            long[] arrl3 = new long[5];
            long[] arrl4 = new long[5];
            SecT283Field.square(arrl2, arrl3);
            long[] arrl5 = new long[10];
            SecT283Field.implMultiply(arrl3, arrl2, arrl5);
            SecT283Field.reduce(arrl5, arrl3);
            SecT283Field.squareN(arrl3, 2, arrl4);
            long[] arrl6 = new long[10];
            SecT283Field.implMultiply(arrl4, arrl3, arrl6);
            SecT283Field.reduce(arrl6, arrl4);
            SecT283Field.squareN(arrl4, 4, arrl3);
            long[] arrl7 = new long[10];
            SecT283Field.implMultiply(arrl3, arrl4, arrl7);
            SecT283Field.reduce(arrl7, arrl3);
            SecT283Field.squareN(arrl3, 8, arrl4);
            long[] arrl8 = new long[10];
            SecT283Field.implMultiply(arrl4, arrl3, arrl8);
            SecT283Field.reduce(arrl8, arrl4);
            SecT283Field.square(arrl4, arrl4);
            long[] arrl9 = new long[10];
            SecT283Field.implMultiply(arrl4, arrl2, arrl9);
            SecT283Field.reduce(arrl9, arrl4);
            SecT283Field.squareN(arrl4, 17, arrl3);
            long[] arrl10 = new long[10];
            SecT283Field.implMultiply(arrl3, arrl4, arrl10);
            SecT283Field.reduce(arrl10, arrl3);
            SecT283Field.square(arrl3, arrl3);
            long[] arrl11 = new long[10];
            SecT283Field.implMultiply(arrl3, arrl2, arrl11);
            SecT283Field.reduce(arrl11, arrl3);
            SecT283Field.squareN(arrl3, 35, arrl4);
            long[] arrl12 = new long[10];
            SecT283Field.implMultiply(arrl4, arrl3, arrl12);
            SecT283Field.reduce(arrl12, arrl4);
            SecT283Field.squareN(arrl4, 70, arrl3);
            long[] arrl13 = new long[10];
            SecT283Field.implMultiply(arrl3, arrl4, arrl13);
            SecT283Field.reduce(arrl13, arrl3);
            SecT283Field.square(arrl3, arrl3);
            long[] arrl14 = new long[10];
            SecT283Field.implMultiply(arrl3, arrl2, arrl14);
            SecT283Field.reduce(arrl14, arrl3);
            SecT283Field.squareN(arrl3, 141, arrl4);
            long[] arrl15 = new long[10];
            SecT283Field.implMultiply(arrl4, arrl3, arrl15);
            SecT283Field.reduce(arrl15, arrl4);
            SecT283Field.square(arrl4, arrl);
            return new SecT283FieldElement(arrl);
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean isOne() {
        long[] arrl = this.x;
        if (arrl[0] != 1L) {
            return false;
        }
        for (int i2 = 1; i2 < 5; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean isZero() {
        return SecT239Field.isZero643(this.x);
    }

    @Override
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] arrl = new long[5];
        SecT283Field.multiply(this.x, ((SecT283FieldElement)eCFieldElement).x, arrl);
        return new SecT283FieldElement(arrl);
    }

    @Override
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return this.multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT283FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT283FieldElement)eCFieldElement2).x;
        long[] arrl4 = ((SecT283FieldElement)eCFieldElement3).x;
        long[] arrl5 = new long[9];
        SecT283Field.multiplyAddToExt(arrl, arrl2, arrl5);
        SecT283Field.multiplyAddToExt(arrl3, arrl4, arrl5);
        long[] arrl6 = new long[5];
        SecT283Field.reduce(arrl5, arrl6);
        return new SecT283FieldElement(arrl6);
    }

    @Override
    public ECFieldElement negate() {
        return this;
    }

    @Override
    public ECFieldElement sqrt() {
        long[] arrl = new long[5];
        long[] arrl2 = this.x;
        long[] arrl3 = new long[5];
        long l2 = Interleave.unshuffle(arrl2[0]);
        long l3 = Interleave.unshuffle(arrl2[1]);
        long l4 = l2 & 0xFFFFFFFFL | l3 << 32;
        arrl3[0] = l2 >>> 32 | l3 & -4294967296L;
        long l5 = Interleave.unshuffle(arrl2[2]);
        long l6 = Interleave.unshuffle(arrl2[3]);
        long l7 = l5 & 0xFFFFFFFFL | l6 << 32;
        arrl3[1] = l5 >>> 32 | l6 & -4294967296L;
        long l8 = Interleave.unshuffle(arrl2[4]);
        long l9 = 0xFFFFFFFFL & l8;
        arrl3[2] = l8 >>> 32;
        long[] arrl4 = SecT283Field.ROOT_Z;
        long[] arrl5 = new long[10];
        SecT283Field.implMultiply(arrl3, arrl4, arrl5);
        SecT283Field.reduce(arrl5, arrl);
        arrl[0] = l4 ^ arrl[0];
        arrl[1] = l7 ^ arrl[1];
        arrl[2] = l9 ^ arrl[2];
        return new SecT283FieldElement(arrl);
    }

    @Override
    public ECFieldElement square() {
        long[] arrl = new long[5];
        SecT283Field.square(this.x, arrl);
        return new SecT283FieldElement(arrl);
    }

    @Override
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT283FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT283FieldElement)eCFieldElement2).x;
        long[] arrl4 = new long[9];
        long[] arrl5 = new long[9];
        SecT283Field.implSquare(arrl, arrl5);
        SecT283Field.addExt(arrl4, arrl5, arrl4);
        SecT283Field.multiplyAddToExt(arrl2, arrl3, arrl4);
        long[] arrl6 = new long[5];
        SecT283Field.reduce(arrl4, arrl6);
        return new SecT283FieldElement(arrl6);
    }

    @Override
    public ECFieldElement squarePow(int n2) {
        if (n2 < 1) {
            return this;
        }
        long[] arrl = new long[5];
        SecT283Field.squareN(this.x, n2, arrl);
        return new SecT283FieldElement(arrl);
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
        long[] arrl = this.x;
        byte[] arrby = new byte[40];
        for (int i2 = 0; i2 < 5; ++i2) {
            long l2 = arrl[i2];
            if (l2 == 0L) continue;
            Nat576.longToBigEndian(l2, arrby, 4 - i2 << 3);
        }
        return new BigInteger(1, arrby);
    }

    @Override
    public int trace() {
        long[] arrl = this.x;
        return 1 & (int)(arrl[0] ^ arrl[4] >>> 15);
    }
}

