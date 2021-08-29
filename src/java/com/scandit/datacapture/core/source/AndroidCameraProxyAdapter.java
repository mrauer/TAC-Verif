/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.source;

import com.scandit.datacapture.core.internal.module.source.NativeFrameSource;
import com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedFuture;
import com.scandit.datacapture.core.internal.sdk.source.NativeAndroidCamera;
import com.scandit.datacapture.core.source.FrameSourceState;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import kotlin.jvm.internal.Intrinsics;

public final class AndroidCameraProxyAdapter {
    public final NativeFrameSource a;
    public final NativeAndroidCamera b;
    public final ProxyCache c;

    public AndroidCameraProxyAdapter(NativeAndroidCamera nativeAndroidCamera, ProxyCache proxyCache, int n2) {
        Object object = (n2 & 2) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)nativeAndroidCamera, (String)"_NativeAndroidCamera");
        Intrinsics.checkNotNullParameter((Object)object, (String)"proxyCache");
        this.b = nativeAndroidCamera;
        this.c = object;
        NativeFrameSource nativeFrameSource = nativeAndroidCamera.asFrameSource();
        Intrinsics.checkNotNullExpressionValue((Object)nativeFrameSource, (String)"_NativeAndroidCamera.asFrameSource()");
        this.a = nativeFrameSource;
    }

    public final NativeWrappedFuture _switchToDesiredState(FrameSourceState frameSourceState) {
        Intrinsics.checkNotNullParameter((Object)((Object)frameSourceState), (String)"desiredState");
        NativeWrappedFuture nativeWrappedFuture = this.b.switchToDesiredStateAsyncAndroid(frameSourceState);
        Intrinsics.checkNotNullExpressionValue((Object)nativeWrappedFuture, (String)"_0");
        return nativeWrappedFuture;
    }
}

