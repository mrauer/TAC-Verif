/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.barcode.selection.capture;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class BarcodeSelectionFreezeBehavior
extends Enum<BarcodeSelectionFreezeBehavior> {
    public static final /* enum */ BarcodeSelectionFreezeBehavior MANUAL;
    public static final /* enum */ BarcodeSelectionFreezeBehavior MANUAL_AND_AUTOMATIC;
    private static final /* synthetic */ BarcodeSelectionFreezeBehavior[] a;

    public static {
        BarcodeSelectionFreezeBehavior barcodeSelectionFreezeBehavior;
        BarcodeSelectionFreezeBehavior barcodeSelectionFreezeBehavior2;
        MANUAL = barcodeSelectionFreezeBehavior = new BarcodeSelectionFreezeBehavior();
        MANUAL_AND_AUTOMATIC = barcodeSelectionFreezeBehavior2 = new BarcodeSelectionFreezeBehavior();
        a = new BarcodeSelectionFreezeBehavior[]{barcodeSelectionFreezeBehavior, barcodeSelectionFreezeBehavior2};
    }

    public static BarcodeSelectionFreezeBehavior valueOf(String string) {
        return (BarcodeSelectionFreezeBehavior)Enum.valueOf(BarcodeSelectionFreezeBehavior.class, (String)string);
    }

    public static BarcodeSelectionFreezeBehavior[] values() {
        return (BarcodeSelectionFreezeBehavior[])a.clone();
    }
}

