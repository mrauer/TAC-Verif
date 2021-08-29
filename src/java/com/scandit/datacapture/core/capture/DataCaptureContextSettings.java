/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.capture;

import com.scandit.datacapture.core.capture.DataCaptureContextSettingsProxyAdapter;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContextSettings;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import kotlin.jvm.internal.Intrinsics;

public final class DataCaptureContextSettings {
    public final /* synthetic */ DataCaptureContextSettingsProxyAdapter a;

    public DataCaptureContextSettings() {
        NativeDataCaptureContextSettings nativeDataCaptureContextSettings = NativeDataCaptureContextSettings.create();
        Intrinsics.checkNotNullExpressionValue((Object)nativeDataCaptureContextSettings, (String)"NativeDataCaptureContextSettings.create()");
        Intrinsics.checkNotNullParameter((Object)nativeDataCaptureContextSettings, (String)"impl");
        this.a = new DataCaptureContextSettingsProxyAdapter(nativeDataCaptureContextSettings, null, 2);
    }
}

