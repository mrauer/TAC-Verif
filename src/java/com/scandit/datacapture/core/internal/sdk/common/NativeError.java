/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.internal.sdk.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeError {
    public final int code;
    public final String message;

    public NativeError(String string, int n2) {
        this.message = string;
        this.code = n2;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeError{message=");
        stringBuilder.append(this.message);
        stringBuilder.append(",code=");
        return GeneratedOutlineSupport.outline20((StringBuilder)stringBuilder, (int)this.code, (String)"}");
    }
}

