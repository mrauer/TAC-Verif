/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.PublicKey
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.x509.AlgorithmIdentifier
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 *  org.bouncycastle.pqc.asn1.McElieceCCA2PublicKey
 *  org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters
 *  org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.mceliece;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.asn1.McElieceCCA2PublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class BCMcElieceCCA2PublicKey
implements PublicKey {
    public McElieceCCA2PublicKeyParameters params;

    public BCMcElieceCCA2PublicKey(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        this.params = mcElieceCCA2PublicKeyParameters;
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object != null) {
            if (!(object instanceof BCMcElieceCCA2PublicKey)) {
                return false;
            }
            BCMcElieceCCA2PublicKey bCMcElieceCCA2PublicKey = (BCMcElieceCCA2PublicKey)object;
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters = this.params;
            int n2 = mcElieceCCA2PublicKeyParameters.n;
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters2 = bCMcElieceCCA2PublicKey.params;
            int n3 = mcElieceCCA2PublicKeyParameters2.n;
            bl = false;
            if (n2 == n3) {
                int n4 = mcElieceCCA2PublicKeyParameters.t;
                int n5 = mcElieceCCA2PublicKeyParameters2.t;
                bl = false;
                if (n4 == n5) {
                    boolean bl2 = mcElieceCCA2PublicKeyParameters.matrixG.equals(mcElieceCCA2PublicKeyParameters2.matrixG);
                    bl = false;
                    if (bl2) {
                        bl = true;
                    }
                }
            }
        }
        return bl;
    }

    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    public byte[] getEncoded() {
        McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters = this.params;
        McElieceCCA2PublicKey mcElieceCCA2PublicKey = new McElieceCCA2PublicKey(mcElieceCCA2PublicKeyParameters.n, mcElieceCCA2PublicKeyParameters.t, mcElieceCCA2PublicKeyParameters.matrixG, Nat576.getDigAlgId(mcElieceCCA2PublicKeyParameters.params));
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(PQCObjectIdentifiers.mcElieceCca2);
        try {
            byte[] arrby = new SubjectPublicKeyInfo(algorithmIdentifier, (ASN1Encodable)mcElieceCCA2PublicKey).getEncoded();
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
        McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters = this.params;
        return 37 * (mcElieceCCA2PublicKeyParameters.n + 37 * mcElieceCCA2PublicKeyParameters.t) + mcElieceCCA2PublicKeyParameters.matrixG.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline26((String)GeneratedOutlineSupport.outline20((StringBuilder)GeneratedOutlineSupport.outline26((String)GeneratedOutlineSupport.outline20((StringBuilder)GeneratedOutlineSupport.outline26((String)"McEliecePublicKey:\n", (String)" length of the code         : "), (int)this.params.n, (String)"\n"), (String)" error correction capability: "), (int)this.params.t, (String)"\n"), (String)" generator matrix           : ");
        stringBuilder.append(this.params.matrixG.toString());
        return stringBuilder.toString();
    }
}

