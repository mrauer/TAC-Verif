/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.scandit.datacapture.core.internal.module.ui.NativeGestureListener;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import kotlin.jvm.internal.Intrinsics;

public final class c {
    public final NativeGestureListener a;

    public c(NativeGestureListener nativeGestureListener, ProxyCache proxyCache, int n2) {
        GuavaMapMakerProxyCache guavaMapMakerProxyCache = ProxyCacheKt.a;
        Intrinsics.checkNotNullParameter((Object)nativeGestureListener, (String)"_NativeGestureListener");
        Intrinsics.checkNotNullParameter((Object)guavaMapMakerProxyCache, (String)"proxyCache");
        this.a = nativeGestureListener;
    }
}

