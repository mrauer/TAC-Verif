/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.common.geometry;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class Size2 {
    public final float height;
    public final float width;

    public Size2(float f2, float f3) {
        this.width = f2;
        this.height = f3;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof Size2)) {
            return false;
        }
        Size2 size2 = (Size2)object;
        return this.width == size2.width && this.height == size2.height;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getWidth() {
        return this.width;
    }

    public final int hashCode() {
        return 31 * (527 + Float.floatToIntBits((float)this.width)) + Float.floatToIntBits((float)this.height);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Size2{width=");
        stringBuilder.append(this.width);
        stringBuilder.append(",height=");
        stringBuilder.append(this.height);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

