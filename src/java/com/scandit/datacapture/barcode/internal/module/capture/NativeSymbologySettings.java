/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.util.EnumSet
 *  java.util.HashSet
 */
package com.scandit.datacapture.barcode.internal.module.capture;

import com.scandit.datacapture.barcode.data.Checksum;
import com.scandit.datacapture.barcode.data.Symbology;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.EnumSet;
import java.util.HashSet;

@DjinniGenerated
public abstract class NativeSymbologySettings {
    public abstract HashSet<Short> getActiveSymbolCounts();

    public abstract EnumSet<Checksum> getChecksumBits();

    public abstract HashSet<String> getEnabledExtensions();

    public abstract Symbology getSymbology();

    public abstract boolean isColorInvertedEnabled();

    public abstract boolean isEnabled();

    public abstract boolean isExtensionEnabled(String var1);

    public abstract void setActiveSymbolCounts(HashSet<Short> var1);

    public abstract void setChecksumBits(EnumSet<Checksum> var1);

    public abstract void setColorInvertedEnabled(boolean var1);

    public abstract void setEnabled(boolean var1);

    public abstract void setExtensionEnabled(String var1, boolean var2);

    public abstract String toJson();
}

