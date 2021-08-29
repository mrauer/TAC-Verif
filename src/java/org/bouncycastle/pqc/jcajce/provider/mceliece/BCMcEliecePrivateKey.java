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
 *  org.bouncycastle.pqc.asn1.McEliecePrivateKey
 *  org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.asn1.McEliecePrivateKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class BCMcEliecePrivateKey
implements PrivateKey {
    public McEliecePrivateKeyParameters params;

    public BCMcEliecePrivateKey(McEliecePrivateKeyParameters mcEliecePrivateKeyParameters) {
        this.params = mcEliecePrivateKeyParameters;
    }

    public boolean equals(Object object) {
        if (!(object instanceof BCMcEliecePrivateKey)) {
            return false;
        }
        BCMcEliecePrivateKey bCMcEliecePrivateKey = (BCMcEliecePrivateKey)object;
        McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = this.params;
        int n2 = mcEliecePrivateKeyParameters.n;
        McEliecePrivateKeyParameters mcEliecePrivateKeyParameters2 = bCMcEliecePrivateKey.params;
        int n3 = mcEliecePrivateKeyParameters2.n;
        boolean bl = false;
        if (n2 == n3) {
            int n4 = mcEliecePrivateKeyParameters.k;
            int n5 = mcEliecePrivateKeyParameters2.k;
            bl = false;
            if (n4 == n5) {
                boolean bl2 = mcEliecePrivateKeyParameters.field.equals(mcEliecePrivateKeyParameters2.field);
                bl = false;
                if (bl2) {
                    boolean bl3 = this.params.goppaPoly.equals(bCMcEliecePrivateKey.params.goppaPoly);
                    bl = false;
                    if (bl3) {
                        boolean bl4 = this.params.sInv.equals(bCMcEliecePrivateKey.params.sInv);
                        bl = false;
                        if (bl4) {
                            boolean bl5 = this.params.p1.equals(bCMcEliecePrivateKey.params.p1);
                            bl = false;
                            if (bl5) {
                                boolean bl6 = this.params.p2.equals(bCMcEliecePrivateKey.params.p2);
                                bl = false;
                                if (bl6) {
                                    bl = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return bl;
    }

    public String getAlgorithm() {
        return "McEliece";
    }

    public byte[] getEncoded() {
        byte[] arrby;
        McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = this.params;
        McEliecePrivateKey mcEliecePrivateKey = new McEliecePrivateKey(mcEliecePrivateKeyParameters.n, mcEliecePrivateKeyParameters.k, mcEliecePrivateKeyParameters.field, mcEliecePrivateKeyParameters.goppaPoly, mcEliecePrivateKeyParameters.p1, mcEliecePrivateKeyParameters.p2, mcEliecePrivateKeyParameters.sInv);
        arrby = null;
        try {
            arrby = new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcEliece), (ASN1Encodable)mcEliecePrivateKey, null, null).getEncoded();
        }
        catch (IOException iOException) {}
        return arrby;
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = this.params;
        return 37 * (37 * (37 * (37 * (37 * (37 * mcEliecePrivateKeyParameters.k + mcEliecePrivateKeyParameters.n) + mcEliecePrivateKeyParameters.field.polynomial) + mcEliecePrivateKeyParameters.goppaPoly.hashCode()) + this.params.p1.hashCode()) + this.params.p2.hashCode()) + this.params.sInv.hashCode();
    }
}

