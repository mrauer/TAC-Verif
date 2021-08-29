/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.serialization.NativeEnumSerializer$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.common.Direction;
import com.scandit.datacapture.core.common.geometry.Anchor;
import com.scandit.datacapture.core.internal.module.serialization.NativeEnumSerializer;
import com.scandit.datacapture.core.internal.module.source.NativeFocusStrategy;
import com.scandit.datacapture.core.internal.module.source.NativeRegionStrategy;
import com.scandit.datacapture.core.source.CameraPosition;
import com.scandit.datacapture.core.source.FocusGestureStrategy;
import com.scandit.datacapture.core.source.FrameSourceState;
import com.scandit.datacapture.core.source.TorchState;
import com.scandit.datacapture.core.source.VideoResolution;
import com.scandit.datacapture.core.ui.LogoStyle;
import com.scandit.datacapture.core.ui.viewfinder.LaserlineViewfinderStyle;
import com.scandit.datacapture.core.ui.viewfinder.RectangularViewfinderLineStyle;
import com.scandit.datacapture.core.ui.viewfinder.RectangularViewfinderStyle;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeEnumSerializer {
    public NativeEnumSerializer() {
    }

    public static String anchorToString(Anchor anchor) {
        return CppProxy.anchorToString((Anchor)anchor);
    }

    public static String cameraPositionToString(CameraPosition cameraPosition) {
        return CppProxy.cameraPositionToString((CameraPosition)cameraPosition);
    }

    public static String directionToString(Direction direction) {
        return CppProxy.directionToString((Direction)direction);
    }

    public static String focusGestureStrategyToString(FocusGestureStrategy focusGestureStrategy) {
        return CppProxy.focusGestureStrategyToString((FocusGestureStrategy)focusGestureStrategy);
    }

    public static String focusStrategyToString(NativeFocusStrategy nativeFocusStrategy) {
        return CppProxy.focusStrategyToString((NativeFocusStrategy)nativeFocusStrategy);
    }

    public static String frameSourceStateToString(FrameSourceState frameSourceState) {
        return CppProxy.frameSourceStateToString((FrameSourceState)frameSourceState);
    }

    public static String laserlineViewfinderStyleToString(LaserlineViewfinderStyle laserlineViewfinderStyle) {
        return CppProxy.laserlineViewfinderStyleToString((LaserlineViewfinderStyle)laserlineViewfinderStyle);
    }

    public static String logoStyleToString(LogoStyle logoStyle) {
        return CppProxy.logoStyleToString((LogoStyle)logoStyle);
    }

    public static String rectangularViewfinderLineStyleToString(RectangularViewfinderLineStyle rectangularViewfinderLineStyle) {
        return CppProxy.rectangularViewfinderLineStyleToString((RectangularViewfinderLineStyle)rectangularViewfinderLineStyle);
    }

    public static String rectangularViewfinderStyleToString(RectangularViewfinderStyle rectangularViewfinderStyle) {
        return CppProxy.rectangularViewfinderStyleToString((RectangularViewfinderStyle)rectangularViewfinderStyle);
    }

    public static String regionStrategyToString(NativeRegionStrategy nativeRegionStrategy) {
        return CppProxy.regionStrategyToString((NativeRegionStrategy)nativeRegionStrategy);
    }

    public static String torchStateToString(TorchState torchState) {
        return CppProxy.torchStateToString((TorchState)torchState);
    }

    public static String videoResolutionToString(VideoResolution videoResolution) {
        return CppProxy.videoResolutionToString((VideoResolution)videoResolution);
    }
}

