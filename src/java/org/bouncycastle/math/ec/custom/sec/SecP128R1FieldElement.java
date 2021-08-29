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
import org.bouncycastle.math.ec.custom.sec.SecP128R1Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP128R1FieldElement
extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));
    public int[] x;

    public SecP128R1FieldElement() {
        this.x = new int[4];
    }

    public SecP128R1FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(Q) < 0) {
            if (bigInteger.signum() >= 0 && bigInteger.bitLength() <= 128) {
                int[] arrn;
                int[] arrn2 = new int[4];
                for (int i2 = 0; i2 < 4; ++i2) {
                    arrn2[i2] = bigInteger.intValue();
                    bigInteger = bigInteger.shiftRight(32);
                }
                if (arrn2[3] >>> 1 >= 2147483646 && SecT239Field.gte(arrn2, arrn = SecP128R1Field.P)) {
                    long l2 = 0L + ((0xFFFFFFFFL & (long)arrn2[0]) - (0xFFFFFFFFL & (long)arrn[0]));
                    arrn2[0] = (int)l2;
                    long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn2[1]) - (0xFFFFFFFFL & (long)arrn[1]));
                    arrn2[1] = (int)l3;
                    long l4 = (l3 >> 32) + ((0xFFFFFFFFL & (long)arrn2[2]) - (0xFFFFFFFFL & (long)arrn[2]));
                    arrn2[2] = (int)l4;
                    arrn2[3] = (int)((l4 >> 32) + ((0xFFFFFFFFL & (long)arrn2[3]) - (0xFFFFFFFFL & (long)arrn[3])));
                }
                this.x = arrn2;
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
    }

    public SecP128R1FieldElement(int[] arrn) {
        this.x = arrn;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] arrn = new int[4];
        SecP128R1Field.add(this.x, ((SecP128R1FieldElement)eCFieldElement).x, arrn);
        return new SecP128R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement addOne() {
        int[] arrn = new int[4];
        if (Nat576.inc(4, this.x, arrn) != 0 || arrn[3] >>> 1 >= 2147483646 && SecT239Field.gte(arrn, SecP128R1Field.P)) {
            SecP128R1Field.addPInvTo(arrn);
        }
        return new SecP128R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] arrn = new int[4];
        int[] arrn2 = ((SecP128R1FieldElement)eCFieldElement).x;
        SecT239Field.checkedModOddInverse(SecP128R1Field.P, arrn2, arrn);
        SecP128R1Field.multiply(arrn, this.x, arrn);
        return new SecP128R1FieldElement(arrn);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecP128R1FieldElement)) {
            return false;
        }
        SecP128R1FieldElement secP128R1FieldElement = (SecP128R1FieldElement)object;
        return SecT239Field.eq(this.x, secP128R1FieldElement.x);
    }

    @Override
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Nat576.hashCode(this.x, 0, 4);
    }

    @Override
    public ECFieldElement invert() {
        int[] arrn = new int[4];
        int[] arrn2 = this.x;
        SecT239Field.checkedModOddInverse(SecP128R1Field.P, arrn2, arrn);
        return new SecP128R1FieldElement(arrn);
    }

    @Override
    public boolean isOne() {
        return SecT239Field.isOne(this.x);
    }

    @Override
    public boolean isZero() {
        return SecT239Field.isZero(this.x);
    }

    @Override
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] arrn = new int[4];
        SecP128R1Field.multiply(this.x, ((SecP128R1FieldElement)eCFieldElement).x, arrn);
        return new SecP128R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement negate() {
        int[] arrn = new int[4];
        int[] arrn2 = this.x;
        if (SecP128R1Field.isZero(arrn2) != 0) {
            int[] arrn3 = SecP128R1Field.P;
            SecT239Field.sub(arrn3, arrn3, arrn);
        } else {
            SecT239Field.sub(SecP128R1Field.P, arrn2, arrn);
        }
        return new SecP128R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement sqrt() {
        int[] arrn = this.x;
        if (!SecT239Field.isZero(arrn)) {
            if (SecT239Field.isOne(arrn)) {
                return this;
            }
            int[] arrn2 = new int[4];
            int[] arrn3 = new int[8];
            SecT239Field.square(arrn, arrn3);
            SecP128R1Field.reduce(arrn3, arrn2);
            int[] arrn4 = new int[8];
            SecT239Field.mul(arrn2, arrn, arrn4);
            SecP128R1Field.reduce(arrn4, arrn2);
            int[] arrn5 = new int[4];
            SecP128R1Field.squareN(arrn2, 2, arrn5);
            int[] arrn6 = new int[8];
            SecT239Field.mul(arrn5, arrn2, arrn6);
            SecP128R1Field.reduce(arrn6, arrn5);
            int[] arrn7 = new int[4];
            SecP128R1Field.squareN(arrn5, 4, arrn7);
            int[] arrn8 = new int[8];
            SecT239Field.mul(arrn7, arrn5, arrn8);
            SecP128R1Field.reduce(arrn8, arrn7);
            SecP128R1Field.squareN(arrn7, 2, arrn5);
            int[] arrn9 = new int[8];
            SecT239Field.mul(arrn5, arrn2, arrn9);
            SecP128R1Field.reduce(arrn9, arrn5);
            SecP128R1Field.squareN(arrn5, 10, arrn2);
            int[] arrn10 = new int[8];
            SecT239Field.mul(arrn2, arrn5, arrn10);
            SecP128R1Field.reduce(arrn10, arrn2);
            SecP128R1Field.squareN(arrn2, 10, arrn7);
            int[] arrn11 = new int[8];
            SecT239Field.mul(arrn7, arrn5, arrn11);
            SecP128R1Field.reduce(arrn11, arrn7);
            int[] arrn12 = new int[8];
            SecT239Field.square(arrn7, arrn12);
            SecP128R1Field.reduce(arrn12, arrn5);
            int[] arrn13 = new int[8];
            SecT239Field.mul(arrn5, arrn, arrn13);
            SecP128R1Field.reduce(arrn13, arrn5);
            SecP128R1Field.squareN(arrn5, 95, arrn5);
            int[] arrn14 = new int[8];
            SecT239Field.square(arrn5, arrn14);
            SecP128R1Field.reduce(arrn14, arrn7);
            if (SecT239Field.eq(arrn, arrn7)) {
                return new SecP128R1FieldElement(arrn5);
            }
            return null;
        }
        return this;
    }

    @Override
    public ECFieldElement square() {
        int[] arrn = new int[4];
        SecP128R1Field.square(this.x, arrn);
        return new SecP128R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] arrn = new int[4];
        SecP128R1Field.subtract(this.x, ((SecP128R1FieldElement)eCFieldElement).x, arrn);
        return new SecP128R1FieldElement(arrn);
    }

    @Override
    public boolean testBitZero() {
        int n2 = 1 & this.x[0];
        boolean bl = false;
        if (n2 == 1) {
            bl = true;
        }
        return bl;
    }

    @Override
    public BigInteger toBigInteger() {
        int[] arrn = this.x;
        byte[] arrby = new byte[16];
        for (int i2 = 0; i2 < 4; ++i2) {
            int n2 = arrn[i2];
            if (n2 == 0) continue;
            Nat576.intToBigEndian(n2, arrby, 3 - i2 << 2);
        }
        return new BigInteger(1, arrby);
    }
}

