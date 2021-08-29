/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.barcode.capture;

import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSession;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import kotlin.jvm.internal.Intrinsics;

public final class BarcodeCaptureSessionProxyAdapter {
    public final NativeBarcodeCaptureSession a;
    public final ProxyCache b;

    public BarcodeCaptureSessionProxyAdapter(NativeBarcodeCaptureSession nativeBarcodeCaptureSession, ProxyCache proxyCache, int n2) {
        Object object = (n2 & 2) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)nativeBarcodeCaptureSession, (String)"_NativeBarcodeCaptureSession");
        Intrinsics.checkNotNullParameter((Object)object, (String)"proxyCache");
        this.a = nativeBarcodeCaptureSession;
        this.b = object;
    }
}

