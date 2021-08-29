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
import org.bouncycastle.math.ec.custom.sec.SecP224K1Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP224K1FieldElement
extends ECFieldElement.AbstractFp {
    public static final int[] PRECOMP_POW2;
    public static final BigInteger Q;
    public int[] x;

    public static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));
        PRECOMP_POW2 = new int[]{868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};
    }

    public SecP224K1FieldElement() {
        this.x = new int[7];
    }

    public SecP224K1FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(Q) < 0) {
            int[] arrn = SecT239Field.fromBigInteger3(bigInteger);
            if (arrn[6] == -1 && SecT239Field.gte3(arrn, SecP224K1Field.P)) {
                Nat576.add33To(7, 6803, arrn);
            }
            this.x = arrn;
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
    }

    public SecP224K1FieldElement(int[] arrn) {
        this.x = arrn;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] arrn = new int[7];
        if (SecT239Field.add3(this.x, ((SecP224K1FieldElement)eCFieldElement).x, arrn) != 0 || arrn[6] == -1 && SecT239Field.gte3(arrn, SecP224K1Field.P)) {
            Nat576.add33To(7, 6803, arrn);
        }
        return new SecP224K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement addOne() {
        int[] arrn = new int[7];
        if (Nat576.inc(7, this.x, arrn) != 0 || arrn[6] == -1 && SecT239Field.gte3(arrn, SecP224K1Field.P)) {
            Nat576.add33To(7, 6803, arrn);
        }
        return new SecP224K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] arrn = new int[7];
        int[] arrn2 = ((SecP224K1FieldElement)eCFieldElement).x;
        SecT239Field.checkedModOddInverse(SecP224K1Field.P, arrn2, arrn);
        SecP224K1Field.multiply(arrn, this.x, arrn);
        return new SecP224K1FieldElement(arrn);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecP224K1FieldElement)) {
            return false;
        }
        SecP224K1FieldElement secP224K1FieldElement = (SecP224K1FieldElement)object;
        return SecT239Field.eq3(this.x, secP224K1FieldElement.x);
    }

    @Override
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Nat576.hashCode(this.x, 0, 7);
    }

    @Override
    public ECFieldElement invert() {
        int[] arrn = new int[7];
        int[] arrn2 = this.x;
        SecT239Field.checkedModOddInverse(SecP224K1Field.P, arrn2, arrn);
        return new SecP224K1FieldElement(arrn);
    }

    @Override
    public boolean isOne() {
        return SecT239Field.isOne3(this.x);
    }

    @Override
    public boolean isZero() {
        return SecT239Field.isZero3(this.x);
    }

    @Override
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] arrn = new int[7];
        SecP224K1Field.multiply(this.x, ((SecP224K1FieldElement)eCFieldElement).x, arrn);
        return new SecP224K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement negate() {
        int[] arrn = new int[7];
        int[] arrn2 = this.x;
        if (SecP224K1Field.isZero(arrn2) != 0) {
            int[] arrn3 = SecP224K1Field.P;
            SecT239Field.sub3(arrn3, arrn3, arrn);
        } else {
            SecT239Field.sub3(SecP224K1Field.P, arrn2, arrn);
        }
        return new SecP224K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement sqrt() {
        int[] arrn = this.x;
        if (!SecT239Field.isZero3(arrn)) {
            if (SecT239Field.isOne3(arrn)) {
                return this;
            }
            int[] arrn2 = new int[7];
            int[] arrn3 = new int[14];
            SecT239Field.square3(arrn, arrn3);
            SecP224K1Field.reduce(arrn3, arrn2);
            int[] arrn4 = new int[14];
            SecT239Field.mul3(arrn2, arrn, arrn4);
            SecP224K1Field.reduce(arrn4, arrn2);
            int[] arrn5 = new int[14];
            SecT239Field.square3(arrn2, arrn5);
            SecP224K1Field.reduce(arrn5, arrn2);
            int[] arrn6 = new int[14];
            SecT239Field.mul3(arrn2, arrn, arrn6);
            SecP224K1Field.reduce(arrn6, arrn2);
            int[] arrn7 = new int[7];
            int[] arrn8 = new int[14];
            SecT239Field.square3(arrn2, arrn8);
            SecP224K1Field.reduce(arrn8, arrn7);
            int[] arrn9 = new int[14];
            SecT239Field.mul3(arrn7, arrn, arrn9);
            SecP224K1Field.reduce(arrn9, arrn7);
            int[] arrn10 = new int[7];
            SecP224K1Field.squareN(arrn7, 4, arrn10);
            int[] arrn11 = new int[14];
            SecT239Field.mul3(arrn10, arrn7, arrn11);
            SecP224K1Field.reduce(arrn11, arrn10);
            int[] arrn12 = new int[7];
            SecP224K1Field.squareN(arrn10, 3, arrn12);
            int[] arrn13 = new int[14];
            SecT239Field.mul3(arrn12, arrn2, arrn13);
            SecP224K1Field.reduce(arrn13, arrn12);
            SecP224K1Field.squareN(arrn12, 8, arrn12);
            int[] arrn14 = new int[14];
            SecT239Field.mul3(arrn12, arrn10, arrn14);
            SecP224K1Field.reduce(arrn14, arrn12);
            SecP224K1Field.squareN(arrn12, 4, arrn10);
            int[] arrn15 = new int[14];
            SecT239Field.mul3(arrn10, arrn7, arrn15);
            SecP224K1Field.reduce(arrn15, arrn10);
            SecP224K1Field.squareN(arrn10, 19, arrn7);
            int[] arrn16 = new int[14];
            SecT239Field.mul3(arrn7, arrn12, arrn16);
            SecP224K1Field.reduce(arrn16, arrn7);
            int[] arrn17 = new int[7];
            SecP224K1Field.squareN(arrn7, 42, arrn17);
            int[] arrn18 = new int[14];
            SecT239Field.mul3(arrn17, arrn7, arrn18);
            SecP224K1Field.reduce(arrn18, arrn17);
            SecP224K1Field.squareN(arrn17, 23, arrn7);
            int[] arrn19 = new int[14];
            SecT239Field.mul3(arrn7, arrn10, arrn19);
            SecP224K1Field.reduce(arrn19, arrn7);
            SecP224K1Field.squareN(arrn7, 84, arrn10);
            int[] arrn20 = new int[14];
            SecT239Field.mul3(arrn10, arrn17, arrn20);
            SecP224K1Field.reduce(arrn20, arrn10);
            SecP224K1Field.squareN(arrn10, 20, arrn10);
            int[] arrn21 = new int[14];
            SecT239Field.mul3(arrn10, arrn12, arrn21);
            SecP224K1Field.reduce(arrn21, arrn10);
            SecP224K1Field.squareN(arrn10, 3, arrn10);
            int[] arrn22 = new int[14];
            SecT239Field.mul3(arrn10, arrn, arrn22);
            SecP224K1Field.reduce(arrn22, arrn10);
            SecP224K1Field.squareN(arrn10, 2, arrn10);
            int[] arrn23 = new int[14];
            SecT239Field.mul3(arrn10, arrn, arrn23);
            SecP224K1Field.reduce(arrn23, arrn10);
            SecP224K1Field.squareN(arrn10, 4, arrn10);
            int[] arrn24 = new int[14];
            SecT239Field.mul3(arrn10, arrn2, arrn24);
            SecP224K1Field.reduce(arrn24, arrn10);
            int[] arrn25 = new int[14];
            SecT239Field.square3(arrn10, arrn25);
            SecP224K1Field.reduce(arrn25, arrn10);
            int[] arrn26 = new int[14];
            SecT239Field.square3(arrn10, arrn26);
            SecP224K1Field.reduce(arrn26, arrn17);
            if (SecT239Field.eq3(arrn, arrn17)) {
                return new SecP224K1FieldElement(arrn10);
            }
            SecP224K1Field.multiply(arrn10, PRECOMP_POW2, arrn10);
            int[] arrn27 = new int[14];
            SecT239Field.square3(arrn10, arrn27);
            SecP224K1Field.reduce(arrn27, arrn17);
            if (SecT239Field.eq3(arrn, arrn17)) {
                return new SecP224K1FieldElement(arrn10);
            }
            return null;
        }
        return this;
    }

    @Override
    public ECFieldElement square() {
        int[] arrn = new int[7];
        SecP224K1Field.square(this.x, arrn);
        return new SecP224K1FieldElement(arrn);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] arrn = new int[7];
        SecP224K1Field.subtract(this.x, ((SecP224K1FieldElement)eCFieldElement).x, arrn);
        return new SecP224K1FieldElement(arrn);
    }

    @Override
    public boolean testBitZero() {
        int n2 = SecT239Field.getBit3(this.x, 0);
        boolean bl = false;
        if (n2 == 1) {
            bl = true;
        }
        return bl;
    }

    @Override
    public BigInteger toBigInteger() {
        return SecT239Field.toBigInteger3(this.x);
    }
}

