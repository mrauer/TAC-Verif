/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.math.BigInteger
 *  java.security.PublicKey
 *  java.security.interfaces.ECPublicKey
 *  java.security.spec.ECParameterSpec
 *  java.security.spec.ECPoint
 *  java.security.spec.ECPublicKeySpec
 *  java.security.spec.EllipticCurve
 *  java.util.Map
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1Null
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.ASN1OctetString
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.DERBitString
 *  org.bouncycastle.asn1.DEROctetString
 *  org.bouncycastle.asn1.x509.AlgorithmIdentifier
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 *  org.bouncycastle.asn1.x9.X962Parameters
 *  org.bouncycastle.asn1.x9.X9ECParameters
 *  org.bouncycastle.crypto.params.ECDomainParameters
 *  org.bouncycastle.crypto.params.ECKeyParameters
 *  org.bouncycastle.crypto.params.ECNamedDomainParameters
 *  org.bouncycastle.crypto.params.ECPublicKeyParameters
 *  org.bouncycastle.jce.provider.BouncyCastleProviderConfiguration
 *  org.bouncycastle.jce.spec.ECPublicKeySpec
 *  org.bouncycastle.math.ec.ECFieldElement
 */
package org.bouncycastle.jcajce.provider.asymmetric.ec;

import com.google.android.material.R;
import java.io.IOException;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProviderConfiguration;
import org.bouncycastle.jce.spec.ECKeySpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.Properties;
import org.bouncycastle.util.Strings;

