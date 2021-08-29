/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.Hashtable
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.x9.X962NamedCurves$1
 *  org.bouncycastle.asn1.x9.X962NamedCurves$10
 *  org.bouncycastle.asn1.x9.X962NamedCurves$11
 *  org.bouncycastle.asn1.x9.X962NamedCurves$12
 *  org.bouncycastle.asn1.x9.X962NamedCurves$13
 *  org.bouncycastle.asn1.x9.X962NamedCurves$14
 *  org.bouncycastle.asn1.x9.X962NamedCurves$15
 *  org.bouncycastle.asn1.x9.X962NamedCurves$16
 *  org.bouncycastle.asn1.x9.X962NamedCurves$17
 *  org.bouncycastle.asn1.x9.X962NamedCurves$18
 *  org.bouncycastle.asn1.x9.X962NamedCurves$19
 *  org.bouncycastle.asn1.x9.X962NamedCurves$2
 *  org.bouncycastle.asn1.x9.X962NamedCurves$20
 *  org.bouncycastle.asn1.x9.X962NamedCurves$21
 *  org.bouncycastle.asn1.x9.X962NamedCurves$22
 *  org.bouncycastle.asn1.x9.X962NamedCurves$23
 *  org.bouncycastle.asn1.x9.X962NamedCurves$3
 *  org.bouncycastle.asn1.x9.X962NamedCurves$4
 *  org.bouncycastle.asn1.x9.X962NamedCurves$5
 *  org.bouncycastle.asn1.x9.X962NamedCurves$6
 *  org.bouncycastle.asn1.x9.X962NamedCurves$7
 *  org.bouncycastle.asn1.x9.X962NamedCurves$8
 *  org.bouncycastle.asn1.x9.X962NamedCurves$9
 *  org.bouncycastle.asn1.x9.X9ECPoint
 */
package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X962NamedCurves;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.encoders.Hex;

public class X962NamedCurves {
    public static X9ECParametersHolder c2pnb163v1;
    public static X9ECParametersHolder c2pnb163v2;
    public static X9ECParametersHolder c2pnb163v3;
    public static X9ECParametersHolder c2pnb176w1;
    public static X9ECParametersHolder c2pnb208w1;
    public static X9ECParametersHolder c2pnb272w1;
    public static X9ECParametersHolder c2pnb304w1;
    public static X9ECParametersHolder c2pnb368w1;
    public static X9ECParametersHolder c2tnb191v1;
    public static X9ECParametersHolder c2tnb191v2;
    public static X9ECParametersHolder c2tnb191v3;
    public static X9ECParametersHolder c2tnb239v1;
    public static X9ECParametersHolder c2tnb239v2;
    public static X9ECParametersHolder c2tnb239v3;
    public static X9ECParametersHolder c2tnb359v1;
    public static X9ECParametersHolder c2tnb431r1;
    public static final Hashtable curves;
    public static final Hashtable names;
    public static final Hashtable objIds;
    public static X9ECParametersHolder prime192v1;
    public static X9ECParametersHolder prime192v2;
    public static X9ECParametersHolder prime192v3;
    public static X9ECParametersHolder prime239v1;
    public static X9ECParametersHolder prime239v2;
    public static X9ECParametersHolder prime239v3;
    public static X9ECParametersHolder prime256v1;

    public static {
        prime192v1 = new 1();
        prime192v2 = new 2();
        prime192v3 = new 3();
        prime239v1 = new 4();
        prime239v2 = new 5();
        prime239v3 = new 6();
        prime256v1 = new 7();
        c2pnb163v1 = new 8();
        c2pnb163v2 = new 9();
        c2pnb163v3 = new 10();
        c2pnb176w1 = new 11();
        c2tnb191v1 = new 12();
        c2tnb191v2 = new 13();
        c2tnb191v3 = new 14();
        c2pnb208w1 = new 15();
        c2tnb239v1 = new 16();
        c2tnb239v2 = new 17();
        c2tnb239v3 = new 18();
        c2pnb272w1 = new 19();
        c2pnb304w1 = new 20();
        c2tnb359v1 = new 21();
        c2pnb368w1 = new 22();
        c2tnb431r1 = new 23();
        objIds = new Hashtable();
        curves = new Hashtable();
        names = new Hashtable();
        X962NamedCurves.defineCurve("prime192v1", X9ObjectIdentifiers.prime192v1, prime192v1);
        X962NamedCurves.defineCurve("prime192v2", X9ObjectIdentifiers.prime192v2, prime192v2);
        X962NamedCurves.defineCurve("prime192v3", X9ObjectIdentifiers.prime192v3, prime192v3);
        X962NamedCurves.defineCurve("prime239v1", X9ObjectIdentifiers.prime239v1, prime239v1);
        X962NamedCurves.defineCurve("prime239v2", X9ObjectIdentifiers.prime239v2, prime239v2);
        X962NamedCurves.defineCurve("prime239v3", X9ObjectIdentifiers.prime239v3, prime239v3);
        X962NamedCurves.defineCurve("prime256v1", X9ObjectIdentifiers.prime256v1, prime256v1);
        X962NamedCurves.defineCurve("c2pnb163v1", X9ObjectIdentifiers.c2pnb163v1, c2pnb163v1);
        X962NamedCurves.defineCurve("c2pnb163v2", X9ObjectIdentifiers.c2pnb163v2, c2pnb163v2);
        X962NamedCurves.defineCurve("c2pnb163v3", X9ObjectIdentifiers.c2pnb163v3, c2pnb163v3);
        X962NamedCurves.defineCurve("c2pnb176w1", X9ObjectIdentifiers.c2pnb176w1, c2pnb176w1);
        X962NamedCurves.defineCurve("c2tnb191v1", X9ObjectIdentifiers.c2tnb191v1, c2tnb191v1);
        X962NamedCurves.defineCurve("c2tnb191v2", X9ObjectIdentifiers.c2tnb191v2, c2tnb191v2);
        X962NamedCurves.defineCurve("c2tnb191v3", X9ObjectIdentifiers.c2tnb191v3, c2tnb191v3);
        X962NamedCurves.defineCurve("c2pnb208w1", X9ObjectIdentifiers.c2pnb208w1, c2pnb208w1);
        X962NamedCurves.defineCurve("c2tnb239v1", X9ObjectIdentifiers.c2tnb239v1, c2tnb239v1);
        X962NamedCurves.defineCurve("c2tnb239v2", X9ObjectIdentifiers.c2tnb239v2, c2tnb239v2);
        X962NamedCurves.defineCurve("c2tnb239v3", X9ObjectIdentifiers.c2tnb239v3, c2tnb239v3);
        X962NamedCurves.defineCurve("c2pnb272w1", X9ObjectIdentifiers.c2pnb272w1, c2pnb272w1);
        X962NamedCurves.defineCurve("c2pnb304w1", X9ObjectIdentifiers.c2pnb304w1, c2pnb304w1);
        X962NamedCurves.defineCurve("c2tnb359v1", X9ObjectIdentifiers.c2tnb359v1, c2tnb359v1);
        X962NamedCurves.defineCurve("c2pnb368w1", X9ObjectIdentifiers.c2pnb368w1, c2pnb368w1);
        X962NamedCurves.defineCurve("c2tnb431r1", X9ObjectIdentifiers.c2tnb431r1, c2tnb431r1);
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
        objIds.put((Object)string, (Object)aSN1ObjectIdentifier);
        names.put((Object)aSN1ObjectIdentifier, (Object)string);
        curves.put((Object)aSN1ObjectIdentifier, (Object)x9ECParametersHolder);
    }
}

