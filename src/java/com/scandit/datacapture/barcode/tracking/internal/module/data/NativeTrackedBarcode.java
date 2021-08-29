/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.barcode.tracking.internal.module.data;

import com.scandit.datacapture.barcode.internal.sdk.data.NativeBarcode;
import com.scandit.datacapture.core.common.geometry.Anchor;
import com.scandit.datacapture.core.common.geometry.Point;
import com.scandit.datacapture.core.common.geometry.Quadrilateral;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeTrackedBarcode {
    public abstract Point getAnchorPosition(Anchor var1);

    public abstract Point getAnchorPositionIgnoringLicense(Anchor var1);

    public abstract NativeBarcode getBarcode();

    public abstract float getDeltaTime();

    public abstract int getIdentifier();

    public abstract Quadrilateral getLocation();

    public abstract Quadrilateral getLocationIgnoringLicense();

    public abstract Quadrilateral getPredictedLocation();

    public abstract Quadrilateral getPredictedLocationIgnoringLicense();

    public abstract boolean shouldAnimateFromPreviousToNextState();

    public abstract String toJson();
}

