/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.common.geometry;

import com.scandit.datacapture.core.common.geometry.Point;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class Quadrilateral {
    public final Point bottomLeft;
    public final Point bottomRight;
    public final Point topLeft;
    public final Point topRight;

    public Quadrilateral(Point point, Point point2, Point point3, Point point4) {
        this.topLeft = point;
        this.topRight = point2;
        this.bottomRight = point3;
        this.bottomLeft = point4;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof Quadrilateral)) {
            return false;
        }
        Quadrilateral quadrilateral = (Quadrilateral)object;
        return this.topLeft.equals(quadrilateral.topLeft) && this.topRight.equals(quadrilateral.topRight) && this.bottomRight.equals(quadrilateral.bottomRight) && this.bottomLeft.equals(quadrilateral.bottomLeft);
    }

    public final Point getBottomLeft() {
        return this.bottomLeft;
    }

    public final Point getBottomRight() {
        return this.bottomRight;
    }

    public final Point getTopLeft() {
        return this.topLeft;
    }

    public final Point getTopRight() {
        return this.topRight;
    }

    public final int hashCode() {
        return 31 * (31 * (31 * (527 + this.topLeft.hashCode()) + this.topRight.hashCode()) + this.bottomRight.hashCode()) + this.bottomLeft.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Quadrilateral{topLeft=");
        stringBuilder.append((Object)this.topLeft);
        stringBuilder.append(",topRight=");
        stringBuilder.append((Object)this.topRight);
        stringBuilder.append(",bottomRight=");
        stringBuilder.append((Object)this.bottomRight);
        stringBuilder.append(",bottomLeft=");
        stringBuilder.append((Object)this.bottomLeft);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

