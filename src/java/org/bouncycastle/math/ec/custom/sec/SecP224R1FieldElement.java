/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.Random
 */
package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.custom.sec.SecP224R1Field;
import org.bouncycastle.math.ec.custom.sec.SecT239Field;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecP224R1FieldElement
extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));
    public int[] x;

    public SecP224R1FieldElement() {
        this.x = new int[7];
    }

    public SecP224R1FieldElement(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(Q) < 0) {
            int[] arrn;
            int[] arrn2 = SecT239Field.fromBigInteger3(bigInteger);
            if (arrn2[6] == -1 && SecT239Field.gte3(arrn2, arrn = SecP224R1Field.P)) {
                long l2 = 0L + ((0xFFFFFFFFL & (long)arrn2[0]) - (0xFFFFFFFFL & (long)arrn[0]));
                arrn2[0] = (int)l2;
                long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn2[1]) - (0xFFFFFFFFL & (long)arrn[1]));
                arrn2[1] = (int)l3;
                long l4 = (l3 >> 32) + ((0xFFFFFFFFL & (long)arrn2[2]) - (0xFFFFFFFFL & (long)arrn[2]));
                arrn2[2] = (int)l4;
                long l5 = (l4 >> 32) + ((0xFFFFFFFFL & (long)arrn2[3]) - (0xFFFFFFFFL & (long)arrn[3]));
                arrn2[3] = (int)l5;
                long l6 = (l5 >> 32) + ((0xFFFFFFFFL & (long)arrn2[4]) - (0xFFFFFFFFL & (long)arrn[4]));
                arrn2[4] = (int)l6;
                long l7 = (l6 >> 32) + ((0xFFFFFFFFL & (long)arrn2[5]) - (0xFFFFFFFFL & (long)arrn[5]));
                arrn2[5] = (int)l7;
                arrn2[6] = (int)((l7 >> 32) + ((0xFFFFFFFFL & (long)arrn2[6]) - (0xFFFFFFFFL & (long)arrn[6])));
            }
            this.x = arrn2;
            return;
        }
        throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
    }

    public SecP224R1FieldElement(int[] arrn) {
        this.x = arrn;
    }

    public static void RS(int[] arrn, int[] arrn2, int[] arrn3, int[] arrn4) {
        int[] arrn5 = new int[14];
        SecT239Field.mul3(arrn2, arrn, arrn5);
        SecP224R1Field.reduce(arrn5, arrn2);
        SecP224R1Field.twice(arrn2, arrn2);
        int[] arrn6 = new int[14];
        SecT239Field.square3(arrn, arrn6);
        SecP224R1Field.reduce(arrn6, arrn4);
        SecP224R1Field.add(arrn3, arrn4, arrn);
        int[] arrn7 = new int[14];
        SecT239Field.mul3(arrn3, arrn4, arrn7);
        SecP224R1Field.reduce(arrn7, arrn3);
        SecP224R1Field.reduce32(Nat576.shiftUpBits(7, arrn3, 2, 0), arrn3);
    }

    @Override
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] arrn = new int[7];
        SecP224R1Field.add(this.x, ((SecP224R1FieldElement)eCFieldElement).x, arrn);
        return new SecP224R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement addOne() {
        int[] arrn = new int[7];
        SecP224R1Field.addOne(this.x, arrn);
        return new SecP224R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] arrn = new int[7];
        int[] arrn2 = ((SecP224R1FieldElement)eCFieldElement).x;
        SecT239Field.checkedModOddInverse(SecP224R1Field.P, arrn2, arrn);
        SecP224R1Field.multiply(arrn, this.x, arrn);
        return new SecP224R1FieldElement(arrn);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SecP224R1FieldElement)) {
            return false;
        }
        SecP224R1FieldElement secP224R1FieldElement = (SecP224R1FieldElement)object;
        return SecT239Field.eq3(this.x, secP224R1FieldElement.x);
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
        SecT239Field.checkedModOddInverse(SecP224R1Field.P, arrn2, arrn);
        return new SecP224R1FieldElement(arrn);
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
        SecP224R1Field.multiply(this.x, ((SecP224R1FieldElement)eCFieldElement).x, arrn);
        return new SecP224R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement negate() {
        int[] arrn = new int[7];
        SecP224R1Field.negate(this.x, arrn);
        return new SecP224R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement sqrt() {
        int[] arrn = this.x;
        if (!SecT239Field.isZero3(arrn)) {
            if (SecT239Field.isOne3(arrn)) {
                return this;
            }
            int[] arrn2 = new int[7];
            SecP224R1Field.negate(arrn, arrn2);
            int[] arrn3 = SecP224R1Field.P;
            int n2 = arrn3.length;
            Random random = new Random();
            int[] arrn4 = new int[n2];
            int n3 = n2 - 1;
            int n4 = arrn3[n3];
            int n5 = n4 | n4 >>> 1;
            int n6 = n5 | n5 >>> 2;
            int n7 = n6 | n6 >>> 4;
            int n8 = n7 | n7 >>> 8;
            int n9 = n8 | n8 >>> 16;
            do {
                for (int i2 = 0; i2 != n2; ++i2) {
                    arrn4[i2] = random.nextInt();
                }
                arrn4[n3] = n9 & arrn4[n3];
            } while (Nat576.gte(n2, arrn4, arrn3));
            int[] arrn5 = new int[7];
            int[] arrn6 = new int[7];
            int[] arrn7 = new int[7];
            SecT239Field.copy(arrn, arrn6);
            for (int i3 = 0; i3 < 7; ++i3) {
                SecT239Field.copy(arrn6, arrn7);
                int n10 = 1 << i3;
                int[] arrn8 = new int[14];
                do {
                    SecT239Field.square3(arrn6, arrn8);
                    SecP224R1Field.reduce(arrn8, arrn6);
                } while (--n10 > 0);
                int[] arrn9 = new int[14];
                SecT239Field.mul3(arrn6, arrn7, arrn9);
                SecP224R1Field.reduce(arrn9, arrn6);
            }
            int n11 = 95;
            int[] arrn10 = new int[14];
            do {
                SecT239Field.square3(arrn6, arrn10);
                SecP224R1Field.reduce(arrn10, arrn6);
            } while (--n11 > 0);
            if (!SecT239Field.isOne3(arrn6)) {
                return null;
            }
            do {
                boolean bl;
                block13 : {
                    int[] arrn11 = new int[7];
                    SecT239Field.copy(arrn4, arrn11);
                    int[] arrn12 = new int[7];
                    arrn12[0] = 1;
                    int[] arrn13 = new int[7];
                    SecT239Field.copy(arrn2, arrn13);
                    int[] arrn14 = new int[7];
                    int[] arrn15 = new int[7];
                    for (int i4 = 0; i4 < 7; ++i4) {
                        SecT239Field.copy(arrn11, arrn14);
                        SecT239Field.copy(arrn12, arrn15);
                        int n12 = 1 << i4;
                        while (--n12 >= 0) {
                            SecP224R1FieldElement.RS(arrn11, arrn12, arrn13, arrn5);
                        }
                        int[] arrn16 = new int[14];
                        SecT239Field.mul3(arrn12, arrn15, arrn16);
                        SecP224R1Field.reduce(arrn16, arrn5);
                        int[] arrn17 = new int[14];
                        SecT239Field.mul3(arrn5, arrn2, arrn17);
                        SecP224R1Field.reduce(arrn17, arrn5);
                        int[] arrn18 = new int[14];
                        SecT239Field.mul3(arrn11, arrn14, arrn18);
                        SecP224R1Field.reduce(arrn18, arrn13);
                        SecP224R1Field.add(arrn13, arrn5, arrn13);
                        int[] arrn19 = new int[14];
                        SecT239Field.mul3(arrn11, arrn15, arrn19);
                        SecP224R1Field.reduce(arrn19, arrn5);
                        SecT239Field.copy(arrn13, arrn11);
                        int[] arrn20 = new int[14];
                        SecT239Field.mul3(arrn12, arrn14, arrn20);
                        SecP224R1Field.reduce(arrn20, arrn12);
                        SecP224R1Field.add(arrn12, arrn5, arrn12);
                        int[] arrn21 = new int[14];
                        SecT239Field.square3(arrn12, arrn21);
                        SecP224R1Field.reduce(arrn21, arrn13);
                        int[] arrn22 = new int[14];
                        SecT239Field.mul3(arrn13, arrn2, arrn22);
                        SecP224R1Field.reduce(arrn22, arrn13);
                    }
                    int[] arrn23 = new int[7];
                    int[] arrn24 = new int[7];
                    for (int i5 = 1; i5 < 96; ++i5) {
                        SecT239Field.copy(arrn11, arrn23);
                        SecT239Field.copy(arrn12, arrn24);
                        SecP224R1FieldElement.RS(arrn11, arrn12, arrn13, arrn5);
                        if (!SecT239Field.isZero3(arrn11)) continue;
                        SecT239Field.checkedModOddInverse(SecP224R1Field.P, arrn24, arrn5);
                        int[] arrn25 = new int[14];
                        SecT239Field.mul3(arrn5, arrn23, arrn25);
                        SecP224R1Field.reduce(arrn25, arrn5);
                        bl = true;
                        break block13;
                    }
                    bl = false;
                }
                if (bl) break;
                SecP224R1Field.addOne(arrn4, arrn4);
            } while (true);
            int[] arrn26 = new int[14];
            SecT239Field.square3(arrn5, arrn26);
            SecP224R1Field.reduce(arrn26, arrn4);
            if (SecT239Field.eq3(arrn, arrn4)) {
                return new SecP224R1FieldElement(arrn5);
            }
            return null;
        }
        return this;
    }

    @Override
    public ECFieldElement square() {
        int[] arrn = new int[7];
        SecP224R1Field.square(this.x, arrn);
        return new SecP224R1FieldElement(arrn);
    }

    @Override
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] arrn = new int[7];
        SecP224R1Field.subtract(this.x, ((SecP224R1FieldElement)eCFieldElement).x, arrn);
        return new SecP224R1FieldElement(arrn);
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

