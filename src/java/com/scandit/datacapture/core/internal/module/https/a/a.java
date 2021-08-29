/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.security.cert.CertificateException
 *  java.security.cert.X509Certificate
 *  java.util.Date
 *  javax.net.ssl.X509TrustManager
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.https.a;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;

public final class a
implements X509TrustManager {
    public volatile boolean a;

    public final boolean a(X509Certificate[] arrx509Certificate) {
        if (!this.a) {
            boolean bl;
            block3 : {
                for (X509Certificate x509Certificate : arrx509Certificate) {
                    Intrinsics.checkNotNullParameter((Object)x509Certificate, (String)"$this$isExpired");
                    if (!x509Certificate.getNotAfter().after(new Date(System.currentTimeMillis()))) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
            if (bl) {
                return true;
            }
        }
        return false;
    }

    public final void checkClientTrusted(X509Certificate[] arrx509Certificate, String string) {
        Intrinsics.checkNotNullParameter((Object)arrx509Certificate, (String)"chain");
        Intrinsics.checkNotNullParameter((Object)string, (String)"authType");
        if (!this.a(arrx509Certificate)) {
            return;
        }
        throw new CertificateException("Certificate for client is expired and allowExpiredCertificates is false");
    }

    public final void checkServerTrusted(X509Certificate[] arrx509Certificate, String string) {
        Intrinsics.checkNotNullParameter((Object)arrx509Certificate, (String)"chain");
        Intrinsics.checkNotNullParameter((Object)string, (String)"authType");
        if (!this.a(arrx509Certificate)) {
            return;
        }
        throw new CertificateException("Certificate for server is expired and allowExpiredCertificates is false");
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}

