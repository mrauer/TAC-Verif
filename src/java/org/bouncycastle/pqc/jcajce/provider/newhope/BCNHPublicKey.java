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
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 *  org.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.io.IOException;
import java.security.Key;
import java.security.PublicKey;
import java.util.Arrays;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;

public class BCNHPublicKey
implements Key,
PublicKey {
    public transient NHPublicKeyParameters params;

    public BCNHPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        this.params = (NHPublicKeyParameters)PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    public boolean equals(Object object) {
        if (object != null && object instanceof BCNHPublicKey) {
            BCNHPublicKey bCNHPublicKey = (BCNHPublicKey)object;
            return Arrays.equals((byte[])this.params.getPubData(), (byte[])bCNHPublicKey.params.getPubData());
        }
        return false;
    }

    public final String getAlgorithm() {
        return "NH";
    }

    public byte[] getEncoded() {
        try {
            byte[] arrby = Nat576.createSubjectPublicKeyInfo((AsymmetricKeyParameter)this.params).getEncoded();
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
        return Nat576.hashCode(this.params.getPubData());
    }
}

