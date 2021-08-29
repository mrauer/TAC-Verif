/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.Hashtable
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.gm.GMNamedCurves$1
 *  org.bouncycastle.asn1.gm.GMNamedCurves$2
 */
package org.bouncycastle.asn1.gm;

import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.gm.GMNamedCurves;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class GMNamedCurves {
    public static final Hashtable curves;
    public static final Hashtable names;
    public static final Hashtable objIds;
    public static X9ECParametersHolder sm2p256v1;
    public static X9ECParametersHolder wapip192v1;

    public static {
        Hashtable hashtable;
        Hashtable hashtable2;
        Hashtable hashtable3;
        sm2p256v1 = new 1();
        wapip192v1 = new 2();
        objIds = hashtable2 = new Hashtable();
        curves = hashtable3 = new Hashtable();
        names = hashtable = new Hashtable();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = GMObjectIdentifiers.wapip192v1;
        X9ECParametersHolder x9ECParametersHolder = wapip192v1;
        hashtable2.put((Object)Strings.toLowerCase("wapip192v1"), (Object)aSN1ObjectIdentifier);
        hashtable.put((Object)aSN1ObjectIdentifier, (Object)"wapip192v1");
        hashtable3.put((Object)aSN1ObjectIdentifier, (Object)x9ECParametersHolder);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = GMObjectIdentifiers.sm2p256v1;
        X9ECParametersHolder x9ECParametersHolder2 = sm2p256v1;
        hashtable2.put((Object)Strings.toLowerCase("sm2p256v1"), (Object)aSN1ObjectIdentifier2);
        hashtable.put((Object)aSN1ObjectIdentifier2, (Object)"sm2p256v1");
        hashtable3.put((Object)aSN1ObjectIdentifier2, (Object)x9ECParametersHolder2);
    }

    public static BigInteger access$000(String string) {
        return new BigInteger(1, Hex.decodeStrict(string));
    }
}

