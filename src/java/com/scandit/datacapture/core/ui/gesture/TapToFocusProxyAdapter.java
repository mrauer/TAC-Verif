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

import com.scandit.datacapture.core.internal.module.ui.NativeFocusGesture;
import com.scandit.datacapture.core.internal.module.ui.NativeTapToFocus;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import kotlin.jvm.internal.Intrinsics;

public final class TapToFocusProxyAdapter {
    public final NativeFocusGesture a;
    public final NativeTapToFocus b;
    public final ProxyCache c;

    public TapToFocusProxyAdapter(NativeTapToFocus nativeTapToFocus, ProxyCache proxyCache, int n2) {
        Object object = (n2 & 2) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)nativeTapToFocus, (String)"_NativeTapToFocus");
        Intrinsics.checkNotNullParameter((Object)object, (String)"proxyCache");
        this.b = nativeTapToFocus;
        this.c = object;
        NativeFocusGesture nativeFocusGesture = nativeTapToFocus.asFocusGesture();
        Intrinsics.checkNotNullExpressionValue((Object)nativeFocusGesture, (String)"_NativeTapToFocus.asFocusGesture()");
        this.a = nativeFocusGesture;
    }
}

