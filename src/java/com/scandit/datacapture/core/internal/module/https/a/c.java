/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.security.GeneralSecurityException
 *  java.security.KeyStore
 *  java.security.cert.X509Certificate
 *  java.util.Arrays
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  javax.net.ssl.X509TrustManager
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.https.a;

import android.annotation.SuppressLint;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;

@SuppressLint(value={"TrustAllX509TrustManager"})
public final class c
implements X509TrustManager {
    public final /* synthetic */ X509TrustManager a;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public c() {
        block4 : {
            super();
            try {
                var2_1 = TrustManagerFactory.getInstance((String)TrustManagerFactory.getDefaultAlgorithm());
                var2_1.init(null);
                Intrinsics.checkNotNullExpressionValue((Object)var2_1, (String)"trustManagerFactory");
                var3_2 = var2_1.getTrustManagers();
                var4_3 = var3_2.length;
                var5_4 = 1;
                if (var4_3 != var5_4 || !(var3_2[0] instanceof X509TrustManager)) {
                    var5_4 = 0;
                }
                if (var5_4 == 0) ** GOTO lbl21
                var6_5 = var3_2[0];
                if (var6_5 == null) break block4;
            }
            catch (GeneralSecurityException var1_8) {
                throw new AssertionError("No System TLS", (Throwable)var1_8);
            }
            this.a = var7_6 = (X509TrustManager)var6_5;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
lbl21: // 1 sources:
        var8_7 = new StringBuilder("Unexpected default trust managers: ");
        var8_7.append(Arrays.toString((Object[])var3_2));
        throw new IllegalStateException(var8_7.toString().toString());
    }

    public final void checkClientTrusted(X509Certificate[] arrx509Certificate, String string) {
        this.a.checkClientTrusted(arrx509Certificate, string);
    }

    public final void checkServerTrusted(X509Certificate[] arrx509Certificate, String string) {
        this.a.checkServerTrusted(arrx509Certificate, string);
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return this.a.getAcceptedIssuers();
    }
}

