/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 */
package org.bouncycastle.asn1.sec;

import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

public interface SECObjectIdentifiers {
    public static final ASN1ObjectIdentifier dhSinglePass_cofactorDH_sha224kdf_scheme;
    public static final ASN1ObjectIdentifier dhSinglePass_cofactorDH_sha256kdf_scheme;
    public static final ASN1ObjectIdentifier dhSinglePass_cofactorDH_sha384kdf_scheme;
    public static final ASN1ObjectIdentifier dhSinglePass_cofactorDH_sha512kdf_scheme;
    public static final ASN1ObjectIdentifier dhSinglePass_stdDH_sha224kdf_scheme;
    public static final ASN1ObjectIdentifier dhSinglePass_stdDH_sha256kdf_scheme;
    public static final ASN1ObjectIdentifier dhSinglePass_stdDH_sha384kdf_scheme;
    public static final ASN1ObjectIdentifier dhSinglePass_stdDH_sha512kdf_scheme;
    public static final ASN1ObjectIdentifier ellipticCurve;
    public static final ASN1ObjectIdentifier mqvSinglePass_sha224kdf_scheme;
    public static final ASN1ObjectIdentifier mqvSinglePass_sha256kdf_scheme;
    public static final ASN1ObjectIdentifier mqvSinglePass_sha384kdf_scheme;
    public static final ASN1ObjectIdentifier mqvSinglePass_sha512kdf_scheme;
    public static final ASN1ObjectIdentifier secg_scheme;
    public static final ASN1ObjectIdentifier secp112r1;
    public static final ASN1ObjectIdentifier secp112r2;
    public static final ASN1ObjectIdentifier secp128r1;
    public static final ASN1ObjectIdentifier secp128r2;
    public static final ASN1ObjectIdentifier secp160k1;
    public static final ASN1ObjectIdentifier secp160r1;
    public static final ASN1ObjectIdentifier secp160r2;
    public static final ASN1ObjectIdentifier secp192k1;
    public static final ASN1ObjectIdentifier secp192r1;
    public static final ASN1ObjectIdentifier secp224k1;
    public static final ASN1ObjectIdentifier secp224r1;
    public static final ASN1ObjectIdentifier secp256k1;
    public static final ASN1ObjectIdentifier secp256r1;
    public static final ASN1ObjectIdentifier secp384r1;
    public static final ASN1ObjectIdentifier secp521r1;
    public static final ASN1ObjectIdentifier sect113r1;
    public static final ASN1ObjectIdentifier sect113r2;
    public static final ASN1ObjectIdentifier sect131r1;
    public static final ASN1ObjectIdentifier sect131r2;
    public static final ASN1ObjectIdentifier sect163k1;
    public static final ASN1ObjectIdentifier sect163r1;
    public static final ASN1ObjectIdentifier sect163r2;
    public static final ASN1ObjectIdentifier sect193r1;
    public static final ASN1ObjectIdentifier sect193r2;
    public static final ASN1ObjectIdentifier sect233k1;
    public static final ASN1ObjectIdentifier sect233r1;
    public static final ASN1ObjectIdentifier sect239k1;
    public static final ASN1ObjectIdentifier sect283k1;
    public static final ASN1ObjectIdentifier sect283r1;
    public static final ASN1ObjectIdentifier sect409k1;
    public static final ASN1ObjectIdentifier sect409r1;
    public static final ASN1ObjectIdentifier sect571k1;
    public static final ASN1ObjectIdentifier sect571r1;

    public static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2;
        ellipticCurve = aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.3.132.0");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect163k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect163r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect239k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect113r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "4");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect113r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "5");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        secp112r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "6");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        secp112r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "7");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        secp160r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "8");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        secp160k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "9");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        secp256k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "10");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect163r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "15");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect283k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "16");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect283r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "17");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect131r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "22");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect131r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "23");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect193r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "24");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect193r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "25");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect233k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "26");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect233r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "27");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        secp128r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "28");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        secp128r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "29");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        secp160r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "30");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        secp192k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "31");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        secp224k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "32");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        secp224r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "33");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        secp384r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "34");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        secp521r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "35");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect409k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "36");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect409r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "37");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect571k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "38");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        sect571r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "39");
        secp192r1 = X9ObjectIdentifiers.prime192v1;
        secp256r1 = X9ObjectIdentifiers.prime256v1;
        secg_scheme = aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.132.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        dhSinglePass_stdDH_sha224kdf_scheme = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "11.0");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        dhSinglePass_stdDH_sha256kdf_scheme = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "11.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        dhSinglePass_stdDH_sha384kdf_scheme = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "11.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        dhSinglePass_stdDH_sha512kdf_scheme = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "11.3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        dhSinglePass_cofactorDH_sha224kdf_scheme = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "14.0");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        dhSinglePass_cofactorDH_sha256kdf_scheme = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "14.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        dhSinglePass_cofactorDH_sha384kdf_scheme = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "14.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        dhSinglePass_cofactorDH_sha512kdf_scheme = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "14.3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        mqvSinglePass_sha224kdf_scheme = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "15.0");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        mqvSinglePass_sha256kdf_scheme = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "15.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        mqvSinglePass_sha384kdf_scheme = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "15.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        mqvSinglePass_sha512kdf_scheme = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "15.3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "16.0");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "16.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "16.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "16.3");
    }
}

