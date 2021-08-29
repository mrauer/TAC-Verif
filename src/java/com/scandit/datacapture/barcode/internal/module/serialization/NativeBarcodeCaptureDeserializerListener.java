/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.internal.module.serialization;

import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSettings;
import com.scandit.datacapture.barcode.internal.module.serialization.NativeBarcodeCaptureDeserializer;
import com.scandit.datacapture.barcode.internal.module.ui.NativeBarcodeCaptureOverlay;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeBarcodeCaptureDeserializerListener {
    public abstract void onModeDeserializationFinished(NativeBarcodeCaptureDeserializer var1, NativeBarcodeCapture var2, NativeJsonValue var3);

    public abstract void onModeDeserializationStarted(NativeBarcodeCaptureDeserializer var1, NativeBarcodeCapture var2, NativeJsonValue var3);

    public abstract void onOverlayDeserializationFinished(NativeBarcodeCaptureDeserializer var1, NativeBarcodeCaptureOverlay var2, NativeJsonValue var3);

    public abstract void onOverlayDeserializationStarted(NativeBarcodeCaptureDeserializer var1, NativeBarcodeCaptureOverlay var2, NativeJsonValue var3);

    public abstract void onSettingsDeserializationFinished(NativeBarcodeCaptureDeserializer var1, NativeBarcodeCaptureSettings var2, NativeJsonValue var3);

    public abstract void onSettingsDeserializationStarted(NativeBarcodeCaptureDeserializer var1, NativeBarcodeCaptureSettings var2, NativeJsonValue var3);
}

