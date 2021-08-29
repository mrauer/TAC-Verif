/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.PrivateKey
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.ASN1Set
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.asn1.x509.AlgorithmIdentifier
 *  org.bouncycastle.pqc.asn1.McElieceCCA2PrivateKey
 *  org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters
 *  org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class BCMcElieceCCA2PrivateKey
implements PrivateKey {
    public McElieceCCA2PrivateKeyParameters params;

    public BCMcElieceCCA2PrivateKey(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters) {
        this.params = mcElieceCCA2PrivateKeyParameters;
    }

    public boolean equals(Object object) {
        if (object != null && object instanceof BCMcElieceCCA2PrivateKey) {
            BCMcElieceCCA2PrivateKey bCMcElieceCCA2PrivateKey = (BCMcElieceCCA2PrivateKey)object;
            McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters = this.params;
            int n2 = mcElieceCCA2PrivateKeyParameters.n;
            McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters2 = bCMcElieceCCA2PrivateKey.params;
            if (n2 == mcElieceCCA2PrivateKeyParameters2.n && mcElieceCCA2PrivateKeyParameters.k == mcElieceCCA2PrivateKeyParameters2.k && mcElieceCCA2PrivateKeyParameters.field.equals(mcElieceCCA2PrivateKeyParameters2.field) && this.params.goppaPoly.equals(bCMcElieceCCA2PrivateKey.params.goppaPoly) && this.params.p.equals(bCMcElieceCCA2PrivateKey.params.p) && this.params.h.equals(bCMcElieceCCA2PrivateKey.params.h)) {
                return true;
            }
        }
        return false;
    }

    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    public byte[] getEncoded() {
        byte[] arrby;
        arrby = null;
        try {
            McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters = this.params;
            McElieceCCA2PrivateKey mcElieceCCA2PrivateKey = new McElieceCCA2PrivateKey(mcElieceCCA2PrivateKeyParameters.n, mcElieceCCA2PrivateKeyParameters.k, mcElieceCCA2PrivateKeyParameters.field, mcElieceCCA2PrivateKeyParameters.goppaPoly, mcElieceCCA2PrivateKeyParameters.p, Nat576.getDigAlgId(mcElieceCCA2PrivateKeyParameters.params));
            arrby = new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcElieceCca2), (ASN1Encodable)mcElieceCCA2PrivateKey, null, null).getEncoded();
        }
        catch (IOException iOException) {}
        return arrby;
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters = this.params;
        return 37 * (37 * (37 * (37 * (37 * mcElieceCCA2PrivateKeyParameters.k + mcElieceCCA2PrivateKeyParameters.n) + mcElieceCCA2PrivateKeyParameters.field.polynomial) + mcElieceCCA2PrivateKeyParameters.goppaPoly.hashCode()) + this.params.p.hashCode()) + this.params.h.hashCode();
    }
}

