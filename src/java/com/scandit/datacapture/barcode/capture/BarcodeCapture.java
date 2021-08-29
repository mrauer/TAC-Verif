/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.capture.BarcodeCapture$b
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.Iterator
 *  java.util.concurrent.CopyOnWriteArraySet
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.barcode.capture;

import com.scandit.datacapture.barcode.capture.BarcodeCapture;
import com.scandit.datacapture.barcode.capture.BarcodeCapture$setNativeFeedback$1;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureListener;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureListenerReversedAdapter;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureProxyAdapter;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureSession;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureSettings;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureSettingsProxyAdapter;
import com.scandit.datacapture.barcode.feedback.BarcodeCaptureFeedback;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureListener;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSession;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSettings;
import com.scandit.datacapture.core.capture.DataCaptureContext;
import com.scandit.datacapture.core.capture.DataCaptureContextProxyAdapter;
import com.scandit.datacapture.core.capture.DataCaptureMode;
import com.scandit.datacapture.core.common.feedback.Feedback;
import com.scandit.datacapture.core.common.feedback.ResourceSound;
import com.scandit.datacapture.core.common.feedback.Sound;
import com.scandit.datacapture.core.common.feedback.Vibration;
import com.scandit.datacapture.core.data.FrameData;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureMode;
import com.scandit.datacapture.core.internal.sdk.capture.NativeFeedback;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class BarcodeCapture
implements DataCaptureMode {
    public DataCaptureContext a;
    public final CopyOnWriteArraySet<BarcodeCaptureListener> c;
    public final BarcodeCaptureSession d;
    public final /* synthetic */ BarcodeCaptureProxyAdapter e;

    public BarcodeCapture(DataCaptureContext dataCaptureContext, BarcodeCaptureSettings barcodeCaptureSettings, DefaultConstructorMarker defaultConstructorMarker) {
        BarcodeCaptureProxyAdapter barcodeCaptureProxyAdapter;
        NativeDataCaptureContext nativeDataCaptureContext = dataCaptureContext != null ? dataCaptureContext.g.b : null;
        NativeBarcodeCapture nativeBarcodeCapture = NativeBarcodeCapture.create(nativeDataCaptureContext, barcodeCaptureSettings.b.a);
        Intrinsics.checkNotNullExpressionValue((Object)nativeBarcodeCapture, (String)"NativeBarcodeCapture.cre\u2026impl(), settings._impl())");
        Intrinsics.checkNotNullParameter((Object)nativeBarcodeCapture, (String)"impl");
        this.e = barcodeCaptureProxyAdapter = new BarcodeCaptureProxyAdapter(nativeBarcodeCapture, null, 2);
        BarcodeCaptureFeedback barcodeCaptureFeedback = new BarcodeCaptureFeedback(new Feedback(new Vibration(), new ResourceSound(2131755008)), null);
        barcodeCaptureProxyAdapter.b.setSuccessFeedback(new BarcodeCapture$setNativeFeedback$1(barcodeCaptureFeedback));
        this.c = new CopyOnWriteArraySet();
        BarcodeCaptureListenerReversedAdapter barcodeCaptureListenerReversedAdapter = new BarcodeCaptureListenerReversedAdapter(new a(this), this, null, 4);
        barcodeCaptureProxyAdapter.b.addListenerAsync(barcodeCaptureListenerReversedAdapter);
        this.d = new BarcodeCaptureSession((Function0<? extends NativeBarcodeCaptureSession>)new b(nativeBarcodeCapture));
    }

    public final NativeDataCaptureMode _dataCaptureModeImpl() {
        return this.e.a;
    }

    @Override
    public final void _setDataCaptureContext(DataCaptureContext dataCaptureContext) {
        this.a = dataCaptureContext;
    }

    public static final class a
    implements BarcodeCaptureListener {
        public final WeakReference<BarcodeCapture> a;

        public a(BarcodeCapture barcodeCapture) {
            Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"owner");
            this.a = new WeakReference((Object)barcodeCapture);
        }

        @Override
        public final void onBarcodeScanned(BarcodeCapture barcodeCapture, BarcodeCaptureSession barcodeCaptureSession, FrameData frameData) {
            CopyOnWriteArraySet<BarcodeCaptureListener> copyOnWriteArraySet;
            Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"barcodeCapture");
            Intrinsics.checkNotNullParameter((Object)barcodeCaptureSession, (String)"session");
            Intrinsics.checkNotNullParameter((Object)frameData, (String)"data");
            BarcodeCapture barcodeCapture2 = (BarcodeCapture)this.a.get();
            if (barcodeCapture2 != null && (copyOnWriteArraySet = barcodeCapture2.c) != null) {
                Iterator iterator = copyOnWriteArraySet.iterator();
                while (iterator.hasNext()) {
                    ((BarcodeCaptureListener)iterator.next()).onBarcodeScanned(barcodeCapture, barcodeCaptureSession, frameData);
                }
            }
        }

        @Override
        public final void onObservationStarted(BarcodeCapture barcodeCapture) {
            Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"barcodeCapture");
            Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"barcodeCapture");
        }

        @Override
        public final void onObservationStopped(BarcodeCapture barcodeCapture) {
            Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"barcodeCapture");
            Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"barcodeCapture");
        }

        @Override
        public final void onSessionUpdated(BarcodeCapture barcodeCapture, BarcodeCaptureSession barcodeCaptureSession, FrameData frameData) {
            CopyOnWriteArraySet<BarcodeCaptureListener> copyOnWriteArraySet;
            Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"barcodeCapture");
            Intrinsics.checkNotNullParameter((Object)barcodeCaptureSession, (String)"session");
            Intrinsics.checkNotNullParameter((Object)frameData, (String)"data");
            BarcodeCapture barcodeCapture2 = (BarcodeCapture)this.a.get();
            if (barcodeCapture2 != null && (copyOnWriteArraySet = barcodeCapture2.c) != null) {
                Iterator iterator = copyOnWriteArraySet.iterator();
                while (iterator.hasNext()) {
                    ((BarcodeCaptureListener)iterator.next()).onSessionUpdated(barcodeCapture, barcodeCaptureSession, frameData);
                }
            }
        }
    }

}

