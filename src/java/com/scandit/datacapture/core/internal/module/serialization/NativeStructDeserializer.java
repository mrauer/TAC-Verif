/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.serialization.NativeStructDeserializer$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.common.geometry.Point;
import com.scandit.datacapture.core.common.geometry.Quadrilateral;
import com.scandit.datacapture.core.internal.module.serialization.NativeStructDeserializer;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.core.internal.sdk.ui.style.NativeBrush;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeStructDeserializer {
    public NativeStructDeserializer() {
    }

    public static NativeBrush brushFromJson(NativeJsonValue nativeJsonValue) {
        return CppProxy.brushFromJson((NativeJsonValue)nativeJsonValue);
    }

    public static Point pointFromJson(NativeJsonValue nativeJsonValue) {
        return CppProxy.pointFromJson((NativeJsonValue)nativeJsonValue);
    }

    public static Quadrilateral quadrilateralFromJson(NativeJsonValue nativeJsonValue) {
        return CppProxy.quadrilateralFromJson((NativeJsonValue)nativeJsonValue);
    }
}

