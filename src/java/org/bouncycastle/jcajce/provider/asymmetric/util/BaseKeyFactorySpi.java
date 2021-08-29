/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.Key
 *  java.security.KeyFactorySpi
 *  java.security.PrivateKey
 *  java.security.PublicKey
 *  java.security.spec.InvalidKeySpecException
 *  java.security.spec.KeySpec
 *  java.security.spec.PKCS8EncodedKeySpec
 *  java.security.spec.X509EncodedKeySpec
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 */
package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public abstract class BaseKeyFactorySpi
extends KeyFactorySpi
implements AsymmetricKeyInfoConverter {
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                PrivateKey privateKey = this.generatePrivate(PrivateKeyInfo.getInstance((Object)((PKCS8EncodedKeySpec)keySpec).getEncoded()));
                return privateKey;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"encoded key spec not recognized: ");
                stringBuilder.append(exception.getMessage());
                throw new InvalidKeySpecException(stringBuilder.toString());
            }
        }
        throw new InvalidKeySpecException("key spec not recognized");
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                PublicKey publicKey = this.generatePublic(SubjectPublicKeyInfo.getInstance((Object)((X509EncodedKeySpec)keySpec).getEncoded()));
                return publicKey;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"encoded key spec not recognized: ");
                stringBuilder.append(exception.getMessage());
                throw new InvalidKeySpecException(stringBuilder.toString());
            }
        }
        throw new InvalidKeySpecException("key spec not recognized");
    }

    public KeySpec engineGetKeySpec(Key key, Class class_) throws InvalidKeySpecException {
        if (class_.isAssignableFrom(PKCS8EncodedKeySpec.class) && key.getFormat().equals((Object)"PKCS#8")) {
            return new PKCS8EncodedKeySpec(key.getEncoded());
        }
        if (class_.isAssignableFrom(X509EncodedKeySpec.class) && key.getFormat().equals((Object)"X.509")) {
            return new X509EncodedKeySpec(key.getEncoded());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("not implemented yet ");
        stringBuilder.append((Object)key);
        stringBuilder.append(" ");
        stringBuilder.append((Object)class_);
        throw new InvalidKeySpecException(stringBuilder.toString());
    }
}

