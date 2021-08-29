/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.source.NativeAndroidCamera$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.source;

import com.scandit.datacapture.core.internal.module.source.NativeAbstractCamera;
import com.scandit.datacapture.core.internal.module.source.NativeCameraApi;
import com.scandit.datacapture.core.internal.module.source.NativeCameraDelegate;
import com.scandit.datacapture.core.internal.module.source.NativeCameraSettings;
import com.scandit.datacapture.core.internal.module.source.NativeFrameSource;
import com.scandit.datacapture.core.internal.module.source.NativeFrameSourceListener;
import com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedFuture;
import com.scandit.datacapture.core.internal.sdk.source.NativeAndroidCamera;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameData;
import com.scandit.datacapture.core.source.CameraPosition;
import com.scandit.datacapture.core.source.FrameSourceState;
import com.scandit.datacapture.core.source.TorchState;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeAndroidCamera {
    public NativeAndroidCamera() {
    }

    public static NativeAndroidCamera create(NativeCameraDelegate nativeCameraDelegate, CameraPosition cameraPosition) {
        return CppProxy.create((NativeCameraDelegate)nativeCameraDelegate, (CameraPosition)cameraPosition);
    }

    public abstract void addListenerAsync(NativeFrameSourceListener var1);

    public abstract NativeWrappedFuture applySettingsAsyncAndroid(NativeCameraSettings var1);

    public abstract void applyTorchStateAsync(TorchState var1);

    public abstract NativeAbstractCamera asAbstractCamera();

    public abstract NativeFrameSource asFrameSource();

    public abstract NativeCameraApi getApi();

    public abstract FrameSourceState getCurrentState();

    public abstract FrameSourceState getDesiredState();

    public abstract CameraPosition getPosition();

    public abstract boolean isTorchAvailable();

    public abstract void onFrameOutputAndroid(NativeCameraFrameData var1);

    public abstract void removeListenerAsync(NativeFrameSourceListener var1);

    public abstract void setDelegate(NativeCameraDelegate var1);

    public abstract NativeWrappedFuture switchToDesiredStateAsyncAndroid(FrameSourceState var1);

    public abstract NativeWrappedFuture switchToInterruptingStateAsyncAndroid(FrameSourceState var1);
}

