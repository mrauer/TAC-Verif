/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.internal.sdk.data.NativeCompositeTypeDescription$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.EnumSet
 *  java.util.HashSet
 */
package com.scandit.datacapture.barcode.internal.sdk.data;

import com.scandit.datacapture.barcode.data.CompositeType;
import com.scandit.datacapture.barcode.data.Symbology;
import com.scandit.datacapture.barcode.internal.sdk.data.NativeCompositeTypeDescription;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeCompositeTypeDescription {
    public NativeCompositeTypeDescription() {
    }

    public static ArrayList<NativeCompositeTypeDescription> all() {
        return CppProxy.all();
    }

    public static NativeCompositeTypeDescription create(EnumSet<CompositeType> enumSet) {
        return CppProxy.create(enumSet);
    }

    public abstract HashSet<Symbology> getSymbologies();

    public abstract EnumSet<CompositeType> getTypesBits();

    public abstract String toJson();
}

