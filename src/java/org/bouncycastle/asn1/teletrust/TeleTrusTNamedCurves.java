/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.Hashtable
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$1
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$10
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$11
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$12
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$13
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$14
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$2
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$3
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$4
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$5
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$6
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$7
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$8
 *  org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves$9
 *  org.bouncycastle.asn1.x9.X9ECPoint
 */
package org.bouncycastle.asn1.teletrust;

import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class TeleTrusTNamedCurves {
    public static X9ECParametersHolder brainpoolP160r1 = new 1();
    public static X9ECParametersHolder brainpoolP160t1 = new 2();
    public static X9ECParametersHolder brainpoolP192r1 = new 3();
    public static X9ECParametersHolder brainpoolP192t1 = new 4();
    public static X9ECParametersHolder brainpoolP224r1 = new 5();
    public static X9ECParametersHolder brainpoolP224t1 = new 6();
    public static X9ECParametersHolder brainpoolP256r1 = new 7();
    public static X9ECParametersHolder brainpoolP256t1 = new 8();
    public static X9ECParametersHolder brainpoolP320r1 = new 9();
    public static X9ECParametersHolder brainpoolP320t1 = new 10();
    public static X9ECParametersHolder brainpoolP384r1 = new 11();
    public static X9ECParametersHolder brainpoolP384t1 = new 12();
    public static X9ECParametersHolder brainpoolP512r1 = new 13();
    public static X9ECParametersHolder brainpoolP512t1 = new 14();
    public static final Hashtable curves;
    public static final Hashtable names;
    public static final Hashtable objIds;

    public static {
        objIds = new Hashtable();
        curves = new Hashtable();
        names = new Hashtable();
        TeleTrusTNamedCurves.defineCurve("brainpoolP160r1", TeleTrusTObjectIdentifiers.brainpoolP160r1, brainpoolP160r1);
        TeleTrusTNamedCurves.defineCurve("brainpoolP160t1", TeleTrusTObjectIdentifiers.brainpoolP160t1, brainpoolP160t1);
        TeleTrusTNamedCurves.defineCurve("brainpoolP192r1", TeleTrusTObjectIdentifiers.brainpoolP192r1, brainpoolP192r1);
        TeleTrusTNamedCurves.defineCurve("brainpoolP192t1", TeleTrusTObjectIdentifiers.brainpoolP192t1, brainpoolP192t1);
        TeleTrusTNamedCurves.defineCurve("brainpoolP224r1", TeleTrusTObjectIdentifiers.brainpoolP224r1, brainpoolP224r1);
        TeleTrusTNamedCurves.defineCurve("brainpoolP224t1", TeleTrusTObjectIdentifiers.brainpoolP224t1, brainpoolP224t1);
        TeleTrusTNamedCurves.defineCurve("brainpoolP256r1", TeleTrusTObjectIdentifiers.brainpoolP256r1, brainpoolP256r1);
        TeleTrusTNamedCurves.defineCurve("brainpoolP256t1", TeleTrusTObjectIdentifiers.brainpoolP256t1, brainpoolP256t1);
        TeleTrusTNamedCurves.defineCurve("brainpoolP320r1", TeleTrusTObjectIdentifiers.brainpoolP320r1, brainpoolP320r1);
        TeleTrusTNamedCurves.defineCurve("brainpoolP320t1", TeleTrusTObjectIdentifiers.brainpoolP320t1, brainpoolP320t1);
        TeleTrusTNamedCurves.defineCurve("brainpoolP384r1", TeleTrusTObjectIdentifiers.brainpoolP384r1, brainpoolP384r1);
        TeleTrusTNamedCurves.defineCurve("brainpoolP384t1", TeleTrusTObjectIdentifiers.brainpoolP384t1, brainpoolP384t1);
        TeleTrusTNamedCurves.defineCurve("brainpoolP512r1", TeleTrusTObjectIdentifiers.brainpoolP512r1, brainpoolP512r1);
        TeleTrusTNamedCurves.defineCurve("brainpoolP512t1", TeleTrusTObjectIdentifiers.brainpoolP512t1, brainpoolP512t1);
    }

    public static BigInteger access$000(String string) {
        return new BigInteger(1, Hex.decodeStrict(string));
    }

    public static X9ECPoint access$200(ECCurve eCCurve, String string) {
        X9ECPoint x9ECPoint = new X9ECPoint(eCCurve, Hex.decodeStrict(string));
        WNafUtil.configureBasepoint(x9ECPoint.getPoint());
        return x9ECPoint;
    }

    public static void defineCurve(String string, ASN1ObjectIdentifier aSN1ObjectIdentifier, X9ECParametersHolder x9ECParametersHolder) {
        objIds.put((Object)Strings.toLowerCase(string), (Object)aSN1ObjectIdentifier);
        names.put((Object)aSN1ObjectIdentifier, (Object)string);
        curves.put((Object)aSN1ObjectIdentifier, (Object)x9ECParametersHolder);
    }
}

