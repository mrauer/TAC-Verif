/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.internal.module.https;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeHttpsSessionConfiguration {
    public final boolean allowsCellularAccess;
    public final int timeoutInterval;

    public NativeHttpsSessionConfiguration(int n2, boolean bl) {
        this.timeoutInterval = n2;
        this.allowsCellularAccess = bl;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof NativeHttpsSessionConfiguration)) {
            return false;
        }
        NativeHttpsSessionConfiguration nativeHttpsSessionConfiguration = (NativeHttpsSessionConfiguration)object;
        return this.timeoutInterval == nativeHttpsSessionConfiguration.timeoutInterval && this.allowsCellularAccess == nativeHttpsSessionConfiguration.allowsCellularAccess;
    }

    public final boolean getAllowsCellularAccess() {
        return this.allowsCellularAccess;
    }

    public final int getTimeoutInterval() {
        return this.timeoutInterval;
    }

    public final int hashCode() {
        return 31 * (527 + this.timeoutInterval) + this.allowsCellularAccess;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeHttpsSessionConfiguration{timeoutInterval=");
        stringBuilder.append(this.timeoutInterval);
        stringBuilder.append(",allowsCellularAccess=");
        stringBuilder.append(this.allowsCellularAccess);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

