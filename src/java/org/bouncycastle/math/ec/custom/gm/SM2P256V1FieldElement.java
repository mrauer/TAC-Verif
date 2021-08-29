/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec.custom.gm;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.custom.gm.SM2P256V1Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SM2P256V1FieldElement
extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"));
    public int[] x;

    public SM2P256V1FieldElement() {
        this.x = new int[8];
    }

    public SM2P256V1FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(Q) < 0) {
            int[] arrn;
            int[] arrn2 = SecT239Field.fromBigInteger4(bigInteger);
            if (arrn2[7] >>> 1 >= Integer.MAX_VALUE && SecT239Field.gte4(arrn2, arrn = SM2P256V1Field.P)) {
                SecT239Field.subFrom4(arrn, arrn2);
            }
            this.x = arrn2;
            return;
        }
        throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
    }

    public SM2P256V1FieldElement(int[] arrn) {
        this.x = arrn;
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] arrn = new int[8];
        SM2P256V1Field.add(this.x, ((SM2P256V1FieldElement)eCFieldElement).x, arrn);
        return new SM2P256V1FieldElement(arrn);
    }

    @Override
    public ECFieldElement addOne() {
        int[] arrn = new int[8];
        if (Nat576.inc(8, this.x, arrn) != 0 || arrn[7] >>> 1 >= Integer.MAX_VALUE && SecT239Field.gte4(arrn, SM2P256V1Field.P)) {
            SM2P256V1Field.addPInvTo(arrn);
        }
        return new SM2P256V1FieldElement(arrn);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] arrn = new int[8];
        int[] arrn2 = ((SM2P256V1FieldElement)eCFieldElement).x;
        SecT239Field.checkedModOddInverse(SM2P256V1Field.P, arrn2, arrn);
        SM2P256V1Field.multiply(arrn, this.x, arrn);
        return new SM2P256V1FieldElement(arrn);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SM2P256V1FieldElement)) {
            return false;
        }
        SM2P256V1FieldElement sM2P256V1FieldElement = (SM2P256V1FieldElement)object;
        return SecT239Field.eq4(this.x, sM2P256V1FieldElement.x);
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
        SecT239Field.checkedModOddInverse(SM2P256V1Field.P, arrn2, arrn);
        return new SM2P256V1FieldElement(arrn);
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
        SM2P256V1Field.multiply(this.x, ((SM2P256V1FieldElement)eCFieldElement).x, arrn);
        return new SM2P256V1FieldElement(arrn);
    }

    @Override
    public ECFieldElement negate() {
        int[] arrn = new int[8];
        int[] arrn2 = this.x;
        if (SM2P256V1Field.isZero(arrn2) != 0) {
            int[] arrn3 = SM2P256V1Field.P;
            SecT239Field.sub4(arrn3, arrn3, arrn);
        } else {
            SecT239Field.sub4(SM2P256V1Field.P, arrn2, arrn);
        }
        return new SM2P256V1FieldElement(arrn);
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
            SM2P256V1Field.reduce(arrn3, arrn2);
            int[] arrn4 = new int[16];
            SecT239Field.mul4(arrn2, arrn, arrn4);
            SM2P256V1Field.reduce(arrn4, arrn2);
            int[] arrn5 = new int[8];
            SM2P256V1Field.squareN(arrn2, 2, arrn5);
            int[] arrn6 = new int[16];
            SecT239Field.mul4(arrn5, arrn2, arrn6);
            SM2P256V1Field.reduce(arrn6, arrn5);
            int[] arrn7 = new int[8];
            SM2P256V1Field.squareN(arrn5, 2, arrn7);
            int[] arrn8 = new int[16];
            SecT239Field.mul4(arrn7, arrn2, arrn8);
            SM2P256V1Field.reduce(arrn8, arrn7);
            SM2P256V1Field.squareN(arrn7, 6, arrn2);
            int[] arrn9 = new int[16];
            SecT239Field.mul4(arrn2, arrn7, arrn9);
            SM2P256V1Field.reduce(arrn9, arrn2);
            int[] arrn10 = new int[8];
            SM2P256V1Field.squareN(arrn2, 12, arrn10);
            int[] arrn11 = new int[16];
            SecT239Field.mul4(arrn10, arrn2, arrn11);
            SM2P256V1Field.reduce(arrn11, arrn10);
            SM2P256V1Field.squareN(arrn10, 6, arrn2);
            int[] arrn12 = new int[16];
            SecT239Field.mul4(arrn2, arrn7, arrn12);
            SM2P256V1Field.reduce(arrn12, arrn2);
            int[] arrn13 = new int[16];
            SecT239Field.square4(arrn2, arrn13);
            SM2P256V1Field.reduce(arrn13, arrn7);
            int[] arrn14 = new int[16];
            SecT239Field.mul4(arrn7, arrn, arrn14);
            SM2P256V1Field.reduce(arrn14, arrn7);
            SM2P256V1Field.squareN(arrn7, 31, arrn10);
            int[] arrn15 = new int[16];
            SecT239Field.mul4(arrn10, arrn7, arrn15);
            SM2P256V1Field.reduce(arrn15, arrn2);
            SM2P256V1Field.squareN(arrn10, 32, arrn10);
            int[] arrn16 = new int[16];
            SecT239Field.mul4(arrn10, arrn2, arrn16);
            SM2P256V1Field.reduce(arrn16, arrn10);
            SM2P256V1Field.squareN(arrn10, 62, arrn10);
            int[] arrn17 = new int[16];
            SecT239Field.mul4(arrn10, arrn2, arrn17);
            SM2P256V1Field.reduce(arrn17, arrn10);
            SM2P256V1Field.squareN(arrn10, 4, arrn10);
            int[] arrn18 = new int[16];
            SecT239Field.mul4(arrn10, arrn5, arrn18);
            SM2P256V1Field.reduce(arrn18, arrn10);
            SM2P256V1Field.squareN(arrn10, 32, arrn10);
            int[] arrn19 = new int[16];
            SecT239Field.mul4(arrn10, arrn, arrn19);
            SM2P256V1Field.reduce(arrn19, arrn10);
            SM2P256V1Field.squareN(arrn10, 62, arrn10);
            int[] arrn20 = new int[16];
            SecT239Field.square4(arrn10, arrn20);
            SM2P256V1Field.reduce(arrn20, arrn5);
            if (SecT239Field.eq4(arrn, arrn5)) {
                return new SM2P256V1FieldElement(arrn10);
            }
            return null;
        }
        return this;
    }

    @Override
    public ECFieldElement square() {
        int[] arrn = new int[8];
        SM2P256V1Field.square(this.x, arrn);
        return new SM2P256V1FieldElement(arrn);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] arrn = new int[8];
        SM2P256V1Field.subtract(this.x, ((SM2P256V1FieldElement)eCFieldElement).x, arrn);
        return new SM2P256V1FieldElement(arrn);
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

