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

import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContextSettings;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import kotlin.jvm.internal.Intrinsics;

public final class DataCaptureContextSettingsProxyAdapter {
    public final NativeDataCaptureContextSettings a;
    public final ProxyCache b;

    public DataCaptureContextSettingsProxyAdapter(NativeDataCaptureContextSettings nativeDataCaptureContextSettings, ProxyCache proxyCache, int n2) {
        Object object = (n2 & 2) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContextSettings, (String)"_NativeDataCaptureContextSettings");
        Intrinsics.checkNotNullParameter((Object)object, (String)"proxyCache");
        this.a = nativeDataCaptureContextSettings;
        this.b = object;
    }
}

