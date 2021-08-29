/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureContextDeserializer;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeDataCaptureContextDeserializerListener {
    public abstract void onContextDeserializationFinished(NativeDataCaptureContextDeserializer var1, NativeDataCaptureContext var2, NativeJsonValue var3);

    public abstract void onContextDeserializationStarted(NativeDataCaptureContextDeserializer var1, NativeDataCaptureContext var2, NativeJsonValue var3);
}

