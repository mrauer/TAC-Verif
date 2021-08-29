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
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 */
package org.bouncycastle.pqc.jcajce.provider.xmss;

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
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.pqc.jcajce.provider.xmss.BCXMSSPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.xmss.BCXMSSPublicKey;

public class XMSSKeyFactorySpi
extends KeyFactorySpi
implements AsymmetricKeyInfoConverter {
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            byte[] arrby = ((PKCS8EncodedKeySpec)keySpec).getEncoded();
            try {
                BCXMSSPrivateKey bCXMSSPrivateKey = new BCXMSSPrivateKey(PrivateKeyInfo.getInstance((Object)ASN1Primitive.fromByteArray((byte[])arrby)));
                return bCXMSSPrivateKey;
            }
            catch (Exception exception) {
                throw new InvalidKeySpecException(exception.toString());
            }
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unsupported key specification: ");
        stringBuilder.append((Object)keySpec.getClass());
        stringBuilder.append(".");
        throw new InvalidKeySpecException(stringBuilder.toString());
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            byte[] arrby = ((X509EncodedKeySpec)keySpec).getEncoded();
            try {
                BCXMSSPublicKey bCXMSSPublicKey = new BCXMSSPublicKey(SubjectPublicKeyInfo.getInstance((Object)arrby));
                return bCXMSSPublicKey;
            }
            catch (Exception exception) {
                throw new InvalidKeySpecException(exception.toString());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unknown key specification: ");
        stringBuilder.append((Object)keySpec);
        stringBuilder.append(".");
        throw new InvalidKeySpecException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     */
    public final KeySpec engineGetKeySpec(Key key, Class class_) throws InvalidKeySpecException {
        if (key instanceof BCXMSSPrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(class_)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
        } else {
            if (!(key instanceof BCXMSSPublicKey)) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unsupported key type: ");
                stringBuilder.append((Object)key.getClass());
                stringBuilder.append(".");
                throw new InvalidKeySpecException(stringBuilder.toString());
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(class_)) {
                return new X509EncodedKeySpec(key.getEncoded());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unknown key specification: ");
        stringBuilder.append((Object)class_);
        stringBuilder.append(".");
        throw new InvalidKeySpecException(stringBuilder.toString());
    }

    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (!(key instanceof BCXMSSPrivateKey)) {
            if (key instanceof BCXMSSPublicKey) {
                return key;
            }
            throw new InvalidKeyException("unsupported key type");
        }
        return key;
    }

    @Override
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) throws IOException {
        return new BCXMSSPrivateKey(privateKeyInfo);
    }

    @Override
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        return new BCXMSSPublicKey(subjectPublicKeyInfo);
    }
}

