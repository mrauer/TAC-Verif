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

import com.scandit.datacapture.core.common.geometry.FloatWithUnit;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class SizeWithAspect {
    public final float aspect;
    public final FloatWithUnit size;

    public SizeWithAspect(FloatWithUnit floatWithUnit, float f2) {
        this.size = floatWithUnit;
        this.aspect = f2;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof SizeWithAspect)) {
            return false;
        }
        SizeWithAspect sizeWithAspect = (SizeWithAspect)object;
        return this.size.equals(sizeWithAspect.size) && this.aspect == sizeWithAspect.aspect;
    }

    public final float getAspect() {
        return this.aspect;
    }

    public final FloatWithUnit getSize() {
        return this.size;
    }

    public final int hashCode() {
        return 31 * (527 + this.size.hashCode()) + Float.floatToIntBits((float)this.aspect);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SizeWithAspect{size=");
        stringBuilder.append((Object)this.size);
        stringBuilder.append(",aspect=");
        stringBuilder.append(this.aspect);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

