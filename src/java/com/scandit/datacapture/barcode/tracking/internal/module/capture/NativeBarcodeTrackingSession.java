/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 */
package com.scandit.datacapture.barcode.tracking.internal.module.capture;

import com.scandit.datacapture.barcode.tracking.internal.module.data.NativeTrackedBarcode;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;
import java.util.HashMap;

@DjinniGenerated
public abstract class NativeBarcodeTrackingSession {
    public abstract ArrayList<NativeTrackedBarcode> getAddedTrackedBarcodes();

    public abstract long getFrameSeqIdAndroid();

    public abstract ArrayList<Integer> getRemovedTrackedBarcodes();

    public abstract HashMap<Integer, NativeTrackedBarcode> getTrackedBarcodes();

    public abstract ArrayList<NativeTrackedBarcode> getUpdatedTrackedBarcodes();

    public abstract String toJson();
}

