/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.common.geometry.NativeSizeWithUnitAndAspect$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.sdk.common.geometry;

import com.scandit.datacapture.core.common.geometry.FloatWithUnit;
import com.scandit.datacapture.core.common.geometry.SizeWithAspect;
import com.scandit.datacapture.core.common.geometry.SizeWithUnit;
import com.scandit.datacapture.core.common.geometry.SizingMode;
import com.scandit.datacapture.core.internal.sdk.common.geometry.NativeSizeWithUnitAndAspect;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeSizeWithUnitAndAspect {
    public NativeSizeWithUnitAndAspect() {
    }

    public static NativeSizeWithUnitAndAspect createWithHeightAndAspectRatio(FloatWithUnit floatWithUnit, float f2) {
        return CppProxy.createWithHeightAndAspectRatio((FloatWithUnit)floatWithUnit, (float)f2);
    }

    public static NativeSizeWithUnitAndAspect createWithShorterDimensionAndAspectRatio(float f2, float f3) {
        return CppProxy.createWithShorterDimensionAndAspectRatio((float)f2, (float)f3);
    }

    public static NativeSizeWithUnitAndAspect createWithWidthAndAspectRatio(FloatWithUnit floatWithUnit, float f2) {
        return CppProxy.createWithWidthAndAspectRatio((FloatWithUnit)floatWithUnit, (float)f2);
    }

    public static NativeSizeWithUnitAndAspect createWithWidthAndHeight(SizeWithUnit sizeWithUnit) {
        return CppProxy.createWithWidthAndHeight((SizeWithUnit)sizeWithUnit);
    }

    public abstract SizeWithAspect getHeightWithAspect();

    public abstract SizeWithAspect getShorterDimensionWithAspect();

    public abstract SizingMode getSizingMode();

    public abstract SizeWithUnit getWidthAndHeight();

    public abstract SizeWithAspect getWidthWithAspect();

    public abstract String toJson();
}

