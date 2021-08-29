/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.math.BigInteger
 *  java.security.InvalidKeyException
 *  java.security.Key
 *  java.security.PrivateKey
 *  java.security.PublicKey
 *  java.security.interfaces.ECPrivateKey
 *  java.security.interfaces.ECPublicKey
 *  java.security.spec.ECParameterSpec
 *  java.security.spec.ECPoint
 *  java.security.spec.ECPrivateKeySpec
 *  java.security.spec.ECPublicKeySpec
 *  java.security.spec.InvalidKeySpecException
 *  java.security.spec.KeySpec
 *  java.util.Objects
 */
package org.bouncycastle.jcajce.provider.asymmetric.ec;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.R;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.sec.ECPrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.BouncyCastleProviderConfiguration;
import org.bouncycastle.jce.spec.OpenSSHPrivateKeySpec;
import org.bouncycastle.jce.spec.OpenSSHPublicKeySpec;
import org.bouncycastle.math.ec.ECCurve;

public class KeyFactorySpi
extends BaseKeyFactorySpi
implements AsymmetricKeyInfoConverter {
    public String algorithm;
    public ProviderConfiguration configuration;

    public KeyFactorySpi(String string, ProviderConfiguration providerConfiguration) {
        this.algorithm = string;
        this.configuration = providerConfiguration;
    }

    @Override
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof org.bouncycastle.jce.spec.ECPrivateKeySpec) {
            return new BCECPrivateKey(this.algorithm, (org.bouncycastle.jce.spec.ECPrivateKeySpec)keySpec, this.configuration);
        }
        if (keySpec instanceof ECPrivateKeySpec) {
            return new BCECPrivateKey(this.algorithm, (ECPrivateKeySpec)keySpec, this.configuration);
        }
        if (keySpec instanceof org.bouncycastle.jcajce.spec.OpenSSHPrivateKeySpec) {
            ECPrivateKey eCPrivateKey = ECPrivateKey.getInstance(((org.bouncycastle.jcajce.spec.OpenSSHPrivateKeySpec)keySpec).getEncoded());
            try {
                BCECPrivateKey bCECPrivateKey = new BCECPrivateKey(this.algorithm, new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, eCPrivateKey.getObjectInTag(0)), eCPrivateKey, null, null), this.configuration);
                return bCECPrivateKey;
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"bad encoding: ");
                stringBuilder.append(iOException.getMessage());
                throw new InvalidKeySpecException(stringBuilder.toString());
            }
        }
        return super.engineGeneratePrivate(keySpec);
    }

    @Override
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        block5 : {
            try {
                if (keySpec instanceof org.bouncycastle.jce.spec.ECPublicKeySpec) {
                    return new BCECPublicKey(this.algorithm, (org.bouncycastle.jce.spec.ECPublicKeySpec)keySpec, this.configuration);
                }
                if (keySpec instanceof ECPublicKeySpec) {
                    return new BCECPublicKey(this.algorithm, (ECPublicKeySpec)keySpec, this.configuration);
                }
                if (!(keySpec instanceof org.bouncycastle.jcajce.spec.OpenSSHPublicKeySpec)) break block5;
                AsymmetricKeyParameter asymmetricKeyParameter = R.style.parsePublicKey((byte[])((org.bouncycastle.jcajce.spec.OpenSSHPublicKeySpec)keySpec).getEncoded());
                if (asymmetricKeyParameter instanceof ECPublicKeyParameters) {
                    ECDomainParameters eCDomainParameters = ((ECPublicKeyParameters)asymmetricKeyParameter).parameters;
                    org.bouncycastle.math.ec.ECPoint eCPoint = ((ECPublicKeyParameters)asymmetricKeyParameter).q;
                    org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = new org.bouncycastle.jce.spec.ECParameterSpec(eCDomainParameters.curve, eCDomainParameters.G, eCDomainParameters.n, eCDomainParameters.h, eCDomainParameters.getSeed());
                    return this.engineGeneratePublic(new org.bouncycastle.jce.spec.ECPublicKeySpec(eCPoint, eCParameterSpec));
                }
                throw new IllegalArgumentException("openssh key is not ec public key");
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"invalid KeySpec: ");
                stringBuilder.append(exception.getMessage());
                throw new InvalidKeySpecException(stringBuilder.toString(), (Throwable)exception);
            }
        }
        return super.engineGeneratePublic(keySpec);
    }

    @Override
    public KeySpec engineGetKeySpec(Key key, Class class_) throws InvalidKeySpecException {
        if ((class_.isAssignableFrom(KeySpec.class) || class_.isAssignableFrom(ECPublicKeySpec.class)) && key instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey)key;
            if (eCPublicKey.getParams() != null) {
                return new ECPublicKeySpec(eCPublicKey.getW(), eCPublicKey.getParams());
            }
            org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = ((BouncyCastleProviderConfiguration)BouncyCastleProvider.CONFIGURATION).getEcImplicitlyCa();
            return new ECPublicKeySpec(eCPublicKey.getW(), EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.curve), eCParameterSpec));
        }
        if ((class_.isAssignableFrom(KeySpec.class) || class_.isAssignableFrom(ECPrivateKeySpec.class)) && key instanceof java.security.interfaces.ECPrivateKey) {
            java.security.interfaces.ECPrivateKey eCPrivateKey = (java.security.interfaces.ECPrivateKey)key;
            if (eCPrivateKey.getParams() != null) {
                return new ECPrivateKeySpec(eCPrivateKey.getS(), eCPrivateKey.getParams());
            }
            org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = ((BouncyCastleProviderConfiguration)BouncyCastleProvider.CONFIGURATION).getEcImplicitlyCa();
            return new ECPrivateKeySpec(eCPrivateKey.getS(), EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.curve), eCParameterSpec));
        }
        if (class_.isAssignableFrom(org.bouncycastle.jce.spec.ECPublicKeySpec.class) && key instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey)key;
            if (eCPublicKey.getParams() != null) {
                return new org.bouncycastle.jce.spec.ECPublicKeySpec(EC5Util.convertPoint(eCPublicKey.getParams(), eCPublicKey.getW()), EC5Util.convertSpec(eCPublicKey.getParams()));
            }
            org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = ((BouncyCastleProviderConfiguration)BouncyCastleProvider.CONFIGURATION).getEcImplicitlyCa();
            return new org.bouncycastle.jce.spec.ECPublicKeySpec(EC5Util.convertPoint(eCPublicKey.getParams(), eCPublicKey.getW()), eCParameterSpec);
        }
        if (class_.isAssignableFrom(org.bouncycastle.jce.spec.ECPrivateKeySpec.class) && key instanceof java.security.interfaces.ECPrivateKey) {
            java.security.interfaces.ECPrivateKey eCPrivateKey = (java.security.interfaces.ECPrivateKey)key;
            if (eCPrivateKey.getParams() != null) {
                return new org.bouncycastle.jce.spec.ECPrivateKeySpec(eCPrivateKey.getS(), EC5Util.convertSpec(eCPrivateKey.getParams()));
            }
            org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = ((BouncyCastleProviderConfiguration)BouncyCastleProvider.CONFIGURATION).getEcImplicitlyCa();
            return new org.bouncycastle.jce.spec.ECPrivateKeySpec(eCPrivateKey.getS(), eCParameterSpec);
        }
        if (class_.isAssignableFrom(org.bouncycastle.jcajce.spec.OpenSSHPublicKeySpec.class) && key instanceof ECPublicKey) {
            if (key instanceof BCECPublicKey) {
                BCECPublicKey bCECPublicKey = (BCECPublicKey)key;
                ECParameterSpec eCParameterSpec = bCECPublicKey.ecSpec;
                org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec2 = eCParameterSpec == null ? null : EC5Util.convertSpec(eCParameterSpec);
                try {
                    org.bouncycastle.math.ec.ECPoint eCPoint = bCECPublicKey.ecPublicKey.q;
                    if (bCECPublicKey.ecSpec == null) {
                        eCPoint = eCPoint.normalize().detach();
                    }
                    ECDomainParameters eCDomainParameters = new ECDomainParameters(eCParameterSpec2.curve, eCParameterSpec2.G, eCParameterSpec2.n, eCParameterSpec2.h, eCParameterSpec2.seed);
                    org.bouncycastle.jcajce.spec.OpenSSHPublicKeySpec openSSHPublicKeySpec = new org.bouncycastle.jcajce.spec.OpenSSHPublicKeySpec(R.style.encodePublicKey((AsymmetricKeyParameter)new ECPublicKeyParameters(eCPoint, eCDomainParameters)));
                    return openSSHPublicKeySpec;
                }
                catch (IOException iOException) {
                    StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unable to produce encoding: ");
                    stringBuilder.append(iOException.getMessage());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"invalid key type: ");
            stringBuilder.append(key.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (class_.isAssignableFrom(org.bouncycastle.jcajce.spec.OpenSSHPrivateKeySpec.class) && key instanceof java.security.interfaces.ECPrivateKey) {
            if (key instanceof BCECPrivateKey) {
                try {
                    ASN1Primitive aSN1Primitive = (ASN1Primitive)PrivateKeyInfo.getInstance(key.getEncoded()).parsePrivateKey();
                    Objects.requireNonNull((Object)aSN1Primitive);
                    org.bouncycastle.jcajce.spec.OpenSSHPrivateKeySpec openSSHPrivateKeySpec = new org.bouncycastle.jcajce.spec.OpenSSHPrivateKeySpec(aSN1Primitive.getEncoded());
                    return openSSHPrivateKeySpec;
                }
                catch (IOException iOException) {
                    StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"cannot encoded key: ");
                    stringBuilder.append(iOException.getMessage());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"invalid key type: ");
            stringBuilder.append(key.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (class_.isAssignableFrom(OpenSSHPublicKeySpec.class) && key instanceof ECPublicKey) {
            if (key instanceof BCECPublicKey) {
                BCECPublicKey bCECPublicKey = (BCECPublicKey)key;
                ECParameterSpec eCParameterSpec = bCECPublicKey.ecSpec;
                org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec3 = eCParameterSpec == null ? null : EC5Util.convertSpec(eCParameterSpec);
                try {
                    org.bouncycastle.math.ec.ECPoint eCPoint = bCECPublicKey.ecPublicKey.q;
                    if (bCECPublicKey.ecSpec == null) {
                        eCPoint = eCPoint.normalize().detach();
                    }
                    ECDomainParameters eCDomainParameters = new ECDomainParameters(eCParameterSpec3.curve, eCParameterSpec3.G, eCParameterSpec3.n, eCParameterSpec3.h, eCParameterSpec3.seed);
                    OpenSSHPublicKeySpec openSSHPublicKeySpec = new OpenSSHPublicKeySpec(R.style.encodePublicKey((AsymmetricKeyParameter)new ECPublicKeyParameters(eCPoint, eCDomainParameters)));
                    return openSSHPublicKeySpec;
                }
                catch (IOException iOException) {
                    StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unable to produce encoding: ");
                    stringBuilder.append(iOException.getMessage());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"invalid key type: ");
            stringBuilder.append(key.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (class_.isAssignableFrom(OpenSSHPrivateKeySpec.class) && key instanceof java.security.interfaces.ECPrivateKey) {
            if (key instanceof BCECPrivateKey) {
                try {
                    ASN1Primitive aSN1Primitive = (ASN1Primitive)PrivateKeyInfo.getInstance(key.getEncoded()).parsePrivateKey();
                    Objects.requireNonNull((Object)aSN1Primitive);
                    OpenSSHPrivateKeySpec openSSHPrivateKeySpec = new OpenSSHPrivateKeySpec(aSN1Primitive.getEncoded());
                    return openSSHPrivateKeySpec;
                }
                catch (IOException iOException) {
                    StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"cannot encoded key: ");
                    stringBuilder.append(iOException.getMessage());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"invalid key type: ");
            stringBuilder.append(key.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return super.engineGetKeySpec(key, class_);
    }

    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof ECPublicKey) {
            return new BCECPublicKey((ECPublicKey)key, this.configuration);
        }
        if (key instanceof java.security.interfaces.ECPrivateKey) {
            return new BCECPrivateKey((java.security.interfaces.ECPrivateKey)key, this.configuration);
        }
        throw new InvalidKeyException("key type unknown");
    }

    @Override
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.privateKeyAlgorithm.algorithm;
        if (aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.id_ecPublicKey)) {
            return new BCECPrivateKey(this.algorithm, privateKeyInfo, this.configuration);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("algorithm identifier ");
        stringBuilder.append((Object)aSN1ObjectIdentifier);
        stringBuilder.append(" in key not recognised");
        throw new IOException(stringBuilder.toString());
    }

    @Override
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.algId.algorithm;
        if (aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.id_ecPublicKey)) {
            return new BCECPublicKey(this.algorithm, subjectPublicKeyInfo, this.configuration);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("algorithm identifier ");
        stringBuilder.append((Object)aSN1ObjectIdentifier);
        stringBuilder.append(" in key not recognised");
        throw new IOException(stringBuilder.toString());
    }

    public static class EC
    extends KeyFactorySpi {
        public EC() {
            super("EC", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECDH
    extends KeyFactorySpi {
        public ECDH() {
            super("ECDH", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECDSA
    extends KeyFactorySpi {
        public ECDSA() {
            super("ECDSA", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECMQV
    extends KeyFactorySpi {
        public ECMQV() {
            super("ECMQV", BouncyCastleProvider.CONFIGURATION);
        }
    }

}

