/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.Key
 *  java.security.PrivateKey
 *  java.util.Arrays
 *  org.bouncycastle.asn1.ASN1Set
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.pqc.crypto.lms.LMSKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.lms;

import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.lms.LMSKeyParameters;

public class BCLMSPrivateKey
implements PrivateKey,
Key {
    public transient ASN1Set attributes;
    public transient LMSKeyParameters keyParams;

    public BCLMSPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.attributes = privateKeyInfo.attributes;
        this.keyParams = (LMSKeyParameters)Nat576.createKey(privateKeyInfo);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof BCLMSPrivateKey) {
            BCLMSPrivateKey bCLMSPrivateKey = (BCLMSPrivateKey)object;
            try {
                boolean bl = Arrays.equals((byte[])this.keyParams.getEncoded(), (byte[])bCLMSPrivateKey.keyParams.getEncoded());
                return bl;
            }
            catch (IOException iOException) {
                throw new IllegalStateException("unable to perform equals");
            }
        }
        return false;
    }

    public String getAlgorithm() {
        return "LMS";
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
        try {
            int n2 = Nat576.hashCode(this.keyParams.getEncoded());
            return n2;
        }
        catch (IOException iOException) {
            throw new IllegalStateException("unable to calculate hashCode");
        }
    }
}

