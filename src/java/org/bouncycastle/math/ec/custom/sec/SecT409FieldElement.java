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

public class SecT409FieldElement
extends ECFieldElement.AbstractF2m {
    public long[] x;

    public SecT409FieldElement() {
        this.x = new long[7];
    }

    public SecT409FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= 409) {
            this.x = Nat576.fromBigInteger64(409, bigInteger);
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
    }

    public SecT409FieldElement(long[] arrl) {
        this.x = arrl;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] arrl = new long[7];
        long[] arrl2 = this.x;
        long[] arrl3 = ((SecT409FieldElement)eCFieldElement).x;
        arrl[0] = arrl2[0] ^ arrl3[0];
        arrl[1] = arrl2[1] ^ arrl3[1];
        arrl[2] = arrl2[2] ^ arrl3[2];
        arrl[3] = arrl2[3] ^ arrl3[3];
        arrl[4] = arrl2[4] ^ arrl3[4];
        arrl[5] = arrl2[5] ^ arrl3[5];
        arrl[6] = arrl2[6] ^ arrl3[6];
        return new SecT409FieldElement(arrl);
    }

    @Override
    public ECFieldElement addOne() {
        long[] arrl = new long[7];
        long[] arrl2 = this.x;
        arrl[0] = 1L ^ arrl2[0];
        arrl[1] = arrl2[1];
        arrl[2] = arrl2[2];
        arrl[3] = arrl2[3];
        arrl[4] = arrl2[4];
        arrl[5] = arrl2[5];
        arrl[6] = arrl2[6];
        return new SecT409FieldElement(arrl);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return this.multiply(eCFieldElement.invert());
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecT409FieldElement)) {
            return false;
        }
        SecT409FieldElement secT409FieldElement = (SecT409FieldElement)object;
        long[] arrl = this.x;
        long[] arrl2 = secT409FieldElement.x;
        for (int i2 = 6; i2 >= 0; --i2) {
            if (arrl[i2] == arrl2[i2]) continue;
            return false;
        }
        return true;
    }

    @Override
    public int getFieldSize() {
        return 409;
    }

    @Override
    public ECFieldElement halfTrace() {
        long[] arrl = new long[7];
        long[] arrl2 = this.x;
        long[] arrl3 = new long[13];
        arrl[0] = arrl2[0];
        arrl[1] = arrl2[1];
        arrl[2] = arrl2[2];
        arrl[3] = arrl2[3];
        arrl[4] = arrl2[4];
        arrl[5] = arrl2[5];
        arrl[6] = arrl2[6];
        for (int i2 = 1; i2 < 409; i2 += 2) {
            SecT239Field.implSquare1(arrl, arrl3);
            SecT239Field.reduce1(arrl3, arrl);
            SecT239Field.implSquare1(arrl, arrl3);
            SecT239Field.reduce1(arrl3, arrl);
            arrl[0] = arrl[0] ^ arrl2[0];
            arrl[1] = arrl[1] ^ arrl2[1];
            arrl[2] = arrl[2] ^ arrl2[2];
            arrl[3] = arrl[3] ^ arrl2[3];
            arrl[4] = arrl[4] ^ arrl2[4];
            arrl[5] = arrl[5] ^ arrl2[5];
            arrl[6] = arrl[6] ^ arrl2[6];
        }
        return new SecT409FieldElement(arrl);
    }

    @Override
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return 4090087 ^ Nat576.hashCode(this.x, 0, 7);
    }

    @Override
    public ECFieldElement invert() {
        long[] arrl = new long[7];
        long[] arrl2 = this.x;
        if (!SecT239Field.isZero644(arrl2)) {
            long[] arrl3 = new long[7];
            long[] arrl4 = new long[7];
            long[] arrl5 = new long[7];
            long[] arrl6 = new long[13];
            SecT239Field.implSquare1(arrl2, arrl6);
            SecT239Field.reduce1(arrl6, arrl3);
            SecT239Field.squareN1(arrl3, 1, arrl4);
            long[] arrl7 = new long[14];
            SecT239Field.implMultiply1(arrl3, arrl4, arrl7);
            SecT239Field.reduce1(arrl7, arrl3);
            SecT239Field.squareN1(arrl4, 1, arrl4);
            long[] arrl8 = new long[14];
            SecT239Field.implMultiply1(arrl3, arrl4, arrl8);
            SecT239Field.reduce1(arrl8, arrl3);
            SecT239Field.squareN1(arrl3, 3, arrl4);
            long[] arrl9 = new long[14];
            SecT239Field.implMultiply1(arrl3, arrl4, arrl9);
            SecT239Field.reduce1(arrl9, arrl3);
            SecT239Field.squareN1(arrl3, 6, arrl4);
            long[] arrl10 = new long[14];
            SecT239Field.implMultiply1(arrl3, arrl4, arrl10);
            SecT239Field.reduce1(arrl10, arrl3);
            SecT239Field.squareN1(arrl3, 12, arrl4);
            long[] arrl11 = new long[14];
            SecT239Field.implMultiply1(arrl3, arrl4, arrl11);
            SecT239Field.reduce1(arrl11, arrl5);
            SecT239Field.squareN1(arrl5, 24, arrl3);
            SecT239Field.squareN1(arrl3, 24, arrl4);
            long[] arrl12 = new long[14];
            SecT239Field.implMultiply1(arrl3, arrl4, arrl12);
            SecT239Field.reduce1(arrl12, arrl3);
            SecT239Field.squareN1(arrl3, 48, arrl4);
            long[] arrl13 = new long[14];
            SecT239Field.implMultiply1(arrl3, arrl4, arrl13);
            SecT239Field.reduce1(arrl13, arrl3);
            SecT239Field.squareN1(arrl3, 96, arrl4);
            long[] arrl14 = new long[14];
            SecT239Field.implMultiply1(arrl3, arrl4, arrl14);
            SecT239Field.reduce1(arrl14, arrl3);
            SecT239Field.squareN1(arrl3, 192, arrl4);
            long[] arrl15 = new long[14];
            SecT239Field.implMultiply1(arrl3, arrl4, arrl15);
            SecT239Field.reduce1(arrl15, arrl3);
            long[] arrl16 = new long[14];
            SecT239Field.implMultiply1(arrl3, arrl5, arrl16);
            SecT239Field.reduce1(arrl16, arrl);
            return new SecT409FieldElement(arrl);
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean isOne() {
        long[] arrl = this.x;
        if (arrl[0] != 1L) {
            return false;
        }
        for (int i2 = 1; i2 < 7; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean isZero() {
        return SecT239Field.isZero644(this.x);
    }

    @Override
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] arrl = new long[7];
        SecT239Field.multiply1(this.x, ((SecT409FieldElement)eCFieldElement).x, arrl);
        return new SecT409FieldElement(arrl);
    }

    @Override
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return this.multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT409FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT409FieldElement)eCFieldElement2).x;
        long[] arrl4 = ((SecT409FieldElement)eCFieldElement3).x;
        long[] arrl5 = new long[13];
        SecT239Field.multiplyAddToExt1(arrl, arrl2, arrl5);
        SecT239Field.multiplyAddToExt1(arrl3, arrl4, arrl5);
        long[] arrl6 = new long[7];
        SecT239Field.reduce1(arrl5, arrl6);
        return new SecT409FieldElement(arrl6);
    }

    @Override
    public ECFieldElement negate() {
        return this;
    }

    @Override
    public ECFieldElement sqrt() {
        long[] arrl = new long[7];
        long[] arrl2 = this.x;
        long l2 = Interleave.unshuffle(arrl2[0]);
        long l3 = Interleave.unshuffle(arrl2[1]);
        long l4 = l2 & 0xFFFFFFFFL | l3 << 32;
        long l5 = l2 >>> 32 | l3 & -4294967296L;
        long l6 = Interleave.unshuffle(arrl2[2]);
        long l7 = Interleave.unshuffle(arrl2[3]);
        long l8 = l6 & 0xFFFFFFFFL | l7 << 32;
        long l9 = l6 >>> 32 | l7 & -4294967296L;
        long l10 = Interleave.unshuffle(arrl2[4]);
        long l11 = Interleave.unshuffle(arrl2[5]);
        long l12 = l10 & 0xFFFFFFFFL | l11 << 32;
        long l13 = l10 >>> 32 | l11 & -4294967296L;
        long l14 = Interleave.unshuffle(arrl2[6]);
        long l15 = l14 & 0xFFFFFFFFL;
        long l16 = l14 >>> 32;
        arrl[0] = l4 ^ l5 << 44;
        arrl[1] = l8 ^ l9 << 44 ^ l5 >>> 20;
        arrl[2] = l12 ^ l13 << 44 ^ l9 >>> 20;
        arrl[3] = l15 ^ l16 << 44 ^ l13 >>> 20 ^ l5 << 13;
        arrl[4] = l16 >>> 20 ^ l9 << 13 ^ l5 >>> 51;
        arrl[5] = l13 << 13 ^ l9 >>> 51;
        arrl[6] = l16 << 13 ^ l13 >>> 51;
        return new SecT409FieldElement(arrl);
    }

    @Override
    public ECFieldElement square() {
        long[] arrl = new long[7];
        long[] arrl2 = this.x;
        long[] arrl3 = new long[13];
        SecT239Field.implSquare1(arrl2, arrl3);
        SecT239Field.reduce1(arrl3, arrl);
        return new SecT409FieldElement(arrl);
    }

    @Override
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT409FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT409FieldElement)eCFieldElement2).x;
        long[] arrl4 = new long[13];
        long[] arrl5 = new long[13];
        SecT239Field.implSquare1(arrl, arrl5);
        for (int i2 = 0; i2 < 13; ++i2) {
            arrl4[i2] = arrl4[i2] ^ arrl5[i2];
        }
        SecT239Field.multiplyAddToExt1(arrl2, arrl3, arrl4);
        long[] arrl6 = new long[7];
        SecT239Field.reduce1(arrl4, arrl6);
        return new SecT409FieldElement(arrl6);
    }

    @Override
    public ECFieldElement squarePow(int n2) {
        if (n2 < 1) {
            return this;
        }
        long[] arrl = new long[7];
        SecT239Field.squareN1(this.x, n2, arrl);
        return new SecT409FieldElement(arrl);
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
        byte[] arrby = new byte[56];
        for (int i2 = 0; i2 < 7; ++i2) {
            long l2 = arrl[i2];
            if (l2 == 0L) continue;
            Nat576.longToBigEndian(l2, arrby, 6 - i2 << 3);
        }
        return new BigInteger(1, arrby);
    }

    @Override
    public int trace() {
        return 1 & (int)this.x[0];
    }
}

