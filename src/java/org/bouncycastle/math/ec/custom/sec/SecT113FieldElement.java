/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec.custom.sec;

import com.google.android.material.R;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat576;

public class SecT113FieldElement
extends ECFieldElement.AbstractF2m {
    public long[] x;

    public SecT113FieldElement() {
        this.x = new long[2];
    }

    public SecT113FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= 113) {
            this.x = Nat576.fromBigInteger64(113, bigInteger);
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
    }

    public SecT113FieldElement(long[] arrl) {
        this.x = arrl;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] arrl = new long[2];
        long[] arrl2 = this.x;
        long[] arrl3 = ((SecT113FieldElement)eCFieldElement).x;
        arrl[0] = arrl2[0] ^ arrl3[0];
        arrl[1] = arrl2[1] ^ arrl3[1];
        return new SecT113FieldElement(arrl);
    }

    @Override
    public ECFieldElement addOne() {
        long[] arrl = new long[2];
        long[] arrl2 = this.x;
        arrl[0] = 1L ^ arrl2[0];
        arrl[1] = arrl2[1];
        return new SecT113FieldElement(arrl);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return this.multiply(eCFieldElement.invert());
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecT113FieldElement)) {
            return false;
        }
        SecT113FieldElement secT113FieldElement = (SecT113FieldElement)object;
        long[] arrl = this.x;
        long[] arrl2 = secT113FieldElement.x;
        for (int i2 = 1; i2 >= 0; --i2) {
            if (arrl[i2] == arrl2[i2]) continue;
            return false;
        }
        return true;
    }

    @Override
    public int getFieldSize() {
        return 113;
    }

    @Override
    public ECFieldElement halfTrace() {
        long[] arrl = new long[2];
        long[] arrl2 = this.x;
        long[] arrl3 = new long[4];
        arrl[0] = arrl2[0];
        arrl[1] = arrl2[1];
        for (int i2 = 1; i2 < 113; i2 += 2) {
            R.style.implSquare((long[])arrl, (long[])arrl3);
            R.style.reduce((long[])arrl3, (long[])arrl);
            R.style.implSquare((long[])arrl, (long[])arrl3);
            R.style.reduce((long[])arrl3, (long[])arrl);
            arrl[0] = arrl[0] ^ arrl2[0];
            arrl[1] = arrl[1] ^ arrl2[1];
        }
        return new SecT113FieldElement(arrl);
    }

    public int hashCode() {
        return 113009 ^ Nat576.hashCode(this.x, 0, 2);
    }

    @Override
    public ECFieldElement invert() {
        long[] arrl = new long[2];
        long[] arrl2 = this.x;
        if (!SecT239Field.isZero64(arrl2)) {
            long[] arrl3 = new long[2];
            long[] arrl4 = new long[2];
            R.style.square((long[])arrl2, (long[])arrl3);
            long[] arrl5 = new long[8];
            R.style.implMultiply((long[])arrl3, (long[])arrl2, (long[])arrl5);
            R.style.reduce((long[])arrl5, (long[])arrl3);
            R.style.square((long[])arrl3, (long[])arrl3);
            long[] arrl6 = new long[8];
            R.style.implMultiply((long[])arrl3, (long[])arrl2, (long[])arrl6);
            R.style.reduce((long[])arrl6, (long[])arrl3);
            R.style.squareN((long[])arrl3, (int)3, (long[])arrl4);
            long[] arrl7 = new long[8];
            R.style.implMultiply((long[])arrl4, (long[])arrl3, (long[])arrl7);
            R.style.reduce((long[])arrl7, (long[])arrl4);
            R.style.square((long[])arrl4, (long[])arrl4);
            long[] arrl8 = new long[8];
            R.style.implMultiply((long[])arrl4, (long[])arrl2, (long[])arrl8);
            R.style.reduce((long[])arrl8, (long[])arrl4);
            R.style.squareN((long[])arrl4, (int)7, (long[])arrl3);
            long[] arrl9 = new long[8];
            R.style.implMultiply((long[])arrl3, (long[])arrl4, (long[])arrl9);
            R.style.reduce((long[])arrl9, (long[])arrl3);
            R.style.squareN((long[])arrl3, (int)14, (long[])arrl4);
            long[] arrl10 = new long[8];
            R.style.implMultiply((long[])arrl4, (long[])arrl3, (long[])arrl10);
            R.style.reduce((long[])arrl10, (long[])arrl4);
            R.style.squareN((long[])arrl4, (int)28, (long[])arrl3);
            long[] arrl11 = new long[8];
            R.style.implMultiply((long[])arrl3, (long[])arrl4, (long[])arrl11);
            R.style.reduce((long[])arrl11, (long[])arrl3);
            R.style.squareN((long[])arrl3, (int)56, (long[])arrl4);
            long[] arrl12 = new long[8];
            R.style.implMultiply((long[])arrl4, (long[])arrl3, (long[])arrl12);
            R.style.reduce((long[])arrl12, (long[])arrl4);
            R.style.square((long[])arrl4, (long[])arrl);
            return new SecT113FieldElement(arrl);
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean isOne() {
        long[] arrl = this.x;
        if (arrl[0] != 1L) {
            return false;
        }
        for (int i2 = 1; i2 < 2; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean isZero() {
        return SecT239Field.isZero64(this.x);
    }

    @Override
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] arrl = new long[2];
        R.style.multiply((long[])this.x, (long[])((SecT113FieldElement)eCFieldElement).x, (long[])arrl);
        return new SecT113FieldElement(arrl);
    }

    @Override
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return this.multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT113FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT113FieldElement)eCFieldElement2).x;
        long[] arrl4 = ((SecT113FieldElement)eCFieldElement3).x;
        long[] arrl5 = new long[4];
        R.style.multiplyAddToExt((long[])arrl, (long[])arrl2, (long[])arrl5);
        R.style.multiplyAddToExt((long[])arrl3, (long[])arrl4, (long[])arrl5);
        long[] arrl6 = new long[2];
        R.style.reduce((long[])arrl5, (long[])arrl6);
        return new SecT113FieldElement(arrl6);
    }

    @Override
    public ECFieldElement negate() {
        return this;
    }

    @Override
    public ECFieldElement sqrt() {
        long[] arrl = new long[2];
        long[] arrl2 = this.x;
        long l2 = Interleave.unshuffle(arrl2[0]);
        long l3 = Interleave.unshuffle(arrl2[1]);
        long l4 = 0xFFFFFFFFL & l2 | l3 << 32;
        long l5 = l2 >>> 32 | l3 & -4294967296L;
        arrl[0] = l4 ^ l5 << 57 ^ l5 << 5;
        arrl[1] = l5 >>> 7 ^ l5 >>> 59;
        return new SecT113FieldElement(arrl);
    }

    @Override
    public ECFieldElement square() {
        long[] arrl = new long[2];
        R.style.square((long[])this.x, (long[])arrl);
        return new SecT113FieldElement(arrl);
    }

    @Override
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT113FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT113FieldElement)eCFieldElement2).x;
        long[] arrl4 = new long[4];
        long[] arrl5 = new long[4];
        R.style.implSquare((long[])arrl, (long[])arrl5);
        R.style.addExt((long[])arrl4, (long[])arrl5, (long[])arrl4);
        R.style.multiplyAddToExt((long[])arrl2, (long[])arrl3, (long[])arrl4);
        long[] arrl6 = new long[2];
        R.style.reduce((long[])arrl4, (long[])arrl6);
        return new SecT113FieldElement(arrl6);
    }

    @Override
    public ECFieldElement squarePow(int n2) {
        if (n2 < 1) {
            return this;
        }
        long[] arrl = new long[2];
        R.style.squareN((long[])this.x, (int)n2, (long[])arrl);
        return new SecT113FieldElement(arrl);
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
        byte[] arrby = new byte[16];
        for (int i2 = 0; i2 < 2; ++i2) {
            long l2 = arrl[i2];
            if (l2 == 0L) continue;
            Nat576.longToBigEndian(l2, arrby, 1 - i2 << 3);
        }
        return new BigInteger(1, arrby);
    }

    @Override
    public int trace() {
        return 1 & (int)this.x[0];
    }
}

