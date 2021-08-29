/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 */
package org.bouncycastle.asn1.bc;

import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface BCObjectIdentifiers {
    public static final ASN1ObjectIdentifier bc;
    public static final ASN1ObjectIdentifier bc_exch;
    public static final ASN1ObjectIdentifier bc_ext;
    public static final ASN1ObjectIdentifier bc_pbe;
    public static final ASN1ObjectIdentifier bc_pbe_sha1;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12;
    public static final ASN1ObjectIdentifier bc_pbe_sha256;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12;
    public static final ASN1ObjectIdentifier bc_sig;
    public static final ASN1ObjectIdentifier newHope;
    public static final ASN1ObjectIdentifier qTESLA;
    public static final ASN1ObjectIdentifier qTESLA_p_I;
    public static final ASN1ObjectIdentifier qTESLA_p_III;
    public static final ASN1ObjectIdentifier sphincs256;
    public static final ASN1ObjectIdentifier sphincs256_with_BLAKE512;
    public static final ASN1ObjectIdentifier sphincs256_with_SHA3_512;
    public static final ASN1ObjectIdentifier sphincs256_with_SHA512;
    public static final ASN1ObjectIdentifier xmss;
    public static final ASN1ObjectIdentifier xmss_SHA256;
    public static final ASN1ObjectIdentifier xmss_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_SHA512;
    public static final ASN1ObjectIdentifier xmss_SHA512ph;
    public static final ASN1ObjectIdentifier xmss_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_SHAKE128ph;
    public static final ASN1ObjectIdentifier xmss_SHAKE256;
    public static final ASN1ObjectIdentifier xmss_SHAKE256ph;
    public static final ASN1ObjectIdentifier xmss_mt;
    public static final ASN1ObjectIdentifier xmss_mt_SHA256;
    public static final ASN1ObjectIdentifier xmss_mt_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHA512;
    public static final ASN1ObjectIdentifier xmss_mt_SHA512ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE128ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE256;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE256ph;

    public static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13;
        bc = aSN1ObjectIdentifier13 = new ASN1ObjectIdentifier("1.3.6.1.4.1.22554");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier13);
        bc_pbe = aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier13, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier8);
        bc_pbe_sha1 = aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier8);
        bc_pbe_sha256 = aSN1ObjectIdentifier = new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "2.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier8);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "2.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier8);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "2.3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier8);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "2.4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier9);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier9, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier9);
        bc_pbe_sha1_pkcs12 = aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier9, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        bc_pbe_sha256_pkcs12 = aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "1.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "1.22");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "1.42");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier7);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier7, "1.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier7);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier7, "1.22");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier7);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier7, "1.42");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier13);
        bc_sig = aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier13, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        sphincs256 = aSN1ObjectIdentifier11 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier11);
        sphincs256_with_BLAKE512 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier11, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier11);
        sphincs256_with_SHA512 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier11, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier11);
        sphincs256_with_SHA3_512 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier11, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        xmss = aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        xmss_SHA256ph = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        xmss_SHA512ph = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        xmss_SHAKE128ph = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        xmss_SHAKE256ph = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        xmss_SHA256 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "5");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        xmss_SHA512 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "6");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        xmss_SHAKE128 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "7");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier6);
        xmss_SHAKE256 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "8");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        xmss_mt = aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier12);
        xmss_mt_SHA256ph = new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier12);
        xmss_mt_SHA512ph = new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier12);
        xmss_mt_SHAKE128ph = new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier12);
        xmss_mt_SHAKE256ph = new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier12);
        xmss_mt_SHA256 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "5");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier12);
        xmss_mt_SHA512 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "6");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier12);
        xmss_mt_SHAKE128 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "7");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier12);
        xmss_mt_SHAKE256 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "8");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        qTESLA = aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "5");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        qTESLA_p_I = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "11");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        qTESLA_p_III = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "12");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier13);
        bc_exch = aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier13, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        newHope = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier13);
        bc_ext = aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier13, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier10);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier10, "1");
    }
}

