/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.math.BigInteger
 */
package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class ECNamedDomainParameters
extends ECDomainParameters {
    public ASN1ObjectIdentifier name;

    public ECNamedDomainParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, X9ECParameters x9ECParameters) {
        super(x9ECParameters.curve, x9ECParameters.getG(), x9ECParameters.n, x9ECParameters.h, x9ECParameters.getSeed());
        this.name = aSN1ObjectIdentifier;
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] arrby) {
        super(eCCurve, eCPoint, bigInteger, bigInteger2, arrby);
        this.name = aSN1ObjectIdentifier;
    }
}

