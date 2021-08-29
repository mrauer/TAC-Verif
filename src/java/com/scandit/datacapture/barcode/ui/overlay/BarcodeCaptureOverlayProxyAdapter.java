/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.barcode.ui.overlay;

import com.scandit.datacapture.barcode.internal.module.ui.NativeBarcodeCaptureOverlay;
import com.scandit.datacapture.core.internal.sdk.ui.overlay.NativeDataCaptureOverlay;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import kotlin.jvm.internal.Intrinsics;

public final class BarcodeCaptureOverlayProxyAdapter {
    public final NativeDataCaptureOverlay a;
    public final NativeBarcodeCaptureOverlay b;
    public final ProxyCache c;

    public BarcodeCaptureOverlayProxyAdapter(NativeBarcodeCaptureOverlay nativeBarcodeCaptureOverlay, ProxyCache proxyCache, int n2) {
        Object object = (n2 & 2) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)nativeBarcodeCaptureOverlay, (String)"_NativeBarcodeCaptureOverlay");
        Intrinsics.checkNotNullParameter((Object)object, (String)"proxyCache");
        this.b = nativeBarcodeCaptureOverlay;
        this.c = object;
        NativeDataCaptureOverlay nativeDataCaptureOverlay = nativeBarcodeCaptureOverlay.asDataCaptureOverlay();
        Intrinsics.checkNotNullExpressionValue((Object)nativeDataCaptureOverlay, (String)"_NativeBarcodeCaptureOve\u2026ay.asDataCaptureOverlay()");
        this.a = nativeDataCaptureOverlay;
    }
}

