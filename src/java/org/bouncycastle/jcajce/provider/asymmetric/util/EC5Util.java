/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.math.BigInteger
 *  java.security.spec.ECField
 *  java.security.spec.ECFieldF2m
 *  java.security.spec.ECFieldFp
 *  java.security.spec.ECParameterSpec
 *  java.security.spec.ECPoint
 *  java.security.spec.EllipticCurve
 *  java.util.Collections
 *  java.util.Enumeration
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Set
 *  java.util.Vector
 *  org.bouncycastle.asn1.ASN1Null
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.ASN1Sequence
 *  org.bouncycastle.asn1.x9.X962Parameters
 *  org.bouncycastle.asn1.x9.X9ECParameters
 *  org.bouncycastle.crypto.params.ECDomainParameters
 *  org.bouncycastle.jce.provider.BouncyCastleProviderConfiguration
 *  org.bouncycastle.jce.spec.ECNamedCurveParameterSpec
 *  org.bouncycastle.math.ec.ECCurve$F2m
 *  org.bouncycastle.math.ec.ECCurve$Fp
 *  org.bouncycastle.math.ec.ECFieldElement
 *  org.bouncycastle.math.field.PolynomialExtensionField
 */
package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.google.android.material.R;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProviderConfiguration;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.GF2Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.math.raw.Nat576;

/*
 * Exception performing whole class analysis.
 */
public class EC5Util {
    public static Map customCurves;

