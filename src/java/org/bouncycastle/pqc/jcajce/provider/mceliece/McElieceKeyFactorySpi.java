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
 *  org.bouncycastle.pqc.asn1.McEliecePrivateKey
 *  org.bouncycastle.pqc.asn1.McEliecePublicKey
 *  org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters
 *  org.bouncycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters
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
import org.bouncycastle.pqc.asn1.McEliecePrivateKey;
import org.bouncycastle.pqc.asn1.McEliecePublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcEliecePrivateKey;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcEliecePublicKey;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McElieceKeyFactorySpi
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
            if (!PQCObjectIdentifiers.mcEliece.equals((ASN1Primitive)privateKeyInfo.privateKeyAlgorithm.algorithm)) {
                throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
            }
            ASN1Encodable aSN1Encodable = privateKeyInfo.parsePrivateKey();
            object = aSN1Encodable instanceof McEliecePrivateKey ? (McEliecePrivateKey)aSN1Encodable : (aSN1Encodable != null ? new McEliecePrivateKey(ASN1Sequence.getInstance((Object)aSN1Encodable)) : null);
        }
        catch (IOException iOException) {
            throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
        }
        McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = new McEliecePrivateKeyParameters(object.n, object.k, new GF2mField(object.encField), new PolynomialGF2mSmallM(new GF2mField(object.encField), object.encGp), new Permutation(object.encP1), new Permutation(object.encP2), new GF2Matrix(object.encSInv));
        return new BCMcEliecePrivateKey(mcEliecePrivateKeyParameters);
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
            McEliecePublicKey mcEliecePublicKey;
            if (!PQCObjectIdentifiers.mcEliece.equals((ASN1Primitive)subjectPublicKeyInfo.algId.algorithm)) throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
            ASN1Primitive aSN1Primitive = subjectPublicKeyInfo.parsePublicKey();
            if (aSN1Primitive instanceof McEliecePublicKey) {
                mcEliecePublicKey = (McEliecePublicKey)aSN1Primitive;
                return new BCMcEliecePublicKey(new McEliecePublicKeyParameters(mcEliecePublicKey.n, mcEliecePublicKey.t, new GF2Matrix(mcEliecePublicKey.g)));
            }
            if (aSN1Primitive == null) return new BCMcEliecePublicKey(new McEliecePublicKeyParameters(mcEliecePublicKey.n, mcEliecePublicKey.t, new GF2Matrix(mcEliecePublicKey.g)));
            mcEliecePublicKey = new McEliecePublicKey(ASN1Sequence.getInstance((Object)aSN1Primitive));
            return new BCMcEliecePublicKey(new McEliecePublicKeyParameters(mcEliecePublicKey.n, mcEliecePublicKey.t, new GF2Matrix(mcEliecePublicKey.g)));
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

