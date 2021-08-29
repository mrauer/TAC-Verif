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

public class SecT233FieldElement
extends ECFieldElement.AbstractF2m {
    public long[] x;

    public SecT233FieldElement() {
        this.x = new long[4];
    }

    public SecT233FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= 233) {
            this.x = Nat576.fromBigInteger64(233, bigInteger);
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
    }

    public SecT233FieldElement(long[] arrl) {
        this.x = arrl;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] arrl = new long[4];
        long[] arrl2 = this.x;
        long[] arrl3 = ((SecT233FieldElement)eCFieldElement).x;
        arrl[0] = arrl2[0] ^ arrl3[0];
        arrl[1] = arrl2[1] ^ arrl3[1];
        arrl[2] = arrl2[2] ^ arrl3[2];
        arrl[3] = arrl2[3] ^ arrl3[3];
        return new SecT233FieldElement(arrl);
    }

    @Override
    public ECFieldElement addOne() {
        long[] arrl = new long[4];
        long[] arrl2 = this.x;
        arrl[0] = 1L ^ arrl2[0];
        arrl[1] = arrl2[1];
        arrl[2] = arrl2[2];
        arrl[3] = arrl2[3];
        return new SecT233FieldElement(arrl);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return this.multiply(eCFieldElement.invert());
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecT233FieldElement)) {
            return false;
        }
        SecT233FieldElement secT233FieldElement = (SecT233FieldElement)object;
        return SecT239Field.eq642(this.x, secT233FieldElement.x);
    }

    @Override
    public int getFieldSize() {
        return 233;
    }

    @Override
    public ECFieldElement halfTrace() {
        long[] arrl = new long[4];
        long[] arrl2 = this.x;
        long[] arrl3 = new long[8];
        SecT239Field.copy642(arrl2, arrl);
        for (int i2 = 1; i2 < 233; i2 += 2) {
            R.style.implSquare2((long[])arrl, (long[])arrl3);
            R.style.reduce2((long[])arrl3, (long[])arrl);
            R.style.implSquare2((long[])arrl, (long[])arrl3);
            R.style.reduce2((long[])arrl3, (long[])arrl);
            arrl[0] = arrl[0] ^ arrl2[0];
            arrl[1] = arrl[1] ^ arrl2[1];
            arrl[2] = arrl[2] ^ arrl2[2];
            arrl[3] = arrl[3] ^ arrl2[3];
        }
        return new SecT233FieldElement(arrl);
    }

    @Override
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return 2330074 ^ Nat576.hashCode(this.x, 0, 4);
    }

    @Override
    public ECFieldElement invert() {
        long[] arrl = new long[4];
        long[] arrl2 = this.x;
        if (!SecT239Field.isZero642(arrl2)) {
            long[] arrl3 = new long[4];
            long[] arrl4 = new long[4];
            R.style.square2((long[])arrl2, (long[])arrl3);
            long[] arrl5 = new long[8];
            R.style.implMultiply2((long[])arrl3, (long[])arrl2, (long[])arrl5);
            R.style.reduce2((long[])arrl5, (long[])arrl3);
            R.style.square2((long[])arrl3, (long[])arrl3);
            long[] arrl6 = new long[8];
            R.style.implMultiply2((long[])arrl3, (long[])arrl2, (long[])arrl6);
            R.style.reduce2((long[])arrl6, (long[])arrl3);
            R.style.squareN2((long[])arrl3, (int)3, (long[])arrl4);
            long[] arrl7 = new long[8];
            R.style.implMultiply2((long[])arrl4, (long[])arrl3, (long[])arrl7);
            R.style.reduce2((long[])arrl7, (long[])arrl4);
            R.style.square2((long[])arrl4, (long[])arrl4);
            long[] arrl8 = new long[8];
            R.style.implMultiply2((long[])arrl4, (long[])arrl2, (long[])arrl8);
            R.style.reduce2((long[])arrl8, (long[])arrl4);
            R.style.squareN2((long[])arrl4, (int)7, (long[])arrl3);
            long[] arrl9 = new long[8];
            R.style.implMultiply2((long[])arrl3, (long[])arrl4, (long[])arrl9);
            R.style.reduce2((long[])arrl9, (long[])arrl3);
            R.style.squareN2((long[])arrl3, (int)14, (long[])arrl4);
            long[] arrl10 = new long[8];
            R.style.implMultiply2((long[])arrl4, (long[])arrl3, (long[])arrl10);
            R.style.reduce2((long[])arrl10, (long[])arrl4);
            R.style.square2((long[])arrl4, (long[])arrl4);
            long[] arrl11 = new long[8];
            R.style.implMultiply2((long[])arrl4, (long[])arrl2, (long[])arrl11);
            R.style.reduce2((long[])arrl11, (long[])arrl4);
            R.style.squareN2((long[])arrl4, (int)29, (long[])arrl3);
            long[] arrl12 = new long[8];
            R.style.implMultiply2((long[])arrl3, (long[])arrl4, (long[])arrl12);
            R.style.reduce2((long[])arrl12, (long[])arrl3);
            R.style.squareN2((long[])arrl3, (int)58, (long[])arrl4);
            long[] arrl13 = new long[8];
            R.style.implMultiply2((long[])arrl4, (long[])arrl3, (long[])arrl13);
            R.style.reduce2((long[])arrl13, (long[])arrl4);
            R.style.squareN2((long[])arrl4, (int)116, (long[])arrl3);
            long[] arrl14 = new long[8];
            R.style.implMultiply2((long[])arrl3, (long[])arrl4, (long[])arrl14);
            R.style.reduce2((long[])arrl14, (long[])arrl3);
            R.style.square2((long[])arrl3, (long[])arrl);
            return new SecT233FieldElement(arrl);
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
        R.style.multiply2((long[])this.x, (long[])((SecT233FieldElement)eCFieldElement).x, (long[])arrl);
        return new SecT233FieldElement(arrl);
    }

    @Override
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return this.multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT233FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT233FieldElement)eCFieldElement2).x;
        long[] arrl4 = ((SecT233FieldElement)eCFieldElement3).x;
        long[] arrl5 = new long[8];
        R.style.multiplyAddToExt2((long[])arrl, (long[])arrl2, (long[])arrl5);
        R.style.multiplyAddToExt2((long[])arrl3, (long[])arrl4, (long[])arrl5);
        long[] arrl6 = new long[4];
        R.style.reduce2((long[])arrl5, (long[])arrl6);
        return new SecT233FieldElement(arrl6);
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
        long l6 = Interleave.unshuffle(arrl2[2]);
        int n2 = 3;
        long l7 = Interleave.unshuffle(arrl2[n2]);
        long l8 = 0xFFFFFFFFL & l6 | l7 << 32;
        long l9 = l6 >>> 32 | l7 & -4294967296L;
        long l10 = l9 >>> 27;
        long l11 = l9 ^ (l5 >>> 27 | l9 << 37);
        long l12 = l5 ^ l5 << 37;
        long[] arrl3 = new long[8];
        int[] arrn = new int[n2];
        arrn[0] = 32;
        arrn[1] = 117;
        arrn[2] = 191;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = arrn[i2] >>> 6;
            int n4 = 63 & arrn[i2];
            arrl3[n3] = arrl3[n3] ^ l12 << n4;
            int n5 = n3 + 1;
            long l13 = arrl3[n5];
            long l14 = l11 << n4;
            int n6 = -n4;
            arrl3[n5] = l13 ^ (l14 | l12 >>> n6);
            int n7 = n3 + 2;
            arrl3[n7] = arrl3[n7] ^ (l10 << n4 | l11 >>> n6);
            n2 = 3;
            int n8 = n3 + 3;
            arrl3[n8] = arrl3[n8] ^ l10 >>> n6;
        }
        R.style.reduce2((long[])arrl3, (long[])arrl);
        arrl[0] = l4 ^ arrl[0];
        arrl[1] = l8 ^ arrl[1];
        return new SecT233FieldElement(arrl);
    }

    @Override
    public ECFieldElement square() {
        long[] arrl = new long[4];
        R.style.square2((long[])this.x, (long[])arrl);
        return new SecT233FieldElement(arrl);
    }

    @Override
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] arrl = this.x;
        long[] arrl2 = ((SecT233FieldElement)eCFieldElement).x;
        long[] arrl3 = ((SecT233FieldElement)eCFieldElement2).x;
        long[] arrl4 = new long[8];
        long[] arrl5 = new long[8];
        R.style.implSquare2((long[])arrl, (long[])arrl5);
        R.style.addExt2((long[])arrl4, (long[])arrl5, (long[])arrl4);
        R.style.multiplyAddToExt2((long[])arrl2, (long[])arrl3, (long[])arrl4);
        long[] arrl6 = new long[4];
        R.style.reduce2((long[])arrl4, (long[])arrl6);
        return new SecT233FieldElement(arrl6);
    }

    @Override
    public ECFieldElement squarePow(int n2) {
        if (n2 < 1) {
            return this;
        }
        long[] arrl = new long[4];
        R.style.squareN2((long[])this.x, (int)n2, (long[])arrl);
        return new SecT233FieldElement(arrl);
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
        return 1 & (int)(arrl[0] ^ arrl[2] >>> 31);
    }
}

