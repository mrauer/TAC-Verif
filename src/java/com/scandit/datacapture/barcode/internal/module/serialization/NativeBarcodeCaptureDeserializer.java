/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.internal.module.serialization.NativeBarcodeCaptureDeserializer$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.scandit.datacapture.barcode.internal.module.serialization;

import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSettings;
import com.scandit.datacapture.barcode.internal.module.serialization.NativeBarcodeCaptureDeserializer;
import com.scandit.datacapture.barcode.internal.module.serialization.NativeBarcodeCaptureDeserializerHelper;
import com.scandit.datacapture.barcode.internal.module.serialization.NativeBarcodeCaptureDeserializerListener;
import com.scandit.datacapture.barcode.internal.module.ui.NativeBarcodeCaptureOverlay;
import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureModeDeserializer;
import com.scandit.datacapture.core.internal.module.serialization.NativeLocationSelectionDeserializer;
import com.scandit.datacapture.core.internal.module.serialization.NativeViewfinderDeserializer;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBarcodeCaptureDeserializer {
    public NativeBarcodeCaptureDeserializer() {
    }

    public static NativeBarcodeCaptureDeserializer create(NativeLocationSelectionDeserializer nativeLocationSelectionDeserializer, NativeViewfinderDeserializer nativeViewfinderDeserializer) {
        return CppProxy.create((NativeLocationSelectionDeserializer)nativeLocationSelectionDeserializer, (NativeViewfinderDeserializer)nativeViewfinderDeserializer);
    }

    public abstract NativeDataCaptureModeDeserializer asDataCaptureModeDeserializer();

    public abstract NativeBarcodeCapture barcodeCaptureFromJson(NativeDataCaptureContext var1, NativeJsonValue var2);

    public abstract NativeBarcodeCaptureOverlay barcodeCaptureOverlayFromJson(NativeBarcodeCapture var1, NativeJsonValue var2);

    public abstract NativeBarcodeCaptureDeserializerHelper getHelper();

    public abstract ArrayList<String> getWarnings();

    public abstract void setHelper(NativeBarcodeCaptureDeserializerHelper var1);

    public abstract void setListener(NativeBarcodeCaptureDeserializerListener var1);

    public abstract NativeBarcodeCaptureSettings settingsFromJson(NativeJsonValue var1);

    public abstract NativeBarcodeCapture updateBarcodeCaptureFromJson(NativeBarcodeCapture var1, NativeJsonValue var2);

    public abstract NativeBarcodeCaptureOverlay updateBarcodeCaptureOverlayFromJson(NativeBarcodeCaptureOverlay var1, NativeJsonValue var2);

    public abstract NativeBarcodeCaptureSettings updateSettingsFromJson(NativeBarcodeCaptureSettings var1, NativeJsonValue var2);
}

