/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.ui.gesture;

import com.scandit.datacapture.core.internal.module.ui.NativeSwipeToZoom;
import com.scandit.datacapture.core.internal.module.ui.NativeZoomGesture;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import kotlin.jvm.internal.Intrinsics;

public final class SwipeToZoomProxyAdapter {
    public final NativeZoomGesture a;
    public final NativeSwipeToZoom b;
    public final ProxyCache c;

    public SwipeToZoomProxyAdapter(NativeSwipeToZoom nativeSwipeToZoom, ProxyCache proxyCache, int n2) {
        Object object = (n2 & 2) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)nativeSwipeToZoom, (String)"_NativeSwipeToZoom");
        Intrinsics.checkNotNullParameter((Object)object, (String)"proxyCache");
        this.b = nativeSwipeToZoom;
        this.c = object;
        NativeZoomGesture nativeZoomGesture = nativeSwipeToZoom.asZoomGesture();
        Intrinsics.checkNotNullExpressionValue((Object)nativeZoomGesture, (String)"_NativeSwipeToZoom.asZoomGesture()");
        this.a = nativeZoomGesture;
    }
}

