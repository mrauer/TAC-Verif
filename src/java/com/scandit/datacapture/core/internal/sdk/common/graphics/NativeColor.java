/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.internal.sdk.common.graphics;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeColor {
    public final float a;
    public final float b;
    public final float g;
    public final float r;

    public NativeColor(float f2, float f3, float f4, float f5) {
        this.r = f2;
        this.g = f3;
        this.b = f4;
        this.a = f5;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof NativeColor)) {
            return false;
        }
        NativeColor nativeColor = (NativeColor)object;
        return this.r == nativeColor.r && this.g == nativeColor.g && this.b == nativeColor.b && this.a == nativeColor.a;
    }

    public final float getA() {
        return this.a;
    }

    public final float getB() {
        return this.b;
    }

    public final float getG() {
        return this.g;
    }

    public final float getR() {
        return this.r;
    }

    public final int hashCode() {
        return 31 * (31 * (31 * (527 + Float.floatToIntBits((float)this.r)) + Float.floatToIntBits((float)this.g)) + Float.floatToIntBits((float)this.b)) + Float.floatToIntBits((float)this.a);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeColor{r=");
        stringBuilder.append(this.r);
        stringBuilder.append(",g=");
        stringBuilder.append(this.g);
        stringBuilder.append(",b=");
        stringBuilder.append(this.b);
        stringBuilder.append(",a=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

