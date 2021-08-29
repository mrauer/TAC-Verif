/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.selection.internal.module.capture;

import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeBarcodeSelection;
import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeBarcodeSelectionSession;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeBarcodeSelectionListener {
    public abstract void onObservationStarted(NativeBarcodeSelection var1);

    public abstract void onObservationStopped(NativeBarcodeSelection var1);

    public abstract void onSelectionUpdated(NativeBarcodeSelection var1, NativeBarcodeSelectionSession var2, NativeFrameData var3);

    public abstract void onUpdate(NativeBarcodeSelection var1, NativeBarcodeSelectionSession var2, NativeFrameData var3);
}

