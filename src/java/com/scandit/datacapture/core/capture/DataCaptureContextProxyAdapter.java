/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.capture;

import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import kotlin.jvm.internal.Intrinsics;

public final class DataCaptureContextProxyAdapter {
    public final NativeDataCaptureContext b;
    public final ProxyCache c;

    public DataCaptureContextProxyAdapter(NativeDataCaptureContext nativeDataCaptureContext, ProxyCache proxyCache, int n2) {
        Object object = (n2 & 2) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContext, (String)"_NativeDataCaptureContext");
        Intrinsics.checkNotNullParameter((Object)object, (String)"proxyCache");
        this.b = nativeDataCaptureContext;
        this.c = object;
    }
}

