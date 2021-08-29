/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTrackingSettings$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 */
package com.scandit.datacapture.barcode.tracking.internal.module.capture;

import com.scandit.datacapture.barcode.data.Symbology;
import com.scandit.datacapture.barcode.internal.module.capture.NativeSymbologySettings;
import com.scandit.datacapture.barcode.tracking.internal.module.capture.NativeBarcodeTrackingSettings;
import com.scandit.datacapture.barcode.tracking.internal.module.data.NativeObjectTrackerScenario;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.HashSet;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBarcodeTrackingSettings {
    public NativeBarcodeTrackingSettings() {
    }

    public static NativeBarcodeTrackingSettings create() {
        return CppProxy.create();
    }

    public static NativeBarcodeTrackingSettings createForScenario(NativeObjectTrackerScenario nativeObjectTrackerScenario) {
        return CppProxy.createForScenario((NativeObjectTrackerScenario)nativeObjectTrackerScenario);
    }

    public abstract void enableSymbologies(HashSet<Symbology> var1);

    public abstract HashSet<Symbology> getEnabledSymbologies();

    public abstract int getProperty(String var1);

    public abstract NativeSymbologySettings getSymbologySettings(Symbology var1);

    public abstract void setProperty(String var1, int var2);

    public abstract void setSymbologyEnabled(Symbology var1, boolean var2);
}

