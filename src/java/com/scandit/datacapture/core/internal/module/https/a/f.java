/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.AssetManager
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.io.Closeable
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.KeyStore
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateFactory
 *  java.security.cert.X509Certificate
 *  java.util.Objects
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  javax.net.ssl.X509TrustManager
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.https.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import com.google.android.material.R;
import com.scandit.datacapture.core.internal.sdk.AppAndroidEnvironment;
import java.io.Closeable;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Objects;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;

@SuppressLint(value={"TrustAllX509TrustManager"})
public final class f
implements X509TrustManager {
    public final /* synthetic */ X509TrustManager a;

    public f(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"assetName");
        Context context = AppAndroidEnvironment.applicationContext;
        if (context != null) {
            Certificate certificate;
            InputStream inputStream = context.getAssets().open(string);
            Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"context.assets.open(certificateAssetName)");
            CertificateFactory certificateFactory = CertificateFactory.getInstance((String)"X.509");
            try {
                certificate = certificateFactory.generateCertificate(inputStream);
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    R.style.closeFinally((Closeable)inputStream, (Throwable)throwable);
                    throw throwable2;
                }
            }
            R.style.closeFinally((Closeable)inputStream, null);
            KeyStore keyStore = KeyStore.getInstance((String)KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("scandit_certificate", certificate);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance((String)TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            Intrinsics.checkNotNullExpressionValue((Object)trustManagerFactory, (String)"trustManagerFactory");
            TrustManager trustManager = trustManagerFactory.getTrustManagers()[0];
            Objects.requireNonNull((Object)trustManager, (String)"null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            this.a = (X509TrustManager)trustManager;
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
        throw null;
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

