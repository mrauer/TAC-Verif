/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 */
package org.bouncycastle.asn1.rosstandart;

import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface RosstandartObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_tc26;
    public static final ASN1ObjectIdentifier id_tc26_agreement;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_256_paramSet;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_256_paramSetA;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSet;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSetA;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSetB;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSetC;
    public static final ASN1ObjectIdentifier rosstandart;

    public static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5;
        rosstandart = aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("1.2.643.7");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier5);
        id_tc26 = aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1.2.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1.2.3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1.4.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1.4.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1.1.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1.1.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1.3.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1.3.3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        id_tc26_agreement = aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1.6");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier3);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        id_tc26_gost_3410_12_256_paramSet = aSN1ObjectIdentifier = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "2.1.1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier);
        id_tc26_gost_3410_12_256_paramSetA = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        id_tc26_gost_3410_12_512_paramSet = aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "2.1.2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        id_tc26_gost_3410_12_512_paramSetA = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "1");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        id_tc26_gost_3410_12_512_paramSetB = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "2");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier4);
        id_tc26_gost_3410_12_512_paramSetC = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "3");
        Objects.requireNonNull((Object)aSN1ObjectIdentifier2);
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "2.5.1.1");
    }
}

