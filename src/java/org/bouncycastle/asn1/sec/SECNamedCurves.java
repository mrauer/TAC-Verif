/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.Hashtable
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.sec.SECNamedCurves$1
 *  org.bouncycastle.asn1.sec.SECNamedCurves$10
 *  org.bouncycastle.asn1.sec.SECNamedCurves$11
 *  org.bouncycastle.asn1.sec.SECNamedCurves$12
 *  org.bouncycastle.asn1.sec.SECNamedCurves$13
 *  org.bouncycastle.asn1.sec.SECNamedCurves$14
 *  org.bouncycastle.asn1.sec.SECNamedCurves$15
 *  org.bouncycastle.asn1.sec.SECNamedCurves$16
 *  org.bouncycastle.asn1.sec.SECNamedCurves$17
 *  org.bouncycastle.asn1.sec.SECNamedCurves$18
 *  org.bouncycastle.asn1.sec.SECNamedCurves$19
 *  org.bouncycastle.asn1.sec.SECNamedCurves$2
 *  org.bouncycastle.asn1.sec.SECNamedCurves$20
 *  org.bouncycastle.asn1.sec.SECNamedCurves$21
 *  org.bouncycastle.asn1.sec.SECNamedCurves$22
 *  org.bouncycastle.asn1.sec.SECNamedCurves$23
 *  org.bouncycastle.asn1.sec.SECNamedCurves$24
 *  org.bouncycastle.asn1.sec.SECNamedCurves$25
 *  org.bouncycastle.asn1.sec.SECNamedCurves$26
 *  org.bouncycastle.asn1.sec.SECNamedCurves$27
 *  org.bouncycastle.asn1.sec.SECNamedCurves$28
 *  org.bouncycastle.asn1.sec.SECNamedCurves$29
 *  org.bouncycastle.asn1.sec.SECNamedCurves$3
 *  org.bouncycastle.asn1.sec.SECNamedCurves$30
 *  org.bouncycastle.asn1.sec.SECNamedCurves$31
 *  org.bouncycastle.asn1.sec.SECNamedCurves$32
 *  org.bouncycastle.asn1.sec.SECNamedCurves$33
 *  org.bouncycastle.asn1.sec.SECNamedCurves$4
 *  org.bouncycastle.asn1.sec.SECNamedCurves$5
 *  org.bouncycastle.asn1.sec.SECNamedCurves$6
 *  org.bouncycastle.asn1.sec.SECNamedCurves$7
 *  org.bouncycastle.asn1.sec.SECNamedCurves$8
 *  org.bouncycastle.asn1.sec.SECNamedCurves$9
 *  org.bouncycastle.asn1.x9.X9ECParameters
 *  org.bouncycastle.asn1.x9.X9ECPoint
 */
package org.bouncycastle.asn1.sec;

import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.math.ec.endo.GLVTypeBEndomorphism;
import org.bouncycastle.math.ec.endo.GLVTypeBParameters;
import org.bouncycastle.util.encoders.Hex;

public class SECNamedCurves {
    public static final Hashtable curves;
    public static final Hashtable names;
    public static final Hashtable objIds;
    public static X9ECParametersHolder secp112r1;
    public static X9ECParametersHolder secp112r2;
    public static X9ECParametersHolder secp128r1;
    public static X9ECParametersHolder secp128r2;
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

