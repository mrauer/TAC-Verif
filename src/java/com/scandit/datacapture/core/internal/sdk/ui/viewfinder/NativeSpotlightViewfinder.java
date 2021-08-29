/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeSpotlightViewfinder$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.ui.viewfinder;

import com.scandit.datacapture.core.common.geometry.FloatWithUnit;
import com.scandit.datacapture.core.internal.sdk.common.geometry.NativeSizeWithUnitAndAspect;
import com.scandit.datacapture.core.internal.sdk.common.graphics.NativeColor;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeSpotlightViewfinder;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeViewfinder;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeSpotlightViewfinder {
    public NativeSpotlightViewfinder() {
    }

    public static NativeSpotlightViewfinder create() {
        return CppProxy.create();
    }

    public abstract NativeViewfinder asViewfinder();

    public abstract NativeColor getBackgroundColor();

    public abstract NativeColor getDisabledBorderColor();

    public abstract NativeColor getEnabledBorderColor();

    public abstract NativeSizeWithUnitAndAspect getSizeWithUnitAndAspect();

    public abstract void setBackgroundColor(NativeColor var1);

    public abstract void setDisabledBorderColor(NativeColor var1);

    public abstract void setEnabledBorderColor(NativeColor var1);

    public abstract void setHeightAndAspectRatio(FloatWithUnit var1, float var2);

    public abstract void setWidthAndAspectRatio(FloatWithUnit var1, float var2);

    public abstract void setWidthAndHeight(FloatWithUnit var1, FloatWithUnit var2);
}

