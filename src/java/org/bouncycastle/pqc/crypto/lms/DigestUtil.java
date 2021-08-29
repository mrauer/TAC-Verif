/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.crypto.digests.SHA256Digest
 *  org.bouncycastle.crypto.digests.SHA512Digest
 *  org.bouncycastle.crypto.digests.SHAKEDigest
 */
package org.bouncycastle.pqc.crypto.lms;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;

public class DigestUtil {
    public static Map<String, ASN1ObjectIdentifier> nameToOid = new HashMap();
    public static Map<ASN1ObjectIdentifier, String> oidToName = new HashMap();

    public static {
        Map<String, ASN1ObjectIdentifier> map = nameToOid;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        map.put((Object)"SHA-256", (Object)aSN1ObjectIdentifier);
        Map<String, ASN1ObjectIdentifier> map2 = nameToOid;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_sha512;
        map2.put((Object)"SHA-512", (Object)aSN1ObjectIdentifier2);
        Map<String, ASN1ObjectIdentifier> map3 = nameToOid;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_shake128;
        map3.put((Object)"SHAKE128", (Object)aSN1ObjectIdentifier3);
        Map<String, ASN1ObjectIdentifier> map4 = nameToOid;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_shake256;
        map4.put((Object)"SHAKE256", (Object)aSN1ObjectIdentifier4);
        oidToName.put((Object)aSN1ObjectIdentifier, (Object)"SHA-256");
        oidToName.put((Object)aSN1ObjectIdentifier2, (Object)"SHA-512");
        oidToName.put((Object)aSN1ObjectIdentifier3, (Object)"SHAKE128");
        oidToName.put((Object)aSN1ObjectIdentifier4, (Object)"SHAKE256");
    }

    public static Digest getDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.equals((ASN1Primitive)NISTObjectIdentifiers.id_sha256)) {
            return new SHA256Digest();
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive)NISTObjectIdentifiers.id_sha512)) {
            return new SHA512Digest();
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive)NISTObjectIdentifiers.id_shake128)) {
            return new SHAKEDigest(128);
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive)NISTObjectIdentifiers.id_shake256)) {
            return new SHAKEDigest(256);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unrecognized digest OID: ");
        stringBuilder.append((Object)aSN1ObjectIdentifier);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}

