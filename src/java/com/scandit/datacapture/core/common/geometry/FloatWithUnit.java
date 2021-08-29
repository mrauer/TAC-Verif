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

import com.scandit.datacapture.core.common.geometry.MeasureUnit;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class FloatWithUnit {
    public final MeasureUnit unit;
    public final float value;

    public FloatWithUnit(float f2, MeasureUnit measureUnit) {
        this.value = f2;
        this.unit = measureUnit;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof FloatWithUnit)) {
            return false;
        }
        FloatWithUnit floatWithUnit = (FloatWithUnit)object;
        return this.value == floatWithUnit.value && this.unit == floatWithUnit.unit;
    }

    public final MeasureUnit getUnit() {
        return this.unit;
    }

    public final float getValue() {
        return this.value;
    }

    public final int hashCode() {
        return 31 * (527 + Float.floatToIntBits((float)this.value)) + this.unit.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("FloatWithUnit{value=");
        stringBuilder.append(this.value);
        stringBuilder.append(",unit=");
        stringBuilder.append((Object)this.unit);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

