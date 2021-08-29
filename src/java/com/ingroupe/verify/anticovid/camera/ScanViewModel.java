/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.lifecycle.ViewModel
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.Objects
 *  java.util.concurrent.CopyOnWriteArraySet
 *  kotlin.Lazy
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.camera;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ViewModel;
import com.google.android.material.R;
import com.ingroupe.verify.anticovid.camera.-$$Lambda$ScanViewModel$cYsiGm25msYQCwKbWYrXkp-RUUU;
import com.ingroupe.verify.anticovid.camera.DataCaptureManager;
import com.scandit.datacapture.barcode.capture.BarcodeCapture;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureListener;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureProxyAdapter;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureSession;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureSessionProxyAdapter;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureSettingsProxyAdapter;
import com.scandit.datacapture.barcode.data.Barcode;
import com.scandit.datacapture.barcode.data.Symbology;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSession;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSettings;
import com.scandit.datacapture.barcode.internal.sdk.data.NativeBarcode;
import com.scandit.datacapture.core.data.FrameData;
import com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedFuture;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

public final class ScanViewModel
extends ViewModel
implements BarcodeCaptureListener {
    public final DataCaptureManager dataCaptureManager;
    public ResultListener listener;
    public final Handler mainHandler;

    public ScanViewModel() {
        DataCaptureManager dataCaptureManager;
        this.dataCaptureManager = dataCaptureManager = DataCaptureManager.CURRENT;
        this.mainHandler = new Handler(Looper.getMainLooper());
        BarcodeCapture barcodeCapture = dataCaptureManager.barcodeCapture;
        NativeBarcodeCaptureSettings nativeBarcodeCaptureSettings = NativeBarcodeCaptureSettings.create();
        Intrinsics.checkNotNullExpressionValue((Object)nativeBarcodeCaptureSettings, (String)"NativeBarcodeCaptureSettings.create()");
        Intrinsics.checkNotNullParameter((Object)nativeBarcodeCaptureSettings, (String)"impl");
        BarcodeCaptureSettingsProxyAdapter barcodeCaptureSettingsProxyAdapter = new BarcodeCaptureSettingsProxyAdapter(nativeBarcodeCaptureSettings, null, 2);
        Symbology symbology = Symbology.QR;
        Intrinsics.checkNotNullParameter((Object)((Object)symbology), (String)"symbology");
        Objects.requireNonNull((Object)barcodeCaptureSettingsProxyAdapter);
        Intrinsics.checkNotNullParameter((Object)((Object)symbology), (String)"symbology");
        barcodeCaptureSettingsProxyAdapter.a.setSymbologyEnabled(symbology, true);
        Symbology symbology2 = Symbology.DATA_MATRIX;
        Intrinsics.checkNotNullParameter((Object)((Object)symbology2), (String)"symbology");
        Objects.requireNonNull((Object)barcodeCaptureSettingsProxyAdapter);
        Intrinsics.checkNotNullParameter((Object)((Object)symbology2), (String)"symbology");
        barcodeCaptureSettingsProxyAdapter.a.setSymbologyEnabled(symbology2, true);
        Objects.requireNonNull((Object)barcodeCapture);
        NativeWrappedFuture nativeWrappedFuture = barcodeCapture.e.b.applySettingsWrapped(barcodeCaptureSettingsProxyAdapter.a);
        Intrinsics.checkNotNullExpressionValue((Object)nativeWrappedFuture, (String)"_impl().applySettingsWrapped(settings._impl())");
        R.style.andThen((NativeWrappedFuture)nativeWrappedFuture, null);
        BarcodeCapture barcodeCapture2 = dataCaptureManager.barcodeCapture;
        Objects.requireNonNull((Object)barcodeCapture2);
        Intrinsics.checkNotNullParameter((Object)this, (String)"listener");
        if (barcodeCapture2.c.add((Object)this)) {
            this.onObservationStarted(barcodeCapture2);
        }
    }

    @Override
    public void onBarcodeScanned(BarcodeCapture barcodeCapture, BarcodeCaptureSession barcodeCaptureSession, FrameData frameData) {
        Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"barcodeCapture");
        Intrinsics.checkNotNullParameter((Object)barcodeCaptureSession, (String)"session");
        Intrinsics.checkNotNullParameter((Object)frameData, (String)"data");
        ArrayList<NativeBarcode> arrayList = ((BarcodeCaptureSessionProxyAdapter)barcodeCaptureSession.a.getValue()).a.getNewlyRecognizedBarcodes();
        Intrinsics.checkNotNullExpressionValue(arrayList, (String)"_0");
        Intrinsics.checkNotNullParameter(arrayList, (String)"source");
        ArrayList arrayList2 = new ArrayList(R.style.collectionSizeOrDefault(arrayList, (int)10));
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            arrayList2.add((Object)new Barcode((NativeBarcode)iterator.next()));
        }
        Barcode barcode = (Barcode)arrayList2.get(0);
        if (this.listener != null && barcode != null) {
            this.dataCaptureManager.barcodeCapture.e.b.setEnabled(false);
            this.mainHandler.post((Runnable)new -$$Lambda$ScanViewModel$cYsiGm25msYQCwKbWYrXkp-RUUU(this, barcode));
        }
    }

    @Override
    public void onObservationStarted(BarcodeCapture barcodeCapture) {
        Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"barcodeCapture");
    }

    @Override
    public void onObservationStopped(BarcodeCapture barcodeCapture) {
        Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"barcodeCapture");
    }

    @Override
    public void onSessionUpdated(BarcodeCapture barcodeCapture, BarcodeCaptureSession barcodeCaptureSession, FrameData frameData) {
        Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"barcodeCapture");
        Intrinsics.checkNotNullParameter((Object)barcodeCaptureSession, (String)"session");
        Intrinsics.checkNotNullParameter((Object)frameData, (String)"data");
    }

    public final void resumeScanning() {
        this.dataCaptureManager.barcodeCapture.e.b.setEnabled(true);
    }

}

