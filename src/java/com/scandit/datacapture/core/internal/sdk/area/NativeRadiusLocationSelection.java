/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.area.NativeRadiusLocationSelection$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.area;

import com.scandit.datacapture.core.common.geometry.FloatWithUnit;
import com.scandit.datacapture.core.internal.sdk.area.NativeLocationSelection;
import com.scandit.datacapture.core.internal.sdk.area.NativeRadiusLocationSelection;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeRadiusLocationSelection {
    public NativeRadiusLocationSelection() {
    }

    public static NativeRadiusLocationSelection create(FloatWithUnit floatWithUnit) {
        return CppProxy.create((FloatWithUnit)floatWithUnit);
    }

    public abstract NativeLocationSelection asLocationSelection();

    public abstract FloatWithUnit getRadius();
}

