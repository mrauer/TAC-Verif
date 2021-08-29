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
import org.bouncycastle.math.ec.custom.sec.SecP160R1Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP160R1FieldElement
extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF"));
    public int[] x;

    public SecP160R1FieldElement() {
        this.x = new int[5];
    }

    public SecP160R1FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(Q) < 0) {
            int[] arrn;
            int[] arrn2 = SecT239Field.fromBigInteger1(bigInteger);
            if (arrn2[4] == -1 && SecT239Field.gte1(arrn2, arrn = SecP160R1Field.P)) {
                SecT239Field.subFrom1(arrn, arrn2);
            }
            this.x = arrn2;
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecP160R1FieldElement");
    }

    public SecP160R1FieldElement(int[] arrn) {
        this.x = arrn;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] arrn = new int[5];
        SecP160R1Field.add(this.x, ((SecP160R1FieldElement)eCFieldElement).x, arrn);
        return new SecP160R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement addOne() {
        int[] arrn = new int[5];
        if (Nat576.inc(5, this.x, arrn) != 0 || arrn[4] == -1 && SecT239Field.gte1(arrn, SecP160R1Field.P)) {
            Nat576.addWordTo(5, -2147483647, arrn);
        }
        return new SecP160R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] arrn = new int[5];
        int[] arrn2 = ((SecP160R1FieldElement)eCFieldElement).x;
        SecT239Field.checkedModOddInverse(SecP160R1Field.P, arrn2, arrn);
        SecP160R1Field.multiply(arrn, this.x, arrn);
        return new SecP160R1FieldElement(arrn);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecP160R1FieldElement)) {
            return false;
        }
        SecP160R1FieldElement secP160R1FieldElement = (SecP160R1FieldElement)object;
        return SecT239Field.eq1(this.x, secP160R1FieldElement.x);
    }

    @Override
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Nat576.hashCode(this.x, 0, 5);
    }

    @Override
    public ECFieldElement invert() {
        int[] arrn = new int[5];
        int[] arrn2 = this.x;
        SecT239Field.checkedModOddInverse(SecP160R1Field.P, arrn2, arrn);
        return new SecP160R1FieldElement(arrn);
    }

    @Override
    public boolean isOne() {
        return SecT239Field.isOne1(this.x);
    }

    @Override
    public boolean isZero() {
        return SecT239Field.isZero1(this.x);
    }

    @Override
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] arrn = new int[5];
        SecP160R1Field.multiply(this.x, ((SecP160R1FieldElement)eCFieldElement).x, arrn);
        return new SecP160R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement negate() {
        int[] arrn = new int[5];
        int[] arrn2 = this.x;
        if (SecP160R1Field.isZero(arrn2) != 0) {
            int[] arrn3 = SecP160R1Field.P;
            SecT239Field.sub1(arrn3, arrn3, arrn);
        } else {
            SecT239Field.sub1(SecP160R1Field.P, arrn2, arrn);
        }
        return new SecP160R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement sqrt() {
        int[] arrn = this.x;
        if (!SecT239Field.isZero1(arrn)) {
            if (SecT239Field.isOne1(arrn)) {
                return this;
            }
            int[] arrn2 = new int[5];
            int[] arrn3 = new int[10];
            SecT239Field.square1(arrn, arrn3);
            SecP160R1Field.reduce(arrn3, arrn2);
            int[] arrn4 = new int[10];
            SecT239Field.mul1(arrn2, arrn, arrn4);
            SecP160R1Field.reduce(arrn4, arrn2);
            int[] arrn5 = new int[5];
            SecP160R1Field.squareN(arrn2, 2, arrn5);
            int[] arrn6 = new int[10];
            SecT239Field.mul1(arrn5, arrn2, arrn6);
            SecP160R1Field.reduce(arrn6, arrn5);
            SecP160R1Field.squareN(arrn5, 4, arrn2);
            int[] arrn7 = new int[10];
            SecT239Field.mul1(arrn2, arrn5, arrn7);
            SecP160R1Field.reduce(arrn7, arrn2);
            SecP160R1Field.squareN(arrn2, 8, arrn5);
            int[] arrn8 = new int[10];
            SecT239Field.mul1(arrn5, arrn2, arrn8);
            SecP160R1Field.reduce(arrn8, arrn5);
            SecP160R1Field.squareN(arrn5, 16, arrn2);
            int[] arrn9 = new int[10];
            SecT239Field.mul1(arrn2, arrn5, arrn9);
            SecP160R1Field.reduce(arrn9, arrn2);
            SecP160R1Field.squareN(arrn2, 32, arrn5);
            int[] arrn10 = new int[10];
            SecT239Field.mul1(arrn5, arrn2, arrn10);
            SecP160R1Field.reduce(arrn10, arrn5);
            SecP160R1Field.squareN(arrn5, 64, arrn2);
            int[] arrn11 = new int[10];
            SecT239Field.mul1(arrn2, arrn5, arrn11);
            SecP160R1Field.reduce(arrn11, arrn2);
            int[] arrn12 = new int[10];
            SecT239Field.square1(arrn2, arrn12);
            SecP160R1Field.reduce(arrn12, arrn5);
            int[] arrn13 = new int[10];
            SecT239Field.mul1(arrn5, arrn, arrn13);
            SecP160R1Field.reduce(arrn13, arrn5);
            SecP160R1Field.squareN(arrn5, 29, arrn5);
            int[] arrn14 = new int[10];
            SecT239Field.square1(arrn5, arrn14);
            SecP160R1Field.reduce(arrn14, arrn2);
            if (SecT239Field.eq1(arrn, arrn2)) {
                return new SecP160R1FieldElement(arrn5);
            }
            return null;
        }
        return this;
    }

    @Override
    public ECFieldElement square() {
        int[] arrn = new int[5];
        SecP160R1Field.square(this.x, arrn);
        return new SecP160R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] arrn = new int[5];
        SecP160R1Field.subtract(this.x, ((SecP160R1FieldElement)eCFieldElement).x, arrn);
        return new SecP160R1FieldElement(arrn);
    }

    @Override
    public boolean testBitZero() {
        int n2 = SecT239Field.getBit1(this.x, 0);
        boolean bl = false;
        if (n2 == 1) {
            bl = true;
        }
        return bl;
    }

    @Override
    public BigInteger toBigInteger() {
        return SecT239Field.toBigInteger1(this.x);
    }
}

