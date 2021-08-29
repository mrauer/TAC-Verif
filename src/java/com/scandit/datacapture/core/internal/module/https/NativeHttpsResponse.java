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

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.HashMap;

@DjinniGenerated
public final class NativeHttpsResponse {
    public final byte[] body;
    public final HashMap<String, String> headers;
    public final int statusCode;

    public NativeHttpsResponse(int n2, HashMap<String, String> hashMap, byte[] arrby) {
        this.statusCode = n2;
        this.headers = hashMap;
        this.body = arrby;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final HashMap<String, String> getHeaders() {
        return this.headers;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeHttpsResponse{statusCode=");
        stringBuilder.append(this.statusCode);
        stringBuilder.append(",headers=");
        stringBuilder.append(this.headers);
        stringBuilder.append(",body=");
        stringBuilder.append((Object)this.body);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

