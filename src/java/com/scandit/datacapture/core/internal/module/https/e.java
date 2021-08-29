/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.X509TrustManager
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt__IndentKt
 *  okhttp3.Call
 *  okhttp3.Callback
 *  okhttp3.Headers
 *  okhttp3.Headers$Companion
 *  okhttp3.Interceptor
 *  okhttp3.MediaType
 *  okhttp3.MediaType$Companion
 *  okhttp3.OkHttpClient
 *  okhttp3.OkHttpClient$Builder
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.RequestBody
 *  okhttp3.RequestBody$Companion
 *  okhttp3.internal.connection.RealCall
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.tls.CertificateChainCleaner
 */
package com.scandit.datacapture.core.internal.module.https;

import com.scandit.datacapture.core.internal.module.https.NativeHttpsMethod;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsRequest;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsSession;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsSessionConfiguration;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsSessionDelegate;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsTask;
import com.scandit.datacapture.core.internal.module.https.a.d;
import com.scandit.datacapture.core.internal.module.https.b;
import com.scandit.datacapture.core.internal.module.https.c;
import com.scandit.datacapture.core.internal.module.https.g;
import com.scandit.datacapture.core.internal.module.https.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;

public final class e
extends NativeHttpsSession {
    public final OkHttpClient a;
    public final AtomicInteger b;
    public NativeHttpsSessionDelegate c;
    public final NativeHttpsSessionConfiguration d;
    public final d e;

    public e(NativeHttpsSessionConfiguration nativeHttpsSessionConfiguration, d d2) {
        block5 : {
            block6 : {
                long l2;
                boolean bl;
                j j2;
                OkHttpClient.Builder builder;
                boolean bl2;
                block8 : {
                    block7 : {
                        Intrinsics.checkNotNullParameter((Object)nativeHttpsSessionConfiguration, (String)"config");
                        Intrinsics.checkNotNullParameter((Object)d2, (String)"trust");
                        j2 = new j();
                        Intrinsics.checkNotNullParameter((Object)nativeHttpsSessionConfiguration, (String)"config");
                        Intrinsics.checkNotNullParameter((Object)d2, (String)"trust");
                        Intrinsics.checkNotNullParameter((Object)j2, (String)"connectivity");
                        this.d = nativeHttpsSessionConfiguration;
                        this.e = d2;
                        this.b = new AtomicInteger(0);
                        long l3 = nativeHttpsSessionConfiguration.timeoutInterval;
                        bl = nativeHttpsSessionConfiguration.allowsCellularAccess;
                        builder = new OkHttpClient.Builder();
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        Intrinsics.checkNotNullParameter((Object)timeUnit, (String)"unit");
                        Intrinsics.checkNotNullParameter((Object)"timeout", (String)"name");
                        long l4 = l3 LCMP 0L;
                        boolean bl3 = l4 >= 0;
                        if (!bl3) break block5;
                        l2 = timeUnit.toMillis(l3);
                        boolean bl4 = l2 <= (long)Integer.MAX_VALUE;
                        if (!bl4) break block6;
                        if (l2 != 0L) break block7;
                        bl2 = false;
                        if (l4 > 0) break block8;
                    }
                    bl2 = true;
                }
                if (bl2) {
                    builder.callTimeout = (int)l2;
                    builder.addInterceptor((Interceptor)new c(j2, bl));
                    com.scandit.datacapture.core.internal.module.https.a.e e2 = (com.scandit.datacapture.core.internal.module.https.a.e)d2;
                    SSLSocketFactory sSLSocketFactory = e2.a;
                    X509TrustManager x509TrustManager = e2.b;
                    Intrinsics.checkNotNullParameter((Object)sSLSocketFactory, (String)"sslSocketFactory");
                    Intrinsics.checkNotNullParameter((Object)x509TrustManager, (String)"trustManager");
                    if (!(true ^ Intrinsics.areEqual((Object)sSLSocketFactory, (Object)builder.sslSocketFactoryOrNull))) {
                        true ^ Intrinsics.areEqual((Object)x509TrustManager, (Object)builder.x509TrustManagerOrNull);
                    }
                    builder.sslSocketFactoryOrNull = sSLSocketFactory;
                    Intrinsics.checkNotNullParameter((Object)x509TrustManager, (String)"trustManager");
                    builder.certificateChainCleaner = Platform.platform.buildCertificateChainCleaner(x509TrustManager);
                    builder.x509TrustManagerOrNull = x509TrustManager;
                    this.a = new OkHttpClient(builder);
                    return;
                }
                throw new IllegalArgumentException("timeout too small.".toString());
            }
            throw new IllegalArgumentException("timeout too large.".toString());
        }
        throw new IllegalStateException("timeout < 0".toString());
    }

    @Override
    public final NativeHttpsSessionConfiguration getConfiguration() {
        return this.d;
    }

    @Override
    public final NativeHttpsSessionDelegate getDelegate() {
        return this.c;
    }

    @Override
    public final void setDelegate(NativeHttpsSessionDelegate nativeHttpsSessionDelegate) {
        this.c = nativeHttpsSessionDelegate;
    }

    @Override
    public final void shouldAllowExpiredCertificates(boolean bl) {
        this.e.a(bl);
    }

    @Override
    public final NativeHttpsTask startRequest(NativeHttpsRequest nativeHttpsRequest) {
        Intrinsics.checkNotNullParameter((Object)nativeHttpsRequest, (String)"request");
        String string = (String)nativeHttpsRequest.headers.get((Object)"Content-Type");
        MediaType mediaType = string != null ? MediaType.Companion.parse((String)string) : null;
        byte[] arrby = nativeHttpsRequest.body;
        RequestBody requestBody = arrby != null ? RequestBody.Companion.create$default((RequestBody.Companion)RequestBody.Companion, (byte[])arrby, (MediaType)mediaType, (int)0, (int)0, (int)6) : null;
        Request.Builder builder = new Request.Builder();
        builder.method(nativeHttpsRequest.method.toString(), requestBody);
        String string2 = nativeHttpsRequest.url;
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"url");
        builder.url(string2);
        Headers.Companion companion = Headers.Companion;
        HashMap<String, String> hashMap = nativeHttpsRequest.headers;
        Intrinsics.checkNotNullExpressionValue(hashMap, (String)"headers");
        Intrinsics.checkNotNullParameter(hashMap, (String)"$this$toHeaders");
        String[] arrstring = new String[2 * hashMap.size()];
        Iterator iterator = hashMap.entrySet().iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            String string3 = (String)entry.getKey();
            String string4 = (String)entry.getValue();
            Objects.requireNonNull((Object)string3, (String)"null cannot be cast to non-null type kotlin.CharSequence");
            String string5 = StringsKt__IndentKt.trim((CharSequence)string3).toString();
            Objects.requireNonNull((Object)string4, (String)"null cannot be cast to non-null type kotlin.CharSequence");
            String string6 = StringsKt__IndentKt.trim((CharSequence)string4).toString();
            companion.checkName(string5);
            companion.checkValue(string6, string5);
            arrstring[n2] = string5;
            arrstring[n2 + 1] = string6;
            n2 += 2;
        }
        builder.headers(new Headers(arrstring, null));
        Request request = builder.build();
        OkHttpClient okHttpClient = this.a;
        Objects.requireNonNull((Object)okHttpClient);
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        RealCall realCall = new RealCall(okHttpClient, request, false);
        int n3 = this.b.getAndIncrement();
        Intrinsics.checkNotNullParameter((Object)this, (String)"session");
        Intrinsics.checkNotNullParameter((Object)nativeHttpsRequest, (String)"request");
        Intrinsics.checkNotNullParameter((Object)realCall, (String)"call");
        g g2 = new g(this, nativeHttpsRequest, (Call)realCall, n3, 0);
        Objects.requireNonNull((Object)g2.e);
        g2.g.enqueue((Callback)g2);
        return g2;
    }
}

