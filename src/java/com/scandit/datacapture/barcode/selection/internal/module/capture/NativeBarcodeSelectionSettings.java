/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.selection.internal.module.capture.NativeBarcodeSelectionSettings$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 */
package com.scandit.datacapture.barcode.selection.internal.module.capture;

import com.scandit.datacapture.barcode.data.Symbology;
import com.scandit.datacapture.barcode.internal.module.capture.NativeSymbologySettings;
import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeBarcodeSelectionSettings;
import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeSelectionType;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.HashSet;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBarcodeSelectionSettings {
    public NativeBarcodeSelectionSettings() {
    }

    public static NativeBarcodeSelectionSettings create() {
        return CppProxy.create();
    }

    public abstract void enableSymbologies(HashSet<Symbology> var1);

    public abstract int getCodeDuplicateFilterMilliseconds();

    public abstract HashSet<Symbology> getEnabledSymbologies();

    public abstract int getProperty(String var1);

    public abstract NativeSelectionType getSelectionType();

    public abstract boolean getSingleBarcodeAutoDetectionEnabled();

    public abstract NativeSymbologySettings getSymbologySettings(Symbology var1);

    public abstract void setCodeDuplicateFilterMilliseconds(int var1);

    public abstract void setProperty(String var1, int var2);

    public abstract void setSelectionType(NativeSelectionType var1);

    public abstract void setSingleBarcodeAutoDetectionEnabled(boolean var1);

    public abstract void setSymbologyEnabled(Symbology var1, boolean var2);
}

