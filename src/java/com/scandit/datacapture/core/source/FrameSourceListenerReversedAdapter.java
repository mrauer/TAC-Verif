/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.source.FrameSourceListenerReversedAdapter$a
 *  com.scandit.datacapture.core.source.FrameSourceListenerReversedAdapter$b
 *  com.scandit.datacapture.core.source.FrameSourceListenerReversedAdapter$c
 *  com.scandit.datacapture.core.source.FrameSourceListenerReversedAdapter$d
 *  com.scandit.datacapture.core.source.FrameSourceListenerReversedAdapter$e
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 */
package com.scandit.datacapture.core.source;

import com.scandit.datacapture.core.data.FrameData;
import com.scandit.datacapture.core.internal.module.source.NativeFrameSource;
import com.scandit.datacapture.core.internal.module.source.NativeFrameSourceListener;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.core.source.FrameSource;
import com.scandit.datacapture.core.source.FrameSourceListener;
import com.scandit.datacapture.core.source.FrameSourceListenerReversedAdapter;
import com.scandit.datacapture.core.source.FrameSourceState;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

public final class FrameSourceListenerReversedAdapter
extends NativeFrameSourceListener {
    public final WeakReference<FrameSource> a;
    public final FrameSourceListener b;
    public final ProxyCache c;

    public FrameSourceListenerReversedAdapter(FrameSourceListener frameSourceListener, FrameSource frameSource, ProxyCache proxyCache, int n2) {
        GuavaMapMakerProxyCache guavaMapMakerProxyCache = (n2 & 4) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)frameSourceListener, (String)"_FrameSourceListener");
        Intrinsics.checkNotNullParameter((Object)frameSource, (String)"_FrameSource");
        Intrinsics.checkNotNullParameter((Object)guavaMapMakerProxyCache, (String)"proxyCache");
        this.b = frameSourceListener;
        this.c = guavaMapMakerProxyCache;
        this.a = new WeakReference((Object)frameSource);
    }

    @Override
    public final void onFrameOutputAndroid(NativeFrameSource nativeFrameSource, NativeFrameData nativeFrameData) {
        Intrinsics.checkNotNullParameter((Object)nativeFrameSource, (String)"source");
        Intrinsics.checkNotNullParameter((Object)nativeFrameData, (String)"frame");
        FrameSource frameSource = (FrameSource)this.a.get();
        if (frameSource != null) {
            Object v2 = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeFrameSource.class), (Object)null, nativeFrameSource, new b(frameSource));
            Intrinsics.checkNotNullExpressionValue(v2, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            FrameSource frameSource2 = (FrameSource)v2;
            FrameData frameData = (FrameData)this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeFrameData.class), (Object)null, nativeFrameData, new a(this, nativeFrameSource, nativeFrameData));
            this.b.onFrameOutput(frameSource2, frameData);
        }
    }

    @Override
    public final void onObservationStarted(NativeFrameSource nativeFrameSource) {
        Intrinsics.checkNotNullParameter((Object)nativeFrameSource, (String)"source");
        FrameSource frameSource = (FrameSource)this.a.get();
        if (frameSource != null) {
            Object v2 = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeFrameSource.class), (Object)null, nativeFrameSource, new c(frameSource));
            Intrinsics.checkNotNullExpressionValue(v2, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            FrameSource frameSource2 = (FrameSource)v2;
            this.b.onObservationStarted(frameSource2);
        }
    }

    @Override
    public final void onObservationStopped(NativeFrameSource nativeFrameSource) {
        Intrinsics.checkNotNullParameter((Object)nativeFrameSource, (String)"source");
        FrameSource frameSource = (FrameSource)this.a.get();
        if (frameSource != null) {
            Object v2 = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeFrameSource.class), (Object)null, nativeFrameSource, new d(frameSource));
            Intrinsics.checkNotNullExpressionValue(v2, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            FrameSource frameSource2 = (FrameSource)v2;
            this.b.onObservationStopped(frameSource2);
        }
    }

    @Override
    public final void onStateChanged(NativeFrameSource nativeFrameSource, FrameSourceState frameSourceState) {
        Intrinsics.checkNotNullParameter((Object)nativeFrameSource, (String)"source");
        Intrinsics.checkNotNullParameter((Object)((Object)frameSourceState), (String)"newState");
        FrameSource frameSource = (FrameSource)this.a.get();
        if (frameSource != null) {
            Object v2 = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeFrameSource.class), (Object)null, nativeFrameSource, new e(frameSource));
            Intrinsics.checkNotNullExpressionValue(v2, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            FrameSource frameSource2 = (FrameSource)v2;
            this.b.onStateChanged(frameSource2, frameSourceState);
        }
    }
}

