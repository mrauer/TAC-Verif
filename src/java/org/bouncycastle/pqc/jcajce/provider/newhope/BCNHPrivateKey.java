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
 *  org.bouncycastle.asn1.ASN1Set
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.pqc.crypto.newhope.NHPrivateKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.newhope.NHPrivateKeyParameters;

public class BCNHPrivateKey
implements Key,
PrivateKey {
    public transient ASN1Set attributes;
    public transient NHPrivateKeyParameters params;

    public BCNHPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.attributes = privateKeyInfo.attributes;
        this.params = (NHPrivateKeyParameters)Nat576.createKey(privateKeyInfo);
    }

    public boolean equals(Object object) {
        if (!(object instanceof BCNHPrivateKey)) {
            return false;
        }
        BCNHPrivateKey bCNHPrivateKey = (BCNHPrivateKey)object;
        return Arrays.equals((short[])this.params.getSecData(), (short[])bCNHPrivateKey.params.getSecData());
    }

    public final String getAlgorithm() {
        return "NH";
    }

    public byte[] getEncoded() {
        try {
            byte[] arrby = Nat576.createPrivateKeyInfo((AsymmetricKeyParameter)this.params, this.attributes).getEncoded();
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
        return Nat576.hashCode(this.params.getSecData());
    }
}

