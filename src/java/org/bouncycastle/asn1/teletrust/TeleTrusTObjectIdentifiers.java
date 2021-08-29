/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 */
package org.bouncycastle.asn1.teletrust;

import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface TeleTrusTObjectIdentifiers {
    public static final ASN1ObjectIdentifier brainpoolP160r1;
    public static final ASN1ObjectIdentifier brainpoolP160t1;
    public static final ASN1ObjectIdentifier brainpoolP192r1;
    public static final ASN1ObjectIdentifier brainpoolP192t1;
    public static final ASN1ObjectIdentifier brainpoolP224r1;
    public static final ASN1ObjectIdentifier brainpoolP224t1;
    public static final ASN1ObjectIdentifier brainpoolP256r1;
    public static final ASN1ObjectIdentifier brainpoolP256t1;
    public static final ASN1ObjectIdentifier brainpoolP320r1;
    public static final ASN1ObjectIdentifier brainpoolP320t1;
    public static final ASN1ObjectIdentifier brainpoolP384r1;
    public static final ASN1ObjectIdentifier brainpoolP384t1;
    public static final ASN1ObjectIdentifier brainpoolP512r1;
    public static final ASN1ObjectIdentifier brainpoolP512t1;
    public static final ASN1ObjectIdentifier ecSign;
    public static final ASN1ObjectIdentifier ecSignWithRipemd160;
    public static final ASN1ObjectIdentifier ecSignWithSha1;
    public static final ASN1ObjectIdentifier ecc_brainpool;
    public static final ASN1ObjectIdentifier ellipticCurve;
    public static final ASN1ObjectIdentifier teleTrusTAlgorithm;
    public static final ASN1ObjectIdentifier teleTrusTRSAsignatureAlgorithm;
    public static final ASN1ObjectIdentifier versionOne;

    public static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6;
        teleTrusTAlgorithm = aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("1.3.36.3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "2.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "2.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "2.3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        teleTrusTRSAsignatureAlgorithm = aSN1ObjectIdentifier = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "3.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        ecSign = aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "3.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        ecSignWithSha1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        ecSignWithRipemd160 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        ecc_brainpool = aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "3.2.8");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        ellipticCurve = aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        versionOne = aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP160r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP160t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP192r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP192t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP224r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "5");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP224t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "6");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP256r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "7");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP256t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "8");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP320r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "9");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP320t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "10");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP384r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "11");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP384t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "12");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP512r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "13");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        brainpoolP512t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "14");
    }
}

