/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.params.DHValidationParameters;
import org.bouncycastle.util.Properties;

public class DHParameters {
    public BigInteger g;
    public BigInteger p;
    public BigInteger q;

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int n2, int n3, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        if (n3 != 0) {
            if (n3 <= bigInteger.bitLength()) {
                if (n3 < n2) {
                    throw new IllegalArgumentException("when l value specified, it may not be less than m value");
                }
            } else {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            }
        }
        if (n2 > bigInteger.bitLength() && !Properties.isOverrideSet("org.bouncycastle.dh.allow_unsafe_p_value")) {
            throw new IllegalArgumentException("unsafe p value so small specific l required");
        }
        this.g = bigInteger2;
        this.p = bigInteger;
        this.q = bigInteger3;
    }

    public boolean equals(Object object) {
        if (!(object instanceof DHParameters)) {
            return false;
        }
        DHParameters dHParameters = (DHParameters)object;
        BigInteger bigInteger = this.q;
        if (bigInteger != null ? !bigInteger.equals((Object)dHParameters.q) : dHParameters.q != null) {
            return false;
        }
        boolean bl = dHParameters.p.equals((Object)this.p);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = dHParameters.g.equals((Object)this.g);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n2 = this.p.hashCode() ^ this.g.hashCode();
        BigInteger bigInteger = this.q;
        int n3 = bigInteger != null ? bigInteger.hashCode() : 0;
        return n2 ^ n3;
    }
}

