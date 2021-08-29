/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.sdk.ui;

import com.scandit.datacapture.core.internal.sdk.ui.NativeNeedsRedrawDelegate;
import com.scandit.datacapture.core.internal.sdk.ui.NeedsRedrawListener;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import kotlin.jvm.internal.Intrinsics;

public final class NeedsRedrawListenerReversedAdapter
extends NativeNeedsRedrawDelegate {
    public final NeedsRedrawListener a;
    public final ProxyCache b;

    public NeedsRedrawListenerReversedAdapter(NeedsRedrawListener needsRedrawListener, ProxyCache proxyCache, int n2) {
        GuavaMapMakerProxyCache guavaMapMakerProxyCache = (n2 & 2) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)needsRedrawListener, (String)"_NeedsRedrawListener");
        Intrinsics.checkNotNullParameter((Object)guavaMapMakerProxyCache, (String)"proxyCache");
        this.a = needsRedrawListener;
        this.b = guavaMapMakerProxyCache;
    }

    @Override
    public final void setNeedsRedrawIn(int n2) {
        this.a.setNeedsRedrawInMillis(n2);
    }
}

