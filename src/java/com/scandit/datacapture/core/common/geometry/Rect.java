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
import com.scandit.datacapture.core.common.geometry.Size2;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class Rect {
    public final Point origin;
    public final Size2 size;

    public Rect(Point point, Size2 size2) {
        this.origin = point;
        this.size = size2;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect)object;
        return this.origin.equals(rect.origin) && this.size.equals(rect.size);
    }

    public final Point getOrigin() {
        return this.origin;
    }

    public final Size2 getSize() {
        return this.size;
    }

    public final int hashCode() {
        return 31 * (527 + this.origin.hashCode()) + this.size.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Rect{origin=");
        stringBuilder.append((Object)this.origin);
        stringBuilder.append(",size=");
        stringBuilder.append((Object)this.size);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

