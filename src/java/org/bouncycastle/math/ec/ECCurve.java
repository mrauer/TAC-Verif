/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.math.BigInteger
 *  java.security.SecureRandom
 *  java.util.Hashtable
 *  org.bouncycastle.math.ec.ECCurve$1
 *  org.bouncycastle.math.ec.ECFieldElement
 */
package org.bouncycastle.math.ec;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.AbstractECMultiplier;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompCallback;
import org.bouncycastle.math.ec.PreCompInfo;
import org.bouncycastle.math.ec.endo.GLVTypeBEndomorphism;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.util.BigIntegers;

public abstract class ECCurve {
    public ECFieldElement a;
    public ECFieldElement b;
    public BigInteger cofactor;
    public int coord = 0;
    public GLVTypeBEndomorphism endomorphism = null;
    public FiniteField field;
    public AbstractECMultiplier multiplier = null;
    public BigInteger order;

    public ECCurve(FiniteField finiteField) {
        this.field = finiteField;
    }

    public abstract ECCurve cloneCurve();

    public Config configure() {
        ECCurve eCCurve = this;
        synchronized (eCCurve) {
            Config config = new Config(this.coord, this.endomorphism, this.multiplier);
            return config;
        }
    }

    public AbstractECLookupTable createCacheSafeLookupTable(ECPoint[] arreCPoint, int n2, int n3) {
        int n4 = 7 + this.getFieldSize() >>> 3;
        byte[] arrby = new byte[2 * (n3 * n4)];
        int n5 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            ECPoint eCPoint = arreCPoint[n2 + i2];
            byte[] arrby2 = eCPoint.x.toBigInteger().toByteArray();
            byte[] arrby3 = eCPoint.y.toBigInteger().toByteArray();
            int n6 = arrby2.length;
            int n7 = 1;
            int n8 = n6 > n4 ? n7 : 0;
            int n9 = arrby2.length - n8;
            if (arrby3.length <= n4) {
                n7 = 0;
            }
            int n10 = arrby3.length - n7;
            int n11 = n5 + n4;
            System.arraycopy((Object)arrby2, (int)n8, (Object)arrby, (int)(n11 - n9), (int)n9);
            n5 = n11 + n4;
            System.arraycopy((Object)arrby3, (int)n7, (Object)arrby, (int)(n5 - n10), (int)n10);
        }
        return new 1(this, n3, n4, arrby);
    }

    public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2) {
        return this.createRawPoint(this.fromBigInteger(bigInteger), this.fromBigInteger(bigInteger2));
    }

    public abstract ECPoint createRawPoint(ECFieldElement var1, ECFieldElement var2);

    public ECPoint decodePoint(byte[] arrby) {
        block17 : {
            byte by;
            ECPoint eCPoint;
            block14 : {
                block9 : {
                    block16 : {
                        int n2;
                        block10 : {
                            block15 : {
                                block11 : {
                                    block12 : {
                                        block13 : {
                                            n2 = (7 + this.getFieldSize()) / 8;
                                            by = arrby[0];
                                            if (by == 0) break block9;
                                            if (by == 2 || by == 3) break block10;
                                            if (by == 4) break block11;
                                            if (by != 6 && by != 7) {
                                                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Invalid point encoding 0x");
                                                stringBuilder.append(Integer.toString((int)by, (int)16));
                                                throw new IllegalArgumentException(stringBuilder.toString());
                                            }
                                            if (arrby.length != 1 + n2 * 2) break block12;
                                            BigInteger bigInteger = BigIntegers.fromUnsignedByteArray(arrby, 1, n2);
                                            BigInteger bigInteger2 = BigIntegers.fromUnsignedByteArray(arrby, n2 + 1, n2);
                                            boolean bl = bigInteger2.testBit(0);
                                            boolean bl2 = false;
                                            if (by == 7) {
                                                bl2 = true;
                                            }
                                            if (bl != bl2) break block13;
                                            eCPoint = this.validatePoint(bigInteger, bigInteger2);
                                            break block14;
                                        }
                                        throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                                    }
                                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                                }
                                if (arrby.length != 1 + n2 * 2) break block15;
                                eCPoint = this.validatePoint(BigIntegers.fromUnsignedByteArray(arrby, 1, n2), BigIntegers.fromUnsignedByteArray(arrby, n2 + 1, n2));
                                break block14;
                            }
                            throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
                        }
                        if (arrby.length != n2 + 1) break block16;
                        eCPoint = this.decompressPoint(by & 1, BigIntegers.fromUnsignedByteArray(arrby, 1, n2));
                        if (!eCPoint.implIsValid(true, true)) {
                            throw new IllegalArgumentException("Invalid point");
                        }
                        break block14;
                    }
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
                if (arrby.length != 1) break block17;
                eCPoint = this.getInfinity();
            }
            if (by != 0) {
                if (!eCPoint.isInfinity()) {
                    return eCPoint;
                }
                throw new IllegalArgumentException("Invalid infinity encoding");
            }
            return eCPoint;
        }
        throw new IllegalArgumentException("Incorrect length for infinity encoding");
    }

    public abstract ECPoint decompressPoint(int var1, BigInteger var2);

    public boolean equals(Object object) {
        return this == object || object instanceof ECCurve && this.equals((ECCurve)object);
        {
        }
    }

    public boolean equals(ECCurve eCCurve) {
        return this == eCCurve || eCCurve != null && this.field.equals((Object)eCCurve.field) && this.a.toBigInteger().equals((Object)eCCurve.a.toBigInteger()) && this.b.toBigInteger().equals((Object)eCCurve.b.toBigInteger());
        {
        }
    }

    public abstract ECFieldElement fromBigInteger(BigInteger var1);

    public abstract int getFieldSize();

    public abstract ECPoint getInfinity();

    public int hashCode() {
        return this.field.hashCode() ^ Integer.rotateLeft((int)this.a.toBigInteger().hashCode(), (int)8) ^ Integer.rotateLeft((int)this.b.toBigInteger().hashCode(), (int)16);
    }

    public ECPoint importPoint(ECPoint eCPoint) {
        if (this == eCPoint.curve) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this.getInfinity();
        }
        ECPoint eCPoint2 = eCPoint.normalize();
        return this.createPoint(eCPoint2.x.toBigInteger(), eCPoint2.getYCoord().toBigInteger());
    }

    public void normalizeAll(ECPoint[] arreCPoint) {
        int n2 = arreCPoint.length;
        if (n2 >= 0 && arreCPoint.length - n2 >= 0) {
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                ECPoint eCPoint = arreCPoint[0 + i2];
                if (eCPoint == null || this == eCPoint.curve) continue;
                throw new IllegalArgumentException("'points' entries must be null or on this curve");
            }
            int n4 = this.coord;
            if (n4 != 0 && n4 != 5) {
                ECFieldElement[] arreCFieldElement = new ECFieldElement[n2];
                int[] arrn = new int[n2];
                int n5 = 0;
                for (int i3 = 0; i3 < n2; ++i3) {
                    int n6 = 0 + i3;
                    ECPoint eCPoint = arreCPoint[n6];
                    if (eCPoint == null || eCPoint.isNormalized()) continue;
                    arreCFieldElement[n5] = eCPoint.getZCoord(0);
                    int n7 = n5 + 1;
                    arrn[n5] = n6;
                    n5 = n7;
                }
                if (n5 == 0) {
                    return;
                }
                ECFieldElement[] arreCFieldElement2 = new ECFieldElement[n5];
                arreCFieldElement2[0] = arreCFieldElement[0];
                int n8 = 0;
                while (++n8 < n5) {
                    arreCFieldElement2[n8] = arreCFieldElement2[n8 - 1].multiply(arreCFieldElement[0 + n8]);
                }
                int n9 = n8 - 1;
                ECFieldElement eCFieldElement = arreCFieldElement2[n9].invert();
                while (n9 > 0) {
                    int n10 = n9 - 1;
                    int n11 = n9 + 0;
                    ECFieldElement eCFieldElement2 = arreCFieldElement[n11];
                    arreCFieldElement[n11] = arreCFieldElement2[n10].multiply(eCFieldElement);
                    eCFieldElement = eCFieldElement.multiply(eCFieldElement2);
                    n9 = n10;
                }
                arreCFieldElement[0] = eCFieldElement;
                while (n3 < n5) {
                    int n12 = arrn[n3];
                    arreCPoint[n12] = arreCPoint[n12].normalize(arreCFieldElement[n3]);
                    ++n3;
                }
            }
            return;
        }
        throw new IllegalArgumentException("invalid range specified for 'points'");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PreCompInfo precompute(ECPoint eCPoint, String string, PreCompCallback preCompCallback) {
        Hashtable hashtable;
        if (this != eCPoint.curve) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
        ECPoint eCPoint2 = eCPoint;
        synchronized (eCPoint2) {
            hashtable = eCPoint.preCompTable;
            if (hashtable == null) {
                eCPoint.preCompTable = hashtable = new Hashtable(4);
            }
        }
        Hashtable hashtable2 = hashtable;
        synchronized (hashtable2) {
            PreCompInfo preCompInfo = (PreCompInfo)hashtable.get((Object)string);
            PreCompInfo preCompInfo2 = preCompCallback.precompute(preCompInfo);
            if (preCompInfo2 != preCompInfo) {
                hashtable.put((Object)string, (Object)preCompInfo2);
            }
            return preCompInfo2;
        }
    }

    public abstract ECFieldElement randomFieldElementMult(SecureRandom var1);

    public boolean supportsCoordinateSystem(int n2) {
        return n2 == 0;
    }

    public ECPoint validatePoint(BigInteger bigInteger, BigInteger bigInteger2) {
        ECPoint eCPoint = this.createPoint(bigInteger, bigInteger2);
        if (eCPoint.implIsValid(false, true)) {
            return eCPoint;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }

    public class Config {
        public int coord;
        public GLVTypeBEndomorphism endomorphism;
        public AbstractECMultiplier multiplier;

        public Config(int n2, GLVTypeBEndomorphism gLVTypeBEndomorphism, AbstractECMultiplier abstractECMultiplier) {
            this.coord = n2;
            this.endomorphism = gLVTypeBEndomorphism;
            this.multiplier = abstractECMultiplier;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public ECCurve create() {
            if (!ECCurve.this.supportsCoordinateSystem(this.coord)) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            ECCurve eCCurve = ECCurve.this.cloneCurve();
            if (eCCurve != ECCurve.this) {
                ECCurve eCCurve2 = eCCurve;
                synchronized (eCCurve2) {
                    eCCurve.coord = this.coord;
                    eCCurve.endomorphism = this.endomorphism;
                    eCCurve.multiplier = this.multiplier;
                    return eCCurve;
                }
            }
            throw new IllegalStateException("implementation returned current curve");
        }
    }

}

