/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.PublicKey
 *  java.util.Arrays
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 *  org.bouncycastle.pqc.crypto.xmss.XMSSMTKeyParameters
 *  org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.xmss;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;

public class BCXMSSMTPublicKey
implements PublicKey {
    public transient XMSSMTPublicKeyParameters keyParams;
    public transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSMTPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters;
        this.keyParams = xMSSMTPublicKeyParameters = (XMSSMTPublicKeyParameters)PublicKeyFactory.createKey(subjectPublicKeyInfo);
        this.treeDigest = Nat576.getDigestOID(xMSSMTPublicKeyParameters.treeDigest);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof BCXMSSMTPublicKey) {
            BCXMSSMTPublicKey bCXMSSMTPublicKey = (BCXMSSMTPublicKey)object;
            return this.treeDigest.equals((ASN1Primitive)bCXMSSMTPublicKey.treeDigest) && Arrays.equals((byte[])this.keyParams.toByteArray(), (byte[])bCXMSSMTPublicKey.keyParams.toByteArray());
        }
        return false;
    }

    public final String getAlgorithm() {
        return "XMSSMT";
    }

    public byte[] getEncoded() {
        try {
            byte[] arrby = Nat576.createSubjectPublicKeyInfo((AsymmetricKeyParameter)this.keyParams).getEncoded();
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
        return this.treeDigest.hashCode() + 37 * Nat576.hashCode(this.keyParams.toByteArray());
    }
}

