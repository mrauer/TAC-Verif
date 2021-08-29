/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.PrivateKey
 *  java.util.Arrays
 *  org.bouncycastle.asn1.ASN1Set
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.pqc.crypto.qtesla.QTESLAPrivateKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.qtesla;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.qtesla.QTESLAPrivateKeyParameters;

public class BCqTESLAPrivateKey
implements PrivateKey {
    public transient ASN1Set attributes;
    public transient QTESLAPrivateKeyParameters keyParams;

    public BCqTESLAPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.attributes = privateKeyInfo.attributes;
        this.keyParams = (QTESLAPrivateKeyParameters)Nat576.createKey(privateKeyInfo);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof BCqTESLAPrivateKey) {
            BCqTESLAPrivateKey bCqTESLAPrivateKey = (BCqTESLAPrivateKey)object;
            QTESLAPrivateKeyParameters qTESLAPrivateKeyParameters = this.keyParams;
            return qTESLAPrivateKeyParameters.securityCategory == bCqTESLAPrivateKey.keyParams.securityCategory && Arrays.equals((byte[])qTESLAPrivateKeyParameters.getSecret(), (byte[])bCqTESLAPrivateKey.keyParams.getSecret());
        }
        return false;
    }

    public final String getAlgorithm() {
        return Nat576.getName(this.keyParams.securityCategory);
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
        QTESLAPrivateKeyParameters qTESLAPrivateKeyParameters = this.keyParams;
        return qTESLAPrivateKeyParameters.securityCategory + 37 * Nat576.hashCode(qTESLAPrivateKeyParameters.getSecret());
    }
}

