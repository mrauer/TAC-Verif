/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.internal.module.serialization.NativeBarcodeEnumSerializer$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 */
package com.scandit.datacapture.barcode.internal.module.serialization;

import com.scandit.datacapture.barcode.data.CompositeType;
import com.scandit.datacapture.barcode.internal.module.serialization.NativeBarcodeEnumSerializer;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.EnumSet;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBarcodeEnumSerializer {
    public NativeBarcodeEnumSerializer() {
    }

    public static String compositeTypeToString(EnumSet<CompositeType> enumSet) {
        return CppProxy.compositeTypeToString(enumSet);
    }
}

