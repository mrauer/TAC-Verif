/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.InvalidKeyException
 *  java.security.Key
 *  java.security.KeyFactorySpi
 *  java.security.PrivateKey
 *  java.security.PublicKey
 *  java.security.spec.InvalidKeySpecException
 *  java.security.spec.KeySpec
 *  java.security.spec.PKCS8EncodedKeySpec
 *  java.security.spec.X509EncodedKeySpec
 *  org.bouncycastle.asn1.ASN1Integer
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.ASN1Sequence
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 *  org.bouncycastle.pqc.asn1.RainbowPrivateKey
 *  org.bouncycastle.pqc.asn1.RainbowPublicKey
 */
package org.bouncycastle.pqc.jcajce.provider.rainbow;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.asn1.RainbowPrivateKey;
import org.bouncycastle.pqc.asn1.RainbowPublicKey;
import org.bouncycastle.pqc.crypto.rainbow.Layer;
import org.bouncycastle.pqc.jcajce.provider.rainbow.BCRainbowPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.rainbow.BCRainbowPublicKey;
import org.bouncycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;
import org.bouncycastle.pqc.jcajce.spec.RainbowPublicKeySpec;

public class RainbowKeyFactorySpi
extends KeyFactorySpi
implements AsymmetricKeyInfoConverter {
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof RainbowPrivateKeySpec) {
            return new BCRainbowPrivateKey((RainbowPrivateKeySpec)keySpec);
        }
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            byte[] arrby = ((PKCS8EncodedKeySpec)keySpec).getEncoded();
            try {
                PrivateKey privateKey = this.generatePrivate(PrivateKeyInfo.getInstance((Object)ASN1Primitive.fromByteArray((byte[])arrby)));
                return privateKey;
            }
            catch (Exception exception) {
                throw new InvalidKeySpecException(exception.toString());
            }
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Unsupported key specification: ");
        stringBuilder.append((Object)keySpec.getClass());
        stringBuilder.append(".");
        throw new InvalidKeySpecException(stringBuilder.toString());
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof RainbowPublicKeySpec) {
            return new BCRainbowPublicKey((RainbowPublicKeySpec)keySpec);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            byte[] arrby = ((X509EncodedKeySpec)keySpec).getEncoded();
            try {
                PublicKey publicKey = this.generatePublic(SubjectPublicKeyInfo.getInstance((Object)arrby));
                return publicKey;
            }
            catch (Exception exception) {
                throw new InvalidKeySpecException(exception.toString());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown key specification: ");
        stringBuilder.append((Object)keySpec);
        stringBuilder.append(".");
        throw new InvalidKeySpecException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     */
    public final KeySpec engineGetKeySpec(Key key, Class class_) throws InvalidKeySpecException {
        if (key instanceof BCRainbowPrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(class_)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
            if (RainbowPrivateKeySpec.class.isAssignableFrom(class_)) {
                BCRainbowPrivateKey bCRainbowPrivateKey = (BCRainbowPrivateKey)key;
                return new RainbowPrivateKeySpec(bCRainbowPrivateKey.A1inv, bCRainbowPrivateKey.b1, bCRainbowPrivateKey.A2inv, bCRainbowPrivateKey.b2, bCRainbowPrivateKey.vi, bCRainbowPrivateKey.layers);
            }
        } else {
            if (!(key instanceof BCRainbowPublicKey)) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Unsupported key type: ");
                stringBuilder.append((Object)key.getClass());
                stringBuilder.append(".");
                throw new InvalidKeySpecException(stringBuilder.toString());
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(class_)) {
                return new X509EncodedKeySpec(key.getEncoded());
            }
            if (RainbowPublicKeySpec.class.isAssignableFrom(class_)) {
                BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey)key;
                return new RainbowPublicKeySpec(bCRainbowPublicKey.docLength, bCRainbowPublicKey.coeffquadratic, bCRainbowPublicKey.getCoeffSingular(), Nat576.clone(bCRainbowPublicKey.coeffscalar));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown key specification: ");
        stringBuilder.append((Object)class_);
        stringBuilder.append(".");
        throw new InvalidKeySpecException(stringBuilder.toString());
    }

    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (!(key instanceof BCRainbowPrivateKey)) {
            if (key instanceof BCRainbowPublicKey) {
                return key;
            }
            throw new InvalidKeyException("Unsupported key type");
        }
        return key;
    }

    @Override
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1Encodable aSN1Encodable = privateKeyInfo.parsePrivateKey();
        Object object = aSN1Encodable instanceof RainbowPrivateKey ? (RainbowPrivateKey)aSN1Encodable : (aSN1Encodable != null ? new RainbowPrivateKey(ASN1Sequence.getInstance((Object)aSN1Encodable)) : null);
        short[][] arrs = Nat576.convertArray(object.invA1);
        short[] arrs2 = Nat576.convertArray(object.b1);
        short[][] arrs3 = Nat576.convertArray(object.invA2);
        short[] arrs4 = Nat576.convertArray(object.b2);
        byte[] arrby = object.vi;
        int[] arrn = new int[arrby.length];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            arrn[i2] = 255 & arrby[i2];
        }
        BCRainbowPrivateKey bCRainbowPrivateKey = new BCRainbowPrivateKey(arrs, arrs2, arrs3, arrs4, arrn, object.layers);
        return bCRainbowPrivateKey;
    }

    @Override
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1Primitive aSN1Primitive = subjectPublicKeyInfo.parsePublicKey();
        Object object = aSN1Primitive instanceof RainbowPublicKey ? (RainbowPublicKey)aSN1Primitive : (aSN1Primitive != null ? new RainbowPublicKey(ASN1Sequence.getInstance((Object)aSN1Primitive)) : null);
        return new BCRainbowPublicKey(object.docLength.intValueExact(), Nat576.convertArray(object.coeffQuadratic), Nat576.convertArray(object.coeffSingular), Nat576.convertArray(object.coeffScalar));
    }
}

