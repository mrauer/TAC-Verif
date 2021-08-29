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
public final class BarcodeSelectionTapBehavior
extends Enum<BarcodeSelectionTapBehavior> {
    public static final /* enum */ BarcodeSelectionTapBehavior REPEAT_SELECTION;
    public static final /* enum */ BarcodeSelectionTapBehavior TOGGLE_SELECTION;
    private static final /* synthetic */ BarcodeSelectionTapBehavior[] a;

    public static {
        BarcodeSelectionTapBehavior barcodeSelectionTapBehavior;
        BarcodeSelectionTapBehavior barcodeSelectionTapBehavior2;
        TOGGLE_SELECTION = barcodeSelectionTapBehavior2 = new BarcodeSelectionTapBehavior();
        REPEAT_SELECTION = barcodeSelectionTapBehavior = new BarcodeSelectionTapBehavior();
        a = new BarcodeSelectionTapBehavior[]{barcodeSelectionTapBehavior2, barcodeSelectionTapBehavior};
    }

    public static BarcodeSelectionTapBehavior valueOf(String string) {
        return (BarcodeSelectionTapBehavior)Enum.valueOf(BarcodeSelectionTapBehavior.class, (String)string);
    }

    public static BarcodeSelectionTapBehavior[] values() {
        return (BarcodeSelectionTapBehavior[])a.clone();
    }
}

