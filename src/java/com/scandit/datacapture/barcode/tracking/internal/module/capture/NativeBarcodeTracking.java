/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTracking$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.tracking.internal.module.capture;

import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTracking;
import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTrackingListener;
import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTrackingSession;
import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTrackingSettings;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureMode;
import com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedFuture;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBarcodeTracking {
    public NativeBarcodeTracking() {
    }

    public static NativeBarcodeTracking create(NativeDataCaptureContext nativeDataCaptureContext, NativeBarcodeTrackingSettings nativeBarcodeTrackingSettings) {
        return CppProxy.create((NativeDataCaptureContext)nativeDataCaptureContext, (NativeBarcodeTrackingSettings)nativeBarcodeTrackingSettings);
    }

    public abstract void addListenerAsync(NativeBarcodeTrackingListener var1, int var2);

    public abstract NativeWrappedFuture applySettingsWrapped(NativeBarcodeTrackingSettings var1);

    public abstract NativeDataCaptureMode asDataCaptureMode();

    public abstract NativeDataCaptureContext getContext();

    public abstract NativeBarcodeTrackingSession getSession();

    public abstract boolean isAttachedToContext();

    public abstract boolean isEnabled();

    public abstract void removeListenerAsync(NativeBarcodeTrackingListener var1);

    public abstract void setEnabled(boolean var1);

    public abstract boolean shouldUseEngineDrivenAnimations();
}

