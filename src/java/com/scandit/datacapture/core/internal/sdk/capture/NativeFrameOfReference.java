/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.internal.sdk.capture;

import com.scandit.datacapture.core.common.geometry.MarginsWithUnit;
import com.scandit.datacapture.core.common.geometry.PointWithUnit;
import com.scandit.datacapture.core.common.geometry.SizeWithUnit;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeFrameOfReference {
    public final MarginsWithUnit margins;
    public final float pixelsPerDip;
    public final PointWithUnit pointOfInterest;
    public final int rotation;
    public final SizeWithUnit viewSize;

    public NativeFrameOfReference(SizeWithUnit sizeWithUnit, float f2, int n2, PointWithUnit pointWithUnit, MarginsWithUnit marginsWithUnit) {
        this.viewSize = sizeWithUnit;
        this.pixelsPerDip = f2;
        this.rotation = n2;
        this.pointOfInterest = pointWithUnit;
        this.margins = marginsWithUnit;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof NativeFrameOfReference)) {
            return false;
        }
        NativeFrameOfReference nativeFrameOfReference = (NativeFrameOfReference)object;
        return this.viewSize.equals(nativeFrameOfReference.viewSize) && this.pixelsPerDip == nativeFrameOfReference.pixelsPerDip && this.rotation == nativeFrameOfReference.rotation && this.pointOfInterest.equals(nativeFrameOfReference.pointOfInterest) && this.margins.equals(nativeFrameOfReference.margins);
    }

    public final MarginsWithUnit getMargins() {
        return this.margins;
    }

    public final float getPixelsPerDip() {
        return this.pixelsPerDip;
    }

    public final PointWithUnit getPointOfInterest() {
        return this.pointOfInterest;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final SizeWithUnit getViewSize() {
        return this.viewSize;
    }

    public final int hashCode() {
        return 31 * (31 * (31 * (31 * (527 + this.viewSize.hashCode()) + Float.floatToIntBits((float)this.pixelsPerDip)) + this.rotation) + this.pointOfInterest.hashCode()) + this.margins.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeFrameOfReference{viewSize=");
        stringBuilder.append((Object)this.viewSize);
        stringBuilder.append(",pixelsPerDip=");
        stringBuilder.append(this.pixelsPerDip);
        stringBuilder.append(",rotation=");
        stringBuilder.append(this.rotation);
        stringBuilder.append(",pointOfInterest=");
        stringBuilder.append((Object)this.pointOfInterest);
        stringBuilder.append(",margins=");
        stringBuilder.append((Object)this.margins);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

