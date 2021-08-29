/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.capture.BarcodeCapture
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.capture;

import com.scandit.datacapture.barcode.capture.BarcodeCapture;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureSession;
import com.scandit.datacapture.core.data.FrameData;

public interface BarcodeCaptureListener {
    public void onBarcodeScanned(BarcodeCapture var1, BarcodeCaptureSession var2, FrameData var3);

    public void onObservationStarted(BarcodeCapture var1);

    public void onObservationStopped(BarcodeCapture var1);

    public void onSessionUpdated(BarcodeCapture var1, BarcodeCaptureSession var2, FrameData var3);
}

