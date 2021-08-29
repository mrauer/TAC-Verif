/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.area.NativeNoLocationSelection$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.area;

import com.scandit.datacapture.core.internal.sdk.area.NativeLocationSelection;
import com.scandit.datacapture.core.internal.sdk.area.NativeNoLocationSelection;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeNoLocationSelection {
    public NativeNoLocationSelection() {
    }

    public static NativeNoLocationSelection create() {
        return CppProxy.create();
    }

    public abstract NativeLocationSelection asLocationSelection();
}

