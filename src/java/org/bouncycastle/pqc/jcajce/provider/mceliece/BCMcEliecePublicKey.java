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
 *  org.bouncycastle.pqc.asn1.McEliecePublicKey
 *  org.bouncycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.mceliece;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.pqc.asn1.McEliecePublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class BCMcEliecePublicKey
implements PublicKey {
    public McEliecePublicKeyParameters params;

    public BCMcEliecePublicKey(McEliecePublicKeyParameters mcEliecePublicKeyParameters) {
        this.params = mcEliecePublicKeyParameters;
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof BCMcEliecePublicKey;
        boolean bl2 = false;
        if (bl) {
            BCMcEliecePublicKey bCMcEliecePublicKey = (BCMcEliecePublicKey)object;
            McEliecePublicKeyParameters mcEliecePublicKeyParameters = this.params;
            int n2 = mcEliecePublicKeyParameters.n;
            McEliecePublicKeyParameters mcEliecePublicKeyParameters2 = bCMcEliecePublicKey.params;
            int n3 = mcEliecePublicKeyParameters2.n;
            bl2 = false;
            if (n2 == n3) {
                int n4 = mcEliecePublicKeyParameters.t;
                int n5 = mcEliecePublicKeyParameters2.t;
                bl2 = false;
                if (n4 == n5) {
                    boolean bl3 = mcEliecePublicKeyParameters.g.equals(mcEliecePublicKeyParameters2.g);
                    bl2 = false;
                    if (bl3) {
                        bl2 = true;
                    }
                }
            }
        }
        return bl2;
    }

    public String getAlgorithm() {
        return "McEliece";
    }

    public byte[] getEncoded() {
        McEliecePublicKeyParameters mcEliecePublicKeyParameters = this.params;
        McEliecePublicKey mcEliecePublicKey = new McEliecePublicKey(mcEliecePublicKeyParameters.n, mcEliecePublicKeyParameters.t, mcEliecePublicKeyParameters.g);
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(PQCObjectIdentifiers.mcEliece);
        try {
            byte[] arrby = new SubjectPublicKeyInfo(algorithmIdentifier, (ASN1Encodable)mcEliecePublicKey).getEncoded();
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
        McEliecePublicKeyParameters mcEliecePublicKeyParameters = this.params;
        return 37 * (mcEliecePublicKeyParameters.n + 37 * mcEliecePublicKeyParameters.t) + mcEliecePublicKeyParameters.g.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline26((String)GeneratedOutlineSupport.outline20((StringBuilder)GeneratedOutlineSupport.outline26((String)GeneratedOutlineSupport.outline20((StringBuilder)GeneratedOutlineSupport.outline26((String)"McEliecePublicKey:\n", (String)" length of the code         : "), (int)this.params.n, (String)"\n"), (String)" error correction capability: "), (int)this.params.t, (String)"\n"), (String)" generator matrix           : ");
        stringBuilder.append((Object)this.params.g);
        return stringBuilder.toString();
    }
}

