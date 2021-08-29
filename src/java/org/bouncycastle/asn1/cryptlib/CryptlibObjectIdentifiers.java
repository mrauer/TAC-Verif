/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 */
package org.bouncycastle.asn1.cryptlib;

import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public class CryptlibObjectIdentifiers {
    public static final ASN1ObjectIdentifier cryptlib;
    public static final ASN1ObjectIdentifier curvey25519;
    public static final ASN1ObjectIdentifier ecc;

    public static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2;
        cryptlib = aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.3.6.1.4.1.3029");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        ecc = aSN1ObjectIdentifier = new ASN1ObjectIdentifier(new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1"), "5");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        curvey25519 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1");
    }
}

