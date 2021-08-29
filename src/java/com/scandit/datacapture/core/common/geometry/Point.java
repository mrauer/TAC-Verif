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
public final class Point {
    public final float x;
    public final float y;

    public Point(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof Point)) {
            return false;
        }
        Point point = (Point)object;
        return this.x == point.x && this.y == point.y;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final int hashCode() {
        return 31 * (527 + Float.floatToIntBits((float)this.x)) + Float.floatToIntBits((float)this.y);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Point{x=");
        stringBuilder.append(this.x);
        stringBuilder.append(",y=");
        stringBuilder.append(this.y);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

