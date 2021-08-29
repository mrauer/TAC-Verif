/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.serialization.NativeEnumDeserializer$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.common.geometry.Anchor;
import com.scandit.datacapture.core.internal.module.serialization.NativeEnumDeserializer;
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
public abstract class NativeEnumDeserializer {
    public NativeEnumDeserializer() {
    }

    public static Anchor anchorFromJsonString(String string) {
        return CppProxy.anchorFromJsonString((String)string);
    }

    public static CameraPosition cameraPositionFromJsonString(String string) {
        return CppProxy.cameraPositionFromJsonString((String)string);
    }

    public static FocusGestureStrategy focusGestureStrategyFromJsonString(String string) {
        return CppProxy.focusGestureStrategyFromJsonString((String)string);
    }

    public static NativeFocusStrategy focusStrategyFromJsonString(String string) {
        return CppProxy.focusStrategyFromJsonString((String)string);
    }

    public static FrameSourceState frameSourceStateFromJsonString(String string) {
        return CppProxy.frameSourceStateFromJsonString((String)string);
    }

    public static LaserlineViewfinderStyle laserlineViewfinderStyleFromJsonString(String string) {
        return CppProxy.laserlineViewfinderStyleFromJsonString((String)string);
    }

    public static LogoStyle logoStyleFromJsonString(String string) {
        return CppProxy.logoStyleFromJsonString((String)string);
    }

    public static RectangularViewfinderLineStyle rectangularViewfinderLineStyleFromJsonString(String string) {
        return CppProxy.rectangularViewfinderLineStyleFromJsonString((String)string);
    }

    public static RectangularViewfinderStyle rectangularViewfinderStyleFromJsonString(String string) {
        return CppProxy.rectangularViewfinderStyleFromJsonString((String)string);
    }

    public static NativeRegionStrategy regionStrategyFromJsonString(String string) {
        return CppProxy.regionStrategyFromJsonString((String)string);
    }

    public static TorchState torchStateFromJsonString(String string) {
        return CppProxy.torchStateFromJsonString((String)string);
    }

    public static VideoResolution videoResolutionFromJsonString(String string) {
        return CppProxy.videoResolutionFromJsonString((String)string);
    }
}

