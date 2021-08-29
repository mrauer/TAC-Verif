/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.serialization.NativeFrameSourceDeserializer$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureModeDeserializer;
import com.scandit.datacapture.core.internal.module.serialization.NativeFrameSourceDeserializer;
import com.scandit.datacapture.core.internal.module.serialization.NativeFrameSourceDeserializerHelper;
import com.scandit.datacapture.core.internal.module.serialization.NativeFrameSourceDeserializerListener;
import com.scandit.datacapture.core.internal.module.source.NativeCameraSettings;
import com.scandit.datacapture.core.internal.module.source.NativeFrameSource;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeFrameSourceDeserializer {
    public NativeFrameSourceDeserializer() {
    }

    public static NativeFrameSourceDeserializer create(ArrayList<NativeDataCaptureModeDeserializer> arrayList) {
        return CppProxy.create(arrayList);
    }

    public abstract NativeCameraSettings cameraSettingsFromJson(NativeJsonValue var1);

    public abstract NativeFrameSource frameSourceFromJson(NativeJsonValue var1);

    public abstract NativeFrameSourceDeserializerHelper getHelper();

    public abstract ArrayList<String> getWarnings();

    public abstract void setHelper(NativeFrameSourceDeserializerHelper var1);

    public abstract void setListener(NativeFrameSourceDeserializerListener var1);

    public abstract NativeCameraSettings updateCameraSettingsFromJson(NativeCameraSettings var1, NativeJsonValue var2);

    public abstract NativeFrameSource updateFrameSourceFromJson(NativeFrameSource var1, NativeJsonValue var2);
}

