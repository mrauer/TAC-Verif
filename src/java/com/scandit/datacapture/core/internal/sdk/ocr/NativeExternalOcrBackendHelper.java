/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.ocr.NativeExternalOcrBackendHelper$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.ocr;

import com.scandit.datacapture.core.common.geometry.Rect;
import com.scandit.datacapture.core.internal.sdk.ocr.NativeExternalOcrBackendHelper;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeExternalOcrBackendHelper {
    public NativeExternalOcrBackendHelper() {
    }

    public static Rect adjustRoi(Rect rect, float f2) {
        return CppProxy.adjustRoi((Rect)rect, (float)f2);
    }
}

