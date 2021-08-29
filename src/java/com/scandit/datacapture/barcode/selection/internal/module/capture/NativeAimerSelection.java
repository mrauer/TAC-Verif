/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.selection.internal.module.capture.NativeAimerSelection$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.barcode.selection.internal.module.capture;

import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeAimerSelection;
import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeSelectionStrategy;
import com.scandit.datacapture.barcode.selection.internal.module.capture.NativeSelectionType;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeAimerSelection {
    public NativeAimerSelection() {
    }

    public static NativeAimerSelection create() {
        return CppProxy.create();
    }

    public abstract NativeSelectionType asSelectionType();

    public abstract NativeSelectionStrategy getSelectionStrategy();

    public abstract void setSelectionStrategy(NativeSelectionStrategy var1);
}

