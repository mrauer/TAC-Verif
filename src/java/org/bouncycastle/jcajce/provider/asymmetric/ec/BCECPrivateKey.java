/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.math.BigInteger
 *  java.security.PrivateKey
 *  java.security.interfaces.ECPrivateKey
 *  java.security.spec.ECParameterSpec
 *  java.security.spec.ECPrivateKeySpec
 *  java.util.Hashtable
 *  java.util.Vector
 *  org.bouncycastle.asn1.ASN1Integer
 *  org.bouncycastle.asn1.ASN1OctetString
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.ASN1Sequence
 *  org.bouncycastle.asn1.DERBitString
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.asn1.sec.ECPrivateKey
 *  org.bouncycastle.asn1.x509.AlgorithmIdentifier
 *  org.bouncycastle.asn1.x9.X962Parameters
 *  org.bouncycastle.crypto.params.ECPrivateKeyParameters
 *  org.bouncycastle.jce.provider.BouncyCastleProviderConfiguration
 *  org.bouncycastle.jce.spec.ECPrivateKeySpec
 *  org.bouncycastle.math.ec.ECFieldElement
 *  org.bouncycastle.math.ec.FixedPointCombMultiplier
 */
package org.bouncycastle.jcajce.provider.asymmetric.ec;

import com.google.android.material.R;
import java.io.IOException;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.sec.ECPrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProviderConfiguration;
import org.bouncycastle.jce.spec.ECKeySpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Strings;

public class BCECPrivateKey
implements java.security.interfaces.ECPrivateKey,
PrivateKey {
    public String algorithm;
    public transient ProviderConfiguration configuration;
    public transient BigInteger d;
    public transient ECParameterSpec ecSpec;
    public transient DERBitString publicKey;

    public BCECPrivateKey() {
        this.algorithm = "EC";
        new Hashtable();
        new Vector();
    }

    public BCECPrivateKey(String string, ECPrivateKeySpec eCPrivateKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        new Hashtable();
        new Vector();
        this.algorithm = string;
        this.d = eCPrivateKeySpec.getS();
        this.ecSpec = eCPrivateKeySpec.getParams();
        this.configuration = providerConfiguration;
    }

    public BCECPrivateKey(String string, PrivateKeyInfo privateKeyInfo, ProviderConfiguration providerConfiguration) throws IOException {
        this.algorithm = "EC";
        new Hashtable();
        new Vector();
        this.algorithm = string;
        this.configuration = providerConfiguration;
        X962Parameters x962Parameters = X962Parameters.getInstance((Object)privateKeyInfo.privateKeyAlgorithm.parameters);
        this.ecSpec = EC5Util.convertToSpec(x962Parameters, EC5Util.getCurve(this.configuration, x962Parameters));
        ASN1Encodable aSN1Encodable = privateKeyInfo.parsePrivateKey();
        if (aSN1Encodable instanceof ASN1Integer) {
            this.d = ASN1Integer.getInstance((Object)aSN1Encodable).getValue();
            return;
        }
        ECPrivateKey eCPrivateKey = ECPrivateKey.getInstance((Object)aSN1Encodable);
        this.d = new BigInteger(1, ((ASN1OctetString)eCPrivateKey.seq.getObjectAt((int)1)).string);
        this.publicKey = (DERBitString)eCPrivateKey.getObjectInTag(1);
    }

    /*
     * Exception decompiling
     */
    public BCECPrivateKey(String var1, ECPrivateKeyParameters var2, BCECPublicKey var3, ECParameterSpec var4, ProviderConfiguration var5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl61 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public BCECPrivateKey(String var1, ECPrivateKeyParameters var2, BCECPublicKey var3, org.bouncycastle.jce.spec.ECParameterSpec var4, ProviderConfiguration var5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl67 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public BCECPrivateKey(String string, ECPrivateKeyParameters eCPrivateKeyParameters, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        new Hashtable();
        new Vector();
        this.algorithm = string;
        this.d = eCPrivateKeyParameters.d;
        this.ecSpec = null;
        this.configuration = providerConfiguration;
    }

    public BCECPrivateKey(String string, org.bouncycastle.jce.spec.ECPrivateKeySpec eCPrivateKeySpec, ProviderConfiguration providerConfiguration) {
        ECParameterSpec eCParameterSpec;
        this.algorithm = "EC";
        new Hashtable();
        new Vector();
        this.algorithm = string;
        this.d = eCPrivateKeySpec.d;
        org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec2 = eCPrivateKeySpec.spec;
        if (eCParameterSpec2 != null) {
            ECCurve eCCurve = eCParameterSpec2.curve;
            eCParameterSpec = EC5Util.convertSpec(EC5Util.convertCurve(eCCurve), eCPrivateKeySpec.spec);
        } else {
            eCParameterSpec = null;
        }
        this.ecSpec = eCParameterSpec;
        this.configuration = providerConfiguration;
    }

    public BCECPrivateKey(java.security.interfaces.ECPrivateKey eCPrivateKey, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        new Hashtable();
        new Vector();
        this.d = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.ecSpec = eCPrivateKey.getParams();
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
        if (!(object instanceof BCECPrivateKey)) {
            return false;
        }
        BCECPrivateKey bCECPrivateKey = (BCECPrivateKey)object;
        boolean bl = this.d.equals((Object)bCECPrivateKey.d);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = this.engineGetSpec().equals(bCECPrivateKey.engineGetSpec());
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

    /*
     * Exception decompiling
     */
    public byte[] getEncoded() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Invisible function parameters on a non-constructor (or reads of uninitialised local variables).
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1560)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1816)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:332)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    public BigInteger getS() {
        return this.d;
    }

    public int hashCode() {
        return this.d.hashCode() ^ this.engineGetSpec().hashCode();
    }

    public String toString() {
        BigInteger bigInteger = this.d;
        org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = this.engineGetSpec();
        StringBuffer stringBuffer = new StringBuffer();
        String string = Strings.LINE_SEPARATOR;
        ECPoint eCPoint = new FixedPointCombMultiplier().multiply(eCParameterSpec.G, bigInteger).normalize();
        stringBuffer.append("EC");
        stringBuffer.append(" Private Key [");
        stringBuffer.append(R.style.generateKeyFingerprint((ECPoint)eCPoint, (org.bouncycastle.jce.spec.ECParameterSpec)eCParameterSpec));
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

