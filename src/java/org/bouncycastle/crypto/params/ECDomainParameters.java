/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.Objects
 */
package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.util.Objects;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat576;

public class ECDomainParameters
implements ECConstants {
    public final ECPoint G;
    public final ECCurve curve;
    public final BigInteger h;
    public final BigInteger n;
    public final byte[] seed;

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, eCPoint, bigInteger, bigInteger2, null);
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] arrby) {
        Objects.requireNonNull((Object)eCCurve, (String)"curve");
        Objects.requireNonNull((Object)bigInteger, (String)"n");
        this.curve = eCCurve;
        this.G = ECDomainParameters.validatePublicPoint(eCCurve, eCPoint);
        this.n = bigInteger;
        this.h = bigInteger2;
        this.seed = Nat576.clone(arrby);
    }

    public static ECPoint validatePublicPoint(ECCurve eCCurve, ECPoint eCPoint) {
        Objects.requireNonNull((Object)eCPoint, (String)"Point cannot be null");
        if (eCCurve.equals(eCPoint.curve)) {
            ECPoint eCPoint2 = eCCurve.importPoint(eCPoint).normalize();
            if (!eCPoint2.isInfinity()) {
                if (eCPoint2.implIsValid(false, true)) {
                    return eCPoint2;
                }
                throw new IllegalArgumentException("Point not on curve");
            }
            throw new IllegalArgumentException("Point at infinity");
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ECDomainParameters)) {
            return false;
        }
        ECDomainParameters eCDomainParameters = (ECDomainParameters)object;
        return this.curve.equals(eCDomainParameters.curve) && this.G.equals(eCDomainParameters.G) && this.n.equals((Object)eCDomainParameters.n);
    }

    public byte[] getSeed() {
        return Nat576.clone(this.seed);
    }

    public int hashCode() {
        return 257 * (257 * (1028 ^ this.curve.hashCode()) ^ this.G.hashCode()) ^ this.n.hashCode();
    }
}

