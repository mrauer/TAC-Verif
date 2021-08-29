/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.Hashtable
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.anssi.ANSSINamedCurves$1
 */
package org.bouncycastle.asn1.anssi;

import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.anssi.ANSSINamedCurves;
import org.bouncycastle.asn1.anssi.ANSSIObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class ANSSINamedCurves {
    public static X9ECParametersHolder FRP256v1;
    public static final Hashtable curves;
    public static final Hashtable names;
    public static final Hashtable objIds;

    public static {
        Hashtable hashtable;
        Hashtable hashtable2;
        Hashtable hashtable3;
        FRP256v1 = new 1();
        objIds = hashtable2 = new Hashtable();
        curves = hashtable3 = new Hashtable();
        names = hashtable = new Hashtable();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = ANSSIObjectIdentifiers.FRP256v1;
        X9ECParametersHolder x9ECParametersHolder = FRP256v1;
        hashtable2.put((Object)Strings.toLowerCase("FRP256v1"), (Object)aSN1ObjectIdentifier);
        hashtable.put((Object)aSN1ObjectIdentifier, (Object)"FRP256v1");
        hashtable3.put((Object)aSN1ObjectIdentifier, (Object)x9ECParametersHolder);
    }

    public static BigInteger access$000(String string) {
        return new BigInteger(1, Hex.decodeStrict(string));
    }
}

