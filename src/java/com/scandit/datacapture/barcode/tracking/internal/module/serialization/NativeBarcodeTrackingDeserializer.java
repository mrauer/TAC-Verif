/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.tracking.internal.module.serialization.NativeBarcodeTrackingDeserializer$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.scandit.datacapture.barcode.tracking.internal.module.serialization;

import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTracking;
import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTrackingSettings;
import com.scandit.datacapture.barcode.tracking.internal.module.serialization.NativeBarcodeTrackingDeserializer;
import com.scandit.datacapture.barcode.tracking.internal.module.serialization.NativeBarcodeTrackingDeserializerHelper;
import com.scandit.datacapture.barcode.tracking.internal.module.serialization.NativeBarcodeTrackingDeserializerListener;
import com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay.NativeBarcodeTrackingAdvancedOverlay;
import com.scandit.datacapture.barcode.tracking.internal.module.ui.overlay.NativeBarcodeTrackingBasicOverlay;
import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureModeDeserializer;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBarcodeTrackingDeserializer {
    public NativeBarcodeTrackingDeserializer() {
    }

    public static NativeBarcodeTrackingDeserializer create() {
        return CppProxy.create();
    }

    public abstract NativeDataCaptureModeDeserializer asDataCaptureModeDeserializer();

    public abstract NativeBarcodeTrackingAdvancedOverlay barcodeTrackingAdvancedOverlayFromJson(NativeBarcodeTracking var1, NativeJsonValue var2);

    public abstract NativeBarcodeTrackingBasicOverlay barcodeTrackingBasicOverlayFromJson(NativeBarcodeTracking var1, NativeJsonValue var2);

    public abstract NativeBarcodeTracking barcodeTrackingFromJson(NativeDataCaptureContext var1, NativeJsonValue var2);

    public abstract NativeBarcodeTrackingDeserializerHelper getHelper();

    public abstract ArrayList<String> getWarnings();

    public abstract void setHelper(NativeBarcodeTrackingDeserializerHelper var1);

    public abstract void setListener(NativeBarcodeTrackingDeserializerListener var1);

    public abstract NativeBarcodeTrackingSettings settingsFromJson(NativeJsonValue var1);

    public abstract NativeBarcodeTrackingAdvancedOverlay updateBarcodeTrackingAdvancedOverlayFromJson(NativeBarcodeTrackingAdvancedOverlay var1, NativeJsonValue var2);

    public abstract NativeBarcodeTrackingBasicOverlay updateBarcodeTrackingBasicOverlayFromJson(NativeBarcodeTrackingBasicOverlay var1, NativeJsonValue var2);

    public abstract NativeBarcodeTracking updateBarcodeTrackingFromJson(NativeBarcodeTracking var1, NativeJsonValue var2);

    public abstract NativeBarcodeTrackingSettings updateSettingsFromJson(NativeBarcodeTrackingSettings var1, NativeJsonValue var2);
}

