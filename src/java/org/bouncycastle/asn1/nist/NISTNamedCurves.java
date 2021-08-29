/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Hashtable
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 */
package org.bouncycastle.asn1.nist;

import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;

public class NISTNamedCurves {
    public static final Hashtable names;
    public static final Hashtable objIds;

    public static {
        objIds = new Hashtable();
        names = new Hashtable();
        NISTNamedCurves.defineCurve("B-571", SECObjectIdentifiers.sect571r1);
        NISTNamedCurves.defineCurve("B-409", SECObjectIdentifiers.sect409r1);
        NISTNamedCurves.defineCurve("B-283", SECObjectIdentifiers.sect283r1);
        NISTNamedCurves.defineCurve("B-233", SECObjectIdentifiers.sect233r1);
        NISTNamedCurves.defineCurve("B-163", SECObjectIdentifiers.sect163r2);
        NISTNamedCurves.defineCurve("K-571", SECObjectIdentifiers.sect571k1);
        NISTNamedCurves.defineCurve("K-409", SECObjectIdentifiers.sect409k1);
        NISTNamedCurves.defineCurve("K-283", SECObjectIdentifiers.sect283k1);
        NISTNamedCurves.defineCurve("K-233", SECObjectIdentifiers.sect233k1);
        NISTNamedCurves.defineCurve("K-163", SECObjectIdentifiers.sect163k1);
        NISTNamedCurves.defineCurve("P-521", SECObjectIdentifiers.secp521r1);
        NISTNamedCurves.defineCurve("P-384", SECObjectIdentifiers.secp384r1);
        NISTNamedCurves.defineCurve("P-256", SECObjectIdentifiers.secp256r1);
        NISTNamedCurves.defineCurve("P-224", SECObjectIdentifiers.secp224r1);
        NISTNamedCurves.defineCurve("P-192", SECObjectIdentifiers.secp192r1);
    }

    public static void defineCurve(String string, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        objIds.put((Object)string, (Object)aSN1ObjectIdentifier);
        names.put((Object)aSN1ObjectIdentifier, (Object)string);
    }
}

