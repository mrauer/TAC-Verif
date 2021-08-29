/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Objects
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.collections.EmptyMap
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Headers
 *  okhttp3.Headers$Builder
 *  okhttp3.HttpUrl
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.Request
 *  okhttp3.RequestBody
 *  okhttp3.Response
 *  okhttp3.internal.http.RealInterceptorChain
 */
package com.ingroupe.verify.anticovid.auth;

import android.content.Context;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
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

public final class AddAuthorizationInterceptor
implements Interceptor {
    public AddAuthorizationInterceptor(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
    }

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
        Intrinsics.checkNotNullParameter((Object)"Authorization", (String)"name");
        Intrinsics.checkNotNullParameter((Object)"Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJqUG0zZ1BzUlZaMWRRUmhHOG1HMGhFN3Jlb2ZXTTNINzJCV1RtajdJcFd3In0.eyJleHAiOjE2ODUxODU5MDYsImlhdCI6MTYyMjExMzkwNiwianRpIjoiOTdjODgyM2EtNjlhZS00NzA4LWE4N2UtNzYxM2NhNGU3ODU5IiwiaXNzIjoiaHR0cHM6Ly9hdXRoLm1lc3NlcnZpY2VzLmluZ3JvdXBlLmNvbS9hdXRoL3JlYWxtcy9QSU5HIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImVhMWY1NWVlLTUxMGMtNGMxNi05MWQ4LTE1MjI4OGJhZDViYSIsInR5cCI6IkJlYXJlciIsImF6cCI6InRhY3YtY2xpZW50LWxpdGUiLCJzZXNzaW9uX3N0YXRlIjoiNjk5ODExY2YtODFlZS00ZmNkLTk4NDctY2FkMGJmYjZhOTdiIiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJST0xFX1ZFUklGWV9DT05UUk9MXzJERE9DX0wxIiwiUk9MRV9WRVJJRllfQ09OVFJPTF8yRERPQ19CMiIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUgb2ZmbGluZV9hY2Nlc3MiLCJzaXJlbiI6IjAwMDAwMDAwMCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwicHJlZmVycmVkX3VzZXJuYW1lIjoidGFjdi1tb2JpbGUtbGl0ZSIsImdpdmVuX25hbWUiOiIiLCJmYW1pbHlfbmFtZSI6IiJ9.mpfrIP8ayElTm7yoVayCF11oYrDQEnauk9hbbVBw8idAiE6OsMlWNloZtUbbnwrJZsMX3_NoEyzkiB3HNbxyhPWp7eRZ7qhn8XjZVgg6sVytXqcVZo9R5-Q9JftMKv7JelsY3PsaOo5x-pYOX30ancPRjd78TeenorGopsVN_LLRLQpenfgjjgwx-srZnLa-TFYTcbSvXozfJT7uk5CHyz_MIFLM7pl9Zdt66yTGBkLIyOLFsV5vPeH5SYvgRNDYdxZy4XMo6Gyfz0lAI9Xfcjs20NBoOQMV4JREH4Z-IcJJXeszC9QeA1-tRmxujqIRuyvBal7msLy7Zimd2q7i3Q", (String)"value");
        builder.add("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJqUG0zZ1BzUlZaMWRRUmhHOG1HMGhFN3Jlb2ZXTTNINzJCV1RtajdJcFd3In0.eyJleHAiOjE2ODUxODU5MDYsImlhdCI6MTYyMjExMzkwNiwianRpIjoiOTdjODgyM2EtNjlhZS00NzA4LWE4N2UtNzYxM2NhNGU3ODU5IiwiaXNzIjoiaHR0cHM6Ly9hdXRoLm1lc3NlcnZpY2VzLmluZ3JvdXBlLmNvbS9hdXRoL3JlYWxtcy9QSU5HIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImVhMWY1NWVlLTUxMGMtNGMxNi05MWQ4LTE1MjI4OGJhZDViYSIsInR5cCI6IkJlYXJlciIsImF6cCI6InRhY3YtY2xpZW50LWxpdGUiLCJzZXNzaW9uX3N0YXRlIjoiNjk5ODExY2YtODFlZS00ZmNkLTk4NDctY2FkMGJmYjZhOTdiIiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJST0xFX1ZFUklGWV9DT05UUk9MXzJERE9DX0wxIiwiUk9MRV9WRVJJRllfQ09OVFJPTF8yRERPQ19CMiIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUgb2ZmbGluZV9hY2Nlc3MiLCJzaXJlbiI6IjAwMDAwMDAwMCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwicHJlZmVycmVkX3VzZXJuYW1lIjoidGFjdi1tb2JpbGUtbGl0ZSIsImdpdmVuX25hbWUiOiIiLCJmYW1pbHlfbmFtZSI6IiJ9.mpfrIP8ayElTm7yoVayCF11oYrDQEnauk9hbbVBw8idAiE6OsMlWNloZtUbbnwrJZsMX3_NoEyzkiB3HNbxyhPWp7eRZ7qhn8XjZVgg6sVytXqcVZo9R5-Q9JftMKv7JelsY3PsaOo5x-pYOX30ancPRjd78TeenorGopsVN_LLRLQpenfgjjgwx-srZnLa-TFYTcbSvXozfJT7uk5CHyz_MIFLM7pl9Zdt66yTGBkLIyOLFsV5vPeH5SYvgRNDYdxZy4XMo6Gyfz0lAI9Xfcjs20NBoOQMV4JREH4Z-IcJJXeszC9QeA1-tRmxujqIRuyvBal7msLy7Zimd2q7i3Q");
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

