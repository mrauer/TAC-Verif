/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.internal.module.capture;

import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureListener;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSession;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSettings;
import com.scandit.datacapture.core.common.geometry.PointWithUnit;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureMode;
import com.scandit.datacapture.core.internal.sdk.capture.NativeFeedback;
import com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedFuture;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBarcodeCapture {
    public NativeBarcodeCapture() {
    }

    public static NativeBarcodeCapture create(NativeDataCaptureContext nativeDataCaptureContext, NativeBarcodeCaptureSettings nativeBarcodeCaptureSettings) {
        return CppProxy.create((NativeDataCaptureContext)nativeDataCaptureContext, (NativeBarcodeCaptureSettings)nativeBarcodeCaptureSettings);
    }

    public abstract void addListenerAsync(NativeBarcodeCaptureListener var1);

    public abstract NativeWrappedFuture applySettingsWrapped(NativeBarcodeCaptureSettings var1);

    public abstract NativeDataCaptureMode asDataCaptureMode();

    public abstract NativeDataCaptureContext getContext();

    public abstract PointWithUnit getPointOfInterest();

    public abstract NativeBarcodeCaptureSession getSession();

    public abstract boolean isEnabled();

    public abstract void removeListenerAsync(NativeBarcodeCaptureListener var1);

    public abstract void setEnabled(boolean var1);

    public abstract void setPointOfInterest(PointWithUnit var1);

    public abstract void setSuccessFeedback(NativeFeedback var1);
}