    public static {
        customCurves = new HashMap();
        Enumeration enumeration = CustomNamedCurves.names.elements();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            X9ECParameters x9ECParameters = R.style.getByName((String)string);
            if (x9ECParameters == null) continue;
            customCurves.put((Object)x9ECParameters.curve, (Object)CustomNamedCurves.getByName((String)string).curve);
        }
        ECCurve eCCurve = CustomNamedCurves.getByName((String)"Curve25519").curve;
        Map map = customCurves;
        ECCurve.Fp fp = new /* Unavailable Anonymous Inner Class!! */;
        map.put((Object)fp, (Object)eCCurve);
    }

    public static EllipticCurve convertCurve(ECCurve eCCurve) {
        ECFieldFp eCFieldFp;
        FiniteField finiteField = eCCurve.field;
        boolean bl = finiteField.getDimension() == 1;
        if (bl) {
            eCFieldFp = new ECFieldFp(finiteField.getCharacteristic());
        } else {
            GF2Polynomial gF2Polynomial = ((PolynomialExtensionField)finiteField).getMinimalPolynomial();
            int[] arrn = gF2Polynomial.getExponentsPresent();
            int n2 = Nat576.getLength(1, arrn.length - 1);
            int[] arrn2 = new int[n2];
            System.arraycopy((Object)arrn, (int)1, (Object)arrn2, (int)0, (int)Math.min((int)(arrn.length - 1), (int)n2));
            int[] arrn3 = Nat576.reverse(arrn2);
            eCFieldFp = new ECFieldF2m(gF2Polynomial.getDegree(), arrn3);
        }
        return new EllipticCurve((ECField)eCFieldFp, eCCurve.a.toBigInteger(), eCCurve.b.toBigInteger(), null);
    }

    public static ECCurve convertCurve(EllipticCurve ellipticCurve) {
        block17 : {
            BigInteger bigInteger;
            int n2;
            BigInteger bigInteger2;
            int[] arrn;
            block16 : {
                int[] arrn2;
                block15 : {
                    ECField eCField = ellipticCurve.getField();
                    bigInteger2 = ellipticCurve.getA();
                    bigInteger = ellipticCurve.getB();
                    if (eCField instanceof ECFieldFp) {
                        BigInteger bigInteger3 = ((ECFieldFp)eCField).getP();
                        Object object = new /* Unavailable Anonymous Inner Class!! */;
                        if (customCurves.containsKey(object)) {
                            object = (ECCurve)customCurves.get(object);
                        }
                        return object;
                    }
                    ECFieldF2m eCFieldF2m = (ECFieldF2m)eCField;
                    n2 = eCFieldF2m.getM();
                    arrn2 = eCFieldF2m.getMidTermsOfReductionPolynomial();
                    arrn = new int[3];
                    if (arrn2.length != 1) break block15;
                    arrn[0] = arrn2[0];
                    break block16;
                }
                if (arrn2.length != 3) break block17;
                if (arrn2[0] < arrn2[1] && arrn2[0] < arrn2[2]) {
                    arrn[0] = arrn2[0];
                    if (arrn2[1] < arrn2[2]) {
                        arrn[1] = arrn2[1];
                        arrn[2] = arrn2[2];
                    } else {
                        arrn[1] = arrn2[2];
                        arrn[2] = arrn2[1];
                    }
                } else if (arrn2[1] < arrn2[2]) {
                    arrn[0] = arrn2[1];
                    if (arrn2[0] < arrn2[2]) {
                        arrn[1] = arrn2[0];
                        arrn[2] = arrn2[2];
                    } else {
                        arrn[1] = arrn2[2];
                        arrn[2] = arrn2[0];
                    }
                } else {
                    arrn[0] = arrn2[2];
                    if (arrn2[0] < arrn2[1]) {
                        arrn[1] = arrn2[0];
                        arrn[2] = arrn2[1];
                    } else {
                        arrn[1] = arrn2[1];
                        arrn[2] = arrn2[0];
                    }
                }
            }
            ECCurve.F2m f2m = new /* Unavailable Anonymous Inner Class!! */;
            return f2m;
        }
        throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
    }

    public static ECPoint convertPoint(org.bouncycastle.math.ec.ECPoint eCPoint) {
        org.bouncycastle.math.ec.ECPoint eCPoint2 = eCPoint.normalize();
        return new ECPoint(eCPoint2.getAffineXCoord().toBigInteger(), eCPoint2.getAffineYCoord().toBigInteger());
    }

    public static org.bouncycastle.math.ec.ECPoint convertPoint(ECParameterSpec eCParameterSpec, ECPoint eCPoint) {
        return EC5Util.convertCurve(eCParameterSpec.getCurve()).createPoint(eCPoint.getAffineX(), eCPoint.getAffineY());
    }

    public static org.bouncycastle.math.ec.ECPoint convertPoint(ECCurve eCCurve, ECPoint eCPoint) {
        return eCCurve.createPoint(eCPoint.getAffineX(), eCPoint.getAffineY());
    }

    public static ECParameterSpec convertSpec(EllipticCurve ellipticCurve, org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECPoint eCPoint = EC5Util.convertPoint(eCParameterSpec.G);
        if (eCParameterSpec instanceof ECNamedCurveParameterSpec) {
            String string = ((ECNamedCurveParameterSpec)eCParameterSpec).name;
            ECNamedCurveSpec eCNamedCurveSpec = new ECNamedCurveSpec(string, ellipticCurve, eCPoint, eCParameterSpec.n, eCParameterSpec.h);
            return eCNamedCurveSpec;
        }
        return new ECParameterSpec(ellipticCurve, eCPoint, eCParameterSpec.n, eCParameterSpec.h.intValue());
    }

    public static org.bouncycastle.jce.spec.ECParameterSpec convertSpec(ECParameterSpec eCParameterSpec) {
        ECCurve eCCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
        org.bouncycastle.math.ec.ECPoint eCPoint = EC5Util.convertPoint(eCCurve, eCParameterSpec.getGenerator());
        BigInteger bigInteger = eCParameterSpec.getOrder();
        BigInteger bigInteger2 = BigInteger.valueOf((long)eCParameterSpec.getCofactor());
        byte[] arrby = eCParameterSpec.getCurve().getSeed();
        if (eCParameterSpec instanceof ECNamedCurveSpec) {
            ECNamedCurveParameterSpec eCNamedCurveParameterSpec = new ECNamedCurveParameterSpec(((ECNamedCurveSpec)eCParameterSpec).name, eCCurve, eCPoint, bigInteger, bigInteger2, arrby);
            return eCNamedCurveParameterSpec;
        }
        org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec2 = new org.bouncycastle.jce.spec.ECParameterSpec(eCCurve, eCPoint, bigInteger, bigInteger2, arrby);
        return eCParameterSpec2;
    }

    /*
     * Exception decompiling
     */
    public static ECParameterSpec convertToSpec(X962Parameters var0, ECCurve var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ECCurve getCurve(ProviderConfiguration providerConfiguration, X962Parameters x962Parameters) {
        X9ECParameters x9ECParameters;
        Set set = Collections.unmodifiableSet((Set)((BouncyCastleProviderConfiguration)providerConfiguration).acceptableNamedCurves);
        ASN1Primitive aSN1Primitive = x962Parameters.params;
        if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance((Object)aSN1Primitive);
            if (!set.isEmpty() && !set.contains((Object)aSN1ObjectIdentifier)) {
                throw new IllegalStateException("named curve not acceptable");
            }
            X9ECParameters x9ECParameters2 = R.style.getNamedCurveByOid((ASN1ObjectIdentifier)aSN1ObjectIdentifier);
            if (x9ECParameters2 != null) return x9ECParameters2.curve;
            x9ECParameters2 = (X9ECParameters)((BouncyCastleProviderConfiguration)providerConfiguration).getAdditionalECParameters().get((Object)aSN1ObjectIdentifier);
            return x9ECParameters2.curve;
        }
        if (aSN1Primitive instanceof ASN1Null) {
            return ((BouncyCastleProviderConfiguration)providerConfiguration).getEcImplicitlyCa().curve;
        }
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance((Object)aSN1Primitive);
        if (!set.isEmpty()) throw new IllegalStateException("encoded parameters not acceptable");
        if (aSN1Sequence.size() > 3) {
            x9ECParameters = X9ECParameters.getInstance((Object)aSN1Sequence);
            do {
                return x9ECParameters.curve;
                break;
            } while (true);
        }
        x9ECParameters = ECGOST3410NamedCurves.getByOIDX9(ASN1ObjectIdentifier.getInstance((Object)aSN1Sequence.getObjectAt(0)));
        return x9ECParameters.curve;
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration providerConfiguration, ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec == null) {
            org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec2 = ((BouncyCastleProviderConfiguration)providerConfiguration).getEcImplicitlyCa();
            ECDomainParameters eCDomainParameters = new ECDomainParameters(eCParameterSpec2.curve, eCParameterSpec2.G, eCParameterSpec2.n, eCParameterSpec2.h, eCParameterSpec2.seed);
            return eCDomainParameters;
        }
        return R.style.getDomainParameters((ProviderConfiguration)providerConfiguration, (org.bouncycastle.jce.spec.ECParameterSpec)EC5Util.convertSpec(eCParameterSpec));
    }
}

