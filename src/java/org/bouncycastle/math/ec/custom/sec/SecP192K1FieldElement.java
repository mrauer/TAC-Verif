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
import org.bouncycastle.math.ec.custom.sec.SecP192K1Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP192K1FieldElement
extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));
    public int[] x;

    public SecP192K1FieldElement() {
        this.x = new int[6];
    }

    public SecP192K1FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(Q) < 0) {
            int[] arrn;
            int[] arrn2 = SecT239Field.fromBigInteger2(bigInteger);
            if (arrn2[5] == -1 && SecT239Field.gte2(arrn2, arrn = SecP192K1Field.P)) {
                SecT239Field.subFrom2(arrn, arrn2);
            }
            this.x = arrn2;
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
    }

    public SecP192K1FieldElement(int[] arrn) {
        this.x = arrn;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] arrn = new int[6];
        if (SecT239Field.add2(this.x, ((SecP192K1FieldElement)eCFieldElement).x, arrn) != 0 || arrn[5] == -1 && SecT239Field.gte2(arrn, SecP192K1Field.P)) {
            Nat576.add33To(6, 4553, arrn);
        }
        return new SecP192K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement addOne() {
        int[] arrn = new int[6];
        if (Nat576.inc(6, this.x, arrn) != 0 || arrn[5] == -1 && SecT239Field.gte2(arrn, SecP192K1Field.P)) {
            Nat576.add33To(6, 4553, arrn);
        }
        return new SecP192K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] arrn = new int[6];
        int[] arrn2 = ((SecP192K1FieldElement)eCFieldElement).x;
        SecT239Field.checkedModOddInverse(SecP192K1Field.P, arrn2, arrn);
        SecP192K1Field.multiply(arrn, this.x, arrn);
        return new SecP192K1FieldElement(arrn);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecP192K1FieldElement)) {
            return false;
        }
        SecP192K1FieldElement secP192K1FieldElement = (SecP192K1FieldElement)object;
        return SecT239Field.eq2(this.x, secP192K1FieldElement.x);
    }

    @Override
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Nat576.hashCode(this.x, 0, 6);
    }

    @Override
    public ECFieldElement invert() {
        int[] arrn = new int[6];
        int[] arrn2 = this.x;
        SecT239Field.checkedModOddInverse(SecP192K1Field.P, arrn2, arrn);
        return new SecP192K1FieldElement(arrn);
    }

    @Override
    public boolean isOne() {
        return SecT239Field.isOne2(this.x);
    }

    @Override
    public boolean isZero() {
        return SecT239Field.isZero2(this.x);
    }

    @Override
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] arrn = new int[6];
        SecP192K1Field.multiply(this.x, ((SecP192K1FieldElement)eCFieldElement).x, arrn);
        return new SecP192K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement negate() {
        int[] arrn = new int[6];
        int[] arrn2 = this.x;
        if (SecP192K1Field.isZero(arrn2) != 0) {
            int[] arrn3 = SecP192K1Field.P;
            SecT239Field.sub2(arrn3, arrn3, arrn);
        } else {
            SecT239Field.sub2(SecP192K1Field.P, arrn2, arrn);
        }
        return new SecP192K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement sqrt() {
        int[] arrn = this.x;
        if (!SecT239Field.isZero2(arrn)) {
            if (SecT239Field.isOne2(arrn)) {
                return this;
            }
            int[] arrn2 = new int[6];
            int[] arrn3 = new int[12];
            SecT239Field.square2(arrn, arrn3);
            SecP192K1Field.reduce(arrn3, arrn2);
            int[] arrn4 = new int[12];
            SecT239Field.mul2(arrn2, arrn, arrn4);
            SecP192K1Field.reduce(arrn4, arrn2);
            int[] arrn5 = new int[6];
            int[] arrn6 = new int[12];
            SecT239Field.square2(arrn2, arrn6);
            SecP192K1Field.reduce(arrn6, arrn5);
            int[] arrn7 = new int[12];
            SecT239Field.mul2(arrn5, arrn, arrn7);
            SecP192K1Field.reduce(arrn7, arrn5);
            int[] arrn8 = new int[6];
            SecP192K1Field.squareN(arrn5, 3, arrn8);
            int[] arrn9 = new int[12];
            SecT239Field.mul2(arrn8, arrn5, arrn9);
            SecP192K1Field.reduce(arrn9, arrn8);
            SecP192K1Field.squareN(arrn8, 2, arrn8);
            int[] arrn10 = new int[12];
            SecT239Field.mul2(arrn8, arrn2, arrn10);
            SecP192K1Field.reduce(arrn10, arrn8);
            SecP192K1Field.squareN(arrn8, 8, arrn2);
            int[] arrn11 = new int[12];
            SecT239Field.mul2(arrn2, arrn8, arrn11);
            SecP192K1Field.reduce(arrn11, arrn2);
            SecP192K1Field.squareN(arrn2, 3, arrn8);
            int[] arrn12 = new int[12];
            SecT239Field.mul2(arrn8, arrn5, arrn12);
            SecP192K1Field.reduce(arrn12, arrn8);
            int[] arrn13 = new int[6];
            SecP192K1Field.squareN(arrn8, 16, arrn13);
            int[] arrn14 = new int[12];
            SecT239Field.mul2(arrn13, arrn2, arrn14);
            SecP192K1Field.reduce(arrn14, arrn13);
            SecP192K1Field.squareN(arrn13, 35, arrn2);
            int[] arrn15 = new int[12];
            SecT239Field.mul2(arrn2, arrn13, arrn15);
            SecP192K1Field.reduce(arrn15, arrn2);
            SecP192K1Field.squareN(arrn2, 70, arrn13);
            int[] arrn16 = new int[12];
            SecT239Field.mul2(arrn13, arrn2, arrn16);
            SecP192K1Field.reduce(arrn16, arrn13);
            SecP192K1Field.squareN(arrn13, 19, arrn2);
            int[] arrn17 = new int[12];
            SecT239Field.mul2(arrn2, arrn8, arrn17);
            SecP192K1Field.reduce(arrn17, arrn2);
            SecP192K1Field.squareN(arrn2, 20, arrn2);
            int[] arrn18 = new int[12];
            SecT239Field.mul2(arrn2, arrn8, arrn18);
            SecP192K1Field.reduce(arrn18, arrn2);
            SecP192K1Field.squareN(arrn2, 4, arrn2);
            int[] arrn19 = new int[12];
            SecT239Field.mul2(arrn2, arrn5, arrn19);
            SecP192K1Field.reduce(arrn19, arrn2);
            SecP192K1Field.squareN(arrn2, 6, arrn2);
            int[] arrn20 = new int[12];
            SecT239Field.mul2(arrn2, arrn5, arrn20);
            SecP192K1Field.reduce(arrn20, arrn2);
            int[] arrn21 = new int[12];
            SecT239Field.square2(arrn2, arrn21);
            SecP192K1Field.reduce(arrn21, arrn2);
            int[] arrn22 = new int[12];
            SecT239Field.square2(arrn2, arrn22);
            SecP192K1Field.reduce(arrn22, arrn5);
            if (SecT239Field.eq2(arrn, arrn5)) {
                return new SecP192K1FieldElement(arrn2);
            }
            return null;
        }
        return this;
    }

    @Override
    public ECFieldElement square() {
        int[] arrn = new int[6];
        SecP192K1Field.square(this.x, arrn);
        return new SecP192K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] arrn = new int[6];
        SecP192K1Field.subtract(this.x, ((SecP192K1FieldElement)eCFieldElement).x, arrn);
        return new SecP192K1FieldElement(arrn);
    }

    @Override
    public boolean testBitZero() {
        int n2 = SecT239Field.getBit2(this.x, 0);
        boolean bl = false;
        if (n2 == 1) {
            bl = true;
        }
        return bl;
    }

    @Override
    public BigInteger toBigInteger() {
        return SecT239Field.toBigInteger2(this.x);
    }
}

