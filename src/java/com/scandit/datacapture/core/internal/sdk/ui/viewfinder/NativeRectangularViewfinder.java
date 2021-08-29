/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeRectangularViewfinder$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.ui.viewfinder;

import com.scandit.datacapture.core.common.geometry.FloatWithUnit;
import com.scandit.datacapture.core.internal.sdk.common.geometry.NativeSizeWithUnitAndAspect;
import com.scandit.datacapture.core.internal.sdk.common.graphics.NativeColor;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeRectangularViewfinder;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeRectangularViewfinderAnimation;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeViewfinder;
import com.scandit.datacapture.core.ui.viewfinder.RectangularViewfinderLineStyle;
import com.scandit.datacapture.core.ui.viewfinder.RectangularViewfinderStyle;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeRectangularViewfinder {
    public NativeRectangularViewfinder() {
    }

    public static NativeRectangularViewfinder create() {
        return CppProxy.create();
    }

    public static NativeRectangularViewfinder createForStyles(RectangularViewfinderStyle rectangularViewfinderStyle, RectangularViewfinderLineStyle rectangularViewfinderLineStyle) {
        return CppProxy.createForStyles((RectangularViewfinderStyle)rectangularViewfinderStyle, (RectangularViewfinderLineStyle)rectangularViewfinderLineStyle);
    }

    public abstract NativeViewfinder asViewfinder();

    public abstract NativeRectangularViewfinderAnimation getAnimation();

    public abstract NativeColor getColor();

    public abstract float getDimming();

    public abstract NativeColor getDisabledColor();

    public abstract RectangularViewfinderLineStyle getLineStyle();

    public abstract NativeSizeWithUnitAndAspect getSizeWithUnitAndAspect();

    public abstract RectangularViewfinderStyle getStyle();

    public abstract void setAnimation(NativeRectangularViewfinderAnimation var1);

    public abstract void setColor(NativeColor var1);

    public abstract void setDimming(float var1);

    public abstract void setDisabledColor(NativeColor var1);

    public abstract void setHeightAndAspectRatio(FloatWithUnit var1, float var2);

    public abstract void setShorterDimensionAndAspectRatio(float var1, float var2);

    public abstract void setWidthAndAspectRatio(FloatWithUnit var1, float var2);

    public abstract void setWidthAndHeight(FloatWithUnit var1, FloatWithUnit var2);
}

