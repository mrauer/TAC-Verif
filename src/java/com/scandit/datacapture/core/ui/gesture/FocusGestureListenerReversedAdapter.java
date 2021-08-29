/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.ui.gesture.FocusGestureListenerReversedAdapter$a
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 */
package com.scandit.datacapture.core.ui.gesture;

import com.scandit.datacapture.core.common.geometry.PointWithUnit;
import com.scandit.datacapture.core.internal.module.ui.NativeFocusGesture;
import com.scandit.datacapture.core.internal.module.ui.NativeFocusGestureListener;
import com.scandit.datacapture.core.ui.gesture.FocusGesture;
import com.scandit.datacapture.core.ui.gesture.FocusGestureListener;
import com.scandit.datacapture.core.ui.gesture.FocusGestureListenerReversedAdapter;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

public final class FocusGestureListenerReversedAdapter
extends NativeFocusGestureListener {
    public final WeakReference<FocusGesture> a;
    public final FocusGestureListener b;
    public final ProxyCache c;

    public FocusGestureListenerReversedAdapter(FocusGestureListener focusGestureListener, FocusGesture focusGesture, ProxyCache proxyCache, int n2) {
        GuavaMapMakerProxyCache guavaMapMakerProxyCache = (n2 & 4) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)focusGestureListener, (String)"_FocusGestureListener");
        Intrinsics.checkNotNullParameter((Object)focusGesture, (String)"_FocusGesture");
        Intrinsics.checkNotNullParameter((Object)guavaMapMakerProxyCache, (String)"proxyCache");
        this.b = focusGestureListener;
        this.c = guavaMapMakerProxyCache;
        this.a = new WeakReference((Object)focusGesture);
    }

    @Override
    public final void onFocusGesture(NativeFocusGesture nativeFocusGesture, PointWithUnit pointWithUnit) {
        Intrinsics.checkNotNullParameter((Object)nativeFocusGesture, (String)"focusGesture");
        Intrinsics.checkNotNullParameter((Object)pointWithUnit, (String)"point");
        FocusGesture focusGesture = (FocusGesture)this.a.get();
        if (focusGesture != null) {
            Object v2 = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeFocusGesture.class), (Object)null, nativeFocusGesture, new a(focusGesture));
            Intrinsics.checkNotNullExpressionValue(v2, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            FocusGesture focusGesture2 = (FocusGesture)v2;
            this.b.onFocusGesture(focusGesture2, pointWithUnit);
        }
    }
}

