/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.Key
 *  java.security.PublicKey
 *  java.util.Arrays
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.x509.AlgorithmIdentifier
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 *  org.bouncycastle.pqc.asn1.SPHINCS256KeyParams
 *  org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters
 *  org.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.sphincs;

import java.io.IOException;
import java.security.Key;
import java.security.PublicKey;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;

public class BCSphincs256PublicKey
implements PublicKey,
Key {
    public transient SPHINCSPublicKeyParameters params;
    public transient ASN1ObjectIdentifier treeDigest;

    public BCSphincs256PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        this.treeDigest = SPHINCS256KeyParams.getInstance((Object)subjectPublicKeyInfo.algId.parameters).treeDigest.algorithm;
        this.params = (SPHINCSPublicKeyParameters)PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof BCSphincs256PublicKey) {
            BCSphincs256PublicKey bCSphincs256PublicKey = (BCSphincs256PublicKey)object;
            return this.treeDigest.equals((ASN1Primitive)bCSphincs256PublicKey.treeDigest) && Arrays.equals((byte[])this.params.getKeyData(), (byte[])bCSphincs256PublicKey.params.getKeyData());
        }
        return false;
    }

    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    public byte[] getEncoded() {
        try {
            SPHINCSPublicKeyParameters sPHINCSPublicKeyParameters = this.params;
            SubjectPublicKeyInfo subjectPublicKeyInfo = sPHINCSPublicKeyParameters.treeDigest != null ? Nat576.createSubjectPublicKeyInfo((AsymmetricKeyParameter)sPHINCSPublicKeyParameters) : new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, (ASN1Encodable)new SPHINCS256KeyParams(new AlgorithmIdentifier(this.treeDigest))), this.params.getKeyData());
            byte[] arrby = subjectPublicKeyInfo.getEncoded();
            return arrby;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + 37 * Nat576.hashCode(this.params.getKeyData());
    }
}

