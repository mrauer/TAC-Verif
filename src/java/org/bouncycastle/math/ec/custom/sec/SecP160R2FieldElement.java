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
import org.bouncycastle.math.ec.custom.sec.SecP160R2Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP160R2FieldElement
extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73"));
    public int[] x;

    public SecP160R2FieldElement() {
        this.x = new int[5];
    }

    public SecP160R2FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(Q) < 0) {
            int[] arrn;
            int[] arrn2 = SecT239Field.fromBigInteger1(bigInteger);
            if (arrn2[4] == -1 && SecT239Field.gte1(arrn2, arrn = SecP160R2Field.P)) {
                SecT239Field.subFrom1(arrn, arrn2);
            }
            this.x = arrn2;
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
    }

    public SecP160R2FieldElement(int[] arrn) {
        this.x = arrn;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] arrn = new int[5];
        SecP160R2Field.add(this.x, ((SecP160R2FieldElement)eCFieldElement).x, arrn);
        return new SecP160R2FieldElement(arrn);
    }

    @Override
    public ECFieldElement addOne() {
        int[] arrn = new int[5];
        if (Nat576.inc(5, this.x, arrn) != 0 || arrn[4] == -1 && SecT239Field.gte1(arrn, SecP160R2Field.P)) {
            Nat576.add33To(5, 21389, arrn);
        }
        return new SecP160R2FieldElement(arrn);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] arrn = new int[5];
        int[] arrn2 = ((SecP160R2FieldElement)eCFieldElement).x;
        SecT239Field.checkedModOddInverse(SecP160R2Field.P, arrn2, arrn);
        SecP160R2Field.multiply(arrn, this.x, arrn);
        return new SecP160R2FieldElement(arrn);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecP160R2FieldElement)) {
            return false;
        }
        SecP160R2FieldElement secP160R2FieldElement = (SecP160R2FieldElement)object;
        return SecT239Field.eq1(this.x, secP160R2FieldElement.x);
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
        SecT239Field.checkedModOddInverse(SecP160R2Field.P, arrn2, arrn);
        return new SecP160R2FieldElement(arrn);
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
        SecP160R2Field.multiply(this.x, ((SecP160R2FieldElement)eCFieldElement).x, arrn);
        return new SecP160R2FieldElement(arrn);
    }

    @Override
    public ECFieldElement negate() {
        int[] arrn = new int[5];
        SecP160R2Field.negate(this.x, arrn);
        return new SecP160R2FieldElement(arrn);
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
            SecP160R2Field.reduce(arrn3, arrn2);
            int[] arrn4 = new int[10];
            SecT239Field.mul1(arrn2, arrn, arrn4);
            SecP160R2Field.reduce(arrn4, arrn2);
            int[] arrn5 = new int[5];
            int[] arrn6 = new int[10];
            SecT239Field.square1(arrn2, arrn6);
            SecP160R2Field.reduce(arrn6, arrn5);
            int[] arrn7 = new int[10];
            SecT239Field.mul1(arrn5, arrn, arrn7);
            SecP160R2Field.reduce(arrn7, arrn5);
            int[] arrn8 = new int[5];
            int[] arrn9 = new int[10];
            SecT239Field.square1(arrn5, arrn9);
            SecP160R2Field.reduce(arrn9, arrn8);
            int[] arrn10 = new int[10];
            SecT239Field.mul1(arrn8, arrn, arrn10);
            SecP160R2Field.reduce(arrn10, arrn8);
            int[] arrn11 = new int[5];
            SecP160R2Field.squareN(arrn8, 3, arrn11);
            int[] arrn12 = new int[10];
            SecT239Field.mul1(arrn11, arrn5, arrn12);
            SecP160R2Field.reduce(arrn12, arrn11);
            SecP160R2Field.squareN(arrn11, 7, arrn8);
            int[] arrn13 = new int[10];
            SecT239Field.mul1(arrn8, arrn11, arrn13);
            SecP160R2Field.reduce(arrn13, arrn8);
            SecP160R2Field.squareN(arrn8, 3, arrn11);
            int[] arrn14 = new int[10];
            SecT239Field.mul1(arrn11, arrn5, arrn14);
            SecP160R2Field.reduce(arrn14, arrn11);
            int[] arrn15 = new int[5];
            SecP160R2Field.squareN(arrn11, 14, arrn15);
            int[] arrn16 = new int[10];
            SecT239Field.mul1(arrn15, arrn8, arrn16);
            SecP160R2Field.reduce(arrn16, arrn15);
            SecP160R2Field.squareN(arrn15, 31, arrn8);
            int[] arrn17 = new int[10];
            SecT239Field.mul1(arrn8, arrn15, arrn17);
            SecP160R2Field.reduce(arrn17, arrn8);
            SecP160R2Field.squareN(arrn8, 62, arrn15);
            int[] arrn18 = new int[10];
            SecT239Field.mul1(arrn15, arrn8, arrn18);
            SecP160R2Field.reduce(arrn18, arrn15);
            SecP160R2Field.squareN(arrn15, 3, arrn8);
            int[] arrn19 = new int[10];
            SecT239Field.mul1(arrn8, arrn5, arrn19);
            SecP160R2Field.reduce(arrn19, arrn8);
            SecP160R2Field.squareN(arrn8, 18, arrn8);
            int[] arrn20 = new int[10];
            SecT239Field.mul1(arrn8, arrn11, arrn20);
            SecP160R2Field.reduce(arrn20, arrn8);
            SecP160R2Field.squareN(arrn8, 2, arrn8);
            int[] arrn21 = new int[10];
            SecT239Field.mul1(arrn8, arrn, arrn21);
            SecP160R2Field.reduce(arrn21, arrn8);
            SecP160R2Field.squareN(arrn8, 3, arrn8);
            int[] arrn22 = new int[10];
            SecT239Field.mul1(arrn8, arrn2, arrn22);
            SecP160R2Field.reduce(arrn22, arrn8);
            SecP160R2Field.squareN(arrn8, 6, arrn8);
            int[] arrn23 = new int[10];
            SecT239Field.mul1(arrn8, arrn5, arrn23);
            SecP160R2Field.reduce(arrn23, arrn8);
            SecP160R2Field.squareN(arrn8, 2, arrn8);
            int[] arrn24 = new int[10];
            SecT239Field.mul1(arrn8, arrn, arrn24);
            SecP160R2Field.reduce(arrn24, arrn8);
            int[] arrn25 = new int[10];
            SecT239Field.square1(arrn8, arrn25);
            SecP160R2Field.reduce(arrn25, arrn2);
            if (SecT239Field.eq1(arrn, arrn2)) {
                return new SecP160R2FieldElement(arrn8);
            }
            return null;
        }
        return this;
    }

    @Override
    public ECFieldElement square() {
        int[] arrn = new int[5];
        SecP160R2Field.square(this.x, arrn);
        return new SecP160R2FieldElement(arrn);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] arrn = new int[5];
        SecP160R2Field.subtract(this.x, ((SecP160R2FieldElement)eCFieldElement).x, arrn);
        return new SecP160R2FieldElement(arrn);
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

