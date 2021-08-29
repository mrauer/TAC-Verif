/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.sdk.capture;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeExpirationDateStatus
extends Enum<NativeExpirationDateStatus> {
    public static final /* enum */ NativeExpirationDateStatus AVAILABLE;
    public static final /* enum */ NativeExpirationDateStatus NOT_AVAILABLE;
    public static final /* enum */ NativeExpirationDateStatus PERPETUAL;
    private static final /* synthetic */ NativeExpirationDateStatus[] a;

    public static {
        NativeExpirationDateStatus nativeExpirationDateStatus;
        NativeExpirationDateStatus nativeExpirationDateStatus2;
        NativeExpirationDateStatus nativeExpirationDateStatus3;
        NOT_AVAILABLE = nativeExpirationDateStatus = new NativeExpirationDateStatus();
        AVAILABLE = nativeExpirationDateStatus3 = new NativeExpirationDateStatus();
        PERPETUAL = nativeExpirationDateStatus2 = new NativeExpirationDateStatus();
        a = new NativeExpirationDateStatus[]{nativeExpirationDateStatus, nativeExpirationDateStatus3, nativeExpirationDateStatus2};
    }

    public static NativeExpirationDateStatus valueOf(String string) {
        return (NativeExpirationDateStatus)Enum.valueOf(NativeExpirationDateStatus.class, (String)string);
    }

    public static NativeExpirationDateStatus[] values() {
        return (NativeExpirationDateStatus[])a.clone();
    }
}

