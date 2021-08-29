/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContextSettings;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureMode;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeDataCaptureContextDeserializerHelper {
    public abstract NativeDataCaptureContext createContext(String var1, String var2, String var3, String var4, String var5, NativeDataCaptureContextSettings var6);

    public abstract void removeModeFromContext(NativeDataCaptureContext var1, NativeDataCaptureMode var2);

    public abstract void updateContextFromJson(NativeDataCaptureContext var1, NativeJsonValue var2);
}

