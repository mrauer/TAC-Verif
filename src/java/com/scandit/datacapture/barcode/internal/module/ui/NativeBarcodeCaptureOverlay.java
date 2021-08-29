/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.internal.module.ui.NativeBarcodeCaptureOverlay$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.internal.module.ui;

import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture;
import com.scandit.datacapture.barcode.internal.module.ui.NativeBarcodeCaptureOverlay;
import com.scandit.datacapture.core.internal.sdk.ui.overlay.NativeDataCaptureOverlay;
import com.scandit.datacapture.core.internal.sdk.ui.style.NativeBrush;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeViewfinder;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBarcodeCaptureOverlay {
    public NativeBarcodeCaptureOverlay() {
    }

    public static NativeBarcodeCaptureOverlay create(NativeBarcodeCapture nativeBarcodeCapture) {
        return CppProxy.create((NativeBarcodeCapture)nativeBarcodeCapture);
    }

    public static NativeBrush defaultBrushForLocalizedOnlyBarcodes() {
        return CppProxy.defaultBrushForLocalizedOnlyBarcodes();
    }

    public static NativeBrush defaultBrushForRecognizedBarcodes() {
        return CppProxy.defaultBrushForRecognizedBarcodes();
    }

    public abstract NativeDataCaptureOverlay asDataCaptureOverlay();

    public abstract NativeBrush getBrushForRecognizedBarcodes();

    public abstract boolean getShouldShowScanAreaGuides();

    public abstract NativeViewfinder getViewfinder();

    public abstract void setBrushForLocalizedOnlyBarcodes(NativeBrush var1);

    public abstract void setBrushForRecognizedBarcodes(NativeBrush var1);

    public abstract void setShouldShowScanAreaGuides(boolean var1);

    public abstract void setViewfinder(NativeViewfinder var1);
}

