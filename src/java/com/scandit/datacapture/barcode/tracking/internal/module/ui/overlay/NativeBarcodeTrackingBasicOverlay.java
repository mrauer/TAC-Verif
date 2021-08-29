/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay.NativeBarcodeTrackingBasicOverlay$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay;

import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTracking;
import com.scandit.datacapture.barcode.tracking.internal.module.data.NativeTrackedBarcode;
import com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay.NativeBarcodeTrackingBasicOverlay;
import com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay.NativeBarcodeTrackingBasicOverlayListener;
import com.scandit.datacapture.core.internal.sdk.ui.overlay.NativeDataCaptureOverlay;
import com.scandit.datacapture.core.internal.sdk.ui.style.NativeBrush;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBarcodeTrackingBasicOverlay {
    public NativeBarcodeTrackingBasicOverlay() {
    }

    public static NativeBarcodeTrackingBasicOverlay create(NativeBarcodeTracking nativeBarcodeTracking) {
        return CppProxy.create((NativeBarcodeTracking)nativeBarcodeTracking);
    }

    public static NativeBrush defaultBrush() {
        return CppProxy.defaultBrush();
    }

    public abstract NativeDataCaptureOverlay asDataCaptureOverlay();

    public abstract void clearTrackedBarcodeBrushes();

    public abstract boolean getBoolProperty(String var1);

    public abstract NativeBrush getDefaultBrush();

    public abstract NativeBarcodeTrackingBasicOverlayListener getListener();

    public abstract boolean getShouldShowScanAreaGuides();

    public abstract void setBoolProperty(String var1, boolean var2);

    public abstract void setDefaultBrush(NativeBrush var1);

    public abstract void setListener(NativeBarcodeTrackingBasicOverlayListener var1);

    public abstract void setShouldShowScanAreaGuides(boolean var1);

    public abstract void setTrackedBarcodeBrush(NativeTrackedBarcode var1, NativeBrush var2);
}

