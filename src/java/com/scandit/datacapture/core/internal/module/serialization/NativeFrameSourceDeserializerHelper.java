/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.module.source.NativeAbstractCamera;
import com.scandit.datacapture.core.internal.module.source.NativeCameraSettings;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.core.source.CameraPosition;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeFrameSourceDeserializerHelper {
    public abstract void applySettings(NativeAbstractCamera var1, NativeCameraSettings var2);

    public abstract NativeAbstractCamera createCamera(CameraPosition var1, NativeCameraSettings var2, String var3, String var4);

    public abstract void updateCameraFromJson(NativeAbstractCamera var1, NativeJsonValue var2);
}

