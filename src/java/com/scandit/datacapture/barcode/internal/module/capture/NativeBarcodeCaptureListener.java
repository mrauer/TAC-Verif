/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.internal.module.capture;

import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSession;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeBarcodeCaptureListener {
    public abstract void onObservationStarted(NativeBarcodeCapture var1);

    public abstract void onObservationStopped(NativeBarcodeCapture var1);

    public abstract void onScan(NativeBarcodeCapture var1, NativeBarcodeCaptureSession var2, NativeFrameData var3);

    public abstract void onUpdate(NativeBarcodeCapture var1, NativeBarcodeCaptureSession var2, NativeFrameData var3);
}

