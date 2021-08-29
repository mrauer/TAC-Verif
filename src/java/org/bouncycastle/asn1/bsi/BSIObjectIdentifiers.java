/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 */
package org.bouncycastle.asn1.bsi;

import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface BSIObjectIdentifiers {
    public static final ASN1ObjectIdentifier bsi_de;
    public static final ASN1ObjectIdentifier ecdsa_plain_RIPEMD160;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA1;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA224;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA256;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA384;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA512;
    public static final ASN1ObjectIdentifier ecdsa_plain_signatures;
    public static final ASN1ObjectIdentifier ecka_eg;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_RIPEMD160;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA1;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA224;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA256;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA384;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA512;
    public static final ASN1ObjectIdentifier id_ecc;

    public static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6;
        bsi_de = aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("0.4.0.127.0.7");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        id_ecc = aSN1ObjectIdentifier = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "1.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        ecdsa_plain_signatures = aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "4.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        ecdsa_plain_SHA1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        ecdsa_plain_SHA224 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        ecdsa_plain_SHA256 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        ecdsa_plain_SHA384 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        ecdsa_plain_SHA512 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "5");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        ecdsa_plain_RIPEMD160 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "6");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        ecka_eg = aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "5.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        ecka_eg_X963kdf = aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        ecka_eg_X963kdf_SHA1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        ecka_eg_X963kdf_SHA224 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        ecka_eg_X963kdf_SHA256 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        ecka_eg_X963kdf_SHA384 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        ecka_eg_X963kdf_SHA512 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "5");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        ecka_eg_X963kdf_RIPEMD160 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "6");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        ecka_eg_SessionKDF = aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "4");
    }
}