public class BCECPublicKey
implements ECPublicKey,
PublicKey {
    public String algorithm = "EC";
    public transient ProviderConfiguration configuration;
    public transient ECPublicKeyParameters ecPublicKey;
    public transient ECParameterSpec ecSpec;

    public BCECPublicKey(String string, java.security.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        ECParameterSpec eCParameterSpec;
        this.algorithm = string;
        this.ecSpec = eCParameterSpec = eCPublicKeySpec.getParams();
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(eCParameterSpec, eCPublicKeySpec.getW()), EC5Util.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String string, SubjectPublicKeyInfo subjectPublicKeyInfo, ProviderConfiguration providerConfiguration) {
        ECNamedDomainParameters eCNamedDomainParameters;
        this.algorithm = string;
        this.configuration = providerConfiguration;
        X962Parameters x962Parameters = X962Parameters.getInstance((Object)subjectPublicKeyInfo.algId.parameters);
        ECCurve eCCurve = EC5Util.getCurve(this.configuration, x962Parameters);
        this.ecSpec = EC5Util.convertToSpec(x962Parameters, eCCurve);
        byte[] arrby = subjectPublicKeyInfo.keyData.getBytes();
        DEROctetString dEROctetString = new DEROctetString(arrby);
        if (arrby[0] == 4 && arrby[1] == arrby.length - 2 && (arrby[2] == 2 || arrby[2] == 3) && (7 + eCCurve.getFieldSize()) / 8 >= arrby.length - 3) {
            try {
                dEROctetString = (ASN1OctetString)ASN1Primitive.fromByteArray((byte[])arrby);
            }
            catch (IOException iOException) {
                throw new IllegalArgumentException("error recovering public key");
            }
        }
        byte[] arrby2 = Nat576.clone(dEROctetString.string);
        Objects.requireNonNull((Object)arrby2, (String)"'string' cannot be null");
        org.bouncycastle.math.ec.ECPoint eCPoint = eCCurve.decodePoint(arrby2).normalize();
        ProviderConfiguration providerConfiguration2 = this.configuration;
        ASN1Primitive aSN1Primitive = x962Parameters.params;
        if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance((Object)aSN1Primitive);
            X9ECParameters x9ECParameters = R.style.getNamedCurveByOid((ASN1ObjectIdentifier)aSN1ObjectIdentifier);
            if (x9ECParameters == null) {
                x9ECParameters = (X9ECParameters)((BouncyCastleProviderConfiguration)providerConfiguration2).getAdditionalECParameters().get((Object)aSN1ObjectIdentifier);
            }
            eCNamedDomainParameters = new ECNamedDomainParameters(aSN1ObjectIdentifier, x9ECParameters);
        } else if (aSN1Primitive instanceof ASN1Null) {
            org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = ((BouncyCastleProviderConfiguration)providerConfiguration2).getEcImplicitlyCa();
            ECCurve eCCurve2 = eCParameterSpec.curve;
            org.bouncycastle.math.ec.ECPoint eCPoint2 = eCParameterSpec.G;
            BigInteger bigInteger = eCParameterSpec.n;
            BigInteger bigInteger2 = eCParameterSpec.h;
            byte[] arrby3 = eCParameterSpec.seed;
            eCNamedDomainParameters = new ECDomainParameters(eCCurve2, eCPoint2, bigInteger, bigInteger2, arrby3);
        } else {
            X9ECParameters x9ECParameters = X9ECParameters.getInstance((Object)aSN1Primitive);
            ECCurve eCCurve3 = x9ECParameters.curve;
            org.bouncycastle.math.ec.ECPoint eCPoint3 = x9ECParameters.getG();
            BigInteger bigInteger = x9ECParameters.n;
            BigInteger bigInteger3 = x9ECParameters.h;
            byte[] arrby4 = x9ECParameters.getSeed();
            eCNamedDomainParameters = new ECDomainParameters(eCCurve3, eCPoint3, bigInteger, bigInteger3, arrby4);
        }
        this.ecPublicKey = new ECPublicKeyParameters(eCPoint, (ECDomainParameters)eCNamedDomainParameters);
    }

    public BCECPublicKey(String string, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters eCDomainParameters = eCPublicKeyParameters.parameters;
        this.algorithm = string;
        this.ecPublicKey = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            ECCurve eCCurve = eCDomainParameters.curve;
            eCDomainParameters.getSeed();
            this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(eCCurve), EC5Util.convertPoint(eCDomainParameters.G), eCDomainParameters.n, eCDomainParameters.h.intValue());
        } else {
            this.ecSpec = eCParameterSpec;
        }
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String string, ECPublicKeyParameters eCPublicKeyParameters, ProviderConfiguration providerConfiguration) {
        this.algorithm = string;
        this.ecPublicKey = eCPublicKeyParameters;
        this.ecSpec = null;
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String string, ECPublicKeyParameters eCPublicKeyParameters, org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters eCDomainParameters = eCPublicKeyParameters.parameters;
        this.algorithm = string;
        if (eCParameterSpec == null) {
            ECCurve eCCurve = eCDomainParameters.curve;
            eCDomainParameters.getSeed();
            this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(eCCurve), EC5Util.convertPoint(eCDomainParameters.G), eCDomainParameters.n, eCDomainParameters.h.intValue());
        } else {
            this.ecSpec = EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.curve), eCParameterSpec);
        }
        this.ecPublicKey = eCPublicKeyParameters;
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String string, ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = string;
        org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = eCPublicKeySpec.spec;
        if (eCParameterSpec != null) {
            ECCurve eCCurve = eCParameterSpec.curve;
            EllipticCurve ellipticCurve = EC5Util.convertCurve(eCCurve);
            this.ecPublicKey = new ECPublicKeyParameters(eCPublicKeySpec.q, R.style.getDomainParameters((ProviderConfiguration)providerConfiguration, (org.bouncycastle.jce.spec.ECParameterSpec)eCPublicKeySpec.spec));
            this.ecSpec = EC5Util.convertSpec(ellipticCurve, eCPublicKeySpec.spec);
        } else {
            BouncyCastleProviderConfiguration bouncyCastleProviderConfiguration = (BouncyCastleProviderConfiguration)providerConfiguration;
            this.ecPublicKey = new ECPublicKeyParameters(bouncyCastleProviderConfiguration.getEcImplicitlyCa().curve.createPoint(eCPublicKeySpec.q.getAffineXCoord().toBigInteger(), eCPublicKeySpec.q.getAffineYCoord().toBigInteger()), EC5Util.getDomainParameters((ProviderConfiguration)bouncyCastleProviderConfiguration, null));
            this.ecSpec = null;
        }
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(ECPublicKey eCPublicKey, ProviderConfiguration providerConfiguration) {
        ECParameterSpec eCParameterSpec;
        this.algorithm = eCPublicKey.getAlgorithm();
        this.ecSpec = eCParameterSpec = eCPublicKey.getParams();
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(eCParameterSpec, eCPublicKey.getW()), EC5Util.getDomainParameters(providerConfiguration, eCPublicKey.getParams()));
        this.configuration = providerConfiguration;
    }

    public org.bouncycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec != null) {
            return EC5Util.convertSpec(eCParameterSpec);
        }
        return ((BouncyCastleProviderConfiguration)this.configuration).getEcImplicitlyCa();
    }

    public boolean equals(Object object) {
        if (!(object instanceof BCECPublicKey)) {
            return false;
        }
        BCECPublicKey bCECPublicKey = (BCECPublicKey)object;
        boolean bl = this.ecPublicKey.q.equals(bCECPublicKey.ecPublicKey.q);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = this.engineGetSpec().equals(bCECPublicKey.engineGetSpec());
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncoded() {
        byte[] arrby;
        boolean bl = Properties.isOverrideSet("org.bouncycastle.ec.enable_pc");
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, (ASN1Encodable)R.style.getDomainParametersFromName((ECParameterSpec)this.ecSpec, (boolean)bl));
        byte[] arrby2 = this.ecPublicKey.q.getEncoded(bl);
        arrby = null;
        try {
            arrby = new SubjectPublicKeyInfo(algorithmIdentifier, arrby2).getEncoded("DER");
        }
        catch (Exception exception) {}
        return arrby;
    }

    public String getFormat() {
        return "X.509";
    }

    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    public ECPoint getW() {
        return EC5Util.convertPoint(this.ecPublicKey.q);
    }

    public int hashCode() {
        return this.ecPublicKey.q.hashCode() ^ this.engineGetSpec().hashCode();
    }

    public String toString() {
        org.bouncycastle.math.ec.ECPoint eCPoint = this.ecPublicKey.q;
        org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = this.engineGetSpec();
        StringBuffer stringBuffer = new StringBuffer();
        String string = Strings.LINE_SEPARATOR;
        stringBuffer.append("EC");
        stringBuffer.append(" Public Key [");
        stringBuffer.append(R.style.generateKeyFingerprint((org.bouncycastle.math.ec.ECPoint)eCPoint, (org.bouncycastle.jce.spec.ECParameterSpec)eCParameterSpec));
        stringBuffer.append("]");
        stringBuffer.append(string);
        stringBuffer.append("            X: ");
        stringBuffer.append(eCPoint.getAffineXCoord().toBigInteger().toString(16));
        stringBuffer.append(string);
        stringBuffer.append("            Y: ");
        stringBuffer.append(eCPoint.getAffineYCoord().toBigInteger().toString(16));
        stringBuffer.append(string);
        return stringBuffer.toString();
    }
}

