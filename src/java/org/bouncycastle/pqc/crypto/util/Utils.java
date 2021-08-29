/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.x509.AlgorithmIdentifier
 *  org.bouncycastle.crypto.digests.SHA256Digest
 *  org.bouncycastle.crypto.digests.SHA512Digest
 *  org.bouncycastle.crypto.digests.SHAKEDigest
 *  org.bouncycastle.pqc.asn1.SPHINCS256KeyParams
 */
package org.bouncycastle.pqc.crypto.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;

public class Utils {
    public static final AlgorithmIdentifier AlgID_qTESLA_p_I;
    public static final AlgorithmIdentifier AlgID_qTESLA_p_III;
    public static final AlgorithmIdentifier SPHINCS_SHA3_256;
    public static final AlgorithmIdentifier SPHINCS_SHA512_256;
    public static final AlgorithmIdentifier XMSS_SHA256;
    public static final AlgorithmIdentifier XMSS_SHA512;
    public static final AlgorithmIdentifier XMSS_SHAKE128;
    public static final AlgorithmIdentifier XMSS_SHAKE256;
    public static final Map categories;

    public static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PQCObjectIdentifiers.qTESLA_p_I;
        AlgID_qTESLA_p_I = new AlgorithmIdentifier(aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PQCObjectIdentifiers.qTESLA_p_III;
        AlgID_qTESLA_p_III = new AlgorithmIdentifier(aSN1ObjectIdentifier2);
        SPHINCS_SHA3_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha3_256);
        SPHINCS_SHA512_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256);
        XMSS_SHA256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
        XMSS_SHA512 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512);
        XMSS_SHAKE128 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake128);
        XMSS_SHAKE256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake256);
        HashMap hashMap = new HashMap();
        categories = hashMap;
        hashMap.put((Object)aSN1ObjectIdentifier, (Object)5);
        hashMap.put((Object)aSN1ObjectIdentifier2, (Object)6);
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

    public static AlgorithmIdentifier qTeslaLookupAlgID(int n2) {
        if (n2 != 5) {
            if (n2 == 6) {
                return AlgID_qTESLA_p_III;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline11((String)"unknown security category: ", (int)n2));
        }
        return AlgID_qTESLA_p_I;
    }

    public static AlgorithmIdentifier sphincs256LookupTreeAlgID(String string) {
        if (string.equals((Object)"SHA3-256")) {
            return SPHINCS_SHA3_256;
        }
        if (string.equals((Object)"SHA-512/256")) {
            return SPHINCS_SHA512_256;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline18((String)"unknown tree digest: ", (String)string));
    }

    public static String sphincs256LookupTreeAlgName(SPHINCS256KeyParams sPHINCS256KeyParams) {
        AlgorithmIdentifier algorithmIdentifier = sPHINCS256KeyParams.treeDigest;
        if (algorithmIdentifier.algorithm.equals((ASN1Primitive)Utils.SPHINCS_SHA3_256.algorithm)) {
            return "SHA3-256";
        }
        if (algorithmIdentifier.algorithm.equals((ASN1Primitive)Utils.SPHINCS_SHA512_256.algorithm)) {
            return "SHA-512/256";
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unknown tree digest: ");
        stringBuilder.append((Object)algorithmIdentifier.algorithm);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static AlgorithmIdentifier xmssLookupTreeAlgID(String string) {
        if (string.equals((Object)"SHA-256")) {
            return XMSS_SHA256;
        }
        if (string.equals((Object)"SHA-512")) {
            return XMSS_SHA512;
        }
        if (string.equals((Object)"SHAKE128")) {
            return XMSS_SHAKE128;
        }
        if (string.equals((Object)"SHAKE256")) {
            return XMSS_SHAKE256;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline18((String)"unknown tree digest: ", (String)string));
    }
}

