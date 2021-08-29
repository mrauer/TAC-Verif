/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.capture.DataCaptureContextFrameListenerReversedAdapter$a
 *  com.scandit.datacapture.core.capture.DataCaptureContextFrameListenerReversedAdapter$b
 *  com.scandit.datacapture.core.capture.DataCaptureContextFrameListenerReversedAdapter$c
 *  com.scandit.datacapture.core.capture.DataCaptureContextFrameListenerReversedAdapter$d
 *  com.scandit.datacapture.core.capture.DataCaptureContextFrameListenerReversedAdapter$e
 *  com.scandit.datacapture.core.capture.DataCaptureContextFrameListenerReversedAdapter$f
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
import com.scandit.datacapture.core.capture.DataCaptureContextFrameListener;
import com.scandit.datacapture.core.capture.DataCaptureContextFrameListenerReversedAdapter;
import com.scandit.datacapture.core.data.FrameData;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContextFrameListener;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

public final class DataCaptureContextFrameListenerReversedAdapter
extends NativeDataCaptureContextFrameListener {
    public final WeakReference<DataCaptureContext> a;
    public final DataCaptureContextFrameListener b;
    public final ProxyCache c;

    public DataCaptureContextFrameListenerReversedAdapter(DataCaptureContextFrameListener dataCaptureContextFrameListener, DataCaptureContext dataCaptureContext, ProxyCache proxyCache, int n2) {
        Object object = (n2 & 4) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)dataCaptureContextFrameListener, (String)"_DataCaptureContextFrameListener");
        Intrinsics.checkNotNullParameter((Object)dataCaptureContext, (String)"_DataCaptureContext");
        Intrinsics.checkNotNullParameter((Object)object, (String)"proxyCache");
        this.b = dataCaptureContextFrameListener;
        this.c = object;
        this.a = new WeakReference((Object)dataCaptureContext);
    }

    @Override
    public final void onFrameProcessingFinished(NativeDataCaptureContext nativeDataCaptureContext, NativeFrameData nativeFrameData) {
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContext, (String)"context");
        Intrinsics.checkNotNullParameter((Object)nativeFrameData, (String)"data");
        DataCaptureContext dataCaptureContext = (DataCaptureContext)this.a.get();
        if (dataCaptureContext != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeDataCaptureContext.class), (Object)null, nativeDataCaptureContext, new b(dataCaptureContext));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            DataCaptureContext dataCaptureContext2 = (DataCaptureContext)v;
            FrameData frameData = (FrameData)this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeFrameData.class), (Object)null, nativeFrameData, new a(this, nativeDataCaptureContext, nativeFrameData));
            this.b.onFrameProcessingFinished(dataCaptureContext2, frameData);
        }
    }

    @Override
    public final void onFrameProcessingStarted(NativeDataCaptureContext nativeDataCaptureContext, NativeFrameData nativeFrameData) {
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContext, (String)"context");
        Intrinsics.checkNotNullParameter((Object)nativeFrameData, (String)"data");
        DataCaptureContext dataCaptureContext = (DataCaptureContext)this.a.get();
        if (dataCaptureContext != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeDataCaptureContext.class), (Object)null, nativeDataCaptureContext, new d(dataCaptureContext));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            DataCaptureContext dataCaptureContext2 = (DataCaptureContext)v;
            FrameData frameData = (FrameData)this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeFrameData.class), (Object)null, nativeFrameData, new c(this, nativeDataCaptureContext, nativeFrameData));
            this.b.onFrameProcessingStarted(dataCaptureContext2, frameData);
        }
    }

    @Override
    public final void onObservationStarted(NativeDataCaptureContext nativeDataCaptureContext) {
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContext, (String)"context");
        DataCaptureContext dataCaptureContext = (DataCaptureContext)this.a.get();
        if (dataCaptureContext != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeDataCaptureContext.class), (Object)null, nativeDataCaptureContext, new e(dataCaptureContext));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            DataCaptureContext dataCaptureContext2 = (DataCaptureContext)v;
            this.b.onObservationStarted(dataCaptureContext2);
        }
    }

    @Override
    public final void onObservationStopped(NativeDataCaptureContext nativeDataCaptureContext) {
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContext, (String)"context");
        DataCaptureContext dataCaptureContext = (DataCaptureContext)this.a.get();
        if (dataCaptureContext != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeDataCaptureContext.class), (Object)null, nativeDataCaptureContext, new f(dataCaptureContext));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            DataCaptureContext dataCaptureContext2 = (DataCaptureContext)v;
            this.b.onObservationStopped(dataCaptureContext2);
        }
    }
}

