/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.ui;

import com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import kotlin.jvm.internal.Intrinsics;

public final class DataCaptureViewProxyAdapter {
    public final NativeDataCaptureView a;
    public final ProxyCache b;

    public DataCaptureViewProxyAdapter(NativeDataCaptureView nativeDataCaptureView, ProxyCache proxyCache, int n2) {
        Object object = (n2 & 2) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureView, (String)"_NativeDataCaptureView");
        Intrinsics.checkNotNullParameter((Object)object, (String)"proxyCache");
        this.a = nativeDataCaptureView;
        this.b = object;
    }
}

