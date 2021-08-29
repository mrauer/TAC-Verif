/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.internal.module.source;

import com.scandit.datacapture.core.common.geometry.Point;
import com.scandit.datacapture.core.internal.module.source.NativeFocusStrategy;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.core.source.FocusGestureStrategy;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeFocusSettings {
    public final FocusGestureStrategy focusGestureStrategy;
    public final Point manualFocusPoint;
    public final float manualLensPosition;
    public final NativeJsonValue properties;
    public final NativeFocusStrategy selectedFocusStrategy;
    public final boolean shouldPreferSmoothAutoFocus;

    public NativeFocusSettings(float f2, NativeFocusStrategy nativeFocusStrategy, boolean bl, NativeJsonValue nativeJsonValue, Point point, FocusGestureStrategy focusGestureStrategy) {
        this.manualLensPosition = f2;
        this.selectedFocusStrategy = nativeFocusStrategy;
        this.shouldPreferSmoothAutoFocus = bl;
        this.properties = nativeJsonValue;
        this.manualFocusPoint = point;
        this.focusGestureStrategy = focusGestureStrategy;
    }

    public final boolean equals(Object object) {
        Point point;
        NativeJsonValue nativeJsonValue;
        if (!(object instanceof NativeFocusSettings)) {
            return false;
        }
        NativeFocusSettings nativeFocusSettings = (NativeFocusSettings)object;
        return this.manualLensPosition == nativeFocusSettings.manualLensPosition && this.selectedFocusStrategy == nativeFocusSettings.selectedFocusStrategy && this.shouldPreferSmoothAutoFocus == nativeFocusSettings.shouldPreferSmoothAutoFocus && ((nativeJsonValue = this.properties) == null && nativeFocusSettings.properties == null || nativeJsonValue != null && nativeJsonValue.equals((Object)nativeFocusSettings.properties)) && ((point = this.manualFocusPoint) == null && nativeFocusSettings.manualFocusPoint == null || point != null && point.equals(nativeFocusSettings.manualFocusPoint)) && this.focusGestureStrategy == nativeFocusSettings.focusGestureStrategy;
    }

    public final FocusGestureStrategy getFocusGestureStrategy() {
        return this.focusGestureStrategy;
    }

    public final Point getManualFocusPoint() {
        return this.manualFocusPoint;
    }

    public final float getManualLensPosition() {
        return this.manualLensPosition;
    }

    public final NativeJsonValue getProperties() {
        return this.properties;
    }

    public final NativeFocusStrategy getSelectedFocusStrategy() {
        return this.selectedFocusStrategy;
    }

    public final boolean getShouldPreferSmoothAutoFocus() {
        return this.shouldPreferSmoothAutoFocus;
    }

    public final int hashCode() {
        int n2 = 31 * (31 * (31 * (527 + Float.floatToIntBits((float)this.manualLensPosition)) + this.selectedFocusStrategy.hashCode()) + this.shouldPreferSmoothAutoFocus);
        NativeJsonValue nativeJsonValue = this.properties;
        int n3 = nativeJsonValue == null ? 0 : nativeJsonValue.hashCode();
        int n4 = 31 * (n2 + n3);
        Point point = this.manualFocusPoint;
        int n5 = point == null ? 0 : point.hashCode();
        return 31 * (n4 + n5) + this.focusGestureStrategy.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeFocusSettings{manualLensPosition=");
        stringBuilder.append(this.manualLensPosition);
        stringBuilder.append(",selectedFocusStrategy=");
        stringBuilder.append((Object)this.selectedFocusStrategy);
        stringBuilder.append(",shouldPreferSmoothAutoFocus=");
        stringBuilder.append(this.shouldPreferSmoothAutoFocus);
        stringBuilder.append(",properties=");
        stringBuilder.append((Object)this.properties);
        stringBuilder.append(",manualFocusPoint=");
        stringBuilder.append((Object)this.manualFocusPoint);
        stringBuilder.append(",focusGestureStrategy=");
        stringBuilder.append((Object)this.focusGestureStrategy);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

