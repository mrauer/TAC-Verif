/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay;

import com.scandit.datacapture.barcode.tracking.internal.module.data.NativeTrackedBarcode;
import com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay.NativeBarcodeTrackingBasicOverlay;
import com.scandit.datacapture.core.internal.sdk.ui.style.NativeBrush;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeBarcodeTrackingBasicOverlayListener {
    public abstract NativeBrush brushForTrackedBarcode(NativeBarcodeTrackingBasicOverlay var1, NativeTrackedBarcode var2);

    public abstract void onTrackedBarcodeTapped(NativeBarcodeTrackingBasicOverlay var1, NativeTrackedBarcode var2);
}

