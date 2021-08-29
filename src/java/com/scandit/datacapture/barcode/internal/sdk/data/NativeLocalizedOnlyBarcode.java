/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.barcode.internal.sdk.data;

import com.scandit.datacapture.core.common.geometry.Quadrilateral;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeLocalizedOnlyBarcode {
    public abstract int getFrameId();

    public abstract Quadrilateral getLocation();

    public abstract String toJson();
}

