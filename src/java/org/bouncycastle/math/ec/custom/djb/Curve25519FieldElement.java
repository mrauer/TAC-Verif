/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec.custom.djb;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.custom.djb.Curve25519Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;

public class Curve25519FieldElement
extends ECFieldElement.AbstractFp {
    public static final int[] PRECOMP_POW2;
    public static final BigInteger Q;
    public int[] x;

    public static {
        Q = SecT239Field.toBigInteger4(Curve25519Field.P);
        PRECOMP_POW2 = new int[]{1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848};
    }

    public Curve25519FieldElement() {
        this.x = new int[8];
    }

    public Curve25519FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(Q) < 0) {
            int[] arrn;
            int[] arrn2 = SecT239Field.fromBigInteger4(bigInteger);
            while (SecT239Field.gte4(arrn2, arrn = Curve25519Field.P)) {
                SecT239Field.subFrom4(arrn, arrn2);
            }
            this.x = arrn2;
            return;
        }
        throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
    }

    public Curve25519FieldElement(int[] arrn) {
        this.x = arrn;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] arrn = new int[8];
        SecT239Field.add4(this.x, ((Curve25519FieldElement)eCFieldElement).x, arrn);
        if (SecT239Field.gte4(arrn, Curve25519Field.P)) {
            Curve25519Field.subPFrom(arrn);
        }
        return new Curve25519FieldElement(arrn);
    }

    @Override
    public ECFieldElement addOne() {
        int[] arrn = new int[8];
        Nat576.inc(8, this.x, arrn);
        if (SecT239Field.gte4(arrn, Curve25519Field.P)) {
            Curve25519Field.subPFrom(arrn);
        }
        return new Curve25519FieldElement(arrn);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] arrn = new int[8];
        int[] arrn2 = ((Curve25519FieldElement)eCFieldElement).x;
        SecT239Field.checkedModOddInverse(Curve25519Field.P, arrn2, arrn);
        Curve25519Field.multiply(arrn, this.x, arrn);
        return new Curve25519FieldElement(arrn);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Curve25519FieldElement)) {
            return false;
        }
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement)object;
        return SecT239Field.eq4(this.x, curve25519FieldElement.x);
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
        SecT239Field.checkedModOddInverse(Curve25519Field.P, arrn2, arrn);
        return new Curve25519FieldElement(arrn);
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
        Curve25519Field.multiply(this.x, ((Curve25519FieldElement)eCFieldElement).x, arrn);
        return new Curve25519FieldElement(arrn);
    }

    @Override
    public ECFieldElement negate() {
        int[] arrn = new int[8];
        int[] arrn2 = this.x;
        if (Curve25519Field.isZero(arrn2) != 0) {
            int[] arrn3 = Curve25519Field.P;
            SecT239Field.sub4(arrn3, arrn3, arrn);
        } else {
            SecT239Field.sub4(Curve25519Field.P, arrn2, arrn);
        }
        return new Curve25519FieldElement(arrn);
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
            Curve25519Field.reduce(arrn3, arrn2);
            int[] arrn4 = new int[16];
            SecT239Field.mul4(arrn2, arrn, arrn4);
            Curve25519Field.reduce(arrn4, arrn2);
            int[] arrn5 = new int[16];
            SecT239Field.square4(arrn2, arrn5);
            Curve25519Field.reduce(arrn5, arrn2);
            int[] arrn6 = new int[16];
            SecT239Field.mul4(arrn2, arrn, arrn6);
            Curve25519Field.reduce(arrn6, arrn2);
            int[] arrn7 = new int[8];
            int[] arrn8 = new int[16];
            SecT239Field.square4(arrn2, arrn8);
            Curve25519Field.reduce(arrn8, arrn7);
            int[] arrn9 = new int[16];
            SecT239Field.mul4(arrn7, arrn, arrn9);
            Curve25519Field.reduce(arrn9, arrn7);
            int[] arrn10 = new int[8];
            Curve25519Field.squareN(arrn7, 3, arrn10);
            int[] arrn11 = new int[16];
            SecT239Field.mul4(arrn10, arrn2, arrn11);
            Curve25519Field.reduce(arrn11, arrn10);
            Curve25519Field.squareN(arrn10, 4, arrn2);
            int[] arrn12 = new int[16];
            SecT239Field.mul4(arrn2, arrn7, arrn12);
            Curve25519Field.reduce(arrn12, arrn2);
            Curve25519Field.squareN(arrn2, 4, arrn10);
            int[] arrn13 = new int[16];
            SecT239Field.mul4(arrn10, arrn7, arrn13);
            Curve25519Field.reduce(arrn13, arrn10);
            Curve25519Field.squareN(arrn10, 15, arrn7);
            int[] arrn14 = new int[16];
            SecT239Field.mul4(arrn7, arrn10, arrn14);
            Curve25519Field.reduce(arrn14, arrn7);
            Curve25519Field.squareN(arrn7, 30, arrn10);
            int[] arrn15 = new int[16];
            SecT239Field.mul4(arrn10, arrn7, arrn15);
            Curve25519Field.reduce(arrn15, arrn10);
            Curve25519Field.squareN(arrn10, 60, arrn7);
            int[] arrn16 = new int[16];
            SecT239Field.mul4(arrn7, arrn10, arrn16);
            Curve25519Field.reduce(arrn16, arrn7);
            Curve25519Field.squareN(arrn7, 11, arrn10);
            int[] arrn17 = new int[16];
            SecT239Field.mul4(arrn10, arrn2, arrn17);
            Curve25519Field.reduce(arrn17, arrn10);
            Curve25519Field.squareN(arrn10, 120, arrn2);
            int[] arrn18 = new int[16];
            SecT239Field.mul4(arrn2, arrn7, arrn18);
            Curve25519Field.reduce(arrn18, arrn2);
            int[] arrn19 = new int[16];
            SecT239Field.square4(arrn2, arrn19);
            Curve25519Field.reduce(arrn19, arrn2);
            int[] arrn20 = new int[16];
            SecT239Field.square4(arrn2, arrn20);
            Curve25519Field.reduce(arrn20, arrn7);
            if (SecT239Field.eq4(arrn, arrn7)) {
                return new Curve25519FieldElement(arrn2);
            }
            Curve25519Field.multiply(arrn2, PRECOMP_POW2, arrn2);
            int[] arrn21 = new int[16];
            SecT239Field.square4(arrn2, arrn21);
            Curve25519Field.reduce(arrn21, arrn7);
            if (SecT239Field.eq4(arrn, arrn7)) {
                return new Curve25519FieldElement(arrn2);
            }
            return null;
        }
        return this;
    }

    @Override
    public ECFieldElement square() {
        int[] arrn = new int[8];
        Curve25519Field.square(this.x, arrn);
        return new Curve25519FieldElement(arrn);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] arrn = new int[8];
        Curve25519Field.subtract(this.x, ((Curve25519FieldElement)eCFieldElement).x, arrn);
        return new Curve25519FieldElement(arrn);
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

