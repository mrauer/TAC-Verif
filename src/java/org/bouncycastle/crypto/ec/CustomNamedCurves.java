/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Hashtable
 *  java.util.Vector
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.x9.X9ECParameters
 *  org.bouncycastle.asn1.x9.X9ECPoint
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$1
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$10
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$11
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$12
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$13
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$14
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$15
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$16
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$17
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$18
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$19
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$2
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$20
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$21
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$22
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$23
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$24
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$25
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$26
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$27
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$28
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$29
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$3
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$30
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$31
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$32
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$4
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$5
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$6
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$7
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$8
 *  org.bouncycastle.crypto.ec.CustomNamedCurves$9
 */
package org.bouncycastle.crypto.ec;

import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptlib.CryptlibObjectIdentifiers;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.math.ec.endo.GLVTypeBEndomorphism;
import org.bouncycastle.math.ec.endo.GLVTypeBParameters;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class CustomNamedCurves {
    public static X9ECParametersHolder curve25519 = new 1();
    public static final Hashtable nameToCurve;
    public static final Hashtable nameToOID;
    public static final Vector names;
    public static final Hashtable oidToCurve;
    public static final Hashtable oidToName;
    public static X9ECParametersHolder secp128r1;
    public static X9ECParametersHolder secp160k1;
    public static X9ECParametersHolder secp160r1;
    public static X9ECParametersHolder secp160r2;
    public static X9ECParametersHolder secp192k1;
    public static X9ECParametersHolder secp192r1;
    public static X9ECParametersHolder secp224k1;
    public static X9ECParametersHolder secp224r1;
    public static X9ECParametersHolder secp256k1;
    public static X9ECParametersHolder secp256r1;
    public static X9ECParametersHolder secp384r1;
    public static X9ECParametersHolder secp521r1;
    public static X9ECParametersHolder sect113r1;
    public static X9ECParametersHolder sect113r2;
    public static X9ECParametersHolder sect131r1;
    public static X9ECParametersHolder sect131r2;
    public static X9ECParametersHolder sect163k1;
    public static X9ECParametersHolder sect163r1;
    public static X9ECParametersHolder sect163r2;
    public static X9ECParametersHolder sect193r1;
    public static X9ECParametersHolder sect193r2;
    public static X9ECParametersHolder sect233k1;
    public static X9ECParametersHolder sect233r1;
    public static X9ECParametersHolder sect239k1;
    public static X9ECParametersHolder sect283k1;
    public static X9ECParametersHolder sect283r1;
    public static X9ECParametersHolder sect409k1;
    public static X9ECParametersHolder sect409r1;
    public static X9ECParametersHolder sect571k1;
    public static X9ECParametersHolder sect571r1;
    public static X9ECParametersHolder sm2p256v1;

    public static {
        secp128r1 = new 2();
        secp160k1 = new 3();
        secp160r1 = new 4();
        secp160r2 = new 5();
        secp192k1 = new 6();
        secp192r1 = new 7();
        secp224k1 = new 8();
        secp224r1 = new 9();
        secp256k1 = new 10();
        secp256r1 = new 11();
        secp384r1 = new 12();
        secp521r1 = new 13();
        sect113r1 = new 14();
        sect113r2 = new 15();
        sect131r1 = new 16();
        sect131r2 = new 17();
        sect163k1 = new 18();
        sect163r1 = new 19();
        sect163r2 = new 20();
        sect193r1 = new 21();
        sect193r2 = new 22();
        sect233k1 = new 23();
        sect233r1 = new 24();
        sect239k1 = new 25();
        sect283k1 = new 26();
        sect283r1 = new 27();
        sect409k1 = new 28();
        sect409r1 = new 29();
        sect571k1 = new 30();
        sect571r1 = new 31();
        sm2p256v1 = new 32();
        nameToCurve = new Hashtable();
        nameToOID = new Hashtable();
        oidToCurve = new Hashtable();
        oidToName = new Hashtable();
        names = new Vector();
        CustomNamedCurves.defineCurveWithOID("curve25519", CryptlibObjectIdentifiers.curvey25519, curve25519);
        CustomNamedCurves.defineCurveWithOID("secp128r1", SECObjectIdentifiers.secp128r1, secp128r1);
        CustomNamedCurves.defineCurveWithOID("secp160k1", SECObjectIdentifiers.secp160k1, secp160k1);
        CustomNamedCurves.defineCurveWithOID("secp160r1", SECObjectIdentifiers.secp160r1, secp160r1);
        CustomNamedCurves.defineCurveWithOID("secp160r2", SECObjectIdentifiers.secp160r2, secp160r2);
        CustomNamedCurves.defineCurveWithOID("secp192k1", SECObjectIdentifiers.secp192k1, secp192k1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = SECObjectIdentifiers.secp192r1;
        CustomNamedCurves.defineCurveWithOID("secp192r1", aSN1ObjectIdentifier, secp192r1);
        CustomNamedCurves.defineCurveWithOID("secp224k1", SECObjectIdentifiers.secp224k1, secp224k1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = SECObjectIdentifiers.secp224r1;
        CustomNamedCurves.defineCurveWithOID("secp224r1", aSN1ObjectIdentifier2, secp224r1);
        CustomNamedCurves.defineCurveWithOID("secp256k1", SECObjectIdentifiers.secp256k1, secp256k1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = SECObjectIdentifiers.secp256r1;
        CustomNamedCurves.defineCurveWithOID("secp256r1", aSN1ObjectIdentifier3, secp256r1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = SECObjectIdentifiers.secp384r1;
        CustomNamedCurves.defineCurveWithOID("secp384r1", aSN1ObjectIdentifier4, secp384r1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = SECObjectIdentifiers.secp521r1;
        CustomNamedCurves.defineCurveWithOID("secp521r1", aSN1ObjectIdentifier5, secp521r1);
        CustomNamedCurves.defineCurveWithOID("sect113r1", SECObjectIdentifiers.sect113r1, sect113r1);
        CustomNamedCurves.defineCurveWithOID("sect113r2", SECObjectIdentifiers.sect113r2, sect113r2);
        CustomNamedCurves.defineCurveWithOID("sect131r1", SECObjectIdentifiers.sect131r1, sect131r1);
        CustomNamedCurves.defineCurveWithOID("sect131r2", SECObjectIdentifiers.sect131r2, sect131r2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = SECObjectIdentifiers.sect163k1;
        CustomNamedCurves.defineCurveWithOID("sect163k1", aSN1ObjectIdentifier6, sect163k1);
        CustomNamedCurves.defineCurveWithOID("sect163r1", SECObjectIdentifiers.sect163r1, sect163r1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = SECObjectIdentifiers.sect163r2;
        CustomNamedCurves.defineCurveWithOID("sect163r2", aSN1ObjectIdentifier7, sect163r2);
        CustomNamedCurves.defineCurveWithOID("sect193r1", SECObjectIdentifiers.sect193r1, sect193r1);
        CustomNamedCurves.defineCurveWithOID("sect193r2", SECObjectIdentifiers.sect193r2, sect193r2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = SECObjectIdentifiers.sect233k1;
        CustomNamedCurves.defineCurveWithOID("sect233k1", aSN1ObjectIdentifier8, sect233k1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = SECObjectIdentifiers.sect233r1;
        CustomNamedCurves.defineCurveWithOID("sect233r1", aSN1ObjectIdentifier9, sect233r1);
        CustomNamedCurves.defineCurveWithOID("sect239k1", SECObjectIdentifiers.sect239k1, sect239k1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = SECObjectIdentifiers.sect283k1;
        CustomNamedCurves.defineCurveWithOID("sect283k1", aSN1ObjectIdentifier10, sect283k1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = SECObjectIdentifiers.sect283r1;
        CustomNamedCurves.defineCurveWithOID("sect283r1", aSN1ObjectIdentifier11, sect283r1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = SECObjectIdentifiers.sect409k1;
        CustomNamedCurves.defineCurveWithOID("sect409k1", aSN1ObjectIdentifier12, sect409k1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = SECObjectIdentifiers.sect409r1;
        CustomNamedCurves.defineCurveWithOID("sect409r1", aSN1ObjectIdentifier13, sect409r1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = SECObjectIdentifiers.sect571k1;
        CustomNamedCurves.defineCurveWithOID("sect571k1", aSN1ObjectIdentifier14, sect571k1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = SECObjectIdentifiers.sect571r1;
        CustomNamedCurves.defineCurveWithOID("sect571r1", aSN1ObjectIdentifier15, sect571r1);
        CustomNamedCurves.defineCurveWithOID("sm2p256v1", GMObjectIdentifiers.sm2p256v1, sm2p256v1);
        CustomNamedCurves.defineCurveAlias("B-163", aSN1ObjectIdentifier7);
        CustomNamedCurves.defineCurveAlias("B-233", aSN1ObjectIdentifier9);
        CustomNamedCurves.defineCurveAlias("B-283", aSN1ObjectIdentifier11);
        CustomNamedCurves.defineCurveAlias("B-409", aSN1ObjectIdentifier13);
        CustomNamedCurves.defineCurveAlias("B-571", aSN1ObjectIdentifier15);
        CustomNamedCurves.defineCurveAlias("K-163", aSN1ObjectIdentifier6);
        CustomNamedCurves.defineCurveAlias("K-233", aSN1ObjectIdentifier8);
        CustomNamedCurves.defineCurveAlias("K-283", aSN1ObjectIdentifier10);
        CustomNamedCurves.defineCurveAlias("K-409", aSN1ObjectIdentifier12);
        CustomNamedCurves.defineCurveAlias("K-571", aSN1ObjectIdentifier14);
        CustomNamedCurves.defineCurveAlias("P-192", aSN1ObjectIdentifier);
        CustomNamedCurves.defineCurveAlias("P-224", aSN1ObjectIdentifier2);
        CustomNamedCurves.defineCurveAlias("P-256", aSN1ObjectIdentifier3);
        CustomNamedCurves.defineCurveAlias("P-384", aSN1ObjectIdentifier4);
        CustomNamedCurves.defineCurveAlias("P-521", aSN1ObjectIdentifier5);
    }

    public static X9ECPoint access$100(ECCurve eCCurve, String string) {
        X9ECPoint x9ECPoint = new X9ECPoint(eCCurve, Hex.decodeStrict(string));
        WNafUtil.configureBasepoint(x9ECPoint.getPoint());
        return x9ECPoint;
    }

    public static ECCurve access$200(ECCurve eCCurve, GLVTypeBParameters gLVTypeBParameters) {
        ECCurve.Config config = eCCurve.configure();
        config.endomorphism = new GLVTypeBEndomorphism(eCCurve, gLVTypeBParameters);
        return config.create();
    }

    public static void defineCurveAlias(String string, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Object object = oidToCurve.get((Object)aSN1ObjectIdentifier);
        if (object != null) {
            String string2 = Strings.toLowerCase(string);
            nameToOID.put((Object)string2, (Object)aSN1ObjectIdentifier);
            nameToCurve.put((Object)string2, object);
            return;
        }
        throw new IllegalStateException();
    }

    public static void defineCurveWithOID(String string, ASN1ObjectIdentifier aSN1ObjectIdentifier, X9ECParametersHolder x9ECParametersHolder) {
        names.addElement((Object)string);
        oidToName.put((Object)aSN1ObjectIdentifier, (Object)string);
        oidToCurve.put((Object)aSN1ObjectIdentifier, (Object)x9ECParametersHolder);
        String string2 = Strings.toLowerCase(string);
        nameToOID.put((Object)string2, (Object)aSN1ObjectIdentifier);
        nameToCurve.put((Object)string2, (Object)x9ECParametersHolder);
    }

    public static X9ECParameters getByName(String string) {
        X9ECParametersHolder x9ECParametersHolder = (X9ECParametersHolder)nameToCurve.get((Object)Strings.toLowerCase(string));
        if (x9ECParametersHolder == null) {
            return null;
        }
        return x9ECParametersHolder.getParameters();
    }
}

