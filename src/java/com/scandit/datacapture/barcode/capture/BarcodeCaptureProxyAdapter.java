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

import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureMode;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import kotlin.jvm.internal.Intrinsics;

public final class BarcodeCaptureProxyAdapter {
    public final NativeDataCaptureMode a;
    public final NativeBarcodeCapture b;
    public final ProxyCache c;

    public BarcodeCaptureProxyAdapter(NativeBarcodeCapture nativeBarcodeCapture, ProxyCache proxyCache, int n2) {
        Object object = (n2 & 2) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)nativeBarcodeCapture, (String)"_NativeBarcodeCapture");
        Intrinsics.checkNotNullParameter((Object)object, (String)"proxyCache");
        this.b = nativeBarcodeCapture;
        this.c = object;
        NativeDataCaptureMode nativeDataCaptureMode = nativeBarcodeCapture.asDataCaptureMode();
        Intrinsics.checkNotNullExpressionValue((Object)nativeDataCaptureMode, (String)"_NativeBarcodeCapture.asDataCaptureMode()");
        this.a = nativeDataCaptureMode;
    }
}

