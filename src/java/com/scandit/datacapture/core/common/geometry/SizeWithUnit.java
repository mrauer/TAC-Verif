/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.common.geometry;

import com.scandit.datacapture.core.common.geometry.FloatWithUnit;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class SizeWithUnit {
    public final FloatWithUnit height;
    public final FloatWithUnit width;

    public SizeWithUnit(FloatWithUnit floatWithUnit, FloatWithUnit floatWithUnit2) {
        this.width = floatWithUnit;
        this.height = floatWithUnit2;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof SizeWithUnit)) {
            return false;
        }
        SizeWithUnit sizeWithUnit = (SizeWithUnit)object;
        return this.width.equals(sizeWithUnit.width) && this.height.equals(sizeWithUnit.height);
    }

    public final FloatWithUnit getHeight() {
        return this.height;
    }

    public final FloatWithUnit getWidth() {
        return this.width;
    }

    public final int hashCode() {
        return 31 * (527 + this.width.hashCode()) + this.height.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SizeWithUnit{width=");
        stringBuilder.append((Object)this.width);
        stringBuilder.append(",height=");
        stringBuilder.append((Object)this.height);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

