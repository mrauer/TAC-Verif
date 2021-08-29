/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.core.internal.module.https.a.b$a
 *  com.scandit.datacapture.core.internal.module.https.a.b$b
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.security.cert.CertificateException
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Objects
 *  javax.net.ssl.X509TrustManager
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.https.a;

import com.google.android.material.R;
import com.scandit.datacapture.core.internal.module.https.a.b;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.net.ssl.X509TrustManager;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class b
implements X509TrustManager {
    public final X509TrustManager[] a;

    public /* varargs */ b(X509TrustManager ... arrx509TrustManager) {
        Intrinsics.checkNotNullParameter((Object)arrx509TrustManager, (String)"trusts");
        this.a = arrx509TrustManager;
    }

    /*
     * Exception decompiling
     */
    public static <T> boolean a(T[] var0, Function1<? super T, Unit> var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl22 : ILOAD : trying to set 1 previously set to 0
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

    public final void checkClientTrusted(X509Certificate[] arrx509Certificate, String string) {
        Intrinsics.checkNotNullParameter((Object)arrx509Certificate, (String)"chain");
        Intrinsics.checkNotNullParameter((Object)string, (String)"authType");
        if (b.a(this.a, new a(arrx509Certificate, string))) {
            return;
        }
        throw new CertificateException("No trust could verify the client");
    }

    public final void checkServerTrusted(X509Certificate[] arrx509Certificate, String string) {
        Intrinsics.checkNotNullParameter((Object)arrx509Certificate, (String)"chain");
        Intrinsics.checkNotNullParameter((Object)string, (String)"authType");
        if (b.a(this.a, new b(arrx509Certificate, string))) {
            return;
        }
        throw new CertificateException("No trust could verify the server");
    }

    public final X509Certificate[] getAcceptedIssuers() {
        X509TrustManager[] arrx509TrustManager = this.a;
        ArrayList arrayList = new ArrayList();
        int n2 = arrx509TrustManager.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object[] arrobject = arrx509TrustManager[i2].getAcceptedIssuers();
            Intrinsics.checkNotNullExpressionValue((Object)arrobject, (String)"it.acceptedIssuers");
            ArraysKt___ArraysJvmKt.addAll((Collection)arrayList, (Iterable)R.style.asIterable((Object[])arrobject));
        }
        Object[] arrobject = arrayList.toArray((Object[])new X509Certificate[0]);
        Objects.requireNonNull((Object)arrobject, (String)"null cannot be cast to non-null type kotlin.Array<T>");
        return (X509Certificate[])arrobject;
    }
}

