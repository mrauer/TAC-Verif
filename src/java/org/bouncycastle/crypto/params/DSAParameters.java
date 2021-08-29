/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.math.BigInteger
 */
package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.params.DSAValidationParameters;

public class DSAParameters {
    public BigInteger g;
    public BigInteger p;
    public BigInteger q;
    public DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.g = bigInteger3;
        this.p = bigInteger;
        this.q = bigInteger2;
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.g = bigInteger3;
        this.p = bigInteger;
        this.q = bigInteger2;
        this.validation = dSAValidationParameters;
    }

    public boolean equals(Object object) {
        if (!(object instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters)object;
        boolean bl = dSAParameters.p.equals((Object)this.p);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = dSAParameters.q.equals((Object)this.q);
            bl2 = false;
            if (bl3) {
                boolean bl4 = dSAParameters.g.equals((Object)this.g);
                bl2 = false;
                if (bl4) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    public int hashCode() {
        return this.p.hashCode() ^ this.q.hashCode() ^ this.g.hashCode();
    }
}

