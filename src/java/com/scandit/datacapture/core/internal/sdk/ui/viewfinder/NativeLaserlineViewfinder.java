/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeLaserlineViewfinder$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.ui.viewfinder;

import com.scandit.datacapture.core.common.geometry.FloatWithUnit;
import com.scandit.datacapture.core.internal.sdk.common.graphics.NativeColor;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeLaserlineViewfinder;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeViewfinder;
import com.scandit.datacapture.core.ui.viewfinder.LaserlineViewfinderStyle;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeLaserlineViewfinder {
    public NativeLaserlineViewfinder() {
    }

    public static NativeLaserlineViewfinder create() {
        return CppProxy.create();
    }

    public static NativeLaserlineViewfinder createForStyle(LaserlineViewfinderStyle laserlineViewfinderStyle) {
        return CppProxy.createForStyle((LaserlineViewfinderStyle)laserlineViewfinderStyle);
    }

    public abstract NativeViewfinder asViewfinder();

    public abstract NativeColor getDisabledColor();

    public abstract NativeColor getEnabledColor();

    public abstract LaserlineViewfinderStyle getStyle();

    public abstract FloatWithUnit getWidth();

    public abstract void setDisabledColor(NativeColor var1);

    public abstract void setEnabledColor(NativeColor var1);

    public abstract void setWidth(FloatWithUnit var1);
}

