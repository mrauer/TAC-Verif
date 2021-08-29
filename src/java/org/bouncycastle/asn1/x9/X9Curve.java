/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.math.BigInteger
 */
package org.bouncycastle.asn1.x9;

import com.google.android.material.R;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x9.X9FieldID;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.raw.Nat576;

public class X9Curve
extends ASN1Object
implements X9ObjectIdentifiers {
    public ECCurve curve;
    public ASN1ObjectIdentifier fieldIdentifier;
    public byte[] seed;

    public X9Curve(X9FieldID x9FieldID, BigInteger bigInteger, BigInteger bigInteger2, ASN1Sequence aSN1Sequence) {
        block6 : {
            block9 : {
                ECCurve eCCurve;
                block5 : {
                    int n2;
                    int n3;
                    int n4;
                    int n5;
                    block8 : {
                        ASN1ObjectIdentifier aSN1ObjectIdentifier;
                        ASN1Sequence aSN1Sequence2;
                        block7 : {
                            block4 : {
                                ASN1ObjectIdentifier aSN1ObjectIdentifier2;
                                this.fieldIdentifier = null;
                                this.fieldIdentifier = aSN1ObjectIdentifier2 = x9FieldID.id;
                                if (!aSN1ObjectIdentifier2.equals(X9ObjectIdentifiers.prime_field)) break block4;
                                BigInteger bigInteger3 = ((ASN1Integer)x9FieldID.parameters).getValue();
                                BigInteger bigInteger4 = new BigInteger(1, ASN1OctetString.getInstance((Object)aSN1Sequence.getObjectAt((int)0)).string);
                                BigInteger bigInteger5 = new BigInteger(1, ASN1OctetString.getInstance((Object)aSN1Sequence.getObjectAt((int)1)).string);
                                eCCurve = new ECCurve.AbstractFp(bigInteger3, bigInteger4, bigInteger5, bigInteger, bigInteger2){
                                    public org.bouncycastle.math.ec.ECPoint$Fp infinity;
                                    public BigInteger q;
                                    public BigInteger r;
                                    {
                                        this.q = bigInteger;
                                        int n2 = bigInteger.bitLength();
                                        BigInteger bigInteger6 = n2 >= 96 && bigInteger.shiftRight(n2 - 64).longValue() == -1L ? org.bouncycastle.math.ec.ECConstants.ONE.shiftLeft(n2).subtract(bigInteger) : null;
                                        this.r = bigInteger6;
                                        this.infinity = new org.bouncycastle.math.ec.ECPoint$Fp(this, null, null);
                                        this.a = this.fromBigInteger(bigInteger2);
                                        this.b = this.fromBigInteger(bigInteger3);
                                        this.order = bigInteger4;
                                        this.cofactor = bigInteger5;
                                        this.coord = 4;
                                    }
                                    {
                                        this.q = bigInteger;
                                        this.r = bigInteger2;
                                        this.infinity = new org.bouncycastle.math.ec.ECPoint$Fp(this, null, null);
                                        this.a = eCFieldElement;
                                        this.b = eCFieldElement2;
                                        this.order = bigInteger3;
                                        this.cofactor = bigInteger4;
                                        this.coord = 4;
                                    }

                                    public ECCurve cloneCurve() {
                                        ECCurve.AbstractFp abstractFp = new /* invalid duplicate definition of identical inner class */;
                                        return abstractFp;
                                    }

                                    public org.bouncycastle.math.ec.ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
                                        return new org.bouncycastle.math.ec.ECPoint$Fp(this, eCFieldElement, eCFieldElement2);
                                    }

                                    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
                                        return new org.bouncycastle.math.ec.ECFieldElement$AbstractFp(this.q, this.r, bigInteger){
                                            public static final /* synthetic */ int $r8$clinit;
                                            public BigInteger q;
                                            public BigInteger r;
                                            public BigInteger x;
                                            {
                                                if (bigInteger3 != null && bigInteger3.signum() >= 0 && bigInteger3.compareTo(bigInteger) < 0) {
                                                    this.q = bigInteger;
                                                    this.r = bigInteger2;
                                                    this.x = bigInteger3;
                                                    return;
                                                }
                                                throw new IllegalArgumentException("x value invalid in Fp field element");
                                            }

                                            public ECFieldElement add(ECFieldElement eCFieldElement) {
                                                BigInteger bigInteger = this.q;
                                                BigInteger bigInteger2 = this.r;
                                                BigInteger bigInteger3 = this.x.add(eCFieldElement.toBigInteger());
                                                if (bigInteger3.compareTo(this.q) >= 0) {
                                                    bigInteger3 = bigInteger3.subtract(this.q);
                                                }
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public ECFieldElement addOne() {
                                                BigInteger bigInteger = this.x.add(org.bouncycastle.math.ec.ECConstants.ONE);
                                                if (bigInteger.compareTo(this.q) == 0) {
                                                    bigInteger = org.bouncycastle.math.ec.ECConstants.ZERO;
                                                }
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public final ECFieldElement checkSqrt(ECFieldElement eCFieldElement) {
                                                if (eCFieldElement.square().equals((Object)this)) {
                                                    return eCFieldElement;
                                                }
                                                return null;
                                            }

                                            public ECFieldElement divide(ECFieldElement eCFieldElement) {
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public boolean equals(Object object) {
                                                if (object == this) {
                                                    return true;
                                                }
                                                if (!(object instanceof org.bouncycastle.math.ec.ECFieldElement$Fp)) {
                                                    return false;
                                                }
                                                org.bouncycastle.math.ec.ECFieldElement$Fp fp = object;
                                                return this.q.equals((Object)fp.q) && this.x.equals((Object)fp.x);
                                            }

                                            public int getFieldSize() {
                                                return this.q.bitLength();
                                            }

                                            public int hashCode() {
                                                return this.q.hashCode() ^ this.x.hashCode();
                                            }

                                            public ECFieldElement invert() {
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public BigInteger modDouble(BigInteger bigInteger) {
                                                BigInteger bigInteger2 = bigInteger.shiftLeft(1);
                                                if (bigInteger2.compareTo(this.q) >= 0) {
                                                    bigInteger2 = bigInteger2.subtract(this.q);
                                                }
                                                return bigInteger2;
                                            }

                                            public BigInteger modInverse(BigInteger bigInteger) {
                                                BigInteger bigInteger2 = this.q;
                                                if (bigInteger2.testBit(0)) {
                                                    if (bigInteger2.signum() == 1) {
                                                        int n2;
                                                        int n3;
                                                        int[] arrn;
                                                        int[] arrn2;
                                                        int[] arrn3;
                                                        if (bigInteger.signum() < 0 || bigInteger.compareTo(bigInteger2) >= 0) {
                                                            bigInteger = bigInteger.mod(bigInteger2);
                                                        }
                                                        if (org.bouncycastle.math.ec.custom.sec.SecT239Field.modOddInverse(arrn = Nat576.fromBigInteger(n2 = bigInteger2.bitLength(), bigInteger2), arrn3 = Nat576.fromBigInteger(n2, bigInteger), arrn2 = new int[n3 = arrn.length]) != 0) {
                                                            return Nat576.toBigInteger(n3, arrn2);
                                                        }
                                                        throw new java.lang.ArithmeticException("BigInteger not invertible.");
                                                    }
                                                    throw new java.lang.ArithmeticException("BigInteger: modulus not positive");
                                                }
                                                throw new IllegalArgumentException("'M' must be odd");
                                            }

                                            public BigInteger modMult(BigInteger bigInteger, BigInteger bigInteger2) {
                                                return this.modReduce(bigInteger.multiply(bigInteger2));
                                            }

                                            public BigInteger modReduce(BigInteger bigInteger) {
                                                if (this.r != null) {
                                                    boolean bl = bigInteger.signum() < 0;
                                                    if (bl) {
                                                        bigInteger = bigInteger.abs();
                                                    }
                                                    int n2 = this.q.bitLength();
                                                    boolean bl2 = this.r.equals((Object)org.bouncycastle.math.ec.ECConstants.ONE);
                                                    while (bigInteger.bitLength() > n2 + 1) {
                                                        BigInteger bigInteger2 = bigInteger.shiftRight(n2);
                                                        BigInteger bigInteger3 = bigInteger.subtract(bigInteger2.shiftLeft(n2));
                                                        if (!bl2) {
                                                            bigInteger2 = bigInteger2.multiply(this.r);
                                                        }
                                                        bigInteger = bigInteger2.add(bigInteger3);
                                                    }
                                                    while (bigInteger.compareTo(this.q) >= 0) {
                                                        bigInteger = bigInteger.subtract(this.q);
                                                    }
                                                    if (bl && bigInteger.signum() != 0) {
                                                        return this.q.subtract(bigInteger);
                                                    }
                                                } else {
                                                    bigInteger = bigInteger.mod(this.q);
                                                }
                                                return bigInteger;
                                            }

                                            public ECFieldElement multiply(ECFieldElement eCFieldElement) {
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
                                                BigInteger bigInteger = this.x;
                                                BigInteger bigInteger2 = eCFieldElement.toBigInteger();
                                                BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
                                                BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
                                                BigInteger bigInteger5 = bigInteger.multiply(bigInteger2);
                                                BigInteger bigInteger6 = bigInteger3.multiply(bigInteger4);
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
                                                BigInteger bigInteger = this.x;
                                                BigInteger bigInteger2 = eCFieldElement.toBigInteger();
                                                BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
                                                BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
                                                BigInteger bigInteger5 = bigInteger.multiply(bigInteger2);
                                                BigInteger bigInteger6 = bigInteger3.multiply(bigInteger4);
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public ECFieldElement negate() {
                                                if (this.x.signum() == 0) {
                                                    return this;
                                                }
                                                BigInteger bigInteger = this.q;
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public ECFieldElement sqrt() {
                                                if (!this.isZero()) {
                                                    if (this.isOne()) {
                                                        return this;
                                                    }
                                                    if (this.q.testBit(0)) {
                                                        BigInteger bigInteger;
                                                        BigInteger bigInteger2 = this.q;
                                                        int n2 = 1;
                                                        if (bigInteger2.testBit(n2)) {
                                                            BigInteger bigInteger3 = this.q.shiftRight(2).add(org.bouncycastle.math.ec.ECConstants.ONE);
                                                            BigInteger bigInteger4 = this.q;
                                                            return this.checkSqrt(new /* invalid duplicate definition of identical inner class */);
                                                        }
                                                        if (this.q.testBit(2)) {
                                                            BigInteger bigInteger5 = this.x.modPow(this.q.shiftRight(3), this.q);
                                                            BigInteger bigInteger6 = this.modMult(bigInteger5, this.x);
                                                            if (this.modMult(bigInteger6, bigInteger5).equals((Object)org.bouncycastle.math.ec.ECConstants.ONE)) {
                                                                return this.checkSqrt(new /* invalid duplicate definition of identical inner class */);
                                                            }
                                                            BigInteger bigInteger7 = this.modMult(bigInteger6, org.bouncycastle.math.ec.ECConstants.TWO.modPow(this.q.shiftRight(2), this.q));
                                                            return this.checkSqrt(new /* invalid duplicate definition of identical inner class */);
                                                        }
                                                        BigInteger bigInteger8 = this.q.shiftRight(n2);
                                                        BigInteger bigInteger9 = this.x.modPow(bigInteger8, this.q);
                                                        if (!bigInteger9.equals((Object)(bigInteger = org.bouncycastle.math.ec.ECConstants.ONE))) {
                                                            return null;
                                                        }
                                                        BigInteger bigInteger10 = this.x;
                                                        BigInteger bigInteger11 = this.modDouble(this.modDouble(bigInteger10));
                                                        BigInteger bigInteger12 = bigInteger8.add(bigInteger);
                                                        BigInteger bigInteger13 = this.q.subtract(bigInteger);
                                                        java.util.Random random = new java.util.Random();
                                                        do {
                                                            BigInteger bigInteger14;
                                                            if ((bigInteger14 = new BigInteger(this.q.bitLength(), random)).compareTo(this.q) >= 0 || !this.modReduce(bigInteger14.multiply(bigInteger14).subtract(bigInteger11)).modPow(bigInteger8, this.q).equals((Object)bigInteger13)) {
                                                                continue;
                                                            }
                                                            int n3 = bigInteger12.bitLength();
                                                            int n4 = bigInteger12.getLowestSetBit();
                                                            BigInteger bigInteger15 = org.bouncycastle.math.ec.ECConstants.ONE;
                                                            BigInteger bigInteger16 = org.bouncycastle.math.ec.ECConstants.TWO;
                                                            BigInteger bigInteger17 = bigInteger14;
                                                            BigInteger bigInteger18 = bigInteger15;
                                                            BigInteger bigInteger19 = bigInteger16;
                                                            BigInteger bigInteger20 = bigInteger18;
                                                            for (int i2 = n3 - n2; i2 >= n4 + 1; --i2) {
                                                                BigInteger bigInteger21;
                                                                bigInteger15 = this.modMult(bigInteger15, bigInteger20);
                                                                if (bigInteger12.testBit(i2)) {
                                                                    BigInteger bigInteger22 = this.modReduce(bigInteger15.multiply(bigInteger10));
                                                                    bigInteger18 = this.modMult(bigInteger18, bigInteger17);
                                                                    bigInteger19 = this.modReduce(bigInteger17.multiply(bigInteger19).subtract(bigInteger14.multiply(bigInteger15)));
                                                                    BigInteger bigInteger23 = bigInteger17.multiply(bigInteger17);
                                                                    bigInteger21 = bigInteger8;
                                                                    bigInteger17 = this.modReduce(bigInteger23.subtract(bigInteger22.shiftLeft(1)));
                                                                    bigInteger20 = bigInteger22;
                                                                } else {
                                                                    bigInteger21 = bigInteger8;
                                                                    BigInteger bigInteger24 = this.modReduce(bigInteger18.multiply(bigInteger19).subtract(bigInteger15));
                                                                    BigInteger bigInteger25 = this.modReduce(bigInteger17.multiply(bigInteger19).subtract(bigInteger14.multiply(bigInteger15)));
                                                                    bigInteger19 = this.modReduce(bigInteger19.multiply(bigInteger19).subtract(bigInteger15.shiftLeft(1)));
                                                                    bigInteger18 = bigInteger24;
                                                                    bigInteger17 = bigInteger25;
                                                                    bigInteger20 = bigInteger15;
                                                                }
                                                                bigInteger8 = bigInteger21;
                                                            }
                                                            BigInteger bigInteger26 = bigInteger8;
                                                            BigInteger bigInteger27 = this.modMult(bigInteger15, bigInteger20);
                                                            BigInteger bigInteger28 = this.modReduce(bigInteger27.multiply(bigInteger10));
                                                            BigInteger bigInteger29 = this.modReduce(bigInteger18.multiply(bigInteger19).subtract(bigInteger27));
                                                            BigInteger bigInteger30 = this.modReduce(bigInteger17.multiply(bigInteger19).subtract(bigInteger14.multiply(bigInteger27)));
                                                            BigInteger bigInteger31 = this.modMult(bigInteger27, bigInteger28);
                                                            for (int i3 = 1; i3 <= n4; ++i3) {
                                                                bigInteger29 = this.modMult(bigInteger29, bigInteger30);
                                                                bigInteger30 = this.modReduce(bigInteger30.multiply(bigInteger30).subtract(bigInteger31.shiftLeft(1)));
                                                                bigInteger31 = this.modReduce(bigInteger31.multiply(bigInteger31));
                                                            }
                                                            BigInteger[] arrbigInteger = new BigInteger[]{bigInteger29, bigInteger30};
                                                            BigInteger bigInteger32 = arrbigInteger[0];
                                                            BigInteger bigInteger33 = arrbigInteger[1];
                                                            if (this.modMult(bigInteger33, bigInteger33).equals((Object)bigInteger11)) {
                                                                BigInteger bigInteger34 = this.q;
                                                                BigInteger bigInteger35 = this.r;
                                                                if (bigInteger33.testBit(0)) {
                                                                    bigInteger33 = this.q.subtract(bigInteger33);
                                                                }
                                                                return new /* invalid duplicate definition of identical inner class */;
                                                            }
                                                            if (!bigInteger32.equals((Object)org.bouncycastle.math.ec.ECConstants.ONE) && !bigInteger32.equals((Object)bigInteger13)) {
                                                                return null;
                                                            }
                                                            n2 = 1;
                                                            bigInteger8 = bigInteger26;
                                                        } while (true);
                                                    }
                                                    throw new java.lang.RuntimeException("not done yet");
                                                }
                                                return this;
                                            }

                                            public ECFieldElement square() {
                                                BigInteger bigInteger = this.q;
                                                BigInteger bigInteger2 = this.r;
                                                BigInteger bigInteger3 = this.x;
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
                                                BigInteger bigInteger = this.x;
                                                BigInteger bigInteger2 = eCFieldElement.toBigInteger();
                                                BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
                                                BigInteger bigInteger4 = bigInteger.multiply(bigInteger);
                                                BigInteger bigInteger5 = bigInteger2.multiply(bigInteger3);
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public ECFieldElement subtract(ECFieldElement eCFieldElement) {
                                                BigInteger bigInteger = this.q;
                                                BigInteger bigInteger2 = this.r;
                                                BigInteger bigInteger3 = this.x.subtract(eCFieldElement.toBigInteger());
                                                if (bigInteger3.signum() < 0) {
                                                    bigInteger3 = bigInteger3.add(this.q);
                                                }
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public BigInteger toBigInteger() {
                                                return this.x;
                                            }
                                        };
                                    }

                                    public int getFieldSize() {
                                        return this.q.bitLength();
                                    }

                                    public org.bouncycastle.math.ec.ECPoint getInfinity() {
                                        return this.infinity;
                                    }

                                    public org.bouncycastle.math.ec.ECPoint importPoint(org.bouncycastle.math.ec.ECPoint eCPoint) {
                                        int n2;
                                        if (!(this == eCPoint.curve || this.coord != 2 || eCPoint.isInfinity() || (n2 = eCPoint.curve.coord) != 2 && n2 != 3 && n2 != 4)) {
                                            ECFieldElement eCFieldElement = this.fromBigInteger(eCPoint.x.toBigInteger());
                                            ECFieldElement eCFieldElement2 = this.fromBigInteger(eCPoint.y.toBigInteger());
                                            ECFieldElement[] arreCFieldElement = new ECFieldElement[]{this.fromBigInteger(eCPoint.zs[0].toBigInteger())};
                                            return new org.bouncycastle.math.ec.ECPoint$AbstractFp(this, eCFieldElement, eCFieldElement2, arreCFieldElement){

                                                /*
                                                 * Unable to fully structure code
                                                 * Enabled aggressive block sorting
                                                 * Lifted jumps to return sites
                                                 */
                                                public org.bouncycastle.math.ec.ECPoint add(org.bouncycastle.math.ec.ECPoint var1_1) {
                                                    block20 : {
                                                        block21 : {
                                                            block22 : {
                                                                if (this.isInfinity()) {
                                                                    return var1_1;
                                                                }
                                                                if (var1_1.isInfinity()) {
                                                                    return this;
                                                                }
                                                                if (this == var1_1) {
                                                                    return this.twice();
                                                                }
                                                                var2_2 = this.curve;
                                                                var3_3 = var2_2.coord;
                                                                var4_4 = this.x;
                                                                var5_5 = this.y;
                                                                var6_6 = var1_1.x;
                                                                var7_7 = var1_1.y;
                                                                if (var3_3 == 0) break block20;
                                                                if (var3_3 == 1) break block21;
                                                                if (var3_3 != 2) {
                                                                    if (var3_3 != 4) throw new java.lang.IllegalStateException("unsupported coordinate system");
                                                                }
                                                                var22_8 = this.zs[0];
                                                                var23_9 = var1_1.zs[0];
                                                                var24_10 = var22_8.isOne();
                                                                if (var24_10 || !var22_8.equals((Object)var23_9)) break block22;
                                                                var39_11 = var4_4.subtract(var6_6);
                                                                var40_12 = var5_5.subtract(var7_7);
                                                                if (var39_11.isZero()) {
                                                                    if (var40_12.isZero() == false) return var2_2.getInfinity();
                                                                    return this.twice();
                                                                }
                                                                var41_13 = var39_11.square();
                                                                var42_14 = var4_4.multiply(var41_13);
                                                                var43_15 = var6_6.multiply(var41_13);
                                                                var44_16 = var42_14.subtract(var43_15).multiply(var5_5);
                                                                var37_17 = var40_12.square().subtract(var42_14).subtract(var43_15);
                                                                var34_18 = var42_14.subtract(var37_17).multiply(var40_12).subtract(var44_16);
                                                                var36_19 = var39_11.multiply(var22_8);
                                                                ** GOTO lbl60
                                                            }
                                                            if (!var24_10) {
                                                                var25_21 = var22_8.square();
                                                                var6_6 = var25_21.multiply(var6_6);
                                                                var7_7 = var25_21.multiply(var22_8).multiply(var7_7);
                                                            }
                                                            var26_22 = var23_9.isOne();
                                                            if (!var26_22) {
                                                                var27_23 = var23_9.square();
                                                                var4_4 = var27_23.multiply(var4_4);
                                                                var5_5 = var27_23.multiply(var23_9).multiply(var5_5);
                                                            }
                                                            var28_24 = var4_4.subtract(var6_6);
                                                            var29_25 = var5_5.subtract(var7_7);
                                                            if (var28_24.isZero()) {
                                                                if (var29_25.isZero() == false) return var2_2.getInfinity();
                                                                return this.twice();
                                                            }
                                                            var30_20 = var28_24.square();
                                                            var31_26 = var30_20.multiply(var28_24);
                                                            var32_27 = var30_20.multiply(var4_4);
                                                            var33_28 = var29_25.square().add(var31_26).subtract(var32_27.add(var32_27));
                                                            var34_18 = var32_27.subtract(var33_28).multiplyMinusProduct(var29_25, var31_26, var5_5);
                                                            var35_29 = var24_10 == false ? var28_24.multiply(var22_8) : var28_24;
                                                            var36_19 = var26_22 == false ? var35_29.multiply(var23_9) : var35_29;
                                                            if (var36_19 == var28_24) {
                                                                var37_17 = var33_28;
                                                            } else {
                                                                var37_17 = var33_28;
lbl60: // 2 sources:
                                                                var30_20 = null;
                                                            }
                                                            if (var3_3 == 4) {
                                                                var38_30 = new ECFieldElement[]{var36_19, this.calculateJacobianModifiedW(var36_19, var30_20)};
                                                                return new /* invalid duplicate definition of identical inner class */;
                                                            }
                                                            var38_30 = new ECFieldElement[]{var36_19};
                                                            return new /* invalid duplicate definition of identical inner class */;
                                                        }
                                                        var12_31 = this.zs[0];
                                                        var13_32 = var1_1.zs[0];
                                                        var14_33 = var12_31.isOne();
                                                        var15_34 = var13_32.isOne();
                                                        if (!var14_33) {
                                                            var7_7 = var7_7.multiply(var12_31);
                                                        }
                                                        if (!var15_34) {
                                                            var5_5 = var5_5.multiply(var13_32);
                                                        }
                                                        var16_35 = var7_7.subtract(var5_5);
                                                        if (!var14_33) {
                                                            var6_6 = var6_6.multiply(var12_31);
                                                        }
                                                        if (!var15_34) {
                                                            var4_4 = var4_4.multiply(var13_32);
                                                        }
                                                        var17_36 = var6_6.subtract(var4_4);
                                                        if (var17_36.isZero()) {
                                                            if (var16_35.isZero() == false) return var2_2.getInfinity();
                                                            return this.twice();
                                                        }
                                                        if (var14_33) {
                                                            var12_31 = var13_32;
                                                        } else if (!var15_34) {
                                                            var12_31 = var12_31.multiply(var13_32);
                                                        }
                                                        var18_37 = var17_36.square();
                                                        var19_38 = var18_37.multiply(var17_36);
                                                        var20_39 = var18_37.multiply(var4_4);
                                                        var21_40 = var16_35.square().multiply(var12_31).subtract(var19_38).subtract(var20_39.add(var20_39));
                                                        return new /* invalid duplicate definition of identical inner class */;
                                                    }
                                                    var8_41 = var6_6.subtract(var4_4);
                                                    var9_42 = var7_7.subtract(var5_5);
                                                    if (var8_41.isZero()) {
                                                        if (var9_42.isZero() == false) return var2_2.getInfinity();
                                                        return this.twice();
                                                    }
                                                    var10_43 = var9_42.divide(var8_41);
                                                    var11_44 = var10_43.square().subtract(var4_4).subtract(var6_6);
                                                    return new /* invalid duplicate definition of identical inner class */;
                                                }

                                                public ECFieldElement calculateJacobianModifiedW(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
                                                    ECFieldElement eCFieldElement3 = this.curve.a;
                                                    if (!eCFieldElement3.isZero()) {
                                                        if (eCFieldElement.isOne()) {
                                                            return eCFieldElement3;
                                                        }
                                                        if (eCFieldElement2 == null) {
                                                            eCFieldElement2 = eCFieldElement.square();
                                                        }
                                                        ECFieldElement eCFieldElement4 = eCFieldElement2.square();
                                                        ECFieldElement eCFieldElement5 = eCFieldElement3.negate();
                                                        if (eCFieldElement5.bitLength() < eCFieldElement3.bitLength()) {
                                                            return eCFieldElement4.multiply(eCFieldElement5).negate();
                                                        }
                                                        return eCFieldElement4.multiply(eCFieldElement3);
                                                    }
                                                    return eCFieldElement3;
                                                }

                                                public org.bouncycastle.math.ec.ECPoint detach() {
                                                    return new /* invalid duplicate definition of identical inner class */;
                                                }

                                                public ECFieldElement four(ECFieldElement eCFieldElement) {
                                                    ECFieldElement eCFieldElement2 = eCFieldElement.add(eCFieldElement);
                                                    return eCFieldElement2.add(eCFieldElement2);
                                                }

                                                public ECFieldElement getJacobianModifiedW() {
                                                    ECFieldElement[] arreCFieldElement = this.zs;
                                                    ECFieldElement eCFieldElement = arreCFieldElement[1];
                                                    if (eCFieldElement == null) {
                                                        arreCFieldElement[1] = eCFieldElement = this.calculateJacobianModifiedW(arreCFieldElement[0], null);
                                                    }
                                                    return eCFieldElement;
                                                }

                                                public ECFieldElement getZCoord(int n2) {
                                                    if (n2 == 1 && 4 == this.getCurveCoordinateSystem()) {
                                                        return this.getJacobianModifiedW();
                                                    }
                                                    return org.bouncycastle.math.ec.ECPoint.super.getZCoord(n2);
                                                }

                                                public org.bouncycastle.math.ec.ECPoint negate() {
                                                    if (this.isInfinity()) {
                                                        return this;
                                                    }
                                                    ECCurve eCCurve = this.curve;
                                                    if (eCCurve.coord != 0) {
                                                        return new /* invalid duplicate definition of identical inner class */;
                                                    }
                                                    return new /* invalid duplicate definition of identical inner class */;
                                                }

                                                public ECFieldElement three(ECFieldElement eCFieldElement) {
                                                    return eCFieldElement.add(eCFieldElement).add(eCFieldElement);
                                                }

                                                public org.bouncycastle.math.ec.ECPoint threeTimes() {
                                                    if (this.isInfinity()) {
                                                        return this;
                                                    }
                                                    ECFieldElement eCFieldElement = this.y;
                                                    if (eCFieldElement.isZero()) {
                                                        return this;
                                                    }
                                                    ECCurve eCCurve = this.curve;
                                                    int n2 = eCCurve.coord;
                                                    if (n2 != 0) {
                                                        if (n2 != 4) {
                                                            return this.twice().add(this);
                                                        }
                                                        return this.twiceJacobianModified(false).add(this);
                                                    }
                                                    ECFieldElement eCFieldElement2 = this.x;
                                                    ECFieldElement eCFieldElement3 = eCFieldElement.add(eCFieldElement);
                                                    ECFieldElement eCFieldElement4 = eCFieldElement3.square();
                                                    ECFieldElement eCFieldElement5 = this.three(eCFieldElement2.square()).add(this.curve.a);
                                                    ECFieldElement eCFieldElement6 = eCFieldElement5.square();
                                                    ECFieldElement eCFieldElement7 = this.three(eCFieldElement2).multiply(eCFieldElement4).subtract(eCFieldElement6);
                                                    if (eCFieldElement7.isZero()) {
                                                        return this.curve.getInfinity();
                                                    }
                                                    ECFieldElement eCFieldElement8 = eCFieldElement7.multiply(eCFieldElement3).invert();
                                                    ECFieldElement eCFieldElement9 = eCFieldElement7.multiply(eCFieldElement8).multiply(eCFieldElement5);
                                                    ECFieldElement eCFieldElement10 = eCFieldElement4.square().multiply(eCFieldElement8).subtract(eCFieldElement9);
                                                    ECFieldElement eCFieldElement11 = eCFieldElement10.subtract(eCFieldElement9).multiply(eCFieldElement9.add(eCFieldElement10)).add(eCFieldElement2);
                                                    return new /* invalid duplicate definition of identical inner class */;
                                                }

                                                public org.bouncycastle.math.ec.ECPoint timesPow2(int n2) {
                                                    block10 : {
                                                        block11 : {
                                                            int n3;
                                                            ECFieldElement eCFieldElement;
                                                            ECFieldElement eCFieldElement2;
                                                            ECFieldElement eCFieldElement3;
                                                            ECCurve eCCurve;
                                                            ECFieldElement eCFieldElement4;
                                                            block12 : {
                                                                ECFieldElement eCFieldElement5;
                                                                block16 : {
                                                                    block13 : {
                                                                        block14 : {
                                                                            block15 : {
                                                                                if (n2 < 0) break block10;
                                                                                if (n2 == 0) break block11;
                                                                                if (this.isInfinity()) {
                                                                                    return this;
                                                                                }
                                                                                if (n2 == 1) {
                                                                                    return this.twice();
                                                                                }
                                                                                eCCurve = this.curve;
                                                                                eCFieldElement2 = this.y;
                                                                                if (eCFieldElement2.isZero()) {
                                                                                    return eCCurve.getInfinity();
                                                                                }
                                                                                n3 = eCCurve.coord;
                                                                                eCFieldElement4 = eCCurve.a;
                                                                                eCFieldElement = this.x;
                                                                                ECFieldElement[] arreCFieldElement = this.zs;
                                                                                eCFieldElement3 = arreCFieldElement.length < 1 ? eCCurve.fromBigInteger(org.bouncycastle.math.ec.ECConstants.ONE) : arreCFieldElement[0];
                                                                                if (eCFieldElement3.isOne() || n3 == 0) break block12;
                                                                                if (n3 == 1) break block13;
                                                                                if (n3 == 2) break block14;
                                                                                if (n3 != 4) break block15;
                                                                                eCFieldElement4 = this.getJacobianModifiedW();
                                                                                break block12;
                                                                            }
                                                                            throw new java.lang.IllegalStateException("unsupported coordinate system");
                                                                        }
                                                                        eCFieldElement5 = null;
                                                                        break block16;
                                                                    }
                                                                    eCFieldElement5 = eCFieldElement3.square();
                                                                    eCFieldElement = eCFieldElement.multiply(eCFieldElement3);
                                                                    eCFieldElement2 = eCFieldElement2.multiply(eCFieldElement5);
                                                                }
                                                                eCFieldElement4 = this.calculateJacobianModifiedW(eCFieldElement3, eCFieldElement5);
                                                            }
                                                            for (int i2 = 0; i2 < n2; ++i2) {
                                                                if (eCFieldElement2.isZero()) {
                                                                    return eCCurve.getInfinity();
                                                                }
                                                                ECFieldElement eCFieldElement6 = this.three(eCFieldElement.square());
                                                                ECFieldElement eCFieldElement7 = eCFieldElement2.add(eCFieldElement2);
                                                                ECFieldElement eCFieldElement8 = eCFieldElement7.multiply(eCFieldElement2);
                                                                ECFieldElement eCFieldElement9 = eCFieldElement.multiply(eCFieldElement8);
                                                                ECFieldElement eCFieldElement10 = eCFieldElement9.add(eCFieldElement9);
                                                                ECFieldElement eCFieldElement11 = eCFieldElement8.square();
                                                                ECFieldElement eCFieldElement12 = eCFieldElement11.add(eCFieldElement11);
                                                                if (!eCFieldElement4.isZero()) {
                                                                    eCFieldElement6 = eCFieldElement6.add(eCFieldElement4);
                                                                    ECFieldElement eCFieldElement13 = eCFieldElement12.multiply(eCFieldElement4);
                                                                    eCFieldElement4 = eCFieldElement13.add(eCFieldElement13);
                                                                }
                                                                ECFieldElement eCFieldElement14 = eCFieldElement6.square().subtract(eCFieldElement10.add(eCFieldElement10));
                                                                eCFieldElement2 = eCFieldElement6.multiply(eCFieldElement10.subtract(eCFieldElement14)).subtract(eCFieldElement12);
                                                                eCFieldElement3 = eCFieldElement3.isOne() ? eCFieldElement7 : eCFieldElement7.multiply(eCFieldElement3);
                                                                eCFieldElement = eCFieldElement14;
                                                            }
                                                            if (n3 != 0) {
                                                                if (n3 != 1) {
                                                                    if (n3 != 2) {
                                                                        if (n3 == 4) {
                                                                            return new /* invalid duplicate definition of identical inner class */;
                                                                        }
                                                                        throw new java.lang.IllegalStateException("unsupported coordinate system");
                                                                    }
                                                                    return new /* invalid duplicate definition of identical inner class */;
                                                                }
                                                                return new /* invalid duplicate definition of identical inner class */;
                                                            }
                                                            ECFieldElement eCFieldElement15 = eCFieldElement3.invert();
                                                            ECFieldElement eCFieldElement16 = eCFieldElement15.square();
                                                            ECFieldElement eCFieldElement17 = eCFieldElement16.multiply(eCFieldElement15);
                                                            return new /* invalid duplicate definition of identical inner class */;
                                                        }
                                                        return this;
                                                    }
                                                    throw new IllegalArgumentException("'e' cannot be negative");
                                                }

                                                /*
                                                 * Unable to fully structure code
                                                 * Enabled aggressive block sorting
                                                 * Lifted jumps to return sites
                                                 */
                                                public org.bouncycastle.math.ec.ECPoint twice() {
                                                    block9 : {
                                                        block11 : {
                                                            block10 : {
                                                                if (this.isInfinity()) {
                                                                    return this;
                                                                }
                                                                var1_1 = this.curve;
                                                                var2_2 = this.y;
                                                                if (var2_2.isZero()) {
                                                                    return var1_1.getInfinity();
                                                                }
                                                                var3_3 = var1_1.coord;
                                                                var4_4 = this.x;
                                                                if (var3_3 == 0) {
                                                                    var5_35 = this.three(var4_4.square()).add(this.curve.a).divide(var2_2.add(var2_2));
                                                                    var6_36 = var5_35.square().subtract(var4_4.add(var4_4));
                                                                    return new /* invalid duplicate definition of identical inner class */;
                                                                }
                                                                if (var3_3 == 1) break block9;
                                                                if (var3_3 != 2) {
                                                                    if (var3_3 != 4) throw new java.lang.IllegalStateException("unsupported coordinate system");
                                                                    return this.twiceJacobianModified(true);
                                                                }
                                                                var22_5 = this.zs[0];
                                                                var23_6 = var22_5.isOne();
                                                                var24_7 = var2_2.square();
                                                                var25_8 = var24_7.square();
                                                                var26_9 = var1_1.a;
                                                                var27_10 = var26_9.negate();
                                                                if (!var27_10.toBigInteger().equals((Object)BigInteger.valueOf((long)3L))) break block10;
                                                                var36_11 = var23_6 != false ? var22_5 : var22_5.square();
                                                                var29_12 = this.three(var4_4.add(var36_11).multiply(var4_4.subtract(var36_11)));
                                                                var30_13 = var24_7.multiply(var4_4);
                                                                break block11;
                                                            }
                                                            var28_14 = this.three(var4_4.square());
                                                            if (var23_6) ** GOTO lbl37
                                                            if (!var26_9.isZero()) {
                                                                var35_15 = var22_5.square().square();
                                                                if (var27_10.bitLength() < var26_9.bitLength()) {
                                                                    var29_12 = var28_14.subtract(var35_15.multiply(var27_10));
                                                                } else {
                                                                    var26_9 = var35_15.multiply(var26_9);
lbl37: // 2 sources:
                                                                    var29_12 = var28_14.add(var26_9);
                                                                }
                                                            } else {
                                                                var29_12 = var28_14;
                                                            }
                                                            var30_13 = var4_4.multiply(var24_7);
                                                        }
                                                        var31_16 = this.four(var30_13);
                                                        var32_17 = var29_12.square().subtract(var31_16.add(var31_16));
                                                        var33_18 = var31_16.subtract(var32_17).multiply(var29_12).subtract(this.four(var25_8.add(var25_8)));
                                                        var34_19 = var2_2.add(var2_2);
                                                        if (var23_6) return new /* invalid duplicate definition of identical inner class */;
                                                        var34_19 = var34_19.multiply(var22_5);
                                                        return new /* invalid duplicate definition of identical inner class */;
                                                    }
                                                    var7_20 = this.zs[0];
                                                    var8_21 = var7_20.isOne();
                                                    var9_22 = var1_1.a;
                                                    if (!var9_22.isZero() && !var8_21) {
                                                        var9_22 = var9_22.multiply(var7_20.square());
                                                    }
                                                    var10_23 = var9_22.add(this.three(var4_4.square()));
                                                    var11_24 = var8_21 != false ? var2_2 : var2_2.multiply(var7_20);
                                                    var12_25 = var8_21 != false ? var2_2.square() : var11_24.multiply(var2_2);
                                                    var13_26 = this.four(var4_4.multiply(var12_25));
                                                    var14_27 = var10_23.square().subtract(var13_26.add(var13_26));
                                                    var15_28 = var11_24.add(var11_24);
                                                    var16_29 = var14_27.multiply(var15_28);
                                                    var17_30 = var12_25.add(var12_25);
                                                    var18_31 = var13_26.subtract(var14_27).multiply(var10_23);
                                                    var19_32 = var17_30.square();
                                                    var20_33 = var18_31.subtract(var19_32.add(var19_32));
                                                    var21_34 = var8_21 != false ? var17_30.add(var17_30) : var15_28.square();
                                                    return new /* invalid duplicate definition of identical inner class */;
                                                }

                                                public org.bouncycastle.math.ec.ECPoint$Fp twiceJacobianModified(boolean bl) {
                                                    ECFieldElement eCFieldElement;
                                                    ECFieldElement eCFieldElement2 = this.x;
                                                    ECFieldElement eCFieldElement3 = this.y;
                                                    ECFieldElement eCFieldElement4 = this.zs[0];
                                                    ECFieldElement eCFieldElement5 = this.getJacobianModifiedW();
                                                    ECFieldElement eCFieldElement6 = this.three(eCFieldElement2.square()).add(eCFieldElement5);
                                                    ECFieldElement eCFieldElement7 = eCFieldElement3.add(eCFieldElement3);
                                                    ECFieldElement eCFieldElement8 = eCFieldElement7.multiply(eCFieldElement3);
                                                    ECFieldElement eCFieldElement9 = eCFieldElement2.multiply(eCFieldElement8);
                                                    ECFieldElement eCFieldElement10 = eCFieldElement9.add(eCFieldElement9);
                                                    ECFieldElement eCFieldElement11 = eCFieldElement6.square().subtract(eCFieldElement10.add(eCFieldElement10));
                                                    ECFieldElement eCFieldElement12 = eCFieldElement8.square();
                                                    ECFieldElement eCFieldElement13 = eCFieldElement12.add(eCFieldElement12);
                                                    ECFieldElement eCFieldElement14 = eCFieldElement6.multiply(eCFieldElement10.subtract(eCFieldElement11)).subtract(eCFieldElement13);
                                                    if (bl) {
                                                        ECFieldElement eCFieldElement15 = eCFieldElement13.multiply(eCFieldElement5);
                                                        eCFieldElement = eCFieldElement15.add(eCFieldElement15);
                                                    } else {
                                                        eCFieldElement = null;
                                                    }
                                                    if (!eCFieldElement4.isOne()) {
                                                        eCFieldElement7 = eCFieldElement7.multiply(eCFieldElement4);
                                                    }
                                                    return new /* invalid duplicate definition of identical inner class */;
                                                }

                                                public org.bouncycastle.math.ec.ECPoint twicePlus(org.bouncycastle.math.ec.ECPoint eCPoint) {
                                                    if (this == eCPoint) {
                                                        return this.threeTimes();
                                                    }
                                                    if (this.isInfinity()) {
                                                        return eCPoint;
                                                    }
                                                    if (eCPoint.isInfinity()) {
                                                        return this.twice();
                                                    }
                                                    ECFieldElement eCFieldElement = this.y;
                                                    if (eCFieldElement.isZero()) {
                                                        return eCPoint;
                                                    }
                                                    ECCurve eCCurve = this.curve;
                                                    int n2 = eCCurve.coord;
                                                    if (n2 != 0) {
                                                        if (n2 != 4) {
                                                            return this.twice().add(eCPoint);
                                                        }
                                                        return this.twiceJacobianModified(false).add(eCPoint);
                                                    }
                                                    ECFieldElement eCFieldElement2 = this.x;
                                                    ECFieldElement eCFieldElement3 = eCPoint.x;
                                                    ECFieldElement eCFieldElement4 = eCPoint.y;
                                                    ECFieldElement eCFieldElement5 = eCFieldElement3.subtract(eCFieldElement2);
                                                    ECFieldElement eCFieldElement6 = eCFieldElement4.subtract(eCFieldElement);
                                                    if (eCFieldElement5.isZero()) {
                                                        if (eCFieldElement6.isZero()) {
                                                            return this.threeTimes();
                                                        }
                                                        return this;
                                                    }
                                                    ECFieldElement eCFieldElement7 = eCFieldElement5.square();
                                                    ECFieldElement eCFieldElement8 = eCFieldElement6.square();
                                                    ECFieldElement eCFieldElement9 = eCFieldElement7.multiply(eCFieldElement2.add(eCFieldElement2).add(eCFieldElement3)).subtract(eCFieldElement8);
                                                    if (eCFieldElement9.isZero()) {
                                                        return eCCurve.getInfinity();
                                                    }
                                                    ECFieldElement eCFieldElement10 = eCFieldElement9.multiply(eCFieldElement5).invert();
                                                    ECFieldElement eCFieldElement11 = eCFieldElement9.multiply(eCFieldElement10).multiply(eCFieldElement6);
                                                    ECFieldElement eCFieldElement12 = eCFieldElement.add(eCFieldElement).multiply(eCFieldElement7).multiply(eCFieldElement5).multiply(eCFieldElement10).subtract(eCFieldElement11);
                                                    ECFieldElement eCFieldElement13 = eCFieldElement12.subtract(eCFieldElement11).multiply(eCFieldElement11.add(eCFieldElement12)).add(eCFieldElement3);
                                                    return new /* invalid duplicate definition of identical inner class */;
                                                }
                                            };
                                        }
                                        return ECCurve.super.importPoint(eCPoint);
                                    }

                                    public boolean supportsCoordinateSystem(int n2) {
                                        return n2 == 0 || n2 == 1 || n2 == 2 || n2 == 4;
                                    }
                                };
                                break block5;
                            }
                            if (!this.fieldIdentifier.equals(X9ObjectIdentifiers.characteristic_two_field)) break block6;
                            aSN1Sequence2 = ASN1Sequence.getInstance(x9FieldID.parameters);
                            n4 = ((ASN1Integer)aSN1Sequence2.getObjectAt(0)).intValueExact();
                            aSN1ObjectIdentifier = (ASN1ObjectIdentifier)aSN1Sequence2.getObjectAt(1);
                            if (!aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.tpBasis)) break block7;
                            n3 = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(2)).intValueExact();
                            n2 = 0;
                            n5 = 0;
                            break block8;
                        }
                        if (!aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.ppBasis)) break block9;
                        ASN1Sequence aSN1Sequence3 = ASN1Sequence.getInstance(aSN1Sequence2.getObjectAt(2));
                        int n6 = ASN1Integer.getInstance(aSN1Sequence3.getObjectAt(0)).intValueExact();
                        int n7 = ASN1Integer.getInstance(aSN1Sequence3.getObjectAt(1)).intValueExact();
                        n5 = ASN1Integer.getInstance(aSN1Sequence3.getObjectAt(2)).intValueExact();
                        n3 = n6;
                        n2 = n7;
                    }
                    BigInteger bigInteger6 = new BigInteger(1, ASN1OctetString.getInstance((Object)aSN1Sequence.getObjectAt((int)0)).string);
                    BigInteger bigInteger7 = new BigInteger(1, ASN1OctetString.getInstance((Object)aSN1Sequence.getObjectAt((int)1)).string);
                    eCCurve = new ECCurve.AbstractF2m(n4, n3, n2, n5, bigInteger6, bigInteger7, bigInteger, bigInteger2){
                        public org.bouncycastle.math.ec.ECPoint$F2m infinity;
                        public int k1;
                        public int k2;
                        public int k3;
                        public int m;
                        {
                            this.m = n2;
                            this.k1 = n3;
                            this.k2 = n4;
                            this.k3 = n5;
                            this.order = bigInteger3;
                            this.cofactor = bigInteger4;
                            this.infinity = new org.bouncycastle.math.ec.ECPoint$F2m(this, null, null);
                            this.a = this.fromBigInteger(bigInteger);
                            this.b = this.fromBigInteger(bigInteger2);
                            this.coord = 6;
                        }
                        {
                            this.m = n2;
                            this.k1 = n3;
                            this.k2 = n4;
                            this.k3 = n5;
                            this.order = bigInteger;
                            this.cofactor = bigInteger2;
                            this.infinity = new org.bouncycastle.math.ec.ECPoint$F2m(this, null, null);
                            this.a = eCFieldElement;
                            this.b = eCFieldElement2;
                            this.coord = 6;
                        }
                        {
                            this(n2, n3, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
                        }

                        public ECCurve cloneCurve() {
                            ECCurve.AbstractF2m abstractF2m = new /* invalid duplicate definition of identical inner class */;
                            return abstractF2m;
                        }

                        public org.bouncycastle.math.ec.AbstractECLookupTable createCacheSafeLookupTable(org.bouncycastle.math.ec.ECPoint[] arreCPoint, int n2, int n3) {
                            int[] arrn;
                            int n4 = 63 + this.m >>> 6;
                            int n5 = this.k2;
                            boolean bl = n5 == 0 && this.k3 == 0;
                            if (bl) {
                                int[] arrn2 = new int[]{this.k1};
                                arrn = arrn2;
                            } else {
                                int[] arrn3 = new int[]{this.k1, n5, this.k3};
                                arrn = arrn3;
                            }
                            long[] arrl = new long[2 * (n3 * n4)];
                            int n6 = 0;
                            for (int i2 = 0; i2 < n3; ++i2) {
                                org.bouncycastle.math.ec.ECPoint eCPoint = arreCPoint[n2 + i2];
                                long[] arrl2 = (eCPoint.x).x.m_ints;
                                System.arraycopy((Object)arrl2, (int)0, (Object)arrl, (int)n6, (int)arrl2.length);
                                int n7 = n6 + n4;
                                long[] arrl3 = (eCPoint.y).x.m_ints;
                                System.arraycopy((Object)arrl3, (int)0, (Object)arrl, (int)n7, (int)arrl3.length);
                                n6 = n7 + n4;
                            }
                            org.bouncycastle.math.ec.ECCurve$F2m$1 eCCurve$F2m$1 = new org.bouncycastle.math.ec.ECCurve$F2m$1(this, n3, n4, arrl, arrn);
                            return eCCurve$F2m$1;
                        }

                        public org.bouncycastle.math.ec.ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
                            return new org.bouncycastle.math.ec.ECPoint$AbstractF2m(this, eCFieldElement, eCFieldElement2){

                                public org.bouncycastle.math.ec.ECPoint add(org.bouncycastle.math.ec.ECPoint eCPoint) {
                                    if (this.isInfinity()) {
                                        return eCPoint;
                                    }
                                    if (eCPoint.isInfinity()) {
                                        return this;
                                    }
                                    ECCurve eCCurve = this.curve;
                                    int n2 = eCCurve.coord;
                                    ECFieldElement eCFieldElement = this.x;
                                    ECFieldElement eCFieldElement2 = eCPoint.x;
                                    if (n2 != 0) {
                                        ECFieldElement eCFieldElement3;
                                        if (n2 != 1) {
                                            if (n2 == 6) {
                                                ECFieldElement eCFieldElement4;
                                                ECFieldElement eCFieldElement5;
                                                ECFieldElement eCFieldElement6;
                                                ECFieldElement eCFieldElement7;
                                                ECFieldElement eCFieldElement8;
                                                ECFieldElement eCFieldElement9;
                                                if (eCFieldElement.isZero()) {
                                                    if (eCFieldElement2.isZero()) {
                                                        return eCCurve.getInfinity();
                                                    }
                                                    return eCPoint.add(this);
                                                }
                                                ECFieldElement eCFieldElement10 = this.y;
                                                ECFieldElement eCFieldElement11 = this.zs[0];
                                                ECFieldElement eCFieldElement12 = eCPoint.y;
                                                ECFieldElement eCFieldElement13 = eCPoint.zs[0];
                                                boolean bl = eCFieldElement11.isOne();
                                                if (!bl) {
                                                    eCFieldElement8 = eCFieldElement2.multiply(eCFieldElement11);
                                                    eCFieldElement4 = eCFieldElement12.multiply(eCFieldElement11);
                                                } else {
                                                    eCFieldElement8 = eCFieldElement2;
                                                    eCFieldElement4 = eCFieldElement12;
                                                }
                                                boolean bl2 = eCFieldElement13.isOne();
                                                if (!bl2) {
                                                    eCFieldElement = eCFieldElement.multiply(eCFieldElement13);
                                                    eCFieldElement7 = eCFieldElement10.multiply(eCFieldElement13);
                                                } else {
                                                    eCFieldElement7 = eCFieldElement10;
                                                }
                                                ECFieldElement eCFieldElement14 = eCFieldElement7.add(eCFieldElement4);
                                                ECFieldElement eCFieldElement15 = eCFieldElement.add(eCFieldElement8);
                                                if (eCFieldElement15.isZero()) {
                                                    if (eCFieldElement14.isZero()) {
                                                        return this.twice();
                                                    }
                                                    return eCCurve.getInfinity();
                                                }
                                                if (eCFieldElement2.isZero()) {
                                                    org.bouncycastle.math.ec.ECPoint eCPoint2 = this.normalize();
                                                    ECFieldElement eCFieldElement16 = eCPoint2.x;
                                                    ECFieldElement eCFieldElement17 = eCPoint2.getYCoord();
                                                    ECFieldElement eCFieldElement18 = eCFieldElement17.add(eCFieldElement12).divide(eCFieldElement16);
                                                    eCFieldElement5 = com.android.tools.r8.GeneratedOutlineSupport.outline30((ECFieldElement)eCFieldElement18, (ECFieldElement)eCFieldElement18, (ECFieldElement)eCFieldElement16).add(eCCurve.a);
                                                    if (eCFieldElement5.isZero()) {
                                                        return new /* invalid duplicate definition of identical inner class */;
                                                    }
                                                    eCFieldElement6 = eCFieldElement18.multiply(eCFieldElement16.add(eCFieldElement5)).add(eCFieldElement5).add(eCFieldElement17).divide(eCFieldElement5).add(eCFieldElement5);
                                                    eCFieldElement9 = eCCurve.fromBigInteger(org.bouncycastle.math.ec.ECConstants.ONE);
                                                } else {
                                                    ECFieldElement eCFieldElement19;
                                                    ECFieldElement eCFieldElement20 = eCFieldElement15.square();
                                                    ECFieldElement eCFieldElement21 = eCFieldElement14.multiply(eCFieldElement);
                                                    ECFieldElement eCFieldElement22 = eCFieldElement21.multiply(eCFieldElement19 = eCFieldElement14.multiply(eCFieldElement8));
                                                    if (eCFieldElement22.isZero()) {
                                                        return new /* invalid duplicate definition of identical inner class */;
                                                    }
                                                    ECFieldElement eCFieldElement23 = eCFieldElement14.multiply(eCFieldElement20);
                                                    if (!bl2) {
                                                        eCFieldElement23 = eCFieldElement23.multiply(eCFieldElement13);
                                                    }
                                                    eCFieldElement6 = eCFieldElement19.add(eCFieldElement20).squarePlusProduct(eCFieldElement23, eCFieldElement10.add(eCFieldElement11));
                                                    eCFieldElement9 = !bl ? eCFieldElement23.multiply(eCFieldElement11) : eCFieldElement23;
                                                    eCFieldElement5 = eCFieldElement22;
                                                }
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }
                                            throw new java.lang.IllegalStateException("unsupported coordinate system");
                                        }
                                        ECFieldElement eCFieldElement24 = this.y;
                                        ECFieldElement eCFieldElement25 = this.zs[0];
                                        ECFieldElement eCFieldElement26 = eCPoint.y;
                                        ECFieldElement eCFieldElement27 = eCPoint.zs[0];
                                        boolean bl = eCFieldElement27.isOne();
                                        ECFieldElement eCFieldElement28 = eCFieldElement25.multiply(eCFieldElement26);
                                        ECFieldElement eCFieldElement29 = bl ? eCFieldElement24 : eCFieldElement24.multiply(eCFieldElement27);
                                        ECFieldElement eCFieldElement30 = eCFieldElement28.add(eCFieldElement29);
                                        ECFieldElement eCFieldElement31 = eCFieldElement25.multiply(eCFieldElement2);
                                        ECFieldElement eCFieldElement32 = eCFieldElement31.add(eCFieldElement3 = bl ? eCFieldElement : eCFieldElement.multiply(eCFieldElement27));
                                        if (eCFieldElement32.isZero()) {
                                            if (eCFieldElement30.isZero()) {
                                                return this.twice();
                                            }
                                            return eCCurve.getInfinity();
                                        }
                                        ECFieldElement eCFieldElement33 = eCFieldElement32.square();
                                        ECFieldElement eCFieldElement34 = eCFieldElement33.multiply(eCFieldElement32);
                                        if (!bl) {
                                            eCFieldElement25 = eCFieldElement25.multiply(eCFieldElement27);
                                        }
                                        ECFieldElement eCFieldElement35 = eCFieldElement30.add(eCFieldElement32);
                                        ECFieldElement eCFieldElement36 = eCFieldElement35.multiplyPlusProduct(eCFieldElement30, eCFieldElement33, eCCurve.a).multiply(eCFieldElement25).add(eCFieldElement34);
                                        ECFieldElement eCFieldElement37 = eCFieldElement32.multiply(eCFieldElement36);
                                        if (!bl) {
                                            eCFieldElement33 = eCFieldElement33.multiply(eCFieldElement27);
                                        }
                                        return new /* invalid duplicate definition of identical inner class */;
                                    }
                                    ECFieldElement eCFieldElement38 = this.y;
                                    ECFieldElement eCFieldElement39 = eCPoint.y;
                                    ECFieldElement eCFieldElement40 = eCFieldElement.add(eCFieldElement2);
                                    ECFieldElement eCFieldElement41 = eCFieldElement38.add(eCFieldElement39);
                                    if (eCFieldElement40.isZero()) {
                                        if (eCFieldElement41.isZero()) {
                                            return this.twice();
                                        }
                                        return eCCurve.getInfinity();
                                    }
                                    ECFieldElement eCFieldElement42 = eCFieldElement41.divide(eCFieldElement40);
                                    ECFieldElement eCFieldElement43 = com.android.tools.r8.GeneratedOutlineSupport.outline30((ECFieldElement)eCFieldElement42, (ECFieldElement)eCFieldElement42, (ECFieldElement)eCFieldElement40).add(eCCurve.a);
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public org.bouncycastle.math.ec.ECPoint detach() {
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public boolean getCompressionYTilde() {
                                    ECFieldElement eCFieldElement = this.x;
                                    if (eCFieldElement.isZero()) {
                                        return false;
                                    }
                                    ECFieldElement eCFieldElement2 = this.y;
                                    int n2 = this.getCurveCoordinateSystem();
                                    if (n2 != 5 && n2 != 6) {
                                        return eCFieldElement2.divide(eCFieldElement).testBitZero();
                                    }
                                    boolean bl = eCFieldElement2.testBitZero();
                                    boolean bl2 = eCFieldElement.testBitZero();
                                    boolean bl3 = false;
                                    if (bl != bl2) {
                                        bl3 = true;
                                    }
                                    return bl3;
                                }

                                public ECFieldElement getYCoord() {
                                    int n2 = this.getCurveCoordinateSystem();
                                    if (n2 != 5 && n2 != 6) {
                                        return this.y;
                                    }
                                    ECFieldElement eCFieldElement = this.x;
                                    ECFieldElement eCFieldElement2 = this.y;
                                    if (!this.isInfinity()) {
                                        ECFieldElement eCFieldElement3;
                                        if (eCFieldElement.isZero()) {
                                            return eCFieldElement2;
                                        }
                                        ECFieldElement eCFieldElement4 = eCFieldElement2.add(eCFieldElement).multiply(eCFieldElement);
                                        if (6 == n2 && !(eCFieldElement3 = this.zs[0]).isOne()) {
                                            eCFieldElement4 = eCFieldElement4.divide(eCFieldElement3);
                                        }
                                        return eCFieldElement4;
                                    }
                                    return eCFieldElement2;
                                }

                                public org.bouncycastle.math.ec.ECPoint negate() {
                                    if (this.isInfinity()) {
                                        return this;
                                    }
                                    ECFieldElement eCFieldElement = this.x;
                                    if (eCFieldElement.isZero()) {
                                        return this;
                                    }
                                    int n2 = this.getCurveCoordinateSystem();
                                    if (n2 != 0) {
                                        if (n2 != 1) {
                                            if (n2 != 5) {
                                                if (n2 == 6) {
                                                    ECFieldElement eCFieldElement2 = this.y;
                                                    ECFieldElement eCFieldElement3 = this.zs[0];
                                                    return new /* invalid duplicate definition of identical inner class */;
                                                }
                                                throw new java.lang.IllegalStateException("unsupported coordinate system");
                                            }
                                            ECFieldElement eCFieldElement4 = this.y;
                                            return new /* invalid duplicate definition of identical inner class */;
                                        }
                                        ECFieldElement eCFieldElement5 = this.y;
                                        ECFieldElement eCFieldElement6 = this.zs[0];
                                        return new /* invalid duplicate definition of identical inner class */;
                                    }
                                    ECFieldElement eCFieldElement7 = this.y;
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public org.bouncycastle.math.ec.ECPoint twice() {
                                    ECCurve eCCurve;
                                    ECFieldElement eCFieldElement;
                                    block6 : {
                                        block7 : {
                                            block8 : {
                                                ECFieldElement eCFieldElement2;
                                                ECFieldElement eCFieldElement3;
                                                ECFieldElement eCFieldElement4;
                                                block11 : {
                                                    block10 : {
                                                        ECFieldElement eCFieldElement5;
                                                        ECFieldElement eCFieldElement6;
                                                        ECFieldElement eCFieldElement7;
                                                        boolean bl;
                                                        block9 : {
                                                            if (this.isInfinity()) {
                                                                return this;
                                                            }
                                                            eCCurve = this.curve;
                                                            eCFieldElement = this.x;
                                                            if (eCFieldElement.isZero()) {
                                                                return eCCurve.getInfinity();
                                                            }
                                                            int n2 = eCCurve.coord;
                                                            if (n2 == 0) break block6;
                                                            if (n2 == 1) break block7;
                                                            if (n2 != 6) break block8;
                                                            ECFieldElement eCFieldElement8 = this.y;
                                                            eCFieldElement7 = this.zs[0];
                                                            bl = eCFieldElement7.isOne();
                                                            eCFieldElement5 = bl ? eCFieldElement8 : eCFieldElement8.multiply(eCFieldElement7);
                                                            ECFieldElement eCFieldElement9 = bl ? eCFieldElement7 : eCFieldElement7.square();
                                                            ECFieldElement eCFieldElement10 = eCCurve.a;
                                                            ECFieldElement eCFieldElement11 = bl ? eCFieldElement10 : eCFieldElement10.multiply(eCFieldElement9);
                                                            eCFieldElement6 = com.android.tools.r8.GeneratedOutlineSupport.outline30((ECFieldElement)eCFieldElement8, (ECFieldElement)eCFieldElement5, (ECFieldElement)eCFieldElement11);
                                                            if (eCFieldElement6.isZero()) {
                                                                return new /* invalid duplicate definition of identical inner class */;
                                                            }
                                                            eCFieldElement4 = eCFieldElement6.square();
                                                            eCFieldElement3 = bl ? eCFieldElement6 : eCFieldElement6.multiply(eCFieldElement9);
                                                            ECFieldElement eCFieldElement12 = eCCurve.b;
                                                            if (eCFieldElement12.bitLength() >= eCCurve.getFieldSize() >> 1) break block9;
                                                            ECFieldElement eCFieldElement13 = eCFieldElement8.add(eCFieldElement).square();
                                                            ECFieldElement eCFieldElement14 = eCFieldElement12.isOne() ? eCFieldElement11.add(eCFieldElement9).square() : eCFieldElement11.squarePlusProduct(eCFieldElement12, eCFieldElement9.square());
                                                            eCFieldElement2 = eCFieldElement13.add(eCFieldElement6).add(eCFieldElement9).multiply(eCFieldElement13).add(eCFieldElement14).add(eCFieldElement4);
                                                            if (eCFieldElement10.isZero()) break block10;
                                                            if (!eCFieldElement10.isOne()) {
                                                                eCFieldElement2 = eCFieldElement2.add(eCFieldElement10.addOne().multiply(eCFieldElement3));
                                                            }
                                                            break block11;
                                                        }
                                                        if (!bl) {
                                                            eCFieldElement = eCFieldElement.multiply(eCFieldElement7);
                                                        }
                                                        eCFieldElement2 = eCFieldElement.squarePlusProduct(eCFieldElement6, eCFieldElement5).add(eCFieldElement4);
                                                    }
                                                    eCFieldElement2 = eCFieldElement2.add(eCFieldElement3);
                                                }
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }
                                            throw new java.lang.IllegalStateException("unsupported coordinate system");
                                        }
                                        ECFieldElement eCFieldElement15 = this.y;
                                        ECFieldElement eCFieldElement16 = this.zs[0];
                                        boolean bl = eCFieldElement16.isOne();
                                        ECFieldElement eCFieldElement17 = bl ? eCFieldElement : eCFieldElement.multiply(eCFieldElement16);
                                        if (!bl) {
                                            eCFieldElement15 = eCFieldElement15.multiply(eCFieldElement16);
                                        }
                                        ECFieldElement eCFieldElement18 = eCFieldElement.square();
                                        ECFieldElement eCFieldElement19 = eCFieldElement18.add(eCFieldElement15);
                                        ECFieldElement eCFieldElement20 = eCFieldElement17.square();
                                        ECFieldElement eCFieldElement21 = eCFieldElement19.add(eCFieldElement17);
                                        ECFieldElement eCFieldElement22 = eCFieldElement21.multiplyPlusProduct(eCFieldElement19, eCFieldElement20, eCCurve.a);
                                        return new /* invalid duplicate definition of identical inner class */;
                                    }
                                    ECFieldElement eCFieldElement23 = this.y.divide(eCFieldElement).add(eCFieldElement);
                                    ECFieldElement eCFieldElement24 = eCFieldElement23.square().add(eCFieldElement23).add(eCCurve.a);
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public org.bouncycastle.math.ec.ECPoint twicePlus(org.bouncycastle.math.ec.ECPoint eCPoint) {
                                    if (this.isInfinity()) {
                                        return eCPoint;
                                    }
                                    if (eCPoint.isInfinity()) {
                                        return this.twice();
                                    }
                                    ECCurve eCCurve = this.curve;
                                    ECFieldElement eCFieldElement = this.x;
                                    if (eCFieldElement.isZero()) {
                                        return eCPoint;
                                    }
                                    if (eCCurve.coord != 6) {
                                        return this.twice().add(eCPoint);
                                    }
                                    ECFieldElement eCFieldElement2 = eCPoint.x;
                                    ECFieldElement eCFieldElement3 = eCPoint.zs[0];
                                    if (!eCFieldElement2.isZero() && eCFieldElement3.isOne()) {
                                        ECFieldElement eCFieldElement4 = this.y;
                                        ECFieldElement eCFieldElement5 = this.zs[0];
                                        ECFieldElement eCFieldElement6 = eCPoint.y;
                                        ECFieldElement eCFieldElement7 = eCFieldElement.square();
                                        ECFieldElement eCFieldElement8 = eCFieldElement4.square();
                                        ECFieldElement eCFieldElement9 = eCFieldElement5.square();
                                        ECFieldElement eCFieldElement10 = eCFieldElement4.multiply(eCFieldElement5);
                                        ECFieldElement eCFieldElement11 = eCCurve.a.multiply(eCFieldElement9).add(eCFieldElement8).add(eCFieldElement10);
                                        ECFieldElement eCFieldElement12 = eCFieldElement6.addOne();
                                        ECFieldElement eCFieldElement13 = eCCurve.a.add(eCFieldElement12).multiply(eCFieldElement9).add(eCFieldElement8).multiplyPlusProduct(eCFieldElement11, eCFieldElement7, eCFieldElement9);
                                        ECFieldElement eCFieldElement14 = eCFieldElement2.multiply(eCFieldElement9);
                                        ECFieldElement eCFieldElement15 = eCFieldElement14.add(eCFieldElement11).square();
                                        if (eCFieldElement15.isZero()) {
                                            if (eCFieldElement13.isZero()) {
                                                return eCPoint.twice();
                                            }
                                            return eCCurve.getInfinity();
                                        }
                                        if (eCFieldElement13.isZero()) {
                                            return new /* invalid duplicate definition of identical inner class */;
                                        }
                                        ECFieldElement eCFieldElement16 = eCFieldElement13.square().multiply(eCFieldElement14);
                                        ECFieldElement eCFieldElement17 = eCFieldElement13.multiply(eCFieldElement15).multiply(eCFieldElement9);
                                        return new /* invalid duplicate definition of identical inner class */;
                                    }
                                    return this.twice().add(eCPoint);
                                }
                            };
                        }

                        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
                            org.bouncycastle.math.ec.ECFieldElement$AbstractF2m abstractF2m = new org.bouncycastle.math.ec.ECFieldElement$AbstractF2m(this.m, this.k1, this.k2, this.k3, bigInteger){
                                public int[] ks;
                                public int m;
                                public int representation;
                                public org.bouncycastle.math.ec.LongArray x;
                                {
                                    block2 : {
                                        block5 : {
                                            block6 : {
                                                block4 : {
                                                    block3 : {
                                                        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > n2) break block2;
                                                        if (n4 != 0 || n5 != 0) break block3;
                                                        this.representation = 2;
                                                        this.ks = new int[]{n3};
                                                        break block4;
                                                    }
                                                    if (n4 >= n5) break block5;
                                                    if (n4 <= 0) break block6;
                                                    this.representation = 3;
                                                    this.ks = new int[]{n3, n4, n5};
                                                }
                                                this.m = n2;
                                                this.x = new org.bouncycastle.math.ec.LongArray(bigInteger);
                                                return;
                                            }
                                            throw new IllegalArgumentException("k2 must be larger than 0");
                                        }
                                        throw new IllegalArgumentException("k2 must be smaller than k3");
                                    }
                                    throw new IllegalArgumentException("x value invalid in F2m field element");
                                }
                                {
                                    this.m = n2;
                                    int n3 = arrn.length == 1 ? 2 : 3;
                                    this.representation = n3;
                                    this.ks = arrn;
                                    this.x = longArray;
                                }

                                public ECFieldElement add(ECFieldElement eCFieldElement) {
                                    org.bouncycastle.math.ec.LongArray longArray = (org.bouncycastle.math.ec.LongArray)this.x.clone();
                                    longArray.addShiftedByWords((eCFieldElement).x, 0);
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public ECFieldElement addOne() {
                                    org.bouncycastle.math.ec.LongArray longArray;
                                    int n2 = this.m;
                                    int[] arrn = this.ks;
                                    org.bouncycastle.math.ec.LongArray longArray2 = this.x;
                                    if (longArray2.m_ints.length == 0) {
                                        longArray = new org.bouncycastle.math.ec.LongArray(new long[]{1L});
                                    } else {
                                        int n3 = java.lang.Math.max((int)1, (int)longArray2.getUsedLength());
                                        long[] arrl = new long[n3];
                                        long[] arrl2 = longArray2.m_ints;
                                        System.arraycopy((Object)arrl2, (int)0, (Object)arrl, (int)0, (int)java.lang.Math.min((int)arrl2.length, (int)n3));
                                        arrl[0] = 1L ^ arrl[0];
                                        longArray = new org.bouncycastle.math.ec.LongArray(arrl);
                                    }
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public int bitLength() {
                                    return this.x.degree();
                                }

                                public ECFieldElement divide(ECFieldElement eCFieldElement) {
                                    return this.multiply(eCFieldElement.invert());
                                }

                                public boolean equals(Object object) {
                                    if (object == this) {
                                        return true;
                                    }
                                    if (!(object instanceof org.bouncycastle.math.ec.ECFieldElement$F2m)) {
                                        return false;
                                    }
                                    org.bouncycastle.math.ec.ECFieldElement$F2m f2m = object;
                                    return this.m == f2m.m && this.representation == f2m.representation && java.util.Arrays.equals((int[])this.ks, (int[])f2m.ks) && this.x.equals(f2m.x);
                                }

                                public int getFieldSize() {
                                    return this.m;
                                }

                                public int hashCode() {
                                    return this.x.hashCode() ^ this.m ^ Nat576.hashCode(this.ks);
                                }

                                /*
                                 * Enabled force condition propagation
                                 * Lifted jumps to return sites
                                 */
                                public ECFieldElement invert() {
                                    int n2 = this.m;
                                    int[] arrn = this.ks;
                                    org.bouncycastle.math.ec.LongArray longArray = this.x;
                                    int n3 = longArray.degree();
                                    if (n3 == 0) throw new java.lang.IllegalStateException();
                                    int n4 = 1;
                                    if (n3 == n4) return new /* invalid duplicate definition of identical inner class */;
                                    org.bouncycastle.math.ec.LongArray longArray2 = (org.bouncycastle.math.ec.LongArray)longArray.clone();
                                    int n5 = n2 + 63 >>> 6;
                                    org.bouncycastle.math.ec.LongArray longArray3 = new org.bouncycastle.math.ec.LongArray(n5);
                                    org.bouncycastle.math.ec.LongArray.reduceBit(longArray3.m_ints, 0, n2, n2, arrn);
                                    org.bouncycastle.math.ec.LongArray longArray4 = new org.bouncycastle.math.ec.LongArray(n5);
                                    longArray4.m_ints[0] = 1L;
                                    org.bouncycastle.math.ec.LongArray longArray5 = new org.bouncycastle.math.ec.LongArray(n5);
                                    int[] arrn2 = new int[2];
                                    arrn2[0] = n3;
                                    arrn2[n4] = n2 + 1;
                                    org.bouncycastle.math.ec.LongArray[] arrlongArray = new org.bouncycastle.math.ec.LongArray[2];
                                    arrlongArray[0] = longArray2;
                                    arrlongArray[n4] = longArray3;
                                    int[] arrn3 = new int[]{1, 0};
                                    org.bouncycastle.math.ec.LongArray[] arrlongArray2 = new org.bouncycastle.math.ec.LongArray[2];
                                    arrlongArray2[0] = longArray4;
                                    arrlongArray2[n4] = longArray5;
                                    int n6 = arrn2[n4];
                                    int n7 = arrn3[n4];
                                    int n8 = n6 - arrn2[0];
                                    do {
                                        if (n8 < 0) {
                                            n8 = -n8;
                                            arrn2[n4] = n6;
                                            arrn3[n4] = n7;
                                            n4 = 1 - n4;
                                            n6 = arrn2[n4];
                                            n7 = arrn3[n4];
                                        }
                                        org.bouncycastle.math.ec.LongArray longArray6 = arrlongArray[n4];
                                        int n9 = 1 - n4;
                                        longArray6.addShiftedByBitsSafe(arrlongArray[n9], arrn2[n9], n8);
                                        int n10 = arrlongArray[n4].degreeFrom(n6);
                                        if (n10 == 0) {
                                            longArray = arrlongArray2[n9];
                                            return new /* invalid duplicate definition of identical inner class */;
                                        }
                                        int n11 = arrn3[n9];
                                        arrlongArray2[n4].addShiftedByBitsSafe(arrlongArray2[n9], n11, n8);
                                        int n12 = n11 + n8;
                                        if (n12 > n7) {
                                            n7 = n12;
                                        } else if (n12 == n7) {
                                            n7 = arrlongArray2[n4].degreeFrom(n7);
                                        }
                                        n8 += n10 - n6;
                                        n6 = n10;
                                    } while (true);
                                }

                                public boolean isOne() {
                                    return this.x.isOne();
                                }

                                public boolean isZero() {
                                    return this.x.isZero();
                                }

                                /*
                                 * Enabled aggressive block sorting
                                 */
                                public ECFieldElement multiply(ECFieldElement eCFieldElement) {
                                    int n2 = this.m;
                                    int[] arrn = this.ks;
                                    org.bouncycastle.math.ec.LongArray longArray = this.x;
                                    org.bouncycastle.math.ec.LongArray longArray2 = (eCFieldElement).x;
                                    int n3 = longArray.degree();
                                    if (n3 == 0) {
                                        return new /* invalid duplicate definition of identical inner class */;
                                    }
                                    int n4 = longArray2.degree();
                                    if (n4 != 0) {
                                        if (n3 > n4) {
                                            int n5 = n4;
                                            n4 = n3;
                                            n3 = n5;
                                        } else {
                                            org.bouncycastle.math.ec.LongArray longArray3 = longArray2;
                                            longArray2 = longArray;
                                            longArray = longArray3;
                                        }
                                        int n6 = n3 + 63 >>> 6;
                                        int n7 = n4 + 63 >>> 6;
                                        int n8 = 62 + (n3 + n4) >>> 6;
                                        if (n6 == 1) {
                                            long l2 = longArray2.m_ints[0];
                                            if (l2 == 1L) {
                                                return new /* invalid duplicate definition of identical inner class */;
                                            }
                                            long[] arrl = new long[n8];
                                            org.bouncycastle.math.ec.LongArray.multiplyWord(l2, longArray.m_ints, n7, arrl, 0);
                                            longArray = new org.bouncycastle.math.ec.LongArray(arrl, 0, org.bouncycastle.math.ec.LongArray.reduceInPlace(arrl, 0, n8, n2, arrn));
                                            return new /* invalid duplicate definition of identical inner class */;
                                        }
                                        int n9 = 63 + (n4 + 7) >>> 6;
                                        int n10 = 16;
                                        int[] arrn2 = new int[n10];
                                        int n11 = n9 << 4;
                                        long[] arrl = new long[n11];
                                        arrn2[1] = n9;
                                        System.arraycopy((Object)longArray.m_ints, (int)0, (Object)arrl, (int)n9, (int)n7);
                                        int n12 = n9;
                                        for (int i2 = 2; i2 < n10; ++i2) {
                                            long[] arrl2;
                                            int n13;
                                            arrn2[i2] = n12 += n9;
                                            if ((i2 & 1) == 0) {
                                                int n14 = n12 >>> 1;
                                                arrl2 = arrl;
                                                n13 = n11;
                                                org.bouncycastle.math.ec.LongArray.shiftUp(arrl, n14, arrl2, n12, n9, 1);
                                            } else {
                                                arrl2 = arrl;
                                                n13 = n11;
                                                int n15 = n12 - n9;
                                                org.bouncycastle.math.ec.LongArray.add(arrl, n9, arrl2, n15, arrl2, n12, n9);
                                            }
                                            n11 = n13;
                                            arrl = arrl2;
                                            n10 = 16;
                                        }
                                        long[] arrl3 = arrl;
                                        int n16 = n11;
                                        long[] arrl4 = new long[n16];
                                        org.bouncycastle.math.ec.LongArray.shiftUp(arrl, 0, arrl4, 0, n16, 4);
                                        long[] arrl5 = longArray2.m_ints;
                                        int n17 = n8 << 3;
                                        long[] arrl6 = new long[n17];
                                        int n18 = 0;
                                        block1 : do {
                                            if (n18 >= n6) {
                                                while ((n17 -= n8) != 0) {
                                                    org.bouncycastle.math.ec.LongArray.addShiftedUp(arrl6, n17 - n8, arrl6, n17, n8, 8);
                                                }
                                                longArray2 = new org.bouncycastle.math.ec.LongArray(arrl6, 0, org.bouncycastle.math.ec.LongArray.reduceInPlace(arrl6, 0, n8, n2, arrn));
                                                break;
                                            }
                                            long l3 = arrl5[n18];
                                            int n19 = n18;
                                            do {
                                                int n20 = 15 & (int)l3;
                                                long l4 = l3 >>> 4;
                                                int n21 = 15 & (int)l4;
                                                int n22 = arrn2[n20];
                                                int n23 = arrn2[n21];
                                                org.bouncycastle.math.ec.LongArray.addBoth(arrl6, n19, arrl3, n22, arrl4, n23, n9);
                                                l3 = l4 >>> 4;
                                                if (l3 == 0L) {
                                                    ++n18;
                                                    continue block1;
                                                }
                                                n19 += n8;
                                            } while (true);
                                            break;
                                        } while (true);
                                    }
                                    longArray = longArray2;
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
                                    return this.multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
                                }

                                public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
                                    org.bouncycastle.math.ec.LongArray longArray = this.x;
                                    org.bouncycastle.math.ec.LongArray longArray2 = (eCFieldElement).x;
                                    org.bouncycastle.math.ec.LongArray longArray3 = (eCFieldElement2).x;
                                    org.bouncycastle.math.ec.LongArray longArray4 = (eCFieldElement3).x;
                                    org.bouncycastle.math.ec.LongArray longArray5 = longArray.multiply(longArray2);
                                    org.bouncycastle.math.ec.LongArray longArray6 = longArray3.multiply(longArray4);
                                    if (longArray5 == longArray || longArray5 == longArray2) {
                                        longArray5 = (org.bouncycastle.math.ec.LongArray)longArray5.clone();
                                    }
                                    longArray5.addShiftedByWords(longArray6, 0);
                                    longArray5.reduce(this.m, this.ks);
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public ECFieldElement negate() {
                                    return this;
                                }

                                public ECFieldElement sqrt() {
                                    if (!this.x.isZero() && !this.x.isOne()) {
                                        return this.squarePow(-1 + this.m);
                                    }
                                    return this;
                                }

                                public ECFieldElement square() {
                                    int n2 = this.m;
                                    int[] arrn = this.ks;
                                    org.bouncycastle.math.ec.LongArray longArray = this.x;
                                    int n3 = longArray.getUsedLength();
                                    if (n3 != 0) {
                                        int n4 = n3 << 1;
                                        long[] arrl = new long[n4];
                                        int n5 = 0;
                                        while (n5 < n4) {
                                            long l2 = longArray.m_ints[n5 >>> 1];
                                            int n6 = n5 + 1;
                                            arrl[n5] = org.bouncycastle.math.ec.LongArray.interleave2_32to64((int)l2);
                                            n5 = n6 + 1;
                                            arrl[n6] = org.bouncycastle.math.ec.LongArray.interleave2_32to64((int)(l2 >>> 32));
                                        }
                                        longArray = new org.bouncycastle.math.ec.LongArray(arrl, 0, org.bouncycastle.math.ec.LongArray.reduceInPlace(arrl, 0, n4, n2, arrn));
                                    }
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
                                    org.bouncycastle.math.ec.LongArray longArray;
                                    org.bouncycastle.math.ec.LongArray longArray2 = this.x;
                                    org.bouncycastle.math.ec.LongArray longArray3 = (eCFieldElement).x;
                                    org.bouncycastle.math.ec.LongArray longArray4 = (eCFieldElement2).x;
                                    int n2 = longArray2.getUsedLength();
                                    if (n2 == 0) {
                                        longArray = longArray2;
                                    } else {
                                        int n3 = n2 << 1;
                                        long[] arrl = new long[n3];
                                        int n4 = 0;
                                        while (n4 < n3) {
                                            long l2 = longArray2.m_ints[n4 >>> 1];
                                            int n5 = n4 + 1;
                                            arrl[n4] = org.bouncycastle.math.ec.LongArray.interleave2_32to64((int)l2);
                                            n4 = n5 + 1;
                                            arrl[n5] = org.bouncycastle.math.ec.LongArray.interleave2_32to64((int)(l2 >>> 32));
                                        }
                                        longArray = new org.bouncycastle.math.ec.LongArray(arrl, 0, n3);
                                    }
                                    org.bouncycastle.math.ec.LongArray longArray5 = longArray3.multiply(longArray4);
                                    if (longArray == longArray2) {
                                        longArray = (org.bouncycastle.math.ec.LongArray)longArray.clone();
                                    }
                                    longArray.addShiftedByWords(longArray5, 0);
                                    longArray.reduce(this.m, this.ks);
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public ECFieldElement squarePow(int n2) {
                                    if (n2 < 1) {
                                        return this;
                                    }
                                    int n3 = this.m;
                                    int[] arrn = this.ks;
                                    org.bouncycastle.math.ec.LongArray longArray = this.x;
                                    int n4 = longArray.getUsedLength();
                                    if (n4 != 0) {
                                        int n5 = n3 + 63 >>> 6 << 1;
                                        long[] arrl = new long[n5];
                                        System.arraycopy((Object)longArray.m_ints, (int)0, (Object)arrl, (int)0, (int)n4);
                                        while (--n2 >= 0) {
                                            int n6 = n4 << 1;
                                            while (--n4 >= 0) {
                                                long l2 = arrl[n4];
                                                int n7 = n6 - 1;
                                                arrl[n7] = org.bouncycastle.math.ec.LongArray.interleave2_32to64((int)(l2 >>> 32));
                                                n6 = n7 - 1;
                                                arrl[n6] = org.bouncycastle.math.ec.LongArray.interleave2_32to64((int)l2);
                                            }
                                            n4 = org.bouncycastle.math.ec.LongArray.reduceInPlace(arrl, 0, n5, n3, arrn);
                                        }
                                        longArray = new org.bouncycastle.math.ec.LongArray(arrl, 0, n4);
                                    }
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public ECFieldElement subtract(ECFieldElement eCFieldElement) {
                                    return this.add(eCFieldElement);
                                }

                                public boolean testBitZero() {
                                    long[] arrl = this.x.m_ints;
                                    int n2 = arrl.length;
                                    boolean bl = false;
                                    if (n2 > 0) {
                                        long l2 = 1L & arrl[0] LCMP 0L;
                                        bl = false;
                                        if (l2 != false) {
                                            bl = true;
                                        }
                                    }
                                    return bl;
                                }

                                public BigInteger toBigInteger() {
                                    org.bouncycastle.math.ec.LongArray longArray = this.x;
                                    int n2 = longArray.getUsedLength();
                                    if (n2 == 0) {
                                        return org.bouncycastle.math.ec.ECConstants.ZERO;
                                    }
                                    long[] arrl = longArray.m_ints;
                                    int n3 = n2 - 1;
                                    long l2 = arrl[n3];
                                    byte[] arrby = new byte[8];
                                    int n4 = 0;
                                    int n5 = 0;
                                    boolean bl = false;
                                    for (int i2 = 7; i2 >= 0; --i2) {
                                        byte by = (byte)(l2 >>> i2 * 8);
                                        if (!bl && by == 0) continue;
                                        int n6 = n5 + 1;
                                        arrby[n5] = by;
                                        n5 = n6;
                                        bl = true;
                                    }
                                    byte[] arrby2 = new byte[n5 + n3 * 8];
                                    while (n4 < n5) {
                                        arrby2[n4] = arrby[n4];
                                        ++n4;
                                    }
                                    for (int i3 = n2 - 2; i3 >= 0; --i3) {
                                        long l3 = longArray.m_ints[i3];
                                        for (int i4 = 7; i4 >= 0; --i4) {
                                            int n7 = n5 + 1;
                                            arrby2[n5] = (byte)(l3 >>> i4 * 8);
                                            n5 = n7;
                                        }
                                    }
                                    return new BigInteger(1, arrby2);
                                }
                            };
                            return abstractF2m;
                        }

                        public int getFieldSize() {
                            return this.m;
                        }

                        public org.bouncycastle.math.ec.ECPoint getInfinity() {
                            return this.infinity;
                        }

                        public boolean supportsCoordinateSystem(int n2) {
                            return n2 == 0 || n2 == 1 || n2 == 6;
                        }
                    };
                }
                this.curve = eCCurve;
                if (aSN1Sequence.size() == 3) {
                    this.seed = ((DERBitString)aSN1Sequence.getObjectAt(2)).getBytes();
                }
                return;
            }
            throw new IllegalArgumentException("This type of EC basis is not implemented");
        }
        throw new IllegalArgumentException("This type of ECCurve is not implemented");
    }

    public X9Curve(ECCurve eCCurve, byte[] arrby) {
        block4 : {
            ASN1ObjectIdentifier aSN1ObjectIdentifier;
            block3 : {
                block2 : {
                    this.fieldIdentifier = null;
                    this.curve = eCCurve;
                    this.seed = Nat576.clone(arrby);
                    if (!R.style.isFpField((FiniteField)this.curve.field)) break block2;
                    aSN1ObjectIdentifier = X9ObjectIdentifiers.prime_field;
                    break block3;
                }
                if (!R.style.isF2mCurve((ECCurve)this.curve)) break block4;
                aSN1ObjectIdentifier = X9ObjectIdentifiers.characteristic_two_field;
            }
            this.fieldIdentifier = aSN1ObjectIdentifier;
            return;
        }
        throw new IllegalArgumentException("This type of ECCurve is not implemented");
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public ASN1Primitive toASN1Primitive() {
        byte[] arrby;
        ASN1EncodableVector aSN1EncodableVector;
        block21 : {
            DEROctetString dEROctetString;
            block20 : {
                byte[] arrby2;
                block27 : {
                    byte[] arrby3;
                    block26 : {
                        int n2;
                        block25 : {
                            byte[] arrby4;
                            block24 : {
                                byte[] arrby5;
                                block23 : {
                                    int n3;
                                    block22 : {
                                        block13 : {
                                            byte[] arrby6;
                                            block19 : {
                                                byte[] arrby7;
                                                block18 : {
                                                    int n4;
                                                    block17 : {
                                                        byte[] arrby8;
                                                        block16 : {
                                                            byte[] arrby9;
                                                            block15 : {
                                                                int n5;
                                                                block14 : {
                                                                    aSN1EncodableVector = new ASN1EncodableVector(3);
                                                                    if (!this.fieldIdentifier.equals(X9ObjectIdentifiers.prime_field)) break block13;
                                                                    ECFieldElement eCFieldElement = this.curve.a;
                                                                    n5 = (7 + eCFieldElement.getFieldSize()) / 8;
                                                                    if (n5 >= (arrby8 = eCFieldElement.toBigInteger().toByteArray()).length) break block14;
                                                                    arrby9 = new byte[n5];
                                                                    System.arraycopy((Object)arrby8, (int)(arrby8.length - n5), (Object)arrby9, (int)0, (int)n5);
                                                                    break block15;
                                                                }
                                                                if (n5 <= arrby8.length) break block16;
                                                                arrby9 = new byte[n5];
                                                                System.arraycopy((Object)arrby8, (int)0, (Object)arrby9, (int)(n5 - arrby8.length), (int)arrby8.length);
                                                            }
                                                            arrby8 = arrby9;
                                                        }
                                                        aSN1EncodableVector.add(new DEROctetString(arrby8));
                                                        ECFieldElement eCFieldElement = this.curve.b;
                                                        n4 = (7 + eCFieldElement.getFieldSize()) / 8;
                                                        arrby6 = eCFieldElement.toBigInteger().toByteArray();
                                                        if (n4 >= arrby6.length) break block17;
                                                        arrby7 = new byte[n4];
                                                        System.arraycopy((Object)arrby6, (int)(arrby6.length - n4), (Object)arrby7, (int)0, (int)n4);
                                                        break block18;
                                                    }
                                                    if (n4 <= arrby6.length) break block19;
                                                    arrby7 = new byte[n4];
                                                    System.arraycopy((Object)arrby6, (int)0, (Object)arrby7, (int)(n4 - arrby6.length), (int)arrby6.length);
                                                }
                                                arrby6 = arrby7;
                                            }
                                            dEROctetString = new DEROctetString(arrby6);
                                            break block20;
                                        }
                                        if (!this.fieldIdentifier.equals(X9ObjectIdentifiers.characteristic_two_field)) break block21;
                                        ECFieldElement eCFieldElement = this.curve.a;
                                        n3 = (7 + eCFieldElement.getFieldSize()) / 8;
                                        if (n3 >= (arrby4 = eCFieldElement.toBigInteger().toByteArray()).length) break block22;
                                        arrby5 = new byte[n3];
                                        System.arraycopy((Object)arrby4, (int)(arrby4.length - n3), (Object)arrby5, (int)0, (int)n3);
                                        break block23;
                                    }
                                    if (n3 <= arrby4.length) break block24;
                                    arrby5 = new byte[n3];
                                    System.arraycopy((Object)arrby4, (int)0, (Object)arrby5, (int)(n3 - arrby4.length), (int)arrby4.length);
                                }
                                arrby4 = arrby5;
                            }
                            aSN1EncodableVector.add(new DEROctetString(arrby4));
                            ECFieldElement eCFieldElement = this.curve.b;
                            n2 = (7 + eCFieldElement.getFieldSize()) / 8;
                            arrby2 = eCFieldElement.toBigInteger().toByteArray();
                            if (n2 >= arrby2.length) break block25;
                            arrby3 = new byte[n2];
                            System.arraycopy((Object)arrby2, (int)(arrby2.length - n2), (Object)arrby3, (int)0, (int)n2);
                            break block26;
                        }
                        if (n2 <= arrby2.length) break block27;
                        arrby3 = new byte[n2];
                        System.arraycopy((Object)arrby2, (int)0, (Object)arrby3, (int)(n2 - arrby2.length), (int)arrby2.length);
                    }
                    arrby2 = arrby3;
                }
                dEROctetString = new DEROctetString(arrby2);
            }
            aSN1EncodableVector.add(dEROctetString);
        }
        if ((arrby = this.seed) != null) {
            aSN1EncodableVector.add(new DERBitString(arrby));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

