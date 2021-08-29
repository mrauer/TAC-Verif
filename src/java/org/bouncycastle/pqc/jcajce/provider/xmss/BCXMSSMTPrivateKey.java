/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.PrivateKey
 *  java.util.Arrays
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.ASN1Set
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.asn1.x509.AlgorithmIdentifier
 *  org.bouncycastle.pqc.asn1.XMSSMTKeyParams
 *  org.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.xmss;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.asn1.XMSSMTKeyParams;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;

public class BCXMSSMTPrivateKey
implements PrivateKey {
    public transient ASN1Set attributes;
    public transient XMSSMTPrivateKeyParameters keyParams;
    public transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSMTPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.attributes = privateKeyInfo.attributes;
        this.treeDigest = XMSSMTKeyParams.getInstance((Object)privateKeyInfo.privateKeyAlgorithm.parameters).treeDigest.algorithm;
        this.keyParams = (XMSSMTPrivateKeyParameters)Nat576.createKey(privateKeyInfo);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof BCXMSSMTPrivateKey) {
            BCXMSSMTPrivateKey bCXMSSMTPrivateKey = (BCXMSSMTPrivateKey)object;
            return this.treeDigest.equals((ASN1Primitive)bCXMSSMTPrivateKey.treeDigest) && Arrays.equals((byte[])this.keyParams.toByteArray(), (byte[])bCXMSSMTPrivateKey.keyParams.toByteArray());
        }
        return false;
    }

    public String getAlgorithm() {
        return "XMSSMT";
    }

    public byte[] getEncoded() {
        try {
            byte[] arrby = Nat576.createPrivateKeyInfo((AsymmetricKeyParameter)this.keyParams, this.attributes).getEncoded();
            return arrby;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + 37 * Nat576.hashCode(this.keyParams.toByteArray());
    }
}

