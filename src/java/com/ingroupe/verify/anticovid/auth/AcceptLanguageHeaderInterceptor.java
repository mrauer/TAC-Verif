/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Objects
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.collections.EmptyMap
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Headers
 *  okhttp3.Headers$Builder
 *  okhttp3.Headers$Companion
 *  okhttp3.HttpUrl
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.Request
 *  okhttp3.RequestBody
 *  okhttp3.Response
 *  okhttp3.internal.http.RealInterceptorChain
 */
package com.ingroupe.verify.anticovid.auth;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

public final class AcceptLanguageHeaderInterceptor
implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter((Object)chain, (String)"chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain)chain;
        Request request = realInterceptorChain.request;
        Objects.requireNonNull((Object)request);
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        new LinkedHashMap();
        HttpUrl httpUrl = request.url;
        String string = request.method;
        RequestBody requestBody = request.body;
        Object object = request.tags.isEmpty() ? new LinkedHashMap() : ArraysKt___ArraysJvmKt.toMutableMap((Map)request.tags);
        Headers.Builder builder = request.headers.newBuilder();
        String string2 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getDefault().language");
        Intrinsics.checkNotNullParameter((Object)"Accept-Language", (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        Intrinsics.checkNotNullParameter((Object)"Accept-Language", (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        Headers.Companion companion = Headers.Companion;
        companion.checkName("Accept-Language");
        companion.checkValue(string2, "Accept-Language");
        builder.removeAll("Accept-Language");
        builder.addLenient$okhttp("Accept-Language", string2);
        if (httpUrl != null) {
            EmptyMap emptyMap;
            Headers headers = builder.build();
            Intrinsics.checkNotNullParameter((Object)object, (String)"$this$toImmutableMap");
            if (object.isEmpty()) {
                emptyMap = EmptyMap.INSTANCE;
            } else {
                emptyMap = Collections.unmodifiableMap((Map)new LinkedHashMap((Map)object));
                Intrinsics.checkNotNullExpressionValue((Object)emptyMap, (String)"Collections.unmodifiableMap(LinkedHashMap(this))");
            }
            EmptyMap emptyMap2 = emptyMap;
            Request request2 = new Request(httpUrl, string, headers, requestBody, (Map)emptyMap2);
            return realInterceptorChain.proceed(request2);
        }
        throw new IllegalStateException("url == null".toString());
    }
}

