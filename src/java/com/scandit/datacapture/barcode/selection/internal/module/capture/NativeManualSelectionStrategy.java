/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.selection.internal.module.capture.NativeManualSelectionStrategy$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.selection.internal.module.capture;

import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeManualSelectionStrategy;
import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeSelectionStrategy;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeManualSelectionStrategy {
    public NativeManualSelectionStrategy() {
    }

    public static NativeManualSelectionStrategy create() {
        return CppProxy.create();
    }

    public abstract NativeSelectionStrategy asSelectionStrategy();
}

