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
import org.bouncycastle.math.ec.custom.sec.SecP256R1Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP256R1FieldElement
extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));
    public int[] x;

    public SecP256R1FieldElement() {
        this.x = new int[8];
    }

    public SecP256R1FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(Q) < 0) {
            int[] arrn;
            int[] arrn2 = SecT239Field.fromBigInteger4(bigInteger);
            if (arrn2[7] == -1 && SecT239Field.gte4(arrn2, arrn = SecP256R1Field.P)) {
                SecT239Field.subFrom4(arrn, arrn2);
            }
            this.x = arrn2;
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
    }

    public SecP256R1FieldElement(int[] arrn) {
        this.x = arrn;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] arrn = new int[8];
        SecP256R1Field.add(this.x, ((SecP256R1FieldElement)eCFieldElement).x, arrn);
        return new SecP256R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement addOne() {
        int[] arrn = new int[8];
        if (Nat576.inc(8, this.x, arrn) != 0 || arrn[7] == -1 && SecT239Field.gte4(arrn, SecP256R1Field.P)) {
            SecP256R1Field.addPInvTo(arrn);
        }
        return new SecP256R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] arrn = new int[8];
        int[] arrn2 = ((SecP256R1FieldElement)eCFieldElement).x;
        SecT239Field.checkedModOddInverse(SecP256R1Field.P, arrn2, arrn);
        SecP256R1Field.multiply(arrn, this.x, arrn);
        return new SecP256R1FieldElement(arrn);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecP256R1FieldElement)) {
            return false;
        }
        SecP256R1FieldElement secP256R1FieldElement = (SecP256R1FieldElement)object;
        return SecT239Field.eq4(this.x, secP256R1FieldElement.x);
    }

    @Override
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Nat576.hashCode(this.x, 0, 8);
    }

    @Override
    public ECFieldElement invert() {
        int[] arrn = new int[8];
        int[] arrn2 = this.x;
        SecT239Field.checkedModOddInverse(SecP256R1Field.P, arrn2, arrn);
        return new SecP256R1FieldElement(arrn);
    }

    @Override
    public boolean isOne() {
        return SecT239Field.isOne4(this.x);
    }

    @Override
    public boolean isZero() {
        return SecT239Field.isZero4(this.x);
    }

    @Override
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] arrn = new int[8];
        SecP256R1Field.multiply(this.x, ((SecP256R1FieldElement)eCFieldElement).x, arrn);
        return new SecP256R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement negate() {
        int[] arrn = new int[8];
        int[] arrn2 = this.x;
        if (SecP256R1Field.isZero(arrn2) != 0) {
            int[] arrn3 = SecP256R1Field.P;
            SecT239Field.sub4(arrn3, arrn3, arrn);
        } else {
            SecT239Field.sub4(SecP256R1Field.P, arrn2, arrn);
        }
        return new SecP256R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement sqrt() {
        int[] arrn = this.x;
        if (!SecT239Field.isZero4(arrn)) {
            if (SecT239Field.isOne4(arrn)) {
                return this;
            }
            int[] arrn2 = new int[8];
            int[] arrn3 = new int[8];
            int[] arrn4 = new int[16];
            SecT239Field.square4(arrn, arrn4);
            SecP256R1Field.reduce(arrn4, arrn2);
            int[] arrn5 = new int[16];
            SecT239Field.mul4(arrn2, arrn, arrn5);
            SecP256R1Field.reduce(arrn5, arrn2);
            SecP256R1Field.squareN(arrn2, 2, arrn3);
            int[] arrn6 = new int[16];
            SecT239Field.mul4(arrn3, arrn2, arrn6);
            SecP256R1Field.reduce(arrn6, arrn3);
            SecP256R1Field.squareN(arrn3, 4, arrn2);
            int[] arrn7 = new int[16];
            SecT239Field.mul4(arrn2, arrn3, arrn7);
            SecP256R1Field.reduce(arrn7, arrn2);
            SecP256R1Field.squareN(arrn2, 8, arrn3);
            int[] arrn8 = new int[16];
            SecT239Field.mul4(arrn3, arrn2, arrn8);
            SecP256R1Field.reduce(arrn8, arrn3);
            SecP256R1Field.squareN(arrn3, 16, arrn2);
            int[] arrn9 = new int[16];
            SecT239Field.mul4(arrn2, arrn3, arrn9);
            SecP256R1Field.reduce(arrn9, arrn2);
            SecP256R1Field.squareN(arrn2, 32, arrn2);
            int[] arrn10 = new int[16];
            SecT239Field.mul4(arrn2, arrn, arrn10);
            SecP256R1Field.reduce(arrn10, arrn2);
            SecP256R1Field.squareN(arrn2, 96, arrn2);
            int[] arrn11 = new int[16];
            SecT239Field.mul4(arrn2, arrn, arrn11);
            SecP256R1Field.reduce(arrn11, arrn2);
            SecP256R1Field.squareN(arrn2, 94, arrn2);
            int[] arrn12 = new int[16];
            SecT239Field.square4(arrn2, arrn12);
            SecP256R1Field.reduce(arrn12, arrn3);
            if (SecT239Field.eq4(arrn, arrn3)) {
                return new SecP256R1FieldElement(arrn2);
            }
            return null;
        }
        return this;
    }

    @Override
    public ECFieldElement square() {
        int[] arrn = new int[8];
        SecP256R1Field.square(this.x, arrn);
        return new SecP256R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] arrn = new int[8];
        SecP256R1Field.subtract(this.x, ((SecP256R1FieldElement)eCFieldElement).x, arrn);
        return new SecP256R1FieldElement(arrn);
    }

    @Override
    public boolean testBitZero() {
        int n2 = SecT239Field.getBit4(this.x, 0);
        boolean bl = false;
        if (n2 == 1) {
            bl = true;
        }
        return bl;
    }

    @Override
    public BigInteger toBigInteger() {
        return SecT239Field.toBigInteger4(this.x);
    }
}

