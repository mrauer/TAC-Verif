/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.capture.DataCaptureContextListenerReversedAdapter$a
 *  com.scandit.datacapture.core.capture.DataCaptureContextListenerReversedAdapter$b
 *  com.scandit.datacapture.core.capture.DataCaptureContextListenerReversedAdapter$c
 *  com.scandit.datacapture.core.capture.DataCaptureContextListenerReversedAdapter$d
 *  com.scandit.datacapture.core.capture.DataCaptureContextListenerReversedAdapter$e
 *  com.scandit.datacapture.core.capture.DataCaptureContextListenerReversedAdapter$f
 *  com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 */
package com.scandit.datacapture.core.capture;

import com.scandit.datacapture.core.capture.DataCaptureContext;
import com.scandit.datacapture.core.capture.DataCaptureContextListener;
import com.scandit.datacapture.core.capture.DataCaptureContextListenerReversedAdapter;
import com.scandit.datacapture.core.capture.DataCaptureMode;
import com.scandit.datacapture.core.common.ContextStatus;
import com.scandit.datacapture.core.internal.module.source.NativeFrameSource;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContextListener;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureMode;
import com.scandit.datacapture.core.internal.sdk.common.NativeContextStatus;
import com.scandit.datacapture.core.source.FrameSource;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

public final class DataCaptureContextListenerReversedAdapter
extends NativeDataCaptureContextListener {
    public final WeakReference<DataCaptureContext> a;
    public final DataCaptureContextListener b;
    public final ProxyCache c;

    public DataCaptureContextListenerReversedAdapter(DataCaptureContextListener dataCaptureContextListener, DataCaptureContext dataCaptureContext, ProxyCache proxyCache, int n2) {
        Object object = (n2 & 4) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)dataCaptureContextListener, (String)"contextListener");
        Intrinsics.checkNotNullParameter((Object)dataCaptureContext, (String)"captureContext");
        Intrinsics.checkNotNullParameter((Object)object, (String)"proxyCache");
        this.b = dataCaptureContextListener;
        this.c = object;
        this.a = new WeakReference((Object)dataCaptureContext);
    }

    @Override
    public final void onFrameSourceChanged(NativeDataCaptureContext nativeDataCaptureContext, NativeFrameSource nativeFrameSource) {
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContext, (String)"context");
        DataCaptureContext dataCaptureContext = (DataCaptureContext)this.a.get();
        if (dataCaptureContext != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeDataCaptureContext.class), (Object)null, nativeDataCaptureContext, new a(dataCaptureContext));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(\n   \u2026text\n            ) { it }");
            DataCaptureContext dataCaptureContext2 = (DataCaptureContext)v;
            FrameSource frameSource = nativeFrameSource == null ? null : (FrameSource)this.c.require(Reflection.getOrCreateKotlinClass(NativeFrameSource.class), null, nativeFrameSource);
            this.b.onFrameSourceChanged(dataCaptureContext2, frameSource);
        }
    }

    @Override
    public final void onModeAdded(NativeDataCaptureContext nativeDataCaptureContext, NativeDataCaptureMode nativeDataCaptureMode) {
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContext, (String)"context");
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureMode, (String)"mode");
        DataCaptureContext dataCaptureContext = (DataCaptureContext)this.a.get();
        if (dataCaptureContext != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeDataCaptureContext.class), (Object)null, nativeDataCaptureContext, new b(dataCaptureContext));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(\n   \u2026text\n            ) { it }");
            DataCaptureContext dataCaptureContext2 = (DataCaptureContext)v;
            DataCaptureMode dataCaptureMode = (DataCaptureMode)this.c.require(Reflection.getOrCreateKotlinClass(NativeDataCaptureMode.class), null, nativeDataCaptureMode);
            this.b.onModeAdded(dataCaptureContext2, dataCaptureMode);
        }
    }

    @Override
    public final void onModeRemoved(NativeDataCaptureContext nativeDataCaptureContext, NativeDataCaptureMode nativeDataCaptureMode) {
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContext, (String)"context");
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureMode, (String)"mode");
        DataCaptureContext dataCaptureContext = (DataCaptureContext)this.a.get();
        if (dataCaptureContext != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeDataCaptureContext.class), (Object)null, nativeDataCaptureContext, new c(dataCaptureContext));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(\n   \u2026text\n            ) { it }");
            DataCaptureContext dataCaptureContext2 = (DataCaptureContext)v;
            DataCaptureMode dataCaptureMode = (DataCaptureMode)this.c.require(Reflection.getOrCreateKotlinClass(NativeDataCaptureMode.class), null, nativeDataCaptureMode);
            this.b.onModeRemoved(dataCaptureContext2, dataCaptureMode);
        }
    }

    @Override
    public final void onObservationStarted(NativeDataCaptureContext nativeDataCaptureContext) {
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContext, (String)"context");
        DataCaptureContext dataCaptureContext = (DataCaptureContext)this.a.get();
        if (dataCaptureContext != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeDataCaptureContext.class), (Object)null, nativeDataCaptureContext, new d(dataCaptureContext));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(\n   \u2026text\n            ) { it }");
            DataCaptureContext dataCaptureContext2 = (DataCaptureContext)v;
            this.b.onObservationStarted(dataCaptureContext2);
        }
    }

    @Override
    public final void onObservationStopped(NativeDataCaptureContext nativeDataCaptureContext) {
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContext, (String)"context");
        DataCaptureContext dataCaptureContext = (DataCaptureContext)this.a.get();
        if (dataCaptureContext != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeDataCaptureContext.class), (Object)null, nativeDataCaptureContext, new e(dataCaptureContext));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(\n   \u2026text\n            ) { it }");
            DataCaptureContext dataCaptureContext2 = (DataCaptureContext)v;
            this.b.onObservationStopped(dataCaptureContext2);
        }
    }

    @Override
    public final void onStatusChanged(NativeDataCaptureContext nativeDataCaptureContext, NativeContextStatus nativeContextStatus) {
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContext, (String)"context");
        Intrinsics.checkNotNullParameter((Object)nativeContextStatus, (String)"status");
        DataCaptureContext dataCaptureContext = (DataCaptureContext)this.a.get();
        if (dataCaptureContext != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeDataCaptureContext.class), (Object)null, nativeDataCaptureContext, new f(dataCaptureContext));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(\n   \u2026text\n            ) { it }");
            DataCaptureContext dataCaptureContext2 = (DataCaptureContext)v;
            Intrinsics.checkNotNullParameter((Object)nativeContextStatus, (String)"source");
            ContextStatus contextStatus = new ContextStatus(nativeContextStatus);
            this.b.onStatusChanged(dataCaptureContext2, contextStatus);
        }
    }
}

