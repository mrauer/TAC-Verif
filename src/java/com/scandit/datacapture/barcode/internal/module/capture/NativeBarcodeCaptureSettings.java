/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSettings$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 *  java.util.HashSet
 */
package com.scandit.datacapture.barcode.internal.module.capture;

import com.scandit.datacapture.barcode.data.CompositeType;
import com.scandit.datacapture.barcode.data.Symbology;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSettings;
import com.scandit.datacapture.barcode.internal.module.capture.NativeSymbologySettings;
import com.scandit.datacapture.core.internal.sdk.area.NativeLocationSelection;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.EnumSet;
import java.util.HashSet;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBarcodeCaptureSettings {
    public NativeBarcodeCaptureSettings() {
    }

    public static NativeBarcodeCaptureSettings create() {
        return CppProxy.create();
    }

    public abstract void enableSymbologies(HashSet<Symbology> var1);

    public abstract void enableSymbologiesForCompositeTypes(EnumSet<CompositeType> var1);

    public abstract int getCodeDuplicateFilterMillis();

    public abstract EnumSet<CompositeType> getEnabledCompositeTypesBits();

    public abstract HashSet<Symbology> getEnabledSymbologies();

    public abstract NativeLocationSelection getLocationSelection();

    public abstract int getProperty(String var1);

    public abstract NativeSymbologySettings getSymbologySettings(Symbology var1);

    public abstract void setCodeDuplicateFilterMillis(int var1);

    public abstract void setEnabledCompositeTypesBits(EnumSet<CompositeType> var1);

    public abstract void setLocationSelection(NativeLocationSelection var1);

    public abstract void setProperty(String var1, int var2);

    public abstract void setSymbologyEnabled(Symbology var1, boolean var2);
}

