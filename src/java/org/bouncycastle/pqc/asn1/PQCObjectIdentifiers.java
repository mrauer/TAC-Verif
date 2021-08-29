/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 */
package org.bouncycastle.pqc.asn1;

import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;

public interface PQCObjectIdentifiers {
    public static final ASN1ObjectIdentifier gmss;
    public static final ASN1ObjectIdentifier mcEliece;
    public static final ASN1ObjectIdentifier mcElieceCca2;
    public static final ASN1ObjectIdentifier newHope;
    public static final ASN1ObjectIdentifier qTESLA_p_I;
    public static final ASN1ObjectIdentifier qTESLA_p_III;
    public static final ASN1ObjectIdentifier rainbow;
    public static final ASN1ObjectIdentifier sphincs256;
    public static final ASN1ObjectIdentifier xmss;
    public static final ASN1ObjectIdentifier xmss_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_SHA512ph;
    public static final ASN1ObjectIdentifier xmss_SHAKE128ph;
    public static final ASN1ObjectIdentifier xmss_SHAKE256ph;
    public static final ASN1ObjectIdentifier xmss_mt;
    public static final ASN1ObjectIdentifier xmss_mt_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHA512ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE256;

    public static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2;
        rainbow = aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.5.3.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "5");
        gmss = aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "5");
        mcEliece = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
        mcElieceCca2 = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2");
        new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2.1");
        new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2.2");
        new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2.3");
        sphincs256 = BCObjectIdentifiers.sphincs256;
        newHope = BCObjectIdentifiers.newHope;
        xmss = BCObjectIdentifiers.xmss;
        xmss_SHA256ph = BCObjectIdentifiers.xmss_SHA256ph;
        xmss_SHA512ph = BCObjectIdentifiers.xmss_SHA512ph;
        xmss_SHAKE128ph = BCObjectIdentifiers.xmss_SHAKE128ph;
        xmss_SHAKE256ph = BCObjectIdentifiers.xmss_SHAKE256ph;
        xmss_mt = BCObjectIdentifiers.xmss_mt;
        xmss_mt_SHA256ph = BCObjectIdentifiers.xmss_mt_SHA256ph;
        xmss_mt_SHA512ph = BCObjectIdentifiers.xmss_mt_SHA512ph;
        xmss_mt_SHAKE128 = BCObjectIdentifiers.xmss_mt_SHAKE128;
        xmss_mt_SHAKE256 = BCObjectIdentifiers.xmss_mt_SHAKE256;
        qTESLA_p_I = BCObjectIdentifiers.qTESLA_p_I;
        qTESLA_p_III = BCObjectIdentifiers.qTESLA_p_III;
    }
}

