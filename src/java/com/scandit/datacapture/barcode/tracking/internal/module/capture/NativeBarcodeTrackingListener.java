/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.tracking.internal.module.capture;

import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTracking;
import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTrackingSession;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeBarcodeTrackingListener {
    public abstract void onObservationStarted(NativeBarcodeTracking var1);

    public abstract void onObservationStopped(NativeBarcodeTracking var1);

    public abstract void onSessionUpdated(NativeBarcodeTracking var1, NativeBarcodeTrackingSession var2, NativeFrameData var3);
}

