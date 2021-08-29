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
public final class PointWithUnit {
    public final FloatWithUnit x;
    public final FloatWithUnit y;

    public PointWithUnit(FloatWithUnit floatWithUnit, FloatWithUnit floatWithUnit2) {
        this.x = floatWithUnit;
        this.y = floatWithUnit2;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof PointWithUnit)) {
            return false;
        }
        PointWithUnit pointWithUnit = (PointWithUnit)object;
        return this.x.equals(pointWithUnit.x) && this.y.equals(pointWithUnit.y);
    }

    public final FloatWithUnit getX() {
        return this.x;
    }

    public final FloatWithUnit getY() {
        return this.y;
    }

    public final int hashCode() {
        return 31 * (527 + this.x.hashCode()) + this.y.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PointWithUnit{x=");
        stringBuilder.append((Object)this.x);
        stringBuilder.append(",y=");
        stringBuilder.append((Object)this.y);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

