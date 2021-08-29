/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureViewDeserializer;
import com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeDataCaptureViewDeserializerListener {
    public abstract void onViewDeserializationFinished(NativeDataCaptureViewDeserializer var1, NativeDataCaptureView var2, NativeJsonValue var3);

    public abstract void onViewDeserializationStarted(NativeDataCaptureViewDeserializer var1, NativeDataCaptureView var2, NativeJsonValue var3);
}

