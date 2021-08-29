/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.selection.internal.module.capture.NativeTapSelection$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.selection.internal.module.capture;

import com.scandit.datacapture.barcode.selection.capture.BarcodeSelectionFreezeBehavior;
import com.scandit.datacapture.barcode.selection.capture.BarcodeSelectionTapBehavior;
import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeSelectionType;
import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeTapSelection;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeTapSelection {
    public NativeTapSelection() {
    }

    public static NativeTapSelection create() {
        return CppProxy.create();
    }

    public abstract NativeSelectionType asSelectionType();

    public abstract BarcodeSelectionFreezeBehavior getFreezeBehavior();

    public abstract BarcodeSelectionTapBehavior getTapBehavior();

    public abstract void setFreezeBehavior(BarcodeSelectionFreezeBehavior var1);

    public abstract void setTapBehavior(BarcodeSelectionTapBehavior var1);
}

