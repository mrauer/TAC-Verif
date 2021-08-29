/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.System
 *  java.math.BigInteger
 *  java.security.SecureRandom
 *  java.util.Hashtable
 *  org.bouncycastle.math.ec.ECFieldElement
 *  org.bouncycastle.math.ec.ECPoint$1
 *  org.bouncycastle.math.ec.ValidityPrecompInfo
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompCallback;
import org.bouncycastle.math.ec.PreCompInfo;
import org.bouncycastle.math.ec.ValidityPrecompInfo;

public abstract class ECPoint {
    public static final ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];
    public ECCurve curve;
    public Hashtable preCompTable;
    public ECFieldElement x;
    public ECFieldElement y;
    public ECFieldElement[] zs;

    public ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        ECFieldElement[] arreCFieldElement;
        block5 : {
            block1 : {
                ECFieldElement eCFieldElement3;
                block2 : {
                    block3 : {
                        block4 : {
                            int n2 = eCCurve == null ? 0 : eCCurve.coord;
                            if (n2 == 0 || n2 == 5) break block1;
                            eCFieldElement3 = eCCurve.fromBigInteger(ECConstants.ONE);
                            if (n2 == 1 || n2 == 2) break block2;
                            if (n2 == 3) break block3;
                            if (n2 == 4) break block4;
                            if (n2 != 6) {
                                throw new IllegalArgumentException("unknown coordinate system");
                            }
                            break block2;
                        }
                        arreCFieldElement = new ECFieldElement[]{eCFieldElement3, eCCurve.a};
                        break block5;
                    }
                    arreCFieldElement = new ECFieldElement[]{eCFieldElement3, eCFieldElement3, eCFieldElement3};
                    break block5;
                }
                arreCFieldElement = new ECFieldElement[]{eCFieldElement3};
                break block5;
            }
            arreCFieldElement = EMPTY_ZS;
        }
        this(eCCurve, eCFieldElement, eCFieldElement2, arreCFieldElement);
    }

    public ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] arreCFieldElement) {
        this.preCompTable = null;
        this.curve = eCCurve;
        this.x = eCFieldElement;
        this.y = eCFieldElement2;
        this.zs = arreCFieldElement;
    }

    public abstract ECPoint add(ECPoint var1);

    public abstract ECPoint detach();

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ECPoint)) {
            return false;
        }
        return this.equals((ECPoint)object);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(ECPoint var1_1) {
        block6 : {
            if (var1_1 == null) {
                return false;
            }
            var2_2 = this.curve;
            var3_3 = var1_1.curve;
            var4_4 = var2_2 == null;
            var5_5 = var3_3 == null;
            var6_6 = this.isInfinity();
            var7_7 = var1_1.isInfinity();
            if (var6_6 || var7_7) break block6;
            if (var4_4 && var5_5) ** GOTO lbl13
            if (var4_4) {
                var1_1 = var1_1.normalize();
lbl13: // 2 sources:
                var11_8 = this;
            } else if (var5_5) {
                var11_8 = this.normalize();
            } else {
                if (!var2_2.equals(var3_3)) {
                    return false;
                }
                var10_9 = new ECPoint[]{this, var2_2.importPoint(var1_1)};
                var2_2.normalizeAll(var10_9);
                var11_8 = var10_9[0];
                var1_1 = var10_9[1];
            }
            var12_10 = var11_8.x.equals((Object)var1_1.x);
            var13_11 = false;
            if (var12_10 == false) return var13_11;
            var14_12 = var11_8.getYCoord().equals((Object)var1_1.getYCoord());
            var13_11 = false;
            if (var14_12 == false) return var13_11;
            return true;
        }
        var8_13 = false;
        if (var6_6 == false) return var8_13;
        var8_13 = false;
        if (var7_7 == false) return var8_13;
        if (var4_4 != false) return true;
        if (var5_5 != false) return true;
        var9_14 = var2_2.equals(var3_3);
        var8_13 = false;
        if (var9_14 == false) return var8_13;
        return true;
    }

    public ECFieldElement getAffineXCoord() {
        if (this.isNormalized()) {
            return this.x;
        }
        throw new IllegalStateException("point not in normal form");
    }

    public ECFieldElement getAffineYCoord() {
        if (this.isNormalized()) {
            return this.getYCoord();
        }
        throw new IllegalStateException("point not in normal form");
    }

    public abstract boolean getCompressionYTilde();

    public int getCurveCoordinateSystem() {
        ECCurve eCCurve = this.curve;
        if (eCCurve == null) {
            return 0;
        }
        return eCCurve.coord;
    }

    public byte[] getEncoded(boolean bl) {
        if (this.isInfinity()) {
            return new byte[1];
        }
        ECPoint eCPoint = this.normalize();
        byte[] arrby = eCPoint.x.getEncoded();
        if (bl) {
            byte[] arrby2 = new byte[1 + arrby.length];
            int n2 = eCPoint.getCompressionYTilde() ? 3 : 2;
            arrby2[0] = n2;
            System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)1, (int)arrby.length);
            return arrby2;
        }
        byte[] arrby3 = eCPoint.getYCoord().getEncoded();
        byte[] arrby4 = new byte[1 + (arrby.length + arrby3.length)];
        arrby4[0] = 4;
        System.arraycopy((Object)arrby, (int)0, (Object)arrby4, (int)1, (int)arrby.length);
        System.arraycopy((Object)arrby3, (int)0, (Object)arrby4, (int)(1 + arrby.length), (int)arrby3.length);
        return arrby4;
    }

    public ECFieldElement getYCoord() {
        return this.y;
    }

    public ECFieldElement getZCoord(int n2) {
        ECFieldElement[] arreCFieldElement;
        if (n2 >= 0 && n2 < (arreCFieldElement = this.zs).length) {
            return arreCFieldElement[n2];
        }
        return null;
    }

    public int hashCode() {
        ECCurve eCCurve = this.curve;
        int n2 = eCCurve == null ? 0 : eCCurve.hashCode();
        if (!this.isInfinity()) {
            ECPoint eCPoint = this.normalize();
            n2 = n2 ^ 17 * eCPoint.x.hashCode() ^ 257 * eCPoint.getYCoord().hashCode();
        }
        return n2;
    }

    public boolean implIsValid(boolean bl, boolean bl2) {
        if (this.isInfinity()) {
            return true;
        }
        return true ^ ((ValidityPrecompInfo)this.curve.precompute((ECPoint)this, (String)"bc_validity", (PreCompCallback)new 1((ECPoint)this, (boolean)bl, (boolean)bl2))).failed;
    }

    public boolean isInfinity() {
        boolean bl;
        block3 : {
            block2 : {
                if (this.x == null || this.y == null) break block2;
                ECFieldElement[] arreCFieldElement = this.zs;
                int n2 = arreCFieldElement.length;
                bl = false;
                if (n2 <= 0) break block3;
                boolean bl2 = arreCFieldElement[0].isZero();
                bl = false;
                if (!bl2) break block3;
            }
            bl = true;
        }
        return bl;
    }

    public boolean isNormalized() {
        boolean bl;
        block3 : {
            block2 : {
                int n2 = this.getCurveCoordinateSystem();
                if (n2 == 0 || n2 == 5 || this.isInfinity()) break block2;
                boolean bl2 = this.zs[0].isOne();
                bl = false;
                if (!bl2) break block3;
            }
            bl = true;
        }
        return bl;
    }

    public abstract ECPoint negate();

    public ECPoint normalize() {
        if (this.isInfinity()) {
            return this;
        }
        int n2 = this.getCurveCoordinateSystem();
        if (n2 != 0 && n2 != 5) {
            ECFieldElement eCFieldElement = this.getZCoord(0);
            if (eCFieldElement.isOne()) {
                return this;
            }
            if (this.curve != null) {
                SecureRandom secureRandom = CryptoServicesRegistrar.getSecureRandom();
                ECFieldElement eCFieldElement2 = this.curve.randomFieldElementMult(secureRandom);
                return this.normalize(eCFieldElement.multiply(eCFieldElement2).invert().multiply(eCFieldElement2));
            }
            throw new IllegalStateException("Detached points must be in affine coordinates");
        }
        return this;
    }

    public ECPoint normalize(ECFieldElement eCFieldElement) {
        int n2 = this.getCurveCoordinateSystem();
        if (n2 != 1) {
            if (n2 != 2 && n2 != 3 && n2 != 4) {
                if (n2 != 6) {
                    throw new IllegalStateException("not a projective coordinate system");
                }
            } else {
                ECFieldElement eCFieldElement2 = eCFieldElement.square();
                ECFieldElement eCFieldElement3 = eCFieldElement2.multiply(eCFieldElement);
                return this.curve.createRawPoint(this.x.multiply(eCFieldElement2), this.y.multiply(eCFieldElement3));
            }
        }
        return this.curve.createRawPoint(this.x.multiply(eCFieldElement), this.y.multiply(eCFieldElement));
    }

    public abstract boolean satisfiesCurveEquation();

    public boolean satisfiesOrder() {
        boolean bl = ECConstants.ONE.equals((Object)this.curve.cofactor);
        int n2 = 1;
        if (bl) {
            return (boolean)n2;
        }
        BigInteger bigInteger = this.curve.order;
        if (bigInteger != null) {
            BigInteger bigInteger2 = bigInteger.abs();
            ECPoint eCPoint = this.curve.getInfinity();
            int n3 = bigInteger2.bitLength();
            if (n3 > 0) {
                if (bigInteger2.testBit(0)) {
                    eCPoint = this;
                }
                ECPoint eCPoint2 = this;
                for (int i2 = n2; i2 < n3; ++i2) {
                    eCPoint2 = eCPoint2.twice();
                    if (!bigInteger2.testBit(i2)) continue;
                    eCPoint = eCPoint.add(eCPoint2);
                }
            }
            if (bigInteger.signum() < 0) {
                eCPoint = eCPoint.negate();
            }
            if (eCPoint.isInfinity()) {
                return (boolean)n2;
            }
            n2 = 0;
        }
        return (boolean)n2;
    }

    public abstract ECPoint subtract(ECPoint var1);

    public ECPoint timesPow2(int n2) {
        if (n2 >= 0) {
            ECPoint eCPoint = this;
            while (--n2 >= 0) {
                eCPoint = eCPoint.twice();
            }
            return eCPoint;
        }
        throw new IllegalArgumentException("'e' cannot be negative");
    }

    public String toString() {
        if (this.isInfinity()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append((Object)this.x);
        stringBuffer.append(',');
        stringBuffer.append((Object)this.y);
        for (int i2 = 0; i2 < this.zs.length; ++i2) {
            stringBuffer.append(',');
            stringBuffer.append((Object)this.zs[i2]);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public abstract ECPoint twice();

    public ECPoint twicePlus(ECPoint eCPoint) {
        return this.twice().add(eCPoint);
    }
}

