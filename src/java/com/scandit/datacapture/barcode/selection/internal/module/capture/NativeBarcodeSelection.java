/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.selection.internal.module.capture.NativeBarcodeSelection$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.selection.internal.module.capture;

import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeBarcodeSelection;
import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeBarcodeSelectionListener;
import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeBarcodeSelectionSession;
import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeBarcodeSelectionSettings;
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
public abstract class NativeBarcodeSelection {
    public NativeBarcodeSelection() {
    }

    public static NativeBarcodeSelection create(NativeDataCaptureContext nativeDataCaptureContext, NativeBarcodeSelectionSettings nativeBarcodeSelectionSettings) {
        return CppProxy.create((NativeDataCaptureContext)nativeDataCaptureContext, (NativeBarcodeSelectionSettings)nativeBarcodeSelectionSettings);
    }

    public abstract void addListenerAsync(NativeBarcodeSelectionListener var1);

    public abstract NativeWrappedFuture applySettingsWrapped(NativeBarcodeSelectionSettings var1);

    public abstract NativeDataCaptureMode asDataCaptureMode();

    public abstract NativeDataCaptureContext getContext();

    public abstract NativeFeedback getFeedback();

    public abstract PointWithUnit getPointOfInterest();

    public abstract NativeBarcodeSelectionSession getSession();

    public abstract boolean isEnabled();

    public abstract void removeListenerAsync(NativeBarcodeSelectionListener var1);

    public abstract void reset();

    public abstract void setEnabled(boolean var1);

    public abstract void setPointOfInterest(PointWithUnit var1);

    public abstract void setSelectionFeedback(NativeFeedback var1);

    public abstract void unfreezeCamera();
}

