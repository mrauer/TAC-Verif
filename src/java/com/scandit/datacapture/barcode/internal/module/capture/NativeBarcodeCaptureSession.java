/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.scandit.datacapture.barcode.internal.module.capture;

import com.scandit.datacapture.barcode.internal.sdk.data.NativeBarcode;
import com.scandit.datacapture.barcode.internal.sdk.data.NativeLocalizedOnlyBarcode;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

@DjinniGenerated
public abstract class NativeBarcodeCaptureSession {
    public abstract void clear();

    public abstract long getFrameSeqIdAndroid();

    public abstract ArrayList<NativeLocalizedOnlyBarcode> getNewlyLocalizedBarcodes();

    public abstract ArrayList<NativeBarcode> getNewlyRecognizedBarcodes();

    public abstract String toJson();
}

