/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.PublicKey
 *  java.util.Arrays
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 *  org.bouncycastle.pqc.crypto.qtesla.QTESLAPublicKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.qtesla;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Arrays;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.qtesla.QTESLAPublicKeyParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;

public class BCqTESLAPublicKey
implements PublicKey {
    public transient QTESLAPublicKeyParameters keyParams;

    public BCqTESLAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        this.keyParams = (QTESLAPublicKeyParameters)PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof BCqTESLAPublicKey) {
            BCqTESLAPublicKey bCqTESLAPublicKey = (BCqTESLAPublicKey)object;
            QTESLAPublicKeyParameters qTESLAPublicKeyParameters = this.keyParams;
            return qTESLAPublicKeyParameters.securityCategory == bCqTESLAPublicKey.keyParams.securityCategory && Arrays.equals((byte[])qTESLAPublicKeyParameters.getPublicData(), (byte[])bCqTESLAPublicKey.keyParams.getPublicData());
        }
        return false;
    }

    public final String getAlgorithm() {
        return Nat576.getName(this.keyParams.securityCategory);
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
        QTESLAPublicKeyParameters qTESLAPublicKeyParameters = this.keyParams;
        return qTESLAPublicKeyParameters.securityCategory + 37 * Nat576.hashCode(qTESLAPublicKeyParameters.getPublicData());
    }
}

