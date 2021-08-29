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
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.math.ec.ECConstants;

public class ECPrivateKeyParameters
extends ECKeyParameters {
    public final BigInteger d;

    public ECPrivateKeyParameters(BigInteger bigInteger, ECDomainParameters eCDomainParameters) {
        super(true, eCDomainParameters);
        Objects.requireNonNull((Object)eCDomainParameters);
        if (bigInteger.compareTo(ECConstants.ONE) >= 0 && bigInteger.compareTo(eCDomainParameters.n) < 0) {
            this.d = bigInteger;
            return;
        }
        throw new IllegalArgumentException("Scalar is not in the interval [1, n - 1]");
    }
}

