/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.internal.sdk.ui.style;

import com.scandit.datacapture.core.internal.sdk.common.graphics.NativeColor;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeBrush {
    public final NativeColor fillColor;
    public final NativeColor strokeColor;
    public final float strokeWidth;

    public NativeBrush(NativeColor nativeColor, NativeColor nativeColor2, float f2) {
        this.fillColor = nativeColor;
        this.strokeColor = nativeColor2;
        this.strokeWidth = f2;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof NativeBrush)) {
            return false;
        }
        NativeBrush nativeBrush = (NativeBrush)object;
        return this.fillColor.equals(nativeBrush.fillColor) && this.strokeColor.equals(nativeBrush.strokeColor) && this.strokeWidth == nativeBrush.strokeWidth;
    }

    public final NativeColor getFillColor() {
        return this.fillColor;
    }

    public final NativeColor getStrokeColor() {
        return this.strokeColor;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final int hashCode() {
        return 31 * (31 * (527 + this.fillColor.hashCode()) + this.strokeColor.hashCode()) + Float.floatToIntBits((float)this.strokeWidth);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeBrush{fillColor=");
        stringBuilder.append((Object)this.fillColor);
        stringBuilder.append(",strokeColor=");
        stringBuilder.append((Object)this.strokeColor);
        stringBuilder.append(",strokeWidth=");
        stringBuilder.append(this.strokeWidth);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

