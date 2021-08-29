/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.module.serialization.NativeFrameSourceDeserializer;
import com.scandit.datacapture.core.internal.module.source.NativeCameraSettings;
import com.scandit.datacapture.core.internal.module.source.NativeFrameSource;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeFrameSourceDeserializerListener {
    public abstract void onCameraSettingsDeserializationFinished(NativeFrameSourceDeserializer var1, NativeCameraSettings var2, NativeJsonValue var3);

    public abstract void onCameraSettingsDeserializationStarted(NativeFrameSourceDeserializer var1, NativeCameraSettings var2, NativeJsonValue var3);

    public abstract void onFrameSourceDeserializationFinished(NativeFrameSourceDeserializer var1, NativeFrameSource var2, NativeJsonValue var3);

    public abstract void onFrameSourceDeserializationStarted(NativeFrameSourceDeserializer var1, NativeFrameSource var2, NativeJsonValue var3);
}

