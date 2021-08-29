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
import org.bouncycastle.math.ec.custom.sec.SecP192R1Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP192R1FieldElement
extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));
    public int[] x;

    public SecP192R1FieldElement() {
        this.x = new int[6];
    }

    public SecP192R1FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(Q) < 0) {
            int[] arrn;
            int[] arrn2 = SecT239Field.fromBigInteger2(bigInteger);
            if (arrn2[5] == -1 && SecT239Field.gte2(arrn2, arrn = SecP192R1Field.P)) {
                SecT239Field.subFrom2(arrn, arrn2);
            }
            this.x = arrn2;
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
    }

    public SecP192R1FieldElement(int[] arrn) {
        this.x = arrn;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] arrn = new int[6];
        SecP192R1Field.add(this.x, ((SecP192R1FieldElement)eCFieldElement).x, arrn);
        return new SecP192R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement addOne() {
        int[] arrn = new int[6];
        if (Nat576.inc(6, this.x, arrn) != 0 || arrn[5] == -1 && SecT239Field.gte2(arrn, SecP192R1Field.P)) {
            SecP192R1Field.addPInvTo(arrn);
        }
        return new SecP192R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] arrn = new int[6];
        int[] arrn2 = ((SecP192R1FieldElement)eCFieldElement).x;
        SecT239Field.checkedModOddInverse(SecP192R1Field.P, arrn2, arrn);
        SecP192R1Field.multiply(arrn, this.x, arrn);
        return new SecP192R1FieldElement(arrn);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecP192R1FieldElement)) {
            return false;
        }
        SecP192R1FieldElement secP192R1FieldElement = (SecP192R1FieldElement)object;
        return SecT239Field.eq2(this.x, secP192R1FieldElement.x);
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
        SecT239Field.checkedModOddInverse(SecP192R1Field.P, arrn2, arrn);
        return new SecP192R1FieldElement(arrn);
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
        SecP192R1Field.multiply(this.x, ((SecP192R1FieldElement)eCFieldElement).x, arrn);
        return new SecP192R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement negate() {
        int[] arrn = new int[6];
        int[] arrn2 = this.x;
        if (SecP192R1Field.isZero(arrn2) != 0) {
            int[] arrn3 = SecP192R1Field.P;
            SecT239Field.sub2(arrn3, arrn3, arrn);
        } else {
            SecT239Field.sub2(SecP192R1Field.P, arrn2, arrn);
        }
        return new SecP192R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement sqrt() {
        int[] arrn = this.x;
        if (!SecT239Field.isZero2(arrn)) {
            if (SecT239Field.isOne2(arrn)) {
                return this;
            }
            int[] arrn2 = new int[6];
            int[] arrn3 = new int[6];
            int[] arrn4 = new int[12];
            SecT239Field.square2(arrn, arrn4);
            SecP192R1Field.reduce(arrn4, arrn2);
            int[] arrn5 = new int[12];
            SecT239Field.mul2(arrn2, arrn, arrn5);
            SecP192R1Field.reduce(arrn5, arrn2);
            SecP192R1Field.squareN(arrn2, 2, arrn3);
            int[] arrn6 = new int[12];
            SecT239Field.mul2(arrn3, arrn2, arrn6);
            SecP192R1Field.reduce(arrn6, arrn3);
            SecP192R1Field.squareN(arrn3, 4, arrn2);
            int[] arrn7 = new int[12];
            SecT239Field.mul2(arrn2, arrn3, arrn7);
            SecP192R1Field.reduce(arrn7, arrn2);
            SecP192R1Field.squareN(arrn2, 8, arrn3);
            int[] arrn8 = new int[12];
            SecT239Field.mul2(arrn3, arrn2, arrn8);
            SecP192R1Field.reduce(arrn8, arrn3);
            SecP192R1Field.squareN(arrn3, 16, arrn2);
            int[] arrn9 = new int[12];
            SecT239Field.mul2(arrn2, arrn3, arrn9);
            SecP192R1Field.reduce(arrn9, arrn2);
            SecP192R1Field.squareN(arrn2, 32, arrn3);
            int[] arrn10 = new int[12];
            SecT239Field.mul2(arrn3, arrn2, arrn10);
            SecP192R1Field.reduce(arrn10, arrn3);
            SecP192R1Field.squareN(arrn3, 64, arrn2);
            int[] arrn11 = new int[12];
            SecT239Field.mul2(arrn2, arrn3, arrn11);
            SecP192R1Field.reduce(arrn11, arrn2);
            SecP192R1Field.squareN(arrn2, 62, arrn2);
            int[] arrn12 = new int[12];
            SecT239Field.square2(arrn2, arrn12);
            SecP192R1Field.reduce(arrn12, arrn3);
            if (SecT239Field.eq2(arrn, arrn3)) {
                return new SecP192R1FieldElement(arrn2);
            }
            return null;
        }
        return this;
    }

    @Override
    public ECFieldElement square() {
        int[] arrn = new int[6];
        SecP192R1Field.square(this.x, arrn);
        return new SecP192R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] arrn = new int[6];
        SecP192R1Field.subtract(this.x, ((SecP192R1FieldElement)eCFieldElement).x, arrn);
        return new SecP192R1FieldElement(arrn);
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

