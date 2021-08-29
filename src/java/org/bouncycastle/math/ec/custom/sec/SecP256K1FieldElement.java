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
import org.bouncycastle.math.ec.custom.sec.SecP256K1Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP256K1FieldElement
extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));
    public int[] x;

    public SecP256K1FieldElement() {
        this.x = new int[8];
    }

    public SecP256K1FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(Q) < 0) {
            int[] arrn;
            int[] arrn2 = SecT239Field.fromBigInteger4(bigInteger);
            if (arrn2[7] == -1 && SecT239Field.gte4(arrn2, arrn = SecP256K1Field.P)) {
                SecT239Field.subFrom4(arrn, arrn2);
            }
            this.x = arrn2;
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
    }

    public SecP256K1FieldElement(int[] arrn) {
        this.x = arrn;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] arrn = new int[8];
        if (SecT239Field.add4(this.x, ((SecP256K1FieldElement)eCFieldElement).x, arrn) != 0 || arrn[7] == -1 && SecT239Field.gte4(arrn, SecP256K1Field.P)) {
            Nat576.add33To(8, 977, arrn);
        }
        return new SecP256K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement addOne() {
        int[] arrn = new int[8];
        if (Nat576.inc(8, this.x, arrn) != 0 || arrn[7] == -1 && SecT239Field.gte4(arrn, SecP256K1Field.P)) {
            Nat576.add33To(8, 977, arrn);
        }
        return new SecP256K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] arrn = new int[8];
        int[] arrn2 = ((SecP256K1FieldElement)eCFieldElement).x;
        SecT239Field.checkedModOddInverse(SecP256K1Field.P, arrn2, arrn);
        SecP256K1Field.multiply(arrn, this.x, arrn);
        return new SecP256K1FieldElement(arrn);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecP256K1FieldElement)) {
            return false;
        }
        SecP256K1FieldElement secP256K1FieldElement = (SecP256K1FieldElement)object;
        return SecT239Field.eq4(this.x, secP256K1FieldElement.x);
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
        SecT239Field.checkedModOddInverse(SecP256K1Field.P, arrn2, arrn);
        return new SecP256K1FieldElement(arrn);
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
        SecP256K1Field.multiply(this.x, ((SecP256K1FieldElement)eCFieldElement).x, arrn);
        return new SecP256K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement negate() {
        int[] arrn = new int[8];
        int[] arrn2 = this.x;
        if (SecP256K1Field.isZero(arrn2) != 0) {
            int[] arrn3 = SecP256K1Field.P;
            SecT239Field.sub4(arrn3, arrn3, arrn);
        } else {
            SecT239Field.sub4(SecP256K1Field.P, arrn2, arrn);
        }
        return new SecP256K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement sqrt() {
        int[] arrn = this.x;
        if (!SecT239Field.isZero4(arrn)) {
            if (SecT239Field.isOne4(arrn)) {
                return this;
            }
            int[] arrn2 = new int[8];
            int[] arrn3 = new int[16];
            SecT239Field.square4(arrn, arrn3);
            SecP256K1Field.reduce(arrn3, arrn2);
            int[] arrn4 = new int[16];
            SecT239Field.mul4(arrn2, arrn, arrn4);
            SecP256K1Field.reduce(arrn4, arrn2);
            int[] arrn5 = new int[8];
            int[] arrn6 = new int[16];
            SecT239Field.square4(arrn2, arrn6);
            SecP256K1Field.reduce(arrn6, arrn5);
            int[] arrn7 = new int[16];
            SecT239Field.mul4(arrn5, arrn, arrn7);
            SecP256K1Field.reduce(arrn7, arrn5);
            int[] arrn8 = new int[8];
            SecP256K1Field.squareN(arrn5, 3, arrn8);
            int[] arrn9 = new int[16];
            SecT239Field.mul4(arrn8, arrn5, arrn9);
            SecP256K1Field.reduce(arrn9, arrn8);
            SecP256K1Field.squareN(arrn8, 3, arrn8);
            int[] arrn10 = new int[16];
            SecT239Field.mul4(arrn8, arrn5, arrn10);
            SecP256K1Field.reduce(arrn10, arrn8);
            SecP256K1Field.squareN(arrn8, 2, arrn8);
            int[] arrn11 = new int[16];
            SecT239Field.mul4(arrn8, arrn2, arrn11);
            SecP256K1Field.reduce(arrn11, arrn8);
            int[] arrn12 = new int[8];
            SecP256K1Field.squareN(arrn8, 11, arrn12);
            int[] arrn13 = new int[16];
            SecT239Field.mul4(arrn12, arrn8, arrn13);
            SecP256K1Field.reduce(arrn13, arrn12);
            SecP256K1Field.squareN(arrn12, 22, arrn8);
            int[] arrn14 = new int[16];
            SecT239Field.mul4(arrn8, arrn12, arrn14);
            SecP256K1Field.reduce(arrn14, arrn8);
            int[] arrn15 = new int[8];
            SecP256K1Field.squareN(arrn8, 44, arrn15);
            int[] arrn16 = new int[16];
            SecT239Field.mul4(arrn15, arrn8, arrn16);
            SecP256K1Field.reduce(arrn16, arrn15);
            int[] arrn17 = new int[8];
            SecP256K1Field.squareN(arrn15, 88, arrn17);
            int[] arrn18 = new int[16];
            SecT239Field.mul4(arrn17, arrn15, arrn18);
            SecP256K1Field.reduce(arrn18, arrn17);
            SecP256K1Field.squareN(arrn17, 44, arrn15);
            int[] arrn19 = new int[16];
            SecT239Field.mul4(arrn15, arrn8, arrn19);
            SecP256K1Field.reduce(arrn19, arrn15);
            SecP256K1Field.squareN(arrn15, 3, arrn8);
            int[] arrn20 = new int[16];
            SecT239Field.mul4(arrn8, arrn5, arrn20);
            SecP256K1Field.reduce(arrn20, arrn8);
            SecP256K1Field.squareN(arrn8, 23, arrn8);
            int[] arrn21 = new int[16];
            SecT239Field.mul4(arrn8, arrn12, arrn21);
            SecP256K1Field.reduce(arrn21, arrn8);
            SecP256K1Field.squareN(arrn8, 6, arrn8);
            int[] arrn22 = new int[16];
            SecT239Field.mul4(arrn8, arrn2, arrn22);
            SecP256K1Field.reduce(arrn22, arrn8);
            SecP256K1Field.squareN(arrn8, 2, arrn8);
            int[] arrn23 = new int[16];
            SecT239Field.square4(arrn8, arrn23);
            SecP256K1Field.reduce(arrn23, arrn2);
            if (SecT239Field.eq4(arrn, arrn2)) {
                return new SecP256K1FieldElement(arrn8);
            }
            return null;
        }
        return this;
    }

    @Override
    public ECFieldElement square() {
        int[] arrn = new int[8];
        SecP256K1Field.square(this.x, arrn);
        return new SecP256K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] arrn = new int[8];
        SecP256K1Field.subtract(this.x, ((SecP256K1FieldElement)eCFieldElement).x, arrn);
        return new SecP256K1FieldElement(arrn);
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

