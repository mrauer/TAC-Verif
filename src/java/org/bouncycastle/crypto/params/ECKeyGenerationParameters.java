/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.math.BigInteger
 *  java.security.SecureRandom
 *  org.bouncycastle.crypto.params.ECDomainParameters
 */
package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.ECDomainParameters;

public class ECKeyGenerationParameters {
    public ECDomainParameters domainParams;
    public SecureRandom random;

    public ECKeyGenerationParameters(ECDomainParameters eCDomainParameters, SecureRandom secureRandom) {
        eCDomainParameters.n.bitLength();
        if (secureRandom == null) {
            secureRandom = CryptoServicesRegistrar.getSecureRandom();
        }
        this.random = secureRandom;
        this.domainParams = eCDomainParameters;
    }
}