    public static {
        secp112r1 = new 1();
        secp112r2 = new 2();
        secp128r1 = new 3();
        secp128r2 = new 4();
        secp160k1 = new 5();
        secp160r1 = new 6();
        secp160r2 = new 7();
        secp192k1 = new 8();
        secp192r1 = new 9();
        secp224k1 = new 10();
        secp224r1 = new 11();
        secp256k1 = new 12();
        secp256r1 = new 13();
        secp384r1 = new 14();
        secp521r1 = new 15();
        sect113r1 = new 16();
        sect113r2 = new 17();
        sect131r1 = new 18();
        sect131r2 = new 19();
        sect163k1 = new 20();
        sect163r1 = new 21();
        sect163r2 = new 22();
        sect193r1 = new 23();
        sect193r2 = new 24();
        sect233k1 = new 25();
        sect233r1 = new 26();
        sect239k1 = new 27();
        sect283k1 = new 28();
        sect283r1 = new 29();
        sect409k1 = new 30();
        sect409r1 = new 31();
        sect571k1 = new 32();
        sect571r1 = new 33();
        objIds = new Hashtable();
        curves = new Hashtable();
        names = new Hashtable();
        SECNamedCurves.defineCurve("secp112r1", SECObjectIdentifiers.secp112r1, secp112r1);
        SECNamedCurves.defineCurve("secp112r2", SECObjectIdentifiers.secp112r2, secp112r2);
        SECNamedCurves.defineCurve("secp128r1", SECObjectIdentifiers.secp128r1, secp128r1);
        SECNamedCurves.defineCurve("secp128r2", SECObjectIdentifiers.secp128r2, secp128r2);
        SECNamedCurves.defineCurve("secp160k1", SECObjectIdentifiers.secp160k1, secp160k1);
        SECNamedCurves.defineCurve("secp160r1", SECObjectIdentifiers.secp160r1, secp160r1);
        SECNamedCurves.defineCurve("secp160r2", SECObjectIdentifiers.secp160r2, secp160r2);
        SECNamedCurves.defineCurve("secp192k1", SECObjectIdentifiers.secp192k1, secp192k1);
        SECNamedCurves.defineCurve("secp192r1", SECObjectIdentifiers.secp192r1, secp192r1);
        SECNamedCurves.defineCurve("secp224k1", SECObjectIdentifiers.secp224k1, secp224k1);
        SECNamedCurves.defineCurve("secp224r1", SECObjectIdentifiers.secp224r1, secp224r1);
        SECNamedCurves.defineCurve("secp256k1", SECObjectIdentifiers.secp256k1, secp256k1);
        SECNamedCurves.defineCurve("secp256r1", SECObjectIdentifiers.secp256r1, secp256r1);
        SECNamedCurves.defineCurve("secp384r1", SECObjectIdentifiers.secp384r1, secp384r1);
        SECNamedCurves.defineCurve("secp521r1", SECObjectIdentifiers.secp521r1, secp521r1);
        SECNamedCurves.defineCurve("sect113r1", SECObjectIdentifiers.sect113r1, sect113r1);
        SECNamedCurves.defineCurve("sect113r2", SECObjectIdentifiers.sect113r2, sect113r2);
        SECNamedCurves.defineCurve("sect131r1", SECObjectIdentifiers.sect131r1, sect131r1);
        SECNamedCurves.defineCurve("sect131r2", SECObjectIdentifiers.sect131r2, sect131r2);
        SECNamedCurves.defineCurve("sect163k1", SECObjectIdentifiers.sect163k1, sect163k1);
        SECNamedCurves.defineCurve("sect163r1", SECObjectIdentifiers.sect163r1, sect163r1);
        SECNamedCurves.defineCurve("sect163r2", SECObjectIdentifiers.sect163r2, sect163r2);
        SECNamedCurves.defineCurve("sect193r1", SECObjectIdentifiers.sect193r1, sect193r1);
        SECNamedCurves.defineCurve("sect193r2", SECObjectIdentifiers.sect193r2, sect193r2);
        SECNamedCurves.defineCurve("sect233k1", SECObjectIdentifiers.sect233k1, sect233k1);
        SECNamedCurves.defineCurve("sect233r1", SECObjectIdentifiers.sect233r1, sect233r1);
        SECNamedCurves.defineCurve("sect239k1", SECObjectIdentifiers.sect239k1, sect239k1);
        SECNamedCurves.defineCurve("sect283k1", SECObjectIdentifiers.sect283k1, sect283k1);
        SECNamedCurves.defineCurve("sect283r1", SECObjectIdentifiers.sect283r1, sect283r1);
        SECNamedCurves.defineCurve("sect409k1", SECObjectIdentifiers.sect409k1, sect409k1);
        SECNamedCurves.defineCurve("sect409r1", SECObjectIdentifiers.sect409r1, sect409r1);
        SECNamedCurves.defineCurve("sect571k1", SECObjectIdentifiers.sect571k1, sect571k1);
        SECNamedCurves.defineCurve("sect571r1", SECObjectIdentifiers.sect571r1, sect571r1);
    }

    public static BigInteger access$000(String string) {
        return new BigInteger(1, Hex.decodeStrict(string));
    }

    public static X9ECPoint access$200(ECCurve eCCurve, String string) {
        X9ECPoint x9ECPoint = new X9ECPoint(eCCurve, Hex.decodeStrict(string));
        WNafUtil.configureBasepoint(x9ECPoint.getPoint());
        return x9ECPoint;
    }

    public static ECCurve access$300(ECCurve eCCurve, GLVTypeBParameters gLVTypeBParameters) {
        ECCurve.Config config = eCCurve.configure();
        config.endomorphism = new GLVTypeBEndomorphism(eCCurve, gLVTypeBParameters);
        return config.create();
    }

    public static void defineCurve(String string, ASN1ObjectIdentifier aSN1ObjectIdentifier, X9ECParametersHolder x9ECParametersHolder) {
        objIds.put((Object)string, (Object)aSN1ObjectIdentifier);
        names.put((Object)aSN1ObjectIdentifier, (Object)string);
        curves.put((Object)aSN1ObjectIdentifier, (Object)x9ECParametersHolder);
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParametersHolder x9ECParametersHolder = (X9ECParametersHolder)curves.get((Object)aSN1ObjectIdentifier);
        if (x9ECParametersHolder == null) {
            return null;
        }
        return x9ECParametersHolder.getParameters();
    }
}

