/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP384R1Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP384R1FieldElement
extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));
    public int[] x;

    public SecP384R1FieldElement() {
        this.x = new int[12];
    }

    public SecP384R1FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(Q) < 0) {
            int[] arrn;
            int[] arrn2 = Nat576.fromBigInteger(384, bigInteger);
            if (arrn2[11] == -1 && Nat576.gte(12, arrn2, arrn = SecP384R1Field.P)) {
                Nat576.subFrom(12, arrn, arrn2);
            }
            this.x = arrn2;
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
    }

    public SecP384R1FieldElement(int[] arrn) {
        this.x = arrn;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] arrn = new int[12];
        SecP384R1Field.add(this.x, ((SecP384R1FieldElement)eCFieldElement).x, arrn);
        return new SecP384R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement addOne() {
        int[] arrn = new int[12];
        if (Nat576.inc(12, this.x, arrn) != 0 || arrn[11] == -1 && Nat576.gte(12, arrn, SecP384R1Field.P)) {
            SecP384R1Field.addPInvTo(arrn);
        }
        return new SecP384R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] arrn = new int[12];
        int[] arrn2 = ((SecP384R1FieldElement)eCFieldElement).x;
        SecT239Field.checkedModOddInverse(SecP384R1Field.P, arrn2, arrn);
        SecP384R1Field.multiply(arrn, this.x, arrn);
        return new SecP384R1FieldElement(arrn);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecP384R1FieldElement)) {
            return false;
        }
        SecP384R1FieldElement secP384R1FieldElement = (SecP384R1FieldElement)object;
        return Nat576.eq(12, this.x, secP384R1FieldElement.x);
    }

    @Override
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Nat576.hashCode(this.x, 0, 12);
    }

    @Override
    public ECFieldElement invert() {
        int[] arrn = new int[12];
        int[] arrn2 = this.x;
        SecT239Field.checkedModOddInverse(SecP384R1Field.P, arrn2, arrn);
        return new SecP384R1FieldElement(arrn);
    }

    @Override
    public boolean isOne() {
        return Nat576.isOne(12, this.x);
    }

    @Override
    public boolean isZero() {
        return Nat576.isZero(12, this.x);
    }

    @Override
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] arrn = new int[12];
        SecP384R1Field.multiply(this.x, ((SecP384R1FieldElement)eCFieldElement).x, arrn);
        return new SecP384R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement negate() {
        int[] arrn = new int[12];
        int[] arrn2 = this.x;
        if (SecP384R1Field.isZero(arrn2) != 0) {
            int[] arrn3 = SecP384R1Field.P;
            Nat576.sub(12, arrn3, arrn3, arrn);
        } else {
            Nat576.sub(12, SecP384R1Field.P, arrn2, arrn);
        }
        return new SecP384R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement sqrt() {
        int[] arrn = this.x;
        if (!Nat576.isZero(12, arrn)) {
            if (Nat576.isOne(12, arrn)) {
                return this;
            }
            int[] arrn2 = new int[12];
            int[] arrn3 = new int[12];
            int[] arrn4 = new int[12];
            int[] arrn5 = new int[12];
            int[] arrn6 = new int[24];
            Interleave.square(arrn, arrn6);
            SecP384R1Field.reduce(arrn6, arrn2);
            int[] arrn7 = new int[24];
            Interleave.mul(arrn2, arrn, arrn7);
            SecP384R1Field.reduce(arrn7, arrn2);
            SecP384R1Field.squareN(arrn2, 2, arrn3);
            int[] arrn8 = new int[24];
            Interleave.mul(arrn3, arrn2, arrn8);
            SecP384R1Field.reduce(arrn8, arrn3);
            int[] arrn9 = new int[24];
            Interleave.square(arrn3, arrn9);
            SecP384R1Field.reduce(arrn9, arrn3);
            int[] arrn10 = new int[24];
            Interleave.mul(arrn3, arrn, arrn10);
            SecP384R1Field.reduce(arrn10, arrn3);
            SecP384R1Field.squareN(arrn3, 5, arrn4);
            int[] arrn11 = new int[24];
            Interleave.mul(arrn4, arrn3, arrn11);
            SecP384R1Field.reduce(arrn11, arrn4);
            SecP384R1Field.squareN(arrn4, 5, arrn5);
            int[] arrn12 = new int[24];
            Interleave.mul(arrn5, arrn3, arrn12);
            SecP384R1Field.reduce(arrn12, arrn5);
            SecP384R1Field.squareN(arrn5, 15, arrn3);
            int[] arrn13 = new int[24];
            Interleave.mul(arrn3, arrn5, arrn13);
            SecP384R1Field.reduce(arrn13, arrn3);
            SecP384R1Field.squareN(arrn3, 2, arrn4);
            int[] arrn14 = new int[24];
            Interleave.mul(arrn2, arrn4, arrn14);
            SecP384R1Field.reduce(arrn14, arrn2);
            SecP384R1Field.squareN(arrn4, 28, arrn4);
            int[] arrn15 = new int[24];
            Interleave.mul(arrn3, arrn4, arrn15);
            SecP384R1Field.reduce(arrn15, arrn3);
            SecP384R1Field.squareN(arrn3, 60, arrn4);
            int[] arrn16 = new int[24];
            Interleave.mul(arrn4, arrn3, arrn16);
            SecP384R1Field.reduce(arrn16, arrn4);
            SecP384R1Field.squareN(arrn4, 120, arrn3);
            int[] arrn17 = new int[24];
            Interleave.mul(arrn3, arrn4, arrn17);
            SecP384R1Field.reduce(arrn17, arrn3);
            SecP384R1Field.squareN(arrn3, 15, arrn3);
            int[] arrn18 = new int[24];
            Interleave.mul(arrn3, arrn5, arrn18);
            SecP384R1Field.reduce(arrn18, arrn3);
            SecP384R1Field.squareN(arrn3, 33, arrn3);
            int[] arrn19 = new int[24];
            Interleave.mul(arrn3, arrn2, arrn19);
            SecP384R1Field.reduce(arrn19, arrn3);
            SecP384R1Field.squareN(arrn3, 64, arrn3);
            int[] arrn20 = new int[24];
            Interleave.mul(arrn3, arrn, arrn20);
            SecP384R1Field.reduce(arrn20, arrn3);
            SecP384R1Field.squareN(arrn3, 30, arrn2);
            int[] arrn21 = new int[24];
            Interleave.square(arrn2, arrn21);
            SecP384R1Field.reduce(arrn21, arrn3);
            if (Nat576.eq(12, arrn, arrn3)) {
                return new SecP384R1FieldElement(arrn2);
            }
            return null;
        }
        return this;
    }

    @Override
    public ECFieldElement square() {
        int[] arrn = new int[12];
        SecP384R1Field.square(this.x, arrn);
        return new SecP384R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] arrn = new int[12];
        SecP384R1Field.subtract(this.x, ((SecP384R1FieldElement)eCFieldElement).x, arrn);
        return new SecP384R1FieldElement(arrn);
    }

    @Override
    public boolean testBitZero() {
        int n2 = Nat576.getBit(this.x, 0);
        boolean bl = false;
        if (n2 == 1) {
            bl = true;
        }
        return bl;
    }

    @Override
    public BigInteger toBigInteger() {
        return Nat576.toBigInteger(12, this.x);
    }
}

