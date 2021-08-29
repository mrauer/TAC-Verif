/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.internal.sdk.ocr;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.scandit.datacapture.core.common.geometry.Quadrilateral;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeExternalOcrBackendResult {
    public final Quadrilateral location;
    public final String value;

    public NativeExternalOcrBackendResult(String string, Quadrilateral quadrilateral) {
        this.value = string;
        this.location = quadrilateral;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof NativeExternalOcrBackendResult)) {
            return false;
        }
        NativeExternalOcrBackendResult nativeExternalOcrBackendResult = (NativeExternalOcrBackendResult)object;
        return this.value.equals((Object)nativeExternalOcrBackendResult.value) && this.location.equals(nativeExternalOcrBackendResult.location);
    }

    public final Quadrilateral getLocation() {
        return this.location;
    }

    public final String getValue() {
        return this.value;
    }

    public final int hashCode() {
        return GeneratedOutlineSupport.outline3((String)this.value, (int)527, (int)31) + this.location.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeExternalOcrBackendResult{value=");
        stringBuilder.append(this.value);
        stringBuilder.append(",location=");
        stringBuilder.append((Object)this.location);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

