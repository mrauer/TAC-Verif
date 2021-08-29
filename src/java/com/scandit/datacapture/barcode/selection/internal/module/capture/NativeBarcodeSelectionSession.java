/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 */
package com.scandit.datacapture.barcode.selection.internal.module.capture;

import com.scandit.datacapture.barcode.internal.sdk.data.NativeBarcode;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

@DjinniGenerated
public abstract class NativeBarcodeSelectionSession {
    public abstract void clearSession();

    public abstract int getCount(NativeBarcode var1);

    public abstract long getFrameSeqIdAndroid();

    public abstract int getLastProcessedFrameId();

    public abstract ArrayList<NativeBarcode> getNewlySelectedBarcodes();

    public abstract ArrayList<NativeBarcode> getNewlyUnselectedBarcodes();

    public abstract ArrayList<NativeBarcode> getSelectedBarcodes();
}

