/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.internal.sdk.data.NativeSymbologyDescription$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 */
package com.scandit.datacapture.barcode.internal.sdk.data;

import com.scandit.datacapture.barcode.data.Symbology;
import com.scandit.datacapture.barcode.internal.sdk.data.NativeSymbologyDescription;
import com.scandit.datacapture.core.data.Range;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.HashSet;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeSymbologyDescription {
    public NativeSymbologyDescription() {
    }

    public static NativeSymbologyDescription create(Symbology symbology) {
        return CppProxy.create((Symbology)symbology);
    }

    public static NativeSymbologyDescription symbologyDescriptionFromIdentifier(String string) {
        return CppProxy.symbologyDescriptionFromIdentifier((String)string);
    }

    public static Symbology symbologyFromIdentifier(String string) {
        return CppProxy.symbologyFromIdentifier((String)string);
    }

    public abstract Range getActiveSymbolCountRange();

    public abstract HashSet<String> getAllExtensions();

    public abstract Range getDefaultSymbolCountRange();

    public abstract String getIdentifier();

    public abstract HashSet<String> getPublicExtensions();

    public abstract String getReadableName();

    public abstract Symbology getSymbology();

    public abstract boolean isAvailable();

    public abstract boolean isColorInvertible();

    public abstract String toJson();
}

