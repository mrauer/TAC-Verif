/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.capture.BarcodeCaptureListenerReversedAdapter$a
 *  com.scandit.datacapture.barcode.capture.BarcodeCaptureListenerReversedAdapter$b
 *  com.scandit.datacapture.barcode.capture.BarcodeCaptureListenerReversedAdapter$c
 *  com.scandit.datacapture.barcode.capture.BarcodeCaptureListenerReversedAdapter$d
 *  com.scandit.datacapture.barcode.capture.BarcodeCaptureListenerReversedAdapter$e
 *  com.scandit.datacapture.barcode.capture.BarcodeCaptureListenerReversedAdapter$f
 *  com.scandit.datacapture.barcode.capture.BarcodeCaptureListenerReversedAdapter$g
 *  com.scandit.datacapture.barcode.capture.BarcodeCaptureListenerReversedAdapter$h
 *  com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 */
package com.scandit.datacapture.barcode.capture;

import com.scandit.datacapture.barcode.capture.BarcodeCapture;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureListener;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureListenerReversedAdapter;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureSession;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureListener;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSession;
import com.scandit.datacapture.core.data.FrameData;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

public final class BarcodeCaptureListenerReversedAdapter
extends NativeBarcodeCaptureListener {
    public final WeakReference<BarcodeCapture> a;
    public final BarcodeCaptureListener b;
    public final ProxyCache c;

    public BarcodeCaptureListenerReversedAdapter(BarcodeCaptureListener barcodeCaptureListener, BarcodeCapture barcodeCapture, ProxyCache proxyCache, int n2) {
        Object object = (n2 & 4) != 0 ? ProxyCacheKt.a : null;
        Intrinsics.checkNotNullParameter((Object)barcodeCaptureListener, (String)"_BarcodeCaptureListener");
        Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"_BarcodeCapture");
        Intrinsics.checkNotNullParameter((Object)object, (String)"proxyCache");
        this.b = barcodeCaptureListener;
        this.c = object;
        this.a = new WeakReference((Object)barcodeCapture);
    }

    @Override
    public final void onObservationStarted(NativeBarcodeCapture nativeBarcodeCapture) {
        Intrinsics.checkNotNullParameter((Object)nativeBarcodeCapture, (String)"mode");
        BarcodeCapture barcodeCapture = (BarcodeCapture)this.a.get();
        if (barcodeCapture != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeBarcodeCapture.class), (Object)null, nativeBarcodeCapture, new a(barcodeCapture));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            BarcodeCapture barcodeCapture2 = (BarcodeCapture)v;
            this.b.onObservationStarted(barcodeCapture2);
        }
    }

    @Override
    public final void onObservationStopped(NativeBarcodeCapture nativeBarcodeCapture) {
        Intrinsics.checkNotNullParameter((Object)nativeBarcodeCapture, (String)"mode");
        BarcodeCapture barcodeCapture = (BarcodeCapture)this.a.get();
        if (barcodeCapture != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeBarcodeCapture.class), (Object)null, nativeBarcodeCapture, new b(barcodeCapture));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            BarcodeCapture barcodeCapture2 = (BarcodeCapture)v;
            this.b.onObservationStopped(barcodeCapture2);
        }
    }

    @Override
    public final void onScan(NativeBarcodeCapture nativeBarcodeCapture, NativeBarcodeCaptureSession nativeBarcodeCaptureSession, NativeFrameData nativeFrameData) {
        Intrinsics.checkNotNullParameter((Object)nativeBarcodeCapture, (String)"mode");
        Intrinsics.checkNotNullParameter((Object)nativeBarcodeCaptureSession, (String)"session");
        Intrinsics.checkNotNullParameter((Object)nativeFrameData, (String)"data");
        BarcodeCapture barcodeCapture = (BarcodeCapture)this.a.get();
        if (barcodeCapture != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeBarcodeCapture.class), (Object)null, nativeBarcodeCapture, new d(barcodeCapture));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            BarcodeCapture barcodeCapture2 = (BarcodeCapture)v;
            BarcodeCaptureSession barcodeCaptureSession = (BarcodeCaptureSession)this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeBarcodeCaptureSession.class), (Object)null, nativeBarcodeCaptureSession, new e(barcodeCapture));
            FrameData frameData = (FrameData)this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeFrameData.class), (Object)null, nativeFrameData, new c(this, nativeBarcodeCapture, nativeBarcodeCaptureSession, nativeFrameData));
            this.b.onBarcodeScanned(barcodeCapture2, barcodeCaptureSession, frameData);
        }
    }

    @Override
    public final void onUpdate(NativeBarcodeCapture nativeBarcodeCapture, NativeBarcodeCaptureSession nativeBarcodeCaptureSession, NativeFrameData nativeFrameData) {
        Intrinsics.checkNotNullParameter((Object)nativeBarcodeCapture, (String)"mode");
        Intrinsics.checkNotNullParameter((Object)nativeBarcodeCaptureSession, (String)"session");
        Intrinsics.checkNotNullParameter((Object)nativeFrameData, (String)"data");
        BarcodeCapture barcodeCapture = (BarcodeCapture)this.a.get();
        if (barcodeCapture != null) {
            Object v = this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeBarcodeCapture.class), (Object)null, nativeBarcodeCapture, new g(barcodeCapture));
            Intrinsics.checkNotNullExpressionValue(v, (String)"proxyCache.getOrPut(Nati\u2026         it\n            }");
            BarcodeCapture barcodeCapture2 = (BarcodeCapture)v;
            BarcodeCaptureSession barcodeCaptureSession = (BarcodeCaptureSession)this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeBarcodeCaptureSession.class), (Object)null, nativeBarcodeCaptureSession, new h(barcodeCapture));
            FrameData frameData = (FrameData)this.c.getOrPut(Reflection.getOrCreateKotlinClass(NativeFrameData.class), (Object)null, nativeFrameData, new f(this, nativeBarcodeCapture, nativeBarcodeCaptureSession, nativeFrameData));
            this.b.onSessionUpdated(barcodeCapture2, barcodeCaptureSession, frameData);
        }
    }
}

