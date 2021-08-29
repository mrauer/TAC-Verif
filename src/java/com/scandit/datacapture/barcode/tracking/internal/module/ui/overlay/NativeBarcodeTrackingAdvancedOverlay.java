/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay.NativeBarcodeTrackingAdvancedOverlay$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay;

import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTracking;
import com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay.NativeBarcodeTrackingAdvancedOverlay;
import com.scandit.datacapture.core.internal.sdk.capture.NativeFeatureAvailability;
import com.scandit.datacapture.core.internal.sdk.ui.overlay.NativeDataCaptureOverlay;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBarcodeTrackingAdvancedOverlay {
    public NativeBarcodeTrackingAdvancedOverlay() {
    }

    public static NativeBarcodeTrackingAdvancedOverlay create(NativeBarcodeTracking nativeBarcodeTracking) {
        return CppProxy.create((NativeBarcodeTracking)nativeBarcodeTracking);
    }

    public abstract NativeDataCaptureOverlay asDataCaptureOverlay();

    public abstract boolean getShouldShowScanAreaGuides();

    public abstract NativeFeatureAvailability requireArFeatureAvailabilityFromContext();

    public abstract void setShouldShowScanAreaGuides(boolean var1);
}

