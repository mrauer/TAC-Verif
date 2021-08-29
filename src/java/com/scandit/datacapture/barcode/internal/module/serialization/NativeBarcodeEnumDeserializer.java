/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.internal.module.serialization.NativeBarcodeEnumDeserializer$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 */
package com.scandit.datacapture.barcode.internal.module.serialization;

import com.scandit.datacapture.barcode.data.CompositeType;
import com.scandit.datacapture.barcode.internal.module.serialization.NativeBarcodeEnumDeserializer;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.EnumSet;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeBarcodeEnumDeserializer {
    public NativeBarcodeEnumDeserializer() {
    }

    public static EnumSet<CompositeType> compositeTypeFromJsonString(String string) {
        return CppProxy.compositeTypeFromJsonString((String)string);
    }
}

