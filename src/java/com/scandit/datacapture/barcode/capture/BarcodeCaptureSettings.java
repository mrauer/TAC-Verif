/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.barcode.capture;

import com.scandit.datacapture.barcode.capture.BarcodeCaptureSettingsProxyAdapter;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSettings;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import kotlin.jvm.internal.Intrinsics;

public final class BarcodeCaptureSettings {
    public final /* synthetic */ BarcodeCaptureSettingsProxyAdapter b;

    public BarcodeCaptureSettings() {
        NativeBarcodeCaptureSettings nativeBarcodeCaptureSettings = NativeBarcodeCaptureSettings.create();
        Intrinsics.checkNotNullExpressionValue((Object)nativeBarcodeCaptureSettings, (String)"NativeBarcodeCaptureSettings.create()");
        Intrinsics.checkNotNullParameter((Object)nativeBarcodeCaptureSettings, (String)"impl");
        this.b = new BarcodeCaptureSettingsProxyAdapter(nativeBarcodeCaptureSettings, null, 2);
    }
}

