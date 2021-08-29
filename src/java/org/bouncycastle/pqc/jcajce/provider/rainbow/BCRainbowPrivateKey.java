/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.PrivateKey
 *  java.util.Arrays
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.ASN1Set
 *  org.bouncycastle.asn1.DERNull
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.asn1.x509.AlgorithmIdentifier
 *  org.bouncycastle.pqc.asn1.RainbowPrivateKey
 */
package org.bouncycastle.pqc.jcajce.provider.rainbow;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.RainbowPrivateKey;
import org.bouncycastle.pqc.crypto.rainbow.Layer;
import org.bouncycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;

public class BCRainbowPrivateKey
implements PrivateKey {
    public short[][] A1inv;
    public short[][] A2inv;
    public short[] b1;
    public short[] b2;
    public Layer[] layers;
    public int[] vi;

    public BCRainbowPrivateKey(RainbowPrivateKeySpec rainbowPrivateKeySpec) {
        short[][] arrs = rainbowPrivateKeySpec.A1inv;
        short[] arrs2 = rainbowPrivateKeySpec.b1;
        short[][] arrs3 = rainbowPrivateKeySpec.A2inv;
        short[] arrs4 = rainbowPrivateKeySpec.b2;
        int[] arrn = rainbowPrivateKeySpec.vi;
        Layer[] arrlayer = rainbowPrivateKeySpec.layers;
        this.A1inv = arrs;
        this.b1 = arrs2;
        this.A2inv = arrs3;
        this.b2 = arrs4;
        this.vi = arrn;
        this.layers = arrlayer;
    }

    public BCRainbowPrivateKey(short[][] arrs, short[] arrs2, short[][] arrs3, short[] arrs4, int[] arrn, Layer[] arrlayer) {
        this.A1inv = arrs;
        this.b1 = arrs2;
        this.A2inv = arrs3;
        this.b2 = arrs4;
        this.vi = arrn;
        this.layers = arrlayer;
    }

    public boolean equals(Object object) {
        if (object != null) {
            if (!(object instanceof BCRainbowPrivateKey)) {
                return false;
            }
            BCRainbowPrivateKey bCRainbowPrivateKey = (BCRainbowPrivateKey)object;
            boolean bl = Nat576.equals(this.A1inv, bCRainbowPrivateKey.A1inv) && Nat576.equals(this.A2inv, bCRainbowPrivateKey.A2inv);
            boolean bl2 = bl && Nat576.equals(this.b1, bCRainbowPrivateKey.b1);
            boolean bl3 = bl2 && Nat576.equals(this.b2, bCRainbowPrivateKey.b2);
            boolean bl4 = bl3 && Arrays.equals((int[])this.vi, (int[])bCRainbowPrivateKey.vi);
            Layer[] arrlayer = this.layers;
            if (arrlayer.length != bCRainbowPrivateKey.layers.length) {
                return false;
            }
            for (int i2 = arrlayer.length - 1; i2 >= 0; --i2) {
                bl4 &= this.layers[i2].equals(bCRainbowPrivateKey.layers[i2]);
            }
            return bl4;
        }
        return false;
    }

    public final String getAlgorithm() {
        return "Rainbow";
    }

    public byte[] getEncoded() {
        byte[] arrby;
        RainbowPrivateKey rainbowPrivateKey = new RainbowPrivateKey(this.A1inv, this.b1, this.A2inv, this.b2, this.vi, this.layers);
        arrby = null;
        try {
            arrby = new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.rainbow, (ASN1Encodable)DERNull.INSTANCE), (ASN1Encodable)rainbowPrivateKey, null, null).getEncoded();
        }
        catch (IOException iOException) {}
        return arrby;
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        int n2 = 37 * (37 * (37 * (37 * (37 * this.layers.length + Nat576.hashCode(this.A1inv)) + Nat576.hashCode(this.b1)) + Nat576.hashCode(this.A2inv)) + Nat576.hashCode(this.b2)) + Nat576.hashCode(this.vi);
        for (int i2 = -1 + this.layers.length; i2 >= 0; --i2) {
            n2 = n2 * 37 + this.layers[i2].hashCode();
        }
        return n2;
    }
}

