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
import org.bouncycastle.crypto.params.DSAKeyParameters;
import org.bouncycastle.crypto.params.DSAParameters;

public class DSAPublicKeyParameters
extends DSAKeyParameters {
    public static final BigInteger ONE = BigInteger.valueOf((long)1L);
    public static final BigInteger TWO = BigInteger.valueOf((long)2L);
    public BigInteger y;

    public DSAPublicKeyParameters(BigInteger bigInteger, DSAParameters dSAParameters) {
        super(false, dSAParameters);
        BigInteger bigInteger2 = TWO;
        if (bigInteger2.compareTo(bigInteger) <= 0 && dSAParameters.p.subtract(bigInteger2).compareTo(bigInteger) >= 0 && ONE.equals((Object)bigInteger.modPow(dSAParameters.q, dSAParameters.p))) {
            this.y = bigInteger;
            return;
        }
        throw new IllegalArgumentException("y value does not appear to be in correct group");
    }
}

