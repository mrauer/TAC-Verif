/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.tracking.internal.module.serialization;

import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTracking;
import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTrackingSettings;
import com.scandit.datacapture.barcode.tracking.internal.module.serialization.NativeBarcodeTrackingDeserializer;
import com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay.NativeBarcodeTrackingAdvancedOverlay;
import com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay.NativeBarcodeTrackingBasicOverlay;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeBarcodeTrackingDeserializerListener {
    public abstract void onAdvancedOverlayDeserializationFinished(NativeBarcodeTrackingDeserializer var1, NativeBarcodeTrackingAdvancedOverlay var2, NativeJsonValue var3);

    public abstract void onAdvancedOverlayDeserializationStarted(NativeBarcodeTrackingDeserializer var1, NativeBarcodeTrackingAdvancedOverlay var2, NativeJsonValue var3);

    public abstract void onBasicOverlayDeserializationFinished(NativeBarcodeTrackingDeserializer var1, NativeBarcodeTrackingBasicOverlay var2, NativeJsonValue var3);

    public abstract void onBasicOverlayDeserializationStarted(NativeBarcodeTrackingDeserializer var1, NativeBarcodeTrackingBasicOverlay var2, NativeJsonValue var3);

    public abstract void onModeDeserializationFinished(NativeBarcodeTrackingDeserializer var1, NativeBarcodeTracking var2, NativeJsonValue var3);

    public abstract void onModeDeserializationStarted(NativeBarcodeTrackingDeserializer var1, NativeBarcodeTracking var2, NativeJsonValue var3);

    public abstract void onSettingsDeserializationFinished(NativeBarcodeTrackingDeserializer var1, NativeBarcodeTrackingSettings var2, NativeJsonValue var3);

    public abstract void onSettingsDeserializationStarted(NativeBarcodeTrackingDeserializer var1, NativeBarcodeTrackingSettings var2, NativeJsonValue var3);
}

