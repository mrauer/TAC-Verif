/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.common.geometry;

import com.scandit.datacapture.core.common.geometry.PointWithUnit;
import com.scandit.datacapture.core.common.geometry.SizeWithUnit;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class RectWithUnit {
    public final PointWithUnit origin;
    public final SizeWithUnit size;

    public RectWithUnit(PointWithUnit pointWithUnit, SizeWithUnit sizeWithUnit) {
        this.origin = pointWithUnit;
        this.size = sizeWithUnit;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof RectWithUnit)) {
            return false;
        }
        RectWithUnit rectWithUnit = (RectWithUnit)object;
        return this.origin.equals(rectWithUnit.origin) && this.size.equals(rectWithUnit.size);
    }

    public final PointWithUnit getOrigin() {
        return this.origin;
    }

    public final SizeWithUnit getSize() {
        return this.size;
    }

    public final int hashCode() {
        return 31 * (527 + this.origin.hashCode()) + this.size.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RectWithUnit{origin=");
        stringBuilder.append((Object)this.origin);
        stringBuilder.append(",size=");
        stringBuilder.append((Object)this.size);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

