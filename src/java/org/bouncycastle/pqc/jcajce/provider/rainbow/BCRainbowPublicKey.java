/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.security.PublicKey
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.DERNull
 *  org.bouncycastle.asn1.x509.AlgorithmIdentifier
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 *  org.bouncycastle.pqc.asn1.RainbowPublicKey
 */
package org.bouncycastle.pqc.jcajce.provider.rainbow;

import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.RainbowPublicKey;
import org.bouncycastle.pqc.jcajce.spec.RainbowPublicKeySpec;

public class BCRainbowPublicKey
implements PublicKey {
    public short[][] coeffquadratic;
    public short[] coeffscalar;
    public short[][] coeffsingular;
    public int docLength;

    public BCRainbowPublicKey(int n2, short[][] arrs, short[][] arrs2, short[] arrs3) {
        this.docLength = n2;
        this.coeffquadratic = arrs;
        this.coeffsingular = arrs2;
        this.coeffscalar = arrs3;
    }

    public BCRainbowPublicKey(RainbowPublicKeySpec rainbowPublicKeySpec) {
        int n2 = rainbowPublicKeySpec.docLength;
        short[][] arrs = rainbowPublicKeySpec.coeffquadratic;
        short[][] arrs2 = rainbowPublicKeySpec.coeffsingular;
        short[] arrs3 = rainbowPublicKeySpec.coeffscalar;
        this.docLength = n2;
        this.coeffquadratic = arrs;
        this.coeffsingular = arrs2;
        this.coeffscalar = arrs3;
    }

    public boolean equals(Object object) {
        if (object != null && object instanceof BCRainbowPublicKey) {
            BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey)object;
            if (this.docLength == bCRainbowPublicKey.docLength && Nat576.equals(this.coeffquadratic, bCRainbowPublicKey.coeffquadratic) && Nat576.equals(this.coeffsingular, bCRainbowPublicKey.getCoeffSingular()) && Nat576.equals(this.coeffscalar, Nat576.clone(bCRainbowPublicKey.coeffscalar))) {
                return true;
            }
        }
        return false;
    }

    public final String getAlgorithm() {
        return "Rainbow";
    }

    public short[][] getCoeffSingular() {
        short[][] arrs;
        short[][] arrarrs = new short[this.coeffsingular.length][];
        for (int i2 = 0; i2 != (arrs = this.coeffsingular).length; ++i2) {
            arrarrs[i2] = Nat576.clone(arrs[i2]);
        }
        return arrarrs;
    }

    public byte[] getEncoded() {
        byte[] arrby;
        RainbowPublicKey rainbowPublicKey = new RainbowPublicKey(this.docLength, this.coeffquadratic, this.coeffsingular, this.coeffscalar);
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(PQCObjectIdentifiers.rainbow, (ASN1Encodable)DERNull.INSTANCE);
        arrby = null;
        try {
            arrby = new SubjectPublicKeyInfo(algorithmIdentifier, (ASN1Encodable)rainbowPublicKey).getEncoded("DER");
        }
        catch (Exception exception) {}
        return arrby;
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return 37 * (37 * (37 * this.docLength + Nat576.hashCode(this.coeffquadratic)) + Nat576.hashCode(this.coeffsingular)) + Nat576.hashCode(this.coeffscalar);
    }
}

