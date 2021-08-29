/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.math.BigInteger
 *  java.security.spec.AlgorithmParameterSpec
 */
package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class ECParameterSpec
implements AlgorithmParameterSpec {
    public ECPoint G;
    public ECCurve curve;
    public BigInteger h;
    public BigInteger n;
    public byte[] seed;

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] arrby) {
        this.curve = eCCurve;
        this.G = eCPoint.normalize();
        this.n = bigInteger;
        this.h = bigInteger2;
        this.seed = arrby;
    }

    public boolean equals(Object object) {
        if (!(object instanceof ECParameterSpec)) {
            return false;
        }
        ECParameterSpec eCParameterSpec = (ECParameterSpec)object;
        boolean bl = this.curve.equals(eCParameterSpec.curve);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = this.G.equals(eCParameterSpec.G);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        return this.curve.hashCode() ^ this.G.hashCode();
    }
}

