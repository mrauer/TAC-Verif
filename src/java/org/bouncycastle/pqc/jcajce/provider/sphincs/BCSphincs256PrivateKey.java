/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.Key
 *  java.security.PrivateKey
 *  java.util.Arrays
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.ASN1Set
 *  org.bouncycastle.asn1.DEROctetString
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.asn1.x509.AlgorithmIdentifier
 *  org.bouncycastle.pqc.asn1.SPHINCS256KeyParams
 *  org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters
 *  org.bouncycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.sphincs;

import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;

public class BCSphincs256PrivateKey
implements PrivateKey,
Key {
    public transient ASN1Set attributes;
    public transient SPHINCSPrivateKeyParameters params;
    public transient ASN1ObjectIdentifier treeDigest;

    public BCSphincs256PrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.attributes = privateKeyInfo.attributes;
        this.treeDigest = SPHINCS256KeyParams.getInstance((Object)privateKeyInfo.privateKeyAlgorithm.parameters).treeDigest.algorithm;
        this.params = (SPHINCSPrivateKeyParameters)Nat576.createKey(privateKeyInfo);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof BCSphincs256PrivateKey) {
            BCSphincs256PrivateKey bCSphincs256PrivateKey = (BCSphincs256PrivateKey)object;
            return this.treeDigest.equals((ASN1Primitive)bCSphincs256PrivateKey.treeDigest) && Arrays.equals((byte[])this.params.getKeyData(), (byte[])bCSphincs256PrivateKey.params.getKeyData());
        }
        return false;
    }

    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    public byte[] getEncoded() {
        byte[] arrby;
        arrby = null;
        try {
            SPHINCSPrivateKeyParameters sPHINCSPrivateKeyParameters = this.params;
            PrivateKeyInfo privateKeyInfo = sPHINCSPrivateKeyParameters.treeDigest != null ? Nat576.createPrivateKeyInfo((AsymmetricKeyParameter)sPHINCSPrivateKeyParameters, this.attributes) : new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, (ASN1Encodable)new SPHINCS256KeyParams(new AlgorithmIdentifier(this.treeDigest))), (ASN1Encodable)new DEROctetString(this.params.getKeyData()), this.attributes, null);
            arrby = privateKeyInfo.getEncoded();
        }
        catch (IOException iOException) {}
        return arrby;
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + 37 * Nat576.hashCode(this.params.getKeyData());
    }
}

