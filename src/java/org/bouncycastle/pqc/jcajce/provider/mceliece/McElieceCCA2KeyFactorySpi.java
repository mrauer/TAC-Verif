/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.lang.Class
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
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.ASN1Sequence
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.asn1.x509.AlgorithmIdentifier
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 *  org.bouncycastle.pqc.asn1.McElieceCCA2PrivateKey
 *  org.bouncycastle.pqc.asn1.McElieceCCA2PublicKey
 *  org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters
 *  org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.mceliece;

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
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.bouncycastle.pqc.asn1.McElieceCCA2PublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcElieceCCA2PrivateKey;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcElieceCCA2PublicKey;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McElieceCCA2KeyFactorySpi
extends KeyFactorySpi
implements AsymmetricKeyInfoConverter {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        Object object;
        PrivateKeyInfo privateKeyInfo;
        if (!(keySpec instanceof PKCS8EncodedKeySpec)) {
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Unsupported key specification: ");
            stringBuilder.append((Object)keySpec.getClass());
            stringBuilder.append(".");
            throw new InvalidKeySpecException(stringBuilder.toString());
        }
        byte[] arrby = ((PKCS8EncodedKeySpec)keySpec).getEncoded();
        try {
            privateKeyInfo = PrivateKeyInfo.getInstance((Object)ASN1Primitive.fromByteArray((byte[])arrby));
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to decode PKCS8EncodedKeySpec: ");
            stringBuilder.append((Object)iOException);
            throw new InvalidKeySpecException(stringBuilder.toString());
        }
        try {
            if (!PQCObjectIdentifiers.mcElieceCca2.equals((ASN1Primitive)privateKeyInfo.privateKeyAlgorithm.algorithm)) {
                throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
            }
            ASN1Encodable aSN1Encodable = privateKeyInfo.parsePrivateKey();
            object = aSN1Encodable instanceof McElieceCCA2PrivateKey ? (McElieceCCA2PrivateKey)aSN1Encodable : (aSN1Encodable != null ? new McElieceCCA2PrivateKey(ASN1Sequence.getInstance((Object)aSN1Encodable)) : null);
        }
        catch (IOException iOException) {
            throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
        }
        McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters = new McElieceCCA2PrivateKeyParameters(object.n, object.k, new GF2mField(object.encField), new PolynomialGF2mSmallM(new GF2mField(object.encField), object.encGp), new Permutation(object.encP), Nat576.getDigest(object.digest).getAlgorithmName());
        return new BCMcElieceCCA2PrivateKey(mcElieceCCA2PrivateKeyParameters);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        SubjectPublicKeyInfo subjectPublicKeyInfo;
        if (!(keySpec instanceof X509EncodedKeySpec)) {
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Unsupported key specification: ");
            stringBuilder.append((Object)keySpec.getClass());
            stringBuilder.append(".");
            throw new InvalidKeySpecException(stringBuilder.toString());
        }
        byte[] arrby = ((X509EncodedKeySpec)keySpec).getEncoded();
        try {
            subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance((Object)ASN1Primitive.fromByteArray((byte[])arrby));
        }
        catch (IOException iOException) {
            throw new InvalidKeySpecException(iOException.toString());
        }
        try {
            McElieceCCA2PublicKey mcElieceCCA2PublicKey;
            if (!PQCObjectIdentifiers.mcElieceCca2.equals((ASN1Primitive)subjectPublicKeyInfo.algId.algorithm)) throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
            ASN1Primitive aSN1Primitive = subjectPublicKeyInfo.parsePublicKey();
            if (aSN1Primitive instanceof McElieceCCA2PublicKey) {
                mcElieceCCA2PublicKey = (McElieceCCA2PublicKey)aSN1Primitive;
                return new BCMcElieceCCA2PublicKey(new McElieceCCA2PublicKeyParameters(mcElieceCCA2PublicKey.n, mcElieceCCA2PublicKey.t, mcElieceCCA2PublicKey.g, Nat576.getDigest(mcElieceCCA2PublicKey.digest).getAlgorithmName()));
            }
            if (aSN1Primitive == null) return new BCMcElieceCCA2PublicKey(new McElieceCCA2PublicKeyParameters(mcElieceCCA2PublicKey.n, mcElieceCCA2PublicKey.t, mcElieceCCA2PublicKey.g, Nat576.getDigest(mcElieceCCA2PublicKey.digest).getAlgorithmName()));
            mcElieceCCA2PublicKey = new McElieceCCA2PublicKey(ASN1Sequence.getInstance((Object)aSN1Primitive));
            return new BCMcElieceCCA2PublicKey(new McElieceCCA2PublicKeyParameters(mcElieceCCA2PublicKey.n, mcElieceCCA2PublicKey.t, mcElieceCCA2PublicKey.g, Nat576.getDigest(mcElieceCCA2PublicKey.digest).getAlgorithmName()));
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Unable to decode X509EncodedKeySpec: ");
            stringBuilder.append(iOException.getMessage());
            throw new InvalidKeySpecException(stringBuilder.toString());
        }
    }

    public KeySpec engineGetKeySpec(Key key, Class class_) throws InvalidKeySpecException {
        return null;
    }

    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        return null;
    }
}

