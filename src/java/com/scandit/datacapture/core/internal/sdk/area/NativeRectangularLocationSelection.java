/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.area.NativeRectangularLocationSelection$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.area;

import com.scandit.datacapture.core.common.geometry.FloatWithUnit;
import com.scandit.datacapture.core.internal.sdk.area.NativeLocationSelection;
import com.scandit.datacapture.core.internal.sdk.area.NativeRectangularLocationSelection;
import com.scandit.datacapture.core.internal.sdk.common.geometry.NativeSizeWithUnitAndAspect;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeRectangularLocationSelection {
    public NativeRectangularLocationSelection() {
    }

    public static NativeRectangularLocationSelection create() {
        return CppProxy.create();
    }

    public abstract NativeLocationSelection asLocationSelection();

    public abstract NativeSizeWithUnitAndAspect getSizeWithUnitAndAspect();

    public abstract void setHeightAndAspectRatio(FloatWithUnit var1, float var2);

    public abstract void setWidthAndAspectRatio(FloatWithUnit var1, float var2);

    public abstract void setWidthAndHeight(FloatWithUnit var1, FloatWithUnit var2);
}

