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
public final class MarginsWithUnit {
    public final FloatWithUnit bottom;
    public final FloatWithUnit left;
    public final FloatWithUnit right;
    public final FloatWithUnit top;

    public MarginsWithUnit(FloatWithUnit floatWithUnit, FloatWithUnit floatWithUnit2, FloatWithUnit floatWithUnit3, FloatWithUnit floatWithUnit4) {
        this.left = floatWithUnit;
        this.top = floatWithUnit2;
        this.right = floatWithUnit3;
        this.bottom = floatWithUnit4;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof MarginsWithUnit)) {
            return false;
        }
        MarginsWithUnit marginsWithUnit = (MarginsWithUnit)object;
        return this.left.equals(marginsWithUnit.left) && this.top.equals(marginsWithUnit.top) && this.right.equals(marginsWithUnit.right) && this.bottom.equals(marginsWithUnit.bottom);
    }

    public final FloatWithUnit getBottom() {
        return this.bottom;
    }

    public final FloatWithUnit getLeft() {
        return this.left;
    }

    public final FloatWithUnit getRight() {
        return this.right;
    }

    public final FloatWithUnit getTop() {
        return this.top;
    }

    public final int hashCode() {
        return 31 * (31 * (31 * (527 + this.left.hashCode()) + this.top.hashCode()) + this.right.hashCode()) + this.bottom.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MarginsWithUnit{left=");
        stringBuilder.append((Object)this.left);
        stringBuilder.append(",top=");
        stringBuilder.append((Object)this.top);
        stringBuilder.append(",right=");
        stringBuilder.append((Object)this.right);
        stringBuilder.append(",bottom=");
        stringBuilder.append((Object)this.bottom);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

