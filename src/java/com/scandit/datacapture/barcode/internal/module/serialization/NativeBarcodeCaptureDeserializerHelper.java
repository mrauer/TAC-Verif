/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.internal.module.serialization;

import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSettings;
import com.scandit.datacapture.barcode.internal.module.ui.NativeBarcodeCaptureOverlay;
import com.scandit.datacapture.core.internal.module.source.NativeCameraSettings;
import com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeBarcodeCaptureDeserializerHelper {
    public abstract void applySettings(NativeBarcodeCapture var1, NativeBarcodeCaptureSettings var2);

    public abstract void changeOverlayAddedToView(NativeBarcodeCaptureOverlay var1, NativeDataCaptureView var2, boolean var3);

    public abstract NativeBarcodeCapture createMode(NativeDataCaptureContext var1);

    public abstract NativeBarcodeCaptureOverlay createOverlay(NativeBarcodeCapture var1);

    public abstract NativeCameraSettings createRecommendedCameraSettings();

    public abstract NativeBarcodeCaptureSettings createSettings();

    public abstract void updateModeFromJson(NativeBarcodeCapture var1, NativeJsonValue var2);

    public abstract void updateOverlayFromJson(NativeBarcodeCaptureOverlay var1, NativeJsonValue var2);

    public abstract void updateSettingsFromJson(NativeBarcodeCaptureSettings var1, NativeJsonValue var2);
}

