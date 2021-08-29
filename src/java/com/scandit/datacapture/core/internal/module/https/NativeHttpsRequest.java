/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 */
package com.scandit.datacapture.core.internal.module.https;

import com.scandit.datacapture.core.internal.module.https.NativeHttpsMethod;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.HashMap;

@DjinniGenerated
public final class NativeHttpsRequest {
    public final byte[] body;
    public final HashMap<String, String> headers;
    public final NativeHttpsMethod method;
    public final String url;

    public NativeHttpsRequest(NativeHttpsMethod nativeHttpsMethod, String string, HashMap<String, String> hashMap, byte[] arrby) {
        this.method = nativeHttpsMethod;
        this.url = string;
        this.headers = hashMap;
        this.body = arrby;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final HashMap<String, String> getHeaders() {
        return this.headers;
    }

    public final NativeHttpsMethod getMethod() {
        return this.method;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeHttpsRequest{method=");
        stringBuilder.append((Object)this.method);
        stringBuilder.append(",url=");
        stringBuilder.append(this.url);
        stringBuilder.append(",headers=");
        stringBuilder.append(this.headers);
        stringBuilder.append(",body=");
        stringBuilder.append((Object)this.body);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

