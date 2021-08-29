/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.EnumSet
 */
package com.scandit.datacapture.core.internal.module.source;

import com.scandit.datacapture.core.common.geometry.Rect;
import com.scandit.datacapture.core.common.geometry.Size2;
import com.scandit.datacapture.core.internal.module.source.NativeCameraApi;
import com.scandit.datacapture.core.internal.module.source.NativeCameraDelegateSettings;
import com.scandit.datacapture.core.internal.module.source.NativeFocusMode;
import com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedPromise;
import com.scandit.datacapture.core.source.CameraPosition;
import com.scandit.datacapture.core.source.FrameSourceState;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;
import java.util.EnumSet;

@DjinniGenerated
public abstract class NativeCameraDelegate {
    public abstract void bootUpWithSettings(NativeCameraDelegateSettings var1, NativeWrappedPromise var2);

    public abstract NativeCameraApi getCameraApi();

    public abstract CameraPosition getCameraPosition();

    public abstract int getCameraToNativeDeviceOrientation();

    public abstract ArrayList<Size2> getFrameResolutions();

    public abstract EnumSet<NativeFocusMode> getSupportedFocusModesBits();

    public abstract boolean goToSleep();

    public abstract boolean hasManualLensPositionControl();

    public abstract boolean hasNoFocusSystem();

    public abstract boolean isTorchAvailable();

    public abstract boolean setFixedLensPosition(float var1);

    public abstract boolean shouldMirrorAroundYAxis();

    public abstract boolean shouldUseContinuous(boolean var1);

    public abstract void shutDown();

    public abstract boolean startContinuousFocusInArea(Rect var1);

    public abstract boolean startSingleShotFocusInArea(Rect var1);

    public abstract void startWithSettings(NativeCameraDelegateSettings var1, NativeWrappedPromise var2);

    public abstract void updateSettings(NativeCameraDelegateSettings var1, FrameSourceState var2);

    public abstract void wakeUp(NativeWrappedPromise var1);
}

