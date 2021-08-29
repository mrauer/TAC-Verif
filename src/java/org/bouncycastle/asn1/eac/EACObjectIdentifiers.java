/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 */
package org.bouncycastle.asn1.eac;

import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface EACObjectIdentifiers {
    public static final ASN1ObjectIdentifier bsi_de;
    public static final ASN1ObjectIdentifier id_CA;
    public static final ASN1ObjectIdentifier id_CA_DH;
    public static final ASN1ObjectIdentifier id_CA_ECDH;
    public static final ASN1ObjectIdentifier id_PK;
    public static final ASN1ObjectIdentifier id_TA;
    public static final ASN1ObjectIdentifier id_TA_ECDSA;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_1;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_224;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_256;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_384;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_512;
    public static final ASN1ObjectIdentifier id_TA_RSA;

    public static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8;
        bsi_de = aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier("0.4.0.127.0.7");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier8);
        id_PK = aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "2.2.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier8);
        id_CA = aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "2.2.3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier7);
        id_CA_DH = aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier7, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier7);
        id_CA_ECDH = aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier7, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier8);
        id_TA = aSN1ObjectIdentifier = new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "2.2.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        id_TA_RSA = aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "5");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "6");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        id_TA_ECDSA = aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        id_TA_ECDSA_SHA_1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        id_TA_ECDSA_SHA_224 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        id_TA_ECDSA_SHA_256 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        id_TA_ECDSA_SHA_384 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        id_TA_ECDSA_SHA_512 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "5");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier8);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "3.1.2.1");
    }
}

