/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.PublicKey
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 *  org.bouncycastle.pqc.crypto.xmss.XMSSKeyParameters
 *  org.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters
 */
package org.bouncycastle.pqc.jcajce.provider.xmss;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.xmss.XMSSKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;

public class BCXMSSPublicKey
implements PublicKey {
    public transient XMSSPublicKeyParameters keyParams;
    public transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        XMSSPublicKeyParameters xMSSPublicKeyParameters;
        this.keyParams = xMSSPublicKeyParameters = (XMSSPublicKeyParameters)PublicKeyFactory.createKey(subjectPublicKeyInfo);
        this.treeDigest = Nat576.getDigestOID(xMSSPublicKeyParameters.treeDigest);
    }

    /*
     * Exception decompiling
     */
    public boolean equals(Object var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl32.1 : ICONST_0 : trying to set 0 previously set to 1
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

    public final String getAlgorithm() {
        return "XMSS";
    }

    public byte[] getEncoded() {
        try {
            byte[] arrby = Nat576.createSubjectPublicKeyInfo((AsymmetricKeyParameter)this.keyParams).getEncoded();
            return arrby;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        int n2;
        int n3;
        try {
            n3 = this.treeDigest.hashCode();
            n2 = Nat576.hashCode(this.keyParams.getEncoded());
        }
        catch (IOException iOException) {
            return this.treeDigest.hashCode();
        }
        return n3 + n2 * 37;
    }
}

