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
import org.bouncycastle.math.ec.custom.sec.SecT571Field;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat576;

public class SecT571FieldElement
extends ECFieldElement.AbstractF2m {
    public long[] x;

    public SecT571FieldElement() {
        this.x = new long[9];
    }

    public SecT571FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= 571) {
            this.x = Nat576.fromBigInteger64(571, bigInteger);
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
    }

    public SecT571FieldElement(long[] arrl) {
        this.x = arrl;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] arrl = new long[9];
        SecT571Field.add(this.x, ((SecT571FieldElement)eCFieldElement).x, arrl);
        return new SecT571FieldElement(arrl);
    }

    @Override
    public ECFieldElement addOne() {
        long[] arrl = new long[9];
        SecT571Field.addOne(this.x, arrl);
        return new SecT571FieldElement(arrl);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return this.multiply(eCFieldElement.invert());
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecT571FieldElement)) {
            return false;
        }
        SecT571FieldElement secT571FieldElement = (SecT571FieldElement)object;
        long[] arrl = this.x;
        long[] arrl2 = secT571FieldElement.x;
        for (int i2 = 8; i2 >= 0; --i2) {
            if (arrl[i2] == arrl2[i2]) continue;
            return false;
        }
        return true;
    }

    @Override
    public int getFieldSize() {
        return 571;
    }

    @Override
    public ECFieldElement halfTrace() {
        int n2;
        long[] arrl = new long[9];
        long[] arrl2 = this.x;
        long[] arrl3 = new long[18];
        arrl[0] = arrl2[0];
        arrl[n2] = arrl2[n2];
        arrl[2] = arrl2[2];
        arrl[3] = arrl2[3];
        arrl[4] = arrl2[4];
        arrl[5] = arrl2[5];
        arrl[6] = arrl2[6];
        arrl[7] = arrl2[7];
        arrl[8] = arrl2[8];
        for (n2 = 1; n2 < 571; n2 += 2) {
            SecT571Field.implSquare(arrl, arrl3);
            SecT571Field.reduce(arrl3, arrl);
            SecT571Field.implSquare(arrl, arrl3);
            SecT571Field.reduce(arrl3, arrl);
            for (int i2 = 0; i2 < 9; ++i2) {
                arrl[i2] = arrl[i2] ^ arrl2[i2];
            }
        }
        return new SecT571FieldElement(arrl);
    }

    @Override
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return 5711052 ^ Nat576.hashCode(this.x, 0, 9);
    }

    @Override
    public ECFieldElement invert() {
        long[] arrl = new long[9];
        long[] arrl2 = this.x;
        if (!Nat576.isZero64(arrl2)) {
            long[] arrl3 = new long[9];
            long[] arrl4 = new long[9];
            long[] arrl5 = new long[9];
            SecT571Field.square(arrl2, arrl5);
            SecT571Field.square(arrl5, arrl3);
            SecT571Field.square(arrl3, arrl4);
            SecT571Field.multiply(arrl3, arrl4, arrl3);
            SecT571Field.squareN(arrl3, 2, arrl4);
            SecT571Field.multiply(arrl3, arrl4, arrl3);
            SecT571Field.multiply(arrl3, arrl5, arrl3);
            SecT571Field.squareN(arrl3, 5, arrl4);
            SecT571Field.multiply(arrl3, arrl4, arrl3);
            SecT571Field.squareN(arrl4, 5, arrl4);
            SecT571Field.multiply(arrl3, arrl4, arrl3);
            SecT571Field.squareN(arrl3, 15, arrl4);
            SecT571Field.multiply(arrl3, arrl4, arrl5);
            SecT571Field.squareN(arrl5, 30, arrl3);
            SecT571Field.squareN(arrl3, 30, arrl4);
            SecT571Field.multiply(arrl3, arrl4, arrl3);
            SecT571Field.squareN(arrl3, 60, arrl4);
            SecT571Field.multiply(arrl3, arrl4, arrl3);
            SecT571Field.squareN(arrl4, 60, arrl4);
            SecT571Field.multiply(arrl3, arrl4, arrl3);
            SecT571Field.squareN(arrl3, 180, arrl4);
            SecT571Field.multiply(arrl3, arrl4, arrl3);
            SecT571Field.squareN(arrl4, 180, arrl4);
            SecT571Field.multiply(arrl3, arrl4, arrl3);
            SecT571Field.multiply(arrl3, arrl5, arrl);
            return new SecT571FieldElement(arrl);
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean isOne() {
        long[] arrl = this.x;
        if (arrl[0] != 1L) {
            return false;
        }
        for (int i2 = 1; i2 < 9; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean isZero() {
        return Nat576.isZero64(this.x);
    }

    @Override
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] arrl = new long[9];
        SecT571Field.multiply(this.x, ((SecT571FieldElement)eCFieldElement).x, arrl);
        return new SecT571FieldElement(arrl);
    }

    @Override
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return this.multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT571FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT571FieldElement)eCFieldElement2).x;
        long[] arrl4 = ((SecT571FieldElement)eCFieldElement3).x;
        long[] arrl5 = new long[18];
        SecT571Field.multiplyAddToExt(arrl, arrl2, arrl5);
        SecT571Field.multiplyAddToExt(arrl3, arrl4, arrl5);
        long[] arrl6 = new long[9];
        SecT571Field.reduce(arrl5, arrl6);
        return new SecT571FieldElement(arrl6);
    }

    @Override
    public ECFieldElement negate() {
        return this;
    }

    @Override
    public ECFieldElement sqrt() {
        long[] arrl = new long[9];
        long[] arrl2 = this.x;
        long[] arrl3 = new long[9];
        long[] arrl4 = new long[9];
        int n2 = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            int n3 = n2 + 1;
            long l2 = Interleave.unshuffle(arrl2[n2]);
            n2 = n3 + 1;
            long l3 = Interleave.unshuffle(arrl2[n3]);
            arrl3[i2] = 0xFFFFFFFFL & l2 | l3 << 32;
            arrl4[i2] = l2 >>> 32 | -4294967296L & l3;
        }
        long l4 = Interleave.unshuffle(arrl2[n2]);
        arrl3[4] = 0xFFFFFFFFL & l4;
        arrl4[4] = l4 >>> 32;
        SecT571Field.multiply(arrl4, SecT571Field.ROOT_Z, arrl);
        SecT571Field.add(arrl, arrl3, arrl);
        return new SecT571FieldElement(arrl);
    }

    @Override
    public ECFieldElement square() {
        long[] arrl = new long[9];
        SecT571Field.square(this.x, arrl);
        return new SecT571FieldElement(arrl);
    }

    @Override
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT571FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT571FieldElement)eCFieldElement2).x;
        long[] arrl4 = new long[18];
        SecT571Field.squareAddToExt(arrl, arrl4);
        SecT571Field.multiplyAddToExt(arrl2, arrl3, arrl4);
        long[] arrl5 = new long[9];
        SecT571Field.reduce(arrl4, arrl5);
        return new SecT571FieldElement(arrl5);
    }

    @Override
    public ECFieldElement squarePow(int n2) {
        if (n2 < 1) {
            return this;
        }
        long[] arrl = new long[9];
        SecT571Field.squareN(this.x, n2, arrl);
        return new SecT571FieldElement(arrl);
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
        byte[] arrby = new byte[72];
        for (int i2 = 0; i2 < 9; ++i2) {
            long l2 = arrl[i2];
            if (l2 == 0L) continue;
            Nat576.longToBigEndian(l2, arrby, 8 - i2 << 3);
        }
        return new BigInteger(1, arrby);
    }

    @Override
    public int trace() {
        long[] arrl = this.x;
        return 1 & (int)(arrl[0] ^ arrl[8] >>> 49 ^ arrl[8] >>> 57);
    }
}

