/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.SecureRandom
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Iterator
 *  javax.net.ssl.KeyManager
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.X509TrustManager
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.https.a;

import com.scandit.datacapture.core.internal.module.https.a.a;
import com.scandit.datacapture.core.internal.module.https.a.b;
import com.scandit.datacapture.core.internal.module.https.a.d;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;

public final class e
implements d {
    public final SSLSocketFactory a;
    public final X509TrustManager b;
    public final X509TrustManager[] c;

    public /* varargs */ e(X509TrustManager ... arrx509TrustManager) {
        Intrinsics.checkNotNullParameter((Object)arrx509TrustManager, (String)"trustManagers");
        this.c = arrx509TrustManager;
        b b2 = new b((X509TrustManager[])Arrays.copyOf((Object[])arrx509TrustManager, (int)arrx509TrustManager.length));
        this.b = b2;
        SSLContext sSLContext = SSLContext.getInstance((String)"TLS");
        sSLContext.init(null, (TrustManager[])new X509TrustManager[]{b2}, null);
        Intrinsics.checkNotNullExpressionValue((Object)sSLContext, (String)"sslContext");
        SSLSocketFactory sSLSocketFactory = sSLContext.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue((Object)sSLSocketFactory, (String)"sslContext.socketFactory");
        this.a = sSLSocketFactory;
    }

    @Override
    public final void a(boolean bl) {
        X509TrustManager[] arrx509TrustManager = this.c;
        ArrayList arrayList = new ArrayList();
        for (X509TrustManager x509TrustManager : arrx509TrustManager) {
            if (!(x509TrustManager instanceof a)) continue;
            arrayList.add((Object)x509TrustManager);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((a)iterator.next()).a = bl;
        }
    }
}

