/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.selection.internal.module.ui.overlay.NativeBarcodeSelectionBasicOverlay$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.selection.internal.module.ui.overlay;

import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeBarcodeSelection;
import com.scandit.datacapture.barcode.selection.internal.module.ui.overlay.NativeBarcodeSelectionBasicOverlay;
import com.scandit.datacapture.core.internal.sdk.ui.overlay.NativeDataCaptureOverlay;
import com.scandit.datacapture.core.internal.sdk.ui.style.NativeBrush;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeViewfinder;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBarcodeSelectionBasicOverlay {
    public NativeBarcodeSelectionBasicOverlay() {
    }

    public static NativeBarcodeSelectionBasicOverlay create(NativeBarcodeSelection nativeBarcodeSelection, NativeViewfinder nativeViewfinder) {
        return CppProxy.create((NativeBarcodeSelection)nativeBarcodeSelection, (NativeViewfinder)nativeViewfinder);
    }

    public static NativeBrush defaultAimedBrush() {
        return CppProxy.defaultAimedBrush();
    }

    public static NativeBrush defaultSelectedBrush() {
        return CppProxy.defaultSelectedBrush();
    }

    public static NativeBrush defaultSelectingBrush() {
        return CppProxy.defaultSelectingBrush();
    }

    public static NativeBrush defaultTrackedBrush() {
        return CppProxy.defaultTrackedBrush();
    }

    public abstract NativeDataCaptureOverlay asDataCaptureOverlay();

    public abstract void clearSelectedBarcodeBrushes();

    public abstract NativeBrush getAimedBrush();

    public abstract NativeBrush getSelectedBrush();

    public abstract NativeBrush getSelectingBrush();

    public abstract boolean getShouldShowScanAreaGuides();

    public abstract boolean getShowHints();

    public abstract NativeBrush getTrackedBrush();

    public abstract void setAimedBrush(NativeBrush var1);

    public abstract void setSelectedBrush(NativeBrush var1);

    public abstract void setSelectingBrush(NativeBrush var1);

    public abstract void setShouldShowScanAreaGuides(boolean var1);

    public abstract void setShowHints(boolean var1);

    public abstract void setTrackedBrush(NativeBrush var1);
}

