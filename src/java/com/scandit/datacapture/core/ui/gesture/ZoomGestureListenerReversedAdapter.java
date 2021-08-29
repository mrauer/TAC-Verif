/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.ui.gesture.ZoomGestureListenerReversedAdapter$a
 *  com.scandit.datacapture.core.ui.gesture.ZoomGestureListenerReversedAdapter$b
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 */
package com.scandit.datacapture.core.ui.gesture;

import com.scandit.datacapture.core.internal.module.ui.NativeZoomGesture;
import com.scandit.datacapture.core.internal.module.ui.NativeZoomGestureListener;
import com.scandit.datacapture.core.ui.gesture.ZoomGesture;
import com.scandit.datacapture.core.ui.gesture.ZoomGestureListener;
import com.scandit.datacapture.core.ui.gesture.ZoomGestureListenerReversedAdapter;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

public final class ZoomGestureListenerReversedAdapter
extends NativeZoomGestureListener {
    public final WeakReference<ZoomGesture> a;
    public final ZoomGestureListener b;
    public final ProxyCache c;

    public ZoomGestureListenerReversedAdapter(ZoomGestureListener zoomGestureListener, ZoomGesture zoomGesture, ProxyCache proxyCache, int n2) {
        GuavaMapMakerProxyCache guavaMapMakerProxyCache = (n2 & 4) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)zoomGestureListener, (String)"_ZoomGestureListener");
        Intrinsics.checkNotNullParameter((Object)zoomGesture, (String)"_ZoomGesture");
        Intrinsics.checkNotNullParameter((Object)guavaMapMakerProxyCache, (String)"proxyCache");
        this.b = zoomGestureListener;
        this.c = guavaMapMakerProxyCache;
        this.a = new WeakReference((Object)zoomGesture);
    }

    @Override
    public final void onZoomInGesture(NativeZoomGesture nativeZoomGesture) {
        Intrinsics.checkNotNullParameter((Object)nativeZoomGesture, (String)"zoomGesture");
        ZoomGesture zoomGesture = (ZoomGesture)this.a.get();
        if (zoomGesture != null) {
            Object v2 = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeZoomGesture.class), (Object)null, nativeZoomGesture, new a(zoomGesture));
            Intrinsics.checkNotNullExpressionValue(v2, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            ZoomGesture zoomGesture2 = (ZoomGesture)v2;
            this.b.onZoomInGesture(zoomGesture2);
        }
    }

    @Override
    public final void onZoomOutGesture(NativeZoomGesture nativeZoomGesture) {
        Intrinsics.checkNotNullParameter((Object)nativeZoomGesture, (String)"zoomGesture");
        ZoomGesture zoomGesture = (ZoomGesture)this.a.get();
        if (zoomGesture != null) {
            Object v2 = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeZoomGesture.class), (Object)null, nativeZoomGesture, new b(zoomGesture));
            Intrinsics.checkNotNullExpressionValue(v2, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            ZoomGesture zoomGesture2 = (ZoomGesture)v2;
            this.b.onZoomOutGesture(zoomGesture2);
        }
    }
}

