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
import org.bouncycastle.math.ec.custom.sec.SecP521R1Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP521R1FieldElement
extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));
    public int[] x;

    public SecP521R1FieldElement() {
        this.x = new int[17];
    }

    public SecP521R1FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(Q) < 0) {
            int[] arrn = Nat576.fromBigInteger(521, bigInteger);
            if (Nat576.eq(17, arrn, SecP521R1Field.P)) {
                for (int i2 = 0; i2 < 17; ++i2) {
                    arrn[i2] = 0;
                }
            }
            this.x = arrn;
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
    }

    public SecP521R1FieldElement(int[] arrn) {
        this.x = arrn;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] arrn = new int[17];
        SecP521R1Field.add(this.x, ((SecP521R1FieldElement)eCFieldElement).x, arrn);
        return new SecP521R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement addOne() {
        int[] arrn = this.x;
        int[] arrn2 = new int[17];
        int n2 = Nat576.inc(16, arrn, arrn2) + arrn[16];
        if (n2 > 511 || n2 == 511 && Nat576.eq(16, arrn2, SecP521R1Field.P)) {
            n2 = 511 & n2 + Nat576.inc(16, arrn2);
        }
        arrn2[16] = n2;
        return new SecP521R1FieldElement(arrn2);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] arrn = new int[17];
        int[] arrn2 = ((SecP521R1FieldElement)eCFieldElement).x;
        SecT239Field.checkedModOddInverse(SecP521R1Field.P, arrn2, arrn);
        SecP521R1Field.multiply(arrn, this.x, arrn);
        return new SecP521R1FieldElement(arrn);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecP521R1FieldElement)) {
            return false;
        }
        SecP521R1FieldElement secP521R1FieldElement = (SecP521R1FieldElement)object;
        return Nat576.eq(17, this.x, secP521R1FieldElement.x);
    }

    @Override
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Nat576.hashCode(this.x, 0, 17);
    }

    @Override
    public ECFieldElement invert() {
        int[] arrn = new int[17];
        int[] arrn2 = this.x;
        SecT239Field.checkedModOddInverse(SecP521R1Field.P, arrn2, arrn);
        return new SecP521R1FieldElement(arrn);
    }

    @Override
    public boolean isOne() {
        return Nat576.isOne(17, this.x);
    }

    @Override
    public boolean isZero() {
        return Nat576.isZero(17, this.x);
    }

    @Override
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] arrn = new int[17];
        SecP521R1Field.multiply(this.x, ((SecP521R1FieldElement)eCFieldElement).x, arrn);
        return new SecP521R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement negate() {
        int[] arrn = new int[17];
        int[] arrn2 = this.x;
        if (SecP521R1Field.isZero(arrn2) != 0) {
            int[] arrn3 = SecP521R1Field.P;
            Nat576.sub(17, arrn3, arrn3, arrn);
        } else {
            Nat576.sub(17, SecP521R1Field.P, arrn2, arrn);
        }
        return new SecP521R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement sqrt() {
        int[] arrn = this.x;
        if (!Nat576.isZero(17, arrn)) {
            if (Nat576.isOne(17, arrn)) {
                return this;
            }
            int[] arrn2 = new int[17];
            int[] arrn3 = new int[17];
            int n2 = 519;
            int[] arrn4 = new int[33];
            SecP521R1Field.implSquare(arrn, arrn4);
            do {
                SecP521R1Field.reduce(arrn4, arrn2);
                if (--n2 <= 0) break;
                SecP521R1Field.implSquare(arrn2, arrn4);
            } while (true);
            int[] arrn5 = new int[33];
            SecP521R1Field.implSquare(arrn2, arrn5);
            SecP521R1Field.reduce(arrn5, arrn3);
            if (Nat576.eq(17, arrn, arrn3)) {
                return new SecP521R1FieldElement(arrn2);
            }
            return null;
        }
        return this;
    }

    @Override
    public ECFieldElement square() {
        int[] arrn = new int[17];
        SecP521R1Field.square(this.x, arrn);
        return new SecP521R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] arrn = new int[17];
        SecP521R1Field.subtract(this.x, ((SecP521R1FieldElement)eCFieldElement).x, arrn);
        return new SecP521R1FieldElement(arrn);
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
        return Nat576.toBigInteger(17, this.x);
    }
}

