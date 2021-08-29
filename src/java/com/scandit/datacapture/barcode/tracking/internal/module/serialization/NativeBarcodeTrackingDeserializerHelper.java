/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.tracking.internal.module.serialization;

import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTracking;
import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTrackingSettings;
import com.scandit.datacapture.barcode.tracking.internal.module.data.NativeObjectTrackerScenario;
import com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay.NativeBarcodeTrackingAdvancedOverlay;
import com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay.NativeBarcodeTrackingBasicOverlay;
import com.scandit.datacapture.core.internal.module.source.NativeCameraSettings;
import com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeBarcodeTrackingDeserializerHelper {
    public abstract void applySettings(NativeBarcodeTracking var1, NativeBarcodeTrackingSettings var2);

    public abstract void changeAdvancedOverlayAddedToView(NativeBarcodeTrackingAdvancedOverlay var1, NativeDataCaptureView var2, boolean var3);

    public abstract void changeBasicOverlayAddedToView(NativeBarcodeTrackingBasicOverlay var1, NativeDataCaptureView var2, boolean var3);

    public abstract NativeBarcodeTrackingAdvancedOverlay createAdvancedOverlay(NativeBarcodeTracking var1);

    public abstract NativeBarcodeTrackingBasicOverlay createBasicOverlay(NativeBarcodeTracking var1);

    public abstract NativeBarcodeTracking createMode(NativeDataCaptureContext var1);

    public abstract NativeCameraSettings createRecommendedCameraSettings();

    public abstract NativeBarcodeTrackingSettings createSettings();

    public abstract NativeBarcodeTrackingSettings createSettingsForScenario(NativeObjectTrackerScenario var1);

    public abstract void updateAdvancedOverlayFromJson(NativeBarcodeTrackingAdvancedOverlay var1, NativeJsonValue var2);

    public abstract void updateBasicOverlayFromJson(NativeBarcodeTrackingBasicOverlay var1, NativeJsonValue var2);

    public abstract void updateModeFromJson(NativeBarcodeTracking var1, NativeJsonValue var2);

    public abstract void updateSettingsFromJson(NativeBarcodeTrackingSettings var1, NativeJsonValue var2);
}

