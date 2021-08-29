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
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat576;

public class SecT239FieldElement
extends ECFieldElement.AbstractF2m {
    public long[] x;

    public SecT239FieldElement() {
        this.x = new long[4];
    }

    public SecT239FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= 239) {
            this.x = Nat576.fromBigInteger64(239, bigInteger);
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
    }

    public SecT239FieldElement(long[] arrl) {
        this.x = arrl;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] arrl = new long[4];
        long[] arrl2 = this.x;
        long[] arrl3 = ((SecT239FieldElement)eCFieldElement).x;
        arrl[0] = arrl2[0] ^ arrl3[0];
        arrl[1] = arrl2[1] ^ arrl3[1];
        arrl[2] = arrl2[2] ^ arrl3[2];
        arrl[3] = arrl2[3] ^ arrl3[3];
        return new SecT239FieldElement(arrl);
    }

    @Override
    public ECFieldElement addOne() {
        long[] arrl = new long[4];
        long[] arrl2 = this.x;
        arrl[0] = 1L ^ arrl2[0];
        arrl[1] = arrl2[1];
        arrl[2] = arrl2[2];
        arrl[3] = arrl2[3];
        return new SecT239FieldElement(arrl);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return this.multiply(eCFieldElement.invert());
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecT239FieldElement)) {
            return false;
        }
        SecT239FieldElement secT239FieldElement = (SecT239FieldElement)object;
        return SecT239Field.eq642(this.x, secT239FieldElement.x);
    }

    @Override
    public int getFieldSize() {
        return 239;
    }

    @Override
    public ECFieldElement halfTrace() {
        long[] arrl = new long[4];
        long[] arrl2 = this.x;
        long[] arrl3 = new long[8];
        SecT239Field.copy642(arrl2, arrl);
        for (int i2 = 1; i2 < 239; i2 += 2) {
            SecT239Field.implSquare(arrl, arrl3);
            SecT239Field.reduce(arrl3, arrl);
            SecT239Field.implSquare(arrl, arrl3);
            SecT239Field.reduce(arrl3, arrl);
            arrl[0] = arrl[0] ^ arrl2[0];
            arrl[1] = arrl[1] ^ arrl2[1];
            arrl[2] = arrl[2] ^ arrl2[2];
            arrl[3] = arrl[3] ^ arrl2[3];
        }
        return new SecT239FieldElement(arrl);
    }

    @Override
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return 23900158 ^ Nat576.hashCode(this.x, 0, 4);
    }

    @Override
    public ECFieldElement invert() {
        long[] arrl = new long[4];
        long[] arrl2 = this.x;
        if (!SecT239Field.isZero642(arrl2)) {
            long[] arrl3 = new long[4];
            long[] arrl4 = new long[4];
            SecT239Field.square(arrl2, arrl3);
            long[] arrl5 = new long[8];
            SecT239Field.implMultiply(arrl3, arrl2, arrl5);
            SecT239Field.reduce(arrl5, arrl3);
            SecT239Field.square(arrl3, arrl3);
            long[] arrl6 = new long[8];
            SecT239Field.implMultiply(arrl3, arrl2, arrl6);
            SecT239Field.reduce(arrl6, arrl3);
            SecT239Field.squareN(arrl3, 3, arrl4);
            long[] arrl7 = new long[8];
            SecT239Field.implMultiply(arrl4, arrl3, arrl7);
            SecT239Field.reduce(arrl7, arrl4);
            SecT239Field.square(arrl4, arrl4);
            long[] arrl8 = new long[8];
            SecT239Field.implMultiply(arrl4, arrl2, arrl8);
            SecT239Field.reduce(arrl8, arrl4);
            SecT239Field.squareN(arrl4, 7, arrl3);
            long[] arrl9 = new long[8];
            SecT239Field.implMultiply(arrl3, arrl4, arrl9);
            SecT239Field.reduce(arrl9, arrl3);
            SecT239Field.squareN(arrl3, 14, arrl4);
            long[] arrl10 = new long[8];
            SecT239Field.implMultiply(arrl4, arrl3, arrl10);
            SecT239Field.reduce(arrl10, arrl4);
            SecT239Field.square(arrl4, arrl4);
            long[] arrl11 = new long[8];
            SecT239Field.implMultiply(arrl4, arrl2, arrl11);
            SecT239Field.reduce(arrl11, arrl4);
            SecT239Field.squareN(arrl4, 29, arrl3);
            long[] arrl12 = new long[8];
            SecT239Field.implMultiply(arrl3, arrl4, arrl12);
            SecT239Field.reduce(arrl12, arrl3);
            SecT239Field.square(arrl3, arrl3);
            long[] arrl13 = new long[8];
            SecT239Field.implMultiply(arrl3, arrl2, arrl13);
            SecT239Field.reduce(arrl13, arrl3);
            SecT239Field.squareN(arrl3, 59, arrl4);
            long[] arrl14 = new long[8];
            SecT239Field.implMultiply(arrl4, arrl3, arrl14);
            SecT239Field.reduce(arrl14, arrl4);
            SecT239Field.square(arrl4, arrl4);
            long[] arrl15 = new long[8];
            SecT239Field.implMultiply(arrl4, arrl2, arrl15);
            SecT239Field.reduce(arrl15, arrl4);
            SecT239Field.squareN(arrl4, 119, arrl3);
            long[] arrl16 = new long[8];
            SecT239Field.implMultiply(arrl3, arrl4, arrl16);
            SecT239Field.reduce(arrl16, arrl3);
            SecT239Field.square(arrl3, arrl);
            return new SecT239FieldElement(arrl);
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean isOne() {
        return SecT239Field.isOne642(this.x);
    }

    @Override
    public boolean isZero() {
        return SecT239Field.isZero642(this.x);
    }

    @Override
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] arrl = new long[4];
        SecT239Field.multiply(this.x, ((SecT239FieldElement)eCFieldElement).x, arrl);
        return new SecT239FieldElement(arrl);
    }

    @Override
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return this.multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT239FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT239FieldElement)eCFieldElement2).x;
        long[] arrl4 = ((SecT239FieldElement)eCFieldElement3).x;
        long[] arrl5 = new long[8];
        SecT239Field.multiplyAddToExt(arrl, arrl2, arrl5);
        SecT239Field.multiplyAddToExt(arrl3, arrl4, arrl5);
        long[] arrl6 = new long[4];
        SecT239Field.reduce(arrl5, arrl6);
        return new SecT239FieldElement(arrl6);
    }

    @Override
    public ECFieldElement negate() {
        return this;
    }

    @Override
    public ECFieldElement sqrt() {
        long[] arrl = new long[4];
        long[] arrl2 = this.x;
        long l2 = Interleave.unshuffle(arrl2[0]);
        long l3 = Interleave.unshuffle(arrl2[1]);
        long l4 = l2 & 0xFFFFFFFFL | l3 << 32;
        long l5 = l2 >>> 32 | l3 & -4294967296L;
        int n2 = 2;
        long l6 = Interleave.unshuffle(arrl2[n2]);
        long l7 = Interleave.unshuffle(arrl2[3]);
        long l8 = l6 & 0xFFFFFFFFL | l7 << 32;
        long l9 = l6 >>> 32 | l7 & -4294967296L;
        long l10 = l9 >>> 49;
        long l11 = l5 >>> 49 | l9 << 15;
        long l12 = l9 ^ l5 << 15;
        long[] arrl3 = new long[8];
        int[] arrn = new int[n2];
        arrn[0] = 39;
        arrn[1] = 120;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = arrn[i2] >>> 6;
            int n4 = 63 & arrn[i2];
            arrl3[n3] = arrl3[n3] ^ l5 << n4;
            int n5 = n3 + 1;
            long l13 = arrl3[n5];
            long l14 = l12 << n4;
            int n6 = -n4;
            arrl3[n5] = l13 ^ (l14 | l5 >>> n6);
            int n7 = n3 + 2;
            arrl3[n7] = arrl3[n7] ^ (l11 << n4 | l12 >>> n6);
            int n8 = n3 + 3;
            arrl3[n8] = arrl3[n8] ^ (l10 << n4 | l11 >>> n6);
            int n9 = n3 + 4;
            arrl3[n9] = arrl3[n9] ^ l10 >>> n6;
            n2 = 2;
        }
        SecT239Field.reduce(arrl3, arrl);
        arrl[0] = l4 ^ arrl[0];
        arrl[1] = l8 ^ arrl[1];
        return new SecT239FieldElement(arrl);
    }

    @Override
    public ECFieldElement square() {
        long[] arrl = new long[4];
        SecT239Field.square(this.x, arrl);
        return new SecT239FieldElement(arrl);
    }

    @Override
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT239FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT239FieldElement)eCFieldElement2).x;
        long[] arrl4 = new long[8];
        long[] arrl5 = new long[8];
        SecT239Field.implSquare(arrl, arrl5);
        SecT239Field.addExt(arrl4, arrl5, arrl4);
        SecT239Field.multiplyAddToExt(arrl2, arrl3, arrl4);
        long[] arrl6 = new long[4];
        SecT239Field.reduce(arrl4, arrl6);
        return new SecT239FieldElement(arrl6);
    }

    @Override
    public ECFieldElement squarePow(int n2) {
        if (n2 < 1) {
            return this;
        }
        long[] arrl = new long[4];
        SecT239Field.squareN(this.x, n2, arrl);
        return new SecT239FieldElement(arrl);
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
        return SecT239Field.toBigInteger642(this.x);
    }

    @Override
    public int trace() {
        long[] arrl = this.x;
        return 1 & (int)(arrl[0] ^ arrl[1] >>> 17 ^ arrl[2] >>> 34);
    }
}

